package com.bytedance.sdk.component.ah.xr.ms.ka;

import com.bytedance.sdk.component.ah.ms.t;
import com.bytedance.sdk.component.ah.ms.y;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class x implements Closeable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Logger f1102ms = Logger.getLogger(ka.class.getName());
    private final com.bytedance.sdk.component.ah.ms.ka ah;
    private final ms d;
    private final boolean ka;
    final d.ms xr;

    interface xr {
        void ms(int i, int i2, List<ah> list) throws IOException;

        void ms(int i, long j);

        void ms(int i, com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar);

        void ms(int i, com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVar, com.bytedance.sdk.component.ah.ms.c cVar);

        void ms(boolean z, int i, int i2);

        void ms(boolean z, int i, int i2, List<ah> list);

        void ms(boolean z, int i, com.bytedance.sdk.component.ah.ms.ka kaVar, int i2) throws IOException;

        void ms(boolean z, u uVar);
    }

    x(com.bytedance.sdk.component.ah.ms.ka kaVar, boolean z) {
        this.ah = kaVar;
        this.ka = z;
        ms msVar = new ms(kaVar);
        this.d = msVar;
        this.xr = new d.ms(4096, msVar);
    }

    public void ms(xr xrVar) throws IOException {
        if (this.ka) {
            if (!ms(true, xrVar)) {
                throw ka.xr("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.bytedance.sdk.component.ah.ms.c cVarAh = this.ah.ah(ka.f1095ms.ab());
        Logger logger = f1102ms;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.bytedance.sdk.component.ah.xr.ms.ah.ms("<< CONNECTION %s", cVarAh.ka()));
        }
        if (!ka.f1095ms.equals(cVarAh)) {
            throw ka.xr("Expected a connection header but was %s", cVarAh.ms());
        }
    }

    public boolean ms(boolean z, xr xrVar) throws IOException {
        try {
            this.ah.ms(9L);
            int iMs = ms(this.ah);
            if (iMs < 0 || iMs > 16384) {
                throw ka.xr("FRAME_SIZE_ERROR: %s", Integer.valueOf(iMs));
            }
            byte bX = (byte) (this.ah.x() & UByte.MAX_VALUE);
            if (z && bX != 4) {
                throw ka.xr("Expected a SETTINGS frame but was %s", Byte.valueOf(bX));
            }
            byte bX2 = (byte) (this.ah.x() & UByte.MAX_VALUE);
            int iCh = this.ah.ch() & Integer.MAX_VALUE;
            Logger logger = f1102ms;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(ka.ms(true, iCh, iMs, bX, bX2));
            }
            switch (bX) {
                case 0:
                    xr(xrVar, iMs, bX2, iCh);
                    return true;
                case 1:
                    ms(xrVar, iMs, bX2, iCh);
                    return true;
                case 2:
                    ah(xrVar, iMs, bX2, iCh);
                    return true;
                case 3:
                    d(xrVar, iMs, bX2, iCh);
                    return true;
                case 4:
                    ka(xrVar, iMs, bX2, iCh);
                    return true;
                case 5:
                    c(xrVar, iMs, bX2, iCh);
                    return true;
                case 6:
                    ab(xrVar, iMs, bX2, iCh);
                    return true;
                case 7:
                    x(xrVar, iMs, bX2, iCh);
                    return true;
                case 8:
                    ny(xrVar, iMs, bX2, iCh);
                    return true;
                default:
                    this.ah.x(iMs);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void ms(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw ka.xr("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sX = (b & 8) != 0 ? (short) (this.ah.x() & UByte.MAX_VALUE) : (short) 0;
        if ((b & 32) != 0) {
            ms(xrVar, i2);
            i -= 5;
        }
        xrVar.ms(z, i2, -1, ms(ms(i, b, sX), sX, b, i2));
    }

    private List<ah> ms(int i, short s, byte b, int i2) throws IOException {
        ms msVar = this.d;
        msVar.d = i;
        msVar.f1103ms = i;
        this.d.ka = s;
        this.d.xr = b;
        this.d.ah = i2;
        this.xr.ms();
        return this.xr.xr();
    }

    private void xr(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw ka.xr("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw ka.xr("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sX = (b & 8) != 0 ? (short) (this.ah.x() & UByte.MAX_VALUE) : (short) 0;
        xrVar.ms(z, i2, this.ah, ms(i, b, sX));
        this.ah.x(sX);
    }

    private void ah(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw ka.xr("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw ka.xr("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        ms(xrVar, i2);
    }

    private void ms(xr xrVar, int i) throws IOException {
        this.ah.ch();
        this.ah.x();
    }

    private void d(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw ka.xr("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw ka.xr("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iCh = this.ah.ch();
        com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVarMs = com.bytedance.sdk.component.ah.xr.ms.ka.xr.ms(iCh);
        if (xrVarMs == null) {
            throw ka.xr("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iCh));
        }
        xrVar.ms(i2, xrVarMs);
    }

    private void ka(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw ka.xr("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw ka.xr("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw ka.xr("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        u uVar = new u();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sNy = this.ah.ny();
            int iCh = this.ah.ch();
            if (sNy == 2) {
                if (iCh != 0 && iCh != 1) {
                    throw ka.xr("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (sNy == 3) {
                sNy = 4;
            } else if (sNy != 4) {
                if (sNy == 5 && (iCh < 16384 || iCh > 16777215)) {
                    throw ka.xr("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iCh));
                }
            } else {
                if (iCh < 0) {
                    throw ka.xr("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                sNy = 7;
            }
            uVar.ms(sNy, iCh);
        }
        xrVar.ms(false, uVar);
    }

    private void c(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw ka.xr("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sX = (b & 8) != 0 ? (short) (this.ah.x() & UByte.MAX_VALUE) : (short) 0;
        xrVar.ms(i2, this.ah.ch() & Integer.MAX_VALUE, ms(ms(i - 4, b, sX), sX, b, i2));
    }

    private void ab(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw ka.xr("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw ka.xr("TYPE_PING streamId != 0", new Object[0]);
        }
        xrVar.ms((b & 1) != 0, this.ah.ch(), this.ah.ch());
    }

    private void x(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw ka.xr("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw ka.xr("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iCh = this.ah.ch();
        int iCh2 = this.ah.ch();
        int i3 = i - 8;
        com.bytedance.sdk.component.ah.xr.ms.ka.xr xrVarMs = com.bytedance.sdk.component.ah.xr.ms.ka.xr.ms(iCh2);
        if (xrVarMs == null) {
            throw ka.xr("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iCh2));
        }
        com.bytedance.sdk.component.ah.ms.c cVarAh = com.bytedance.sdk.component.ah.ms.c.xr;
        if (i3 > 0) {
            cVarAh = this.ah.ah(i3);
        }
        xrVar.ms(iCh, xrVarMs, cVarAh);
    }

    private void ny(xr xrVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw ka.xr("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jCh = ((long) this.ah.ch()) & 2147483647L;
        if (jCh == 0) {
            throw ka.xr("windowSizeIncrement was 0", Long.valueOf(jCh));
        }
        xrVar.ms(i2, jCh);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ah.close();
    }

    static final class ms implements y {
        int ah;
        private final com.bytedance.sdk.component.ah.ms.ka c;
        int d;
        short ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1103ms;
        byte xr;

        @Override // com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        ms(com.bytedance.sdk.component.ah.ms.ka kaVar) {
            this.c = kaVar;
        }

        @Override // com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            while (true) {
                int i = this.d;
                if (i == 0) {
                    this.c.x(this.ka);
                    this.ka = (short) 0;
                    if ((this.xr & 4) != 0) {
                        return -1L;
                    }
                    xr();
                } else {
                    long jMs = this.c.ms(ahVar, Math.min(j, i));
                    if (jMs == -1) {
                        return -1L;
                    }
                    this.d = (int) (((long) this.d) - jMs);
                    return jMs;
                }
            }
        }

        @Override // com.bytedance.sdk.component.ah.ms.y
        public t ms() {
            return this.c.ms();
        }

        private void xr() throws IOException {
            int i = this.ah;
            int iMs = x.ms(this.c);
            this.d = iMs;
            this.f1103ms = iMs;
            byte bX = (byte) (this.c.x() & UByte.MAX_VALUE);
            this.xr = (byte) (this.c.x() & UByte.MAX_VALUE);
            if (x.f1102ms.isLoggable(Level.FINE)) {
                x.f1102ms.fine(ka.ms(true, this.ah, this.f1103ms, bX, this.xr));
            }
            int iCh = this.c.ch() & Integer.MAX_VALUE;
            this.ah = iCh;
            if (bX != 9) {
                throw ka.xr("%s != TYPE_CONTINUATION", Byte.valueOf(bX));
            }
            if (iCh != i) {
                throw ka.xr("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int ms(com.bytedance.sdk.component.ah.ms.ka kaVar) throws IOException {
        return (kaVar.x() & UByte.MAX_VALUE) | ((kaVar.x() & UByte.MAX_VALUE) << 16) | ((kaVar.x() & UByte.MAX_VALUE) << 8);
    }

    static int ms(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw ka.xr("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
