package com.anythink.basead.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.anythink.basead.b.c.d;
import com.anythink.basead.d.f;
import com.anythink.basead.d.g;
import com.anythink.basead.g.i;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.h5template.WTWebViewBaseScreenATView;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.a.o;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bf;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.l.e.a.e;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;
import com.bykv.vk.component.ttvideo.player.C;
import com.umeng.analytics.pro.l;

/* JADX INFO: loaded from: classes.dex */
public class BaseATActivity extends Activity {
    public static final String a = "BaseATActivity";
    private boolean A;
    boolean b;
    bf c;
    i j;
    long l;
    long m;
    long n;
    private BaseScreenATView o;
    private x p;
    private w q;
    private String r;
    private com.anythink.basead.g.b.AbstractC0044b s;
    private String t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    long d = 0;
    long e = 0;
    float f = 0.0f;
    boolean g = false;
    boolean h = false;
    com.anythink.core.common.b.a i = new com.anythink.core.common.b.a() { // from class: com.anythink.basead.ui.BaseATActivity.1
        @Override // com.anythink.core.common.b.a
        public final void a(Object obj) {
            if (!(obj instanceof bf) || BaseATActivity.this.q == null) {
                return;
            }
            bf bfVar = (bf) obj;
            if (bfVar.a().I().equals(BaseATActivity.this.q.I())) {
                if (BaseATActivity.this.b) {
                    bfVar.a(BaseATActivity.this);
                } else {
                    BaseATActivity.this.c = bfVar;
                }
            }
        }
    };
    boolean k = false;

