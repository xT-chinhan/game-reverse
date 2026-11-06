package com.smartdigimkt.e0;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ g b;

    public f(g gVar, RelativeLayout relativeLayout) {
        this.b = gVar;
        this.a = relativeLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.e = ValueAnimator.ofFloat(0.0f, 720.0f);
        this.b.e.setDuration(2000L);
        this.b.e.addUpdateListener(new e(this));
        if (this.b.e.isStarted()) {
            return;
        }
        this.b.e.start();
    }
}
