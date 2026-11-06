package com.mcto.sspsdk.internal;

import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class y6 extends FrameLayout {
    public ImageView a;
    public ImageView b;
    public View c;
    public TextView d;
    public AnimatorSet e;
    public AnimatorSet f;
    public AnimatorSet g;

    public y6(Context context) {
        super(context);
    }

    public final void a() {
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.start();
        }
        AnimatorSet animatorSet2 = this.f;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        AnimatorSet animatorSet3 = this.e;
        if (animatorSet3 != null) {
            animatorSet3.start();
        }
    }

    public final void b() {
        AnimatorSet animatorSet = this.g;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.e;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }
}
