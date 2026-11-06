package com.byazt.sb;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.byazt.zp.k;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 765, 20})
public class hn extends com.byazt.ga.pr {
    public boolean s;

    public hn(Context context, ViewGroup viewGroup, of ofVar, com.byazt.az.pr prVar) {
        super(context, viewGroup, ofVar, prVar);
        this.s = true;
        pr(false);
    }

    @Override // com.byazt.ga.pr
    public int fo() {
        return 5;
    }

    @Override // com.byazt.ga.pr
    public void uc(boolean z) {
        super.uc(z);
        if (this.s) {
            if (!k.pr(this.uc) || c()) {
                hw();
            }
        }
    }

    public void rc() {
        qn();
    }

    @Override // com.byazt.ga.pr
    public boolean t_() {
        return false;
    }

    public void fw(boolean z) {
        this.s = z;
    }
}
