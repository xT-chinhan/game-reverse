package com.anythink.basead.ui.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.b.e;
import com.anythink.basead.d.f;
import com.anythink.basead.d.j;
import com.anythink.basead.d.k;
import com.anythink.basead.ui.RoundCornerRelativeLayout;
import com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView;
import com.anythink.basead.ui.animplayerview.BasePlayerView;
import com.anythink.basead.ui.animplayerview.EmptyAnimPlayer;
import com.anythink.basead.ui.animplayerview.GuideToClickAnimPlayerView;
import com.anythink.basead.ui.animplayerview.RedPacketAnimPlayerView;
import com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView;
import com.anythink.basead.ui.animplayerview.WebLandpagePlayerView;
import com.anythink.basead.ui.improveclick.g;
import com.anythink.basead.webtemplet.WTWebContainerView;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.a.n;
import com.anythink.core.common.a.o;
import com.anythink.core.common.h.bj;
import com.anythink.core.common.h.bl;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.b.c;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final String a;
    Context b;
    x c;
    w d;
    int e;
    boolean f;
    com.anythink.basead.ui.improveclick.a g;
    BasePlayerView h;
    BasePlayerView.a i;
    InterfaceC0058a j;
    long k;
    long l;
    BasePlayerView.a m;
    ConcurrentHashMap<Integer, Boolean> n;
    private com.anythink.basead.a.a o;
    private boolean p;
    private View q;
    private WTWebContainerView r;
    private boolean s;

    /* JADX INFO: renamed from: com.anythink.basead.ui.component.a$a, reason: collision with other inner class name */
    public interface InterfaceC0058a {
        j a();

        com.anythink.basead.d.a b();
    }

    public a(View view, x xVar, w wVar) {
        this(view, xVar, wVar, m.f(view.getContext()));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005a  */
    public a(View view, x xVar, w wVar, int i) {
        boolean zA;
        this.a = "a";
        this.s = true;
        Context context = view.getContext();
        this.b = context;
        this.c = xVar;
        this.d = wVar;
        this.e = i;
        this.h = (BasePlayerView) view.findViewById(q.a(context, "myoffer_player_view_id", "id"));
        w wVar2 = this.d;
        x xVar2 = this.c;
        if (xVar2 == null || wVar2 == null) {
            zA = false;
        } else {
            String strValueOf = String.valueOf(xVar2.j);
            strValueOf.hashCode();
            if (strValueOf.equals("1")) {
                if (TextUtils.isEmpty(wVar2.E())) {
                    zA = false;
                } else {
                    zA = true;
                }
            } else if (strValueOf.equals("3")) {
                zA = e.a(wVar2, xVar2);
            } else {
                zA = false;
            }
        }
        this.p = zA;
        View viewFindViewById = view.findViewById(q.a(this.b, "myoffer_player_view_container_id", "id"));
        this.q = viewFindViewById;
        if (viewFindViewById != null && (viewFindViewById instanceof RoundCornerRelativeLayout)) {
            ((RoundCornerRelativeLayout) viewFindViewById).setRadius(0);
        }
        this.s = true;
    }

    public final void a(int i) {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            basePlayerView.setViewType(i);
        }
    }

    public final void a(BasePlayerView.a aVar) {
        this.i = aVar;
    }

    public final void a(InterfaceC0058a interfaceC0058a) {
        this.j = interfaceC0058a;
    }

    public final void a(com.anythink.basead.ui.improveclick.a aVar) {
        this.g = aVar;
    }

    public final void a(WTWebContainerView wTWebContainerView) {
        this.r = wTWebContainerView;
    }

    public final BasePlayerView a(boolean z, List<Bitmap> list, com.anythink.basead.j.e eVar) {
        this.f = z;
        if (this.h != null) {
            BasePlayerView.a aVar = new BasePlayerView.a() { // from class: com.anythink.basead.ui.component.a.1
                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void b() {
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void a() {
                    a.this.b(101);
                    if (a.this.g != null) {
                        a.this.g.a(a.this.h.getVideoLength());
                    }
                    a.this.k = System.currentTimeMillis();
                    a.a(a.this);
                    if (a.this.i != null) {
                        a.this.i.a();
                        a.this.i.a(0L);
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void a(long j) {
                    if (a.this.g != null) {
                        HashMap map = new HashMap();
                        map.put(g.a.k, Long.valueOf(j));
                        a.this.g.a(map);
                    }
                    a.this.b(125);
                    a.a(a.this, j);
                    if (a.this.i != null) {
                        a.this.i.a(j);
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void c() {
                    a.this.b(107);
                    a.b(a.this);
                    if (a.this.i != null) {
                        a.this.i.c();
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void a(f fVar) {
                    fVar.c();
                    if (a.this.g != null) {
                        HashMap map = new HashMap();
                        map.put(g.a.i, fVar.c());
                        a.this.g.a(map);
                    }
                    a.this.b(108);
                    a.c(a.this);
                    if (a.this.i != null) {
                        a.this.i.a(fVar);
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void a(int i) {
                    a.a(a.this, i);
                    if (a.this.i != null) {
                        a.this.i.a(i);
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void b(int i) {
                    a.d(a.this);
                    if (a.this.i != null) {
                        a.this.i.b(i);
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void d() {
                    a.a(a.this, true);
                    if (a.this.i != null) {
                        a.this.i.d();
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void e() {
                    a.a(a.this, false);
                    if (a.this.i != null) {
                        a.this.i.e();
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void b(long j) {
                    if (a.this.g != null) {
                        HashMap map = new HashMap();
                        map.put(g.a.d, Long.valueOf(j));
                        a.this.g.a(map);
                    }
                    a.this.b(123);
                    a.e(a.this);
                    if (a.this.i != null) {
                        a.this.i.b(j);
                    }
                }

                @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
                public final void f() {
                    c.a().c(a.this.d.E());
                    if (a.this.i != null) {
                        a.this.i.f();
                    }
                }
            };
            this.m = aVar;
            this.h.setListener(aVar);
            this.h.init(this.d, this.c, this.f, list, eVar);
        }
        return this.h;
    }

    protected final void b(int i) {
        com.anythink.basead.ui.improveclick.a aVar = this.g;
        if (aVar != null) {
            aVar.a(i);
        }
        if (this.r != null) {
            com.anythink.basead.ui.improveclick.a aVar2 = this.g;
            this.r.notifyInnerAdEvent(i, aVar2 != null ? aVar2.b() : null);
        }
    }

    public final void c(int i) {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            basePlayerView.setVisibility(i);
        }
    }

    public final boolean a() {
        BasePlayerView basePlayerView = this.h;
        return (basePlayerView == null || basePlayerView.getParent() == null || !(this.h.getParent() instanceof ViewGroup)) ? false : true;
    }

    public final void b() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView == null || basePlayerView.getParent() == null) {
            return;
        }
        ((ViewGroup) this.h.getParent()).removeView(this.h);
        this.h = null;
    }

    public final void c() {
        b(124);
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView == null || !basePlayerView.isPlaying()) {
            return;
        }
        this.h.stop();
        this.h.removeAllViews();
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            jVarA.i = this.j.b();
            com.anythink.basead.b.b.a(16, this.d, jVarA);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.s = z;
        }
        d();
    }

    public final void d() {
        BasePlayerView basePlayerView;
        if (this.s && (basePlayerView = this.h) != null && basePlayerView.hasVideo()) {
            if (!this.h.isPlaying()) {
                w();
            }
            this.h.start();
            if (this.f) {
                return;
            }
            y();
        }
    }

    public final void b(boolean z) {
        this.s = z;
        e();
    }

    public final void e() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            if (basePlayerView.isPlaying()) {
                x();
            }
            this.h.pause();
        }
    }

    public final void d(final int i) {
        boolean zJ = j();
        e();
        if (zJ) {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.ui.component.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    long j;
                    long jD;
                    n nVarA;
                    long jI = a.this.i();
                    long jH = a.this.h();
                    if (a.this.d == null || (nVarA = o.a().a(a.this.d.E())) == null) {
                        j = 0;
                        jD = 0;
                    } else {
                        long jE = nVarA.e();
                        jD = nVarA.d();
                        j = jE;
                    }
                    com.anythink.core.common.u.e.a(a.this.c, a.this.d, i, jI, j, jH, jD);
                }
            }, 8);
        }
    }

    public final boolean f() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            return basePlayerView.isMute();
        }
        return false;
    }

    public final void c(boolean z) {
        if (!z) {
            y();
        }
        this.f = z;
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            basePlayerView.setMute(z);
        }
    }

    public final boolean g() {
        BasePlayerView basePlayerView = this.h;
        return basePlayerView != null && (basePlayerView instanceof WebLandpagePlayerView);
    }

    public final void a(int i, int i2, Intent intent) {
        if (g()) {
            ((WebLandpagePlayerView) this.h).onActivityResult(i, i2, intent);
        }
    }

    public final long h() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            return basePlayerView.getVideoLength();
        }
        return 0L;
    }

    public final long i() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            return basePlayerView.getCurrentPosition();
        }
        return 0L;
    }

    public final boolean j() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            return basePlayerView.isPlaying();
        }
        return false;
    }

    public final boolean k() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            return basePlayerView.isPlayCompletion();
        }
        return false;
    }

    public final void e(int i) {
        BasePlayerView emptyAnimPlayer;
        if (this.h != null) {
            Context context = this.b;
            if (i == 1) {
                emptyAnimPlayer = new EmptyAnimPlayer(context);
            } else if (i == 2) {
                emptyAnimPlayer = new GuideToClickAnimPlayerView(context);
            } else if (i == 3) {
                emptyAnimPlayer = new RedPacketAnimPlayerView(context);
            } else if (i == 4) {
                emptyAnimPlayer = new ViewPagerAnimPlayerView(context);
            } else if (i == 5) {
                emptyAnimPlayer = new AlbumScaleAnimPlayerView(context);
            } else if (i == 101) {
                emptyAnimPlayer = new WebLandpagePlayerView(context);
            } else {
                emptyAnimPlayer = new EmptyAnimPlayer(context);
            }
            emptyAnimPlayer.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.h.getParent();
            viewGroup.addView(emptyAnimPlayer, viewGroup.indexOfChild(this.h), this.h.getLayoutParams());
            viewGroup.removeView(this.h);
            this.h = emptyAnimPlayer;
        }
    }

    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView == null || !(basePlayerView instanceof WebLandpagePlayerView)) {
            return false;
        }
        return ((WebLandpagePlayerView) basePlayerView).openInternalWebView(str, iOfferClickHandler);
    }

    public final BasePlayerView l() {
        return this.h;
    }

    public final View m() {
        return this.q;
    }

    public final void n() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            this.j = null;
            this.g = null;
            basePlayerView.setListener(this.m);
            this.h.rePlayVideo();
        }
    }

    private void q() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            com.anythink.basead.b.b.a(1, this.d, interfaceC0058a.a());
        }
    }

    private void a(long j) {
        bl blVarAG;
        Map<Integer, String[]> mapZ;
        w wVar = this.d;
        if (!(wVar instanceof bj) || (blVarAG = ((bj) wVar).aG()) == null || (mapZ = blVarAG.z()) == null || mapZ.size() <= 0) {
            return;
        }
        if (this.n == null) {
            this.n = new ConcurrentHashMap<>();
        }
        long j2 = j / 1000;
        for (Integer num : mapZ.keySet()) {
            if (this.n.get(num) == null || !this.n.get(num).booleanValue()) {
                if (j2 >= num.intValue() && this.j != null) {
                    this.n.put(num, Boolean.TRUE);
                    j jVarA = this.j.a();
                    jVarA.j.i = num.intValue();
                    com.anythink.basead.b.b.a(32, this.d, jVarA);
                }
            }
        }
    }

    private void r() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            com.anythink.basead.b.b.a(5, this.d, jVarA);
            com.anythink.basead.b.b.a(31, this.d, jVarA);
        }
    }

    private void s() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            jVarA.j = d(false);
            com.anythink.basead.b.b.a(17, this.d, jVarA);
        }
    }

    private void g(int i) {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            if (i == 25) {
                com.anythink.basead.b.b.a(2, this.d, jVarA);
            } else if (i == 50) {
                com.anythink.basead.b.b.a(3, this.d, jVarA);
            } else {
                if (i != 75) {
                    return;
                }
                com.anythink.basead.b.b.a(4, this.d, jVarA);
            }
        }
    }

    private void t() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            jVarA.i = this.j.b();
            com.anythink.basead.b.b.a(14, this.d, jVarA);
        }
    }

    private void e(boolean z) {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            if (z) {
                j jVarA = interfaceC0058a.a();
                jVarA.i = this.j.b();
                com.anythink.basead.b.b.a(12, this.d, jVarA);
            } else {
                j jVarA2 = interfaceC0058a.a();
                jVarA2.i = this.j.b();
                com.anythink.basead.b.b.a(13, this.d, jVarA2);
            }
        }
    }

    private void u() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            com.anythink.basead.b.b.a(35, this.d, interfaceC0058a.a());
        }
    }

    private void v() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            jVarA.i = this.j.b();
            com.anythink.basead.b.b.a(16, this.d, jVarA);
        }
    }

    private void w() {
        if (this.j != null) {
            this.k = System.currentTimeMillis();
            long currentPosition = this.h.getCurrentPosition();
            this.l = currentPosition;
            if (currentPosition != 0) {
                com.anythink.basead.b.b.a(15, this.d, this.j.a());
            }
        }
    }

    private void x() {
        InterfaceC0058a interfaceC0058a = this.j;
        if (interfaceC0058a != null) {
            com.anythink.basead.b.b.a(11, this.d, interfaceC0058a.a());
        }
    }

    public final k d(boolean z) {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null && !basePlayerView.hasVideo()) {
            return null;
        }
        k kVar = new k();
        kVar.l = this.e == 2 ? 4 : 1;
        kVar.r = 1;
        BasePlayerView basePlayerView2 = this.h;
        kVar.a = basePlayerView2 != null ? basePlayerView2.getVideoLength() / 1000 : 0L;
        kVar.b = this.l / 1000;
        BasePlayerView basePlayerView3 = this.h;
        kVar.c = basePlayerView3 != null ? basePlayerView3.getCurrentPosition() / 1000 : 0L;
        kVar.d = this.l == 0 ? 1 : 0;
        kVar.o = this.l == 0 ? 1 : 2;
        BasePlayerView basePlayerView4 = this.h;
        kVar.e = (basePlayerView4 == null || basePlayerView4.getCurrentPosition() != this.h.getVideoLength()) ? 0 : 1;
        kVar.u = z ? 0 : 2;
        kVar.f = this.k;
        kVar.g = System.currentTimeMillis();
        BasePlayerView basePlayerView5 = this.h;
        kVar.h = basePlayerView5 != null ? basePlayerView5.getCurrentPosition() : 0L;
        kVar.toString();
        return kVar;
    }

    public final void o() {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            basePlayerView.setNeedInterruptRelease(true);
        }
    }

    public final void f(int i) {
        BasePlayerView basePlayerView = this.h;
        if (basePlayerView != null) {
            basePlayerView.release(i);
        }
    }

    private void y() {
        if (this.p) {
            if (this.o == null) {
                com.anythink.basead.a.a aVar = new com.anythink.basead.a.a();
                this.o = aVar;
                aVar.a(this.b);
            }
            this.o.a();
        }
    }

    private void z() {
        com.anythink.basead.a.a aVar = this.o;
        if (aVar != null) {
            aVar.b();
            this.o = null;
        }
    }

    public final void p() {
        com.anythink.basead.a.a aVar = this.o;
        if (aVar != null) {
            aVar.b();
            this.o = null;
        }
    }

    static /* synthetic */ void a(a aVar) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            com.anythink.basead.b.b.a(1, aVar.d, interfaceC0058a.a());
        }
    }

    static /* synthetic */ void a(a aVar, long j) {
        bl blVarAG;
        Map<Integer, String[]> mapZ;
        w wVar = aVar.d;
        if (!(wVar instanceof bj) || (blVarAG = ((bj) wVar).aG()) == null || (mapZ = blVarAG.z()) == null || mapZ.size() <= 0) {
            return;
        }
        if (aVar.n == null) {
            aVar.n = new ConcurrentHashMap<>();
        }
        long j2 = j / 1000;
        for (Integer num : mapZ.keySet()) {
            if (aVar.n.get(num) == null || !aVar.n.get(num).booleanValue()) {
                if (j2 >= num.intValue() && aVar.j != null) {
                    aVar.n.put(num, Boolean.TRUE);
                    j jVarA = aVar.j.a();
                    jVarA.j.i = num.intValue();
                    com.anythink.basead.b.b.a(32, aVar.d, jVarA);
                }
            }
        }
    }

    static /* synthetic */ void b(a aVar) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            com.anythink.basead.b.b.a(5, aVar.d, jVarA);
            com.anythink.basead.b.b.a(31, aVar.d, jVarA);
        }
    }

    static /* synthetic */ void c(a aVar) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            jVarA.j = aVar.d(false);
            com.anythink.basead.b.b.a(17, aVar.d, jVarA);
        }
    }

    static /* synthetic */ void a(a aVar, int i) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            if (i == 25) {
                com.anythink.basead.b.b.a(2, aVar.d, jVarA);
            } else if (i == 50) {
                com.anythink.basead.b.b.a(3, aVar.d, jVarA);
            } else {
                if (i != 75) {
                    return;
                }
                com.anythink.basead.b.b.a(4, aVar.d, jVarA);
            }
        }
    }

    static /* synthetic */ void d(a aVar) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            j jVarA = interfaceC0058a.a();
            jVarA.i = aVar.j.b();
            com.anythink.basead.b.b.a(14, aVar.d, jVarA);
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            if (z) {
                j jVarA = interfaceC0058a.a();
                jVarA.i = aVar.j.b();
                com.anythink.basead.b.b.a(12, aVar.d, jVarA);
            } else {
                j jVarA2 = interfaceC0058a.a();
                jVarA2.i = aVar.j.b();
                com.anythink.basead.b.b.a(13, aVar.d, jVarA2);
            }
        }
    }

    static /* synthetic */ void e(a aVar) {
        InterfaceC0058a interfaceC0058a = aVar.j;
        if (interfaceC0058a != null) {
            com.anythink.basead.b.b.a(35, aVar.d, interfaceC0058a.a());
        }
    }
}
