package com.smartdigimkt.i2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.RoundCornerRelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public ViewGroup a;
    public final com.smartdigimkt.b3.c b;
    public final com.smartdigimkt.a3.a c;
    public final com.smartdigimkt.b3.e d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public RoundCornerRelativeLayout l;
    public boolean m;
    public int n = 8;
    public int o = 8;

    public j(com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar) {
        this.b = cVar;
        this.c = aVar;
        if (cVar != null) {
            this.d = aVar.s;
        }
    }

    public final void a(View view) {
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        Context context2 = view.getContext();
        this.e = (ImageView) view.findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_ad_logo", "id"));
        this.l = (RoundCornerRelativeLayout) view.findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_banner_ad_logo_container", "id"));
        if (this.e == null) {
            this.e = (ImageView) view.findViewById(com.smartdigimkt.r4.k.a(context2, "myoffer_banner_self_ad_logo", "id"));
        }
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.e.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.e.setOnClickListener(new g());
            this.e.setImageResource(com.smartdigimkt.r4.k.a(context2, "myoffer_ad_logo_default", "drawable"));
            if (SDMSDK.getInstance().isUseLocalLogo() || TextUtils.isEmpty(this.b.g)) {
                this.b.getClass();
                this.b.getClass();
            } else {
                int iA = com.smartdigimkt.r4.k.a(context2, 100.0f);
                com.smartdigimkt.i3.m.a(context2).a(new com.smartdigimkt.i3.o(3, this.b.g), iA, iA, new i(this));
            }
        }
        RoundCornerRelativeLayout roundCornerRelativeLayout = this.l;
        if (roundCornerRelativeLayout != null) {
            roundCornerRelativeLayout.setRadius(0);
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_four_element_container", "id"));
        this.a = viewGroup;
        if (viewGroup == null) {
            return;
        }
        this.f = (TextView) viewGroup.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_publisher_name", "id"));
        this.h = (TextView) this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_privacy_agreement", "id"));
        this.i = (TextView) this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_permission_manage", "id"));
        this.g = (TextView) this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_version_name", "id"));
        this.j = (TextView) this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_function_manage", "id"));
        this.k = (TextView) this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_disclaimer", "id"));
        View viewFindViewById = view.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_four_element_container_bg", "id"));
        View viewFindViewById2 = this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_center_line1", "id"));
        if (viewFindViewById2 == null) {
            viewFindViewById2 = this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_banner_center_line", "id"));
        }
        View viewFindViewById3 = this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_center_line2", "id"));
        if (viewFindViewById3 == null) {
            viewFindViewById3 = this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_banner_center_line2", "id"));
        }
        View viewFindViewById4 = this.a.findViewById(com.smartdigimkt.r4.k.a(context, "myoffer_center_line3", "id"));
        if (this.b.g()) {
            this.a.setVisibility(0);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(0);
            }
            TextView textView = this.f;
            if (textView != null) {
                textView.setVisibility(0);
                this.f.setText(this.b.r);
                this.f.setOnClickListener(new a());
            }
            TextView textView2 = this.g;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.g.setText(context.getResources().getString(com.smartdigimkt.r4.k.a(context, "myoffer_panel_version", "string"), this.b.s));
                this.g.setOnClickListener(new b());
            }
            if (this.h != null) {
                if (TextUtils.isEmpty(this.b.t)) {
                    this.h.setVisibility(8);
                } else {
                    this.h.setVisibility(0);
                    this.h.setOnClickListener(new c(this));
                }
            }
            if (this.i != null) {
                if (TextUtils.isEmpty(this.b.u)) {
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(8);
                    }
                    this.i.setVisibility(8);
                } else {
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setVisibility(0);
                    }
                    this.i.setVisibility(0);
                    this.i.setOnClickListener(new d(this));
                }
            }
            if (this.j != null) {
                if (TextUtils.isEmpty(this.b.v)) {
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setVisibility(8);
                    }
                    this.j.setVisibility(8);
                } else {
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setVisibility(0);
                    }
                    this.j.setVisibility(0);
                    this.j.setOnClickListener(new e(this));
                }
            }
        } else {
            if (this.a != null && !TextUtils.equals(String.valueOf(this.d.a), "2")) {
                this.a.setVisibility(8);
            }
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            TextView textView4 = this.f;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.h;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.i;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            TextView textView7 = this.j;
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
        if (this.k != null) {
            ViewGroup viewGroup2 = this.a;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
            }
            this.k.setVisibility(0);
            if (viewFindViewById4 != null && this.b.g()) {
                viewFindViewById4.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.c.s.P0)) {
                return;
            }
            this.k.setOnClickListener(new f(this));
        }
    }
}
