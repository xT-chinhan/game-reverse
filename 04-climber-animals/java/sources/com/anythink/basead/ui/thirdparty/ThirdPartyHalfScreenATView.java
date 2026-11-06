package com.anythink.basead.ui.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.anythink.basead.b.e;
import com.anythink.basead.b.f;
import com.anythink.basead.d.g;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.BaseEndCardView;
import com.anythink.basead.ui.HalfScreenATView;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
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
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public class ThirdPartyHalfScreenATView extends HalfScreenATView implements com.anythink.core.common.l.e.a.c {
    private static final String an = "ThirdPartyHalfScreenATView";
    private final com.anythink.core.common.t.a ao;
    private BaseAd ap;
    private View aq;
    private Timer ar;
    private com.anythink.basead.mixad.f.b as;
    private boolean at;
    private boolean au;
    private FrameLayout av;
    private final com.anythink.core.common.t.b aw;

    @Override // com.anythink.basead.ui.HalfScreenATView
    public boolean isAttachRoot() {
        return false;
    }

    static /* synthetic */ boolean b(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView) {
        thirdPartyHalfScreenATView.at = true;
        return true;
    }

    static /* synthetic */ boolean o(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView) {
        thirdPartyHalfScreenATView.au = true;
        return true;
    }

    public ThirdPartyHalfScreenATView(Context context) {
        super(context);
        this.ao = d.a();
        this.at = false;
        this.au = false;
        this.aw = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView.1
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyHalfScreenATView.this.T();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThirdPartyHalfScreenATView(Context context, x xVar, w wVar, String str, int i, int i2, BaseAd baseAd, com.anythink.core.common.l.a aVar) {
        FrameLayout.LayoutParams layoutParams;
        super(context, xVar, wVar, str, i, i2);
        this.ao = d.a();
        this.at = false;
        this.au = false;
        this.aw = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView.1
            @Override // java.lang.Runnable
            public final void run() {
                ThirdPartyHalfScreenATView.this.T();
            }
        };
        this.ap = baseAd;
        this.aq = baseAd.getAdMediaView(new Object[0]);
        if (aVar instanceof View) {
            View view = (View) aVar;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams.gravity = 17;
            this.av.addView(view, layoutParams);
        }
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseATView
    protected final void a() {
        super.a();
        this.av = new FrameLayout(getContext());
        this.av.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.av.addView(this.ah);
        addView(this.av);
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void b() {
        ViewGroup customAdContainer;
        super.b();
        if (this.R != null) {
            this.R.setVisibility(8);
        }
        if (this.ai != null) {
            this.ai.a();
        }
        if (this.M != null && (customAdContainer = this.ap.getCustomAdContainer()) != null) {
            if (!this.ap.isNativeExpress() && as()) {
                View view = this.aq;
                if (aq()) {
                    c.c(customAdContainer);
                    c.c(view);
                } else if (ar()) {
                    c.c(view);
                }
            }
            ViewParent parent = this.M.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int iIndexOfChild = viewGroup.indexOfChild(this.M);
                if (iIndexOfChild >= 0) {
                    viewGroup.removeViewAt(iIndexOfChild);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, this.M.getLayoutParams().height);
                layoutParams.gravity = 17;
                customAdContainer.addView(this.M, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(15);
                layoutParams2.leftMargin = q.a(getContext(), 26.0f);
                layoutParams2.rightMargin = q.a(getContext(), 26.0f);
                viewGroup.addView(customAdContainer, iIndexOfChild, layoutParams2);
            }
        }
        View viewFindViewById = findViewById(q.a(getContext(), "myoffer_ad_lable", "id"));
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    @Override // com.anythink.basead.ui.BaseScreenATView
    public void init() {
        boolean z;
        b();
        this.D = b(this.E);
        this.ap.setNativeEventListener(new p() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView.2
            @Override // com.anythink.core.common.d.o
            public final void onAdDislikeButtonClick() {
            }

            @Override // com.anythink.core.common.d.o
            public final void onDeeplinkCallback(boolean z2) {
            }

            @Override // com.anythink.core.common.d.o
            public final void onDownloadConfirmCallback(Context context, View view, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdImpressed() {
                if (ThirdPartyHalfScreenATView.this.at) {
                    return;
                }
                ThirdPartyHalfScreenATView.b(ThirdPartyHalfScreenATView.this);
                if (ThirdPartyHalfScreenATView.this.W != null) {
                    ThirdPartyHalfScreenATView.this.W.a(new j());
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdClicked(View view) {
                int iA = com.anythink.basead.mixad.f.b.a;
                if (ThirdPartyHalfScreenATView.this.as != null) {
                    iA = ThirdPartyHalfScreenATView.this.as.a();
                }
                if (ThirdPartyHalfScreenATView.this.W != null) {
                    ThirdPartyHalfScreenATView.this.W.b(new j().a(1, iA));
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoStart() {
                ThirdPartyHalfScreenATView.h(ThirdPartyHalfScreenATView.this);
                if (ThirdPartyHalfScreenATView.this.W != null) {
                    ThirdPartyHalfScreenATView.this.W.a();
                }
                if (ThirdPartyHalfScreenATView.this.aq() && ThirdPartyHalfScreenATView.this.as()) {
                    c.a(ThirdPartyHalfScreenATView.this.aq);
                }
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoEnd() {
                if (ThirdPartyHalfScreenATView.this.au) {
                    return;
                }
                ThirdPartyHalfScreenATView.o(ThirdPartyHalfScreenATView.this);
                ThirdPartyHalfScreenATView.p(ThirdPartyHalfScreenATView.this);
                ThirdPartyHalfScreenATView.this.T();
                if (ThirdPartyHalfScreenATView.this.W != null) {
                    ThirdPartyHalfScreenATView.this.W.b();
                }
                ThirdPartyHalfScreenATView.this.x();
            }

            @Override // com.anythink.core.common.d.p
            public final void a(String str, String str2) {
                ThirdPartyHalfScreenATView.this.x();
                ThirdPartyHalfScreenATView.this.a(g.a(str, str2));
            }

            @Override // com.anythink.core.common.d.o
            public final void onAdVideoProgress(int i) {
                ThirdPartyHalfScreenATView.p(ThirdPartyHalfScreenATView.this);
                ThirdPartyHalfScreenATView.a(ThirdPartyHalfScreenATView.this, i);
            }
        });
        Object[] objArr = new Object[1];
        Boolean.valueOf(this.I);
        if (!this.I) {
            if (3 == this.a) {
                if (this.ap.isNativeExpress()) {
                    z = true;
                } else {
                    BaseAd baseAd = this.ap;
                    z = false;
                    if (baseAd != null) {
                        if (TextUtils.equals(baseAd.getAdType(), "1") && this.aq != null) {
                            z = true;
                        }
                        Object[] objArr2 = new Object[1];
                        Boolean.valueOf(z);
                    }
                }
                if (z) {
                    w();
                    if (this.C >= 0) {
                        if (this.C > 0) {
                            this.ao.a(this.aw, this.C, true);
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
        ao();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void w() {
        try {
            if (this.aq == null || this.ap == null || this.r == null) {
                return;
            }
            double videoDuration = this.ap.getVideoDuration();
            Object[] objArr = new Object[2];
            Double.valueOf(videoDuration);
            BasePlayerView basePlayerViewL = this.r.l();
            if (basePlayerViewL != null) {
                this.M.addView(this.aq, 1, basePlayerViewL.getLayoutParams());
            }
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
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void H() {
        if (this.N != null) {
            this.N.setVisibility(4);
            this.N.init(this.g, this.f, this.b, false, null);
            if (this.ap != null) {
                this.N.setBaseAdIconView(this.ap.getAdIconView());
            }
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
        this.S.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ThirdPartyHalfScreenATView.this.aq == null || ThirdPartyHalfScreenATView.this.S == null || ThirdPartyHalfScreenATView.this.ap == null) {
                    return;
                }
                ThirdPartyHalfScreenATView thirdPartyHalfScreenATView = ThirdPartyHalfScreenATView.this;
                thirdPartyHalfScreenATView.K = !thirdPartyHalfScreenATView.K;
                ThirdPartyHalfScreenATView.this.S.setMute(ThirdPartyHalfScreenATView.this.K);
                ThirdPartyHalfScreenATView.this.ap.setVideoMute(ThirdPartyHalfScreenATView.this.K);
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
            this.ap.setVideoMute(this.K);
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
    protected final void T() {
        if (X() != null && X().getVisibility() != 0) {
            X().setVisibility(0);
            X().setClickAreaScaleFactor(this.L);
        }
        this.ao.b(this.aw);
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final boolean b(int i) {
        if (i == 3 || i == 4) {
            return e.a(this.g);
        }
        return i == 7;
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void M() {
        super.c(1);
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    protected final void U() {
        Object[] objArr = new Object[1];
        BaseEndCardView baseEndCardView = this.O;
        if (ap()) {
            am.a(this.aq);
            BasePlayerView basePlayerViewL = this.r.l();
            if (basePlayerViewL != null) {
                this.M.addView(this.aq, 1, basePlayerViewL.getLayoutParams());
            }
            T();
        } else {
            super.U();
        }
        ao();
        ah();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void V() {
        if (this.aq != null && !ap() && this.aq.getParent() != null) {
            ((ViewGroup) this.aq.getParent()).removeView(this.aq);
        }
        e(8);
        if (this.S != null) {
            this.S.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
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

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        Timer timer = this.ar;
        if (timer != null) {
            timer.cancel();
            this.ar = null;
        }
        this.ao.b(this.aw);
        BaseAd baseAd = this.ap;
        if (baseAd != null) {
            baseAd.setNativeEventListener(null);
            this.ap.clear(this);
            this.ap.destroy();
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

    private void ah() {
        ArrayList arrayList = new ArrayList();
        int iH = this.f.o.H();
        if (iH == 0) {
            arrayList.addAll(this.N.getClickViews());
            arrayList.add(this.N);
            if (this.O != null) {
                arrayList.add(this.O);
            }
        } else if (iH == 1) {
            if (this.N.getCTAButton() != null) {
                arrayList.add(this.N.getCTAButton());
            }
            if (ar()) {
                c.c(this.ap.getAdIconView());
            }
        } else if (iH == 2) {
            arrayList.addAll(this.N.getClickViews());
            arrayList.add(this.N);
        }
        final com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        bVar.a(this.N.getTitleView());
        bVar.d(this.N.getDescView());
        bVar.e(this.N.getCTAButton());
        bVar.b(this.N.getIconView());
        b.a(this.M, this.ap, new b.a() { // from class: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView.4
            @Override // com.anythink.basead.ui.thirdparty.b.a
            public final void a(View view, View view2, View view3) {
                bVar.g(view);
                bVar.h(view2);
                bVar.f(view3);
            }
        });
        this.ap.registerListener(this.av, arrayList, com.anythink.basead.mixad.f.a.a(this.f.f, 0, 0), bVar);
    }

    private void ai() {
        if (this.C < 0) {
            return;
        }
        if (this.C > 0) {
            this.ao.a(this.aw, this.C, true);
        } else {
            T();
        }
    }

    private void aj() {
        if (this.ar == null) {
            Timer timer = new Timer();
            this.ar = timer;
            timer.schedule(new AnonymousClass5(), 0L, 300L);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView$5, reason: invalid class name */
    final class AnonymousClass5 extends TimerTask {
        AnonymousClass5() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ThirdPartyHalfScreenATView thirdPartyHalfScreenATView = ThirdPartyHalfScreenATView.this;
            ThirdPartyHalfScreenATView.a(thirdPartyHalfScreenATView, (int) thirdPartyHalfScreenATView.ap.getVideoProgress());
        }
    }

    private void ak() {
        Timer timer = this.ar;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void al() {
        Timer timer = this.ar;
        if (timer != null) {
            timer.cancel();
            this.ar = null;
        }
        this.ao.b(this.aw);
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.thirdparty.ThirdPartyHalfScreenATView$6, reason: invalid class name */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ int a;

        AnonymousClass6(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a * 1000;
            ThirdPartyHalfScreenATView.this.b(i);
            if (ThirdPartyHalfScreenATView.this.C < 0 || i < ThirdPartyHalfScreenATView.this.C) {
                return;
            }
            ThirdPartyHalfScreenATView.this.T();
        }
    }

    private void f(int i) {
        post(new AnonymousClass6(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(com.anythink.core.common.l.a aVar) {
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
            this.av.addView(view, layoutParams);
        }
    }

    private void an() {
        ViewGroup customAdContainer;
        if (this.M == null || (customAdContainer = this.ap.getCustomAdContainer()) == null) {
            return;
        }
        if (!this.ap.isNativeExpress() && as()) {
            View view = this.aq;
            if (aq()) {
                c.c(customAdContainer);
                c.c(view);
            } else if (ar()) {
                c.c(view);
            }
        }
        ViewParent parent = this.M.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this.M);
            if (iIndexOfChild >= 0) {
                viewGroup.removeViewAt(iIndexOfChild);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, this.M.getLayoutParams().height);
            layoutParams.gravity = 17;
            customAdContainer.addView(this.M, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = q.a(getContext(), 26.0f);
            layoutParams2.rightMargin = q.a(getContext(), 26.0f);
            viewGroup.addView(customAdContainer, iIndexOfChild, layoutParams2);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.basead.mixad.f.b bVar = this.as;
        if (bVar != null) {
            bVar.a(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void ao() {
        ArrayList arrayList = new ArrayList();
        View view = this.aq;
        if (view != null) {
            arrayList.add(view);
        }
        if (this.O != null) {
            arrayList.add(this.O);
        }
        if (this.N != null) {
            arrayList.add(this.N.getIconView());
        }
        this.as = new com.anythink.basead.mixad.f.b.a().a(arrayList).a(this.N.getTitleView()).b(this.N.getDescView()).c(this.N.getCTAButton()).a();
    }

    private boolean ap() {
        return (this.g == null || !TextUtils.isEmpty(this.g.B()) || this.aq == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aq() {
        return this.f != null && this.f.f == 39;
    }

    private boolean ar() {
        return this.f != null && this.f.f == 59;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean as() {
        return (this.f == null || this.f.o == null || this.f.o.H() == 0) ? false : true;
    }

    private boolean at() {
        return this.ap.isNativeExpress();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    protected final void x() {
        if (this.ap.isNativeExpress()) {
            return;
        }
        if (this.g != null && TextUtils.isEmpty(this.g.B()) && this.aq == null) {
            return;
        }
        super.x();
    }

    private boolean am() {
        if (this.ap.isNativeExpress()) {
            return true;
        }
        BaseAd baseAd = this.ap;
        boolean z = false;
        if (baseAd != null) {
            if (TextUtils.equals(baseAd.getAdType(), "1") && this.aq != null) {
                z = true;
            }
            Object[] objArr = new Object[1];
            Boolean.valueOf(z);
        }
        return z;
    }

    private void a(ViewGroup viewGroup) {
        if (!this.ap.isNativeExpress() && as()) {
            View view = this.aq;
            if (aq()) {
                c.c(viewGroup);
                c.c(view);
            } else if (ar()) {
                c.c(view);
            }
        }
    }

    static /* synthetic */ void h(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView) {
        if (thirdPartyHalfScreenATView.ar == null) {
            Timer timer = new Timer();
            thirdPartyHalfScreenATView.ar = timer;
            timer.schedule(thirdPartyHalfScreenATView.new AnonymousClass5(), 0L, 300L);
        }
    }

    static /* synthetic */ void p(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView) {
        Timer timer = thirdPartyHalfScreenATView.ar;
        if (timer != null) {
            timer.cancel();
        }
    }

    static /* synthetic */ void a(ThirdPartyHalfScreenATView thirdPartyHalfScreenATView, int i) {
        thirdPartyHalfScreenATView.post(thirdPartyHalfScreenATView.new AnonymousClass6(i));
    }
}
