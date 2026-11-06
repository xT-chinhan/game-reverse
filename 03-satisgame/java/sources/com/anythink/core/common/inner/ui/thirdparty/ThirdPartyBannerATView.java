package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.inner.ui.BaseBannerATView;
import com.anythink.core.common.inner.ui.CloseImageView;
import com.anythink.core.common.inner.ui.ScanningAnimButton;
import com.anythink.core.common.k.e.a.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.p;
import com.anythink.core.common.ui.component.RoundImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyBannerATView extends BaseBannerATView implements d {
    private Context A;
    private ViewGroup d;
    private com.anythink.core.common.k.g.d l;
    private FrameLayout m;
    private FrameLayout n;
    private LinearLayout o;
    private TextView p;
    private TextView q;
    private ScanningAnimButton r;
    private RoundImageView s;
    private View t;
    private View u;
    private List<Integer> v;
    private boolean w;
    private TextView x;
    private String y;
    private com.anythink.core.common.inner.mixad.f.b z;

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a() {
    }

    public ThirdPartyBannerATView(Context context) {
        super(context);
        this.w = false;
        this.y = "";
        this.A = context;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:57:0x01bc  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public ThirdPartyBannerATView(Context context, BaseAd baseAd, x xVar, w<?> wVar, com.anythink.core.common.inner.e.a aVar) {
        float f;
        String str;
        byte b;
        byte b2;
        byte b3;
        float f2;
        ViewGroup.LayoutParams layoutParams;
        super(context, xVar, wVar, aVar);
        byte b4 = 0;
        this.w = false;
        this.y = "";
        if (baseAd instanceof com.anythink.core.common.k.g.d) {
            this.l = (com.anythink.core.common.k.g.d) baseAd;
        }
        com.anythink.core.common.k.g.d dVar = this.l;
        if (dVar == null || wVar == null || xVar == null) {
            return;
        }
        this.A = context;
        this.w = dVar.r();
        this.v = new ArrayList();
        if (!this.l.isNativeExpress()) {
            for (int i : this.l.i()) {
                this.v.add(Integer.valueOf(i));
            }
        }
        this.y = this.l.p();
        float f3 = 50.0f;
        if (this.l.isNativeExpress()) {
            this.d = (ViewGroup) LayoutInflater.from(this.A).inflate(p.a(getContext(), "myoffer_banner_ad_layout_template", "layout"), (ViewGroup) this, false);
            int iA = p.a(getContext(), 320.0f);
            int iA2 = p.a(getContext(), 50.0f);
            String str2 = this.y;
            str2.hashCode();
            switch (str2) {
                case "300x250":
                    iA = p.a(getContext(), 300.0f);
                    f = 250.0f;
                    iA2 = p.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = p.a(getContext(), 320.0f);
                    iA2 = p.a(getContext(), 50.0f);
                    f = 250.0f;
                    break;
                case "320x90":
                    iA = p.a(getContext(), 320.0f);
                    iA2 = p.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                case "728x90":
                    iA = p.a(getContext(), 720.0f);
                    iA2 = p.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                default:
                    f = 250.0f;
                    break;
            }
            this.d.setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            addView(this.d);
            FrameLayout frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_banner_template_view", "id"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            View adMediaView = this.l.getAdMediaView(frameLayout);
            this.u = adMediaView;
            if (adMediaView != null) {
                if (adMediaView.getParent() != null) {
                    ((ViewGroup) this.u.getParent()).removeView(this.u);
                }
                frameLayout.addView(this.u, layoutParams2);
            }
            CloseImageView closeImageView = (CloseImageView) findViewById(p.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView;
            if (closeImageView != null) {
                if (this.w) {
                    closeImageView.setVisibility(0);
                } else {
                    closeImageView.setVisibility(8);
                }
            }
            b = 1;
            b2 = -1;
        } else {
            f = 250.0f;
            this.d = new FrameLayout(this.A);
            String str3 = this.y;
            str3.hashCode();
            switch (str3) {
                case "300x250":
                    str = "myoffer_banner_native_ad_layout_300x250";
                    break;
                case "320x90":
                    com.anythink.core.common.k.g.d dVar2 = this.l;
                    if (!(dVar2.getAdMediaView(this) == null && TextUtils.isEmpty(dVar2.getMainImageUrl()))) {
                        str = "myoffer_banner_native_ad_layout_320x90";
                        break;
                    } else {
                        str = "myoffer_banner_native_ad_layout_no_main_res_320x90";
                        break;
                    }
                    break;
                case "728x90":
                    str = "myoffer_banner_native_ad_layout_728x90";
                    break;
                default:
                    str = "myoffer_banner_native_ad_layout_320x50";
                    break;
            }
            this.d.addView((ViewGroup) LayoutInflater.from(this.A).inflate(p.a(getContext(), str, "layout"), (ViewGroup) this, false));
            addView(this.d);
            this.m = (FrameLayout) findViewById(p.a(getContext(), "myoffer_main_resouce_container", "id"));
            this.n = (FrameLayout) findViewById(p.a(getContext(), "myoffer_banner_icon_container", "id"));
            this.o = (LinearLayout) findViewById(p.a(getContext(), "ll_title_desc", "id"));
            this.s = (RoundImageView) findViewById(p.a(getContext(), "myoffer_banner_icon", "id"));
            this.p = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_title", "id"));
            this.q = (TextView) findViewById(p.a(getContext(), "myoffer_banner_desc", "id"));
            this.r = (ScanningAnimButton) findViewById(p.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
            this.x = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_from", "id"));
            CloseImageView closeImageView2 = (CloseImageView) findViewById(p.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView2;
            a(this.x, this.l.getAdFrom());
            if (closeImageView2 != null) {
                if (this.w) {
                    closeImageView2.setVisibility(0);
                } else {
                    closeImageView2.setVisibility(8);
                }
            }
            View adIconView = this.l.getAdIconView();
            this.t = adIconView;
            if (adIconView != null) {
                if (adIconView.getParent() != null && (this.t.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.t.getParent()).removeView(this.t);
                }
                this.n.removeAllViews();
                this.n.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
            } else if (!TextUtils.isEmpty(this.g.l()) && this.s != null) {
                this.n.setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = this.n.getLayoutParams();
                this.s.setRadiusInDip(6);
                this.s.setNeedRadiu(true);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.l()), layoutParams3.width, layoutParams3.height, new AnonymousClass1());
            } else {
                FrameLayout frameLayout2 = this.n;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
            }
            a(this.p, this.g.j());
            String strO = this.g.o();
            a(this.r, strO);
            if (TextUtils.isEmpty(strO)) {
                ScanningAnimButton scanningAnimButton = this.r;
                if (scanningAnimButton != null) {
                    scanningAnimButton.setVisibility(8);
                }
            } else {
                ScanningAnimButton scanningAnimButton2 = this.r;
                if (scanningAnimButton2 != null) {
                    scanningAnimButton2.setVisibility(0);
                }
            }
            a(this.q, this.g.k());
            if (this.m != null) {
                b2 = -1;
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 17;
                this.u = this.l.getAdMediaView(this.m);
                String mainImageUrl = this.l.getMainImageUrl();
                if (this.u != null) {
                    this.m.setVisibility(0);
                    if (this.u.getParent() != null) {
                        ((ViewGroup) this.u.getParent()).removeView(this.u);
                    }
                    this.m.addView(this.u, layoutParams4);
                    b = 1;
                } else if (!TextUtils.isEmpty(mainImageUrl)) {
                    this.m.setVisibility(0);
                    RoundImageView roundImageView = new RoundImageView(getContext());
                    this.m.addView(roundImageView, layoutParams4);
                    b = 1;
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, mainImageUrl), new AnonymousClass2(mainImageUrl, roundImageView));
                } else {
                    b = 1;
                    this.m.setVisibility(8);
                }
            } else {
                b = 1;
                b2 = -1;
            }
            View adLogoView = this.l.getAdLogoView();
            this.c = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
            this.c.a(adLogoView);
            this.c.b(this);
        }
        b();
        com.anythink.core.common.k.g.d dVar3 = this.l;
        if (this.d != null) {
            Context context2 = getContext();
            String str4 = this.y;
            str4.hashCode();
            switch (str4.hashCode()) {
                case -559799608:
                    b3 = str4.equals(y.c) ? (byte) 0 : b2;
                    break;
                case 1507809730:
                    b3 = str4.equals(y.a) ? b : b2;
                    break;
                case 1507809854:
                    b3 = str4.equals(y.b) ? (byte) 2 : b2;
                    break;
                case 1622564786:
                    b3 = str4.equals(y.d) ? (byte) 3 : b2;
                    break;
                default:
                    b3 = b2;
                    break;
            }
            switch (b3) {
                case 0:
                    f2 = 300.0f;
                    break;
                case 1:
                case 2:
                default:
                    f2 = 320.0f;
                    break;
                case 3:
                    f2 = 728.0f;
                    break;
            }
            int iA3 = p.a(context2, f2);
            String str5 = this.y;
            str5.hashCode();
            switch (str5.hashCode()) {
                case -559799608:
                    if (!str5.equals(y.c)) {
                        b4 = b2;
                    }
                    break;
                case 1507809730:
                    b4 = str5.equals(y.a) ? b : b2;
                    break;
                case 1507809854:
                    b4 = str5.equals(y.b) ? (byte) 2 : b2;
                    break;
                case 1622564786:
                    b4 = str5.equals(y.d) ? (byte) 3 : b2;
                    break;
                default:
                    b4 = b2;
                    break;
            }
            switch (b4) {
                case 0:
                    f3 = f;
                    break;
                case 2:
                case 3:
                    f3 = 90.0f;
                    break;
            }
            int iA4 = p.a(context2, f3);
            int i2 = getResources().getDisplayMetrics().widthPixels;
            iA3 = iA3 > i2 ? i2 : iA3;
            ViewGroup customAdContainer = dVar3 != null ? dVar3.getCustomAdContainer() : null;
            if (customAdContainer != null) {
                ViewGroup.LayoutParams layoutParams5 = customAdContainer.getLayoutParams();
                if (layoutParams5 == null) {
                    layoutParams5 = new ViewGroup.LayoutParams(iA3, iA4);
                } else {
                    layoutParams5.width = iA3;
                    layoutParams5.height = iA4;
                }
                customAdContainer.setLayoutParams(layoutParams5);
                removeAllViews();
                if (customAdContainer instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iA3, iA4);
                    layoutParams6.gravity = 17;
                    layoutParams = layoutParams6;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(iA3, iA4);
                }
                this.d.setLayoutParams(layoutParams);
                al.a((View) customAdContainer);
                customAdContainer.addView(this.d);
                if (customAdContainer.getParent() != null) {
                    ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                }
                addView(customAdContainer);
            }
            a(this.d);
        }
        if (this.l.isNativeExpress()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.n != null) {
            arrayList.add(this.m);
        }
        FrameLayout frameLayout3 = this.n;
        if (frameLayout3 != null) {
            arrayList.add(frameLayout3);
        }
        this.z = new com.anythink.core.common.inner.mixad.f.b.a().a(arrayList).a(this.p).b(this.q).c(this.r).a();
    }

    private void c() {
        this.w = this.l.r();
        this.v = new ArrayList();
        if (!this.l.isNativeExpress()) {
            for (int i : this.l.i()) {
                this.v.add(Integer.valueOf(i));
            }
        }
        this.y = this.l.p();
    }

    private void g() {
        byte b = 0;
        this.d = (ViewGroup) LayoutInflater.from(this.A).inflate(p.a(getContext(), "myoffer_banner_ad_layout_template", "layout"), (ViewGroup) this, false);
        int iA = p.a(getContext(), 320.0f);
        int iA2 = p.a(getContext(), 50.0f);
        String str = this.y;
        str.hashCode();
        switch (str.hashCode()) {
            case -559799608:
                if (!str.equals(y.c)) {
                    b = -1;
                }
                break;
            case 1507809730:
                b = !str.equals(y.a) ? (byte) -1 : (byte) 1;
                break;
            case 1507809854:
                b = !str.equals(y.b) ? (byte) -1 : (byte) 2;
                break;
            case 1622564786:
                b = !str.equals(y.d) ? (byte) -1 : (byte) 3;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                iA = p.a(getContext(), 300.0f);
                iA2 = p.a(getContext(), 250.0f);
                break;
            case 1:
                iA = p.a(getContext(), 320.0f);
                iA2 = p.a(getContext(), 50.0f);
                break;
            case 2:
                iA = p.a(getContext(), 320.0f);
                iA2 = p.a(getContext(), 90.0f);
                break;
            case 3:
                iA = p.a(getContext(), 720.0f);
                iA2 = p.a(getContext(), 90.0f);
                break;
        }
        this.d.setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
        addView(this.d);
    }

    private void h() {
        String str;
        this.d = new FrameLayout(this.A);
        String str2 = this.y;
        str2.hashCode();
        switch (str2) {
            case "300x250":
                str = "myoffer_banner_native_ad_layout_300x250";
                break;
            case "320x90":
                com.anythink.core.common.k.g.d dVar = this.l;
                if (!(dVar.getAdMediaView(this) == null && TextUtils.isEmpty(dVar.getMainImageUrl()))) {
                    str = "myoffer_banner_native_ad_layout_320x90";
                    break;
                } else {
                    str = "myoffer_banner_native_ad_layout_no_main_res_320x90";
                    break;
                }
                break;
            case "728x90":
                str = "myoffer_banner_native_ad_layout_728x90";
                break;
            default:
                str = "myoffer_banner_native_ad_layout_320x50";
                break;
        }
        this.d.addView((ViewGroup) LayoutInflater.from(this.A).inflate(p.a(getContext(), str, "layout"), (ViewGroup) this, false));
        addView(this.d);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void i() {
        FrameLayout frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_banner_template_view", "id"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        View adMediaView = this.l.getAdMediaView(frameLayout);
        this.u = adMediaView;
        if (adMediaView != null) {
            if (adMediaView.getParent() != null) {
                ((ViewGroup) this.u.getParent()).removeView(this.u);
            }
            frameLayout.addView(this.u, layoutParams);
        }
        CloseImageView closeImageView = (CloseImageView) findViewById(p.a(getContext(), "myoffer_banner_close", "id"));
        this.b = closeImageView;
        if (closeImageView != null) {
            if (this.w) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
    }

    private void j() {
        this.m = (FrameLayout) findViewById(p.a(getContext(), "myoffer_main_resouce_container", "id"));
        this.n = (FrameLayout) findViewById(p.a(getContext(), "myoffer_banner_icon_container", "id"));
        this.o = (LinearLayout) findViewById(p.a(getContext(), "ll_title_desc", "id"));
        this.s = (RoundImageView) findViewById(p.a(getContext(), "myoffer_banner_icon", "id"));
        this.p = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.q = (TextView) findViewById(p.a(getContext(), "myoffer_banner_desc", "id"));
        this.r = (ScanningAnimButton) findViewById(p.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.x = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_from", "id"));
        CloseImageView closeImageView = (CloseImageView) findViewById(p.a(getContext(), "myoffer_banner_close", "id"));
        this.b = closeImageView;
        a(this.x, this.l.getAdFrom());
        if (closeImageView != null) {
            if (this.w) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
        View adIconView = this.l.getAdIconView();
        this.t = adIconView;
        if (adIconView != null) {
            if (adIconView.getParent() != null && (this.t.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.t.getParent()).removeView(this.t);
            }
            this.n.removeAllViews();
            this.n.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
        } else if (!TextUtils.isEmpty(this.g.l()) && this.s != null) {
            this.n.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            this.s.setRadiusInDip(6);
            this.s.setNeedRadiu(true);
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.l()), layoutParams.width, layoutParams.height, new AnonymousClass1());
        } else {
            FrameLayout frameLayout = this.n;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        a(this.p, this.g.j());
        String strO = this.g.o();
        a(this.r, strO);
        if (TextUtils.isEmpty(strO)) {
            ScanningAnimButton scanningAnimButton = this.r;
            if (scanningAnimButton != null) {
                scanningAnimButton.setVisibility(8);
            }
        } else {
            ScanningAnimButton scanningAnimButton2 = this.r;
            if (scanningAnimButton2 != null) {
                scanningAnimButton2.setVisibility(0);
            }
        }
        a(this.q, this.g.k());
        if (this.m != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            this.u = this.l.getAdMediaView(this.m);
            String mainImageUrl = this.l.getMainImageUrl();
            if (this.u != null) {
                this.m.setVisibility(0);
                if (this.u.getParent() != null) {
                    ((ViewGroup) this.u.getParent()).removeView(this.u);
                }
                this.m.addView(this.u, layoutParams2);
            } else if (!TextUtils.isEmpty(mainImageUrl)) {
                this.m.setVisibility(0);
                RoundImageView roundImageView = new RoundImageView(getContext());
                this.m.addView(roundImageView, layoutParams2);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, mainImageUrl), new AnonymousClass2(mainImageUrl, roundImageView));
            } else {
                this.m.setVisibility(8);
            }
        }
        View adLogoView = this.l.getAdLogoView();
        this.c = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
        this.c.a(adLogoView);
        this.c.b(this);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyBannerATView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(ThirdPartyBannerATView.this.g.l(), str)) {
                ThirdPartyBannerATView.this.s.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyBannerATView$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ String a;
        final /* synthetic */ RoundImageView b;

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass2(String str, RoundImageView roundImageView) {
            this.a = str;
            this.b = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(this.a, str)) {
                this.b.setImageBitmap(bitmap);
            }
        }
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

    private void a(View view) {
        RoundImageView roundImageView;
        int i = this.f.j;
        FrameLayout.LayoutParams layoutParamsA = com.anythink.core.common.inner.mixad.f.a.a(i, a(32.0f), a(8.0f));
        com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        int[] iArrI = this.l.i();
        if (iArrI == null) {
            b((View) this);
        } else {
            for (int i2 : iArrI) {
                if (i2 == 1) {
                    View view2 = this.t;
                    if (view2 != null) {
                        b(view2);
                        bVar.b(this.t);
                    } else if (!TextUtils.isEmpty(this.l.getIconImageUrl()) && (roundImageView = this.s) != null) {
                        b(roundImageView);
                        bVar.b(this.s);
                    }
                    b(this.u);
                    View view3 = this.u;
                    if (view3 != null) {
                        bVar.c(view3);
                    }
                } else if (i2 == 2) {
                    b(this.p);
                    bVar.a(this.p);
                } else if (i2 == 3) {
                    b(this.q);
                    bVar.d(this.q);
                } else if (i2 == 4) {
                    b(this.r);
                    bVar.e(this.r);
                } else if (i2 == 5) {
                    b((View) this);
                }
            }
        }
        if (this.b != null) {
            bVar.i(this.b);
        }
        if (this.c != null && i == 34) {
            bVar.f(this.x);
            this.c.a(this.l, bVar, false);
        }
        com.anythink.core.common.k.g.d dVar = this.l;
        if (dVar != null) {
            dVar.registerListener(view, this.j, layoutParamsA, bVar);
        }
    }

    private void b(View view) {
        if (view != null) {
            this.j.add(view);
        }
    }

    private int a(float f) {
        return p.a(getContext(), f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.core.common.inner.mixad.f.b bVar = this.z;
        if (bVar != null) {
            bVar.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private static boolean a(float f, float f2, View view) {
        if (view == null) {
            return false;
        }
        float x = view.getX();
        float y = view.getY();
        return f >= x && f <= ((float) view.getWidth()) + x && f2 >= y && f2 <= ((float) view.getHeight()) + y;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void a(BaseAd baseAd) {
        char c;
        ViewGroup.LayoutParams layoutParams;
        if (this.d == null) {
            return;
        }
        Context context = getContext();
        String str = this.y;
        str.hashCode();
        byte b = 3;
        switch (str) {
            case "300x250":
                c = 0;
                break;
            case "320x50":
                c = 1;
                break;
            case "320x90":
                c = 2;
                break;
            case "728x90":
                c = 3;
                break;
            default:
                c = -1;
                break;
        }
        float f = 320.0f;
        switch (c) {
            case 0:
                f = 300.0f;
                break;
            case 3:
                f = 728.0f;
                break;
        }
        int iA = p.a(context, f);
        String str2 = this.y;
        str2.hashCode();
        switch (str2.hashCode()) {
            case -559799608:
                b = !str2.equals(y.c) ? (byte) -1 : (byte) 0;
                break;
            case 1507809730:
                b = !str2.equals(y.a) ? (byte) -1 : (byte) 1;
                break;
            case 1507809854:
                b = !str2.equals(y.b) ? (byte) -1 : (byte) 2;
                break;
            case 1622564786:
                if (!str2.equals(y.d)) {
                    b = -1;
                }
                break;
            default:
                b = -1;
                break;
        }
        float f2 = 50.0f;
        switch (b) {
            case 0:
                f2 = 250.0f;
                break;
            case 2:
            case 3:
                f2 = 90.0f;
                break;
        }
        int iA2 = p.a(context, f2);
        int i = getResources().getDisplayMetrics().widthPixels;
        if (iA > i) {
            iA = i;
        }
        ViewGroup customAdContainer = baseAd != null ? baseAd.getCustomAdContainer() : null;
        if (customAdContainer != null) {
            ViewGroup.LayoutParams layoutParams2 = customAdContainer.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(iA, iA2);
            } else {
                layoutParams2.width = iA;
                layoutParams2.height = iA2;
            }
            customAdContainer.setLayoutParams(layoutParams2);
            removeAllViews();
            if (customAdContainer instanceof FrameLayout) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iA, iA2);
                layoutParams3.gravity = 17;
                layoutParams = layoutParams3;
            } else {
                layoutParams = new ViewGroup.LayoutParams(iA, iA2);
            }
            this.d.setLayoutParams(layoutParams);
            al.a((View) customAdContainer);
            customAdContainer.addView(this.d);
            if (customAdContainer.getParent() != null) {
                ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            addView(customAdContainer);
        }
        a(this.d);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int a(Context context) {
        String str = this.y;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -559799608:
                if (str.equals(y.c)) {
                    b = 0;
                }
                break;
            case 1507809730:
                if (str.equals(y.a)) {
                    b = 1;
                }
                break;
            case 1507809854:
                if (str.equals(y.b)) {
                    b = 2;
                }
                break;
            case 1622564786:
                if (str.equals(y.d)) {
                    b = 3;
                }
                break;
        }
        float f = 320.0f;
        switch (b) {
            case 0:
                f = 300.0f;
                break;
            case 3:
                f = 728.0f;
                break;
        }
        return p.a(context, f);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int b(Context context) {
        String str = this.y;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -559799608:
                if (str.equals(y.c)) {
                    b = 0;
                }
                break;
            case 1507809730:
                if (str.equals(y.a)) {
                    b = 1;
                }
                break;
            case 1507809854:
                if (str.equals(y.b)) {
                    b = 2;
                }
                break;
            case 1622564786:
                if (str.equals(y.d)) {
                    b = 3;
                }
                break;
        }
        float f = 50.0f;
        switch (b) {
            case 0:
                f = 250.0f;
                break;
            case 2:
            case 3:
                f = 90.0f;
                break;
        }
        return p.a(context, f);
    }

    public int getClickedArea() {
        com.anythink.core.common.inner.mixad.f.b bVar = this.z;
        return bVar != null ? bVar.a() : com.anythink.core.common.inner.mixad.f.b.a;
    }

    @Override // com.anythink.core.common.k.e.a.d
    public void destroyNativeAd() {
        com.anythink.core.common.k.g.d dVar = this.l;
        if (dVar != null) {
            dVar.clear(this.d);
            this.l.destroy();
        }
    }

    private void k() {
        ArrayList arrayList = new ArrayList();
        if (this.n != null) {
            arrayList.add(this.m);
        }
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        this.z = new com.anythink.core.common.inner.mixad.f.b.a().a(arrayList).a(this.p).b(this.q).c(this.r).a();
    }

    private boolean l() {
        return this.l.isNativeExpress();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0160  */
    /* JADX WARN: Code duplicated, block: B:6:0x0055  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: switch over string: strings are not added: [[320x50]] */
    private void f() {
        float f;
        String str;
        byte b;
        byte b2;
        float f2;
        ViewGroup.LayoutParams layoutParams;
        float f3 = 50.0f;
        if (this.l.isNativeExpress()) {
            this.d = (ViewGroup) LayoutInflater.from(this.A).inflate(p.a(getContext(), "myoffer_banner_ad_layout_template", "layout"), (ViewGroup) this, false);
            int iA = p.a(getContext(), 320.0f);
            int iA2 = p.a(getContext(), 50.0f);
            String str2 = this.y;
            str2.hashCode();
            switch (str2) {
                case "300x250":
                    iA = p.a(getContext(), 300.0f);
                    f = 250.0f;
                    iA2 = p.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = p.a(getContext(), 320.0f);
                    iA2 = p.a(getContext(), 50.0f);
                    f = 250.0f;
                    break;
                case "320x90":
                    iA = p.a(getContext(), 320.0f);
                    iA2 = p.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                case "728x90":
                    iA = p.a(getContext(), 720.0f);
                    iA2 = p.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                default:
                    f = 250.0f;
                    break;
            }
            this.d.setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            addView(this.d);
            FrameLayout frameLayout = (FrameLayout) findViewById(p.a(getContext(), "myoffer_banner_template_view", "id"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            View adMediaView = this.l.getAdMediaView(frameLayout);
            this.u = adMediaView;
            if (adMediaView != null) {
                if (adMediaView.getParent() != null) {
                    ((ViewGroup) this.u.getParent()).removeView(this.u);
                }
                frameLayout.addView(this.u, layoutParams2);
            }
            CloseImageView closeImageView = (CloseImageView) findViewById(p.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView;
            if (closeImageView != null) {
                if (this.w) {
                    closeImageView.setVisibility(0);
                } else {
                    closeImageView.setVisibility(8);
                }
            }
            b = 1;
        } else {
            f = 250.0f;
            this.d = new FrameLayout(this.A);
            String str3 = this.y;
            str3.hashCode();
            switch (str3) {
                case "300x250":
                    str = "myoffer_banner_native_ad_layout_300x250";
                    break;
                case "320x90":
                    com.anythink.core.common.k.g.d dVar = this.l;
                    if (dVar.getAdMediaView(this) == null && TextUtils.isEmpty(dVar.getMainImageUrl())) {
                        str = "myoffer_banner_native_ad_layout_no_main_res_320x90";
                        break;
                    } else {
                        str = "myoffer_banner_native_ad_layout_320x90";
                        break;
                    }
                    break;
                case "728x90":
                    str = "myoffer_banner_native_ad_layout_728x90";
                    break;
                default:
                    str = "myoffer_banner_native_ad_layout_320x50";
                    break;
            }
            this.d.addView((ViewGroup) LayoutInflater.from(this.A).inflate(p.a(getContext(), str, "layout"), (ViewGroup) this, false));
            addView(this.d);
            this.m = (FrameLayout) findViewById(p.a(getContext(), "myoffer_main_resouce_container", "id"));
            this.n = (FrameLayout) findViewById(p.a(getContext(), "myoffer_banner_icon_container", "id"));
            this.o = (LinearLayout) findViewById(p.a(getContext(), "ll_title_desc", "id"));
            this.s = (RoundImageView) findViewById(p.a(getContext(), "myoffer_banner_icon", "id"));
            this.p = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_title", "id"));
            this.q = (TextView) findViewById(p.a(getContext(), "myoffer_banner_desc", "id"));
            this.r = (ScanningAnimButton) findViewById(p.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
            this.x = (TextView) findViewById(p.a(getContext(), "myoffer_banner_ad_from", "id"));
            CloseImageView closeImageView2 = (CloseImageView) findViewById(p.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView2;
            a(this.x, this.l.getAdFrom());
            if (closeImageView2 != null) {
                if (this.w) {
                    closeImageView2.setVisibility(0);
                } else {
                    closeImageView2.setVisibility(8);
                }
            }
            View adIconView = this.l.getAdIconView();
            this.t = adIconView;
            if (adIconView != null) {
                if (adIconView.getParent() != null && (this.t.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.t.getParent()).removeView(this.t);
                }
                this.n.removeAllViews();
                this.n.addView(this.t, new FrameLayout.LayoutParams(-1, -1));
            } else if (!TextUtils.isEmpty(this.g.l()) && this.s != null) {
                this.n.setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = this.n.getLayoutParams();
                this.s.setRadiusInDip(6);
                this.s.setNeedRadiu(true);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.l()), layoutParams3.width, layoutParams3.height, new AnonymousClass1());
            } else {
                FrameLayout frameLayout2 = this.n;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
            }
            a(this.p, this.g.j());
            String strO = this.g.o();
            a(this.r, strO);
            if (TextUtils.isEmpty(strO)) {
                ScanningAnimButton scanningAnimButton = this.r;
                if (scanningAnimButton != null) {
                    scanningAnimButton.setVisibility(8);
                }
            } else {
                ScanningAnimButton scanningAnimButton2 = this.r;
                if (scanningAnimButton2 != null) {
                    scanningAnimButton2.setVisibility(0);
                }
            }
            a(this.q, this.g.k());
            if (this.m != null) {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 17;
                this.u = this.l.getAdMediaView(this.m);
                String mainImageUrl = this.l.getMainImageUrl();
                if (this.u != null) {
                    this.m.setVisibility(0);
                    if (this.u.getParent() != null) {
                        ((ViewGroup) this.u.getParent()).removeView(this.u);
                    }
                    this.m.addView(this.u, layoutParams4);
                } else if (!TextUtils.isEmpty(mainImageUrl)) {
                    this.m.setVisibility(0);
                    RoundImageView roundImageView = new RoundImageView(getContext());
                    this.m.addView(roundImageView, layoutParams4);
                    b = 1;
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, mainImageUrl), new AnonymousClass2(mainImageUrl, roundImageView));
                } else {
                    b = 1;
                    this.m.setVisibility(8);
                }
                View adLogoView = this.l.getAdLogoView();
                this.c = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
                this.c.a(adLogoView);
                this.c.b(this);
            }
            b = 1;
            View adLogoView2 = this.l.getAdLogoView();
            this.c = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
            this.c.a(adLogoView2);
            this.c.b(this);
        }
        b();
        com.anythink.core.common.k.g.d dVar2 = this.l;
        if (this.d != null) {
            Context context = getContext();
            String str4 = this.y;
            str4.hashCode();
            switch (str4.hashCode()) {
                case -559799608:
                    if (str4.equals(y.c)) {
                        b2 = 0;
                    }
                    break;
                case 1507809730:
                    if (str4.equals(y.a)) {
                        b2 = b;
                    }
                    break;
                case 1507809854:
                    if (str4.equals(y.b)) {
                        b2 = 2;
                    }
                    break;
                case 1622564786:
                    if (str4.equals(y.d)) {
                        b2 = 3;
                    }
                    break;
                default:
                    break;
            }
            switch (b2) {
                case 0:
                    f2 = 300.0f;
                    break;
                case 1:
                case 2:
                default:
                    f2 = 320.0f;
                    break;
                case 3:
                    f2 = 728.0f;
                    break;
            }
            int iA3 = p.a(context, f2);
            String str5 = this.y;
            str5.hashCode();
            switch (str5) {
                case "300x250":
                    f3 = f;
                    break;
                case "320x90":
                case "728x90":
                    f3 = 90.0f;
                    break;
            }
            int iA4 = p.a(context, f3);
            int i = getResources().getDisplayMetrics().widthPixels;
            if (iA3 > i) {
                iA3 = i;
            }
            ViewGroup customAdContainer = dVar2 != null ? dVar2.getCustomAdContainer() : null;
            if (customAdContainer != null) {
                ViewGroup.LayoutParams layoutParams5 = customAdContainer.getLayoutParams();
                if (layoutParams5 == null) {
                    layoutParams5 = new ViewGroup.LayoutParams(iA3, iA4);
                } else {
                    layoutParams5.width = iA3;
                    layoutParams5.height = iA4;
                }
                customAdContainer.setLayoutParams(layoutParams5);
                removeAllViews();
                if (customAdContainer instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(iA3, iA4);
                    layoutParams6.gravity = 17;
                    layoutParams = layoutParams6;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(iA3, iA4);
                }
                this.d.setLayoutParams(layoutParams);
                al.a((View) customAdContainer);
                customAdContainer.addView(this.d);
                if (customAdContainer.getParent() != null) {
                    ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                }
                addView(customAdContainer);
            }
            a(this.d);
        }
    }
}
