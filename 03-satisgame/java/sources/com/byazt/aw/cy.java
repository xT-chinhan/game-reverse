package com.byazt.aw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements s {
    public final String n;
    public final List<s> qg;
    public final boolean s;

    public cy(String str, List<s> list, boolean z) {
        this.n = str;
        this.qg = list;
        this.s = z;
    }

    public String n() {
        return this.n;
    }

    public List<s> qg() {
        return this.qg;
    }

    public boolean s() {
        return this.s;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.q(fsVar, sVar, this, wVar);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.n + "' Shapes: " + Arrays.toString(this.qg.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
