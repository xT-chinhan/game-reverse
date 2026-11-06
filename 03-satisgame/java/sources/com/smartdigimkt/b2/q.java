package com.smartdigimkt.b2;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ r c;

    public q(r rVar, int i, int i2) {
        this.c = rVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.b.getParent() == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.b.getLayoutParams();
        int i = layoutParams.width;
        int i2 = this.a;
        if (i == i2 && layoutParams.height == this.b) {
            return;
        }
        layoutParams.width = i2;
        layoutParams.height = this.b;
        layoutParams.gravity = 17;
        this.c.b.setLayoutParams(layoutParams);
    }
}
