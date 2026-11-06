package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.b.e;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.basead.ui.component.RoundFrameLayout;
import com.anythink.basead.ui.f.d;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PanelView extends RelativeLayout {
    public static final int TYPE_FULL_SCREEN_BANNER = 0;
    public static final int TYPE_FULL_SCREEN_EMPTY_INFO = 8;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_LANDSCAPE = 6;
    public static final int TYPE_FULL_SCREEN_ENDCARD_HORIZONTAL_PORTRAIT = 1;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_LANDSCAPE = 2;
    public static final int TYPE_FULL_SCREEN_ENDCARD_VERTICAL_PORTRAIT = 5;
    public static final int TYPE_HALF_SCREEN_EMPTY_INFO = 7;
    public static final int TYPE_HALF_SCREEN_HORIZONTAL = 4;
    public static final int TYPE_HALF_SCREEN_VERTICAL = 3;
    public static final int TYPE_LETTER = 9;
    protected boolean a;
    private View b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private CTAButtonLayout g;
    private BaseShakeView h;
    private a i;
    private int j;
    private y k;
    private x l;
    private w m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private List<View> r;
    private d s;
    private View t;
    private final View.OnClickListener u;

    public interface a {
        void a(int i, int i2);

        boolean a();
    }

    public PanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0;
        this.o = false;
        this.p = false;
        this.q = false;
        this.a = false;
        this.u = new View.OnClickListener() { // from class: com.anythink.basead.ui.PanelView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (PanelView.this.k != null) {
                    if (PanelView.this.k.H() == 1) {
                        if (view != PanelView.this.g || PanelView.this.i == null) {
                            return;
                        }
                        PanelView.this.i.a(1, 1);
                        return;
                    }
                    if (PanelView.this.i != null) {
                        if (view == PanelView.this.g) {
                            PanelView.this.i.a(1, 1);
                        } else if (PanelView.this.h == null || view != PanelView.this.h) {
                            PanelView.this.i.a(1, 2);
                        } else {
                            PanelView.this.i.a(1, 11);
                        }
                    }
                }
            }
        };
    }

    public void init(w wVar, x xVar, int i, boolean z, a aVar) {
        this.i = aVar;
        this.j = i;
        this.m = wVar;
        this.l = xVar;
        this.k = xVar.o;
        this.q = z;
        this.o = wVar.T();
        this.p = this.k.y() == 1;
        this.r = new ArrayList();
        this.s = new d(wVar, this.k);
    }

    private boolean a() {
        return this.o && !this.p;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.basead.ui.d.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.d.a
        public final void a(int i, int i2) {
            if (PanelView.this.i != null) {
                PanelView.this.i.a(i, i2);
            }
        }
    }

    private void c() {
        ImageView imageView = this.c;
        if (imageView instanceof RoundImageView) {
            ((RoundImageView) imageView).setNeedRadiu(true);
            int i = this.n;
            if (i == 2 || i == 6) {
                ((RoundImageView) this.c).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.c).setRadiusInDip(12);
            }
            this.c.invalidate();
        }
    }

    public void setLayoutType(int i) {
        ViewGroup viewGroup;
        int iIndexOfChild;
        BaseShakeView baseShakeView;
        this.n = i;
        switch (i) {
            case 1:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_endcard_horizontal_portrait", "layout"), (ViewGroup) this, true);
                }
                break;
            case 2:
            case 6:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_endcard_landscape_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_endcard_landscape", "layout"), (ViewGroup) this, true);
                }
                break;
            case 3:
                if (this.j == 1) {
                    if (!g()) {
                        this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                    } else {
                        this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                    }
                } else if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_vertical_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_vertical", "layout"), (ViewGroup) this, true);
                }
                break;
            case 4:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                }
                break;
            case 5:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_endcard_vertical_portrait", "layout"), (ViewGroup) this, true);
                }
                break;
            case 7:
                this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 8:
                this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_full_screen_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 9:
                this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_letter", "layout"), (ViewGroup) this, true);
                break;
            default:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_bottom_banner_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_panel_view_bottom_banner", "layout"), (ViewGroup) this, true);
                }
                break;
        }
        this.a = (i == 1 || i == 2 || i == 5 || i == 6 || i == 9) && !e.e(this.m, this.l);
        this.r.clear();
        this.c = (ImageView) this.b.findViewById(q.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.e = (TextView) this.b.findViewById(q.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f = (TextView) this.b.findViewById(q.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.g = (CTAButtonLayout) this.b.findViewById(q.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.d = (ImageView) this.b.findViewById(q.a(getContext(), "myoffer_ad_logo", "id"));
        try {
            BaseShakeView baseShakeView2 = (BaseShakeView) this.b.findViewById(q.a(getContext(), "myoffer_shake_hint_text", "id"));
            this.h = baseShakeView2;
            baseShakeView2.setShakeSetting(this.l.o, this.m.K());
            this.h.startShakeIconAnimation();
        } catch (Throwable unused) {
        }
        if (this.q && (baseShakeView = this.h) != null && this.n != 8) {
            baseShakeView.setVisibility(0);
        }
        w wVar = this.m;
        ImageView imageView = this.c;
        if (imageView != null) {
            View view = this.t;
            if (view == null) {
                String strZ = wVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strZ), layoutParams.width, layoutParams.height, new AnonymousClass4(strZ));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    am.a(imageView);
                    am.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i2 = this.n;
                    if (i2 == 2 || i2 == 6) {
                        roundFrameLayout.setRadius(8);
                    } else {
                        roundFrameLayout.setRadius(12);
                    }
                    roundFrameLayout.addView(view);
                    viewGroup.addView(roundFrameLayout, iIndexOfChild, layoutParams2);
                    roundFrameLayout.setId(imageView.getId());
                    if (view instanceof ImageView) {
                        this.c = (ImageView) view;
                    }
                }
            }
            if (!g()) {
                this.c.setVisibility(8);
            }
        }
        if (this.f != null) {
            if (!TextUtils.isEmpty(wVar.y())) {
                this.f.setText(wVar.y());
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(wVar.x())) {
                this.e.setText(wVar.x());
            } else {
                this.e.setVisibility(8);
            }
        }
        CTAButtonLayout cTAButtonLayout = this.g;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(wVar, this.l, this.a, new AnonymousClass5());
            int i3 = this.n;
            if (i3 == 8 || i3 == 7) {
                this.g.changeMinorButtonStyle();
            }
        }
        new com.anythink.basead.ui.f.a(wVar, this.l).b(this);
        if (this.c != null) {
            if (!this.m.c()) {
                this.c.setOnClickListener(this.u);
            }
            this.r.add(this.c);
        }
        if (this.e != null) {
            if (!this.m.c()) {
                this.e.setOnClickListener(this.u);
            }
            this.r.add(this.e);
        }
        if (this.f != null) {
            if (!this.m.c()) {
                this.f.setOnClickListener(this.u);
            }
            this.r.add(this.f);
        }
        if (this.g != null) {
            if (!this.m.c()) {
                this.g.setOnClickListener(this.u);
            }
            this.r.add(this.g);
        }
        if (this.d != null) {
            if (!this.m.c()) {
                this.d.setOnClickListener(this.u);
            }
            this.r.add(this.d);
        }
        if (this.h != null && this.q && !this.m.c()) {
            this.h.setOnClickListener(this.u);
            this.h.setOnShakeListener(new AnonymousClass3(), this.k);
        }
        View viewFindViewById = this.b.findViewById(q.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            if (!this.m.c()) {
                viewFindViewById.setOnClickListener(this.u);
            }
            this.r.add(viewFindViewById);
        } else {
            if (!this.m.c()) {
                this.b.setOnClickListener(this.u);
            }
            this.r.add(this.b);
        }
        ImageView imageView2 = this.c;
        if (imageView2 instanceof RoundImageView) {
            ((RoundImageView) imageView2).setNeedRadiu(true);
            int i4 = this.n;
            if (i4 == 2 || i4 == 6) {
                ((RoundImageView) this.c).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.c).setRadiusInDip(12);
            }
            this.c.invalidate();
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.a(this.n).a(new AnonymousClass2()).a(getContext(), this.b);
        }
    }

    private void d() {
        BaseShakeView baseShakeView;
        if (!this.q || (baseShakeView = this.h) == null || this.n == 8) {
            return;
        }
        baseShakeView.setVisibility(0);
    }

    private void e() {
        BaseShakeView baseShakeView;
        this.r.clear();
        this.c = (ImageView) this.b.findViewById(q.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.e = (TextView) this.b.findViewById(q.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f = (TextView) this.b.findViewById(q.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.g = (CTAButtonLayout) this.b.findViewById(q.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.d = (ImageView) this.b.findViewById(q.a(getContext(), "myoffer_ad_logo", "id"));
        try {
            BaseShakeView baseShakeView2 = (BaseShakeView) this.b.findViewById(q.a(getContext(), "myoffer_shake_hint_text", "id"));
            this.h = baseShakeView2;
            baseShakeView2.setShakeSetting(this.l.o, this.m.K());
            this.h.startShakeIconAnimation();
        } catch (Throwable unused) {
        }
        if (!this.q || (baseShakeView = this.h) == null || this.n == 8) {
            return;
        }
        baseShakeView.setVisibility(0);
    }

    private void f() {
        if (this.c != null) {
            if (!this.m.c()) {
                this.c.setOnClickListener(this.u);
            }
            this.r.add(this.c);
        }
        if (this.e != null) {
            if (!this.m.c()) {
                this.e.setOnClickListener(this.u);
            }
            this.r.add(this.e);
        }
        if (this.f != null) {
            if (!this.m.c()) {
                this.f.setOnClickListener(this.u);
            }
            this.r.add(this.f);
        }
        if (this.g != null) {
            if (!this.m.c()) {
                this.g.setOnClickListener(this.u);
            }
            this.r.add(this.g);
        }
        if (this.d != null) {
            if (!this.m.c()) {
                this.d.setOnClickListener(this.u);
            }
            this.r.add(this.d);
        }
        if (this.h != null && this.q && !this.m.c()) {
            this.h.setOnClickListener(this.u);
            this.h.setOnShakeListener(new AnonymousClass3(), this.k);
        }
        View viewFindViewById = this.b.findViewById(q.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            if (!this.m.c()) {
                viewFindViewById.setOnClickListener(this.u);
            }
            this.r.add(viewFindViewById);
        } else {
            if (!this.m.c()) {
                this.b.setOnClickListener(this.u);
            }
            this.r.add(this.b);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$3, reason: invalid class name */
    final class AnonymousClass3 implements BaseShakeView.a {
        AnonymousClass3() {
        }

        @Override // com.anythink.basead.ui.BaseShakeView.a
        public final boolean a() {
            if (PanelView.this.i != null) {
                return PanelView.this.i.a();
            }
            return false;
        }
    }

    private void a(w wVar) {
        ViewGroup viewGroup;
        int iIndexOfChild;
        ImageView imageView = this.c;
        if (imageView != null) {
            View view = this.t;
            if (view == null) {
                String strZ = wVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strZ), layoutParams.width, layoutParams.height, new AnonymousClass4(strZ));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    am.a(imageView);
                    am.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i = this.n;
                    if (i == 2 || i == 6) {
                        roundFrameLayout.setRadius(8);
                    } else {
                        roundFrameLayout.setRadius(12);
                    }
                    roundFrameLayout.addView(view);
                    viewGroup.addView(roundFrameLayout, iIndexOfChild, layoutParams2);
                    roundFrameLayout.setId(imageView.getId());
                    if (view instanceof ImageView) {
                        this.c = (ImageView) view;
                    }
                }
            }
            if (!g()) {
                this.c.setVisibility(8);
            }
        }
        if (this.f != null) {
            if (!TextUtils.isEmpty(wVar.y())) {
                this.f.setText(wVar.y());
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(wVar.x())) {
                this.e.setText(wVar.x());
            } else {
                this.e.setVisibility(8);
            }
        }
        CTAButtonLayout cTAButtonLayout = this.g;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(wVar, this.l, this.a, new AnonymousClass5());
            int i2 = this.n;
            if (i2 == 8 || i2 == 7) {
                this.g.changeMinorButtonStyle();
            }
        }
        new com.anythink.basead.ui.f.a(wVar, this.l).b(this);
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$4, reason: invalid class name */
    final class AnonymousClass4 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ String a;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass4(String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                PanelView.this.c.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.PanelView$5, reason: invalid class name */
    final class AnonymousClass5 implements com.anythink.basead.ui.f.b.a {
        AnonymousClass5() {
        }

        @Override // com.anythink.basead.ui.f.b.a
        public final void a(int i, int i2) {
            if (PanelView.this.i != null) {
                PanelView.this.i.a(i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public List<View> getClickViews() {
        return this.r;
    }

    public View getIconView() {
        View view = this.c;
        View view2 = this.t;
        if (view2 != null) {
            view = view2;
        }
        Object[] objArr = new Object[1];
        return view;
    }

    public View getCTAButton() {
        return this.g;
    }

    public View getShakeView() {
        return this.h;
    }

    private boolean g() {
        return h() || this.t != null;
    }

    public View getTitleView() {
        return this.e;
    }

    public View getDescView() {
        return this.f;
    }

    private boolean h() {
        w wVar = this.m;
        return (wVar == null || TextUtils.isEmpty(wVar.z())) ? false : true;
    }

    public void setBaseAdIconView(View view) {
        this.t = view;
    }

    private void a(ImageView imageView, View view) {
        ViewGroup viewGroup;
        int iIndexOfChild;
        if (imageView == null || view == null) {
            return;
        }
        imageView.setVisibility(0);
        view.setVisibility(0);
        ViewParent parent = imageView.getParent();
        if (!(parent instanceof ViewGroup) || (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) < 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        am.a(imageView);
        am.a(view);
        RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
        int i = this.n;
        if (i == 2 || i == 6) {
            roundFrameLayout.setRadius(8);
        } else {
            roundFrameLayout.setRadius(12);
        }
        roundFrameLayout.addView(view);
        viewGroup.addView(roundFrameLayout, iIndexOfChild, layoutParams);
        roundFrameLayout.setId(imageView.getId());
        if (view instanceof ImageView) {
            this.c = (ImageView) view;
        }
    }

    private void a(RoundFrameLayout roundFrameLayout) {
        int i = this.n;
        if (i == 2 || i == 6) {
            roundFrameLayout.setRadius(8);
        } else {
            roundFrameLayout.setRadius(12);
        }
    }

    public void notifyHalfScreenEndCardShow() {
        this.a = true;
        CTAButtonLayout cTAButtonLayout = this.g;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(this.m, this.l, true, new com.anythink.basead.ui.f.b.a() { // from class: com.anythink.basead.ui.PanelView.6
                @Override // com.anythink.basead.ui.f.b.a
                public final void a(int i, int i2) {
                    if (PanelView.this.i != null) {
                        PanelView.this.i.a(i, i2);
                    }
                }
            });
        }
    }

    private boolean a(int i) {
        return (i == 1 || i == 2 || i == 5 || i == 6 || i == 9) && !e.e(this.m, this.l);
    }

    private void b() {
        ViewGroup viewGroup;
        int iIndexOfChild;
        BaseShakeView baseShakeView;
        this.r.clear();
        this.c = (ImageView) this.b.findViewById(q.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.e = (TextView) this.b.findViewById(q.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f = (TextView) this.b.findViewById(q.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.g = (CTAButtonLayout) this.b.findViewById(q.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.d = (ImageView) this.b.findViewById(q.a(getContext(), "myoffer_ad_logo", "id"));
        try {
            BaseShakeView baseShakeView2 = (BaseShakeView) this.b.findViewById(q.a(getContext(), "myoffer_shake_hint_text", "id"));
            this.h = baseShakeView2;
            baseShakeView2.setShakeSetting(this.l.o, this.m.K());
            this.h.startShakeIconAnimation();
        } catch (Throwable unused) {
        }
        if (this.q && (baseShakeView = this.h) != null && this.n != 8) {
            baseShakeView.setVisibility(0);
        }
        w wVar = this.m;
        ImageView imageView = this.c;
        if (imageView != null) {
            View view = this.t;
            if (view == null) {
                String strZ = wVar.z();
                if (!TextUtils.isEmpty(strZ)) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, strZ), layoutParams.width, layoutParams.height, new AnonymousClass4(strZ));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    am.a(imageView);
                    am.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i = this.n;
                    if (i == 2 || i == 6) {
                        roundFrameLayout.setRadius(8);
                    } else {
                        roundFrameLayout.setRadius(12);
                    }
                    roundFrameLayout.addView(view);
                    viewGroup.addView(roundFrameLayout, iIndexOfChild, layoutParams2);
                    roundFrameLayout.setId(imageView.getId());
                    if (view instanceof ImageView) {
                        this.c = (ImageView) view;
                    }
                }
            }
            if (!g()) {
                this.c.setVisibility(8);
            }
        }
        if (this.f != null) {
            if (!TextUtils.isEmpty(wVar.y())) {
                this.f.setText(wVar.y());
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(wVar.x())) {
                this.e.setText(wVar.x());
            } else {
                this.e.setVisibility(8);
            }
        }
        CTAButtonLayout cTAButtonLayout = this.g;
        if (cTAButtonLayout != null) {
            cTAButtonLayout.initSetting(wVar, this.l, this.a, new AnonymousClass5());
            int i2 = this.n;
            if (i2 == 8 || i2 == 7) {
                this.g.changeMinorButtonStyle();
            }
        }
        new com.anythink.basead.ui.f.a(wVar, this.l).b(this);
        if (this.c != null) {
            if (!this.m.c()) {
                this.c.setOnClickListener(this.u);
            }
            this.r.add(this.c);
        }
        if (this.e != null) {
            if (!this.m.c()) {
                this.e.setOnClickListener(this.u);
            }
            this.r.add(this.e);
        }
        if (this.f != null) {
            if (!this.m.c()) {
                this.f.setOnClickListener(this.u);
            }
            this.r.add(this.f);
        }
        if (this.g != null) {
            if (!this.m.c()) {
                this.g.setOnClickListener(this.u);
            }
            this.r.add(this.g);
        }
        if (this.d != null) {
            if (!this.m.c()) {
                this.d.setOnClickListener(this.u);
            }
            this.r.add(this.d);
        }
        if (this.h != null && this.q && !this.m.c()) {
            this.h.setOnClickListener(this.u);
            this.h.setOnShakeListener(new AnonymousClass3(), this.k);
        }
        View viewFindViewById = this.b.findViewById(q.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            if (!this.m.c()) {
                viewFindViewById.setOnClickListener(this.u);
            }
            this.r.add(viewFindViewById);
        } else {
            if (!this.m.c()) {
                this.b.setOnClickListener(this.u);
            }
            this.r.add(this.b);
        }
        ImageView imageView2 = this.c;
        if (imageView2 instanceof RoundImageView) {
            ((RoundImageView) imageView2).setNeedRadiu(true);
            int i3 = this.n;
            if (i3 == 2 || i3 == 6) {
                ((RoundImageView) this.c).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.c).setRadiusInDip(12);
            }
            this.c.invalidate();
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.a(this.n).a(new AnonymousClass2()).a(getContext(), this.b);
        }
    }
}
