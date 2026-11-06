package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF})
public final class bb implements Closeable {
    public final long cp;
    public final long d;
    public final bb fs;
    public final hd l;
    public final h n;
    public String oa;
    public final String q;
    public final m qg;
    public final bb rv;
    public final int s;
    public volatile q sz;
    public final bb tj;
    public final cd w;
    public final ln x;

    public bb(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w.n();
        this.x = nVar.x;
        this.fs = nVar.fs;
        this.rv = nVar.rv;
        this.tj = nVar.tj;
        this.cp = nVar.cp;
        this.d = nVar.d;
        this.oa = nVar.oa;
    }

    public String n() {
        return this.oa;
    }

    public void n(String str) {
        this.oa = str;
    }

    public h qg() {
        return this.n;
    }

    public m s() {
        return this.qg;
    }

    public int q() {
        return this.s;
    }

    public boolean l() {
        int i = this.s;
        return i >= 200 && i < 300;
    }

    public String w() {
        return this.q;
    }

    public hd x() {
        return this.l;
    }

    public String qg(String str) {
        return n(str, null);
    }

    public String n(String str, String str2) {
        String strN = this.w.n(str);
        return strN != null ? strN : str2;
    }

    public cd fs() {
        return this.w;
    }

    public ln rv() {
        return this.x;
    }

    public n tj() {
        return new n(this);
    }

    public bb cp() {
        return this.fs;
    }

    public bb d() {
        return this.tj;
    }

    public q oa() {
        q qVar = this.sz;
        if (qVar != null) {
            return qVar;
        }
        q qVarN = q.n(this.w);
        this.sz = qVarN;
        return qVarN;
    }

    public long sz() {
        return this.cp;
    }

    public long k() {
        return this.d;
    }

    public ur cy() {
        h hVar = this.n;
        if (hVar == null) {
            return null;
        }
        return hVar.x;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ln lnVar = this.x;
        if (lnVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        lnVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.qg + ", code=" + this.s + ", message=" + this.q + ", url=" + this.n.n() + AbstractJsonLexerKt.END_OBJ;
    }

    @com.byazt.cp.n(n = {0, 1, 109, 1603})
    public static class n {
        public long cp;
        public long d;
        public bb fs;
        public hd l;
        public h n;
        public String oa;
        public String q;
        public m qg;
        public bb rv;
        public int s;
        public bb tj;
        public cd.n w;
        public ln x;

        public n() {
            this.s = -1;
            this.w = new cd.n();
        }

        public n(bb bbVar) {
            this.s = -1;
            this.n = bbVar.n;
            this.qg = bbVar.qg;
            this.s = bbVar.s;
            this.q = bbVar.q;
            this.l = bbVar.l;
            this.w = bbVar.w.qg();
            this.x = bbVar.x;
            this.fs = bbVar.fs;
            this.rv = bbVar.rv;
            this.tj = bbVar.tj;
            this.cp = bbVar.cp;
            this.d = bbVar.d;
            this.oa = bbVar.oa;
        }

        public n n(h hVar) {
            this.n = hVar;
            return this;
        }

        public n n(m mVar) {
            this.qg = mVar;
            return this;
        }

        public n n(int i) {
            this.s = i;
            return this;
        }

        public n n(String str) {
            this.q = str;
            return this;
        }

        public n n(hd hdVar) {
            this.l = hdVar;
            return this;
        }

        public n n(String str, String str2) {
            this.w.n(str, str2);
            return this;
        }

        public n n(cd cdVar) {
            this.w = cdVar.qg();
            return this;
        }

        public n n(ln lnVar) {
            this.x = lnVar;
            return this;
        }

        public n n(bb bbVar) {
            if (bbVar != null) {
                n("networkResponse", bbVar);
            }
            this.fs = bbVar;
            return this;
        }

        public n qg(bb bbVar) {
            if (bbVar != null) {
                n("cacheResponse", bbVar);
            }
            this.rv = bbVar;
            return this;
        }

        private void n(String str, bb bbVar) {
            if (bbVar.x != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (bbVar.fs != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (bbVar.rv != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (bbVar.tj != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public n s(bb bbVar) {
            if (bbVar != null) {
                q(bbVar);
            }
            this.tj = bbVar;
            return this;
        }

        private void q(bb bbVar) {
            if (bbVar.x != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public n n(long j) {
            this.cp = j;
            return this;
        }

        public n qg(long j) {
            this.d = j;
            return this;
        }

        public bb n() {
            if (this.n == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.qg == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.s < 0) {
                throw new IllegalStateException("code < 0: " + this.s);
            }
            if (this.q == null) {
                throw new IllegalStateException("message == null");
            }
            return new bb(this);
        }
    }
}
