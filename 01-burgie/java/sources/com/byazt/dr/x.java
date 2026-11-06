package com.byazt.dr;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.hg.of;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1091, 121})
public class x extends com.byazt.ji.hw {
    public boolean s;

    public x(Context context, ViewGroup viewGroup, of ofVar) {
        super(context, viewGroup, ofVar, null);
        pr(false);
    }

    @Override // com.byazt.ji.hw, com.byazt.ga.pr
    public int fo() {
        return 4;
    }

    @Override // com.byazt.ga.pr
    public void uc(boolean z) {
        super.uc(z);
    }

    public boolean rc() {
        return yb() != null && yb().k();
    }

    public boolean z() {
        return this.s;
    }

    public void fw(boolean z) {
        this.s = z;
    }

    @Override // com.byazt.ji.hw, com.byazt.ga.pr, com.byazt.w.hn
    public void zo() {
        if (this.s) {
            return;
        }
        super.zo();
    }

    @Override // com.byazt.ga.pr, com.byazt.w.hn
    public void vk() {
        this.s = false;
        super.vk();
    }
}
