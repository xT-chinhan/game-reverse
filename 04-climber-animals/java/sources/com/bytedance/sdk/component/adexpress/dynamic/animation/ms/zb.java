package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends d {
    public zb(View view, com.bytedance.sdk.component.adexpress.dynamic.ah.ms msVar) {
        super(view, msVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.ms.d
    List<ObjectAnimator> ms() {
        if ((this.ah instanceof ImageView) && (this.ah.getParent() instanceof DynamicImageView)) {
            this.ah = (View) this.ah.getParent();
            ((ViewGroup) this.ah).setClipChildren(true);
            ((ViewGroup) this.ah.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ah, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.xr.ch() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(ms(duration));
        return arrayList;
    }
}
