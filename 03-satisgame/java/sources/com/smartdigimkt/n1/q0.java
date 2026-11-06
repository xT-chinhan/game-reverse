package com.smartdigimkt.n1;

import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.BaseMediaATView;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements Runnable {
    public final /* synthetic */ BaseMediaATView a;

    public q0(BaseMediaATView baseMediaATView) {
        this.a = baseMediaATView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        float f;
        float f2;
        BaseMediaATView baseMediaATView = this.a;
        baseMediaATView.f = baseMediaATView.getMeasuredWidth();
        BaseMediaATView baseMediaATView2 = this.a;
        if (baseMediaATView2.h && (i = baseMediaATView2.f) > 0) {
            int i2 = baseMediaATView2.k;
            if (i2 == 1 || i2 == 2) {
                f = i;
                f2 = 0.5f;
            } else {
                f = i;
                f2 = 0.75f;
            }
            baseMediaATView2.g = (int) (f * f2);
        }
        if (baseMediaATView2.getParent() != null) {
            ViewGroup.LayoutParams layoutParams = baseMediaATView2.getLayoutParams();
            layoutParams.width = baseMediaATView2.getMediaViewWidth();
            layoutParams.height = baseMediaATView2.getLayoutParamsHeight();
            baseMediaATView2.setLayoutParams(layoutParams);
            baseMediaATView2.postInvalidate();
        }
    }
}
