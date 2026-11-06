package com.smartdigimkt.g2;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.simpleview.SimpleCircleView;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ SimpleCircleView a;

    public b(SimpleCircleView simpleCircleView) {
        this.a = simpleCircleView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setScaleX(0.1f);
        this.a.setScaleY(0.1f);
        this.a.b = ValueAnimator.ofFloat(0.1f, Math.max((this.a.getWidth() <= 0 || this.a.getHeight() <= 0) ? 3.0f : (float) (Math.hypot(this.a.getWidth() / 2, this.a.getHeight() / 2) / ((double) (Math.min(this.a.getWidth(), this.a.getHeight()) / 2))), 3.0f));
        this.a.b.setDuration(500L);
        this.a.b.addUpdateListener(new a(this));
        this.a.b.start();
    }
}
