package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj implements um {
    public final cp q;
    public final l qg;
    public final Inflater s;
    public int n = 0;
    public final CRC32 l = new CRC32();

    public tj(um umVar) {
        if (umVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.s = inflater;
        l lVarN = d.n(umVar);
        this.qg = lVarN;
        this.q = new cp(lVarN, inflater);
    }

    @Override // com.byazt.wa.um
    public long n(s sVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.n == 0) {
            qg();
            this.n = 1;
        }
        if (this.n == 1) {
            long j2 = sVar.qg;
            long jN = this.q.n(sVar, j);
            if (jN != -1) {
                n(sVar, j2, jN);
                return jN;
            }
            this.n = 2;
        }
        if (this.n == 2) {
            s();
            this.n = 3;
            if (!this.qg.l()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private void qg() throws IOException {
        this.qg.n(10L);
        byte bQg = this.qg.s().qg(3L);
        boolean z = ((bQg >> 1) & 1) == 1;
        if (z) {
            n(this.qg.s(), 0L, 10L);
        }
        n("ID1ID2", 8075, this.qg.rv());
        this.qg.fs(8L);
        if (((bQg >> 2) & 1) == 1) {
            this.qg.n(2L);
            if (z) {
                n(this.qg.s(), 0L, 2L);
            }
            long jCp = this.qg.s().cp();
            this.qg.n(jCp);
            if (z) {
                n(this.qg.s(), 0L, jCp);
            }
            this.qg.fs(jCp);
        }
        if (((bQg >> 3) & 1) == 1) {
            long jN = this.qg.n((byte) 0);
            if (jN == -1) {
                throw new EOFException();
            }
            if (z) {
                n(this.qg.s(), 0L, jN + 1);
            }
            this.qg.fs(jN + 1);
        }
        if (((bQg >> 4) & 1) == 1) {
            long jN2 = this.qg.n((byte) 0);
            if (jN2 == -1) {
                throw new EOFException();
            }
            if (z) {
                n(this.qg.s(), 0L, jN2 + 1);
            }
            this.qg.fs(jN2 + 1);
        }
        if (z) {
            n("FHCRC", this.qg.cp(), (short) this.l.getValue());
            this.l.reset();
        }
    }

    private void s() throws IOException {
        n("CRC", this.qg.d(), (int) this.l.getValue());
        n("ISIZE", this.qg.d(), (int) this.s.getBytesWritten());
    }

    @Override // com.byazt.wa.um
    public a n() {
        return this.qg.n();
    }

    @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.q.close();
        } finally {
            this.s.end();
        }
    }

    private void n(s sVar, long j, long j2) {
        k kVar = sVar.n;
        while (j >= kVar.s - kVar.qg) {
            j -= (long) (kVar.s - kVar.qg);
            kVar = kVar.w;
        }
        while (j2 > 0) {
            int i = (int) (((long) kVar.qg) + j);
            int iMin = (int) Math.min(kVar.s - i, j2);
            this.l.update(kVar.n, i, iMin);
            j2 -= (long) iMin;
            kVar = kVar.w;
            j = 0;
        }
    }

    private void n(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
