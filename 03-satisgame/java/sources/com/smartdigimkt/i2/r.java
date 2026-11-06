package com.smartdigimkt.i2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView;
import com.smartdigimkt.z.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public final com.smartdigimkt.b3.c a;
    public final com.smartdigimkt.b3.e b;
    public int c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public com.smartdigimkt.e2.a l;

    public r(com.smartdigimkt.b3.c cVar, com.smartdigimkt.b3.e eVar) {
        this.a = cVar;
        this.b = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:116:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:118:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:121:0x042f  */
    /* JADX WARN: Code duplicated, block: B:123:0x043b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0462  */
    /* JADX WARN: Code duplicated, block: B:127:0x047d  */
    public final void a(Context context, View view) {
        View view2;
        ViewGroup.LayoutParams layoutParams;
        boolean z;
        View view3;
        this.d = view;
        if (view == null || this.a == null || !c0.a(this.b)) {
            return;
        }
        View viewFindViewById = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_include_invalid_button_full_screen", "id"));
        this.i = viewFindViewById;
        if (viewFindViewById == null) {
            this.i = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_fl_invalid_btn", "id"));
        }
        this.e = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_splash_ad_bottom_container", "id"));
        this.h = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_ll_top_content", "id"));
        this.f = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_panel_cta_layout", "id"));
        this.g = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_shake_hint_text", "id"));
        this.k = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_ll_title_desc_container", "id"));
        View view4 = this.i;
        if (view4 != null) {
            this.j = view4.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_invalid_btn", "id"));
        }
        if (this.i == null) {
            return;
        }
        if (TextUtils.equals(String.valueOf(this.b.a), "4")) {
            if (this.f == null) {
                this.f = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_splash_ad_cta_layout", "id"));
            }
            if (this.g == null) {
                this.g = this.d.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_shake_view", "id"));
            }
            if (BaseSdkSplashATView.isSinglePicture(this.a, this.b)) {
                this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 26.0f), 0, 0);
                a(context, this.f, 100.0f);
                a(context, this.g, 100.0f);
            } else if (this.b.m == 2) {
                this.i.setPadding(0, 0, 0, 0);
                View view5 = this.j;
                if (view5 != null && view5.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
                    layoutParams2.height = com.smartdigimkt.r4.k.a(context, 46.0f);
                    this.j.setLayoutParams(layoutParams2);
                    this.j.setPadding((int) ((context.getResources().getDisplayMetrics().density * 31.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 13.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 33.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 13.0f) + 0.5f));
                    this.j.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                }
                View view6 = this.k;
                if (view6 != null && view6.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams3 = this.k.getLayoutParams();
                    if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                        layoutParams4.addRule(0, com.smartdigimkt.r4.k.a(context, "myoffer_fl_invalid_btn", "id"));
                        layoutParams4.rightMargin = com.smartdigimkt.r4.k.a(context, 10.0f);
                        this.k.setLayoutParams(layoutParams4);
                    }
                    this.k.setPadding(0, 0, 0, 0);
                }
            } else {
                this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 26.0f), 0, 0);
                View view7 = this.e;
                if (view7 != null) {
                    view7.setPadding(0, (int) ((context.getResources().getDisplayMetrics().density * 25.0f) + 0.5f), 0, 0);
                }
            }
            this.i.setVisibility(0);
            View view8 = this.i;
            if (view8 == null) {
                return;
            }
            view8.setOnClickListener(new o(this));
            return;
        }
        int i = this.c;
        if (i != -101) {
            switch (i) {
                case 101:
                case 105:
                    this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 26.0f), 0, 0);
                    if (!TextUtils.isEmpty(this.a.e)) {
                        a(context, this.f, 84.0f);
                        a(context, this.g, 138.0f);
                    }
                    z = false;
                    break;
                case 102:
                case 106:
                    this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 10.0f), 0, 0);
                    if (!TextUtils.isEmpty(this.a.e)) {
                        a(context, this.h, 144.0f);
                        a(context, this.f, 54.0f);
                        a(context, this.g, 108.0f);
                    }
                    z = false;
                    break;
                case 103:
                case 104:
                case 107:
                    if (com.smartdigimkt.r4.h.y(context) != 2) {
                        this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 10.0f), 0, 0);
                        z = false;
                    } else {
                        View view9 = this.j;
                        if (view9 != null && view9.getLayoutParams() != null) {
                            ViewGroup.LayoutParams layoutParams5 = this.j.getLayoutParams();
                            layoutParams5.width = com.smartdigimkt.r4.k.a(context, 80.0f);
                            layoutParams5.height = (int) ((context.getResources().getDisplayMetrics().density * 48.0f) + 0.5f);
                            this.j.setLayoutParams(layoutParams5);
                            this.j.setPadding((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f));
                            this.j.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                        }
                        z = true;
                    }
                    break;
                case 108:
                    if (com.smartdigimkt.r4.h.y(context) == 2) {
                        this.i.setPadding(0, 0, 0, 0);
                        view2 = this.j;
                        if (view2 != null) {
                            ViewGroup.LayoutParams layoutParams6 = view2.getLayoutParams();
                            layoutParams6.height = com.smartdigimkt.r4.k.a(context, 48.0f);
                            this.j.setLayoutParams(layoutParams6);
                            this.j.setPadding((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f));
                            this.j.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                        }
                        if (this.c == -101) {
                            layoutParams = this.i.getLayoutParams();
                            layoutParams.width = -2;
                            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                                RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) layoutParams;
                                layoutParams7.addRule(11);
                                layoutParams7.rightMargin = com.smartdigimkt.r4.k.a(context, 20.0f);
                                layoutParams7.bottomMargin = (int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
                            }
                            this.i.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 26.0f), 0, 0);
                        a(context, this.f, 100.0f);
                        a(context, this.g, 152.0f);
                        if (this.c == -101) {
                            a(context, this.i, 35.0f);
                        }
                    }
                    z = false;
                    break;
                default:
                    if (com.smartdigimkt.r4.h.y(context) == 2) {
                        this.i.setPadding(0, 0, 0, 0);
                        View view10 = this.j;
                        if (view10 != null) {
                            ViewGroup.LayoutParams layoutParams8 = view10.getLayoutParams();
                            layoutParams8.height = com.smartdigimkt.r4.k.a(context, 48.0f);
                            this.j.setLayoutParams(layoutParams8);
                            this.j.setPadding((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f));
                            this.j.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                        }
                        View view11 = this.k;
                        if (view11 != null && view11.getLayoutParams() != null) {
                            ViewGroup.LayoutParams layoutParams9 = this.k.getLayoutParams();
                            if (layoutParams9 instanceof RelativeLayout.LayoutParams) {
                                RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
                                layoutParams10.addRule(0, com.smartdigimkt.r4.k.a(context, "myoffer_fl_invalid_btn", "id"));
                                this.k.setLayoutParams(layoutParams10);
                            }
                        }
                        if (this.c == -100) {
                            ViewGroup.LayoutParams layoutParams11 = this.i.getLayoutParams();
                            layoutParams11.width = -2;
                            if (layoutParams11 instanceof RelativeLayout.LayoutParams) {
                                RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
                                layoutParams12.addRule(11);
                                layoutParams12.rightMargin = com.smartdigimkt.r4.k.a(context, 20.0f);
                                layoutParams12.bottomMargin = (int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
                            }
                            this.i.setLayoutParams(layoutParams11);
                        }
                    } else {
                        this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 26.0f), 0, 0);
                        View view12 = this.e;
                        if (view12 != null) {
                            view12.setPadding(0, 0, 0, 0);
                        }
                        View view13 = this.h;
                        if (view13 != null) {
                            ViewGroup.LayoutParams layoutParams13 = view13.getLayoutParams();
                            if (layoutParams13 instanceof RelativeLayout.LayoutParams) {
                                ((RelativeLayout.LayoutParams) layoutParams13).topMargin = com.smartdigimkt.r4.k.a(context, 14.0f);
                            } else if (layoutParams13 instanceof LinearLayout.LayoutParams) {
                                ((LinearLayout.LayoutParams) layoutParams13).topMargin = com.smartdigimkt.r4.k.a(context, 14.0f);
                            }
                        }
                        View view14 = this.f;
                        if (view14 != null) {
                            ViewGroup.LayoutParams layoutParams14 = view14.getLayoutParams();
                            if (layoutParams14 instanceof RelativeLayout.LayoutParams) {
                                ((RelativeLayout.LayoutParams) layoutParams14).topMargin = com.smartdigimkt.r4.k.a(context, 92.0f);
                            } else if (layoutParams14 instanceof LinearLayout.LayoutParams) {
                                ((LinearLayout.LayoutParams) layoutParams14).topMargin = com.smartdigimkt.r4.k.a(context, 92.0f);
                            }
                        }
                        if (this.c == -100) {
                            a(context, this.i, 44.0f);
                        }
                    }
                    z = false;
                    break;
            }
        } else {
            if (com.smartdigimkt.r4.h.y(context) == 2) {
                this.i.setPadding(0, 0, 0, 0);
                view2 = this.j;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams15 = view2.getLayoutParams();
                    layoutParams15.height = com.smartdigimkt.r4.k.a(context, 48.0f);
                    this.j.setLayoutParams(layoutParams15);
                    this.j.setPadding((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 14.0f) + 0.5f));
                    this.j.setBackgroundResource(com.smartdigimkt.r4.k.a(context, "myoffer_invalid_button_shape_radius_24", "drawable"));
                }
                if (this.c == -101) {
                    layoutParams = this.i.getLayoutParams();
                    layoutParams.width = -2;
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams16.addRule(11);
                        layoutParams16.rightMargin = com.smartdigimkt.r4.k.a(context, 20.0f);
                        layoutParams16.bottomMargin = (int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f);
                    }
                    this.i.setLayoutParams(layoutParams);
                }
            } else {
                this.i.setPadding(0, com.smartdigimkt.r4.k.a(context, 26.0f), 0, 0);
                a(context, this.f, 100.0f);
                a(context, this.g, 152.0f);
                if (this.c == -101) {
                    a(context, this.i, 35.0f);
                }
            }
            z = false;
        }
        this.i.setVisibility(0);
        if (z && (view3 = this.j) != null) {
            view3.setOnClickListener(new n(this));
            return;
        }
        View view15 = this.i;
        if (view15 == null) {
            return;
        }
        view15.setOnClickListener(new o(this));
    }

    public static void a(Context context, View view, float f) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.smartdigimkt.r4.k.a(context, f);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = com.smartdigimkt.r4.k.a(context, f);
        }
    }
}
