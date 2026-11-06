package com.anythink.basead.f.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.anythink.basead.g.j;
import com.anythink.basead.ui.OwnNativeATView;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.basead.ui.improveclick.i;
import com.anythink.core.api.IExHandlerBaseAd;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.bi;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends d {
    private boolean E;
    volatile boolean a;
    volatile boolean b;
    OwnNativeATView c;
    WeakReference<View> d;
    com.anythink.basead.ui.a e;
    com.anythink.basead.ui.component.a.InterfaceC0058a f;
    com.anythink.basead.b.c g;
    com.anythink.basead.ui.improveclick.a h;
    com.anythink.basead.ui.f.c i;
    com.anythink.core.common.v.a.c j;
    com.anythink.core.common.v.a.c k;
    HashMap<String, Object> l;
    com.anythink.basead.j.e m;
    View.OnClickListener n;
    View.OnClickListener o;
    private final String p;
    private IExHandlerBaseAd.DataFetchListener q;

    protected List<View> J() {
        return null;
    }

    void K() {
    }

    abstract View L();

    final void a(View view, boolean z) {
        WeakReference<View> weakReference = this.d;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null && view == view2) {
            a(view, 1, 1, z);
        } else if (J() != null && J().contains(view)) {
            a(view, 1, 3, z);
        } else {
            a(view, 1, 2, z);
        }
    }

    final void a(View view, int i, int i2) {
        a(view, i, i2, false);
    }

    private void a(View view, final int i, final int i2, boolean z) {
        if (this.c != null) {
            I();
            if (this.g == null) {
                this.g = new com.anythink.basead.b.c(t.b().g(), this.t, this.s, this.c);
            }
            if (this.g.a()) {
                return;
            }
            if (this.s.ae() && ((i2 == 1 || i2 == 6) && this.s.aa() == 4 && this.t.o.aM())) {
                com.anythink.basead.b.a().pause(this.s);
                return;
            }
            this.g.a(new com.anythink.basead.b.c.a() { // from class: com.anythink.basead.f.b.a.a.5
                @Override // com.anythink.basead.b.c.a
                public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
                    return false;
                }

                @Override // com.anythink.basead.b.c.a
                public final void a() {
                    if (a.this.b) {
                        return;
                    }
                    if (a.this.s != null && a.this.s.ax()) {
                        if (a.this.s.r() != null && a.this.s.r().bK() == 2) {
                            com.anythink.core.common.u.e.c(a.this.s, a.this.t, 2);
                        } else {
                            com.anythink.core.common.u.e.c(a.this.s, a.this.t, 1);
                            return;
                        }
                    }
                    if (a.this.v != null) {
                        com.anythink.basead.g.a aVar = a.this.v;
                        j jVarA = new j().a(i, i2);
                        jVarA.e = a.this.t.o.bg();
                        aVar.onAdClick(jVarA);
                    }
                }

                @Override // com.anythink.basead.b.c.a
                public final void b() {
                    a.this.K();
                }

                @Override // com.anythink.basead.b.c.a
                public final void c() {
                    i.a().b();
                }

                @Override // com.anythink.basead.b.c.a
                public final void a(boolean z2) {
                    if (a.this.b) {
                        return;
                    }
                    if ((a.this.s == null || !a.this.s.ax() || a.this.s.r() == null || a.this.s.r().bK() == 2) && a.this.v != null) {
                        a.this.v.onDeeplinkCallback(z2);
                    }
                }
            });
            com.anythink.basead.d.j jVarM = M();
            if (i == 1) {
                OwnNativeATView ownNativeATView = this.c;
                jVarM.i = ownNativeATView != null ? ownNativeATView.getAdClickRecord() : null;
            } else {
                com.anythink.basead.ui.f.c cVar = this.i;
                jVarM.i = cVar != null ? cVar.a(view, i, i2) : null;
            }
            if (z) {
                jVarM.m = true;
            }
            this.g.a(jVarM);
            if (this.h != null) {
                HashMap map = new HashMap();
                map.put("click_type", Integer.valueOf(i));
                map.put(g.a.g, Integer.valueOf(i2));
                this.h.a(map);
            }
            a(113);
        }
    }

    public a(Context context, bj bjVar, x xVar, boolean z) {
        super(context, bjVar, xVar, z);
        this.p = "a";
        this.a = false;
        this.b = false;
        this.l = new HashMap<>();
        this.E = false;
        this.n = new View.OnClickListener() { // from class: com.anythink.basead.f.b.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.a(view, false);
            }
        };
        this.o = new View.OnClickListener() { // from class: com.anythink.basead.f.b.a.a.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.a(view, true);
            }
        };
        this.i = new com.anythink.basead.ui.f.c(this.s);
        this.f = new com.anythink.basead.ui.component.a.InterfaceC0058a() { // from class: com.anythink.basead.f.b.a.a.6
            @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
            public final com.anythink.basead.d.j a() {
                return a.this.M();
            }

            @Override // com.anythink.basead.ui.component.a.InterfaceC0058a
            public final com.anythink.basead.d.a b() {
                if (a.this.c != null) {
                    return a.this.c.getAdClickRecord();
                }
                return null;
            }
        };
        this.m = new com.anythink.basead.j.e(bjVar, xVar);
    }

    protected final OwnNativeATView G() {
        OwnNativeATView ownNativeATView = this.c;
        if (ownNativeATView != null) {
            ownNativeATView.releaseAllCallback();
            com.anythink.basead.j.e eVar = this.m;
            if (eVar != null) {
                eVar.b();
                this.m = null;
            }
        }
        OwnNativeATView ownNativeATView2 = new OwnNativeATView(this.r);
        ownNativeATView2.setClickRecordHelper(this.i);
        this.E = false;
        return ownNativeATView2;
    }

    @Override // com.anythink.basead.f.a
    public void a(View view, List<View> list, List<View> list2, FrameLayout.LayoutParams layoutParams, View view2) {
        if (this.c == null || this.E) {
            return;
        }
        int iBL = 1;
        this.E = true;
        com.anythink.basead.j.e eVar = this.m;
        if (eVar != null && view2 != null) {
            eVar.a(view2);
        }
        if (!this.a && this.k == null) {
            com.anythink.core.common.v.a.a aVar = new com.anythink.core.common.v.a.a() { // from class: com.anythink.basead.f.b.a.a.7
                @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                public final int getImpressionMinPercentageViewed() {
                    return 25;
                }

                @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
                public final void recordImpression(View view3) {
                    if (a.this.D == 0) {
                        a.this.D = System.currentTimeMillis();
                    }
                    a.this.a(201);
                }
            };
            if (this.s != null && this.s.r() != null) {
                iBL = this.s.r().bL();
            }
            view.getContext();
            com.anythink.core.common.v.a.c cVar = new com.anythink.core.common.v.a.c(iBL, 0);
            this.k = cVar;
            cVar.a(view, aVar);
        }
        if (this.s != null && !this.s.n()) {
            a(view);
            if (list != null && list.size() > 0) {
                for (View view3 : list) {
                    if (view3 != null) {
                        view3.setOnClickListener(this.n);
                    }
                }
            } else {
                a(view, this.n);
            }
            if (list2 != null && list2.size() > 0) {
                for (View view4 : list2) {
                    if (view4 != null) {
                        view4.setOnClickListener(this.o);
                    }
                }
            }
        }
        if (this.c != null && this.s != null && this.t != null) {
            this.h = new AnonymousClass10(this.c, this.s, this.t, this.u ? 5 : 6, new AnonymousClass9());
            this.l.put(g.a.c, this.v);
            this.h.a(this.l);
            this.c.setLifeCallback(new AnonymousClass11());
            com.anythink.basead.ui.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.setATImproveClickViewController(this.h);
            }
            if (this.a) {
                a(114);
            }
        }
        L();
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void q() {
        super.q();
        com.anythink.core.common.v.a.c cVar = this.j;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.anythink.basead.f.b.a.d
    protected View H() {
        return this.c;
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.b.a.a$8, reason: invalid class name */
    final class AnonymousClass8 extends com.anythink.basead.b.a {
        AnonymousClass8(w wVar) {
            super(wVar);
        }

        @Override // com.anythink.core.api.IExHandlerBaseAd.DataFetchListener
        public final void onStatusChanged(String str) {
            if (a.this.d == null || a.this.d.get() == null) {
                a.this.L();
            }
            View view = a.this.d != null ? a.this.d.get() : null;
            if (view == null || !(view instanceof TextView)) {
                return;
            }
            ((TextView) view).setText(str);
        }
    }

    private void a(bj bjVar) {
        if (bjVar == null || !bjVar.ae()) {
            return;
        }
        this.q = new AnonymousClass8(bjVar);
        com.anythink.basead.b.a().addDataFetchListener(this.q);
    }

    final void a(int i) {
        com.anythink.basead.ui.improveclick.a aVar = this.h;
        if (aVar != null) {
            aVar.a(i);
        }
        com.anythink.basead.j.e eVar = this.m;
        if (eVar != null) {
            eVar.a(i, this.c);
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public void r() {
        super.r();
        a(112);
        OwnNativeATView ownNativeATView = this.c;
        if (ownNativeATView != null) {
            ownNativeATView.releaseAllCallback();
        }
        this.c = null;
        this.d = null;
        com.anythink.basead.j.e eVar = this.m;
        if (eVar != null) {
            eVar.b();
        }
        com.anythink.basead.b.c cVar = this.g;
        if (cVar != null) {
            cVar.d();
            this.g = null;
        }
        if (this.q != null) {
            com.anythink.basead.b.a().removeDataFetchListener(this.q);
        }
        com.anythink.basead.ui.a aVar = this.e;
        if (aVar != null) {
            aVar.destroyPlayerView(3);
        }
        com.anythink.core.common.v.a.c cVar2 = this.j;
        if (cVar2 != null) {
            cVar2.b();
            this.j = null;
        }
        com.anythink.core.common.v.a.c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.b();
            this.k = null;
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void u() {
        super.u();
        com.anythink.basead.ui.a aVar = this.e;
        if (aVar != null) {
            aVar.resumeVideo();
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void v() {
        super.v();
        com.anythink.basead.ui.a aVar = this.e;
        if (aVar != null) {
            aVar.pauseVideo();
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final void b(boolean z) {
        super.b(z);
        com.anythink.basead.ui.a aVar = this.e;
        if (aVar != null) {
            aVar.setIsMuted(z);
        }
    }

    @Override // com.anythink.basead.f.b.a.d, com.anythink.basead.f.a
    public final long C() {
        com.anythink.basead.ui.a aVar = this.e;
        if (aVar != null) {
            return aVar.getVideoCurrentPosition();
        }
        return 0L;
    }

    private void a(View view, View.OnClickListener onClickListener) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), onClickListener);
            }
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    private void N() {
        if (this.c == null || this.s == null || this.t == null) {
            return;
        }
        this.h = new AnonymousClass10(this.c, this.s, this.t, this.u ? 5 : 6, new AnonymousClass9());
        this.l.put(g.a.c, this.v);
        this.h.a(this.l);
        this.c.setLifeCallback(new AnonymousClass11());
        com.anythink.basead.ui.a aVar = this.e;
        if (aVar != null) {
            aVar.setATImproveClickViewController(this.h);
        }
        if (this.a) {
            a(114);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.b.a.a$9, reason: invalid class name */
    final class AnonymousClass9 implements com.anythink.basead.ui.improveclick.c.a {
        AnonymousClass9() {
        }

        @Override // com.anythink.basead.ui.improveclick.c.a
        public final void a(int i, int i2) {
            a aVar = a.this;
            aVar.a(aVar.L(), i, i2);
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.b.a.a$10, reason: invalid class name */
    final class AnonymousClass10 extends com.anythink.basead.ui.improveclick.a {
        AnonymousClass10(ViewGroup viewGroup, w wVar, x xVar, int i, com.anythink.basead.ui.improveclick.c.a aVar) {
            super(viewGroup, wVar, xVar, i, aVar);
        }

        @Override // com.anythink.basead.ui.improveclick.a
        public final ViewGroup.LayoutParams a() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (a.this.c != null) {
                layoutParams.gravity = 81;
                layoutParams.setMargins(0, 0, 0, 0);
            }
            return layoutParams;
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.f.b.a.a$11, reason: invalid class name */
    final class AnonymousClass11 implements OwnNativeATView.a {
        AnonymousClass11() {
        }

        @Override // com.anythink.basead.ui.OwnNativeATView.a
        public final void a() {
            a.this.a(110);
        }

        @Override // com.anythink.basead.ui.OwnNativeATView.a
        public final void b() {
            a.this.a(111);
        }
    }

    final void a(View view) {
        com.anythink.core.common.v.a.a aVar = new com.anythink.core.common.v.a.a() { // from class: com.anythink.basead.f.b.a.a.2
            @Override // com.anythink.core.common.v.a.a, com.anythink.core.common.v.a.b
            public final void recordImpression(View view2) {
                a.this.I();
            }
        };
        if (this.j == null) {
            int iBL = (this.s == null || this.s.r() == null) ? 1 : this.s.r().bL();
            view.getContext();
            this.j = new com.anythink.core.common.v.a.c(iBL, this.t.o.Z() <= 0 ? 100 : this.t.o.Z());
        }
        this.j.a(view, aVar);
    }

    void I() {
        if (this.a) {
            return;
        }
        this.a = true;
        if (this.s != null && this.s.ax()) {
            com.anythink.core.common.u.e.c(this.s, this.t, 3);
            this.b = true;
            return;
        }
        if (this.s instanceof bi) {
            com.anythink.basead.f.f.c.a().a(this.r, com.anythink.basead.f.f.c.a(this.t.b, this.t.c), this.s, this.t.o);
        }
        if (H() != null) {
            com.anythink.basead.b.b.a(8, this.s, M());
            if (this.v != null) {
                com.anythink.basead.g.a aVar = this.v;
                j jVar = new j();
                jVar.e = this.t.o.bg();
                aVar.onAdShow(jVar);
            }
        }
        a(114);
        bj bjVar = this.s;
        if (bjVar == null || !bjVar.ae()) {
            return;
        }
        this.q = new AnonymousClass8(bjVar);
        com.anythink.basead.b.a().addDataFetchListener(this.q);
    }

    final void a(com.anythink.basead.ui.a aVar) {
        this.e = aVar;
        aVar.initPlayerView(this.s, this.t, this.f, this.m);
        this.e.setIsMuted(this.x);
        this.e.setAutoPlay(this.y);
        this.e.setVideoListener(this.w);
        this.e.setPlayerOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.f.b.a.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.n.onClick(view);
            }
        });
    }
}
