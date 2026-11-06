package com.byazt.gxb;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.si.ae;
import com.byazt.si.cd;
import com.byazt.si.lh;
import com.byazt.si.ln;
import com.byazt.si.um;
import com.byazt.si.v;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 790, 13})
public class w {
    public ExecutorService fs;
    public final um qg;
    public ln rv;
    public com.byazt.si.l w;
    public cd x;
    public Map<String, List<s>> n = new ConcurrentHashMap();
    public Map<String, lh> s = new HashMap();
    public Map<String, v> q = new HashMap();
    public Map<String, com.byazt.si.q> l = new HashMap();

    public w(um umVar, boolean z) {
        this.qg = (um) fs.n(umVar);
        if (z) {
            com.byazt.dl.n.n(umVar.rv());
        }
    }

    public Collection<lh> n() {
        return this.s.values();
    }

    public Collection<v> qg() {
        return this.q.values();
    }

    public Collection<com.byazt.si.q> s() {
        return this.l.values();
    }

    public lh n(com.byazt.si.qg qgVar) {
        if (qgVar == null) {
            qgVar = com.byazt.dl.n.rv();
        }
        String string = qgVar.l().toString();
        lh lhVar = this.s.get(string);
        if (lhVar != null) {
            return lhVar;
        }
        lh lhVarQ = q(qgVar);
        this.s.put(string, lhVarQ);
        return lhVarQ;
    }

    private lh q(com.byazt.si.qg qgVar) {
        lh lhVarL = this.qg.l();
        if (lhVarL != null) {
            return com.byazt.qok.n.n(lhVarL);
        }
        return com.byazt.qok.n.n(qgVar.qg());
    }

    public v qg(com.byazt.si.qg qgVar) {
        if (qgVar == null) {
            qgVar = com.byazt.dl.n.rv();
        }
        String string = qgVar.l().toString();
        v vVar = this.q.get(string);
        if (vVar != null) {
            return vVar;
        }
        v vVarL = l(qgVar);
        this.q.put(string, vVarL);
        return vVarL;
    }

    private v l(com.byazt.si.qg qgVar) {
        v vVarW = this.qg.w();
        return vVarW != null ? vVarW : com.byazt.qok.l.n(qgVar.fs());
    }

    public com.byazt.si.q s(com.byazt.si.qg qgVar) {
        if (qgVar == null) {
            qgVar = com.byazt.dl.n.rv();
        }
        String string = qgVar.l().toString();
        com.byazt.si.q qVar = this.l.get(string);
        if (qVar != null) {
            return qVar;
        }
        com.byazt.si.q qVarW = w(qgVar);
        this.l.put(string, qVarW);
        return qVarW;
    }

    public com.byazt.si.q n(String str) {
        return s(com.byazt.dl.n.n(new File(str)));
    }

    private com.byazt.si.q w(com.byazt.si.qg qgVar) {
        com.byazt.si.q qVarX = this.qg.x();
        return qVarX != null ? qVarX : new com.byazt.lkc.qg(qgVar.l(), qgVar.n(), w());
    }

    public com.byazt.si.l q() {
        if (this.w == null) {
            this.w = rv();
        }
        return this.w;
    }

    private com.byazt.si.l rv() {
        com.byazt.si.l lVarQ = this.qg.q();
        return lVarQ == null ? com.byazt.tb.qg.n() : lVarQ;
    }

    public cd l() {
        if (this.x == null) {
            this.x = tj();
        }
        return this.x;
    }

    private cd tj() {
        cd cdVarN = this.qg.n();
        return cdVarN != null ? cdVarN : com.byazt.zvd.qg.n();
    }

    public ExecutorService w() {
        ExecutorService executorServiceN;
        ae aeVarS = this.qg.s();
        if (aeVarS != null && (executorServiceN = aeVarS.n()) != null) {
            return executorServiceN;
        }
        if (this.fs == null) {
            this.fs = cp();
        }
        return this.fs;
    }

    private ExecutorService cp() {
        ExecutorService executorServiceQg = this.qg.qg();
        return executorServiceQg != null ? executorServiceQg : com.byazt.zvd.s.n();
    }

    public Map<String, List<s>> x() {
        return this.n;
    }

    public com.byazt.gms.n n(s sVar) {
        ImageView.ScaleType scaleTypeL = sVar.l();
        if (scaleTypeL == null) {
            scaleTypeL = com.byazt.gms.n.n;
        }
        ImageView.ScaleType scaleType = scaleTypeL;
        Bitmap.Config configD = sVar.d();
        if (configD == null) {
            configD = com.byazt.gms.n.qg;
        }
        return new com.byazt.gms.n(sVar.s(), sVar.q(), scaleType, configD, sVar.rv(), sVar.tj());
    }

    public ln fs() {
        if (this.rv == null) {
            this.rv = d();
        }
        return this.rv;
    }

    private ln d() {
        ln lnVarFs = this.qg.fs();
        return lnVarFs == null ? new x() : lnVarFs;
    }
}
