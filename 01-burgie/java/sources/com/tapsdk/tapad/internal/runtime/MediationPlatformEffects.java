package com.tapsdk.tapad.internal.runtime;

import android.content.Context;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.observability.MediationTelemetryHost;
import com.tapsdk.tapad.internal.utils.AdnDeviceManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationPlatformEffects {
    private static final String CALLBACK = "onCoreMediationPlatformEffects";
    private static final DirichletRuntime.NativeCallback CORE_CALLBACK = new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.runtime.MediationPlatformEffects$$ExternalSyntheticLambda0
        @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
        public final void onCallback(String str, String str2) {
            MediationPlatformEffects.handle(str, str2);
        }
    };
    private static final int DEFAULT_EVENT_BATCH_COUNT = 20;

    private MediationPlatformEffects() {
    }

    public static void apply(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("privacy_collection")) {
            AndroidPrivacyPolicy.applyMediationCollectionPolicy(jSONObject.optJSONObject("privacy_collection"));
        }
        String strOptString = jSONObject.optString("adn_did", "");
        if (!strOptString.isEmpty()) {
            AdnDeviceManager.getInstance(context).saveAdnDid(strOptString);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("runtime_delivery");
        if (jSONObjectOptJSONObject != null) {
            try {
                WasmRuntimeController.getInstance().refreshFromMediationPlatformEffects(context, jSONObjectOptJSONObject, jSONObject.optBoolean("runtime_delivery_fresh", false));
            } catch (LinkageError e) {
            } catch (RuntimeException e2) {
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("telemetry_config");
        if (jSONObjectOptJSONObject2 != null) {
            MediationTelemetryHost.applyRemoteConfiguration(jSONObjectOptJSONObject2.optString("analytics_server", ""), stringList(jSONObjectOptJSONObject2.optJSONArray("optional_event_whitelist")), stringList(jSONObjectOptJSONObject2.optJSONArray("optional_event_blacklist")), jSONObjectOptJSONObject2.optBoolean("sdk_status_event_enabled", false), Math.max(1, jSONObjectOptJSONObject2.optInt("event_batch_count", 20)));
        }
        deliverTelemetry(jSONObject);
        apply(context, jSONObject.optJSONObject("platform_actions"));
    }

    public static void bind() {
        DirichletRuntime.getInstance().registerControlCallback(CALLBACK, CORE_CALLBACK);
    }

    private static void deliverTelemetry(JSONObject jSONObject) {
        try {
            MediationTelemetryHost.deliverCoreEvents(jSONObject.optJSONArray("telemetry_events"));
        } catch (LinkageError | RuntimeException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handle(String str, String str2) {
        if (CALLBACK.equals(str)) {
            try {
                if (str2 == null) {
                    str2 = "";
                }
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.optInt("schema_version", 0) == 1 && "shared_rust".equals(jSONObject.optString("owner")) && "mediation_platform_effects".equals(jSONObject.optString("kind"))) {
                    apply(AppContextHolder.appContext, jSONObject);
                }
            } catch (Throwable th) {
            }
        }
    }

    private static List<String> stringList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strTrim = jSONArray.optString(i, "").trim();
                if (!strTrim.isEmpty()) {
                    arrayList.add(strTrim);
                }
            }
        }
        return arrayList;
    }
}
