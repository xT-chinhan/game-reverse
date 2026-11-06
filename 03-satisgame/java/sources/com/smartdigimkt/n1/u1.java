package com.smartdigimkt.n1;

import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 implements Runnable {
    public final /* synthetic */ BaseShakeView a;

    public u1(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = this.a.a;
        if (imageView == null || imageView.getWidth() <= 0 || this.a.a.getHeight() <= 0) {
            return;
        }
        int width = (int) (((double) this.a.a.getWidth()) * 0.8d);
        int height = (int) (((double) this.a.a.getHeight()) * 0.8d);
        this.a.a.setPivotX(width);
        this.a.a.setPivotY(height);
    }
}
