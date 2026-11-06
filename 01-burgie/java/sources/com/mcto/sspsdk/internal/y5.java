package com.mcto.sspsdk.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.feedback.FeedBackActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class y5 extends AnimatorListenerAdapter {
    public final /* synthetic */ FeedBackActivity a;

    public y5(FeedBackActivity feedBackActivity) {
        this.a = feedBackActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.a.findViewById(R.id.qy_feedback_main_layout).setVisibility(8);
    }
}
