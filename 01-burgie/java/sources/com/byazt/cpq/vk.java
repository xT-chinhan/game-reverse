package com.byazt.cpq;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 50})
public final class vk implements Closeable {
    public static final Logger hw = Logger.getLogger(c.class.getName());
    public final com.byazt.du.hn c;
    public boolean fw;
    public final com.byazt.du.x hn;
    public final x.hw pr;
    public int uc;
    public final boolean x;

    public vk(com.byazt.du.x xVar, boolean z) {
        this.hn = xVar;
        this.x = z;
        com.byazt.du.hn hnVar = new com.byazt.du.hn();
        this.c = hnVar;
        this.pr = new x.hw(hnVar);
        this.uc = 16384;
    }

    public synchronized void pr() throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        if (this.x) {
            Logger logger = hw;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.byazt.xx.hn.pr(">> CONNECTION %s", c.pr.c()));
            }
            this.hn.hn(c.pr.zo());
            this.hn.flush();
        }
    }

    public synchronized void pr(g gVar) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        this.uc = gVar.x(this.uc);
        if (gVar.hn() != -1) {
            this.pr.pr(gVar.hn());
        }
        pr(0, 0, (byte) 4, (byte) 1);
        this.hn.flush();
    }

    public synchronized void pr(int i, int i2, List<hn> list) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        this.pr.pr(list);
        long jHw = this.c.hw();
        int iMin = (int) Math.min(this.uc - 4, jHw);
        long j = iMin;
        pr(i, iMin + 4, (byte) 5, jHw == j ? (byte) 4 : (byte) 0);
        this.hn.fw(i2 & Integer.MAX_VALUE);
        this.hn.a_(this.c, j);
        if (jHw > j) {
            hw(i, jHw - j);
        }
    }

    public synchronized void hw() throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        this.hn.flush();
    }

    public synchronized void pr(boolean z, int i, int i2, List<hn> list) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        pr(z, i, list);
    }

    public synchronized void pr(int i, hw hwVar) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        if (hwVar.fw == -1) {
            throw new IllegalArgumentException();
        }
        pr(i, 4, (byte) 3, (byte) 0);
        this.hn.fw(hwVar.fw);
        this.hn.flush();
    }

    public int hn() {
        return this.uc;
    }

    public synchronized void pr(boolean z, int i, com.byazt.du.hn hnVar, int i2) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        pr(i, z ? (byte) 1 : (byte) 0, hnVar, i2);
    }

    public void pr(int i, byte b, com.byazt.du.hn hnVar, int i2) throws IOException {
        pr(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.hn.a_(hnVar, i2);
        }
    }

    public synchronized void hw(g gVar) throws IOException {
        int i;
        if (this.fw) {
            throw new IOException("closed");
        }
        pr(0, gVar.hw() * 6, (byte) 4, (byte) 0);
        for (int i2 = 0; i2 < 10; i2++) {
            if (gVar.pr(i2)) {
                if (i2 == 4) {
                    i = 3;
                } else if (i2 != 7) {
                    i = i2;
                } else {
                    i = 4;
                }
                this.hn.zo(i);
                this.hn.fw(gVar.hw(i2));
            }
        }
        this.hn.flush();
    }

    public synchronized void pr(boolean z, int i, int i2) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        pr(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.hn.fw(i);
        this.hn.fw(i2);
        this.hn.flush();
    }

    public synchronized void pr(int i, hw hwVar, byte[] bArr) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        if (hwVar.fw == -1) {
            throw c.pr("errorCode.httpCode == -1", new Object[0]);
        }
        pr(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.hn.fw(i);
        this.hn.fw(hwVar.fw);
        if (bArr.length > 0) {
            this.hn.hn(bArr);
        }
        this.hn.flush();
    }

    public synchronized void pr(int i, long j) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw c.pr("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        pr(i, 4, (byte) 8, (byte) 0);
        this.hn.fw((int) j);
        this.hn.flush();
    }

    public void pr(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = hw;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(c.pr(false, i, i2, b, b2));
        }
        int i3 = this.uc;
        if (i2 > i3) {
            throw c.pr("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw c.pr("reserved bit set: %s", Integer.valueOf(i));
        }
        pr(this.hn, i2);
        this.hn.aj(b & UByte.MAX_VALUE);
        this.hn.aj(b2 & UByte.MAX_VALUE);
        this.hn.fw(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.fw = true;
        this.hn.close();
    }

    private static void pr(com.byazt.du.x xVar, int i) throws IOException {
        xVar.aj((i >>> 16) & 255);
        xVar.aj((i >>> 8) & 255);
        xVar.aj(i & 255);
    }

    private void hw(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.uc, j);
            long j2 = iMin;
            j -= j2;
            pr(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.hn.a_(this.c, j2);
        }
    }

    public void pr(boolean z, int i, List<hn> list) throws IOException {
        if (this.fw) {
            throw new IOException("closed");
        }
        this.pr.pr(list);
        long jHw = this.c.hw();
        int iMin = (int) Math.min(this.uc, jHw);
        long j = iMin;
        byte b = jHw == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        pr(i, iMin, (byte) 1, b);
        this.hn.a_(this.c, j);
        if (jHw > j) {
            hw(i, jHw - j);
        }
    }
}
