package com.byazt.xdp;

import android.view.View;
import com.byazt.aqe.tj;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cd;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1162, 8})
public abstract class s implements qg {
    public com.byazt.re.l l;
    public boolean n;
    public com.byazt.re.qg q;
    public pk qg;
    public pk s;
    public TTBaseVideoActivity w;
    public int x = 0;

    public s(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, com.byazt.re.qg qgVar, com.byazt.re.l lVar, boolean z) {
        this.w = tTBaseVideoActivity;
        this.qg = pkVar;
        this.q = qgVar;
        this.l = lVar;
        this.n = z;
    }

    @Override // com.byazt.xdp.qg
    public void s(View view) {
        n(1);
    }

    @Override // com.byazt.xdp.qg
    public void n(View view) {
        n(2);
    }

    @Override // com.byazt.xdp.qg
    public void qg(View view) {
        n(3);
    }

    @Override // com.byazt.xdp.qg
    public void q(View view) {
        n(4);
    }

    @Override // com.byazt.xdp.qg
    public void l(View view) {
        n(5);
        this.w.fs(3);
    }

    @Override // com.byazt.xdp.qg
    public void w(View view) {
        n(6);
    }

    @Override // com.byazt.xdp.qg
    public void x(View view) {
        n(7);
    }

    public boolean n() {
        if (cd.oa(this.qg) || cx.qg() <= 0) {
            return false;
        }
        int i = this.x;
        this.x = i + 1;
        if (i < cx.qg()) {
            return false;
        }
        com.byazt.eji.s.n().n(this.qg, "stats_reward_full_close_force", this.w.ri().n(new JSONObject()));
        this.w.finish();
        return true;
    }

    public void n(int i) {
        this.w.cx();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable unused) {
        }
        com.byazt.eji.s.n().n(this.qg, "stats_reward_full_top_handle", jSONObject);
    }

    public void n(pk pkVar) {
        this.s = pkVar;
    }

    public boolean n(tj tjVar) {
        pk pkVar = this.s;
        if (pkVar != null) {
            return this.w.n(pkVar, tjVar);
        }
        return this.w.n(this.qg, tjVar);
    }
}
