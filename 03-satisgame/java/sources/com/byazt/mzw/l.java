package com.byazt.mzw;

import android.text.TextUtils;
import com.byazt.tk.k;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1346, 18})
public class l extends s {
    public static File n;
    public static volatile l qg;
    public AtomicBoolean s = new AtomicBoolean(true);
    public AtomicBoolean q = new AtomicBoolean(false);
    public boolean l = false;
    public AtomicBoolean w = new AtomicBoolean(false);
    public AtomicInteger x = new AtomicInteger(0);
    public AtomicLong fs = new AtomicLong();

    public static l qg() {
        if (qg == null) {
            synchronized (l.class) {
                if (qg == null) {
                    qg = new l();
                }
            }
        }
        return qg;
    }

    private l() {
        fs();
    }

    private void fs() {
        com.byazt.cq.l.qg(new com.byazt.qit.x("init") { // from class: com.byazt.mzw.l.1
            @Override // java.lang.Runnable
            public void run() {
                fs.n();
                l.this.s.set(false);
                l.this.s();
                l.this.w();
                com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
                if (com.byazt.gkj.n.n().s() == null || !lVar.n()) {
                    return;
                }
                com.byazt.gkj.n.n().s().qg().post(new Runnable() { // from class: com.byazt.mzw.l.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.byazt.gkj.n.n().s() != null) {
                            com.byazt.gkj.n.n();
                        }
                    }
                });
            }
        }, 10);
    }

    public void s() {
        com.byazt.px.n nVarQg = fs.qg();
        if (nVarQg == null || !nVarQg.w()) {
            return;
        }
        boolean zN = n(nVarQg);
        if (!zN) {
            fs.q();
        }
        this.l = zN;
    }

    public boolean n(com.byazt.px.n nVar) {
        if (nVar == null) {
            return false;
        }
        return n(nVar.n()) || n(nVar.l()) || n(nVar.getResources());
    }

    public boolean q() {
        return this.l;
    }

    public com.byazt.px.n l() {
        return fs.qg();
    }

    @Override // com.byazt.mzw.s
    public File n() {
        return x();
    }

    public void w() {
        n(false);
    }

    public void n(boolean z) {
        List<com.byazt.px.n.C0308n> listN;
        boolean z2;
        if (this.s.get()) {
            return;
        }
        try {
            if (this.q.get()) {
                if (z) {
                    this.x.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.q.set(true);
            com.byazt.px.n nVarS = com.byazt.gkj.n.n().s().s();
            com.byazt.px.n nVarQg = fs.qg();
            if (nVarS != null && nVarS.w()) {
                if (!fs.qg(nVarS)) {
                    this.q.set(false);
                    this.fs.set(System.currentTimeMillis());
                    return;
                }
                if (com.byazt.gkj.n.n().s() != null) {
                    com.byazt.gkj.n.n().s().qg().post(new Runnable() { // from class: com.byazt.mzw.l.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.byazt.gjp.l.n().qg();
                        }
                    });
                }
                fs.n(nVarS);
                boolean zN = (nVarS.l() == null || TextUtils.isEmpty(nVarS.l().n())) ? false : n(nVarS.l().n());
                if (nVarS.n().size() != 0) {
                    listN = n(nVarS, nVarQg);
                    z2 = listN != null;
                } else {
                    listN = null;
                    z2 = zN;
                }
                if (!zN) {
                    List<com.byazt.px.n.C0308n> listQg = qg(nVarS, nVarQg);
                    if (listN == null || listQg == null) {
                        listN = listQg;
                    } else {
                        listN.addAll(listQg);
                    }
                    if (listQg == null) {
                        z3 = false;
                    }
                    if (listQg == null) {
                        this.q.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && n(nVarS)) {
                    fs.n(nVarS);
                    fs.s();
                    qg(listN);
                }
                s();
                this.q.set(false);
                this.fs.set(System.currentTimeMillis());
                rv();
                return;
            }
            this.q.set(false);
            n(109);
        } catch (Throwable unused) {
        }
    }

    private void rv() {
        if (this.x.getAndSet(0) <= 0 || System.currentTimeMillis() - this.fs.get() <= 600000) {
            return;
        }
        w();
    }

    public static File x() {
        if (n == null) {
            try {
                File file = new File(new File(q.n(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                n = file;
            } catch (Throwable th) {
                k.n("TemplateManager", "getTemplateDir error", th);
            }
        }
        return n;
    }
}
