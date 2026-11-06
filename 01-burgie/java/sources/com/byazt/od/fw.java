package com.byazt.od;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 62})
@com.byazt.qa.hw
public class fw implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "is_click_button")
    public volatile boolean aj;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_status_listener")
    public DownloadStatusChangeListener c;

    @com.byazt.qa.pr(hw = "ALL", pr = "pip_controller")
    public com.byazt.ga.hw g;

    @com.byazt.qa.pr(hw = "ALL", pr = "enable_update_download_model")
    public boolean ho;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "app")
    public JSONObject k;

    @com.byazt.qa.pr(hw = "ALL", pr = "dialog_to_landing_page_convert")
    public com.byazt.ni.pr m;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_popup_manager")
    public com.byazt.wr.hn uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_url")
    public String vk;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_conf")
    public JSONObject w;

    @com.byazt.qa.pr(hw = "ALL", pr = "event_tag")
    public String x;

    @com.byazt.qa.pr(hw = "ALL", pr = "is_open_market_intercept_for_dsp")
    public volatile boolean zo;

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_from_landing_page")
    public volatile boolean hn = false;

    @com.byazt.qa.pr(hw = "ALL", pr = "need_check_compliance")
    public int fw = 0;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        if (!pr()) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        int iX = com.byazt.ye.pr.x(map2);
        com.byazt.ye.x xVar = new com.byazt.ye.x(this.pr, this.hw, this.x, this.uc, this.vk, this.ho, map2, false);
        xVar.hw(this.aj);
        xVar.pr(this.zo, iX);
        xVar.pr(this.c);
        xVar.pr(this.hn);
        xVar.pr(this.fw);
        xVar.pr(this.m);
        xVar.pr(new qa(this.w));
        if (new com.byazt.ov.hw(xVar, this.g).pr(map2)) {
            prVar.pr(map2);
        } else {
            prVar.pr(map2, (com.byazt.rs.pr) null);
        }
        return true;
    }

    private boolean pr() {
        if (this.pr == null || this.hw == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.vk)) {
            com.byazt.hg.c cVarHw = com.byazt.sd.pr.hw(this.k);
            if (cVarHw != null) {
                this.vk = cVarHw.hw();
            }
            if (TextUtils.isEmpty(this.vk)) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.x) || this.uc == null) ? false : true;
    }
}
