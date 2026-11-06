package com.byazt.qn;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1998, 18})
public class l implements q {
    public PluginValueSet l;
    public com.byazt.pch.n n;
    public int q;
    public com.byazt.pch.qg qg;
    public Map<String, Object> s;
    public int w = -1;
    public String x = "";

    public l(int i, PluginValueSet pluginValueSet) {
        if (pluginValueSet != null) {
            this.l = pluginValueSet;
            this.q = i;
            com.byazt.pch.n nVar = new com.byazt.pch.n(pluginValueSet.sparseArray(), com.byazt.vgx.s.qg());
            this.n = nVar;
            this.qg = nVar.ur();
            return;
        }
        com.byazt.rb.qg.qg("AdLinkInfo", "valueset is null");
    }

    @Override // com.byazt.qn.q
    public com.byazt.pch.n cd() {
        return this.n;
    }

    @Override // com.byazt.qn.q
    public float oa() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.fs();
        }
        return 0.0f;
    }

    @Override // com.byazt.qn.q
    public float sz() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.rv();
        }
        return 0.0f;
    }

    @Override // com.byazt.qn.q
    public boolean k() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.cp();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public void w(int i) {
        this.w = i;
    }

    @Override // com.byazt.qn.q
    public int cy() {
        return this.w;
    }

    @Override // com.byazt.qn.q
    public int um() {
        return this.q;
    }

    @Override // com.byazt.qn.q
    public String a() {
        if (!TextUtils.isEmpty(this.x)) {
            return this.x;
        }
        com.byazt.pch.n nVar = this.n;
        return nVar != null ? nVar.q() : "";
    }

    @Override // com.byazt.qn.q
    public void q(String str) {
        this.x = str;
    }

    @Override // com.byazt.qn.q
    public int ou() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.w();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public int wm() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.x();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public int m() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.d();
        }
        return 1;
    }

    @Override // com.byazt.qn.q
    public boolean hu() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.tj();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public String ur() {
        com.byazt.pch.n nVar = this.n;
        return nVar != null ? nVar.oa() : "";
    }

    @Override // com.byazt.qn.q
    public String bb() {
        com.byazt.pch.n nVar = this.n;
        return nVar != null ? nVar.sz() : "";
    }

    @Override // com.byazt.qn.q
    public int ln() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.k();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public String h() {
        com.byazt.pch.qg qgVar;
        com.byazt.pch.n nVar = this.n;
        String strM = nVar != null ? nVar.m() : "";
        return (!TextUtils.isEmpty(strM) || (qgVar = this.qg) == null) ? strM : qgVar.sz();
    }

    @Override // com.byazt.qn.q
    public int t() {
        com.byazt.pch.qg qgVar;
        com.byazt.pch.n nVar = this.n;
        int iHu = nVar != null ? nVar.hu() : 0;
        return (iHu != 0 || (qgVar = this.qg) == null) ? iHu : qgVar.k();
    }

    @Override // com.byazt.qn.q
    public String py() {
        com.byazt.pch.qg qgVar = this.qg;
        return qgVar != null ? qgVar.fs() : "";
    }

    @Override // com.byazt.qn.q
    public boolean lh() {
        com.byazt.pch.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.s();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public String v() {
        Map<String, Object> mapW;
        com.byazt.pch.qg qgVar = this.qg;
        if (qgVar == null || (mapW = qgVar.w()) == null) {
            return "";
        }
        Object obj = mapW.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.byazt.qn.q
    public boolean j() {
        com.byazt.pch.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.x();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public Map<String, Object> an() {
        Map<String, Object> map = this.s;
        if (map != null) {
            return map;
        }
        if (this.qg != null) {
            this.s = new ConcurrentHashMap();
            Map<String, Object> mapW = this.qg.w();
            if (mapW != null && mapW.size() > 0) {
                for (Map.Entry<String, Object> entry : mapW.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.s.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        if (this.s == null) {
            this.s = new ConcurrentHashMap();
        }
        return this.s;
    }

    @Override // com.byazt.qn.q
    public boolean hd() {
        com.byazt.pch.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.rv();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public void x(int i) {
        this.q = i;
    }

    @Override // com.byazt.qn.q
    public String df() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.bb();
        }
        return null;
    }

    @Override // com.byazt.qn.q
    public boolean oj() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.t();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public SparseArray<Object> ae() {
        PluginValueSet pluginValueSet = this.l;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        return null;
    }

    @Override // com.byazt.qn.q
    public Map<String, Object> f() {
        com.byazt.pch.n nVar = this.n;
        if (nVar != null) {
            return nVar.ln();
        }
        return null;
    }
}
