package com.taptap.sdk.compliance.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taptap.sdk.compliance.TimingCallback;
import com.taptap.sdk.compliance.internal.TapComplianceLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/compliance/model/TimingHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "timingInterval", "", "callback", "Lcom/taptap/sdk/compliance/TimingCallback;", "(Landroid/os/Looper;ILcom/taptap/sdk/compliance/TimingCallback;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimingHandler extends Handler {
    private final TimingCallback callback;
    private final int timingInterval;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimingHandler(Looper looper, int i, TimingCallback callback) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.timingInterval = i;
        this.callback = callback;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Object objM174constructorimpl;
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Result.Companion companion = Result.INSTANCE;
            TimingHandler timingHandler = this;
            int i = msg.what;
            if (i == 0) {
                this.callback.countTime(new TapTapCallback<Boolean>() { // from class: com.taptap.sdk.compliance.model.TimingHandler$handleMessage$1$1
                    @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                    public void onFail(TapTapException exception) {
                        Intrinsics.checkNotNullParameter(exception, "exception");
                    }

                    @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                    public void onCancel() {
                        TapTapCallback.DefaultImpls.onCancel(this);
                    }

                    @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                    public /* bridge */ /* synthetic */ void onSuccess(Boolean bool) {
                        onSuccess(bool.booleanValue());
                    }

                    public void onSuccess(boolean result) {
                        Message messageObtain = Message.obtain();
                        messageObtain.arg1 = 1;
                        messageObtain.what = 0;
                        messageObtain.setTarget(this.this$0);
                        TapComplianceLoggerKt.logInfo("send countTime message: result=" + result + ", message=" + messageObtain);
                        TimingHandler timingHandler2 = this;
                        timingHandler2.sendMessageDelayed(messageObtain, ((long) timingHandler2.timingInterval) * 1000);
                    }
                });
            } else if (i != 1) {
                if (i == 3) {
                    this.callback.childTimeRunOut();
                } else if (i == 5) {
                    this.callback.unbind();
                } else if (i == 6) {
                    this.callback.syncServerError();
                }
            } else if (!this.callback.countDown()) {
                sendMessageDelayed(Message.obtain(msg), 1000L);
            }
            objM174constructorimpl = Result.m174constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM174constructorimpl = Result.m174constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM177exceptionOrNullimpl = Result.m177exceptionOrNullimpl(objM174constructorimpl);
        if (thM177exceptionOrNullimpl != null) {
            thM177exceptionOrNullimpl.printStackTrace();
        }
    }
}
