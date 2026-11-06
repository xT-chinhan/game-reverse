package com.smartdigimkt.sdk.basead.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.inner.b.b;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.c1.g;
import com.smartdigimkt.h0.m;
import com.smartdigimkt.i2.j;
import com.smartdigimkt.i2.r;
import com.smartdigimkt.j1.v;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.n1.a1;
import com.smartdigimkt.n1.b1;
import com.smartdigimkt.n1.c1;
import com.smartdigimkt.n1.d0;
import com.smartdigimkt.n1.d1;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.n1.e1;
import com.smartdigimkt.n1.f1;
import com.smartdigimkt.n1.g1;
import com.smartdigimkt.n1.h1;
import com.smartdigimkt.n1.j1;
import com.smartdigimkt.n1.j3;
import com.smartdigimkt.n1.o3;
import com.smartdigimkt.n1.p3;
import com.smartdigimkt.n1.r3;
import com.smartdigimkt.n1.s0;
import com.smartdigimkt.n1.t0;
import com.smartdigimkt.n1.u0;
import com.smartdigimkt.n1.v0;
import com.smartdigimkt.n1.y0;
import com.smartdigimkt.n1.z0;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView;
import com.smartdigimkt.sdk.basead.ui.animplayerview.WebLandpagePlayerView;
import com.smartdigimkt.sdk.basead.ui.component.CTAButtonLayout;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;
import com.smartdigimkt.u1.d;
import com.smartdigimkt.u1.e;
import com.smartdigimkt.x.l;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseScreenATView extends BaseATView {
    public static final int FORMAT_INTERSTITIAL = 3;
    public static final int FORMAT_REWARD_VIDEO = 1;
    public static final String TAG = "BaseScreenATView";
    public int A0;
    public final int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public final int J;
    public long K;
    public final long L;
    public long M;
    public boolean N;
    public int O;
    public int P;
    public final long Q;
    public final long R;
    public long S;
    public long T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean a0;
    public boolean b0;
    public float c0;
    public boolean d0;
    public boolean e0;
    public RelativeLayout f0;
    public PanelView g0;
    public EndCardView h0;
    public r3 i0;
    public l j0;
    public CountDownView k0;
    public CloseImageView l0;
    public ViewGroup m0;
    public MuteImageView n0;
    public FullScreenHeaderPanelView o0;
    public ValueAnimator p0;
    public j q0;
    public e r0;
    public final r s0;
    public v t0;
    public boolean u0;
    public boolean v0;
    public final d1 w0;
    public int x0;
    public int y0;
    public int z0;

    public BaseScreenATView(Context context) {
        super(context);
        this.P = 100;
        this.U = false;
        this.w0 = new d1(this);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    private void getScreenParams() {
        int[] iArr;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                Context context = getContext();
                if (context instanceof Activity) {
                    Rect bounds = ((Activity) context).getWindowManager().getCurrentWindowMetrics().getBounds();
                    if (bounds.width() <= 0 || bounds.height() <= 0) {
                        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                        iArr = new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
                    } else {
                        iArr = new int[]{bounds.width(), bounds.height()};
                    }
                } else {
                    DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
                    iArr = new int[]{displayMetrics2.widthPixels, displayMetrics2.heightPixels};
                }
            } catch (Throwable unused) {
            }
        } else {
            DisplayMetrics displayMetrics3 = getResources().getDisplayMetrics();
            iArr = new int[]{displayMetrics3.widthPixels, displayMetrics3.heightPixels};
        }
        int i = iArr[0];
        this.F = i;
        int i2 = iArr[1];
        this.G = i2;
        this.x0 = i;
        this.y0 = i2;
    }

    public abstract void A();

    public void B() {
        destroy();
        f fVarA = f.a();
        fVarA.b.removeCallbacks(this.w0);
        ValueAnimator valueAnimator = this.p0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void C() {
        com.smartdigimkt.b3.e eVar;
        BasePlayerView basePlayerView;
        a(103);
        d dVar = this.n;
        if (dVar != null && (basePlayerView = dVar.h) != null && basePlayerView.getParent() != null && (dVar.h.getParent() instanceof ViewGroup) && (!c0.h(this.c, this.b) || this.l)) {
            F();
        }
        d(8);
        if (getCloseView() != null) {
            a aVar = this.b;
            double d = this.g ? 1.0d : (aVar == null || (eVar = aVar.s) == null) ? 1.0d : eVar.o1;
            CloseImageView closeView = getCloseView();
            float f = this.c0;
            if (closeView != null) {
                closeView.setClickAreaScaleFactor(f);
                closeView.setClickViewAlpha(d);
            }
        }
        MuteImageView muteImageView = this.n0;
        if (muteImageView != null && muteImageView.getVisibility() != 8) {
            this.n0.setVisibility(8);
        }
        FullScreenHeaderPanelView fullScreenHeaderPanelView = this.o0;
        if (fullScreenHeaderPanelView == null || fullScreenHeaderPanelView.getVisibility() == 8) {
            return;
        }
        this.o0.setVisibility(8);
    }

    public final void D() {
        g gVar;
        this.U = true;
        try {
            l lVar = this.j0;
            if (lVar == null || (gVar = lVar.a) == null || !gVar.isShowing()) {
                a(110);
                d dVar = this.n;
                if (dVar != null) {
                    dVar.d();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void E();

    public void F() {
        BasePlayerView basePlayerView;
        d dVar = this.n;
        if (dVar == null || (basePlayerView = dVar.h) == null || basePlayerView.getParent() == null) {
            return;
        }
        ((ViewGroup) dVar.h.getParent()).removeView(dVar.h);
        dVar.h = null;
    }

    public void G() {
    }

    public void H() {
    }

    public void I() {
    }

    public final void J() {
        com.smartdigimkt.b3.e eVar;
        if (getFeedbackButton() != null && getFeedbackButton().getVisibility() != 0) {
            getFeedbackButton().setVisibility(0);
        }
        this.d0 = true;
        View view = this.m;
        if (view != null && (view instanceof CTAButtonLayout) && ((CTAButtonLayout) view).needInterceptCloseViewShow()) {
            ((CTAButtonLayout) this.m).activateSubCloseButton();
            boolean z = this.V;
            if (!z) {
                return;
            }
            if (z && getPanelView() != null && getPanelView().getVisibility() == 0) {
                return;
            }
        }
        if (getCloseView() == null || getCloseView().getVisibility() == 0) {
            return;
        }
        getCloseView().setVisibility(0);
        a aVar = this.b;
        double d = this.g ? 1.0d : (aVar == null || (eVar = aVar.s) == null) ? 1.0d : eVar.o1;
        CloseImageView closeView = getCloseView();
        float f = this.c0;
        if (closeView != null) {
            closeView.setClickAreaScaleFactor(f);
            closeView.setClickViewAlpha(d);
        }
    }

    public void K() {
        int i;
        a(102);
        this.V = true;
        this.O = getPanelViewTypeForShowEndCard();
        EndCardView endCardView = this.h0;
        if (endCardView != null && (endCardView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.h0.getParent()).removeView(this.h0);
        }
        EndCardView endCardView2 = new EndCardView(getContext(), this.c, this.b);
        endCardView2.setSize(this.F, this.G);
        int iNextInt = 0;
        endCardView2.init(false, false, new h1(this));
        this.h0 = endCardView2;
        E();
        endCardView2.load();
        if (b(this.O)) {
            L();
            PanelView panelView = getPanelView();
            if (panelView != null && panelView.getVisibility() == 0) {
                if (panelView.getCTAButton() == null || panelView.getCTAButton().getVisibility() != 0) {
                    setTrackClickAreaView(panelView);
                } else {
                    setTrackClickAreaView(panelView.getCTAButton());
                }
            }
        }
        C();
        EndCardView endCardView3 = this.h0;
        if (endCardView3 != null) {
            g1 g1Var = new g1(this);
            com.smartdigimkt.b3.e eVar = this.b.s;
            if (!this.d0 && eVar != null && (i = (int) (eVar.t / 100.0f)) != 0) {
                Random random = new Random();
                if (random.nextInt(100) <= i) {
                    int i2 = eVar.u;
                    int i3 = eVar.v;
                    if (i3 > 0) {
                        if (i2 == i3) {
                            iNextInt = i2;
                        } else {
                            try {
                                iNextInt = random.nextInt(i3 - i2) + i2;
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            }
            endCardView3.postDelayed(g1Var, iNextInt);
        }
        s.a(6, this.c, d());
    }

    public void L() {
        PanelView panelView = getPanelView();
        if (panelView != null) {
            if (panelView.getVisibility() != 0) {
                a(104);
                panelView.setVisibility(0);
            }
            if (panelView.getCTAButton() == null || panelView.getCTAButton().getVisibility() != 0) {
                return;
            }
            View view = this.m;
            if (view == null || !view.equals(panelView.getCTAButton())) {
                if (this.m != null && (panelView.getCTAButton() instanceof CTAButtonLayout)) {
                    View view2 = this.m;
                    if (view2 instanceof CTAButtonLayout) {
                        String majorCTAText = ((CTAButtonLayout) view2).getMajorCTAText();
                        if (!TextUtils.isEmpty(majorCTAText)) {
                            ((CTAButtonLayout) panelView.getCTAButton()).setMajorCTAText(majorCTAText);
                        }
                    }
                }
                this.m = panelView.getCTAButton();
            }
        }
    }

    public void M() {
        if (this.o0 == null) {
            G();
        }
        FullScreenHeaderPanelView fullScreenHeaderPanelView = this.o0;
        if (fullScreenHeaderPanelView == null || fullScreenHeaderPanelView.getVisibility() == 0) {
            return;
        }
        ValueAnimator valueAnimator = this.p0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
        this.p0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.p0.addUpdateListener(new z0(this));
        this.p0.start();
        this.o0.setAlpha(0.2f);
        this.o0.setVisibility(0);
    }

    public void N() {
        d(0);
        MuteImageView muteImageView = this.n0;
        if (muteImageView != null && muteImageView.getVisibility() != 0) {
            this.n0.setVisibility(0);
        }
        H();
    }

    public final void O() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.f();
        }
    }

    public void a(List list) {
        I();
        if (this.J == 0) {
            J();
        }
        d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.i = new e1(this);
        v vVar = this.t0;
        if (vVar != null) {
            d0 d0Var = (d0) vVar;
            d0Var.d = "1";
            BaseATActivity baseATActivity = d0Var.e;
            int i = BaseATActivity.A;
            baseATActivity.a("4", 0L);
        }
        if (g()) {
            this.n.a(this.a0, list);
        }
        if (this.P == 1) {
            K();
            return;
        }
        BasePlayerView basePlayerView = this.n.h;
        if (basePlayerView != null) {
            basePlayerView.setVisibility(0);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void b() {
        getScreenParams();
        getMaterialRealSize();
    }

    public abstract boolean b(int i);

    public void c(int i) {
        m mVarD = d();
        mVarD.g = getAdClickRecord();
        s.a(7, this.c, mVarD);
        if (this.t0 != null) {
            k.a(this.c, this.b, this.y, this.x);
            v vVar = this.t0;
            vVar.b = i;
            vVar.a();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final m d() {
        m mVar = new m(this.b, this.h);
        View viewO = o();
        mVar.e = viewO.getWidth();
        mVar.f = viewO.getHeight();
        d dVar = this.n;
        if (dVar != null) {
            mVar.h = dVar.a(true);
        }
        try {
            int[] iArr = new int[2];
            viewO.getLocationOnScreen(iArr);
            mVar.l = iArr[0];
            mVar.m = iArr[1];
        } catch (Throwable unused) {
        }
        d dVar2 = this.n;
        if (dVar2 != null) {
            mVar.h = dVar2.a(true);
        }
        mVar.n = this.v;
        return mVar;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        this.t0 = null;
        d dVar = this.n;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void e() {
        com.smartdigimkt.b2.g gVar;
        com.smartdigimkt.x1.d dVar;
        super.e();
        e0 e0Var = this.o;
        if (e0Var != null) {
            c1 c1Var = new c1(this);
            ArrayList arrayList = e0Var.e;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = e0Var.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        gVar = null;
                        break;
                    }
                    com.smartdigimkt.b2.f fVar = (com.smartdigimkt.b2.f) it.next();
                    if (fVar instanceof com.smartdigimkt.b2.g) {
                        gVar = (com.smartdigimkt.b2.g) fVar;
                        break;
                    }
                }
            } else {
                gVar = null;
                break;
            }
            if (gVar != null && (dVar = gVar.i) != null) {
                dVar.h = c1Var;
            }
        }
        d dVar2 = this.n;
        if (dVar2 != null) {
            dVar2.g = this.o;
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public List<View> getAutoClickCTAViews() {
        ArrayList arrayList = new ArrayList(2);
        PanelView panelView = getPanelView();
        if (panelView != null) {
            arrayList.add(panelView.getCTAButton());
        }
        arrayList.add(this.m);
        return arrayList;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public View getAutoClickPanelView() {
        return getPanelView();
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public View getAutoClickRootView() {
        return this.f0;
    }

    public float getCloseButtonScaleFactor() {
        return this.c0;
    }

    public CloseImageView getCloseView() {
        return this.l0;
    }

    public ViewGroup getFeedbackButton() {
        return this.m0;
    }

    public long getHideBannerTime() {
        return this.M;
    }

    public void getMaterialRealSize() {
        int i;
        String str = this.c.f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c cVar = this.c;
        synchronized (cVar) {
            i = cVar.E;
        }
        if (i > 0 || this.c.b() > 0) {
            this.z0 = this.c.c();
            int iB = this.c.b();
            this.A0 = iB;
            this.x0 = this.z0;
            this.y0 = iB;
            return;
        }
        f.a().getClass();
        if (f.c()) {
            return;
        }
        com.smartdigimkt.z.e0.a().getClass();
        int[] iArrA = com.smartdigimkt.s4.d.a(com.smartdigimkt.z.e0.a(1, str));
        if (iArrA != null) {
            int i2 = iArrA[0];
            this.z0 = i2;
            int i3 = iArrA[1];
            this.A0 = i3;
            this.x0 = i2;
            this.y0 = i3;
        }
    }

    public PanelView getPanelView() {
        return this.g0;
    }

    public abstract int getPanelViewTypeForShowEndCard();

    public int getPlayerViewType() {
        return this.P;
    }

    public long getShowBannerTime() {
        return this.K;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.E == 2) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, com.smartdigimkt.r4.k.a(getContext(), 154.0f));
        } else {
            int measuredHeight = (getMeasuredHeight() * 2) / 3;
            layoutParams.addRule(11);
            layoutParams.setMargins(0, measuredHeight, 0, 0);
        }
        return layoutParams;
    }

    public void handleFullScreenClick() {
    }

    public boolean hasReward() {
        return this.W;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void i() {
        int i;
        v vVar = this.t0;
        if (vVar != null) {
            int i2 = this.P;
            if (i2 == 101) {
                i = 7;
            } else if (i2 != 1) {
                i = 3;
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = 5;
                        if (i2 != 4) {
                            i = i2 != 5 ? 1 : 6;
                        }
                    } else {
                        i = 4;
                    }
                }
            } else {
                i = this.b.s.j0 == 1 ? 2 : 8;
            }
            w wVar = new w();
            wVar.c = i;
            if ((this instanceof LetterFullScreenATView) || (this instanceof LetterHalfScreenATView)) {
                wVar.d = 1;
            } else {
                wVar.d = 2;
            }
            if (this instanceof FullScreenATView) {
                wVar.f = false;
            } else {
                wVar.f = true;
            }
            wVar.g = this.b.s.c1;
            vVar.b(wVar);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView, com.smartdigimkt.p3.d
    public int impressionMaterialType() {
        return c0.a(this.c, this.b);
    }

    public void init() {
        x();
        if (this.V) {
            K();
            return;
        }
        int i = this.D;
        if (1 == i) {
            if (this.P == 100) {
                a((List) null);
                return;
            } else {
                f.a().c(new y0(this, new f1(this)));
                return;
            }
        }
        if (3 == i) {
            if (c0.h(this.c, this.b)) {
                a(new ArrayList());
                return;
            }
            K();
            Math.max(0, this.b.s.R);
            this.A = new a1(this);
            c();
            H();
        }
    }

    public boolean isShowEndCard() {
        return this.V;
    }

    public boolean isVideoMute() {
        return this.a0;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void k() {
        a aVar;
        com.smartdigimkt.b3.e eVar;
        this.b0 = false;
        f.a().a(new j1(this));
        if (this.e0 && this.D == 3 && (aVar = this.b) != null && (eVar = aVar.s) != null && eVar.A0 == 1) {
            d dVar = this.n;
            if (dVar != null) {
                dVar.f();
            }
            c(6);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void l() {
        this.b0 = true;
        if (this.i0 == null) {
            this.i0 = new r3(this.f0);
        }
        r3 r3Var = this.i0;
        ImageView imageView = r3Var.b;
        if (imageView != null) {
            r3Var.a.removeView(imageView);
        }
        r3Var.a.post(new o3(r3Var));
        r3Var.b.post(new p3(r3Var));
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final View o() {
        RelativeLayout relativeLayout = this.f0;
        return relativeLayout != null ? relativeLayout : this;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        d dVar;
        BasePlayerView basePlayerView;
        if (!y() || (dVar = this.n) == null || (basePlayerView = dVar.h) == null || !(basePlayerView instanceof WebLandpagePlayerView)) {
            return;
        }
        ((WebLandpagePlayerView) basePlayerView).onActivityResult(i, i2, intent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int iMax = Math.max(1, i3 - i);
        int iMax2 = Math.max(1, i4 - i2);
        if (iMax == this.F && iMax2 == this.G) {
            return;
        }
        this.F = iMax;
        this.G = iMax2;
        this.E = iMax > iMax2 ? 2 : 1;
        EndCardView endCardView = this.h0;
        if (endCardView instanceof EndCardView) {
            endCardView.setSize(iMax, iMax2);
        }
        j();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        g gVar;
        super.onWindowFocusChanged(z);
        if (z && this.U && this.n != null) {
            l lVar = this.j0;
            if (lVar == null || (gVar = lVar.a) == null || !gVar.isShowing()) {
                this.n.e();
            }
        }
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public void r() {
        if (getPanelView() == null || getPanelView().getVisibility() == 8) {
            return;
        }
        getPanelView().setVisibility(8);
    }

    public void s() {
        j jVar = new j(this.c, this.b);
        this.q0 = jVar;
        jVar.a(this);
    }

    public void setCloseButtonScaleFactor(float f) {
        this.c0 = f;
        if (getCloseView() != null) {
            getCloseView().setClickAreaScaleFactor(this.c0);
        }
    }

    public void setCountDownDuration(long j) {
        e eVar = this.r0;
        if (eVar != null) {
            eVar.d = j;
            CountDownView countDownView = eVar.b;
            if (countDownView != null) {
                countDownView.setDuration(j);
            }
        }
    }

    public void setHasReward(boolean z) {
        this.W = z;
    }

    public void setHideBannerTime(long j) {
        this.M = j;
    }

    public void setIsShowEndCard(boolean z) {
        this.V = z;
    }

    public void setListener(v vVar) {
        this.t0 = vVar;
    }

    public void setShowBannerTime(long j) {
        this.K = j;
    }

    public void setVideoMute(boolean z) {
        this.a0 = z;
    }

    public void t() {
        if (getCloseView() != null) {
            this.c0 = a((j3) getCloseView(), false);
            getCloseView().setVisibility(8);
            getCloseView().setOnClickListener(new u0(this));
        }
    }

    public void u() {
        if (getFeedbackButton() != null) {
            getFeedbackButton().setOnClickListener(new v0(this));
        }
    }

    public void v() {
    }

    public void w() {
        PanelView panelView = this.g0;
        if (panelView != null) {
            panelView.setVisibility(4);
            PanelView panelView2 = this.g0;
            c cVar = this.c;
            a aVar = this.b;
            panelView2.init(cVar, aVar, this.E, c0.d(aVar), new s0(this));
        }
    }

    public void x() {
        this.f0 = (RelativeLayout) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_rl_root", "id"));
        this.l0 = (CloseImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_btn_close_id", "id"));
        this.g0 = (PanelView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_banner_view_id", "id"));
        this.k0 = (CountDownView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_count_down_view_id", "id"));
        this.n0 = (MuteImageView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.m0 = (ViewGroup) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_feedback_ll_id", "id"));
        d dVar = new d(this, this.b, this.c, this.E);
        this.n = dVar;
        int aTViewType = getATViewType();
        BasePlayerView basePlayerView = dVar.h;
        if (basePlayerView != null) {
            basePlayerView.setViewType(aTViewType);
        }
        e0 e0Var = this.o;
        if (e0Var != null) {
            this.n.g = e0Var;
            HashMap map = new HashMap();
            map.put("material_direction", Integer.valueOf(this.x0 > this.y0 ? 2 : 1));
            this.o.a(map);
        }
        this.n.j = new b1(this);
        this.r0 = new e(this.b.s, this.k0, (WebProgressBarView) findViewById(com.smartdigimkt.r4.k.a(getContext(), "myoffer_player_view_progress_bar_id", "id")));
        s();
        d(4);
        MuteImageView muteImageView = this.n0;
        if (muteImageView != null) {
            if (muteImageView != null && muteImageView.getVisibility() != 4) {
                this.n0.setVisibility(4);
            }
            if (this.a0) {
                this.n0.setMute(true);
            } else {
                this.n0.setMute(false);
            }
            this.n0.setOnClickListener(new t0(this));
        }
        t();
        u();
        w();
        v();
        this.N = b(this.O);
    }

    public final boolean y() {
        d dVar;
        BasePlayerView basePlayerView;
        return this.D == 1 && this.P == 101 && (dVar = this.n) != null && (basePlayerView = dVar.h) != null && (basePlayerView instanceof WebLandpagePlayerView);
    }

    public void z() {
        v vVar;
        if (1 == this.D) {
            J();
            if (this.W) {
                return;
            }
            this.W = true;
            if (this.f || (vVar = this.t0) == null) {
                return;
            }
            vVar.b();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void h() {
        com.smartdigimkt.h0.g gVar = new com.smartdigimkt.h0.g(b.k, b.ag);
        v vVar = this.t0;
        if (vVar != null) {
            vVar.a(gVar);
        }
        if (c0.h(this.c, this.b)) {
            if (this.o != null) {
                HashMap map = new HashMap();
                map.put("video_play_fail_message", "code[ 40002 ],desc[ the ad has been due ]");
                this.o.a(map);
            }
            a(108);
            this.l = true;
            if (!this.V) {
                K();
            }
            d dVar = this.n;
            if (dVar != null) {
                dVar.b();
            }
            F();
        }
    }

    public void b(long j) {
        e eVar = this.r0;
        if (eVar != null) {
            CountDownView countDownView = eVar.b;
            if (countDownView != null) {
                countDownView.refresh(j);
            }
            WebProgressBarView webProgressBarView = eVar.c;
            if (webProgressBarView != null) {
                long j2 = eVar.d;
                if (j2 > 0) {
                    webProgressBarView.setProgress((int) ((j * 100.0d) / j2));
                } else {
                    webProgressBarView.setProgress(100);
                }
            }
        }
    }

    public void d(int i) {
        e eVar = this.r0;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(int i, int i2) {
        this.c0 = a((j3) getCloseView(), true);
        if (this.b0 || this.c == null) {
            return;
        }
        if (i == -100) {
            A();
        } else {
            super.a(i, i2);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(w wVar) {
        this.e0 = true;
        v vVar = this.t0;
        if (vVar != null) {
            vVar.a(wVar);
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.BaseATView
    public final void a(boolean z) {
        v vVar = this.t0;
        if (vVar != null) {
            vVar.a(z);
        }
    }

    public void a(long j) {
        long j2 = this.M;
        if (j2 >= 0 && j > j2) {
            r();
        } else if (this.N) {
            long j3 = this.K;
            if (j3 >= 0 && j >= j3) {
                L();
            }
        }
        if (j <= this.R) {
            if (j >= this.Q) {
                M();
            }
        } else {
            FullScreenHeaderPanelView fullScreenHeaderPanelView = this.o0;
            if (fullScreenHeaderPanelView == null || fullScreenHeaderPanelView.getVisibility() == 8) {
                return;
            }
            this.o0.setVisibility(8);
        }
    }

    public final void a(PanelView panelView) {
        if (this.q0 == null) {
            return;
        }
        if (panelView != null && panelView.hasApkComplianceElements()) {
            j jVar = this.q0;
            if (!jVar.m) {
                jVar.m = true;
                ImageView imageView = jVar.e;
                jVar.n = imageView != null ? imageView.getVisibility() : 8;
                ViewGroup viewGroup = jVar.a;
                jVar.o = viewGroup != null ? viewGroup.getVisibility() : 8;
            }
            ImageView imageView2 = jVar.e;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ViewGroup viewGroup2 = jVar.a;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
                return;
            }
            return;
        }
        j jVar2 = this.q0;
        if (jVar2.m) {
            jVar2.m = false;
            ImageView imageView3 = jVar2.e;
            if (imageView3 != null) {
                imageView3.setVisibility(jVar2.n);
            }
            ViewGroup viewGroup3 = jVar2.a;
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(jVar2.o);
            }
        }
    }

    public BaseScreenATView(Context context, a aVar, c cVar, String str, int i, int i2) {
        com.smartdigimkt.b3.e eVar;
        super(context, aVar, cVar, str);
        this.P = 100;
        this.U = false;
        this.w0 = new d1(this);
        this.D = i;
        this.E = i2;
        this.u0 = false;
        this.d0 = false;
        this.v0 = false;
        if (aVar != null && (eVar = aVar.s) != null && c0.a(eVar)) {
            this.s0 = new r(cVar, aVar.s);
        }
        com.smartdigimkt.b3.e eVar2 = this.b.s;
        int i3 = eVar2.c;
        long j = i3 > 0 ? i3 * 1000 : i3;
        this.K = j;
        int i4 = eVar2.d;
        long j2 = i4 > 0 ? i4 * 1000 : i4;
        this.L = j2;
        if (j2 > 0 && j >= 0) {
            this.M = j + j2;
        } else {
            this.M = j2;
        }
        long j3 = eVar2.C0;
        this.Q = j3;
        long j4 = eVar2.D0;
        if (j4 > 0) {
            this.R = j3 + j4;
        }
        this.J = eVar2.g * 1000;
        this.a0 = eVar2.f == 0;
        if (1 == i) {
            if (this.c.h()) {
                this.P = 100;
            } else {
                com.smartdigimkt.b3.e eVar3 = this.b.s;
                if (eVar3.i0 == 1) {
                    this.P = 101;
                } else {
                    int i5 = eVar3.j0;
                    if (i5 > 0) {
                        this.P = i5;
                    }
                }
            }
            long j5 = this.b.s.x;
            this.T = j5 <= 0 ? 30000L : j5;
        }
    }
}
