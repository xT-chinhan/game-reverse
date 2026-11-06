package com.anythink.core.common.m.b.a.e;

import com.anythink.core.common.m.c.w;
import com.anythink.core.common.m.c.x;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
final class h implements Closeable {
    static final Logger a = Logger.getLogger(e.class.getName());
    final d.a b;
    private final com.anythink.core.common.m.c.e c;
    private final a d;
    private final boolean e;

    interface b {
        void a();

        void a(int i, long j);

        void a(int i, com.anythink.core.common.m.b.a.e.b bVar);

        void a(int i, com.anythink.core.common.m.c.f fVar);

        void a(int i, List<c> list);

        void a(m mVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, com.anythink.core.common.m.c.e eVar, int i2);

        void a(boolean z, int i, List<c> list);

        void b();

        void d();
    }

    h(com.anythink.core.common.m.c.e eVar, boolean z) {
        this.c = eVar;
        this.e = z;
        a aVar = new a(eVar);
        this.d = aVar;
        this.b = new d.a(aVar, (byte) 0);
    }

    public final void a(b bVar) throws IOException {
        if (this.e) {
            if (!a(true, bVar)) {
                throw e.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.anythink.core.common.m.c.f fVarD = this.c.d(e.a.j());
        Logger logger = a;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.anythink.core.common.m.b.a.c.a("<< CONNECTION %s", fVarD.g()));
        }
        if (!e.a.equals(fVarD)) {
            throw e.b("Expected a connection header but was %s", fVarD.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(boolean z, b bVar) throws IOException {
        try {
            this.c.a(9L);
            int iA = a(this.c);
            if (iA < 0 || iA > 16384) {
                throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
            }
            byte bK = (byte) (this.c.k() & UByte.MAX_VALUE);
            if (z && bK != 4) {
                throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(bK));
            }
            byte bK2 = (byte) (this.c.k() & UByte.MAX_VALUE);
            int iM = this.c.m() & Integer.MAX_VALUE;
            Logger logger = a;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, iM, iA, bK, bK2));
            }
            switch (bK) {
                case 0:
                    if (iM == 0) {
                        throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
                    }
                    boolean z2 = (bK2 & 1) != 0;
                    if (((bK2 & 32) != 0) != false) {
                        throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
                    }
                    short sK = (bK2 & 8) != 0 ? (short) (this.c.k() & UByte.MAX_VALUE) : (short) 0;
                    bVar.a(z2, iM, this.c, a(iA, bK2, sK));
                    this.c.i(sK);
                    return true;
                case 1:
                    if (iM == 0) {
                        throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
                    }
                    boolean z3 = (bK2 & 1) != 0;
                    short sK2 = (bK2 & 8) != 0 ? (short) (this.c.k() & UByte.MAX_VALUE) : (short) 0;
                    if ((bK2 & 32) != 0) {
                        a();
                        iA -= 5;
                    }
                    bVar.a(z3, iM, a(a(iA, bK2, sK2), sK2, bK2, iM));
                    return true;
                case 2:
                    if (iA != 5) {
                        throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(iA));
                    }
                    if (iM == 0) {
                        throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
                    }
                    a();
                    return true;
                case 3:
                    if (iA != 4) {
                        throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(iA));
                    }
                    if (iM == 0) {
                        throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
                    }
                    int iM2 = this.c.m();
                    com.anythink.core.common.m.b.a.e.b bVarA = com.anythink.core.common.m.b.a.e.b.a(iM2);
                    if (bVarA == null) {
                        throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iM2));
                    }
                    bVar.a(iM, bVarA);
                    return true;
                case 4:
                    if (iM != 0) {
                        throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
                    }
                    if ((bK2 & 1) == 0) {
                        if (iA % 6 != 0) {
                            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(iA));
                        }
                        m mVar = new m();
                        for (int i = 0; i < iA; i += 6) {
                            int iL = this.c.l() & UShort.MAX_VALUE;
                            int iM3 = this.c.m();
                            if (iL == 2) {
                                if (iM3 != 0 && iM3 != 1) {
                                    throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                                }
                            } else if (iL == 3) {
                                iL = 4;
                            } else if (iL != 4) {
                                if (iL == 5 && (iM3 < 16384 || iM3 > 16777215)) {
                                    throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iM3));
                                }
                            } else {
                                if (iM3 < 0) {
                                    throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                }
                                iL = 7;
                            }
                            mVar.a(iL, iM3);
                        }
                        bVar.a(mVar);
                    } else if (iA != 0) {
                        throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                    }
                    return true;
                case 5:
                    if (iM == 0) {
                        throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
                    }
                    short sK3 = (bK2 & 8) != 0 ? (short) (this.c.k() & UByte.MAX_VALUE) : (short) 0;
                    bVar.a(this.c.m() & Integer.MAX_VALUE, a(a(iA - 4, bK2, sK3), sK3, bK2, iM));
                    return true;
                case 6:
                    if (iA != 8) {
                        throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(iA));
                    }
                    if (iM != 0) {
                        throw e.b("TYPE_PING streamId != 0", new Object[0]);
                    }
                    bVar.a((bK2 & 1) != 0, this.c.m(), this.c.m());
                    return true;
                case 7:
                    if (iA < 8) {
                        throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(iA));
                    }
                    if (iM != 0) {
                        throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
                    }
                    int iM4 = this.c.m();
                    int iM5 = this.c.m();
                    int i2 = iA - 8;
                    if (com.anythink.core.common.m.b.a.e.b.a(iM5) == null) {
                        throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iM5));
                    }
                    com.anythink.core.common.m.c.f fVarD = com.anythink.core.common.m.c.f.b;
                    if (i2 > 0) {
                        fVarD = this.c.d(i2);
                    }
                    bVar.a(iM4, fVarD);
                    return true;
                case 8:
                    if (iA != 4) {
                        throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(iA));
                    }
                    long jM = ((long) this.c.m()) & 2147483647L;
                    if (jM == 0) {
                        throw e.b("windowSizeIncrement was 0", Long.valueOf(jM));
                    }
                    bVar.a(iM, jM);
                    return true;
                default:
                    this.c.i(iA);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short sK = (b2 & 8) != 0 ? (short) (this.c.k() & UByte.MAX_VALUE) : (short) 0;
        if ((b2 & 32) != 0) {
            a();
            i -= 5;
        }
        bVar.a(z, i2, a(a(i, b2, sK), sK, b2, i2));
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.d;
        aVar.d = i;
        aVar.a = i;
        this.d.e = s;
        this.d.b = b2;
        this.d.c = i2;
        this.b.a();
        return this.b.b();
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sK = (b2 & 8) != 0 ? (short) (this.c.k() & UByte.MAX_VALUE) : (short) 0;
        bVar.a(z, i2, this.c, a(i, b2, sK));
        this.c.i(sK);
    }

    private void a(int i, int i2) throws IOException {
        if (i != 5) {
            throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a();
    }

    private void a() {
        this.c.m();
        this.c.k();
    }

    private void a(b bVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iM = this.c.m();
        com.anythink.core.common.m.b.a.e.b bVarA = com.anythink.core.common.m.b.a.e.b.a(iM);
        if (bVarA == null) {
            throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iM));
        }
        bVar.a(i2, bVarA);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        m mVar = new m();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int iL = this.c.l() & UShort.MAX_VALUE;
            int iM = this.c.m();
            if (iL == 2) {
                if (iM != 0 && iM != 1) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (iL == 3) {
                iL = 4;
            } else if (iL != 4) {
                if (iL == 5 && (iM < 16384 || iM > 16777215)) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iM));
                }
            } else {
                if (iM < 0) {
                    throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                iL = 7;
            }
            mVar.a(iL, iM);
        }
        bVar.a(mVar);
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sK = (b2 & 8) != 0 ? (short) (this.c.k() & UByte.MAX_VALUE) : (short) 0;
        bVar.a(this.c.m() & Integer.MAX_VALUE, a(a(i - 4, b2, sK), sK, b2, i2));
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b2 & 1) != 0, this.c.m(), this.c.m());
    }

    private void b(b bVar, int i, int i2) throws IOException {
        if (i < 8) {
            throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iM = this.c.m();
        int iM2 = this.c.m();
        int i3 = i - 8;
        if (com.anythink.core.common.m.b.a.e.b.a(iM2) == null) {
            throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iM2));
        }
        com.anythink.core.common.m.c.f fVarD = com.anythink.core.common.m.c.f.b;
        if (i3 > 0) {
            fVarD = this.c.d(i3);
        }
        bVar.a(iM, fVarD);
    }

    private void c(b bVar, int i, int i2) throws IOException {
        if (i != 4) {
            throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jM = ((long) this.c.m()) & 2147483647L;
        if (jM == 0) {
            throw e.b("windowSizeIncrement was 0", Long.valueOf(jM));
        }
        bVar.a(i2, jM);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.c.close();
    }

    static final class a implements w {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final com.anythink.core.common.m.c.e f;

        @Override // com.anythink.core.common.m.c.w, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        a(com.anythink.core.common.m.c.e eVar) {
            this.f = eVar;
        }

        @Override // com.anythink.core.common.m.c.w
        public final long a_(com.anythink.core.common.m.c.c cVar, long j) throws IOException {
            int i;
            int iM;
            do {
                int i2 = this.d;
                if (i2 == 0) {
                    this.f.i(this.e);
                    this.e = (short) 0;
                    if ((this.b & 4) != 0) {
                        return -1L;
                    }
                    i = this.c;
                    int iA = h.a(this.f);
                    this.d = iA;
                    this.a = iA;
                    byte bK = (byte) (this.f.k() & UByte.MAX_VALUE);
                    this.b = (byte) (this.f.k() & UByte.MAX_VALUE);
                    if (h.a.isLoggable(Level.FINE)) {
                        h.a.fine(e.a(true, this.c, this.a, bK, this.b));
                    }
                    iM = this.f.m() & Integer.MAX_VALUE;
                    this.c = iM;
                    if (bK != 9) {
                        throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(bK));
                    }
                } else {
                    long jA_ = this.f.a_(cVar, Math.min(j, i2));
                    if (jA_ == -1) {
                        return -1L;
                    }
                    this.d = (int) (((long) this.d) - jA_);
                    return jA_;
                }
            } while (iM == i);
            throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
        }

        @Override // com.anythink.core.common.m.c.w
        public final x a() {
            return this.f.a();
        }

        private void b() throws IOException {
            int i = this.c;
            int iA = h.a(this.f);
            this.d = iA;
            this.a = iA;
            byte bK = (byte) (this.f.k() & UByte.MAX_VALUE);
            this.b = (byte) (this.f.k() & UByte.MAX_VALUE);
            if (h.a.isLoggable(Level.FINE)) {
                h.a.fine(e.a(true, this.c, this.a, bK, this.b));
            }
            int iM = this.f.m() & Integer.MAX_VALUE;
            this.c = iM;
            if (bK != 9) {
                throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(bK));
            }
            if (iM != i) {
                throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(com.anythink.core.common.m.c.e eVar) {
        return (eVar.k() & UByte.MAX_VALUE) | ((eVar.k() & UByte.MAX_VALUE) << 16) | ((eVar.k() & UByte.MAX_VALUE) << 8);
    }

    private static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
