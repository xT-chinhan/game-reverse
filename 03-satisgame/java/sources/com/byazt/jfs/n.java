package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 19})
public class n extends q {
    public n(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        float fCd = this.qg.cd() / 100.0f;
        float fUm = this.qg.um() / 100.0f;
        if ("reverse".equals(this.qg.cy()) && this.qg.sz() <= 0.0d) {
            fUm = fCd;
            fCd = fUm;
        }
        this.s.setAlpha(fCd);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "alpha", fCd, fUm).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        return arrayList;
    }
}
