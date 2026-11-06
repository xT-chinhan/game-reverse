package com.taptap.sdk.compliance.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import com.taptap.sdk.compliance.TimingCallback;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/compliance/model/TimingHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "timingInterval", "", "callback", "Lcom/taptap/sdk/compliance/TimingCallback;", "(Landroid/os/Looper;ILcom/taptap/sdk/compliance/TimingCallback;)V", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TimingHandler extends Handler {
    private final TimingCallback callback;
    private final int timingInterval;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimingHandler(Looper looper, int timingInterval, TimingCallback callback) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.timingInterval = timingInterval;
        this.callback = callback;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Object objM534constructorimpl;
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Result.Companion companion = Result.INSTANCE;
            final TimingHandler $this$handleMessage_u24lambda_u240 = this;
            switch (msg.what) {
                case 0:
                    $this$handleMessage_u24lambda_u240.callback.countTime(new TapTapCallback<Boolean>() { // from class: com.taptap.sdk.compliance.model.TimingHandler$handleMessage$1$1
                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onCancel() {
                            TapTapCallback.DefaultImpls.onCancel(this);
                        }

                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public /* bridge */ /* synthetic */ void onSuccess(Boolean bool) {
                            onSuccess(bool.booleanValue());
                        }

                        public void onSuccess(boolean result) {
                            Message message = Message.obtain();
                            message.arg1 = 1;
                            message.what = 0;
                            message.setTarget(this.this$0);
                            TapLoggerKt.logInfo("send countTime message: result=" + result + ", message=" + message);
                            TimingHandler timingHandler = $this$handleMessage_u24lambda_u240;
                            timingHandler.sendMessageDelayed(message, ((long) timingHandler.timingInterval) * 1000);
                        }

                        @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
                        public void onFail(TapTapException exception) {
                            Intrinsics.checkNotNullParameter(exception, "exception");
                        }
                    });
                    break;
                case 1:
                    if (!$this$handleMessage_u24lambda_u240.callback.countDown()) {
                        $this$handleMessage_u24lambda_u240.sendMessageDelayed(Message.obtain(msg), 1000L);
                    }
                    break;
                case 3:
                    $this$handleMessage_u24lambda_u240.callback.childTimeRunOut();
                    break;
                case 5:
                    $this$handleMessage_u24lambda_u240.callback.unbind();
                    break;
                case 6:
                    $this$handleMessage_u24lambda_u240.callback.syncServerError();
                    break;
            }
            objM534constructorimpl = Result.m534constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM534constructorimpl = Result.m534constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m537exceptionOrNullimpl(objM534constructorimpl);
        if (it != null) {
            it.printStackTrace();
        }
    }
}
