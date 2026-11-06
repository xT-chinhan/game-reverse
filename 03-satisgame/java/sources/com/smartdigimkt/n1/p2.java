package com.smartdigimkt.n1;

import android.graphics.Rect;
import com.smartdigimkt.sdk.basead.ui.CloseImageView;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 implements Runnable {
    public final /* synthetic */ CloseImageView a;

    public p2(CloseImageView closeImageView) {
        this.a = closeImageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = new Rect();
        CloseImageView closeImageView = this.a;
        closeImageView.getHitRect(closeImageView.b);
        float fWidth = this.a.b.width();
        CloseImageView closeImageView2 = this.a;
        int i = ((int) ((closeImageView2.a - 1.0f) * fWidth)) / 2;
        float fHeight = closeImageView2.b.height();
        CloseImageView closeImageView3 = this.a;
        int i2 = ((int) ((closeImageView3.a - 1.0f) * fHeight)) / 2;
        Rect rect = closeImageView3.b;
        rect.top -= i2;
        rect.bottom += i2;
        rect.left -= i;
        rect.right += i;
    }
}
