package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 5})
public class uc {
    public final pr hn;
    public final List<hw> hw;
    public final hn pr;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE})
    static final class hn {
        public final String hn;
        public final String hw;
        public final String pr;

        public String toString() {
            return "RequestLine{method='" + this.pr + "', path='" + this.hw + "', version='" + this.hn + '\'' + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    public static final class hw {
        public final String hw;
        public final String pr;

        public hw(String str, String str2) {
            this.pr = str;
            this.hw = str2;
        }

        public String toString() {
            return "Header{name='" + this.pr + "', value='" + this.hw + '\'' + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 129})
    static final class pr {
        public final int c;
        public final String hn;
        public final String hw;
        public final int pr;
        public final List<String> uc;
        public final int x;

        public String toString() {
            return "Extra{flag=" + this.pr + ", rawKey='" + this.hw + "', key='" + this.hn + "', from=" + this.x + ", to=" + this.c + ", urls=" + this.uc + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public String toString() {
        return "Request{requestLine=" + this.pr + ", headers=" + this.hw + ", extra=" + this.hn + AbstractJsonLexerKt.END_OBJ;
    }
}
