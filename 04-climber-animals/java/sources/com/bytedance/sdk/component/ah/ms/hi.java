package com.bytedance.sdk.component.ah.ms;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
public final class hi implements y {
    private int ah;
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ka f1008ms;
    private final Inflater xr;

    hi(ka kaVar, Inflater inflater) {
        if (kaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f1008ms = kaVar;
        this.xr = inflater;
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public long ms(ah ahVar, long j) throws IOException {
        boolean zXr;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zXr = xr();
            try {
                ub ubVarKa = ahVar.ka(1);
                int iInflate = this.xr.inflate(ubVarKa.f1020ms, ubVarKa.ah, (int) Math.min(j, 8192 - ubVarKa.ah));
                if (iInflate > 0) {
                    ubVarKa.ah += iInflate;
                    long j2 = iInflate;
                    ahVar.xr += j2;
                    return j2;
                }
                if (!this.xr.finished() && !this.xr.needsDictionary()) {
                }
                ah();
                if (ubVarKa.xr != ubVarKa.ah) {
                    return -1L;
                }
                ahVar.f1003ms = ubVarKa.xr();
                ao.ms(ubVarKa);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zXr);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean xr() throws IOException {
        if (!this.xr.needsInput()) {
            return false;
        }
        ah();
        if (this.xr.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f1008ms.ka()) {
            return true;
        }
        ub ubVar = this.f1008ms.ah().f1003ms;
        this.ah = ubVar.ah - ubVar.xr;
        this.xr.setInput(ubVar.f1020ms, ubVar.xr, this.ah);
        return false;
    }

    private void ah() throws IOException {
        int i = this.ah;
        if (i == 0) {
            return;
        }
        int remaining = i - this.xr.getRemaining();
        this.ah -= remaining;
        this.f1008ms.x(remaining);
    }

    @Override // com.bytedance.sdk.component.ah.ms.y
    public t ms() {
        return this.f1008ms.ms();
    }

    @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.d) {
            return;
        }
        this.xr.end();
        this.d = true;
        this.f1008ms.close();
    }
}
