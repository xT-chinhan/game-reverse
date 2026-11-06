package com.smartdigimkt.d2;

import android.view.animation.Animation;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.QAIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Animation.AnimationListener {
    public final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        QAIncentiveTaskView qAIncentiveTaskView = this.a.a;
        ((com.smartdigimkt.b2.n) qAIncentiveTaskView.b).a(qAIncentiveTaskView.j);
        ((com.smartdigimkt.b2.n) this.a.a.b).a();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
