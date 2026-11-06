package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.BaseSplashATView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class n2 implements Runnable {
    public final WeakReference a;

    public n2(BaseSplashATView baseSplashATView) {
        this.a = new WeakReference(baseSplashATView);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    /* JADX WARN: Code duplicated, block: B:30:0x008e  */
    @Override // java.lang.Runnable
    public final void run() {
        BaseSplashATView baseSplashATView = (BaseSplashATView) this.a.get();
        if (baseSplashATView == null || baseSplashATView.J != this) {
            return;
        }
        com.smartdigimkt.p3.l lVar = baseSplashATView.N;
        if (baseSplashATView.getParent() != null && lVar != null) {
            Object parent = baseSplashATView.getParent();
            if ((parent instanceof View) && lVar.a((View) parent, baseSplashATView, 80, 0) && !com.smartdigimkt.o3.d.a) {
                long j = baseSplashATView.O;
                if (j > 0) {
                    baseSplashATView.a(j);
                    baseSplashATView.O -= 1000;
                } else if (baseSplashATView.needShowSplashEndCard()) {
                    baseSplashATView.onSplashEndCardCountDownTick(baseSplashATView.P);
                    long j2 = baseSplashATView.P - 1000;
                    baseSplashATView.P = j2;
                    if (j2 <= 0) {
                        baseSplashATView.a(2, true);
                        baseSplashATView.E.setText(baseSplashATView.H);
                        baseSplashATView.c0 = true;
                    }
                } else {
                    baseSplashATView.a(2, true);
                    baseSplashATView.E.setText(baseSplashATView.H);
                    baseSplashATView.c0 = true;
                }
                if (baseSplashATView.W.compareAndSet(3, 2)) {
                    baseSplashATView.a(110);
                }
            } else if (baseSplashATView.W.compareAndSet(2, 3)) {
                baseSplashATView.a(111);
            }
        } else if (baseSplashATView.W.compareAndSet(2, 3)) {
            baseSplashATView.a(111);
        }
        if (baseSplashATView.J == this) {
            baseSplashATView.I.postDelayed(this, 1000L);
        }
    }
}
