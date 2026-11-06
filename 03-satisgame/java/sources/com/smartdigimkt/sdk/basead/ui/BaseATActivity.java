package com.smartdigimkt.sdk.basead.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.h;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.h0.j;
import com.smartdigimkt.j1.d;
import com.smartdigimkt.n1.b0;
import com.smartdigimkt.n1.c0;
import com.smartdigimkt.n1.d0;
import com.smartdigimkt.n1.k;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.b;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewBaseScreenATView;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.t2.w;
import com.smartdigimkt.t2.z;

/* JADX INFO: loaded from: classes3.dex */
public class BaseATActivity extends Activity {
    public static final /* synthetic */ int A = 0;
    public b a;
    public BaseScreenATView b;
    public a c;
    public c d;
    public String e;
    public d f;
    public String g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public j p;
    public long q = 0;
    public long r = 0;
    public float s = 0.0f;
    public boolean t = false;
    public boolean u = false;
    public final b0 v = new b0(this);
    public d0 w;
    public long x;
    public long y;
    public long z;

    public static void a(Activity activity, com.smartdigimkt.b3.a aVar) {
        e eVar;
        Intent intent = new Intent();
        Context contextD = SDKContext.getInstance().d();
        if (activity != null && !activity.isFinishing()) {
            contextD = activity;
        }
        int i = aVar.a;
        a aVar2 = aVar.f;
        boolean zEquals = (aVar2 == null || (eVar = aVar2.s) == null || i != 3) ? false : TextUtils.equals("2", eVar.w);
        if (aVar.e == 2) {
            if (zEquals || aVar.g) {
                intent.setClass(contextD, ATLandscapeTranslucentActivity.class);
            } else {
                intent.setClass(contextD, ATLandscapeActivity.class);
            }
        } else if (zEquals || aVar.g) {
            intent.setClass(contextD, ATPortraitTranslucentActivity.class);
        } else {
            intent.setClass(contextD, ATPortraitActivity.class);
        }
        intent.putExtra(com.anythink.core.basead.a.C0009a.d, aVar.d);
        com.smartdigimkt.f2.a aVarA = com.smartdigimkt.f2.a.a();
        String str = aVar.d;
        aVarA.getClass();
        if (!TextUtils.isEmpty(str)) {
            aVarA.a.put(str, aVar);
        }
        if (!(contextD instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        try {
            contextD.startActivity(intent);
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.overridePendingTransition(0, 0);
        } catch (Throwable th) {
            d dVar = (d) com.smartdigimkt.j1.b.a.a.get(aVar.d);
            if (dVar != null) {
                dVar.a(new g(com.anythink.core.common.inner.b.b.b, th.getMessage()));
            }
        }
    }

    public final BaseScreenATView b() {
        e eVar;
        com.smartdigimkt.b3.d dVar;
        int i = this.h;
        if (i == 1) {
            a aVar = this.c;
            if ((aVar == null || (eVar = aVar.s) == null || (dVar = eVar.R1) == null || (!h.a(3, dVar) && !h.a(4, dVar))) && this.d.d() == 3 && s.b(this.d)) {
                return new WTWebViewBaseScreenATView(this, this.c, this.d, this.g, this.h, this.i);
            }
        } else if (i == 3) {
            if (this.d.d() == 3 && s.b(this.d)) {
                return new WTWebViewBaseScreenATView(this, this.c, this.d, this.g, this.h, this.i);
            }
            if (this.m) {
                return (this.c.s.m0 == 1 && this.i == 1) ? new LetterHalfScreenATView(this, this.c, this.d, this.g, this.h, this.i) : new HalfScreenATView(this, this.c, this.d, this.g, this.h, this.i);
            }
            return (this.c.s.m0 == 1 && this.i == 1) ? new LetterFullScreenATView(this, this.c, this.d, this.g, this.h, this.i) : new FullScreenATView(this, this.c, this.d, this.g, this.h, this.i);
        }
        return new FullScreenATView(this, this.c, this.d, this.g, this.h, this.i);
    }

    public final void c() {
        e eVar;
        try {
            c cVar = this.d;
            if (cVar == null || (eVar = cVar.w) == null || eVar.E1 != 1) {
                return;
            }
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.systemUiVisibility |= 2050;
            window.setAttributes(attributes);
            window.addFlags(1024);
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        BaseScreenATView baseScreenATView = this.b;
        if (baseScreenATView != null) {
            baseScreenATView.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        e eVar;
        e eVar2;
        super.onCreate(bundle);
        this.a = com.smartdigimkt.r4.d.a(this, new c0());
        if (SDKContext.getInstance().d() == null) {
            SDKContext.getInstance().a(getApplicationContext());
        }
        if (this instanceof ATLandscapeActivity) {
            this.i = 2;
        } else {
            this.i = 1;
        }
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.e = intent.getStringExtra(com.anythink.core.basead.a.C0009a.d);
                com.smartdigimkt.f2.a aVarA = com.smartdigimkt.f2.a.a();
                String str = this.e;
                aVarA.getClass();
                com.smartdigimkt.b3.a aVar = !TextUtils.isEmpty(str) ? (com.smartdigimkt.b3.a) aVarA.a.get(str) : null;
                if (aVar != null) {
                    this.g = aVar.b;
                    this.h = aVar.a;
                    this.d = aVar.c;
                    this.c = aVar.f;
                    this.n = aVar.h;
                }
                int i = this.h;
                a aVar2 = this.c;
                this.m = (aVar2 == null || (eVar = aVar2.s) == null || i != 3) ? false : TextUtils.equals("2", eVar.w);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f = (d) com.smartdigimkt.j1.b.a.a.get(this.e);
        a("1", 0L);
        a aVar3 = this.c;
        if (aVar3 == null || aVar3.s == null) {
            try {
                d dVar = this.f;
                if (dVar != null) {
                    dVar.a(new g(com.anythink.core.common.inner.b.b.k, "BaseATActivityStart FullScreen Ad Error."));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            a();
        } else if (this.d == null) {
            try {
                d dVar2 = this.f;
                if (dVar2 != null) {
                    dVar2.a(new g(com.anythink.core.common.inner.b.b.k, "BaseATActivity onCreate: OfferAd = null"));
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            a();
        } else {
            com.smartdigimkt.z.d dVarA = com.smartdigimkt.z.d.a();
            b0 b0Var = this.v;
            synchronized (dVarA) {
                if (!TextUtils.isEmpty("1") && b0Var != null) {
                    f.a().c(new com.smartdigimkt.z.a(dVarA, b0Var));
                }
            }
            try {
                BaseScreenATView baseScreenATViewB = b();
                this.b = baseScreenATViewB;
                setContentView(baseScreenATViewB);
                k.a(getWindow());
                c cVar = this.d;
                k.a(this.b, (cVar == null || (eVar2 = cVar.w) == null || eVar2.E1 != 1) ? false : true);
                BaseScreenATView baseScreenATView = this.b;
                if (baseScreenATView instanceof BaseATView) {
                    baseScreenATView.setRvDeepRewardListenerRegistered(this.n);
                }
                d0 d0Var = new d0(this);
                this.w = d0Var;
                this.b.setListener(d0Var);
                if (bundle != null) {
                    this.j = bundle.getBoolean(com.anythink.core.basead.a.C0009a.f);
                    this.k = bundle.getBoolean(com.anythink.core.basead.a.C0009a.g);
                    this.l = bundle.getBoolean(com.anythink.core.basead.a.C0009a.j);
                    this.q = bundle.getLong(com.anythink.core.basead.a.C0009a.l);
                    this.r = bundle.getLong(com.anythink.core.basead.a.C0009a.m);
                    this.s = bundle.getFloat(com.anythink.core.basead.a.C0009a.n);
                    this.t = bundle.getBoolean(com.anythink.core.basead.a.C0009a.h, false);
                    this.u = bundle.getBoolean(com.anythink.core.basead.a.C0009a.o, false);
                }
                this.b.setIsShowEndCard(this.j);
                this.b.setHasReward(this.l);
                if (bundle != null) {
                    this.b.setVideoMute(this.k);
                    this.b.setShowBannerTime(this.q);
                    this.b.setHideBannerTime(this.r);
                    this.b.setCloseButtonScaleFactor(this.s);
                    this.b.setHasPerformClick(this.t);
                    this.b.setShowingEndCardAfterVideoPlay(this.u);
                }
                try {
                    this.b.init();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    try {
                        d dVar3 = this.f;
                        if (dVar3 != null) {
                            dVar3.a(new g(com.anythink.core.common.inner.b.b.k, com.smartdigimkt.r4.k.a(th3.getStackTrace())));
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    a();
                }
            } catch (Throwable th5) {
                String.valueOf(th5);
                String message = th5.getMessage() != null ? th5.getMessage() : th5.getClass().getSimpleName();
                try {
                    d dVar4 = this.f;
                    if (dVar4 != null) {
                        dVar4.a(new g(com.anythink.core.common.inner.b.b.k, "BaseATActivity inflate failed: " + message));
                    }
                } catch (Throwable unused) {
                }
                a();
            }
        }
        c();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        com.smartdigimkt.j1.c cVar;
        b bVar = this.a;
        if (bVar != null) {
            bVar.run();
            this.a = null;
        }
        if (isFinishing() && !isChangingConfigurations()) {
            com.smartdigimkt.f2.a aVarA = com.smartdigimkt.f2.a.a();
            String str = this.e;
            aVarA.getClass();
            if (!TextUtils.isEmpty(str)) {
                aVarA.a.remove(str);
            }
        }
        this.p = null;
        this.w = null;
        com.smartdigimkt.z.d dVarA = com.smartdigimkt.z.d.a();
        b0 b0Var = this.v;
        synchronized (dVarA) {
            if (!TextUtils.isEmpty("1") && b0Var != null) {
                f.a().c(new com.smartdigimkt.z.b(dVarA, b0Var));
            }
        }
        BaseScreenATView baseScreenATView = this.b;
        if (baseScreenATView != null) {
            baseScreenATView.removeAllViews();
            this.b.B();
            this.b = null;
        }
        c cVar2 = this.d;
        if (cVar2 != null && cVar2.h()) {
            this.d.getClass();
            z zVarA = z.a();
            if (!zVarA.d) {
                f.a().a(new w(zVarA), 0L, 13);
            }
        }
        if (this.c != null) {
            com.smartdigimkt.n3.a aVarA2 = com.smartdigimkt.n3.a.a();
            String str2 = this.c.g + this.c.f;
            aVarA2.getClass();
            if (!TextUtils.isEmpty(str2) && (cVar = (com.smartdigimkt.j1.c) aVarA2.a.remove(str2)) != null && cVar.a.equals(str2) && !cVar.b.c) {
                d dVar = cVar.b;
                dVar.b = 3;
                dVar.a();
            }
        }
        if (!TextUtils.isEmpty(this.e)) {
            com.smartdigimkt.j1.b.a.a.remove(this.e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        long j = this.z + 1;
        this.z = j;
        if (j <= 5) {
            StringBuilder sb = new StringBuilder("3-");
            d0 d0Var = this.w;
            a(sb.append(d0Var != null ? d0Var.d : "0").toString(), SystemClock.elapsedRealtime() - this.x);
        }
        this.o = false;
        BaseScreenATView baseScreenATView = this.b;
        if (baseScreenATView != null) {
            baseScreenATView.a(111);
            baseScreenATView.U = false;
            com.smartdigimkt.u1.d dVar = baseScreenATView.n;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.getMessage();
            com.smartdigimkt.r4.k.a(th.getStackTrace());
            a();
        }
        c();
        this.x = SystemClock.elapsedRealtime();
        long j = this.y + 1;
        this.y = j;
        if (j <= 5) {
            StringBuilder sb = new StringBuilder("2-");
            d0 d0Var = this.w;
            a(sb.append(d0Var != null ? d0Var.d : "0").toString(), 0L);
        }
        this.o = true;
        BaseScreenATView baseScreenATView = this.b;
        if (baseScreenATView != null) {
            baseScreenATView.D();
        }
        j jVar = this.p;
        if (jVar != null) {
            jVar.a(this);
            this.p = null;
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        BaseScreenATView baseScreenATView = this.b;
        if (baseScreenATView != null) {
            if (baseScreenATView.isShowEndCard()) {
                bundle.putBoolean(com.anythink.core.basead.a.C0009a.f, true);
            }
            bundle.putBoolean(com.anythink.core.basead.a.C0009a.g, this.b.isVideoMute());
            bundle.putBoolean(com.anythink.core.basead.a.C0009a.j, this.b.hasReward());
            bundle.putLong(com.anythink.core.basead.a.C0009a.l, this.b.getShowBannerTime());
            bundle.putLong(com.anythink.core.basead.a.C0009a.m, this.b.getHideBannerTime());
            bundle.putFloat(com.anythink.core.basead.a.C0009a.n, this.b.getCloseButtonScaleFactor());
            bundle.putBoolean(com.anythink.core.basead.a.C0009a.h, this.b.getHasPerformClick());
            bundle.putBoolean(com.anythink.core.basead.a.C0009a.o, this.b.isShowingEndCardAfterVideoPlay());
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        com.smartdigimkt.u1.d dVar;
        super.onStop();
        BaseScreenATView baseScreenATView = this.b;
        if (baseScreenATView == null || (dVar = baseScreenATView.n) == null) {
            return;
        }
        BasePlayerView basePlayerView = dVar.h;
        if (basePlayerView == null || !basePlayerView.isPlaying()) {
            dVar.c();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            c();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (Build.VERSION.SDK_INT == 26) {
            super.setTheme(com.smartdigimkt.r4.k.a(this, "myoffer_half_screen_fit_by_o", "style"));
        } else {
            super.setTheme(i);
        }
    }

    public final void a() {
        try {
            finish();
            overridePendingTransition(0, 0);
        } catch (Throwable unused) {
        }
    }

    public final void a(String str, long j) {
        a aVar;
        if (this.d == null || (aVar = this.c) == null) {
            return;
        }
        try {
            String str2 = aVar.f;
            String str3 = this.c.c + "";
            String str4 = this.c != null ? this.c.k + "" : "";
            c cVar = this.d;
            int iE = cVar != null ? cVar.e() : -1;
            c cVar2 = this.d;
            String str5 = cVar2 != null ? cVar2.a : "";
            String str6 = cVar2 instanceof com.smartdigimkt.b3.b ? ((com.smartdigimkt.b3.b) cVar2).c0 : "";
            boolean zH = com.smartdigimkt.z.c0.h(cVar2, this.c);
            if (SDKContext.getInstance().d() == null) {
                return;
            }
            f.a().a(new com.smartdigimkt.n3.j(str3, str4, aVar, str2, iE, str6, str5, zH, str, j), 0L, 13);
        } catch (Throwable unused) {
        }
    }
}
