package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 29})
public final class cp implements um {
    public final l n;
    public boolean q;
    public final Inflater qg;
    public int s;

    public cp(l lVar, Inflater inflater) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.n = lVar;
        this.qg = inflater;
    }

    @Override // com.byazt.wa.um
    public long n(s sVar, long j) throws IOException {
        boolean zQg;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.q) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zQg = qg();
            try {
                k kVarL = sVar.l(1);
                int iInflate = this.qg.inflate(kVarL.n, kVarL.s, (int) Math.min(j, 8192 - kVarL.s));
                if (iInflate > 0) {
                    kVarL.s += iInflate;
                    long j2 = iInflate;
                    sVar.qg += j2;
                    return j2;
                }
                if (!this.qg.finished() && !this.qg.needsDictionary()) {
                }
                s();
                if (kVarL.qg != kVarL.s) {
                    return -1L;
                }
                sVar.n = kVarL.qg();
                cy.n(kVarL);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zQg);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean qg() throws IOException {
        if (!this.qg.needsInput()) {
            return false;
        }
        s();
        if (this.qg.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.n.l()) {
            return true;
        }
        k kVar = this.n.s().n;
        this.s = kVar.s - kVar.qg;
        this.qg.setInput(kVar.n, kVar.qg, this.s);
        return false;
    }

    private void s() throws IOException {
        int i = this.s;
        if (i == 0) {
            return;
        }
        int remaining = i - this.qg.getRemaining();
        this.s -= remaining;
        this.n.fs(remaining);
    }

    @Override // com.byazt.wa.um
    public a n() {
        return this.n.n();
    }

    @Override // com.byazt.wa.um, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.q) {
            return;
        }
        this.qg.end();
        this.q = true;
        this.n.close();
    }
}
