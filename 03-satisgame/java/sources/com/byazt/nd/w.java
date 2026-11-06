package com.byazt.nd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 13})
public class w {
    public final s n;
    public final List<qg> qg;
    public final n s;

    @com.byazt.cp.n(n = {0, 1, 674, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME})
    static final class s {
        public final String n;
        public final String qg;
        public final String s;

        public String toString() {
            return "RequestLine{method='" + this.n + "', path='" + this.qg + "', version='" + this.s + "'}";
        }
    }

    @com.byazt.cp.n(n = {0, 1, 674, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    public static final class qg {
        public final String n;
        public final String qg;

        public qg(String str, String str2) {
            this.n = str;
            this.qg = str2;
        }

        public String toString() {
            return "Header{name='" + this.n + "', value='" + this.qg + "'}";
        }
    }

    @com.byazt.cp.n(n = {0, 1, 674, 108})
    static final class n {
        public final int l;
        public final int n;
        public final int q;
        public final String qg;
        public final String s;
        public final List<String> w;

        public String toString() {
            return "Extra{flag=" + this.n + ", rawKey='" + this.qg + "', key='" + this.s + "', from=" + this.q + ", to=" + this.l + ", urls=" + this.w + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public String toString() {
        return "Request{requestLine=" + this.n + ", headers=" + this.qg + ", extra=" + this.s + AbstractJsonLexerKt.END_OBJ;
    }
}
