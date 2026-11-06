package com.mcto.sspsdk.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class tf extends AnimatorListenerAdapter {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ uf b;

    public tf(uf ufVar, ImageView imageView) {
        this.b = ufVar;
        this.a = imageView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        uf ufVar = this.b;
        ImageView imageView = this.a;
        ufVar.l.remove(imageView);
        ufVar.k.remove(imageView);
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        uf ufVar = this.b;
        ImageView imageView = this.a;
        ufVar.l.remove(imageView);
        ufVar.k.remove(imageView);
        if (imageView.getParent() != null) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
    }
}
