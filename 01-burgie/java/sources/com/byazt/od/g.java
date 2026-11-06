package com.byazt.od;

import android.content.Context;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
@com.byazt.qa.hw
public class g implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = d.R)
    public Context hw;

    @com.byazt.qa.pr(hw = "ALL", pr = "material_meta")
    public of pr;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        Context context;
        of ofVar = this.pr;
        if (ofVar == null || (context = this.hw) == null) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        com.byazt.wt.c.pr(context, ofVar);
        prVar.pr(map2);
        return true;
    }
}
