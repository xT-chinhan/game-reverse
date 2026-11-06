package com.byazt.prf;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, 1455})
public class RecyclerView extends ViewGroup implements com.byazt.mgr.s {
    public boolean a;
    public final List<m> ae;
    public final int[] an;
    public int b;
    public final py bb;
    public boolean cd;
    public EdgeEffect ci;
    public final Rect cp;
    public EdgeEffect cx;
    public final ArrayList<fs> cy;
    public final RectF d;
    public boolean dh;
    public final com.byazt.prf.cy.qg dm;
    public int dn;
    public final int dw;
    public int e;
    public Runnable ei;
    public int el;
    public int fl;
    public final com.byazt.prf.cy fs;
    public float g;
    public final wm h;
    public float ha;
    public boolean hd;
    public int he;
    public int hf;
    public w hu;
    public d i;
    public EdgeEffect ic;
    public final int[] j;
    public sz ju;
    public hd k;
    public int kc;
    public final cy l;
    public boolean lh;
    public boolean ln;
    public EdgeEffect lq;
    public boolean m;
    public final int[] mz;
    public List<cp> nf;
    public final int[] np;
    public n oa;
    public boolean ou;
    public int pe;
    public final cd pk;
    public boolean py;
    public com.byazt.mgr.q r;
    public int rf;
    public final AccessibilityManager ri;
    public boolean rv;
    public boolean ry;
    public final ArrayList<oa> sh;
    public final int[] sq;
    public final int su;
    public rv sz;
    public com.byazt.prf.q t;
    public List<sz> ta;
    public final Runnable tj;
    public boolean um;
    public com.byazt.prf.q.n ur;
    public boolean v;
    public int vb;
    public com.byazt.prf.n w;
    public boolean wm;
    public final Rect wo;
    public w.n wv;
    public com.byazt.prf.qg x;
    public q xi;
    public oa y;
    public l yw;
    public VelocityTracker z;
    public static final int[] fi = {R.attr.nestedScrollingEnabled};
    public static final int[] df = {R.attr.clipToPadding};
    public static final boolean n = false;
    public static final boolean qg = true;
    public static final boolean s = true;
    public static final boolean q = true;
    public static final boolean oj = false;
    public static final boolean dg = false;
    public static final Class<?>[] u = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    public static final Interpolator f = new Interpolator() { // from class: com.byazt.prf.RecyclerView.6
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    public interface cp {
        void n(View view);

        void qg(View view);
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1135})
    public static abstract class d {
        public abstract boolean n(int i, int i2);
    }

    public interface hd {
    }

    public interface oa {
        boolean n(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2428})
    public static abstract class ou {
        public abstract View n(cy cyVar, int i, int i2);
    }

