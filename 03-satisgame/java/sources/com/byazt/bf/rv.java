package com.byazt.bf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends q {
    public long fs;
    public long w;
    public String x;

    public rv(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        super(str, str2, str3, str4, i);
        this.fs = 0L;
        this.w = 0L;
        try {
            this.w = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.x = str6;
    }

    public rv(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i, str5, str6);
        this.fs = 0L;
        try {
            this.fs = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }

    public void n(long j) {
        this.fs = j;
    }

    public long rv() {
        return this.w;
    }

    public String tj() {
        return this.x;
    }

    public long cp() {
        return this.fs;
    }

    public boolean d() {
        return this.fs != 0;
    }

    @Override // com.byazt.bf.q
    public boolean fs() {
        return (TextUtils.isEmpty(this.x) || this.w == 0) ? false : true;
    }

    @Override // com.byazt.bf.q
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.n + "', showRulesVersion='" + this.s + "', timingMode=" + this.l + "}IntervalPacingBean{pacing=" + this.w + ", pacingRuleId='" + this.x + "', effectiveTime=" + this.fs + AbstractJsonLexerKt.END_OBJ;
    }
}
