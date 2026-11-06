package com.byazt.war;

import com.byazt.si.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 110})
public class sz<T> extends n {
    public T n;
    public byte[] q;
    public com.byazt.si.x qg;
    public boolean s;

    @Override // com.byazt.war.rv
    public String n() {
        return "success";
    }

    public sz(T t, byte[] bArr, com.byazt.si.x xVar, boolean z) {
        this.n = t;
        this.qg = xVar;
        this.s = z;
        this.q = bArr;
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        String strHu = sVar.hu();
        Map<String, List<com.byazt.gxb.s>> mapX = sVar.py().x();
        List<com.byazt.gxb.s> list = mapX.get(strHu);
        if (list == null) {
            qg(sVar);
            return;
        }
        synchronized (list) {
            Iterator<com.byazt.gxb.s> it = list.iterator();
            while (it.hasNext()) {
                qg(it.next());
            }
            list.clear();
            mapX.remove(strHu);
        }
    }

    private Map<String, String> qg() {
        com.byazt.si.x xVar = this.qg;
        if (xVar != null) {
            return xVar.l();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void qg(com.byazt.gxb.s sVar) {
        m mVarCp = sVar.cp();
        int iOa = sVar.oa();
        if (mVarCp != null) {
            T t = this.n;
            if (iOa == 3) {
                com.byazt.si.qg qgVarOu = sVar.ou();
                if (this.q == null && qgVarOu.x()) {
                    this.q = sVar.py().qg(qgVarOu).n(sVar.w());
                }
                T tN = (T) this.q;
                if (tN == null) {
                    tN = this.n;
                }
                if (!(tN instanceof byte[])) {
                    if (sVar.hd()) {
                        tN = com.byazt.esj.n.n(sVar);
                    } else {
                        tN = sVar.py().s(sVar.ou()).n(sVar.w());
                    }
                    if (!(tN instanceof byte[])) {
                        mVarCp.n(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                    }
                }
                t = (T) tN;
            } else if (iOa == 2 && (t instanceof byte[])) {
                try {
                    t = (T) sVar.py().n(sVar).n((byte[]) t);
                } catch (Throwable th) {
                    mVarCp.n(2000, "decode failed", th);
                    return;
                }
            }
            mVarCp.n(new com.byazt.gxb.q().n(sVar, t, qg(), this.s));
        }
    }
}
