package com.byazt.hf;

import com.byazt.wa.a;
import com.byazt.wa.um;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 101})
public final class fs implements Closeable {
    public static final Logger n = Logger.getLogger(l.class.getName());
    public final boolean l;
    public final n q;
    public final q.n qg;
    public final com.byazt.wa.l s;

    interface qg {
        void n(int i, int i2, List<s> list) throws IOException;

        void n(int i, long j);

        void n(int i, com.byazt.hf.qg qgVar);

        void n(int i, com.byazt.hf.qg qgVar, com.byazt.wa.w wVar);

        void n(boolean z, int i, int i2);

        void n(boolean z, int i, int i2, List<s> list);

        void n(boolean z, int i, com.byazt.wa.l lVar, int i2) throws IOException;

        void n(boolean z, sz szVar);
    }

    public fs(com.byazt.wa.l lVar, boolean z) {
        this.s = lVar;
        this.l = z;
        n nVar = new n(lVar);
        this.q = nVar;
        this.qg = new q.n(4096, nVar);
    }

    public void n(qg qgVar) throws IOException {
        if (this.l) {
            if (!n(true, qgVar)) {
                throw l.qg("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.byazt.wa.w wVarS = this.s.s(l.n.x());
        Logger logger = n;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.byazt.zho.s.n("<< CONNECTION %s", wVarS.l()));
        }
        if (!l.n.equals(wVarS)) {
            throw l.qg("Expected a connection header but was %s", wVarS.n());
        }
    }

    public boolean n(boolean z, qg qgVar) throws IOException {
        try {
            this.s.n(9L);
            int iN = n(this.s);
            if (iN < 0 || iN > 16384) {
                throw l.qg("FRAME_SIZE_ERROR: %s", Integer.valueOf(iN));
            }
            byte bFs = (byte) (this.s.fs() & UByte.MAX_VALUE);
            if (z && bFs != 4) {
                throw l.qg("Expected a SETTINGS frame but was %s", Byte.valueOf(bFs));
            }
            byte bFs2 = (byte) (this.s.fs() & UByte.MAX_VALUE);
            int iTj = this.s.tj() & Integer.MAX_VALUE;
            Logger logger = n;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(l.n(true, iTj, iN, bFs, bFs2));
            }
            switch (bFs) {
                case 0:
                    qg(qgVar, iN, bFs2, iTj);
                    return true;
                case 1:
                    n(qgVar, iN, bFs2, iTj);
                    return true;
                case 2:
                    s(qgVar, iN, bFs2, iTj);
                    return true;
                case 3:
                    q(qgVar, iN, bFs2, iTj);
                    return true;
                case 4:
                    l(qgVar, iN, bFs2, iTj);
                    return true;
                case 5:
                    w(qgVar, iN, bFs2, iTj);
                    return true;
                case 6:
                    x(qgVar, iN, bFs2, iTj);
                    return true;
                case 7:
                    fs(qgVar, iN, bFs2, iTj);
                    return true;
                case 8:
                    rv(qgVar, iN, bFs2, iTj);
                    return true;
                default:
                    this.s.fs(iN);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void n(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw l.qg("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sFs = (b & 8) != 0 ? (short) (this.s.fs() & UByte.MAX_VALUE) : (short) 0;
        if ((b & 32) != 0) {
            n(qgVar, i2);
            i -= 5;
        }
        qgVar.n(z, i2, -1, n(n(i, b, sFs), sFs, b, i2));
    }

    private List<s> n(int i, short s, byte b, int i2) throws IOException {
        n nVar = this.q;
        nVar.q = i;
        nVar.n = i;
        this.q.l = s;
        this.q.qg = b;
        this.q.s = i2;
        this.qg.n();
        return this.qg.qg();
    }

    private void qg(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw l.qg("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw l.qg("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sFs = (b & 8) != 0 ? (short) (this.s.fs() & UByte.MAX_VALUE) : (short) 0;
        qgVar.n(z, i2, this.s, n(i, b, sFs));
        this.s.fs(sFs);
    }

    private void s(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw l.qg("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw l.qg("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        n(qgVar, i2);
    }

    private void n(qg qgVar, int i) throws IOException {
        this.s.tj();
        this.s.fs();
    }

    private void q(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw l.qg("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw l.qg("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iTj = this.s.tj();
        com.byazt.hf.qg qgVarN = com.byazt.hf.qg.n(iTj);
        if (qgVarN == null) {
            throw l.qg("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iTj));
        }
        qgVar.n(i2, qgVarN);
    }

    private void l(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw l.qg("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw l.qg("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw l.qg("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        sz szVar = new sz();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sRv = this.s.rv();
            int iTj = this.s.tj();
            if (sRv == 2) {
                if (iTj != 0 && iTj != 1) {
                    throw l.qg("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (sRv == 3) {
                sRv = 4;
            } else if (sRv != 4) {
                if (sRv == 5 && (iTj < 16384 || iTj > 16777215)) {
                    throw l.qg("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iTj));
                }
            } else {
                if (iTj < 0) {
                    throw l.qg("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
                sRv = 7;
            }
            szVar.n(sRv, iTj);
        }
        qgVar.n(false, szVar);
    }

    private void w(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw l.qg("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sFs = (b & 8) != 0 ? (short) (this.s.fs() & UByte.MAX_VALUE) : (short) 0;
        qgVar.n(i2, this.s.tj() & Integer.MAX_VALUE, n(n(i - 4, b, sFs), sFs, b, i2));
    }

    private void x(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw l.qg("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw l.qg("TYPE_PING streamId != 0", new Object[0]);
        }
        qgVar.n((b & 1) != 0, this.s.tj(), this.s.tj());
    }

    private void fs(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw l.qg("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw l.qg("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iTj = this.s.tj();
        int iTj2 = this.s.tj();
        int i3 = i - 8;
        com.byazt.hf.qg qgVarN = com.byazt.hf.qg.n(iTj2);
        if (qgVarN == null) {
            throw l.qg("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iTj2));
        }
        com.byazt.wa.w wVarS = com.byazt.wa.w.qg;
        if (i3 > 0) {
            wVarS = this.s.s(i3);
        }
        qgVar.n(iTj, qgVarN, wVarS);
    }

    private void rv(qg qgVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw l.qg("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jTj = ((long) this.s.tj()) & 2147483647L;
        if (jTj == 0) {
            throw l.qg("windowSizeIncrement was 0", Long.valueOf(jTj));
        }
        qgVar.n(i2, jTj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s.close();
    }

    @com.byazt.cp.n(n = {0, 1, 938, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    static final class n implements um {
        public short l;
        public int n;
        public int q;
        public byte qg;
        public int s;
        public final com.byazt.wa.l w;

        @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public n(com.byazt.wa.l lVar) {
            this.w = lVar;
        }

        @Override // com.byazt.wa.um
        public long n(com.byazt.wa.s sVar, long j) throws IOException {
            while (true) {
                int i = this.q;
                if (i == 0) {
                    this.w.fs(this.l);
                    this.l = (short) 0;
                    if ((this.qg & 4) != 0) {
                        return -1L;
                    }
                    qg();
                } else {
                    long jN = this.w.n(sVar, Math.min(j, i));
                    if (jN == -1) {
                        return -1L;
                    }
                    this.q = (int) (((long) this.q) - jN);
                    return jN;
                }
            }
        }

        @Override // com.byazt.wa.um
        public a n() {
            return this.w.n();
        }

        private void qg() throws IOException {
            int i = this.s;
            int iN = fs.n(this.w);
            this.q = iN;
            this.n = iN;
            byte bFs = (byte) (this.w.fs() & UByte.MAX_VALUE);
            this.qg = (byte) (this.w.fs() & UByte.MAX_VALUE);
            if (fs.n.isLoggable(Level.FINE)) {
                fs.n.fine(l.n(true, this.s, this.n, bFs, this.qg));
            }
            int iTj = this.w.tj() & Integer.MAX_VALUE;
            this.s = iTj;
            if (bFs != 9) {
                throw l.qg("%s != TYPE_CONTINUATION", Byte.valueOf(bFs));
            }
            if (iTj != i) {
                throw l.qg("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    public static int n(com.byazt.wa.l lVar) throws IOException {
        return (lVar.fs() & UByte.MAX_VALUE) | ((lVar.fs() & UByte.MAX_VALUE) << 16) | ((lVar.fs() & UByte.MAX_VALUE) << 8);
    }

    public static int n(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw l.qg("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
