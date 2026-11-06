package com.smartdigimkt.b2;

import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements View.OnLayoutChangeListener {
    public final /* synthetic */ float a = 0.1f;
    public final /* synthetic */ FrameLayout b;

    public r(FrameLayout frameLayout) {
        this.b = frameLayout;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if (i9 <= 0 || i10 <= 0) {
            return;
        }
        int iMax = Math.max(1, (int) ((1.0f - (this.a * 2.0f)) * i9));
        int iMax2 = Math.max(1, (int) ((1.0f - (this.a * 2.0f)) * i10));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        if (layoutParams.width == iMax && layoutParams.height == iMax2) {
            return;
        }
        this.b.post(new q(this, iMax, iMax2));
    }
}
