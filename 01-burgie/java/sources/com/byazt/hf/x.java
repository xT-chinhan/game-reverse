package com.byazt.hf;

import com.byazt.sd.zo;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 219, 121})
public class x implements com.byazt.wt.pr.hw {
    public long hn;
    public long hw;
    public long pr;

    public x() {
        zo.nt().pr(this);
    }

    public void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.hw;
        if (j != 0) {
            this.pr += jCurrentTimeMillis - j;
        }
        this.hw = jCurrentTimeMillis;
    }

    public void uc() {
        if (this.hw == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.hn = jCurrentTimeMillis;
        this.pr += jCurrentTimeMillis - this.hw;
        this.hw = 0L;
        this.hn = 0L;
    }

    public long pr(TimeUnit timeUnit) {
        if (timeUnit != null) {
            return timeUnit.convert(this.pr, TimeUnit.MILLISECONDS);
        }
        return this.pr;
    }

    public void fw() {
        this.hw = 0L;
        this.hn = 0L;
        this.pr = 0L;
    }

    public void zo() {
        zo.nt().hw(this);
    }

    @Override // com.byazt.wt.pr.hw
    public void pr() {
        uc();
    }

    @Override // com.byazt.wt.pr.hw
    public void hw() {
        c();
    }

    @Override // com.byazt.wt.pr.hw
    public void hn() {
    }

    @Override // com.byazt.wt.pr.hw
    public void x() {
    }
}
