package com.byazt.aa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 668, 61})
public class aj extends Handler {
    public final WeakReference<pr> pr;

    public interface pr {
        void pr(Message message);
    }

    public aj(Looper looper, pr prVar) {
        super(looper);
        this.pr = new WeakReference<>(prVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        pr prVar = this.pr.get();
        if (prVar != null && message != null) {
            prVar.pr(message);
        }
    }
}
