package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 74})
public class nt extends x {
    public nt(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "translationX", 0.0f, com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), 20.0f), 0.0f, -com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), 20.0f), 0.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        return arrayList;
    }
}
