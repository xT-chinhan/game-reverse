package com.smartdigimkt.h2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.smartdigimkt.sdk.basead.ui.specialnote.BaseSpecialNoteView;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AnimatorListenerAdapter {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ BaseSpecialNoteView b;

    public f(BaseSpecialNoteView baseSpecialNoteView, ValueAnimator valueAnimator) {
        this.b = baseSpecialNoteView;
        this.a = valueAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.b.setAlpha(((Float) this.a.getAnimatedValue()).floatValue());
        this.b.setVisibility(0);
    }
}
