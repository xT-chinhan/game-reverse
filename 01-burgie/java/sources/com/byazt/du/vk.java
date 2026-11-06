package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 50})
public final class vk implements qa {
    public final Inflater hn;
    public final c hw;
    public final w x;
    public int pr = 0;
    public final CRC32 c = new CRC32();

    public vk(qa qaVar) {
        if (qaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.hn = inflater;
        c cVarPr = k.pr(qaVar);
        this.hw = cVarPr;
        this.x = new w(cVarPr, inflater);
    }

    @Override // com.byazt.du.qa
    public long pr(hn hnVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.pr == 0) {
            hw();
            this.pr = 1;
        }
        if (this.pr == 1) {
            long j2 = hnVar.hw;
            long jPr = this.x.pr(hnVar, j);
            if (jPr != -1) {
                pr(hnVar, j2, jPr);
                return jPr;
            }
            this.pr = 2;
        }
        if (this.pr == 2) {
            hn();
            this.pr = 3;
            if (!this.hw.c()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void hw() throws IOException {
        this.hw.pr(10L);
        byte bHw = this.hw.hn().hw(3L);
        boolean z = ((bHw >> 1) & 1) == 1;
        if (z) {
            pr(this.hw.hn(), 0L, 10L);
        }
        pr("ID1ID2", 8075, this.hw.aj());
        this.hw.zo(8L);
        if (((bHw >> 2) & 1) == 1) {
            this.hw.pr(2L);
            if (z) {
                pr(this.hw.hn(), 0L, 2L);
            }
            long jW = this.hw.hn().w();
            this.hw.pr(jW);
            if (z) {
                pr(this.hw.hn(), 0L, jW);
            }
            this.hw.zo(jW);
        }
        if (((bHw >> 3) & 1) == 1) {
            long jPr = this.hw.pr((byte) 0);
            if (jPr == -1) {
                throw new EOFException();
            }
            if (z) {
                pr(this.hw.hn(), 0L, jPr + 1);
            }
            this.hw.zo(jPr + 1);
        }
        if (((bHw >> 4) & 1) == 1) {
            long jPr2 = this.hw.pr((byte) 0);
            if (jPr2 == -1) {
                throw new EOFException();
            }
            if (z) {
                pr(this.hw.hn(), 0L, jPr2 + 1);
            }
            this.hw.zo(jPr2 + 1);
        }
        if (z) {
            pr("FHCRC", this.hw.w(), (short) this.c.getValue());
            this.c.reset();
        }
    }

    private void hn() throws IOException {
        pr("CRC", this.hw.k(), (int) this.c.getValue());
        pr("ISIZE", this.hw.k(), (int) this.hn.getBytesWritten());
    }

    @Override // com.byazt.du.qa
    public a pr() {
        return this.hw.pr();
    }

    @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.x.close();
        } finally {
            this.hn.end();
        }
    }

    private void pr(hn hnVar, long j, long j2) {
        ho hoVar = hnVar.pr;
        while (j >= hoVar.hn - hoVar.hw) {
            j -= (long) (hoVar.hn - hoVar.hw);
            hoVar = hoVar.uc;
        }
        while (j2 > 0) {
            int i = (int) (((long) hoVar.hw) + j);
            int iMin = (int) Math.min(hoVar.hn - i, j2);
            this.c.update(hoVar.pr, i, iMin);
            j2 -= (long) iMin;
            hoVar = hoVar.uc;
            j = 0;
        }
    }

    private void pr(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
