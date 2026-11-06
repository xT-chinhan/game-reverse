package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 878})
public final class h {
    public volatile q fs;
    public final Object l;
    public final um n;
    public final t q;
    public final String qg;
    public final cd s;
    public final String w;
    public ur x;

    public h(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s.n();
        this.q = nVar.q;
        this.l = nVar.l != null ? nVar.l : this;
        this.w = nVar.w;
        if (nVar.x != null) {
            this.x = nVar.x;
        } else {
            this.x = new ur();
        }
    }

    public um n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public cd s() {
        return this.s;
    }

    public String n(String str) {
        return this.s.n(str);
    }

    public t q() {
        return this.q;
    }

    public Object l() {
        return this.l;
    }

    public String w() {
        return this.w;
    }

    public n x() {
        return new n(this);
    }

    public q fs() {
        q qVar = this.fs;
        if (qVar != null) {
            return qVar;
        }
        q qVarN = q.n(this.s);
        this.fs = qVarN;
        return qVarN;
    }

    public boolean rv() {
        return this.n.s();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Request{method=").append(this.qg).append(", url=").append(this.n).append(", tag=");
        Object obj = this.l;
        if (obj == this) {
            obj = null;
        }
        return sbAppend.append(obj).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    @com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME})
    public static class n {
        public Object l;
        public um n;
        public t q;
        public String qg;
        public cd.n s;
        public String w;
        public ur x;

        public n() {
            this.qg = TapHttp.METHOD_GET;
            this.s = new cd.n();
        }

        public n(h hVar) {
            this.n = hVar.n;
            this.qg = hVar.qg;
            this.q = hVar.q;
            this.l = hVar.l;
            this.w = hVar.w;
            this.s = hVar.s.qg();
            this.x = hVar.x;
        }

        public n n(um umVar) {
            if (umVar == null) {
                throw new NullPointerException("url == null");
            }
            this.n = umVar;
            return this;
        }

        public n n(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            um umVarL = um.l(str);
            if (umVarL == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return n(umVarL);
        }

        public n n(String str, String str2) {
            this.s.s(str, str2);
            return this;
        }

        public n qg(String str) {
            this.s.qg(str);
            return this;
        }

        public n n(cd cdVar) {
            this.s = cdVar.qg();
            return this;
        }

        public n n(q qVar) {
            String string = qVar.toString();
            return string.isEmpty() ? qg("Cache-Control") : n("Cache-Control", string);
        }

        public n n(t tVar) {
            return n(TapHttp.METHOD_POST, tVar);
        }

        public n delete(t tVar) {
            return n("DELETE", tVar);
        }

        public n delete() {
            return delete(com.byazt.zho.s.q);
        }

        public n n(String str, t tVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (tVar != null && !com.byazt.cri.w.s(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (tVar == null && com.byazt.cri.w.qg(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.qg = str;
            this.q = tVar;
            return this;
        }

        public n n(Object obj) {
            this.l = obj;
            return this;
        }

        public n s(String str) {
            this.w = str;
            return this;
        }

        public h n() {
            if (this.n == null) {
                throw new IllegalStateException("url == null");
            }
            return new h(this);
        }
    }
}
