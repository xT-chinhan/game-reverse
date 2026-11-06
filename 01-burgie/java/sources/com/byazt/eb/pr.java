package com.byazt.eb;

import com.byazt.hg.zo;
import com.byazt.pe.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1183, 37})
public abstract class pr extends hw {
    public final AtomicBoolean hn;
    public final AtomicBoolean hw;
    public final AtomicBoolean pr;
    public final AtomicBoolean x;

    public abstract void pr();

    public pr(c cVar, zo.hn hnVar) {
        super(cVar);
        this.pr = new AtomicBoolean(false);
        this.hw = new AtomicBoolean(false);
        this.hn = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.c = hnVar;
    }

    @Override // com.byazt.eb.hw
    public void pr(int i, String str) {
        this.aj = i;
        this.vk = str;
        this.x.set(true);
        hw();
    }

    public void hw() {
        if (this.hn.get() && this.fw != null) {
            pr(this.fw, 2);
        } else if (this.x.get()) {
            if (this.uc != null) {
                pr(this.uc, 1);
            } else {
                pr((com.byazt.pe.hn) null, 3);
            }
        }
    }

    private void pr(com.byazt.pe.hn hnVar, int i) {
        if (this.pr.compareAndSet(false, true)) {
            if (i == 3) {
                if (this.zo != null) {
                    this.zo.pr(this.aj, this.vk);
                }
            } else if (hnVar != null) {
                hnVar.pr();
            }
        }
    }

    @Override // com.byazt.eb.hw
    public void pr(boolean z) {
        if (z) {
            this.hn.set(true);
            hw();
        } else {
            this.hw.set(true);
            pr();
        }
    }

    @Override // com.byazt.eb.hw
    public void hn() {
        this.x.set(true);
        hw();
    }
}
