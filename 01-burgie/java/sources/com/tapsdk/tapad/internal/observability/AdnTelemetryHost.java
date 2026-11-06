package com.tapsdk.tapad.internal.observability;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.internal.runtime.AdnRuntimeCoreBridge;
import com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport;
import com.tapsdk.tapad.internal.telemetry.RustTelemetryBridge;
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdnTelemetryHost {
    private static final String CLIENT_ID = "tap_adn";
    private static final AtomicBoolean INITIALIZING = new AtomicBoolean();
    private static final String TAG = "AdnTelemetryHost";
    private static volatile State state;

    public static final class State {
        final AndroidTelemetryTransport client;
        final Context context;
        final long mediaId;

        public State(Context context, AndroidTelemetryTransport androidTelemetryTransport, long j) {
            this.context = context;
            this.client = androidTelemetryTransport;
            this.mediaId = j;
        }
    }

    private AdnTelemetryHost() {
    }

    public static void applyCoreConfiguration(String str, List<String> list, List<String> list2, int i) {
        State state2 = state;
        if (state2 == null) {
            return;
        }
        state2.client.updateConfiguration(str, i, list, list2, true);
    }

    private static String currentAdnDid(State state2) {
        try {
            String adnDid = AdnDeviceManager.getInstance(state2.context).getAdnDid();
            return adnDid == null ? "" : adnDid;
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean deliverCoreEvent(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        final State state2 = state;
        return AndroidTelemetryTransport.deliverCoreEnvelope(state2 == null ? null : state2.client, jSONObject, new AndroidTelemetryTransport.CoreFieldProjector() { // from class: com.tapsdk.tapad.internal.observability.AdnTelemetryHost$$ExternalSyntheticLambda1
            @Override // com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.CoreFieldProjector
            public final Map project(Map map) {
                return AdnTelemetryHost.project(state2, map, true);
            }
        }, new AndroidTelemetryTransport.DeliveryAcknowledger() { // from class: com.tapsdk.tapad.internal.observability.AdnTelemetryHost$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.DeliveryAcknowledger
            public final void acknowledge(String str, boolean z) {
                AdnRuntimeCoreBridge.acknowledgeEvent(str, z);
            }
        });
    }

    public static boolean deliverCoreEvents(JSONArray jSONArray) {
        boolean zDeliverCoreEvent = true;
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                zDeliverCoreEvent &= deliverCoreEvent(jSONArray.optJSONObject(i));
            }
        }
        return zDeliverCoreEvent;
    }

    private static void enrichFromCore(Map<String, Object> map) {
        try {
            AdnRuntimeCoreBridge.Result resultProjectTelemetry = AdnRuntimeCoreBridge.projectTelemetry(new JSONObject().put("product", "adn").put("event_time_ms", System.currentTimeMillis()).put("fields", new JSONObject(map)));
            JSONObject jSONObjectOptJSONObject = resultProjectTelemetry.isSuccess() ? resultProjectTelemetry.output.optJSONObject("fields") : null;
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            map.clear();
            map.putAll(AndroidTelemetryTransport.jsonObjectToMap(jSONObjectOptJSONObject));
        } catch (Throwable th) {
        }
    }

    private static void forwardFactOutcome(int i, Map<String, Object> map) {
        State state2 = state;
        if (state2 == null) {
            return;
        }
        try {
            AdnRuntimeCoreBridge.Result resultProjectLifecycle = AdnRuntimeCoreBridge.projectLifecycle(new JSONObject().put("product", "adn").put("source_fact", i).put("event_time_ms", System.currentTimeMillis()).put(Common.Predefined.SUB_OS_TYPE, "android").put("media_id", String.valueOf(state2.mediaId)).put("adn_did", currentAdnDid(state2)).put("fields", new JSONObject(map)));
            if (resultProjectLifecycle.isSuccess()) {
                deliverCoreEvent(resultProjectLifecycle.output.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            }
        } catch (Throwable th) {
        }
    }

    private static void forwardOutcome(String str, Map<String, Object> map) {
        State state2 = state;
        if (state2 == null) {
            return;
        }
        try {
            AdnRuntimeCoreBridge.Result resultProjectLifecycle = AdnRuntimeCoreBridge.projectLifecycle(new JSONObject().put("product", "adn").put("source_event", str).put("event_time_ms", System.currentTimeMillis()).put(Common.Predefined.SUB_OS_TYPE, "android").put("media_id", String.valueOf(state2.mediaId)).put("adn_did", currentAdnDid(state2)).put("fields", new JSONObject(map)));
            if (resultProjectLifecycle.isSuccess()) {
                deliverCoreEvent(resultProjectLifecycle.output.optJSONObject(NotificationCompat.CATEGORY_EVENT));
            }
        } catch (Throwable th) {
        }
    }

    private static Map<String, Object> identityFacts(State state2) {
        HashMap map = new HashMap();
        if (state2 == null) {
            return map;
        }
        map.put("media_id", Long.valueOf(state2.mediaId));
        map.put("adn_did", currentAdnDid(state2));
        return map;
    }

    public static void initialize(Context context, TapAdConfig tapAdConfig) {
        if (state != null || context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = INITIALIZING;
        boolean z = true;
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    atomicBoolean.set(false);
                    return;
                }
                if (tapAdConfig == null || !tapAdConfig.mIsDebug) {
                    z = false;
                }
                AndroidTelemetryTransport androidTelemetryTransportCreateAndroid = AndroidTelemetryTransport.createAndroid(applicationContext, CLIENT_ID, z);
                if (androidTelemetryTransportCreateAndroid == null) {
                    throw new IllegalStateException("Rust telemetry core is unavailable");
                }
                state = new State(applicationContext, androidTelemetryTransportCreateAndroid, tapAdConfig == null ? 0L : tapAdConfig.mMediaId);
                AndroidFatalCrashHook.install(new AndroidFatalCrashHook.ThrowableRecorder() { // from class: com.tapsdk.tapad.internal.observability.AdnTelemetryHost$$ExternalSyntheticLambda4
                    @Override // com.tapsdk.tapad.internal.observability.AndroidFatalCrashHook.ThrowableRecorder
                    public final void record(Throwable th) {
                        AdnTelemetryHost.recordFatalCrash(th);
                    }
                });
                atomicBoolean.set(false);
            } catch (Throwable th) {
                try {
                    state = null;
                } finally {
                    INITIALIZING.set(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> project(State state2, Map<String, Object> map, boolean z) {
        Map<String, Object> mapIdentityFacts = identityFacts(state2);
        Map<String, Object> mapProjectFields = z ? projectFields(mapIdentityFacts, map, null) : projectFields(mapIdentityFacts, null, map);
        if (mapProjectFields != null && !z) {
            enrichFromCore(mapProjectFields);
        }
        return mapProjectFields;
    }

    private static Map<String, Object> projectFields(Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("profile", "android");
            if (map == null) {
                map = new HashMap<>();
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put(d.R, new JSONObject(map));
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            JSONObject jSONObjectPut3 = jSONObjectPut2.put(LiveConfigKey.ORIGIN, new JSONObject(map2));
            if (map3 == null) {
                map3 = new HashMap<>();
            }
            String strProjectFields = RustTelemetryBridge.projectFields(jSONObjectPut3.put(NotificationCompat.CATEGORY_EVENT, new JSONObject(map3)).toString());
            if (strProjectFields.isEmpty()) {
                return null;
            }
            return AndroidTelemetryTransport.jsonObjectToMap(new JSONObject(strProjectFields));
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void recordFatalCrash(Throwable th) {
        State state2;
        HashMap map = new HashMap();
        StringWriter stringWriter = new StringWriter();
        if (th != null) {
            th.printStackTrace(new PrintWriter(stringWriter));
        }
        map.put("error", stringWriter.toString());
        if (!submitFact(17, map) || (state2 = state) == null) {
            return;
        }
        state2.client.flushForDelivery();
    }

    public static void report(final String str, Map<String, Object> map, Object... objArr) {
        if (str == null || str.isEmpty()) {
            return;
        }
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i];
                Object obj2 = objArr[i2];
                if ((obj instanceof String) && obj2 != null) {
                    map2.put((String) obj, obj2);
                }
                i += 2;
            }
        }
        if (AndroidTelemetryTransport.deferFromMain(new Runnable() { // from class: com.tapsdk.tapad.internal.observability.AdnTelemetryHost$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AdnTelemetryHost.report(str, map2);
            }
        })) {
            return;
        }
        forwardOutcome(str, map2);
        submit(str, map2, false);
    }

    public static void reportFact(final int i, Map<String, Object> map, Object... objArr) {
        if (i <= 0) {
            return;
        }
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        if (objArr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i2];
                Object obj2 = objArr[i3];
                if ((obj instanceof String) && obj2 != null) {
                    map2.put((String) obj, obj2);
                }
                i2 += 2;
            }
        }
        if (AndroidTelemetryTransport.deferFromMain(new Runnable() { // from class: com.tapsdk.tapad.internal.observability.AdnTelemetryHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AdnTelemetryHost.reportFact(i, map2);
            }
        })) {
            return;
        }
        forwardFactOutcome(i, map2);
        submitFact(i, map2);
    }

    public static void reportThrowable(String str, Throwable th, Map<String, Object> map) {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            map2.put("internal_error_name", str);
            map2.put("internal_error_message", String.valueOf(th.getMessage()));
            map2.put("error_type", th.getClass().getName());
            map2.put("error_message", String.valueOf(th.getMessage()));
            map2.put("error_stack", stringWriter.toString());
        }
        reportFact(6, map2);
    }

    private static boolean submit(String str, Map<String, Object> map, boolean z) {
        Map<String, Object> mapProject;
        State state2 = state;
        if (state2 == null || !state2.client.isConfigured() || (mapProject = project(state2, map, z)) == null) {
            return false;
        }
        return z ? state2.client.trackRaw(str, mapProject, 1) : state2.client.track(str, mapProject, 1);
    }

    private static boolean submitFact(int i, Map<String, Object> map) {
        Map<String, Object> mapProject;
        State state2 = state;
        if (state2 == null || !state2.client.isConfigured() || (mapProject = project(state2, map, false)) == null) {
            return false;
        }
        return state2.client.trackFact(i, mapProject, 1);
    }

    public static void reportFact(int i, Map<String, Object> map) {
        reportFact(i, map, new Object[0]);
    }

    public static void report(String str, Map<String, Object> map) {
        report(str, map, new Object[0]);
    }
}
