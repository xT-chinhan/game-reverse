package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 5})
public class uc extends x {
    public uc(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        float f = this.hn.getLayoutParams().width;
        this.hn.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationX", f, 0.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hn, "alpha", 0.0f, 1.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        arrayList.add(pr(duration2));
        return arrayList;
    }
}
