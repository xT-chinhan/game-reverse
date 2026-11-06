package com.smartdigimkt.x1;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.component.emdcardimprove.RPSecondEndCardView;
import com.smartdigimkt.sdk.basead.ui.simpleview.SimplePlayer;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends d {
    public ViewGroup p;
    public SimplePlayer q;
    public RPSecondEndCardView r;
    public boolean s;
    public int t;

    public v(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b2.e eVar, int i, ViewGroup viewGroup) {
        super(context, cVar, aVar, eVar, i, viewGroup);
        this.s = false;
        this.t = 1;
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(RelativeLayout relativeLayout) {
        String str;
        if (!c0.d(this.b, this.c)) {
            a(false);
        }
        this.p = relativeLayout;
        com.smartdigimkt.b3.e eVar = this.b.w;
        if (eVar != null) {
            str = eVar.V0;
            this.t = eVar.U0;
        } else {
            str = "";
        }
        b(this.c.s.L0);
        CountDownView countDownView = this.n;
        Context context = this.a;
        countDownView.setCountDownEndDrawable(com.smartdigimkt.o3.d.a(context, com.smartdigimkt.r4.k.a(context, "myoffer_base_skip_icon", "drawable")));
        SimplePlayer simplePlayer = new SimplePlayer(this.a);
        this.q = simplePlayer;
        relativeLayout.addView(simplePlayer, -1, -1);
        this.q.load(str, true);
        this.q.setSimplePlayerViewListener(new q(this));
        this.q.setOnClickListener(new r(this));
        RPSecondEndCardView rPSecondEndCardView = new RPSecondEndCardView(this.a);
        this.r = rPSecondEndCardView;
        if (eVar != null) {
            rPSecondEndCardView.setAdTitle(eVar.X0);
            this.r.setAdIcon(eVar.W0);
            this.r.setAdPoster(eVar.Y0);
            String str2 = eVar.Z0;
            if (!TextUtils.isEmpty(str2)) {
                this.r.setCTAText(str2);
            } else if (this.b.o == 4) {
                this.r.setCTAText(this.a.getResources().getString(com.smartdigimkt.r4.k.a(this.a, "myoffer_rp_second_hint_link4_text", "string")));
            }
        }
        this.r.setBackgroundColor(Color.parseColor("#CC000000"));
        View viewInflate = LayoutInflater.from(this.a).inflate(com.smartdigimkt.r4.k.a(this.a, "myoffer_include_4_element", "layout"), (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(viewInflate, layoutParams);
        new com.smartdigimkt.i2.j(this.b, this.c).a(relativeLayout);
    }

    @Override // com.smartdigimkt.x1.d
    public final void a(long j) {
        super.a(j);
        if (this.l >= this.m) {
            com.smartdigimkt.i2.l.a(this.n, true, this.c, false);
            this.n.setOnClickListener(new u(this));
        }
    }
}
