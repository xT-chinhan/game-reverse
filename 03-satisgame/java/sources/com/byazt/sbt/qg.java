package com.byazt.sbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 26})
public class qg implements d {
    public final String n;

    @Override // com.byazt.sbt.d
    public boolean n(com.byazt.fi.n.C0175n c0175n, Map<String, Object> map) {
        return c0175n != null;
    }

    public qg(String str) {
        this.n = str;
    }

    @Override // com.byazt.sbt.d
    public String n() {
        return this.n;
    }
}
