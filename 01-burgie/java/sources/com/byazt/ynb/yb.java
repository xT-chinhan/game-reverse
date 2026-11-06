package com.byazt.ynb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb implements hn {
    public final com.byazt.eqw.zo hn;
    public final int hw;
    public final String pr;
    public final boolean x;

    public yb(String str, int i, com.byazt.eqw.zo zoVar, boolean z) {
        this.pr = str;
        this.hw = i;
        this.hn = zoVar;
        this.x = z;
    }

    public String pr() {
        return this.pr;
    }

    public com.byazt.eqw.zo hw() {
        return this.hn;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.lb(zoVar, hnVar, this);
    }

    public boolean hn() {
        return this.x;
    }

    public String toString() {
        return "ShapePath{name=" + this.pr + ", index=" + this.hw + AbstractJsonLexerKt.END_OBJ;
    }
}
