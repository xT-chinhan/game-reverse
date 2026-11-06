package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.e0.f;
import com.smartdigimkt.e0.g;
import com.smartdigimkt.n1.m3;
import com.smartdigimkt.n1.n3;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LetterHalfScreenATView extends HalfScreenATView {
    public g E0;
    public int F0;
    public int G0;

    public LetterHalfScreenATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void B() {
        super.B();
        g gVar = this.E0;
        if (gVar != null) {
            gVar.a();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void E() {
        BasePlayerView basePlayerView = this.n.h;
        if (basePlayerView != null) {
            this.h0.setPadding(basePlayerView.getPaddingLeft(), basePlayerView.getPaddingTop(), basePlayerView.getPaddingRight(), basePlayerView.getPaddingBottom());
        }
        super.E();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void L() {
        if (b(this.O)) {
            super.L();
        } else {
            getPanelView().setVisibility(8);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView
    public final int P() {
        return 109;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView
    public final void Q() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g0.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f0.getLayoutParams();
        BasePlayerView basePlayerView = this.n.h;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) basePlayerView.getLayoutParams();
        int i = this.F;
        int i2 = (i - layoutParams2.leftMargin) - layoutParams2.rightMargin;
        int i3 = this.F0 * 2;
        int i4 = i2 - i3;
        this.H = i4;
        this.I = i4;
        this.E0.a(i - i3);
        int i5 = this.E0.h;
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        this.f0.setLayoutParams(layoutParams2);
        layoutParams3.width = this.H;
        layoutParams3.height = this.I;
        basePlayerView.setLayoutParams(layoutParams3);
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.topMargin = this.I;
        layoutParams.bottomMargin = this.E0.i;
        this.g0.setLayoutParams(layoutParams);
        PanelView panelView = this.g0;
        panelView.setPadding(panelView.getPaddingLeft(), this.g0.getPaddingTop(), this.g0.getPaddingRight(), k.a(getContext(), 9.0f) + (i5 - this.E0.i));
        if (!b(this.O)) {
            g gVar = this.E0;
            int i6 = gVar.i;
            layoutParams3.bottomMargin = i6;
            layoutParams3.height = (this.I + gVar.h) - (i6 * 2);
            basePlayerView.setLayoutParams(layoutParams3);
            int paddingLeft = basePlayerView.getPaddingLeft();
            int paddingTop = basePlayerView.getPaddingTop();
            int paddingRight = basePlayerView.getPaddingRight();
            g gVar2 = this.E0;
            basePlayerView.setPadding(paddingLeft, paddingTop, paddingRight, gVar2.h - (gVar2.i * 2));
        }
        this.G0 = layoutParams3.height;
        g gVar3 = this.E0;
        RelativeLayout relativeLayout = this.f0;
        if (gVar3.f || gVar3.g) {
            return;
        }
        gVar3.f = true;
        relativeLayout.postDelayed(new f(gVar3, relativeLayout), 2000L);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final boolean b(int i) {
        return (TextUtils.isEmpty(this.c.e) && TextUtils.isEmpty(this.c.c) && TextUtils.isEmpty(this.c.d)) ? false : true;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void f() {
        this.F0 = k.a(getContext(), 38.0f);
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_half_screen_letter_vertical", "layout"), this);
        int i = this.F0;
        setPadding(i, 0, i, 0);
        setBackgroundResource(k.a(getContext(), "dailog_background_color", "color"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        int i = (this.G0 * 2) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, i, 0, 0);
        return layoutParams;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void s() {
        super.s();
        g gVar = new g(getContext());
        this.E0 = gVar;
        gVar.a((RelativeLayout) this.f0.getParent(), this.f0.getId());
        g gVar2 = this.E0;
        this.m = gVar2.a;
        gVar2.a(this.c, this.b, new n3(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.HalfScreenATView, com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void x() {
        e eVar;
        super.x();
        a aVar = this.b;
        if (aVar == null || (eVar = aVar.s) == null || eVar.e != 0) {
            return;
        }
        this.f0.setOnClickListener(new m3(this));
    }

    public LetterHalfScreenATView(Context context, a aVar, c cVar, String str, int i, int i2) {
        super(context, aVar, cVar, str, i, i2);
        if (this.o != null) {
            HashMap map = new HashMap();
            map.put("screen_style", 1);
            this.o.a(map);
        }
    }
}
