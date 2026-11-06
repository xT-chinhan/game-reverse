package com.smartdigimkt.s1;

import android.animation.Animator;
import com.smartdigimkt.q1.g;
import com.smartdigimkt.sdk.basead.ui.animplayerview.scale.AlbumScaleMainView;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g {
    public final /* synthetic */ AlbumScaleMainView a;

    public d(AlbumScaleMainView albumScaleMainView) {
        this.a = albumScaleMainView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.a.f.sendEmptyMessageDelayed(100, 500L);
    }
}
