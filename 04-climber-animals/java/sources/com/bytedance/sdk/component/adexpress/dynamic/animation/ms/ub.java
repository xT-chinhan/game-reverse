package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ub extends d {
    public ub(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        float f;
        float fMs = com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.xr.c());
        float fMs2 = com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.xr.ab());
        float f2 = 0.0f;
        if ("reverse".equals(this.xr.ao())) {
            f = fMs2;
            fMs2 = 0.0f;
            f2 = fMs;
            fMs = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.d.ah.ms(this.ah.getContext())) {
            fMs = -fMs;
            f2 = -f2;
        }
        this.ah.setTranslationX(fMs);
        this.ah.setTranslationY(fMs2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationX", fMs, f2).setDuration((int) (this.xr.ch() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ah, "translationY", fMs2, f).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        arrayList.add(ms(duration2));
        return arrayList;
    }
}
