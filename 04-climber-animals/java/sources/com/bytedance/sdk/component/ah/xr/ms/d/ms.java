package com.bytedance.sdk.component.ah.xr.ms.d;

import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.ms.sl;
import com.bytedance.sdk.component.ah.ms.t;
import com.bytedance.sdk.component.ah.ms.y;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.g;
import com.bytedance.sdk.component.ah.xr.ms.ah.hi;
import com.bytedance.sdk.component.ah.xr.ms.ah.ny;
import com.bytedance.sdk.component.ah.xr.ms.ah.x;
import com.bytedance.sdk.component.ah.xr.ms.xr.ab;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements com.bytedance.sdk.component.ah.xr.ms.ah.ah {
    final com.bytedance.sdk.component.ah.ms.ka ah;
    final com.bytedance.sdk.component.ah.ms.d d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final re f1069ms;
    final ab xr;
    int ka = 0;
    private long c = 262144;

    public ms(re reVar, ab abVar, com.bytedance.sdk.component.ah.ms.ka kaVar, com.bytedance.sdk.component.ah.ms.d dVar) {
        this.f1069ms = reVar;
        this.xr = abVar;
        this.ah = kaVar;
        this.d = dVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public qv ms(yu yuVar, long j) {
        if ("chunked".equalsIgnoreCase(yuVar.ms("Transfer-Encoding"))) {
            return ka();
        }
        if (j != -1) {
            return ms(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void ah() {
        com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVarXr = this.xr.xr();
        if (ahVarXr != null) {
            ahVarXr.xr();
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void ms(yu yuVar) throws IOException {
        ms(yuVar.ah(), ny.ms(yuVar, this.xr.xr().ms().xr().type()));
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public g ms(cv cvVar) throws IOException {
        String strMs = cvVar.ms("Content-Type");
        if (!com.bytedance.sdk.component.ah.xr.ms.ah.ka.ah(cvVar)) {
            return new x(strMs, 0L, sl.ms(xr(0L)));
        }
        if ("chunked".equalsIgnoreCase(cvVar.ms("Transfer-Encoding"))) {
            return new x(strMs, -1L, sl.ms(ms(cvVar.ms().ms())));
        }
        long jMs = com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(cvVar);
        if (jMs != -1) {
            return new x(strMs, jMs, sl.ms(xr(jMs)));
        }
        return new x(strMs, -1L, sl.ms(c()));
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void ms() throws IOException {
        this.d.flush();
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void xr() throws IOException {
        this.d.flush();
    }

    public void ms(com.bytedance.sdk.component.ah.xr.qv qvVar, String str) throws IOException {
        if (this.ka != 0) {
            throw new IllegalStateException("state: " + this.ka);
        }
        this.d.xr(str).xr("\r\n");
        int iMs = qvVar.ms();
        for (int i = 0; i < iMs; i++) {
            this.d.xr(qvVar.ms(i)).xr(": ").xr(qvVar.xr(i)).xr("\r\n");
        }
        this.d.xr("\r\n");
        this.ka = 1;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public cv.ms ms(boolean z) throws IOException {
        int i = this.ka;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.ka);
        }
        try {
            hi hiVarMs = hi.ms(ab());
            cv.ms msVarMs = new cv.ms().ms(hiVarMs.f1062ms).ms(hiVarMs.xr).ms(hiVarMs.ah).ms(d());
            if (z && hiVarMs.xr == 100) {
                return null;
            }
            this.ka = 4;
            return msVarMs;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.xr);
            iOException.initCause(e);
            throw iOException;
        }
    }

    private String ab() throws IOException {
        String strKa = this.ah.ka(this.c);
        this.c -= (long) strKa.length();
        return strKa;
    }

    public com.bytedance.sdk.component.ah.xr.qv d() throws IOException {
        com.bytedance.sdk.component.ah.xr.qv.ms msVar = new com.bytedance.sdk.component.ah.xr.qv.ms();
        while (true) {
            String strAb = ab();
            if (strAb.length() != 0) {
                com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(msVar, strAb);
            } else {
                return msVar.ms();
            }
        }
    }

    public qv ka() {
        if (this.ka != 1) {
            throw new IllegalStateException("state: " + this.ka);
        }
        this.ka = 2;
        return new xr();
    }

    public qv ms(long j) {
        if (this.ka != 1) {
            throw new IllegalStateException("state: " + this.ka);
        }
        this.ka = 2;
        return new d(j);
    }

    public y xr(long j) throws IOException {
        if (this.ka != 4) {
            throw new IllegalStateException("state: " + this.ka);
        }
        this.ka = 5;
        return new ka(j);
    }

    public y ms(com.bytedance.sdk.component.ah.xr.y yVar) throws IOException {
        if (this.ka != 4) {
            throw new IllegalStateException("state: " + this.ka);
        }
        this.ka = 5;
        return new ah(yVar);
    }

    public y c() throws IOException {
        if (this.ka != 4) {
            throw new IllegalStateException("state: " + this.ka);
        }
        ab abVar = this.xr;
        if (abVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.ka = 5;
        abVar.d();
        return new c();
    }

    void ms(com.bytedance.sdk.component.ah.ms.ny nyVar) {
        t tVarMs = nyVar.ms();
        nyVar.ms(t.ah);
        tVarMs.c();
        tVarMs.ka();
    }

    private final class d implements qv {
        private boolean ah;
        private long d;
        private final com.bytedance.sdk.component.ah.ms.ny xr;

        d(long j) {
            this.xr = new com.bytedance.sdk.component.ah.ms.ny(ms.this.d.ms());
            this.d = j;
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv
        public t ms() {
            return this.xr;
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv
        public void a_(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (this.ah) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(ahVar.xr(), 0L, j);
            if (j > this.d) {
                throw new ProtocolException("expected " + this.d + " bytes but received " + j);
            }
            ms.this.d.a_(ahVar, j);
            this.d -= j;
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
        public void flush() throws IOException {
            if (this.ah) {
                return;
            }
            ms.this.d.flush();
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.ah) {
                return;
            }
            this.ah = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            ms.this.ms(this.xr);
            ms.this.ka = 3;
        }
    }

    private final class xr implements qv {
        private boolean ah;
        private final com.bytedance.sdk.component.ah.ms.ny xr;

        xr() {
            this.xr = new com.bytedance.sdk.component.ah.ms.ny(ms.this.d.ms());
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv
        public t ms() {
            return this.xr;
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv
        public void a_(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (this.ah) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            ms.this.d.hi(j);
            ms.this.d.xr("\r\n");
            ms.this.d.a_(ahVar, j);
            ms.this.d.xr("\r\n");
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.ah) {
                return;
            }
            ms.this.d.flush();
        }

        @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.ah) {
                return;
            }
            this.ah = true;
            ms.this.d.xr("0\r\n\r\n");
            ms.this.ms(this.xr);
            ms.this.ka = 3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.ah.xr.ms.d.ms$ms, reason: collision with other inner class name */
    private abstract class AbstractC0241ms implements y {
        protected long ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        protected final com.bytedance.sdk.component.ah.ms.ny f1071ms;
        protected boolean xr;

        private AbstractC0241ms() {
            this.f1071ms = new com.bytedance.sdk.component.ah.ms.ny(ms.this.ah.ms());
            this.ah = 0L;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y
        public t ms() {
            return this.f1071ms;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            try {
                long jMs = ms.this.ah.ms(ahVar, j);
                if (jMs > 0) {
                    this.ah += jMs;
                }
                return jMs;
            } catch (IOException e) {
                ms(false, e);
                throw e;
            }
        }

        protected final void ms(boolean z, IOException iOException) throws IOException {
            if (ms.this.ka == 6) {
                return;
            }
            if (ms.this.ka != 5) {
                throw new IllegalStateException("state: " + ms.this.ka);
            }
            ms.this.ms(this.f1071ms);
            ms.this.ka = 6;
            if (ms.this.xr != null) {
                ms.this.xr.ms(!z, ms.this, this.ah, iOException);
            }
        }
    }

    private class ka extends AbstractC0241ms {
        private long c;

        ka(long j) throws IOException {
            super();
            this.c = j;
            if (j == 0) {
                ms(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.d.ms.AbstractC0241ms, com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.xr) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.c;
            if (j2 == 0) {
                return -1L;
            }
            long jMs = super.ms(ahVar, Math.min(j2, j));
            if (jMs == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                ms(false, (IOException) protocolException);
                throw protocolException;
            }
            long j3 = this.c - jMs;
            this.c = j3;
            if (j3 == 0) {
                ms(true, (IOException) null);
            }
            return jMs;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xr) {
                return;
            }
            if (this.c != 0 && !com.bytedance.sdk.component.ah.xr.ms.ah.ms(this, 100, TimeUnit.MILLISECONDS)) {
                ms(false, (IOException) null);
            }
            this.xr = true;
        }
    }

    private class ah extends AbstractC0241ms {
        private long ab;
        private final com.bytedance.sdk.component.ah.xr.y c;
        private boolean x;

        ah(com.bytedance.sdk.component.ah.xr.y yVar) {
            super();
            this.ab = -1L;
            this.x = true;
            this.c = yVar;
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.d.ms.AbstractC0241ms, com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.xr) {
                throw new IllegalStateException("closed");
            }
            if (!this.x) {
                return -1L;
            }
            long j2 = this.ab;
            if (j2 == 0 || j2 == -1) {
                xr();
                if (!this.x) {
                    return -1L;
                }
            }
            long jMs = super.ms(ahVar, Math.min(j, this.ab));
            if (jMs == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                ms(false, (IOException) protocolException);
                throw protocolException;
            }
            this.ab -= jMs;
            return jMs;
        }

        private void xr() throws IOException {
            if (this.ab != -1) {
                ms.this.ah.ao();
            }
            try {
                this.ab = ms.this.ah.zb();
                String strTrim = ms.this.ah.ao().trim();
                if (this.ab < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.ab + strTrim + "\"");
                }
                if (this.ab == 0) {
                    this.x = false;
                    com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(ms.this.f1069ms.c(), this.c, ms.this.d());
                    ms(true, (IOException) null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xr) {
                return;
            }
            if (this.x && !com.bytedance.sdk.component.ah.xr.ms.ah.ms(this, 100, TimeUnit.MILLISECONDS)) {
                ms(false, (IOException) null);
            }
            this.xr = true;
        }
    }

    private class c extends AbstractC0241ms {
        private boolean c;

        c() {
            super();
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.d.ms.AbstractC0241ms, com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            if (this.xr) {
                throw new IllegalStateException("closed");
            }
            if (this.c) {
                return -1L;
            }
            long jMs = super.ms(ahVar, j);
            if (jMs != -1) {
                return jMs;
            }
            this.c = true;
            ms(true, (IOException) null);
            return -1L;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.xr) {
                return;
            }
            if (!this.c) {
                ms(false, (IOException) null);
            }
            this.xr = true;
        }
    }
}
