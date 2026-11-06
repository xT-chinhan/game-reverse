package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.e0.f;
import com.smartdigimkt.e0.g;
import com.smartdigimkt.n1.k3;
import com.smartdigimkt.n1.l3;
import com.smartdigimkt.r4.k;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LetterFullScreenATView extends FullScreenATView {
    public g O0;
    public int P0;
    public final int Q0;
    public final int R0;
    public final int S0;
    public int T0;
    public int U0;

    public LetterFullScreenATView(Context context) {
        super(context);
        this.P0 = k.a(getContext(), 13.0f);
        this.Q0 = k.a(getContext(), 60.0f);
        this.R0 = k.a(getContext(), 53.0f);
        this.S0 = k.a(getContext(), 17.0f);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void C() {
        super.C();
        Drawable bgDrawable = this.h0.getBgDrawable();
        if (bgDrawable != null) {
            setBackgroundDrawable(bgDrawable);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void E() {
        this.h0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        PanelView panelView = getPanelView();
        if (panelView != null) {
            panelView.setVisibility(0);
        }
        this.f0.addView(this.h0, 0);
        if (b(this.O)) {
            PanelView panelView2 = getPanelView();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) panelView2.getLayoutParams();
            layoutParams.addRule(3, this.h0.getId());
            layoutParams.height = -2;
            layoutParams.bottomMargin = this.O0.i;
            layoutParams.addRule(12, 0);
            int iA = k.a(getContext(), 30.0f);
            g gVar = this.O0;
            panelView2.setPadding(0, iA, 0, (((gVar.i / 129) * 69) + gVar.h) - layoutParams.bottomMargin);
            panelView2.setBackgroundColor(-1);
            this.h0.getLayoutParams().height = this.T0;
        } else {
            ((RelativeLayout.LayoutParams) this.h0.getLayoutParams()).bottomMargin = this.U0;
            this.h0.getLayoutParams().height = this.T0;
            EndCardView endCardView = this.h0;
            g gVar2 = this.O0;
            endCardView.setPadding(0, 0, 0, (gVar2.h - this.U0) - gVar2.i);
            r();
        }
        g gVar3 = this.O0;
        RelativeLayout relativeLayout = this.f0;
        if (gVar3.f || gVar3.g) {
            return;
        }
        gVar3.f = true;
        relativeLayout.postDelayed(new f(gVar3, relativeLayout), 2000L);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void L() {
        if (b(this.O)) {
            super.L();
        } else {
            getPanelView().setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final boolean b(int i) {
        return (TextUtils.isEmpty(this.c.e) && TextUtils.isEmpty(this.c.c) && TextUtils.isEmpty(this.c.d)) ? false : true;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        e eVar;
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_letter_full_screen", "layout"), this);
        setGravity(13);
        a aVar = this.b;
        if (aVar == null || (eVar = aVar.s) == null || eVar.e != 0) {
            return;
        }
        setOnClickListener(new k3(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public int getPanelViewTypeForShowEndCard() {
        return this.O;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        int i = (this.T0 * 2) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, i, 0, 0);
        return layoutParams;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(1140850688);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void s() {
        super.s();
        g gVar = new g(getContext());
        this.O0 = gVar;
        gVar.a(this.c, this.b, new l3(this));
        this.O0.a(this, this.f0.getId());
        this.O0.a(this.F - (this.P0 * 2));
        this.T0 = (this.F - (this.P0 * 2)) - (this.S0 * 2);
        if (!b(this.O)) {
            g gVar2 = this.O0;
            int i = gVar2.i;
            this.U0 = i;
            this.T0 = ((this.T0 + gVar2.h) - i) - i;
        }
        this.m = this.O0.a;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void v() {
        this.O = 109;
        PanelView panelView = getPanelView();
        if (panelView != null) {
            panelView.setLayoutType(this.O);
            ((LinearLayout.LayoutParams) panelView.findViewById(k.a(getContext(), "myoffer_iv_banner_icon", "id")).getLayoutParams()).bottomMargin = k.a(getContext(), 30.0f);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.FullScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void x() {
        this.P0 = (this.F - ((int) (((double) ((this.G - this.R0) - this.Q0)) * 0.49714285714285716d))) / 2;
        super.x();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f0.getLayoutParams();
        int i = this.S0;
        layoutParams.setMargins(i, this.Q0, i, this.R0);
        int i2 = this.P0;
        setPadding(i2, 0, i2, 0);
    }

    public LetterFullScreenATView(Context context, a aVar, c cVar, String str, int i, int i2) {
        super(context, aVar, cVar, str, i, i2);
        this.P0 = k.a(getContext(), 13.0f);
        this.Q0 = k.a(getContext(), 60.0f);
        this.R0 = k.a(getContext(), 53.0f);
        this.S0 = k.a(getContext(), 17.0f);
        if (this.o != null) {
            HashMap map = new HashMap();
            map.put("screen_style", 1);
            this.o.a(map);
        }
    }
}
