package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class LetterHalfScreenATView extends HalfScreenATView {
    com.anythink.basead.b.d.a an;
    int ao;
    int ap;

    @Override // com.anythink.basead.ui.HalfScreenATView
    protected final int af() {
        return 9;
    }

    public LetterHalfScreenATView(Context context) {
        super(context);
    }

    public LetterHalfScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str, i, i2);
        if (this.s != null) {
            HashMap map = new HashMap();
            map.put(g.a.a, 1);
            this.s.a(map);
        }
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseATView
    protected final void a() {
        this.ao = q.a(getContext(), 38.0f);
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_half_screen_letter_vertical", "layout"), this);
        int i = this.ao;
        setPadding(i, 0, i, 0);
        setBackgroundResource(q.a(getContext(), "dailog_background_color", "color"));
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void b() {
        super.b();
        if (this.f == null || this.f.o == null || this.f.o.H() != 0) {
            return;
        }
        this.M.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.LetterHalfScreenATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LetterHalfScreenATView.this.a(1, 7);
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void c() {
        super.c();
        com.anythink.basead.b.d.a aVar = new com.anythink.basead.b.d.a(getContext());
        this.an = aVar;
        aVar.a((RelativeLayout) this.M.getParent(), this.M.getId());
        this.q = this.an.d();
        this.an.a(this.g, this.f, new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.LetterHalfScreenATView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.basead.ui.f.b.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.f.b.a
        public final void a(int i, int i2) {
            LetterHalfScreenATView.this.a(i, i2);
        }
    }

    private void ah() {
        this.an.a(this.g, this.f, new AnonymousClass2());
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void U() {
        BasePlayerView basePlayerViewL = this.r.l();
        if (basePlayerViewL != null) {
            this.O.setPadding(basePlayerViewL.getPaddingLeft(), basePlayerViewL.getPaddingTop(), basePlayerViewL.getPaddingRight(), basePlayerViewL.getPaddingBottom());
        }
        super.U();
    }

    @Override // com.anythink.basead.ui.HalfScreenATView
    protected final void ag() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
        BasePlayerView basePlayerViewL = this.r.l();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) basePlayerViewL.getLayoutParams();
        this.A = ((this.c - layoutParams2.leftMargin) - layoutParams2.rightMargin) - (this.ao * 2);
        this.B = this.A;
        this.an.a(this.c - (this.ao * 2));
        int iA = this.an.a();
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        this.M.setLayoutParams(layoutParams2);
        layoutParams3.width = this.A;
        layoutParams3.height = this.B;
        basePlayerViewL.setLayoutParams(layoutParams3);
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.topMargin = this.B;
        layoutParams.bottomMargin = this.an.b();
        this.N.setLayoutParams(layoutParams);
        this.N.setPadding(this.N.getPaddingLeft(), this.N.getPaddingTop(), this.N.getPaddingRight(), (iA - this.an.b()) + q.a(getContext(), 9.0f));
        if (!b(this.E)) {
            layoutParams3.bottomMargin = this.an.b();
            layoutParams3.height = (this.B + this.an.a()) - (this.an.b() * 2);
            basePlayerViewL.setLayoutParams(layoutParams3);
            basePlayerViewL.setPadding(basePlayerViewL.getPaddingLeft(), basePlayerViewL.getPaddingTop(), basePlayerViewL.getPaddingRight(), this.an.a() - (this.an.b() * 2));
        }
        this.ap = layoutParams3.height;
        this.an.a(this.M);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void F() {
        super.F();
        com.anythink.basead.b.d.a aVar = this.an;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final boolean b(int i) {
        if (this.g.n()) {
            return false;
        }
        return (TextUtils.isEmpty(this.g.z()) && TextUtils.isEmpty(this.g.x()) && TextUtils.isEmpty(this.g.y())) ? false : true;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void Q() {
        if (!b(this.E)) {
            aa().setVisibility(8);
        } else {
            super.Q();
        }
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    protected final RelativeLayout.LayoutParams q() {
        int i = (this.ap * 2) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, i, 0, 0);
        return layoutParams;
    }
}
