package com.byazt.od;

import android.content.Context;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 108})
@com.byazt.qa.hw
public class m implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_tag")
    public String aj;

    @com.byazt.qa.pr(hw = "ALL", pr = "app_info")
    public JSONObject c;

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_from_downloader")
    public boolean fw;

    @com.byazt.qa.pr(hw = "ALL", pr = "event_tag")
    public String hn;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_from_landing_page")
    public boolean uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "pip_controller")
    public com.byazt.ga.hw vk;

    @com.byazt.qa.pr(hw = "ALL", pr = "is_click_button")
    public volatile boolean w;

    @com.byazt.qa.pr(hw = "ALL", pr = "deep_link")
    public JSONObject x;

    @com.byazt.qa.pr(hw = "ALL", pr = "download_adapter")
    public com.byazt.nv.hn zo;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.ye.fw fwVar = new com.byazt.ye.fw(com.byazt.sd.pr.hw(this.c), this.hw, this.pr, map2);
        fwVar.pr(this.hn);
        com.byazt.ye.hn hnVar = new com.byazt.ye.hn(fwVar, this.pr, this.hn, new com.byazt.hg.yb(this.x), this.hw, map2, false);
        hnVar.hw(this.fw);
        hnVar.pr(this.uc);
        hnVar.pr(this.zo);
        hnVar.pr(this.aj);
        hnVar.pr(this.vk);
        hnVar.hn(this.w);
        if (hnVar.pr(map2)) {
            prVar.pr(map2);
            return true;
        }
        prVar.pr(map2, (com.byazt.rs.pr) null);
        return true;
    }
}
