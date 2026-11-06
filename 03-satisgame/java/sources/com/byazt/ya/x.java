package com.byazt.ya;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 935, 21})
public class x extends com.byazt.gf.q {
    public com.byazt.xmw.qg n;

    public x(com.byazt.xmw.qg qgVar) {
        this.n = qgVar;
    }

    public PluginValueSet s() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(8476, q());
        nVarN.n(8477, l());
        nVarN.n(8478, w());
        nVarN.n(8027, n());
        nVarN.n(8028, qg());
        return nVarN.qg();
    }

    public List<String> q() {
        com.byazt.xmw.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.n();
        }
        return null;
    }

    public List<String> l() {
        com.byazt.xmw.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.qg();
        }
        return null;
    }

    public boolean w() {
        com.byazt.xmw.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.s();
        }
        return true;
    }

    public boolean n() {
        com.byazt.xmw.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.q();
        }
        return false;
    }

    public boolean qg() {
        com.byazt.xmw.qg qgVar = this.n;
        if (qgVar != null) {
            return qgVar.l();
        }
        return true;
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) s().sparseArray();
        }
        return null;
    }
}
