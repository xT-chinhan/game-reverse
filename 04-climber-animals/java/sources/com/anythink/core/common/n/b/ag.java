package com.anythink.core.common.n.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class ag implements Closeable {
    private Reader a;

    public abstract x a();

    public abstract long b();

    public abstract com.anythink.core.common.n.c.e c();

    private InputStream e() {
        return c().i();
    }

    private byte[] f() throws IOException {
        long jB = b();
        if (jB > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jB)));
        }
        com.anythink.core.common.n.c.e eVarC = c();
        try {
            byte[] bArrY = eVarC.y();
            if (eVarC != null) {
                eVarC.close();
            }
            if (jB == -1 || jB == bArrY.length) {
                return bArrY;
            }
            throw new IOException("Content-Length (" + jB + ") and stream length (" + bArrY.length + ") disagree");
        } catch (Throwable th) {
            if (eVarC != null) {
                try {
                    eVarC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private Reader g() {
        Reader reader = this.a;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(c(), h());
        this.a = aVar;
        return aVar;
    }

    public final String d() {
        com.anythink.core.common.n.c.e eVarC = c();
        try {
            String strA = eVarC.a(com.anythink.core.common.n.b.a.c.a(eVarC, h()));
            if (eVarC != null) {
                eVarC.close();
            }
            return strA;
        } catch (Throwable th) {
            if (eVarC != null) {
                try {
                    eVarC.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private Charset h() {
        x xVarA = a();
        return xVarA != null ? xVarA.a(StandardCharsets.UTF_8) : StandardCharsets.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.anythink.core.common.n.b.a.c.a(c());
    }

    private static ag a(x xVar, String str) {
        Charset charsetA = StandardCharsets.UTF_8;
        if (xVar != null && (charsetA = xVar.a((Charset) null)) == null) {
            charsetA = StandardCharsets.UTF_8;
            xVar = x.b(xVar + "; charset=utf-8");
        }
        com.anythink.core.common.n.c.c cVarB = new com.anythink.core.common.n.c.c().b(str, charsetA);
        return a(xVar, cVarB.b(), cVarB);
    }

    public static ag a(x xVar, byte[] bArr) {
        return a(xVar, bArr.length, new com.anythink.core.common.n.c.c().d(bArr));
    }

    private static ag a(x xVar, com.anythink.core.common.n.c.f fVar) {
        return a(xVar, fVar.j(), new com.anythink.core.common.n.c.c().d(fVar));
    }

    public static ag a(final x xVar, final long j, final com.anythink.core.common.n.c.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ag() { // from class: com.anythink.core.common.n.b.ag.1
            @Override // com.anythink.core.common.n.b.ag
            public final x a() {
                return xVar;
            }

            @Override // com.anythink.core.common.n.b.ag
            public final long b() {
                return j;
            }

            @Override // com.anythink.core.common.n.b.ag
            public final com.anythink.core.common.n.c.e c() {
                return eVar;
            }
        };
    }

    static final class a extends Reader {
        private final com.anythink.core.common.n.c.e a;
        private final Charset b;
        private boolean c;
        private Reader d;

        a(com.anythink.core.common.n.c.e eVar, Charset charset) {
            this.a = eVar;
            this.b = charset;
        }

        @Override // java.io.Reader
        public final int read(char[] cArr, int i, int i2) throws IOException {
            if (this.c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.a.i(), com.anythink.core.common.n.b.a.c.a(this.a, this.b));
                this.d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            this.c = true;
            Reader reader = this.d;
            if (reader != null) {
                reader.close();
            } else {
                this.a.close();
            }
        }
    }
}
