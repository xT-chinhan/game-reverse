package com.tapsdk.tapad.internal.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.internal.network.utils.SecureConnectionUtil;
import com.tapsdk.tapad.internal.runtime.AndroidDeviceFacts;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.utils.FinstallIdManager;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AndroidTelemetryTransport {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final int DEFAULT_BATCH_SIZE = 20;
    private static final int MAX_SCREENSHOT_BASE64_LENGTH = 2097152;
    static final int MAX_TELEMETRY_STRING_LENGTH = 4096;
    private static final String QUEUE_KEY_PREFIX = "queue_";
    private static final String QUEUE_PREFS_NAME = "tapad_rust_telemetry_queue";
    private static final int READ_TIMEOUT_MS = 30000;
    private static final String SCREENSHOT_BASE64_FIELD = "ss_base64";
    private static final String SCREENSHOT_EVENT_HASH = "bff5f677";
    private static final String TAG = "AndroidTelemetryTransport";
    private final Context appContext;
    private final String clientId;
    private final Map<String, Object> commonFields;
    private volatile boolean configured;
    private final boolean debugMode;
    private ScheduledFuture<?> deliveryDeadlineFuture;
    private volatile long deliveryDeadlineMillis;
    private final ScheduledExecutorService deliveryExecutor;
    private volatile boolean deliveryRequested;
    private ScheduledFuture<?> deliveryRetryFuture;
    private volatile boolean deliveryRunning;
    private final String deviceId;
    private volatile boolean forceDeliveryRequested;
    private volatile boolean retryBackoffActive;

    public interface CoreFieldProjector {
        Map<String, Object> project(Map<String, Object> map);
    }

    public interface DeliveryAcknowledger {
        void acknowledge(String str, boolean z);
    }

    public static final class DeliveryDirective {
        final long retryDelayMillis;

        public DeliveryDirective(long j) {
            this.retryDelayMillis = j;
        }
    }

    public static final class DeliveryTransportFact {
        final String responseBody;
        final int statusCode;
        final int transport;

        private DeliveryTransportFact(int i, int i2, String str) {
            this.transport = i;
            this.statusCode = i2;
            this.responseBody = str == null ? "" : str;
        }

        public static DeliveryTransportFact malformed() {
            return new DeliveryTransportFact(2, -1, "");
        }

        public static DeliveryTransportFact networkError() {
            return new DeliveryTransportFact(1, -1, "");
        }

        public static DeliveryTransportFact response(int i, String str) {
            return new DeliveryTransportFact(0, i, str);
        }

        public static DeliveryTransportFact timeout() {
            return new DeliveryTransportFact(3, -1, "");
        }
    }

    private AndroidTelemetryTransport(Context context, String str, String str2, String str3, int i, List<String> list, List<String> list2, Map<String, Object> map, boolean z) {
        this.clientId = str != null ? str : "";
        this.appContext = context != null ? context.getApplicationContext() : null;
        String str4 = str3 != null ? str3 : "";
        this.deviceId = str4;
        Map<String, Object> mapUnmodifiableMap = map != null ? Collections.unmodifiableMap(new HashMap(map)) : Collections.EMPTY_MAP;
        this.commonFields = mapUnmodifiableMap;
        this.debugMode = z;
        this.deliveryExecutor = Executors.newSingleThreadScheduledExecutor();
        this.configured = configure(str2, str4, i, list, list2, mapUnmodifiableMap, true);
        if (this.configured && restorePersistedQueue()) {
            scheduleDelivery(true, false);
        }
    }

    private static JSONObject buildNativeConfiguration(String str, String str2, String str3, int i, List<String> list, List<String> list2, Map<String, Object> map, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enabled", z);
        jSONObject.put("client_id", str);
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("server_url", str2);
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put("device_id", str3);
        jSONObject.put("batch_size", Math.max(i, 1));
        jSONObject.put("timezone_offset_minutes", currentTimezoneOffsetMinutes());
        jSONObject.put("allowed_events", listToJson(list));
        jSONObject.put("blocked_events", listToJson(list2));
        jSONObject.put("common_fields", mapToJson(map));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cancelDeliveryDeadline() {
        ScheduledFuture<?> scheduledFuture = this.deliveryDeadlineFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.deliveryDeadlineFuture = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cancelDeliveryRetry() {
        ScheduledFuture<?> scheduledFuture = this.deliveryRetryFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.deliveryRetryFuture = null;
        }
    }

    private boolean configure(String str, String str2, int i, List<String> list, List<String> list2, Map<String, Object> map, boolean z) {
        try {
            boolean zConfigure = RustTelemetryBridge.configure(buildNativeConfiguration(this.clientId, str, str2, i, list, list2, map, z).toString());
            if (zConfigure) {
                String strDeliveryPolicy = RustTelemetryBridge.deliveryPolicy(this.clientId);
                JSONObject jSONObject = strDeliveryPolicy.length() > 0 ? new JSONObject(strDeliveryPolicy) : null;
                long jOptLong = jSONObject != null ? jSONObject.optLong("delivery_deadline_ms", 0L) : 0L;
                if (jOptLong <= 0) {
                    throw new IllegalStateException("Rust delivery policy is unavailable");
                }
                this.deliveryDeadlineMillis = jOptLong;
            }
            return zConfigure;
        } catch (Throwable th) {
            return false;
        }
    }

    public static AndroidTelemetryTransport createAndroid(Context context, String str, boolean z) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return null;
        }
        AndroidTelemetryNetworkType.getInstance().start(applicationContext);
        String finstallId = FinstallIdManager.getInstance(applicationContext).getFinstallId();
        List list = Collections.EMPTY_LIST;
        AndroidTelemetryTransport androidTelemetryTransport = new AndroidTelemetryTransport(applicationContext, str, "", finstallId, 20, list, list, AndroidDeviceFacts.telemetryPlatformFacts(applicationContext), z);
        if (androidTelemetryTransport.isConfigured()) {
            return androidTelemetryTransport;
        }
        return null;
    }

    private static int currentTimezoneOffsetMinutes() {
        return TimeZone.getDefault().getOffset(System.currentTimeMillis()) / BaseConstants.Time.MINUTE;
    }

    public static boolean deferFromMain(Runnable runnable) {
        return runnable != null && Looper.myLooper() == Looper.getMainLooper() && DirichletRuntime.getInstance().runOnRuntimeQueue(runnable);
    }

    public static boolean deliverCoreEnvelope(AndroidTelemetryTransport androidTelemetryTransport, JSONObject jSONObject, CoreFieldProjector coreFieldProjector, DeliveryAcknowledger deliveryAcknowledger) {
        boolean z = false;
        if (jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString("delivery_token", "");
        try {
            String strOptString2 = jSONObject.optString("event_hash", "");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("fields");
            if (androidTelemetryTransport != null && androidTelemetryTransport.isConfigured() && jSONObjectOptJSONObject != null) {
                Map<String, Object> mapJsonObjectToMap = jsonObjectToMap(jSONObjectOptJSONObject);
                if (coreFieldProjector != null) {
                    mapJsonObjectToMap = coreFieldProjector.project(mapJsonObjectToMap);
                }
                if (mapJsonObjectToMap != null) {
                    boolean zTrack = jSONObject.optBoolean("apply_filters", false) ? androidTelemetryTransport.track(strOptString2, mapJsonObjectToMap, 1) : androidTelemetryTransport.trackRaw(strOptString2, mapJsonObjectToMap, 1);
                    if (!zTrack) {
                        androidTelemetryTransport.requestCapacityDelivery();
                    }
                    z = zTrack;
                }
            }
        } catch (Throwable th) {
        }
        if (!strOptString.isEmpty() && deliveryAcknowledger != null) {
            try {
                deliveryAcknowledger.acknowledge(strOptString, z);
            } catch (Throwable th2) {
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long drainDeliveryQueue(boolean z) {
        while (this.configured) {
            String strBeginFlush = z ? RustTelemetryBridge.beginFlush(this.clientId) : RustTelemetryBridge.beginFlushIfNeeded(this.clientId);
            if (strBeginFlush.length() == 0) {
                return 0L;
            }
            DeliveryDirective deliveryDirectiveFinishDelivery = finishDelivery(sendCountlyRequest(strBeginFlush));
            if (deliveryDirectiveFinishDelivery == null) {
                this.configured = false;
                return 0L;
            }
            persistQueue();
            long j = deliveryDirectiveFinishDelivery.retryDelayMillis;
            if (j > 0) {
                return j;
            }
        }
        return 0L;
    }

    private DeliveryDirective finishDelivery(DeliveryTransportFact deliveryTransportFact) {
        try {
            String strFinishDelivery = RustTelemetryBridge.finishDelivery(this.clientId, deliveryTransportFact.transport, deliveryTransportFact.statusCode, deliveryTransportFact.responseBody);
            if (strFinishDelivery.length() == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strFinishDelivery);
            String strOptString = jSONObject.optString("outcome", "");
            long jOptLong = jSONObject.optLong("retry_delay_ms", 0L);
            long jOptLong2 = jSONObject.optLong("delivery_deadline_ms", 0L);
            if (jOptLong2 > 0) {
                this.deliveryDeadlineMillis = jOptLong2;
            }
            if ("retry".equals(strOptString)) {
                if (jOptLong > 0) {
                    return new DeliveryDirective(jOptLong);
                }
                return null;
            }
            if (!TrackAction.SUCCESS.equals(strOptString) && !"drop".equals(strOptString)) {
                return null;
            }
            return new DeliveryDirective(0L);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Map<String, Object> jsonObjectToMap(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt != null && objOpt != JSONObject.NULL) {
                    map.put(next, objOpt);
                }
            }
        }
        return map;
    }

    private static JSONArray listToJson(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (String str : list) {
                if (str != null && str.trim().length() > 0) {
                    jSONArray.put(str.trim());
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject mapToJson(Map<String, ?> map) {
        return mapToJson(map, false);
    }

    public static Map<String, Object> mergeCurrentAndroidFields(Map<String, Object> map, int i) {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.remove("oaid");
        map2.remove("oaid_manufacturer");
        map2.put("network_type", Integer.valueOf(i));
        return map2;
    }

    private static Object normalizeValue(String str, Object obj, boolean z) {
        if (!z || !"ss_base64".equals(str) || !(obj instanceof String)) {
            return normalizeValue(obj);
        }
        String str2 = (String) obj;
        if (str2.length() <= 2097152) {
            return str2;
        }
        return null;
    }

    private void onTrackAccepted() {
        persistQueue();
        scheduleDelivery(false);
        if (this.retryBackoffActive) {
            return;
        }
        scheduleDeliveryDeadline();
    }

    private synchronized void persistQueue() {
        if (this.appContext != null && this.configured) {
            String strSnapshot = RustTelemetryBridge.snapshot(this.clientId);
            SharedPreferences.Editor editorEdit = queuePreferences().edit();
            if (strSnapshot == null || strSnapshot.length() == 0 || "[]".equals(strSnapshot)) {
                editorEdit.remove(queueStorageKey());
            } else {
                editorEdit.putString(queueStorageKey(), strSnapshot);
            }
            editorEdit.apply();
        }
    }

    private SharedPreferences queuePreferences() {
        return this.appContext.getSharedPreferences(QUEUE_PREFS_NAME, 0);
    }

    private String queueStorageKey() {
        return QUEUE_KEY_PREFIX + sanitizeStorageKey(this.clientId);
    }

    private static String readResponse(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            errorStream = httpURLConnection.getErrorStream();
        }
        if (errorStream == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = errorStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            try {
                errorStream.close();
            } catch (Throwable th2) {
            }
            return str;
        } catch (Throwable th3) {
            try {
                errorStream.close();
            } catch (Throwable th4) {
            }
            return "";
        }
    }

    private synchronized boolean restorePersistedQueue() {
        if (this.appContext == null) {
            return false;
        }
        String string = queuePreferences().getString(queueStorageKey(), "");
        if (string != null && string.length() != 0 && !"[]".equals(string)) {
            if (RustTelemetryBridge.restore(this.clientId, string)) {
                return true;
            }
            queuePreferences().edit().remove(queueStorageKey()).apply();
        }
        return false;
    }

    private static String sanitizeStorageKey(String str) {
        if (str == null || str.length() == 0) {
            return "default";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '_' || cCharAt == '-'))) {
                sb.append('_');
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleDelivery(boolean z) {
        scheduleDelivery(z, false);
    }

    private synchronized void scheduleDeliveryDeadline() {
        ScheduledFuture<?> scheduledFuture;
        ScheduledFuture<?> scheduledFuture2;
        if (this.deliveryExecutor != null && this.deliveryDeadlineMillis > 0 && (((scheduledFuture = this.deliveryDeadlineFuture) == null || scheduledFuture.isDone()) && ((scheduledFuture2 = this.deliveryRetryFuture) == null || scheduledFuture2.isDone()))) {
            this.deliveryDeadlineFuture = this.deliveryExecutor.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AndroidTelemetryTransport.this) {
                        AndroidTelemetryTransport.this.deliveryDeadlineFuture = null;
                    }
                    AndroidTelemetryTransport.this.scheduleDelivery(true);
                }
            }, this.deliveryDeadlineMillis, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleDeliveryRetry(long j) {
        ScheduledFuture<?> scheduledFuture;
        if (this.deliveryExecutor != null && j > 0 && ((scheduledFuture = this.deliveryRetryFuture) == null || scheduledFuture.isDone())) {
            this.deliveryRetryFuture = this.deliveryExecutor.schedule(new Runnable() { // from class: com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AndroidTelemetryTransport.this) {
                        AndroidTelemetryTransport.this.deliveryRetryFuture = null;
                    }
                    AndroidTelemetryTransport.this.scheduleDelivery(true, true);
                }
            }, j, TimeUnit.MILLISECONDS);
        }
    }

    private DeliveryTransportFact sendCountlyRequest(String str) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString("server_url", "");
                String strOptString2 = jSONObject.optString("post_body", "");
                if (strOptString.length() != 0 && strOptString2.length() != 0) {
                    HttpURLConnection httpURLConnectionOpenConnection = SecureConnectionUtil.openConnection(new URL(strOptString));
                    httpURLConnectionOpenConnection.setConnectTimeout(30000);
                    httpURLConnectionOpenConnection.setReadTimeout(30000);
                    httpURLConnectionOpenConnection.setUseCaches(false);
                    httpURLConnectionOpenConnection.setDoInput(true);
                    httpURLConnectionOpenConnection.setDoOutput(true);
                    httpURLConnectionOpenConnection.setRequestMethod(TapHttp.METHOD_POST);
                    httpURLConnectionOpenConnection.setRequestProperty("Content-Type", "text/plain");
                    httpURLConnectionOpenConnection.addRequestProperty("X-Code", String.valueOf(50300001));
                    OutputStream outputStream = httpURLConnectionOpenConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                    bufferedWriter.write(strOptString2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    DeliveryTransportFact deliveryTransportFactResponse = DeliveryTransportFact.response(httpURLConnectionOpenConnection.getResponseCode(), readResponse(httpURLConnectionOpenConnection));
                    httpURLConnectionOpenConnection.disconnect();
                    return deliveryTransportFactResponse;
                }
                return DeliveryTransportFact.malformed();
            } catch (Throwable th) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (SocketTimeoutException e) {
            DeliveryTransportFact deliveryTransportFactTimeout = DeliveryTransportFact.timeout();
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            return deliveryTransportFactTimeout;
        } catch (Throwable th2) {
            DeliveryTransportFact deliveryTransportFactNetworkError = DeliveryTransportFact.networkError();
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            return deliveryTransportFactNetworkError;
        }
    }

    public static boolean shouldStartDelivery(boolean z, boolean z2) {
        return z || !z2;
    }

    private boolean trackInternal(String str, Map<String, Object> map, int i, boolean z) {
        if (this.configured && str != null && str.length() != 0) {
            try {
                JSONObject jSONObjectMapToJson = mapToJson(withCurrentAndroidFields(map), SCREENSHOT_EVENT_HASH.equals(str));
                boolean zTrackRaw = z ? RustTelemetryBridge.trackRaw(this.clientId, str, jSONObjectMapToJson.toString(), Math.max(i, 1)) : RustTelemetryBridge.track(this.clientId, str, jSONObjectMapToJson.toString(), Math.max(i, 1));
                if (zTrackRaw) {
                    onTrackAccepted();
                }
                return zTrackRaw;
            } catch (Throwable th) {
                this.configured = false;
            }
        }
        return false;
    }

    private Map<String, Object> withCurrentAndroidFields(Map<String, Object> map) {
        return mergeCurrentAndroidFields(map, AndroidTelemetryNetworkType.getInstance().current());
    }

    public boolean executeBestEffort(Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService;
        if (runnable != null && (scheduledExecutorService = this.deliveryExecutor) != null) {
            try {
                scheduledExecutorService.execute(runnable);
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public void flushForDelivery() {
        scheduleDelivery(true, true);
    }

    public boolean isConfigured() {
        return this.configured;
    }

    public void requestCapacityDelivery() {
        scheduleDelivery(true, false);
    }

    public boolean track(String str, Map<String, Object> map, int i) {
        return trackInternal(str, map, i, false);
    }

    public boolean trackFact(int i, Map<String, Object> map, int i2) {
        if (this.configured && i > 0) {
            try {
                boolean zTrackFact = RustTelemetryBridge.trackFact(this.clientId, i, mapToJson(withCurrentAndroidFields(map)).toString(), Math.max(i2, 1));
                if (zTrackFact) {
                    onTrackAccepted();
                }
                return zTrackFact;
            } catch (Throwable th) {
                this.configured = false;
            }
        }
        return false;
    }

    public boolean trackRaw(String str, Map<String, Object> map, int i) {
        return trackInternal(str, map, i, true);
    }

    public synchronized boolean updateConfiguration(String str, int i, List<String> list, List<String> list2, boolean z) {
        boolean zConfigure;
        zConfigure = configure(str, this.deviceId, i, list, list2, this.commonFields, z);
        if (zConfigure) {
            this.configured = true;
            persistQueue();
            this.retryBackoffActive = false;
            cancelDeliveryRetry();
            scheduleDelivery(true, false);
        }
        return zConfigure;
    }

    private static JSONObject mapToJson(Map<String, ?> map, boolean z) {
        Object objNormalizeValue;
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && key.trim().length() != 0 && (objNormalizeValue = normalizeValue(key, entry.getValue(), z)) != null) {
                    jSONObject.put(key, objNormalizeValue);
                }
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleDelivery(final boolean z, boolean z2) {
        if (!this.configured || this.deliveryExecutor == null) {
            return;
        }
        if (z) {
            cancelDeliveryDeadline();
        }
        synchronized (this) {
            if (shouldStartDelivery(z2, this.retryBackoffActive)) {
                if (this.deliveryRunning) {
                    this.deliveryRequested = true;
                    this.forceDeliveryRequested = this.forceDeliveryRequested || z;
                } else {
                    this.deliveryRunning = true;
                    this.deliveryRequested = false;
                    this.forceDeliveryRequested = false;
                    this.deliveryExecutor.execute(new Runnable() { // from class: com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z3;
                            boolean z4;
                            try {
                                long jDrainDeliveryQueue = AndroidTelemetryTransport.this.drainDeliveryQueue(z);
                                synchronized (AndroidTelemetryTransport.this) {
                                    AndroidTelemetryTransport.this.deliveryRunning = false;
                                    AndroidTelemetryTransport.this.retryBackoffActive = jDrainDeliveryQueue > 0;
                                    z3 = AndroidTelemetryTransport.this.deliveryRequested;
                                    z4 = AndroidTelemetryTransport.this.forceDeliveryRequested;
                                    AndroidTelemetryTransport.this.deliveryRequested = false;
                                    AndroidTelemetryTransport.this.forceDeliveryRequested = false;
                                }
                                if (jDrainDeliveryQueue > 0) {
                                    AndroidTelemetryTransport.this.cancelDeliveryDeadline();
                                    AndroidTelemetryTransport.this.scheduleDeliveryRetry(jDrainDeliveryQueue);
                                } else {
                                    AndroidTelemetryTransport.this.cancelDeliveryRetry();
                                    if (z3) {
                                        AndroidTelemetryTransport.this.scheduleDelivery(z4);
                                    }
                                }
                            } catch (Throwable th) {
                                synchronized (AndroidTelemetryTransport.this) {
                                    AndroidTelemetryTransport.this.deliveryRunning = false;
                                    AndroidTelemetryTransport.this.retryBackoffActive = false;
                                    boolean unused = AndroidTelemetryTransport.this.deliveryRequested;
                                    boolean unused2 = AndroidTelemetryTransport.this.forceDeliveryRequested;
                                    AndroidTelemetryTransport.this.deliveryRequested = false;
                                    AndroidTelemetryTransport.this.forceDeliveryRequested = false;
                                    throw th;
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    private static Object normalizeValue(Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() <= 4096) {
                return str;
            }
            int i = Character.isHighSurrogate(str.charAt(4095)) ? 4095 : 4096;
            char[] cArr = new char[i];
            str.getChars(0, i, cArr, 0);
            return new String(cArr);
        }
        if ((obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        return null;
    }
}
