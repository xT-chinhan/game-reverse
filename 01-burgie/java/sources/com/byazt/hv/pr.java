package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 37})
public class pr extends x {
    public pr(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        float fLb = this.hw.lb() / 100.0f;
        float fQa = this.hw.qa() / 100.0f;
        if ("reverse".equals(this.hw.nt()) && this.hw.g() <= 0.0d) {
            fQa = fLb;
            fLb = fQa;
        }
        this.hn.setAlpha(fLb);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "alpha", fLb, fQa).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        return arrayList;
    }
}
