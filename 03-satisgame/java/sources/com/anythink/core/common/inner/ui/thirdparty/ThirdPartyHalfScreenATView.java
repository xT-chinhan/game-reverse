package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.o;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.e;
import com.anythink.core.common.inner.ui.HalfScreenATView;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.g;
import com.anythink.core.common.u.p;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyHalfScreenATView extends HalfScreenATView implements com.anythink.core.common.k.e.a.c {
    private static final String P = "ThirdPartyHalfScreenATView";
    private BaseAd Q;
    private View R;
    private Timer S;
    private com.anythink.core.common.inner.mixad.f.b T;
    private boolean U;
    private boolean V;
    private FrameLayout W;
    private CountDownTimer aa;

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView
    public boolean isAttachRoot() {
        return false;
    }

    static /* synthetic */ boolean b(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView) {
        thirdPartyHalfScreenATView.U = true;
        return true;
    }

    static /* synthetic */ boolean n(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView) {
        thirdPartyHalfScreenATView.V = true;
        return true;
    }

    public ThirdPartyHalfScreenATView(Context context) {
        super(context);
        this.U = false;
        this.V = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartyHalfScreenATView(Context context, x xVar, w wVar, String str, int i, int i2, BaseAd baseAd, com.anythink.core.common.k.a aVar) {
        FrameLayout.LayoutParams layoutParams;
        super(context, xVar, wVar, str, i, i2);
        this.U = false;
        this.V = false;
        this.Q = baseAd;
        this.R = baseAd.getAdMediaView(new Object[0]);
        if (aVar instanceof View) {
            View view = (View) aVar;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams.gravity = 17;
            this.W.addView(view, layoutParams);
        }
        if (F()) {
            this.r = -1;
        }
    }

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView, com.anythink.core.common.inner.ui.BaseATView
    protected final void a() {
        super.a();
        this.W = new FrameLayout(getContext());
        this.W.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.W.addView(this.K);
        addView(this.W);
    }

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView, com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void b() {
        ViewGroup customAdContainer;
        super.b();
        if (this.A != null) {
            this.A.setVisibility(8);
        }
        try {
            if (this.v != null && (customAdContainer = this.Q.getCustomAdContainer()) != null) {
                handleFullScreenClick(customAdContainer);
                ViewParent parent = this.v.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int iIndexOfChild = viewGroup.indexOfChild(this.v);
                    if (iIndexOfChild >= 0) {
                        viewGroup.removeViewAt(iIndexOfChild);
                    }
                    ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = customAdContainer.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height);
                    } else {
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).gravity = 17;
                        } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) layoutParams2).addRule(13);
                        } else if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                            ((LinearLayout.LayoutParams) layoutParams2).gravity = 17;
                        }
                        layoutParams2.width = layoutParams.width;
                        layoutParams2.height = layoutParams.height;
                    }
                    customAdContainer.addView(this.v, layoutParams2);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
                    layoutParams3.addRule(13);
                    layoutParams3.leftMargin = p.a(getContext(), 26.0f);
                    layoutParams3.rightMargin = p.a(getContext(), 26.0f);
                    if (customAdContainer.getParent() instanceof ViewGroup) {
                        ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                    }
                    viewGroup.addView(customAdContainer, iIndexOfChild, layoutParams3);
                }
            }
        } catch (Throwable th) {
            Log.e("anythink", "addCustomAdContainer error", th);
        }
        View viewFindViewById = findViewById(p.a(getContext(), "myoffer_ad_lable", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
    }

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView, com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void j() {
        View cTAButton;
        super.j();
        String strO = this.g != null ? this.g.o() : "";
        if (this.w == null || !TextUtils.isEmpty(strO) || (cTAButton = this.w.getCTAButton()) == null) {
            return;
        }
        cTAButton.setVisibility(8);
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    public void init() {
        BaseAd baseAd;
        b();
        this.o = a(this.p);
        this.Q.setNativeEventListener(new o() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyHalfScreenATView.1
            @Override // com.anythink.core.common.d.n
            public final void onAdActReward(int i) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdActRewardSuccess() {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdDislikeButtonClick() {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoProgress(int i) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onDeeplinkCallback(boolean z) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdImpressed() {
                if (ThirdPartyHalfScreenATView.this.U) {
                    return;
                }
                ThirdPartyHalfScreenATView.b(ThirdPartyHalfScreenATView.this);
                if (ThirdPartyHalfScreenATView.this.E != null) {
                    ThirdPartyHalfScreenATView.this.E.a(new e());
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdClicked(View view) {
                int iA = com.anythink.core.common.inner.mixad.f.b.a;
                if (ThirdPartyHalfScreenATView.this.T != null) {
                    iA = ThirdPartyHalfScreenATView.this.T.a();
                }
                ThirdPartyHalfScreenATView.this.hasClick = true;
                int i = com.anythink.core.common.inner.mixad.f.b.g;
                if (ThirdPartyHalfScreenATView.this.z != null) {
                    if (ThirdPartyHalfScreenATView.this.z.isTouch()) {
                        i = com.anythink.core.common.inner.mixad.f.b.h;
                    }
                    ThirdPartyHalfScreenATView.this.z.setVisibility(8);
                }
                if (ThirdPartyHalfScreenATView.this.E != null) {
                    ThirdPartyHalfScreenATView.this.E.b(new e().a(i, iA));
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoStart() {
                if (ThirdPartyHalfScreenATView.this.E != null) {
                    ThirdPartyHalfScreenATView.this.E.a();
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoEnd() {
                if (ThirdPartyHalfScreenATView.this.V) {
                    return;
                }
                ThirdPartyHalfScreenATView.n(ThirdPartyHalfScreenATView.this);
                ThirdPartyHalfScreenATView.this.p();
                if (ThirdPartyHalfScreenATView.this.E != null) {
                    ThirdPartyHalfScreenATView.this.E.b();
                }
                ThirdPartyHalfScreenATView.this.f();
            }

            @Override // com.anythink.core.common.d.o
            public final void a(String str, String str2) {
                ThirdPartyHalfScreenATView.this.f();
                ThirdPartyHalfScreenATView.this.a(com.anythink.core.common.inner.b.b.a(str, str2));
            }
        });
        if (this.s) {
            f();
        } else if (3 == this.a) {
            boolean z = true;
            if (!F() && ((baseAd = this.Q) == null || !TextUtils.equals(baseAd.getAdType(), "1") || this.R == null)) {
                z = false;
            }
            if (z) {
                c();
            } else {
                f();
            }
            if (this.n <= 0) {
                b(8);
                p();
            } else {
                b(this.n);
                b(0);
            }
            if (this.n > 0) {
                if (this.aa == null) {
                    this.aa = new AnonymousClass4(this.n).start();
                }
            } else {
                p();
            }
        }
        D();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void c() {
        BaseAd baseAd;
        try {
            if (this.R == null || (baseAd = this.Q) == null) {
                return;
            }
            baseAd.getVideoDuration();
            View viewFindViewById = findViewById(p.a(getContext(), "myoffer_player_view_id", "id"));
            if (viewFindViewById != null) {
                this.v.addView(this.R, 1, viewFindViewById.getLayoutParams());
            }
            n();
            y();
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void i() {
        if (this.w != null) {
            this.w.setVisibility(4);
            this.w.init(this.g, this.f, this.b, false, null);
            if (this.Q != null) {
                this.w.setBaseAdIconView(this.Q.getAdIconView());
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void k() {
        if (this.B == null) {
            return;
        }
        if (this.u) {
            this.B.setMute(true);
        } else {
            this.B.setMute(false);
        }
        this.B.setVisibility(4);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyHalfScreenATView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ThirdPartyHalfScreenATView.this.R == null || ThirdPartyHalfScreenATView.this.B == null || ThirdPartyHalfScreenATView.this.Q == null) {
                    return;
                }
                ThirdPartyHalfScreenATView thirdPartyHalfScreenATView = ThirdPartyHalfScreenATView.this;
                thirdPartyHalfScreenATView.u = !thirdPartyHalfScreenATView.u;
                ThirdPartyHalfScreenATView.this.B.setMute(ThirdPartyHalfScreenATView.this.u);
                ThirdPartyHalfScreenATView.this.Q.setVideoMute(ThirdPartyHalfScreenATView.this.u);
            }
        });
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void n() {
        super.n();
        if (this.f == null) {
            return;
        }
        int i = this.f.j;
        if (this.B == null || i == 8) {
            return;
        }
        this.B.setVisibility(8);
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void p() {
        if (s() != null && s().getVisibility() != 0) {
            s().setVisibility(0);
        }
        CountDownTimer countDownTimer = this.aa;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.aa = null;
        }
        if (this.z != null) {
            if (this.r >= this.ranDom && !this.hasClick) {
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView, com.anythink.core.common.inner.ui.BaseScreenATView
    protected final boolean a(int i) {
        if (i == 3 || i == 4) {
            return com.anythink.core.common.inner.a.a.a(this.g);
        }
        return i == 7;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void f() {
        if (F()) {
            return;
        }
        if (this.g != null && TextUtils.isEmpty(this.g.m()) && this.R == null) {
            return;
        }
        super.f();
    }

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView, com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void q() {
        if (E()) {
            al.a(this.R);
            View viewFindViewById = findViewById(p.a(getContext(), "myoffer_player_view_id", "id"));
            if (viewFindViewById != null) {
                this.v.addView(this.R, 1, viewFindViewById.getLayoutParams());
            }
        } else {
            super.q();
        }
        D();
        y();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void r() {
        if (this.R != null && !E() && this.R.getParent() != null) {
            ((ViewGroup) this.R.getParent()).removeView(this.R);
        }
        b(8);
        if (this.B != null) {
            this.B.setVisibility(8);
        }
    }

    @Override // com.anythink.core.common.inner.ui.HalfScreenATView, com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void h() {
        String strM = this.g.m();
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        com.anythink.core.common.inner.a.b.a();
        int[] iArrA = g.a(com.anythink.core.common.inner.a.b.a(strM));
        if (iArrA != null) {
            this.I = iArrA[0];
            this.J = iArrA[1];
            this.G = this.I;
            this.H = this.J;
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView, com.anythink.core.common.inner.ui.BaseATView
    public void destroy() {
        super.destroy();
        Timer timer = this.S;
        if (timer != null) {
            timer.cancel();
            this.S = null;
        }
        CountDownTimer countDownTimer = this.aa;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.aa = null;
        }
        BaseAd baseAd = this.Q;
        if (baseAd != null) {
            baseAd.setNativeEventListener(null);
            this.Q.clear(this);
            this.Q.destroy();
        }
        if (this.v != null) {
            this.v.removeAllViews();
        }
        if (this.w != null) {
            this.w.removeAllViews();
        }
        if (this.x != null) {
            this.x.mListener = null;
        }
        if (this.A != null) {
            this.A.setOnClickListener(null);
            this.A.removeAllViews();
        }
        removeAllViews();
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        if (this.r >= this.ranDom) {
            arrayList.add(this.z);
        } else if (this.z != null) {
            this.z.setVisibility(8);
        }
        int iQ = this.f.t.q();
        if (iQ == 0) {
            arrayList.addAll(this.w.getClickViews());
            arrayList.add(this.w);
            if (this.x != null) {
                arrayList.add(this.x);
            }
        } else if (iQ == 1) {
            if (this.w.getCTAButton() != null) {
                arrayList.add(this.w.getCTAButton());
            }
            if (u()) {
                c.a(this.Q.getAdIconView());
            }
        } else if (iQ == 2) {
            arrayList.addAll(this.w.getClickViews());
            arrayList.add(this.w);
        }
        final com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        bVar.a(this.w.getTitleView());
        bVar.d(this.w.getDescView());
        bVar.e(this.w.getCTAButton());
        bVar.b(this.w.getIconView());
        b.a(this.v, this.Q, new b.a() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyHalfScreenATView.3
            @Override // com.anythink.core.common.inner.ui.thirdparty.b.a
            public final void a(View view, View view2, View view3) {
                bVar.g(view);
                bVar.h(view2);
                bVar.f(view3);
            }
        });
        this.Q.registerListener(this.W, arrayList, com.anythink.core.common.inner.mixad.f.a.a(this.f.j, 0, 0), bVar);
    }

    private void z() {
        if (this.n <= 0) {
            b(8);
            p();
        } else {
            b(this.n);
            b(0);
        }
        if (this.n > 0) {
            if (this.aa == null) {
                this.aa = new AnonymousClass4(this.n).start();
                return;
            }
            return;
        }
        p();
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyHalfScreenATView$4, reason: invalid class name */
    final class AnonymousClass4 extends CountDownTimer {
        AnonymousClass4(long j) {
            super(j, 500L);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            ThirdPartyHalfScreenATView.a(ThirdPartyHalfScreenATView.this, j);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            ThirdPartyHalfScreenATView.this.p();
            ThirdPartyHalfScreenATView.this.b(8);
        }
    }

    private void A() {
        Timer timer = this.S;
        if (timer != null) {
            timer.cancel();
            this.S = null;
        }
        CountDownTimer countDownTimer = this.aa;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.aa = null;
        }
    }

    private boolean B() {
        if (F()) {
            return true;
        }
        BaseAd baseAd = this.Q;
        return (baseAd == null || !TextUtils.equals(baseAd.getAdType(), "1") || this.R == null) ? false : true;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyHalfScreenATView$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ long a;

        AnonymousClass5(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ThirdPartyHalfScreenATView.this.a(this.a);
        }
    }

    private void c(long j) {
        post(new AnonymousClass5(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.k.a aVar) {
        FrameLayout.LayoutParams layoutParams;
        if (aVar instanceof View) {
            View view = (View) aVar;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams.gravity = 17;
            this.W.addView(view, layoutParams);
        }
    }

    private void C() {
        ViewGroup customAdContainer;
        if (this.v == null || (customAdContainer = this.Q.getCustomAdContainer()) == null) {
            return;
        }
        handleFullScreenClick(customAdContainer);
        ViewParent parent = this.v.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this.v);
            if (iIndexOfChild >= 0) {
                viewGroup.removeViewAt(iIndexOfChild);
            }
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = customAdContainer.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height);
            } else {
                if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams2).gravity = 17;
                } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).addRule(13);
                } else if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams2).gravity = 17;
                }
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            }
            customAdContainer.addView(this.v, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams3.addRule(13);
            layoutParams3.leftMargin = p.a(getContext(), 26.0f);
            layoutParams3.rightMargin = p.a(getContext(), 26.0f);
            if (customAdContainer.getParent() instanceof ViewGroup) {
                ((ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            viewGroup.addView(customAdContainer, iIndexOfChild, layoutParams3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.core.common.inner.mixad.f.b bVar = this.T;
        if (bVar != null) {
            bVar.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void D() {
        ArrayList arrayList = new ArrayList();
        View view = this.R;
        if (view != null) {
            arrayList.add(view);
        }
        if (this.x != null) {
            arrayList.add(this.x);
        }
        if (this.w != null) {
            arrayList.add(this.w.getIconView());
        }
        this.T = new com.anythink.core.common.inner.mixad.f.b.a().a(arrayList).a(this.w.getTitleView()).b(this.w.getDescView()).c(this.w.getCTAButton()).a();
    }

    private boolean E() {
        return (this.g == null || !TextUtils.isEmpty(this.g.m()) || this.R == null) ? false : true;
    }

    private boolean F() {
        BaseAd baseAd = this.Q;
        return baseAd != null && baseAd.isNativeExpress();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    public void handleFullScreenClick(ViewGroup viewGroup) {
        if (F() || !x() || viewGroup == null || !w()) {
            return;
        }
        c.a(viewGroup);
    }

    static /* synthetic */ void a(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView, long j) {
        thirdPartyHalfScreenATView.post(thirdPartyHalfScreenATView.new AnonymousClass5(j));
    }
}
