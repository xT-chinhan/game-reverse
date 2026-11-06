package com.smartdigimkt.b2;

import android.view.View;
import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.SwipeOverlayView;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;

    public t(SwipeOverlayView swipeOverlayView) {
        this.a = swipeOverlayView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ViewGroup.LayoutParams layoutParams;
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if (i9 <= 0 || i10 <= 0 || (layoutParams = this.a.getLayoutParams()) == null) {
            return;
        }
        if (layoutParams.width == i9 && layoutParams.height == i10) {
            return;
        }
        this.a.post(new s(this, i9, i10));
    }
}
