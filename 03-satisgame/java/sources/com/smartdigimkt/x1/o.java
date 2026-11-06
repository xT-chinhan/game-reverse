package com.smartdigimkt.x1;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.SecondEndCardView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends d {
    public SecondEndCardView p;
    public com.smartdigimkt.i2.j q;
    public int r;
    public boolean s;
    public boolean t;
    public View u;

    public o(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b2.e eVar, int i, ViewGroup viewGroup) {
        super(context, cVar, aVar, eVar, i, viewGroup);
        this.r = 1;
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(RelativeLayout relativeLayout) {
        View view;
        if (!c0.d(this.b, this.c)) {
            a(false);
        }
        this.u = this.g;
        this.r = this.c.s.T0;
        SecondEndCardView secondEndCardView = new SecondEndCardView(this.a);
        this.p = secondEndCardView;
        secondEndCardView.setAdTitle(this.b.c);
        this.p.setAdDesc(this.b.d);
        if (TextUtils.isEmpty(this.b.e)) {
            this.p.setAdIcon(this.b.f);
        } else {
            this.p.setAdIcon(this.b.e);
        }
        if (TextUtils.isEmpty(this.b.h)) {
            SecondEndCardView secondEndCardView2 = this.p;
            Context context = this.a;
            secondEndCardView2.setCTAText(context.getString(c0.a(context, this.b)));
        } else {
            this.p.setCTAText(this.b.h);
        }
        boolean z = this.f != 1;
        this.s = z;
        this.p.addComplianceElements(!z);
        if (!this.s) {
            this.p.setBackgroundColor(Color.parseColor("#CC000000"));
        }
        c1 c1Var = this.h;
        View subCloseView = (c1Var == null || (view = c1Var.a.m) == null || !(view instanceof CTAButtonLayout)) ? null : ((CTAButtonLayout) view).getSubCloseView();
        if (subCloseView == null) {
            subCloseView = b();
        }
        if (subCloseView != null) {
            if ((subCloseView instanceof TextView) && TextUtils.isEmpty(this.c.s.d1)) {
                ((TextView) subCloseView).setText(com.smartdigimkt.r4.k.a(this.a, "myoffer_sub_close_default_skip_text", "string"));
            }
            if (subCloseView instanceof ImageView) {
                subCloseView.setBackgroundResource(com.smartdigimkt.r4.k.a(this.a, "myoffer_base_skip_icon", "drawable"));
            }
            subCloseView.setOnClickListener(new m(this, relativeLayout));
        }
        this.t = false;
    }

    @Override // com.smartdigimkt.x1.d
    public final View c() {
        return this.u;
    }

    @Override // com.smartdigimkt.x1.d
    public final void a() {
        this.t = true;
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(long j) {
        super.a(j);
        if (this.l >= this.m) {
            com.smartdigimkt.i2.l.a(this.n, true, this.c, false);
            this.n.setOnClickListener(new n(this));
        }
    }
}
