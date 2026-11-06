package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ao extends d {
    public ao(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), 20.0f), 0.0f, -com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), 20.0f), 0.0f).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        return arrayList;
    }
}
