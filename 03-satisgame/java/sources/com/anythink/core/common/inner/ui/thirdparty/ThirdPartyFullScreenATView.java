package com.anythink.core.common.inner.ui.thirdparty;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.o;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.e;
import com.anythink.core.common.inner.ui.BaseScreenATView;
import com.anythink.core.common.k.g.d;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.g;
import com.anythink.core.common.u.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyFullScreenATView extends BaseScreenATView implements com.anythink.core.common.k.e.a.c {
    private static final String M = "ThirdPartyFullScreenATView";
    View K;
    Timer L;
    private BaseAd N;
    private CountDownTimer O;
    private TextView P;
    private com.anythink.core.common.inner.mixad.f.b Q;
    private boolean R;
    private boolean S;
    private FrameLayout T;

    private void F() {
    }

    static /* synthetic */ boolean b(ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        thirdPartyFullScreenATView.R = true;
        return true;
    }

    static /* synthetic */ boolean n(ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        thirdPartyFullScreenATView.S = true;
        return true;
    }

    public ThirdPartyFullScreenATView(Context context) {
        super(context);
        this.R = false;
        this.S = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartyFullScreenATView(Context context, x xVar, w wVar, String str, int i, int i2, BaseAd baseAd, com.anythink.core.common.k.a aVar) {
        super(context, xVar, wVar, str, i, i2);
        this.R = false;
        this.S = false;
        this.N = baseAd;
        View adMediaView = baseAd.getAdMediaView(new Object[0]);
        this.K = adMediaView;
        if (adMediaView != null && this.f.j == 28) {
            c.a(adMediaView);
        }
        if (aVar instanceof View) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.T.addView((View) aVar, layoutParams);
        }
        if (H()) {
            this.r = -1;
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a() {
        this.T = new FrameLayout(getContext());
        this.T.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.T.addView(LayoutInflater.from(getContext()).inflate(p.a(getContext(), "myoffer_thirdparty_full_screen", "layout"), (ViewGroup) this, false));
        addView(this.T);
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void b() {
        super.b();
        this.P = (TextView) findViewById(p.a(getContext(), "myoffer_tv_reward_tip", "id"));
        if (this.A != null) {
            this.A.setVisibility(8);
        }
        if (this.P != null) {
            BaseAd baseAd = this.N;
            if ((baseAd instanceof d) && ((d) baseAd).s()) {
                this.P.setVisibility(0);
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    public void init() {
        b();
        this.o = a(this.p);
        this.N.setNativeEventListener(new o() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyFullScreenATView.1
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
                if (ThirdPartyFullScreenATView.this.R) {
                    return;
                }
                ThirdPartyFullScreenATView.b(ThirdPartyFullScreenATView.this);
                if (ThirdPartyFullScreenATView.this.E != null) {
                    ThirdPartyFullScreenATView.this.E.a(new e());
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdClicked(View view) {
                int iA = com.anythink.core.common.inner.mixad.f.b.a;
                if (ThirdPartyFullScreenATView.this.Q != null) {
                    iA = ThirdPartyFullScreenATView.this.Q.a();
                }
                ThirdPartyFullScreenATView.this.hasClick = true;
                int i = com.anythink.core.common.inner.mixad.f.b.g;
                if (ThirdPartyFullScreenATView.this.z != null) {
                    if (ThirdPartyFullScreenATView.this.z.isTouch()) {
                        i = com.anythink.core.common.inner.mixad.f.b.h;
                    }
                    ThirdPartyFullScreenATView.this.z.setVisibility(8);
                }
                if (ThirdPartyFullScreenATView.this.E != null) {
                    ThirdPartyFullScreenATView.this.E.b(new e().a(i, iA));
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoStart() {
                if (ThirdPartyFullScreenATView.this.E != null) {
                    ThirdPartyFullScreenATView.this.E.a();
                }
            }

            @Override // com.anythink.core.common.d.n
            public final void onAdVideoEnd() {
                if (ThirdPartyFullScreenATView.this.S) {
                    return;
                }
                ThirdPartyFullScreenATView.n(ThirdPartyFullScreenATView.this);
                ThirdPartyFullScreenATView.this.p();
                if (ThirdPartyFullScreenATView.this.E != null) {
                    ThirdPartyFullScreenATView.this.E.b();
                }
                ThirdPartyFullScreenATView.this.f();
            }

            @Override // com.anythink.core.common.d.o
            public final void a(String str, String str2) {
                ThirdPartyFullScreenATView.this.f();
                ThirdPartyFullScreenATView.this.a(com.anythink.core.common.inner.b.b.a(str, str2));
            }
        });
        if (this.s) {
            f();
        } else if (3 == this.a || 1 == this.a) {
            if (D()) {
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
                if (this.O == null) {
                    this.O = new AnonymousClass2(this.n).start();
                }
            } else {
                p();
            }
        }
        y();
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        View view = this.K;
        if (view != null) {
            arrayList.add(view);
        }
        if (this.x != null) {
            arrayList.add(this.x);
        }
        if (this.w != null) {
            arrayList.add(this.w.getIconView());
        }
        this.Q = new com.anythink.core.common.inner.mixad.f.b.a().a(arrayList).a(this.w.getTitleView()).b(this.w.getDescView()).c(this.w.getCTAButton()).a();
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
            if (this.O == null) {
                this.O = new AnonymousClass2(this.n).start();
                return;
            }
            return;
        }
        p();
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyFullScreenATView$2, reason: invalid class name */
    final class AnonymousClass2 extends CountDownTimer {
        AnonymousClass2(long j) {
            super(j, 500L);
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long j) {
            ThirdPartyFullScreenATView.a(ThirdPartyFullScreenATView.this, j);
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            ThirdPartyFullScreenATView.this.p();
            ThirdPartyFullScreenATView.this.b(8);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyFullScreenATView$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ long a;

        AnonymousClass3(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ThirdPartyFullScreenATView.this.a(this.a);
        }
    }

    private void c(long j) {
        post(new AnonymousClass3(j));
    }

    private void A() {
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
            if (v()) {
                a(arrayList);
            }
        } else if (iQ == 1) {
            a(arrayList);
            if (u()) {
                c.a(this.N.getAdIconView());
            }
        } else if (iQ == 2) {
            arrayList.addAll(this.w.getClickViews());
            arrayList.add(this.w);
            if (v()) {
                a(arrayList);
            }
        }
        final com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        bVar.a(this.w.getTitleView());
        bVar.d(this.w.getDescView());
        bVar.e(this.w.getCTAButton());
        bVar.b(this.w.getIconView());
        b.a(this.v, this.N, new b.a() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyFullScreenATView.4
            @Override // com.anythink.core.common.inner.ui.thirdparty.b.a
            public final void a(View view, View view2, View view3) {
                bVar.g(view);
                bVar.h(view2);
                bVar.f(view3);
            }
        });
        this.N.registerListener(this.T, arrayList, com.anythink.core.common.inner.mixad.f.a.a(this.f.j, 0, 0), bVar);
    }

    private void a(List<View> list) {
        if (this.w.getCTAButton() != null) {
            list.add(this.w.getCTAButton());
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void c() {
        if (this.K != null) {
            this.v.addView(this.K, 0, new RelativeLayout.LayoutParams(-1, -1));
            n();
            A();
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void i() {
        if (this.w != null) {
            this.w.setVisibility(4);
            this.w.init(this.g, this.f, this.b, false, null);
            if (this.N != null) {
                this.w.setBaseAdIconView(this.N.getAdIconView());
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void j() {
        View cTAButton;
        super.j();
        if (this.w != null) {
            if (!com.anythink.core.common.inner.a.a.a(this.g)) {
                this.p = 8;
            } else {
                this.p = 0;
            }
            this.w.setLayoutType(this.p);
            if ((TextUtils.isEmpty(this.g != null ? this.g.o() : "") || (this.p == 8 && this.f.t.q() == 0)) && (cTAButton = this.w.getCTAButton()) != null) {
                cTAButton.setVisibility(8);
            }
            this.w.setVisibility(0);
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
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.core.common.inner.ui.thirdparty.ThirdPartyFullScreenATView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ThirdPartyFullScreenATView.this.K == null || ThirdPartyFullScreenATView.this.B == null || ThirdPartyFullScreenATView.this.N == null) {
                    return;
                }
                ThirdPartyFullScreenATView thirdPartyFullScreenATView = ThirdPartyFullScreenATView.this;
                thirdPartyFullScreenATView.u = !thirdPartyFullScreenATView.u;
                ThirdPartyFullScreenATView.this.B.setMute(ThirdPartyFullScreenATView.this.u);
                ThirdPartyFullScreenATView.this.N.setVideoMute(ThirdPartyFullScreenATView.this.u);
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
    protected final boolean a(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) {
            return com.anythink.core.common.inner.a.a.a(this.g);
        }
        return i == 8;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void p() {
        super.p();
        CountDownTimer countDownTimer = this.O;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.O = null;
        }
        if (this.z != null) {
            if (this.r >= this.ranDom && !this.hasClick) {
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
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

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final int g() {
        if (this.p == 8) {
            return this.p;
        }
        if (this.c < this.d) {
            return this.G >= this.H ? 1 : 5;
        }
        return this.G < this.H ? 2 : 6;
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void f() {
        if (H()) {
            return;
        }
        if (this.g != null && TextUtils.isEmpty(this.g.m()) && this.K == null) {
            return;
        }
        super.f();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:0x0091  */
    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void q() {
        int iA;
        int iA2;
        RelativeLayout.LayoutParams layoutParams;
        if (this.v != null && this.x != null && this.x.getParent() == null) {
            if (!D()) {
                if (G()) {
                    a(new RelativeLayout.LayoutParams(-1, -1));
                } else {
                    this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    t().setVisibility(0);
                    this.v.addView(this.x, 1);
                }
            } else {
                this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                if (a(this.p)) {
                    int i = this.p;
                    if (i == 1) {
                        this.v.setBackgroundColor(-1);
                        int i2 = (int) (this.d * 0.5f);
                        if (TextUtils.isEmpty(this.g.l())) {
                            iA = this.d - i2;
                        } else {
                            iA = (this.d - i2) + p.a(getContext(), 50.0f);
                        }
                        this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                        this.x.setNeedArc(true);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.width = this.c;
                            layoutParams2.height = iA;
                            this.w.setLayoutParams(layoutParams2);
                            this.w.removeAllViews();
                            this.w.setLayoutType(this.p);
                        }
                    } else if (i == 2) {
                        iA2 = p.a(getContext(), 300.0f);
                        this.x.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                        layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iA2;
                            layoutParams.height = -1;
                            this.w.setLayoutParams(layoutParams);
                            this.w.removeAllViews();
                            this.w.setLayoutType(this.p);
                        }
                    } else if (i == 5) {
                        int i3 = (int) (this.d * 0.5f);
                        this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.d - i3));
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3.width = this.c;
                            layoutParams3.height = i3;
                            this.w.setLayoutParams(layoutParams3);
                            this.w.removeAllViews();
                            this.w.setLayoutType(this.p);
                        }
                    } else if (i == 6) {
                        iA2 = p.a(getContext(), 300.0f);
                        this.x.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                        layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iA2;
                            layoutParams.height = -1;
                            this.w.setLayoutParams(layoutParams);
                            this.w.removeAllViews();
                            this.w.setLayoutType(this.p);
                        }
                    }
                }
                if (G()) {
                    a(this.x.getLayoutParams());
                } else {
                    this.v.addView(this.x, 1);
                }
            }
            A();
        }
        y();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void r() {
        if (this.K != null && !G() && this.K.getParent() != null) {
            ((ViewGroup) this.K.getParent()).removeView(this.K);
        }
        b(8);
        if (this.B != null) {
            this.B.setVisibility(8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005a  */
    /* JADX WARN: Code duplicated, block: B:18:0x007b  */
    private void B() {
        int iA;
        int iA2;
        RelativeLayout.LayoutParams layoutParams;
        this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (a(this.p)) {
            int i = this.p;
            if (i == 1) {
                this.v.setBackgroundColor(-1);
                int i2 = (int) (this.d * 0.5f);
                if (TextUtils.isEmpty(this.g.l())) {
                    iA = this.d - i2;
                } else {
                    iA = (this.d - i2) + p.a(getContext(), 50.0f);
                }
                this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                this.x.setNeedArc(true);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.c;
                    layoutParams2.height = iA;
                    this.w.setLayoutParams(layoutParams2);
                    this.w.removeAllViews();
                    this.w.setLayoutType(this.p);
                }
            } else if (i == 2) {
                iA2 = p.a(getContext(), 300.0f);
                this.x.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    this.w.setLayoutParams(layoutParams);
                    this.w.removeAllViews();
                    this.w.setLayoutType(this.p);
                }
            } else if (i == 5) {
                int i3 = (int) (this.d * 0.5f);
                this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.d - i3));
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.c;
                    layoutParams3.height = i3;
                    this.w.setLayoutParams(layoutParams3);
                    this.w.removeAllViews();
                    this.w.setLayoutType(this.p);
                }
            } else if (i == 6) {
                iA2 = p.a(getContext(), 300.0f);
                this.x.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    this.w.setLayoutParams(layoutParams);
                    this.w.removeAllViews();
                    this.w.setLayoutType(this.p);
                }
            }
        }
        if (G()) {
            a(this.x.getLayoutParams());
        } else {
            this.v.addView(this.x, 1);
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    protected final void l() {
        super.m();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView, com.anythink.core.common.inner.ui.BaseATView
    public void destroy() {
        super.destroy();
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
            this.L = null;
        }
        CountDownTimer countDownTimer = this.O;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.O = null;
        }
        BaseAd baseAd = this.N;
        if (baseAd != null) {
            baseAd.setNativeEventListener(null);
            this.N.clear(this);
            this.N.destroy();
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

    private void C() {
        Timer timer = this.L;
        if (timer != null) {
            timer.cancel();
            this.L = null;
        }
        CountDownTimer countDownTimer = this.O;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.O = null;
        }
    }

    private boolean D() {
        if (H()) {
            return true;
        }
        BaseAd baseAd = this.N;
        return (baseAd == null || !TextUtils.equals(baseAd.getAdType(), "1") || this.K == null) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.core.common.inner.mixad.f.b bVar = this.Q;
        if (bVar != null) {
            bVar.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.k.a aVar) {
        if (aVar instanceof View) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.T.addView((View) aVar, layoutParams);
        }
    }

    private void a(View view) {
        if (view == null || this.f.j != 28) {
            return;
        }
        c.a(view);
    }

    private void E() {
        this.x.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        t().setVisibility(0);
        this.v.addView(this.x, 1);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (this.K == null || this.v == null) {
            return;
        }
        al.a(this.K);
        this.v.addView(this.K, 1, layoutParams);
    }

    private boolean G() {
        return (this.g == null || !TextUtils.isEmpty(this.g.m()) || this.K == null) ? false : true;
    }

    private boolean H() {
        BaseAd baseAd = this.N;
        return baseAd != null && baseAd.isNativeExpress();
    }

    @Override // com.anythink.core.common.inner.ui.BaseScreenATView
    public void handleFullScreenClick(ViewGroup viewGroup) {
        if (H() || !x() || viewGroup == null || !w()) {
            return;
        }
        c.a(viewGroup);
    }

    static /* synthetic */ void a(ThirdPartyFullScreenATView thirdPartyFullScreenATView, long j) {
        thirdPartyFullScreenATView.post(thirdPartyFullScreenATView.new AnonymousClass3(j));
    }
}
