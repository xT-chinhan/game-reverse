package com.smartdigimkt.w1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        RelativeLayout relativeLayout = this.a.a.a.a;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.a.a.a.b;
        if (relativeLayout2 != null) {
            relativeLayout2.setAlpha(1.0f);
            this.a.a.a.b.setVisibility(0);
        }
        RedPacketPage redPacketPage = this.a.a.a;
        TextView textView = redPacketPage.n;
        if (textView == null) {
            return;
        }
        com.smartdigimkt.p1.h hVar = redPacketPage.o;
        if (hVar != null) {
            hVar.stop();
        }
        com.smartdigimkt.p1.h hVar2 = new com.smartdigimkt.p1.h(textView);
        redPacketPage.o = hVar2;
        hVar2.e = 0.85f;
        hVar2.start();
    }
}
