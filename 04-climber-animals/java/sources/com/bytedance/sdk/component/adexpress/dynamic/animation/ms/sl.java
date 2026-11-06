package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends d {
    public sl(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        int i;
        int i2;
        this.ah.setTag(2097610711, Integer.valueOf(this.xr.d()));
        if (this.ah == null || !com.bytedance.sdk.component.adexpress.d.ah.ms(this.ah.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "shineValue", i, i2).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        return arrayList;
    }
}
