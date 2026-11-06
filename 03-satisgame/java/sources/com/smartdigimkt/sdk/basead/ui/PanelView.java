package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.i2.j;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.a4;
import com.smartdigimkt.n1.b4;
import com.smartdigimkt.n1.c4;
import com.smartdigimkt.n1.d4;
import com.smartdigimkt.n1.x3;
import com.smartdigimkt.n1.y3;
import com.smartdigimkt.n1.z3;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.sdk.basead.ui.component.RoundFrameLayout;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.z.c0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PanelView extends RelativeLayout {
    public static final int TYPE_FULL_SCREEN_BANNER = 100;
    public static final int TYPE_FULL_SCREEN_EMPTY_INFO = 108;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_LANDSCAPE = 106;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_PORTRAIT = 101;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_LANDSCAPE = 102;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_PORTRAIT = 105;
    public static final int TYPE_HALF_SCREEN_EMPTY_INFO = 107;
    public static final int TYPE_HALF_SCREEN_HORIZONTAL = 104;
    public static final int TYPE_HALF_SCREEN_VERTICAL = 103;
    public static final int TYPE_LETTER = 109;
    public static final int TYPE_UNINITIALIZED = 0;
    public View a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public CTAButtonLayout f;
    public BaseShakeView g;
    public d4 h;
    public int i;
    public e j;
    public a k;
    public c l;
    public int m;
    public boolean n;
    public ArrayList o;
    public r p;
    public View q;
    public boolean r;
    public final x3 s;

    public PanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        this.n = false;
        this.r = false;
        this.s = new x3(this);
    }

    private void setDataFrom(c cVar) {
        ViewGroup viewGroup;
        int iIndexOfChild;
        ImageView imageView = this.b;
        if (imageView != null) {
            View view = this.q;
            if (view == null) {
                String str = cVar.e;
                if (!TextUtils.isEmpty(str)) {
                    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                    m.a(getContext()).a(new o(1, str), layoutParams.width, layoutParams.height, new a4(this, str));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    d.a(imageView);
                    d.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i = this.m;
                    if (i == 102 || i == 106) {
                        roundFrameLayout.setRadius(8);
                    } else {
                        roundFrameLayout.setRadius(12);
                    }
                    roundFrameLayout.addView(view);
                    viewGroup.addView(roundFrameLayout, iIndexOfChild, layoutParams2);
                    roundFrameLayout.setId(imageView.getId());
                    if (view instanceof ImageView) {
                        this.b = (ImageView) view;
                    }
                }
            }
            if (!a()) {
                this.b.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (TextUtils.isEmpty(cVar.d)) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(cVar.d);
            }
        }
        if (this.d != null) {
            if (TextUtils.isEmpty(cVar.c)) {
                this.d.setVisibility(8);
            } else {
                this.d.setText(cVar.c);
            }
        }
        CTAButtonLayout cTAButtonLayout = this.f;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(cVar, this.k, this.r, new b4(this));
            int i2 = this.m;
            if (i2 == 108 || i2 == 107) {
                this.f.changeMinorButtonStyle();
            }
        }
        new j(cVar, this.k).a(this);
    }

    public final boolean a() {
        c cVar = this.l;
        return ((cVar == null || TextUtils.isEmpty(cVar.e)) && this.q == null) ? false : true;
    }

    public View getCTAButton() {
        return this.f;
    }

    public List<View> getClickViews() {
        return this.o;
    }

    public View getDescView() {
        return this.e;
    }

    public View getIconView() {
        ImageView imageView = this.b;
        View view = this.q;
        return view != null ? view : imageView;
    }

    public View getShakeView() {
        return this.g;
    }

    public View getTitleView() {
        return this.d;
    }

    public boolean hasApkComplianceElements() {
        View view = this.a;
        return (view == null || view.findViewById(k.a(getContext(), "myoffer_four_element_container", "id")) == null) ? false : true;
    }

    public void init(c cVar, a aVar, int i, boolean z, d4 d4Var) {
        this.h = d4Var;
        this.i = i;
        this.l = cVar;
        this.k = aVar;
        this.j = aVar.s;
        this.n = z;
        cVar.g();
        int i2 = this.j.h;
        this.o = new ArrayList();
        e eVar = aVar.s;
        if (eVar == null || !c0.a(eVar)) {
            return;
        }
        this.p = new r(cVar, this.j);
    }

    public boolean isFullScreenEndCardLayout() {
        int i = this.m;
        return i == 101 || i == 102 || i == 105 || i == 106;
    }

    public void notifyHalfScreenEndCardShow() {
        this.r = true;
        CTAButtonLayout cTAButtonLayout = this.f;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(this.l, this.k, true, new c4(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setBaseAdIconView(View view) {
        this.q = view;
    }

    public void setLayoutType(int i) {
        BaseShakeView baseShakeView;
        a aVar;
        if (this.m == i) {
            return;
        }
        this.m = i;
        switch (i) {
            case 101:
                if (!a()) {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_endcard_horizontal_portrait", "layout"), (ViewGroup) this, true);
                }
                break;
            case 102:
            case 106:
                if (!a()) {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_endcard_landscape_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_endcard_landscape", "layout"), (ViewGroup) this, true);
                }
                break;
            case 103:
                if (this.i != 1) {
                    if (!a()) {
                        this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_vertical_without_icon", "layout"), (ViewGroup) this, true);
                    } else {
                        this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_vertical", "layout"), (ViewGroup) this, true);
                    }
                } else if (!a()) {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                }
                break;
            case 104:
                if (!a()) {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                }
                break;
            case 105:
                if (!a()) {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_endcard_vertical_portrait", "layout"), (ViewGroup) this, true);
                }
                break;
            case 107:
                this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 108:
                this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_full_screen_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 109:
                this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_letter", "layout"), (ViewGroup) this, true);
                break;
            default:
                if (!a()) {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_bottom_banner_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.a = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_panel_view_bottom_banner", "layout"), (ViewGroup) this, true);
                }
                break;
        }
        this.r = (i == 101 || i == 102 || i == 105 || i == 106 || i == 109) && !c0.d(this.l, this.k);
        this.o.clear();
        this.b = (ImageView) this.a.findViewById(k.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.d = (TextView) this.a.findViewById(k.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.e = (TextView) this.a.findViewById(k.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.f = (CTAButtonLayout) this.a.findViewById(k.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.c = (ImageView) this.a.findViewById(k.a(getContext(), "myoffer_ad_logo", "id"));
        try {
            BaseShakeView baseShakeView2 = (BaseShakeView) this.a.findViewById(k.a(getContext(), "myoffer_shake_hint_text", "id"));
            this.g = baseShakeView2;
            baseShakeView2.setShakeSetting(this.k.s, this.l.o);
            this.g.startShakeIconAnimation();
        } catch (Throwable unused) {
        }
        if (this.n && (baseShakeView = this.g) != null && this.m != 108 && ((aVar = this.k) == null || aVar.s == null || !aVar.t)) {
            baseShakeView.setVisibility(0);
        }
        setDataFrom(this.l);
        if (this.b != null) {
            this.l.getClass();
            this.b.setOnClickListener(this.s);
            this.o.add(this.b);
        }
        if (this.d != null) {
            this.l.getClass();
            this.d.setOnClickListener(this.s);
            this.o.add(this.d);
        }
        if (this.e != null) {
            this.l.getClass();
            this.e.setOnClickListener(this.s);
            this.o.add(this.e);
        }
        if (this.f != null) {
            this.l.getClass();
            this.f.setOnClickListener(this.s);
            this.o.add(this.f);
        }
        if (this.c != null) {
            this.l.getClass();
            this.c.setOnClickListener(this.s);
            this.o.add(this.c);
        }
        if (this.g != null && this.n) {
            this.l.getClass();
            this.g.setOnClickListener(this.s);
            this.g.setOnShakeListener(new z3(this), this.j);
        }
        View viewFindViewById = this.a.findViewById(k.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            this.l.getClass();
            viewFindViewById.setOnClickListener(this.s);
            this.o.add(viewFindViewById);
        } else {
            this.l.getClass();
            this.a.setOnClickListener(this.s);
            this.o.add(this.a);
        }
        ImageView imageView = this.b;
        if (imageView instanceof RoundImageView) {
            ((RoundImageView) imageView).setNeedRadiu(true);
            int i2 = this.m;
            if (i2 == 102 || i2 == 106) {
                ((RoundImageView) this.b).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.b).setRadiusInDip(12);
            }
            this.b.invalidate();
        }
        r rVar = this.p;
        if (rVar != null) {
            rVar.c = this.m;
            rVar.l = new y3(this);
            rVar.a(getContext(), this.a);
        }
    }
}
