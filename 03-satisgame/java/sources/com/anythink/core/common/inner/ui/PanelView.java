package com.anythink.core.common.inner.ui;

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
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.inner.mixad.f.b;
import com.anythink.core.common.inner.ui.component.RoundFrameLayout;
import com.anythink.core.common.inner.ui.e.c;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;
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
    private ScanningAnimButton g;
    private a h;
    private int i;
    private y j;
    private x k;
    private w l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private List<View> q;
    private View r;
    private final View.OnClickListener s;

    public interface a {
        void a();

        boolean b();
    }

    private static boolean a(int i) {
        return i == 1 || i == 2 || i == 5 || i == 6 || i == 9;
    }

    private static void d() {
    }

    public PanelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = false;
        this.a = false;
        this.s = new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.PanelView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (PanelView.this.j != null) {
                    if (PanelView.this.j.q() == 1) {
                        if (view != PanelView.this.g || PanelView.this.h == null) {
                            return;
                        }
                        a unused = PanelView.this.h;
                        int i = b.g;
                        int i2 = b.e;
                        return;
                    }
                    if (PanelView.this.h != null) {
                        if (view == PanelView.this.g) {
                            a unused2 = PanelView.this.h;
                            int i3 = b.g;
                            int i4 = b.e;
                        } else {
                            a unused3 = PanelView.this.h;
                            int i5 = b.g;
                            int i6 = b.a;
                        }
                    }
                }
            }
        };
    }

    public void init(w wVar, x xVar, int i, boolean z, a aVar) {
        this.h = aVar;
        this.i = i;
        this.l = wVar;
        this.k = xVar;
        this.j = xVar.t;
        this.p = z;
        this.n = wVar.C();
        this.o = this.j.j() == 1;
        this.q = new ArrayList();
    }

    private boolean a() {
        return this.n && !this.o;
    }

    private void c() {
        ImageView imageView = this.c;
        if (imageView instanceof RoundImageView) {
            ((RoundImageView) imageView).setNeedRadiu(true);
            int i = this.m;
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
        this.m = i;
        switch (i) {
            case 1:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_endcard_horizontal_portrait", "layout"), (ViewGroup) this, true);
                }
                break;
            case 2:
            case 6:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_endcard_landscape_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_endcard_landscape", "layout"), (ViewGroup) this, true);
                }
                break;
            case 3:
                if (this.i == 1) {
                    if (!g()) {
                        this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                    } else {
                        this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                    }
                } else if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_vertical_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_vertical", "layout"), (ViewGroup) this, true);
                }
                break;
            case 4:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_horizontal_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_horizontal", "layout"), (ViewGroup) this, true);
                }
                break;
            case 5:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_endcard_portrait_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_endcard_vertical_portrait", "layout"), (ViewGroup) this, true);
                }
                break;
            case 7:
                this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 8:
                this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_full_screen_empty_info", "layout"), (ViewGroup) this, true);
                break;
            case 9:
                this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_letter", "layout"), (ViewGroup) this, true);
                break;
            default:
                if (!g()) {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_bottom_banner_without_icon", "layout"), (ViewGroup) this, true);
                } else {
                    this.b = LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_panel_view_bottom_banner", "layout"), (ViewGroup) this, true);
                }
                break;
        }
        this.a = i == 1 || i == 2 || i == 5 || i == 6 || i == 9;
        this.q.clear();
        this.c = (ImageView) this.b.findViewById(p.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.e = (TextView) this.b.findViewById(p.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f = (TextView) this.b.findViewById(p.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.g = (ScanningAnimButton) this.b.findViewById(p.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.d = (ImageView) this.b.findViewById(p.a(getContext(), "myoffer_ad_logo", "id"));
        w wVar = this.l;
        ImageView imageView = this.c;
        if (imageView != null) {
            View view = this.r;
            if (view == null) {
                String strL = wVar.l();
                if (!TextUtils.isEmpty(strL)) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, strL), layoutParams.width, layoutParams.height, new AnonymousClass2(strL));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    al.a(imageView);
                    al.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i2 = this.m;
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
            if (!TextUtils.isEmpty(wVar.k())) {
                this.f.setText(wVar.k());
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(wVar.j())) {
                this.e.setText(wVar.j());
            } else {
                this.e.setVisibility(8);
            }
        }
        if (this.g != null) {
            if (!TextUtils.isEmpty(wVar.o())) {
                this.g.setText(wVar.o());
            } else {
                this.g.setText(c.a(getContext(), wVar));
            }
            this.g.setOnClickListener(new AnonymousClass3());
            this.g.startAnimation(this.k.t.D());
        }
        new com.anythink.core.common.inner.ui.e.a(wVar, this.k).b(this);
        if (this.c != null) {
            if (!this.l.D()) {
                this.c.setOnClickListener(this.s);
            }
            this.q.add(this.c);
        }
        if (this.e != null) {
            if (!this.l.D()) {
                this.e.setOnClickListener(this.s);
            }
            this.q.add(this.e);
        }
        if (this.f != null) {
            if (!this.l.D()) {
                this.f.setOnClickListener(this.s);
            }
            this.q.add(this.f);
        }
        if (this.g != null) {
            if (!this.l.D()) {
                this.g.setOnClickListener(this.s);
            }
            this.q.add(this.g);
        }
        if (this.d != null) {
            if (!this.l.D()) {
                this.d.setOnClickListener(this.s);
            }
            this.q.add(this.d);
        }
        View viewFindViewById = this.b.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            if (!this.l.D()) {
                viewFindViewById.setOnClickListener(this.s);
            }
            this.q.add(viewFindViewById);
        } else {
            if (!this.l.D()) {
                this.b.setOnClickListener(this.s);
            }
            this.q.add(this.b);
        }
        ImageView imageView2 = this.c;
        if (imageView2 instanceof RoundImageView) {
            ((RoundImageView) imageView2).setNeedRadiu(true);
            int i3 = this.m;
            if (i3 == 2 || i3 == 6) {
                ((RoundImageView) this.c).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.c).setRadiusInDip(12);
            }
            this.c.invalidate();
        }
    }

    private void e() {
        this.q.clear();
        this.c = (ImageView) this.b.findViewById(p.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.e = (TextView) this.b.findViewById(p.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f = (TextView) this.b.findViewById(p.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.g = (ScanningAnimButton) this.b.findViewById(p.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.d = (ImageView) this.b.findViewById(p.a(getContext(), "myoffer_ad_logo", "id"));
    }

    private void f() {
        if (this.c != null) {
            if (!this.l.D()) {
                this.c.setOnClickListener(this.s);
            }
            this.q.add(this.c);
        }
        if (this.e != null) {
            if (!this.l.D()) {
                this.e.setOnClickListener(this.s);
            }
            this.q.add(this.e);
        }
        if (this.f != null) {
            if (!this.l.D()) {
                this.f.setOnClickListener(this.s);
            }
            this.q.add(this.f);
        }
        if (this.g != null) {
            if (!this.l.D()) {
                this.g.setOnClickListener(this.s);
            }
            this.q.add(this.g);
        }
        if (this.d != null) {
            if (!this.l.D()) {
                this.d.setOnClickListener(this.s);
            }
            this.q.add(this.d);
        }
        View viewFindViewById = this.b.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            if (!this.l.D()) {
                viewFindViewById.setOnClickListener(this.s);
            }
            this.q.add(viewFindViewById);
        } else {
            if (!this.l.D()) {
                this.b.setOnClickListener(this.s);
            }
            this.q.add(this.b);
        }
    }

    private void a(w wVar) {
        ViewGroup viewGroup;
        int iIndexOfChild;
        ImageView imageView = this.c;
        if (imageView != null) {
            View view = this.r;
            if (view == null) {
                String strL = wVar.l();
                if (!TextUtils.isEmpty(strL)) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, strL), layoutParams.width, layoutParams.height, new AnonymousClass2(strL));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    al.a(imageView);
                    al.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i = this.m;
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
            if (!TextUtils.isEmpty(wVar.k())) {
                this.f.setText(wVar.k());
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(wVar.j())) {
                this.e.setText(wVar.j());
            } else {
                this.e.setVisibility(8);
            }
        }
        if (this.g != null) {
            if (!TextUtils.isEmpty(wVar.o())) {
                this.g.setText(wVar.o());
            } else {
                this.g.setText(c.a(getContext(), wVar));
            }
            this.g.setOnClickListener(new AnonymousClass3());
            this.g.startAnimation(this.k.t.D());
        }
        new com.anythink.core.common.inner.ui.e.a(wVar, this.k).b(this);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.PanelView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ String a;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass2(String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, this.a)) {
                PanelView.this.c.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.PanelView$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (PanelView.this.h != null) {
                a unused = PanelView.this.h;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public List<View> getClickViews() {
        return this.q;
    }

    public View getIconView() {
        ImageView imageView = this.c;
        View view = this.r;
        return view != null ? view : imageView;
    }

    public View getCTAButton() {
        return this.g;
    }

    private boolean g() {
        return h() || this.r != null;
    }

    public View getTitleView() {
        return this.e;
    }

    public View getDescView() {
        return this.f;
    }

    private boolean h() {
        w wVar = this.l;
        return (wVar == null || TextUtils.isEmpty(wVar.l())) ? false : true;
    }

    public void setBaseAdIconView(View view) {
        this.r = view;
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
        al.a(imageView);
        al.a(view);
        RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
        int i = this.m;
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
        int i = this.m;
        if (i == 2 || i == 6) {
            roundFrameLayout.setRadius(8);
        } else {
            roundFrameLayout.setRadius(12);
        }
    }

    private void b() {
        ViewGroup viewGroup;
        int iIndexOfChild;
        this.q.clear();
        this.c = (ImageView) this.b.findViewById(p.a(getContext(), "myoffer_iv_banner_icon", "id"));
        this.e = (TextView) this.b.findViewById(p.a(getContext(), "myoffer_tv_banner_title", "id"));
        this.f = (TextView) this.b.findViewById(p.a(getContext(), "myoffer_tv_banner_desc", "id"));
        this.g = (ScanningAnimButton) this.b.findViewById(p.a(getContext(), "myoffer_panel_cta_layout", "id"));
        this.d = (ImageView) this.b.findViewById(p.a(getContext(), "myoffer_ad_logo", "id"));
        w wVar = this.l;
        ImageView imageView = this.c;
        if (imageView != null) {
            View view = this.r;
            if (view == null) {
                String strL = wVar.l();
                if (!TextUtils.isEmpty(strL)) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, strL), layoutParams.width, layoutParams.height, new AnonymousClass2(strL));
                }
            } else if (imageView != null && view != null) {
                imageView.setVisibility(0);
                view.setVisibility(0);
                ViewParent parent = imageView.getParent();
                if ((parent instanceof ViewGroup) && (iIndexOfChild = (viewGroup = (ViewGroup) parent).indexOfChild(imageView)) >= 0) {
                    ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                    al.a(imageView);
                    al.a(view);
                    RoundFrameLayout roundFrameLayout = new RoundFrameLayout(getContext());
                    int i = this.m;
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
            if (!TextUtils.isEmpty(wVar.k())) {
                this.f.setText(wVar.k());
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.e != null) {
            if (!TextUtils.isEmpty(wVar.j())) {
                this.e.setText(wVar.j());
            } else {
                this.e.setVisibility(8);
            }
        }
        if (this.g != null) {
            if (!TextUtils.isEmpty(wVar.o())) {
                this.g.setText(wVar.o());
            } else {
                this.g.setText(c.a(getContext(), wVar));
            }
            this.g.setOnClickListener(new AnonymousClass3());
            this.g.startAnimation(this.k.t.D());
        }
        new com.anythink.core.common.inner.ui.e.a(wVar, this.k).b(this);
        if (this.c != null) {
            if (!this.l.D()) {
                this.c.setOnClickListener(this.s);
            }
            this.q.add(this.c);
        }
        if (this.e != null) {
            if (!this.l.D()) {
                this.e.setOnClickListener(this.s);
            }
            this.q.add(this.e);
        }
        if (this.f != null) {
            if (!this.l.D()) {
                this.f.setOnClickListener(this.s);
            }
            this.q.add(this.f);
        }
        if (this.g != null) {
            if (!this.l.D()) {
                this.g.setOnClickListener(this.s);
            }
            this.q.add(this.g);
        }
        if (this.d != null) {
            if (!this.l.D()) {
                this.d.setOnClickListener(this.s);
            }
            this.q.add(this.d);
        }
        View viewFindViewById = this.b.findViewById(p.a(getContext(), "myoffer_panel_view_blank", "id"));
        if (viewFindViewById != null) {
            if (!this.l.D()) {
                viewFindViewById.setOnClickListener(this.s);
            }
            this.q.add(viewFindViewById);
        } else {
            if (!this.l.D()) {
                this.b.setOnClickListener(this.s);
            }
            this.q.add(this.b);
        }
        ImageView imageView2 = this.c;
        if (imageView2 instanceof RoundImageView) {
            ((RoundImageView) imageView2).setNeedRadiu(true);
            int i2 = this.m;
            if (i2 == 2 || i2 == 6) {
                ((RoundImageView) this.c).setRadiusInDip(8);
            } else {
                ((RoundImageView) this.c).setRadiusInDip(12);
            }
            this.c.invalidate();
        }
    }
}
