package com.byazt.bf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 19})
public class n {
    public String n;
    public String q;
    public String qg;
    public long s;

    public n(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public n(String str, String str2, long j, String str3) {
        this.n = str2;
        this.qg = str;
        this.s = j;
        this.q = str3;
    }

    public long n() {
        return this.s;
    }

    public String qg() {
        return this.q;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.n + "', adnName='" + this.qg + "', effectiveTime=" + this.s + AbstractJsonLexerKt.END_OBJ;
    }
}
