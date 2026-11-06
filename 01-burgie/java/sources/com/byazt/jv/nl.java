package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 574})
public abstract class nl implements Closeable {
    public abstract com.byazt.du.c hn();

    public abstract long hw();

    public abstract cz pr();

    public final InputStream x() {
        return hn().uc();
    }

    public final byte[] c() throws IOException {
        long jHw = hw();
        if (jHw > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jHw)));
        }
        com.byazt.du.c cVarHn = hn();
        try {
            byte[] bArrYb = cVarHn.yb();
            com.byazt.xx.hn.pr(cVarHn);
            if (jHw != -1 && jHw != bArrYb.length) {
                throw new IOException("Content-Length (" + jHw + ") and stream length (" + bArrYb.length + ") disagree");
            }
            return bArrYb;
        } catch (Throwable th) {
            com.byazt.xx.hn.pr(cVarHn);
            throw th;
        }
    }

    public final String uc() throws IOException {
        com.byazt.du.c cVarHn = hn();
        try {
            return cVarHn.pr(com.byazt.xx.hn.pr(cVarHn, fw()));
        } catch (OutOfMemoryError e) {
            return null;
        } finally {
            com.byazt.xx.hn.pr(cVarHn);
        }
    }

    private Charset fw() {
        cz czVarPr = pr();
        return czVarPr != null ? czVarPr.pr(com.byazt.xx.hn.c) : com.byazt.xx.hn.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.byazt.xx.hn.pr(hn());
    }

    public static nl pr(cz czVar, byte[] bArr) {
        return pr(czVar, bArr.length, new com.byazt.du.hn().hn(bArr));
    }

    public static nl pr(final cz czVar, final long j, final com.byazt.du.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("source == null");
        }
        return new nl() { // from class: com.byazt.jv.nl.1
            @Override // com.byazt.jv.nl
            public cz pr() {
                return czVar;
            }

            @Override // com.byazt.jv.nl
            public long hw() {
                return j;
            }

            @Override // com.byazt.jv.nl
            public com.byazt.du.c hn() {
                return cVar;
            }
        };
    }
}
