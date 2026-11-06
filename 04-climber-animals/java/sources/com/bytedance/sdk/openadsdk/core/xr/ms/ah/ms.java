package com.bytedance.sdk.openadsdk.core.xr.ms.ah;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.ch;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.u.d;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    protected String ab;
    protected Map<String, Object> c;
    private String hi;
    protected ch ka;
    private com.bytedance.sdk.openadsdk.core.video.xr.xr sl;
    protected boolean x;
    private int ny = -1;
    private int ch = -1;
    private boolean zb = false;

    public void ms(boolean z) {
        this.zb = z;
    }

    public void ms(String str) {
        this.ab = str;
    }

    public void xr(boolean z) {
        this.x = z;
    }

    public void ms() {
        this.ny = 1;
    }

    public void xr() {
        this.ch = 1;
    }

    public void xr(String str) {
        this.hi = str;
    }

    public String ah() {
        return this.hi;
    }

    public void ms(ch chVar) {
        this.ka = chVar;
    }

    public ms() {
    }

    public ms(lm lmVar, Context context) {
        this.f3767ms = lmVar;
        this.xr = context;
        this.c = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.xr.ms.ah.xr, com.bytedance.sdk.openadsdk.core.xr.ms.ms
    public int ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.xr.ms.ah ahVar) {
        if (this.zb) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar = this.sl;
        if (xrVar != null && xrVar.hi() == 1) {
            return 0;
        }
        if (this.ah == null) {
            this.ah = new hi();
        }
        if ("splash_ad".equals(this.ab) || "cache_splash_ad".equals(this.ab) || "splash_ad_landingpage".equals(this.ab)) {
            this.ny = this.ny == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean zBooleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.ka == null) {
            this.ka = d();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            c();
        }
        Object obj3 = map.get("is_need_report_click_button");
        boolean zBooleanValue2 = obj3 instanceof Boolean ? ((Boolean) obj3).booleanValue() : false;
        int i = this.ah.ka() ? 1 : 2;
        if (zBooleanValue2) {
            com.bytedance.sdk.openadsdk.core.zb.ah.ms("click_button", this.f3767ms, this.ka, this.ab, true, this.c, i, this.x);
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.c.put(TTDownloadField.TT_REFER, "banner");
        }
        if (le.ms(this.f3767ms) && !d.ms(String.valueOf(f.ny(this.f3767ms))) && this.f3767ms.fi() != null) {
            this.c.put("refresh_num", Integer.valueOf(this.f3767ms.fi().ah()));
        }
        Object obj4 = map.get("click_saas_action");
        if (obj4 != null && (obj4 instanceof Integer)) {
            this.c.put("click_saas_action", obj4);
        }
        Object obj5 = map.get("click_saas_area");
        if (obj4 != null && (obj4 instanceof Integer)) {
            this.c.put("click_saas_area", obj5);
        }
        ms(true);
        com.bytedance.sdk.openadsdk.core.zb.ah.ms("click", this.f3767ms, this.ka, this.ab, zBooleanValue, this.c, i, this.x);
        return 0;
    }

    protected ch d() {
        int i = this.ny;
        if (i != -1) {
            this.ny = -1;
        } else {
            i = -1;
        }
        float fC = ul.c(this.xr);
        int iX = ul.x(this.xr);
        float fAb = ul.ab(this.xr);
        View viewAb = this.ah.ab();
        View viewC = this.ah.c();
        return new ch.ms().c(this.ah.u()).ka(this.ah.ub()).d(this.ah.ao()).ah(this.ah.h()).xr(this.ah.sl()).ms(this.ah.zb()).xr(ul.ms(viewAb)).ms(ul.ms(viewC)).ah(ul.ah(viewAb)).d(ul.ah(viewC)).ah(this.ah.xr()).d(this.ah.ah()).ka(this.ah.d()).ms(this.ah.ch()).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(this.hi).ms(fC).ms(iX).xr(fAb).c(i).ab(this.ch).x(this.ah.y()).ka(this.ah.qv()).ms();
    }

    public void ms(Map<String, Object> map) {
        Map<String, Object> map2 = this.c;
        if (map2 == null) {
            this.c = map;
        } else {
            map2.putAll(map);
        }
    }

    public Map<String, Object> ka() {
        return this.c;
    }

    private void c() {
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        long jXr = xrVarMs.xr("click_to_live_duration", 0L);
        if (jXr == 0) {
            Map<String, Object> map = this.c;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - jXr;
        HashMap map2 = new HashMap();
        map2.put("click_livead_duration", Long.valueOf(jCurrentTimeMillis));
        ms(map2);
        xrVarMs.xr("click_to_live_duration", 0L);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.xr.xr xrVar) {
        this.sl = xrVar;
    }
}
