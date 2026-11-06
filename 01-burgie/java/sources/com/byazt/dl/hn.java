package com.byazt.dl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.byazt.ca.yb;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.gz.fw;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 671, 20})
public class hn extends pr {
    public fw fw;
    public int uc;
    public boolean zo;

    @Override // com.byazt.dl.pr, com.byazt.ln.pr
    public int pr(Map<String, Object> map, com.byazt.ln.hn hnVar) {
        String str;
        boolean z;
        hw(this.pr.aj());
        hn();
        final pr.InterfaceC0041pr interfaceC0041prPr = this.c.pr();
        zo.pr(new Runnable() { // from class: com.byazt.dl.hn.1
            @Override // java.lang.Runnable
            public void run() {
                pr.InterfaceC0041pr interfaceC0041pr = interfaceC0041prPr;
                if (interfaceC0041pr != null) {
                    interfaceC0041pr.pr(hn.this.x, hn.this.c.hn());
                }
            }
        });
        Map<String, Object> mapZo = this.c.zo();
        String strZ = this.hn.z();
        if (!TextUtils.isEmpty(strZ)) {
            str = strZ;
        } else {
            str = "clickEvent";
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        mapZo.put("click_from_uchain", 1);
        mapZo.put("event_type", str);
        ls.ve();
        HashMap map2 = new HashMap();
        map2.put("material_meta", this.pr);
        map2.put("click_chain", hnVar);
        map2.put("dpa_tag", this.hn.rc());
        map2.put(d.R, this.hw);
        map2.put("event_tag", this.c.aj());
        map2.put("landing_page_source", Integer.valueOf(this.c.fw()));
        map2.put("view", this.x);
        if (!(this.x instanceof TextView)) {
            z = false;
        } else {
            CharSequence text = ((TextView) this.x).getText();
            if (text != null && (text.toString().contains("下载") || text.toString().contains("安装"))) {
                z = true;
            } else {
                z = false;
            }
            if (this.x instanceof Button) {
                z = true;
            }
        }
        map2.put("handle_chain_data", map);
        com.byazt.nv.hn hnVarUc = this.c.uc();
        if (hnVarUc == null) {
            map2.put("has_show_dl_factors", Boolean.FALSE);
        } else {
            map2.put("download_adapter", hnVarUc);
            map2.put("has_show_dl_factors", Boolean.valueOf(hnVarUc.uc()));
            Map<String, Object> mapC = hnVarUc.c();
            if (mapC != null && !(mapC.get(TTDownloadField.TT_ACTIVITY) instanceof Activity) && qa.nt(this.pr)) {
                try {
                    Activity activityPr = com.byazt.ri.hw.pr(this.x);
                    if (activityPr != null) {
                        hnVarUc.pr(activityPr, true);
                        mapC.put(TTDownloadField.TT_ACTIVITY, activityPr);
                    }
                } catch (Exception e) {
                    com.byazt.xk.hw.pr().pr("openMarketInApp", e);
                }
            }
            if (mapC != null) {
                map2.putAll(mapC);
            }
        }
        map2.put("is_click_button", Boolean.valueOf(z || this.hn.x()));
        Map<String, Object> mapPr = com.byazt.lxw.pr.pr().pr(this.pr.hashCode() + this.pr.ny());
        this.fw = (fw) cz.hn(this.pr.le(), fw.class);
        Object objRemove = mapPr.remove("is_express_ad");
        if (objRemove instanceof Boolean) {
            this.zo = ((Boolean) objRemove).booleanValue();
        }
        map2.put("is_video_lp", Boolean.valueOf(zo()));
        map2.putAll(mapPr);
        map2.put("convert_from_downloader", Boolean.FALSE);
        map2.put("convert_from_landing_page", Boolean.valueOf(this.c.hw()));
        map2.put("pip_controller", this.c.k());
        map2.put("open_video_detail_page_direct", Boolean.valueOf(!zo() && this.c.x()));
        map2.put("is_from_video_layout", Boolean.valueOf(this.c.vk()));
        map2.put("is_open_web_page", Boolean.FALSE);
        map2.put("is_feed_register_direct_download", Boolean.valueOf(this.hn.x()));
        com.byazt.lx.hw.pr(this.pr, mapZo, str, map2, this.c.aj(), new HashMap(), hnVar.pr());
        x();
        return 0;
    }

    private boolean zo() {
        return aj() && hw(this.x) && !this.c.hw();
    }

    private boolean hw(View view) {
        if (view == null) {
            return false;
        }
        if ((view instanceof NativeVideoTsView) || view.getId() == 2114387961 || view.getId() == 2114387664 || view.getId() == 2114387957 || view.getId() == 2114387764 || view.getId() == 2114387686 || view.getId() == 2114387626) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return false;
            }
            if (hw(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean aj() {
        if (this.pr == null || vk() || !of.hn(this.pr)) {
            return false;
        }
        if (this.uc == 0) {
            this.uc = ls.k(this.pr);
        }
        c();
        fw();
        uc();
        if (this.uc == 5 && w() && fw() && !c() && !uc()) {
            return false;
        }
        int i = this.uc;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean vk() {
        return this.zo;
    }

    public boolean c() {
        fw fwVar = this.fw;
        if (fwVar == null) {
            return false;
        }
        return fwVar.pr();
    }

    public boolean uc() {
        fw fwVar = this.fw;
        if (fwVar == null) {
            return false;
        }
        return fwVar.hw();
    }

    public boolean fw() {
        if (this.pr == null) {
            return true;
        }
        switch (a.hw().uc(ls.m(this.pr))) {
            case 1:
                return yb.x(this.hw);
            case 2:
                return yb.c(this.hw) || yb.x(this.hw) || yb.uc(this.hw);
            case 3:
                return false;
            case 4:
            default:
                return true;
            case 5:
                return yb.x(this.hw) || yb.uc(this.hw);
        }
    }

    private boolean w() {
        return this.pr != null && this.pr.fe() == 1 && of.hn(this.pr);
    }
}
