package com.anythink.basead.ui.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.BaseSdkSplashATView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final int a = -100;
    public static final int b = -101;
    public static final int c = -102;
    private final w<?> d;
    private final y e;
    private int f;
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;
    private View n;
    private com.anythink.basead.ui.d.a o;

    public d(w<?> wVar, y yVar) {
        this.d = wVar;
        this.e = yVar;
    }

    public final d a(int i) {
        this.f = i;
        return this;
    }

    public final d a(com.anythink.basead.ui.d.a aVar) {
        this.o = aVar;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0341  */
    /* JADX WARN: Code duplicated, block: B:104:0x0347  */
    /* JADX WARN: Code duplicated, block: B:106:0x0362  */
    /* JADX WARN: Code duplicated, block: B:107:0x036a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0373  */
    /* JADX WARN: Code duplicated, block: B:112:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:114:0x03b0  */
    public final void a(Context context, View view) {
        y yVar;
        View view2;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        this.g = view;
        if (view == null || this.d == null || (yVar = this.e) == null || !yVar.ap()) {
            return;
        }
        if ((TextUtils.equals(String.valueOf(this.e.D()), "4") || TextUtils.equals(String.valueOf(this.e.D()), "3") || TextUtils.equals(String.valueOf(this.e.D()), "1")) && this.e.aN() != 1) {
            return;
        }
        View viewFindViewById = this.g.findViewById(q.a(context, "myoffer_include_invalid_button_full_screen", "id"));
        this.l = viewFindViewById;
        if (viewFindViewById == null) {
            this.l = this.g.findViewById(q.a(context, "myoffer_fl_invalid_btn", "id"));
        }
        this.h = this.g.findViewById(q.a(context, "myoffer_splash_ad_bottom_container", "id"));
        this.k = this.g.findViewById(q.a(context, "myoffer_ll_top_content", "id"));
        this.i = this.g.findViewById(q.a(context, "myoffer_panel_cta_layout", "id"));
        this.j = this.g.findViewById(q.a(context, "myoffer_shake_hint_text", "id"));
        this.n = this.g.findViewById(q.a(context, "myoffer_ll_title_desc_container", "id"));
        View view3 = this.l;
        if (view3 != null) {
            this.m = view3.findViewById(q.a(context, "myoffer_invalid_btn", "id"));
        }
        if (this.l == null) {
            return;
        }
        if (!TextUtils.equals(String.valueOf(this.e.D()), "4")) {
            int i = this.f;
            if (i != -101) {
                switch (i) {
                    case 1:
                    case 5:
                        this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
                        if (!TextUtils.isEmpty(this.d.z())) {
                            a(context, this.i, 84.0f);
                            a(context, this.j, 138.0f);
                        }
                        z = false;
                        break;
                    case 2:
                    case 6:
                        this.l.setPadding(0, q.a(context, 10.0f), 0, 0);
                        if (!TextUtils.isEmpty(this.d.z())) {
                            a(context, this.k, 144.0f);
                            a(context, this.i, 54.0f);
                            a(context, this.j, 108.0f);
                        }
                        z = false;
                        break;
                    case 3:
                    case 4:
                    case 7:
                        if (m.g(context)) {
                            View view4 = this.m;
                            if (view4 != null && view4.getLayoutParams() != null) {
                                ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
                                layoutParams2.width = q.a(context, 80.0f);
                                layoutParams2.height = q.a(context, 48.0f);
                                this.m.setLayoutParams(layoutParams2);
                                this.m.setPadding(q.a(context, 34.0f), q.a(context, 14.0f), q.a(context, 34.0f), q.a(context, 14.0f));
                                this.m.setBackgroundResource(q.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                            }
                            z = true;
                        } else {
                            this.l.setPadding(0, q.a(context, 10.0f), 0, 0);
                            z = false;
                        }
                        break;
                    case 8:
                        if (!m.g(context)) {
                            this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
                            a(context, this.i, 100.0f);
                            a(context, this.j, 152.0f);
                            if (this.f == -101) {
                                a(context, this.l, 35.0f);
                            }
                        } else {
                            this.l.setPadding(0, 0, 0, 0);
                            view2 = this.m;
                            if (view2 != null) {
                                ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                                layoutParams3.height = q.a(context, 48.0f);
                                this.m.setLayoutParams(layoutParams3);
                                this.m.setPadding(q.a(context, 34.0f), q.a(context, 14.0f), q.a(context, 34.0f), q.a(context, 14.0f));
                                this.m.setBackgroundResource(q.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                            }
                            if (this.f == -101) {
                                layoutParams = this.l.getLayoutParams();
                                layoutParams.width = -2;
                                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
                                    layoutParams4.addRule(11);
                                    layoutParams4.rightMargin = q.a(context, 20.0f);
                                    layoutParams4.bottomMargin = q.a(context, 30.0f);
                                }
                                this.l.setLayoutParams(layoutParams);
                            }
                        }
                        z = false;
                        break;
                    default:
                        if (!m.g(context)) {
                            this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
                            View view5 = this.h;
                            if (view5 != null) {
                                view5.setPadding(0, 0, 0, 0);
                            }
                            b(context, this.k, 14.0f);
                            b(context, this.i, 92.0f);
                            if (this.f == -100) {
                                a(context, this.l, 44.0f);
                            }
                        } else {
                            this.l.setPadding(0, 0, 0, 0);
                            View view6 = this.m;
                            if (view6 != null) {
                                ViewGroup.LayoutParams layoutParams5 = view6.getLayoutParams();
                                layoutParams5.height = q.a(context, 48.0f);
                                this.m.setLayoutParams(layoutParams5);
                                this.m.setPadding(q.a(context, 34.0f), q.a(context, 14.0f), q.a(context, 34.0f), q.a(context, 14.0f));
                                this.m.setBackgroundResource(q.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                            }
                            View view7 = this.n;
                            if (view7 != null && view7.getLayoutParams() != null) {
                                ViewGroup.LayoutParams layoutParams6 = this.n.getLayoutParams();
                                if (layoutParams6 instanceof RelativeLayout.LayoutParams) {
                                    RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams6;
                                    layoutParams7.addRule(0, q.a(context, "myoffer_fl_invalid_btn", "id"));
                                    this.n.setLayoutParams(layoutParams7);
                                }
                            }
                            if (this.f == -100) {
                                ViewGroup.LayoutParams layoutParams8 = this.l.getLayoutParams();
                                layoutParams8.width = -2;
                                if (layoutParams8 instanceof RelativeLayout.LayoutParams) {
                                    RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) layoutParams8;
                                    layoutParams9.addRule(11);
                                    layoutParams9.rightMargin = q.a(context, 20.0f);
                                    layoutParams9.bottomMargin = q.a(context, 30.0f);
                                }
                                this.l.setLayoutParams(layoutParams8);
                            }
                        }
                        z = false;
                        break;
                }
            } else {
                if (!m.g(context)) {
                    this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
                    a(context, this.i, 100.0f);
                    a(context, this.j, 152.0f);
                    if (this.f == -101) {
                        a(context, this.l, 35.0f);
                    }
                } else {
                    this.l.setPadding(0, 0, 0, 0);
                    view2 = this.m;
                    if (view2 != null) {
                        ViewGroup.LayoutParams layoutParams10 = view2.getLayoutParams();
                        layoutParams10.height = q.a(context, 48.0f);
                        this.m.setLayoutParams(layoutParams10);
                        this.m.setPadding(q.a(context, 34.0f), q.a(context, 14.0f), q.a(context, 34.0f), q.a(context, 14.0f));
                        this.m.setBackgroundResource(q.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                    }
                    if (this.f == -101) {
                        layoutParams = this.l.getLayoutParams();
                        layoutParams.width = -2;
                        if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) layoutParams;
                            layoutParams11.addRule(11);
                            layoutParams11.rightMargin = q.a(context, 20.0f);
                            layoutParams11.bottomMargin = q.a(context, 30.0f);
                        }
                        this.l.setLayoutParams(layoutParams);
                    }
                }
                z = false;
            }
            this.l.setVisibility(0);
            a(z);
            return;
        }
        if (this.i == null) {
            this.i = this.g.findViewById(q.a(context, "myoffer_splash_ad_cta_layout", "id"));
        }
        if (this.j == null) {
            this.j = this.g.findViewById(q.a(context, "myoffer_shake_view", "id"));
        }
        if (BaseSdkSplashATView.isSinglePicture(this.d, this.e)) {
            this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
            a(context, this.i, 100.0f);
            a(context, this.j, 100.0f);
        } else if (this.e.A() == 2) {
            this.l.setPadding(0, 0, 0, 0);
            View view8 = this.m;
            if (view8 != null && view8.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams12 = this.m.getLayoutParams();
                layoutParams12.height = q.a(context, 46.0f);
                this.m.setLayoutParams(layoutParams12);
                this.m.setPadding(q.a(context, 31.0f), q.a(context, 13.0f), q.a(context, 33.0f), q.a(context, 13.0f));
                this.m.setBackgroundResource(q.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
            }
            View view9 = this.n;
            if (view9 != null && view9.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams13 = this.n.getLayoutParams();
                if (layoutParams13 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) layoutParams13;
                    layoutParams14.addRule(0, q.a(context, "myoffer_fl_invalid_btn", "id"));
                    layoutParams14.rightMargin = q.a(context, 10.0f);
                    this.n.setLayoutParams(layoutParams14);
                }
                this.n.setPadding(0, 0, 0, 0);
            }
        } else {
            this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
            View view10 = this.h;
            if (view10 != null) {
                view10.setPadding(0, q.a(context, 25.0f), 0, 0);
            }
        }
        this.l.setVisibility(0);
        a(false);
    }

    private void a(Context context) {
        if (this.i == null) {
            this.i = this.g.findViewById(q.a(context, "myoffer_splash_ad_cta_layout", "id"));
        }
        if (this.j == null) {
            this.j = this.g.findViewById(q.a(context, "myoffer_shake_view", "id"));
        }
        if (BaseSdkSplashATView.isSinglePicture(this.d, this.e)) {
            this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
            a(context, this.i, 100.0f);
            a(context, this.j, 100.0f);
        } else if (this.e.A() == 2) {
            this.l.setPadding(0, 0, 0, 0);
            View view = this.m;
            if (view != null && view.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                layoutParams.height = q.a(context, 46.0f);
                this.m.setLayoutParams(layoutParams);
                this.m.setPadding(q.a(context, 31.0f), q.a(context, 13.0f), q.a(context, 33.0f), q.a(context, 13.0f));
                this.m.setBackgroundResource(q.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
            }
            View view2 = this.n;
            if (view2 != null && view2.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.addRule(0, q.a(context, "myoffer_fl_invalid_btn", "id"));
                    layoutParams3.rightMargin = q.a(context, 10.0f);
                    this.n.setLayoutParams(layoutParams3);
                }
                this.n.setPadding(0, 0, 0, 0);
            }
        } else {
            this.l.setPadding(0, q.a(context, 26.0f), 0, 0);
            View view3 = this.h;
            if (view3 != null) {
                view3.setPadding(0, q.a(context, 25.0f), 0, 0);
            }
        }
        this.l.setVisibility(0);
        a(false);
    }

    private void b(Context context) {
        View viewFindViewById = this.g.findViewById(q.a(context, "myoffer_include_invalid_button_full_screen", "id"));
        this.l = viewFindViewById;
        if (viewFindViewById == null) {
            this.l = this.g.findViewById(q.a(context, "myoffer_fl_invalid_btn", "id"));
        }
        this.h = this.g.findViewById(q.a(context, "myoffer_splash_ad_bottom_container", "id"));
        this.k = this.g.findViewById(q.a(context, "myoffer_ll_top_content", "id"));
        this.i = this.g.findViewById(q.a(context, "myoffer_panel_cta_layout", "id"));
        this.j = this.g.findViewById(q.a(context, "myoffer_shake_hint_text", "id"));
        this.n = this.g.findViewById(q.a(context, "myoffer_ll_title_desc_container", "id"));
        View view = this.l;
        if (view != null) {
            this.m = view.findViewById(q.a(context, "myoffer_invalid_btn", "id"));
        }
    }

    private void a(boolean z) {
        View view;
        if (z && (view = this.m) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.d.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (d.this.o != null) {
                        d.this.o.a(10, 14);
                    }
                }
            });
            return;
        }
        View view2 = this.l;
        if (view2 == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.f.d.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                if (d.this.o != null) {
                    d.this.o.a(10, 14);
                }
            }
        });
    }

    private static void a(Context context, View view, float f) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = q.a(context, f);
                return;
            }
            return;
        }
        ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = q.a(context, f);
    }

    private static void b(Context context, View view, float f) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = q.a(context, f);
                return;
            }
            return;
        }
        ((RelativeLayout.LayoutParams) layoutParams).topMargin = q.a(context, f);
    }

    private static int a(Context context, float f) {
        return q.a(context, f);
    }

    public final void a() {
        t.b().b(new Runnable() { // from class: com.anythink.basead.ui.f.d.3
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.l != null) {
                    d.this.l.setVisibility(8);
                }
            }
        });
    }

    public final void b() {
        t.b().b(new Runnable() { // from class: com.anythink.basead.ui.f.d.4
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.l != null) {
                    d.this.l.setVisibility(0);
                }
            }
        });
    }
}
