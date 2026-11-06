package com.byazt.bf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 26})
public class qg {
    public List<String> n;
    public List<String> qg;
    public long s;

    public long n() {
        return this.s;
    }

    public void n(long j) {
        this.s = j;
    }

    public List<String> qg() {
        return this.n;
    }

    public void n(List<String> list) {
        this.n = list;
    }

    public List<String> s() {
        return this.qg;
    }

    public void qg(List<String> list) {
        this.qg = list;
    }

    public String toString() {
        return "AdnLoadFailShowConfigBean{ breadRequestErrorCode=" + this.n + ",ritList=" + this.qg + ",breadRequestDuration=" + this.s + " }";
    }
}
