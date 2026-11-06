package com.taptap.sdk.compilance;

import android.app.Activity;
import com.taptap.sdk.compilance.bean.CheckPaymentResult;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: compiled from: TapTapCompliance.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000fH\u0007J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nH\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0012H\u0007¨\u0006\u001b"}, d2 = {"Lcom/taptap/sdk/compilance/TapTapCompliance;", "", "()V", "checkPaymentLimit", "", "activity", "Landroid/app/Activity;", "amount", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "Lcom/taptap/sdk/compilance/bean/CheckPaymentResult;", "exit", "getAgeRange", "getCurrentAccessToken", "", "getRemainingTime", "registerComplianceCallback", "Lcom/taptap/sdk/compilance/TapTapComplianceCallback;", "setTestEnvironment", "isTestEnv", "", "startup", "userId", "submitPayment", "Lkotlinx/serialization/json/JsonElement;", "unregisterComplianceCallback", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapCompliance {
    public static final TapTapCompliance INSTANCE = new TapTapCompliance();

    private TapTapCompliance() {
    }

    @JvmStatic
    public static final void startup(Activity activity, String userId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userId, "userId");
        TapComplianceInternal.INSTANCE.startupWithTapTap(activity, userId);
    }

    @JvmStatic
    public static final void registerComplianceCallback(TapTapComplianceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapComplianceInternal.INSTANCE.registerComplianceCallback(callback);
    }

    @JvmStatic
    public static final void unregisterComplianceCallback(TapTapComplianceCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
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
        TapComplianceInternal.INSTANCE.submitPayment(amount, callback);
    }

    @JvmStatic
    public static final void exit() {
        TapComplianceInternal.INSTANCE.unbindUser();
    }

    @JvmStatic
    public static final int getRemainingTime() {
        return TapComplianceInternal.INSTANCE.getRemainingTime();
    }

    @JvmStatic
    public static final String getCurrentAccessToken() {
        return TapComplianceInternal.INSTANCE.getCurrentAccessToken();
    }

    @JvmStatic
    public static final void setTestEnvironment(Activity activity, boolean isTestEnv) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        TapComplianceInternal.INSTANCE.setTestEnvironment(activity, isTestEnv);
    }

    @JvmStatic
    public static final int getAgeRange() {
        return TapComplianceInternal.INSTANCE.getUserAgeRange();
    }
}
