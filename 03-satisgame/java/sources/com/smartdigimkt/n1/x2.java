package com.smartdigimkt.n1;

import android.view.View;
import android.view.animation.Animation;
import com.smartdigimkt.sdk.basead.ui.FullScreenATView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;

/* JADX INFO: loaded from: classes3.dex */
public final class x2 implements Animation.AnimationListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ FullScreenATView b;

    public x2(FullScreenATView fullScreenATView, BasePlayerView basePlayerView) {
        this.b = fullScreenATView;
        this.a = basePlayerView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        View view = this.a;
        if (view != null) {
            view.post(new w2(this));
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
