package com.byazt.od;

import android.content.Context;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 250})
@com.byazt.qa.hw
public class k implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "wc_miniapp_info")
    public JSONObject c;

    @com.byazt.qa.pr(hw = "ALL", pr = "convert_from_landing_page")
    public boolean hn;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "landing_page_source")
    public int uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "event_tag")
    public String x;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        if (!pr()) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        if (new com.byazt.ye.zo(this.pr, this.hw, this.hn, this.x, map2, prVar, this.uc, false).pr(new HashMap())) {
            prVar.pr(map2);
        } else {
            prVar.pr(map2, (com.byazt.rs.pr) null);
        }
        return true;
    }

    private boolean pr() {
        return (this.pr == null || this.hw == null || this.c == null) ? false : true;
    }
}
