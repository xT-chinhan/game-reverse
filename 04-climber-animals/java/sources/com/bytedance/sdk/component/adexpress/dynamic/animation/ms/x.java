package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class x extends d {
    public x(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.xr.ch() * 1000.0d));
        ((ViewGroup) this.ah.getParent()).setClipChildren(false);
        ((ViewGroup) this.ah.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.ah.getParent().getParent().getParent()).setClipChildren(false);
        this.ah.setTag(2097610712, this.xr.x());
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        return arrayList;
    }
}
