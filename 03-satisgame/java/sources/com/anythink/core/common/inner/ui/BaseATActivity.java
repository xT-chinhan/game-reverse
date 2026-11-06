package com.anythink.core.common.inner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.basead.b.c;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.bh;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.b;
import com.anythink.core.common.inner.e.d;
import com.anythink.core.common.k.e.a.e;
import com.anythink.core.common.k.e.a.g;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.p;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
public class BaseATActivity extends Activity {
    public static final String a = "BaseATActivity";
    boolean b;
    bh c;
    d j;
    private BaseScreenATView l;
    private x m;
    private w n;
    private String o;
    private b.AbstractC0023b p;
    private String q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    long d = 0;
    long e = 0;
    float f = 0.0f;
    boolean g = false;
    boolean h = false;
    com.anythink.core.common.b.a i = new com.anythink.core.common.b.a() { // from class: com.anythink.core.common.inner.ui.BaseATActivity.1
        @Override // com.anythink.core.common.b.a
        public final void a(Object obj) {
            if (!(obj instanceof bh) || BaseATActivity.this.n == null) {
                return;
            }
            bh bhVar = (bh) obj;
            if (!bhVar.b().s().equals(BaseATActivity.this.n.s()) || BaseATActivity.this.b) {
                return;
            }
            BaseATActivity.this.c = bhVar;
        }
    };
    boolean k = false;

