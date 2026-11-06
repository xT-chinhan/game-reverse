package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.d.g;
import com.anythink.basead.e;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.basead.ui.f.d;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.a.f;
import com.anythink.core.common.v.am;
import com.anythink.core.common.v.q;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSplashATView extends BaseATView {
    private Map<String, Object> A;
    private final int B;
    private final int C;
    private final int D;
    private AtomicInteger E;
    protected TextView I;
    protected CloseFrameLayout J;
    protected ViewGroup K;
    protected String L;
    protected Timer M;
    protected volatile boolean N;
    protected com.anythink.basead.g.a O;
    protected c P;
    final long Q;
    protected e R;
    protected final View.OnClickListener S;
    protected d T;
    protected int U;
    protected com.anythink.basead.ui.f.a V;
    boolean W;
    private f.b a;
    boolean aa;
    boolean ab;
    boolean ac;
    private long b;
    private long c;
    private boolean d;

    @Override // com.anythink.basead.ui.BaseATView
    protected int r() {
        return 3;
    }

    protected boolean y() {
        return false;
    }

    public BaseSplashATView(Context context) {
        super(context);
        this.L = "Skip";
        this.Q = 1000L;
        this.b = 5000L;
        this.c = 5000L;
        this.d = false;
        this.S = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseSplashATView.this.q != null && BaseSplashATView.this.q == view) {
                    BaseSplashATView.this.a(1, 1);
                } else {
                    BaseSplashATView.this.a(1, 2);
                }
            }
        };
        this.U = 2;
        this.B = 1;
        this.C = 2;
        this.D = 3;
        this.E = new AtomicInteger(1);
        this.W = false;
        this.aa = false;
        this.ab = false;
    }

    public BaseSplashATView(Context context, x xVar, w wVar, com.anythink.basead.g.a aVar) {
        Drawable directlySplashAdCTAButtongBgDrawable;
        super(context, xVar, wVar);
        this.L = "Skip";
        this.Q = 1000L;
        this.b = 5000L;
        this.c = 5000L;
        this.d = false;
        this.S = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashATView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseSplashATView.this.q != null && BaseSplashATView.this.q == view) {
                    BaseSplashATView.this.a(1, 1);
                } else {
                    BaseSplashATView.this.a(1, 2);
                }
            }
        };
        this.U = 2;
        int iBL = 1;
        this.B = 1;
        this.C = 2;
        this.D = 3;
        this.E = new AtomicInteger(1);
        this.W = false;
        this.aa = false;
        this.ab = false;
        if (wVar != null && wVar.r() != null) {
            iBL = wVar.r().bL();
        }
        this.a = new f.b(iBL);
        this.O = aVar;
        this.L = getResources().getString(q.a(getContext(), "myoffer_splash_skip_text", "string"));
        this.I = (TextView) findViewById(q.a(getContext(), "myoffer_splash_skip", "id"));
        this.J = (CloseFrameLayout) findViewById(q.a(getContext(), "myoffer_splash_skip_area", "id"));
        this.K = (ViewGroup) findViewById(q.a(getContext(), "myoffer_feedback_ll_id", "id"));
        this.b = this.f.o.x();
        this.N = false;
        a((b) this.J, false);
        if (wVar.b() == 4) {
            try {
                if (this.q != null && (this.q instanceof CTAButtonLayout) && (directlySplashAdCTAButtongBgDrawable = ATSDKGlobalSetting.getDirectlySplashAdCTAButtongBgDrawable()) != null) {
                    ((CTAButtonLayout) this.q).changeMajorButtonBackground(directlySplashAdCTAButtongBgDrawable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.c = this.f.o.aB();
        com.anythink.basead.ui.f.a aVar2 = new com.anythink.basead.ui.f.a(this.g, this.f);
        this.V = aVar2;
        aVar2.b(this);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected void e() {
        super.e();
        if (this.f != null) {
            this.T = new d(this.g, this.f.o);
        }
    }

    public void checkSkipViewLocation() {
        try {
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                int iB = ((FrameLayout.LayoutParams) layoutParams).topMargin + q.b(getContext());
                int[] iArr = new int[2];
                this.I.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (i < iB) {
                    int i2 = iB - i;
                    ViewParent parent = this.I.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).setPadding(((ViewGroup) parent).getPaddingLeft(), ((ViewGroup) parent).getPaddingTop() + i2, ((ViewGroup) parent).getPaddingRight(), ((ViewGroup) parent).getPaddingBottom());
                    }
                    View viewFindViewById = findViewById(q.a(getContext(), "myoffer_btn_mute_id", "id"));
                    if (viewFindViewById != null && (viewFindViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        layoutParams2.topMargin += i2;
                        viewFindViewById.setLayoutParams(layoutParams2);
                    }
                    View viewFindViewById2 = findViewById(q.a(getContext(), "myoffer_feedback_ll_id", "id"));
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

    protected final void a(com.anythink.basead.d.f fVar) {
        if (this.W) {
            return;
        }
        this.W = true;
        com.anythink.basead.g.a aVar = this.O;
        if (aVar != null) {
            aVar.onShowFailed(fVar);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.aa) {
            return;
        }
        this.aa = true;
        if (this.ac) {
            return;
        }
        this.J.setVisibility(0);
        this.J.setOnClickListener(new AnonymousClass2());
        this.ab = false;
        Timer timer = new Timer();
        this.M = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.b);
        this.b -= 1000;
    }

    public void setDontCountDown(boolean z) {
        CloseFrameLayout closeFrameLayout;
        this.ac = z;
        if (!z || (closeFrameLayout = this.J) == null) {
            return;
        }
        closeFrameLayout.setVisibility(8);
    }

    private void b() {
        if (this.aa) {
            return;
        }
        this.aa = true;
        if (this.ac) {
            return;
        }
        this.J.setVisibility(0);
        this.J.setOnClickListener(new AnonymousClass2());
        this.ab = false;
        Timer timer = new Timer();
        this.M = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.b);
        this.b -= 1000;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSplashATView$2, reason: invalid class name */
    final class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (BaseSplashATView.this.f.o.z() == 0 || BaseSplashATView.this.ab) {
                BaseSplashATView.this.a(true, 1);
            }
        }
    }

    private void c() {
        this.J.setVisibility(0);
        this.J.setOnClickListener(new AnonymousClass2());
        this.ab = false;
        Timer timer = new Timer();
        this.M = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.b);
        this.b -= 1000;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseSplashATView$3, reason: invalid class name */
    final class AnonymousClass3 extends TimerTask {
        AnonymousClass3() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            BaseSplashATView baseSplashATView = BaseSplashATView.this;
            if (!am.a(baseSplashATView, baseSplashATView.a)) {
                if (BaseSplashATView.this.E.compareAndSet(2, 3)) {
                    BaseSplashATView.this.a(111);
                }
            } else {
                BaseSplashATView.this.post(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashATView.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (BaseSplashATView.this.b > 0) {
                            BaseSplashATView.this.a(BaseSplashATView.this.b);
                            BaseSplashATView.this.b -= 1000;
                        } else {
                            if (BaseSplashATView.this.needShowSplashEndCard()) {
                                BaseSplashATView.this.onSplashEndCardCountDownTick(BaseSplashATView.this.c);
                                BaseSplashATView.this.c -= 1000;
                                if (BaseSplashATView.this.c <= 0) {
                                    BaseSplashATView.d(BaseSplashATView.this);
                                    return;
                                }
                                return;
                            }
                            BaseSplashATView.d(BaseSplashATView.this);
                        }
                    }
                });
                if (BaseSplashATView.this.E.compareAndSet(3, 2)) {
                    BaseSplashATView.this.a(110);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f.o.z() == 0) {
            this.I.setText((j / 1000) + "s | " + this.L);
        } else {
            this.I.setText((j / 1000) + " s");
        }
    }

    private void d() {
        a(true, 2);
        this.I.setText(this.L);
        this.ab = true;
    }

    protected void a(boolean z, int i) {
        B();
        if (!((i != 2 && i != 7) || this.f.o == null || this.f.o.bG() == 1) || this.N) {
            return;
        }
        if (i == 2 && y()) {
            Map<String, Object> map = this.A;
            if (map != null) {
                map.put(com.anythink.core.common.a.b.C0077b.c, 1);
                return;
            }
            return;
        }
        this.N = true;
        this.U = i;
        if (i == 6 && this.r != null) {
            this.r.c();
        }
        if (i == 1 && this.ab && this.f.o != null && this.f.o.bG() != 1) {
            i = 11;
        }
        a(115);
        if (!this.W) {
            a(g.a(g.k, "SplashView not showing on screen."));
        }
        com.anythink.core.common.u.e.a(this.g, this.f, this.y, this.x);
        Map<String, Object> map2 = this.A;
        if (map2 != null) {
            map2.put(com.anythink.core.common.a.b.C0077b.a, Integer.valueOf(i));
            this.A.put(com.anythink.core.common.a.b.C0077b.b, Boolean.valueOf(z));
        }
        com.anythink.basead.g.a aVar = this.O;
        if (aVar != null) {
            aVar.onAdClosed();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void f() {
        this.W = true;
        com.anythink.basead.g.a aVar = this.O;
        if (aVar != null) {
            aVar.onAdShow(new j());
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(j jVar) {
        com.anythink.basead.g.a aVar = this.O;
        if (aVar != null) {
            aVar.onAdClick(jVar);
        }
        if (this.g == null || this.g.r() == null || !this.g.r().aE()) {
            return;
        }
        t.b().b(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashATView.4
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashATView.this.a(true, 6);
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(boolean z) {
        com.anythink.basead.g.a aVar = this.O;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(int i, int i2) {
        super.a(i, i2);
        a((b) this.J, true);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void g() {
        if (this.g instanceof bj) {
            if (this.P == null) {
                this.P = new c(this);
            }
            this.P.b();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void h() {
        if (!(this.g instanceof bj) || this.P == null) {
            return;
        }
        post(new Runnable() { // from class: com.anythink.basead.ui.BaseSplashATView.5
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashATView.this.P.c();
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        this.O = null;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSkipViewLocation();
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false, 3);
    }

    protected void x() {
        int size = this.n.size();
        for (int i = 0; i < size; i++) {
            View view = this.n.get(i);
            if (view != null) {
                view.setOnClickListener(this.S);
            }
        }
        ViewGroup viewGroup = this.K;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSplashATView.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BaseSplashATView.this.A();
                }
            });
        }
    }

    protected final void A() {
        a(111);
        if (this.R == null) {
            this.R = new e();
        }
        this.R.a(getContext(), this.g, this.f, new e.a() { // from class: com.anythink.basead.ui.BaseSplashATView.7
            @Override // com.anythink.basead.e.a
            public final void a() {
            }

            @Override // com.anythink.basead.e.a
            public final void b() {
                BaseSplashATView.this.a(110);
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final RelativeLayout.LayoutParams q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f.o.A() == 2) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, q.a(getContext(), 154.0f));
        } else {
            int measuredHeight = (getMeasuredHeight() * 2) / 3;
            layoutParams.addRule(11);
            layoutParams.setMargins(0, measuredHeight, 0, 0);
        }
        return layoutParams;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
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

    public void setAdExtraInfoMap(Map<String, Object> map) {
        this.A = map;
    }

    public boolean needShowSplashEndCard() {
        return (!this.l || this.d) && com.anythink.basead.b.e.b(this.g, this.f);
    }

    public void onSplashEndCardCountDownTick(long j) {
        this.d = true;
    }

    public void beforeSplashEndCardShow() {
        a(118);
        Map<String, Object> map = this.A;
        if (map != null) {
            map.put(com.anythink.core.common.a.b.C0077b.d, 1);
        }
    }

    protected final void B() {
        Timer timer = this.M;
        if (timer != null) {
            timer.cancel();
        }
        this.M = null;
    }

    protected final boolean C() {
        return com.anythink.basead.ui.f.b.a(this.w, this.f) && !this.N;
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void u() {
        super.u();
        a(g.a(g.k, g.ag));
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected void a(int i) {
        super.a(i);
        if (i == 110) {
            this.E.set(2);
        } else {
            if (i != 111) {
                return;
            }
            this.E.set(3);
        }
    }

    static /* synthetic */ void d(BaseSplashATView baseSplashATView) {
        baseSplashATView.a(true, 2);
        baseSplashATView.I.setText(baseSplashATView.L);
        baseSplashATView.ab = true;
    }
}
