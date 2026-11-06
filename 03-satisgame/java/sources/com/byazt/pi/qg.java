package com.byazt.pi;

import android.os.Looper;
import android.os.Message;
import com.byazt.tk.t;
import com.byazt.vf.wo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 743, 26})
public class qg implements wo.n {
    public n qg;
    public AtomicBoolean s = new AtomicBoolean(true);
    public final AtomicBoolean q = new AtomicBoolean(false);
    public final t n = new t(Looper.getMainLooper(), this);
    public int l = 5;
    public int w = 1;

    public interface n {
        void n();

        void n(int i);
    }

    private void l() {
        this.n.removeMessages(1);
        this.w = 1;
    }

    public void n() {
        l();
    }

    public void n(boolean z) {
        this.s.set(z);
        if (!this.s.get()) {
            w();
        } else {
            if (this.q.get()) {
                return;
            }
            x();
        }
    }

    public void qg() {
        this.q.set(true);
        w();
    }

    public void s() {
        this.q.set(false);
        if (this.s.get()) {
            x();
        }
    }

    private void w() {
        try {
            this.n.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void x() {
        try {
            this.n.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    public void q() {
        l();
        this.n.sendEmptyMessage(1);
    }

    public void n(n nVar) {
        this.qg = nVar;
    }

    public void n(int i) {
        this.l = i;
        l();
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what == 1) {
            fs();
        }
    }

    private void fs() {
        try {
            int i = this.w;
            if (i >= this.l + 1) {
                n nVar = this.qg;
                if (nVar != null) {
                    nVar.n();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.w = i2;
            n nVar2 = this.qg;
            if (nVar2 != null) {
                nVar2.n(i2);
            }
            this.n.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }
}
