package com.smartdigimkt.x1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ o b;

    public m(o oVar, RelativeLayout relativeLayout) {
        this.b = oVar;
        this.a = relativeLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CountDownView countDownView;
        c1 c1Var = this.b.h;
        if (c1Var != null) {
            c1Var.a(true);
        }
        SecondEndCardView secondEndCardView = this.b.p;
        if (secondEndCardView != null && secondEndCardView.getParent() == null) {
            o oVar = this.b;
            if (oVar.s) {
                ViewGroup viewGroup = oVar.g;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                    if (this.b.g.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.b.g.getParent()).addView(this.b.p, -1, -1);
                    }
                }
            } else {
                this.a.addView(oVar.p, -1, -1);
            }
            o oVar2 = this.b;
            oVar2.u = oVar2.p;
            oVar2.q = new com.smartdigimkt.i2.j(oVar2.b, oVar2.c);
            o oVar3 = this.b;
            oVar3.q.a(oVar3.p);
            this.b.p.setSecondECClickListener(new l(this));
        }
        o oVar4 = this.b;
        oVar4.b(oVar4.c.s.M0);
        o oVar5 = this.b;
        if (oVar5.s && (countDownView = oVar5.n) != null) {
            com.smartdigimkt.o3.d.a(countDownView);
            ViewGroup.LayoutParams layoutParams = this.b.n.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.addRule(11);
            layoutParams2.setMargins(0, com.smartdigimkt.r4.k.a(this.b.a, 8.0f), com.smartdigimkt.r4.k.a(this.b.a, 8.0f), 0);
            o oVar6 = this.b;
            oVar6.p.addCloseView(oVar6.n, layoutParams2);
        }
        this.b.a(true);
    }
}
