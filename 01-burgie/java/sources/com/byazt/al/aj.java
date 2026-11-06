package com.byazt.al;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 61})
public class aj extends com.byazt.cz.pr<PointF> {
    public Path vk;
    public final com.byazt.cz.pr<PointF> w;

    public aj(com.byazt.dx.uc ucVar, com.byazt.cz.pr<PointF> prVar) {
        super(ucVar, prVar.pr, prVar.hw, prVar.hn, prVar.x, prVar.c, prVar.uc, prVar.fw);
        this.w = prVar;
        pr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr() {
        boolean z = (this.hw == 0 || this.pr == 0 || !((PointF) this.pr).equals(((PointF) this.hw).x, ((PointF) this.hw).y)) ? false : true;
        if (this.pr != 0 && this.hw != 0 && !z) {
            this.vk = com.byazt.ptr.vk.pr((PointF) this.pr, (PointF) this.hw, this.w.zo, this.w.aj);
        }
    }

    public Path hw() {
        return this.vk;
    }
}
