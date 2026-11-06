package com.smartdigimkt.x1;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.GuideToClickView;
import com.smartdigimkt.sdk.basead.ui.simpleview.SimpleCircleView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends d {
    public GuideToClickView p;
    public SimpleCircleView q;

    public g(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b2.e eVar, int i, ViewGroup viewGroup) {
        super(context, cVar, aVar, eVar, i, viewGroup);
    }

    @Override // com.smartdigimkt.x1.d
    public final void a() {
        GuideToClickView guideToClickView = this.p;
        if (guideToClickView != null) {
            com.smartdigimkt.o3.d.a(guideToClickView);
        }
        SimpleCircleView simpleCircleView = this.q;
        if (simpleCircleView != null) {
            com.smartdigimkt.o3.d.a(simpleCircleView);
        }
        this.j = false;
        this.k = null;
        CountDownView countDownView = this.n;
        if (countDownView != null) {
            countDownView.refresh(this.m);
            this.n.setOnClickListener(new f(this));
        }
        c1 c1Var = this.h;
        if (c1Var != null) {
            c1Var.a(false);
        }
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(RelativeLayout relativeLayout) {
        if (!c0.d(this.b, this.c)) {
            a(false);
        }
        this.q = new SimpleCircleView(this.a);
        GuideToClickView guideToClickView = new GuideToClickView(this.a);
        this.p = guideToClickView;
        guideToClickView.hideBackground();
        relativeLayout.addView(this.q, -1, -1);
        relativeLayout.addView(this.p, -1, -1);
        b(this.c.s.L0);
        this.p.setOnClickListener(new e(this));
        c1 c1Var = this.h;
        if (c1Var != null) {
            c1Var.a(true);
        }
    }
}
