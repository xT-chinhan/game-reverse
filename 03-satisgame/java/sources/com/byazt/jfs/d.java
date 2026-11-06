package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 113})
public class d extends q {
    public d(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        int i;
        int i2;
        this.s.setTag(2097610711, Integer.valueOf(this.qg.q()));
        if (this.s == null || !com.byazt.cq.s.n(this.s.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "shineValue", i, i2).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        return arrayList;
    }
}
