package com.byazt.bf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 5})
public abstract class q {
    public int l;
    public String n;
    public String q;
    public String qg;
    public String s;
    public boolean w;

    public boolean n() {
        return this.w;
    }

    public String qg() {
        return this.n;
    }

    public String s() {
        return this.qg;
    }

    public String q() {
        return TextUtils.isEmpty(this.qg) ? this.n : this.n + "_" + this.qg;
    }

    public String l() {
        return this.s;
    }

    public String w() {
        return this.q;
    }

    public int x() {
        return this.l;
    }

    public q(String str, String str2, String str3, String str4, int i) {
        this.n = str;
        this.s = str3;
        this.l = i;
        this.qg = str2;
        this.w = !TextUtils.isEmpty(str2);
        this.q = str4;
    }

    public boolean fs() {
        return this.l == 1;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.n + "', showRulesVersion='" + this.s + "', timingMode=" + this.l + AbstractJsonLexerKt.END_OBJ;
    }
}
