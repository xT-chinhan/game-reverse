package com.anythink.core.common.n.c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class l implements w {
    private static final byte a = 1;
    private static final byte b = 2;
    private static final byte c = 3;
    private static final byte d = 4;
    private static final byte e = 0;
    private static final byte f = 1;
    private static final byte g = 2;
    private static final byte h = 3;
    private final e j;
    private final Inflater k;
    private final m l;
    private int i = 0;
    private final CRC32 m = new CRC32();

    public l(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.k = inflater;
        e eVarA = n.a(wVar);
        this.j = eVarA;
        this.l = new m(eVarA, inflater);
    }

    @Override // com.anythink.core.common.n.c.w
    public final long a_(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.i == 0) {
            this.j.a(10L);
            byte bC = this.j.c().c(3L);
            boolean z = ((bC >> 1) & 1) == 1;
            if (z) {
                a(this.j.c(), 0L, 10L);
            }
            a("ID1ID2", 8075, this.j.l());
            this.j.i(8L);
            if (((bC >> 2) & 1) == 1) {
                this.j.a(2L);
                if (z) {
                    a(this.j.c(), 0L, 2L);
                }
                long jO = this.j.c().o();
                this.j.a(jO);
                if (z) {
                    a(this.j.c(), 0L, jO);
                }
                this.j.i(jO);
            }
            if (((bC >> 3) & 1) == 1) {
                long jA = this.j.a((byte) 0);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z) {
                    a(this.j.c(), 0L, jA + 1);
                }
                this.j.i(jA + 1);
            }
            if (((bC >> 4) & 1) == 1) {
                long jA2 = this.j.a((byte) 0);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    a(this.j.c(), 0L, jA2 + 1);
                }
                this.j.i(jA2 + 1);
            }
            if (z) {
                a("FHCRC", this.j.o(), (short) this.m.getValue());
                this.m.reset();
            }
            this.i = 1;
        }
        if (this.i == 1) {
            long j2 = cVar.c;
            long jA_ = this.l.a_(cVar, j);
            if (jA_ != -1) {
                a(cVar, j2, jA_);
                return jA_;
            }
            this.i = 2;
        }
        if (this.i == 2) {
            a("CRC", this.j.p(), (int) this.m.getValue());
            a("ISIZE", this.j.p(), (int) this.k.getBytesWritten());
            this.i = 3;
            if (!this.j.g()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void b() throws IOException {
        this.j.a(10L);
        byte bC = this.j.c().c(3L);
        boolean z = ((bC >> 1) & 1) == 1;
        if (z) {
            a(this.j.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.j.l());
        this.j.i(8L);
        if (((bC >> 2) & 1) == 1) {
            this.j.a(2L);
            if (z) {
                a(this.j.c(), 0L, 2L);
            }
            long jA = y.a(this.j.c().l());
            this.j.a(jA);
            if (z) {
                a(this.j.c(), 0L, jA);
            }
            this.j.i(jA);
        }
        if (((bC >> 3) & 1) == 1) {
            long jA2 = this.j.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.c(), 0L, jA2 + 1);
            }
            this.j.i(jA2 + 1);
        }
        if (((bC >> 4) & 1) == 1) {
            long jA3 = this.j.a((byte) 0);
            if (jA3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.j.c(), 0L, jA3 + 1);
            }
            this.j.i(jA3 + 1);
        }
        if (z) {
            a("FHCRC", this.j.o(), (short) this.m.getValue());
            this.m.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.j.p(), (int) this.m.getValue());
        a("ISIZE", this.j.p(), (int) this.k.getBytesWritten());
    }

    @Override // com.anythink.core.common.n.c.w
    public final x a() {
        return this.j.a();
    }

    @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.l.close();
    }

    private void a(c cVar, long j, long j2) {
        s sVar = cVar.b;
        while (j >= sVar.e - sVar.d) {
            j -= (long) (sVar.e - sVar.d);
            sVar = sVar.h;
        }
        while (j2 > 0) {
            int i = (int) (((long) sVar.d) + j);
            int iMin = (int) Math.min(sVar.e - i, j2);
            this.m.update(sVar.c, i, iMin);
            j2 -= (long) iMin;
            sVar = sVar.h;
            j = 0;
        }
    }

    private static void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
