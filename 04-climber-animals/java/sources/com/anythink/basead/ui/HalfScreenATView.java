package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.b.e;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.basead.ui.f.d;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class HalfScreenATView extends BaseScreenATView {
    public static final String TAG = "HalfScreenATView";
    protected View ah;
    protected d ai;
    protected final int aj;
    protected final int ak;
    protected final int al;
    protected int am;

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void R() {
    }

    public boolean isAttachRoot() {
        return true;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final int r() {
        return 2;
    }

    public HalfScreenATView(Context context) {
        super(context);
        this.aj = 1;
        this.ak = 2;
        this.al = 3;
    }

    public HalfScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str, i, i2);
        this.aj = 1;
        this.ak = 2;
        this.al = 3;
        setId(q.a(getContext(), "myoffer_half_screen_view_id", "id"));
        if (xVar != null) {
            this.ai = new d(wVar, xVar.o);
        }
    }

    protected int af() {
        int i = this.am;
        if (i != 1) {
            return i != 2 ? 4 : 3;
        }
        return 7;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void G() {
        super.G();
        if (this.g.J() == 1) {
            if (this.g.V() > 0 && this.g.W() > 0) {
                this.ad = this.g.V();
                this.ae = this.g.W();
            }
            int i = this.ad;
            int i2 = this.ae;
        }
    }

    private boolean ah() {
        return this.g.n() || this.ad <= this.ae;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    protected final void e() {
        super.e();
        if ((!e.a(this.g)) || this.g.n()) {
            this.am = 1;
        } else if (ah()) {
            this.am = 2;
        } else {
            this.am = 3;
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected void a() {
        int i = this.am;
        if (i == 1) {
            this.ah = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_half_screen_empty_info", "layout"), this, isAttachRoot());
        } else if (i == 2) {
            this.ah = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_half_screen_vertical", "layout"), this, isAttachRoot());
        } else {
            this.ah = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_half_screen_horizontal", "layout"), this, isAttachRoot());
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void b() {
        super.b();
        try {
            ag();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d dVar = this.ai;
        if (dVar != null) {
            dVar.a(this.E).a(new com.anythink.basead.ui.d.a() { // from class: com.anythink.basead.ui.HalfScreenATView.1
                @Override // com.anythink.basead.ui.d.a
                public final void a(int i, int i2) {
                    HalfScreenATView.this.a(i, i2);
                }
            }).a(getContext(), this.ah);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void I() {
        super.I();
        this.E = af();
        if (aa() != null) {
            aa().setLayoutType(this.E);
            if (b(this.E)) {
                Q();
            } else {
                aa().setVisibility(8);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final int y() {
        return this.E;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected boolean b(int i) {
        if (this.g.n()) {
            return false;
        }
        return (i == 7 && this.f.o.H() == 0) ? false : true;
    }

    private boolean ai() {
        return !e.a(this.g);
    }

    protected void ag() {
        int i;
        int i2;
        int i3;
        int iA;
        int i4;
        int iA2;
        View viewFindViewById;
        View viewFindViewById2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
        int i5 = layoutParams2.leftMargin;
        int i6 = layoutParams2.rightMargin;
        int i7 = layoutParams2.topMargin;
        int i8 = layoutParams2.bottomMargin;
        BasePlayerView basePlayerViewL = this.r.l();
        RelativeLayout.LayoutParams layoutParams3 = basePlayerViewL != null ? (RelativeLayout.LayoutParams) basePlayerViewL.getLayoutParams() : null;
        int iB = q.b(getContext());
        if (iB <= 0) {
            iB = q.a(getContext(), 32.0f);
        }
        int i9 = this.am;
        if (i9 == 1) {
            if (this.b == 2) {
                i2 = (this.d - i7) - i8;
                i3 = (int) (i2 * 1.75f);
                iA = q.a(getContext(), 120.0f);
                if (i7 < iB) {
                    layoutParams2.topMargin = (int) (iB * 1.1f);
                }
                layoutParams2.width = i3;
                this.M.setLayoutParams(layoutParams2);
            } else if (ah()) {
                i3 = (this.c - i5) - i6;
                i2 = (int) (i3 / 0.5714286f);
                int i10 = iB * 4;
                if (this.d - i2 < i10) {
                    i2 = this.d - i10;
                }
                iA = q.a(getContext(), 240.0f);
            } else {
                i3 = (this.c - i5) - i6;
                i2 = (int) (i3 / 1.032258f);
                iA = q.a(getContext(), 120.0f);
            }
            this.A = i3;
            this.B = i2;
        } else {
            if (i9 == 2) {
                if (this.b == 1) {
                    View viewFindViewById3 = this.N.findViewById(q.a(getContext(), "myoffer_panel_view_blank", "id"));
                    i = viewFindViewById3 != null ? ((RelativeLayout.LayoutParams) viewFindViewById3.getLayoutParams()).topMargin : 0;
                    i3 = (this.c - i5) - i6;
                    float f = i3;
                    int i11 = (int) (f / 0.5714286f);
                    int i12 = iB * 4;
                    if (this.d - i11 < i12) {
                        i11 = this.d - i12;
                    }
                    iA = (int) (f / 1.8181819f);
                    this.A = i3;
                    this.B = (i11 - iA) + i;
                    i2 = i11;
                } else {
                    if (i7 < iB) {
                        i7 = (int) (iB * 1.1f);
                        layoutParams2.topMargin = i7;
                    }
                    i2 = (this.d - i7) - i8;
                    i3 = (int) (i2 * 1.6f);
                    if (this.ai != null && (iA2 = this.c - (q.a(getContext(), 116.0f) * 2)) < i3) {
                        i2 = (int) (iA2 / 1.6f);
                        i3 = iA2;
                    }
                    this.B = i2;
                    this.A = (int) (this.B * 0.56f);
                    i4 = i3 - this.A;
                    layoutParams2.width = i3;
                    this.M.setLayoutParams(layoutParams2);
                    iA = i2;
                }
                layoutParams2.width = i3;
                layoutParams2.height = i2;
                this.M.setLayoutParams(layoutParams2);
                if (layoutParams3 != null && basePlayerViewL != null) {
                    layoutParams3.width = this.A;
                    layoutParams3.height = this.B;
                    basePlayerViewL.setLayoutParams(layoutParams3);
                }
                layoutParams.width = i4;
                layoutParams.height = iA;
                this.N.setLayoutParams(layoutParams);
                if (this.am == 2 || this.b != 2) {
                    viewFindViewById = findViewById(q.a(getContext(), "myoffer_guide2click_container", "id"));
                    if (viewFindViewById != null && layoutParams3 != null) {
                        viewFindViewById.setLayoutParams(layoutParams3);
                    }
                    viewFindViewById2 = findViewById(q.a(getContext(), "myoffer_guide2click_mask", "id"));
                    if (viewFindViewById2 != null || layoutParams3 == null) {
                    }
                    viewFindViewById2.setLayoutParams(layoutParams3);
                    return;
                }
                return;
            }
            View viewFindViewById4 = this.N.findViewById(q.a(getContext(), "myoffer_panel_view_blank", "id"));
            i = viewFindViewById4 != null ? ((RelativeLayout.LayoutParams) viewFindViewById4.getLayoutParams()).topMargin : 0;
            if (this.b == 1) {
                i3 = (this.c - i5) - i6;
                i2 = (int) (i3 / 1.032258f);
                this.A = i3;
                this.B = (int) (this.A / 2.0f);
                iA = (i2 - this.B) + i;
            } else {
                if (i7 < iB) {
                    i7 = (int) (iB * 1.1f);
                    layoutParams2.topMargin = i7;
                }
                i2 = (this.d - i7) - i8;
                i3 = (int) (i2 * 1.032258f);
                this.A = i3;
                this.B = (int) (this.A / 2.0f);
                iA = (i2 - this.B) + i;
                layoutParams2.width = i3;
                this.M.setLayoutParams(layoutParams2);
            }
        }
        i4 = i3;
        layoutParams2.width = i3;
        layoutParams2.height = i2;
        this.M.setLayoutParams(layoutParams2);
        if (layoutParams3 != null) {
            layoutParams3.width = this.A;
            layoutParams3.height = this.B;
            basePlayerViewL.setLayoutParams(layoutParams3);
        }
        layoutParams.width = i4;
        layoutParams.height = iA;
        this.N.setLayoutParams(layoutParams);
        if (this.am == 2) {
        }
        viewFindViewById = findViewById(q.a(getContext(), "myoffer_guide2click_container", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setLayoutParams(layoutParams3);
        }
        viewFindViewById2 = findViewById(q.a(getContext(), "myoffer_guide2click_mask", "id"));
        if (viewFindViewById2 != null) {
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void U() {
        if (this.N != null) {
            this.N.notifyHalfScreenEndCardShow();
        }
        BasePlayerView basePlayerViewL = this.r.l();
        if (this.M == null || this.O == null || this.O.getParent() != null || basePlayerViewL == null) {
            return;
        }
        this.M.addView(this.O, 1, basePlayerViewL.getLayoutParams());
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected void M() {
        super.N();
        super.c(1);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    protected RelativeLayout.LayoutParams q() {
        if (this.M != null && this.N != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
            int i = (layoutParams.height * 2) / 3;
            BasePlayerView basePlayerViewL = this.r.l();
            if (basePlayerViewL != null) {
                i = (((RelativeLayout.LayoutParams) basePlayerViewL.getLayoutParams()).height * 2) / 3;
            } else if (this.O != null) {
                i = (((RelativeLayout.LayoutParams) this.O.getLayoutParams()).height * 2) / 3;
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.setMargins(0, i, (this.am == 2 && this.b == 2) ? layoutParams2.width + 0 : 0, 0);
            return layoutParams3;
        }
        return super.q();
    }
}
