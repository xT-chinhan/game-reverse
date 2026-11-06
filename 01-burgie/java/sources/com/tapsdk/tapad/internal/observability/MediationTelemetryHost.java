package com.tapsdk.tapad.internal.observability;

import android.content.Context;
import com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge;
import com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge;
import com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport;
import com.taptap.sdk.db.constant.Common;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationTelemetryHost {
    private static final String CLIENT_ID = "dirichlet_adn";
    private static final String SCREENSHOT_EVENT_HASH = "bff5f677";
    private static final String TAG = "MediationTelemetryHost";
    private static volatile AndroidTelemetryTransport client;
    private static volatile boolean originReady;
    private static volatile long sdkMediaId;
    private static final AtomicBoolean INITIALIZING = new AtomicBoolean();
    private static final AtomicBoolean SDK_INIT_REPORTING = new AtomicBoolean();
    private static final AtomicBoolean SDK_INIT_REPORTED = new AtomicBoolean();

    public static final class RuntimeProjection {
        final String eventHash;
        final JSONArray events;
        final Map<String, Object> fields;

        public RuntimeProjection(String str, Map<String, Object> map, JSONArray jSONArray) {
            this.eventHash = str;
            this.fields = map;
            this.events = jSONArray;
        }
    }

    static {
        CoreMediationTelemetryBridge.install(new CoreMediationTelemetryBridge.Sink() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda5
            @Override // com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge.Sink
            public final void report(String str, Map map) {
                MediationTelemetryHost.reportCoreStatusEvent(str, map);
            }
        });
        CoreMediationTelemetryBridge.installFactSink(new CoreMediationTelemetryBridge.FactSink() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda6
            @Override // com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge.FactSink
            public final void report(int i, Map map) {
                MediationTelemetryHost.report(i, map);
            }
        });
        CoreMediationTelemetryBridge.installEnvelopeSink(new CoreMediationTelemetryBridge.EnvelopeSink() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda7
            @Override // com.tapsdk.tapad.internal.runtime.CoreMediationTelemetryBridge.EnvelopeSink
            public final boolean report(JSONObject jSONObject) {
                return MediationTelemetryHost.deliverCoreEvent(jSONObject);
            }
        });
    }

    private MediationTelemetryHost() {
    }

    public static Map<String, Object> addSdkIdentityIfAbsent(Map<String, Object> map, long j) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("media_id");
        if ((obj == null || String.valueOf(obj).isEmpty()) && j > 0) {
            map.put("media_id", String.valueOf(j));
        }
        return map;
    }

    public static void applyRemoteConfiguration(String str, List<String> list, List<String> list2, boolean z, int i) {
        AndroidTelemetryTransport androidTelemetryTransport = client;
        if (androidTelemetryTransport == null) {
            return;
        }
        try {
            androidTelemetryTransport.updateConfiguration(str, i, list, list2, z);
            tryReportSdkInit();
        } catch (Throwable th) {
        }
    }

    public static boolean deliverCoreEvent(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            final JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            if (AndroidTelemetryTransport.deferFromMain(new Runnable() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    MediationTelemetryHost.deliverCoreEvent(jSONObject2);
                }
            })) {
                return true;
            }
            return AndroidTelemetryTransport.deliverCoreEnvelope(client, jSONObject, SCREENSHOT_EVENT_HASH.equals(jSONObject.optString("event_hash", "")) ? null : new AndroidTelemetryTransport.CoreFieldProjector() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda3
                @Override // com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.CoreFieldProjector
                public final Map project(Map map) {
                    return MediationTelemetryHost.projectCoreOriginFields(map);
                }
            }, new AndroidTelemetryTransport.DeliveryAcknowledger() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda4
                @Override // com.tapsdk.tapad.internal.telemetry.AndroidTelemetryTransport.DeliveryAcknowledger
                public final void acknowledge(String str, boolean z) {
                    MediationRuntimeCoreBridge.acknowledgeEvent(str, z);
                }
            });
        } catch (Throwable th) {
            return false;
        }
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

    public static void initialize(Context context, long j) {
        if (client == null && context != null) {
            AtomicBoolean atomicBoolean = INITIALIZING;
            if (atomicBoolean.compareAndSet(false, true)) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null) {
                        atomicBoolean.set(false);
                        return;
                    }
                    AndroidTelemetryTransport androidTelemetryTransportCreateAndroid = AndroidTelemetryTransport.createAndroid(applicationContext, CLIENT_ID, false);
                    if (androidTelemetryTransportCreateAndroid == null) {
                        throw new IllegalStateException("Rust telemetry core is unavailable");
                    }
                    sdkMediaId = j;
                    client = androidTelemetryTransportCreateAndroid;
                    atomicBoolean.set(false);
                } catch (Throwable th) {
                    try {
                        client = null;
                    } finally {
                        INITIALIZING.set(false);
                    }
                }
            }
        }
    }

    public static void onOriginReady() {
        originReady = true;
        tryReportSdkInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> projectCoreOriginFields(Map<String, Object> map) {
        try {
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            MediationRuntimeCoreBridge.Result resultProjectOriginFields = MediationRuntimeCoreBridge.projectOriginFields(new JSONObject(map));
            JSONObject jSONObjectOptJSONObject = resultProjectOriginFields.isSuccess() ? resultProjectOriginFields.output.optJSONObject("fields") : null;
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            return addSdkIdentityIfAbsent(AndroidTelemetryTransport.jsonObjectToMap(jSONObjectOptJSONObject), sdkMediaId);
        } catch (Throwable th) {
            return null;
        }
    }

    private static RuntimeProjection projectRuntimeEvent(int i, Map<String, Object> map) {
        try {
            MediationRuntimeCoreBridge.Result resultProjectEvent = MediationRuntimeCoreBridge.projectEvent(new JSONObject().put("fact_code", i).put("event_time_ms", System.currentTimeMillis()).put(Common.Predefined.SUB_OS_TYPE, "android").put("fields", new JSONObject(map)));
            JSONObject jSONObjectOptJSONObject = resultProjectEvent.isSuccess() ? resultProjectEvent.output.optJSONObject("fields") : null;
            String strOptString = resultProjectEvent.isSuccess() ? resultProjectEvent.output.optString("event_hash", "") : "";
            if (jSONObjectOptJSONObject != null && !strOptString.isEmpty()) {
                return new RuntimeProjection(strOptString, addSdkIdentityIfAbsent(AndroidTelemetryTransport.jsonObjectToMap(jSONObjectOptJSONObject), sdkMediaId), resultProjectEvent.output.optJSONArray("telemetry_events"));
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void report(final int i, Map<String, Object> map) {
        if (i <= 0) {
            return;
        }
        final Map map2 = map == null ? Collections.EMPTY_MAP : new HashMap(map);
        if (AndroidTelemetryTransport.deferFromMain(new Runnable() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediationTelemetryHost.report(i, map2);
            }
        })) {
            return;
        }
        reportFact(i, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportCoreStatusEvent(final String str, Map<String, Object> map) {
        final Map map2 = map == null ? Collections.EMPTY_MAP : new HashMap(map);
        if (AndroidTelemetryTransport.deferFromMain(new Runnable() { // from class: com.tapsdk.tapad.internal.observability.MediationTelemetryHost$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediationTelemetryHost.reportCoreStatusEvent(str, map2);
            }
        })) {
            return;
        }
        submitCoreStatusEvent(str, map2);
    }

    private static boolean reportFact(int i, Map<String, Object> map) {
        AndroidTelemetryTransport androidTelemetryTransport = client;
        if (androidTelemetryTransport != null && androidTelemetryTransport.isConfigured()) {
            try {
                RuntimeProjection runtimeProjectionProjectRuntimeEvent = projectRuntimeEvent(i, map);
                if (runtimeProjectionProjectRuntimeEvent == null) {
                    return false;
                }
                deliverCoreEvents(runtimeProjectionProjectRuntimeEvent.events);
                boolean zTrack = androidTelemetryTransport.track(runtimeProjectionProjectRuntimeEvent.eventHash, runtimeProjectionProjectRuntimeEvent.fields, 1);
                if (!zTrack) {
                    androidTelemetryTransport.requestCapacityDelivery();
                }
                return zTrack;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static void submitCoreStatusEvent(String str, Map<String, Object> map) {
        Map<String, Object> mapProjectCoreOriginFields;
        AndroidTelemetryTransport androidTelemetryTransport = client;
        if (androidTelemetryTransport == null || !androidTelemetryTransport.isConfigured() || (mapProjectCoreOriginFields = projectCoreOriginFields(map)) == null) {
            return;
        }
        androidTelemetryTransport.track(str, mapProjectCoreOriginFields, 1);
    }

    private static void tryReportSdkInit() {
        AndroidTelemetryTransport androidTelemetryTransport = client;
        if (originReady) {
            AtomicBoolean atomicBoolean = SDK_INIT_REPORTED;
            if (atomicBoolean.get() || androidTelemetryTransport == null || !androidTelemetryTransport.isConfigured()) {
                return;
            }
            if (SDK_INIT_REPORTING.compareAndSet(false, true)) {
                try {
                    if (reportFact(60, Collections.EMPTY_MAP)) {
                        atomicBoolean.set(true);
                    }
                } finally {
                    SDK_INIT_REPORTING.set(false);
                }
            }
        }
    }
}
