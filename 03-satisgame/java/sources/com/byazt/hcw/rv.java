package com.byazt.hcw;

import com.byazt.pq.bb;
import com.byazt.tbt.cp;
import com.byazt.tbt.cy;
import com.byazt.tbt.hd;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends cy {
    public bb n;

    public rv(bb bbVar) {
        this.n = bbVar;
    }

    @Override // com.byazt.tbt.cy
    public long n() {
        return this.n.k();
    }

    @Override // com.byazt.tbt.cy
    public long qg() {
        return this.n.sz();
    }

    @Override // com.byazt.tbt.cy
    public sz s() {
        return new fs(this.n.qg());
    }

    @Override // com.byazt.tbt.cy
    public int q() {
        bb bbVar = this.n;
        if (bbVar != null) {
            return bbVar.q();
        }
        return 0;
    }

    @Override // com.byazt.tbt.cy
    public boolean l() {
        return this.n.l();
    }

    @Override // com.byazt.tbt.cy
    public String w() {
        return this.n.w();
    }

    @Override // com.byazt.tbt.cy
    public hd x() {
        return new tj(this.n.rv());
    }

    @Override // com.byazt.tbt.cy
    public com.byazt.tbt.w fs() {
        return new com.byazt.tbt.w(this.n.fs().n);
    }

    @Override // com.byazt.tbt.cy
    public String n(String str) {
        return this.n.qg(str);
    }

    @Override // com.byazt.tbt.cy
    public String n(String str, String str2) {
        return this.n.n(str, str2);
    }

    @Override // com.byazt.tbt.cy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.n.close();
    }

    public String toString() {
        return this.n.toString();
    }

    @Override // com.byazt.tbt.cy
    public cp rv() {
        if (this.n == null) {
            return null;
        }
        return new cp(this.n.cy());
    }

    @Override // com.byazt.tbt.cy
    public String tj() {
        bb bbVar = this.n;
        if (bbVar == null) {
            return null;
        }
        return bbVar.n();
    }
}
