package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends d {
    public c(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        float f = this.ah.getLayoutParams().width;
        this.ah.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationX", f, 0.0f).setDuration((int) (this.xr.ch() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.ah, "alpha", 0.0f, 1.0f).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        arrayList.add(ms(duration2));
        return arrayList;
    }
}