    public static void a(Activity activity, c cVar) {
        Intent intent = new Intent();
        Context contextG = s.b().g();
        if (activity == null || activity.isFinishing()) {
            Log.i("anythink_BaseATActivity", "Activity is null");
        } else {
            contextG = activity;
        }
        boolean zA = a(cVar.a, cVar.h);
        if (cVar.e == 2) {
            if (zA || cVar.j) {
                intent.setClass(contextG, ATLandscapeTranslucentActivity.class);
            } else {
                intent.setClass(contextG, ATLandscapeActivity.class);
            }
        } else if (zA || cVar.j) {
            intent.setClass(contextG, ATPortraitTranslucentActivity.class);
        } else {
            intent.setClass(contextG, ATPortraitActivity.class);
        }
        intent.putExtra(com.anythink.core.basead.a.C0009a.d, cVar.d);
        com.anythink.core.common.inner.ui.d.a.a().a(cVar.d, cVar);
        if (!(contextG instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        try {
            contextG.startActivity(intent);
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.overridePendingTransition(0, 0);
        } catch (Throwable th) {
            b.AbstractC0023b abstractC0023bA = b.a().a(cVar.d);
            if (abstractC0023bA != null) {
                abstractC0023bA.a(com.anythink.core.common.inner.b.b.a(com.anythink.core.common.inner.b.b.b, th.getMessage()));
            }
        }
    }

    private void a() {
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.o = intent.getStringExtra(com.anythink.core.basead.a.C0009a.d);
                c cVarA = com.anythink.core.common.inner.ui.d.a.a().a(this.o);
                if (cVarA != null) {
                    this.q = cVarA.b;
                    this.r = cVarA.a;
                    this.n = cVarA.c;
                    this.m = cVarA.h;
                }
                this.w = a(this.r, this.m);
                return;
            }
            Log.e("anythink", a + " Intent is null.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean a(int i, x xVar) {
        if (xVar == null || xVar.t == null || i != 3) {
            return false;
        }
        return TextUtils.equals("2", xVar.t.u());
    }

    private BaseScreenATView a(com.anythink.core.common.inner.mixad.c.a.a aVar, BaseAd baseAd) {
        int i = this.r;
        if ((i == 1 || i == 3) && baseAd != null) {
            boolean z = this.w;
            if (aVar != null) {
                Object objA = new com.anythink.core.common.inner.mixad.c.b(new com.anythink.core.common.inner.mixad.c.a.a.C0024a().a(aVar).a(this).a(z).a(this.q).a(this.s).a()).a();
                if (objA instanceof BaseScreenATView) {
                    this.x = objA instanceof e;
                    return (BaseScreenATView) objA;
                }
            }
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (s.b().g() == null) {
            s.b().a(getApplicationContext());
        }
        a(bundle);
        d();
        try {
            com.anythink.core.common.k.e.a.a.InterfaceC0029a interfaceC0029aB = com.anythink.core.common.inner.mixad.a.a().b(this.o);
            if (interfaceC0029aB != null) {
                interfaceC0029aB.a(this);
            }
        } catch (Throwable unused) {
        }
    }

    private void b() {
        com.anythink.core.common.k.e.a.a.InterfaceC0029a interfaceC0029aB = com.anythink.core.common.inner.mixad.a.a().b(this.o);
        if (interfaceC0029aB != null) {
            interfaceC0029aB.a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f0  */
    protected void a(Bundle bundle) {
        BaseAd baseAdA;
        BaseScreenATView baseScreenATView;
        if (this instanceof ATLandscapeActivity) {
            this.s = 2;
        } else {
            this.s = 1;
        }
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.o = intent.getStringExtra(com.anythink.core.basead.a.C0009a.d);
                c cVarA = com.anythink.core.common.inner.ui.d.a.a().a(this.o);
                if (cVarA != null) {
                    this.q = cVarA.b;
                    this.r = cVarA.a;
                    this.n = cVarA.c;
                    this.m = cVarA.h;
                }
                this.w = a(this.r, this.m);
            } else {
                Log.e("anythink", a + " Intent is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.p = b.a().a(this.o);
        x xVar = this.m;
        if (xVar == null || xVar.t == null) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            Log.e("anythink", sb.append(str).append("Start Screen Ad Error.").toString());
            try {
                b.AbstractC0023b abstractC0023b = this.p;
                if (abstractC0023b != null) {
                    abstractC0023b.a(com.anythink.core.common.inner.b.b.a(com.anythink.core.common.inner.b.b.k, str + "Start FullScreen Ad Error."));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c();
            return;
        }
        if (this.n == null) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = a;
            Log.e("anythink", sb2.append(str2).append(" onCreate: OfferAd = null").toString());
            try {
                b.AbstractC0023b abstractC0023b2 = this.p;
                if (abstractC0023b2 != null) {
                    abstractC0023b2.a(com.anythink.core.common.inner.b.b.a(com.anythink.core.common.inner.b.b.k, str2 + " onCreate: OfferAd = null"));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            c();
            return;
        }
        com.anythink.core.common.b.a().a("1", this.i);
        com.anythink.core.common.inner.mixad.c.a.a aVarA = com.anythink.core.common.inner.mixad.a.a().a(this.o);
        if (aVarA == null || aVarA.a() == null) {
            baseAdA = null;
        } else {
            ATNativeAdInfo aTNativeAdInfoA = aVarA.a();
            if (aTNativeAdInfoA instanceof g) {
                baseAdA = ((g) aTNativeAdInfoA).a();
                this.k = true;
            } else {
                baseAdA = null;
            }
        }
        int i = this.r;
        if ((i == 1 || i == 3) && baseAdA != null) {
            boolean z = this.w;
            if (aVarA != null) {
                Object objA = new com.anythink.core.common.inner.mixad.c.b(new com.anythink.core.common.inner.mixad.c.a.a.C0024a().a(aVarA).a(this).a(z).a(this.q).a(this.s).a()).a();
                if (objA instanceof BaseScreenATView) {
                    this.x = objA instanceof e;
                    baseScreenATView = (BaseScreenATView) objA;
                } else {
                    baseScreenATView = null;
                }
            } else {
                baseScreenATView = null;
            }
        } else {
            baseScreenATView = null;
        }
        this.l = baseScreenATView;
        if (baseScreenATView == null) {
            b.AbstractC0023b abstractC0023b3 = this.p;
            if (abstractC0023b3 != null) {
                abstractC0023b3.a(com.anythink.core.common.inner.b.b.a(com.anythink.core.common.inner.b.b.k, "mScreenAdView is null."));
                return;
            }
            return;
        }
        if (this.x || this.w) {
            setContentView(baseScreenATView);
        } else {
            ViewGroup customAdContainer = baseAdA != null ? baseAdA.getCustomAdContainer() : null;
            if (customAdContainer != null) {
                customAdContainer.addView(this.l);
                al.a((View) customAdContainer);
                setContentView(customAdContainer);
                this.l.handleFullScreenClick(customAdContainer);
            } else {
                setContentView(this.l);
            }
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.j = anonymousClass2;
        this.l.setListener(anonymousClass2);
        if (bundle != null) {
            this.t = bundle.getBoolean(com.anythink.core.basead.a.C0009a.f);
            this.u = bundle.getBoolean(com.anythink.core.basead.a.C0009a.g);
            this.v = bundle.getBoolean(com.anythink.core.basead.a.C0009a.j);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0009a.l);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0009a.m);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0009a.n);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0009a.h, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0009a.o, false);
        }
        this.l.setIsShowEndCard(this.t);
        this.l.setHasReward(this.v);
        if (bundle != null) {
            this.l.setVideoMute(this.u);
            this.l.setShowBannerTime(this.d);
            this.l.setHideBannerTime(this.e);
        }
        try {
            this.l.init();
        } catch (Throwable th3) {
            th3.printStackTrace();
            try {
                b.AbstractC0023b abstractC0023b4 = this.p;
                if (abstractC0023b4 != null) {
                    abstractC0023b4.a(com.anythink.core.common.inner.b.b.a(com.anythink.core.common.inner.b.b.k, p.a(th3.getStackTrace())));
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            c();
        }
    }

    private void b(Bundle bundle) {
        if (bundle != null) {
            this.t = bundle.getBoolean(com.anythink.core.basead.a.C0009a.f);
            this.u = bundle.getBoolean(com.anythink.core.basead.a.C0009a.g);
            this.v = bundle.getBoolean(com.anythink.core.basead.a.C0009a.j);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0009a.l);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0009a.m);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0009a.n);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0009a.h, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0009a.o, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseATActivity$2, reason: invalid class name */
    final class AnonymousClass2 extends d {
        @Override // com.anythink.core.common.inner.e.d
        public final void f() {
        }

        @Override // com.anythink.core.common.inner.e.d
        public final void g() {
        }

        @Override // com.anythink.core.common.inner.e.d
        public final void h() {
        }

        @Override // com.anythink.core.common.inner.e.d
        public final String i() {
            return "";
        }

        AnonymousClass2() {
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void a(com.anythink.core.common.inner.e.e eVar) {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.a(eVar);
            }
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void a(com.anythink.core.common.inner.b.a aVar) {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.a(aVar);
            }
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void a() {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.a();
            }
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void b() {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.b();
            }
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void c() {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.c();
            }
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void d() {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.a(e());
                BaseATActivity.this.p.d();
            }
            BaseATActivity.this.c();
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void b(com.anythink.core.common.inner.e.e eVar) {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.b(eVar);
            }
        }

        @Override // com.anythink.core.common.inner.e.b.AbstractC0023b
        public final void a(boolean z) {
            if (BaseATActivity.this.p != null) {
                BaseATActivity.this.p.a(z);
            }
        }
    }

    private void c(Bundle bundle) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.j = anonymousClass2;
        this.l.setListener(anonymousClass2);
        if (bundle != null) {
            this.t = bundle.getBoolean(com.anythink.core.basead.a.C0009a.f);
            this.u = bundle.getBoolean(com.anythink.core.basead.a.C0009a.g);
            this.v = bundle.getBoolean(com.anythink.core.basead.a.C0009a.j);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0009a.l);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0009a.m);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0009a.n);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0009a.h, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0009a.o, false);
        }
        this.l.setIsShowEndCard(this.t);
        this.l.setHasReward(this.v);
        if (bundle != null) {
            this.l.setVideoMute(this.u);
            this.l.setShowBannerTime(this.d);
            this.l.setHideBannerTime(this.e);
        }
        try {
            this.l.init();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                b.AbstractC0023b abstractC0023b = this.p;
                if (abstractC0023b != null) {
                    abstractC0023b.a(com.anythink.core.common.inner.b.b.a(com.anythink.core.common.inner.b.b.k, p.a(th.getStackTrace())));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            finish();
            overridePendingTransition(0, 0);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseScreenATView baseScreenATView = this.l;
        if (baseScreenATView != null) {
            if (baseScreenATView.isShowEndCard()) {
                bundle.putBoolean(com.anythink.core.basead.a.C0009a.f, true);
            }
            bundle.putBoolean(com.anythink.core.basead.a.C0009a.g, this.l.isVideoMute());
            bundle.putBoolean(com.anythink.core.basead.a.C0009a.j, this.l.hasReward());
            bundle.putLong(com.anythink.core.basead.a.C0009a.l, this.l.getShowBannerTime());
            bundle.putLong(com.anythink.core.basead.a.C0009a.m, this.l.getHideBannerTime());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                super.onResume();
            } catch (Throwable unused) {
                c();
            }
        } else {
            super.onResume();
        }
        d();
        this.b = true;
        if (this.c != null) {
            this.c = null;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            d();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.b = false;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.c = null;
        this.j = null;
        com.anythink.core.common.b.a().b("1", this.i);
        BaseScreenATView baseScreenATView = this.l;
        if (baseScreenATView != null) {
            baseScreenATView.removeAllViews();
            this.l.destroy();
            this.l = null;
        }
        w wVar = this.n;
        if (wVar != null && wVar.v() && !this.n.D()) {
            com.anythink.core.common.a.g.a().b();
        }
        if (this.m != null) {
            com.anythink.core.common.t.c.a().a(this.m.f + this.m.e);
        }
        if (!TextUtils.isEmpty(this.o)) {
            b.a().b(this.o);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (Build.VERSION.SDK_INT == 26) {
            super.setTheme(p.a(this, "myoffer_half_screen_fit_by_o", "style"));
        } else {
            super.setTheme(i);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        BaseScreenATView baseScreenATView = this.l;
        if (baseScreenATView != null) {
            baseScreenATView.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    private BaseScreenATView a(com.anythink.core.common.inner.mixad.c.a.a aVar, boolean z) {
        if (aVar == null) {
            return null;
        }
        Object objA = new com.anythink.core.common.inner.mixad.c.b(new com.anythink.core.common.inner.mixad.c.a.a.C0024a().a(aVar).a(this).a(z).a(this.q).a(this.s).a()).a();
        if (!(objA instanceof BaseScreenATView)) {
            return null;
        }
        this.x = objA instanceof e;
        return (BaseScreenATView) objA;
    }

    private void d() {
        try {
            boolean z = false;
            if (this.k) {
                if (ATSDKGlobalSetting.isHideNavAndStatusBar) {
                    z = true;
                }
            } else {
                w wVar = this.n;
                if (wVar != null && wVar.f() != null && this.n.f().ad() == 1) {
                    z = true;
                }
            }
            if (z) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.systemUiVisibility = 2050;
                window.setAttributes(attributes);
                window.addFlags(1024);
            }
        } catch (Throwable unused) {
        }
    }
}
