package com.bytedance.sdk.component.ah.ms;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class ch implements y {
    private final Inflater ah;
    private final hi d;
    private final ka xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f1007ms = 0;
    private final CRC32 ka = new CRC32();

    public ch(y yVar) {
        if (yVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.ah = inflater;
        ka kaVarMs = sl.ms(yVar);
        this.xr = kaVarMs;
        this.d = new hi(kaVarMs, inflater);
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public long ms(ah ahVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f1007ms == 0) {
            xr();
            this.f1007ms = 1;
        }
        if (this.f1007ms == 1) {
            long j2 = ahVar.xr;
            long jMs = this.d.ms(ahVar, j);
            if (jMs != -1) {
                ms(ahVar, j2, jMs);
                return jMs;
            }
            this.f1007ms = 2;
        }
        if (this.f1007ms == 2) {
            ah();
            this.f1007ms = 3;
            if (!this.xr.ka()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void xr() throws IOException {
        this.xr.ms(10L);
        byte bXr = this.xr.ah().xr(3L);
        boolean z = ((bXr >> 1) & 1) == 1;
        if (z) {
            ms(this.xr.ah(), 0L, 10L);
        }
        ms("ID1ID2", 8075, this.xr.ny());
        this.xr.x(8L);
        if (((bXr >> 2) & 1) == 1) {
            this.xr.ms(2L);
            if (z) {
                ms(this.xr.ah(), 0L, 2L);
            }
            long jHi = this.xr.ah().hi();
            this.xr.ms(jHi);
            if (z) {
                ms(this.xr.ah(), 0L, jHi);
            }
            this.xr.x(jHi);
        }
        if (((bXr >> 3) & 1) == 1) {
            long jMs = this.xr.ms((byte) 0);
            if (jMs == -1) {
                throw new EOFException();
            }
            if (z) {
                ms(this.xr.ah(), 0L, jMs + 1);
            }
            this.xr.x(jMs + 1);
        }
        if (((bXr >> 4) & 1) == 1) {
            long jMs2 = this.xr.ms((byte) 0);
            if (jMs2 == -1) {
                throw new EOFException();
            }
            if (z) {
                ms(this.xr.ah(), 0L, jMs2 + 1);
            }
            this.xr.x(jMs2 + 1);
        }
        if (z) {
            ms("FHCRC", this.xr.hi(), (short) this.ka.getValue());
            this.ka.reset();
        }
    }

    private void ah() throws IOException {
        ms("CRC", this.xr.sl(), (int) this.ka.getValue());
        ms("ISIZE", this.xr.sl(), (int) this.ah.getBytesWritten());
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public t ms() {
        return this.xr.ms();
    }

    @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
    }

    private void ms(ah ahVar, long j, long j2) {
        ub ubVar = ahVar.f1003ms;
        while (j >= ubVar.ah - ubVar.xr) {
            j -= (long) (ubVar.ah - ubVar.xr);
            ubVar = ubVar.c;
        }
        while (j2 > 0) {
            int i = (int) (((long) ubVar.xr) + j);
            int iMin = (int) Math.min(ubVar.ah - i, j2);
            this.ka.update(ubVar.f1020ms, i, iMin);
            j2 -= (long) iMin;
            ubVar = ubVar.c;
            j = 0;
        }
    }

    private void ms(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
