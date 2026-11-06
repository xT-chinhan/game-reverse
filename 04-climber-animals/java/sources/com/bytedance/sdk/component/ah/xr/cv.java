package com.bytedance.sdk.component.ah.xr;

import java.io.Closeable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class cv implements Closeable {
    final g ab;
    final int ah;
    final qv c;
    final cv ch;
    final String d;
    final long hi;
    final h ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final yu f1037ms;
    final cv ny;
    final long sl;
    final cv x;
    final i xr;
    private volatile d zb;

    cv(ms msVar) {
        this.f1037ms = msVar.f1038ms;
        this.xr = msVar.xr;
        this.ah = msVar.ah;
        this.d = msVar.d;
        this.ka = msVar.ka;
        this.c = msVar.c.ms();
        this.ab = msVar.ab;
        this.x = msVar.x;
        this.ny = msVar.ny;
        this.ch = msVar.ch;
        this.hi = msVar.hi;
        this.sl = msVar.sl;
    }

    public yu ms() {
        return this.f1037ms;
    }

    public i xr() {
        return this.xr;
    }

    public int ah() {
        return this.ah;
    }

    public boolean d() {
        int i = this.ah;
        return i >= 200 && i < 300;
    }

    public String ka() {
        return this.d;
    }

    public h c() {
        return this.ka;
    }

    public String ms(String str) {
        return ms(str, null);
    }

    public String ms(String str, String str2) {
        String strMs = this.c.ms(str);
        return strMs != null ? strMs : str2;
    }

    public qv ab() {
        return this.c;
    }

    public g x() {
        return this.ab;
    }

    public ms ny() {
        return new ms(this);
    }

    public cv ch() {
        return this.x;
    }

    public cv hi() {
        return this.ch;
    }

    public d sl() {
        d dVar = this.zb;
        if (dVar != null) {
            return dVar;
        }
        d dVarMs = d.ms(this.c);
        this.zb = dVarMs;
        return dVarMs;
    }

    public long zb() {
        return this.hi;
    }

    public long u() {
        return this.sl;
    }

    public le ub() {
        yu yuVar = this.f1037ms;
        if (yuVar == null) {
            return null;
        }
        return yuVar.c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g gVar = this.ab;
        if (gVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        gVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.xr + ", code=" + this.ah + ", message=" + this.d + ", url=" + this.f1037ms.ms() + AbstractJsonLexerKt.END_OBJ;
    }

    public static class ms {
        g ab;
        int ah;
        qv.ms c;
        cv ch;
        String d;
        long hi;
        h ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        yu f1038ms;
        cv ny;
        long sl;
        cv x;
        i xr;

        public ms() {
            this.ah = -1;
            this.c = new qv.ms();
        }

        ms(cv cvVar) {
            this.ah = -1;
            this.f1038ms = cvVar.f1037ms;
            this.xr = cvVar.xr;
            this.ah = cvVar.ah;
            this.d = cvVar.d;
            this.ka = cvVar.ka;
            this.c = cvVar.c.xr();
            this.ab = cvVar.ab;
            this.x = cvVar.x;
            this.ny = cvVar.ny;
            this.ch = cvVar.ch;
            this.hi = cvVar.hi;
            this.sl = cvVar.sl;
        }

        public ms ms(yu yuVar) {
            this.f1038ms = yuVar;
            return this;
        }

        public ms ms(i iVar) {
            this.xr = iVar;
            return this;
        }

        public ms ms(int i) {
            this.ah = i;
            return this;
        }

        public ms ms(String str) {
            this.d = str;
            return this;
        }

        public ms ms(h hVar) {
            this.ka = hVar;
            return this;
        }

        public ms ms(String str, String str2) {
            this.c.ms(str, str2);
            return this;
        }

        public ms ms(qv qvVar) {
            this.c = qvVar.xr();
            return this;
        }

        public ms ms(g gVar) {
            this.ab = gVar;
            return this;
        }

        public ms ms(cv cvVar) {
            if (cvVar != null) {
                ms("networkResponse", cvVar);
            }
            this.x = cvVar;
            return this;
        }

        public ms xr(cv cvVar) {
            if (cvVar != null) {
                ms("cacheResponse", cvVar);
            }
            this.ny = cvVar;
            return this;
        }

        private void ms(String str, cv cvVar) {
            if (cvVar.ab != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (cvVar.x != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (cvVar.ny != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (cvVar.ch != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public ms ah(cv cvVar) {
            if (cvVar != null) {
                d(cvVar);
            }
            this.ch = cvVar;
            return this;
        }

        private void d(cv cvVar) {
            if (cvVar.ab != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public ms ms(long j) {
            this.hi = j;
            return this;
        }

        public ms xr(long j) {
            this.sl = j;
            return this;
        }

        public cv ms() {
            if (this.f1038ms == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.xr == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.ah < 0) {
                throw new IllegalStateException("code < 0: " + this.ah);
            }
            if (this.d == null) {
                throw new IllegalStateException("message == null");
            }
            return new cv(this);
        }
    }
}
