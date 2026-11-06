package com.smartdigimkt.x1;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RPSecondEndCardView;
import com.smartdigimkt.sdk.basead.ui.simpleview.SimplePlayer;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ v a;

    public u(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v vVar = this.a;
        CountDownView countDownView = vVar.n;
        Context context = vVar.a;
        countDownView.setCountDownEndDrawable(com.smartdigimkt.o3.d.a(context, com.smartdigimkt.r4.k.a(context, "myoffer_base_close_icon", "drawable")));
        this.a.n.setOnClickListener(new s(this));
        SimplePlayer simplePlayer = this.a.q;
        if (simplePlayer != null) {
            simplePlayer.stopVideo();
        }
        c1 c1Var = this.a.h;
        if (c1Var != null) {
            c1Var.a(true);
        }
        RPSecondEndCardView rPSecondEndCardView = this.a.r;
        if (rPSecondEndCardView != null && rPSecondEndCardView.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            v vVar2 = this.a;
            vVar2.p.addView(vVar2.r, 1, layoutParams);
            this.a.r.setSecondECClickListener(new t(this));
        }
        v vVar3 = this.a;
        com.smartdigimkt.i2.l.a(vVar3.n, true, vVar3.c, false);
        this.a.a(true);
    }
}
