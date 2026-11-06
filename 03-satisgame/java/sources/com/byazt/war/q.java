package com.byazt.war;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 5})
public class q extends n {
    @Override // com.byazt.war.rv
    public String n() {
        return "cache_policy";
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        com.byazt.si.qg qgVarOu = sVar.ou();
        if (sVar.hd()) {
            if (qgVarOu.s()) {
                sVar.n(new tj());
                return;
            } else if (qgVarOu.x()) {
                sVar.n(new d());
                return;
            } else {
                sVar.n(new oa());
                return;
            }
        }
        if (qgVarOu != null) {
            if (qgVarOu.s()) {
                sVar.n(new tj());
                return;
            } else if (qgVarOu.q()) {
                sVar.n(new w());
                return;
            }
        }
        sVar.n(new cp());
    }
}
