package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.inner.e.e;
import com.anythink.core.common.u.a.f;
import com.anythink.core.common.u.al;
import com.anythink.core.common.u.p;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSplashATView extends BaseATView {
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    private f.b a;
    private long b;
    private Map<String, Object> c;
    protected TextView q;
    protected CloseFrameLayout r;
    public int ranDom;
    protected CloseShadeView s;
    protected String t;
    protected Timer u;
    protected volatile boolean v;
    protected com.anythink.core.common.inner.e.a w;
    final long x;
    protected com.anythink.core.common.inner.ui.e.a y;
    protected int z;

    private static void i() {
    }

    private static boolean j() {
        return false;
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a(boolean z) {
    }

    public BaseSplashATView(Context context) {
        super(context);
        this.t = "Skip";
        this.x = 1000L;
        this.b = 5000L;
        this.A = false;
        this.B = false;
        this.C = false;
    }

    public BaseSplashATView(Context context, x xVar, w wVar, com.anythink.core.common.inner.e.a aVar) {
        super(context, xVar, wVar);
        this.t = "Skip";
        this.x = 1000L;
        this.b = 5000L;
        this.A = false;
        this.B = false;
        this.C = false;
        this.a = new f.b((wVar == null || wVar.f() == null) ? 1 : wVar.f().ac());
        this.w = aVar;
        this.t = getResources().getString(p.a(getContext(), "myoffer_splash_skip_text", "string"));
        this.q = (TextView) findViewById(p.a(getContext(), "myoffer_splash_skip", "id"));
        this.r = (CloseFrameLayout) findViewById(p.a(getContext(), "myoffer_splash_skip_area", "id"));
        this.s = (CloseShadeView) findViewById(p.a(getContext(), "myoffer_splash_skip_shade_area", "id"));
        this.b = this.f.t.i();
        this.v = false;
        com.anythink.core.common.inner.ui.e.a aVar2 = new com.anythink.core.common.inner.ui.e.a(this.g, this.f);
        this.y = aVar2;
        aVar2.b(this);
        this.ranDom = new Random().nextInt(100) + 1;
        this.z = this.f.t.a();
        int i = this.f.j;
        if (i == 34 || i == 58 || i == 2 || i == 39) {
            this.z = -1;
        }
    }

    public void checkSkipViewLocation() {
        try {
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                int iB = ((FrameLayout.LayoutParams) layoutParams).topMargin + p.b(getContext());
                int[] iArr = new int[2];
                this.q.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (i < iB) {
                    int i2 = iB - i;
                    ViewParent parent = this.q.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).setPadding(((ViewGroup) parent).getPaddingLeft(), ((ViewGroup) parent).getPaddingTop() + i2, ((ViewGroup) parent).getPaddingRight(), ((ViewGroup) parent).getPaddingBottom());
                    }
                    View viewFindViewById = findViewById(p.a(getContext(), "myoffer_btn_mute_id", "id"));
                    if (viewFindViewById != null && (viewFindViewById.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
                        layoutParams2.topMargin += i2;
                        viewFindViewById.setLayoutParams(layoutParams2);
                    }
                    View viewFindViewById2 = findViewById(p.a(getContext(), "myoffer_feedback_ll_id", "id"));
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

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.B) {
            return;
        }
        this.B = true;
        if (this.D) {
            return;
        }
        this.r.setVisibility(0);
        this.r.setOnClickListener(new AnonymousClass1());
        if (this.z >= this.ranDom) {
            CloseFrameLayout closeFrameLayout = this.r;
            if (closeFrameLayout != null) {
                closeFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2());
            }
            CloseShadeView closeShadeView = this.s;
            if (closeShadeView != null) {
                closeShadeView.setVisibility(0);
            }
        } else {
            CloseShadeView closeShadeView2 = this.s;
            if (closeShadeView2 != null) {
                closeShadeView2.setVisibility(8);
            }
        }
        this.C = false;
        Timer timer = new Timer();
        this.u = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.b);
        this.b -= 1000;
    }

    public void setDontCountDown(boolean z) {
        this.D = z;
        if (z) {
            CloseFrameLayout closeFrameLayout = this.r;
            if (closeFrameLayout != null) {
                closeFrameLayout.setVisibility(8);
            }
            CloseShadeView closeShadeView = this.s;
            if (closeShadeView != null) {
                closeShadeView.setVisibility(8);
            }
        }
    }

    private void b() {
        if (this.B) {
            return;
        }
        this.B = true;
        if (this.D) {
            return;
        }
        this.r.setVisibility(0);
        this.r.setOnClickListener(new AnonymousClass1());
        if (this.z >= this.ranDom) {
            CloseFrameLayout closeFrameLayout = this.r;
            if (closeFrameLayout != null) {
                closeFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2());
            }
            CloseShadeView closeShadeView = this.s;
            if (closeShadeView != null) {
                closeShadeView.setVisibility(0);
            }
        } else {
            CloseShadeView closeShadeView2 = this.s;
            if (closeShadeView2 != null) {
                closeShadeView2.setVisibility(8);
            }
        }
        this.C = false;
        Timer timer = new Timer();
        this.u = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.b);
        this.b -= 1000;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseSplashATView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (BaseSplashATView.this.f.t.k() == 0 || BaseSplashATView.this.C) {
                BaseSplashATView.this.g();
            }
        }
    }

    private void c() {
        this.r.setVisibility(0);
        this.r.setOnClickListener(new AnonymousClass1());
        if (this.z >= this.ranDom) {
            CloseFrameLayout closeFrameLayout = this.r;
            if (closeFrameLayout != null) {
                closeFrameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2());
            }
            CloseShadeView closeShadeView = this.s;
            if (closeShadeView != null) {
                closeShadeView.setVisibility(0);
            }
        } else {
            CloseShadeView closeShadeView2 = this.s;
            if (closeShadeView2 != null) {
                closeShadeView2.setVisibility(8);
            }
        }
        this.C = false;
        Timer timer = new Timer();
        this.u = timer;
        timer.schedule(new AnonymousClass3(), 1000L, 1000L);
        a(this.b);
        this.b -= 1000;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseSplashATView$2, reason: invalid class name */
    final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams;
            if (BaseSplashATView.this.s != null && (layoutParams = BaseSplashATView.this.s.getLayoutParams()) != null) {
                layoutParams.width = BaseSplashATView.this.r.getWidth();
                layoutParams.height = BaseSplashATView.this.r.getHeight();
                BaseSplashATView.this.s.setLayoutParams(layoutParams);
            }
            BaseSplashATView.this.r.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.ui.BaseSplashATView$3, reason: invalid class name */
    final class AnonymousClass3 extends TimerTask {
        AnonymousClass3() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            BaseSplashATView baseSplashATView = BaseSplashATView.this;
            if (al.a(baseSplashATView, baseSplashATView.a)) {
                BaseSplashATView.this.post(new Runnable() { // from class: com.anythink.core.common.inner.ui.BaseSplashATView.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (BaseSplashATView.this.b > 0) {
                            BaseSplashATView.this.a(BaseSplashATView.this.b);
                            BaseSplashATView.this.b -= 1000;
                            return;
                        }
                        BaseSplashATView.c(BaseSplashATView.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.f.t.k() == 0) {
            this.q.setText((j / 1000) + "s | " + this.t);
        } else {
            this.q.setText((j / 1000) + " s");
        }
    }

    private void f() {
        g();
        this.q.setText(this.t);
        this.C = true;
    }

    protected void g() {
        h();
        if (this.v) {
            return;
        }
        this.v = true;
        com.anythink.core.common.inner.e.a aVar = this.w;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void e() {
        this.A = true;
        if (this.w != null) {
            new e();
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATView
    protected final void a(e eVar) {
        if (this.g == null || this.g.f() == null || !this.g.f().C()) {
            return;
        }
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.inner.ui.BaseSplashATView.4
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashATView.this.g();
            }
        });
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSkipViewLocation();
    }

    public void setAdExtraInfoMap(Map<String, Object> map) {
        this.c = map;
    }

    protected final void h() {
        Timer timer = this.u;
        if (timer != null) {
            timer.cancel();
        }
        this.u = null;
    }

    static /* synthetic */ void c(BaseSplashATView baseSplashATView) {
        baseSplashATView.g();
        baseSplashATView.q.setText(baseSplashATView.t);
        baseSplashATView.C = true;
    }
}
