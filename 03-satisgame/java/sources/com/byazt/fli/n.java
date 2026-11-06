package com.byazt.fli;

import com.byazt.gct.fs;
import com.byazt.gzx.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 19})
public abstract class n extends qg {
    public final AtomicBoolean n;
    public final AtomicBoolean q;
    public final AtomicBoolean qg;
    public final AtomicBoolean s;

    public abstract void n();

    public n(l lVar, fs.s sVar) {
        super(lVar);
        this.n = new AtomicBoolean(false);
        this.qg = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.l = sVar;
    }

    @Override // com.byazt.fli.qg
    public void n(int i, String str) {
        this.rv = i;
        this.tj = str;
        this.q.set(true);
        qg();
    }

    public void qg() {
        if (this.s.get() && this.x != null) {
            n(this.x, 2);
        } else if (this.q.get()) {
            if (this.w != null) {
                n(this.w, 1);
            } else {
                n((com.byazt.gzx.s) null, 3);
            }
        }
    }

    private void n(com.byazt.gzx.s sVar, int i) {
        if (this.n.compareAndSet(false, true)) {
            if (i == 3) {
                if (this.fs != null) {
                    this.fs.n(this.rv, this.tj);
                }
            } else if (sVar != null) {
                sVar.n();
            }
        }
    }

    @Override // com.byazt.fli.qg
    public void n(boolean z) {
        if (z) {
            this.s.set(true);
            qg();
        } else {
            this.qg.set(true);
            n();
        }
    }

    @Override // com.byazt.fli.qg
    public void s() {
        this.q.set(true);
        qg();
    }
}
