package com.byazt.fli;

import com.byazt.gct.fs;
import com.byazt.gzx.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 8})
public class s extends qg {
    public final AtomicBoolean d;
    public final AtomicBoolean n;
    public final AtomicBoolean q;
    public final AtomicBoolean qg;
    public final AtomicBoolean s;

    public s(l lVar, fs.s sVar) {
        super(lVar);
        this.n = new AtomicBoolean(false);
        this.qg = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.l = sVar;
    }

    @Override // com.byazt.fli.qg
    public void n(int i, String str) {
        this.rv = i;
        this.tj = str;
        this.qg.set(true);
        this.d.set(true);
        n();
    }

    public void n() {
        if (this.q.get() && this.cp != 2 && this.x != null) {
            n(this.x, 2);
            return;
        }
        if (this.d.get()) {
            if (this.w != null) {
                n(this.w, 1);
            } else if (this.s.get()) {
                n((com.byazt.gzx.s) null, 3);
            }
        }
    }

    private void n(com.byazt.gzx.s sVar, int i) {
        if (!this.n.compareAndSet(false, true)) {
            if (sVar != null) {
                sVar.s();
                return;
            }
            return;
        }
        this.cp = i;
        if (i == 3) {
            if (this.fs != null) {
                this.fs.n(this.rv, this.tj);
            }
        } else if (sVar != null) {
            sVar.n();
        }
    }

    @Override // com.byazt.fli.qg
    public void n(boolean z) {
        if (z) {
            this.q.set(true);
            n();
        } else {
            this.s.set(true);
            n();
        }
    }

    @Override // com.byazt.fli.qg
    public void s() {
        this.d.set(true);
        n();
    }
}
