package com.byazt.ri;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.wt.ls;
import com.byazt.wt.ww;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 697, 121})
public class x extends pr {
    public boolean fo;
    public volatile Map<String, Object> ny;

    public x(Context context, of ofVar, String str, String str2) {
        super(context, ofVar, str, str2);
        this.fo = false;
    }

    @Override // com.byazt.ri.pr
    public void m() {
        if (!TextUtils.isEmpty(this.nt)) {
            c().put("enable_update_download_model", Boolean.TRUE);
            c().put("download_url", this.nt);
            com.byazt.vo.hn.pr(this.nt, this.x, this.hn, (JSONObject) null, g());
        } else {
            com.byazt.vo.hn.pr(this.x, this.hn, (JSONObject) null, g());
        }
        com.byazt.vo.hn.pr(this.hn, g(), false);
    }

    @Override // com.byazt.ri.pr
    public synchronized void k() {
        ho();
        this.uc.set(true);
        if (this.m != null) {
            this.m.apply(com.byazt.xi.hw.pr().pr(5).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(g())).pr("downloadStatusChangeListener", this.yb).pr("marketStatusChangeListener", this.qa)).hw());
        }
    }

    private void ho() {
        com.byazt.hg.c cVarHo = this.hn.ho();
        if (cVarHo != null) {
            c().put("download_url", cVarHo.hw());
        }
        c().put("download_status_listener", this.yb);
        c().put("event_tag", this.x);
        c().put("dialog_to_landing_page_convert", new com.byazt.ni.pr() { // from class: com.byazt.ri.x.1
            @Override // com.byazt.ni.pr
            public boolean pr(Map<String, Object> map) {
                x xVar = x.this;
                return xVar.pr(xVar.getContext(), x.this.hn, x.this.x);
            }
        });
        c().put("download_popup_manager", fw());
        c().put(TTDownloadField.TT_ACTIVITY, getContext());
        c().put("open_market_in_app", Boolean.valueOf(qa.nt(this.hn)));
        c().put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.byazt.nv.hn
    public void pr(of ofVar, boolean z) {
        if (getContext() == null) {
            return;
        }
        pr(ls.fo(ofVar), z);
    }

    @Override // com.byazt.ri.pr, com.byazt.nv.hn
    public void pr(int i) {
        c().put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.byazt.ri.pr, com.byazt.nv.hn
    public Map<String, Object> c() {
        if (this.ny == null) {
            this.ny = new HashMap();
        }
        return this.ny;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
    }

    @Override // com.byazt.nv.hn
    public void hw(boolean z) {
        c().put("is_open_market_intercept_for_dsp", Boolean.valueOf(z));
    }

    @Override // com.byazt.ri.pr
    public void c(boolean z) {
        c().put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.byazt.ri.pr
    public synchronized void vk() {
        if (this.hw == null) {
            return;
        }
        if (this.m != null && iu.x >= 6400 && !iu.fw()) {
            com.byazt.vo.hn.pr((com.byazt.qp.hn) null, g());
        }
        if (this.uc != null && this.uc.get()) {
            this.uc.set(false);
            if (this.m != null) {
                this.m.apply(com.byazt.xi.hw.pr().pr(4).pr(Void.class).pr(0, new ww().pr("hashCode", Integer.valueOf(g()))).hw());
            }
        }
        aj();
    }

    @Override // com.byazt.nv.hn
    public void pr(JSONObject jSONObject, boolean z) {
        ls.ve();
        HashMap map = new HashMap();
        map.put("material_meta", this.hn);
        map.put(d.R, a.getContext());
        com.byazt.hg.c cVarHo = this.hn.ho();
        if (cVarHo != null) {
            map.put("download_url", cVarHo.hw());
        }
        if (c() != null) {
            map.putAll(c());
        }
        map.put("download_status_listener", this.yb);
        map.put("event_tag", this.x);
        map.put("landing_page_source", Integer.valueOf(ls.x(this.x)));
        map.put("dialog_to_landing_page_convert", new com.byazt.ni.pr() { // from class: com.byazt.ri.x.2
            @Override // com.byazt.ni.pr
            public boolean pr(Map<String, Object> map2) {
                x xVar = x.this;
                return xVar.pr(xVar.getContext(), x.this.hn, x.this.x);
            }
        });
        map.put("download_popup_manager", fw());
        map.put(TTDownloadField.TT_ACTIVITY, getContext());
        map.put("open_market_in_app", Boolean.valueOf(qa.nt(this.hn)));
        map.putAll(com.byazt.lxw.pr.pr().pr(this.hn.hashCode() + this.hn.ny()));
        map.put("convert_from_downloader", Boolean.TRUE);
        map.put("download_manager_hash_code", Integer.valueOf(g()));
        map.put("is_feed_register_direct_download", Boolean.valueOf(z));
        HashMap map2 = new HashMap();
        map.put("download_manager_hash_code", Integer.valueOf(g()));
        HashMap map3 = new HashMap();
        if (this.fo) {
            com.byazt.lx.hw.pr("download", this.hn.to(), map, (com.byazt.kr.c) null);
        } else {
            com.byazt.lx.hw.pr(this.hn, map2, "clickEvent", map, this.x, map3, -1L);
        }
    }

    @Override // com.byazt.nv.hn
    public void x() {
        if (this.hn != null) {
            com.byazt.qd.pr.x(this.hn.z());
        }
        if (this.hw == null) {
            return;
        }
        this.uc.set(false);
        if (this.m != null) {
            this.m.apply(com.byazt.xi.hw.pr().pr(8).pr(Void.class).pr(0, new ww().pr("force", Boolean.TRUE).pr("hashCode", Integer.valueOf(g()))).hw());
        }
        k();
    }

    @Override // com.byazt.ri.pr, com.byazt.nv.hn
    public void hn(boolean z) {
        this.g = z;
        c().put("is_click_button", Boolean.valueOf(z));
    }

    @Override // com.byazt.nv.hn
    public void x(boolean z) {
        this.ho = z;
        c().put("has_show_dl_factors", Boolean.valueOf(z));
    }

    @Override // com.byazt.nv.hn
    public boolean uc() {
        return this.ho;
    }

    public void uc(boolean z) {
        this.fo = z;
    }
}
