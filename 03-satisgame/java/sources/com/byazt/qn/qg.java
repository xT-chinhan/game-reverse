package com.byazt.qn;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1998, 26})
public class qg implements q, s {
    public String l;
    public q n;
    public boolean q;
    public com.byazt.ws.qg qg;
    public s s;

    public s cp() {
        return this.s;
    }

    public qg(int i, PluginValueSet pluginValueSet, String str) {
        n(i, pluginValueSet, null);
        this.l = str;
    }

    public qg(qg qgVar) {
        if (qgVar != null) {
            n(qgVar.um(), com.byazt.qvu.n.n(qgVar.ae()).qg(), qgVar.cp());
            this.l = qgVar.d();
        }
    }

    private void n(int i, PluginValueSet pluginValueSet, s sVar) {
        this.n = new l(i, pluginValueSet);
        this.s = new n();
    }

    public String d() {
        return this.l;
    }

    @Override // com.byazt.qn.s
    public void l(int i) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.l(i);
        }
    }

    @Override // com.byazt.qn.s
    public int fs() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.fs();
        }
        return 0;
    }

    @Override // com.byazt.qn.s
    public void n(JSONObject jSONObject) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.n(jSONObject);
        }
    }

    @Override // com.byazt.qn.s
    public JSONObject rv() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.rv();
        }
        return null;
    }

    @Override // com.byazt.qn.s
    public void s(String str) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.s(str);
        }
    }

    @Override // com.byazt.qn.s
    public String tj() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.tj();
        }
        return null;
    }

    @Override // com.byazt.qn.q
    public float oa() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.oa();
        }
        return 0.0f;
    }

    @Override // com.byazt.qn.q
    public float sz() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.sz();
        }
        return 0.0f;
    }

    @Override // com.byazt.qn.q
    public boolean k() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.k();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public void w(int i) {
        q qVar = this.n;
        if (qVar != null) {
            qVar.w(i);
        }
    }

    @Override // com.byazt.qn.q
    public int cy() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.cy();
        }
        return -1;
    }

    @Override // com.byazt.qn.q
    public boolean hd() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.hd();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public void x(int i) {
        q qVar = this.n;
        if (qVar != null) {
            qVar.x(i);
        }
    }

    @Override // com.byazt.qn.q
    public com.byazt.pch.n cd() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.cd();
        }
        return null;
    }

    @Override // com.byazt.qn.q
    public int um() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.um();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public String a() {
        q qVar = this.n;
        return qVar != null ? qVar.a() : "";
    }

    @Override // com.byazt.qn.q
    public void q(String str) {
        q qVar = this.n;
        if (qVar != null) {
            qVar.q(str);
        }
    }

    @Override // com.byazt.qn.q
    public String py() {
        q qVar = this.n;
        return qVar != null ? qVar.py() : "";
    }

    @Override // com.byazt.qn.q
    public int ou() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.ou();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public int wm() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.wm();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public int m() {
        q qVar;
        if (5 != um() && 9 != um()) {
            return 1;
        }
        com.byazt.ws.qg qgVar = this.qg;
        int iA = qgVar != null ? qgVar.a() : 0;
        if (iA == 0 && (qVar = this.n) != null) {
            iA = qVar.m();
        }
        if (iA <= 0) {
            return 1;
        }
        if (iA >= 3) {
            return 3;
        }
        return iA;
    }

    @Override // com.byazt.qn.q
    public boolean hu() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.hu();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public String h() {
        q qVar = this.n;
        return qVar != null ? qVar.h() : "";
    }

    @Override // com.byazt.qn.q
    public int t() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.t();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public String ur() {
        q qVar = this.n;
        return qVar != null ? qVar.ur() : "";
    }

    @Override // com.byazt.qn.q
    public String bb() {
        q qVar = this.n;
        return qVar != null ? qVar.bb() : "";
    }

    @Override // com.byazt.qn.q
    public int ln() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.ln();
        }
        return 0;
    }

    @Override // com.byazt.qn.q
    public boolean lh() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.lh();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public String v() {
        q qVar = this.n;
        return qVar != null ? qVar.v() : "";
    }

    @Override // com.byazt.qn.q
    public boolean j() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.j();
        }
        return false;
    }

    @Override // com.byazt.qn.q
    public Map<String, Object> an() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.an();
        }
        return new ConcurrentHashMap();
    }

    @Override // com.byazt.qn.q
    public SparseArray<Object> ae() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.ae();
        }
        return com.byazt.qvu.n.n.sparseArray();
    }

    @Override // com.byazt.qn.q
    public Map<String, Object> f() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.f();
        }
        return null;
    }

    public void n(com.byazt.ws.qg qgVar) {
        this.qg = qgVar;
    }

    public com.byazt.ws.qg fi() {
        return this.qg;
    }

    @Override // com.byazt.qn.q
    public String df() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.df();
        }
        return null;
    }

    @Override // com.byazt.qn.q
    public boolean oj() {
        q qVar = this.n;
        if (qVar != null) {
            return qVar.oj();
        }
        return false;
    }

    public long dg() {
        com.byazt.ws.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.bb();
        }
        return 0L;
    }

    public String u() {
        com.byazt.ws.qg qgVar = this.qg;
        return qgVar != null ? qgVar.an() : "";
    }

    public double pk() {
        com.byazt.ws.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.py();
        }
        return 0.0d;
    }

    public int wo() {
        com.byazt.ws.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.dh();
        }
        return 0;
    }

    public int sh() {
        com.byazt.ws.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.b();
        }
        return 0;
    }

    public String y() {
        com.byazt.ws.qg qgVar = this.qg;
        return qgVar != null ? qgVar.rf() : "";
    }

    public int rf() {
        com.byazt.ws.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.ln();
        }
        return 0;
    }

    public String dh() {
        com.byazt.ws.qg qgVar = this.qg;
        return qgVar != null ? qgVar.lh() : "";
    }

    public String b() {
        com.byazt.ws.qg qgVar = this.qg;
        return qgVar != null ? qgVar.ou() : "";
    }

    public int ri() {
        com.byazt.ws.qg qgVar = this.qg;
        if (qgVar != null) {
            return qgVar.n();
        }
        return 0;
    }

    @Override // com.byazt.qn.s
    public String n() {
        s sVar = this.s;
        return sVar != null ? sVar.n() : "";
    }

    @Override // com.byazt.qn.s
    public void n(String str) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.n(str);
        }
    }

    @Override // com.byazt.qn.s
    public void n(int i) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.n(i);
        }
    }

    @Override // com.byazt.qn.s
    public int qg() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.qg();
        }
        return 0;
    }

    @Override // com.byazt.qn.s
    public int s() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.s();
        }
        return 0;
    }

    @Override // com.byazt.qn.s
    public void qg(int i) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.qg(i);
        }
    }

    @Override // com.byazt.qn.s
    public void s(int i) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.s(i);
        }
    }

    @Override // com.byazt.qn.s
    public int q() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.q();
        }
        return 0;
    }

    @Override // com.byazt.qn.s
    public int l() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.l();
        }
        return 0;
    }

    @Override // com.byazt.qn.s
    public void q(int i) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.q(i);
        }
    }

    @Override // com.byazt.qn.s
    public String w() {
        s sVar = this.s;
        return sVar != null ? sVar.w() : "";
    }

    @Override // com.byazt.qn.s
    public void qg(String str) {
        s sVar = this.s;
        if (sVar != null) {
            sVar.qg(str);
        }
    }

    @Override // com.byazt.qn.s
    public boolean x() {
        s sVar = this.s;
        if (sVar != null) {
            return sVar.x();
        }
        return false;
    }

    public boolean nf() {
        int iUm = um();
        Map<String, Object> mapAn = an();
        if (mapAn == null) {
            return false;
        }
        Object obj = mapAn.get("use_share_cache");
        return (obj instanceof Boolean) && (iUm == 3 || iUm == 1 || iUm == 5 || iUm == 10 || iUm == 7) && ((Boolean) obj).booleanValue();
    }

    public void n(PluginValueSet pluginValueSet) {
        if (this.n == null || pluginValueSet == null) {
            return;
        }
        this.n = new l(um(), pluginValueSet);
    }

    public boolean pe() {
        return this.q;
    }

    public void n(boolean z) {
        this.q = z;
    }
}
