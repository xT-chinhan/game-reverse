package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.gx.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 108})
public class m extends x {
    public m(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        if ((this.hn instanceof ImageView) && (this.hn.getParent() instanceof DynamicImageView)) {
            this.hn = (View) this.hn.getParent();
            ((ViewGroup) this.hn).setClipChildren(true);
            ((ViewGroup) this.hn.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        return arrayList;
    }
}
