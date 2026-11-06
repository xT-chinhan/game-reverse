package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends d {
    public hi(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
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

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        float f;
        float fHi = (float) this.xr.hi();
        float fSl = (float) this.xr.sl();
        String strAo = this.xr.ao();
        float f2 = 1.0f;
        if ("reverse".equals(strAo) || "alternate-reverse".equals(strAo)) {
            f = 1.0f;
        } else {
            f = fSl;
            fSl = 1.0f;
            f2 = fHi;
            fHi = 1.0f;
        }
        this.ah.setTag(2097610710, this.xr.xr());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "scaleX", fHi, f2).setDuration((int) (this.xr.ch() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ah, "scaleY", fSl, f).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        arrayList.add(ms(duration2));
        return arrayList;
    }
}
