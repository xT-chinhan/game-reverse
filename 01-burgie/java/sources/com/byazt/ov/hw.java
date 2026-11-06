package com.byazt.ov;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 13})
public class hw implements com.byazt.ni.pr {
    public com.byazt.ni.pr hw;
    public com.byazt.ga.hw pr;

    public hw(com.byazt.ni.pr prVar, com.byazt.ga.hw hwVar) {
        this.hw = prVar;
        this.pr = hwVar;
    }

    public hw(com.byazt.ga.hw hwVar) {
        this.pr = hwVar;
    }

    @Override // com.byazt.ni.pr
    public boolean pr(Map<String, Object> map) {
        com.byazt.ga.hw hwVar = this.pr;
        if (hwVar == null) {
            return this.hw.pr(map);
        }
        if (hwVar.pr()) {
            return true;
        }
        com.byazt.ni.pr prVar = this.hw;
        if (prVar == null) {
            return false;
        }
        return prVar.pr(map);
    }
}
