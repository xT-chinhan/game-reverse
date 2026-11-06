package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.a.b;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.i2.j;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.j1.a;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.n1.h2;
import com.smartdigimkt.n1.i2;
import com.smartdigimkt.n1.j2;
import com.smartdigimkt.n1.j3;
import com.smartdigimkt.n1.k2;
import com.smartdigimkt.n1.n2;
import com.smartdigimkt.n1.o3;
import com.smartdigimkt.n1.p3;
import com.smartdigimkt.n1.r3;
import com.smartdigimkt.p3.l;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.z.c0;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseSplashATView extends BaseATView {
    public static final /* synthetic */ int e0 = 0;
    public boolean D;
    public final TextView E;
    public final CloseFrameLayout F;
    public ViewGroup G;
    public final String H;
    public final Handler I;
    public volatile n2 J;
    public volatile boolean K;
    public a L;
    public r3 M;
    public final l N;
    public long O;
    public long P;
    public boolean Q;
    public com.smartdigimkt.x.l R;
    public final h2 S;
    public r T;
    public Map U;
    public int V;
    public final AtomicInteger W;
    public boolean a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;

    public BaseSplashATView(Context context) {
        super(context);
        this.H = "Skip";
        this.I = new Handler(Looper.getMainLooper());
        this.O = 5000L;
        this.P = 5000L;
        this.Q = false;
        this.S = new h2(this);
        this.V = 2;
        this.W = new AtomicInteger(1);
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
    }

    public final void a(g gVar) {
        if (this.a0) {
            return;
        }
        this.a0 = true;
        a aVar = this.L;
        if (aVar != null) {
            aVar.onShowFailed(gVar);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void b() {
        com.smartdigimkt.a3.a aVar = this.b;
        if (aVar != null) {
            this.T = new r(this.c, aVar.s);
        }
    }

    public void beforeSplashEndCardShow() {
        a(118);
        Map map = this.U;
        if (map != null) {
            map.put(b.C0013b.d, 1);
        }
    }

    public void checkSkipViewLocation() {
        if (this.D) {
            return;
        }
        try {
            ViewGroup.LayoutParams layoutParams = this.E.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                int iA = ((FrameLayout.LayoutParams) layoutParams).topMargin + k.a(getContext());
                int[] iArr = new int[2];
                this.E.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (i < iA) {
                    int i2 = iA - i;
                    ViewParent parent = this.E.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).setPadding(((ViewGroup) parent).getPaddingLeft(), ((ViewGroup) parent).getPaddingTop() + i2, ((ViewGroup) parent).getPaddingRight(), ((ViewGroup) parent).getPaddingBottom());
                    }
                    View viewFindViewById = findViewById(k.a(getContext(), "myoffer_btn_mute_id", "id"));
                    if (viewFindViewById != null && (viewFindViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        layoutParams2.topMargin += i2;
                        viewFindViewById.setLayoutParams(layoutParams2);
                    }
                    View viewFindViewById2 = findViewById(k.a(getContext(), "myoffer_feedback_ll_id", "id"));
                    if (viewFindViewById2 == null || !(viewFindViewById2.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
                    layoutParams3.topMargin += i2;
                    viewFindViewById2.setLayoutParams(layoutParams3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void destroy() {
        n2 n2Var = this.J;
        this.J = null;
        if (n2Var != null) {
            this.I.removeCallbacks(n2Var);
        }
        super.destroy();
        this.L = null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public int getATViewType() {
        return 3;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.b.s.m == 2) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, k.a(getContext(), 154.0f));
        } else {
            int measuredHeight = (getMeasuredHeight() * 2) / 3;
            layoutParams.addRule(11);
            layoutParams.setMargins(0, measuredHeight, 0, 0);
        }
        return layoutParams;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void i() {
        this.a0 = true;
        a aVar = this.L;
        if (aVar != null) {
            aVar.onAdShow(new w());
        }
    }

    public boolean isSplashSkipCountReadyForBubbleVibration() {
        com.smartdigimkt.a3.a aVar;
        e eVar;
        if (this.d0 || (aVar = this.b) == null || (eVar = aVar.s) == null) {
            return true;
        }
        long j = eVar.l;
        return j <= 1000 || this.O <= j - 2000;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void k() {
        if (!(this.c instanceof com.smartdigimkt.b3.l) || this.M == null) {
            return;
        }
        post(new k2(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void l() {
        if (this.c instanceof com.smartdigimkt.b3.l) {
            if (this.M == null) {
                this.M = new r3(this);
            }
            r3 r3Var = this.M;
            ImageView imageView = r3Var.b;
            if (imageView != null) {
                r3Var.a.removeView(imageView);
            }
            r3Var.a.post(new o3(r3Var));
            r3Var.b.post(new p3(r3Var));
        }
    }

    public boolean needShowSplashEndCard() {
        return (!this.g || this.Q) && c0.g(this.c, this.b);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.D || Build.VERSION.SDK_INT < 28) {
            return;
        }
        this.D = true;
        com.smartdigimkt.n1.k.a(this, false);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(3, false);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSkipViewLocation();
    }

    public void onSplashEndCardCountDownTick(long j) {
        this.Q = true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            a(110);
        } else {
            a(111);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            if (z) {
                a(110);
            } else {
                a(111);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.b0) {
            return;
        }
        this.b0 = true;
        if (this.d0) {
            return;
        }
        this.F.setVisibility(0);
        this.F.setOnClickListener(new i2(this));
        this.c0 = false;
        this.J = new n2(this);
        this.I.postDelayed(this.J, 1000L);
        a(this.O);
        this.O -= 1000;
    }

    public boolean p() {
        return false;
    }

    public void setAdExtraInfoMap(Map<String, Object> map) {
        this.U = map;
    }

    public void setDontCountDown(boolean z) {
        CloseFrameLayout closeFrameLayout;
        this.d0 = z;
        if (!z || (closeFrameLayout = this.F) == null) {
            return;
        }
        closeFrameLayout.setVisibility(8);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void h() {
        a(new g(com.anythink.core.common.inner.b.b.k, com.anythink.core.common.inner.b.b.ag));
    }

    public final void a(long j) {
        if (this.b.s.k == 0) {
            this.E.setText((j / 1000) + "s | " + this.H);
        } else {
            this.E.setText((j / 1000) + " s");
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(w wVar) {
        e eVar;
        a aVar = this.L;
        if (aVar != null) {
            aVar.onAdClick(wVar);
        }
        c cVar = this.c;
        if (cVar == null || (eVar = cVar.w) == null || eVar.A0 != 1) {
            return;
        }
        f.a().a(new j2(this));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(boolean z) {
        a aVar = this.L;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void a(int i, int i2) {
        super.a(i, i2);
        a((j3) this.F, true);
    }

    public void a(int i, boolean z) {
        e eVar;
        e eVar2;
        d dVar;
        n2 n2Var = this.J;
        this.J = null;
        if (n2Var != null) {
            this.I.removeCallbacks(n2Var);
        }
        if (!((i != 2 && i != 7) || (eVar = this.b.s) == null || eVar.B1 == 1) || this.K) {
            return;
        }
        if (i == 2 && p()) {
            Map map = this.U;
            if (map != null) {
                map.put(b.C0013b.c, 1);
                return;
            }
            return;
        }
        this.K = true;
        this.V = i;
        if (i == 6 && (dVar = this.n) != null) {
            dVar.f();
        }
        if (i == 1 && this.c0 && (eVar2 = this.b.s) != null && eVar2.B1 != 1) {
            i = 11;
        }
        a(115);
        if (!this.a0) {
            a(new g(com.anythink.core.common.inner.b.b.k, "SplashView not showing on screen."));
        }
        com.smartdigimkt.n3.k.a(this.c, this.b, this.y, this.x);
        Map map2 = this.U;
        if (map2 != null) {
            map2.put(b.C0013b.a, Integer.valueOf(i));
            this.U.put(b.C0013b.b, Boolean.valueOf(z));
        }
        a aVar = this.L;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void a(int i) {
        super.a(i);
        if (i == 110) {
            this.W.set(2);
        } else {
            if (i != 111) {
                return;
            }
            this.W.set(3);
        }
    }

    public BaseSplashATView(Context context, com.smartdigimkt.a3.a aVar, c cVar, a aVar2) {
        Drawable directlySplashAdCTAButtongBgDrawable;
        e eVar;
        super(context, aVar, cVar);
        this.H = "Skip";
        this.I = new Handler(Looper.getMainLooper());
        this.O = 5000L;
        this.P = 5000L;
        this.Q = false;
        this.S = new h2(this);
        this.V = 2;
        int iA = 1;
        this.W = new AtomicInteger(1);
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        if (cVar != null && (eVar = cVar.w) != null) {
            iA = eVar.a();
        }
        this.N = new l(iA);
        this.L = aVar2;
        this.H = getResources().getString(k.a(getContext(), "myoffer_splash_skip_text", "string"));
        this.E = (TextView) findViewById(k.a(getContext(), "myoffer_splash_skip", "id"));
        CloseFrameLayout closeFrameLayout = (CloseFrameLayout) findViewById(k.a(getContext(), "myoffer_splash_skip_area", "id"));
        this.F = closeFrameLayout;
        this.G = (ViewGroup) findViewById(k.a(getContext(), "myoffer_feedback_ll_id", "id"));
        this.O = this.b.s.l;
        this.K = false;
        a((j3) closeFrameLayout, false);
        if (cVar.e() == 4) {
            try {
                View view = this.m;
                if (view != null && (view instanceof CTAButtonLayout) && (directlySplashAdCTAButtongBgDrawable = SDMSDK.getInstance().getDirectlyOfferSetting().getDirectlySplashAdCTAButtongBgDrawable()) != null) {
                    ((CTAButtonLayout) this.m).changeMajorButtonBackground(directlySplashAdCTAButtongBgDrawable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.smartdigimkt.a3.a aVar3 = this.b;
        this.P = aVar3.s.B0;
        new j(this.c, aVar3).a(this);
    }
}
