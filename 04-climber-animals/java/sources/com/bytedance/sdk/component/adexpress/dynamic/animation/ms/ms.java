package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends d {
    public ms(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        float fQv = this.xr.qv() / 100.0f;
        float fY = this.xr.y() / 100.0f;
        if ("reverse".equals(this.xr.ao()) && this.xr.u() <= 0.0d) {
            fY = fQv;
            fQv = fY;
        }
        this.ah.setAlpha(fQv);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "alpha", fQv, fY).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        return arrayList;
    }
}
