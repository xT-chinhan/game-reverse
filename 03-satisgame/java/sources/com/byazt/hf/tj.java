package com.byazt.hf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj implements Closeable {
    public static final Logger qg = Logger.getLogger(l.class.getName());
    public final com.byazt.wa.s l;
    public final q.qg n;
    public final boolean q;
    public final com.byazt.wa.q s;
    public int w;
    public boolean x;

    public tj(com.byazt.wa.q qVar, boolean z) {
        this.s = qVar;
        this.q = z;
        com.byazt.wa.s sVar = new com.byazt.wa.s();
        this.l = sVar;
        this.n = new q.qg(sVar);
        this.w = 16384;
    }

    public synchronized void n() throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        if (this.q) {
            Logger logger = qg;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.byazt.zho.s.n(">> CONNECTION %s", l.n.l()));
            }
            this.s.s(l.n.fs());
            this.s.flush();
        }
    }

    public synchronized void n(sz szVar) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        this.w = szVar.q(this.w);
        if (szVar.s() != -1) {
            this.n.n(szVar.s());
        }
        n(0, 0, (byte) 4, (byte) 1);
        this.s.flush();
    }

    public synchronized void n(int i, int i2, List<s> list) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        this.n.n(list);
        long jQg = this.l.qg();
        int iMin = (int) Math.min(this.w - 4, jQg);
        long j = iMin;
        n(i, iMin + 4, (byte) 5, jQg == j ? (byte) 4 : (byte) 0);
        this.s.x(i2 & Integer.MAX_VALUE);
        this.s.a_(this.l, j);
        if (jQg > j) {
            qg(i, jQg - j);
        }
    }

    public synchronized void qg() throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        this.s.flush();
    }

    public synchronized void n(boolean z, int i, int i2, List<s> list) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        n(z, i, list);
    }

    public synchronized void n(int i, qg qgVar) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        if (qgVar.x == -1) {
            throw new IllegalArgumentException();
        }
        n(i, 4, (byte) 3, (byte) 0);
        this.s.x(qgVar.x);
        this.s.flush();
    }

    public int s() {
        return this.w;
    }

    public synchronized void n(boolean z, int i, com.byazt.wa.s sVar, int i2) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        n(i, z ? (byte) 1 : (byte) 0, sVar, i2);
    }

    public void n(int i, byte b, com.byazt.wa.s sVar, int i2) throws IOException {
        n(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.s.a_(sVar, i2);
        }
    }

    public synchronized void qg(sz szVar) throws IOException {
        int i;
        if (this.x) {
            throw new IOException("closed");
        }
        int i2 = 0;
        n(0, szVar.qg() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (szVar.n(i2)) {
                if (i2 == 4) {
                    i = 3;
                } else {
                    i = i2 == 7 ? 4 : i2;
                }
                this.s.fs(i);
                this.s.x(szVar.qg(i2));
            }
            i2++;
        }
        this.s.flush();
    }

    public synchronized void n(boolean z, int i, int i2) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        n(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.s.x(i);
        this.s.x(i2);
        this.s.flush();
    }

    public synchronized void n(int i, qg qgVar, byte[] bArr) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        if (qgVar.x == -1) {
            throw l.n("errorCode.httpCode == -1", new Object[0]);
        }
        n(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.s.x(i);
        this.s.x(qgVar.x);
        if (bArr.length > 0) {
            this.s.s(bArr);
        }
        this.s.flush();
    }

    public synchronized void n(int i, long j) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw l.n("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        n(i, 4, (byte) 8, (byte) 0);
        this.s.x((int) j);
        this.s.flush();
    }

    public void n(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = qg;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(l.n(false, i, i2, b, b2));
        }
        int i3 = this.w;
        if (i2 > i3) {
            throw l.n("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw l.n("reserved bit set: %s", Integer.valueOf(i));
        }
        n(this.s, i2);
        this.s.rv(b & UByte.MAX_VALUE);
        this.s.rv(b2 & UByte.MAX_VALUE);
        this.s.x(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.x = true;
        this.s.close();
    }

    private static void n(com.byazt.wa.q qVar, int i) throws IOException {
        qVar.rv((i >>> 16) & 255);
        qVar.rv((i >>> 8) & 255);
        qVar.rv(i & 255);
    }

    private void qg(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.w, j);
            long j2 = iMin;
            j -= j2;
            n(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.s.a_(this.l, j2);
        }
    }

    public void n(boolean z, int i, List<s> list) throws IOException {
        if (this.x) {
            throw new IOException("closed");
        }
        this.n.n(list);
        long jQg = this.l.qg();
        int iMin = (int) Math.min(this.w, jQg);
        long j = iMin;
        byte b = jQg == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        n(i, iMin, (byte) 1, b);
        this.s.a_(this.l, j);
        if (jQg > j) {
            qg(i, jQg - j);
        }
    }
}
