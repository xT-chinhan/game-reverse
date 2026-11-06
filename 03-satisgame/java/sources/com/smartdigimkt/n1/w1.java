package com.smartdigimkt.n1;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.smartdigimkt.sdk.basead.ui.BaseShakeView;

/* JADX INFO: loaded from: classes3.dex */
public final class w1 implements Runnable {
    public final /* synthetic */ BaseShakeView a;

    public w1(BaseShakeView baseShakeView) {
        this.a = baseShakeView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BaseShakeView baseShakeView = this.a;
        ImageView imageView = baseShakeView.a;
        if (imageView != null) {
            Bitmap bitmap = baseShakeView.j;
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(com.smartdigimkt.r4.k.a(baseShakeView.getContext(), "myoffer_shake_icon", "drawable"));
            }
        }
        BaseShakeView baseShakeView2 = this.a;
        ImageView imageView2 = baseShakeView2.b;
        if (imageView2 != null) {
            Bitmap bitmap2 = baseShakeView2.j;
            if (bitmap2 != null) {
                imageView2.setImageBitmap(bitmap2);
            } else {
                imageView2.setImageResource(com.smartdigimkt.r4.k.a(baseShakeView2.getContext(), "myoffer_shake_icon", "drawable"));
            }
        }
    }
}
