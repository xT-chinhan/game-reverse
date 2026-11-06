package com.smartdigimkt.s1;

import android.animation.Animator;
import android.os.Handler;
import com.smartdigimkt.q1.g;
import com.smartdigimkt.sdk.basead.ui.animplayerview.scale.AlbumScaleMainView;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends g {
    public final /* synthetic */ AlbumScaleMainView a;

    public e(AlbumScaleMainView albumScaleMainView) {
        this.a = albumScaleMainView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Handler handler = this.a.f;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(100, 500L);
        }
    }
}
