package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public final class b {
    public final Object c;
    public volatile x fw;
    public final lb hn;
    public final String hw;
    public final qa pr;
    public ve uc;
    public final iu x;

    public b(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn.pr();
        this.x = prVar.x;
        this.c = prVar.c != null ? prVar.c : this;
        if (prVar.uc != null) {
            this.uc = prVar.uc;
        } else {
            this.uc = new ve();
        }
    }

    public qa pr() {
        return this.pr;
    }

    public String hw() {
        return this.hw;
    }

    public lb hn() {
        return this.hn;
    }

    public String pr(String str) {
        return this.hn.pr(str);
    }

    public iu x() {
        return this.x;
    }

    public Object c() {
        return this.c;
    }

    public pr uc() {
        return new pr(this);
    }

    public x fw() {
        x xVar = this.fw;
        if (xVar != null) {
            return xVar;
        }
        x xVarPr = x.pr(this.hn);
        this.fw = xVarPr;
        return xVarPr;
    }

    public boolean zo() {
        return this.pr.hn();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Request{method=").append(this.hw).append(", url=").append(this.pr).append(", tag=");
        Object obj = this.c;
        if (obj == this) {
            obj = null;
        }
        return sbAppend.append(obj).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS})
    public static class pr {
        public Object c;
        public lb.pr hn;
        public String hw;
        public qa pr;
        public ve uc;
        public iu x;

        public pr() {
            this.hw = TapHttp.METHOD_GET;
            this.hn = new lb.pr();
        }

        public pr(b bVar) {
            this.pr = bVar.pr;
            this.hw = bVar.hw;
            this.x = bVar.x;
            this.c = bVar.c;
            this.hn = bVar.hn.hw();
            this.uc = bVar.uc;
        }

        public pr pr(qa qaVar) {
            if (qaVar == null) {
                throw new NullPointerException("url == null");
            }
            this.pr = qaVar;
            return this;
        }

        public pr pr(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            qa qaVarC = qa.c(str);
            if (qaVarC == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return pr(qaVarC);
        }

        public pr pr(String str, String str2) {
            this.hn.hn(str, str2);
            return this;
        }

        public pr hw(String str) {
            this.hn.hw(str);
            return this;
        }

        public pr pr(lb lbVar) {
            this.hn = lbVar.hw();
            return this;
        }

        public pr pr(x xVar) {
            String string = xVar.toString();
            return string.isEmpty() ? hw("Cache-Control") : pr("Cache-Control", string);
        }

        public pr pr(iu iuVar) {
            return pr(TapHttp.METHOD_POST, iuVar);
        }

        public pr delete(iu iuVar) {
            return pr("DELETE", iuVar);
        }

        public pr delete() {
            return delete(com.byazt.xx.hn.x);
        }

        public pr pr(String str, iu iuVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (iuVar != null && !com.byazt.osx.uc.hn(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (iuVar == null && com.byazt.osx.uc.hw(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.hw = str;
            this.x = iuVar;
            return this;
        }

        public pr pr(Object obj) {
            this.c = obj;
            return this;
        }

        public b pr() {
            if (this.pr == null) {
                throw new IllegalStateException("url == null");
            }
            return new b(this);
        }
    }
}
