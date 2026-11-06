package com.tapsdk.tapad.internal.runtime;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.byazt.mg.PluginConstants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeCreativeSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.model.TapLoginModelKt;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationRuntimeCoreBridge {
    private static final int ERR_INVALID_OUTPUT = -9617;
    private static final int ERR_RUNTIME_UNAVAILABLE = -9612;
    private static final long MAX_ATTEMPT_ID = 4294967295L;
    private static final int MAX_OUTPUT_BYTES = 2097152;
    private static final int OP_ACK_EVENT = 104;
    private static final int OP_BIND_LOAD_PLAN = 105;
    private static final int OP_CLAIM_PROVIDER_BILLING = 114;
    private static final int OP_CLAIM_SCREENSHOT = 113;
    private static final int OP_MAKE_TRACK_ID = 106;
    private static final int OP_PROJECT_EVENT = 103;
    private static final int OP_PROJECT_ORIGIN_FIELDS = 117;
    private static final int OP_PROJECT_PRICING_INGRESS = 112;
    private static final int OP_PROJECT_PROVIDER_CREATIVE = 116;
    private static final int OP_PROJECT_PUBLISHER_SETTINGS = 115;
    private static final int OP_RECORD_FILL = 110;
    private static final int OP_RELEASE_LOAD_PLAN = 107;
    private static final int OP_RESOLVE_ADAPTER_REGISTRY_TERMINAL = 118;
    private static final int OP_RESOLVE_REWARD_CALLBACK = 120;
    private static final int OP_UPDATE_FILL_WIN = 111;
    private static final String TAG = "MediationRuntimeCore";

    public static final class Result {
        public final JSONObject output;
        public final int status;

        /* JADX INFO: Access modifiers changed from: private */
        public static Result failure(int i) {
            return new Result(i, null);
        }

        public boolean isSuccess() {
            return this.status > 0 && this.output != null;
        }

        private Result(int i, JSONObject jSONObject) {
            this.status = i;
            this.output = jSONObject;
        }
    }

    public interface RewardCallbackCommandReceiver {
        void onCommand(JSONObject jSONObject);

        default void onError(int i) {
        }
    }

    private MediationRuntimeCoreBridge() {
    }

    public static void acknowledgeEvent(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            transform(currentModule(), 104, new JSONObject().put("event_id", str).put("accepted", z));
        } catch (Throwable th) {
        }
    }

    public static byte[] bindLoadPlan(String str, List<Integer> list) {
        if (str == null || str.isEmpty() || list == null || list.isEmpty()) {
            return new byte[0];
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                if (num != null && num.intValue() > 0) {
                    jSONArray.put(num);
                }
                return new byte[0];
            }
            Result resultTransform = transform(currentModule(), 105, new JSONObject().put(Constants.Bidding.REQUEST_ID, str).put("bound_route_keys", jSONArray));
            if (!resultTransform.isSuccess()) {
                return new byte[0];
            }
            String strOptString = resultTransform.output.optString("scheduler_facts", "");
            return strOptString.isEmpty() ? new byte[0] : Base64.decode(strOptString.replace('-', '/'), 3);
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    public static JSONObject buildRecordFillFacts(String str, int i, long j, int i2, Long l, long j2, Long l2, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(Constants.Bidding.REQUEST_ID, str).put("route_key", i).put("attempt_id", j).put("offset", i2).put("fill_time", j2);
        if (str2 == null) {
            str2 = "";
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("track_id", str2);
        if (str3 == null) {
            str3 = "";
        }
        JSONObject jSONObjectPut3 = jSONObjectPut2.put("adn_track_id", str3);
        if (str4 == null) {
            str4 = "";
        }
        JSONObject jSONObjectPut4 = jSONObjectPut3.put("adn_extra_info", str4);
        if (l != null) {
            jSONObjectPut4.put("provider_price", l);
        }
        if (l2 != null) {
            jSONObjectPut4.put("event_time_ms", l2);
        }
        return jSONObjectPut4;
    }

    public static long claimCandidateScreenshot(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                Result resultTransform = transform(currentModule(), 113, new JSONObject().put("track_id", str));
                if (resultTransform.isSuccess()) {
                    return Math.max(0L, resultTransform.output.optLong("delay_ms", 0L));
                }
                return 0L;
            } catch (Throwable th) {
            }
        }
        return 0L;
    }

    public static boolean claimProviderBilling(String str, boolean z, boolean z2) {
        if (str != null && !str.isEmpty()) {
            try {
                Result resultTransform = transform(currentModule(), 114, new JSONObject().put("track_id", str).put("phase", z ? "settlement" : "media").put("win", z2));
                return resultTransform.isSuccess() && resultTransform.output.optBoolean("notify_provider", false);
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static WasmModule currentModule() {
        try {
            return DirichletRuntime.getInstance().getModule("core");
        } catch (Throwable th) {
            return null;
        }
    }

    private static void deliverRewardCallback(RewardCallbackCommandReceiver rewardCallbackCommandReceiver, JSONObject jSONObject) {
        deliverRewardCallback(rewardCallbackCommandReceiver, jSONObject, 0);
    }

    private static void deliverRewardCallbackError(RewardCallbackCommandReceiver rewardCallbackCommandReceiver, int i) {
        deliverRewardCallback(rewardCallbackCommandReceiver, null, i);
    }

    static /* synthetic */ void lambda$deliverRewardCallback$1(int i, RewardCallbackCommandReceiver rewardCallbackCommandReceiver, JSONObject jSONObject) {
        if (i == 0) {
            rewardCallbackCommandReceiver.onCommand(jSONObject);
        } else {
            rewardCallbackCommandReceiver.onError(i);
        }
    }

    static /* synthetic */ void lambda$resolveRewardCallback$0(JSONObject jSONObject, RewardCallbackCommandReceiver rewardCallbackCommandReceiver) {
        Result resultTransform = transform(currentModule(), 120, jSONObject);
        boolean zIsSuccess = resultTransform.isSuccess();
        int i = ERR_INVALID_OUTPUT;
        if (!zIsSuccess) {
            int i2 = resultTransform.status;
            if (i2 < 0) {
                i = i2;
            }
            deliverRewardCallbackError(rewardCallbackCommandReceiver, i);
            return;
        }
        if (!"shared_rust".equals(resultTransform.output.optString("owner", "")) || !"reward_callback_command".equals(resultTransform.output.optString("kind", "")) || !resultTransform.output.has("command")) {
            deliverRewardCallbackError(rewardCallbackCommandReceiver, ERR_INVALID_OUTPUT);
            return;
        }
        Object objOpt = resultTransform.output.opt("command");
        JSONObject jSONObject2 = null;
        if (objOpt == JSONObject.NULL) {
            deliverRewardCallback(rewardCallbackCommandReceiver, null);
            return;
        }
        if (objOpt instanceof JSONObject) {
            JSONObject jSONObject3 = (JSONObject) objOpt;
            if ((jSONObject3.opt(Common.System.NAME) instanceof String) && (jSONObject3.opt("payload") instanceof JSONObject)) {
                jSONObject2 = jSONObject3;
            }
        }
        if (jSONObject2 == null) {
            deliverRewardCallbackError(rewardCallbackCommandReceiver, ERR_INVALID_OUTPUT);
        } else {
            deliverRewardCallback(rewardCallbackCommandReceiver, jSONObject2);
        }
    }

    public static String makeTrackId(String str, int i, int i2, long j) {
        if (str == null || str.isEmpty() || i <= 0 || i2 < 0) {
            return "";
        }
        try {
            Result resultTransform = transform(currentModule(), 106, new JSONObject().put(Constants.Bidding.REQUEST_ID, str).put("route_key", i).put("request_offset", i2).put("event_time_ms", j));
            return resultTransform.isSuccess() ? resultTransform.output.optString("track_id", "") : "";
        } catch (Throwable th) {
            return "";
        }
    }

    public static byte[] normalizeProviderCreative(String str, String str2, AdapterNativeCreativeSession adapterNativeCreativeSession, long j) {
        if (adapterNativeCreativeSession == null) {
            return new byte[0];
        }
        try {
            JSONArray jSONArray = new JSONArray();
            List<AdapterNativeImage> images = adapterNativeCreativeSession.getImages();
            if (images != null) {
                for (AdapterNativeImage adapterNativeImage : images) {
                    if (adapterNativeImage != null) {
                        jSONArray.put(new JSONObject().put(BreakpointSQLiteKey.URL, safe(adapterNativeImage.getUrl())).put("width", adapterNativeImage.getWidth()).put("height", adapterNativeImage.getHeight()));
                    }
                }
            }
            AdapterAppComplianceInfo complianceInfo = adapterNativeCreativeSession.getComplianceInfo();
            if (complianceInfo == null) {
                complianceInfo = AdapterAppComplianceInfo.EMPTY;
            }
            return normalizeProviderCreative(new JSONObject().put("format", safe(str)).put("creative_id", safe(str2)).put(BundleKey.TITLE, safe(adapterNativeCreativeSession.getTitle())).put(BundleKey.DESCRIPTION, safe(adapterNativeCreativeSession.getDescription())).put("icon_url", safe(adapterNativeCreativeSession.getIconUrl())).put("image_mode", adapterNativeCreativeSession.getImageMode()).put("interaction_type", adapterNativeCreativeSession.getInteractionType()).put("video_mute_control", adapterNativeCreativeSession.supportsVideoMuteControl()).put("video_muted_by_default", adapterNativeCreativeSession.isVideoMutedByDefault()).put("duration_ms", Math.max(0L, adapterNativeCreativeSession.getDurationMillis())).put("expires_at_ms", j).put("images", jSONArray).put(TapLoginModelKt.COMPLIANCE_SCOPE, new JSONObject().put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, complianceInfo.getAppName()).put("app_version", complianceInfo.getAppVersion()).put("developer_name", complianceInfo.getDeveloperName()).put("privacy_url", complianceInfo.getPrivacyUrl()).put("function_desc_url", complianceInfo.getFunctionDescriptionUrl()).put(NativeUnifiedADAppInfoImpl.Keys.PERMISSION_URL, complianceInfo.getPermissionUrl()).put("ad_logo_url", complianceInfo.getAdLogoUrl())));
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    public static Result projectCurrentPublisherSettings() {
        try {
            return transform(currentModule(), 115, new JSONObject().put("media_global_settings", PublisherSettingsBridge.snapshot()));
        } catch (Throwable th) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
    }

    public static Result projectEvent(JSONObject jSONObject) {
        return transform(currentModule(), 103, jSONObject);
    }

    public static Result projectOriginFields(JSONObject jSONObject) {
        try {
            WasmModule wasmModuleCurrentModule = currentModule();
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            return transform(wasmModuleCurrentModule, 117, jSONObject2.put("fields", jSONObject));
        } catch (Throwable th) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
    }

    public static byte[] projectPricingIngress(String str, int i, JSONArray jSONArray) {
        if (str == null || str.isEmpty() || i <= 0 || jSONArray == null || jSONArray.length() == 0) {
            return new byte[0];
        }
        try {
            Result resultTransform = transform(currentModule(), 112, new JSONObject().put(Constants.Bidding.REQUEST_ID, str).put("route_key", i).put("track_ids", jSONArray));
            if (!resultTransform.isSuccess()) {
                return new byte[0];
            }
            String strOptString = resultTransform.output.optString("pricing_ingress", "");
            return strOptString.isEmpty() ? new byte[0] : Base64.decode(strOptString.replace('-', '/'), 3);
        } catch (Throwable th) {
            return new byte[0];
        }
    }

    public static Result projectPublisherSettings(String str) {
        try {
            WasmModule wasmModuleCurrentModule = currentModule();
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "";
            }
            return transform(wasmModuleCurrentModule, 115, jSONObject.put("base_data", str).put("media_global_settings", PublisherSettingsBridge.snapshot()));
        } catch (Throwable th) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
    }

    public static Boolean recordFill(String str, int i, int i2, long j, long j2, String str2, String str3, String str4) {
        return recordFill(str, i, 0L, i2, j, j2, str2, str3, str4);
    }

    public static boolean recordNoFill(String str, int i, int i2, long j) {
        return recordNoFill(str, i, 0L, i2, j);
    }

    public static void releaseLoadPlan(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            transform(currentModule(), 107, new JSONObject().put(Constants.Bidding.REQUEST_ID, str));
        } catch (Throwable th) {
        }
    }

    public static Result resolveAdapterRegistryTerminal(int i, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
        try {
            Result resultTransform = transform(currentModule(), 118, new JSONObject().put("ready_count", i).put("failed_count", i2).put("unavailable_count", i3));
            if (resultTransform.isSuccess() && (resultTransform.output.opt("succeeded") instanceof Boolean) && (resultTransform.output.opt(PluginConstants.KEY_ERROR_CODE) instanceof Number) && (resultTransform.output.opt("message") instanceof String)) {
                return resultTransform;
            }
            return Result.failure(ERR_INVALID_OUTPUT);
        } catch (Throwable th) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
    }

    public static void resolveRewardCallback(JSONObject jSONObject, final RewardCallbackCommandReceiver rewardCallbackCommandReceiver) {
        if (rewardCallbackCommandReceiver == null) {
            return;
        }
        if (jSONObject == null) {
            deliverRewardCallbackError(rewardCallbackCommandReceiver, ERR_INVALID_OUTPUT);
            return;
        }
        try {
            final JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
            Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediationRuntimeCoreBridge.lambda$resolveRewardCallback$0(jSONObject2, rewardCallbackCommandReceiver);
                }
            };
            if (dirichletRuntime.isOnRuntimeQueue()) {
                runnable.run();
            } else {
                if (dirichletRuntime.runOnRuntimeQueue(runnable)) {
                    return;
                }
                deliverRewardCallbackError(rewardCallbackCommandReceiver, ERR_RUNTIME_UNAVAILABLE);
            }
        } catch (Throwable th) {
            deliverRewardCallbackError(rewardCallbackCommandReceiver, ERR_INVALID_OUTPUT);
        }
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    private static Result transform(WasmModule wasmModule, int i, JSONObject jSONObject) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null && Looper.myLooper() == mainLooper) {
            return Result.failure(ERR_RUNTIME_UNAVAILABLE);
        }
        if (wasmModule == null || wasmModule.isUnloaded()) {
            return Result.failure(ERR_RUNTIME_UNAVAILABLE);
        }
        if (jSONObject == null) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
        try {
            String string = jSONObject.toString();
            Charset charset = StandardCharsets.UTF_8;
            WasmModule.MediationProtocolResult mediationProtocolResultCallMediationProtocolSync = wasmModule.callMediationProtocolSync(i, string.getBytes(charset));
            if (mediationProtocolResultCallMediationProtocolSync.isSuccess()) {
                byte[] bArr = mediationProtocolResultCallMediationProtocolSync.output;
                if (bArr.length != 0 && bArr.length <= 2097152) {
                    JSONObject jSONObject2 = new JSONObject(new String(mediationProtocolResultCallMediationProtocolSync.output, charset));
                    return jSONObject2.optInt("schema_version", 0) != 1 ? Result.failure(ERR_INVALID_OUTPUT) : new Result(mediationProtocolResultCallMediationProtocolSync.status, jSONObject2);
                }
            }
            return Result.failure(mediationProtocolResultCallMediationProtocolSync.status);
        } catch (Throwable th) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
    }

    public static boolean updateFillWin(String str, boolean z, long j, long j2, long j3) {
        if (str != null && !str.isEmpty()) {
            try {
                return transform(currentModule(), 111, new JSONObject().put("track_id", str).put(com.tapsdk.tapad.group.constants.Constants.IS_WIN_FIELD, z).put("selection_rank", j).put("adjusted_price", j2).put("clearing_price", j3)).isSuccess();
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static void deliverRewardCallback(final RewardCallbackCommandReceiver rewardCallbackCommandReceiver, final JSONObject jSONObject, final int i) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null || Looper.myLooper() != mainLooper) {
            if (mainLooper != null) {
                new Handler(mainLooper).post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.MediationRuntimeCoreBridge$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediationRuntimeCoreBridge.lambda$deliverRewardCallback$1(i, rewardCallbackCommandReceiver, jSONObject);
                    }
                });
            }
        } else if (i == 0) {
            rewardCallbackCommandReceiver.onCommand(jSONObject);
        } else {
            rewardCallbackCommandReceiver.onError(i);
        }
    }

    public static Boolean recordFill(String str, int i, long j, int i2, long j2, long j3, String str2, String str3, String str4) {
        if (str != null && !str.isEmpty() && i > 0 && j > 0 && j <= MAX_ATTEMPT_ID) {
            try {
                Result resultTransform = transform(currentModule(), 110, buildRecordFillFacts(str, i, j, i2, Long.valueOf(j2), j3, Long.valueOf(System.currentTimeMillis()), str2, str3, str4));
                if (resultTransform.isSuccess()) {
                    return Boolean.valueOf(resultTransform.output.optBoolean("price_disclosure", false));
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static boolean recordNoFill(String str, int i, long j, int i2, long j2) {
        if (str != null && !str.isEmpty() && i > 0 && j > 0 && j <= MAX_ATTEMPT_ID) {
            try {
                return transform(currentModule(), 110, buildRecordFillFacts(str, i, j, i2, null, j2, null, "", "", "")).isSuccess();
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static byte[] normalizeProviderCreative(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new byte[0];
        }
        try {
            Result resultTransform = transform(currentModule(), 116, jSONObject);
            if (!resultTransform.isSuccess()) {
                return new byte[0];
            }
            String strOptString = resultTransform.output.optString("normalized_creative", "");
            return strOptString.isEmpty() ? new byte[0] : Base64.decode(strOptString.replace('-', '/'), 3);
        } catch (Throwable th) {
            return new byte[0];
        }
    }
}
