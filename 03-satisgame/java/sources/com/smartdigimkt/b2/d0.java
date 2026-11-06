package com.smartdigimkt.b2;

import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.ShakeBorderThumbView;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ g0 a;

    public d0(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.a()) {
            try {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.2f);
                valueAnimatorOfFloat.setDuration(500L);
                valueAnimatorOfFloat.setRepeatCount(1);
                valueAnimatorOfFloat.setRepeatMode(2);
                valueAnimatorOfFloat.addUpdateListener(new b0(this));
                valueAnimatorOfFloat.addListener(new c0(this));
                valueAnimatorOfFloat.start();
            } catch (Throwable unused) {
                if (this.a.a()) {
                    ShakeBorderThumbView shakeBorderThumbView = this.a.j;
                    if (shakeBorderThumbView == null || shakeBorderThumbView.getParent() == null) {
                        this.a.i.setVisibility(0);
                    } else {
                        this.a.i.setVisibility(8);
                        this.a.j.setVisibility(0);
                    }
                }
            }
        }
    }
}
