package com.smartdigimkt.r1;

import android.animation.Animator;
import android.os.Handler;
import com.smartdigimkt.q1.g;
import com.smartdigimkt.sdk.basead.ui.animplayerview.redpacket.RedPacketAnimatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends g {
    public final /* synthetic */ RedPacketAnimatorView a;

    public a(RedPacketAnimatorView redPacketAnimatorView) {
        this.a = redPacketAnimatorView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Handler handler = this.a.g;
        if (handler != null) {
            handler.removeMessages(100);
            this.a.g.sendEmptyMessageDelayed(100, 500L);
        }
    }
}
