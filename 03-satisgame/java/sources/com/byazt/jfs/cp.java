package com.byazt.jfs;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.osr.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1191, 29})
public class cp extends q {
    public cp(View view, com.byazt.lh.n nVar) {
        super(view, nVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.byazt.jfs.q
    public List<ObjectAnimator> n() {
        float f;
        float fCp = (float) this.qg.cp();
        float fD = (float) this.qg.d();
        String strCy = this.qg.cy();
        float f2 = 1.0f;
        if ("reverse".equals(strCy) || "alternate-reverse".equals(strCy)) {
            f = 1.0f;
        } else {
            f = fD;
            fD = 1.0f;
            f2 = fCp;
            fCp = 1.0f;
        }
        this.s.setTag(2097610710, this.qg.qg());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.s, "scaleX", fCp, f2).setDuration((int) (this.qg.tj() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.s, "scaleY", fD, f).setDuration((int) (this.qg.tj() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(n(duration));
        arrayList.add(n(duration2));
        return arrayList;
    }
}
