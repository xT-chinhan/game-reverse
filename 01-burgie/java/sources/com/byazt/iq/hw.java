package com.byazt.iq;

import com.byazt.ca.aj;
import com.byazt.sd.zo;
import com.byazt.vkw.b;
import com.byazt.zs.uc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1612, 13})
public class hw {
    public long hn;
    public int hw;
    public int pr = 10000;
    public Runnable x;

    public hw(int i) {
        this.hw = i;
    }

    public hw pr(int i) {
        this.pr = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public void pr(final Runnable runnable) {
        this.hn = System.currentTimeMillis();
        if (!pr.uc()) {
            hw(runnable);
            return;
        }
        if (zo.nt().y()) {
            hw(2);
            pr();
        } else if (!pr.pr()) {
            hw(runnable);
        } else {
            aj.pr().postDelayed(new Runnable() { // from class: com.byazt.iq.hw.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zo.nt().y()) {
                        hw.this.hw(2);
                        hw.this.pr();
                    } else {
                        hw.this.hw(runnable);
                    }
                }
            }, this.pr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(Runnable runnable) {
        b bVar = (b) uc.pr("m_s");
        if (bVar != null && bVar.hw(0, this.hw, true)) {
            hw(3);
            pr();
        } else if (runnable != null) {
            hw(1);
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        Runnable runnable = this.x;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(int i) {
        System.currentTimeMillis();
    }
}
