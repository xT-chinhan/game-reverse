package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 109})
public final class w implements qa {
    public int hn;
    public final Inflater hw;
    public final c pr;
    public boolean x;

    public w(c cVar, Inflater inflater) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.pr = cVar;
        this.hw = inflater;
    }

    @Override // com.byazt.du.qa
    public long pr(hn hnVar, long j) throws IOException {
        boolean zHw;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.x) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zHw = hw();
            try {
                ho hoVarC = hnVar.c(1);
                int iInflate = this.hw.inflate(hoVarC.pr, hoVarC.hn, (int) Math.min(j, 8192 - hoVarC.hn));
                if (iInflate > 0) {
                    hoVarC.hn += iInflate;
                    long j2 = iInflate;
                    hnVar.hw += j2;
                    return j2;
                }
                if (!this.hw.finished() && !this.hw.needsDictionary()) {
                }
                hn();
                if (hoVarC.hw == hoVarC.hn) {
                    hnVar.pr = hoVarC.hw();
                    nt.pr(hoVarC);
                    return -1L;
                }
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zHw);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean hw() throws IOException {
        if (!this.hw.needsInput()) {
            return false;
        }
        hn();
        if (this.hw.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.pr.c()) {
            return true;
        }
        ho hoVar = this.pr.hn().pr;
        this.hn = hoVar.hn - hoVar.hw;
        this.hw.setInput(hoVar.pr, hoVar.hw, this.hn);
        return false;
    }

    private void hn() throws IOException {
        int i = this.hn;
        if (i == 0) {
            return;
        }
        int remaining = i - this.hw.getRemaining();
        this.hn -= remaining;
        this.pr.zo(remaining);
    }

    @Override // com.byazt.du.qa
    public a pr() {
        return this.pr.pr();
    }

    @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.x) {
            return;
        }
        this.hw.end();
        this.x = true;
        this.pr.close();
    }
}
