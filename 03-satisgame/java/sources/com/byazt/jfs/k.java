package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 210})
public class k extends q {
    public k(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        float f;
        float fN = com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.qg.w());
        float fN2 = com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), this.qg.x());
        float f2 = 0.0f;
        if ("reverse".equals(this.qg.cy())) {
            f = fN2;
            fN2 = 0.0f;
            f2 = fN;
            fN = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.byazt.cq.s.n(this.s.getContext())) {
            fN = -fN;
            f2 = -f2;
        }
        this.s.setTranslationX(fN);
        this.s.setTranslationY(fN2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "translationX", fN, f2).setDuration((int) (this.qg.tj() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.s, "translationY", fN2, f).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        arrayList.add(n(duration2));
        return arrayList;
    }
}
