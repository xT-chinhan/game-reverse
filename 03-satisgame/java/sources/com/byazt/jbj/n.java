package com.byazt.jbj;

import com.byazt.fm.s;
import com.byazt.jjq.qg;
import com.byazt.xvf.q;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2174, 19})
public class n {
    public static volatile n qg;
    public Map<String, com.byazt.jjq.n> n = new HashMap();

    private n() {
    }

    public static n n() {
        if (qg != null) {
            return qg;
        }
        synchronized (n.class) {
            if (qg != null) {
                return qg;
            }
            n nVar = new n();
            qg = nVar;
            return nVar;
        }
    }

    public void n(String str, com.byazt.jjq.n nVar) {
        this.n.put(str, nVar);
    }

    public void n(String str, com.byazt.dm.n nVar, com.byazt.xvf.n nVar2) {
        com.byazt.jjq.n nVar3 = this.n.get(str);
        if (nVar3 == null || nVar == null) {
            return;
        }
        Map<String, Object> mapN = nVar.n();
        q qVarL = nVar.l();
        if (qVarL != null) {
            Map<String, Object> mapN2 = com.byazt.wu.n.n().n(String.valueOf(qVarL.hashCode()));
            mapN.putAll(mapN2);
            mapN2.clear();
        }
        if (nVar.fs() != null && nVar.fs().q() && !s.n(nVar.fs().s(), nVar.s(), nVar.n())) {
            nVar.qg(mapN, new com.byazt.bds.n(7599999, "条件不满足"));
            return;
        }
        com.byazt.fu.n nVarN = com.byazt.fu.n.n();
        com.byazt.jjq.n nVarN2 = nVarN.n(nVar3);
        HashMap map = new HashMap();
        if (n(nVar.qg())) {
            map.putAll(nVar.qg());
        }
        if (n(mapN)) {
            map.putAll(mapN);
        }
        nVarN.n(nVarN2, map);
        if (nVarN2 instanceof com.byazt.jjq.s) {
            ((com.byazt.jjq.s) nVarN2).n(nVar.qg(), nVar.n(), nVar);
        } else if (nVarN2 instanceof qg) {
            ((qg) nVarN2).n(nVar.qg(), nVar.n(), nVar);
        }
    }

    private boolean n(Map map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
