package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 101})
public class fs extends q {
    public fs(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.qg.tj() * 1000.0d));
        ((ViewGroup) this.s.getParent()).setClipChildren(false);
        ((ViewGroup) this.s.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.s.getParent().getParent().getParent()).setClipChildren(false);
        this.s.setTag(2097610712, this.qg.fs());
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        return arrayList;
    }
}
