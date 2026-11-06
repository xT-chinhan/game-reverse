package com.byazt.aw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements s {
    public final String n;
    public final n qg;
    public final boolean s;

    public enum n {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static n n(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i == 4) {
                return INTERSECT;
            }
            if (i == 5) {
                return EXCLUDE_INTERSECTIONS;
            }
            return MERGE;
        }
    }

    public rv(String str, n nVar, boolean z) {
        this.n = str;
        this.qg = nVar;
        this.s = z;
    }

    public String n() {
        return this.n;
    }

    public n qg() {
        return this.qg;
    }

    public boolean s() {
        return this.s;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.d(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.qg + AbstractJsonLexerKt.END_OBJ;
    }
}
