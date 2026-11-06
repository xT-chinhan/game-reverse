package com.byazt.gz;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, 62})
public class fw {
    public uc pr;

    public fw(uc ucVar) {
        this.pr = ucVar;
    }

    public boolean pr() {
        boolean zPr;
        if (this.pr.iu == null) {
            zPr = false;
        } else {
            zPr = this.pr.iu.pr();
        }
        this.pr.hn.getVisibility();
        return zPr || this.pr.hn.getVisibility() == 0;
    }

    public boolean hw() {
        if (com.byazt.lpk.pr.pr(this.pr.z)) {
            return true;
        }
        return (this.pr.zo != null && this.pr.zo.getVisibility() == 0) || (this.pr.vk != null && this.pr.vk.getVisibility() == 0) || ((this.pr.w != null && this.pr.w.getVisibility() == 0) || (this.pr.k != null && this.pr.k.getVisibility() == 0));
    }
}
