package com.byazt.od;

import android.content.Context;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
@com.byazt.qa.hw
public class zo implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "is_show_download_dialog")
    public boolean aj = true;

    @com.byazt.qa.pr(hw = "ALL", pr = "app_manage_model")
    public com.byazt.hg.x c;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_url")
    public String fw;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of hn;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "is_direct_download")
    public boolean k;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_dialog_listener")
    public com.byazt.rx.pr m;

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_from_landing_page")
    public boolean pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "event_tag")
    public String uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "is_from_new_click_event")
    public boolean vk;

    @com.byazt.qa.pr(hw = "ALL", pr = "dynamic_download_dialog_type")
    public int w;

    @com.byazt.qa.pr(hw = "ALL", pr = "is_app_market_convert")
    public boolean x;

    @com.byazt.qa.pr(hw = "ALL", pr = "start_download_listener")
    public com.byazt.rx.hw zo;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.wr.hn hnVar = new com.byazt.wr.hn(this.hw, this.hn);
        hnVar.hn(this.k);
        hnVar.pr(this.aj);
        hnVar.pr(this.w);
        hnVar.hw(this.vk);
        hnVar.pr(this.m);
        hnVar.pr(pr());
        if (!hnVar.x(false)) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        hnVar.pr(this.c, this.uc, this.fw, this.zo);
        prVar.pr(map2);
        return true;
    }

    private com.byazt.wr.pr pr() {
        if (this.x) {
            return new com.byazt.wr.c();
        }
        if (this.pr) {
            return new com.byazt.wr.x();
        }
        return new com.byazt.wr.hw();
    }
}
