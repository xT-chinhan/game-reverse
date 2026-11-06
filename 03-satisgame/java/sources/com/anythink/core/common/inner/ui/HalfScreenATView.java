package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class HalfScreenATView extends BaseScreenATView {
    public static final String TAG = "HalfScreenATView";
    protected View K;
    protected final int L;
    protected final int M;
    protected final int N;
    protected int O;

    public boolean isAttachRoot() {
        return true;
    }

    public HalfScreenATView(Context context) {
        super(context);
        this.L = 1;
        this.M = 2;
        this.N = 3;
    }

    public HalfScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str, i, i2);
        this.L = 1;
        this.M = 2;
        this.N = 3;
        setId(p.a(getContext(), "myoffer_half_screen_view_id", "id"));
    }

    private int y() {
        int i = this.O;
        if (i != 1) {
            return i != 2 ? 4 : 3;
        }
        return 7;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected void h() {
        super.h();
        if (this.g.t() != 1 || this.g.F() <= 0 || this.g.G() <= 0) {
            return;
        }
        this.G = this.g.F();
        this.H = this.g.G();
    }

    private boolean z() {
        return this.G <= this.H;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView, com.anythink.core.common.inner.ui.BaseATView
    protected final void d() {
        super.d();
        if (!com.anythink.core.common.inner.a.a.a(this.g)) {
            this.O = 1;
        } else if (z()) {
            this.O = 2;
        } else {
            this.O = 3;
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected void a() {
        int i = this.O;
        if (i == 1) {
            this.K = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_half_screen_empty_info", "layout"), this, isAttachRoot());
        } else if (i == 2) {
            this.K = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_half_screen_vertical", "layout"), this, isAttachRoot());
        } else {
            this.K = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_half_screen_horizontal", "layout"), this, isAttachRoot());
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected void b() {
        int i;
        int i2;
        int i3;
        int iA;
        int i4;
        int i5;
        int i6;
        int i7;
        int iA2;
        super.b();
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            int i8 = layoutParams2.leftMargin;
            int i9 = layoutParams2.rightMargin;
            int i10 = layoutParams2.topMargin;
            int i11 = layoutParams2.bottomMargin;
            View viewFindViewById = findViewById(p.a(getContext(), "myoffer_player_view_id", "id"));
            RelativeLayout.LayoutParams layoutParams3 = viewFindViewById != null ? (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams() : null;
            int iB = p.b(getContext());
            if (iB <= 0) {
                iB = p.a(getContext(), 32.0f);
            }
            int i12 = this.O;
            if (i12 == 1) {
                if (this.b == 2) {
                    i2 = (this.d - i10) - i11;
                    i3 = (int) (i2 * 1.75f);
                    iA = p.a(getContext(), 120.0f);
                    if (i10 < iB) {
                        layoutParams2.topMargin = (int) (iB * 1.1f);
                    }
                    layoutParams2.width = i3;
                    this.v.setLayoutParams(layoutParams2);
                } else {
                    if (z()) {
                        i6 = (this.c - i8) - i9;
                        i7 = (int) (i6 / 0.5714286f);
                        int i13 = iB * 4;
                        if (this.d - i7 < i13) {
                            i7 = this.d - i13;
                        }
                        iA2 = p.a(getContext(), 240.0f);
                    } else {
                        i6 = (this.c - i8) - i9;
                        i7 = (int) (i6 / 1.032258f);
                        iA2 = p.a(getContext(), 120.0f);
                    }
                    int i14 = i7;
                    int i15 = i6;
                    i2 = i14;
                    if (this.nativeTemplateRatio == 2) {
                        i2 = (this.c - i8) - i9;
                        iA = p.a(getContext(), 120.0f);
                        i3 = i2;
                    } else {
                        i3 = i15;
                        iA = iA2;
                    }
                }
                this.l = i3;
                this.m = i2;
            } else {
                if (i12 == 2) {
                    if (this.b == 1) {
                        View viewFindViewById2 = this.w.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
                        i = viewFindViewById2 != null ? ((RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams()).topMargin : 0;
                        i3 = (this.c - i8) - i9;
                        float f = i3;
                        int i16 = (int) (f / 0.5714286f);
                        if (this.nativeTemplateRatio == 2) {
                            i16 = ((int) (f / 0.6451613f)) - i;
                        }
                        int i17 = iB * 4;
                        if (this.d - i16 < i17) {
                            i16 = this.d - i17;
                        }
                        int i18 = (int) (f / 1.8181819f);
                        this.l = i3;
                        this.m = (i16 - i18) + i;
                        i4 = i18;
                        i2 = i16;
                        i5 = i3;
                    } else {
                        if (i10 < iB) {
                            i10 = (int) (iB * 1.1f);
                            layoutParams2.topMargin = i10;
                        }
                        i2 = (this.d - i10) - i11;
                        i3 = (int) (i2 * 1.6f);
                        this.m = i2;
                        this.l = (int) (this.m * 0.56f);
                        i5 = i3 - this.l;
                        layoutParams2.width = i3;
                        this.v.setLayoutParams(layoutParams2);
                        i4 = i2;
                    }
                } else {
                    View viewFindViewById3 = this.w.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
                    i = viewFindViewById3 != null ? ((RelativeLayout.LayoutParams) viewFindViewById3.getLayoutParams()).topMargin : 0;
                    if (this.b == 1) {
                        int i19 = (this.c - i8) - i9;
                        int i20 = (int) (i19 / 1.032258f);
                        this.l = i19;
                        this.m = (int) (this.l / 2.0f);
                        i4 = (i20 - this.m) + i;
                        if (this.nativeTemplateRatio == 2) {
                            i3 = (this.c - i8) - i9;
                            i2 = ((int) (i3 / 0.6666667f)) - i;
                            this.l = i3;
                            this.m = i3;
                            iA = (i2 - this.m) + i;
                        } else {
                            i3 = i19;
                            i5 = i3;
                            i2 = i20;
                        }
                    } else {
                        if (i10 < iB) {
                            i10 = (int) (iB * 1.1f);
                            layoutParams2.topMargin = i10;
                        }
                        i2 = (this.d - i10) - i11;
                        i3 = (int) (i2 * 1.032258f);
                        this.l = i3;
                        this.m = (int) (this.l / 2.0f);
                        iA = (i2 - this.m) + i;
                        layoutParams2.width = i3;
                        this.v.setLayoutParams(layoutParams2);
                    }
                }
                layoutParams2.width = i3;
                layoutParams2.height = i2;
                this.v.setLayoutParams(layoutParams2);
                if (layoutParams3 != null && viewFindViewById != null) {
                    layoutParams3.width = this.l;
                    layoutParams3.height = this.m;
                    viewFindViewById.setLayoutParams(layoutParams3);
                }
                layoutParams.width = i5;
                layoutParams.height = i4;
                this.w.setLayoutParams(layoutParams);
            }
            i4 = iA;
            i5 = i3;
            layoutParams2.width = i3;
            layoutParams2.height = i2;
            this.v.setLayoutParams(layoutParams2);
            if (layoutParams3 != null) {
                layoutParams3.width = this.l;
                layoutParams3.height = this.m;
                viewFindViewById.setLayoutParams(layoutParams3);
            }
            layoutParams.width = i5;
            layoutParams.height = i4;
            this.w.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected void j() {
        int i;
        super.j();
        int i2 = this.O;
        if (i2 != 1) {
            i = i2 != 2 ? 4 : 3;
        } else {
            i = 7;
        }
        this.p = i;
        if (t() != null) {
            t().setLayoutType(this.p);
            if (a(this.p)) {
                o();
            } else {
                t().setVisibility(8);
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final int g() {
        return this.p;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected boolean a(int i) {
        if (this.g.e()) {
            return false;
        }
        return (i == 7 && this.f.t.q() == 0) ? false : true;
    }

    private boolean A() {
        return !com.anythink.core.common.inner.a.a.a(this.g);
    }

    private void B() {
        int i;
        int i2;
        int i3;
        int iA;
        int i4;
        int i5;
        int i6;
        int iA2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
        int i7 = layoutParams2.leftMargin;
        int i8 = layoutParams2.rightMargin;
        int i9 = layoutParams2.topMargin;
        int i10 = layoutParams2.bottomMargin;
        View viewFindViewById = findViewById(p.a(getContext(), "myoffer_player_view_id", "id"));
        RelativeLayout.LayoutParams layoutParams3 = viewFindViewById != null ? (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams() : null;
        int iB = p.b(getContext());
        if (iB <= 0) {
            iB = p.a(getContext(), 32.0f);
        }
        int i11 = this.O;
        if (i11 == 1) {
            if (this.b == 2) {
                i2 = (this.d - i9) - i10;
                i3 = (int) (i2 * 1.75f);
                iA = p.a(getContext(), 120.0f);
                if (i9 < iB) {
                    layoutParams2.topMargin = (int) (iB * 1.1f);
                }
                layoutParams2.width = i3;
                this.v.setLayoutParams(layoutParams2);
            } else {
                if (z()) {
                    i5 = (this.c - i7) - i8;
                    i6 = (int) (i5 / 0.5714286f);
                    int i12 = iB * 4;
                    if (this.d - i6 < i12) {
                        i6 = this.d - i12;
                    }
                    iA2 = p.a(getContext(), 240.0f);
                } else {
                    i5 = (this.c - i7) - i8;
                    i6 = (int) (i5 / 1.032258f);
                    iA2 = p.a(getContext(), 120.0f);
                }
                if (this.nativeTemplateRatio == 2) {
                    i2 = (this.c - i7) - i8;
                    iA = p.a(getContext(), 120.0f);
                    i3 = i2;
                } else {
                    i3 = i5;
                    i2 = i6;
                    iA = iA2;
                }
            }
            this.l = i3;
            this.m = i2;
        } else {
            if (i11 == 2) {
                if (this.b == 1) {
                    View viewFindViewById2 = this.w.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
                    i = viewFindViewById2 != null ? ((RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams()).topMargin : 0;
                    i3 = (this.c - i7) - i8;
                    float f = i3;
                    int i13 = (int) (f / 0.5714286f);
                    if (this.nativeTemplateRatio == 2) {
                        i13 = ((int) (f / 0.6451613f)) - i;
                    }
                    int i14 = iB * 4;
                    if (this.d - i13 < i14) {
                        i13 = this.d - i14;
                    }
                    iA = (int) (f / 1.8181819f);
                    this.l = i3;
                    this.m = (i13 - iA) + i;
                    i2 = i13;
                } else {
                    if (i9 < iB) {
                        i9 = (int) (iB * 1.1f);
                        layoutParams2.topMargin = i9;
                    }
                    i2 = (this.d - i9) - i10;
                    i3 = (int) (i2 * 1.6f);
                    this.m = i2;
                    this.l = (int) (this.m * 0.56f);
                    i4 = i3 - this.l;
                    layoutParams2.width = i3;
                    this.v.setLayoutParams(layoutParams2);
                    iA = i2;
                }
            } else {
                View viewFindViewById3 = this.w.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
                i = viewFindViewById3 != null ? ((RelativeLayout.LayoutParams) viewFindViewById3.getLayoutParams()).topMargin : 0;
                if (this.b == 1) {
                    i4 = (this.c - i7) - i8;
                    int i15 = (int) (i4 / 1.032258f);
                    this.l = i4;
                    this.m = (int) (this.l / 2.0f);
                    int i16 = (i15 - this.m) + i;
                    if (this.nativeTemplateRatio == 2) {
                        i3 = (this.c - i7) - i8;
                        i2 = ((int) (i3 / 0.6666667f)) - i;
                        this.l = i3;
                        this.m = i3;
                        iA = (i2 - this.m) + i;
                    } else {
                        i3 = i4;
                        i2 = i15;
                        iA = i16;
                    }
                } else {
                    if (i9 < iB) {
                        i9 = (int) (iB * 1.1f);
                        layoutParams2.topMargin = i9;
                    }
                    i2 = (this.d - i9) - i10;
                    i3 = (int) (i2 * 1.032258f);
                    this.l = i3;
                    this.m = (int) (this.l / 2.0f);
                    iA = (i2 - this.m) + i;
                    layoutParams2.width = i3;
                    this.v.setLayoutParams(layoutParams2);
                }
            }
            layoutParams2.width = i3;
            layoutParams2.height = i2;
            this.v.setLayoutParams(layoutParams2);
            if (layoutParams3 != null && viewFindViewById != null) {
                layoutParams3.width = this.l;
                layoutParams3.height = this.m;
                viewFindViewById.setLayoutParams(layoutParams3);
            }
            layoutParams.width = i4;
            layoutParams.height = iA;
            this.w.setLayoutParams(layoutParams);
        }
        i4 = i3;
        layoutParams2.width = i3;
        layoutParams2.height = i2;
        this.v.setLayoutParams(layoutParams2);
        if (layoutParams3 != null) {
            layoutParams3.width = this.l;
            layoutParams3.height = this.m;
            viewFindViewById.setLayoutParams(layoutParams3);
        }
        layoutParams.width = i4;
        layoutParams.height = iA;
        this.w.setLayoutParams(layoutParams);
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected void q() {
        View viewFindViewById = findViewById(p.a(getContext(), "myoffer_player_view_id", "id"));
        if (this.v == null || this.x == null || this.x.getParent() != null || viewFindViewById == null) {
            return;
        }
        this.v.addView(this.x, 1, viewFindViewById.getLayoutParams());
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void l() {
        super.m();
    }
}
