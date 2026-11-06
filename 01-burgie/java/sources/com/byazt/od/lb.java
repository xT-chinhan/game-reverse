package com.byazt.od;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO, 48})
@com.byazt.qa.hw
public class lb implements com.byazt.lf.hn {

    @com.byazt.qa.pr(hw = "ALL", pr = "reward_dialog_callback")
    public com.byazt.wv.vk pr;

    @Override // com.byazt.lf.hn
    public boolean pr(Map<String, Object> map, Map<String, Object> map2, com.byazt.hws.pr prVar) {
        com.byazt.wv.vk vkVar = this.pr;
        if (vkVar == null) {
            prVar.pr(map2, (com.byazt.rs.pr) null);
            return true;
        }
        vkVar.pr();
        prVar.pr(map2);
        return true;
    }
}
