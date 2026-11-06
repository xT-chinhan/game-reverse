package com.smartdigimkt.x1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.sdk.basead.ui.BaseScreenATView;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RedPacketPage;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends d {
    public RedPacketPage p;
    public int q;
    public int r;

    public k(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b2.e eVar, int i, ViewGroup viewGroup) {
        super(context, cVar, aVar, eVar, i, viewGroup);
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(RelativeLayout relativeLayout) {
        String strReplace;
        if (!c0.d(this.b, this.c)) {
            a(false);
        }
        int i = this.c.s.S0;
        this.q = i / 10;
        this.r = i % 10;
        this.p = new RedPacketPage(this.a);
        new com.smartdigimkt.i2.j(this.b, this.c).a(this.p);
        this.p.setOpenIconClickClickAction(this.c.s.R0);
        this.p.setRedPacketClickListener(new i(this));
        com.smartdigimkt.b3.c cVar = this.b;
        if (cVar != null) {
            String str = cVar.c;
            if ((cVar instanceof com.smartdigimkt.b3.b) && !TextUtils.isEmpty(((com.smartdigimkt.b3.b) cVar).X)) {
                str = ((com.smartdigimkt.b3.b) this.b).X;
            }
            if (TextUtils.isEmpty(str)) {
                strReplace = "";
            } else {
                strReplace = !TextUtils.isEmpty(this.c.s.N0) ? this.c.s.N0.replace("{__sender__}", "") : this.a.getResources().getString(com.smartdigimkt.r4.k.a(this.a, "myoffer_red_packet_title_text", "string"), str);
            }
            this.p.setAdTitle(strReplace);
            this.p.setAdBless(this.c.s.O0);
            if (TextUtils.isEmpty(this.b.e)) {
                this.p.setAdIconUrl(this.b.f);
            } else {
                this.p.setAdIconUrl(this.b.e);
            }
            this.p.setAdNotice(this.c.s.Q0, this.b.o);
            RedPacketPage redPacketPage = this.p;
            this.c.s.getClass();
            redPacketPage.setCTAText("");
        }
        relativeLayout.addView(this.p, -1, -1);
        b(this.c.s.L0);
        CountDownView countDownView = this.n;
        if (countDownView != null) {
            com.smartdigimkt.i2.l.a(countDownView, false, this.c, false);
        }
        c1 c1Var = this.h;
        if (c1Var != null) {
            c1Var.a(true);
        }
    }

    @Override // com.smartdigimkt.x1.d
    public final void d() {
        c1 c1Var = this.h;
        if (c1Var != null) {
            Context context = c1Var.a.getContext();
            if (!(context instanceof Activity) || context.getResources().getConfiguration().orientation == 1) {
                return;
            }
            ((Activity) context).setRequestedOrientation(1);
            BaseScreenATView baseScreenATView = c1Var.a;
            int i = baseScreenATView.F;
            int i2 = baseScreenATView.G;
            if (i > i2) {
                int i3 = i + i2;
                int i4 = i3 - i2;
                baseScreenATView.G = i4;
                baseScreenATView.F = i3 - i4;
            }
        }
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(long j) {
        super.a(j);
        if (this.l >= this.m) {
            this.n.setOnClickListener(new j(this));
        }
    }
}
