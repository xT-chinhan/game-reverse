package com.taptap.sdk.compliance.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.taptap.sdk.compliance.bean.AntiPolicy;
import com.taptap.sdk.compliance.bean.CheckPlayResult;
import com.taptap.sdk.compliance.bean.UserAntiConfig;
import com.taptap.sdk.compliance.bean.UserInfo;
import com.taptap.sdk.compliance.extensions.SystemExtKt;
import com.taptap.sdk.compliance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.kit.internal.extensions.NetExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\r\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\u0018\u0010\u001b\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/taptap/sdk/compliance/model/TimingModel;", "", "()V", "handler", "Lcom/taptap/sdk/compliance/model/TimingHandler;", "handlerThread", "Landroid/os/HandlerThread;", "isTiming", "", "()Z", "setTiming", "(Z)V", "timingCallback", "com/taptap/sdk/compliance/model/TimingModel$timingCallback$1", "Lcom/taptap/sdk/compliance/model/TimingModel$timingCallback$1;", "timingInterval", "", "getTimingInterval", "()I", "setTimingInterval", "(I)V", "bind", "Lkotlinx/coroutines/Job;", "checkPlayable", "", "callback", "Lcom/taptap/sdk/kit/internal/callback/TapTapCallback;", "sendGameTimeToServerSync", "Lcom/taptap/sdk/compliance/bean/CheckPlayResult;", "syncTime", "unbind", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimingModel {
    private static TimingHandler handler;
    private static HandlerThread handlerThread;
    private static boolean isTiming;
    public static final TimingModel INSTANCE = new TimingModel();
    private static int timingInterval = 120;
    private static final TimingModel$timingCallback$1 timingCallback = new TimingModel$timingCallback$1();

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
                TapComplianceLoggerKt.logInfo("checkPlayable success: result=" + result);
                if ((result != null ? result.getRemainTime() : 0) <= 0) {
                    SystemExtKt.runOnMain(new TimingModel$checkPlayable$1$onSuccess$1(callback, result, null));
                } else {
                    SystemExtKt.runOnMain(new TimingModel$checkPlayable$1$onSuccess$2(callback, null));
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
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TimingModel.INSTANCE.unbind();
            TimingModel timingModel = TimingModel.INSTANCE;
            HandlerThread handlerThread = new HandlerThread("TapComplianceMonitor", 10);
            handlerThread.start();
            TimingModel timingModel2 = TimingModel.INSTANCE;
            Looper looper = handlerThread.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "looper");
            TimingModel.handler = new TimingHandler(looper, TimingModel.INSTANCE.getTimingInterval(), TimingModel.timingCallback);
            TimingModel.handlerThread = handlerThread;
            TapComplianceLoggerKt.logInfo("bind user: current user=" + UserModel.INSTANCE.getCurrentUser() + ", handler=" + TimingModel.handler);
            TimingHandler timingHandler = TimingModel.handler;
            if (timingHandler != null) {
                Message messageObtainMessage = timingHandler.obtainMessage();
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "it.obtainMessage()");
                messageObtainMessage.what = 0;
                messageObtainMessage.arg1 = 1;
                Boxing.boxBoolean(timingHandler.sendMessage(messageObtainMessage));
            }
            TimingModel.INSTANCE.setTiming(true);
            return Unit.INSTANCE;
        }
    }

    public final Job bind() {
        return SystemExtKt.runOnMain(new AnonymousClass1(null));
    }

    public final void unbind() {
        TapComplianceLoggerKt.logInfo("unbind user: current user=" + UserModel.INSTANCE.getCurrentUser() + ", handler=" + handler);
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
        Object objM174constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            TimingModel timingModel = this;
            sendGameTimeToServerSync(callback);
            objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            TapComplianceLoggerKt.logInfo("syncTime fail: cause=" + thM177exceptionOrNullimpl);
            TimingHandler timingHandler = handler;
            if (timingHandler != null) {
                if (NetExtKt.isTokenExpired(thM177exceptionOrNullimpl)) {
                    Message messageObtainMessage = timingHandler.obtainMessage();
                    Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "msgHandler.obtainMessage()");
                    messageObtainMessage.what = 5;
                    timingHandler.sendMessage(messageObtainMessage);
                    return;
                }
                Message messageObtainMessage2 = timingHandler.obtainMessage();
                Intrinsics.checkNotNullExpressionValue(messageObtainMessage2, "msgHandler.obtainMessage()");
                messageObtainMessage2.what = 6;
                timingHandler.sendMessage(messageObtainMessage2);
            }
        }
    }

    private final void sendGameTimeToServerSync(final TapTapCallback<CheckPlayResult> callback) {
        AntiPolicy antiAddiction;
        UserAntiConfig currentUserAntiConfig = UserModel.INSTANCE.getCurrentUserAntiConfig();
        if (Intrinsics.areEqual((currentUserAntiConfig == null || (antiAddiction = currentUserAntiConfig.getAntiAddiction()) == null) ? null : antiAddiction.getPolicyActive(), TapComplianceSettings.TIME_RANGE_MODE) && Intrinsics.areEqual(currentUserAntiConfig.getAntiAddiction().getPolicyModel(), "local")) {
            CheckPlayResult second = PlayLogModel.INSTANCE.checkPlayableLocally().getSecond();
            UserInfo currentUser = UserModel.INSTANCE.getCurrentUser();
            if (currentUser != null) {
                currentUser.resetRemainTime(second.getRemainTime());
            }
            callback.onSuccess(second);
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
            public void onSuccess2(Triple<Boolean, CheckPlayResult, Boolean> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                UserInfo currentUser2 = UserModel.INSTANCE.getCurrentUser();
                if (currentUser2 != null) {
                    currentUser2.resetRemainTime(result.getSecond().getRemainTime());
                }
                callback.onSuccess(result.getSecond());
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                callback.onFail(exception);
            }
        });
    }
}
