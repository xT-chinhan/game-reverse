package com.taptap.sdk.compliance.internal.enginebridge;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.internal.tracker.experiment.d;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeParams;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import kotlin.Metadata;

/* JADX INFO: compiled from: BridgeComplianceService.kt */
/* JADX INFO: loaded from: classes2.dex */
@EngineBridgeService("BridgeComplianceService")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\b\u0010\n\u001a\u00020\u0003H'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'J\u001a\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'¨\u0006\u0013"}, d2 = {"Lcom/taptap/sdk/compliance/internal/enginebridge/BridgeComplianceService;", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "checkPaymentLimit", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", d.q, "", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "exit", "getCurrentAccessToken", "getUserAgeRange", "getUserRemainTime", "registerComplianceCallback", "startup", "userId", "", "submitPayment", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface BridgeComplianceService extends IEngineBridgeService {
    @EngineBridgeMethod("checkPaymentLimit")
    void checkPaymentLimit(Activity activity, @EngineBridgeParams(d.q) int amount, EngineBridgeCallback callback);

    @EngineBridgeMethod("exit")
    void exit();

    @EngineBridgeMethod("getCurrentAccessToken")
    void getCurrentAccessToken(EngineBridgeCallback callback);

    @EngineBridgeMethod("getUserAgeRange")
    void getUserAgeRange(EngineBridgeCallback callback);

    @EngineBridgeMethod("getUserRemainTime")
    void getUserRemainTime(EngineBridgeCallback callback);

    @EngineBridgeMethod("registerComplianceCallback")
    void registerComplianceCallback(EngineBridgeCallback callback);

    @EngineBridgeMethod("startup")
    void startup(Activity activity, @EngineBridgeParams("userId") String userId);

    @EngineBridgeMethod("submitPayment")
    void submitPayment(@EngineBridgeParams("submitAmount") int amount, EngineBridgeCallback callback);
}
