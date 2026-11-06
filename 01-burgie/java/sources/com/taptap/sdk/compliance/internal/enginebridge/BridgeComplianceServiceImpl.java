package com.taptap.sdk.compliance.internal.enginebridge;

import android.app.Activity;
import android.support.v4.app.NotificationCompat;
import com.byazt.mg.PluginConstants;
import com.byazt.ol.TTDownloadField;
import com.mar.sdk.IAction;
import com.taptap.sdk.compliance.TapTapCompliance;
import com.taptap.sdk.compliance.TapTapComplianceCallback;
import com.taptap.sdk.compliance.bean.CheckPaymentResult;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BridgeComplianceServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0014"}, d2 = {"Lcom/taptap/sdk/compliance/internal/enginebridge/BridgeComplianceServiceImpl;", "Lcom/taptap/sdk/compliance/internal/enginebridge/BridgeComplianceService;", "()V", "checkPaymentLimit", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", IAction.BuyKey.CostAmount, "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "exit", "getCurrentAccessToken", "getUserAgeRange", "getUserRemainTime", "registerComplianceCallback", "startup", "userId", "", "submitPayment", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BridgeComplianceServiceImpl implements BridgeComplianceService {
    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void registerComplianceCallback(final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoggerKt.logInfo("registerComplianceCallback from engine bridge");
        TapTapCompliance.registerComplianceCallback(new TapTapComplianceCallback() { // from class: com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceServiceImpl.registerComplianceCallback.1
            @Override // com.taptap.sdk.compliance.TapTapComplianceCallback
            public void onComplianceResult(int code, Map<String, ? extends Object> extra) throws JSONException {
                JSONObject $this$onComplianceResult_u24lambda_u242_u24lambda_u241;
                if (extra != null) {
                    $this$onComplianceResult_u24lambda_u242_u24lambda_u241 = new JSONObject();
                    for (Map.Entry<String, ? extends Object> entry : extra.entrySet()) {
                        $this$onComplianceResult_u24lambda_u242_u24lambda_u241.put(entry.getKey(), entry.getValue());
                    }
                } else {
                    $this$onComplianceResult_u24lambda_u242_u24lambda_u241 = null;
                }
                JSONObject extraObj = $this$onComplianceResult_u24lambda_u242_u24lambda_u241;
                JSONObject $this$onComplianceResult_u24lambda_u243 = new JSONObject();
                $this$onComplianceResult_u24lambda_u243.put(PluginConstants.KEY_ERROR_CODE, code);
                $this$onComplianceResult_u24lambda_u243.put("extras", extraObj);
                String resultJson = $this$onComplianceResult_u24lambda_u243.toString();
                Intrinsics.checkNotNullExpressionValue(resultJson, "JSONObject().apply {\n   …             }.toString()");
                TapLoggerKt.logInfo("engine bridge callback: result=" + resultJson);
                callback.onResult(resultJson);
            }
        });
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void startup(Activity activity, String userId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        TapLoggerKt.logInfo("startup from engine bridge");
        TapTapCompliance.startup(activity, userId);
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void checkPaymentLimit(Activity activity, int amount, final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoggerKt.logInfo("checkPaymentLimit from engine bridge: amount=" + amount);
        TapTapCompliance.checkPaymentLimit(activity, amount, new TapTapCallback<CheckPaymentResult>() { // from class: com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceServiceImpl.checkPaymentLimit.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(CheckPaymentResult result) throws JSONException {
                Intrinsics.checkNotNullParameter(result, "result");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TrackAction.SUCCESS, 0);
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, result.getStatus() ? 1 : 0);
                jSONObject.put(BundleKey.TITLE, result.getTitle());
                jSONObject.put(BundleKey.DESCRIPTION, result.getDescription());
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(string);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) throws JSONException {
                Intrinsics.checkNotNullParameter(exception, "exception");
                JSONObject $this$onFail_u24lambda_u241 = new JSONObject();
                $this$onFail_u24lambda_u241.put(TrackAction.SUCCESS, -1);
                $this$onFail_u24lambda_u241.put(BundleKey.DESCRIPTION, exception.getMessage());
                String resultJson = $this$onFail_u24lambda_u241.toString();
                Intrinsics.checkNotNullExpressionValue(resultJson, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(resultJson);
            }
        });
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void submitPayment(int amount, final EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoggerKt.logInfo("submitPayment from engine bridge: amount=" + amount);
        TapTapCompliance.submitPayment(amount, new TapTapCallback<JsonElement>() { // from class: com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceServiceImpl.submitPayment.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(JsonElement result) throws JSONException {
                Intrinsics.checkNotNullParameter(result, "result");
                JSONObject $this$onSuccess_u24lambda_u240 = new JSONObject();
                $this$onSuccess_u24lambda_u240.put(TrackAction.SUCCESS, 0);
                String resultJson = $this$onSuccess_u24lambda_u240.toString();
                Intrinsics.checkNotNullExpressionValue(resultJson, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(resultJson);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) throws JSONException {
                Intrinsics.checkNotNullParameter(exception, "exception");
                JSONObject $this$onFail_u24lambda_u241 = new JSONObject();
                $this$onFail_u24lambda_u241.put(TrackAction.SUCCESS, -1);
                $this$onFail_u24lambda_u241.put(BundleKey.DESCRIPTION, exception.getMessage());
                String resultJson = $this$onFail_u24lambda_u241.toString();
                Intrinsics.checkNotNullExpressionValue(resultJson, "JSONObject().apply {\n   …             }.toString()");
                callback.onResult(resultJson);
            }
        });
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void exit() {
        TapLoggerKt.logInfo("exit from engine bridge");
        TapTapCompliance.exit();
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void getUserAgeRange(EngineBridgeCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject ageRangeJson = new JSONObject();
        ageRangeJson.put("ageRange", TapComplianceInternal.INSTANCE.getUserAgeRange());
        String string = ageRangeJson.toString();
        Intrinsics.checkNotNullExpressionValue(string, "ageRangeJson.toString()");
        callback.onResult(string);
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void getUserRemainTime(EngineBridgeCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoggerKt.logInfo("getUserRemainTime from engine bridge");
        JSONObject $this$getUserRemainTime_u24lambda_u241 = new JSONObject();
        $this$getUserRemainTime_u24lambda_u241.put("remainTime", TapTapCompliance.getRemainingTime());
        String resultJson = $this$getUserRemainTime_u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(resultJson, "JSONObject().apply {\n   …e())\n        }.toString()");
        callback.onResult(resultJson);
    }

    @Override // com.taptap.sdk.compliance.internal.enginebridge.BridgeComplianceService
    public void getCurrentAccessToken(EngineBridgeCallback callback) throws JSONException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapLoggerKt.logInfo("getCurrentAccessToken from engine bridge");
        JSONObject $this$getCurrentAccessToken_u24lambda_u242 = new JSONObject();
        $this$getCurrentAccessToken_u24lambda_u242.put("token", TapTapCompliance.getCurrentAccessToken());
        String resultJson = $this$getCurrentAccessToken_u24lambda_u242.toString();
        Intrinsics.checkNotNullExpressionValue(resultJson, "JSONObject().apply {\n   …n())\n        }.toString()");
        callback.onResult(resultJson);
    }
}
