package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 672})
public final class gz implements Closeable {
    public final gz aj;
    public final yb c;
    public final nl fw;
    public volatile x g;
    public final int hn;
    public final rc hw;
    public final long k;
    public String m;
    public final b pr;
    public final lb uc;
    public final gz vk;
    public final long w;
    public final String x;
    public final gz zo;

    public gz(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc.pr();
        this.fw = prVar.fw;
        this.zo = prVar.zo;
        this.aj = prVar.aj;
        this.vk = prVar.vk;
        this.w = prVar.w;
        this.k = prVar.k;
        this.m = prVar.m;
    }

    public String pr() {
        return this.m;
    }

    public void pr(String str) {
        this.m = str;
    }

    public b hw() {
        return this.pr;
    }

    public rc hn() {
        return this.hw;
    }

    public int x() {
        return this.hn;
    }

    public boolean c() {
        int i = this.hn;
        return i >= 200 && i < 300;
    }

    public String uc() {
        return this.x;
    }

    public yb fw() {
        return this.c;
    }

    public String hw(String str) {
        return pr(str, null);
    }

    public String pr(String str, String str2) {
        String strPr = this.uc.pr(str);
        return strPr != null ? strPr : str2;
    }

    public lb zo() {
        return this.uc;
    }

    public nl aj() {
        return this.fw;
    }

    public pr vk() {
        return new pr(this);
    }

    public gz w() {
        return this.zo;
    }

    public gz k() {
        return this.vk;
    }

    public x m() {
        x xVar = this.g;
        if (xVar != null) {
            return xVar;
        }
        x xVarPr = x.pr(this.uc);
        this.g = xVarPr;
        return xVarPr;
    }

    public long g() {
        return this.w;
    }

    public long ho() {
        return this.k;
    }

    public ve nt() {
        b bVar = this.pr;
        if (bVar == null) {
            return null;
        }
        return bVar.uc;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        nl nlVar = this.fw;
        if (nlVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        nlVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.hw + ", code=" + this.hn + ", message=" + this.x + ", url=" + this.pr.pr() + AbstractJsonLexerKt.END_OBJ;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 1418})
    public static class pr {
        public gz aj;
        public yb c;
        public nl fw;
        public int hn;
        public rc hw;
        public long k;
        public String m;
        public b pr;
        public lb.pr uc;
        public gz vk;
        public long w;
        public String x;
        public gz zo;

        public pr() {
            this.hn = -1;
            this.uc = new lb.pr();
        }

        public pr(gz gzVar) {
            this.hn = -1;
            this.pr = gzVar.pr;
            this.hw = gzVar.hw;
            this.hn = gzVar.hn;
            this.x = gzVar.x;
            this.c = gzVar.c;
            this.uc = gzVar.uc.hw();
            this.fw = gzVar.fw;
            this.zo = gzVar.zo;
            this.aj = gzVar.aj;
            this.vk = gzVar.vk;
            this.w = gzVar.w;
            this.k = gzVar.k;
            this.m = gzVar.m;
        }

        public pr pr(b bVar) {
            this.pr = bVar;
            return this;
        }

        public pr pr(rc rcVar) {
            this.hw = rcVar;
            return this;
        }

        public pr pr(int i) {
            this.hn = i;
            return this;
        }

        public pr pr(String str) {
            this.x = str;
            return this;
        }

        public pr pr(yb ybVar) {
            this.c = ybVar;
            return this;
        }

        public pr pr(String str, String str2) {
            this.uc.pr(str, str2);
            return this;
        }

        public pr pr(lb lbVar) {
            this.uc = lbVar.hw();
            return this;
        }

        public pr pr(nl nlVar) {
            this.fw = nlVar;
            return this;
        }

        public pr pr(gz gzVar) {
            if (gzVar != null) {
                pr("networkResponse", gzVar);
            }
            this.zo = gzVar;
            return this;
        }

        public pr hw(gz gzVar) {
            if (gzVar != null) {
                pr("cacheResponse", gzVar);
            }
            this.aj = gzVar;
            return this;
        }

        private void pr(String str, gz gzVar) {
            if (gzVar.fw != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (gzVar.zo != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (gzVar.aj != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (gzVar.vk != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public pr hn(gz gzVar) {
            if (gzVar != null) {
                x(gzVar);
            }
            this.vk = gzVar;
            return this;
        }

        private void x(gz gzVar) {
            if (gzVar.fw != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public pr pr(long j) {
            this.w = j;
            return this;
        }

        public pr hw(long j) {
            this.k = j;
            return this;
        }

        public gz pr() {
            if (this.pr == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.hw == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.hn < 0) {
                throw new IllegalStateException("code < 0: " + this.hn);
            }
            if (this.x == null) {
                throw new IllegalStateException("message == null");
            }
            return new gz(this);
        }
    }
}
