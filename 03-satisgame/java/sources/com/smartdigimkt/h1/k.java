package com.smartdigimkt.h1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.smartdigimkt.j1.t;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.n1.i3;
import com.smartdigimkt.sdk.basead.ui.OwnNativeATView;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.a0;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends p implements com.smartdigimkt.p3.d {
    public boolean A;
    public final b B;
    public final c C;
    public boolean D;
    public volatile boolean o;
    public volatile boolean p;
    public OwnNativeATView q;
    public WeakReference r;
    public i3 s;
    public final e t;
    public a0 u;
    public i v;
    public final com.smartdigimkt.i2.m w;
    public com.smartdigimkt.p3.i x;
    public final HashMap y;
    public g z;

    public k(Context context, com.smartdigimkt.b3.l lVar, com.smartdigimkt.a3.a aVar, boolean z) {
        super(context, lVar, aVar, z);
        this.o = false;
        this.p = false;
        this.y = new HashMap();
        this.A = false;
        this.B = new b(this);
        this.C = new c(this);
        this.w = new com.smartdigimkt.i2.m();
        this.t = new e(this);
    }

    public final void a(View view, boolean z) {
        WeakReference weakReference = this.r;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null && view == view2) {
            a(view, 1, 1, z);
        } else if (g() == null || !g().contains(view)) {
            a(view, 1, 2, z);
        } else {
            a(view, 1, 3, z);
        }
    }

    public void d() {
    }

    public void e() {
        com.smartdigimkt.p3.e eVar = this.c.a;
        if (eVar != null) {
            eVar.c();
        }
        if (this.f) {
            return;
        }
        com.smartdigimkt.p3.i iVar = this.x;
        if (iVar != null) {
            iVar.a();
            this.x = null;
        }
        a0 a0Var = this.u;
        if (a0Var != null) {
            a0Var.a();
            this.u = null;
        }
        if (!this.f) {
            this.f = true;
            com.smartdigimkt.j1.a aVar = this.e;
            if (aVar instanceof t) {
                t tVar = (t) aVar;
                tVar.h = true;
                tVar.g = null;
            }
            this.e = null;
        }
        a(112);
        i iVar2 = this.v;
        if (iVar2 != null) {
            HashMap map = iVar2.f;
            if (map != null) {
                map.clear();
            }
            this.v = null;
        }
        HashMap map2 = this.y;
        if (map2 != null) {
            map2.clear();
        }
        OwnNativeATView ownNativeATView = this.q;
        if (ownNativeATView != null) {
            ownNativeATView.releaseAllCallback();
        }
        this.q = null;
        this.r = null;
        if (this.z != null) {
            com.smartdigimkt.x.c.a().removeDataFetchListener(this.z);
        }
        i3 i3Var = this.s;
        if (i3Var != null) {
            i3Var.destroyPlayerView(3);
        }
    }

    public abstract View f();

    public List g() {
        return null;
    }

    public void h() {
        com.smartdigimkt.j1.a aVar;
        com.smartdigimkt.p3.e eVar = this.c.a;
        if (eVar == null || !eVar.a(this.D) || this.o) {
            return;
        }
        this.o = true;
        com.smartdigimkt.b3.l lVar = this.b;
        if (lVar != null && lVar.j()) {
            com.smartdigimkt.n3.k.b(3, this.c, this.b);
            this.p = true;
            return;
        }
        if (this.q != null) {
            com.smartdigimkt.h0.m mVarA = a();
            if (this.c.a == null) {
                s.a(8, this.b, mVarA);
            }
            if (!this.f && (aVar = this.e) != null) {
                w wVar = new w();
                wVar.e = this.c.s.F0;
                aVar.onAdShow(wVar);
            }
        }
        a(114);
        com.smartdigimkt.b3.l lVar2 = this.b;
        if (lVar2 == null || !lVar2.i()) {
            return;
        }
        this.z = new g(this, lVar2);
        com.smartdigimkt.x.c.a().addDataFetchListener(this.z);
    }

    @Override // com.smartdigimkt.p3.d
    public final int impressionMaterialType() {
        return c0.a(this.b, this.c);
    }

    @Override // com.smartdigimkt.p3.d
    public final void onImpressionExpired() {
        if (this.p) {
            return;
        }
        this.p = true;
        this.o = true;
        com.smartdigimkt.n3.k.b(3, this.c, this.b);
    }

    @Override // com.smartdigimkt.p3.d
    public final void sendMediaImpression() {
        h();
    }

    @Override // com.smartdigimkt.p3.d
    public final void sendUpstreamImpression() {
        s.a(8, this.b, a());
    }

    public final void a(View view, int i, int i2, boolean z) {
        if (this.f || this.q == null) {
            return;
        }
        this.D = true;
        try {
            h();
            this.D = false;
            if (this.u == null) {
                this.u = new a0(SDKContext.getInstance().d(), this.c, this.b, this.q);
            }
            com.smartdigimkt.a0.e eVar = this.u.g;
            if (eVar == null || !eVar.e.get()) {
                if (this.b.i() && ((i2 == 1 || i2 == 6) && this.b.D == 4 && this.c.s.H0)) {
                    com.smartdigimkt.x.c.a().pause(this.b);
                    return;
                }
                a0 a0Var = this.u;
                d dVar = new d(this, i, i2);
                com.smartdigimkt.a0.e eVar2 = a0Var.g;
                if (eVar2 != null) {
                    eVar2.a = dVar;
                }
                com.smartdigimkt.h0.m mVarA = a();
                if (i == 1) {
                    OwnNativeATView ownNativeATView = this.q;
                    mVarA.g = ownNativeATView != null ? ownNativeATView.getAdClickRecord(i2) : null;
                } else {
                    com.smartdigimkt.i2.m mVar = this.w;
                    mVarA.g = mVar != null ? mVar.a(view, view, i, i2, 3) : null;
                }
                if (z) {
                    mVarA.k = true;
                }
                this.u.a(mVarA);
                if (this.v != null) {
                    HashMap map = new HashMap();
                    map.put("click_type", Integer.valueOf(i));
                    map.put("click_area", Integer.valueOf(i2));
                    this.v.a(map);
                }
                a(113);
            }
        } catch (Throwable th) {
            this.D = false;
            throw th;
        }
    }

    public void a(View view, List list, List list2, FrameLayout.LayoutParams layoutParams, View view2) {
        com.smartdigimkt.b3.l lVar;
        com.smartdigimkt.a3.a aVar;
        i3 i3Var;
        View.OnClickListener onClickListener;
        com.smartdigimkt.b3.e eVar;
        if (this.q == null || view == null || this.A) {
            return;
        }
        int iA = 1;
        this.A = true;
        if (!this.o && this.x == null) {
            f fVar = new f(this);
            com.smartdigimkt.b3.l lVar2 = this.b;
            if (lVar2 != null && (eVar = lVar2.w) != null) {
                iA = eVar.a();
            }
            view.getContext();
            com.smartdigimkt.p3.i iVar = new com.smartdigimkt.p3.i(iA, 0);
            this.x = iVar;
            iVar.a(view, fVar);
        }
        if (this.b != null) {
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    View view3 = (View) it.next();
                    if (view3 != null) {
                        view3.setOnClickListener(this.B);
                    }
                }
            } else {
                a(view, this.B);
            }
            if (list2 != null && list2.size() > 0) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    View view4 = (View) it2.next();
                    if (view4 != null) {
                        view4.setOnClickListener(this.C);
                    }
                }
            }
        }
        if (!this.d && (i3Var = this.s) != null) {
            if (list2 != null && list2.contains(i3Var)) {
                onClickListener = this.C;
            } else {
                onClickListener = (list == null || list.isEmpty() || list.contains(this.s)) ? this.B : null;
            }
            this.s.setPlayerOnClickListener(onClickListener);
        }
        OwnNativeATView ownNativeATView = this.q;
        if (ownNativeATView != null && (lVar = this.b) != null && (aVar = this.c) != null) {
            this.v = new i(this, ownNativeATView, lVar, aVar, this.d ? 5 : 6, new h(this));
            this.y.put("native_ad_event_listener", this.e);
            this.v.a(this.y);
            this.q.setLifeCallback(new j(this));
            i3 i3Var2 = this.s;
            if (i3Var2 != null) {
                i3Var2.setATImproveClickViewController(this.v);
            }
            if (this.o) {
                a(114);
            }
        }
        f();
    }

    public final void a(int i) {
        i iVar = this.v;
        if (iVar != null) {
            iVar.a(i);
        }
    }

    public static void a(View view, b bVar) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), bVar);
            }
            return;
        }
        view.setOnClickListener(bVar);
    }
}
