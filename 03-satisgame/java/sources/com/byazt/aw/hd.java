package com.byazt.aw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd implements s {
    public final String n;
    public final boolean q;
    public final int qg;
    public final com.byazt.ccr.fs s;

    public hd(String str, int i, com.byazt.ccr.fs fsVar, boolean z) {
        this.n = str;
        this.qg = i;
        this.s = fsVar;
        this.q = z;
    }

    public String n() {
        return this.n;
    }

    public com.byazt.ccr.fs qg() {
        return this.s;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.cd(fsVar, sVar, this);
    }

    public boolean s() {
        return this.q;
    }

    public String toString() {
        return "ShapePath{name=" + this.n + ", index=" + this.qg + AbstractJsonLexerKt.END_OBJ;
    }
}