    public static void a(Activity activity, com.anythink.core.basead.b.c cVar) {
        Intent intent = new Intent();
        Context contextG = t.b().g();
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
        intent.putExtra(com.anythink.core.basead.a.C0075a.d, cVar.d);
        com.anythink.basead.ui.e.a.a().a(cVar.d, cVar);
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
            com.anythink.basead.g.b.AbstractC0044b abstractC0044bA = com.anythink.basead.g.b.a().a(cVar.d);
            if (abstractC0044bA != null) {
                abstractC0044bA.a(g.a("10000", th.getMessage()));
            }
        }
    }

    private void a() {
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.r = intent.getStringExtra(com.anythink.core.basead.a.C0075a.d);
                com.anythink.core.basead.b.c cVarA = com.anythink.basead.ui.e.a.a().a(this.r);
                if (cVarA != null) {
                    this.t = cVarA.b;
                    this.u = cVarA.a;
                    this.q = cVarA.c;
                    this.p = cVarA.h;
                }
                this.z = a(this.u, this.p);
                return;
            }
            Log.e("anythink", a + " Intent is null.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean a(int i, x xVar) {
        if (xVar == null || xVar.o == null || i != 3) {
            return false;
        }
        return TextUtils.equals("2", xVar.o.O());
    }

    private BaseScreenATView a(com.anythink.basead.mixad.c.a.a aVar, BaseAd baseAd) {
        int i = this.u;
        if (i != 1) {
            if (i == 3) {
                if (baseAd != null) {
                    boolean z = this.z;
                    if (aVar != null) {
                        Object objA = new com.anythink.basead.mixad.c.b(new com.anythink.basead.mixad.c.a.a.C0045a().a(aVar).a(this).a(z).a(this.t).a(this.v).a()).a();
                        Object[] objArr = new Object[1];
                        if (objA instanceof BaseScreenATView) {
                            this.A = objA instanceof e;
                            return (BaseScreenATView) objA;
                        }
                    }
                    return null;
                }
                if (this.q.ao() == 3) {
                    if (d.b(this.q)) {
                        return new WTWebViewBaseScreenATView(this, this.p, this.q, this.t, this.u, this.v);
                    }
                    if (this.q.r().bC() != 1) {
                        com.anythink.basead.g.b.AbstractC0044b abstractC0044b = this.s;
                        if (abstractC0044b != null) {
                            abstractC0044b.a(g.a(g.t, g.ad));
                        }
                        c();
                        return null;
                    }
                }
                if (this.z) {
                    if (this.p.o.ar() == 1 && this.v == 1) {
                        return new LetterHalfScreenATView(this, this.p, this.q, this.t, this.u, this.v);
                    }
                    return new HalfScreenATView(this, this.p, this.q, this.t, this.u, this.v);
                }
                if (this.p.o.ar() == 1 && this.v == 1) {
                    return new LetterFullScreenATView(this, this.p, this.q, this.t, this.u, this.v);
                }
                return new FullScreenATView(this, this.p, this.q, this.t, this.u, this.v);
            }
        } else if (this.q.ao() == 3) {
            if (d.b(this.q)) {
                return new WTWebViewBaseScreenATView(this, this.p, this.q, this.t, this.u, this.v);
            }
            if (this.q.r().bC() != 1) {
                com.anythink.basead.g.b.AbstractC0044b abstractC0044b2 = this.s;
                if (abstractC0044b2 != null) {
                    abstractC0044b2.a(g.a(g.t, g.ad));
                }
                c();
                return null;
            }
        }
        return new FullScreenATView(this, this.p, this.q, this.t, this.u, this.v);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (t.b().g() == null) {
            t.b().a(getApplicationContext());
        }
        a(bundle);
        d();
        try {
            com.anythink.core.common.l.e.a.a.InterfaceC0086a interfaceC0086aB = com.anythink.basead.mixad.a.a().b(this.r);
            if (interfaceC0086aB != null) {
                interfaceC0086aB.a(this);
            }
        } catch (Throwable unused) {
        }
    }

    private void b() {
        com.anythink.core.common.l.e.a.a.InterfaceC0086a interfaceC0086aB = com.anythink.basead.mixad.a.a().b(this.r);
        if (interfaceC0086aB != null) {
            interfaceC0086aB.a(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ed  */
    protected void a(Bundle bundle) {
        BaseAd baseAdA;
        if (this instanceof ATLandscapeActivity) {
            this.v = 2;
        } else {
            this.v = 1;
        }
        Intent intent = getIntent();
        try {
            if (intent != null) {
                this.r = intent.getStringExtra(com.anythink.core.basead.a.C0075a.d);
                com.anythink.core.basead.b.c cVarA = com.anythink.basead.ui.e.a.a().a(this.r);
                if (cVarA != null) {
                    this.t = cVarA.b;
                    this.u = cVarA.a;
                    this.q = cVarA.c;
                    this.p = cVarA.h;
                }
                this.z = a(this.u, this.p);
            } else {
                Log.e("anythink", a + " Intent is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.s = com.anythink.basead.g.b.a().a(this.r);
        a("1", 0L);
        x xVar = this.p;
        if (xVar == null || xVar.o == null) {
            StringBuilder sb = new StringBuilder();
            String str = a;
            Log.e("anythink", sb.append(str).append("Start Screen Ad Error.").toString());
            try {
                com.anythink.basead.g.b.AbstractC0044b abstractC0044b = this.s;
                if (abstractC0044b != null) {
                    abstractC0044b.a(g.a(g.k, str + "Start FullScreen Ad Error."));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c();
            return;
        }
        if (this.q == null) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = a;
            Log.e("anythink", sb2.append(str2).append(" onCreate: OfferAd = null").toString());
            try {
                com.anythink.basead.g.b.AbstractC0044b abstractC0044b2 = this.s;
                if (abstractC0044b2 != null) {
                    abstractC0044b2.a(g.a(g.k, str2 + " onCreate: OfferAd = null"));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            c();
            return;
        }
        com.anythink.core.common.b.a().a("1", this.i);
        com.anythink.basead.mixad.c.a.a aVarA = com.anythink.basead.mixad.a.a().a(this.r);
        if (aVarA == null || aVarA.a() == null) {
            baseAdA = null;
        } else {
            ATNativeAdInfo aTNativeAdInfoA = aVarA.a();
            if (aTNativeAdInfoA instanceof com.anythink.core.common.l.e.a.g) {
                baseAdA = ((com.anythink.core.common.l.e.a.g) aTNativeAdInfoA).a();
                this.k = true;
            } else {
                baseAdA = null;
            }
        }
        BaseScreenATView baseScreenATViewA = a(aVarA, baseAdA);
        this.o = baseScreenATViewA;
        if (baseScreenATViewA == null) {
            return;
        }
        if (this.A || this.z) {
            setContentView(baseScreenATViewA);
        } else {
            ViewGroup customAdContainer = baseAdA != null ? baseAdA.getCustomAdContainer() : null;
            if (customAdContainer != null) {
                customAdContainer.addView(this.o);
                am.a(customAdContainer);
                setContentView(customAdContainer);
                this.o.handleFullScreenClick();
            } else {
                setContentView(this.o);
            }
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.j = anonymousClass2;
        this.o.setListener(anonymousClass2);
        if (bundle != null) {
            this.w = bundle.getBoolean(com.anythink.core.basead.a.C0075a.f);
            this.x = bundle.getBoolean(com.anythink.core.basead.a.C0075a.g);
            this.y = bundle.getBoolean(com.anythink.core.basead.a.C0075a.j);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0075a.l);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0075a.m);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0075a.n);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0075a.h, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0075a.o, false);
        }
        this.o.setIsShowEndCard(this.w);
        this.o.setHasReward(this.y);
        if (bundle != null) {
            this.o.setVideoMute(this.x);
            this.o.setShowBannerTime(this.d);
            this.o.setHideBannerTime(this.e);
            this.o.setCloseButtonScaleFactor(this.f);
            this.o.setHasPerformClick(this.g);
            this.o.setShowingEndCardAfterVideoPlay(this.h);
        }
        try {
            this.o.init();
        } catch (Throwable th3) {
            th3.printStackTrace();
            try {
                com.anythink.basead.g.b.AbstractC0044b abstractC0044b3 = this.s;
                if (abstractC0044b3 != null) {
                    abstractC0044b3.a(g.a(g.k, q.a(th3.getStackTrace())));
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            c();
        }
    }

    private void b(Bundle bundle) {
        if (bundle != null) {
            this.w = bundle.getBoolean(com.anythink.core.basead.a.C0075a.f);
            this.x = bundle.getBoolean(com.anythink.core.basead.a.C0075a.g);
            this.y = bundle.getBoolean(com.anythink.core.basead.a.C0075a.j);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0075a.l);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0075a.m);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0075a.n);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0075a.h, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0075a.o, false);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseATActivity$2, reason: invalid class name */
    final class AnonymousClass2 extends i {
        String a = "1";

        AnonymousClass2() {
        }

        @Override // com.anythink.basead.g.i
        public final String i() {
            return this.a;
        }

        @Override // com.anythink.basead.g.i
        public final void f() {
            this.a = "1";
            BaseATActivity.this.a("4", 0L);
        }

        @Override // com.anythink.basead.g.i
        public final void g() {
            if (TextUtils.equals(this.a, "1")) {
                this.a = "2";
            }
            BaseATActivity.this.a("5-".concat(BaseATActivity.this.m - BaseATActivity.this.n <= 0 ? "2" : "1"), 0L);
        }

        @Override // com.anythink.basead.g.i
        public final void h() {
            if (TextUtils.equals(this.a, "1")) {
                this.a = "3";
                BaseATActivity.this.a("6-".concat(BaseATActivity.this.m - BaseATActivity.this.n <= 0 ? "2" : "1"), 0L);
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void a(j jVar) {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.a(jVar);
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void a(f fVar) {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.a(fVar);
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void a() {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.a();
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void b() {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.b();
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void c() {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.c();
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void d() {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.a(e());
                BaseATActivity.this.s.d();
            }
            BaseATActivity.this.c();
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void b(j jVar) {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.b(jVar);
            }
        }

        @Override // com.anythink.basead.g.b.AbstractC0044b
        public final void a(boolean z) {
            if (BaseATActivity.this.s != null) {
                BaseATActivity.this.s.a(z);
            }
        }
    }

    private void c(Bundle bundle) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.j = anonymousClass2;
        this.o.setListener(anonymousClass2);
        if (bundle != null) {
            this.w = bundle.getBoolean(com.anythink.core.basead.a.C0075a.f);
            this.x = bundle.getBoolean(com.anythink.core.basead.a.C0075a.g);
            this.y = bundle.getBoolean(com.anythink.core.basead.a.C0075a.j);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0075a.l);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0075a.m);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0075a.n);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0075a.h, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0075a.o, false);
        }
        this.o.setIsShowEndCard(this.w);
        this.o.setHasReward(this.y);
        if (bundle != null) {
            this.o.setVideoMute(this.x);
            this.o.setShowBannerTime(this.d);
            this.o.setHideBannerTime(this.e);
            this.o.setCloseButtonScaleFactor(this.f);
            this.o.setHasPerformClick(this.g);
            this.o.setShowingEndCardAfterVideoPlay(this.h);
        }
        try {
            this.o.init();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                com.anythink.basead.g.b.AbstractC0044b abstractC0044b = this.s;
                if (abstractC0044b != null) {
                    abstractC0044b.a(g.a(g.k, q.a(th.getStackTrace())));
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
        BaseScreenATView baseScreenATView = this.o;
        if (baseScreenATView != null) {
            if (baseScreenATView.isShowEndCard()) {
                bundle.putBoolean(com.anythink.core.basead.a.C0075a.f, true);
            }
            bundle.putBoolean(com.anythink.core.basead.a.C0075a.g, this.o.isVideoMute());
            bundle.putBoolean(com.anythink.core.basead.a.C0075a.j, this.o.hasReward());
            bundle.putLong(com.anythink.core.basead.a.C0075a.l, this.o.getShowBannerTime());
            bundle.putLong(com.anythink.core.basead.a.C0075a.m, this.o.getHideBannerTime());
            bundle.putFloat(com.anythink.core.basead.a.C0075a.n, this.o.getCloseButtonScaleFactor());
            bundle.putBoolean(com.anythink.core.basead.a.C0075a.h, this.o.getHasPerformClick());
            bundle.putBoolean(com.anythink.core.basead.a.C0075a.o, this.o.isShowingEndCardAfterVideoPlay());
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
        this.l = SystemClock.elapsedRealtime();
        long j = this.m + 1;
        this.m = j;
        if (j <= 5) {
            StringBuilder sb = new StringBuilder("2-");
            i iVar = this.j;
            a(sb.append(iVar != null ? iVar.i() : "0").toString(), 0L);
        }
        this.b = true;
        BaseScreenATView baseScreenATView = this.o;
        if (baseScreenATView != null) {
            baseScreenATView.A();
        }
        bf bfVar = this.c;
        if (bfVar != null) {
            bfVar.a(this);
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
        long j = this.n + 1;
        this.n = j;
        if (j <= 5) {
            StringBuilder sb = new StringBuilder("3-");
            i iVar = this.j;
            a(sb.append(iVar != null ? iVar.i() : "0").toString(), SystemClock.elapsedRealtime() - this.l);
        }
        this.b = false;
        BaseScreenATView baseScreenATView = this.o;
        if (baseScreenATView != null) {
            baseScreenATView.D();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.c = null;
        this.j = null;
        com.anythink.core.common.b.a().b("1", this.i);
        BaseScreenATView baseScreenATView = this.o;
        if (baseScreenATView != null) {
            baseScreenATView.removeAllViews();
            this.o.F();
            this.o = null;
        }
        w wVar = this.q;
        if (wVar != null && wVar.L() && !this.q.c()) {
            o.a().b();
        }
        if (this.p != null) {
            com.anythink.core.common.u.a.a().a(this.p.d + this.p.c);
        }
        if (!TextUtils.isEmpty(this.r)) {
            com.anythink.basead.g.b.a().b(this.r);
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
            super.setTheme(q.a(this, "myoffer_half_screen_fit_by_o", "style"));
        } else {
            super.setTheme(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j) {
        w wVar = this.q;
        if (wVar == null || wVar.b() == 10) {
            return;
        }
        try {
            x xVar = this.p;
            String str2 = xVar != null ? xVar.c : "";
            String string = this.p != null ? new StringBuilder().append(this.p.j).toString() : "";
            String string2 = this.p != null ? new StringBuilder().append(this.p.f).toString() : "";
            w wVar2 = this.q;
            int iB = wVar2 != null ? wVar2.b() : -1;
            w wVar3 = this.q;
            String strV = wVar3 != null ? wVar3.v() : "";
            w wVar4 = this.q;
            com.anythink.core.common.u.e.a(str, xVar, str2, string, string2, iB, 0, strV, wVar4 instanceof r ? ((r) wVar4).aC() : "", com.anythink.basead.b.e.a(this.q, this.p), j);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        BaseScreenATView baseScreenATView = this.o;
        if (baseScreenATView != null) {
            baseScreenATView.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    private BaseScreenATView a(com.anythink.basead.mixad.c.a.a aVar, boolean z) {
        if (aVar == null) {
            return null;
        }
        Object objA = new com.anythink.basead.mixad.c.b(new com.anythink.basead.mixad.c.a.a.C0045a().a(aVar).a(this).a(z).a(this.t).a(this.v).a()).a();
        Object[] objArr = new Object[1];
        if (!(objA instanceof BaseScreenATView)) {
            return null;
        }
        this.A = objA instanceof e;
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
                w wVar = this.q;
                if (wVar != null && wVar.r() != null && this.q.r().bM() == 1) {
                    z = true;
                }
            }
            if (z) {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.systemUiVisibility = l.b;
                window.setAttributes(attributes);
                window.addFlags(1024);
            }
        } catch (Throwable unused) {
        }
    }
}
