package com.byazt.cpq;

import com.byazt.du.a;
import com.byazt.du.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo implements Closeable {
    public static final Logger pr = Logger.getLogger(c.class.getName());
    public final boolean c;
    public final com.byazt.du.c hn;
    public final x.pr hw;
    public final pr x;

    interface hw {
        void pr(int i, int i2, List<hn> list) throws IOException;

        void pr(int i, long j);

        void pr(int i, com.byazt.cpq.hw hwVar);

        void pr(int i, com.byazt.cpq.hw hwVar, com.byazt.du.uc ucVar);

        void pr(boolean z, int i, int i2);

        void pr(boolean z, int i, int i2, List<hn> list);

        void pr(boolean z, int i, com.byazt.du.c cVar, int i2) throws IOException;

        void pr(boolean z, g gVar);
    }

    public zo(com.byazt.du.c cVar, boolean z) {
        this.hn = cVar;
        this.c = z;
        pr prVar = new pr(cVar);
        this.x = prVar;
        this.hw = new x.pr(4096, prVar);
    }

    public void pr(hw hwVar) throws IOException {
        if (this.c) {
            if (!pr(true, hwVar)) {
                throw c.hw("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        com.byazt.du.uc ucVarHn = this.hn.hn(c.pr.fw());
        Logger logger = pr;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(com.byazt.xx.hn.pr("<< CONNECTION %s", ucVarHn.c()));
        }
        if (!c.pr.equals(ucVarHn)) {
            throw c.hw("Expected a connection header but was %s", ucVarHn.pr());
        }
    }

    public boolean pr(boolean z, hw hwVar) throws IOException {
        try {
            this.hn.pr(9L);
            int iPr = pr(this.hn);
            if (iPr < 0 || iPr > 16384) {
                throw c.hw("FRAME_SIZE_ERROR: %s", Integer.valueOf(iPr));
            }
            byte bZo = (byte) (this.hn.zo() & UByte.MAX_VALUE);
            if (z && bZo != 4) {
                throw c.hw("Expected a SETTINGS frame but was %s", Byte.valueOf(bZo));
            }
            byte bZo2 = (byte) (this.hn.zo() & UByte.MAX_VALUE);
            int iVk = this.hn.vk() & Integer.MAX_VALUE;
            Logger logger = pr;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.pr(true, iVk, iPr, bZo, bZo2));
            }
            switch (bZo) {
                case 0:
                    hw(hwVar, iPr, bZo2, iVk);
                    return true;
                case 1:
                    pr(hwVar, iPr, bZo2, iVk);
                    return true;
                case 2:
                    hn(hwVar, iPr, bZo2, iVk);
                    return true;
                case 3:
                    x(hwVar, iPr, bZo2, iVk);
                    return true;
                case 4:
                    c(hwVar, iPr, bZo2, iVk);
                    return true;
                case 5:
                    uc(hwVar, iPr, bZo2, iVk);
                    return true;
                case 6:
                    fw(hwVar, iPr, bZo2, iVk);
                    return true;
                case 7:
                    zo(hwVar, iPr, bZo2, iVk);
                    return true;
                case 8:
                    aj(hwVar, iPr, bZo2, iVk);
                    return true;
                default:
                    this.hn.zo(iPr);
                    return true;
            }
        } catch (IOException e) {
            return false;
        }
    }

    private void pr(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw c.hw("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short sZo = (b & 8) != 0 ? (short) (this.hn.zo() & UByte.MAX_VALUE) : (short) 0;
        if ((b & 32) != 0) {
            pr(hwVar, i2);
            i -= 5;
        }
        hwVar.pr(z, i2, -1, pr(pr(i, b, sZo), sZo, b, i2));
    }

    private List<hn> pr(int i, short s, byte b, int i2) throws IOException {
        pr prVar = this.x;
        prVar.x = i;
        prVar.pr = i;
        this.x.c = s;
        this.x.hw = b;
        this.x.hn = i2;
        this.hw.pr();
        return this.hw.hw();
    }

    private void hw(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw c.hw("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw c.hw("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short sZo = (b & 8) != 0 ? (short) (this.hn.zo() & UByte.MAX_VALUE) : (short) 0;
        hwVar.pr(z, i2, this.hn, pr(i, b, sZo));
        this.hn.zo(sZo);
    }

    private void hn(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw c.hw("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw c.hw("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        pr(hwVar, i2);
    }

    private void pr(hw hwVar, int i) throws IOException {
        this.hn.vk();
        this.hn.zo();
    }

    private void x(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw c.hw("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw c.hw("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int iVk = this.hn.vk();
        com.byazt.cpq.hw hwVarPr = com.byazt.cpq.hw.pr(iVk);
        if (hwVarPr == null) {
            throw c.hw("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iVk));
        }
        hwVar.pr(i2, hwVarPr);
    }

    private void c(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw c.hw("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw c.hw("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            return;
        }
        if (i % 6 != 0) {
            throw c.hw("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        g gVar = new g();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sAj = this.hn.aj();
            int iVk = this.hn.vk();
            switch (sAj) {
                case 2:
                    if (iVk != 0 && iVk != 1) {
                        throw c.hw("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                    break;
                case 3:
                    sAj = 4;
                    break;
                case 4:
                    sAj = 7;
                    if (iVk < 0) {
                        throw c.hw("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                    break;
                case 5:
                    if (iVk < 16384 || iVk > 16777215) {
                        throw c.hw("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iVk));
                    }
                    break;
                    break;
            }
            gVar.pr(sAj, iVk);
        }
        hwVar.pr(false, gVar);
    }

    private void uc(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw c.hw("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short sZo = (b & 8) != 0 ? (short) (this.hn.zo() & UByte.MAX_VALUE) : (short) 0;
        hwVar.pr(i2, this.hn.vk() & Integer.MAX_VALUE, pr(pr(i - 4, b, sZo), sZo, b, i2));
    }

    private void fw(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw c.hw("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw c.hw("TYPE_PING streamId != 0", new Object[0]);
        }
        hwVar.pr((b & 1) != 0, this.hn.vk(), this.hn.vk());
    }

    private void zo(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw c.hw("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw c.hw("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int iVk = this.hn.vk();
        int iVk2 = this.hn.vk();
        int i3 = i - 8;
        com.byazt.cpq.hw hwVarPr = com.byazt.cpq.hw.pr(iVk2);
        if (hwVarPr == null) {
            throw c.hw("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iVk2));
        }
        com.byazt.du.uc ucVarHn = com.byazt.du.uc.hw;
        if (i3 > 0) {
            ucVarHn = this.hn.hn(i3);
        }
        hwVar.pr(iVk, hwVarPr, ucVarHn);
    }

    private void aj(hw hwVar, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw c.hw("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long jVk = ((long) this.hn.vk()) & 2147483647L;
        if (jVk == 0) {
            throw c.hw("windowSizeIncrement was 0", Long.valueOf(jVk));
        }
        hwVar.pr(i2, jVk);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.hn.close();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 673})
    static final class pr implements qa {
        public short c;
        public int hn;
        public byte hw;
        public int pr;
        public final com.byazt.du.c uc;
        public int x;

        public pr(com.byazt.du.c cVar) {
            this.uc = cVar;
        }

        @Override // com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            while (true) {
                int i = this.x;
                if (i == 0) {
                    this.uc.zo(this.c);
                    this.c = (short) 0;
                    if ((this.hw & 4) != 0) {
                        return -1L;
                    }
                    hw();
                } else {
                    long jPr = this.uc.pr(hnVar, Math.min(j, i));
                    if (jPr == -1) {
                        return -1L;
                    }
                    this.x = (int) (((long) this.x) - jPr);
                    return jPr;
                }
            }
        }

        @Override // com.byazt.du.qa
        public a pr() {
            return this.uc.pr();
        }

        @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        private void hw() throws IOException {
            int i = this.hn;
            int iPr = zo.pr(this.uc);
            this.x = iPr;
            this.pr = iPr;
            byte bZo = (byte) (this.uc.zo() & UByte.MAX_VALUE);
            this.hw = (byte) (this.uc.zo() & UByte.MAX_VALUE);
            if (zo.pr.isLoggable(Level.FINE)) {
                zo.pr.fine(c.pr(true, this.hn, this.pr, bZo, this.hw));
            }
            int iVk = this.uc.vk() & Integer.MAX_VALUE;
            this.hn = iVk;
            if (bZo != 9) {
                throw c.hw("%s != TYPE_CONTINUATION", Byte.valueOf(bZo));
            }
            if (iVk != i) {
                throw c.hw("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    public static int pr(com.byazt.du.c cVar) throws IOException {
        return (cVar.zo() & UByte.MAX_VALUE) | ((cVar.zo() & UByte.MAX_VALUE) << 16) | ((cVar.zo() & UByte.MAX_VALUE) << 8);
    }

    public static int pr(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw c.hw("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
