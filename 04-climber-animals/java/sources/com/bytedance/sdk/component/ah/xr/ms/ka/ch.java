package com.bytedance.sdk.component.ah.xr.ms.ka;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class ch implements Closeable {
    private static final Logger xr = Logger.getLogger(ka.class.getName());
    private boolean ab;
    private final com.bytedance.sdk.component.ah.ms.d ah;
    private int c;
    private final boolean d;
    private final com.bytedance.sdk.component.ah.ms.ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final d.xr f1089ms;

    ch(com.bytedance.sdk.component.ah.ms.d dVar, boolean z) {
        this.ah = dVar;
        this.d = z;
        com.bytedance.sdk.component.ah.ms.ah ahVar = new com.bytedance.sdk.component.ah.ms.ah();
        this.ka = ahVar;
        this.f1089ms = new d.xr(ahVar);
        this.c = 16384;
    }

    public synchronized void ms() throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        if (this.d) {
            Logger logger = xr;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.bytedance.sdk.component.ah.xr.ms.ah.ms(">> CONNECTION %s", ka.f1095ms.ka()));
            }
            this.ah.ah(ka.f1095ms.x());
            this.ah.flush();
        }
    }

    public synchronized void ms(u uVar) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        this.c = uVar.d(this.c);
        if (uVar.ah() != -1) {
            this.f1089ms.ms(uVar.ah());
        }
        ms(0, 0, (byte) 4, (byte) 1);
        this.ah.flush();
    }

    public synchronized void ms(int i, int i2, List<ah> list) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        this.f1089ms.ms(list);
        long jXr = this.ka.xr();
        int iMin = (int) Math.min(this.c - 4, jXr);
        long j = iMin;
        ms(i, iMin + 4, (byte) 5, jXr == j ? (byte) 4 : (byte) 0);
        this.ah.ab(i2 & Integer.MAX_VALUE);
        this.ah.a_(this.ka, j);
        if (jXr > j) {
            xr(i, jXr - j);
        }
    }

    public synchronized void xr() throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        this.ah.flush();
    }

    public synchronized void ms(boolean z, int i, int i2, List<ah> list) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        ms(z, i, list);
    }

    public synchronized void ms(int i, xr xrVar) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        if (xrVar.ab == -1) {
            throw new IllegalArgumentException();
        }
        ms(i, 4, (byte) 3, (byte) 0);
        this.ah.ab(xrVar.ab);
        this.ah.flush();
    }

    public int ah() {
        return this.c;
    }

    public synchronized void ms(boolean z, int i, com.bytedance.sdk.component.ah.ms.ah ahVar, int i2) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        ms(i, z ? (byte) 1 : (byte) 0, ahVar, i2);
    }

    void ms(int i, byte b, com.bytedance.sdk.component.ah.ms.ah ahVar, int i2) throws IOException {
        ms(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.ah.a_(ahVar, i2);
        }
    }

    public synchronized void xr(u uVar) throws IOException {
        int i;
        if (this.ab) {
            throw new IOException("closed");
        }
        int i2 = 0;
        ms(0, uVar.xr() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (uVar.ms(i2)) {
                if (i2 == 4) {
                    i = 3;
                } else {
                    i = i2 == 7 ? 4 : i2;
                }
                this.ah.x(i);
                this.ah.ab(uVar.xr(i2));
            }
            i2++;
        }
        this.ah.flush();
    }

    public synchronized void ms(boolean z, int i, int i2) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        ms(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.ah.ab(i);
        this.ah.ab(i2);
        this.ah.flush();
    }

    public synchronized void ms(int i, xr xrVar, byte[] bArr) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        if (xrVar.ab == -1) {
            throw ka.ms("errorCode.httpCode == -1", new Object[0]);
        }
        ms(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.ah.ab(i);
        this.ah.ab(xrVar.ab);
        if (bArr.length > 0) {
            this.ah.ah(bArr);
        }
        this.ah.flush();
    }

    public synchronized void ms(int i, long j) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw ka.ms("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        ms(i, 4, (byte) 8, (byte) 0);
        this.ah.ab((int) j);
        this.ah.flush();
    }

    public void ms(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = xr;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(ka.ms(false, i, i2, b, b2));
        }
        int i3 = this.c;
        if (i2 > i3) {
            throw ka.ms("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw ka.ms("reserved bit set: %s", Integer.valueOf(i));
        }
        ms(this.ah, i2);
        this.ah.ny(b & UByte.MAX_VALUE);
        this.ah.ny(b2 & UByte.MAX_VALUE);
        this.ah.ab(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.ab = true;
        this.ah.close();
    }

    private static void ms(com.bytedance.sdk.component.ah.ms.d dVar, int i) throws IOException {
        dVar.ny((i >>> 16) & 255);
        dVar.ny((i >>> 8) & 255);
        dVar.ny(i & 255);
    }

    private void xr(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.c, j);
            long j2 = iMin;
            j -= j2;
            ms(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.ah.a_(this.ka, j2);
        }
    }

    void ms(boolean z, int i, List<ah> list) throws IOException {
        if (this.ab) {
            throw new IOException("closed");
        }
        this.f1089ms.ms(list);
        long jXr = this.ka.xr();
        int iMin = (int) Math.min(this.c, jXr);
        long j = iMin;
        byte b = jXr == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        ms(i, iMin, (byte) 1, b);
        this.ah.a_(this.ka, j);
        if (jXr > j) {
            xr(i, jXr - j);
        }
    }
}
