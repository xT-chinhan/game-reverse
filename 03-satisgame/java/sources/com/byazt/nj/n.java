package com.byazt.nj;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.tk.rv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1070, 19})
public final class n {
    public static final Map<String, qg> n = new ConcurrentHashMap();
    public int fs;
    public boolean l;
    public final int qg;
    public boolean w;
    public boolean x;
    public final x s = new x();
    public s q = s.n();

    public n(int i) {
        this.qg = i;
        this.fs = i;
    }

    public static void n(pk pkVar, qg qgVar) {
        String strL = l(pkVar);
        if (TextUtils.isEmpty(strL) || qgVar == null || !x.n(pkVar)) {
            return;
        }
        n.put(strL, qgVar);
    }

    public static qg n(pk pkVar) {
        String strL = l(pkVar);
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        return n.get(strL);
    }

    public static void qg(pk pkVar) {
        qg qgVarN = n(pkVar);
        if (qgVarN == null) {
            qgVarN = qg.n();
        }
        qgVarN.w();
        n(pkVar, qgVarN);
    }

    public static void n(final pk pkVar, final int i) {
        Handler handlerS;
        if (x.n(pkVar) && (handlerS = rv.s()) != null) {
            handlerS.post(new Runnable() { // from class: com.byazt.nj.n.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        qg qgVarQ = n.q(pkVar);
                        if (qgVarQ == null) {
                            qgVarQ = qg.n();
                        }
                        com.byazt.eji.s.n().n(pkVar, i, qgVarQ);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void n(pk pkVar, boolean z) {
        qg qgVarN = n(pkVar);
        if (qgVarN != null) {
            qgVarN.update(this.q.s(), this.q.q(), z ? 1 : 0);
        } else {
            n(pkVar, qg(z));
        }
    }

    public void qg(pk pkVar, int i) {
        if (this.l) {
            return;
        }
        this.l = true;
        this.q = this.s.n(pkVar, s(pkVar, i));
        l();
    }

    public void n() {
        this.l = false;
        this.q = s.n();
        qg();
        this.fs = this.qg;
    }

    public void qg() {
        this.w = false;
        this.x = false;
    }

    public void n(boolean z) {
        if (this.x) {
            return;
        }
        this.x = true;
        if (z) {
            return;
        }
        this.w = false;
    }

    public boolean n(boolean z, boolean z2, boolean z3) {
        if (!this.q.qg()) {
            return z;
        }
        if (!z) {
            return false;
        }
        if (this.q.q() == 0) {
            if (z3) {
                return true;
            }
            return !z2 && this.x;
        }
        if (this.w) {
            return !z2 && this.x;
        }
        this.w = true;
        return false;
    }

    public boolean s() {
        return this.q.qg();
    }

    public int q() {
        return this.fs;
    }

    public qg qg(boolean z) {
        if (!this.q.qg()) {
            return qg.n();
        }
        return new qg(this.q.s(), this.q.q(), z ? 1 : 0);
    }

    private q s(pk pkVar, int i) {
        long jB = pkVar != null ? pkVar.b() : -1L;
        long jElapsedRealtime = jB > -1 ? SystemClock.elapsedRealtime() - jB : -1L;
        return new q(i, pkVar != null ? nf.s(pkVar) : 0, pkVar != null ? nf.n(pkVar) : 0, (pkVar == null || !pkVar.wn()) ? 0 : 1, jElapsedRealtime);
    }

    private void l() {
        this.fs = this.qg;
        if (!this.q.qg() || this.q.s() <= 0 || this.q.s() >= 3000) {
            return;
        }
        this.fs = this.q.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static qg q(pk pkVar) {
        String strL = l(pkVar);
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        return n.remove(strL);
    }

    private static String l(pk pkVar) {
        if (pkVar != null) {
            return pkVar.cs();
        }
        return null;
    }
}
