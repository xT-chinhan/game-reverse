package com.byazt.hcw;

import com.byazt.pq.ln;
import com.byazt.pq.py;
import com.byazt.tbt.hd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 95, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends hd {
    public ln n;

    public tj(ln lnVar) {
        this.n = lnVar;
    }

    @Override // com.byazt.tbt.hd
    public long n() {
        ln lnVar = this.n;
        if (lnVar != null) {
            return lnVar.qg();
        }
        return -1L;
    }

    @Override // com.byazt.tbt.hd
    public String qg() {
        try {
            return this.n.w();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.byazt.tbt.hd, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ln lnVar = this.n;
        if (lnVar != null) {
            lnVar.close();
        }
    }

    @Override // com.byazt.tbt.hd
    public InputStream s() {
        ln lnVar = this.n;
        if (lnVar != null) {
            return lnVar.q();
        }
        return null;
    }

    @Override // com.byazt.tbt.hd
    public byte[] q() {
        try {
            return this.n.l();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.byazt.tbt.hd
    public com.byazt.tbt.tj l() {
        py pyVarN;
        ln lnVar = this.n;
        if (lnVar == null || (pyVarN = lnVar.n()) == null) {
            return null;
        }
        return new com.byazt.tbt.tj(pyVarN.toString(), pyVarN.n(), pyVarN.qg(), pyVarN.s() != null ? pyVarN.s().name() : null);
    }
}
