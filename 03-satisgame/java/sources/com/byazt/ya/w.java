package com.byazt.ya;

import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 13})
public class w extends com.byazt.gf.q {
    public com.byazt.zq.s n;

    public w(com.byazt.zq.s sVar) {
        this.n = sVar;
    }

    public PluginValueSet n() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        com.byazt.zq.s sVar = this.n;
        nVarN.n(8481, sVar != null ? sVar.n() : 0.0d);
        com.byazt.zq.s sVar2 = this.n;
        nVarN.n(8482, sVar2 != null ? sVar2.qg() : 0.0d);
        return nVarN.qg();
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) n().sparseArray();
        }
        return null;
    }
}
