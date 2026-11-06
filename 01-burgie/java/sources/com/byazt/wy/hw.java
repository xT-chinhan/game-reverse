package com.byazt.wy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.vkw.qi;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1595, 13})
public class hw extends Handler implements hn {
    public Looper hw;
    public WeakReference<qi.pr> pr;

    public hw(Looper looper, qi.pr prVar) {
        super(looper);
        this.hw = looper;
        if (prVar != null) {
            this.pr = new WeakReference<>(prVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        qi.pr prVar;
        WeakReference<qi.pr> weakReference = this.pr;
        if (weakReference != null && (prVar = weakReference.get()) != null && message != null) {
            prVar.pr(message);
        }
    }

    @Override // com.byazt.wy.hn
    public void pr() {
        removeCallbacksAndMessages(null);
        WeakReference<qi.pr> weakReference = this.pr;
        if (weakReference != null) {
            weakReference.clear();
            this.pr = null;
        }
    }

    public void pr(qi.pr prVar) {
        this.pr = new WeakReference<>(prVar);
    }

    public void hw() {
        Looper looper = this.hw;
        if (looper != null) {
            looper.quit();
            this.hw = null;
        }
    }
}
