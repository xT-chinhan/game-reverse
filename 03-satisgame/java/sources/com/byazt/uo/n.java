package com.byazt.uo;

import android.content.Context;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1609, 19})
public class n extends s<CycleSkipView> {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ih.s
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public CycleSkipView n() {
        return new CycleSkipView(this.qg);
    }

    @Override // com.byazt.ih.s
    public void qg() {
        super.qg();
    }

    public void qg(int i, int i2) {
        if (this.l != 0) {
            ((CycleSkipView) this.l).n(i, i2);
        }
    }
}