    public interface q {
        int n(int i, int i2);
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1137})
    public static abstract class s {
        public void n() {
        }

        public void n(int i, int i2) {
        }

        public void n(int i, int i2, Object obj) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2523})
    public static abstract class sz {
        public void n(RecyclerView recyclerView, int i) {
        }

        public void n(RecyclerView recyclerView, int i, int i2) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2545})
    public static class um implements oa {
        @Override // com.byazt.prf.RecyclerView.oa
        public boolean n(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pk = new cd();
        this.l = new cy();
        this.fs = new com.byazt.prf.cy();
        this.tj = new Runnable() { // from class: com.byazt.prf.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.um || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.hd) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.py) {
                    RecyclerView.this.a = true;
                } else {
                    RecyclerView.this.l();
                }
            }
        };
        this.cp = new Rect();
        this.wo = new Rect();
        this.d = new RectF();
        this.cy = new ArrayList<>();
        this.sh = new ArrayList<>();
        this.rf = 0;
        this.wm = false;
        this.m = false;
        this.pe = 0;
        this.e = 0;
        this.yw = new l();
        this.hu = new com.byazt.prf.s();
        this.hf = 0;
        this.kc = -1;
        this.ha = Float.MIN_VALUE;
        this.g = Float.MIN_VALUE;
        this.ry = true;
        this.h = new wm();
        this.ur = q ? new com.byazt.prf.q.n() : null;
        this.bb = new py();
        this.ln = false;
        this.lh = false;
        this.wv = new x();
        this.v = false;
        this.np = new int[2];
        this.mz = new int[2];
        this.j = new int[2];
        this.sq = new int[2];
        this.an = new int[2];
        this.ae = new ArrayList();
        this.ei = new Runnable() { // from class: com.byazt.prf.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.hu != null) {
                    RecyclerView.this.hu.n();
                }
                RecyclerView.this.v = false;
            }
        };
        this.dm = new com.byazt.prf.cy.qg() { // from class: com.byazt.prf.RecyclerView.3
            @Override // com.byazt.prf.cy.qg
            public void n(m mVar, w.qg qgVar, w.qg qgVar2) {
                RecyclerView.this.l.s(mVar);
                RecyclerView.this.qg(mVar, qgVar, qgVar2);
            }

            @Override // com.byazt.prf.cy.qg
            public void qg(m mVar, w.qg qgVar, w.qg qgVar2) {
                RecyclerView.this.n(mVar, qgVar, qgVar2);
            }

            @Override // com.byazt.prf.cy.qg
            public void s(m mVar, w.qg qgVar, w.qg qgVar2) {
                mVar.n(false);
                if (RecyclerView.this.wm) {
                    if (RecyclerView.this.hu.n(mVar, mVar, qgVar, qgVar2)) {
                        RecyclerView.this.cy();
                    }
                } else if (RecyclerView.this.hu.s(mVar, qgVar, qgVar2)) {
                    RecyclerView.this.cy();
                }
            }

            @Override // com.byazt.prf.cy.qg
            public void n(m mVar) {
                RecyclerView.this.sz.n(mVar.n, RecyclerView.this.l);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, df, i, 0);
                this.rv = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception unused) {
            }
        } else {
            this.rv = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.fl = viewConfiguration.getScaledTouchSlop();
        this.ha = com.byazt.mgr.x.n(viewConfiguration, context);
        this.g = com.byazt.mgr.x.qg(viewConfiguration, context);
        this.dw = viewConfiguration.getScaledMinimumFlingVelocity();
        this.su = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.hu.n(this.wv);
        qg();
        h();
        hu();
        if (com.byazt.mgr.x.qg(this) == 0) {
            com.byazt.mgr.x.n(this, 1);
        }
        this.ri = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable unused2) {
        }
        setNestedScrollingEnabled(true);
    }

    public String n() {
        return " " + super.toString() + ", adapter:" + this.oa + ", layout:" + this.sz + ", context:" + getContext();
    }

    private void hu() {
        if (com.byazt.mgr.x.rv(this) == 0) {
            com.byazt.mgr.x.qg(this, 8);
        }
    }

    private void h() {
        this.x = new com.byazt.prf.qg(new com.byazt.prf.qg.InterfaceC0305qg() { // from class: com.byazt.prf.RecyclerView.4
            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public int n() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void n(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.d(view);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public int n(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void n(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.cp(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public View qg(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void qg() {
                int iN = n();
                for (int i = 0; i < iN; i++) {
                    View viewQg = qg(i);
                    RecyclerView.this.cp(viewQg);
                    viewQg.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public m qg(View view) {
                return RecyclerView.l(view);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void n(View view, int i, ViewGroup.LayoutParams layoutParams) {
                m mVarL = RecyclerView.l(view);
                if (mVarL != null) {
                    if (!mVarL.cd() && !mVarL.X_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + mVarL + RecyclerView.this.n());
                    }
                    mVarL.oa();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void s(int i) {
                m mVarL;
                View viewQg = qg(i);
                if (viewQg != null && (mVarL = RecyclerView.l(viewQg)) != null) {
                    if (mVarL.cd() && !mVarL.X_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + mVarL + RecyclerView.this.n());
                    }
                    mVarL.qg(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void s(View view) {
                m mVarL = RecyclerView.l(view);
                if (mVarL != null) {
                    mVarL.n(RecyclerView.this);
                }
            }

            @Override // com.byazt.prf.qg.InterfaceC0305qg
            public void q(View view) {
                m mVarL = RecyclerView.l(view);
                if (mVarL != null) {
                    mVarL.qg(RecyclerView.this);
                }
            }
        });
    }

    public void qg() {
        this.w = new com.byazt.prf.n(new com.byazt.prf.n.InterfaceC0304n() { // from class: com.byazt.prf.RecyclerView.5
            @Override // com.byazt.prf.n.InterfaceC0304n
            public m n(int i) {
                m mVarN = RecyclerView.this.n(i, true);
                if (mVarN == null || RecyclerView.this.x.s(mVarN.n)) {
                    return null;
                }
                return mVarN;
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void n(int i, int i2) {
                RecyclerView.this.n(i, i2, true);
                RecyclerView.this.ln = true;
                RecyclerView.this.bb.s += i2;
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void qg(int i, int i2) {
                RecyclerView.this.n(i, i2, false);
                RecyclerView.this.ln = true;
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void n(int i, int i2, Object obj) {
                RecyclerView.this.n(i, i2, obj);
                RecyclerView.this.lh = true;
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void n(com.byazt.prf.n.qg qgVar) {
                s(qgVar);
            }

            public void s(com.byazt.prf.n.qg qgVar) {
                int i = qgVar.n;
                if (i == 1) {
                    RecyclerView.this.sz.n(RecyclerView.this, qgVar.qg, qgVar.q);
                    return;
                }
                if (i == 2) {
                    RecyclerView.this.sz.qg(RecyclerView.this, qgVar.qg, qgVar.q);
                } else if (i == 4) {
                    RecyclerView.this.sz.n(RecyclerView.this, qgVar.qg, qgVar.q, qgVar.s);
                } else {
                    if (i != 8) {
                        return;
                    }
                    RecyclerView.this.sz.n(RecyclerView.this, qgVar.qg, qgVar.q, 1);
                }
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void qg(com.byazt.prf.n.qg qgVar) {
                s(qgVar);
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void s(int i, int i2) {
                RecyclerView.this.x(i, i2);
                RecyclerView.this.ln = true;
            }

            @Override // com.byazt.prf.n.InterfaceC0304n
            public void q(int i, int i2) {
                RecyclerView.this.w(i, i2);
                RecyclerView.this.ln = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.cd = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.rv) {
            d();
        }
        this.rv = z;
        super.setClipToPadding(z);
        if (this.um) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.rv;
    }

    public void setAdapter(n nVar) {
        setLayoutFrozen(false);
        n(nVar, false, true);
        s(false);
        requestLayout();
    }

    public void s() {
        w wVar = this.hu;
        if (wVar != null) {
            wVar.q();
        }
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.s(this.l);
            this.sz.qg(this.l);
        }
        this.l.n();
    }

    private void n(n nVar, boolean z, boolean z2) {
        n nVar2 = this.oa;
        if (nVar2 != null) {
            nVar2.qg(this.pk);
        }
        if (!z || z2) {
            s();
        }
        this.w.n();
        n nVar3 = this.oa;
        this.oa = nVar;
        if (nVar != null) {
            nVar.n(this.pk);
        }
        this.l.n(nVar3, this.oa, z);
        this.bb.w = true;
    }

    public n getAdapter() {
        return this.oa;
    }

    public void setRecyclerListener(hd hdVar) {
        this.k = hdVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        rv rvVar = this.sz;
        return rvVar != null ? rvVar.a() : super.getBaseline();
    }

    public void n(cp cpVar) {
        if (this.nf == null) {
            this.nf = new ArrayList();
        }
        this.nf.add(cpVar);
    }

    public void setLayoutManager(rv rvVar) {
        if (rvVar != this.sz) {
            x();
            if (this.sz != null) {
                w wVar = this.hu;
                if (wVar != null) {
                    wVar.q();
                }
                this.sz.s(this.l);
                this.sz.qg(this.l);
                this.l.n();
                if (this.hd) {
                    this.sz.qg(this, this.l);
                }
                this.sz.qg((RecyclerView) null);
                this.sz = null;
            } else {
                this.l.n();
            }
            this.x.n();
            this.sz = rvVar;
            if (rvVar != null) {
                if (rvVar.hd != null) {
                    throw new IllegalArgumentException("LayoutManager " + rvVar + " is already attached to a RecyclerView:" + rvVar.hd.n());
                }
                this.sz.qg(this);
                if (this.hd) {
                    this.sz.s(this);
                }
            }
            this.l.qg();
            requestLayout();
        }
    }

    public void setOnFlingListener(d dVar) {
        this.i = dVar;
    }

    public d getOnFlingListener() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void l(m mVar) {
        View view = mVar.n;
        boolean z = view.getParent() == this;
        this.l.s(qg(view));
        if (mVar.cd()) {
            this.x.n(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.x.n(view, true);
        } else {
            this.x.q(view);
        }
    }

    public boolean n(View view) {
        w();
        boolean zW = this.x.w(view);
        if (zW) {
            m mVarL = l(view);
            this.l.s(mVarL);
            this.l.qg(mVarL);
        }
        n(!zW);
        return zW;
    }

    public rv getLayoutManager() {
        return this.sz;
    }

    public k getRecycledViewPool() {
        return this.l.x();
    }

    public void setRecycledViewPool(k kVar) {
        this.l.n(kVar);
    }

    public void setViewCacheExtension(ou ouVar) {
        this.l.n(ouVar);
    }

    public void setItemViewCacheSize(int i) {
        this.l.n(i);
    }

    public int getScrollState() {
        return this.hf;
    }

    public void setScrollState(int i) {
        if (i != this.hf) {
            this.hf = i;
            if (i != 2) {
                ur();
            }
            x(i);
        }
    }

    public void n(fs fsVar, int i) {
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.n("Cannot add item decoration during a scroll  or layout");
        }
        if (this.cy.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.cy.add(fsVar);
        } else {
            this.cy.add(i, fsVar);
        }
        cd();
        requestLayout();
    }

    public void n(fs fsVar) {
        n(fsVar, -1);
    }

    public int getItemDecorationCount() {
        return this.cy.size();
    }

    public void setChildDrawingOrderCallback(q qVar) {
        if (qVar != this.xi) {
            this.xi = qVar;
            setChildrenDrawingOrderEnabled(qVar != null);
        }
    }

    public void n(sz szVar) {
        if (this.ta == null) {
            this.ta = new ArrayList();
        }
        this.ta.add(szVar);
    }

    public void qg(sz szVar) {
        List<sz> list = this.ta;
        if (list != null) {
            list.remove(szVar);
        }
    }

    public void q() {
        List<sz> list = this.ta;
        if (list != null) {
            list.clear();
        }
    }

    public void n(int i) {
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.l(i);
            awakenScrollBars();
        }
    }

    public void qg(int i) {
        if (this.py) {
            return;
        }
        rv rvVar = this.sz;
        if (rvVar == null) {
            com.byazt.tk.k.qg("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            rvVar.n(this, this.bb, i);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        rv rvVar = this.sz;
        if (rvVar == null) {
            com.byazt.tk.k.qg("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.py) {
            return;
        }
        boolean zQ = rvVar.q();
        boolean zL = this.sz.l();
        if (zQ || zL) {
            if (!zQ) {
                i = 0;
            }
            if (!zL) {
                i2 = 0;
            }
            n(i, i2, (MotionEvent) null);
        }
    }

    public void n(int i, int i2, int[] iArr) {
        w();
        oa();
        com.byazt.ybd.n.n("RV Scroll");
        n(this.bb);
        int iN = i != 0 ? this.sz.n(i, this.l, this.bb) : 0;
        int iQg = i2 != 0 ? this.sz.qg(i2, this.l, this.bb) : 0;
        com.byazt.ybd.n.n();
        wm();
        sz();
        n(false);
        if (iArr != null) {
            iArr[0] = iN;
            iArr[1] = iQg;
        }
    }

    public void l() {
        if (this.um && !this.wm) {
            if (!this.w.q()) {
                return;
            }
            if (this.w.n(4) && !this.w.n(11)) {
                com.byazt.ybd.n.n("RV PartialInvalidate");
                w();
                oa();
                this.w.qg();
                if (!this.a) {
                    if (t()) {
                        hd();
                    } else {
                        this.w.s();
                    }
                }
                n(true);
                sz();
                com.byazt.ybd.n.n();
                return;
            }
            if (!this.w.q()) {
                return;
            }
        }
        com.byazt.ybd.n.n("RV FullInvalidate");
        hd();
        com.byazt.ybd.n.n();
    }

    private boolean t() {
        int iQg = this.x.qg();
        for (int i = 0; i < iQg; i++) {
            m mVarL = l(this.x.qg(i));
            if (mVarL != null && !mVarL.X_() && mVarL.h()) {
                return true;
            }
        }
        return false;
    }

    public boolean n(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        l();
        if (this.oa != null) {
            n(i, i2, this.an);
            int[] iArr = this.an;
            int i7 = iArr[0];
            int i8 = iArr[1];
            i4 = i8;
            i5 = i7;
            i6 = i - i7;
            i3 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.cy.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (n(i5, i4, i6, i3, this.mz, 0)) {
            int i10 = this.el;
            int[] iArr2 = this.mz;
            int i11 = iArr2[0];
            this.el = i10 - i11;
            int i12 = this.vb;
            int i13 = iArr2[1];
            this.vb = i12 - i13;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i11, i13);
            }
            int[] iArr3 = this.sq;
            int i14 = iArr3[0];
            int[] iArr4 = this.mz;
            iArr3[0] = i14 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.byazt.mgr.x.n(motionEvent, 8194)) {
                n(motionEvent.getX(), i6, motionEvent.getY(), i9);
            }
            s(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            fs(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        rv rvVar = this.sz;
        if (rvVar != null && rvVar.q()) {
            return this.sz.s(this.bb);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        rv rvVar = this.sz;
        if (rvVar != null && rvVar.q()) {
            return this.sz.l(this.bb);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        rv rvVar = this.sz;
        if (rvVar != null && rvVar.q()) {
            return this.sz.x(this.bb);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        rv rvVar = this.sz;
        if (rvVar != null && rvVar.l()) {
            return this.sz.q(this.bb);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        rv rvVar = this.sz;
        if (rvVar != null && rvVar.l()) {
            return this.sz.w(this.bb);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        rv rvVar = this.sz;
        if (rvVar != null && rvVar.l()) {
            return this.sz.fs(this.bb);
        }
        return 0;
    }

    public void w() {
        int i = this.rf + 1;
        this.rf = i;
        if (i != 1 || this.py) {
            return;
        }
        this.a = false;
    }

    public void n(boolean z) {
        if (this.rf <= 0) {
            this.rf = 1;
        }
        if (!z && !this.py) {
            this.a = false;
        }
        if (this.rf == 1) {
            if (z && this.a && !this.py && this.sz != null && this.oa != null) {
                hd();
            }
            if (!this.py) {
                this.a = false;
            }
        }
        this.rf--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.py) {
            n("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.py = false;
                if (this.a && this.sz != null && this.oa != null) {
                    requestLayout();
                }
                this.a = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.py = true;
            this.dh = true;
            x();
        }
    }

    public void n(int i, int i2) {
        n(i, i2, (Interpolator) null);
    }

    public void n(int i, int i2, Interpolator interpolator) {
        rv rvVar = this.sz;
        if (rvVar == null) {
            com.byazt.tk.k.qg("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.py) {
            return;
        }
        if (!rvVar.q()) {
            i = 0;
        }
        if (!this.sz.l()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.h.n(i, i2, interpolator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean qg(int i, int i2) {
        rv rvVar = this.sz;
        if (rvVar == null) {
            com.byazt.tk.k.qg("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.py) {
            return false;
        }
        int iQ = rvVar.q();
        boolean zL = this.sz.l();
        if (iQ == 0 || Math.abs(i) < this.dw) {
            i = 0;
        }
        if (!zL || Math.abs(i2) < this.dw) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f2 = i;
        float f3 = i2;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = iQ != 0 || zL;
            dispatchNestedFling(f2, f3, z);
            d dVar = this.i;
            if (dVar != null && dVar.n(i, i2)) {
                return true;
            }
            if (z) {
                if (zL) {
                    iQ = (iQ == true ? 1 : 0) | 2;
                }
                rv(iQ, 1);
                int i3 = this.su;
                int iMax = Math.max(-i3, Math.min(i, i3));
                int i4 = this.su;
                this.h.n(iMax, Math.max(-i4, Math.min(i2, i4)));
                return true;
            }
        }
        return false;
    }

    public void x() {
        setScrollState(0);
        ur();
    }

    private void ur() {
        this.h.qg();
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.an();
        }
    }

    public int getMinFlingVelocity() {
        return this.dw;
    }

    public int getMaxFlingVelocity() {
        return this.su;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    private void n(float f2, float f3, float f4, float f5) {
        boolean z;
        boolean z2 = true;
        if (f3 >= 0.0f) {
            if (f3 > 0.0f) {
                rv();
                com.byazt.mgr.n.n(this.ic, f3 / getWidth(), f4 / getHeight());
            } else {
                z = false;
            }
            if (f5 < 0.0f) {
                tj();
                com.byazt.mgr.n.n(this.lq, (-f5) / getHeight(), f2 / getWidth());
            } else if (f5 > 0.0f) {
                cp();
                com.byazt.mgr.n.n(this.ci, f5 / getHeight(), 1.0f - (f2 / getWidth()));
            } else {
                z2 = z;
            }
            if (z2 && f3 == 0.0f && f5 == 0.0f) {
                return;
            }
            com.byazt.mgr.x.s(this);
        }
        fs();
        com.byazt.mgr.n.n(this.cx, (-f3) / getWidth(), 1.0f - (f4 / getHeight()));
        z = true;
        if (f5 < 0.0f) {
            tj();
            com.byazt.mgr.n.n(this.lq, (-f5) / getHeight(), f2 / getWidth());
        } else if (f5 > 0.0f) {
            cp();
            com.byazt.mgr.n.n(this.ci, f5 / getHeight(), 1.0f - (f2 / getWidth()));
        } else {
            z2 = z;
        }
        if (z2) {
        }
        com.byazt.mgr.x.s(this);
    }

    private void bb() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.cx;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.cx.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.lq;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.lq.isFinished();
        }
        EdgeEffect edgeEffect3 = this.ic;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.ic.isFinished();
        }
        EdgeEffect edgeEffect4 = this.ci;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.ci.isFinished();
        }
        if (zIsFinished) {
            com.byazt.mgr.x.s(this);
        }
    }

    public void s(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.cx;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.cx.onRelease();
            zIsFinished = this.cx.isFinished();
        }
        EdgeEffect edgeEffect2 = this.ic;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.ic.onRelease();
            zIsFinished |= this.ic.isFinished();
        }
        EdgeEffect edgeEffect3 = this.lq;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.lq.onRelease();
            zIsFinished |= this.lq.isFinished();
        }
        EdgeEffect edgeEffect4 = this.ci;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.ci.onRelease();
            zIsFinished |= this.ci.isFinished();
        }
        if (zIsFinished) {
            com.byazt.mgr.x.s(this);
        }
    }

    public void q(int i, int i2) {
        if (i < 0) {
            fs();
            this.cx.onAbsorb(-i);
        } else if (i > 0) {
            rv();
            this.ic.onAbsorb(i);
        }
        if (i2 < 0) {
            tj();
            this.lq.onAbsorb(-i2);
        } else if (i2 > 0) {
            cp();
            this.ci.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        com.byazt.mgr.x.s(this);
    }

    public void fs() {
        if (this.cx == null) {
            EdgeEffect edgeEffectN = this.yw.n(this, 0);
            this.cx = edgeEffectN;
            if (this.rv) {
                edgeEffectN.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectN.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void rv() {
        if (this.ic == null) {
            EdgeEffect edgeEffectN = this.yw.n(this, 2);
            this.ic = edgeEffectN;
            if (this.rv) {
                edgeEffectN.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectN.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void tj() {
        if (this.lq == null) {
            EdgeEffect edgeEffectN = this.yw.n(this, 1);
            this.lq = edgeEffectN;
            if (this.rv) {
                edgeEffectN.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectN.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void cp() {
        if (this.ci == null) {
            EdgeEffect edgeEffectN = this.yw.n(this, 3);
            this.ci = edgeEffectN;
            if (this.rv) {
                edgeEffectN.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectN.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void d() {
        this.ci = null;
        this.lq = null;
        this.ic = null;
        this.cx = null;
    }

    public static <T> T n(T t) {
        t.getClass();
        return t;
    }

    public void setEdgeEffectFactory(l lVar) {
        n(lVar);
        this.yw = lVar;
        d();
    }

    public l getEdgeEffectFactory() {
        return this.yw;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewN;
        boolean z;
        View viewQ = this.sz.q(view, i);
        if (viewQ != null) {
            return viewQ;
        }
        boolean z2 = (this.oa == null || this.sz == null || k() || this.py) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.sz.l()) {
                int i2 = i == 2 ? MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (oj) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.sz.q()) {
                int i3 = (this.sz.um() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (oj) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                l();
                if (s(view) == null) {
                    return null;
                }
                w();
                this.sz.n(view, i, this.l, this.bb);
                n(false);
            }
            viewN = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                l();
                if (s(view) == null) {
                    return null;
                }
                w();
                viewN = this.sz.n(view, i, this.l, this.bb);
                n(false);
            } else {
                viewN = viewFindNextFocus;
            }
        }
        if (viewN == null || viewN.hasFocusable()) {
            return n(view, viewN, i) ? viewN : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        n(viewN, (View) null);
        return view;
    }

    private boolean n(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || s(view2) == null) {
            return false;
        }
        if (view == null || s(view) == null) {
            return true;
        }
        this.cp.set(0, 0, view.getWidth(), view.getHeight());
        this.wo.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.cp);
        offsetDescendantRectToMyCoords(view2, this.wo);
        byte b = -1;
        int i3 = this.sz.um() == 1 ? -1 : 1;
        if ((this.cp.left < this.wo.left || this.cp.right <= this.wo.left) && this.cp.right < this.wo.right) {
            i2 = 1;
        } else {
            i2 = ((this.cp.right > this.wo.right || this.cp.left >= this.wo.right) && this.cp.left > this.wo.left) ? -1 : 0;
        }
        if ((this.cp.top < this.wo.top || this.cp.bottom <= this.wo.top) && this.cp.bottom < this.wo.bottom) {
            b = 1;
        } else if ((this.cp.bottom <= this.wo.bottom && this.cp.top < this.wo.bottom) || this.cp.top <= this.wo.top) {
            b = 0;
        }
        if (i == 1) {
            return b < 0 || (b == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return b > 0 || (b == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return b < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return b > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + n());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.sz.n(this, this.bb, view, view2) && view2 != null) {
            n(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void n(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.cp.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof tj) {
            tj tjVar = (tj) layoutParams;
            if (!tjVar.l) {
                Rect rect = tjVar.q;
                this.cp.left -= rect.left;
                this.cp.right += rect.right;
                this.cp.top -= rect.top;
                this.cp.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.cp);
            offsetRectIntoDescendantCoords(view, this.cp);
        }
        this.sz.n(this, view, this.cp, !this.um, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.sz.n(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        rv rvVar = this.sz;
        if (rvVar == null || !rvVar.n(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (k()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.pe = 0;
        this.hd = true;
        this.um = this.um && !isLayoutRequested();
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.s(this);
        }
        this.v = false;
        if (q) {
            com.byazt.prf.q qVar = com.byazt.prf.q.n.get();
            this.t = qVar;
            if (qVar == null) {
                this.t = new com.byazt.prf.q();
                Display displayX = com.byazt.mgr.x.x(this);
                if (isInEditMode() || displayX == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displayX.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                this.t.q = (long) (1.0E9f / refreshRate);
                com.byazt.prf.q.n.set(this.t);
            }
            this.t.n(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.byazt.prf.q qVar;
        super.onDetachedFromWindow();
        w wVar = this.hu;
        if (wVar != null) {
            wVar.q();
        }
        x();
        this.hd = false;
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.qg(this, this.l);
        }
        this.ae.clear();
        removeCallbacks(this.ei);
        this.fs.qg();
        if (!q || (qVar = this.t) == null) {
            return;
        }
        qVar.qg(this);
        this.t = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.hd;
    }

    public void n(String str) {
        if (k()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + n());
            }
            throw new IllegalStateException(str);
        }
        if (this.e > 0) {
            new IllegalStateException(n());
        }
    }

    public void n(oa oaVar) {
        this.sh.add(oaVar);
    }

    public void qg(oa oaVar) {
        this.sh.remove(oaVar);
        if (this.y == oaVar) {
            this.y = null;
        }
    }

    private boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.y = null;
        }
        int size = this.sh.size();
        for (int i = 0; i < size; i++) {
            oa oaVar = this.sh.get(i);
            if (oaVar.n(this, motionEvent) && action != 3) {
                this.y = oaVar;
                return true;
            }
        }
        return false;
    }

    private boolean qg(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.y != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.y = null;
                }
                return true;
            }
            this.y = null;
        }
        if (action != 0) {
            int size = this.sh.size();
            for (int i = 0; i < size; i++) {
                oa oaVar = this.sh.get(i);
                if (oaVar.n(this, motionEvent)) {
                    this.y = oaVar;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.py) {
            return false;
        }
        if (n(motionEvent)) {
            lh();
            return true;
        }
        rv rvVar = this.sz;
        if (rvVar == null) {
            return false;
        }
        boolean zQ = rvVar.q();
        boolean zL = this.sz.l();
        if (this.z == null) {
            this.z = VelocityTracker.obtain();
        }
        this.z.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.dh) {
                this.dh = false;
            }
            this.kc = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.el = x2;
            this.dn = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.vb = y;
            this.he = y;
            if (this.hf == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.sq;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = zQ;
            if (zL) {
                i = (zQ ? 1 : 0) | 2;
            }
            rv(i, 0);
        } else if (actionMasked == 1) {
            this.z.clear();
            fs(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.kc);
            if (iFindPointerIndex < 0) {
                com.byazt.tk.k.qg("RecyclerView", "Error processing scroll; pointer index for id " + this.kc + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.hf != 1) {
                int i2 = x3 - this.dn;
                int i3 = y2 - this.he;
                if (!zQ || Math.abs(i2) <= this.fl) {
                    z = false;
                } else {
                    this.el = x3;
                    z = true;
                }
                if (zL && Math.abs(i3) > this.fl) {
                    this.vb = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            lh();
        } else if (actionMasked == 5) {
            this.kc = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.el = x4;
            this.dn = x4;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.vb = y3;
            this.he = y3;
        } else if (actionMasked == 6) {
            s(motionEvent);
        }
        return this.hf == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.sh.size();
        for (int i = 0; i < size; i++) {
            this.sh.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0106  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        boolean z2 = false;
        if (this.py || this.dh) {
            return false;
        }
        if (qg(motionEvent)) {
            lh();
            return true;
        }
        rv rvVar = this.sz;
        if (rvVar == null) {
            return false;
        }
        boolean zQ = rvVar.q();
        boolean zL = this.sz.l();
        if (this.z == null) {
            this.z = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.sq;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.sq;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.kc = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.el = x2;
            this.dn = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.vb = y;
            this.he = y;
            if (zL) {
                i = zQ;
                i = (zQ ? 1 : 0) | 2;
            }
            i = zQ;
            rv(i, 0);
        } else if (actionMasked == 1) {
            this.z.addMovement(motionEventObtain);
            this.z.computeCurrentVelocity(1000, this.su);
            float f2 = zQ ? -this.z.getXVelocity(this.kc) : 0.0f;
            float f3 = zL ? -this.z.getYVelocity(this.kc) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !qg((int) f2, (int) f3)) {
                setScrollState(0);
            }
            ln();
            z2 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.kc);
            if (iFindPointerIndex < 0) {
                com.byazt.tk.k.qg("RecyclerView", "Error processing scroll; pointer index for id " + this.kc + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int i2 = this.el - x3;
            int i3 = this.vb - y2;
            if (n(i2, i3, this.j, this.mz, 0)) {
                int[] iArr3 = this.j;
                i2 -= iArr3[0];
                i3 -= iArr3[1];
                int[] iArr4 = this.mz;
                motionEventObtain.offsetLocation(iArr4[0], iArr4[1]);
                int[] iArr5 = this.sq;
                int i4 = iArr5[0];
                int[] iArr6 = this.mz;
                iArr5[0] = i4 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.hf != 1) {
                if (zQ) {
                    int iAbs = Math.abs(i2);
                    int i5 = this.fl;
                    if (iAbs > i5) {
                        i2 = i2 > 0 ? i2 - i5 : i2 + i5;
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (zL) {
                    int iAbs2 = Math.abs(i3);
                    int i6 = this.fl;
                    if (iAbs2 > i6) {
                        i3 = i3 > 0 ? i3 - i6 : i3 + i6;
                        z = true;
                    }
                }
                if (z) {
                    setScrollState(1);
                }
            }
            if (this.hf == 1) {
                int[] iArr7 = this.mz;
                this.el = x3 - iArr7[0];
                this.vb = y2 - iArr7[1];
                if (n(zQ ? i2 : 0, zL ? i3 : 0, motionEventObtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                com.byazt.prf.q qVar = this.t;
                if (qVar != null && (i2 != 0 || i3 != 0)) {
                    qVar.n(this, i2, i3);
                }
            }
        } else if (actionMasked == 3) {
            lh();
        } else if (actionMasked == 5) {
            this.kc = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.el = x4;
            this.dn = x4;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.vb = y3;
            this.he = y3;
        } else if (actionMasked == 6) {
            s(motionEvent);
        }
        if (!z2) {
            this.z.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void ln() {
        VelocityTracker velocityTracker = this.z;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        fs(0);
        bb();
    }

    private void lh() {
        ln();
        setScrollState(0);
    }

    private void s(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.kc) {
            int i = actionIndex == 0 ? 1 : 0;
            this.kc = motionEvent.getPointerId(i);
            int x2 = (int) (motionEvent.getX(i) + 0.5f);
            this.el = x2;
            this.dn = x2;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.vb = y;
            this.he = y;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0060  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float axisValue;
        if (this.sz != null && !this.py && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f2 = this.sz.l() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.sz.q() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.sz.l()) {
                    f2 = -axisValue;
                } else if (this.sz.q()) {
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f2 = 0.0f;
                axisValue = 0.0f;
            }
            if (f2 != 0.0f || axisValue != 0.0f) {
                n((int) (axisValue * this.ha), (int) (f2 * this.g), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        rv rvVar = this.sz;
        if (rvVar == null) {
            l(i, i2);
            return;
        }
        boolean z = false;
        if (!rvVar.s()) {
            if (this.cd) {
                this.sz.n(this.l, this.bb, i, i2);
                return;
            }
            if (this.ou) {
                w();
                oa();
                an();
                sz();
                if (this.bb.cp) {
                    this.bb.x = true;
                } else {
                    this.w.l();
                    this.bb.x = false;
                }
                this.ou = false;
                n(false);
            } else if (this.bb.cp) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            n nVar = this.oa;
            if (nVar != null) {
                this.bb.l = nVar.n();
            } else {
                this.bb.l = 0;
            }
            w();
            this.sz.n(this.l, this.bb, i, i2);
            n(false);
            this.bb.x = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.sz.n(this.l, this.bb, i, i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z = true;
        }
        if (z || this.oa == null) {
            return;
        }
        if (this.bb.q == 1) {
            oj();
        }
        this.sz.s(i, i2);
        this.bb.rv = true;
        dg();
        this.sz.q(i, i2);
        if (this.sz.cp()) {
            this.sz.s(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), C.ENCODING_PCM_32BIT));
            this.bb.rv = true;
            dg();
            this.sz.q(i, i2);
        }
    }

    public void l(int i, int i2) {
        setMeasuredDimension(rv.n(i, getPaddingLeft() + getPaddingRight(), com.byazt.mgr.x.q(this)), rv.n(i2, getPaddingTop() + getPaddingBottom(), com.byazt.mgr.x.l(this)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        d();
    }

    public void setItemAnimator(w wVar) {
        w wVar2 = this.hu;
        if (wVar2 != null) {
            wVar2.q();
            this.hu.n(null);
        }
        this.hu = wVar;
        if (wVar != null) {
            wVar.n(this.wv);
        }
    }

    public void oa() {
        this.pe++;
    }

    public void sz() {
        qg(true);
    }

    public void qg(boolean z) {
        int i = this.pe - 1;
        this.pe = i;
        if (i <= 0) {
            this.pe = 0;
            if (z) {
                v();
                m();
            }
        }
    }

    private void v() {
        this.b = 0;
    }

    public boolean k() {
        return this.pe > 0;
    }

    public w getItemAnimator() {
        return this.hu;
    }

    public void cy() {
        if (this.v || !this.hd) {
            return;
        }
        com.byazt.mgr.x.n(this, this.ei);
        this.v = true;
    }

    private boolean j() {
        return this.hu != null && this.sz.qg();
    }

    private void an() {
        if (this.wm) {
            this.w.n();
            if (this.m) {
                this.sz.n(this);
            }
        }
        if (j()) {
            this.w.qg();
        } else {
            this.w.l();
        }
        boolean z = false;
        boolean z2 = this.ln || this.lh;
        this.bb.tj = this.um && this.hu != null && (this.wm || z2 || this.sz.py) && (!this.wm || this.oa.qg());
        py pyVar = this.bb;
        if (pyVar.tj && z2 && !this.wm && j()) {
            z = true;
        }
        pyVar.cp = z;
    }

    public void hd() {
        if (this.oa == null) {
            com.byazt.tk.k.qg("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.sz == null) {
            com.byazt.tk.k.qg("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.bb.rv = false;
        if (this.bb.q == 1) {
            oj();
        } else {
            if (!this.w.w() && this.sz.m() == getWidth() && this.sz.hu() == getHeight()) {
                this.sz.l(this);
            }
            u();
        }
        this.sz.l(this);
        dg();
        u();
    }

    private void ae() {
        int iL;
        View focusedChild = (this.ry && hasFocus() && this.oa != null) ? getFocusedChild() : null;
        m mVarQ = focusedChild != null ? q(focusedChild) : null;
        if (mVarQ == null) {
            f();
            return;
        }
        this.bb.oa = this.oa.qg() ? mVarQ.x() : -1L;
        py pyVar = this.bb;
        if (this.wm) {
            iL = -1;
        } else {
            iL = mVarQ.hd() ? mVarQ.q : mVarQ.l();
        }
        pyVar.d = iL;
        this.bb.sz = oa(mVarQ.n);
    }

    private void f() {
        this.bb.oa = -1L;
        this.bb.d = -1;
        this.bb.sz = -1;
    }

    private View fi() {
        m mVarQ;
        int i = this.bb.d != -1 ? this.bb.d : 0;
        int iL = this.bb.l();
        for (int i2 = i; i2 < iL; i2++) {
            m mVarQ2 = q(i2);
            if (mVarQ2 == null) {
                break;
            }
            if (mVarQ2.n.hasFocusable()) {
                return mVarQ2.n;
            }
        }
        int iMin = Math.min(iL, i);
        do {
            iMin--;
            if (iMin < 0 || (mVarQ = q(iMin)) == null) {
                return null;
            }
        } while (!mVarQ.n.hasFocusable());
        return mVarQ.n;
    }

    private void df() {
        View viewFindViewById;
        if (!this.ry || this.oa == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (dg && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.x.qg() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.x.s(focusedChild)) {
                return;
            }
        }
        View viewFi = null;
        m mVarN = (this.bb.oa == -1 || !this.oa.qg()) ? null : n(this.bb.oa);
        if (mVarN != null && !this.x.s(mVarN.n) && mVarN.n.hasFocusable()) {
            viewFi = mVarN.n;
        } else if (this.x.qg() > 0) {
            viewFi = fi();
        }
        if (viewFi != null) {
            if (this.bb.sz != -1 && (viewFindViewById = viewFi.findViewById(this.bb.sz)) != null && viewFindViewById.isFocusable()) {
                viewFi = viewFindViewById;
            }
            viewFi.requestFocus();
        }
    }

    private int oa(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public final void n(py pyVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.h.n;
            pyVar.k = overScroller.getFinalX() - overScroller.getCurrX();
            pyVar.cy = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            pyVar.k = 0;
            pyVar.cy = 0;
        }
    }

    private void oj() {
        this.bb.n(1);
        n(this.bb);
        this.bb.rv = false;
        w();
        this.fs.n();
        oa();
        an();
        ae();
        py pyVar = this.bb;
        pyVar.fs = pyVar.tj && this.lh;
        this.lh = false;
        this.ln = false;
        py pyVar2 = this.bb;
        pyVar2.x = pyVar2.cp;
        this.bb.l = this.oa.n();
        n(this.np);
        if (this.bb.tj) {
            int iQg = this.x.qg();
            for (int i = 0; i < iQg; i++) {
                m mVarL = l(this.x.qg(i));
                if (!mVarL.X_() && (!mVarL.sz() || this.oa.qg())) {
                    this.fs.n(mVarL, this.hu.n(this.bb, mVarL, w.l(mVarL), mVarL.py()));
                    if (this.bb.fs && mVarL.h() && !mVarL.hd() && !mVarL.X_() && !mVarL.sz()) {
                        this.fs.n(n(mVarL), mVarL);
                    }
                }
            }
        }
        if (this.bb.cp) {
            um();
            boolean z = this.bb.w;
            this.bb.w = false;
            this.sz.n(this.l, this.bb);
            this.bb.w = z;
            for (int i2 = 0; i2 < this.x.qg(); i2++) {
                m mVarL2 = l(this.x.qg(i2));
                if (!mVarL2.X_() && !this.fs.q(mVarL2)) {
                    int iL = w.l(mVarL2);
                    boolean zN = mVarL2.n(8192);
                    if (!zN) {
                        iL |= 4096;
                    }
                    w.qg qgVarN = this.hu.n(this.bb, mVarL2, iL, mVarL2.py());
                    if (zN) {
                        n(mVarL2, qgVarN);
                    } else {
                        this.fs.qg(mVarL2, qgVarN);
                    }
                }
            }
            a();
        } else {
            a();
        }
        sz();
        n(false);
        this.bb.q = 2;
    }

    private void dg() {
        w();
        oa();
        this.bb.n(6);
        this.w.l();
        this.bb.l = this.oa.n();
        this.bb.s = 0;
        this.bb.x = false;
        this.sz.n(this.l, this.bb);
        this.bb.w = false;
        py pyVar = this.bb;
        pyVar.tj = pyVar.tj && this.hu != null;
        this.bb.q = 4;
        sz();
        n(false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0079  */
    private void u() {
        this.bb.n(4);
        w();
        oa();
        this.bb.q = 1;
        if (this.bb.tj) {
            for (int iQg = this.x.qg() - 1; iQg >= 0; iQg--) {
                m mVarL = l(this.x.qg(iQg));
                if (!mVarL.X_()) {
                    long jN = n(mVarL);
                    w.qg qgVarN = this.hu.n(this.bb, mVarL);
                    m mVarN = this.fs.n(jN);
                    if (mVarN != null && !mVarN.X_()) {
                        boolean zN = this.fs.n(mVarN);
                        boolean zN2 = this.fs.n(mVarL);
                        if (!zN || mVarN != mVarL) {
                            w.qg qgVarQg = this.fs.qg(mVarN);
                            this.fs.s(mVarL, qgVarN);
                            w.qg qgVarS = this.fs.s(mVarL);
                            if (qgVarQg == null) {
                                n(jN, mVarL, mVarN);
                            } else {
                                n(mVarN, mVarL, qgVarQg, qgVarS, zN, zN2);
                            }
                        } else {
                            this.fs.s(mVarL, qgVarN);
                        }
                    } else {
                        this.fs.s(mVarL, qgVarN);
                    }
                }
            }
            this.fs.n(this.dm);
        }
        this.sz.qg(this.l);
        py pyVar = this.bb;
        pyVar.qg = pyVar.l;
        this.wm = false;
        this.m = false;
        this.bb.tj = false;
        this.bb.cp = false;
        this.sz.py = false;
        if (this.l.qg != null) {
            this.l.qg.clear();
        }
        if (this.sz.hu) {
            this.sz.m = 0;
            this.sz.hu = false;
            this.l.qg();
        }
        this.sz.n(this.bb);
        sz();
        n(false);
        this.fs.n();
        int[] iArr = this.np;
        if (tj(iArr[0], iArr[1])) {
            fs(0, 0);
        }
        df();
        f();
    }

    private void n(long j, m mVar, m mVar2) {
        int iQg = this.x.qg();
        for (int i = 0; i < iQg; i++) {
            m mVarL = l(this.x.qg(i));
            if (mVarL != mVar && n(mVarL) == j) {
                n nVar = this.oa;
                if (nVar != null && nVar.qg()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + mVarL + " \n View Holder 2:" + mVar + n());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + mVarL + " \n View Holder 2:" + mVar + n());
            }
        }
        com.byazt.tk.k.qg("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + mVar2 + " cannot be found but it is necessary for " + mVar + n());
    }

    public void n(m mVar, w.qg qgVar) {
        mVar.n(0, 8192);
        if (this.bb.fs && mVar.h() && !mVar.hd() && !mVar.X_()) {
            this.fs.n(n(mVar), mVar);
        }
        this.fs.n(mVar, qgVar);
    }

    private void n(int[] iArr) {
        int iQg = this.x.qg();
        if (iQg == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iQg; i3++) {
            m mVarL = l(this.x.qg(i3));
            if (!mVarL.X_()) {
                int iQ = mVarL.q();
                if (iQ < i) {
                    i = iQ;
                }
                if (iQ > i2) {
                    i2 = iQ;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean tj(int i, int i2) {
        n(this.np);
        int[] iArr = this.np;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        m mVarL = l(view);
        if (mVarL != null) {
            if (mVarL.cd()) {
                mVarL.oa();
            } else if (!mVarL.X_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + mVarL + n());
            }
        }
        view.clearAnimation();
        cp(view);
        super.removeDetachedView(view, z);
    }

    public long n(m mVar) {
        return this.oa.qg() ? mVar.x() : mVar.s;
    }

    public void n(m mVar, w.qg qgVar, w.qg qgVar2) {
        mVar.n(false);
        if (this.hu.qg(mVar, qgVar, qgVar2)) {
            cy();
        }
    }

    public void qg(m mVar, w.qg qgVar, w.qg qgVar2) {
        l(mVar);
        mVar.n(false);
        if (this.hu.n(mVar, qgVar, qgVar2)) {
            cy();
        }
    }

    private void n(m mVar, m mVar2, w.qg qgVar, w.qg qgVar2, boolean z, boolean z2) {
        mVar.n(false);
        if (z) {
            l(mVar);
        }
        if (mVar != mVar2) {
            if (z2) {
                l(mVar2);
            }
            mVar.fs = mVar2;
            l(mVar);
            this.l.s(mVar);
            mVar2.n(false);
            mVar2.rv = mVar;
        }
        if (this.hu.n(mVar, mVar2, qgVar, qgVar2)) {
            cy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.byazt.ybd.n.n("RV OnLayout");
        hd();
        com.byazt.ybd.n.n();
        this.um = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.rf == 0 && !this.py) {
            super.requestLayout();
        } else {
            this.a = true;
        }
    }

    public void cd() {
        int iS = this.x.s();
        for (int i = 0; i < iS; i++) {
            ((tj) this.x.q(i).getLayoutParams()).l = true;
        }
        this.l.tj();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.cy.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.cy.get(i);
        }
        EdgeEffect edgeEffect = this.cx;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.rv ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.cx;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.lq;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.rv) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.lq;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.ic;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.rv ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.ic;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.ci;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.rv) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.ci;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.hu == null || this.cy.size() <= 0 || !this.hu.qg()) ? z : true) {
            com.byazt.mgr.x.s(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.cy.size();
        for (int i = 0; i < size; i++) {
            this.cy.get(i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof tj) && this.sz.n((tj) layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        rv rvVar = this.sz;
        if (rvVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + n());
        }
        return rvVar.n();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        rv rvVar = this.sz;
        if (rvVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + n());
        }
        return rvVar.n(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        rv rvVar = this.sz;
        if (rvVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + n());
        }
        return rvVar.n(layoutParams);
    }

    public void um() {
        int iS = this.x.s();
        for (int i = 0; i < iS; i++) {
            m mVarL = l(this.x.q(i));
            if (!mVarL.X_()) {
                mVarL.qg();
            }
        }
    }

    public void a() {
        int iS = this.x.s();
        for (int i = 0; i < iS; i++) {
            m mVarL = l(this.x.q(i));
            if (!mVarL.X_()) {
                mVarL.n();
            }
        }
        this.l.rv();
    }

    public void w(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iS = this.x.s();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < iS; i6++) {
            m mVarL = l(this.x.q(i6));
            if (mVarL != null && mVarL.s >= i4 && mVarL.s <= i3) {
                if (mVarL.s == i) {
                    mVarL.n(i2 - i, false);
                } else {
                    mVarL.n(i5, false);
                }
                this.bb.w = true;
            }
        }
        this.l.n(i, i2);
        requestLayout();
    }

    public void x(int i, int i2) {
        int iS = this.x.s();
        for (int i3 = 0; i3 < iS; i3++) {
            m mVarL = l(this.x.q(i3));
            if (mVarL != null && !mVarL.X_() && mVarL.s >= i) {
                mVarL.n(i2, false);
                this.bb.w = true;
            }
        }
        this.l.qg(i, i2);
        requestLayout();
    }

    public void n(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iS = this.x.s();
        for (int i4 = 0; i4 < iS; i4++) {
            m mVarL = l(this.x.q(i4));
            if (mVarL != null && !mVarL.X_()) {
                if (mVarL.s >= i3) {
                    mVarL.n(-i2, z);
                    this.bb.w = true;
                } else if (mVarL.s >= i) {
                    mVarL.n(i - 1, -i2, z);
                    this.bb.w = true;
                }
            }
        }
        this.l.n(i, i2, z);
        requestLayout();
    }

    public void n(int i, int i2, Object obj) {
        int iS = this.x.s();
        int i3 = i + i2;
        for (int i4 = 0; i4 < iS; i4++) {
            View viewQ = this.x.q(i4);
            m mVarL = l(viewQ);
            if (mVarL != null && !mVarL.X_() && mVarL.s >= i && mVarL.s < i3) {
                mVarL.qg(2);
                mVarL.n(obj);
                ((tj) viewQ.getLayoutParams()).l = true;
            }
        }
        this.l.s(i, i2);
    }

    public boolean qg(m mVar) {
        w wVar = this.hu;
        return wVar == null || wVar.n(mVar, mVar.py());
    }

    public void s(boolean z) {
        this.m = z | this.m;
        this.wm = true;
        py();
    }

    public void py() {
        int iS = this.x.s();
        for (int i = 0; i < iS; i++) {
            m mVarL = l(this.x.q(i));
            if (mVarL != null && !mVarL.X_()) {
                mVarL.qg(6);
            }
        }
        cd();
        this.l.fs();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.ry;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.ry = z;
    }

    public m qg(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return l(view);
    }

    public View s(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public m q(View view) {
        View viewS = s(view);
        if (viewS == null) {
            return null;
        }
        return qg(viewS);
    }

    public static m l(View view) {
        if (view == null) {
            return null;
        }
        return ((tj) view.getLayoutParams()).s;
    }

    @Deprecated
    public int w(View view) {
        return x(view);
    }

    public int x(View view) {
        m mVarL = l(view);
        if (mVarL != null) {
            return mVarL.l();
        }
        return -1;
    }

    public int fs(View view) {
        m mVarL = l(view);
        if (mVarL != null) {
            return mVarL.q();
        }
        return -1;
    }

    public m s(int i) {
        return n(i, false);
    }

    public m q(int i) {
        m mVar = null;
        if (this.wm) {
            return null;
        }
        int iS = this.x.s();
        for (int i2 = 0; i2 < iS; i2++) {
            m mVarL = l(this.x.q(i2));
            if (mVarL != null && !mVarL.hd() && q(mVarL) == i) {
                if (!this.x.s(mVarL.n)) {
                    return mVarL;
                }
                mVar = mVarL;
            }
        }
        return mVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:21:0x0033 A[SYNTHETIC] */
    public m n(int i, boolean z) {
        int iS = this.x.s();
        m mVar = null;
        for (int i2 = 0; i2 < iS; i2++) {
            m mVarL = l(this.x.q(i2));
            if (mVarL != null && !mVarL.hd()) {
                if (z) {
                    if (mVarL.s != i) {
                        continue;
                    } else {
                        if (!this.x.s(mVarL.n)) {
                            return mVarL;
                        }
                        mVar = mVarL;
                    }
                } else if (mVarL.q() != i) {
                    continue;
                } else {
                    if (!this.x.s(mVarL.n)) {
                        return mVarL;
                    }
                    mVar = mVarL;
                }
            }
        }
        return mVar;
    }

    public m n(long j) {
        n nVar = this.oa;
        m mVar = null;
        if (nVar != null && nVar.qg()) {
            int iS = this.x.s();
            for (int i = 0; i < iS; i++) {
                m mVarL = l(this.x.q(i));
                if (mVarL != null && !mVarL.hd() && mVarL.x() == j) {
                    if (!this.x.s(mVarL.n)) {
                        return mVarL;
                    }
                    mVar = mVarL;
                }
            }
        }
        return mVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void l(int i) {
        int iQg = this.x.qg();
        for (int i2 = 0; i2 < iQg; i2++) {
            this.x.qg(i2).offsetTopAndBottom(i);
        }
    }

    public void w(int i) {
        int iQg = this.x.qg();
        for (int i2 = 0; i2 < iQg; i2++) {
            this.x.qg(i2).offsetLeftAndRight(i);
        }
    }

    public static void n(View view, Rect rect) {
        tj tjVar = (tj) view.getLayoutParams();
        Rect rect2 = tjVar.q;
        rect.set((view.getLeft() - rect2.left) - tjVar.leftMargin, (view.getTop() - rect2.top) - tjVar.topMargin, view.getRight() + rect2.right + tjVar.rightMargin, view.getBottom() + rect2.bottom + tjVar.bottomMargin);
    }

    public Rect rv(View view) {
        tj tjVar = (tj) view.getLayoutParams();
        if (!tjVar.l) {
            return tjVar.q;
        }
        if (this.bb.n() && (tjVar.l() || tjVar.s())) {
            return tjVar.q;
        }
        Rect rect = tjVar.q;
        rect.set(0, 0, 0, 0);
        int size = this.cy.size();
        for (int i = 0; i < size; i++) {
            this.cp.set(0, 0, 0, 0);
            this.cy.get(i).n(this.cp, view, this, this.bb);
            rect.left += this.cp.left;
            rect.top += this.cp.top;
            rect.right += this.cp.right;
            rect.bottom += this.cp.bottom;
        }
        tjVar.l = false;
        return rect;
    }

    public void fs(int i, int i2) {
        this.e++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        sz szVar = this.ju;
        if (szVar != null) {
            szVar.n(this, i, i2);
        }
        List<sz> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ta.get(size).n(this, i, i2);
            }
        }
        this.e--;
    }

    public void x(int i) {
        rv rvVar = this.sz;
        if (rvVar != null) {
            rvVar.d(i);
        }
        sz szVar = this.ju;
        if (szVar != null) {
            szVar.n(this, i);
        }
        List<sz> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ta.get(size).n(this, i);
            }
        }
    }

    public boolean ou() {
        return !this.um || this.wm || this.w.q();
    }

    public void wm() {
        int iQg = this.x.qg();
        for (int i = 0; i < iQg; i++) {
            View viewQg = this.x.qg(i);
            m mVarQg = qg(viewQg);
            if (mVarQg != null && mVarQg.rv != null) {
                View view = mVarQg.rv.n;
                int left = viewQg.getLeft();
                int top = viewQg.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public static RecyclerView tj(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewTj = tj(viewGroup.getChildAt(i));
            if (recyclerViewTj != null) {
                return recyclerViewTj;
            }
        }
        return null;
    }

    public static void s(m mVar) {
        if (mVar.qg != null) {
            RecyclerView recyclerView = mVar.qg.get();
            while (recyclerView != null) {
                if (recyclerView == mVar.n) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            mVar.qg = null;
        }
    }

    public long getNanoTime() {
        if (q) {
            return System.nanoTime();
        }
        return 0L;
    }

    public void cp(View view) {
        l(view);
        List<cp> list = this.nf;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.nf.get(size).qg(view);
            }
        }
    }

    public void d(View view) {
        l(view);
        List<cp> list = this.nf;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.nf.get(size).n(view);
            }
        }
    }

    public boolean n(m mVar, int i) {
        if (k()) {
            mVar.k = i;
            this.ae.add(mVar);
            return false;
        }
        com.byazt.mgr.x.n(mVar.n, i);
        return true;
    }

    public void m() {
        int i;
        for (int size = this.ae.size() - 1; size >= 0; size--) {
            m mVar = this.ae.get(size);
            if (mVar.n.getParent() == this && !mVar.X_() && (i = mVar.k) != -1) {
                com.byazt.mgr.x.n(mVar.n, i);
                mVar.k = -1;
            }
        }
        this.ae.clear();
    }

    public int q(m mVar) {
        if (mVar.n(524) || !mVar.cy()) {
            return -1;
        }
        return this.w.s(mVar.s);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().n(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().n();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().qg(i);
    }

    public boolean rv(int i, int i2) {
        return getScrollingChildHelper().n(i, i2);
    }

    @Override // android.view.View, com.byazt.mgr.qg
    public void stopNestedScroll() {
        getScrollingChildHelper().s();
    }

    public void fs(int i) {
        getScrollingChildHelper().s(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().qg();
    }

    public boolean rv(int i) {
        return getScrollingChildHelper().n(i);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().n(i, i2, i3, i4, iArr);
    }

    public boolean n(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().n(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().n(i, i2, iArr, iArr2);
    }

    public boolean n(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().n(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().n(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().n(f2, f3);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        q qVar = this.xi;
        return qVar == null ? super.getChildDrawingOrder(i, i2) : qVar.n(i, i2);
    }

    private com.byazt.mgr.q getScrollingChildHelper() {
        if (this.r == null) {
            this.r = new com.byazt.mgr.q(this);
        }
        return this.r;
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1138})
    public static abstract class w {
        public n n = null;
        public ArrayList<Object> qg = new ArrayList<>();
        public long s = 120;
        public long q = 120;
        public long l = 250;
        public long w = 250;

        interface n {
            void n(m mVar);
        }

        public abstract void n();

        public abstract boolean n(m mVar, m mVar2, qg qgVar, qg qgVar2);

        public abstract boolean n(m mVar, qg qgVar, qg qgVar2);

        public abstract void q();

        public abstract void q(m mVar);

        public abstract boolean qg();

        public abstract boolean qg(m mVar, qg qgVar, qg qgVar2);

        public abstract boolean s(m mVar, qg qgVar, qg qgVar2);

        public boolean x(m mVar) {
            return true;
        }

        public long l() {
            return this.l;
        }

        public long w() {
            return this.s;
        }

        public long x() {
            return this.q;
        }

        public long fs() {
            return this.w;
        }

        public void n(n nVar) {
            this.n = nVar;
        }

        public qg n(py pyVar, m mVar, int i, List<Object> list) {
            return tj().n(mVar);
        }

        public qg n(py pyVar, m mVar) {
            return tj().n(mVar);
        }

        public static int l(m mVar) {
            int i = mVar.tj & 14;
            if (mVar.sz()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iW = mVar.w();
            int iL = mVar.l();
            return (iW == -1 || iL == -1 || iW == iL) ? i : i | 2048;
        }

        public final void w(m mVar) {
            n nVar = this.n;
            if (nVar != null) {
                nVar.n(mVar);
            }
        }

        public boolean n(m mVar, List<Object> list) {
            return x(mVar);
        }

        public final void rv() {
            int size = this.qg.size();
            for (int i = 0; i < size; i++) {
                this.qg.get(i);
            }
            this.qg.clear();
        }

        public qg tj() {
            return new qg();
        }

        @com.byazt.cp.n(n = {0, 1, 102, 1720})
        public static class qg {
            public int n;
            public int q;
            public int qg;
            public int s;

            public qg n(m mVar) {
                return n(mVar, 0);
            }

            public qg n(m mVar, int i) {
                View view = mVar.n;
                this.n = view.getLeft();
                this.qg = view.getTop();
                this.s = view.getRight();
                this.q = view.getBottom();
                return this;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1139})
    private class x implements w.n {
        public x() {
        }

        @Override // com.byazt.prf.RecyclerView.w.n
        public void n(m mVar) {
            mVar.n(true);
            if (mVar.fs != null && mVar.rv == null) {
                mVar.fs = null;
            }
            mVar.rv = null;
            if (mVar.m() || RecyclerView.this.n(mVar.n) || !mVar.cd()) {
                return;
            }
            RecyclerView.this.removeDetachedView(mVar.n, false);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2520})
    public static class py {
        public int cy;
        public int d;
        public SparseArray<Object> hd;
        public int k;
        public long oa;
        public int sz;
        public int n = -1;
        public int qg = 0;
        public int s = 0;
        public int q = 1;
        public int l = 0;
        public boolean w = false;
        public boolean x = false;
        public boolean fs = false;
        public boolean rv = false;
        public boolean tj = false;
        public boolean cp = false;

        public void n(int i) {
            if ((this.q & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.q));
            }
        }

        public void n(n nVar) {
            this.q = 1;
            this.l = nVar.n();
            this.x = false;
            this.fs = false;
            this.rv = false;
        }

        public boolean n() {
            return this.x;
        }

        public boolean qg() {
            return this.cp;
        }

        public int s() {
            return this.n;
        }

        public boolean q() {
            return this.n != -1;
        }

        public int l() {
            return this.x ? this.qg - this.s : this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.n + ", mData=" + this.hd + ", mItemCount=" + this.l + ", mIsMeasuring=" + this.rv + ", mPreviousLayoutItemCount=" + this.qg + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.s + ", mStructureChanged=" + this.w + ", mInPreLayout=" + this.x + ", mRunSimpleAnimations=" + this.tj + ", mRunPredictiveAnimations=" + this.cp + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2522})
    static class qg extends Observable<s> {
        public void n() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((s) this.mObservers.get(size)).n();
            }
        }

        public void n(int i, int i2) {
            n(i, i2, null);
        }

        public void n(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((s) this.mObservers.get(size)).n(i, i2, obj);
            }
        }

        public void qg(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((s) this.mObservers.get(size)).n(i, i2);
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1146})
    public static abstract class a {
        public boolean fs;
        public boolean l;
        public boolean q;
        public RecyclerView qg;
        public rv s;
        public View w;
        public int n = -1;
        public final n x = new n(0, 0);

        public interface qg {
            PointF q(int i);
        }

        public abstract void n();

        public abstract void n(int i, int i2, py pyVar, n nVar);

        public abstract void n(View view, py pyVar, n nVar);

        public void n(RecyclerView recyclerView, rv rvVar) {
            if (this.fs) {
                getClass().getSimpleName();
                getClass().getSimpleName();
            }
            this.qg = recyclerView;
            this.s = rvVar;
            if (this.n == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.bb.n = this.n;
            this.l = true;
            this.q = true;
            this.w = l(fs());
            this.qg.h.n();
            this.fs = true;
        }

        public void s(int i) {
            this.n = i;
        }

        public PointF q(int i) {
            Object objQ = q();
            if (objQ instanceof qg) {
                return ((qg) objQ).q(i);
            }
            return null;
        }

        public rv q() {
            return this.s;
        }

        public final void l() {
            if (this.l) {
                this.l = false;
                n();
                this.qg.bb.n = -1;
                this.w = null;
                this.n = -1;
                this.q = false;
                this.s.qg(this);
                this.s = null;
                this.qg = null;
            }
        }

        public boolean w() {
            return this.q;
        }

        public boolean x() {
            return this.l;
        }

        public int fs() {
            return this.n;
        }

        public void n(int i, int i2) {
            PointF pointFQ;
            RecyclerView recyclerView = this.qg;
            if (!this.l || this.n == -1 || recyclerView == null) {
                l();
            }
            if (this.q && this.w == null && this.s != null && (pointFQ = q(this.n)) != null && (pointFQ.x != 0.0f || pointFQ.y != 0.0f)) {
                recyclerView.n((int) Math.signum(pointFQ.x), (int) Math.signum(pointFQ.y), (int[]) null);
            }
            this.q = false;
            View view = this.w;
            if (view != null) {
                if (n(view) == this.n) {
                    n(this.w, recyclerView.bb, this.x);
                    this.x.n(recyclerView);
                    l();
                } else {
                    com.byazt.tk.k.qg("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.w = null;
                }
            }
            if (this.l) {
                n(i, i2, recyclerView.bb, this.x);
                boolean zN = this.x.n();
                this.x.n(recyclerView);
                if (zN) {
                    if (this.l) {
                        this.q = true;
                        recyclerView.h.n();
                    } else {
                        l();
                    }
                }
            }
        }

        public int n(View view) {
            return this.qg.fs(view);
        }

        public int rv() {
            return this.qg.sz.py();
        }

        public View l(int i) {
            return this.qg.sz.s(i);
        }

        public void qg(View view) {
            if (n(view) == fs()) {
                this.w = view;
            }
        }

        public void n(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        @com.byazt.cp.n(n = {0, 1, 102, 1700})
        public static class n {
            public Interpolator l;
            public int n;
            public int q;
            public int qg;
            public int s;
            public boolean w;
            public int x;

            public n(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public n(int i, int i2, int i3, Interpolator interpolator) {
                this.q = -1;
                this.w = false;
                this.x = 0;
                this.n = i;
                this.qg = i2;
                this.s = i3;
                this.l = interpolator;
            }

            public void n(int i) {
                this.q = i;
            }

            public boolean n() {
                return this.q >= 0;
            }

            public void n(RecyclerView recyclerView) {
                int i = this.q;
                if (i >= 0) {
                    this.q = -1;
                    recyclerView.n(i);
                    this.w = false;
                } else {
                    if (this.w) {
                        qg();
                        if (this.l == null) {
                            if (this.s == Integer.MIN_VALUE) {
                                recyclerView.h.qg(this.n, this.qg);
                            } else {
                                recyclerView.h.n(this.n, this.qg, this.s);
                            }
                        } else {
                            recyclerView.h.n(this.n, this.qg, this.s, this.l);
                        }
                        int i2 = this.x + 1;
                        this.x = i2;
                        if (i2 > 10) {
                            com.byazt.tk.k.qg("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.w = false;
                        return;
                    }
                    this.x = 0;
                }
            }

            private void qg() {
                if (this.l != null && this.s <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.s <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.n = i;
                this.qg = i2;
                this.s = i3;
                this.l = interpolator;
                this.w = true;
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2526})
    public static class tj extends ViewGroup.MarginLayoutParams {
        public boolean l;
        public final Rect q;
        public m s;
        public boolean w;

        public tj(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.q = new Rect();
            this.l = true;
            this.w = false;
        }

        public tj(int i, int i2) {
            super(i, i2);
            this.q = new Rect();
            this.l = true;
            this.w = false;
        }

        public tj(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.q = new Rect();
            this.l = true;
            this.w = false;
        }

        public tj(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.q = new Rect();
            this.l = true;
            this.w = false;
        }

        public tj(tj tjVar) {
            super((ViewGroup.MarginLayoutParams) tjVar);
            this.q = new Rect();
            this.l = true;
            this.w = false;
        }

        public boolean s() {
            return this.s.sz();
        }

        public boolean q() {
            return this.s.hd();
        }

        public boolean l() {
            return this.s.h();
        }

        public int w() {
            return this.s.q();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1133})
    public static abstract class m {
        public static final List<Object> hd = Collections.emptyList();
        public RecyclerView cy;
        public final View n;
        public WeakReference<RecyclerView> qg;
        public int tj;
        public int s = -1;
        public int q = -1;
        public long l = -1;
        public int w = -1;
        public int x = -1;
        public m fs = null;
        public m rv = null;
        public List<Object> cp = null;
        public List<Object> d = null;
        public int cd = 0;
        public cy oa = null;
        public boolean sz = false;
        public int um = 0;
        public int k = -1;

        public m(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.n = view;
        }

        public void n(int i, int i2, boolean z) {
            qg(8);
            n(i2, z);
            this.s = i;
        }

        public void n(int i, boolean z) {
            if (this.q == -1) {
                this.q = this.s;
            }
            if (this.x == -1) {
                this.x = this.s;
            }
            if (z) {
                this.x += i;
            }
            this.s += i;
            if (this.n.getLayoutParams() != null) {
                ((tj) this.n.getLayoutParams()).l = true;
            }
        }

        public void n() {
            this.q = -1;
            this.x = -1;
        }

        public void qg() {
            if (this.q == -1) {
                this.q = this.s;
            }
        }

        public boolean X_() {
            return (this.tj & 128) != 0;
        }

        public final int q() {
            int i = this.x;
            return i == -1 ? this.s : i;
        }

        public final int l() {
            RecyclerView recyclerView = this.cy;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.q(this);
        }

        public final int w() {
            return this.q;
        }

        public final long x() {
            return this.l;
        }

        public final int fs() {
            return this.w;
        }

        public boolean rv() {
            return this.oa != null;
        }

        public void tj() {
            this.oa.s(this);
        }

        public boolean cp() {
            return (this.tj & 32) != 0;
        }

        public void d() {
            this.tj &= -33;
        }

        public void oa() {
            this.tj &= -257;
        }

        public void n(cy cyVar, boolean z) {
            this.oa = cyVar;
            this.sz = z;
        }

        public boolean sz() {
            return (this.tj & 4) != 0;
        }

        public boolean k() {
            return (this.tj & 2) != 0;
        }

        public boolean cy() {
            return (this.tj & 1) != 0;
        }

        public boolean hd() {
            return (this.tj & 8) != 0;
        }

        public boolean n(int i) {
            return (i & this.tj) != 0;
        }

        public boolean cd() {
            return (this.tj & 256) != 0;
        }

        public boolean um() {
            return (this.tj & 512) != 0 || sz();
        }

        public void n(int i, int i2) {
            this.tj = (i & i2) | (this.tj & (~i2));
        }

        public void qg(int i) {
            this.tj = i | this.tj;
        }

        public void n(Object obj) {
            if (obj == null) {
                qg(1024);
            } else if ((1024 & this.tj) == 0) {
                t();
                this.cp.add(obj);
            }
        }

        private void t() {
            if (this.cp == null) {
                ArrayList arrayList = new ArrayList();
                this.cp = arrayList;
                this.d = Collections.unmodifiableList(arrayList);
            }
        }

        public void a() {
            List<Object> list = this.cp;
            if (list != null) {
                list.clear();
            }
            this.tj &= -1025;
        }

        public List<Object> py() {
            if ((this.tj & 1024) == 0) {
                List<Object> list = this.cp;
                return (list == null || list.size() == 0) ? hd : this.d;
            }
            return hd;
        }

        public void ou() {
            this.tj = 0;
            this.s = -1;
            this.q = -1;
            this.l = -1L;
            this.x = -1;
            this.cd = 0;
            this.fs = null;
            this.rv = null;
            a();
            this.um = 0;
            this.k = -1;
            RecyclerView.s(this);
        }

        public void n(RecyclerView recyclerView) {
            int i = this.k;
            if (i != -1) {
                this.um = i;
            } else {
                this.um = com.byazt.mgr.x.qg(this.n);
            }
            recyclerView.n(this, 4);
        }

        public void qg(RecyclerView recyclerView) {
            recyclerView.n(this, this.um);
            this.um = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.s + " id=" + this.l + ", oldPos=" + this.q + ", pLpos:" + this.x);
            if (rv()) {
                sb.append(" scrap ").append(this.sz ? "[changeScrap]" : "[attachedScrap]");
            }
            if (sz()) {
                sb.append(" invalid");
            }
            if (!cy()) {
                sb.append(" unbound");
            }
            if (k()) {
                sb.append(" update");
            }
            if (hd()) {
                sb.append(" removed");
            }
            if (X_()) {
                sb.append(" ignored");
            }
            if (cd()) {
                sb.append(" tmpDetached");
            }
            if (!wm()) {
                sb.append(" not recyclable(" + this.cd + ")");
            }
            if (um()) {
                sb.append(" undefined adapter position");
            }
            if (this.n.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void n(boolean z) {
            int i = this.cd;
            int i2 = z ? i - 1 : i + 1;
            this.cd = i2;
            if (i2 < 0) {
                this.cd = 0;
                com.byazt.tk.k.qg("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.tj |= 16;
            } else if (z && i2 == 0) {
                this.tj &= -17;
            }
        }

        public final boolean wm() {
            return (this.tj & 16) == 0 && !com.byazt.mgr.x.w(this.n);
        }

        public boolean m() {
            return (this.tj & 16) != 0;
        }

        public boolean hu() {
            return (this.tj & 16) == 0 && com.byazt.mgr.x.w(this.n);
        }

        public boolean h() {
            return (this.tj & 2) != 0;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2411})
    public static abstract class fs {
        @Deprecated
        public void n(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void n(Rect rect, View view, RecyclerView recyclerView, py pyVar) {
            n(rect, ((tj) view.getLayoutParams()).w(), recyclerView);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2535})
    public static abstract class rv {
        public a a;
        public com.byazt.prf.k cd;
        public com.byazt.prf.qg cy;
        public int fs;
        public RecyclerView hd;
        public boolean hu;
        public int l;
        public int m;
        public final com.byazt.prf.k.qg n;
        public boolean ou;
        public boolean py;
        public boolean q;
        public final com.byazt.prf.k.qg qg;
        public boolean s;
        public com.byazt.prf.k um;
        public int w;
        public boolean wm;
        public int x;

        public interface n {
            void qg(int i, int i2);
        }

        public int a() {
            return -1;
        }

        public boolean cp() {
            return false;
        }

        public void d(int i) {
        }

        public int fs(py pyVar) {
            return 0;
        }

        public int l(py pyVar) {
            return 0;
        }

        public void l(int i) {
        }

        public boolean l() {
            return false;
        }

        public int n(int i, cy cyVar, py pyVar) {
            return 0;
        }

        public View n(View view, int i, cy cyVar, py pyVar) {
            return null;
        }

        public abstract tj n();

        public void n(int i, int i2, py pyVar, n nVar) {
        }

        public void n(int i, n nVar) {
        }

        public void n(py pyVar) {
        }

        public void n(RecyclerView recyclerView) {
        }

        public void n(RecyclerView recyclerView, int i, int i2) {
        }

        public void n(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void n(RecyclerView recyclerView, int i, int i2, Object obj) {
        }

        public void n(RecyclerView recyclerView, cy cyVar) {
        }

        public boolean n(tj tjVar) {
            return tjVar != null;
        }

        public boolean n(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int q(py pyVar) {
            return 0;
        }

        public View q(View view, int i) {
            return null;
        }

        public void q(RecyclerView recyclerView) {
        }

        public boolean q() {
            return false;
        }

        public int qg(int i, cy cyVar, py pyVar) {
            return 0;
        }

        public void qg(RecyclerView recyclerView, int i, int i2) {
        }

        public boolean qg() {
            return false;
        }

        public int s(py pyVar) {
            return 0;
        }

        public int w(py pyVar) {
            return 0;
        }

        public int x(py pyVar) {
            return 0;
        }

        public rv() {
            com.byazt.prf.k.qg qgVar = new com.byazt.prf.k.qg() { // from class: com.byazt.prf.RecyclerView.rv.1
                @Override // com.byazt.prf.k.qg
                public View n(int i) {
                    return rv.this.rv(i);
                }

                @Override // com.byazt.prf.k.qg
                public int n() {
                    return rv.this.h();
                }

                @Override // com.byazt.prf.k.qg
                public int qg() {
                    return rv.this.m() - rv.this.ur();
                }

                @Override // com.byazt.prf.k.qg
                public int n(View view) {
                    return rv.this.fs(view) - ((tj) view.getLayoutParams()).leftMargin;
                }

                @Override // com.byazt.prf.k.qg
                public int qg(View view) {
                    return rv.this.tj(view) + ((tj) view.getLayoutParams()).rightMargin;
                }
            };
            this.n = qgVar;
            com.byazt.prf.k.qg qgVar2 = new com.byazt.prf.k.qg() { // from class: com.byazt.prf.RecyclerView.rv.2
                @Override // com.byazt.prf.k.qg
                public View n(int i) {
                    return rv.this.rv(i);
                }

                @Override // com.byazt.prf.k.qg
                public int n() {
                    return rv.this.t();
                }

                @Override // com.byazt.prf.k.qg
                public int qg() {
                    return rv.this.hu() - rv.this.bb();
                }

                @Override // com.byazt.prf.k.qg
                public int n(View view) {
                    return rv.this.rv(view) - ((tj) view.getLayoutParams()).topMargin;
                }

                @Override // com.byazt.prf.k.qg
                public int qg(View view) {
                    return rv.this.cp(view) + ((tj) view.getLayoutParams()).bottomMargin;
                }
            };
            this.qg = qgVar2;
            this.cd = new com.byazt.prf.k(qgVar);
            this.um = new com.byazt.prf.k(qgVar2);
            this.py = false;
            this.ou = false;
            this.wm = false;
            this.s = true;
            this.q = true;
        }

        public void qg(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.hd = null;
                this.cy = null;
                this.x = 0;
                this.fs = 0;
            } else {
                this.hd = recyclerView;
                this.cy = recyclerView.x;
                this.x = recyclerView.getWidth();
                this.fs = recyclerView.getHeight();
            }
            this.l = C.ENCODING_PCM_32BIT;
            this.w = C.ENCODING_PCM_32BIT;
        }

        public void s(int i, int i2) {
            this.x = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.l = mode;
            if (mode == 0 && !RecyclerView.qg) {
                this.x = 0;
            }
            this.fs = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.w = mode2;
            if (mode2 != 0 || RecyclerView.qg) {
                return;
            }
            this.fs = 0;
        }

        public void q(int i, int i2) {
            int iPy = py();
            if (iPy == 0) {
                this.hd.l(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iPy; i7++) {
                View viewRv = rv(i7);
                Rect rect = this.hd.cp;
                n(viewRv, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.hd.cp.set(i6, i4, i3, i5);
            n(this.hd.cp, i, i2);
        }

        public void n(Rect rect, int i, int i2) {
            w(n(i, rect.width() + h() + ur(), v()), n(i2, rect.height() + t() + bb(), j()));
        }

        public void sz() {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int n(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void n(String str) {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                recyclerView.n(str);
            }
        }

        public boolean s() {
            return this.wm;
        }

        public final boolean k() {
            return this.q;
        }

        public void s(RecyclerView recyclerView) {
            this.ou = true;
            q(recyclerView);
        }

        public void qg(RecyclerView recyclerView, cy cyVar) {
            this.ou = false;
            n(recyclerView, cyVar);
        }

        public boolean cy() {
            return this.ou;
        }

        public boolean n(Runnable runnable) {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public boolean hd() {
            RecyclerView recyclerView = this.hd;
            return recyclerView != null && recyclerView.rv;
        }

        public void n(cy cyVar, py pyVar) {
            com.byazt.tk.k.qg("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public tj n(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof tj) {
                return new tj((tj) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new tj((ViewGroup.MarginLayoutParams) layoutParams) : new tj(layoutParams);
        }

        public tj n(Context context, AttributeSet attributeSet) {
            return new tj(context, attributeSet);
        }

        public void n(RecyclerView recyclerView, py pyVar, int i) {
            com.byazt.tk.k.qg("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void n(a aVar) {
            a aVar2 = this.a;
            if (aVar2 != null && aVar != aVar2 && aVar2.x()) {
                this.a.l();
            }
            this.a = aVar;
            aVar.n(this.hd, this);
        }

        public boolean cd() {
            a aVar = this.a;
            return aVar != null && aVar.x();
        }

        public int um() {
            return com.byazt.mgr.x.n(this.hd);
        }

        public void n(View view) {
            n(view, -1);
        }

        public void n(View view, int i) {
            n(view, i, true);
        }

        public void qg(View view) {
            qg(view, -1);
        }

        public void qg(View view, int i) {
            n(view, i, false);
        }

        private void n(View view, int i, boolean z) {
            m mVarL = RecyclerView.l(view);
            if (!z && !mVarL.hd()) {
                this.hd.fs.w(mVarL);
            } else {
                this.hd.fs.l(mVarL);
            }
            tj tjVar = (tj) view.getLayoutParams();
            if (!mVarL.cp() && !mVarL.rv()) {
                if (view.getParent() == this.hd) {
                    int iQg = this.cy.qg(view);
                    if (i == -1) {
                        i = this.cy.qg();
                    }
                    if (iQg == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.hd.indexOfChild(view) + this.hd.n());
                    }
                    if (iQg != i) {
                        this.hd.sz.l(iQg, i);
                    }
                } else {
                    this.cy.n(view, i, false);
                    tjVar.l = true;
                    a aVar = this.a;
                    if (aVar != null && aVar.x()) {
                        this.a.qg(view);
                    }
                }
            } else {
                if (mVarL.rv()) {
                    mVarL.tj();
                } else {
                    mVarL.d();
                }
                this.cy.n(view, i, view.getLayoutParams(), false);
            }
            if (tjVar.w) {
                mVarL.n.invalidate();
                tjVar.w = false;
            }
        }

        public void s(View view) {
            this.cy.n(view);
        }

        public void x(int i) {
            if (rv(i) != null) {
                this.cy.n(i);
            }
        }

        public int q(View view) {
            return ((tj) view.getLayoutParams()).w();
        }

        public View l(View view) {
            View viewS;
            RecyclerView recyclerView = this.hd;
            if (recyclerView == null || (viewS = recyclerView.s(view)) == null || this.cy.s(viewS)) {
                return null;
            }
            return viewS;
        }

        public View s(int i) {
            int iPy = py();
            for (int i2 = 0; i2 < iPy; i2++) {
                View viewRv = rv(i2);
                m mVarL = RecyclerView.l(viewRv);
                if (mVarL != null && mVarL.q() == i && !mVarL.X_() && (this.hd.bb.n() || !mVarL.hd())) {
                    return viewRv;
                }
            }
            return null;
        }

        public void fs(int i) {
            n(i, rv(i));
        }

        private void n(int i, View view) {
            this.cy.l(i);
        }

        public void n(View view, int i, tj tjVar) {
            m mVarL = RecyclerView.l(view);
            if (mVarL.hd()) {
                this.hd.fs.l(mVarL);
            } else {
                this.hd.fs.w(mVarL);
            }
            this.cy.n(view, i, tjVar, mVarL.hd());
        }

        public void s(View view, int i) {
            n(view, i, (tj) view.getLayoutParams());
        }

        public void l(int i, int i2) {
            View viewRv = rv(i);
            if (viewRv == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.hd.toString());
            }
            fs(i);
            s(viewRv, i2);
        }

        public void n(View view, cy cyVar) {
            s(view);
            cyVar.n(view);
        }

        public void n(int i, cy cyVar) {
            View viewRv = rv(i);
            x(i);
            cyVar.n(viewRv);
        }

        public int py() {
            com.byazt.prf.qg qgVar = this.cy;
            if (qgVar != null) {
                return qgVar.qg();
            }
            return 0;
        }

        public View rv(int i) {
            com.byazt.prf.qg qgVar = this.cy;
            if (qgVar != null) {
                return qgVar.qg(i);
            }
            return null;
        }

        public int ou() {
            return this.l;
        }

        public int wm() {
            return this.w;
        }

        public int m() {
            return this.x;
        }

        public int hu() {
            return this.fs;
        }

        public int h() {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int t() {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int ur() {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int bb() {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View ln() {
            View focusedChild;
            RecyclerView recyclerView = this.hd;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.cy.s(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int lh() {
            RecyclerView recyclerView = this.hd;
            n adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.n();
            }
            return 0;
        }

        public void tj(int i) {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                recyclerView.w(i);
            }
        }

        public void cp(int i) {
            RecyclerView recyclerView = this.hd;
            if (recyclerView != null) {
                recyclerView.l(i);
            }
        }

        public void n(cy cyVar) {
            for (int iPy = py() - 1; iPy >= 0; iPy--) {
                n(cyVar, iPy, rv(iPy));
            }
        }

        private void n(cy cyVar, int i, View view) {
            m mVarL = RecyclerView.l(view);
            if (mVarL.X_()) {
                return;
            }
            if (mVarL.sz() && !mVarL.hd() && !this.hd.oa.qg()) {
                x(i);
                cyVar.qg(mVarL);
            } else {
                fs(i);
                cyVar.s(view);
                this.hd.fs.fs(mVarL);
            }
        }

        public void qg(cy cyVar) {
            int iL = cyVar.l();
            for (int i = iL - 1; i >= 0; i--) {
                View viewL = cyVar.l(i);
                m mVarL = RecyclerView.l(viewL);
                if (!mVarL.X_()) {
                    mVarL.n(false);
                    if (mVarL.cd()) {
                        this.hd.removeDetachedView(viewL, false);
                    }
                    if (this.hd.hu != null) {
                        this.hd.hu.q(mVarL);
                    }
                    mVarL.n(true);
                    cyVar.qg(viewL);
                }
            }
            cyVar.w();
            if (iL > 0) {
                this.hd.invalidate();
            }
        }

        public boolean n(View view, int i, int i2, tj tjVar) {
            return (this.s && qg(view.getMeasuredWidth(), i, tjVar.width) && qg(view.getMeasuredHeight(), i2, tjVar.height)) ? false : true;
        }

        public boolean qg(View view, int i, int i2, tj tjVar) {
            return (!view.isLayoutRequested() && this.s && qg(view.getWidth(), i, tjVar.width) && qg(view.getHeight(), i2, tjVar.height)) ? false : true;
        }

        private static boolean qg(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void n(View view, int i, int i2) {
            tj tjVar = (tj) view.getLayoutParams();
            Rect rectRv = this.hd.rv(view);
            int i3 = i + rectRv.left + rectRv.right;
            int i4 = i2 + rectRv.top + rectRv.bottom;
            int iN = n(m(), ou(), h() + ur() + tjVar.leftMargin + tjVar.rightMargin + i3, tjVar.width, q());
            int iN2 = n(hu(), wm(), t() + bb() + tjVar.topMargin + tjVar.bottomMargin + i4, tjVar.height, l());
            if (qg(view, iN, iN2, tjVar)) {
                view.measure(iN, iN2);
            }
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        /* JADX WARN: Code duplicated, block: B:13:0x001e  */
        /* JADX WARN: Code duplicated, block: B:19:0x002c  */
        public static int n(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = 1073741824;
                } else if (i4 == -1 && (i2 == Integer.MIN_VALUE || i2 == 1073741824)) {
                    i4 = iMax;
                } else {
                    i2 = 0;
                    i4 = 0;
                }
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 == -1) {
                i4 = iMax;
            } else if (i4 != -2) {
                i2 = 0;
                i4 = 0;
            } else if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                i4 = iMax;
                i2 = Integer.MIN_VALUE;
            } else {
                i4 = iMax;
                i2 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public int w(View view) {
            Rect rect = ((tj) view.getLayoutParams()).q;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int x(View view) {
            Rect rect = ((tj) view.getLayoutParams()).q;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void n(View view, int i, int i2, int i3, int i4) {
            tj tjVar = (tj) view.getLayoutParams();
            Rect rect = tjVar.q;
            view.layout(i + rect.left + tjVar.leftMargin, i2 + rect.top + tjVar.topMargin, (i3 - rect.right) - tjVar.rightMargin, (i4 - rect.bottom) - tjVar.bottomMargin);
        }

        public void n(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((tj) view.getLayoutParams()).q;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.hd != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.hd.d;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n(View view, Rect rect) {
            RecyclerView.n(view, rect);
        }

        public int fs(View view) {
            return view.getLeft() - sz(view);
        }

        public int rv(View view) {
            return view.getTop() - d(view);
        }

        public int tj(View view) {
            return view.getRight() + k(view);
        }

        public int cp(View view) {
            return view.getBottom() + oa(view);
        }

        public void qg(View view, Rect rect) {
            RecyclerView recyclerView = this.hd;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.rv(view));
            }
        }

        public int d(View view) {
            return ((tj) view.getLayoutParams()).q.top;
        }

        public int oa(View view) {
            return ((tj) view.getLayoutParams()).q.bottom;
        }

        public int sz(View view) {
            return ((tj) view.getLayoutParams()).q.left;
        }

        public int k(View view) {
            return ((tj) view.getLayoutParams()).q.right;
        }

        private int[] qg(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iH = h();
            int iT = t();
            int iM = m() - ur();
            int iHu = hu() - bb();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iH;
            int iMin = Math.min(0, i);
            int i2 = top - iT;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iM;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iHu);
            if (um() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean n(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return n(recyclerView, view, rect, z, false);
        }

        public boolean n(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrQg = qg(recyclerView, view, rect, z);
            int i = iArrQg[0];
            int i2 = iArrQg[1];
            if ((z2 && !s(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.n(i, i2);
            }
            return true;
        }

        public boolean n(View view, boolean z, boolean z2) {
            boolean z3 = this.cd.n(view, 24579) && this.um.n(view, 24579);
            if (z) {
                return z3;
            }
            return !z3;
        }

        private boolean s(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iH = h();
            int iT = t();
            int iM = m() - ur();
            int iHu = hu() - bb();
            Rect rect = this.hd.cp;
            n(focusedChild, rect);
            return rect.left - i < iM && rect.right - i > iH && rect.top - i2 < iHu && rect.bottom - i2 > iT;
        }

        @Deprecated
        public boolean n(RecyclerView recyclerView, View view, View view2) {
            return cd() || recyclerView.k();
        }

        public boolean n(RecyclerView recyclerView, py pyVar, View view, View view2) {
            return n(recyclerView, view, view2);
        }

        public void n(cy cyVar, py pyVar, int i, int i2) {
            this.hd.l(i, i2);
        }

        public void w(int i, int i2) {
            this.hd.setMeasuredDimension(i, i2);
        }

        public int v() {
            return com.byazt.mgr.x.q(this.hd);
        }

        public int j() {
            return com.byazt.mgr.x.l(this.hd);
        }

        public void an() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.l();
            }
        }

        public void qg(a aVar) {
            if (this.a == aVar) {
                this.a = null;
            }
        }

        public void s(cy cyVar) {
            for (int iPy = py() - 1; iPy >= 0; iPy--) {
                if (!RecyclerView.l(rv(iPy)).X_()) {
                    n(iPy, cyVar);
                }
            }
        }

        public void ae() {
            this.py = true;
        }

        public void l(RecyclerView recyclerView) {
            s(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), C.ENCODING_PCM_32BIT));
        }

        public boolean f() {
            int iPy = py();
            for (int i = 0; i < iPy; i++) {
                ViewGroup.LayoutParams layoutParams = rv(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1134})
    public static abstract class n<VH extends m> {
        public final qg n = new qg();
        public boolean qg = false;

        public abstract int n();

        public int n(int i) {
            return 0;
        }

        public abstract VH n(ViewGroup viewGroup, int i);

        public void n(VH vh) {
        }

        public abstract void n(VH vh, int i);

        public long qg(int i) {
            return -1L;
        }

        public boolean qg(VH vh) {
            return false;
        }

        public void n(VH vh, int i, List<Object> list) {
            n(vh, i);
        }

        public final VH qg(ViewGroup viewGroup, int i) {
            try {
                com.byazt.ybd.n.n("RV CreateView");
                VH vh = (VH) n(viewGroup, i);
                if (vh.n.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.w = i;
                com.byazt.ybd.n.n();
                return vh;
            } catch (Throwable th) {
                com.byazt.ybd.n.n();
                throw th;
            }
        }

        public final void qg(VH vh, int i) {
            vh.s = i;
            if (qg()) {
                vh.l = qg(i);
            }
            vh.n(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.byazt.ybd.n.n("RV OnBindView");
            n(vh, i, vh.py());
            vh.a();
            ViewGroup.LayoutParams layoutParams = vh.n.getLayoutParams();
            if (layoutParams instanceof tj) {
                ((tj) layoutParams).l = true;
            }
            com.byazt.ybd.n.n();
        }

        public final boolean qg() {
            return this.qg;
        }

        public void n(s sVar) {
            this.n.registerObserver(sVar);
        }

        public void qg(s sVar) {
            this.n.unregisterObserver(sVar);
        }

        public final void s() {
            this.n.n();
        }

        public final void n(int i, Object obj) {
            this.n.n(i, 1, obj);
        }

        public final void n(int i, int i2) {
            this.n.n(i, i2);
        }

        public final void qg(int i, int i2) {
            this.n.qg(i, i2);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2390})
    public final class cy {
        public int fs;
        public k l;
        public final ArrayList<m> n;
        public int q;
        public ArrayList<m> qg;
        public ou rv;
        public final ArrayList<m> s;
        public final List<m> x;

        public cy() {
            ArrayList<m> arrayList = new ArrayList<>();
            this.n = arrayList;
            this.qg = null;
            this.s = new ArrayList<>();
            this.x = Collections.unmodifiableList(arrayList);
            this.fs = 2;
            this.q = 2;
        }

        public void n() {
            this.n.clear();
            q();
        }

        public void n(int i) {
            this.fs = i;
            qg();
        }

        public void qg() {
            this.q = this.fs + (RecyclerView.this.sz != null ? RecyclerView.this.sz.m : 0);
            for (int size = this.s.size() - 1; size >= 0 && this.s.size() > this.q; size--) {
                q(size);
            }
        }

        public List<m> s() {
            return this.x;
        }

        public boolean n(m mVar) {
            if (mVar.hd()) {
                return RecyclerView.this.bb.n();
            }
            if (mVar.s >= 0 && mVar.s < RecyclerView.this.oa.n()) {
                if (RecyclerView.this.bb.n() || RecyclerView.this.oa.n(mVar.s) == mVar.fs()) {
                    return !RecyclerView.this.oa.qg() || mVar.x() == RecyclerView.this.oa.qg(mVar.s);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + mVar + RecyclerView.this.n());
        }

        private boolean n(m mVar, int i, int i2, long j) {
            mVar.cy = RecyclerView.this;
            int iFs = mVar.fs();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != LongCompanionObject.MAX_VALUE && !this.l.qg(iFs, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.oa.qg(mVar, i);
            this.l.qg(mVar.fs(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.bb.n()) {
                return true;
            }
            mVar.x = i2;
            return true;
        }

        public int qg(int i) {
            if (i < 0 || i >= RecyclerView.this.bb.l()) {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.bb.l() + RecyclerView.this.n());
            }
            return !RecyclerView.this.bb.n() ? i : RecyclerView.this.w.qg(i);
        }

        public View s(int i) {
            return n(i, false);
        }

        public View n(int i, boolean z) {
            return n(i, z, LongCompanionObject.MAX_VALUE).n;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x020f  */
        /* JADX WARN: Code duplicated, block: B:102:0x0217  */
        /* JADX WARN: Code duplicated, block: B:103:0x0225  */
        /* JADX WARN: Code duplicated, block: B:106:0x022b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:108:0x022e  */
        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0182 A[PHI: r1 r4
          0x0182: PHI (r1v18 com.byazt.prf.RecyclerView$m) = (r1v17 com.byazt.prf.RecyclerView$m), (r1v43 com.byazt.prf.RecyclerView$m) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:82:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:88:0x01d1  */
        /* JADX WARN: Code duplicated, block: B:90:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:99:0x0201  */
        public m n(int i, boolean z, long j) {
            m mVarQg;
            boolean z2;
            m mVar;
            boolean z3;
            boolean zN;
            ViewGroup.LayoutParams layoutParams;
            tj tjVar;
            int iQg;
            RecyclerView recyclerViewTj;
            ou ouVar;
            View viewN;
            if (i >= 0 && i < RecyclerView.this.bb.l()) {
                if (RecyclerView.this.bb.n()) {
                    mVarQg = w(i);
                    if (mVarQg != null) {
                        z2 = true;
                    }
                    if (mVarQg == null && (mVarQg = qg(i, z)) != null) {
                        if (n(mVarQg)) {
                            z2 = true;
                        } else {
                            if (!z) {
                                mVarQg.qg(4);
                                if (mVarQg.rv()) {
                                    RecyclerView.this.removeDetachedView(mVarQg.n, false);
                                    mVarQg.tj();
                                } else if (mVarQg.cp()) {
                                    mVarQg.d();
                                }
                                qg(mVarQg);
                            }
                            mVarQg = null;
                        }
                    }
                    if (mVarQg == null) {
                        mVar = mVarQg;
                    } else {
                        iQg = RecyclerView.this.w.qg(i);
                        if (iQg >= 0 || iQg >= RecyclerView.this.oa.n()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iQg + ").state:" + RecyclerView.this.bb.l() + RecyclerView.this.n());
                        }
                        int iN = RecyclerView.this.oa.n(iQg);
                        if (RecyclerView.this.oa.qg() && (mVarQg = n(RecyclerView.this.oa.qg(iQg), iN, z)) != null) {
                            mVarQg.s = iQg;
                            z2 = true;
                        }
                        if (mVarQg == null && (ouVar = this.rv) != null && (viewN = ouVar.n(this, i, iN)) != null) {
                            mVarQg = RecyclerView.this.qg(viewN);
                            if (mVarQg == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.n());
                            }
                            if (mVarQg.X_()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.n());
                            }
                        }
                        if (mVarQg == null) {
                            m mVarN = x().n(iN);
                            if (mVarN != null) {
                                mVarN.ou();
                                if (RecyclerView.n) {
                                    l(mVarN);
                                }
                            }
                            mVarQg = mVarN;
                        }
                        if (mVarQg == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j != LongCompanionObject.MAX_VALUE && !this.l.n(iN, nanoTime, j)) {
                                return null;
                            }
                            m mVarQg2 = RecyclerView.this.oa.qg(RecyclerView.this, iN);
                            if (RecyclerView.q && (recyclerViewTj = RecyclerView.tj(mVarQg2.n)) != null) {
                                mVarQg2.qg = new WeakReference<>(recyclerViewTj);
                            }
                            this.l.n(iN, RecyclerView.this.getNanoTime() - nanoTime);
                            mVar = mVarQg2;
                        } else {
                            mVar = mVarQg;
                        }
                    }
                    z3 = z2;
                    if (z3 && !RecyclerView.this.bb.n() && mVar.n(8192)) {
                        mVar.n(0, 8192);
                        if (RecyclerView.this.bb.tj) {
                            RecyclerView.this.n(mVar, RecyclerView.this.hu.n(RecyclerView.this.bb, mVar, w.l(mVar) | 4096, mVar.py()));
                        }
                    }
                    if (!RecyclerView.this.bb.n() && mVar.cy()) {
                        mVar.x = i;
                    } else {
                        if (mVar.cy() || mVar.k() || mVar.sz()) {
                            zN = n(mVar, RecyclerView.this.w.qg(i), i, j);
                        }
                        layoutParams = mVar.n.getLayoutParams();
                        if (layoutParams == null) {
                            tjVar = (tj) RecyclerView.this.generateDefaultLayoutParams();
                            mVar.n.setLayoutParams(tjVar);
                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                            tjVar = (tj) RecyclerView.this.generateLayoutParams(layoutParams);
                            mVar.n.setLayoutParams(tjVar);
                        } else {
                            tjVar = (tj) layoutParams;
                        }
                        tjVar.s = mVar;
                        tjVar.w = !z3 && zN;
                        return mVar;
                    }
                    zN = false;
                    layoutParams = mVar.n.getLayoutParams();
                    if (layoutParams == null) {
                        tjVar = (tj) RecyclerView.this.generateDefaultLayoutParams();
                        mVar.n.setLayoutParams(tjVar);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                        tjVar = (tj) RecyclerView.this.generateLayoutParams(layoutParams);
                        mVar.n.setLayoutParams(tjVar);
                    } else {
                        tjVar = (tj) layoutParams;
                    }
                    tjVar.s = mVar;
                    tjVar.w = !z3 && zN;
                    return mVar;
                }
                mVarQg = null;
                z2 = false;
                if (mVarQg == null) {
                    if (n(mVarQg)) {
                        if (!z) {
                            mVarQg.qg(4);
                            if (mVarQg.rv()) {
                                RecyclerView.this.removeDetachedView(mVarQg.n, false);
                                mVarQg.tj();
                            } else if (mVarQg.cp()) {
                                mVarQg.d();
                            }
                            qg(mVarQg);
                        }
                        mVarQg = null;
                    } else {
                        z2 = true;
                    }
                }
                if (mVarQg == null) {
                    iQg = RecyclerView.this.w.qg(i);
                    if (iQg >= 0) {
                    }
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iQg + ").state:" + RecyclerView.this.bb.l() + RecyclerView.this.n());
                }
                mVar = mVarQg;
                z3 = z2;
                if (z3) {
                    mVar.n(0, 8192);
                    if (RecyclerView.this.bb.tj) {
                        RecyclerView.this.n(mVar, RecyclerView.this.hu.n(RecyclerView.this.bb, mVar, w.l(mVar) | 4096, mVar.py()));
                    }
                }
                if (!RecyclerView.this.bb.n()) {
                    if (mVar.cy()) {
                    }
                    zN = n(mVar, RecyclerView.this.w.qg(i), i, j);
                } else {
                    if (mVar.cy()) {
                    }
                    zN = n(mVar, RecyclerView.this.w.qg(i), i, j);
                }
                layoutParams = mVar.n.getLayoutParams();
                if (layoutParams == null) {
                    tjVar = (tj) RecyclerView.this.generateDefaultLayoutParams();
                    mVar.n.setLayoutParams(tjVar);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                    tjVar = (tj) RecyclerView.this.generateLayoutParams(layoutParams);
                    mVar.n.setLayoutParams(tjVar);
                } else {
                    tjVar = (tj) layoutParams;
                }
                tjVar.s = mVar;
                tjVar.w = !z3 && zN;
                return mVar;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.bb.l() + RecyclerView.this.n());
        }

        private void l(m mVar) {
            if (mVar.n instanceof ViewGroup) {
                n((ViewGroup) mVar.n, false);
            }
        }

        private void n(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    n((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void n(View view) {
            m mVarL = RecyclerView.l(view);
            if (mVarL.cd()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (mVarL.rv()) {
                mVarL.tj();
            } else if (mVarL.cp()) {
                mVarL.d();
            }
            qg(mVarL);
        }

        public void q() {
            for (int size = this.s.size() - 1; size >= 0; size--) {
                q(size);
            }
            this.s.clear();
            if (RecyclerView.q) {
                RecyclerView.this.ur.n();
            }
        }

        public void q(int i) {
            n(this.s.get(i), true);
            this.s.remove(i);
        }

        public void qg(m mVar) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (!mVar.rv() && mVar.n.getParent() == null) {
                if (mVar.cd()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + mVar + RecyclerView.this.n());
                }
                if (mVar.X_()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.n());
                }
                boolean zHu = mVar.hu();
                if ((RecyclerView.this.oa != null && zHu && RecyclerView.this.oa.qg(mVar)) || mVar.wm()) {
                    if (this.q <= 0 || mVar.n(526)) {
                        z = false;
                    } else {
                        int size = this.s.size();
                        if (size >= this.q && size > 0) {
                            q(0);
                            size--;
                        }
                        if (RecyclerView.q && size > 0 && !RecyclerView.this.ur.n(mVar.s)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.ur.n(this.s.get(i).s)) {
                                    break;
                                } else {
                                    i--;
                                }
                            }
                            size = i + 1;
                        }
                        this.s.add(size, mVar);
                        z = true;
                    }
                    if (z) {
                        z3 = false;
                    } else {
                        n(mVar, true);
                    }
                    z2 = z;
                } else {
                    z3 = false;
                }
                RecyclerView.this.fs.x(mVar);
                if (z2 || z3 || !zHu) {
                    return;
                }
                mVar.cy = null;
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + mVar.rv() + " isAttached:" + (mVar.n.getParent() != null) + RecyclerView.this.n());
        }

        public void n(m mVar, boolean z) {
            RecyclerView.s(mVar);
            if (mVar.n(16384)) {
                mVar.n(0, 16384);
            }
            if (z) {
                q(mVar);
            }
            mVar.cy = null;
            x().n(mVar);
        }

        public void qg(View view) {
            m mVarL = RecyclerView.l(view);
            mVarL.oa = null;
            mVarL.sz = false;
            mVarL.d();
            qg(mVarL);
        }

        public void s(View view) {
            m mVarL = RecyclerView.l(view);
            if (!mVarL.n(12) && mVarL.h() && !RecyclerView.this.qg(mVarL)) {
                if (this.qg == null) {
                    this.qg = new ArrayList<>();
                }
                mVarL.n(this, true);
                this.qg.add(mVarL);
                return;
            }
            if (mVarL.sz() && !mVarL.hd() && !RecyclerView.this.oa.qg()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.n());
            }
            mVarL.n(this, false);
            this.n.add(mVarL);
        }

        public void s(m mVar) {
            if (mVar.sz) {
                this.qg.remove(mVar);
            } else {
                this.n.remove(mVar);
            }
            mVar.oa = null;
            mVar.sz = false;
            mVar.d();
        }

        public int l() {
            return this.n.size();
        }

        public View l(int i) {
            return this.n.get(i).n;
        }

        public void w() {
            this.n.clear();
            ArrayList<m> arrayList = this.qg;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public m w(int i) {
            int size;
            int iQg;
            ArrayList<m> arrayList = this.qg;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    m mVar = this.qg.get(i2);
                    if (!mVar.cp() && mVar.q() == i) {
                        mVar.qg(32);
                        return mVar;
                    }
                }
                if (RecyclerView.this.oa.qg() && (iQg = RecyclerView.this.w.qg(i)) > 0 && iQg < RecyclerView.this.oa.n()) {
                    long jQg = RecyclerView.this.oa.qg(iQg);
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar2 = this.qg.get(i3);
                        if (!mVar2.cp() && mVar2.x() == jQg) {
                            mVar2.qg(32);
                            return mVar2;
                        }
                    }
                }
            }
            return null;
        }

        public m qg(int i, boolean z) {
            View viewS;
            int size = this.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar = this.n.get(i2);
                if (!mVar.cp() && mVar.q() == i && !mVar.sz() && (RecyclerView.this.bb.x || !mVar.hd())) {
                    mVar.qg(32);
                    return mVar;
                }
            }
            if (!z && (viewS = RecyclerView.this.x.s(i)) != null) {
                m mVarL = RecyclerView.l(viewS);
                RecyclerView.this.x.l(viewS);
                int iQg = RecyclerView.this.x.qg(viewS);
                if (iQg == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + mVarL + RecyclerView.this.n());
                }
                RecyclerView.this.x.l(iQg);
                s(viewS);
                mVarL.qg(8224);
                return mVarL;
            }
            int size2 = this.s.size();
            for (int i3 = 0; i3 < size2; i3++) {
                m mVar2 = this.s.get(i3);
                if (!mVar2.sz() && mVar2.q() == i) {
                    if (!z) {
                        this.s.remove(i3);
                    }
                    return mVar2;
                }
            }
            return null;
        }

        public m n(long j, int i, boolean z) {
            for (int size = this.n.size() - 1; size >= 0; size--) {
                m mVar = this.n.get(size);
                if (mVar.x() == j && !mVar.cp()) {
                    if (i == mVar.fs()) {
                        mVar.qg(32);
                        if (mVar.hd() && !RecyclerView.this.bb.n()) {
                            mVar.n(2, 14);
                        }
                        return mVar;
                    }
                    if (!z) {
                        this.n.remove(size);
                        RecyclerView.this.removeDetachedView(mVar.n, false);
                        qg(mVar.n);
                    }
                }
            }
            int size2 = this.s.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                m mVar2 = this.s.get(size2);
                if (mVar2.x() == j) {
                    if (i == mVar2.fs()) {
                        if (!z) {
                            this.s.remove(size2);
                        }
                        return mVar2;
                    }
                    if (!z) {
                        q(size2);
                        return null;
                    }
                }
            }
        }

        public void q(m mVar) {
            if (RecyclerView.this.oa != null) {
                RecyclerView.this.oa.n(mVar);
            }
            if (RecyclerView.this.bb != null) {
                RecyclerView.this.fs.x(mVar);
            }
        }

        public void n(n nVar, n nVar2, boolean z) {
            n();
            x().n(nVar, nVar2, z);
        }

        public void n(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.s.size();
            for (int i6 = 0; i6 < size; i6++) {
                m mVar = this.s.get(i6);
                if (mVar != null && mVar.s >= i5 && mVar.s <= i4) {
                    if (mVar.s == i) {
                        mVar.n(i2 - i, false);
                    } else {
                        mVar.n(i3, false);
                    }
                }
            }
        }

        public void qg(int i, int i2) {
            int size = this.s.size();
            for (int i3 = 0; i3 < size; i3++) {
                m mVar = this.s.get(i3);
                if (mVar != null && mVar.s >= i) {
                    mVar.n(i2, true);
                }
            }
        }

        public void n(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.s.size() - 1; size >= 0; size--) {
                m mVar = this.s.get(size);
                if (mVar != null) {
                    if (mVar.s >= i3) {
                        mVar.n(-i2, z);
                    } else if (mVar.s >= i) {
                        mVar.qg(8);
                        q(size);
                    }
                }
            }
        }

        public void n(ou ouVar) {
            this.rv = ouVar;
        }

        public void n(k kVar) {
            k kVar2 = this.l;
            if (kVar2 != null) {
                kVar2.s();
            }
            this.l = kVar;
            if (kVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.l.qg();
        }

        public k x() {
            if (this.l == null) {
                this.l = new k();
            }
            return this.l;
        }

        public void s(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.s.size() - 1; size >= 0; size--) {
                m mVar = this.s.get(size);
                if (mVar != null && (i3 = mVar.s) >= i && i3 < i4) {
                    mVar.qg(2);
                    q(size);
                }
            }
        }

        public void fs() {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                m mVar = this.s.get(i);
                if (mVar != null) {
                    mVar.qg(6);
                    mVar.n((Object) null);
                }
            }
            if (RecyclerView.this.oa == null || !RecyclerView.this.oa.qg()) {
                q();
            }
        }

        public void rv() {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                this.s.get(i).n();
            }
            int size2 = this.n.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.n.get(i2).n();
            }
            ArrayList<m> arrayList = this.qg;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.qg.get(i3).n();
                }
            }
        }

        public void tj() {
            int size = this.s.size();
            for (int i = 0; i < size; i++) {
                tj tjVar = (tj) this.s.get(i).n.getLayoutParams();
                if (tjVar != null) {
                    tjVar.l = true;
                }
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1130})
    public static class k {
        public SparseArray<n> n = new SparseArray<>();
        public int qg = 0;

        @com.byazt.cp.n(n = {0, 1, 102, 901})
        static class n {
            public final ArrayList<m> n = new ArrayList<>();
            public int qg = 5;
            public long s = 0;
            public long q = 0;
        }

        public void n() {
            for (int i = 0; i < this.n.size(); i++) {
                this.n.valueAt(i).n.clear();
            }
        }

        public m n(int i) {
            n nVar = this.n.get(i);
            if (nVar == null || nVar.n.isEmpty()) {
                return null;
            }
            ArrayList<m> arrayList = nVar.n;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void n(m mVar) {
            int iFs = mVar.fs();
            ArrayList<m> arrayList = qg(iFs).n;
            if (this.n.get(iFs).qg > arrayList.size()) {
                mVar.ou();
                arrayList.add(mVar);
            }
        }

        public long n(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void n(int i, long j) {
            n nVarQg = qg(i);
            nVarQg.s = n(nVarQg.s, j);
        }

        public void qg(int i, long j) {
            n nVarQg = qg(i);
            nVarQg.q = n(nVarQg.q, j);
        }

        public boolean n(int i, long j, long j2) {
            long j3 = qg(i).s;
            return j3 == 0 || j + j3 < j2;
        }

        public boolean qg(int i, long j, long j2) {
            long j3 = qg(i).q;
            return j3 == 0 || j + j3 < j2;
        }

        public void qg() {
            this.qg++;
        }

        public void s() {
            this.qg--;
        }

        public void n(n nVar, n nVar2, boolean z) {
            if (nVar != null) {
                s();
            }
            if (!z && this.qg == 0) {
                n();
            }
            if (nVar2 != null) {
                qg();
            }
        }

        private n qg(int i) {
            n nVar = this.n.get(i);
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n();
            this.n.put(i, nVar2);
            return nVar2;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1132})
    public static class l {
        public EdgeEffect n(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2389})
    private class cd extends s {
        public cd() {
        }

        @Override // com.byazt.prf.RecyclerView.s
        public void n() {
            RecyclerView.this.n((String) null);
            RecyclerView.this.bb.w = true;
            RecyclerView.this.s(true);
            if (RecyclerView.this.w.q()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.byazt.prf.RecyclerView.s
        public void n(int i, int i2, Object obj) {
            RecyclerView.this.n((String) null);
            if (RecyclerView.this.w.n(i, i2, obj)) {
                qg();
            }
        }

        @Override // com.byazt.prf.RecyclerView.s
        public void n(int i, int i2) {
            RecyclerView.this.n((String) null);
            if (RecyclerView.this.w.qg(i, i2)) {
                qg();
            }
        }

        public void qg() {
            if (RecyclerView.s && RecyclerView.this.cd && RecyclerView.this.hd) {
                RecyclerView recyclerView = RecyclerView.this;
                com.byazt.mgr.x.n(recyclerView, recyclerView.tj);
            } else {
                RecyclerView.this.ou = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 102, 2553})
    class wm implements Runnable {
        public int l;
        public OverScroller n;
        public int q;
        public Interpolator qg = RecyclerView.f;
        public boolean w = false;
        public boolean x = false;

        public wm() {
            this.n = new OverScroller(RecyclerView.this.getContext(), RecyclerView.f);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ec  */
        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            if (RecyclerView.this.sz == null) {
                qg();
                return;
            }
            s();
            RecyclerView.this.l();
            OverScroller overScroller = this.n;
            a aVar = RecyclerView.this.sz.a;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.j;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.q;
                int i7 = currY - this.l;
                this.q = currX;
                this.l = currY;
                if (RecyclerView.this.n(i6, i7, iArr, null, 1)) {
                    i6 -= iArr[0];
                    i7 -= iArr[1];
                }
                if (RecyclerView.this.oa != null) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.n(i6, i7, recyclerView.an);
                    i = RecyclerView.this.an[0];
                    i2 = RecyclerView.this.an[1];
                    i3 = i6 - i;
                    i4 = i7 - i2;
                    if (aVar != null && !aVar.w() && aVar.x()) {
                        int iL = RecyclerView.this.bb.l();
                        if (iL == 0) {
                            aVar.l();
                        } else {
                            if (aVar.fs() >= iL) {
                                aVar.s(iL - 1);
                            }
                            aVar.n(i6 - i3, i7 - i4);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.cy.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.s(i6, i7);
                }
                if (!RecyclerView.this.n(i, i2, i3, i4, (int[]) null, 1) && (i3 != 0 || i4 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i3 == currX) {
                        i5 = 0;
                    } else if (i3 < 0) {
                        i5 = -currVelocity;
                    } else if (i3 > 0) {
                        i5 = currVelocity;
                    } else {
                        i5 = 0;
                    }
                    if (i4 == currY) {
                        currVelocity = 0;
                    } else if (i4 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i4 <= 0) {
                        currVelocity = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.q(i5, currVelocity);
                    }
                    if ((i5 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (i != 0 || i2 != 0) {
                    RecyclerView.this.fs(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i6 == 0 && i7 == 0) || (i6 != 0 && RecyclerView.this.sz.q() && i == i6) || (i7 != 0 && RecyclerView.this.sz.l() && i2 == i7);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.rv(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.q) {
                        RecyclerView.this.ur.n();
                    }
                    RecyclerView.this.fs(1);
                } else {
                    n();
                    if (RecyclerView.this.t != null) {
                        RecyclerView.this.t.n(RecyclerView.this, i6, i7);
                    }
                }
            }
            if (aVar != null) {
                if (aVar.w()) {
                    aVar.n(0, 0);
                }
                if (!this.x) {
                    aVar.l();
                }
            }
            q();
        }

        private void s() {
            this.x = false;
            this.w = true;
        }

        private void q() {
            this.w = false;
            if (this.x) {
                n();
            }
        }

        public void n() {
            if (this.w) {
                this.x = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.byazt.mgr.x.n(RecyclerView.this, this);
            }
        }

        public void n(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.l = 0;
            this.q = 0;
            this.n.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            n();
        }

        public void qg(int i, int i2) {
            n(i, i2, 0, 0);
        }

        public void n(int i, int i2, int i3, int i4) {
            n(i, i2, qg(i, i2, i3, i4));
        }

        private float n(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int qg(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fN = f2 + (n(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fN / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void n(int i, int i2, int i3) {
            n(i, i2, i3, RecyclerView.f);
        }

        public void n(int i, int i2, Interpolator interpolator) {
            int iQg = qg(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.f;
            }
            n(i, i2, iQg, interpolator);
        }

        public void n(int i, int i2, int i3, Interpolator interpolator) {
            if (this.qg != interpolator) {
                this.qg = interpolator;
                this.n = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.l = 0;
            this.q = 0;
            this.n.startScroll(0, 0, i, i2, i3);
            n();
        }

        public void qg() {
            RecyclerView.this.removeCallbacks(this);
            this.n.abortAnimation();
        }
    }
}
