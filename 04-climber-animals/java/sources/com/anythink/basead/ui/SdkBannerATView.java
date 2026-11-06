package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.d.j;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.res.e;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public class SdkBannerATView extends BaseBannerATView {
    private static final int D = 1;
    private static final int E = 2;
    String A;
    SimplePlayerBannerMediaView B;
    private int C;
    private final View.OnClickListener F;
    private final View.OnClickListener G;

    public SdkBannerATView(Context context) {
        super(context);
        this.F = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkBannerATView.super.a(1, 3);
            }
        };
        this.G = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerATView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SdkBannerATView.this.q == null || SdkBannerATView.this.q != view) {
                    SdkBannerATView.super.a(1, 2);
                } else {
                    SdkBannerATView.super.a(1, 1);
                }
            }
        };
    }

    public SdkBannerATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        super(context, xVar, wVar, aVar);
        this.F = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SdkBannerATView.super.a(1, 3);
            }
        };
        this.G = new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerATView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (SdkBannerATView.this.q == null || SdkBannerATView.this.q != view) {
                    SdkBannerATView.super.a(1, 2);
                } else {
                    SdkBannerATView.super.a(1, 1);
                }
            }
        };
        b();
        c();
    }

    private void d() {
        byte b;
        String str;
        String strB = this.f.o.B();
        String strD = this.g.d(this.f.o);
        switch (strB) {
            case "300x250":
                b = 1;
                break;
            case "320x50":
                b = 3;
                break;
            case "320x90":
                b = 0;
                break;
            case "728x90":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            this.A = y.b;
            str = (this.g.L() || !TextUtils.isEmpty(strD)) ? "myoffer_banner_ad_layout_320x90" : "myoffer_banner_ad_layout_no_main_res_320x90";
        } else if (b == 1) {
            this.A = y.c;
            str = "myoffer_banner_ad_layout_300x250";
        } else if (b == 2) {
            this.A = y.d;
            str = "myoffer_banner_ad_layout_728x90";
        } else {
            this.A = y.a;
            str = "myoffer_banner_ad_layout_320x50";
        }
        int i = (!(this.g instanceof bj) ? !(!(this.g instanceof ay) || TextUtils.equals(strD, this.g.B())) : ((bj) this.g).aI() == 1) ? 2 : 1;
        this.C = i;
        if (1 == i) {
            LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_banner_ad_layout_pure_picture", "layout"), this);
            int iA = q.a(getContext(), 320.0f);
            int iA2 = q.a(getContext(), 50.0f);
            strB.hashCode();
            switch (strB) {
                case "300x250":
                    iA = q.a(getContext(), 300.0f);
                    iA2 = q.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 50.0f);
                    break;
                case "320x90":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    break;
                case "728x90":
                    iA = q.a(getContext(), 720.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    break;
            }
            if (this.f.o.k() > 0) {
                iA = this.f.o.k();
            }
            if (this.f.o.l() > 0) {
                iA2 = this.f.o.l();
            }
            setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_banner_root", "id"));
            this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            if (this.f.o.C() == 0) {
                this.b.setVisibility(0);
                if (TextUtils.equals(y.d, this.A)) {
                    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                    layoutParams.width = q.a(getContext(), 23.0f);
                    layoutParams.height = q.a(getContext(), 23.0f);
                    this.b.setLayoutParams(layoutParams);
                }
                a((b) this.b, false);
            } else {
                com.anythink.basead.ui.f.b.a((View) this.b, true);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            relativeLayout.setLayoutParams(layoutParams2);
            a(this, strD);
            return;
        }
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), str, "layout"), this);
        RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_banner_icon", "id"));
        TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
        TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_banner_desc", "id"));
        Button button = (Button) findViewById(q.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.q = button;
        this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        if (this.f.o.C() == 0) {
            this.b.setVisibility(0);
            a((b) this.b, false);
        } else {
            com.anythink.basead.ui.f.b.a((View) this.b, true);
        }
        if (roundImageView != null) {
            if (!TextUtils.isEmpty(this.g.z())) {
                ViewGroup.LayoutParams layoutParams3 = roundImageView.getLayoutParams();
                roundImageView.setVisibility(0);
                roundImageView.setRadiusInDip(6);
                roundImageView.setNeedRadiu(true);
                this.n.add(roundImageView);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), layoutParams3.width, layoutParams3.height, new AnonymousClass3(roundImageView));
            } else {
                roundImageView.setVisibility(0);
                com.anythink.basead.ui.f.b.a((View) roundImageView, false);
            }
        }
        if (!TextUtils.isEmpty(this.g.D())) {
            button.setText(this.g.D());
            button.setVisibility(0);
            this.n.add(button);
            this.o = button;
        } else {
            button.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.g.x())) {
            textView.setText(this.g.x());
            textView.setVisibility(0);
            this.n.add(textView);
        } else {
            textView.setVisibility(8);
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(this.g.y())) {
                textView2.setText(this.g.y());
                textView2.setVisibility(0);
                this.n.add(textView2);
            } else {
                textView2.setVisibility(8);
            }
        }
        a((ViewGroup) findViewById(q.a(getContext(), "myoffer_main_resouce_container", "id")), (String) null);
    }

    private int a(String str) {
        int i = 1;
        if (!(this.g instanceof bj) ? !(this.g instanceof ay) || TextUtils.equals(str, this.g.B()) : ((bj) this.g).aI() != 1) {
            i = 2;
        }
        this.C = i;
        return i;
    }

    private void b(String str) {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_banner_root", "id"));
        this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        if (this.f.o.C() == 0) {
            this.b.setVisibility(0);
            if (TextUtils.equals(y.d, this.A)) {
                ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                layoutParams.width = q.a(getContext(), 23.0f);
                layoutParams.height = q.a(getContext(), 23.0f);
                this.b.setLayoutParams(layoutParams);
            }
            a((b) this.b, false);
        } else {
            com.anythink.basead.ui.f.b.a((View) this.b, true);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        relativeLayout.setLayoutParams(layoutParams2);
        a(this, str);
    }

    private void w() {
        RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_banner_icon", "id"));
        TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
        TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_banner_desc", "id"));
        Button button = (Button) findViewById(q.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.q = button;
        this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        if (this.f.o.C() == 0) {
            this.b.setVisibility(0);
            a((b) this.b, false);
        } else {
            com.anythink.basead.ui.f.b.a((View) this.b, true);
        }
        if (roundImageView != null) {
            if (!TextUtils.isEmpty(this.g.z())) {
                ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
                roundImageView.setVisibility(0);
                roundImageView.setRadiusInDip(6);
                roundImageView.setNeedRadiu(true);
                this.n.add(roundImageView);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), layoutParams.width, layoutParams.height, new AnonymousClass3(roundImageView));
            } else {
                roundImageView.setVisibility(0);
                com.anythink.basead.ui.f.b.a((View) roundImageView, false);
            }
        }
        if (!TextUtils.isEmpty(this.g.D())) {
            button.setText(this.g.D());
            button.setVisibility(0);
            this.n.add(button);
            this.o = button;
        } else {
            button.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.g.x())) {
            textView.setText(this.g.x());
            textView.setVisibility(0);
            this.n.add(textView);
        } else {
            textView.setVisibility(8);
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(this.g.y())) {
                textView2.setText(this.g.y());
                textView2.setVisibility(0);
                this.n.add(textView2);
            } else {
                textView2.setVisibility(8);
            }
        }
        a((ViewGroup) findViewById(q.a(getContext(), "myoffer_main_resouce_container", "id")), (String) null);
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.SdkBannerATView$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ RoundImageView a;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass3(RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(SdkBannerATView.this.g.z(), str)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    private void a(ViewGroup viewGroup, final String str) {
        if (viewGroup != null) {
            boolean z = true;
            if (com.anythink.basead.b.e.a(this.g, this.f)) {
                SimplePlayerBannerMediaView simplePlayerBannerMediaView = new SimplePlayerBannerMediaView(getContext());
                this.B = simplePlayerBannerMediaView;
                simplePlayerBannerMediaView.setmIsPureMode(this.C == 1);
                viewGroup.addView(this.B, 0, new RelativeLayout.LayoutParams(-1, -1));
                this.B.setATImproveClickViewController(this.s);
                this.B.setIsMuted(true);
                this.B.initPlayerView(this.g, this.f, new com.anythink.basead.ui.component.a.InterfaceC0058a() { // from class: com.anythink.basead.ui.SdkBannerATView.4
                    @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
                    public final j a() {
                        return SdkBannerATView.this.l();
                    }

                    @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
                    public final com.anythink.basead.d.a b() {
                        return SdkBannerATView.this.m();
                    }
                }, this.z);
                this.B.setPlayerOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.SdkBannerATView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SdkBannerATView.this.G.onClick(view);
                    }
                });
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = this.g.d(this.f.o);
                }
                if (TextUtils.isEmpty(str)) {
                    str = this.g.z();
                }
                if (TextUtils.isEmpty(str)) {
                    z = false;
                } else {
                    final RecycleImageView recycleImageView = new RecycleImageView(getContext());
                    recycleImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    final RecycleImageView recycleImageView2 = new RecycleImageView(getContext());
                    recycleImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    viewGroup.addView(recycleImageView2, 0, new RelativeLayout.LayoutParams(-1, -1));
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, str), new com.anythink.core.common.res.b.a() { // from class: com.anythink.basead.ui.SdkBannerATView.6
                        @Override // com.anythink.core.common.res.b.a
                        public final void onFail(String str2, String str3) {
                        }

                        @Override // com.anythink.core.common.res.b.a
                        public final void onSuccess(String str2, Bitmap bitmap) {
                            if (TextUtils.equals(str, str2)) {
                                recycleImageView.setImageBitmap(bitmap);
                                h.a(SdkBannerATView.this.getContext(), bitmap, new h.a() { // from class: com.anythink.basead.ui.SdkBannerATView.6.1
                                    @Override // com.anythink.core.common.v.h.a
                                    public final void a() {
                                    }

                                    @Override // com.anythink.core.common.v.h.a
                                    public final void a(Bitmap bitmap2) {
                                        recycleImageView2.setImageBitmap(bitmap2);
                                    }
                                });
                            }
                        }
                    });
                    viewGroup.addView(recycleImageView, 1, new RelativeLayout.LayoutParams(-1, -1));
                    this.n.add(recycleImageView);
                }
            }
            if (z) {
                viewGroup.setVisibility(0);
            } else {
                viewGroup.setVisibility(8);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseBannerATView
    protected final void c() {
        super.c();
        if (this.C == 1) {
            setOnClickListener(this.F);
            return;
        }
        if (this.f.o.H() == 1) {
            if (this.q != null) {
                this.q.setOnClickListener(this.G);
            }
        } else {
            int size = this.n.size();
            for (int i = 0; i < size; i++) {
                View view = this.n.get(i);
                if (view != null) {
                    view.setOnClickListener(this.G);
                }
            }
        }
        if (this.f.o.H() == 0) {
            setOnClickListener(this.F);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        SimplePlayerBannerMediaView simplePlayerBannerMediaView = this.B;
        if (simplePlayerBannerMediaView != null) {
            simplePlayerBannerMediaView.destroyPlayerView(4);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        byte b;
        String str;
        String strB = this.f.o.B();
        String strD = this.g.d(this.f.o);
        switch (strB) {
            case "300x250":
                b = 1;
                break;
            case "320x50":
                b = 3;
                break;
            case "320x90":
                b = 0;
                break;
            case "728x90":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            this.A = y.b;
            str = (this.g.L() || !TextUtils.isEmpty(strD)) ? "myoffer_banner_ad_layout_320x90" : "myoffer_banner_ad_layout_no_main_res_320x90";
        } else if (b == 1) {
            this.A = y.c;
            str = "myoffer_banner_ad_layout_300x250";
        } else if (b == 2) {
            this.A = y.d;
            str = "myoffer_banner_ad_layout_728x90";
        } else {
            this.A = y.a;
            str = "myoffer_banner_ad_layout_320x50";
        }
        int i = (!(this.g instanceof bj) ? !(!(this.g instanceof ay) || TextUtils.equals(strD, this.g.B())) : ((bj) this.g).aI() == 1) ? 2 : 1;
        this.C = i;
        if (1 == i) {
            LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_banner_ad_layout_pure_picture", "layout"), this);
            int iA = q.a(getContext(), 320.0f);
            int iA2 = q.a(getContext(), 50.0f);
            strB.hashCode();
            switch (strB) {
                case "300x250":
                    iA = q.a(getContext(), 300.0f);
                    iA2 = q.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 50.0f);
                    break;
                case "320x90":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    break;
                case "728x90":
                    iA = q.a(getContext(), 720.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    break;
            }
            if (this.f.o.k() > 0) {
                iA = this.f.o.k();
            }
            if (this.f.o.l() > 0) {
                iA2 = this.f.o.l();
            }
            setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_banner_root", "id"));
            this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            if (this.f.o.C() == 0) {
                this.b.setVisibility(0);
                if (TextUtils.equals(y.d, this.A)) {
                    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
                    layoutParams.width = q.a(getContext(), 23.0f);
                    layoutParams.height = q.a(getContext(), 23.0f);
                    this.b.setLayoutParams(layoutParams);
                }
                a((b) this.b, false);
            } else {
                com.anythink.basead.ui.f.b.a((View) this.b, true);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            relativeLayout.setLayoutParams(layoutParams2);
            a(this, strD);
        } else {
            LayoutInflater.from(getContext()).inflate(q.a(getContext(), str, "layout"), this);
            RoundImageView roundImageView = (RoundImageView) findViewById(q.a(getContext(), "myoffer_banner_icon", "id"));
            TextView textView = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
            TextView textView2 = (TextView) findViewById(q.a(getContext(), "myoffer_banner_desc", "id"));
            Button button = (Button) findViewById(q.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
            this.q = button;
            this.b = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            if (this.f.o.C() == 0) {
                this.b.setVisibility(0);
                a((b) this.b, false);
            } else {
                com.anythink.basead.ui.f.b.a((View) this.b, true);
            }
            if (roundImageView != null) {
                if (!TextUtils.isEmpty(this.g.z())) {
                    ViewGroup.LayoutParams layoutParams3 = roundImageView.getLayoutParams();
                    roundImageView.setVisibility(0);
                    roundImageView.setRadiusInDip(6);
                    roundImageView.setNeedRadiu(true);
                    this.n.add(roundImageView);
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), layoutParams3.width, layoutParams3.height, new AnonymousClass3(roundImageView));
                } else {
                    roundImageView.setVisibility(0);
                    com.anythink.basead.ui.f.b.a((View) roundImageView, false);
                }
            }
            if (!TextUtils.isEmpty(this.g.D())) {
                button.setText(this.g.D());
                button.setVisibility(0);
                this.n.add(button);
                this.o = button;
            } else {
                button.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.g.x())) {
                textView.setText(this.g.x());
                textView.setVisibility(0);
                this.n.add(textView);
            } else {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                if (!TextUtils.isEmpty(this.g.y())) {
                    textView2.setText(this.g.y());
                    textView2.setVisibility(0);
                    this.n.add(textView2);
                } else {
                    textView2.setVisibility(8);
                }
            }
            a((ViewGroup) findViewById(q.a(getContext(), "myoffer_main_resouce_container", "id")), (String) null);
        }
        this.d = new com.anythink.basead.ui.f.a(this.g, this.f);
        this.d.b(this);
    }
}
