package com.bytedance.sdk.component.ah.xr;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Closeable {
    public abstract com.bytedance.sdk.component.ah.ms.ka ah();

    public abstract nw ms();

    public abstract long xr();

    public final InputStream d() {
        return ah().c();
    }

    public final byte[] ka() throws IOException {
        long jXr = xr();
        if (jXr > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jXr)));
        }
        com.bytedance.sdk.component.ah.ms.ka kaVarAh = ah();
        try {
            byte[] bArrH = kaVarAh.h();
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(kaVarAh);
            if (jXr == -1 || jXr == bArrH.length) {
                return bArrH;
            }
            throw new IOException("Content-Length (" + jXr + ") and stream length (" + bArrH.length + ") disagree");
        } catch (Throwable th) {
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(kaVarAh);
            throw th;
        }
    }

    public final String c() throws IOException {
        com.bytedance.sdk.component.ah.ms.ka kaVarAh = ah();
        try {
            return kaVarAh.ms(com.bytedance.sdk.component.ah.xr.ms.ah.ms(kaVarAh, ab()));
        } catch (OutOfMemoryError unused) {
            return null;
        } finally {
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(kaVarAh);
        }
    }

    private Charset ab() {
        nw nwVarMs = ms();
        return nwVarMs != null ? nwVarMs.ms(com.bytedance.sdk.component.ah.xr.ms.ah.ka) : com.bytedance.sdk.component.ah.xr.ms.ah.ka;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.ah.xr.ms.ah.ms(ah());
    }

    public static g ms(nw nwVar, byte[] bArr) {
        return ms(nwVar, bArr.length, new com.bytedance.sdk.component.ah.ms.ah().ah(bArr));
    }

    public static g ms(final nw nwVar, final long j, final com.bytedance.sdk.component.ah.ms.ka kaVar) {
        if (kaVar == null) {
            throw new NullPointerException("source == null");
        }
        return new g() { // from class: com.bytedance.sdk.component.ah.xr.g.1
            @Override // com.bytedance.sdk.component.ah.xr.g
            public nw ms() {
                return nwVar;
            }

            @Override // com.bytedance.sdk.component.ah.xr.g
            public long xr() {
                return j;
            }

            @Override // com.bytedance.sdk.component.ah.xr.g
            public com.bytedance.sdk.component.ah.ms.ka ah() {
                return kaVar;
            }
        };
    }
}
