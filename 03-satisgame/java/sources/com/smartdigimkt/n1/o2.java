package com.smartdigimkt.n1;

import android.graphics.Rect;
import com.smartdigimkt.sdk.basead.ui.CloseFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class o2 implements Runnable {
    public final /* synthetic */ CloseFrameLayout a;

    public o2(CloseFrameLayout closeFrameLayout) {
        this.a = closeFrameLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = new Rect();
        CloseFrameLayout closeFrameLayout = this.a;
        closeFrameLayout.getHitRect(closeFrameLayout.b);
        float fWidth = this.a.b.width();
        CloseFrameLayout closeFrameLayout2 = this.a;
        int i = ((int) ((closeFrameLayout2.a - 1.0f) * fWidth)) / 2;
        float fHeight = closeFrameLayout2.b.height();
        CloseFrameLayout closeFrameLayout3 = this.a;
        int i2 = ((int) ((closeFrameLayout3.a - 1.0f) * fHeight)) / 2;
        Rect rect = closeFrameLayout3.b;
        rect.top -= i2;
        rect.bottom += i2;
        rect.left -= i;
        rect.right += i;
    }
}
