package com.byazt.ya;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 101})
public class fs extends com.byazt.gf.q {
    public com.byazt.xmw.s n;

    public fs(com.byazt.xmw.s sVar) {
        this.n = sVar;
    }

    public PluginValueSet n() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        com.byazt.xmw.s sVar = this.n;
        nVarN.n(8468, sVar != null ? sVar.n() : new HashMap<>());
        com.byazt.xmw.s sVar2 = this.n;
        nVarN.n(8469, sVar2 != null ? sVar2.l() : 0);
        com.byazt.xmw.s sVar3 = this.n;
        nVarN.n(8470, sVar3 != null ? sVar3.s() : "");
        com.byazt.xmw.s sVar4 = this.n;
        nVarN.n(8471, sVar4 != null ? sVar4.q() : "");
        com.byazt.xmw.s sVar5 = this.n;
        nVarN.n(8472, sVar5 != null ? sVar5.qg() : "");
        com.byazt.xmw.s sVar6 = this.n;
        nVarN.n(8473, sVar6 != null ? sVar6.w() : "");
        com.byazt.xmw.s sVar7 = this.n;
        nVarN.n(8474, sVar7 != null ? sVar7.x() : "");
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
