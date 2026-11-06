package com.byazt.fli;

import com.byazt.gct.fs;
import com.byazt.gzx.l;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 5})
public class q extends qg implements Runnable {
    public final AtomicBoolean d;
    public final AtomicBoolean n;
    public final int oa;
    public final AtomicBoolean q;
    public final AtomicBoolean qg;
    public final AtomicBoolean s;
    public final String sz;

    public q(l lVar, fs.s sVar, int i, String str) {
        super(lVar);
        this.n = new AtomicBoolean(false);
        this.qg = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.l = sVar;
        this.oa = i;
        this.sz = str;
    }

    @Override // com.byazt.fli.qg
    public void n(int i, String str) {
        this.rv = i;
        this.tj = str;
        this.s.set(true);
        this.d.set(true);
        qg();
    }

    public void n() {
        rv.qg().postDelayed(this, l());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.n.set(true);
        qg();
    }

    public void qg() {
        if (this.d.get()) {
            rv.qg().removeCallbacks(this);
            if (this.w != null) {
                n(this.w, 1);
                return;
            }
            if (this.q.get()) {
                if (this.s.get()) {
                    if (this.l.n("forbid_realtime_use_cache", new fs.qg.n().n(this.rv).n())) {
                        n((com.byazt.gzx.s) null, 3);
                        return;
                    }
                }
                if (this.x != null) {
                    n(this.x, 2);
                    return;
                } else {
                    n((com.byazt.gzx.s) null, 3);
                    return;
                }
            }
            return;
        }
        if (this.n.get() && this.q.get()) {
            if (fs.n(this.cp).n("forbid_realtime_use_cache", new fs.qg.n().n(-666).n()) || this.x == null) {
                return;
            }
            n(this.x, 2);
        }
    }

    private void n(com.byazt.gzx.s sVar, int i) {
        if (this.qg.compareAndSet(false, true)) {
            this.cp = i;
            if (i == 3) {
                if (this.fs != null) {
                    this.fs.n(this.rv, this.tj);
                }
            } else if (sVar != null) {
                sVar.n();
            }
            if (i == 1 && this.x != null) {
                this.x.s();
            }
            if (i != 2 || this.w == null) {
                return;
            }
            this.w.s();
            return;
        }
        if (i == this.cp || sVar == null) {
            return;
        }
        sVar.s();
    }

    @Override // com.byazt.fli.qg
    public void n(boolean z) {
        this.q.set(true);
        qg();
    }

    @Override // com.byazt.fli.qg
    public void s() {
        this.d.set(true);
        qg();
    }

    private long l() {
        long jN = com.byazt.bh.qg.n().n(this.oa, this.sz);
        if (jN > 0) {
            return jN;
        }
        if (this.l == null || this.l.w() <= 0) {
            return 10000L;
        }
        return this.l.w();
    }
}
