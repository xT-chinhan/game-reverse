package com.anythink.core.common.m.b.a.e;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
final class j implements Closeable {
    private static final Logger b = Logger.getLogger(e.class.getName());
    final d.b a;
    private final com.anythink.core.common.m.c.d c;
    private final boolean d;
    private final com.anythink.core.common.m.c.c e;
    private int f;
    private boolean g;

    j(com.anythink.core.common.m.c.d dVar, boolean z) {
        this.c = dVar;
        this.d = z;
        com.anythink.core.common.m.c.c cVar = new com.anythink.core.common.m.c.c();
        this.e = cVar;
        this.a = new d.b(cVar);
        this.f = 16384;
    }

    public final synchronized void a() {
        if (this.g) {
            throw new IOException("closed");
        }
        if (this.d) {
            Logger logger = b;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.anythink.core.common.m.b.a.c.a(">> CONNECTION %s", e.a.g()));
            }
            this.c.d(e.a.k());
            this.c.flush();
        }
    }

    public final synchronized void a(m mVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f = mVar.c(this.f);
        if (mVar.c() != -1) {
            this.a.a(mVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.c.flush();
    }

    public final synchronized void a(int i, int i2, List<c> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.a.a(list);
        long jB = this.e.b();
        int iMin = (int) Math.min(this.f - 4, jB);
        long j = iMin;
        a(i, iMin + 4, (byte) 5, jB == j ? (byte) 4 : (byte) 0);
        this.c.i(i2 & Integer.MAX_VALUE);
        this.c.a(this.e, j);
        if (jB > j) {
            b(i, jB - j);
        }
    }

    public final synchronized void b() {
        if (this.g) {
            throw new IOException("closed");
        }
        this.c.flush();
    }

    public final synchronized void a(int i, b bVar) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (bVar.l == -1) {
            throw new IllegalArgumentException();
        }
        a(i, 4, (byte) 3, (byte) 0);
        this.c.i(bVar.l);
        this.c.flush();
    }

    public final int c() {
        return this.f;
    }

    public final synchronized void a(boolean z, int i, com.anythink.core.common.m.c.c cVar, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, i2, (byte) 0, z ? (byte) 1 : (byte) 0);
        if (i2 > 0) {
            this.c.a(cVar, i2);
        }
    }

    private void a(int i, byte b2, com.anythink.core.common.m.c.c cVar, int i2) {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.c.a(cVar, i2);
        }
    }

    public final synchronized void b(m mVar) {
        int i;
        if (this.g) {
            throw new IOException("closed");
        }
        int i2 = 0;
        a(0, mVar.b() * 6, (byte) 4, (byte) 0);
        while (i2 < 10) {
            if (mVar.a(i2)) {
                if (i2 == 4) {
                    i = 3;
                } else {
                    i = i2 == 7 ? 4 : i2;
                }
                this.c.k(i);
                this.c.i(mVar.b(i2));
            }
            i2++;
        }
        this.c.flush();
    }

    public final synchronized void a(boolean z, int i, int i2) {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.c.i(i);
        this.c.i(i2);
        this.c.flush();
    }

    public final synchronized void a(int i, b bVar, byte[] bArr) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (bVar.l == -1) {
            throw e.a("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.c.i(i);
        this.c.i(bVar.l);
        if (bArr.length > 0) {
            this.c.d(bArr);
        }
        this.c.flush();
    }

    public final synchronized void a(int i, long j) {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.c.i((int) j);
        this.c.flush();
    }

    private void a(int i, int i2, byte b2, byte b3) {
        Logger logger = b;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a(false, i, i2, b2, b3));
        }
        int i3 = this.f;
        if (i2 > i3) {
            throw e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw e.a("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.c, i2);
        this.c.l(b2 & UByte.MAX_VALUE);
        this.c.l(b3 & UByte.MAX_VALUE);
        this.c.i(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.g = true;
        this.c.close();
    }

    private static void a(com.anythink.core.common.m.c.d dVar, int i) {
        dVar.l((i >>> 16) & 255);
        dVar.l((i >>> 8) & 255);
        dVar.l(i & 255);
    }

    private void b(int i, long j) {
        while (j > 0) {
            int iMin = (int) Math.min(this.f, j);
            long j2 = iMin;
            j -= j2;
            a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.c.a(this.e, j2);
        }
    }

    public final synchronized void a(boolean z, int i, List<c> list) {
        if (this.g) {
            throw new IOException("closed");
        }
        this.a.a(list);
        long jB = this.e.b();
        int iMin = (int) Math.min(this.f, jB);
        long j = iMin;
        byte b2 = jB == j ? (byte) 4 : (byte) 0;
        if (z) {
            b2 = (byte) (b2 | 1);
        }
        a(i, iMin, (byte) 1, b2);
        this.c.a(this.e, j);
        if (jB > j) {
            b(i, jB - j);
        }
    }
}
