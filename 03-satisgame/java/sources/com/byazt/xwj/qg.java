package com.byazt.xwj;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1367, 26})
public class qg implements com.byazt.wj.n {
    public com.byazt.zx.qg n;
    public com.byazt.wj.n qg;

    public qg(com.byazt.wj.n nVar, com.byazt.zx.qg qgVar) {
        this.qg = nVar;
        this.n = qgVar;
    }

    public qg(com.byazt.zx.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.wj.n
    public boolean n(Map<String, Object> map) {
        com.byazt.zx.qg qgVar = this.n;
        if (qgVar == null) {
            return this.qg.n(map);
        }
        if (qgVar.n()) {
            return true;
        }
        com.byazt.wj.n nVar = this.qg;
        if (nVar == null) {
            return false;
        }
        return nVar.n(map);
    }
}
