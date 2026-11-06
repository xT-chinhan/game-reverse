package com.byazt.oh;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE, 5})
public class q extends n {
    public volatile Map<String, Object> ou;
    public boolean wm;

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
    }

    public q(Context context, pk pkVar, String str, String str2) {
        super(context, pkVar, str, str2);
        this.wm = false;
    }

    @Override // com.byazt.oh.n
    public void x() {
        if (!TextUtils.isEmpty(this.cy)) {
            getParam().put("enable_update_download_model", Boolean.TRUE);
            getParam().put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, this.cy);
            com.byazt.esa.s.n(this.cy, this.q, this.s, (JSONObject) null, fs());
        } else {
            com.byazt.esa.s.n(this.q, this.s, (JSONObject) null, fs());
        }
        com.byazt.esa.s.n(this.s, fs(), false);
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public boolean isAppMarketConvert() {
        return this.oa != null && com.byazt.esa.s.n(this.oa, fs()) == 2;
    }

    @Override // com.byazt.oh.n
    public synchronized void w() {
        rv();
        this.w.set(true);
        if (this.oa != null) {
            this.oa.apply(com.byazt.of.qg.n().n(5).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(fs())).n("downloadStatusChangeListener", this.hd).n("marketStatusChangeListener", this.um)).qg());
        }
    }

    private void rv() {
        com.byazt.gct.l lVarK = this.s.k();
        if (lVarK != null) {
            getParam().put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, lVarK.qg());
        }
        getParam().put("download_status_listener", this.hd);
        getParam().put("event_tag", this.q);
        getParam().put("dialog_to_landing_page_convert", new com.byazt.wj.n() { // from class: com.byazt.oh.q.1
            @Override // com.byazt.wj.n
            public boolean n(Map<String, Object> map) {
                q qVar = q.this;
                return qVar.n(qVar.getContext(), q.this.s, q.this.q);
            }
        });
        getParam().put("download_popup_manager", n());
        getParam().put("activity", getContext());
        getParam().put("open_market_in_app", Boolean.valueOf(um.cy(this.s)));
        getParam().put("download_manager_hash_code", Integer.valueOf(hashCode()));
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void handleAdClick(pk pkVar, boolean z) {
        if (getContext() == null) {
            return;
        }
        changeDownloadStatus(w.h(pkVar), z);
    }

    @Override // com.byazt.oh.n, com.byazt.pmn.ITTInnerDownloadAdapter
    public void setCheckCompliance(int i) {
        getParam().put("need_check_compliance", Integer.valueOf(i));
    }

    @Override // com.byazt.oh.n, com.byazt.pmn.ITTInnerDownloadAdapter
    public Map<String, Object> getParam() {
        if (this.ou == null) {
            this.ou = new HashMap();
        }
        return this.ou;
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void setOpenMarketInterceptorForDSP(boolean z) {
        getParam().put("is_open_market_intercept_for_dsp", Boolean.valueOf(z));
    }

    @Override // com.byazt.oh.n
    public void n(boolean z) {
        getParam().put("convert_from_landing_page", Boolean.valueOf(z));
    }

    @Override // com.byazt.oh.n
    public synchronized void q() {
        if (this.qg == null) {
            return;
        }
        if (this.oa != null && tj.l >= 6400 && !tj.fs()) {
            com.byazt.esa.s.n((com.byazt.myr.s) null, fs());
        }
        if (this.w != null && this.w.get()) {
            this.w.set(false);
            if (this.oa != null) {
                this.oa.apply(com.byazt.of.qg.n().n(4).n(Void.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(fs()))).qg());
            }
        }
        s();
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void changeDownloadStatus(JSONObject jSONObject, boolean z) {
        w.ur();
        HashMap map = new HashMap();
        map.put("material_meta", this.s);
        map.put("context", rv.getContext());
        com.byazt.gct.l lVarK = this.s.k();
        if (lVarK != null) {
            map.put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, lVarK.qg());
        }
        if (getParam() != null) {
            map.putAll(getParam());
        }
        map.put("download_status_listener", this.hd);
        map.put("event_tag", this.q);
        map.put("landing_page_source", Integer.valueOf(w.q(this.q)));
        map.put("dialog_to_landing_page_convert", new com.byazt.wj.n() { // from class: com.byazt.oh.q.2
            @Override // com.byazt.wj.n
            public boolean n(Map<String, Object> map2) {
                q qVar = q.this;
                return qVar.n(qVar.getContext(), q.this.s, q.this.q);
            }
        });
        map.put("download_popup_manager", n());
        map.put("activity", getContext());
        map.put("open_market_in_app", Boolean.valueOf(um.cy(this.s)));
        map.putAll(com.byazt.wu.n.n().n(this.s.hashCode() + this.s.ou()));
        map.put("convert_from_downloader", Boolean.TRUE);
        map.put("download_manager_hash_code", Integer.valueOf(fs()));
        map.put("is_feed_register_direct_download", Boolean.valueOf(z));
        HashMap map2 = new HashMap();
        map.put("download_manager_hash_code", Integer.valueOf(fs()));
        HashMap map3 = new HashMap();
        if (this.wm) {
            com.byazt.ukb.qg.n("download", this.s.pv(), map, (com.byazt.xvf.l) null);
        } else {
            com.byazt.ukb.qg.n(this.s, map2, "clickEvent", map, this.q, map3, -1L);
        }
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void cancelDownload() {
        if (this.s != null) {
            com.byazt.de.n.q(this.s.h());
        }
        if (this.qg == null) {
            return;
        }
        this.w.set(false);
        if (this.oa != null) {
            this.oa.apply(com.byazt.of.qg.n().n(8).n(Void.class).n(0, new com.byazt.ikv.s().n("force", Boolean.TRUE).n("hashCode", Integer.valueOf(fs()))).qg());
        }
        w();
    }

    @Override // com.byazt.oh.n, com.byazt.pmn.ITTInnerDownloadAdapter
    public void setClickViewIsButton(boolean z) {
        this.sz = z;
        getParam().put("is_click_button", Boolean.valueOf(z));
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public void setShowDLFactorsCard(boolean z) {
        this.k = z;
        getParam().put("has_show_dl_factors", Boolean.valueOf(z));
    }

    @Override // com.byazt.pmn.ITTInnerDownloadAdapter
    public boolean hasShowDLFactorsCard() {
        return this.k;
    }

    public void qg(boolean z) {
        this.wm = z;
    }
}
