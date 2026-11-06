package com.byazt.od;

import android.content.Context;
import android.view.View;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 109})
@com.byazt.qa.hw
public class w implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "live_saas_interaction_type")
    public int c = -1;

    @com.byazt.qa.pr(hw = "ALL", pr = "handle_chain_data")
    public Map<String, Object> fw;

    @com.byazt.qa.pr(hw = "ALL", pr = "event_tag")
    public String hn;

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of pr;

    @com.byazt.qa.pr(hw = "ALL", pr = "view")
    public View uc;

    @com.byazt.qa.pr(hw = "ALL", pr = "dpa_tag")
    public String x;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        int iHn;
        if (!pr()) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        if (this.pr.ll() != -1001) {
            iHn = this.pr.ll();
        } else {
            iHn = com.byazt.eg.hw.pr().hn();
            this.pr.jw(iHn);
        }
        map2.put("saas_status_while_click", Integer.valueOf(iHn));
        com.byazt.ye.uc ucVar = new com.byazt.ye.uc(this.pr, this.hw, this.hn, this.x, map2);
        int i = this.c;
        if (i != -1) {
            ucVar.hw(i);
        }
        ucVar.pr(this.uc);
        ucVar.hw(this.fw);
        if (new com.byazt.ye.hw(new com.byazt.ye.c(ucVar, this.pr, prVar, map2, this.hn), this.hw, this.pr, this.hn, map2, prVar).pr(new HashMap())) {
            prVar.pr(map2);
            return false;
        }
        prVar.pr(map2, (com.byazt.rs.pr) null);
        return false;
    }

    private boolean pr() {
        return (this.pr == null || this.hw == null) ? false : true;
    }
}
