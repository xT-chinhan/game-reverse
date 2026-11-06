package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 19})
public class ho extends x {
    public ho(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        float f;
        float fPr = com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.hw.uc());
        float fPr2 = com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.hw.fw());
        float f2 = 0.0f;
        if (!"reverse".equals(this.hw.nt())) {
            f = 0.0f;
        } else {
            f = fPr2;
            fPr2 = 0.0f;
            f2 = fPr;
            fPr = 0.0f;
        }
        if (com.byazt.js.hn.pr(this.hn.getContext())) {
            fPr = -fPr;
            f2 = -f2;
        }
        this.hn.setTranslationX(fPr);
        this.hn.setTranslationY(fPr2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationX", fPr, f2).setDuration((int) (this.hw.vk() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hn, "translationY", fPr2, f).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        arrayList.add(pr(duration2));
        return arrayList;
    }
}
