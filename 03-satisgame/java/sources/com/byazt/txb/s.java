package com.byazt.txb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.vf.wo;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 775, 8})
public class s extends Handler implements q {
    public WeakReference<wo.n> n;
    public Looper qg;

    public s(Looper looper, wo.n nVar) {
        super(looper);
        this.qg = looper;
        if (nVar != null) {
            this.n = new WeakReference<>(nVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        wo.n nVar;
        WeakReference<wo.n> weakReference = this.n;
        if (weakReference == null || (nVar = weakReference.get()) == null || message == null) {
            return;
        }
        nVar.n(message);
    }

    @Override // com.byazt.txb.q
    public void qg() {
        removeCallbacksAndMessages(null);
        WeakReference<wo.n> weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
            this.n = null;
        }
    }

    public void n(wo.n nVar) {
        this.n = new WeakReference<>(nVar);
    }

    public void n() {
        Looper looper = this.qg;
        if (looper != null) {
            looper.quit();
            this.qg = null;
        }
    }
}
