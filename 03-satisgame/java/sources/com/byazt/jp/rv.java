package com.byazt.jp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public double n;
    public double qg;

    public rv(double d, double d2) {
        this.n = d;
        this.qg = d2;
    }

    public double n() {
        return this.n;
    }

    public double qg() {
        return this.qg;
    }

    public String toString() {
        return "GMLocation{lantitude=" + this.n + ", longtitude=" + this.qg + AbstractJsonLexerKt.END_OBJ;
    }
}
