package com.byazt.kp;

import com.byazt.kr.x;
import com.byazt.lf.hw;
import com.byazt.re.hn;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1424, 37})
public class pr {
    public static volatile pr hw;
    public Map<String, com.byazt.lf.pr> pr = new HashMap();

    private pr() {
    }

    public static pr pr() {
        if (hw != null) {
            return hw;
        }
        synchronized (pr.class) {
            if (hw != null) {
                return hw;
            }
            pr prVar = new pr();
            hw = prVar;
            return prVar;
        }
    }

    public void pr(String str, com.byazt.lf.pr prVar) {
        this.pr.put(str, prVar);
    }

    public void pr(String str, com.byazt.hws.pr prVar, com.byazt.kr.pr prVar2) {
        com.byazt.lf.pr prVar3 = this.pr.get(str);
        if (prVar3 == null || prVar == null) {
            return;
        }
        Map<String, Object> mapPr = prVar.pr();
        x xVarC = prVar.c();
        if (xVarC != null) {
            Map<String, Object> mapPr2 = com.byazt.lxw.pr.pr().pr(String.valueOf(xVarC.hashCode()));
            mapPr.putAll(mapPr2);
            mapPr2.clear();
        }
        if (prVar.zo() != null && prVar.zo().x() && !hn.pr(prVar.zo().hn(), prVar.hn(), prVar.pr())) {
            prVar.hw(mapPr, new com.byazt.rs.pr(7599999, "条件不满足"));
            return;
        }
        com.byazt.bxj.pr prVarPr = com.byazt.bxj.pr.pr();
        com.byazt.lf.pr prVarPr2 = prVarPr.pr(prVar3);
        HashMap map = new HashMap();
        if (pr(prVar.hw())) {
            map.putAll(prVar.hw());
        }
        if (pr(mapPr)) {
            map.putAll(mapPr);
        }
        prVarPr.pr(prVarPr2, map);
        if (prVarPr2 instanceof com.byazt.lf.hn) {
            ((com.byazt.lf.hn) prVarPr2).pr(prVar.hw(), prVar.pr(), prVar);
        } else if (prVarPr2 instanceof hw) {
            ((hw) prVarPr2).pr(prVar.hw(), prVar.pr(), prVar);
        }
    }

    private boolean pr(Map map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
