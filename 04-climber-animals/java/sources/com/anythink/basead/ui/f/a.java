package com.anythink.basead.ui.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.basead.ui.RoundCornerRelativeLayout;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    View a;
    ImageView b;
    TextView c;
    TextView d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    RoundCornerRelativeLayout i;
    ImageView j;
    private final w<?> k;
    private final x l;
    private y m;
    private FrameLayout n;
    private View o;

    public a(w<?> wVar, x xVar) {
        this.k = wVar;
        this.l = xVar;
        if (wVar != null) {
            this.m = xVar.o;
        }
    }

    public final void a(View view) {
        this.o = view;
    }

    public final void b(View view) {
        boolean z;
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        Context context2 = view.getContext();
        this.n = (FrameLayout) view.findViewById(q.a(context2, "myoffer_ad_logo_container", "id"));
        this.b = (ImageView) view.findViewById(q.a(context2, "myoffer_ad_logo", "id"));
        this.i = (RoundCornerRelativeLayout) view.findViewById(q.a(context2, "myoffer_banner_ad_logo_container", "id"));
        this.j = (ImageView) view.findViewById(q.a(context2, "myoffer_banner_self_ad_logo_label", "id"));
        if (this.b == null) {
            this.b = (ImageView) view.findViewById(q.a(context2, "myoffer_banner_self_ad_logo", "id"));
        }
        View view2 = this.o;
        if (this.n == null || view2 == null || view2.getVisibility() != 0) {
            z = false;
        } else {
            if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.n.removeAllViews();
            this.n.addView(view2);
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(view2));
            z = true;
        }
        if (!z) {
            ImageView imageView = this.b;
            if (imageView != null) {
                imageView.setVisibility(0);
                this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
                this.b.setOnClickListener(new AnonymousClass8());
                this.b.setImageResource(q.a(context2, "myoffer_ad_logo_default", "drawable"));
                if (!TextUtils.isEmpty(this.k.C())) {
                    int iA = q.a(context2, 100.0f);
                    com.anythink.core.common.res.b.a(context2).a(new com.anythink.core.common.res.e(3, this.k.C()), iA, iA, new AnonymousClass9());
                } else if (this.k.S() != null) {
                    Bitmap bitmapS = this.k.S();
                    float width = (bitmapS.getWidth() * 1.0f) / bitmapS.getHeight();
                    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                    int i = layoutParams.height;
                    layoutParams.width = (int) (i * width);
                    layoutParams.height = i;
                    this.b.setLayoutParams(layoutParams);
                    this.b.setScaleType(ImageView.ScaleType.FIT_XY);
                    this.b.setImageBitmap(bitmapS);
                    this.b.setImageBitmap(this.k.S());
                    this.b.setVisibility(0);
                } else if (this.k.c()) {
                    this.b.setVisibility(4);
                }
            }
            if (this.i != null) {
                w<?> wVar = this.k;
                if (wVar != null && !TextUtils.isEmpty(wVar.ak()) && this.j != null) {
                    this.i.setRadius(2);
                    this.j.setVisibility(0);
                    this.b.setClickable(false);
                    this.i.setOnClickListener(new AnonymousClass10(context2));
                } else {
                    this.i.setRadius(0);
                }
            }
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(q.a(context, "myoffer_four_element_container", "id"));
        this.a = viewGroup;
        if (viewGroup == null) {
            return;
        }
        this.c = (TextView) viewGroup.findViewById(q.a(context, "myoffer_publisher_name", "id"));
        this.e = (TextView) this.a.findViewById(q.a(context, "myoffer_privacy_agreement", "id"));
        this.f = (TextView) this.a.findViewById(q.a(context, "myoffer_permission_manage", "id"));
        this.d = (TextView) this.a.findViewById(q.a(context, "myoffer_version_name", "id"));
        this.g = (TextView) this.a.findViewById(q.a(context, "myoffer_function_manage", "id"));
        this.h = (TextView) this.a.findViewById(q.a(context, "myoffer_disclaimer", "id"));
        View viewFindViewById = view.findViewById(q.a(context, "myoffer_four_element_container_bg", "id"));
        View viewFindViewById2 = this.a.findViewById(q.a(context, "myoffer_center_line1", "id"));
        if (viewFindViewById2 == null) {
            viewFindViewById2 = this.a.findViewById(q.a(context, "myoffer_banner_center_line", "id"));
        }
        View viewFindViewById3 = this.a.findViewById(q.a(context, "myoffer_center_line2", "id"));
        if (viewFindViewById3 == null) {
            viewFindViewById3 = this.a.findViewById(q.a(context, "myoffer_banner_center_line2", "id"));
        }
        View viewFindViewById4 = this.a.findViewById(q.a(context, "myoffer_center_line3", "id"));
        if (this.k.T()) {
            this.a.setVisibility(0);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(0);
                this.c.setText(this.k.M());
                this.c.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.a.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                    }
                });
            }
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.d.setText(context.getResources().getString(q.a(context, "myoffer_panel_version", "string"), this.k.N()));
                this.d.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.a.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                    }
                });
            }
            if (this.e != null) {
                if (!TextUtils.isEmpty(this.k.O())) {
                    this.e.setVisibility(0);
                    this.e.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.a.4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            com.anythink.core.common.v.y.a(t.b().g(), a.this.k.O());
                        }
                    });
                } else {
                    this.e.setVisibility(8);
                }
            }
            if (this.f != null) {
                if (!TextUtils.isEmpty(this.k.P())) {
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(0);
                    }
                    this.f.setVisibility(0);
                    this.f.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.a.5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            com.anythink.core.common.v.y.a(t.b().g(), a.this.k.P());
                        }
                    });
                } else {
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(8);
                    }
                    this.f.setVisibility(8);
                }
            }
            if (this.g != null) {
                if (!TextUtils.isEmpty(this.k.h())) {
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setVisibility(0);
                    }
                    this.g.setVisibility(0);
                    this.g.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.a.6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            com.anythink.core.common.v.y.a(t.b().g(), a.this.k.h());
                        }
                    });
                } else {
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setVisibility(8);
                    }
                    this.g.setVisibility(8);
                }
            }
        } else {
            if (this.a != null && !TextUtils.equals(String.valueOf(this.m.D()), "2")) {
                this.a.setVisibility(8);
            }
            TextView textView3 = this.d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.c;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.e;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.f;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            TextView textView7 = this.g;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(8);
            }
            if (viewFindViewById != null) {
                try {
                    viewFindViewById.setBackground(null);
                } catch (Throwable unused) {
                }
            }
        }
        if (this.h != null) {
            View view3 = this.a;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.h.setVisibility(0);
            if (viewFindViewById4 != null && this.k.T()) {
                viewFindViewById4.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.l.o.aS())) {
                return;
            }
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.a.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    com.anythink.core.common.v.y.a(t.b().g(), a.this.l.o.aS());
                }
            });
        }
    }

    private void c(View view) {
        boolean z;
        Context context = view.getContext();
        this.n = (FrameLayout) view.findViewById(q.a(context, "myoffer_ad_logo_container", "id"));
        this.b = (ImageView) view.findViewById(q.a(context, "myoffer_ad_logo", "id"));
        this.i = (RoundCornerRelativeLayout) view.findViewById(q.a(context, "myoffer_banner_ad_logo_container", "id"));
        this.j = (ImageView) view.findViewById(q.a(context, "myoffer_banner_self_ad_logo_label", "id"));
        if (this.b == null) {
            this.b = (ImageView) view.findViewById(q.a(context, "myoffer_banner_self_ad_logo", "id"));
        }
        View view2 = this.o;
        if (this.n == null || view2 == null || view2.getVisibility() != 0) {
            z = false;
        } else {
            if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            this.n.removeAllViews();
            this.n.addView(view2);
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(view2));
            z = true;
        }
        if (z) {
            return;
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.b.setOnClickListener(new AnonymousClass8());
            this.b.setImageResource(q.a(context, "myoffer_ad_logo_default", "drawable"));
            if (!TextUtils.isEmpty(this.k.C())) {
                int iA = q.a(context, 100.0f);
                com.anythink.core.common.res.b.a(context).a(new com.anythink.core.common.res.e(3, this.k.C()), iA, iA, new AnonymousClass9());
            } else if (this.k.S() != null) {
                Bitmap bitmapS = this.k.S();
                float width = (bitmapS.getWidth() * 1.0f) / bitmapS.getHeight();
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                int i = layoutParams.height;
                layoutParams.width = (int) (i * width);
                layoutParams.height = i;
                this.b.setLayoutParams(layoutParams);
                this.b.setScaleType(ImageView.ScaleType.FIT_XY);
                this.b.setImageBitmap(bitmapS);
                this.b.setImageBitmap(this.k.S());
                this.b.setVisibility(0);
            } else if (this.k.c()) {
                this.b.setVisibility(4);
            }
        }
        if (this.i != null) {
            w<?> wVar = this.k;
            if (wVar != null && !TextUtils.isEmpty(wVar.ak()) && this.j != null) {
                this.i.setRadius(2);
                this.j.setVisibility(0);
                this.b.setClickable(false);
                this.i.setOnClickListener(new AnonymousClass10(context));
                return;
            }
            this.i.setRadius(0);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.f.a$8, reason: invalid class name */
    final class AnonymousClass8 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }

        AnonymousClass8() {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.f.a$9, reason: invalid class name */
    final class AnonymousClass9 implements com.anythink.core.common.res.b.a {
        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass9() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(str, a.this.k.C())) {
                a.this.b.setScaleType(ImageView.ScaleType.FIT_XY);
                a.this.b.setImageBitmap(bitmap);
                a.this.b.setVisibility(0);
                a.this.b.post(new Runnable() { // from class: com.anythink.basead.ui.f.a.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.l != null && a.this.k.c() && a.this.l.f == 28) {
                            a.this.b.setBackgroundColor(Color.parseColor("#66999999"));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.f.a$10, reason: invalid class name */
    final class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ Context a;

        AnonymousClass10(Context context) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            new com.anythink.basead.e().a(this.a, a.this.k, a.this.l, new com.anythink.basead.e.a() { // from class: com.anythink.basead.ui.f.a.10.1
                @Override // com.anythink.basead.e.a
                public final void a() {
                }

                @Override // com.anythink.basead.e.a
                public final void b() {
                }
            });
        }
    }

    private boolean d(View view) {
        if (this.n == null || view == null || view.getVisibility() != 0) {
            return false;
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.n.removeAllViews();
        this.n.addView(view);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(view));
        return true;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.f.a$2, reason: invalid class name */
    final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;

        AnonymousClass2(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int height = this.a.getHeight();
            int width = this.a.getWidth();
            int iA = q.a(this.a.getContext(), 8.0f);
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = iA;
            if (width <= 0 || height <= 0) {
                layoutParams.width = iA;
            } else {
                layoutParams.width = (iA * width) / height;
            }
            this.a.setLayoutParams(layoutParams);
        }
    }

    public final void a() {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void a(BaseAd baseAd, com.anythink.core.basead.b.b bVar) {
        a(baseAd, bVar, false);
    }

    public final void a(BaseAd baseAd, com.anythink.core.basead.b.b bVar, boolean z) {
        x xVar = this.l;
        if (xVar == null || baseAd == null || bVar == null || this.a == null || xVar.f != 34) {
            return;
        }
        String domain = baseAd.getDomain();
        String warning = baseAd.getWarning();
        String adFrom = baseAd.getAdFrom();
        if (TextUtils.isEmpty(domain) && TextUtils.isEmpty(warning) && TextUtils.isEmpty(adFrom)) {
            return;
        }
        this.a.setVisibility(0);
        if (z && this.d != null && !TextUtils.isEmpty(adFrom)) {
            a(this.d, adFrom);
            bVar.f(this.d);
        }
        if (this.f != null && !TextUtils.isEmpty(domain)) {
            a(this.f, domain);
            bVar.g(this.f);
        }
        if (this.g == null || TextUtils.isEmpty(warning)) {
            return;
        }
        a(this.g, warning);
        bVar.h(this.g);
    }

    private static void a(TextView textView, String str) {
        if (textView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
    }
}
