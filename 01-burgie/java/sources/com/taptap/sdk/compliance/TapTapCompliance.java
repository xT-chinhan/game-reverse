package com.taptap.sdk.compliance;

import android.app.Activity;
import com.byazt.ol.TTDownloadField;
import com.mar.sdk.IAction;
import com.taptap.sdk.compliance.bean.CheckPaymentResult;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.initializer.api.check.TapSdkChecker;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: TapTapCompliance.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nH\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0012H\u0007¨\u0006\u001b"}, d2 = {"Lcom/taptap/sdk/compliance/TapTapCompliance;", "", "()V", "checkPaymentLimit", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", IAction.BuyKey.CostAmount, "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compliance/bean/CheckPaymentResult;", "exit", "getAgeRange", "getCurrentAccessToken", "", "getRemainingTime", "registerComplianceCallback", "Lcom/taptap/sdk/compliance/TapTapComplianceCallback;", "setShowSwitchAccount", "showSwitchAccount", "", "startup", "userId", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "unregisterComplianceCallback", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapCompliance {
    public static final TapTapCompliance INSTANCE = new TapTapCompliance();

    private TapTapCompliance() {
    }

    @JvmStatic
    public static final void startup(Activity activity, String userId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        TapComplianceInternal.INSTANCE.startupWithTapTap(activity, userId);
    }

    @JvmStatic
    public static final void setShowSwitchAccount(boolean showSwitchAccount) {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        TapComplianceInternal.INSTANCE.setShowSwitchAccount(showSwitchAccount);
    }

    @JvmStatic
    public static final void registerComplianceCallback(TapTapComplianceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        TapComplianceInternal.INSTANCE.registerComplianceCallback(callback);
    }

    @JvmStatic
    public static final void unregisterComplianceCallback(TapTapComplianceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        TapComplianceInternal.INSTANCE.unregisterComplianceCallback(callback);
    }

    public static /* synthetic */ void checkPaymentLimit$default(Activity activity, int i, TapTapCallback tapTapCallback, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            tapTapCallback = null;
        }
        checkPaymentLimit(activity, i, tapTapCallback);
    }

    @JvmStatic
    public static final void checkPaymentLimit(Activity activity, int amount, TapTapCallback<CheckPaymentResult> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            if (callback != null) {
                callback.onFail(new TapTapException("SDK not initialized"));
                return;
            }
            return;
        }
        TapComplianceInternal.INSTANCE.checkPayment(activity, amount, callback);
    }

    public static /* synthetic */ void submitPayment$default(int i, TapTapCallback tapTapCallback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            tapTapCallback = null;
        }
        submitPayment(i, tapTapCallback);
    }

    @JvmStatic
    public static final void submitPayment(int amount, TapTapCallback<JsonElement> callback) {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            if (callback != null) {
                callback.onFail(new TapTapException("SDK not initialized"));
                return;
            }
            return;
        }
        TapComplianceInternal.INSTANCE.submitPayment(amount, callback);
    }

    @JvmStatic
    public static final void exit() {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return;
        }
        TapComplianceInternal.INSTANCE.unbindUser();
    }

    @JvmStatic
    public static final int getRemainingTime() {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return -1;
        }
        return TapComplianceInternal.INSTANCE.getRemainingTime();
    }

    @JvmStatic
    public static final String getCurrentAccessToken() {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return "";
        }
        return TapComplianceInternal.INSTANCE.getCurrentAccessToken();
    }

    @JvmStatic
    public static final int getAgeRange() {
        if (!TapSdkChecker.checkInitialize$default(TapSdkChecker.INSTANCE, false, 1, null)) {
            return -1;
        }
        return TapComplianceInternal.INSTANCE.getUserAgeRange();
    }
}
