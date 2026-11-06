package com.anythink.basead.ui.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.basead.b.e;
import com.anythink.basead.b.f;
import com.anythink.basead.d.g;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.BaseScreenATView;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.d.p;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.t.d;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyFullScreenATView extends BaseScreenATView implements com.anythink.core.common.l.e.a.c {
    private static final String aj = "ThirdPartyFullScreenATView";
    View ah;
    Timer ai;
    private BaseAd ak;
    private final com.anythink.core.common.t.a al;
    private final com.anythink.core.common.t.b am;
    private com.anythink.basead.mixad.f.b an;
    private boolean ao;
    private boolean ap;
    private FrameLayout aq;

    static /* synthetic */ boolean b(ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        thirdPartyFullScreenATView.ao = true;
        return true;
    }

    static /* synthetic */ boolean n(ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        thirdPartyFullScreenATView.ap = true;
        return true;
    }

    public ThirdPartyFullScreenATView(Context context) {
        super(context);
        this.al = d.a();
        this.am = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView.1
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyFullScreenATView.this.T();
            }
        };
        this.ao = false;
        this.ap = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartyFullScreenATView(Context context, x xVar, w wVar, String str, int i, int i2, BaseAd baseAd, com.anythink.core.common.l.a aVar) {
        super(context, xVar, wVar, str, i, i2);
        this.al = d.a();
        this.am = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView.1
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyFullScreenATView.this.T();
            }
        };
        this.ao = false;
        this.ap = false;
        this.ak = baseAd;
        View adMediaView = baseAd.getAdMediaView(new Object[0]);
        this.ah = adMediaView;
        if (adMediaView != null && this.f.f == 28) {
            c.c(adMediaView);
        }
        if (aVar instanceof View) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.aq.addView((View) aVar, layoutParams);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a() {
        this.aq = new FrameLayout(getContext());
        this.aq.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.aq.addView(LayoutInflater.from(getContext()).inflate(q.a(getContext(), "myoffer_thirdparty_full_screen", "layout"), (ViewGroup) this, false));
        addView(this.aq);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void b() {
        super.b();
        if (this.R != null) {
            this.R.setVisibility(8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    @Override // com.anythink.basead.ui.BaseScreenATView
    public void init() {
        b();
        this.D = b(this.E);
        this.ak.setNativeEventListener(new p() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView.2
            @Override // com.anythink.core.common.d.o
            public final void onAdDislikeButtonClick() {
            }

            @Override // com.anythink.core.common.d.o
            public final void onDeeplinkCallback(boolean z) {
            }

            @Override // com.anythink.core.common.d.o
            public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdImpressed() {
                if (ThirdPartyFullScreenATView.this.ao) {
                    return;
                }
                ThirdPartyFullScreenATView.b(ThirdPartyFullScreenATView.this);
                if (ThirdPartyFullScreenATView.this.W != null) {
                    ThirdPartyFullScreenATView.this.W.a(new j());
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdClicked(View view) {
                int iA = com.anythink.basead.mixad.f.b.a;
                if (ThirdPartyFullScreenATView.this.an != null) {
                    iA = ThirdPartyFullScreenATView.this.an.a();
                }
                if (ThirdPartyFullScreenATView.this.W != null) {
                    ThirdPartyFullScreenATView.this.W.b(new j().a(1, iA));
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoStart() {
                ThirdPartyFullScreenATView.h(ThirdPartyFullScreenATView.this);
                if (ThirdPartyFullScreenATView.this.W != null) {
                    ThirdPartyFullScreenATView.this.W.a();
                }
                if (ThirdPartyFullScreenATView.this.aq() && ThirdPartyFullScreenATView.this.at()) {
                    c.a(ThirdPartyFullScreenATView.this.ah);
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoEnd() {
                if (ThirdPartyFullScreenATView.this.ap) {
                    return;
                }
                ThirdPartyFullScreenATView.n(ThirdPartyFullScreenATView.this);
                ThirdPartyFullScreenATView.o(ThirdPartyFullScreenATView.this);
                ThirdPartyFullScreenATView.this.T();
                if (ThirdPartyFullScreenATView.this.W != null) {
                    ThirdPartyFullScreenATView.this.W.b();
                }
                ThirdPartyFullScreenATView.this.x();
            }

            @Override // com.anythink.core.common.d.p
            public final void a(String str, String str2) {
                ThirdPartyFullScreenATView.this.x();
                ThirdPartyFullScreenATView.this.a(g.a(str, str2));
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoProgress(int i) {
                ThirdPartyFullScreenATView.o(ThirdPartyFullScreenATView.this);
                ThirdPartyFullScreenATView.a(ThirdPartyFullScreenATView.this, i);
            }
        });
        if (!this.I) {
            if (1 != this.a && 3 == this.a) {
                if (am()) {
                    w();
                    if (this.C >= 0) {
                        if (this.C > 0) {
                            this.al.a(this.am, this.C, true);
                        } else {
                            T();
                        }
                    }
                } else {
                    x();
                }
            }
        } else {
            x();
        }
        af();
    }

    private void af() {
        ArrayList arrayList = new ArrayList();
        View view = this.ah;
        if (view != null) {
            arrayList.add(view);
        }
        if (this.O != null) {
            arrayList.add(this.O);
        }
        if (this.N != null) {
            arrayList.add(this.N.getIconView());
        }
        this.an = new com.anythink.basead.mixad.f.b.a().a(arrayList).a(this.N.getTitleView()).b(this.N.getDescView()).c(this.N.getCTAButton()).a();
    }

    private void ag() {
        if (this.C < 0) {
            return;
        }
        if (this.C > 0) {
            this.al.a(this.am, this.C, true);
        } else {
            T();
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ int a;

        AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a * 1000;
            ThirdPartyFullScreenATView.this.b(i);
            if (ThirdPartyFullScreenATView.this.C < 0 || i < ThirdPartyFullScreenATView.this.C) {
                return;
            }
            ThirdPartyFullScreenATView.this.T();
        }
    }

    private void f(int i) {
        post(new AnonymousClass3(i));
    }

    private void ah() {
        ArrayList arrayList = new ArrayList();
        int iH = this.f.o.H();
        if (iH == 0) {
            arrayList.addAll(this.N.getClickViews());
            arrayList.add(this.N);
            if (this.O != null) {
                arrayList.add(this.O);
            }
            if (as()) {
                b(arrayList);
            }
        } else if (iH == 1) {
            b(arrayList);
            if (ar()) {
                c.c(this.ak.getAdIconView());
            }
        } else if (iH == 2) {
            arrayList.addAll(this.N.getClickViews());
            arrayList.add(this.N);
            if (as()) {
                b(arrayList);
            }
        }
        final com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        bVar.a(this.N.getTitleView());
        bVar.d(this.N.getDescView());
        if (this.N.getCTAButton() instanceof CTAButtonLayout) {
            bVar.e(((CTAButtonLayout) this.N.getCTAButton()).getMajorCTAButtonView());
        } else {
            bVar.e(this.N.getCTAButton());
        }
        bVar.b(this.N.getIconView());
        b.a(this.M, this.ak, new b.a() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView.4
            @Override // com.anythink.basead.ui.thirdparty.b.a
            public final void a(View view, View view2, View view3) {
                bVar.g(view);
                bVar.h(view2);
                bVar.f(view3);
            }
        });
        this.ak.registerListener(this.aq, arrayList, com.anythink.basead.mixad.f.a.a(this.f.f, 0, 0), bVar);
    }

    private void b(List<View> list) {
        if (this.N.getCTAButton() != null) {
            if (this.N.getCTAButton() instanceof CTAButtonLayout) {
                list.add(((CTAButtonLayout) this.N.getCTAButton()).getMajorCTAButtonView());
            } else {
                list.add(this.N.getCTAButton());
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void w() {
        if (this.ah != null) {
            this.M.addView(this.ah, 0, new RelativeLayout.LayoutParams(-1, -1));
            double videoDuration = this.ak.getVideoDuration();
            if (aq()) {
                T();
                videoDuration = 0.0d;
            }
            c(((long) ((int) videoDuration)) * 1000);
            P();
            ah();
            if (videoDuration <= 0.0d) {
                e(8);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void H() {
        if (this.N != null) {
            this.N.setVisibility(4);
            this.N.init(this.g, this.f, this.b, false, null);
            if (this.ak != null) {
                this.N.setBaseAdIconView(this.ak.getAdIconView());
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void I() {
        super.I();
        if (this.N != null) {
            if (!e.a(this.g)) {
                this.E = 8;
            } else {
                this.E = 0;
            }
            this.N.setLayoutType(this.E);
            if (this.E == 8 && this.f.o.H() == 0) {
                this.N.getCTAButton().setVisibility(8);
            }
            this.N.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void K() {
        if (this.S == null) {
            return;
        }
        if (this.K) {
            this.S.setMute(true);
        } else {
            this.S.setMute(false);
        }
        this.S.setVisibility(4);
        this.S.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ThirdPartyFullScreenATView.this.ah == null || ThirdPartyFullScreenATView.this.S == null || ThirdPartyFullScreenATView.this.ak == null) {
                    return;
                }
                ThirdPartyFullScreenATView thirdPartyFullScreenATView = ThirdPartyFullScreenATView.this;
                thirdPartyFullScreenATView.K = !thirdPartyFullScreenATView.K;
                ThirdPartyFullScreenATView.this.S.setMute(ThirdPartyFullScreenATView.this.K);
                ThirdPartyFullScreenATView.this.ak.setVideoMute(ThirdPartyFullScreenATView.this.K);
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void P() {
        super.P();
        if (this.f == null) {
            return;
        }
        int i = this.f.f;
        if (i == 22) {
            this.ak.setVideoMute(this.K);
        }
        if (this.S != null && i != 8) {
            this.S.setVisibility(8);
        }
        if (i == 28 || i == 22) {
            e(8);
            T();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final boolean b(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) {
            return e.a(this.g);
        }
        return i == 8;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void T() {
        super.T();
        this.al.b(this.am);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void G() {
        String strB = this.g.B();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        f.a();
        int[] iArrA = h.a(f.a(2, strB));
        if (iArrA != null) {
            this.af = iArrA[0];
            this.ag = iArrA[1];
            this.ad = this.af;
            this.ae = this.ag;
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final int y() {
        if (this.E == 8) {
            return this.E;
        }
        if (this.c < this.d) {
            return this.ad >= this.ae ? 1 : 5;
        }
        return this.ad < this.ae ? 2 : 6;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:0x0091  */
    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void U() {
        int iA;
        int iA2;
        RelativeLayout.LayoutParams layoutParams;
        if (this.M != null && this.O != null && this.O.getParent() == null) {
            if (!am()) {
                if (ap()) {
                    a(new RelativeLayout.LayoutParams(-1, -1));
                    T();
                } else {
                    this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    aa().setVisibility(0);
                    this.M.addView(this.O, 1);
                }
            } else {
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                if (b(this.E)) {
                    int i = this.E;
                    if (i == 1) {
                        this.M.setBackgroundColor(-1);
                        int i2 = (int) (this.d * 0.5f);
                        if (TextUtils.isEmpty(this.g.z())) {
                            iA = this.d - i2;
                        } else {
                            iA = (this.d - i2) + q.a(getContext(), 50.0f);
                        }
                        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                        this.O.setNeedArc(true);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.width = this.c;
                            layoutParams2.height = iA;
                            this.N.setLayoutParams(layoutParams2);
                            this.N.removeAllViews();
                            this.N.setLayoutType(this.E);
                        }
                    } else if (i == 2) {
                        iA2 = q.a(getContext(), 300.0f);
                        this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                        layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iA2;
                            layoutParams.height = -1;
                            this.N.setLayoutParams(layoutParams);
                            this.N.removeAllViews();
                            this.N.setLayoutType(this.E);
                        }
                    } else if (i == 5) {
                        int i3 = (int) (this.d * 0.5f);
                        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.d - i3));
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                        if (layoutParams3 != null) {
                            layoutParams3.width = this.c;
                            layoutParams3.height = i3;
                            this.N.setLayoutParams(layoutParams3);
                            this.N.removeAllViews();
                            this.N.setLayoutType(this.E);
                        }
                    } else if (i == 6) {
                        iA2 = q.a(getContext(), 300.0f);
                        this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                        layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iA2;
                            layoutParams.height = -1;
                            this.N.setLayoutParams(layoutParams);
                            this.N.removeAllViews();
                            this.N.setLayoutType(this.E);
                        }
                    }
                }
                if (ap()) {
                    a(this.O.getLayoutParams());
                } else {
                    this.M.addView(this.O, 1);
                }
            }
            ah();
        }
        af();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void V() {
        if (this.ah != null && !ap() && this.ah.getParent() != null) {
            ((ViewGroup) this.ah.getParent()).removeView(this.ah);
        }
        e(8);
        if (this.S != null) {
            this.S.setVisibility(8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005a  */
    /* JADX WARN: Code duplicated, block: B:18:0x007b  */
    private void ai() {
        int iA;
        int iA2;
        RelativeLayout.LayoutParams layoutParams;
        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (b(this.E)) {
            int i = this.E;
            if (i == 1) {
                this.M.setBackgroundColor(-1);
                int i2 = (int) (this.d * 0.5f);
                if (TextUtils.isEmpty(this.g.z())) {
                    iA = this.d - i2;
                } else {
                    iA = (this.d - i2) + q.a(getContext(), 50.0f);
                }
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
                this.O.setNeedArc(true);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.c;
                    layoutParams2.height = iA;
                    this.N.setLayoutParams(layoutParams2);
                    this.N.removeAllViews();
                    this.N.setLayoutType(this.E);
                }
            } else if (i == 2) {
                iA2 = q.a(getContext(), 300.0f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    this.N.setLayoutParams(layoutParams);
                    this.N.removeAllViews();
                    this.N.setLayoutType(this.E);
                }
            } else if (i == 5) {
                int i3 = (int) (this.d * 0.5f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.d - i3));
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.c;
                    layoutParams3.height = i3;
                    this.N.setLayoutParams(layoutParams3);
                    this.N.removeAllViews();
                    this.N.setLayoutType(this.E);
                }
            } else if (i == 6) {
                iA2 = q.a(getContext(), 300.0f);
                this.O.setLayoutParams(new RelativeLayout.LayoutParams(this.c - iA2, -1));
                layoutParams = (RelativeLayout.LayoutParams) this.N.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iA2;
                    layoutParams.height = -1;
                    this.N.setLayoutParams(layoutParams);
                    this.N.removeAllViews();
                    this.N.setLayoutType(this.E);
                }
            }
        }
        if (ap()) {
            a(this.O.getLayoutParams());
        } else {
            this.M.addView(this.O, 1);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void M() {
        super.c(1);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        Timer timer = this.ai;
        if (timer != null) {
            timer.cancel();
            this.ai = null;
        }
        this.al.b(this.am);
        BaseAd baseAd = this.ak;
        if (baseAd != null) {
            baseAd.setNativeEventListener(null);
            this.ak.clear(this);
            this.ak.destroy();
        }
        if (this.M != null) {
            this.M.removeAllViews();
        }
        if (this.N != null) {
            this.N.removeAllViews();
        }
        if (this.O != null) {
            this.O.mListener = null;
        }
        if (this.R != null) {
            this.R.setOnClickListener(null);
            this.R.removeAllViews();
        }
        removeAllViews();
    }

    private void aj() {
        if (this.ai == null) {
            Timer timer = new Timer();
            this.ai = timer;
            timer.schedule(new AnonymousClass6(), 0L, 300L);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.thirdparty.ThirdPartyFullScreenATView$6, reason: invalid class name */
    final class AnonymousClass6 extends TimerTask {
        AnonymousClass6() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ThirdPartyFullScreenATView thirdPartyFullScreenATView = ThirdPartyFullScreenATView.this;
            ThirdPartyFullScreenATView.a(thirdPartyFullScreenATView, (int) thirdPartyFullScreenATView.ak.getVideoProgress());
        }
    }

    private void ak() {
        Timer timer = this.ai;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void al() {
        Timer timer = this.ai;
        if (timer != null) {
            timer.cancel();
            this.ai = null;
        }
        this.al.b(this.am);
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.basead.mixad.f.b bVar = this.an;
        if (bVar != null) {
            bVar.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.l.a aVar) {
        if (aVar instanceof View) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.aq.addView((View) aVar, layoutParams);
        }
    }

    private void b(View view) {
        if (view == null || this.f.f != 28) {
            return;
        }
        c.c(view);
    }

    private void an() {
        this.O.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        aa().setVisibility(0);
        this.M.addView(this.O, 1);
    }

    private void a(ViewGroup.LayoutParams layoutParams) {
        if (this.ah == null || this.M == null) {
            return;
        }
        am.a(this.ah);
        this.M.addView(this.ah, 1, layoutParams);
    }

    private void ao() {
        BaseAd baseAd = this.ak;
        if (baseAd == null) {
            return;
        }
        new StringBuilder("show native material:\nadMaterial: ").append(baseAd).append("\ngetTitle:").append(baseAd.getTitle()).append("\ngetDescriptionText:").append(baseAd.getDescriptionText()).append("\ngetNativeType:").append(baseAd.getNativeType()).append("\ngetAdMediaView:").append(baseAd.getAdMediaView(new Object[0])).append("\ngetAdIconView:").append(baseAd.getAdIconView()).append("\ngetIconImageUrl:").append(baseAd.getIconImageUrl()).append("\ngetMainImageUrl:").append(baseAd.getMainImageUrl()).append("\ngetMainImageWidth:").append(baseAd.getMainImageWidth()).append("\ngetMainImageHeight:").append(baseAd.getMainImageHeight()).append("\ngetVideoWidth:").append(baseAd.getVideoWidth()).append("\ngetVideoHeight:").append(baseAd.getVideoHeight()).append("\ngetAppPrice:").append(baseAd.getAppPrice()).append("\ngetAppCommentNum:").append(baseAd.getAppCommentNum()).append("\ngetCallToActionText:").append(baseAd.getCallToActionText()).append("\ngetStarRating:").append(baseAd.getStarRating()).append("\ngetVideoUrl:").append(baseAd.getVideoUrl()).append("\ngetAdChoiceIconUrl:").append(baseAd.getAdChoiceIconUrl()).append("\ngetAdFrom:").append(baseAd.getAdFrom()).append("\ngetImageUrlList:").append(baseAd.getImageUrlList()).append("\ngetNetworkInfoMap:").append(baseAd.getNetworkInfoMap()).append("\ngetAdAppInfo:").append(baseAd.getAdAppInfo()).append("\ngetNativeAdInteractionType:").append(baseAd.getNativeAdInteractionType()).append("\ngetVideoDuration:").append(baseAd.getVideoDuration()).append("\ngetAdvertiserName:").append(baseAd.getAdvertiserName()).append("\ngetNativeType:").append(baseAd.getNativeType()).append("\ngetAdType:").append(baseAd.getAdType()).append("\ngetNativeCustomVideo:").append(baseAd.getNativeCustomVideo()).append("\ngetAdLogo:").append(baseAd.getAdLogo());
        baseAd.getNativeExpressWidth();
        baseAd.getNativeExpressHeight();
    }

    private boolean ap() {
        return (this.g == null || !TextUtils.isEmpty(this.g.B()) || this.ah == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aq() {
        return this.f != null && this.f.f == 39;
    }

    private boolean ar() {
        return this.f != null && this.f.f == 59;
    }

    private boolean as() {
        return this.f != null && this.f.f == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean at() {
        return (this.f == null || this.f.o == null || this.f.o.H() == 0) ? false : true;
    }

    private boolean au() {
        return this.ak.isNativeExpress();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void x() {
        if (this.ak.isNativeExpress()) {
            return;
        }
        if (this.g != null && TextUtils.isEmpty(this.g.B()) && this.ah == null) {
            return;
        }
        super.x();
    }

    private boolean am() {
        if (this.ak.isNativeExpress()) {
            return true;
        }
        BaseAd baseAd = this.ak;
        boolean z = false;
        if (baseAd != null) {
            if (TextUtils.equals(baseAd.getAdType(), "1") && this.ah != null) {
                z = true;
            }
            Object[] objArr = new Object[1];
            Boolean.valueOf(z);
        }
        return z;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void handleFullScreenClick() {
        if (!this.ak.isNativeExpress() && at()) {
            View view = this.ah;
            if (aq()) {
                Object parent = getParent();
                if (parent instanceof ViewGroup) {
                    Object[] objArr = new Object[1];
                    c.c((View) parent);
                }
                c.c(view);
                return;
            }
            if (ar()) {
                c.c(view);
            }
        }
    }

    static /* synthetic */ void h(ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        if (thirdPartyFullScreenATView.ai == null) {
            Timer timer = new Timer();
            thirdPartyFullScreenATView.ai = timer;
            timer.schedule(thirdPartyFullScreenATView.new AnonymousClass6(), 0L, 300L);
        }
    }

    static /* synthetic */ void o(ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        Timer timer = thirdPartyFullScreenATView.ai;
        if (timer != null) {
            timer.cancel();
        }
    }

    static /* synthetic */ void a(ThirdPartyFullScreenATView thirdPartyFullScreenATView, int i) {
        thirdPartyFullScreenATView.post(thirdPartyFullScreenATView.new AnonymousClass3(i));
    }
}
