package com.anythink.basead.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.g.j;
import com.anythink.basead.j.e;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.basead.ui.guidetoclickv2.d;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.api.IExHandlerBaseAd;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.h.ay;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseATView extends RelativeLayout implements com.anythink.basead.ui.guidetoclickv2.c {
    private IExHandlerBaseAd.DataFetchListener a;
    String e;
    protected x f;
    protected w g;
    com.anythink.core.common.v.a.c h;
    com.anythink.basead.b.c i;
    volatile boolean j;
    volatile boolean k;
    protected boolean l;
    String m;
    protected List<View> n;
    View o;
    protected boolean p;
    protected View q;
    protected com.anythink.basead.ui.component.a r;
    protected com.anythink.basead.ui.improveclick.a s;
    d t;
    protected com.anythink.basead.ui.f.c u;
    protected long v;
    protected long w;
    protected boolean x;
    protected boolean y;
    protected e z;

    public static class a {
        public static final int A = 202;
        public static final int B = 203;
        public static final int C = 204;
        public static final int D = 205;
        public static final int E = 206;
        public static final int F = 207;
        public static final int G = 208;
        public static final int H = 209;
        public static final int I = 210;
        public static final int J = 211;
        public static final int K = 212;
        public static final int L = 301;
        public static final int M = 302;
        public static final int N = 303;
        public static final int O = 304;
        public static final int P = 305;
        public static final int a = 101;
        public static final int b = 102;
        public static final int c = 103;
        public static final int d = 104;
        public static final int e = 105;
        public static final int f = 106;
        public static final int g = 107;
        public static final int h = 108;
        public static final int i = 110;
        public static final int j = 111;
        public static final int k = 112;
        public static final int l = 113;
        public static final int m = 114;
        public static final int n = 115;
        public static final int o = 116;
        public static final int p = 117;
        public static final int q = 118;
        public static final int r = 119;
        public static final int s = 120;
        public static final int t = 121;
        public static final int u = 122;
        public static final int v = 123;
        public static final int w = 124;
        public static final int x = 125;
        public static final int y = 125;
        public static final int z = 201;
    }

    public static class b {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 100;
    }

    private View c() {
        return this;
    }

    protected abstract void a();

    protected abstract void a(j jVar);

    protected abstract void a(boolean z);

    protected boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        return false;
    }

    protected void e() {
    }

    protected abstract void f();

    protected void g() {
    }

    protected void h() {
    }

    protected boolean p() {
        return false;
    }

    protected RelativeLayout.LayoutParams q() {
        return null;
    }

    protected int r() {
        return 0;
    }

    protected boolean t() {
        return true;
    }

    protected void u() {
    }

    public BaseATView(Context context, x xVar, w wVar, String str) {
        super(context);
        this.e = "BaseATView";
        this.j = false;
        this.k = false;
        this.l = false;
        this.p = false;
        this.f = xVar;
        this.g = wVar;
        this.m = str;
        this.n = new ArrayList();
        this.u = new com.anythink.basead.ui.f.c(this.g);
        this.z = new e(this.g, this.f);
        e();
        a();
        i();
        w wVar2 = this.g;
        if (wVar2 != null && !wVar2.c()) {
            setFocusable(true);
            setClickable(true);
        }
        if (wVar != null && wVar.ae()) {
            this.a = new AnonymousClass4(wVar);
            com.anythink.basead.b.a().addDataFetchListener(this.a);
        }
        post(new AnonymousClass5(wVar));
    }

    public BaseATView(Context context, x xVar, w wVar) {
        this(context, xVar, wVar, "");
    }

    public BaseATView(Context context) {
        super(context);
        this.e = "BaseATView";
        this.j = false;
        this.k = false;
        this.l = false;
        this.p = false;
    }

    protected void i() {
        this.s = new com.anythink.basead.ui.improveclick.a(this, this.g, this.f, r(), s()) { // from class: com.anythink.basead.ui.BaseATView.1
            @Override // com.anythink.basead.ui.improveclick.a
            public final ViewGroup.LayoutParams a() {
                return BaseATView.this.q();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void j() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (v()) {
            com.anythink.core.common.u.e.c(this.g, this.f, 3);
            u();
            this.k = true;
            return;
        }
        w wVar = this.g;
        if (wVar instanceof ay) {
            com.anythink.basead.h.a.b.a(getContext()).a((ay) this.g);
        } else if (wVar instanceof bj) {
            com.anythink.basead.f.f.c.a().a(getContext(), com.anythink.basead.f.f.c.a(this.f.b, this.f.c), this.g, this.f.o);
        }
        if ((this.g instanceof bj) && this.f.f == 67) {
            if (((bj) this.g).a(true, true)) {
                com.anythink.core.common.f.c.a(getContext()).a(this.g.v(), 0, 1);
            }
            if (((bj) this.g).a(false, true)) {
                com.anythink.core.common.f.b.a(getContext()).a(this.g.w(), 0, 1);
            }
        }
        a(114);
        com.anythink.basead.b.b.a(8, this.g, l());
        f();
    }

    protected void a(int i, int i2) {
        this.l = true;
        j();
        if (this.i == null) {
            this.i = new com.anythink.basead.b.c(getContext(), this.f, this.g, this);
        }
        if (this.i.a()) {
            return;
        }
        if (this.g.ae() && i == 1 && ((i2 == 1 || i2 == 6) && this.g.aa() == 4 && this.f.o.aM())) {
            com.anythink.basead.b.a().pause(this.g);
            return;
        }
        if (i != 5 && i != 6 && i != 7) {
            int iA = com.anythink.basead.ui.f.c.a(i, i2);
            if (iA == 0 || iA == 1) {
                this.y = true;
            } else if (iA == 2) {
                this.x = true;
            }
        }
        if (this.p) {
            if (i2 == 1) {
                i2 = 6;
            } else if (i2 == 2 || i2 == 3) {
                i2 = 7;
            } else if (i2 == 4) {
                i2 = 8;
            } else if (i2 == 5) {
                i2 = 9;
            }
        }
        final j jVarA = new j().a(i, i2);
        this.i.a(new com.anythink.basead.b.c.a() { // from class: com.anythink.basead.ui.BaseATView.2
            @Override // com.anythink.basead.b.c.a
            public final void a() {
                if (BaseATView.this.k) {
                    return;
                }
                if (BaseATView.this.v()) {
                    if (BaseATView.this.g != null && BaseATView.this.g.r() != null && BaseATView.this.g.r().bK() == 2) {
                        com.anythink.core.common.u.e.c(BaseATView.this.g, BaseATView.this.f, 2);
                    } else {
                        com.anythink.core.common.u.e.c(BaseATView.this.g, BaseATView.this.f, 1);
                        return;
                    }
                }
                BaseATView.this.a(jVarA);
                BaseATView.this.k();
            }

            @Override // com.anythink.basead.b.c.a
            public final void b() {
                BaseATView.this.g();
            }

            @Override // com.anythink.basead.b.c.a
            public final void c() {
                BaseATView.this.h();
            }

            @Override // com.anythink.basead.b.c.a
            public final void a(boolean z) {
                if (BaseATView.this.k) {
                    return;
                }
                if (!BaseATView.this.v() || BaseATView.this.g == null || BaseATView.this.g.r() == null || BaseATView.this.g.r().bK() == 2) {
                    BaseATView.this.a(z);
                }
            }

            @Override // com.anythink.basead.b.c.a
            public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
                return BaseATView.this.a(str, iOfferClickHandler);
            }
        });
        com.anythink.basead.d.j jVarL = l();
        com.anythink.basead.ui.f.c cVar = this.u;
        if (cVar != null) {
            if (i != 1) {
                View view = this.o;
                if (view != null) {
                    jVarL.i = cVar.a(view, i, i2);
                } else {
                    jVarL.i = cVar.a(this, i, i2);
                }
            } else {
                jVarL.i = cVar.a();
            }
        }
        this.i.a(jVarL);
        if (this.s != null) {
            HashMap map = new HashMap();
            map.put("click_type", Integer.valueOf(i));
            map.put(g.a.g, Integer.valueOf(i2));
            this.s.a(map);
        }
        a(113);
    }

    protected void a(final int i, final Runnable runnable) {
        w wVar = this.g;
        int iBL = (wVar == null || wVar.r() == null) ? 1 : this.g.r().bL();
        if (i > 0) {
            getContext();
            this.h = new com.anythink.core.common.v.a.c(iBL, i);
        } else {
            getContext();
            this.h = new com.anythink.core.common.v.a.c(iBL);
        }
        this.h.a(this, new com.anythink.core.common.v.a.a() { // from class: com.anythink.basead.ui.BaseATView.3
            @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
            public final void recordImpression(View view) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }

            @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
            public final int getImpressionMinTimeViewed() {
                int i2 = i;
                if (i2 > 0) {
                    return i2;
                }
                return 50;
            }
        });
    }

    private void b() {
        w wVar = this.g;
        if (wVar instanceof ay) {
            com.anythink.basead.h.a.b.a(getContext()).a((ay) this.g);
        } else if (wVar instanceof bj) {
            com.anythink.basead.f.f.c.a().a(getContext(), com.anythink.basead.f.f.c.a(this.f.b, this.f.c), this.g, this.f.o);
        }
        if ((this.g instanceof bj) && this.f.f == 67) {
            if (((bj) this.g).a(true, true)) {
                com.anythink.core.common.f.c.a(getContext()).a(this.g.v(), 0, 1);
            }
            if (((bj) this.g).a(false, true)) {
                com.anythink.core.common.f.b.a(getContext()).a(this.g.w(), 0, 1);
            }
        }
    }

    protected final void k() {
        if ((this.g instanceof bj) && this.f.f == 67) {
            if (((bj) this.g).a(true, false)) {
                com.anythink.core.common.f.c.a(getContext()).a(this.g.v(), 1, 0);
            }
            if (((bj) this.g).a(false, false)) {
                com.anythink.core.common.f.b.a(getContext()).a(this.g.w(), 1, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(117);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.v == 0) {
            this.v = System.currentTimeMillis();
            if (!this.z.a()) {
                a(201);
            }
        }
        a(116);
    }

    public void destroy() {
        a(112);
        com.anythink.basead.b.c cVar = this.i;
        if (cVar != null) {
            cVar.d();
        }
        com.anythink.core.common.v.a.c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.b();
        }
        if (this.a != null) {
            com.anythink.basead.b.a().removeDataFetchListener(this.a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.anythink.basead.ui.f.c cVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            com.anythink.basead.ui.f.c cVar2 = this.u;
            if (cVar2 != null) {
                cVar2.a((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
            }
        } else if ((action == 1 || action == 3) && (cVar = this.u) != null) {
            cVar.b((int) motionEvent.getRawX(), (int) motionEvent.getRawY(), (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected com.anythink.basead.d.j l() {
        com.anythink.basead.d.j jVar = new com.anythink.basead.d.j(this.f, "");
        jVar.g = getWidth();
        jVar.h = getHeight();
        try {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            jVar.n = iArr[0];
            jVar.o = iArr[1];
        } catch (Throwable unused) {
        }
        jVar.p = 100;
        x xVar = this.f;
        if (xVar != null && xVar.j == 2) {
            jVar.p = f.b.a(this);
        }
        jVar.q = this.v;
        return jVar;
    }

    protected final com.anythink.basead.d.a m() {
        com.anythink.basead.ui.f.c cVar = this.u;
        if (cVar != null) {
            return cVar.a();
        }
        return null;
    }

    private void b(View view) {
        this.o = view;
    }

    protected boolean n() {
        return com.anythink.basead.b.e.a(this.f);
    }

    protected float a(com.anythink.basead.ui.b bVar, boolean z) {
        return com.anythink.basead.ui.f.b.a(bVar, z, this.f, true);
    }

    protected final boolean o() {
        return com.anythink.basead.b.e.b(this.g);
    }

    public boolean isShowingEndCardAfterVideoPlay() {
        return this.p;
    }

    public void setShowingEndCardAfterVideoPlay(boolean z) {
        this.p = z;
    }

    public boolean getHasPerformClick() {
        return this.l;
    }

    public void setHasPerformClick(boolean z) {
        this.l = z;
    }

    protected void a(int i) {
        if (i == 114) {
            this.w = System.currentTimeMillis();
        }
        e eVar = this.z;
        if (eVar != null) {
            eVar.a(i, this);
        }
        com.anythink.basead.ui.improveclick.a aVar = this.s;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        synchronized (this) {
            try {
                d dVar = this.t;
                if (dVar != null && dVar.a(motionEvent)) {
                    return true;
                }
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.c
    public void setCallback(d dVar) {
        synchronized (this) {
            this.t = dVar;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseATView$4, reason: invalid class name */
    final class AnonymousClass4 extends com.anythink.basead.b.a {
        AnonymousClass4(w wVar) {
            super(wVar);
        }

        @Override // com.anythink.core.api.IExHandlerBaseAd.DataFetchListener
        public final void onStatusChanged(String str) {
            if (BaseATView.this.q != null && (BaseATView.this.q instanceof CTAButtonLayout)) {
                ((CTAButtonLayout) BaseATView.this.q).setMajorCTAText(str);
            }
            if (BaseATView.this.s != null) {
                HashMap map = new HashMap();
                map.put(g.a.h, str);
                BaseATView.this.s.a(map);
            }
            BaseATView.this.a(121);
        }
    }

    private void a(w wVar) {
        if (wVar == null || !wVar.ae()) {
            return;
        }
        this.a = new AnonymousClass4(wVar);
        com.anythink.basead.b.a().addDataFetchListener(this.a);
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseATView$5, reason: invalid class name */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ w a;

        AnonymousClass5(w wVar) {
            this.a = wVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!(BaseATView.this.q instanceof ScanningAnimButton) || this.a.r() == null) {
                return;
            }
            ((ScanningAnimButton) BaseATView.this.q).startAnimation(this.a.r().aF());
        }
    }

    private void b(w wVar) {
        post(new AnonymousClass5(wVar));
    }

    protected com.anythink.basead.ui.improveclick.c.a s() {
        return new com.anythink.basead.ui.improveclick.c.a() { // from class: com.anythink.basead.ui.BaseATView.6
            @Override // com.anythink.basead.ui.improveclick.c.a
            public final void a(int i, int i2) {
                BaseATView.this.a(i, i2);
            }
        };
    }

    protected final void a(View view) {
        if (this.z == null || view == null || !(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            this.z.b(viewGroup.getChildAt(i));
        }
    }

    protected final boolean v() {
        w wVar = this.g;
        if (wVar instanceof bj) {
            return ((bj) wVar).ax();
        }
        return false;
    }
}
