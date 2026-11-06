package com.byazt.eb;

import com.byazt.hg.zo;
import com.byazt.pe.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1183, 20})
public class hn extends hw {
    public final AtomicBoolean hn;
    public final AtomicBoolean hw;
    public final AtomicBoolean k;
    public final AtomicBoolean pr;
    public final AtomicBoolean x;

    public hn(c cVar, zo.hn hnVar) {
        super(cVar);
        this.pr = new AtomicBoolean(false);
        this.hw = new AtomicBoolean(false);
        this.hn = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.c = hnVar;
    }

    @Override // com.byazt.eb.hw
    public void pr(int i, String str) {
        this.aj = i;
        this.vk = str;
        this.hw.set(true);
        this.k.set(true);
        pr();
    }

    public void pr() {
        if (this.x.get() && this.w != 2 && this.fw != null) {
            pr(this.fw, 2);
            return;
        }
        if (this.k.get()) {
            if (this.uc != null) {
                pr(this.uc, 1);
            } else if (this.hn.get()) {
                pr((com.byazt.pe.hn) null, 3);
            }
        }
    }

    private void pr(com.byazt.pe.hn hnVar, int i) {
        if (this.pr.compareAndSet(false, true)) {
            this.w = i;
            if (i == 3) {
                if (this.zo != null) {
                    this.zo.pr(this.aj, this.vk);
                    return;
                }
                return;
            } else {
                if (hnVar != null) {
                    hnVar.pr();
                    return;
                }
                return;
            }
        }
        if (hnVar != null) {
            hnVar.hn();
        }
    }

    @Override // com.byazt.eb.hw
    public void pr(boolean z) {
        if (z) {
            this.x.set(true);
            pr();
        } else {
            this.hn.set(true);
            pr();
        }
    }

    @Override // com.byazt.eb.hw
    public void hn() {
        this.k.set(true);
        pr();
    }
}
