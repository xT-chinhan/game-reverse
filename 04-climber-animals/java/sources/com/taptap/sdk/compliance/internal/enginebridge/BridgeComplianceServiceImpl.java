package com.taptap.sdk.compliance.internal.enginebridge;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.internal.tracker.experiment.d;
import com.taptap.sdk.compliance.TapTapCompliance;
import com.taptap.sdk.compliance.TapTapComplianceCallback;
import com.taptap.sdk.compliance.bean.CheckPaymentResult;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BridgeComplianceServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/compliance/internal/enginebridge/BridgeComplianceServiceImpl;", "Lcom/taptap/sdk/compliance/internal/enginebridge/BridgeComplianceService;", "()V", "checkPaymentLimit", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", d.q, "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "exit", "getCurrentAccessToken", "getUserAgeRange", "getUserRemainTime", "registerComplianceCallback", "startup", "userId", "", "submitPayment", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BridgeComplianceServiceImpl implements BridgeComplianceService {
    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void registerComplianceCallback(final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapComplianceLoggerKt.logInfo("registerComplianceCallback from engine bridge");
        TapTapCompliance.registerComplianceCallback(new TapTapComplianceCallback() { // from class: com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceServiceImpl.registerComplianceCallback.1
            @Override // com.taptap.sdk.compliance.TapTapComplianceCallback
            public void onComplianceResult(int code, Map<String, ? extends Object> extra) throws JSONException {
                JSONObject jSONObject;
                if (extra != null) {
                    jSONObject = new JSONObject();
                    for (Map.Entry<String, ? extends Object> entry : extra.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } else {
                    jSONObject = null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", code);
                jSONObject2.put("extras", jSONObject);
                String string = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …             }.toString()");
                TapComplianceLoggerKt.logInfo("engine bridge callback: result=" + string);
                callback.onResult(string);
            }
        });
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void startup(Activity activity, String userId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        TapComplianceLoggerKt.logInfo("startup from engine bridge");
        TapTapCompliance.startup(activity, userId);
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void checkPaymentLimit(Activity activity, int amount, final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapComplianceLoggerKt.logInfo("checkPaymentLimit from engine bridge: amount=" + amount);
        TapTapCompliance.checkPaymentLimit(activity, amount, new TapTapCallback<CheckPaymentResult>() { // from class: com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceServiceImpl.checkPaymentLimit.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(CheckPaymentResult result) throws JSONException {
                Intrinsics.checkNotNullParameter(result, "result");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", 0);
                jSONObject.put("status", result.getStatus() ? 1 : 0);
                jSONObject.put("title", result.getTitle());
                jSONObject.put(BundleKey.DESCRIPTION, result.getDescription());
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(string);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) throws JSONException {
                Intrinsics.checkNotNullParameter(exception, "exception");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", -1);
                jSONObject.put(BundleKey.DESCRIPTION, exception.getMessage());
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(string);
            }
        });
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void submitPayment(int amount, final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapComplianceLoggerKt.logInfo("submitPayment from engine bridge: amount=" + amount);
        TapTapCompliance.submitPayment(amount, new TapTapCallback<JsonElement>() { // from class: com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceServiceImpl.submitPayment.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(JsonElement result) throws JSONException {
                Intrinsics.checkNotNullParameter(result, "result");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", 0);
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(string);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) throws JSONException {
                Intrinsics.checkNotNullParameter(exception, "exception");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", -1);
                jSONObject.put(BundleKey.DESCRIPTION, exception.getMessage());
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(string);
            }
        });
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void exit() {
        TapComplianceLoggerKt.logInfo("exit from engine bridge");
        TapTapCompliance.exit();
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void getUserAgeRange(EngineBridgeCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ageRange", TapComplianceInternal.INSTANCE.getUserAgeRange());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "ageRangeJson.toString()");
        callback.onResult(string);
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void getUserRemainTime(EngineBridgeCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapComplianceLoggerKt.logInfo("getUserRemainTime from engine bridge");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("remainTime", TapTapCompliance.getRemainingTime());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …e())\n        }.toString()");
        callback.onResult(string);
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void getCurrentAccessToken(EngineBridgeCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapComplianceLoggerKt.logInfo("getCurrentAccessToken from engine bridge");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", TapTapCompliance.getCurrentAccessToken());
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …n())\n        }.toString()");
        callback.onResult(string);
    }
}
