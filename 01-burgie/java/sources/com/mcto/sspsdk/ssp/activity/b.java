package com.mcto.sspsdk.ssp.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ QyRewardActivity b;

    public b(QyRewardActivity qyRewardActivity, View view) {
        this.b = qyRewardActivity;
        this.a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.b.m.removeView(this.a);
    }
}
