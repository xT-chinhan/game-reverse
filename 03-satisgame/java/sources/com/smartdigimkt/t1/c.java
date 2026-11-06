package com.smartdigimkt.t1;

import android.animation.Animator;
import com.smartdigimkt.sdk.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ VpMainImgAnimatorView a;

    public c(VpMainImgAnimatorView vpMainImgAnimatorView) {
        this.a = vpMainImgAnimatorView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        VpMainImgAnimatorView vpMainImgAnimatorView = this.a;
        int i = VpMainImgAnimatorView.l;
        vpMainImgAnimatorView.b();
        a aVar = this.a.h;
        if (aVar != null) {
            aVar.removeMessages(100);
            this.a.h.sendEmptyMessageDelayed(100, 1500L);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
