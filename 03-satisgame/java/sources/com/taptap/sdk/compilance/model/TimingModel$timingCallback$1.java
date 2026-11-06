package com.taptap.sdk.compilance.model;

import android.os.Message;
import android.text.TextUtils;
import com.taptap.sdk.compilance.TimingCallback;
import com.taptap.sdk.compilance.bean.CheckPlayResult;
import com.taptap.sdk.compilance.bean.UserInfo;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import com.taptap.sdk.compilance.extensions.SystemExtKt;
import com.taptap.sdk.compilance.internal.TapComplianceInternal;
import com.taptap.sdk.compilance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"com/taptap/sdk/compilance/model/TimingModel$timingCallback$1", "Lcom/taptap/sdk/compilance/TimingCallback;", "childTimeRunOut", "", "countDown", "", "countTime", "countingCallback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "syncServerError", "unbind", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimingModel$timingCallback$1 implements TimingCallback {
    TimingModel$timingCallback$1() {
    }

    @Override // com.taptap.sdk.compilance.TimingCallback
    public void countTime(final TapTapCallback<Boolean> countingCallback) {
        if (UserModel.INSTANCE.getCurrentUser() == null) {
            return;
        }
        TimingModel.INSTANCE.syncTime(new TapTapCallback<CheckPlayResult>() { // from class: com.taptap.sdk.compilance.model.TimingModel$timingCallback$1$countTime$1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(CheckPlayResult result) {
                TapLogger.logi(TapComplianceLoggerKt.LOGGER_TAG, "countTime success: result=" + result);
                IntRange intRange = new IntRange(1, TimingModel.INSTANCE.getTimingInterval());
                Integer numValueOf = result != null ? Integer.valueOf(result.getRemainTime()) : null;
                if (numValueOf != null && intRange.contains(numValueOf.intValue())) {
                    TimingHandler timingHandler = TimingModel.handler;
                    if (timingHandler != null) {
                        Message messageObtainMessage = timingHandler.obtainMessage();
                        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "it.obtainMessage()");
                        messageObtainMessage.what = 1;
                        timingHandler.sendMessageDelayed(messageObtainMessage, 1000L);
                    }
                    TapTapCallback<Boolean> tapTapCallback = countingCallback;
                    if (tapTapCallback != null) {
                        tapTapCallback.onSuccess(false);
                        return;
                    }
                    return;
                }
                if ((result != null ? result.getRemainTime() : 0) <= 0) {
                    SystemExtKt.runOnMain(new TimingModel$timingCallback$1$countTime$1$onSuccess$2(result, null));
                }
                TapTapCallback<Boolean> tapTapCallback2 = countingCallback;
                if (tapTapCallback2 != null) {
                    tapTapCallback2.onSuccess(true);
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapTapCallback<Boolean> tapTapCallback = countingCallback;
                if (tapTapCallback != null) {
                    tapTapCallback.onFail(exception);
                }
            }
        });
    }

    @Override // com.taptap.sdk.compilance.TimingCallback
    public boolean countDown() {
        if (UserModel.INSTANCE.getCurrentUser() == null) {
            return true;
        }
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser != null) {
            currentUser.updateRemainTime(1);
        }
        UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
        if ((currentUser2 != null ? currentUser2.getRemainTime() : 0) > 0) {
            return false;
        }
        TimingHandler timingHandler = TimingModel.handler;
        if (timingHandler != null) {
            Message messageObtainMessage = timingHandler.obtainMessage();
            Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "it.obtainMessage()");
            messageObtainMessage.what = 3;
            timingHandler.sendMessage(messageObtainMessage);
        }
        return true;
    }

    @Override // com.taptap.sdk.compilance.TimingCallback
    public void childTimeRunOut() {
        if (UserModel.INSTANCE.getCurrentUser() == null) {
            return;
        }
        TimingModel.INSTANCE.syncTime(new TapTapCallback<CheckPlayResult>() { // from class: com.taptap.sdk.compilance.model.TimingModel$timingCallback$1$childTimeRunOut$1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(CheckPlayResult result) {
                if ((result != null ? result.getRemainTime() : 0) <= 0) {
                    SystemExtKt.runOnMain(new TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1(result, result, null));
                    this.this$0.unbind();
                } else {
                    TimingCallback.DefaultImpls.countTime$default(this.this$0, null, 1, null);
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                TapComplianceLoggerKt.logError("syncTime error: cause=" + exception.getMessage(), exception);
            }
        });
    }

    @Override // com.taptap.sdk.compilance.TimingCallback
    public void unbind() {
        TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
    }

    @Override // com.taptap.sdk.compilance.TimingCallback
    public void syncServerError() {
        UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
        if (currentUser == null || TextUtils.isEmpty(currentUser.getAccessToken())) {
            return;
        }
        TimingModel.INSTANCE.unbind();
        TapComplianceInternal.INSTANCE.notifyMessageInternal(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, MapsKt.mapOf(TuplesKt.to(BundleKey.DESCRIPTION, "网络异常，请稍后重试")));
    }
}
