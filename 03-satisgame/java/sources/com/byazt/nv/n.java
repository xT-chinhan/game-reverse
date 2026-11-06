package com.byazt.nv;

import android.os.SystemClock;
import com.anythink.core.common.l.f;
import com.byazt.pd.l;
import com.byazt.qf.fs;
import com.byazt.qf.w;
import com.byazt.yw.sz;
import com.byazt.yw.tj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1389, 19})
public class n implements Thread.UncaughtExceptionHandler {
    public static n n;
    public qg q;
    public Thread.UncaughtExceptionHandler qg;
    public HashSet<Thread.UncaughtExceptionHandler> s = new HashSet<>();
    public long l = -1;
    public volatile boolean w = true;

    private n() {
        s();
    }

    public static n n() {
        if (n == null) {
            n = new n();
        }
        return n;
    }

    public void n(qg qgVar) {
        this.q = qgVar;
    }

    private void s() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.qg == null) {
                this.qg = defaultUncaughtExceptionHandler;
            } else {
                this.s.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public static void qg() {
        try {
            n nVar = n;
            if (nVar != null) {
                nVar.w = false;
                qg sVar = n.q;
                n = new n();
                if (sVar == null) {
                    sVar = new s(fs.q());
                }
                n.n(sVar);
                return;
            }
            tj.n("CrashCatchDispatcher id not init.");
        } catch (Throwable th) {
            tj.n("CrashCatchDispatcher reRegister", th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        qg qgVar;
        if (SystemClock.uptimeMillis() - this.l < 20000) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            this.l = SystemClock.uptimeMillis();
            if (!this.w) {
                tj.n("This CrashCatchDispatcher is disable");
                s(thread, th);
                return;
            }
            boolean zN = n(thread, th);
            if (!zN) {
                s(thread, th);
                return;
            }
            com.byazt.qf.s sVar = com.byazt.qf.s.JAVA;
            qg(thread, th);
            if (zN && (qgVar = this.q) != null && qgVar.n(th)) {
                this.q.n(jCurrentTimeMillis, thread, th);
            }
            s(thread, th);
        } catch (Throwable th2) {
            try {
                tj.n(th2);
            } finally {
                s(thread, th);
            }
        }
    }

    private boolean n(Thread thread, Throwable th) {
        w wVarQ = fs.qg().q();
        if (wVarQ != null) {
            try {
                if (!wVarQ.n(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void qg(Thread thread, Throwable th) {
        List<Object> listQg = fs.qg().qg();
        com.byazt.qf.s sVar = com.byazt.qf.s.JAVA;
        Iterator<Object> it = listQg.iterator();
        while (it.hasNext()) {
            it.next();
            try {
                sz.n(th);
            } catch (Throwable th2) {
                tj.qg(th2);
            }
        }
    }

    private void s(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.s.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.qg.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    public static void n(final String str) {
        if (str == null) {
            return;
        }
        com.byazt.oy.n.n().n(new com.byazt.oy.s() { // from class: com.byazt.nv.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.ub.n nVar = new com.byazt.ub.n();
                    nVar.n(f.R, str);
                    nVar.n("userdefine", (Object) 1);
                    com.byazt.ub.n nVarN = l.n().n(com.byazt.qf.s.CUSTOM_JAVA, nVar);
                    if (nVarN != null) {
                        com.byazt.xh.n.n().s(nVarN.n());
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
