package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.anythink.basead.d.f;
import com.anythink.basead.d.j;
import com.anythink.basead.e;
import com.anythink.basead.g.i;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.basead.ui.component.CTAButtonLayout;
import com.anythink.basead.ui.improveclick.d;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.core.basead.ui.web.WebProgressBarView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.h;
import com.anythink.core.common.v.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseScreenATView extends BaseATView {
    public static final int FORMAT_INTERSTITIAL = 3;
    public static final int FORMAT_REWARD_VIDEO = 1;
    public static final String TAG = "BaseScreenATView";
    protected int A;
    protected int B;
    protected int C;
    protected boolean D;
    protected int E;
    protected int F;
    protected long G;
    protected long H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected float L;
    protected RelativeLayout M;
    protected PanelView N;
    protected BaseEndCardView O;
    protected c P;
    protected CloseImageView Q;
    protected ViewGroup R;
    protected MuteImageView S;
    protected View T;
    com.anythink.basead.ui.f.a U;
    protected com.anythink.basead.ui.component.b V;
    protected i W;
    protected int a;
    protected boolean aa;
    protected boolean ab;
    Runnable ac;
    protected int ad;
    protected int ae;
    protected int af;
    protected int ag;
    private long ah;
    private long ai;
    private long aj;
    private long ak;
    private long al;
    private long am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private e ar;
    private CountDownView as;
    private ValueAnimator at;
    private WebProgressBarView au;
    protected int b;
    protected int c;
    protected int d;

    private interface a {
        void a(List<Bitmap> list);
    }

    protected void I() {
    }

    protected abstract void M();

    protected abstract void U();

    protected abstract boolean b(int i);

    protected void d() {
    }

    public void handleFullScreenClick() {
    }

    protected abstract int y();

    public BaseScreenATView(Context context) {
        super(context);
        this.F = 100;
        this.an = false;
        this.ac = new Runnable() { // from class: com.anythink.basead.ui.BaseScreenATView.10
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenATView.super.j();
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006b  */
    public BaseScreenATView(Context context, x xVar, w wVar, String str, int i, int i2) {
        super(context, xVar, wVar, str);
        this.F = 100;
        this.an = false;
        this.ac = new Runnable() { // from class: com.anythink.basead.ui.BaseScreenATView.10
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenATView.super.j();
            }
        };
        this.a = i;
        this.b = i2;
        this.aa = false;
        this.ap = false;
        this.ab = false;
        this.ah = this.f.o.F() > 0 ? this.f.o.F() * 1000 : this.f.o.F();
        long jG = this.f.o.G() > 0 ? this.f.o.G() * 1000 : this.f.o.G();
        this.ai = jG;
        if (jG > 0) {
            long j = this.ah;
            if (j >= 0) {
                this.aj = j + jG;
            } else {
                this.aj = jG;
            }
        } else {
            this.aj = jG;
        }
        this.ak = this.f.o.aC();
        long jAD = this.f.o.aD();
        this.al = jAD;
        if (jAD > 0) {
            this.am = this.ak + jAD;
        }
        this.C = this.f.o.J() * 1000;
        this.K = this.f.o.I() == 0;
        if (1 == this.a) {
            if (this.g.L()) {
                this.F = 100;
            } else if (this.f.o.an() == 1) {
                this.F = 101;
            } else if (this.f.o.ao() > 0) {
                this.F = this.f.o.ao();
            }
            this.H = this.f.o.o();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0050  */
    private void af() {
        this.ah = this.f.o.F() > 0 ? this.f.o.F() * 1000 : this.f.o.F();
        long jG = this.f.o.G() > 0 ? this.f.o.G() * 1000 : this.f.o.G();
        this.ai = jG;
        if (jG > 0) {
            long j = this.ah;
            if (j >= 0) {
                this.aj = j + jG;
            } else {
                this.aj = jG;
            }
        } else {
            this.aj = jG;
        }
        this.ak = this.f.o.aC();
        long jAD = this.f.o.aD();
        this.al = jAD;
        if (jAD > 0) {
            this.am = this.ak + jAD;
        }
        this.C = this.f.o.J() * 1000;
        this.K = this.f.o.I() == 0;
        if (1 == this.a) {
            if (this.g.L()) {
                this.F = 100;
            } else if (this.f.o.an() == 1) {
                this.F = 101;
            } else if (this.f.o.ao() > 0) {
                this.F = this.f.o.ao();
            }
            this.H = this.f.o.o();
        }
    }

    public void setListener(i iVar) {
        this.W = iVar;
    }

    public boolean isShowEndCard() {
        return this.I;
    }

    public void setIsShowEndCard(boolean z) {
        this.I = z;
    }

    public boolean hasReward() {
        return this.J;
    }

    public void setHasReward(boolean z) {
        this.J = z;
    }

    public boolean isVideoMute() {
        return this.K;
    }

    public void setVideoMute(boolean z) {
        this.K = z;
    }

    public long getShowBannerTime() {
        return this.ah;
    }

    public void setShowBannerTime(long j) {
        this.ah = j;
    }

    public long getHideBannerTime() {
        return this.aj;
    }

    public void setHideBannerTime(long j) {
        this.aj = j;
    }

    public void setCloseButtonScaleFactor(float f) {
        this.L = f;
        if (X() != null) {
            X().setClickAreaScaleFactor(this.L);
        }
    }

    public float getCloseButtonScaleFactor() {
        return this.L;
    }

    public void init() {
        b();
        if (this.I) {
            x();
            return;
        }
        int i = this.a;
        if (1 == i) {
            if (this.F == 100) {
                a((List<Bitmap>) null);
            } else {
                com.anythink.core.common.v.b.b.a().b(new AnonymousClass7(new AnonymousClass12()), 2);
            }
            ag();
            return;
        }
        if (3 == i) {
            if (com.anythink.basead.b.e.a(this.g, this.f)) {
                w();
                ag();
            } else {
                x();
                if (o()) {
                    return;
                }
                super.j();
            }
        }
    }

    protected void b() {
        this.M = (RelativeLayout) findViewById(q.a(getContext(), "myoffer_rl_root", "id"));
        this.Q = (CloseImageView) findViewById(q.a(getContext(), "myoffer_btn_close_id", "id"));
        this.N = (PanelView) findViewById(q.a(getContext(), "myoffer_banner_view_id", "id"));
        this.as = (CountDownView) findViewById(q.a(getContext(), "myoffer_count_down_view_id", "id"));
        this.S = (MuteImageView) findViewById(q.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.R = (ViewGroup) findViewById(q.a(getContext(), "myoffer_feedback_ll_id", "id"));
        this.r = new com.anythink.basead.ui.component.a(this, this.f, this.g, this.b);
        this.r.a(r());
        if (this.s != null) {
            this.r.a(this.s);
            HashMap map = new HashMap();
            map.put(g.a.e, Integer.valueOf(this.ad > this.ae ? 2 : 1));
            this.s.a(map);
        }
        this.r.a(new com.anythink.basead.ui.component.a.InterfaceC0058a() { // from class: com.anythink.basead.ui.BaseScreenATView.1
            @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
            public final j a() {
                return BaseScreenATView.this.l();
            }

            @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
            public final com.anythink.basead.d.a b() {
                return BaseScreenATView.this.m();
            }
        });
        this.au = (WebProgressBarView) findViewById(q.a(getContext(), "myoffer_player_view_progress_bar_id", "id"));
        this.V = new com.anythink.basead.ui.component.b(this.f.o, this.as, this.au);
        c();
        e(4);
        K();
        L();
        O();
        H();
        I();
        this.D = b(this.E);
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void i() {
        super.i();
        if (this.s != null) {
            this.s.a(new d.a() { // from class: com.anythink.basead.ui.BaseScreenATView.9
                @Override // com.anythink.basead.ui.improveclick.d.a
                public final View a() {
                    return BaseScreenATView.this.X();
                }

                @Override // com.anythink.basead.ui.improveclick.d.a
                public final void b() {
                    BaseScreenATView.this.M();
                }

                @Override // com.anythink.basead.ui.improveclick.d.a
                public final View c() {
                    if (BaseScreenATView.this.q == null || !(BaseScreenATView.this.q instanceof CTAButtonLayout)) {
                        return null;
                    }
                    return ((CTAButtonLayout) BaseScreenATView.this.q).getSubCloseView();
                }

                @Override // com.anythink.basead.ui.improveclick.d.a
                public final void d() {
                    Context context = BaseScreenATView.this.getContext();
                    if (!(context instanceof Activity) || context.getResources().getConfiguration().orientation == 1) {
                        return;
                    }
                    ((Activity) context).setRequestedOrientation(1);
                    if (BaseScreenATView.this.c > BaseScreenATView.this.d) {
                        BaseScreenATView.this.c += BaseScreenATView.this.d;
                        BaseScreenATView baseScreenATView = BaseScreenATView.this;
                        baseScreenATView.d = baseScreenATView.c - BaseScreenATView.this.d;
                        BaseScreenATView.this.c -= BaseScreenATView.this.d;
                    }
                }

                @Override // com.anythink.basead.ui.improveclick.d.a
                public final void a(boolean z) {
                    BaseScreenATView.this.aa = z;
                    if (z) {
                        BaseScreenATView.this.a(119);
                    }
                }
            });
        }
        if (this.r != null) {
            this.r.a(this.s);
        }
    }

    protected void c() {
        com.anythink.basead.ui.f.a aVar = new com.anythink.basead.ui.f.a(this.g, this.f);
        this.U = aVar;
        aVar.b(this);
    }

    private void ag() {
        if (o() && !com.anythink.basead.b.c.d.a(this.f, this.g) && this.O == null) {
            this.O = b(true);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final j l() {
        j jVar = new j(this.f, this.m);
        jVar.g = getWidth();
        jVar.h = getHeight();
        if (this.r != null) {
            jVar.j = this.r.d(true);
        }
        try {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            jVar.n = iArr[0];
            jVar.o = iArr[1];
        } catch (Throwable unused) {
        }
        jVar.p = 100;
        if (this.r != null) {
            jVar.j = this.r.d(true);
        }
        jVar.q = this.v;
        return jVar;
    }

    private void ah() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.c = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels;
        this.d = i;
        this.ad = this.c;
        this.ae = i;
    }

    protected void a(List<Bitmap> list) {
        d();
        a(0L);
        if (this.C == 0) {
            T();
        }
        if (this.r == null) {
            return;
        }
        this.r.a(new BasePlayerView.a() { // from class: com.anythink.basead.ui.BaseScreenATView.11
            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a(int i) {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void b() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void d() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void e() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void f() {
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a() {
                if (BaseScreenATView.this.s != null) {
                    HashMap map = new HashMap();
                    map.put(g.a.d, Long.valueOf(BaseScreenATView.this.r.h()));
                    BaseScreenATView.this.s.a(map);
                }
                BaseScreenATView.this.P();
                BaseScreenATView.this.j();
                BaseScreenATView.b(BaseScreenATView.this);
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a(long j) {
                if (BaseScreenATView.this.k) {
                    return;
                }
                BaseScreenATView.this.a(j);
                BaseScreenATView.this.b(j);
                if (!BaseScreenATView.this.ab) {
                    BaseScreenATView.this.e(0);
                    BaseScreenATView.this.d(0);
                    BaseScreenATView.this.ab = true;
                }
                if (BaseScreenATView.this.C >= 0 && j >= BaseScreenATView.this.C) {
                    BaseScreenATView.this.T();
                }
                if (BaseScreenATView.this.r() == 100 || j < BaseScreenATView.this.H) {
                    return;
                }
                BaseScreenATView.this.ad();
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void c() {
                if (BaseScreenATView.this.W != null) {
                    BaseScreenATView.this.W.b();
                }
                if (BaseScreenATView.this.r() != 100) {
                    BaseScreenATView.this.ad();
                }
                if (BaseScreenATView.this.f.o.R() == 1) {
                    BaseScreenATView.this.p = true;
                    if (!BaseScreenATView.this.I) {
                        BaseScreenATView.this.x();
                        return;
                    } else {
                        BaseScreenATView.this.ab();
                        return;
                    }
                }
                if (BaseScreenATView.this.X() != null && BaseScreenATView.this.u != null) {
                    BaseScreenATView.this.u.a(BaseScreenATView.this.X());
                }
                BaseScreenATView.this.c(2);
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void a(f fVar) {
                BaseScreenATView.this.p = true;
                if (BaseScreenATView.this.W != null) {
                    BaseScreenATView.this.W.h();
                }
                BaseScreenATView.this.a(fVar);
                if (BaseScreenATView.this.r() != 100 && BaseScreenATView.this.f.o.p() == 1) {
                    BaseScreenATView.this.ad();
                }
                BaseScreenATView.this.W();
                if (!BaseScreenATView.this.I) {
                    BaseScreenATView.this.x();
                } else {
                    BaseScreenATView.this.ab();
                }
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void b(int i) {
                if (BaseScreenATView.this.r != null) {
                    BaseScreenATView baseScreenATView = BaseScreenATView.this;
                    BaseScreenATView.a(baseScreenATView, baseScreenATView.r.i());
                }
                if ((BaseScreenATView.this.f.o == null || BaseScreenATView.this.f.o.E() != 1) && !BaseScreenATView.this.Y()) {
                    return;
                }
                BaseScreenATView.this.a(i, 3);
            }

            @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
            public final void b(long j) {
                BaseScreenATView.this.G = j;
                if (BaseScreenATView.this.W != null) {
                    BaseScreenATView.this.W.g();
                }
                BaseScreenATView.this.c(j);
            }
        });
        this.W.f();
        if (t()) {
            this.r.a(this.K, list, this.z);
        }
        if (this.F == 1) {
            x();
        } else {
            this.r.c(0);
        }
    }

    protected void w() {
        a(new ArrayList());
    }

    private void ai() {
        if (this.F == 100) {
            a((List<Bitmap>) null);
        } else {
            com.anythink.core.common.v.b.b.a().b(new AnonymousClass7(new AnonymousClass12()), 2);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseScreenATView$12, reason: invalid class name */
    final class AnonymousClass12 implements a {
        AnonymousClass12() {
        }

        @Override // com.anythink.basead.ui.BaseScreenATView.a
        public final void a(List<Bitmap> list) {
            if (BaseScreenATView.this.F == 5 && (list == null || list.size() == 0)) {
                BaseScreenATView.this.F = 1;
            }
            if (BaseScreenATView.this.F == 2 && !com.anythink.core.common.v.g.a().b(com.anythink.core.common.a.b.d.i)) {
                BaseScreenATView.this.F = 1;
            }
            BaseScreenATView.this.a(list);
            if (!BaseScreenATView.this.an || BaseScreenATView.this.r == null || BaseScreenATView.this.r.j()) {
                return;
            }
            BaseScreenATView.this.B();
        }
    }

    protected void x() {
        a(102);
        this.I = true;
        if (o()) {
            if (this.O == null) {
                this.O = b(false);
            }
            U();
        } else {
            this.E = y();
            EndCardView endCardView = new EndCardView(getContext(), this.g, this.f);
            endCardView.setSize(this.c, this.d);
            endCardView.init(false, false, new AnonymousClass15());
            this.O = endCardView;
            U();
            endCardView.load();
            if (b(this.E)) {
                Q();
                PanelView panelViewAa = aa();
                if (panelViewAa != null && panelViewAa.getVisibility() == 0) {
                    if (panelViewAa.getCTAButton() != null && panelViewAa.getCTAButton().getVisibility() == 0) {
                        this.o = panelViewAa.getCTAButton();
                    } else {
                        this.o = panelViewAa;
                    }
                }
            }
        }
        V();
        BaseEndCardView baseEndCardView = this.O;
        if (baseEndCardView != null) {
            baseEndCardView.postDelayed(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenATView.13
                @Override // java.lang.Runnable
                public final void run() {
                    BaseScreenATView.this.T();
                }
            }, a(this.f.o));
        }
        com.anythink.basead.b.b.a(6, this.g, l());
    }

    private int a(y yVar) {
        int iL;
        if (this.ap || yVar == null || (iL = (int) (yVar.L() / 100.0f)) == 0) {
            return 0;
        }
        Random random = new Random();
        if (random.nextInt(100) > iL) {
            return 0;
        }
        int iM = yVar.M();
        int iN = yVar.N();
        if (iN <= 0) {
            return 0;
        }
        if (iM == iN) {
            return iM;
        }
        try {
            return random.nextInt(iN - iM) + iM;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private BaseEndCardView b(boolean z) {
        MraidEndCardView mraidEndCardView = new MraidEndCardView(getContext(), this.g, this.f, this.z);
        mraidEndCardView.setEndCardListener(new MraidEndCardView.a() { // from class: com.anythink.basead.ui.BaseScreenATView.14
            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void b() {
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void a(String str) {
                String str2 = BaseScreenATView.TAG;
                BaseScreenATView.this.g.w(str);
                BaseScreenATView.this.a(1, 13);
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void a() {
                if (3 != BaseScreenATView.this.a || com.anythink.basead.b.e.a(BaseScreenATView.this.g, BaseScreenATView.this.f)) {
                    return;
                }
                BaseScreenATView.this.ae();
            }

            @Override // com.anythink.basead.ui.MraidEndCardView.a
            public final void c() {
                if (3 == BaseScreenATView.this.a) {
                    if (BaseScreenATView.this.g.J() == 1 && BaseScreenATView.this.g.L()) {
                        return;
                    }
                    BaseScreenATView.this.a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, com.anythink.basead.d.g.V));
                    BaseScreenATView.this.c(5);
                }
            }
        });
        a(this.M);
        mraidEndCardView.init(z);
        return mraidEndCardView;
    }

    private void aj() {
        if (this.O == null) {
            this.O = b(false);
        }
        U();
        V();
    }

    private void ak() {
        this.E = y();
        EndCardView endCardView = new EndCardView(getContext(), this.g, this.f);
        endCardView.setSize(this.c, this.d);
        endCardView.init(false, false, new AnonymousClass15());
        this.O = endCardView;
        U();
        endCardView.load();
        if (b(this.E)) {
            Q();
            PanelView panelViewAa = aa();
            if (panelViewAa != null && panelViewAa.getVisibility() == 0) {
                if (panelViewAa.getCTAButton() != null && panelViewAa.getCTAButton().getVisibility() == 0) {
                    this.o = panelViewAa.getCTAButton();
                } else {
                    this.o = panelViewAa;
                }
            }
        }
        V();
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseScreenATView$15, reason: invalid class name */
    final class AnonymousClass15 implements BaseEndCardView.a {
        @Override // com.anythink.basead.ui.BaseEndCardView.a
        public final void a() {
        }

        AnonymousClass15() {
        }

        @Override // com.anythink.basead.ui.BaseEndCardView.a
        public final void a(int i) {
            String str = BaseScreenATView.TAG;
            BaseScreenATView baseScreenATView = BaseScreenATView.this;
            baseScreenATView.a(1, baseScreenATView.p ? 7 : 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z() {
        D();
        if (this.ar == null) {
            this.ar = new e();
        }
        this.ar.a(getContext(), this.g, this.f, new e.a() { // from class: com.anythink.basead.ui.BaseScreenATView.16
            @Override // com.anythink.basead.e.a
            public final void a() {
            }

            @Override // com.anythink.basead.e.a
            public final void b() {
                BaseScreenATView.this.a(122);
                BaseScreenATView.this.A();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, int i2) {
        this.L = a((b) X(), true);
        if (this.ao || this.g == null) {
            return;
        }
        if (i == -100) {
            M();
        } else {
            super.a(i, i2);
        }
    }

    private void al() {
        if (this.P == null) {
            this.P = new c(this.M);
        }
        this.P.b();
    }

    private void am() {
        c cVar = this.P;
        if (cVar != null) {
            cVar.c();
        }
    }

    private void an() {
        i iVar = this.W;
        if (iVar != null) {
            iVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(f fVar) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.a(fVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void f() {
        int i;
        if (this.W != null) {
            int i2 = this.F;
            if (i2 != 1) {
                i = 3;
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = 5;
                        if (i2 != 4) {
                            if (i2 != 5) {
                                i = i2 != 101 ? 1 : 7;
                            } else {
                                i = 6;
                            }
                        }
                    } else {
                        i = 4;
                    }
                }
            } else {
                i = this.f.o.ao() == 1 ? 2 : 8;
            }
            com.anythink.basead.g.j jVar = new com.anythink.basead.g.j();
            jVar.c = i;
            if ((this instanceof LetterFullScreenATView) || (this instanceof LetterHalfScreenATView)) {
                jVar.d = 1;
            } else {
                jVar.d = 2;
            }
            if (this instanceof FullScreenATView) {
                jVar.f = false;
            } else {
                jVar.f = true;
            }
            jVar.g = this.f.o.bj();
            this.W.a(jVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(com.anythink.basead.g.j jVar) {
        this.aq = true;
        i iVar = this.W;
        if (iVar != null) {
            iVar.b(jVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void a(boolean z) {
        i iVar = this.W;
        if (iVar != null) {
            iVar.a(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void g() {
        this.ao = true;
        if (this.P == null) {
            this.P = new c(this.M);
        }
        this.P.b();
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void h() {
        this.ao = false;
        t.b().b(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenATView.2
            @Override // java.lang.Runnable
            public final void run() {
                BaseScreenATView.d(BaseScreenATView.this);
            }
        });
        if (this.aq && this.a == 3 && this.f != null && this.f.o != null && this.f.o.aE()) {
            if (this.r != null) {
                this.r.c();
            }
            c(6);
        }
    }

    protected final void A() {
        this.an = true;
        try {
            e eVar = this.ar;
            if (eVar == null || !eVar.a()) {
                a(110);
                B();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected final void B() {
        if (this.r != null) {
            this.r.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C() {
        if (this.r != null) {
            this.r.a(true);
        }
    }

    protected final void D() {
        a(111);
        this.an = false;
        ao();
    }

    private void ao() {
        if (this.r != null) {
            this.r.e();
        }
    }

    protected final void E() {
        if (this.r != null) {
            this.r.b(false);
        }
    }

    protected void a(long j) {
        long j2 = this.aj;
        if (j2 >= 0 && j > j2) {
            R();
        } else if (this.D) {
            long j3 = this.ah;
            if (j3 >= 0 && j >= j3) {
                Q();
            }
        }
        if (j > this.am) {
            ar();
        } else if (j >= this.ak) {
            ac();
        }
    }

    private void d(long j) {
        if (this.D && this.ah == -1) {
            long j2 = this.ai;
            if (j2 != 0) {
                this.ah = j;
                if (j2 > 0) {
                    this.aj = j + j2;
                }
                Q();
            }
        }
    }

    protected void F() {
        destroy();
        t.b().d(this.ac);
        ValueAnimator valueAnimator = this.at;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        this.W = null;
        BaseEndCardView baseEndCardView = this.O;
        if (baseEndCardView != null) {
            baseEndCardView.a();
        }
        if (this.r != null) {
            this.r.p();
        }
    }

    protected void G() {
        String strB = this.g.B();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (this.g.ab() > 0 || this.g.ac() > 0) {
            this.af = this.g.ab();
            int iAc = this.g.ac();
            this.ag = iAc;
            this.ad = this.af;
            this.ae = iAc;
            return;
        }
        com.anythink.basead.b.f.a();
        int[] iArrA = h.a(com.anythink.basead.b.f.a(1, strB));
        if (iArrA != null) {
            int i = iArrA[0];
            this.af = i;
            int i2 = iArrA[1];
            this.ag = i2;
            this.ad = i;
            this.ae = i2;
        }
    }

    protected void H() {
        PanelView panelView = this.N;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.N.init(this.g, this.f, this.b, n(), new PanelView.a() { // from class: com.anythink.basead.ui.BaseScreenATView.3
                @Override // com.anythink.basead.ui.PanelView.a
                public final void a(int i, int i2) {
                    BaseScreenATView.this.a(i, i2);
                }

                @Override // com.anythink.basead.ui.PanelView.a
                public final boolean a() {
                    if (!BaseScreenATView.this.J()) {
                        return false;
                    }
                    BaseScreenATView.this.a(4, 5);
                    return true;
                }
            });
        }
    }

    protected final boolean J() {
        if (!com.anythink.basead.ui.f.b.a(this.w, this.f)) {
            return false;
        }
        e eVar = this.ar;
        return (eVar == null || !eVar.a()) && this.an && !this.aa;
    }

    private void ap() {
        e(4);
    }

    protected void K() {
        MuteImageView muteImageView = this.S;
        if (muteImageView == null) {
            return;
        }
        if (this.K) {
            muteImageView.setMute(true);
        } else {
            muteImageView.setMute(false);
        }
        d(4);
        this.S.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenATView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseScreenATView.this.r == null || BaseScreenATView.this.S == null) {
                    return;
                }
                if (!BaseScreenATView.this.r.f()) {
                    BaseScreenATView.this.K = true;
                    BaseScreenATView.this.S.setMute(true);
                    BaseScreenATView.this.r.c(true);
                } else {
                    BaseScreenATView.this.K = false;
                    BaseScreenATView.this.S.setMute(false);
                    BaseScreenATView.this.r.c(false);
                }
            }
        });
    }

    protected void L() {
        if (X() != null) {
            this.L = a((b) X(), false);
            X().setVisibility(8);
            X().setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenATView.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseScreenATView.this.M();
                }
            });
        }
    }

    protected final void N() {
        if (this.r != null) {
            this.r.c();
        }
    }

    protected void c(int i) {
        j jVarL = l();
        jVarL.i = m();
        com.anythink.basead.b.b.a(7, this.g, jVarL);
        if (this.W != null) {
            com.anythink.core.common.u.e.a(this.g, this.f, this.y, this.x);
            this.W.a(i);
            this.W.d();
        }
    }

    protected void O() {
        if (Z() != null) {
            Z().setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseScreenATView.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseScreenATView.this.z();
                }
            });
        }
    }

    protected void P() {
        e(0);
        d(0);
    }

    protected final void d(int i) {
        MuteImageView muteImageView = this.S;
        if (muteImageView == null || muteImageView.getVisibility() == i) {
            return;
        }
        this.S.setVisibility(i);
    }

    protected void Q() {
        PanelView panelViewAa = aa();
        if (panelViewAa != null) {
            if (panelViewAa.getVisibility() != 0) {
                a(104);
                panelViewAa.setVisibility(0);
            }
            if (panelViewAa.getCTAButton() == null || panelViewAa.getCTAButton().getVisibility() != 0) {
                return;
            }
            if (this.q == null || !this.q.equals(panelViewAa.getCTAButton())) {
                if (this.q != null && (panelViewAa.getCTAButton() instanceof CTAButtonLayout) && (this.q instanceof CTAButtonLayout)) {
                    String majorCTAText = ((CTAButtonLayout) this.q).getMajorCTAText();
                    if (!TextUtils.isEmpty(majorCTAText)) {
                        ((CTAButtonLayout) panelViewAa.getCTAButton()).setMajorCTAText(majorCTAText);
                    }
                }
                this.q = panelViewAa.getCTAButton();
            }
        }
    }

    protected void R() {
        if (aa() == null || aa().getVisibility() == 8) {
            return;
        }
        aa().setVisibility(8);
    }

    protected final void S() {
        if (Z() == null || Z().getVisibility() == 0) {
            return;
        }
        Z().setVisibility(0);
    }

    protected void T() {
        S();
        this.ap = true;
        if (this.q != null && (this.q instanceof CTAButtonLayout) && ((CTAButtonLayout) this.q).needInterceptCloseViewShow()) {
            ((CTAButtonLayout) this.q).activateSubCloseButton();
            boolean z = this.I;
            if (!z) {
                return;
            }
            if (z && aa() != null && aa().getVisibility() == 0) {
                return;
            }
        }
        if (X() == null || X().getVisibility() == 0) {
            return;
        }
        X().setVisibility(0);
        com.anythink.basead.ui.f.b.a(X(), this.L, this.l ? 1.0d : (this.f == null || this.f.o == null) ? 1.0d : this.f.o.bw());
    }

    protected void V() {
        a(103);
        if (this.r != null && this.r.a() && (!p() || this.p)) {
            ab();
        }
        e(8);
        if (X() != null) {
            com.anythink.basead.ui.f.b.a(X(), this.L, this.l ? 1.0d : (this.f == null || this.f.o == null) ? 1.0d : this.f.o.bw());
        }
        d(8);
        ar();
    }

    protected void e(int i) {
        com.anythink.basead.ui.component.b bVar = this.V;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(long j) {
        com.anythink.basead.ui.component.b bVar = this.V;
        if (bVar != null) {
            bVar.b(j);
        }
    }

    protected final void W() {
        com.anythink.basead.ui.component.b bVar = this.V;
        if (bVar != null) {
            bVar.a();
        }
    }

    protected void c(long j) {
        com.anythink.basead.ui.component.b bVar = this.V;
        if (bVar != null) {
            bVar.a(j);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected RelativeLayout.LayoutParams q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.b == 2) {
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

    @Override // com.anythink.basead.ui.BaseATView
    protected final boolean p() {
        return com.anythink.basead.b.e.a(this.g, this.f);
    }

    protected CloseImageView X() {
        return this.Q;
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.BaseScreenATView$7, reason: invalid class name */
    final class AnonymousClass7 implements Runnable {
        final /* synthetic */ a a;

        AnonymousClass7(a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(BaseScreenATView.this.getContext()).b(t.b().p());
            List<String> arrayList = new ArrayList<>();
            final ArrayList arrayList2 = new ArrayList();
            int i = BaseScreenATView.this.F;
            int iMin = 0;
            if (i == 2) {
                arrayList = bVarB.o();
            } else if (i == 3) {
                arrayList = bVarB.q();
            } else if (i == 5) {
                arrayList = bVarB.p();
                boolean z = arrayList.size() >= 4;
                if (z) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        String str = arrayList.get(i2);
                        if (TextUtils.isEmpty(str) || !com.anythink.basead.b.c.d.b(str, 3)) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    arrayList.clear();
                }
            }
            if (arrayList.size() == 0) {
                t.b().b(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenATView.7.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (AnonymousClass7.this.a != null) {
                            AnonymousClass7.this.a.a(arrayList2);
                        }
                    }
                });
                return;
            }
            if (arrayList != null && arrayList.size() > 0) {
                try {
                    iMin = Math.min(BaseScreenATView.this.getResources().getDisplayMetrics().widthPixels, BaseScreenATView.this.getResources().getDisplayMetrics().heightPixels) / 2;
                } catch (Throwable unused) {
                }
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    Bitmap bitmapB = com.anythink.core.common.res.b.a(BaseScreenATView.this.getContext()).b(new com.anythink.core.common.res.e(3, it.next()), iMin, iMin);
                    if (bitmapB != null) {
                        arrayList2.add(bitmapB);
                    }
                }
                if (arrayList2.size() != arrayList.size()) {
                    arrayList2.clear();
                }
            }
            t.b().b(new Runnable() { // from class: com.anythink.basead.ui.BaseScreenATView.7.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (AnonymousClass7.this.a != null) {
                        AnonymousClass7.this.a.a(arrayList2);
                    }
                }
            });
        }
    }

    private void a(a aVar) {
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass7(aVar), 2);
    }

    protected final boolean Y() {
        return this.a == 1 && this.F == 101 && this.r != null && this.r.g();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!Y() || this.r == null) {
            return;
        }
        this.r.a(i, i2, intent);
    }

    protected ViewGroup Z() {
        return this.R;
    }

    protected PanelView aa() {
        return this.N;
    }

    private void aq() {
        if (this.r == null || !this.r.a()) {
            return;
        }
        if (!p() || this.p) {
            ab();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ab() {
        if (this.r != null) {
            this.r.b();
        }
    }

    public int getPlayerViewType() {
        return this.F;
    }

    private void ar() {
        View view = this.T;
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        this.T.setVisibility(8);
    }

    protected void ac() {
        View view = this.T;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        ValueAnimator valueAnimator = this.at;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
        this.at = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.at.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.BaseScreenATView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                if (BaseScreenATView.this.T != null) {
                    BaseScreenATView.this.T.setAlpha(fFloatValue);
                }
            }
        });
        this.at.start();
        this.T.setAlpha(0.2f);
        this.T.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ad() {
        i iVar;
        if (1 == this.a) {
            T();
            if (this.J) {
                return;
            }
            this.J = true;
            if (this.k || (iVar = this.W) == null) {
                return;
            }
            iVar.c();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected final void u() {
        super.u();
        a(com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, com.anythink.basead.d.g.ag));
        if (p()) {
            if (this.s != null) {
                HashMap map = new HashMap();
                map.put(g.a.i, com.anythink.basead.d.g.a(com.anythink.basead.d.g.k, com.anythink.basead.d.g.ag).c());
                this.s.a(map);
            }
            a(108);
            this.p = true;
            if (!this.I) {
                x();
            }
            ao();
            ab();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    protected void e() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.c = displayMetrics.widthPixels;
        int i = displayMetrics.heightPixels;
        this.d = i;
        this.ad = this.c;
        this.ae = i;
        G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ae() {
        super.j();
    }

    static /* synthetic */ void b(BaseScreenATView baseScreenATView) {
        i iVar = baseScreenATView.W;
        if (iVar != null) {
            iVar.a();
        }
    }

    static /* synthetic */ void a(BaseScreenATView baseScreenATView, long j) {
        if (baseScreenATView.D && baseScreenATView.ah == -1) {
            long j2 = baseScreenATView.ai;
            if (j2 != 0) {
                baseScreenATView.ah = j;
                if (j2 > 0) {
                    baseScreenATView.aj = j + j2;
                }
                baseScreenATView.Q();
            }
        }
    }

    static /* synthetic */ void d(BaseScreenATView baseScreenATView) {
        c cVar = baseScreenATView.P;
        if (cVar != null) {
            cVar.c();
        }
    }
}
