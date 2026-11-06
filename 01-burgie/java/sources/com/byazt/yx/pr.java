package com.byazt.yx;

import android.content.Context;
import android.view.View;
import com.byazt.dt.fw;
import com.byazt.hg.aj;
import com.byazt.hg.of;
import com.byazt.hg.ve;
import com.byazt.hg.vk;
import com.byazt.ri.c;
import com.byazt.sd.zo;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zs.uc;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2286, 37})
public class pr extends hw {
    public aj c;
    public String fw;
    public com.byazt.ga.hw k;
    public Map<String, Object> uc;
    public String w;
    public boolean zo;
    public int aj = -1;
    public int vk = -1;
    public boolean m = false;

    public void pr(boolean z) {
        this.m = z;
    }

    public void pr(String str) {
        this.fw = str;
    }

    public void hw(boolean z) {
        this.zo = z;
    }

    public void pr() {
        this.aj = 1;
    }

    public void hw() {
        this.vk = 1;
    }

    public void hw(String str) {
        this.w = str;
    }

    public String hn() {
        return this.w;
    }

    public void pr(aj ajVar) {
        this.c = ajVar;
    }

    public pr() {
    }

    public pr(of ofVar, Context context) {
        this.pr = ofVar;
        this.hw = context;
        this.uc = new HashMap();
    }

    @Override // com.byazt.yx.hw, com.byazt.ln.pr
    public int pr(Map<String, Object> map, com.byazt.ln.hn hnVar) {
        boolean zBooleanValue;
        boolean zBooleanValue2;
        if (this.m) {
            return 0;
        }
        com.byazt.ga.hw hwVar = this.k;
        if (hwVar != null && hwVar.w() == 1) {
            return 0;
        }
        if (this.hn == null) {
            this.hn = new vk();
        }
        if ("splash_ad".equals(this.fw) || "cache_splash_ad".equals(this.fw) || "splash_ad_landingpage".equals(this.fw)) {
            this.aj = this.aj == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        if (!(obj instanceof Boolean)) {
            zBooleanValue = false;
        } else {
            zBooleanValue = ((Boolean) obj).booleanValue();
        }
        if (this.c == null) {
            this.c = x();
        }
        Object obj2 = map.get("is_reward_live");
        if (!(obj2 instanceof Boolean)) {
            zBooleanValue2 = false;
        } else {
            zBooleanValue2 = ((Boolean) obj2).booleanValue();
        }
        if (zBooleanValue2) {
            uc();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.uc.put("refer", MediationConstant.RIT_TYPE_BANNER);
        }
        if (ve.pr(this.pr) && !fw.pr(String.valueOf(ls.m(this.pr))) && this.pr.sb() != null) {
            this.uc.put("refresh_num", Integer.valueOf(this.pr.sb().hn()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.uc.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.uc.put("click_saas_area", obj4);
        }
        pr(true);
        com.byazt.pj.pr.pr("click", this.pr, this.c, this.fw, zBooleanValue, this.uc, this.hn.aj() ? 1 : 2, this.zo, this.hn.pr());
        return 0;
    }

    public aj x() {
        int i = this.aj;
        if (i == -1) {
            i = -1;
        } else {
            this.aj = -1;
        }
        g gVar = (g) uc.pr("device_info_new");
        float fFw = er.fw(this.hw);
        int iA = gVar.a();
        float fZo = er.zo(this.hw);
        View viewW = this.hn.w();
        View viewVk = this.hn.vk();
        return new aj.pr().uc(this.hn.lb()).c(this.hn.qa()).x(this.hn.a()).hn(this.hn.cz()).hw(this.hn.nt()).pr(this.hn.yb()).hw(er.pr(viewW)).pr(er.pr(viewVk)).hn(er.hn(viewW)).x(er.hn(viewVk)).x(this.hn.uc()).c(this.hn.fw()).uc(this.hn.zo()).pr(this.hn.g()).hn(zo.nt().hw() ? 1 : 2).pr(this.w).pr(fFw).hw(iA).hw(fZo).fw(i).zo(this.vk).aj(this.hn.fo()).c(this.hn.ny()).pr(this.hn.x()).vk(this.hn.c()).hw(this.hn.hw()).pr(this.hn.hn()).pr(c.hw(this.pr)).pr();
    }

    public void pr(Map<String, Object> map) {
        Map<String, Object> map2 = this.uc;
        if (map2 == null) {
            this.uc = map;
        } else {
            map2.putAll(map);
        }
    }

    public Map<String, Object> c() {
        return this.uc;
    }

    private void uc() {
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        long jHw = hnVarPr.hw("click_to_live_duration", 0L);
        if (jHw == 0) {
            Map<String, Object> map = this.uc;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jHw;
        HashMap map2 = new HashMap();
        map2.put("click_livead_duration", Long.valueOf(jCurrentTimeMillis));
        pr(map2);
        hnVarPr.hw("click_to_live_duration", 0L);
    }

    public void pr(com.byazt.ga.hw hwVar) {
        this.k = hwVar;
    }
}
