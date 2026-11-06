package com.byazt.gz;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.hg.of;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, 20})
public class hn extends x {
    public hn(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, ofVar, str, z, z2, z3);
    }

    @Override // com.byazt.gz.x
    public void pr(int i, int i2) {
        super.pr(i, i2);
        if (this.c != null && i > 0 && i2 > 0) {
            this.c.hn(i, i2);
            this.c.pr(i, i2);
            hw(-1, -1);
        }
    }

    @Override // com.byazt.gz.x
    public com.byazt.c.hw fo() {
        if (this.c != null) {
            return this.c.yb();
        }
        return null;
    }
}
