package com.byazt.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 101})
public class fs extends Handler {
    public final WeakReference<n> n;

    public interface n {
        void n(Message message);
    }

    public fs(Looper looper, n nVar) {
        super(looper);
        this.n = new WeakReference<>(nVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n nVar = this.n.get();
        if (nVar == null || message == null) {
            return;
        }
        nVar.n(message);
    }
}
