package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 13})
public class w extends q {
    public w(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        float f = this.s.getLayoutParams().width;
        this.s.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationX", f, 0.0f).setDuration((int) (this.qg.tj() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        arrayList.add(n(duration2));
        return arrayList;
    }
}
