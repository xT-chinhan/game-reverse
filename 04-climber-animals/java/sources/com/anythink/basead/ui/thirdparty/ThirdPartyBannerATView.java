package com.anythink.basead.ui.thirdparty;

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
import com.anythink.basead.ui.BaseBannerATView;
import com.anythink.basead.ui.CloseImageView;
import com.anythink.basead.ui.ScanningAnimButton;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.l.e.a.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyBannerATView extends BaseBannerATView implements d {
    private ViewGroup A;
    private com.anythink.core.common.l.g.d B;
    private FrameLayout C;
    private FrameLayout D;
    private LinearLayout E;
    private TextView F;
    private TextView G;
    private ScanningAnimButton H;
    private RoundImageView I;
    private View J;
    private View K;
    private List<Integer> L;
    private boolean M;
    private TextView N;
    private String O;
    private com.anythink.basead.mixad.f.b P;
    private Context Q;

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, Runnable runnable) {
    }

    public ThirdPartyBannerATView(Context context) {
        super(context);
        this.M = false;
        this.O = "";
        this.Q = context;
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
    public ThirdPartyBannerATView(Context context, BaseAd baseAd, x xVar, w<?> wVar, com.anythink.basead.g.a aVar) {
        float f;
        String str;
        byte b;
        byte b2;
        byte b3;
        float f2;
        ViewGroup.LayoutParams layoutParams;
        super(context, xVar, wVar, aVar);
        byte b4 = 0;
        this.M = false;
        this.O = "";
        if (baseAd instanceof com.anythink.core.common.l.g.d) {
            this.B = (com.anythink.core.common.l.g.d) baseAd;
        }
        com.anythink.core.common.l.g.d dVar = this.B;
        if (dVar == null || wVar == null || xVar == null) {
            return;
        }
        this.Q = context;
        this.M = dVar.p();
        this.L = new ArrayList();
        if (!this.B.isNativeExpress()) {
            for (int i : this.B.h()) {
                this.L.add(Integer.valueOf(i));
            }
        }
        this.O = this.B.n();
        float f3 = 50.0f;
        if (this.B.isNativeExpress()) {
            this.A = (ViewGroup) LayoutInflater.from(this.Q).inflate(q.a(getContext(), "myoffer_banner_ad_layout_template", "layout"), (ViewGroup) this, false);
            int iA = q.a(getContext(), 320.0f);
            int iA2 = q.a(getContext(), 50.0f);
            String str2 = this.O;
            str2.hashCode();
            switch (str2) {
                case "300x250":
                    iA = q.a(getContext(), 300.0f);
                    f = 250.0f;
                    iA2 = q.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 50.0f);
                    f = 250.0f;
                    break;
                case "320x90":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                case "728x90":
                    iA = q.a(getContext(), 720.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                default:
                    f = 250.0f;
                    break;
            }
            this.A.setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            addView(this.A);
            FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_template_view", "id"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            View adMediaView = this.B.getAdMediaView(frameLayout);
            this.K = adMediaView;
            if (adMediaView != null) {
                if (adMediaView.getParent() != null) {
                    ((ViewGroup) this.K.getParent()).removeView(this.K);
                }
                frameLayout.addView(this.K, layoutParams2);
            }
            CloseImageView closeImageView = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView;
            if (closeImageView != null) {
                if (this.M) {
                    closeImageView.setVisibility(0);
                } else {
                    closeImageView.setVisibility(8);
                }
            }
            b = 1;
            b2 = -1;
        } else {
            f = 250.0f;
            this.A = new FrameLayout(this.Q);
            String str3 = this.O;
            str3.hashCode();
            switch (str3) {
                case "300x250":
                    str = "myoffer_banner_native_ad_layout_300x250";
                    break;
                case "320x90":
                    com.anythink.core.common.l.g.d dVar2 = this.B;
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
            this.A.addView((ViewGroup) LayoutInflater.from(this.Q).inflate(q.a(getContext(), str, "layout"), (ViewGroup) this, false));
            addView(this.A);
            this.C = (FrameLayout) findViewById(q.a(getContext(), "myoffer_main_resouce_container", "id"));
            this.D = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_icon_container", "id"));
            this.E = (LinearLayout) findViewById(q.a(getContext(), "ll_title_desc", "id"));
            this.I = (RoundImageView) findViewById(q.a(getContext(), "myoffer_banner_icon", "id"));
            this.F = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
            this.G = (TextView) findViewById(q.a(getContext(), "myoffer_banner_desc", "id"));
            this.H = (ScanningAnimButton) findViewById(q.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
            this.N = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_from", "id"));
            CloseImageView closeImageView2 = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView2;
            ScanningAnimButton scanningAnimButton = this.H;
            if (scanningAnimButton != null) {
                scanningAnimButton.startAnimation(1);
            }
            a(this.N, this.B.getAdFrom());
            if (closeImageView2 != null) {
                if (this.M) {
                    closeImageView2.setVisibility(0);
                } else {
                    closeImageView2.setVisibility(8);
                }
            }
            View adIconView = this.B.getAdIconView();
            this.J = adIconView;
            if (adIconView != null) {
                if (adIconView.getParent() != null && (this.J.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.J.getParent()).removeView(this.J);
                }
                this.D.removeAllViews();
                this.D.addView(this.J, new FrameLayout.LayoutParams(-1, -1));
            } else if (!TextUtils.isEmpty(this.g.z()) && this.I != null) {
                this.D.setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
                this.I.setRadiusInDip(6);
                this.I.setNeedRadiu(true);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), layoutParams3.width, layoutParams3.height, new AnonymousClass1());
            } else {
                FrameLayout frameLayout2 = this.D;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
            }
            a(this.F, this.g.x());
            String strD = this.g.D();
            a(this.H, strD);
            if (TextUtils.isEmpty(strD)) {
                ScanningAnimButton scanningAnimButton2 = this.H;
                if (scanningAnimButton2 != null) {
                    scanningAnimButton2.setVisibility(8);
                }
            } else {
                ScanningAnimButton scanningAnimButton3 = this.H;
                if (scanningAnimButton3 != null) {
                    scanningAnimButton3.setVisibility(0);
                }
            }
            a(this.G, this.g.y());
            if (this.C != null) {
                b2 = -1;
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 17;
                this.K = this.B.getAdMediaView(this.C);
                String mainImageUrl = this.B.getMainImageUrl();
                if (this.K != null) {
                    this.C.setVisibility(0);
                    if (this.K.getParent() != null) {
                        ((ViewGroup) this.K.getParent()).removeView(this.K);
                    }
                    this.C.addView(this.K, layoutParams4);
                    b = 1;
                } else if (!TextUtils.isEmpty(mainImageUrl)) {
                    this.C.setVisibility(0);
                    RoundImageView roundImageView = new RoundImageView(getContext());
                    this.C.addView(roundImageView, layoutParams4);
                    b = 1;
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, mainImageUrl), new AnonymousClass2(mainImageUrl, roundImageView));
                } else {
                    b = 1;
                    this.C.setVisibility(8);
                }
            } else {
                b = 1;
                b2 = -1;
            }
            View adLogoView = this.B.getAdLogoView();
            this.d = new com.anythink.basead.ui.f.a(this.g, this.f);
            this.d.a(adLogoView);
            this.d.b(this);
        }
        c();
        com.anythink.core.common.l.g.d dVar3 = this.B;
        if (this.A != null) {
            Context context2 = getContext();
            String str4 = this.O;
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
            int iA3 = q.a(context2, f2);
            String str5 = this.O;
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
            int iA4 = q.a(context2, f3);
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
                this.A.setLayoutParams(layoutParams);
                am.a(customAdContainer);
                customAdContainer.addView(this.A);
                if (customAdContainer.getParent() != null) {
                    ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                }
                addView(customAdContainer);
            }
            b(this.A);
        }
        if (this.B.isNativeExpress()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (this.D != null) {
            arrayList.add(this.C);
        }
        FrameLayout frameLayout3 = this.D;
        if (frameLayout3 != null) {
            arrayList.add(frameLayout3);
        }
        this.P = new com.anythink.basead.mixad.f.b.a().a(arrayList).a(this.F).b(this.G).c(this.H).a();
    }

    private void d() {
        this.M = this.B.p();
        this.L = new ArrayList();
        if (!this.B.isNativeExpress()) {
            for (int i : this.B.h()) {
                this.L.add(Integer.valueOf(i));
            }
        }
        this.O = this.B.n();
    }

    private void x() {
        byte b = 0;
        this.A = (ViewGroup) LayoutInflater.from(this.Q).inflate(q.a(getContext(), "myoffer_banner_ad_layout_template", "layout"), (ViewGroup) this, false);
        int iA = q.a(getContext(), 320.0f);
        int iA2 = q.a(getContext(), 50.0f);
        String str = this.O;
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
                iA = q.a(getContext(), 300.0f);
                iA2 = q.a(getContext(), 250.0f);
                break;
            case 1:
                iA = q.a(getContext(), 320.0f);
                iA2 = q.a(getContext(), 50.0f);
                break;
            case 2:
                iA = q.a(getContext(), 320.0f);
                iA2 = q.a(getContext(), 90.0f);
                break;
            case 3:
                iA = q.a(getContext(), 720.0f);
                iA2 = q.a(getContext(), 90.0f);
                break;
        }
        this.A.setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
        addView(this.A);
    }

    private void y() {
        String str;
        this.A = new FrameLayout(this.Q);
        String str2 = this.O;
        str2.hashCode();
        switch (str2) {
            case "300x250":
                str = "myoffer_banner_native_ad_layout_300x250";
                break;
            case "320x90":
                com.anythink.core.common.l.g.d dVar = this.B;
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
        this.A.addView((ViewGroup) LayoutInflater.from(this.Q).inflate(q.a(getContext(), str, "layout"), (ViewGroup) this, false));
        addView(this.A);
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
    private void z() {
        FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_template_view", "id"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        View adMediaView = this.B.getAdMediaView(frameLayout);
        this.K = adMediaView;
        if (adMediaView != null) {
            if (adMediaView.getParent() != null) {
                ((ViewGroup) this.K.getParent()).removeView(this.K);
            }
            frameLayout.addView(this.K, layoutParams);
        }
        CloseImageView closeImageView = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        this.b = closeImageView;
        if (closeImageView != null) {
            if (this.M) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
    }

    private void A() {
        this.C = (FrameLayout) findViewById(q.a(getContext(), "myoffer_main_resouce_container", "id"));
        this.D = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_icon_container", "id"));
        this.E = (LinearLayout) findViewById(q.a(getContext(), "ll_title_desc", "id"));
        this.I = (RoundImageView) findViewById(q.a(getContext(), "myoffer_banner_icon", "id"));
        this.F = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.G = (TextView) findViewById(q.a(getContext(), "myoffer_banner_desc", "id"));
        this.H = (ScanningAnimButton) findViewById(q.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.N = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_from", "id"));
        CloseImageView closeImageView = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
        this.b = closeImageView;
        ScanningAnimButton scanningAnimButton = this.H;
        if (scanningAnimButton != null) {
            scanningAnimButton.startAnimation(1);
        }
        a(this.N, this.B.getAdFrom());
        if (closeImageView != null) {
            if (this.M) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
        View adIconView = this.B.getAdIconView();
        this.J = adIconView;
        if (adIconView != null) {
            if (adIconView.getParent() != null && (this.J.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.J.getParent()).removeView(this.J);
            }
            this.D.removeAllViews();
            this.D.addView(this.J, new FrameLayout.LayoutParams(-1, -1));
        } else if (!TextUtils.isEmpty(this.g.z()) && this.I != null) {
            this.D.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
            this.I.setRadiusInDip(6);
            this.I.setNeedRadiu(true);
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), layoutParams.width, layoutParams.height, new AnonymousClass1());
        } else {
            FrameLayout frameLayout = this.D;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        a(this.F, this.g.x());
        String strD = this.g.D();
        a(this.H, strD);
        if (TextUtils.isEmpty(strD)) {
            ScanningAnimButton scanningAnimButton2 = this.H;
            if (scanningAnimButton2 != null) {
                scanningAnimButton2.setVisibility(8);
            }
        } else {
            ScanningAnimButton scanningAnimButton3 = this.H;
            if (scanningAnimButton3 != null) {
                scanningAnimButton3.setVisibility(0);
            }
        }
        a(this.G, this.g.y());
        if (this.C != null) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            this.K = this.B.getAdMediaView(this.C);
            String mainImageUrl = this.B.getMainImageUrl();
            if (this.K != null) {
                this.C.setVisibility(0);
                if (this.K.getParent() != null) {
                    ((ViewGroup) this.K.getParent()).removeView(this.K);
                }
                this.C.addView(this.K, layoutParams2);
            } else if (!TextUtils.isEmpty(mainImageUrl)) {
                this.C.setVisibility(0);
                RoundImageView roundImageView = new RoundImageView(getContext());
                this.C.addView(roundImageView, layoutParams2);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, mainImageUrl), new AnonymousClass2(mainImageUrl, roundImageView));
            } else {
                this.C.setVisibility(8);
            }
        }
        View adLogoView = this.B.getAdLogoView();
        this.d = new com.anythink.basead.ui.f.a(this.g, this.f);
        this.d.a(adLogoView);
        this.d.b(this);
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.thirdparty.ThirdPartyBannerATView$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        @Override // com.anythink.core.common.res.b.a
        public final void onFail(String str, String str2) {
        }

        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(String str, Bitmap bitmap) {
            if (TextUtils.equals(ThirdPartyBannerATView.this.g.z(), str)) {
                ThirdPartyBannerATView.this.I.setImageBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.thirdparty.ThirdPartyBannerATView$2, reason: invalid class name */
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

    private void b(View view) {
        RoundImageView roundImageView;
        int i = this.f.f;
        FrameLayout.LayoutParams layoutParamsA = com.anythink.basead.mixad.f.a.a(i, a(32.0f), a(8.0f));
        com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        int[] iArrH = this.B.h();
        if (iArrH == null) {
            c(this);
        } else {
            for (int i2 : iArrH) {
                if (i2 == 1) {
                    View view2 = this.J;
                    if (view2 != null) {
                        c(view2);
                        bVar.b(this.J);
                    } else if (!TextUtils.isEmpty(this.B.getIconImageUrl()) && (roundImageView = this.I) != null) {
                        c(roundImageView);
                        bVar.b(this.I);
                    }
                    c(this.K);
                    View view3 = this.K;
                    if (view3 != null) {
                        bVar.c(view3);
                    }
                } else if (i2 == 2) {
                    c(this.F);
                    bVar.a(this.F);
                } else if (i2 == 3) {
                    c(this.G);
                    bVar.d(this.G);
                } else if (i2 == 4) {
                    c(this.H);
                    bVar.e(this.H);
                } else if (i2 == 5) {
                    c(this);
                }
            }
        }
        if (this.b != null) {
            bVar.i(this.b);
        }
        if (this.d != null && i == 34) {
            bVar.f(this.N);
            this.d.a(this.B, bVar, false);
        }
        com.anythink.core.common.l.g.d dVar = this.B;
        if (dVar != null) {
            dVar.registerListener(view, this.n, layoutParamsA, bVar);
        }
    }

    private void c(View view) {
        if (view != null) {
            this.n.add(view);
        }
    }

    private int a(float f) {
        return q.a(getContext(), f);
    }

    @Override // com.anythink.basead.ui.BaseBannerATView, com.anythink.basead.ui.BaseATView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.basead.mixad.f.b bVar = this.P;
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
        if (this.A == null) {
            return;
        }
        Context context = getContext();
        String str = this.O;
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
        int iA = q.a(context, f);
        String str2 = this.O;
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
        int iA2 = q.a(context, f2);
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
            this.A.setLayoutParams(layoutParams);
            am.a(customAdContainer);
            customAdContainer.addView(this.A);
            if (customAdContainer.getParent() != null) {
                ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            addView(customAdContainer);
        }
        b(this.A);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int a(Context context) {
        String str = this.O;
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
        return q.a(context, f);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int b(Context context) {
        String str = this.O;
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
        return q.a(context, f);
    }

    public int getClickedArea() {
        com.anythink.basead.mixad.f.b bVar = this.P;
        return bVar != null ? bVar.a() : com.anythink.basead.mixad.f.b.a;
    }

    @Override // com.anythink.core.common.l.e.a.d
    public void destroyNativeAd() {
        com.anythink.core.common.l.g.d dVar = this.B;
        if (dVar != null) {
            dVar.clear(this.A);
            this.B.destroy();
        }
    }

    private void B() {
        ArrayList arrayList = new ArrayList();
        if (this.D != null) {
            arrayList.add(this.C);
        }
        FrameLayout frameLayout = this.D;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        this.P = new com.anythink.basead.mixad.f.b.a().a(arrayList).a(this.F).b(this.G).c(this.H).a();
    }

    private boolean C() {
        return this.B.isNativeExpress();
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
    private void w() {
        float f;
        String str;
        byte b;
        byte b2;
        float f2;
        ViewGroup.LayoutParams layoutParams;
        float f3 = 50.0f;
        if (this.B.isNativeExpress()) {
            this.A = (ViewGroup) LayoutInflater.from(this.Q).inflate(q.a(getContext(), "myoffer_banner_ad_layout_template", "layout"), (ViewGroup) this, false);
            int iA = q.a(getContext(), 320.0f);
            int iA2 = q.a(getContext(), 50.0f);
            String str2 = this.O;
            str2.hashCode();
            switch (str2) {
                case "300x250":
                    iA = q.a(getContext(), 300.0f);
                    f = 250.0f;
                    iA2 = q.a(getContext(), 250.0f);
                    break;
                case "320x50":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 50.0f);
                    f = 250.0f;
                    break;
                case "320x90":
                    iA = q.a(getContext(), 320.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                case "728x90":
                    iA = q.a(getContext(), 720.0f);
                    iA2 = q.a(getContext(), 90.0f);
                    f = 250.0f;
                    break;
                default:
                    f = 250.0f;
                    break;
            }
            this.A.setLayoutParams(new ViewGroup.LayoutParams(Math.min(iA, getResources().getDisplayMetrics().widthPixels), iA2));
            addView(this.A);
            FrameLayout frameLayout = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_template_view", "id"));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            View adMediaView = this.B.getAdMediaView(frameLayout);
            this.K = adMediaView;
            if (adMediaView != null) {
                if (adMediaView.getParent() != null) {
                    ((ViewGroup) this.K.getParent()).removeView(this.K);
                }
                frameLayout.addView(this.K, layoutParams2);
            }
            CloseImageView closeImageView = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView;
            if (closeImageView != null) {
                if (this.M) {
                    closeImageView.setVisibility(0);
                } else {
                    closeImageView.setVisibility(8);
                }
            }
            b = 1;
        } else {
            f = 250.0f;
            this.A = new FrameLayout(this.Q);
            String str3 = this.O;
            str3.hashCode();
            switch (str3) {
                case "300x250":
                    str = "myoffer_banner_native_ad_layout_300x250";
                    break;
                case "320x90":
                    com.anythink.core.common.l.g.d dVar = this.B;
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
            this.A.addView((ViewGroup) LayoutInflater.from(this.Q).inflate(q.a(getContext(), str, "layout"), (ViewGroup) this, false));
            addView(this.A);
            this.C = (FrameLayout) findViewById(q.a(getContext(), "myoffer_main_resouce_container", "id"));
            this.D = (FrameLayout) findViewById(q.a(getContext(), "myoffer_banner_icon_container", "id"));
            this.E = (LinearLayout) findViewById(q.a(getContext(), "ll_title_desc", "id"));
            this.I = (RoundImageView) findViewById(q.a(getContext(), "myoffer_banner_icon", "id"));
            this.F = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_title", "id"));
            this.G = (TextView) findViewById(q.a(getContext(), "myoffer_banner_desc", "id"));
            this.H = (ScanningAnimButton) findViewById(q.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
            this.N = (TextView) findViewById(q.a(getContext(), "myoffer_banner_ad_from", "id"));
            CloseImageView closeImageView2 = (CloseImageView) findViewById(q.a(getContext(), "myoffer_banner_close", "id"));
            this.b = closeImageView2;
            ScanningAnimButton scanningAnimButton = this.H;
            if (scanningAnimButton != null) {
                scanningAnimButton.startAnimation(1);
            }
            a(this.N, this.B.getAdFrom());
            if (closeImageView2 != null) {
                if (this.M) {
                    closeImageView2.setVisibility(0);
                } else {
                    closeImageView2.setVisibility(8);
                }
            }
            View adIconView = this.B.getAdIconView();
            this.J = adIconView;
            if (adIconView != null) {
                if (adIconView.getParent() != null && (this.J.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.J.getParent()).removeView(this.J);
                }
                this.D.removeAllViews();
                this.D.addView(this.J, new FrameLayout.LayoutParams(-1, -1));
            } else if (!TextUtils.isEmpty(this.g.z()) && this.I != null) {
                this.D.setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = this.D.getLayoutParams();
                this.I.setRadiusInDip(6);
                this.I.setNeedRadiu(true);
                com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.g.z()), layoutParams3.width, layoutParams3.height, new AnonymousClass1());
            } else {
                FrameLayout frameLayout2 = this.D;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
            }
            a(this.F, this.g.x());
            String strD = this.g.D();
            a(this.H, strD);
            if (TextUtils.isEmpty(strD)) {
                ScanningAnimButton scanningAnimButton2 = this.H;
                if (scanningAnimButton2 != null) {
                    scanningAnimButton2.setVisibility(8);
                }
            } else {
                ScanningAnimButton scanningAnimButton3 = this.H;
                if (scanningAnimButton3 != null) {
                    scanningAnimButton3.setVisibility(0);
                }
            }
            a(this.G, this.g.y());
            if (this.C != null) {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 17;
                this.K = this.B.getAdMediaView(this.C);
                String mainImageUrl = this.B.getMainImageUrl();
                if (this.K != null) {
                    this.C.setVisibility(0);
                    if (this.K.getParent() != null) {
                        ((ViewGroup) this.K.getParent()).removeView(this.K);
                    }
                    this.C.addView(this.K, layoutParams4);
                } else if (!TextUtils.isEmpty(mainImageUrl)) {
                    this.C.setVisibility(0);
                    RoundImageView roundImageView = new RoundImageView(getContext());
                    this.C.addView(roundImageView, layoutParams4);
                    b = 1;
                    com.anythink.core.common.res.b.a(getContext()).a(new e(1, mainImageUrl), new AnonymousClass2(mainImageUrl, roundImageView));
                } else {
                    b = 1;
                    this.C.setVisibility(8);
                }
                View adLogoView = this.B.getAdLogoView();
                this.d = new com.anythink.basead.ui.f.a(this.g, this.f);
                this.d.a(adLogoView);
                this.d.b(this);
            }
            b = 1;
            View adLogoView2 = this.B.getAdLogoView();
            this.d = new com.anythink.basead.ui.f.a(this.g, this.f);
            this.d.a(adLogoView2);
            this.d.b(this);
        }
        c();
        com.anythink.core.common.l.g.d dVar2 = this.B;
        if (this.A != null) {
            Context context = getContext();
            String str4 = this.O;
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
            int iA3 = q.a(context, f2);
            String str5 = this.O;
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
            int iA4 = q.a(context, f3);
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
                this.A.setLayoutParams(layoutParams);
                am.a(customAdContainer);
                customAdContainer.addView(this.A);
                if (customAdContainer.getParent() != null) {
                    ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                }
                addView(customAdContainer);
            }
            b(this.A);
        }
    }
}
