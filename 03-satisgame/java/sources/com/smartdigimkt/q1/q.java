package com.smartdigimkt.q1;

import android.view.animation.Animation;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;
import com.smartdigimkt.sdk.basead.ui.web.BaseWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Animation.AnimationListener {
    public final /* synthetic */ WebLandpagePlayerView a;

    public q(WebLandpagePlayerView webLandpagePlayerView) {
        this.a = webLandpagePlayerView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        BaseWebView baseWebView = this.a.G;
        if (baseWebView != null) {
            baseWebView.setVisibility(0);
        }
    }
}
