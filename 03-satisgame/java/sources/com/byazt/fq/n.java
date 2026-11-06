package com.byazt.fq;

import android.content.Context;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.gct.rv;
import com.byazt.gct.tj;
import com.byazt.gct.ur;
import com.byazt.oh.l;
import com.byazt.qp.q;
import com.byazt.vf.oa;
import com.byazt.vgx.w;
import com.byazt.wd.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 569, 19})
public class n extends qg {
    public String cp;
    public com.byazt.zx.qg d;
    public boolean fs;
    public rv l;
    public Map<String, Object> w;
    public String x;
    public int rv = -1;
    public int tj = -1;
    public boolean oa = false;

    public void n(boolean z) {
        this.oa = z;
    }

    public void n(String str) {
        this.x = str;
    }

    public void qg(boolean z) {
        this.fs = z;
    }

    public void n() {
        this.rv = 1;
    }

    public void qg() {
        this.tj = 1;
    }

    public void qg(String str) {
        this.cp = str;
    }

    public String s() {
        return this.cp;
    }

    public void n(rv rvVar) {
        this.l = rvVar;
    }

    public n() {
    }

    public n(pk pkVar, Context context) {
        this.n = pkVar;
        this.qg = context;
        this.w = new HashMap();
    }

    @Override // com.byazt.fq.qg, com.byazt.dj.n
    public int n(Map<String, Object> map, com.byazt.dj.s sVar) {
        if (this.oa) {
            return 0;
        }
        com.byazt.zx.qg qgVar = this.d;
        if (qgVar != null && qgVar.cp() == 1) {
            return 0;
        }
        if (this.s == null) {
            this.s = new tj();
        }
        if ("splash_ad".equals(this.x) || "cache_splash_ad".equals(this.x) || "splash_ad_landingpage".equals(this.x)) {
            this.rv = this.rv == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.l == null) {
            this.l = q();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            w();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.w.put("refer", MediationConstant.RIT_TYPE_BANNER);
        }
        if (ur.n(this.n) && !x.n(String.valueOf(w.cy(this.n))) && this.n.nq() != null) {
            this.w.put("refresh_num", Integer.valueOf(this.n.nq().s()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.w.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.w.put("click_saas_area", obj4);
        }
        n(true);
        com.byazt.hm.n.n("click", this.n, this.l, this.x, zBooleanValue, this.w, this.s.rv() ? 1 : 2, this.fs, this.s.n());
        return 0;
    }

    public rv q() {
        int i = this.rv;
        if (i != -1) {
            this.rv = -1;
        } else {
            i = -1;
        }
        oa oaVar = (oa) q.n("device_info_new");
        float fX = com.byazt.okk.s.x(this.qg);
        int iA = oaVar.a();
        float fFs = com.byazt.okk.s.fs(this.qg);
        View viewCp = this.s.cp();
        View viewTj = this.s.tj();
        return new rv.n().w(this.s.cd()).l(this.s.um()).q(this.s.a()).s(this.s.py()).qg(this.s.cy()).n(this.s.hd()).qg(com.byazt.okk.s.n(viewCp)).n(com.byazt.okk.s.n(viewTj)).s(com.byazt.okk.s.s(viewCp)).q(com.byazt.okk.s.s(viewTj)).q(this.s.w()).l(this.s.x()).w(this.s.fs()).n(this.s.sz()).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).n(this.cp).n(fX).qg(iA).qg(fFs).x(i).fs(this.tj).rv(this.s.wm()).l(this.s.ou()).n(this.s.q()).tj(this.s.l()).qg(this.s.qg()).n(this.s.s()).n(l.qg(this.n)).n();
    }

    public void n(Map<String, Object> map) {
        Map<String, Object> map2 = this.w;
        if (map2 == null) {
            this.w = map;
        } else {
            map2.putAll(map);
        }
    }

    public Map<String, Object> l() {
        return this.w;
    }

    private void w() {
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        long jQg = sVarN.qg("click_to_live_duration", 0L);
        if (jQg == 0) {
            Map<String, Object> map = this.w;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jQg;
        HashMap map2 = new HashMap();
        map2.put("click_livead_duration", Long.valueOf(jCurrentTimeMillis));
        n(map2);
        sVarN.qg("click_to_live_duration", 0L);
    }

    public void n(com.byazt.zx.qg qgVar) {
        this.d = qgVar;
    }
}
