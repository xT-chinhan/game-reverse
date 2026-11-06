package com.byazt.zct;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.ia.x;
import com.byazt.nf.rv;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.tk.hd;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS, 8})
public class s extends n {
    public boolean fs;
    public int w;
    public x x;

    @Override // com.byazt.zct.n, com.byazt.dj.n
    public int n(Map<String, Object> map, com.byazt.dj.s sVar) {
        boolean z;
        qg(this.n.rv());
        s();
        final n.InterfaceC0409n interfaceC0409nN = this.l.n();
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.zct.s.1
            @Override // java.lang.Runnable
            public void run() {
                n.InterfaceC0409n interfaceC0409n = interfaceC0409nN;
                if (interfaceC0409n != null) {
                    interfaceC0409n.n(s.this.q, s.this.l.s());
                }
            }
        });
        Map<String, Object> mapFs = this.l.fs();
        String strHu = this.s.hu();
        if (TextUtils.isEmpty(strHu)) {
            strHu = "clickEvent";
        }
        String str = strHu;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        mapFs.put("click_from_uchain", 1);
        mapFs.put("event_type", str);
        w.ur();
        HashMap map2 = new HashMap();
        map2.put("material_meta", this.n);
        map2.put("click_chain", sVar);
        map2.put("dpa_tag", this.s.m());
        map2.put("context", this.qg);
        map2.put("event_tag", this.l.rv());
        map2.put("landing_page_source", Integer.valueOf(this.l.x()));
        map2.put("view", this.q);
        if (this.q instanceof TextView) {
            CharSequence text = ((TextView) this.q).getText();
            z = text != null && (text.toString().contains("下载") || text.toString().contains("安装"));
            if (this.q instanceof Button) {
                z = true;
            }
        } else {
            z = false;
        }
        map2.put("handle_chain_data", map);
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterW = this.l.w();
        if (iTTInnerDownloadAdapterW != null) {
            map2.put("download_adapter", iTTInnerDownloadAdapterW);
            map2.put("has_show_dl_factors", Boolean.valueOf(iTTInnerDownloadAdapterW.hasShowDLFactorsCard()));
            Map<String, Object> param = iTTInnerDownloadAdapterW.getParam();
            if (param != null && !(param.get("activity") instanceof Activity) && um.cy(this.n)) {
                try {
                    Activity activityN = com.byazt.oh.qg.n(this.q);
                    if (activityN != null) {
                        iTTInnerDownloadAdapterW.setActivity(activityN, true);
                        param.put("activity", activityN);
                    }
                } catch (Exception e) {
                    com.byazt.eji.s.n().n("openMarketInApp", e);
                }
            }
            if (param != null) {
                map2.putAll(param);
            }
        } else {
            map2.put("has_show_dl_factors", Boolean.FALSE);
        }
        map2.put("is_click_button", Boolean.valueOf(z || this.s.q()));
        Map<String, Object> mapN = com.byazt.wu.n.n().n(this.n.hashCode() + this.n.ou());
        this.x = (x) com.byazt.ikv.qg.s(this.n.ih(), x.class);
        Object objRemove = mapN.remove("is_express_ad");
        if (objRemove instanceof Boolean) {
            this.fs = ((Boolean) objRemove).booleanValue();
        }
        map2.put("is_video_lp", Boolean.valueOf(fs()));
        map2.putAll(mapN);
        map2.put("convert_from_downloader", Boolean.FALSE);
        map2.put("convert_from_landing_page", Boolean.valueOf(this.l.qg()));
        map2.put("pip_controller", this.l.d());
        map2.put("open_video_detail_page_direct", Boolean.valueOf(!fs() && this.l.q()));
        map2.put("is_from_video_layout", Boolean.valueOf(this.l.tj()));
        map2.put("is_open_web_page", Boolean.FALSE);
        map2.put("is_feed_register_direct_download", Boolean.valueOf(this.s.q()));
        com.byazt.ukb.qg.n(this.n, mapFs, str, map2, this.l.rv(), new HashMap(), sVar.n());
        q();
        return 0;
    }

    private boolean fs() {
        return rv() && qg(this.q) && !this.l.qg();
    }

    private boolean qg(View view) {
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
            if (qg(viewGroup.getChildAt(i))) {
                return true;
            }
            i++;
        }
    }

    private boolean rv() {
        if (this.n == null || tj() || !pk.s(this.n)) {
            return false;
        }
        if (this.w == 0) {
            this.w = w.d(this.n);
        }
        l();
        x();
        w();
        if (this.w == 5 && cp() && x() && !l() && !w()) {
            return false;
        }
        int i = this.w;
        return i == 1 || i == 2 || i == 5;
    }

    private boolean tj() {
        return this.fs;
    }

    public boolean l() {
        x xVar = this.x;
        if (xVar == null) {
            return false;
        }
        return xVar.n();
    }

    public boolean w() {
        x xVar = this.x;
        if (xVar == null) {
            return false;
        }
        return xVar.qg();
    }

    public boolean x() {
        if (this.n == null) {
            return true;
        }
        int iL = rv.qg().l(w.cy(this.n));
        if (iL == 1) {
            return hd.q(this.qg);
        }
        if (iL == 2) {
            return hd.l(this.qg) || hd.q(this.qg) || hd.w(this.qg);
        }
        if (iL != 3) {
            return iL != 5 || hd.q(this.qg) || hd.w(this.qg);
        }
        return false;
    }

    private boolean cp() {
        return this.n != null && this.n.il() == 1 && pk.s(this.n);
    }
}
