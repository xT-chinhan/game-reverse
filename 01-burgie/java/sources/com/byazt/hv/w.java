package com.byazt.hv;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.gx.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 802, 109})
public class w extends x {
    public w(View view, com.byazt.rk.pr prVar) {
        super(view, prVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null && (viewGroup2 instanceof DynamicBaseWidget)) {
                viewGroup2.setClipChildren(false);
                viewGroup2.setClipToPadding(false);
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 != null && (viewGroup3 instanceof DynamicBaseWidget)) {
                    viewGroup3.setClipChildren(false);
                    viewGroup3.setClipToPadding(false);
                }
            }
        }
    }

    @Override // com.byazt.hv.x
    public List<ObjectAnimator> pr() {
        float f;
        float fW = (float) this.hw.w();
        float fK = (float) this.hw.k();
        String strNt = this.hw.nt();
        float f2 = 1.0f;
        if ("reverse".equals(strNt) || "alternate-reverse".equals(strNt)) {
            f = 1.0f;
        } else {
            f = fK;
            fK = 1.0f;
            f2 = fW;
            fW = 1.0f;
        }
        this.hn.setTag(2097610710, this.hw.hw());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.hn, "scaleX", fW, f2).setDuration((int) (this.hw.vk() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.hn, "scaleY", fK, f).setDuration((int) (this.hw.vk() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(pr(duration));
        arrayList.add(pr(duration2));
        return arrayList;
    }
}
