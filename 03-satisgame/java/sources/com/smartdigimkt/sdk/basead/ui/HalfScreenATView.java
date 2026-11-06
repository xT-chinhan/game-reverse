package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.n1.h3;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public class HalfScreenATView extends BaseScreenATView {
    public static final String TAG = "HalfScreenATView";
    public View B0;
    public int C0;
    public int D0;

    public HalfScreenATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void A() {
        O();
        c(1);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void E() {
        EndCardView endCardView;
        PanelView panelView = this.g0;
        if (panelView != null) {
            panelView.notifyHalfScreenEndCardShow();
        }
        BasePlayerView basePlayerView = this.n.h;
        if (this.f0 == null || (endCardView = this.h0) == null || endCardView.getParent() != null || basePlayerView == null) {
            return;
        }
        this.f0.addView(this.h0, 1, basePlayerView.getLayoutParams());
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void H() {
        r rVar = this.s0;
        if (rVar != null) {
            rVar.c = this.O;
            rVar.l = new h3(this);
            rVar.a(getContext(), this.B0);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void L() {
        super.L();
        if (this.C0 != 1) {
            return;
        }
        PanelView panelView = getPanelView();
        if (panelView == null || panelView.getVisibility() != 0) {
            panelView = null;
        }
        a(panelView);
    }

    public int P() {
        int i = this.C0;
        if (i != 1) {
            return i != 2 ? 104 : 103;
        }
        return 107;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0196  */
    public void Q() {
        int i;
        int i2;
        int iA;
        int i3;
        int i4;
        int iA2;
        int i5;
        int i6;
        float fMin;
        View viewFindViewById;
        View viewFindViewById2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g0.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f0.getLayoutParams();
        int i7 = layoutParams2.leftMargin;
        int i8 = layoutParams2.rightMargin;
        int i9 = layoutParams2.topMargin;
        int i10 = layoutParams2.bottomMargin;
        BasePlayerView basePlayerView = this.n.h;
        RelativeLayout.LayoutParams layoutParams3 = basePlayerView != null ? (RelativeLayout.LayoutParams) basePlayerView.getLayoutParams() : null;
        int iA3 = k.a(getContext());
        if (iA3 <= 0) {
            iA3 = k.a(getContext(), 32.0f);
        }
        int i11 = this.C0;
        if (i11 == 1) {
            if (this.D0 == 2) {
                i = (this.G - i9) - i10;
                i2 = (int) (i * 1.75f);
                iA = k.a(getContext(), 120.0f);
                if (i9 < iA3) {
                    layoutParams2.topMargin = (int) (iA3 * 1.1f);
                }
                layoutParams2.width = i2;
                this.f0.setLayoutParams(layoutParams2);
            } else if (this.x0 <= this.y0) {
                i2 = (this.F - i7) - i8;
                i = (int) (i2 / 0.5714286f);
                int i12 = this.G;
                int i13 = iA3 * 4;
                if (i12 - i < i13) {
                    i = i12 - i13;
                }
                iA = k.a(getContext(), 240.0f);
            } else {
                i2 = (this.F - i7) - i8;
                i = (int) (i2 / 1.032258f);
                iA = k.a(getContext(), 120.0f);
            }
            this.H = i2;
            this.I = i;
        } else {
            if (i11 == 2) {
                if (this.D0 == 1) {
                    View viewFindViewById3 = this.g0.findViewById(k.a(getContext(), "myoffer_panel_view_blank", "id"));
                    int i14 = viewFindViewById3 != null ? ((RelativeLayout.LayoutParams) viewFindViewById3.getLayoutParams()).topMargin : 0;
                    i2 = (this.F - i7) - i8;
                    float f = i2;
                    i3 = (int) (f / 0.5714286f);
                    int i15 = this.G;
                    int i16 = iA3 * 4;
                    if (i15 - i3 < i16) {
                        i3 = i15 - i16;
                    }
                    iA = (int) (f / 1.8181819f);
                    this.H = i2;
                    this.I = (i3 - iA) + i14;
                } else {
                    if (i9 < iA3) {
                        i9 = (int) (iA3 * 1.1f);
                        layoutParams2.topMargin = i9;
                    }
                    i = (this.G - i9) - i10;
                    i2 = (int) (i * 1.6f);
                    if (this.s0 != null && (iA2 = this.F - (k.a(getContext(), 116.0f) * 2)) < i2) {
                        i = (int) (iA2 / 1.6f);
                        i2 = iA2;
                    }
                    this.I = i;
                    int i17 = (int) (i * 0.56f);
                    this.H = i17;
                    i4 = i2 - i17;
                    layoutParams2.width = i2;
                    this.f0.setLayoutParams(layoutParams2);
                    iA = i;
                }
                i5 = this.F;
                if (i2 <= i5 || i > this.G) {
                    i6 = 1;
                    fMin = Math.min(i5 / Math.max(1, i2), this.G / Math.max(1, i));
                } else {
                    fMin = 1.0f;
                    i6 = 1;
                }
                int iMax = Math.max(i6, Math.min((int) (i2 * fMin), this.F));
                int iMax2 = Math.max(i6, Math.min((int) (i * fMin), this.G));
                this.H = Math.max(i6, Math.min((int) (this.H * fMin), iMax));
                this.I = Math.max(i6, Math.min((int) (this.I * fMin), iMax2));
                int iMax3 = Math.max(i6, Math.min((int) (i4 * fMin), iMax));
                int iMax4 = Math.max(i6, Math.min((int) (iA * fMin), iMax2));
                layoutParams2.width = iMax;
                layoutParams2.height = iMax2;
                this.f0.setLayoutParams(layoutParams2);
                if (layoutParams3 != null && basePlayerView != null) {
                    layoutParams3.width = this.H;
                    layoutParams3.height = this.I;
                    basePlayerView.setLayoutParams(layoutParams3);
                }
                layoutParams.width = iMax3;
                layoutParams.height = iMax4;
                this.g0.setLayoutParams(layoutParams);
                if (this.C0 == 2 || this.D0 != 2) {
                    viewFindViewById = findViewById(k.a(getContext(), "myoffer_guide2click_container", "id"));
                    if (viewFindViewById != null && layoutParams3 != null) {
                        viewFindViewById.setLayoutParams(layoutParams3);
                    }
                    viewFindViewById2 = findViewById(k.a(getContext(), "myoffer_guide2click_mask", "id"));
                    if (viewFindViewById2 != null || layoutParams3 == null) {
                    }
                    viewFindViewById2.setLayoutParams(layoutParams3);
                    return;
                }
                return;
            }
            View viewFindViewById4 = this.g0.findViewById(k.a(getContext(), "myoffer_panel_view_blank", "id"));
            int i18 = viewFindViewById4 != null ? ((RelativeLayout.LayoutParams) viewFindViewById4.getLayoutParams()).topMargin : 0;
            if (this.D0 == 1) {
                i2 = (this.F - i7) - i8;
                float f2 = i2;
                i3 = (int) (f2 / 1.032258f);
                this.H = i2;
                int i19 = (int) (f2 / 2.0f);
                this.I = i19;
                iA = (i3 - i19) + i18;
            } else {
                if (i9 < iA3) {
                    i9 = (int) (iA3 * 1.1f);
                    layoutParams2.topMargin = i9;
                }
                i = (this.G - i9) - i10;
                i2 = (int) (i * 1.032258f);
                this.H = i2;
                int i20 = (int) (i2 / 2.0f);
                this.I = i20;
                iA = (i - i20) + i18;
                layoutParams2.width = i2;
                this.f0.setLayoutParams(layoutParams2);
            }
            i = i3;
        }
        i4 = i2;
        i5 = this.F;
        if (i2 <= i5) {
            i6 = 1;
            fMin = Math.min(i5 / Math.max(1, i2), this.G / Math.max(1, i));
        } else {
            i6 = 1;
            fMin = Math.min(i5 / Math.max(1, i2), this.G / Math.max(1, i));
        }
        int iMax5 = Math.max(i6, Math.min((int) (i2 * fMin), this.F));
        int iMax6 = Math.max(i6, Math.min((int) (i * fMin), this.G));
        this.H = Math.max(i6, Math.min((int) (this.H * fMin), iMax5));
        this.I = Math.max(i6, Math.min((int) (this.I * fMin), iMax6));
        int iMax7 = Math.max(i6, Math.min((int) (i4 * fMin), iMax5));
        int iMax8 = Math.max(i6, Math.min((int) (iA * fMin), iMax6));
        layoutParams2.width = iMax5;
        layoutParams2.height = iMax6;
        this.f0.setLayoutParams(layoutParams2);
        if (layoutParams3 != null) {
            layoutParams3.width = this.H;
            layoutParams3.height = this.I;
            basePlayerView.setLayoutParams(layoutParams3);
        }
        layoutParams.width = iMax7;
        layoutParams.height = iMax8;
        this.g0.setLayoutParams(layoutParams);
        if (this.C0 == 2) {
        }
        viewFindViewById = findViewById(k.a(getContext(), "myoffer_guide2click_container", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setLayoutParams(layoutParams3);
        }
        viewFindViewById2 = findViewById(k.a(getContext(), "myoffer_guide2click_mask", "id"));
        if (viewFindViewById2 != null) {
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void b() {
        super.b();
        this.D0 = getResources().getConfiguration().orientation;
        if (!c0.a(this.c)) {
            this.C0 = 1;
        } else if (this.x0 <= this.y0) {
            this.C0 = 2;
        } else {
            this.C0 = 3;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void f() {
        int i = this.C0;
        if (i == 1) {
            this.B0 = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_half_screen_empty_info", "layout"), this, isAttachRoot());
        } else if (i != 2) {
            this.B0 = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_half_screen_horizontal", "layout"), this, isAttachRoot());
        } else {
            this.B0 = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_half_screen_vertical", "layout"), this, isAttachRoot());
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public int getATViewType() {
        return 2;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void getMaterialRealSize() {
        int i;
        int i2;
        super.getMaterialRealSize();
        c cVar = this.c;
        if (cVar.n != 1 || (i = cVar.G) <= 0 || (i2 = cVar.H) <= 0) {
            return;
        }
        this.x0 = i;
        this.y0 = i2;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public int getPanelViewTypeForShowEndCard() {
        return this.O;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView, com.smartdigimkt.sdk.basead.ui.BaseATView
    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        RelativeLayout relativeLayout = this.f0;
        if (relativeLayout == null || this.g0 == null) {
            return super.getSpecialNoteViewLayoutParams();
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.g0.getLayoutParams();
        int i = (layoutParams.height * 2) / 3;
        BasePlayerView basePlayerView = this.n.h;
        if (basePlayerView != null) {
            i = (((RelativeLayout.LayoutParams) basePlayerView.getLayoutParams()).height * 2) / 3;
        } else {
            EndCardView endCardView = this.h0;
            if (endCardView != null) {
                i = (((RelativeLayout.LayoutParams) endCardView.getLayoutParams()).height * 2) / 3;
            }
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, i, (this.C0 == 2 && this.E == 2) ? layoutParams2.width : 0, 0);
        return layoutParams3;
    }

    public boolean isAttachRoot() {
        return true;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void j() {
        if (this.f0 != null && this.g0 != null && this.n != null) {
            Q();
        }
        requestLayout();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void r() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public final void v() {
        this.O = P();
        if (getPanelView() != null) {
            getPanelView().setLayoutType(this.O);
            if (b(this.O)) {
                L();
            } else {
                getPanelView().setVisibility(8);
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public void x() {
        super.x();
        try {
            Q();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public HalfScreenATView(Context context, a aVar, c cVar, String str, int i, int i2) {
        super(context, aVar, cVar, str, i, i2);
        setId(k.a(getContext(), "myoffer_half_screen_view_id", "id"));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseScreenATView
    public boolean b(int i) {
        return (i == 107 && this.b.s.e == 0) ? false : true;
    }
}
