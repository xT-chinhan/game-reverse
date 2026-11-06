package com.taptap.sdk.compliance.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.taptap.sdk.compliance.TimingCallback;
import com.taptap.sdk.compliance.bean.AntiPolicy;
import com.taptap.sdk.compliance.bean.CheckPlayResult;
import com.taptap.sdk.compliance.bean.UserAntiConfig;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.TapComplianceInternal;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.NetExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\u0018\u0010\u001b\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/compliance/model/TimingModel;", "", "()V", "handler", "Lcom/taptap/sdk/compliance/model/TimingHandler;", "handlerThread", "Landroid/os/HandlerThread;", "isTiming", "", "()Z", "setTiming", "(Z)V", "timingCallback", "com/taptap/sdk/compliance/model/TimingModel$timingCallback$1", "Lcom/taptap/sdk/compliance/model/TimingModel$timingCallback$1;", "timingInterval", "", "getTimingInterval", "()I", "setTimingInterval", "(I)V", "bind", "Lkotlinx/coroutines/Job;", "checkPlayable", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "sendGameTimeToServerSync", "Lcom/taptap/sdk/compliance/bean/CheckPlayResult;", "syncTime", "unbind", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimingModel {
    private static TimingHandler handler;
    private static HandlerThread handlerThread;
    private static boolean isTiming;
    public static final TimingModel INSTANCE = new TimingModel();
    private static int timingInterval = 120;
    private static final TimingModel$timingCallback$1 timingCallback = new TimingCallback() { // from class: com.taptap.sdk.compliance.model.TimingModel$timingCallback$1
        @Override // com.taptap.sdk.compliance.TimingCallback
        public void countTime(final TapTapCallback<Boolean> countingCallback) {
            TapLoggerKt.logInfo("execute countTime: current user=" + UserModel.INSTANCE.getCurrentUser());
            if (UserModel.INSTANCE.getCurrentUser() == null) {
                return;
            }
            TimingModel.INSTANCE.syncTime(new TapTapCallback<CheckPlayResult>() { // from class: com.taptap.sdk.compliance.model.TimingModel$timingCallback$1$countTime$1
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onCancel() {
                    TapTapCallback.DefaultImpls.onCancel(this);
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onSuccess(CheckPlayResult result) {
                    TapLoggerKt.logInfo("countTime success: result=" + result);
                    IntRange intRange = new IntRange(1, TimingModel.INSTANCE.getTimingInterval());
                    Integer numValueOf = result != null ? Integer.valueOf(result.getRemainTime()) : null;
                    if (numValueOf != null && intRange.contains(numValueOf.intValue())) {
                        TapLoggerKt.logInfo("count down, current remain time = " + (result != null ? Integer.valueOf(result.getRemainTime()) : null));
                        TimingHandler it = TimingModel.handler;
                        if (it != null) {
                            Message message = it.obtainMessage();
                            Intrinsics.checkNotNullExpressionValue(message, "it.obtainMessage()");
                            message.what = 1;
                            it.sendMessageDelayed(message, 1000L);
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
                    TapLoggerKt.logInfo("countTime fail: cause=" + exception);
                    TapTapCallback<Boolean> tapTapCallback = countingCallback;
                    if (tapTapCallback != null) {
                        tapTapCallback.onFail(exception);
                    }
                }
            });
        }

        @Override // com.taptap.sdk.compliance.TimingCallback
        public boolean countDown() {
            if (UserModel.INSTANCE.getCurrentUser() == null) {
                return true;
            }
            UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
            if (currentUser != null) {
                currentUser.updateRemainTime(1);
            }
            StringBuilder sbAppend = new StringBuilder().append("count down, current remain time = ");
            UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
            TapLoggerKt.logInfo(sbAppend.append(currentUser2 != null ? Integer.valueOf(currentUser2.getRemainTime()) : null).toString());
            UserInfo currentUser3 = UserModel.INSTANCE.getCurrentUser();
            if ((currentUser3 != null ? currentUser3.getRemainTime() : 0) > 0) {
                return false;
            }
            TimingHandler it = TimingModel.handler;
            if (it != null) {
                Message msg = it.obtainMessage();
                Intrinsics.checkNotNullExpressionValue(msg, "it.obtainMessage()");
                msg.what = 3;
                it.sendMessage(msg);
            }
            return true;
        }

        @Override // com.taptap.sdk.compliance.TimingCallback
        public void childTimeRunOut() {
            if (UserModel.INSTANCE.getCurrentUser() == null) {
                return;
            }
            TimingModel.INSTANCE.syncTime(new TapTapCallback<CheckPlayResult>() { // from class: com.taptap.sdk.compliance.model.TimingModel$timingCallback$1$childTimeRunOut$1
                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onCancel() {
                    TapTapCallback.DefaultImpls.onCancel(this);
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onSuccess(CheckPlayResult result) {
                    if ((result != null ? result.getRemainTime() : 0) <= 0) {
                        SystemExtKt.runOnMain(new TimingModel$timingCallback$1$childTimeRunOut$1$onSuccess$1(result, result, null));
                        TimingModel.INSTANCE.unbind();
                    } else {
                        TimingCallback.DefaultImpls.countTime$default(this.this$0, null, 1, null);
                    }
                }

                @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                public void onFail(TapTapException exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    TapLoggerKt.logError("syncTime error: cause=" + exception.getMessage(), exception);
                }
            });
        }

        @Override // com.taptap.sdk.compliance.TimingCallback
        public void unbind() {
            TapComplianceInternal.notifyMessageInternal$default(TapComplianceInternal.INSTANCE, 9001, null, 2, null);
        }

        @Override // com.taptap.sdk.compliance.TimingCallback
        public void syncServerError() {
            TapLoggerKt.logInfo("syncServerError");
            UserInfo userInfo = UserModel.INSTANCE.getCurrentUser();
            if (userInfo == null || TextUtils.isEmpty(userInfo.getAccessToken())) {
                return;
            }
            TimingModel.INSTANCE.unbind();
            TapComplianceInternal.INSTANCE.notifyMessageInternal(ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR, MapsKt.mapOf(TuplesKt.to(BundleKey.DESCRIPTION, "网络异常，请稍后重试")));
        }
    };

    private TimingModel() {
    }

    public final boolean isTiming() {
        return isTiming;
    }

    public final void setTiming(boolean z) {
        isTiming = z;
    }

    public final int getTimingInterval() {
        return timingInterval;
    }

    public final void setTimingInterval(int i) {
        timingInterval = i;
    }

    public final void checkPlayable(final TapTapCallback<Boolean> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        syncTime(new TapTapCallback<CheckPlayResult>() { // from class: com.taptap.sdk.compliance.model.TimingModel.checkPlayable.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(CheckPlayResult result) {
                TapLoggerKt.logInfo("checkPlayable success: result=" + result);
                if ((result != null ? result.getRemainTime() : 0) > 0) {
                    SystemExtKt.runOnMain(new TimingModel$checkPlayable$1$onSuccess$2(callback, null));
                } else {
                    SystemExtKt.runOnMain(new TimingModel$checkPlayable$1$onSuccess$1(callback, result, null));
                }
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                callback.onFail(exception);
            }
        });
    }

    /* JADX INFO: renamed from: com.taptap.sdk.compliance.model.TimingModel$bind$1, reason: invalid class name */
    /* JADX INFO: compiled from: TimingModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.compliance.model.TimingModel$bind$1", f = "TimingModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    TimingModel.INSTANCE.unbind();
                    TimingModel timingModel = TimingModel.INSTANCE;
                    HandlerThread $this$invokeSuspend_u24lambda_u240 = new HandlerThread("TapComplianceMonitor", 10);
                    $this$invokeSuspend_u24lambda_u240.start();
                    TimingModel timingModel2 = TimingModel.INSTANCE;
                    Looper looper = $this$invokeSuspend_u24lambda_u240.getLooper();
                    Intrinsics.checkNotNullExpressionValue(looper, "looper");
                    TimingModel.handler = new TimingHandler(looper, TimingModel.INSTANCE.getTimingInterval(), TimingModel.timingCallback);
                    TimingModel.handlerThread = $this$invokeSuspend_u24lambda_u240;
                    TapLoggerKt.logInfo("bind user: current user=" + UserModel.INSTANCE.getCurrentUser() + ", handler=" + TimingModel.handler);
                    TimingHandler it = TimingModel.handler;
                    if (it != null) {
                        Message msg = it.obtainMessage();
                        Intrinsics.checkNotNullExpressionValue(msg, "it.obtainMessage()");
                        msg.what = 0;
                        msg.arg1 = 1;
                        Boxing.boxBoolean(it.sendMessage(msg));
                    }
                    TimingModel.INSTANCE.setTiming(true);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Job bind() {
        return SystemExtKt.runOnMain(new AnonymousClass1(null));
    }

    public final void unbind() {
        TapLoggerKt.logInfo("unbind user: current user=" + UserModel.INSTANCE.getCurrentUser() + ", handler=" + handler);
        HandlerThread handlerThread2 = handlerThread;
        if (handlerThread2 != null) {
            handlerThread2.quitSafely();
        }
        handlerThread = null;
        TimingHandler timingHandler = handler;
        if (timingHandler != null) {
            timingHandler.removeCallbacksAndMessages(null);
        }
        handler = null;
        isTiming = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncTime(TapTapCallback<CheckPlayResult> callback) {
        Object objM534constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            TimingModel $this$syncTime_u24lambda_u240 = this;
            $this$syncTime_u24lambda_u240.sendGameTimeToServerSync(callback);
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            TapLoggerKt.logInfo("syncTime fail: cause=" + it);
            TimingHandler msgHandler = handler;
            if (msgHandler != null) {
                if (NetExtKt.isTokenExpired(it)) {
                    Message message = msgHandler.obtainMessage();
                    Intrinsics.checkNotNullExpressionValue(message, "msgHandler.obtainMessage()");
                    message.what = 5;
                    msgHandler.sendMessage(message);
                    return;
                }
                Message message2 = msgHandler.obtainMessage();
                Intrinsics.checkNotNullExpressionValue(message2, "msgHandler.obtainMessage()");
                message2.what = 6;
                msgHandler.sendMessage(message2);
            }
        }
    }

    private final void sendGameTimeToServerSync(final TapTapCallback<CheckPlayResult> callback) {
        AntiPolicy antiAddiction;
        UserAntiConfig userAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
        if (Intrinsics.areEqual((userAntiConfig == null || (antiAddiction = userAntiConfig.getAntiAddiction()) == null) ? null : antiAddiction.getPolicyActive(), TapComplianceSettings.TIME_RANGE_MODE) && Intrinsics.areEqual(userAntiConfig.getAntiAddiction().getPolicyModel(), TapComplianceSettings.STRATEGY_LOCAL)) {
            CheckPlayResult result = PlayLogModel.INSTANCE.checkPlayableLocally().getSecond();
            UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
            if (currentUser != null) {
                currentUser.resetRemainTime(result.getRemainTime());
            }
            callback.onSuccess(result);
            return;
        }
        PlayLogModel.INSTANCE.uploadPlayLogSync((TapTapCallback) new TapTapCallback<Triple<? extends Boolean, ? extends CheckPlayResult, ? extends Boolean>>() { // from class: com.taptap.sdk.compliance.model.TimingModel.sendGameTimeToServerSync.1
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                TapTapCallback.DefaultImpls.onCancel(this);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public /* bridge */ /* synthetic */ void onSuccess(Triple<? extends Boolean, ? extends CheckPlayResult, ? extends Boolean> triple) {
                onSuccess2((Triple<Boolean, CheckPlayResult, Boolean>) triple);
            }

            /* JADX INFO: renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public void onSuccess2(Triple<Boolean, CheckPlayResult, Boolean> result2) {
                Intrinsics.checkNotNullParameter(result2, "result");
                UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
                if (currentUser2 != null) {
                    currentUser2.resetRemainTime(result2.getSecond().getRemainTime());
                }
                callback.onSuccess(result2.getSecond());
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                callback.onFail(exception);
            }
        });
    }
}
