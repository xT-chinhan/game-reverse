package com.smartdigimkt.t1;

import android.animation.Animator;
import android.view.View;
import com.smartdigimkt.sdk.basead.ui.WrapRoundImageView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Animator.AnimatorListener {
    public final View a;
    public final /* synthetic */ VpMainImgAnimatorView b;

    public d(VpMainImgAnimatorView vpMainImgAnimatorView, WrapRoundImageView wrapRoundImageView) {
        this.b = vpMainImgAnimatorView;
        this.a = wrapRoundImageView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        View view = this.a;
        if (view == null || view.getTranslationX() >= 0.0f) {
            return;
        }
        this.a.setTranslationX(this.b.g);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
