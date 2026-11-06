package com.byazt.eb;

import com.byazt.ca.aj;
import com.byazt.hg.zo;
import com.byazt.pe.c;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1183, 121})
public class x extends hw implements Runnable {
    public final String g;
    public final AtomicBoolean hn;
    public final AtomicBoolean hw;
    public final AtomicBoolean k;
    public final int m;
    public final AtomicBoolean pr;
    public final AtomicBoolean x;

    public x(c cVar, zo.hn hnVar, int i, String str) {
        super(cVar);
        this.pr = new AtomicBoolean(false);
        this.hw = new AtomicBoolean(false);
        this.hn = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.c = hnVar;
        this.m = i;
        this.g = str;
    }

    @Override // com.byazt.eb.hw
    public void pr(int i, String str) {
        this.aj = i;
        this.vk = str;
        this.hn.set(true);
        this.k.set(true);
        hw();
    }

    public void pr() {
        aj.hw().postDelayed(this, c());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pr.set(true);
        hw();
    }

    public void hw() {
        if (this.k.get()) {
            aj.hw().removeCallbacks(this);
            if (this.uc != null) {
                pr(this.uc, 1);
                return;
            }
            if (this.x.get()) {
                if (this.hn.get()) {
                    if (this.c.pr("forbid_realtime_use_cache", new zo.hw.pr().pr(this.aj).pr())) {
                        pr((com.byazt.pe.hn) null, 3);
                        return;
                    }
                }
                if (this.fw != null) {
                    pr(this.fw, 2);
                    return;
                } else {
                    pr((com.byazt.pe.hn) null, 3);
                    return;
                }
            }
            return;
        }
        if (this.pr.get() && this.x.get()) {
            if (zo.pr(this.w).pr("forbid_realtime_use_cache", new zo.hw.pr().pr(-666).pr()) || this.fw == null) {
                return;
            }
            pr(this.fw, 2);
        }
    }

    private void pr(com.byazt.pe.hn hnVar, int i) {
        if (this.hw.compareAndSet(false, true)) {
            this.w = i;
            if (i == 3) {
                if (this.zo != null) {
                    this.zo.pr(this.aj, this.vk);
                }
            } else if (hnVar != null) {
                hnVar.pr();
            }
            if (i == 1 && this.fw != null) {
                this.fw.hn();
            }
            if (i == 2 && this.uc != null) {
                this.uc.hn();
                return;
            }
            return;
        }
        if (i != this.w && hnVar != null) {
            hnVar.hn();
        }
    }

    @Override // com.byazt.eb.hw
    public void pr(boolean z) {
        this.x.set(true);
        hw();
    }

    @Override // com.byazt.eb.hw
    public void hn() {
        this.k.set(true);
        hw();
    }

    private long c() {
        long jPr = com.byazt.cf.hw.pr().pr(this.m, this.g);
        if (jPr > 0) {
            return jPr;
        }
        return (this.c == null || this.c.uc() <= 0) ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : this.c.uc();
    }
}
