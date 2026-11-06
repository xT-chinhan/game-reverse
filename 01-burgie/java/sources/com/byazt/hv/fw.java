package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 62})
public class fw extends x {
    public fw(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        this.hn.setTag(2097610709, Integer.valueOf(this.hw.hn()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        return arrayList;
    }
}
