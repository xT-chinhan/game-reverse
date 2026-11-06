package com.smartdigimkt.sdk.basead.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b2.k;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.b3.h;
import com.smartdigimkt.b3.l;
import com.smartdigimkt.i1.b;
import com.smartdigimkt.i2.m;
import com.smartdigimkt.j1.w;
import com.smartdigimkt.n1.e0;
import com.smartdigimkt.n1.f0;
import com.smartdigimkt.n1.i0;
import com.smartdigimkt.n1.j0;
import com.smartdigimkt.n1.j3;
import com.smartdigimkt.n1.k0;
import com.smartdigimkt.n1.l0;
import com.smartdigimkt.p3.d;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.h5template.WTWebViewSplashATView;
import com.smartdigimkt.x.j;
import com.smartdigimkt.y1.g0;
import com.smartdigimkt.y1.h0;
import com.smartdigimkt.z.a0;
import com.smartdigimkt.z.c0;
import com.smartdigimkt.z.s;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseATView extends RelativeLayout implements g0, d {
    public static final /* synthetic */ int C = 0;
    public Runnable A;
    public boolean B;
    public final String a;
    public final a b;
    public final c c;
    public a0 d;
    public volatile boolean e;
    public volatile boolean f;
    public boolean g;
    public final String h;
    public boolean i;
    public final ArrayList j;
    public View k;
    public boolean l;
    public View m;
    public com.smartdigimkt.u1.d n;
    public e0 o;
    public h0 p;
    public final com.smartdigimkt.n1.h0 q;
    public final j0 r;
    public final m s;
    public MCView t;
    public long u;
    public final long v;
    public long w;
    public boolean x;
    public boolean y;
    public final i0 z;

    /* JADX WARN: Code duplicated, block: B:32:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a3  */
    public BaseATView(Context context, a aVar, c cVar, String str) {
        a aVar2;
        e eVar;
        super(context);
        this.a = "BaseATView";
        this.e = false;
        this.f = false;
        this.g = false;
        this.l = false;
        this.B = false;
        this.v = System.currentTimeMillis();
        this.b = aVar;
        this.c = cVar;
        this.h = str;
        if (context instanceof BaseATActivity) {
            try {
                this.i = ((BaseATActivity) context).n;
            } catch (Throwable unused) {
            }
        }
        this.j = new ArrayList();
        this.s = new m();
        b();
        f();
        e();
        if (this.c != null) {
            setFocusable(true);
            setClickable(true);
        }
        if (cVar != null && cVar.i()) {
            com.smartdigimkt.n1.h0 h0Var = new com.smartdigimkt.n1.h0(this, cVar, cVar);
            this.q = h0Var;
            com.smartdigimkt.x.c.a().addDataFetchListener(h0Var);
        }
        i0 i0Var = new i0(this);
        this.z = i0Var;
        j.a().s.add(i0Var);
        if (cVar != null && !TextUtils.isEmpty(cVar.m)) {
            boolean z = cVar.o == 1;
            if (!z && (aVar2 = this.b) != null && (eVar = aVar2.s) != null && h.a(eVar.R1)) {
                Context context2 = getContext();
                if (this.i && !k.a(context2, cVar)) {
                    j0 j0Var = new j0(this, cVar, cVar);
                    this.r = j0Var;
                    com.smartdigimkt.x.c.a().addDataFetchListenerV2(j0Var);
                } else if (z) {
                    j0 j0Var2 = new j0(this, cVar, cVar);
                    this.r = j0Var2;
                    com.smartdigimkt.x.c.a().addDataFetchListenerV2(j0Var2);
                }
            } else if (z) {
                j0 j0Var3 = new j0(this, cVar, cVar);
                this.r = j0Var3;
                com.smartdigimkt.x.c.a().addDataFetchListenerV2(j0Var3);
            }
        }
        post(new k0(this, cVar));
    }

    public void a() {
    }

    public abstract void a(w wVar);

    public abstract void a(boolean z);

    public boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        return false;
    }

    public void b() {
    }

    public final void c() {
        com.smartdigimkt.p3.e eVar = this.b.a;
        if (eVar != null) {
            eVar.a(this, this);
        }
    }

    public com.smartdigimkt.h0.m d() {
        com.smartdigimkt.h0.m mVar = new com.smartdigimkt.h0.m(this.b, "");
        View viewO = o();
        mVar.e = viewO.getWidth();
        mVar.f = viewO.getHeight();
        try {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            mVar.l = iArr[0];
            mVar.m = iArr[1];
        } catch (Throwable unused) {
        }
        mVar.n = this.v;
        return mVar;
    }

    public void destroy() {
        com.smartdigimkt.p3.e eVar = this.b.a;
        if (eVar != null) {
            eVar.c();
        }
        this.A = null;
        a(112);
        a0 a0Var = this.d;
        if (a0Var != null) {
            a0Var.a();
        }
        if (this.q != null) {
            com.smartdigimkt.x.c.a().removeDataFetchListener(this.q);
        }
        if (this.z != null) {
            j jVarA = j.a();
            jVarA.s.remove(this.z);
        }
        if (this.r != null) {
            com.smartdigimkt.x.c.a().removeDataFetchListenerV2(this.r);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.s != null) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int[] iArr = new int[2];
            o().getLocationInWindow(iArr);
            int iMax = Math.max(0, rawX - iArr[0]);
            int iMax2 = Math.max(0, rawY - iArr[1]);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.s.a(rawX, rawY, iMax, iMax2);
            } else if (action == 1) {
                m mVar = this.s;
                mVar.c = rawX;
                mVar.d = rawY;
                mVar.g = iMax;
                mVar.h = iMax2;
                mVar.j = System.currentTimeMillis();
            } else {
                if (action == 2) {
                    m mVar2 = this.s;
                    mVar2.p = rawX;
                    mVar2.q = rawY;
                    mVar2.r = iMax;
                    mVar2.s = iMax2;
                } else if (action == 3) {
                }
                m mVar3 = this.s;
                mVar3.c = rawX;
                mVar3.d = rawY;
                mVar3.g = iMax;
                mVar3.h = iMax2;
                mVar3.j = System.currentTimeMillis();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
        this.o = new e0(this, this, this.c, this.b, getATViewType(), getImproveClickCallback());
    }

    public abstract void f();

    public boolean g() {
        return !(this instanceof WTWebViewSplashATView);
    }

    public int getATViewType() {
        return 0;
    }

    public com.smartdigimkt.h0.a getAdClickRecord() {
        m mVar = this.s;
        if (mVar != null) {
            return mVar.a(0, 13);
        }
        return null;
    }

    public List<View> getAutoClickCTAViews() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.m);
        return arrayList;
    }

    public View getAutoClickPanelView() {
        return null;
    }

    public View getAutoClickRootView() {
        return this;
    }

    public boolean getHasPerformClick() {
        return this.g;
    }

    public com.smartdigimkt.b2.e getImproveClickCallback() {
        return new l0(this);
    }

    public RelativeLayout.LayoutParams getSpecialNoteViewLayoutParams() {
        return null;
    }

    public void h() {
    }

    public abstract void i();

    @Override // com.smartdigimkt.p3.d
    public int impressionMaterialType() {
        return c0.a(this.c, this.b);
    }

    public boolean isRvDeepRewardListenerRegistered() {
        return this.i;
    }

    public boolean isShowingEndCardAfterVideoPlay() {
        return this.l;
    }

    public void j() {
        requestLayout();
    }

    public void k() {
    }

    public void l() {
    }

    public final synchronized void m() {
        com.smartdigimkt.p3.e eVar;
        com.smartdigimkt.p3.e eVar2 = this.b.a;
        if (eVar2 == null || eVar2.a(this.g)) {
            if (this.e) {
                return;
            }
            this.e = true;
            c cVar = this.c;
            if ((cVar instanceof l) && ((l) cVar).j()) {
                com.smartdigimkt.n3.k.b(3, this.b, this.c);
                h();
                this.f = true;
                return;
            }
            n();
            if ((this.c instanceof com.smartdigimkt.e3.a) && (eVar = this.b.a) != null) {
                eVar.f();
            }
            a();
            a(114);
            if (this.b.a == null) {
                sendUpstreamImpression();
            }
            i();
        }
    }

    public final void n() {
        c cVar = this.c;
        if (cVar instanceof com.smartdigimkt.e3.a) {
            com.smartdigimkt.l1.e eVarA = com.smartdigimkt.l1.e.a(getContext());
            com.smartdigimkt.e3.a aVar = (com.smartdigimkt.e3.a) this.c;
            eVarA.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = ((SimpleDateFormat) com.smartdigimkt.l1.e.d.get()).format(new Date(jCurrentTimeMillis));
            com.smartdigimkt.h0.c cVarA = eVarA.a(aVar);
            if (cVarA.f.equals(str)) {
                cVarA.d++;
            } else {
                cVarA.d = 1;
                cVarA.f = str;
            }
            cVarA.e = jCurrentTimeMillis;
            f.a().c(new com.smartdigimkt.l1.d(eVarA, cVarA));
        } else if (cVar instanceof l) {
            if (com.smartdigimkt.i1.c.c == null) {
                synchronized (com.smartdigimkt.i1.c.class) {
                    if (com.smartdigimkt.i1.c.c == null) {
                        com.smartdigimkt.i1.c.c = new com.smartdigimkt.i1.c();
                    }
                }
            }
            com.smartdigimkt.i1.c cVar2 = com.smartdigimkt.i1.c.c;
            Context context = getContext();
            a aVar2 = this.b;
            String strA = com.smartdigimkt.p.a.a(aVar2.b, aVar2.f);
            c cVar3 = this.c;
            e eVar = this.b.s;
            cVar2.getClass();
            if (cVar3.e() == 3 && (eVar instanceof com.smartdigimkt.b3.m)) {
                com.smartdigimkt.b3.m mVar = (com.smartdigimkt.b3.m) eVar;
                if (mVar.Y1 > 0) {
                    f.a().c(new b(cVar2, mVar, strA, context, cVar3));
                }
            }
        }
        c cVar4 = this.c;
        if ((cVar4 instanceof l) && this.b.k == 67) {
            if (((l) cVar4).a(true, true)) {
                com.smartdigimkt.u2.c.a(getContext()).a(this.c.a, 0, 1);
            }
            if (((l) this.c).a(false, true)) {
                com.smartdigimkt.u2.b.a(getContext()).a(this.c.b, 0, 1);
            }
        }
    }

    public View o() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        a aVar;
        super.onAttachedToWindow();
        c();
        if (this.t == null && (aVar = this.b) != null && aVar.s.M == 1) {
            this.t = new MCView(getContext());
            addView(this.t, getChildCount(), new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.u == 0) {
            this.u = System.currentTimeMillis();
        }
        a(116);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(117);
    }

    @Override // com.smartdigimkt.p3.d
    public void onImpressionExpired() {
        if (this.f || this.e) {
            return;
        }
        this.f = true;
        this.e = true;
        com.smartdigimkt.n3.k.b(3, this.b, this.c);
        h();
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

    @Override // com.smartdigimkt.p3.d
    public void sendMediaImpression() {
        Runnable runnable = this.A;
        if (runnable != null) {
            runnable.run();
        } else {
            m();
        }
    }

    @Override // com.smartdigimkt.p3.d
    public void sendUpstreamImpression() {
        s.a(8, this.c, d());
    }

    @Override // com.smartdigimkt.y1.g0
    public void setCallback(h0 h0Var) {
        synchronized (this) {
            this.p = h0Var;
        }
    }

    public void setHasPerformClick(boolean z) {
        this.g = z;
    }

    public void setRvDeepRewardListenerRegistered(boolean z) {
        this.i = z;
    }

    public void setShowingEndCardAfterVideoPlay(boolean z) {
        this.l = z;
    }

    public void setTrackClickAreaView(View view) {
        this.k = view;
    }

    public void a(int i, int i2) {
        e eVar;
        this.g = true;
        m();
        if (this.d == null) {
            this.d = new a0(getContext(), this.b, this.c, this);
        }
        com.smartdigimkt.a0.e eVar2 = this.d.g;
        if (eVar2 == null || !eVar2.e.get()) {
            if (this.c.i() && i == 1 && ((i2 == 1 || i2 == 6) && this.c.D == 4 && this.b.s.H0)) {
                com.smartdigimkt.x.c.a().pause(this.c);
                return;
            }
            if (i != 5 && i != 6 && i != 7) {
                int iB = m.b(i, i2);
                if (iB == 0 || iB == 1) {
                    this.y = true;
                } else if (iB == 2) {
                    this.x = true;
                }
            }
            if (this.l) {
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
            w wVar = new w();
            wVar.a = i;
            wVar.b = i2;
            if ((i == 4 || i == 19) && this.t != null) {
                WeakReference weakReference = com.smartdigimkt.r3.c.a().c;
                View autoClickPanelView = null;
                Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
                if (activity != null) {
                    f0 f0Var = new f0(this, wVar, i, i2);
                    a aVar = this.b;
                    int i3 = (aVar == null || (eVar = aVar.s) == null) ? -1 : eVar.e;
                    if (i3 == 1) {
                        List<View> autoClickCTAViews = getAutoClickCTAViews();
                        if (autoClickCTAViews != null) {
                            int size = autoClickCTAViews.size();
                            for (int i4 = 0; i4 < size; i4++) {
                                View view = autoClickCTAViews.get(i4);
                                if (view != null && view.isShown() && view.getWidth() > 0 && view.getHeight() > 0) {
                                    autoClickPanelView = view;
                                    break;
                                }
                            }
                        }
                    } else if (i3 == 2) {
                        autoClickPanelView = getAutoClickPanelView();
                    }
                    this.t.runMC(activity, getAutoClickRootView(), autoClickPanelView, f0Var);
                    return;
                }
            }
            a(wVar, i, i2);
        }
    }

    public final void a(w wVar, int i, int i2) {
        View view;
        int i3;
        e eVar;
        a0 a0Var = this.d;
        com.smartdigimkt.n1.g0 g0Var = new com.smartdigimkt.n1.g0(this, wVar);
        com.smartdigimkt.a0.e eVar2 = a0Var.g;
        if (eVar2 != null) {
            eVar2.a = g0Var;
        }
        com.smartdigimkt.h0.m mVarD = d();
        m mVar = this.s;
        if (mVar != null) {
            if (i == 18) {
                mVar.c = mVar.p;
                mVar.d = mVar.q;
                mVar.g = mVar.r;
                mVar.h = mVar.s;
                mVar.j = System.currentTimeMillis();
            }
            m mVar2 = this.s;
            if (mVar2 != null && i == 19) {
                mVar2.a();
            }
            if (i == 1) {
                mVarD.g = this.s.a(0, i2);
            } else if (i != 5 && i != 6 && i != 7) {
                View view2 = this.k;
                View view3 = view2 != null ? view2 : this;
                mVarD.g = this.s.a(view3, view3, i, i2, 1);
            } else {
                a aVar = this.b;
                int i4 = (aVar == null || (eVar = aVar.s) == null) ? 0 : eVar.e;
                int i5 = 4;
                View autoClickPanelView = null;
                if (i4 == 1) {
                    List<View> autoClickCTAViews = getAutoClickCTAViews();
                    if (autoClickCTAViews != null) {
                        int size = autoClickCTAViews.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            View view4 = autoClickCTAViews.get(i6);
                            if (view4 != null && view4.isShown() && view4.getWidth() > 0 && view4.getHeight() > 0) {
                                autoClickPanelView = view4;
                                break;
                            }
                        }
                    }
                } else if (i4 != 2) {
                    i5 = 1;
                } else {
                    autoClickPanelView = getAutoClickPanelView();
                }
                if (autoClickPanelView == null || !autoClickPanelView.isShown() || autoClickPanelView.getWidth() <= 0 || autoClickPanelView.getHeight() <= 0) {
                    View autoClickRootView = getAutoClickRootView();
                    if (autoClickPanelView != null) {
                        autoClickPanelView.toString();
                    }
                    view = autoClickRootView;
                    i3 = 1;
                } else {
                    i3 = i5;
                    view = autoClickPanelView;
                }
                mVarD.g = this.s.a(view, o(), i, i2, i3);
            }
        }
        this.d.a(mVarD);
        if (this.o != null) {
            HashMap map = new HashMap();
            map.put("click_type", Integer.valueOf(i));
            map.put("click_area", Integer.valueOf(i2));
            this.o.a(map);
        }
        a(113);
    }

    public final float a(j3 j3Var, boolean z) {
        return com.smartdigimkt.i2.l.a(j3Var, z, this.b, true);
    }

    public void a(int i) {
        if (i == 114) {
            this.w = System.currentTimeMillis();
        }
        e0 e0Var = this.o;
        if (e0Var != null) {
            e0Var.a(i);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        synchronized (this) {
            try {
                try {
                    h0 h0Var = this.p;
                    if (h0Var != null && h0Var.a(motionEvent)) {
                        return true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    public BaseATView(Context context, a aVar, c cVar) {
        this(context, aVar, cVar, "");
    }

    public BaseATView(Context context) {
        super(context);
        this.a = "BaseATView";
        this.e = false;
        this.f = false;
        this.g = false;
        this.l = false;
        this.B = false;
    }
}
