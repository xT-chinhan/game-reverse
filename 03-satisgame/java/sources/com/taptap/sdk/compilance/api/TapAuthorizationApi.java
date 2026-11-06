package com.taptap.sdk.compilance.api;

import android.app.Activity;
import com.taptap.sdk.compilance.TapAuthorizationCallback;
import com.taptap.sdk.compilance.bean.IdentityVerifyState;
import com.taptap.sdk.compilance.bean.IdentityVerifyStateKt;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compilance.model.TapLoginModel;
import com.taptap.sdk.compilance.widget.ComplianceUIHelper;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.AccessToken;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapAuthorizationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/compilance/api/TapAuthorizationApi;", "", "()V", "checkAuthorizationFromTapTap", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/taptap/sdk/compilance/TapAuthorizationCallback;", "uploadTapAuthorizationInfo", "accessToken", "Lcom/taptap/sdk/login/AccessToken;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapAuthorizationApi {
    public static final TapAuthorizationApi INSTANCE = new TapAuthorizationApi();

    private TapAuthorizationApi() {
    }

    public final void checkAuthorizationFromTapTap(final Activity activity, final TapAuthorizationCallback callback) {
        Object objM184constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Result.Companion companion = Result.INSTANCE;
            TapAuthorizationApi tapAuthorizationApi = this;
            ComplianceUIHelper.showLoading$default(ComplianceUIHelper.INSTANCE, activity, 0L, 2, null);
            TapLoginModel.INSTANCE.getTapIdentifyToken(activity, new TapTapCallback<AccessToken>() { // from class: com.taptap.sdk.compilance.api.TapAuthorizationApi$checkAuthorizationFromTapTap$1$1
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onSuccess(AccessToken result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    this.$this_runCatching.uploadTapAuthorizationInfo(result, callback);
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onCancel() {
                    ComplianceUIHelper.INSTANCE.dismissLoading();
                    ComplianceUIHelper.INSTANCE.showToast(activity, "授权取消");
                    callback.onCancel();
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onFail(TapTapException exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    ComplianceUIHelper.INSTANCE.dismissLoading();
                    ComplianceUIHelper.INSTANCE.showToast(activity, "授权失败");
                    callback.goToRealNameManual();
                }
            });
            objM184constructorimpl = Result.m184constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            thM187exceptionOrNullimpl.printStackTrace();
            callback.goToRealNameManual();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadTapAuthorizationInfo(AccessToken accessToken, final TapAuthorizationCallback callback) {
        IdentityVerifyApi.INSTANCE.getTokenWithTapToken(accessToken, new TapTapCallback<IdentityVerifyState>() { // from class: com.taptap.sdk.compilance.api.TapAuthorizationApi.uploadTapAuthorizationInfo.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(IdentityVerifyState result) {
                Intrinsics.checkNotNullParameter(result, "result");
                ComplianceUIHelper.INSTANCE.dismissLoading();
                String verifyState = result.getVerifyState();
                if (Intrinsics.areEqual(verifyState, IdentityVerifyStateKt.VERIFY_STATE_SUCCESS)) {
                    callback.onSuccess(result);
                } else if (Intrinsics.areEqual(verifyState, IdentityVerifyStateKt.VERIFY_STATE_WAITING)) {
                    callback.goToUnderReview();
                } else {
                    callback.goToRealNameManual();
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapComplianceLoggerKt.logError(exception.getMessage(), exception);
                ComplianceUIHelper.INSTANCE.dismissLoading();
                callback.goToRealNameManual();
            }
        });
    }
}
