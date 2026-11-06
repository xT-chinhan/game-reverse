package com.byazt.cv;

import com.byazt.sd.fo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 439, 37})
public class pr implements fo.hw {
    public int hw;
    public fo.hw pr;

    public pr(fo.hw hwVar) {
        this.pr = hwVar;
    }

    public void pr(int i) {
        this.hw = i;
    }

    @Override // com.byazt.sd.fo.hw
    public void pr(int i, String str, com.byazt.hg.hw hwVar) {
        fo.hw hwVar2 = this.pr;
        if (hwVar2 != null) {
            hwVar2.pr(i, str, hwVar);
        }
    }

    @Override // com.byazt.sd.fo.hw
    public void pr(final com.byazt.hg.pr prVar, final com.byazt.hg.hw hwVar) {
        com.byazt.jx.pr.pr(prVar);
        int i = this.hw;
        boolean z = true;
        boolean z2 = i == 3 || i == 4;
        if (z2) {
            z = (com.byazt.mp.c.pr().k() & 1) != 1;
        }
        if (z) {
            if (this.pr != null) {
                Runnable runnable = new Runnable() { // from class: com.byazt.cv.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pr.this.pr.pr(prVar, hwVar);
                    }
                };
                if (z2) {
                    com.byazt.zp.zo.pr(runnable);
                    return;
                } else {
                    com.byazt.zp.zo.hn(runnable);
                    return;
                }
            }
            return;
        }
        fo.hw hwVar2 = this.pr;
        if (hwVar2 != null) {
            hwVar2.pr(prVar, hwVar);
        }
    }
}
