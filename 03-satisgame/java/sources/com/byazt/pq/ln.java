package com.byazt.pq;

import androidx.core.view.PointerIconCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, PointerIconCompat.TYPE_ZOOM_IN})
public abstract class ln implements Closeable {
    public abstract py n();

    public abstract long qg();

    public abstract com.byazt.wa.l s();

    public final InputStream q() {
        return s().w();
    }

    public final byte[] l() throws IOException {
        long jQg = qg();
        if (jQg > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jQg)));
        }
        com.byazt.wa.l lVarS = s();
        try {
            byte[] bArrHd = lVarS.hd();
            com.byazt.zho.s.n(lVarS);
            if (jQg == -1 || jQg == bArrHd.length) {
                return bArrHd;
            }
            throw new IOException("Content-Length (" + jQg + ") and stream length (" + bArrHd.length + ") disagree");
        } catch (Throwable th) {
            com.byazt.zho.s.n(lVarS);
            throw th;
        }
    }

    public final String w() throws IOException {
        com.byazt.wa.l lVarS = s();
        try {
            return lVarS.n(com.byazt.zho.s.n(lVarS, x()));
        } catch (OutOfMemoryError unused) {
            return null;
        } finally {
            com.byazt.zho.s.n(lVarS);
        }
    }

    private Charset x() {
        py pyVarN = n();
        return pyVarN != null ? pyVarN.n(com.byazt.zho.s.l) : com.byazt.zho.s.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.byazt.zho.s.n(s());
    }

    public static ln n(py pyVar, byte[] bArr) {
        return n(pyVar, bArr.length, new com.byazt.wa.s().s(bArr));
    }

    public static ln n(final py pyVar, final long j, final com.byazt.wa.l lVar) {
        if (lVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ln() { // from class: com.byazt.pq.ln.1
            @Override // com.byazt.pq.ln
            public py n() {
                return pyVar;
            }

            @Override // com.byazt.pq.ln
            public long qg() {
                return j;
            }

            @Override // com.byazt.pq.ln
            public com.byazt.wa.l s() {
                return lVar;
            }
        };
    }
}
