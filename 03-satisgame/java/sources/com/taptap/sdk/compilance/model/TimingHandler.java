package com.taptap.sdk.compilance.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.taptap.sdk.compilance.TimingCallback;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimingModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/compilance/model/TimingHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "timingInterval", "", "callback", "Lcom/taptap/sdk/compilance/TimingCallback;", "(Landroid/os/Looper;ILcom/taptap/sdk/compilance/TimingCallback;)V", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "tap-compliance_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
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
    public void handleMessage(final Message msg) {
        Object objM184constructorimpl;
        Intrinsics.checkNotNullParameter(msg, "msg");
        try {
            Result.Companion companion = Result.INSTANCE;
            TimingHandler timingHandler = this;
            int i = msg.what;
            if (i == 0) {
                this.callback.countTime(new TapTapCallback<Boolean>() { // from class: com.taptap.sdk.compilance.model.TimingHandler$handleMessage$1$1
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
                        Message messageObtain = Message.obtain(msg);
                        messageObtain.arg1 = 1;
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
            objM184constructorimpl = Result.m184constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM184constructorimpl = Result.m184constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM187exceptionOrNullimpl = Result.m187exceptionOrNullimpl(objM184constructorimpl);
        if (thM187exceptionOrNullimpl != null) {
            thM187exceptionOrNullimpl.printStackTrace();
        }
    }
}
