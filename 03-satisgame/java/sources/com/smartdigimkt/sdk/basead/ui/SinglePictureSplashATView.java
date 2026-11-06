package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.api.loader.KsDexEncryptHelper;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b2.f;
import com.smartdigimkt.b2.g0;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.i3.m;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.n1.u5;
import com.smartdigimkt.n1.x5;
import com.smartdigimkt.n1.y5;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SinglePictureSplashATView extends BaseSdkSplashATView {
    public static final /* synthetic */ int n0 = 0;
    public boolean m0;

    public SinglePictureSplashATView(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView, com.smartdigimkt.sdk.basead.ui.BaseSplashATView
    public void beforeSplashEndCardShow() {
        this.m0 = false;
        super.beforeSplashEndCardShow();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void f() {
        View viewInflate = this.b.s.m == 2 ? LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_single_land", "layout"), this) : LayoutInflater.from(getContext()).inflate(k.a(getContext(), "myoffer_splash_ad_layout_single_port", "layout"), this);
        r();
        r rVar = this.T;
        if (rVar != null) {
            rVar.c = KsDexEncryptHelper.DECRYPT_ERROR_IO;
            rVar.l = new u5(this);
            rVar.a(getContext(), viewInflate);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public List<View> getAutoClickCTAViews() {
        g0 g0Var;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(2);
        e0 e0Var = this.o;
        if (e0Var != null && (arrayList = e0Var.e) != null && arrayList.size() > 0) {
            Iterator it = e0Var.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    g0Var = null;
                    break;
                }
                f fVar = (f) it.next();
                if (fVar instanceof g0) {
                    g0Var = (g0) fVar;
                    break;
                }
            }
        } else {
            g0Var = null;
            break;
        }
        if (g0Var != null) {
            arrayList2.add(g0Var.i);
        }
        arrayList2.add(this.m);
        return arrayList2;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void q() {
        this.l0 = true;
        m.a(getContext()).a(new o(1, this.c.f), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new x5(this));
    }

    public void restoreCtaAfterShake() {
        if (!this.m0 || this.m == null) {
            return;
        }
        this.m0 = false;
        String string = getContext().getString(c0.a(getContext(), this.c));
        View view = this.m;
        if (view instanceof CTAButtonLayout) {
            ((CTAButtonLayout) view).setMajorCTAText(string);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(string);
        }
        this.m.setVisibility(0);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public void s() {
        View view;
        this.m = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
        if (this.c.e() == 4) {
            try {
                View directlySplashCTAButton = SDMSDK.getInstance().getDirectlyOfferSetting().getDirectlySplashCTAButton();
                if (directlySplashCTAButton != null) {
                    try {
                        int iIndexOfChild = indexOfChild(this.m);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                        this.m.setVisibility(8);
                        this.m = directlySplashCTAButton;
                        if (directlySplashCTAButton.getLayoutParams() != null && (directlySplashCTAButton.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                            layoutParams = (RelativeLayout.LayoutParams) directlySplashCTAButton.getLayoutParams();
                        }
                        d.a(directlySplashCTAButton);
                        addView(directlySplashCTAButton, iIndexOfChild, layoutParams);
                        SDKContext.getInstance().getClass();
                    } catch (Throwable unused) {
                        this.m = findViewById(k.a(getContext(), "myoffer_splash_ad_cta_layout", "id"));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        a aVar = this.b;
        if (aVar.s == null || (view = this.m) == null) {
            return;
        }
        if (view instanceof CTAButtonLayout) {
            ((CTAButtonLayout) view).initSetting(this.c, aVar, false, null);
        } else if (view instanceof TextView) {
            if (TextUtils.isEmpty(this.c.h)) {
                ((TextView) this.m).setText(c0.a(getContext(), this.c));
            } else {
                ((TextView) this.m).setText(this.c.h);
            }
        }
        if (c0.d(this.b)) {
            this.m0 = true;
            this.m.setVisibility(8);
        }
        this.j.add(this.m);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseSdkSplashATView
    public final void t() {
        int i = this.b.s.R;
        this.A = new y5(this);
        c();
    }

    public SinglePictureSplashATView(Context context, a aVar, c cVar, com.smartdigimkt.j1.a aVar2) {
        super(context, aVar, cVar, aVar2);
    }
}
