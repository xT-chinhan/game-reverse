package com.byazt.gi;

import android.text.TextUtils;
import com.byazt.gwu.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1745, 19})
public class n {
    public static volatile n qg;
    public long l;
    public long q;
    public String w;
    public final String n = com.byazt.ug.n.n;
    public final s s = com.byazt.ri.n.l();

    private n() {
    }

    public static n n() {
        if (qg == null) {
            synchronized (n.class) {
                if (qg == null) {
                    qg = new n();
                }
            }
        }
        return qg;
    }

    public void n(long j) {
        try {
            if (this.s.getLong("first_install_time", -1L) == -1) {
                long j2 = com.byazt.ri.n.n().getLong("first_install_time", -1L);
                if (j2 != -1) {
                    j = j2;
                }
                this.s.n("first_install_time", j);
            }
        } catch (Throwable unused) {
        }
    }

    public long qg() {
        try {
            long jCurrentTimeMillis = this.s.getLong("first_install_time", -1L);
            if (jCurrentTimeMillis == -1) {
                jCurrentTimeMillis = com.byazt.ri.n.n().getLong("first_install_time", -1L);
                if (jCurrentTimeMillis == -1) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                this.s.n("first_install_time", jCurrentTimeMillis);
            }
            return jCurrentTimeMillis;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public synchronized void s() {
        this.s.n("discard_num", this.s.getInt("discard_num", 0) + 1);
    }

    public synchronized int q() {
        return this.s.getInt("discard_num", 0);
    }

    public synchronized void l() {
        this.s.n("discard_num", 0);
    }

    public void w() {
        this.q = System.currentTimeMillis();
    }

    public void x() {
        this.l = System.currentTimeMillis();
    }

    public long fs() {
        long j = this.l - this.q;
        com.byazt.rb.qg.qg(this.n, "InitMethodDuration = ".concat(String.valueOf(j)));
        return j;
    }

    public long rv() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.q;
        com.byazt.rb.qg.qg(this.n, "SplashRequestDuration = ".concat(String.valueOf(jCurrentTimeMillis)));
        return jCurrentTimeMillis;
    }

    public long tj() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.q;
        com.byazt.rb.qg.qg(this.n, "SplashFillDuration = ".concat(String.valueOf(jCurrentTimeMillis)));
        return jCurrentTimeMillis;
    }

    public void n(String str) {
        this.w = str;
    }

    public boolean cp() {
        return TextUtils.isEmpty(this.w);
    }

    public boolean d() {
        String strQg = com.byazt.cw.n.n(com.byazt.qt.n.d().oa()).qg();
        boolean zEquals = TextUtils.equals(this.w, strQg);
        com.byazt.rb.qg.qg(this.n, "canUploadInitDuration = " + zEquals + " 当sessionId = " + strQg + " 存储的sessionId = " + this.w);
        return !zEquals;
    }
}
