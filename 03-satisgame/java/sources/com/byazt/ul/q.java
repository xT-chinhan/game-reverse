package com.byazt.ul;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gct.pk;
import com.byazt.mu.w;
import com.byazt.prf.RecyclerView;
import com.byazt.vh.cd;
import com.byazt.vyf.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 831, 5})
public class q extends com.byazt.ozc.n {
    public boolean m;
    public List<com.byazt.mu.s> ou;
    public int wm;

    @Override // com.byazt.za.d
    public void fs() {
    }

    @Override // com.byazt.za.d
    public void l() {
    }

    @Override // com.byazt.za.d
    public long n() {
        return 0L;
    }

    @Override // com.byazt.za.d
    public void n(float f) {
    }

    @Override // com.byazt.za.d
    public void n(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.byazt.za.d
    public void n(int i) {
    }

    @Override // com.byazt.za.d
    public void n(int i, int i2) {
    }

    @Override // com.byazt.za.d
    public void n(int i, String str) {
    }

    @Override // com.byazt.za.d
    public void n(pk pkVar) {
    }

    @Override // com.byazt.ozc.q
    public void n(RecyclerView recyclerView, int i) {
    }

    @Override // com.byazt.za.d
    public void n(boolean z) {
    }

    @Override // com.byazt.za.d
    public void q() {
    }

    @Override // com.byazt.za.d
    public void q(int i) {
    }

    @Override // com.byazt.za.d
    public int qg() {
        return 0;
    }

    @Override // com.byazt.za.d
    public void qg(int i) {
    }

    @Override // com.byazt.za.d
    public void rv() {
    }

    @Override // com.byazt.za.d
    public int s() {
        return 0;
    }

    @Override // com.byazt.za.d
    public void s(int i) {
    }

    @Override // com.byazt.za.d
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.byazt.za.d
    public void tj() {
    }

    @Override // com.byazt.za.d
    public void w() {
    }

    @Override // com.byazt.za.d
    public void x() {
    }

    public q(Context context, ViewGroup viewGroup, com.byazt.hm.q qVar, pk pkVar, String str, int i) {
        super(context, viewGroup, qVar, pkVar, str, i);
    }

    @Override // com.byazt.ozc.n
    public List<com.byazt.mu.s> cp() {
        this.ou = new ArrayList();
        JSONObject jSONObjectPv = this.l.pv();
        this.ou.add(0, new com.byazt.mu.s(jSONObjectPv, -1221270899));
        this.ou.add(new com.byazt.mu.s(jSONObjectPv, -2134548432));
        return this.ou;
    }

    public void l(int i) {
        this.wm = i;
        if (i < 0) {
            return;
        }
        final String str = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.x instanceof w) {
            l.q().post(new Runnable() { // from class: com.byazt.ul.q.1
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.x != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((w) q.this.x).n();
                            if (recyclerView.getScrollState() != 0 || recyclerView.k()) {
                                return;
                            }
                            ((w) q.this.x).n(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((w) this.x).n(new com.byazt.mu.l.q() { // from class: com.byazt.ul.q.2
                @Override // com.byazt.mu.l.q
                public void n(RecyclerView.m mVar, int i2) {
                    com.byazt.ih.s sVarQ = ((com.byazt.mu.l.C0250l) mVar).t().q("count_down");
                    if (sVarQ instanceof com.byazt.ud.qg) {
                        ((com.byazt.ud.qg) sVarQ).oa(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.ozc.q
    public void q(com.byazt.ih.s<View> sVar) {
        n(sVar);
    }

    @Override // com.byazt.ozc.q
    public void qg(int i, int i2) {
        if (i2 > 0) {
            this.tj.set(1);
        }
    }

    @Override // com.byazt.ozc.q
    public void n(com.byazt.ih.s sVar, int i, View view, com.byazt.mu.s sVar2) {
        if (sVar2 == null || sVar2.n() == null) {
            return;
        }
        int iHashCode = sVar2.n().hashCode();
        if (this.cp.get(Integer.valueOf(iHashCode)) != null && this.cp.containsKey(Integer.valueOf(iHashCode)) && this.cp.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        n(sVar2.n());
        this.cp.put(Integer.valueOf(iHashCode), Boolean.TRUE);
    }

    @Override // com.byazt.ozc.q
    public void l(com.byazt.ih.s<View> sVar) {
        if (sVar == null) {
            return;
        }
        if (this.wm <= 0 && !this.m && TextUtils.equals(sVar.v(), "header")) {
            l(0);
            this.m = true;
        }
        JSONObject jSONObjectTj = sVar.tj();
        if (jSONObjectTj == null) {
            return;
        }
        cd.n nVarQ = sVar.q("video_".concat(String.valueOf(jSONObjectTj.optInt("image_mode"))));
        if (nVarQ instanceof com.byazt.kx.qg) {
            com.byazt.kx.qg qgVar = (com.byazt.kx.qg) nVarQ;
            qgVar.n(this.oa);
            qgVar.cx();
        }
    }

    @Override // com.byazt.ozc.q
    public void w(com.byazt.ih.s<View> sVar) {
        JSONObject jSONObjectTj;
        if (sVar == null || (jSONObjectTj = sVar.tj()) == null) {
            return;
        }
        cd.n nVarQ = sVar.q("video_".concat(String.valueOf(jSONObjectTj.optInt("image_mode"))));
        if (nVarQ instanceof com.byazt.kx.qg) {
            ((com.byazt.kx.qg) nVarQ).ci();
        }
    }

    @Override // com.byazt.ozc.s
    public void s(com.byazt.ih.s sVar) {
        pk pkVarN;
        if (sVar == null || (pkVarN = com.byazt.vgx.qg.n(sVar.tj())) == null) {
            return;
        }
        n(pkVarN, sVar);
    }
}
