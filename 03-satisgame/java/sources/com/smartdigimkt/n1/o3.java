package com.smartdigimkt.n1;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class o3 implements Runnable {
    public final /* synthetic */ r3 a;

    public o3(r3 r3Var) {
        this.a = r3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ViewGroup viewGroup = this.a.a;
            if (viewGroup instanceof RelativeLayout) {
                int i = this.a.c;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
                layoutParams.addRule(13);
                r3 r3Var = this.a;
                r3Var.a.addView(r3Var.b, layoutParams);
            } else if (viewGroup instanceof FrameLayout) {
                int i2 = this.a.c;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
                layoutParams2.gravity = 17;
                r3 r3Var2 = this.a;
                r3Var2.a.addView(r3Var2.b, layoutParams2);
            }
        } catch (Throwable unused) {
        }
    }
}
