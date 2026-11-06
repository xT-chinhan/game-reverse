package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 250})
public class k extends x {
    public k(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        int i;
        int i2;
        this.hn.setTag(2097610711, Integer.valueOf(this.hw.x()));
        if (this.hn != null && com.byazt.js.hn.pr(this.hn.getContext())) {
            i2 = 1;
            i = 0;
        } else {
            i = 1;
            i2 = 0;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "shineValue", i2, i).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        return arrayList;
    }
}
