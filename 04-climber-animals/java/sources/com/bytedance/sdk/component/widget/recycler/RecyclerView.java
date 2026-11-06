package com.bytedance.sdk.component.widget.recycler;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.ms.ah.ah {
    com.bytedance.sdk.component.widget.recycler.xr ab;
    private int am;
    final ArrayList<x> ao;
    boolean b;
    private int bz;
    com.bytedance.sdk.component.widget.recycler.ms c;
    private int ce;
    final Runnable ch;
    final t cv;
    private final int[] ec;
    private final qv eg;
    final List<re> f;
    private final Rect fm;
    boolean g;
    private final int[] gs;
    private VelocityTracker gy;
    boolean h;
    final Rect hi;
    boolean i;
    private final int ih;
    private zb il;
    private final int j;
    private int jm;
    final int[] jw;
    private sl jy;
    final ao ka;
    private final int[] kl;
    private boolean l;
    com.bytedance.sdk.component.widget.recycler.d.ms le;
    private d n;
    private final com.bytedance.sdk.component.widget.recycler.u.xr nl;
    private List<u> nn;
    boolean nw;
    boolean ny;
    private c.ms o;
    boolean of;
    private float oh;
    com.bytedance.sdk.component.widget.recycler.d op;
    boolean p;
    final int[] pc;
    private int qf;
    private EdgeEffect qk;
    private int qr;
    boolean qv;
    private Runnable r;
    boolean re;
    private EdgeEffect rt;
    private int s;
    private final AccessibilityManager sa;
    private int sk;
    final RectF sl;
    boolean t;
    private int ti;
    private u tk;
    private List<hi> tz;
    ny u;
    h ub;
    private ka v;
    private com.bytedance.sdk.component.widget.recycler.ms.ah.d vf;
    private int vl;
    private EdgeEffect vm;
    private int vy;
    c w;
    final com.bytedance.sdk.component.widget.recycler.u x;
    private final ArrayList<zb> xn;
    boolean y;
    final b yu;
    private boolean z;
    ms zb;
    private float zd;
    private EdgeEffect zf;
    private static final int[] az = {R.attr.nestedScrollingEnabled};
    private static final int[] m = {R.attr.clipToPadding};

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final boolean f1374ms = false;
    static final boolean xr = true;
    static final boolean ah = true;
    static final boolean d = true;
    private static final boolean lm = false;
    private static final boolean e = false;
    private static final Class<?>[] k = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final Interpolator ul = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    public static abstract class ah {
        public void ms() {
        }

        public void ms(int i, int i2, Object obj) {
        }
    }

    public interface d {
        int ms(int i, int i2);
    }

    public interface h {
    }

    public interface hi {
        void ms(View view);

        void xr(View view);
    }

    public static abstract class nw {
        public abstract View ms(ao aoVar, int i, int i2);
    }

    public static abstract class sl {
        public abstract boolean ms(int i, int i2);
    }

    public static abstract class u {
        public void ms(RecyclerView recyclerView, int i) {
        }

        public void ms(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public interface zb {
        boolean ms(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eg = new qv();
        this.ka = new ao();
        this.x = new com.bytedance.sdk.component.widget.recycler.u();
        this.ch = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.y || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.h) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.nw) {
                    RecyclerView.this.t = true;
                } else {
                    RecyclerView.this.d();
                }
            }
        };
        this.hi = new Rect();
        this.fm = new Rect();
        this.sl = new RectF();
        this.ao = new ArrayList<>();
        this.xn = new ArrayList<>();
        this.qf = 0;
        this.re = false;
        this.i = false;
        this.ti = 0;
        this.s = 0;
        this.v = new ka();
        this.w = new com.bytedance.sdk.component.widget.recycler.ah();
        this.vy = 0;
        this.sk = -1;
        this.oh = Float.MIN_VALUE;
        this.zd = Float.MIN_VALUE;
        this.z = true;
        this.yu = new b();
        this.le = d ? new com.bytedance.sdk.component.widget.recycler.d.ms() : null;
        this.cv = new t();
        this.g = false;
        this.of = false;
        this.o = new ab();
        this.p = false;
        this.ec = new int[2];
        this.kl = new int[2];
        this.pc = new int[2];
        this.gs = new int[2];
        this.jw = new int[2];
        this.f = new ArrayList();
        this.r = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.w != null) {
                    RecyclerView.this.w.ms();
                }
                RecyclerView.this.p = false;
            }
        };
        this.nl = new com.bytedance.sdk.component.widget.recycler.u.xr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.u.xr
            public void ms(re reVar, c.xr xrVar, c.xr xrVar2) {
                RecyclerView.this.ka.ah(reVar);
                RecyclerView.this.xr(reVar, xrVar, xrVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.xr
            public void xr(re reVar, c.xr xrVar, c.xr xrVar2) {
                RecyclerView.this.ms(reVar, xrVar, xrVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.xr
            public void ah(re reVar, c.xr xrVar, c.xr xrVar2) {
                reVar.ms(false);
                if (RecyclerView.this.re) {
                    if (RecyclerView.this.w.ms(reVar, reVar, xrVar, xrVar2)) {
                        RecyclerView.this.ub();
                    }
                } else if (RecyclerView.this.w.ah(reVar, xrVar, xrVar2)) {
                    RecyclerView.this.ub();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.u.xr
            public void ms(re reVar) {
                RecyclerView.this.u.ms(reVar.f1391ms, RecyclerView.this.ka);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m, i, 0);
                this.ny = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.sl.ms(e2);
            }
        } else {
            this.ny = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.bz = viewConfiguration.getScaledTouchSlop();
        this.oh = com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(viewConfiguration, context);
        this.zd = com.bytedance.sdk.component.widget.recycler.ms.ah.ab.xr(viewConfiguration, context);
        this.j = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ih = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.w.ms(this.o);
        xr();
        w();
        i();
        if (com.bytedance.sdk.component.widget.recycler.ms.ah.ab.xr(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(this, 1);
        }
        this.sa = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
        setNestedScrollingEnabled(true);
    }

    String ms() {
        return " " + super.toString() + ", adapter:" + this.zb + ", layout:" + this.u + ", context:" + getContext();
    }

    private void i() {
        if (com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ny(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.ms.ah.ab.xr(this, 8);
        }
    }

    private void w() {
        this.ab = new com.bytedance.sdk.component.widget.recycler.xr(new com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public int ms() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void ms(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.sl(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public int ms(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void ms(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.hi(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public View xr(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void xr() {
                int iMs = ms();
                for (int i = 0; i < iMs; i++) {
                    View viewXr = xr(i);
                    RecyclerView.this.hi(viewXr);
                    viewXr.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public re xr(View view) {
                return RecyclerView.ka(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void ms(View view, int i, ViewGroup.LayoutParams layoutParams) {
                re reVarKa = RecyclerView.ka(view);
                if (reVarKa != null) {
                    if (!reVarKa.qv() && !reVarKa.M_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + reVarKa + RecyclerView.this.ms());
                    }
                    reVarKa.zb();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void ah(int i) {
                re reVarKa;
                View viewXr = xr(i);
                if (viewXr != null && (reVarKa = RecyclerView.ka(viewXr)) != null) {
                    if (reVarKa.qv() && !reVarKa.M_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + reVarKa + RecyclerView.this.ms());
                    }
                    reVarKa.xr(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void ah(View view) {
                re reVarKa = RecyclerView.ka(view);
                if (reVarKa != null) {
                    reVarKa.ms(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.xr.InterfaceC0253xr
            public void d(View view) {
                re reVarKa = RecyclerView.ka(view);
                if (reVarKa != null) {
                    reVarKa.xr(RecyclerView.this);
                }
            }
        });
    }

    void xr() {
        this.c = new com.bytedance.sdk.component.widget.recycler.ms(new com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms
            public re ms(int i) {
                re reVarMs = RecyclerView.this.ms(i, true);
                if (reVarMs == null || RecyclerView.this.ab.ah(reVarMs.f1391ms)) {
                    return null;
                }
                return reVarMs;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms
            public void ms(int i, int i2) {
                RecyclerView.this.ms(i, i2, true);
                RecyclerView.this.g = true;
                RecyclerView.this.cv.ah += i2;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms
            public void xr(int i, int i2) {
                RecyclerView.this.ms(i, i2, false);
                RecyclerView.this.g = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms
            public void ms(int i, int i2, Object obj) {
                RecyclerView.this.ms(i, i2, obj);
                RecyclerView.this.of = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms
            public void ah(int i, int i2) {
                RecyclerView.this.ab(i, i2);
                RecyclerView.this.g = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.ms.InterfaceC0252ms
            public void d(int i, int i2) {
                RecyclerView.this.c(i, i2);
                RecyclerView.this.g = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.qv = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.ny) {
            hi();
        }
        this.ny = z;
        super.setClipToPadding(z);
        if (this.y) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.ny;
    }

    public void setAdapter(ms msVar) {
        setLayoutFrozen(false);
        ms(msVar, false, true);
        ah(false);
        requestLayout();
    }

    void ah() {
        c cVar = this.w;
        if (cVar != null) {
            cVar.d();
        }
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.ah(this.ka);
            this.u.xr(this.ka);
        }
        this.ka.ms();
    }

    private void ms(ms msVar, boolean z, boolean z2) {
        ms msVar2 = this.zb;
        if (msVar2 != null) {
            msVar2.xr(this.eg);
        }
        if (!z || z2) {
            ah();
        }
        this.c.ms();
        ms msVar3 = this.zb;
        this.zb = msVar;
        if (msVar != null) {
            msVar.ms(this.eg);
        }
        this.ka.ms(msVar3, this.zb, z);
        this.cv.c = true;
    }

    public ms getAdapter() {
        return this.zb;
    }

    public void setRecyclerListener(h hVar) {
        this.ub = hVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        ny nyVar = this.u;
        return nyVar != null ? nyVar.qv() : super.getBaseline();
    }

    public void ms(hi hiVar) {
        if (this.tz == null) {
            this.tz = new ArrayList();
        }
        this.tz.add(hiVar);
    }

    public void setLayoutManager(ny nyVar) {
        if (nyVar != this.u) {
            c();
            if (this.u != null) {
                c cVar = this.w;
                if (cVar != null) {
                    cVar.d();
                }
                this.u.ah(this.ka);
                this.u.xr(this.ka);
                this.ka.ms();
                if (this.h) {
                    this.u.xr(this, this.ka);
                }
                this.u.ms((RecyclerView) null);
                this.u = null;
            } else {
                this.ka.ms();
            }
            this.ab.ms();
            this.u = nyVar;
            if (nyVar != null) {
                if (nyVar.ny != null) {
                    throw new IllegalArgumentException("LayoutManager " + nyVar + " is already attached to a RecyclerView:" + nyVar.ny.ms());
                }
                this.u.ms(this);
                if (this.h) {
                    this.u.xr(this);
                }
            }
            this.ka.xr();
            requestLayout();
        }
    }

    public void setOnFlingListener(sl slVar) {
        this.jy = slVar;
    }

    public sl getOnFlingListener() {
        return this.jy;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void ka(re reVar) {
        View view = reVar.f1391ms;
        boolean z = view.getParent() == this;
        this.ka.ah(xr(view));
        if (reVar.qv()) {
            this.ab.ms(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.ab.ms(view, true);
        } else {
            this.ab.d(view);
        }
    }

    boolean ms(View view) {
        ka();
        boolean zC = this.ab.c(view);
        if (zC) {
            re reVarKa = ka(view);
            this.ka.ah(reVarKa);
            this.ka.xr(reVarKa);
        }
        ms(!zC);
        return zC;
    }

    public ny getLayoutManager() {
        return this.u;
    }

    public ub getRecycledViewPool() {
        return this.ka.ab();
    }

    public void setRecycledViewPool(ub ubVar) {
        this.ka.ms(ubVar);
    }

    public void setViewCacheExtension(nw nwVar) {
        this.ka.ms(nwVar);
    }

    public void setItemViewCacheSize(int i) {
        this.ka.ms(i);
    }

    public int getScrollState() {
        return this.vy;
    }

    void setScrollState(int i) {
        if (i != this.vy) {
            this.vy = i;
            if (i != 2) {
                op();
            }
            ab(i);
        }
    }

    public void ms(x xVar, int i) {
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.ms("Cannot add item decoration during a scroll  or layout");
        }
        if (this.ao.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.ao.add(xVar);
        } else {
            this.ao.add(i, xVar);
        }
        h();
        requestLayout();
    }

    public void ms(x xVar) {
        ms(xVar, -1);
    }

    public int getItemDecorationCount() {
        return this.ao.size();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.n) {
            this.n = dVar;
            setChildrenDrawingOrderEnabled(dVar != null);
        }
    }

    public void ms(u uVar) {
        if (this.nn == null) {
            this.nn = new ArrayList();
        }
        this.nn.add(uVar);
    }

    public void xr(u uVar) {
        List<u> list = this.nn;
        if (list != null) {
            list.remove(uVar);
        }
    }

    void ms(int i) {
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.d(i);
            awakenScrollBars();
        }
    }

    public void xr(int i) {
        if (this.nw) {
            return;
        }
        ny nyVar = this.u;
        if (nyVar == null) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            nyVar.ms(this, this.cv, i);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        ny nyVar = this.u;
        if (nyVar == null) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.nw) {
            return;
        }
        boolean zAh = nyVar.ah();
        boolean zD = this.u.d();
        if (zAh || zD) {
            if (!zAh) {
                i = 0;
            }
            if (!zD) {
                i2 = 0;
            }
            ms(i, i2, (MotionEvent) null);
        }
    }

    void ms(int i, int i2, int[] iArr) {
        ka();
        sl();
        com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV Scroll");
        ms(this.cv);
        int iMs = i != 0 ? this.u.ms(i, this.ka, this.cv) : 0;
        int iXr = i2 != 0 ? this.u.xr(i2, this.ka, this.cv) : 0;
        com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
        b();
        zb();
        ms(false);
        if (iArr != null) {
            iArr[0] = iMs;
            iArr[1] = iXr;
        }
    }

    void d() {
        if (this.y && !this.re) {
            if (!this.c.d()) {
                return;
            }
            if (this.c.ms(4) && !this.c.ms(11)) {
                com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV PartialInvalidate");
                ka();
                sl();
                this.c.xr();
                if (!this.t) {
                    if (yu()) {
                        ao();
                    } else {
                        this.c.ah();
                    }
                }
                ms(true);
                zb();
                com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
                return;
            }
            if (!this.c.d()) {
                return;
            }
        }
        com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV FullInvalidate");
        ao();
        com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
    }

    private boolean yu() {
        int iXr = this.ab.xr();
        for (int i = 0; i < iXr; i++) {
            re reVarKa = ka(this.ab.xr(i));
            if (reVarKa != null && !reVarKa.M_() && reVarKa.yu()) {
                return true;
            }
        }
        return false;
    }

    boolean ms(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        d();
        if (this.zb != null) {
            ms(i, i2, this.jw);
            int[] iArr = this.jw;
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
        if (!this.ao.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (ms(i5, i4, i6, i3, this.kl, 0)) {
            int i10 = this.ce;
            int[] iArr2 = this.kl;
            int i11 = iArr2[0];
            this.ce = i10 - i11;
            int i12 = this.jm;
            int i13 = iArr2[1];
            this.jm = i12 - i13;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i11, i13);
            }
            int[] iArr3 = this.gs;
            int i14 = iArr3[0];
            int[] iArr4 = this.kl;
            iArr3[0] = i14 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(motionEvent, 8194)) {
                ms(motionEvent.getX(), i6, motionEvent.getY(), i9);
            }
            ah(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            x(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        ny nyVar = this.u;
        if (nyVar != null && nyVar.ah()) {
            return this.u.ah(this.cv);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        ny nyVar = this.u;
        if (nyVar != null && nyVar.ah()) {
            return this.u.ka(this.cv);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        ny nyVar = this.u;
        if (nyVar != null && nyVar.ah()) {
            return this.u.ab(this.cv);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        ny nyVar = this.u;
        if (nyVar != null && nyVar.d()) {
            return this.u.d(this.cv);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        ny nyVar = this.u;
        if (nyVar != null && nyVar.d()) {
            return this.u.c(this.cv);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        ny nyVar = this.u;
        if (nyVar != null && nyVar.d()) {
            return this.u.x(this.cv);
        }
        return 0;
    }

    void ka() {
        int i = this.qf + 1;
        this.qf = i;
        if (i != 1 || this.nw) {
            return;
        }
        this.t = false;
    }

    void ms(boolean z) {
        if (this.qf <= 0) {
            this.qf = 1;
        }
        if (!z && !this.nw) {
            this.t = false;
        }
        if (this.qf == 1) {
            if (z && this.t && !this.nw && this.u != null && this.zb != null) {
                ao();
            }
            if (!this.nw) {
                this.t = false;
            }
        }
        this.qf--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.nw) {
            ms("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.nw = false;
                if (this.t && this.u != null && this.zb != null) {
                    requestLayout();
                }
                this.t = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.nw = true;
            this.l = true;
            c();
        }
    }

    public void ms(int i, int i2) {
        ms(i, i2, (Interpolator) null);
    }

    public void ms(int i, int i2, Interpolator interpolator) {
        ny nyVar = this.u;
        if (nyVar == null) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.nw) {
            return;
        }
        if (!nyVar.ah()) {
            i = 0;
        }
        if (!this.u.d()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.yu.ms(i, i2, interpolator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean xr(int i, int i2) {
        ny nyVar = this.u;
        if (nyVar == null) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.nw) {
            return false;
        }
        int iAh = nyVar.ah();
        boolean zD = this.u.d();
        if (iAh == 0 || Math.abs(i) < this.j) {
            i = 0;
        }
        if (!zD || Math.abs(i2) < this.j) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = iAh != 0 || zD;
            dispatchNestedFling(f, f2, z);
            sl slVar = this.jy;
            if (slVar != null && slVar.ms(i, i2)) {
                return true;
            }
            if (z) {
                if (zD) {
                    iAh = (iAh == true ? 1 : 0) | 2;
                }
                ny(iAh, 1);
                int i3 = this.ih;
                int iMax = Math.max(-i3, Math.min(i, i3));
                int i4 = this.ih;
                this.yu.ms(iMax, Math.max(-i4, Math.min(i2, i4)));
                return true;
            }
        }
        return false;
    }

    public void c() {
        setScrollState(0);
        op();
    }

    private void op() {
        this.yu.xr();
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.p();
        }
    }

    public int getMinFlingVelocity() {
        return this.j;
    }

    public int getMaxFlingVelocity() {
        return this.ih;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0040  */
    /* JADX WARN: Code duplicated, block: B:13:0x0056  */
    /* JADX WARN: Code duplicated, block: B:15:0x005a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    private void ms(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 >= 0.0f) {
            if (f2 > 0.0f) {
                x();
                com.bytedance.sdk.component.widget.recycler.ms.ah.ms.ms(this.zf, f2 / getWidth(), f3 / getHeight());
            } else {
                z = false;
            }
            if (f4 < 0.0f) {
                ny();
                com.bytedance.sdk.component.widget.recycler.ms.ah.ms.ms(this.vm, (-f4) / getHeight(), f / getWidth());
            } else if (f4 > 0.0f) {
                ch();
                com.bytedance.sdk.component.widget.recycler.ms.ah.ms.ms(this.rt, f4 / getHeight(), 1.0f - (f / getWidth()));
            } else {
                z2 = z;
            }
            if (z2 && f2 == 0.0f && f4 == 0.0f) {
                return;
            }
            com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ah(this);
        }
        ab();
        com.bytedance.sdk.component.widget.recycler.ms.ah.ms.ms(this.qk, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
        z = true;
        if (f4 < 0.0f) {
            ny();
            com.bytedance.sdk.component.widget.recycler.ms.ah.ms.ms(this.vm, (-f4) / getHeight(), f / getWidth());
        } else if (f4 > 0.0f) {
            ch();
            com.bytedance.sdk.component.widget.recycler.ms.ah.ms.ms(this.rt, f4 / getHeight(), 1.0f - (f / getWidth()));
        } else {
            z2 = z;
        }
        if (z2) {
        }
        com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ah(this);
    }

    private void le() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.qk;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.qk.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.vm;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.vm.isFinished();
        }
        EdgeEffect edgeEffect3 = this.zf;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.zf.isFinished();
        }
        EdgeEffect edgeEffect4 = this.rt;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.rt.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ah(this);
        }
    }

    void ah(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.qk;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.qk.onRelease();
            zIsFinished = this.qk.isFinished();
        }
        EdgeEffect edgeEffect2 = this.zf;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.zf.onRelease();
            zIsFinished |= this.zf.isFinished();
        }
        EdgeEffect edgeEffect3 = this.vm;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.vm.onRelease();
            zIsFinished |= this.vm.isFinished();
        }
        EdgeEffect edgeEffect4 = this.rt;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.rt.onRelease();
            zIsFinished |= this.rt.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ah(this);
        }
    }

    void d(int i, int i2) {
        if (i < 0) {
            ab();
            this.qk.onAbsorb(-i);
        } else if (i > 0) {
            x();
            this.zf.onAbsorb(i);
        }
        if (i2 < 0) {
            ny();
            this.vm.onAbsorb(-i2);
        } else if (i2 > 0) {
            ch();
            this.rt.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ah(this);
    }

    void ab() {
        if (this.qk == null) {
            EdgeEffect edgeEffectMs = this.v.ms(this, 0);
            this.qk = edgeEffectMs;
            if (this.ny) {
                edgeEffectMs.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectMs.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void x() {
        if (this.zf == null) {
            EdgeEffect edgeEffectMs = this.v.ms(this, 2);
            this.zf = edgeEffectMs;
            if (this.ny) {
                edgeEffectMs.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectMs.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void ny() {
        if (this.vm == null) {
            EdgeEffect edgeEffectMs = this.v.ms(this, 1);
            this.vm = edgeEffectMs;
            if (this.ny) {
                edgeEffectMs.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectMs.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void ch() {
        if (this.rt == null) {
            EdgeEffect edgeEffectMs = this.v.ms(this, 3);
            this.rt = edgeEffectMs;
            if (this.ny) {
                edgeEffectMs.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectMs.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void hi() {
        this.rt = null;
        this.vm = null;
        this.zf = null;
        this.qk = null;
    }

    public static <T> T ms(T t2) {
        t2.getClass();
        return t2;
    }

    public void setEdgeEffectFactory(ka kaVar) {
        ms(kaVar);
        this.v = kaVar;
        hi();
    }

    public ka getEdgeEffectFactory() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewMs;
        boolean z;
        View viewD = this.u.d(view, i);
        if (viewD != null) {
            return viewD;
        }
        boolean z2 = (this.zb == null || this.u == null || u() || this.nw) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.u.d()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (lm) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.u.ah()) {
                int i3 = (this.u.h() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (lm) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                d();
                if (ah(view) == null) {
                    return null;
                }
                ka();
                this.u.ms(view, i, this.ka, this.cv);
                ms(false);
            }
            viewMs = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                d();
                if (ah(view) == null) {
                    return null;
                }
                ka();
                viewMs = this.u.ms(view, i, this.ka, this.cv);
                ms(false);
            } else {
                viewMs = viewFindNextFocus;
            }
        }
        if (viewMs == null || viewMs.hasFocusable()) {
            return ms(view, viewMs, i) ? viewMs : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        ms(viewMs, (View) null);
        return view;
    }

    private boolean ms(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || ah(view2) == null) {
            return false;
        }
        if (view == null || ah(view) == null) {
            return true;
        }
        this.hi.set(0, 0, view.getWidth(), view.getHeight());
        this.fm.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.hi);
        offsetDescendantRectToMyCoords(view2, this.fm);
        byte b2 = -1;
        int i3 = this.u.h() == 1 ? -1 : 1;
        if ((this.hi.left < this.fm.left || this.hi.right <= this.fm.left) && this.hi.right < this.fm.right) {
            i2 = 1;
        } else {
            i2 = ((this.hi.right > this.fm.right || this.hi.left >= this.fm.right) && this.hi.left > this.fm.left) ? -1 : 0;
        }
        if ((this.hi.top < this.fm.top || this.hi.bottom <= this.fm.top) && this.hi.bottom < this.fm.bottom) {
            b2 = 1;
        } else if ((this.hi.bottom <= this.fm.bottom && this.hi.top < this.fm.bottom) || this.hi.top <= this.fm.top) {
            b2 = 0;
        }
        if (i == 1) {
            return b2 < 0 || (b2 == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return b2 > 0 || (b2 == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return b2 < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return b2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + ms());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.u.ms(this, this.cv, view, view2) && view2 != null) {
            ms(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void ms(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.hi.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof ch) {
            ch chVar = (ch) layoutParams;
            if (!chVar.ah) {
                Rect rect = chVar.xr;
                this.hi.left -= rect.left;
                this.hi.right += rect.right;
                this.hi.top -= rect.top;
                this.hi.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.hi);
            offsetRectIntoDescendantCoords(view, this.hi);
        }
        this.u.ms(this, view, this.hi, !this.y, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.u.ms(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ny nyVar = this.u;
        if (nyVar == null || !nyVar.ms(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (u()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.ti = 0;
        this.h = true;
        this.y = this.y && !isLayoutRequested();
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.xr(this);
        }
        this.p = false;
        if (d) {
            com.bytedance.sdk.component.widget.recycler.d dVar = com.bytedance.sdk.component.widget.recycler.d.f1410ms.get();
            this.op = dVar;
            if (dVar == null) {
                this.op = new com.bytedance.sdk.component.widget.recycler.d();
                Display displayAb = com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ab(this);
                if (isInEditMode() || displayAb == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displayAb.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                this.op.d = (long) (1.0E9f / refreshRate);
                com.bytedance.sdk.component.widget.recycler.d.f1410ms.set(this.op);
            }
            this.op.ms(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.d dVar;
        super.onDetachedFromWindow();
        c cVar = this.w;
        if (cVar != null) {
            cVar.d();
        }
        c();
        this.h = false;
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.xr(this, this.ka);
        }
        this.f.clear();
        removeCallbacks(this.r);
        this.x.xr();
        if (!d || (dVar = this.op) == null) {
            return;
        }
        dVar.xr(this);
        this.op = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.h;
    }

    void ms(String str) {
        if (u()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + ms());
            }
            throw new IllegalStateException(str);
        }
        if (this.s > 0) {
            com.bytedance.sdk.component.utils.sl.xr("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(ms()));
        }
    }

    private boolean ms(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.il = null;
        }
        int size = this.xn.size();
        for (int i = 0; i < size; i++) {
            zb zbVar = this.xn.get(i);
            if (zbVar.ms(this, motionEvent) && action != 3) {
                this.il = zbVar;
                return true;
            }
        }
        return false;
    }

    private boolean xr(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.il != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.il = null;
                }
                return true;
            }
            this.il = null;
        }
        if (action != 0) {
            int size = this.xn.size();
            for (int i = 0; i < size; i++) {
                zb zbVar = this.xn.get(i);
                if (zbVar.ms(this, motionEvent)) {
                    this.il = zbVar;
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
        if (this.nw) {
            return false;
        }
        if (ms(motionEvent)) {
            g();
            return true;
        }
        ny nyVar = this.u;
        if (nyVar == null) {
            return false;
        }
        boolean zAh = nyVar.ah();
        boolean zD = this.u.d();
        if (this.gy == null) {
            this.gy = VelocityTracker.obtain();
        }
        this.gy.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.l) {
                this.l = false;
            }
            this.sk = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.ce = x2;
            this.vl = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.jm = y2;
            this.qr = y2;
            if (this.vy == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.gs;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = zAh;
            if (zD) {
                i = (zAh ? 1 : 0) | 2;
            }
            ny(i, 0);
        } else if (actionMasked == 1) {
            this.gy.clear();
            x(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.sk);
            if (iFindPointerIndex < 0) {
                com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Error processing scroll; pointer index for id " + this.sk + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.vy != 1) {
                int i2 = x3 - this.vl;
                int i3 = y3 - this.qr;
                if (!zAh || Math.abs(i2) <= this.bz) {
                    z = false;
                } else {
                    this.ce = x3;
                    z = true;
                }
                if (zD && Math.abs(i3) > this.bz) {
                    this.jm = y3;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            g();
        } else if (actionMasked == 5) {
            this.sk = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.ce = x4;
            this.vl = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.jm = y4;
            this.qr = y4;
        } else if (actionMasked == 6) {
            ah(motionEvent);
        }
        return this.vy == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.xn.size();
        for (int i = 0; i < size; i++) {
            this.xn.get(i);
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
        if (this.nw || this.l) {
            return false;
        }
        if (xr(motionEvent)) {
            g();
            return true;
        }
        ny nyVar = this.u;
        if (nyVar == null) {
            return false;
        }
        boolean zAh = nyVar.ah();
        boolean zD = this.u.d();
        if (this.gy == null) {
            this.gy = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.gs;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.gs;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.sk = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.ce = x2;
            this.vl = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.jm = y2;
            this.qr = y2;
            if (zD) {
                i = zAh;
                i = (zAh ? 1 : 0) | 2;
            }
            i = zAh;
            ny(i, 0);
        } else if (actionMasked == 1) {
            this.gy.addMovement(motionEventObtain);
            this.gy.computeCurrentVelocity(1000, this.ih);
            float f = zAh ? -this.gy.getXVelocity(this.sk) : 0.0f;
            float f2 = zD ? -this.gy.getYVelocity(this.sk) : 0.0f;
            if ((f == 0.0f && f2 == 0.0f) || !xr((int) f, (int) f2)) {
                setScrollState(0);
            }
            cv();
            z2 = true;
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.sk);
            if (iFindPointerIndex < 0) {
                com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Error processing scroll; pointer index for id " + this.sk + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            int i2 = this.ce - x3;
            int i3 = this.jm - y3;
            if (ms(i2, i3, this.pc, this.kl, 0)) {
                int[] iArr3 = this.pc;
                i2 -= iArr3[0];
                i3 -= iArr3[1];
                int[] iArr4 = this.kl;
                motionEventObtain.offsetLocation(iArr4[0], iArr4[1]);
                int[] iArr5 = this.gs;
                int i4 = iArr5[0];
                int[] iArr6 = this.kl;
                iArr5[0] = i4 + iArr6[0];
                iArr5[1] = iArr5[1] + iArr6[1];
            }
            if (this.vy != 1) {
                if (zAh) {
                    int iAbs = Math.abs(i2);
                    int i5 = this.bz;
                    if (iAbs > i5) {
                        i2 = i2 > 0 ? i2 - i5 : i2 + i5;
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (zD) {
                    int iAbs2 = Math.abs(i3);
                    int i6 = this.bz;
                    if (iAbs2 > i6) {
                        i3 = i3 > 0 ? i3 - i6 : i3 + i6;
                        z = true;
                    }
                }
                if (z) {
                    setScrollState(1);
                }
            }
            if (this.vy == 1) {
                int[] iArr7 = this.kl;
                this.ce = x3 - iArr7[0];
                this.jm = y3 - iArr7[1];
                if (ms(zAh ? i2 : 0, zD ? i3 : 0, motionEventObtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                com.bytedance.sdk.component.widget.recycler.d dVar = this.op;
                if (dVar != null && (i2 != 0 || i3 != 0)) {
                    dVar.ms(this, i2, i3);
                }
            }
        } else if (actionMasked == 3) {
            g();
        } else if (actionMasked == 5) {
            this.sk = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.ce = x4;
            this.vl = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.jm = y4;
            this.qr = y4;
        } else if (actionMasked == 6) {
            ah(motionEvent);
        }
        if (!z2) {
            this.gy.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void cv() {
        VelocityTracker velocityTracker = this.gy;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        x(0);
        le();
    }

    private void g() {
        cv();
        setScrollState(0);
    }

    private void ah(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.sk) {
            int i = actionIndex == 0 ? 1 : 0;
            this.sk = motionEvent.getPointerId(i);
            int x2 = (int) (motionEvent.getX(i) + 0.5f);
            this.ce = x2;
            this.vl = x2;
            int y2 = (int) (motionEvent.getY(i) + 0.5f);
            this.jm = y2;
            this.qr = y2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0060  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.u != null && !this.nw && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.u.d() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.u.ah() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.u.d()) {
                    f = -axisValue;
                } else if (this.u.ah()) {
                    f = 0.0f;
                } else {
                    f = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f = 0.0f;
                axisValue = 0.0f;
            }
            if (f != 0.0f || axisValue != 0.0f) {
                ms((int) (axisValue * this.oh), (int) (f * this.zd), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ny nyVar = this.u;
        if (nyVar == null) {
            ka(i, i2);
            return;
        }
        boolean z = false;
        if (!nyVar.ms()) {
            if (this.qv) {
                this.u.ms(this.ka, this.cv, i, i2);
                return;
            }
            if (this.b) {
                ka();
                sl();
                pc();
                zb();
                if (this.cv.hi) {
                    this.cv.ab = true;
                } else {
                    this.c.ka();
                    this.cv.ab = false;
                }
                this.b = false;
                ms(false);
            } else if (this.cv.hi) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            ms msVar = this.zb;
            if (msVar != null) {
                this.cv.ka = msVar.ms();
            } else {
                this.cv.ka = 0;
            }
            ka();
            this.u.ms(this.ka, this.cv, i, i2);
            ms(false);
            this.cv.ab = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.u.ms(this.ka, this.cv, i, i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z = true;
        }
        if (z || this.zb == null) {
            return;
        }
        if (this.cv.d == 1) {
            m();
        }
        this.u.xr(i, i2);
        this.cv.ny = true;
        lm();
        this.u.ah(i, i2);
        if (this.u.ny()) {
            this.u.xr(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.cv.ny = true;
            lm();
            this.u.ah(i, i2);
        }
    }

    void ka(int i, int i2) {
        setMeasuredDimension(ny.ms(i, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.ms.ah.ab.d(this)), ny.ms(i2, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ka(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        hi();
    }

    public void setItemAnimator(c cVar) {
        c cVar2 = this.w;
        if (cVar2 != null) {
            cVar2.d();
            this.w.ms(null);
        }
        this.w = cVar;
        if (cVar != null) {
            cVar.ms(this.o);
        }
    }

    void sl() {
        this.ti++;
    }

    void zb() {
        xr(true);
    }

    void xr(boolean z) {
        int i = this.ti - 1;
        this.ti = i;
        if (i <= 0) {
            this.ti = 0;
            if (z) {
                of();
                re();
            }
        }
    }

    private void of() {
        this.am = 0;
    }

    public boolean u() {
        return this.ti > 0;
    }

    public c getItemAnimator() {
        return this.w;
    }

    void ub() {
        if (this.p || !this.h) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(this, this.r);
        this.p = true;
    }

    private boolean p() {
        return this.w != null && this.u.sl();
    }

    private void pc() {
        if (this.re) {
            this.c.ms();
        }
        if (p()) {
            this.c.xr();
        } else {
            this.c.ka();
        }
        boolean z = false;
        boolean z2 = this.g || this.of;
        this.cv.ch = this.y && this.w != null && (this.re || z2 || this.u.zb) && (!this.re || this.zb.xr());
        t tVar = this.cv;
        if (tVar.ch && z2 && !this.re && p()) {
            z = true;
        }
        tVar.hi = z;
    }

    void ao() {
        if (this.zb == null) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.u == null) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.cv.ny = false;
        if (this.cv.d == 1) {
            m();
        } else {
            if (!this.c.c() && this.u.b() == getWidth() && this.u.re() == getHeight()) {
                this.u.d(this);
            }
            e();
        }
        this.u.d(this);
        lm();
        e();
    }

    private void jw() {
        int iKa;
        View focusedChild = (this.z && hasFocus() && this.zb != null) ? getFocusedChild() : null;
        re reVarD = focusedChild != null ? d(focusedChild) : null;
        if (reVarD == null) {
            f();
            return;
        }
        this.cv.zb = this.zb.xr() ? reVarD.ab() : -1L;
        t tVar = this.cv;
        if (this.re) {
            iKa = -1;
        } else {
            iKa = reVarD.h() ? reVarD.d : reVarD.ka();
        }
        tVar.sl = iKa;
        this.cv.u = zb(reVarD.f1391ms);
    }

    private void f() {
        this.cv.zb = -1L;
        this.cv.sl = -1;
        this.cv.u = -1;
    }

    private View ul() {
        re reVarD;
        int i = this.cv.sl != -1 ? this.cv.sl : 0;
        int iD = this.cv.d();
        for (int i2 = i; i2 < iD; i2++) {
            re reVarD2 = d(i2);
            if (reVarD2 == null) {
                break;
            }
            if (reVarD2.f1391ms.hasFocusable()) {
                return reVarD2.f1391ms;
            }
        }
        int iMin = Math.min(iD, i);
        do {
            iMin--;
            if (iMin < 0 || (reVarD = d(iMin)) == null) {
                return null;
            }
        } while (!reVarD.f1391ms.hasFocusable());
        return reVarD.f1391ms;
    }

    private void az() {
        View viewFindViewById;
        if (!this.z || this.zb == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (e && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.ab.xr() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.ab.ah(focusedChild)) {
                return;
            }
        }
        View viewUl = null;
        re reVarMs = (this.cv.zb == -1 || !this.zb.xr()) ? null : ms(this.cv.zb);
        if (reVarMs != null && !this.ab.ah(reVarMs.f1391ms) && reVarMs.f1391ms.hasFocusable()) {
            viewUl = reVarMs.f1391ms;
        } else if (this.ab.xr() > 0) {
            viewUl = ul();
        }
        if (viewUl != null) {
            if (this.cv.u != -1 && (viewFindViewById = viewUl.findViewById(this.cv.u)) != null && viewFindViewById.isFocusable()) {
                viewUl = viewFindViewById;
            }
            viewUl.requestFocus();
        }
    }

    private int zb(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void ms(t tVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.yu.f1382ms;
            tVar.ub = overScroller.getFinalX() - overScroller.getCurrX();
            tVar.ao = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            tVar.ub = 0;
            tVar.ao = 0;
        }
    }

    private void m() {
        this.cv.ms(1);
        ms(this.cv);
        this.cv.ny = false;
        ka();
        this.x.ms();
        sl();
        pc();
        jw();
        t tVar = this.cv;
        tVar.x = tVar.ch && this.of;
        this.of = false;
        this.g = false;
        t tVar2 = this.cv;
        tVar2.ab = tVar2.hi;
        this.cv.ka = this.zb.ms();
        ms(this.ec);
        if (this.cv.ch) {
            int iXr = this.ab.xr();
            for (int i = 0; i < iXr; i++) {
                re reVarKa = ka(this.ab.xr(i));
                if (!reVarKa.M_() && (!reVarKa.u() || this.zb.xr())) {
                    this.x.ms(reVarKa, this.w.ms(this.cv, reVarKa, c.ka(reVarKa), reVarKa.nw()));
                    if (this.cv.x && reVarKa.yu() && !reVarKa.h() && !reVarKa.M_() && !reVarKa.u()) {
                        this.x.ms(ms(reVarKa), reVarKa);
                    }
                }
            }
        }
        if (this.cv.hi) {
            qv();
            boolean z = this.cv.c;
            this.cv.c = false;
            this.u.ms(this.ka, this.cv);
            this.cv.c = z;
            for (int i2 = 0; i2 < this.ab.xr(); i2++) {
                re reVarKa2 = ka(this.ab.xr(i2));
                if (!reVarKa2.M_() && !this.x.d(reVarKa2)) {
                    int iKa = c.ka(reVarKa2);
                    boolean zMs = reVarKa2.ms(8192);
                    if (!zMs) {
                        iKa |= 4096;
                    }
                    c.xr xrVarMs = this.w.ms(this.cv, reVarKa2, iKa, reVarKa2.nw());
                    if (zMs) {
                        ms(reVarKa2, xrVarMs);
                    } else {
                        this.x.xr(reVarKa2, xrVarMs);
                    }
                }
            }
            y();
        } else {
            y();
        }
        zb();
        ms(false);
        this.cv.d = 2;
    }

    private void lm() {
        ka();
        sl();
        this.cv.ms(6);
        this.c.ka();
        this.cv.ka = this.zb.ms();
        this.cv.ah = 0;
        this.cv.ab = false;
        this.u.ms(this.ka, this.cv);
        this.cv.c = false;
        t tVar = this.cv;
        tVar.ch = tVar.ch && this.w != null;
        this.cv.d = 4;
        zb();
        ms(false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0079  */
    private void e() {
        this.cv.ms(4);
        ka();
        sl();
        this.cv.d = 1;
        if (this.cv.ch) {
            for (int iXr = this.ab.xr() - 1; iXr >= 0; iXr--) {
                re reVarKa = ka(this.ab.xr(iXr));
                if (!reVarKa.M_()) {
                    long jMs = ms(reVarKa);
                    c.xr xrVarMs = this.w.ms(this.cv, reVarKa);
                    re reVarMs = this.x.ms(jMs);
                    if (reVarMs != null && !reVarMs.M_()) {
                        boolean zMs = this.x.ms(reVarMs);
                        boolean zMs2 = this.x.ms(reVarKa);
                        if (!zMs || reVarMs != reVarKa) {
                            c.xr xrVarXr = this.x.xr(reVarMs);
                            this.x.ah(reVarKa, xrVarMs);
                            c.xr xrVarAh = this.x.ah(reVarKa);
                            if (xrVarXr == null) {
                                ms(jMs, reVarKa, reVarMs);
                            } else {
                                ms(reVarMs, reVarKa, xrVarXr, xrVarAh, zMs, zMs2);
                            }
                        } else {
                            this.x.ah(reVarKa, xrVarMs);
                        }
                    } else {
                        this.x.ah(reVarKa, xrVarMs);
                    }
                }
            }
            this.x.ms(this.nl);
        }
        this.u.xr(this.ka);
        t tVar = this.cv;
        tVar.xr = tVar.ka;
        this.re = false;
        this.i = false;
        this.cv.ch = false;
        this.cv.hi = false;
        this.u.zb = false;
        if (this.ka.xr != null) {
            this.ka.xr.clear();
        }
        if (this.u.h) {
            this.u.ao = 0;
            this.u.h = false;
            this.ka.xr();
        }
        this.u.xr(this.cv);
        zb();
        ms(false);
        this.x.ms();
        int[] iArr = this.ec;
        if (ch(iArr[0], iArr[1])) {
            x(0, 0);
        }
        az();
        f();
    }

    private void ms(long j, re reVar, re reVar2) {
        int iXr = this.ab.xr();
        for (int i = 0; i < iXr; i++) {
            re reVarKa = ka(this.ab.xr(i));
            if (reVarKa != reVar && ms(reVarKa) == j) {
                ms msVar = this.zb;
                if (msVar != null && msVar.xr()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + reVarKa + " \n View Holder 2:" + reVar + ms());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + reVarKa + " \n View Holder 2:" + reVar + ms());
            }
        }
        com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + reVar2 + " cannot be found but it is necessary for " + reVar + ms());
    }

    void ms(re reVar, c.xr xrVar) {
        reVar.ms(0, 8192);
        if (this.cv.x && reVar.yu() && !reVar.h() && !reVar.M_()) {
            this.x.ms(ms(reVar), reVar);
        }
        this.x.ms(reVar, xrVar);
    }

    private void ms(int[] iArr) {
        int iXr = this.ab.xr();
        if (iXr == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iXr; i3++) {
            re reVarKa = ka(this.ab.xr(i3));
            if (!reVarKa.M_()) {
                int iD = reVarKa.d();
                if (iD < i) {
                    i = iD;
                }
                if (iD > i2) {
                    i2 = iD;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean ch(int i, int i2) {
        ms(this.ec);
        int[] iArr = this.ec;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        re reVarKa = ka(view);
        if (reVarKa != null) {
            if (reVarKa.qv()) {
                reVarKa.zb();
            } else if (!reVarKa.M_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + reVarKa + ms());
            }
        }
        view.clearAnimation();
        hi(view);
        super.removeDetachedView(view, z);
    }

    long ms(re reVar) {
        return this.zb.xr() ? reVar.ab() : reVar.ah;
    }

    void ms(re reVar, c.xr xrVar, c.xr xrVar2) {
        reVar.ms(false);
        if (this.w.xr(reVar, xrVar, xrVar2)) {
            ub();
        }
    }

    void xr(re reVar, c.xr xrVar, c.xr xrVar2) {
        ka(reVar);
        reVar.ms(false);
        if (this.w.ms(reVar, xrVar, xrVar2)) {
            ub();
        }
    }

    private void ms(re reVar, re reVar2, c.xr xrVar, c.xr xrVar2, boolean z, boolean z2) {
        reVar.ms(false);
        if (z) {
            ka(reVar);
        }
        if (reVar != reVar2) {
            if (z2) {
                ka(reVar2);
            }
            reVar.x = reVar2;
            ka(reVar);
            this.ka.ah(reVar);
            reVar2.ms(false);
            reVar2.ny = reVar;
        }
        if (this.w.ms(reVar, reVar2, xrVar, xrVar2)) {
            ub();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV OnLayout");
        ao();
        com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
        this.y = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.qf == 0 && !this.nw) {
            super.requestLayout();
        } else {
            this.t = true;
        }
    }

    void h() {
        int iAh = this.ab.ah();
        for (int i = 0; i < iAh; i++) {
            ((ch) this.ab.d(i).getLayoutParams()).ah = true;
        }
        this.ka.ch();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.ao.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.ao.get(i);
        }
        EdgeEffect edgeEffect = this.qk;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.ny ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.qk;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.vm;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.ny) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.vm;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.zf;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.ny ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.zf;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.rt;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.ny) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.rt;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.w == null || this.ao.size() <= 0 || !this.w.xr()) ? z : true) {
            com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ah(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.ao.size();
        for (int i = 0; i < size; i++) {
            this.ao.get(i);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ch) && this.u.ms((ch) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ny nyVar = this.u;
        if (nyVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + ms());
        }
        return nyVar.xr();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ny nyVar = this.u;
        if (nyVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + ms());
        }
        return nyVar.ms(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ny nyVar = this.u;
        if (nyVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + ms());
        }
        return nyVar.ms(layoutParams);
    }

    void qv() {
        int iAh = this.ab.ah();
        for (int i = 0; i < iAh; i++) {
            re reVarKa = ka(this.ab.d(i));
            if (!reVarKa.M_()) {
                reVarKa.xr();
            }
        }
    }

    void y() {
        int iAh = this.ab.ah();
        for (int i = 0; i < iAh; i++) {
            re reVarKa = ka(this.ab.d(i));
            if (!reVarKa.M_()) {
                reVarKa.ms();
            }
        }
        this.ka.ny();
    }

    void c(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iAh = this.ab.ah();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < iAh; i6++) {
            re reVarKa = ka(this.ab.d(i6));
            if (reVarKa != null && reVarKa.ah >= i4 && reVarKa.ah <= i3) {
                if (reVarKa.ah == i) {
                    reVarKa.ms(i2 - i, false);
                } else {
                    reVarKa.ms(i5, false);
                }
                this.cv.c = true;
            }
        }
        this.ka.ms(i, i2);
        requestLayout();
    }

    void ab(int i, int i2) {
        int iAh = this.ab.ah();
        for (int i3 = 0; i3 < iAh; i3++) {
            re reVarKa = ka(this.ab.d(i3));
            if (reVarKa != null && !reVarKa.M_() && reVarKa.ah >= i) {
                reVarKa.ms(i2, false);
                this.cv.c = true;
            }
        }
        this.ka.xr(i, i2);
        requestLayout();
    }

    void ms(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iAh = this.ab.ah();
        for (int i4 = 0; i4 < iAh; i4++) {
            re reVarKa = ka(this.ab.d(i4));
            if (reVarKa != null && !reVarKa.M_()) {
                if (reVarKa.ah >= i3) {
                    reVarKa.ms(-i2, z);
                    this.cv.c = true;
                } else if (reVarKa.ah >= i) {
                    reVarKa.ms(i - 1, -i2, z);
                    this.cv.c = true;
                }
            }
        }
        this.ka.ms(i, i2, z);
        requestLayout();
    }

    void ms(int i, int i2, Object obj) {
        int iAh = this.ab.ah();
        int i3 = i + i2;
        for (int i4 = 0; i4 < iAh; i4++) {
            View viewD = this.ab.d(i4);
            re reVarKa = ka(viewD);
            if (reVarKa != null && !reVarKa.M_() && reVarKa.ah >= i && reVarKa.ah < i3) {
                reVarKa.xr(2);
                reVarKa.ms(obj);
                ((ch) viewD.getLayoutParams()).ah = true;
            }
        }
        this.ka.ah(i, i2);
    }

    boolean xr(re reVar) {
        c cVar = this.w;
        return cVar == null || cVar.ms(reVar, reVar.nw());
    }

    void ah(boolean z) {
        this.i = z | this.i;
        this.re = true;
        t();
    }

    void t() {
        int iAh = this.ab.ah();
        for (int i = 0; i < iAh; i++) {
            re reVarKa = ka(this.ab.d(i));
            if (reVarKa != null && !reVarKa.M_()) {
                reVarKa.xr(6);
            }
        }
        h();
        this.ka.x();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.z;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.z = z;
    }

    public re xr(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return ka(view);
    }

    public View ah(View view) {
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

    public re d(View view) {
        View viewAh = ah(view);
        if (viewAh == null) {
            return null;
        }
        return xr(viewAh);
    }

    static re ka(View view) {
        if (view == null) {
            return null;
        }
        return ((ch) view.getLayoutParams()).f1385ms;
    }

    @Deprecated
    public int c(View view) {
        return ab(view);
    }

    public int ab(View view) {
        re reVarKa = ka(view);
        if (reVarKa != null) {
            return reVarKa.ka();
        }
        return -1;
    }

    public int x(View view) {
        re reVarKa = ka(view);
        if (reVarKa != null) {
            return reVarKa.d();
        }
        return -1;
    }

    public re ah(int i) {
        return ms(i, false);
    }

    public re d(int i) {
        re reVar = null;
        if (this.re) {
            return null;
        }
        int iAh = this.ab.ah();
        for (int i2 = 0; i2 < iAh; i2++) {
            re reVarKa = ka(this.ab.d(i2));
            if (reVarKa != null && !reVarKa.h() && d(reVarKa) == i) {
                if (!this.ab.ah(reVarKa.f1391ms)) {
                    return reVarKa;
                }
                reVar = reVarKa;
            }
        }
        return reVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:21:0x0033 A[SYNTHETIC] */
    re ms(int i, boolean z) {
        int iAh = this.ab.ah();
        re reVar = null;
        for (int i2 = 0; i2 < iAh; i2++) {
            re reVarKa = ka(this.ab.d(i2));
            if (reVarKa != null && !reVarKa.h()) {
                if (z) {
                    if (reVarKa.ah != i) {
                        continue;
                    } else {
                        if (!this.ab.ah(reVarKa.f1391ms)) {
                            return reVarKa;
                        }
                        reVar = reVarKa;
                    }
                } else if (reVarKa.d() != i) {
                    continue;
                } else {
                    if (!this.ab.ah(reVarKa.f1391ms)) {
                        return reVarKa;
                    }
                    reVar = reVarKa;
                }
            }
        }
        return reVar;
    }

    public re ms(long j) {
        ms msVar = this.zb;
        re reVar = null;
        if (msVar != null && msVar.xr()) {
            int iAh = this.ab.ah();
            for (int i = 0; i < iAh; i++) {
                re reVarKa = ka(this.ab.d(i));
                if (reVarKa != null && !reVarKa.h() && reVarKa.ab() == j) {
                    if (!this.ab.ah(reVarKa.f1391ms)) {
                        return reVarKa;
                    }
                    reVar = reVarKa;
                }
            }
        }
        return reVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ka(int i) {
        int iXr = this.ab.xr();
        for (int i2 = 0; i2 < iXr; i2++) {
            this.ab.xr(i2).offsetTopAndBottom(i);
        }
    }

    public void c(int i) {
        int iXr = this.ab.xr();
        for (int i2 = 0; i2 < iXr; i2++) {
            this.ab.xr(i2).offsetLeftAndRight(i);
        }
    }

    static void ms(View view, Rect rect) {
        ch chVar = (ch) view.getLayoutParams();
        Rect rect2 = chVar.xr;
        rect.set((view.getLeft() - rect2.left) - chVar.leftMargin, (view.getTop() - rect2.top) - chVar.topMargin, view.getRight() + rect2.right + chVar.rightMargin, view.getBottom() + rect2.bottom + chVar.bottomMargin);
    }

    Rect ny(View view) {
        ch chVar = (ch) view.getLayoutParams();
        if (!chVar.ah) {
            return chVar.xr;
        }
        if (this.cv.ms() && (chVar.ah() || chVar.ms())) {
            return chVar.xr;
        }
        Rect rect = chVar.xr;
        rect.set(0, 0, 0, 0);
        int size = this.ao.size();
        for (int i = 0; i < size; i++) {
            this.hi.set(0, 0, 0, 0);
            this.ao.get(i).ms(this.hi, view, this, this.cv);
            rect.left += this.hi.left;
            rect.top += this.hi.top;
            rect.right += this.hi.right;
            rect.bottom += this.hi.bottom;
        }
        chVar.ah = false;
        return rect;
    }

    void x(int i, int i2) {
        this.s++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        u uVar = this.tk;
        if (uVar != null) {
            uVar.ms(this, i, i2);
        }
        List<u> list = this.nn;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.nn.get(size).ms(this, i, i2);
            }
        }
        this.s--;
    }

    void ab(int i) {
        ny nyVar = this.u;
        if (nyVar != null) {
            nyVar.hi(i);
        }
        u uVar = this.tk;
        if (uVar != null) {
            uVar.ms(this, i);
        }
        List<u> list = this.nn;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.nn.get(size).ms(this, i);
            }
        }
    }

    public boolean nw() {
        return !this.y || this.re || this.c.d();
    }

    void b() {
        int iXr = this.ab.xr();
        for (int i = 0; i < iXr; i++) {
            View viewXr = this.ab.xr(i);
            re reVarXr = xr(viewXr);
            if (reVarXr != null && reVarXr.ny != null) {
                View view = reVarXr.ny.f1391ms;
                int left = viewXr.getLeft();
                int top = viewXr.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView ch(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewCh = ch(viewGroup.getChildAt(i));
            if (recyclerViewCh != null) {
                return recyclerViewCh;
            }
        }
        return null;
    }

    static void ah(re reVar) {
        if (reVar.xr != null) {
            RecyclerView recyclerView = reVar.xr.get();
            while (recyclerView != null) {
                if (recyclerView == reVar.f1391ms) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            reVar.xr = null;
        }
    }

    long getNanoTime() {
        if (d) {
            return System.nanoTime();
        }
        return 0L;
    }

    void hi(View view) {
        ka(view);
        List<hi> list = this.tz;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.tz.get(size).xr(view);
            }
        }
    }

    void sl(View view) {
        ka(view);
        List<hi> list = this.tz;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.tz.get(size).ms(view);
            }
        }
    }

    boolean ms(re reVar, int i) {
        if (u()) {
            reVar.ub = i;
            this.f.add(reVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(reVar.f1391ms, i);
        return true;
    }

    void re() {
        int i;
        for (int size = this.f.size() - 1; size >= 0; size--) {
            re reVar = this.f.get(size);
            if (reVar.f1391ms.getParent() == this && !reVar.M_() && (i = reVar.ub) != -1) {
                com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(reVar.f1391ms, i);
                reVar.ub = -1;
            }
        }
        this.f.clear();
    }

    int d(re reVar) {
        if (reVar.ms(524) || !reVar.ao()) {
            return -1;
        }
        return this.c.ah(reVar.ah);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().ms(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().ms();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().xr(i);
    }

    public boolean ny(int i, int i2) {
        return getScrollingChildHelper().ms(i, i2);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.ms.ah.xr
    public void stopNestedScroll() {
        getScrollingChildHelper().ah();
    }

    public void x(int i) {
        getScrollingChildHelper().ah(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().xr();
    }

    public boolean ny(int i) {
        return getScrollingChildHelper().ms(i);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().ms(i, i2, i3, i4, iArr);
    }

    public boolean ms(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().ms(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().ms(i, i2, iArr, iArr2);
    }

    public boolean ms(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().ms(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().ms(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().ms(f, f2);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        d dVar = this.n;
        return dVar == null ? super.getChildDrawingOrder(i, i2) : dVar.ms(i, i2);
    }

    private com.bytedance.sdk.component.widget.recycler.ms.ah.d getScrollingChildHelper() {
        if (this.vf == null) {
            this.vf = new com.bytedance.sdk.component.widget.recycler.ms.ah.d(this);
        }
        return this.vf;
    }

    public static abstract class c {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ms f1383ms = null;
        private ArrayList<Object> xr = new ArrayList<>();
        private long ah = 120;
        private long d = 120;
        private long ka = 250;
        private long c = 250;

        interface ms {
            void ms(re reVar);
        }

        public boolean ab(re reVar) {
            return true;
        }

        public abstract boolean ah(re reVar, xr xrVar, xr xrVar2);

        public abstract void d();

        public abstract void d(re reVar);

        public abstract void ms();

        public abstract boolean ms(re reVar, xr xrVar, xr xrVar2);

        public abstract boolean ms(re reVar, re reVar2, xr xrVar, xr xrVar2);

        public abstract boolean xr();

        public abstract boolean xr(re reVar, xr xrVar, xr xrVar2);

        public long ka() {
            return this.ka;
        }

        public long c() {
            return this.ah;
        }

        public long ab() {
            return this.d;
        }

        public long x() {
            return this.c;
        }

        void ms(ms msVar) {
            this.f1383ms = msVar;
        }

        public xr ms(t tVar, re reVar, int i, List<Object> list) {
            return ch().ms(reVar);
        }

        public xr ms(t tVar, re reVar) {
            return ch().ms(reVar);
        }

        static int ka(re reVar) {
            int i = reVar.ch & 14;
            if (reVar.u()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iC = reVar.c();
            int iKa = reVar.ka();
            return (iC == -1 || iKa == -1 || iC == iKa) ? i : i | 2048;
        }

        public final void c(re reVar) {
            ms msVar = this.f1383ms;
            if (msVar != null) {
                msVar.ms(reVar);
            }
        }

        public boolean ms(re reVar, List<Object> list) {
            return ab(reVar);
        }

        public final void ny() {
            int size = this.xr.size();
            for (int i = 0; i < size; i++) {
                this.xr.get(i);
            }
            this.xr.clear();
        }

        public xr ch() {
            return new xr();
        }

        public static class xr {
            public int ah;
            public int d;

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public int f1384ms;
            public int xr;

            public xr ms(re reVar) {
                return ms(reVar, 0);
            }

            public xr ms(re reVar, int i) {
                View view = reVar.f1391ms;
                this.f1384ms = view.getLeft();
                this.xr = view.getTop();
                this.ah = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }
    }

    private class ab implements c.ms {
        ab() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c.ms
        public void ms(re reVar) {
            reVar.ms(true);
            if (reVar.x != null && reVar.ny == null) {
                reVar.x = null;
            }
            reVar.ny = null;
            if (reVar.i() || RecyclerView.this.ms(reVar.f1391ms) || !reVar.qv()) {
                return;
            }
            RecyclerView.this.removeDetachedView(reVar.f1391ms, false);
        }
    }

    public static class t {
        int ao;
        private SparseArray<Object> h;
        int sl;
        int u;
        int ub;
        long zb;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f1392ms = -1;
        int xr = 0;
        int ah = 0;
        int d = 1;
        int ka = 0;
        boolean c = false;
        boolean ab = false;
        boolean x = false;
        boolean ny = false;
        boolean ch = false;
        boolean hi = false;

        void ms(int i) {
            if ((this.d & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
            }
        }

        void ms(ms msVar) {
            this.d = 1;
            this.ka = msVar.ms();
            this.ab = false;
            this.x = false;
            this.ny = false;
        }

        public boolean ms() {
            return this.ab;
        }

        public boolean xr() {
            return this.hi;
        }

        public boolean ah() {
            return this.f1392ms != -1;
        }

        public int d() {
            return this.ab ? this.xr - this.ah : this.ka;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1392ms + ", mData=" + this.h + ", mItemCount=" + this.ka + ", mIsMeasuring=" + this.ny + ", mPreviousLayoutItemCount=" + this.xr + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.ah + ", mStructureChanged=" + this.c + ", mInPreLayout=" + this.ab + ", mRunSimpleAnimations=" + this.ch + ", mRunPredictiveAnimations=" + this.hi + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static class xr extends Observable<ah> {
        xr() {
        }

        public void ms() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((ah) this.mObservers.get(size)).ms();
            }
        }

        public void ms(int i, int i2) {
            ms(i, i2, null);
        }

        public void ms(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((ah) this.mObservers.get(size)).ms(i, i2, obj);
            }
        }
    }

    public static abstract class y {
        private ny ah;
        private View c;
        private boolean d;
        private boolean ka;
        private boolean x;
        private RecyclerView xr;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f1395ms = -1;
        private final ms ab = new ms(0, 0);

        public interface xr {
            PointF ah(int i);
        }

        protected abstract void ms();

        protected abstract void ms(int i, int i2, t tVar, ms msVar);

        protected abstract void ms(View view, t tVar, ms msVar);

        void ms(RecyclerView recyclerView, ny nyVar) {
            if (this.x) {
                com.bytedance.sdk.component.utils.sl.xr("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.xr = recyclerView;
            this.ah = nyVar;
            if (this.f1395ms == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.cv.f1392ms = this.f1395ms;
            this.ka = true;
            this.d = true;
            this.c = ka(x());
            this.xr.yu.ms();
            this.x = true;
        }

        public void ah(int i) {
            this.f1395ms = i;
        }

        public PointF d(int i) {
            Object objD = d();
            if (objD instanceof xr) {
                return ((xr) objD).ah(i);
            }
            com.bytedance.sdk.component.utils.sl.xr("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + xr.class.getCanonicalName());
            return null;
        }

        public ny d() {
            return this.ah;
        }

        protected final void ka() {
            if (this.ka) {
                this.ka = false;
                ms();
                this.xr.cv.f1392ms = -1;
                this.c = null;
                this.f1395ms = -1;
                this.d = false;
                this.ah.xr(this);
                this.ah = null;
                this.xr = null;
            }
        }

        public boolean c() {
            return this.d;
        }

        public boolean ab() {
            return this.ka;
        }

        public int x() {
            return this.f1395ms;
        }

        void ms(int i, int i2) {
            PointF pointFD;
            RecyclerView recyclerView = this.xr;
            if (!this.ka || this.f1395ms == -1 || recyclerView == null) {
                ka();
            }
            if (this.d && this.c == null && this.ah != null && (pointFD = d(this.f1395ms)) != null && (pointFD.x != 0.0f || pointFD.y != 0.0f)) {
                recyclerView.ms((int) Math.signum(pointFD.x), (int) Math.signum(pointFD.y), (int[]) null);
            }
            this.d = false;
            View view = this.c;
            if (view != null) {
                if (ms(view) == this.f1395ms) {
                    ms(this.c, recyclerView.cv, this.ab);
                    this.ab.ms(recyclerView);
                    ka();
                } else {
                    com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.c = null;
                }
            }
            if (this.ka) {
                ms(i, i2, recyclerView.cv, this.ab);
                boolean zMs = this.ab.ms();
                this.ab.ms(recyclerView);
                if (zMs) {
                    if (this.ka) {
                        this.d = true;
                        recyclerView.yu.ms();
                    } else {
                        ka();
                    }
                }
            }
        }

        public int ms(View view) {
            return this.xr.x(view);
        }

        public int ny() {
            return this.xr.u.y();
        }

        public View ka(int i) {
            return this.xr.u.xr(i);
        }

        protected void xr(View view) {
            if (ms(view) == x()) {
                this.c = view;
            }
        }

        protected void ms(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public static class ms {
            private int ab;
            private int ah;
            private boolean c;
            private int d;
            private Interpolator ka;

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private int f1396ms;
            private int xr;

            public ms(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public ms(int i, int i2, int i3, Interpolator interpolator) {
                this.d = -1;
                this.c = false;
                this.ab = 0;
                this.f1396ms = i;
                this.xr = i2;
                this.ah = i3;
                this.ka = interpolator;
            }

            public void ms(int i) {
                this.d = i;
            }

            boolean ms() {
                return this.d >= 0;
            }

            void ms(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.ms(i);
                    this.c = false;
                } else {
                    if (this.c) {
                        xr();
                        if (this.ka == null) {
                            if (this.ah == Integer.MIN_VALUE) {
                                recyclerView.yu.xr(this.f1396ms, this.xr);
                            } else {
                                recyclerView.yu.ms(this.f1396ms, this.xr, this.ah);
                            }
                        } else {
                            recyclerView.yu.ms(this.f1396ms, this.xr, this.ah, this.ka);
                        }
                        int i2 = this.ab + 1;
                        this.ab = i2;
                        if (i2 > 10) {
                            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.c = false;
                        return;
                    }
                    this.ab = 0;
                }
            }

            private void xr() {
                if (this.ka != null && this.ah <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.ah <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.f1396ms = i;
                this.xr = i2;
                this.ah = i3;
                this.ka = interpolator;
                this.c = true;
            }
        }
    }

    public static class ch extends ViewGroup.MarginLayoutParams {
        boolean ah;
        boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        re f1385ms;
        final Rect xr;

        public ch(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.xr = new Rect();
            this.ah = true;
            this.d = false;
        }

        public ch(int i, int i2) {
            super(i, i2);
            this.xr = new Rect();
            this.ah = true;
            this.d = false;
        }

        public ch(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.xr = new Rect();
            this.ah = true;
            this.d = false;
        }

        public ch(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.xr = new Rect();
            this.ah = true;
            this.d = false;
        }

        public ch(ch chVar) {
            super((ViewGroup.MarginLayoutParams) chVar);
            this.xr = new Rect();
            this.ah = true;
            this.d = false;
        }

        public boolean ms() {
            return this.f1385ms.u();
        }

        public boolean xr() {
            return this.f1385ms.h();
        }

        public boolean ah() {
            return this.f1385ms.yu();
        }

        public int d() {
            return this.f1385ms.d();
        }
    }

    public static abstract class re {
        private static final List<Object> h = Collections.emptyList();
        RecyclerView ao;
        int ch;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final View f1391ms;
        WeakReference<RecyclerView> xr;
        int ah = -1;
        int d = -1;
        long ka = -1;
        int c = -1;
        int ab = -1;
        re x = null;
        re ny = null;
        List<Object> hi = null;
        List<Object> sl = null;
        private int qv = 0;
        ao zb = null;
        boolean u = false;
        private int y = 0;
        int ub = -1;

        public re(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1391ms = view;
        }

        void ms(int i, int i2, boolean z) {
            xr(8);
            ms(i2, z);
            this.ah = i;
        }

        void ms(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.ah;
            }
            if (this.ab == -1) {
                this.ab = this.ah;
            }
            if (z) {
                this.ab += i;
            }
            this.ah += i;
            if (this.f1391ms.getLayoutParams() != null) {
                ((ch) this.f1391ms.getLayoutParams()).ah = true;
            }
        }

        void ms() {
            this.d = -1;
            this.ab = -1;
        }

        void xr() {
            if (this.d == -1) {
                this.d = this.ah;
            }
        }

        boolean M_() {
            return (this.ch & 128) != 0;
        }

        public final int d() {
            int i = this.ab;
            return i == -1 ? this.ah : i;
        }

        public final int ka() {
            RecyclerView recyclerView = this.ao;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d(this);
        }

        public final int c() {
            return this.d;
        }

        public final long ab() {
            return this.ka;
        }

        public final int x() {
            return this.c;
        }

        boolean ny() {
            return this.zb != null;
        }

        void ch() {
            this.zb.ah(this);
        }

        boolean hi() {
            return (this.ch & 32) != 0;
        }

        void sl() {
            this.ch &= -33;
        }

        void zb() {
            this.ch &= -257;
        }

        void ms(ao aoVar, boolean z) {
            this.zb = aoVar;
            this.u = z;
        }

        boolean u() {
            return (this.ch & 4) != 0;
        }

        boolean ub() {
            return (this.ch & 2) != 0;
        }

        boolean ao() {
            return (this.ch & 1) != 0;
        }

        boolean h() {
            return (this.ch & 8) != 0;
        }

        boolean ms(int i) {
            return (i & this.ch) != 0;
        }

        boolean qv() {
            return (this.ch & 256) != 0;
        }

        boolean y() {
            return (this.ch & 512) != 0 || u();
        }

        void ms(int i, int i2) {
            this.ch = (i & i2) | (this.ch & (~i2));
        }

        void xr(int i) {
            this.ch = i | this.ch;
        }

        void ms(Object obj) {
            if (obj == null) {
                xr(1024);
            } else if ((1024 & this.ch) == 0) {
                op();
                this.hi.add(obj);
            }
        }

        private void op() {
            if (this.hi == null) {
                ArrayList arrayList = new ArrayList();
                this.hi = arrayList;
                this.sl = Collections.unmodifiableList(arrayList);
            }
        }

        void t() {
            List<Object> list = this.hi;
            if (list != null) {
                list.clear();
            }
            this.ch &= -1025;
        }

        List<Object> nw() {
            if ((this.ch & 1024) == 0) {
                List<Object> list = this.hi;
                return (list == null || list.size() == 0) ? h : this.sl;
            }
            return h;
        }

        void b() {
            this.ch = 0;
            this.ah = -1;
            this.d = -1;
            this.ka = -1L;
            this.ab = -1;
            this.qv = 0;
            this.x = null;
            this.ny = null;
            t();
            this.y = 0;
            this.ub = -1;
            RecyclerView.ah(this);
        }

        void ms(RecyclerView recyclerView) {
            int i = this.ub;
            if (i != -1) {
                this.y = i;
            } else {
                this.y = com.bytedance.sdk.component.widget.recycler.ms.ah.ab.xr(this.f1391ms);
            }
            recyclerView.ms(this, 4);
        }

        void xr(RecyclerView recyclerView) {
            recyclerView.ms(this, this.y);
            this.y = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.ah + " id=" + this.ka + ", oldPos=" + this.d + ", pLpos:" + this.ab);
            if (ny()) {
                sb.append(" scrap ").append(this.u ? "[changeScrap]" : "[attachedScrap]");
            }
            if (u()) {
                sb.append(" invalid");
            }
            if (!ao()) {
                sb.append(" unbound");
            }
            if (ub()) {
                sb.append(" update");
            }
            if (h()) {
                sb.append(" removed");
            }
            if (M_()) {
                sb.append(" ignored");
            }
            if (qv()) {
                sb.append(" tmpDetached");
            }
            if (!re()) {
                sb.append(" not recyclable(" + this.qv + ")");
            }
            if (y()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1391ms.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void ms(boolean z) {
            int i = this.qv;
            int i2 = z ? i - 1 : i + 1;
            this.qv = i2;
            if (i2 < 0) {
                this.qv = 0;
                com.bytedance.sdk.component.utils.sl.d("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.ch |= 16;
            } else if (z && i2 == 0) {
                this.ch &= -17;
            }
        }

        public final boolean re() {
            return (this.ch & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.ms.ah.ab.c(this.f1391ms);
        }

        boolean i() {
            return (this.ch & 16) != 0;
        }

        boolean w() {
            return (this.ch & 16) == 0 && com.bytedance.sdk.component.widget.recycler.ms.ah.ab.c(this.f1391ms);
        }

        boolean yu() {
            return (this.ch & 2) != 0;
        }
    }

    public static abstract class x {
        @Deprecated
        public void ms(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void ms(Rect rect, View view, RecyclerView recyclerView, t tVar) {
            ms(rect, ((ch) view.getLayoutParams()).d(), recyclerView);
        }
    }

    public static abstract class ny {
        private int ab;
        private boolean ah;
        int ao;
        private int c;
        com.bytedance.sdk.component.widget.recycler.zb ch;
        private boolean d;
        boolean h;
        com.bytedance.sdk.component.widget.recycler.zb hi;
        private int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bytedance.sdk.component.widget.recycler.zb.xr f1387ms;
        RecyclerView ny;
        private int qv;
        y sl;
        boolean u;
        boolean ub;
        com.bytedance.sdk.component.widget.recycler.xr x;
        private final com.bytedance.sdk.component.widget.recycler.zb.xr xr;
        boolean zb;

        public interface ms {
            void xr(int i, int i2);
        }

        public int ab(t tVar) {
            return 0;
        }

        public int ah(t tVar) {
            return 0;
        }

        public void ah(RecyclerView recyclerView) {
        }

        public boolean ah() {
            return false;
        }

        public int c(t tVar) {
            return 0;
        }

        public int d(t tVar) {
            return 0;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
        }

        public boolean d() {
            return false;
        }

        public void hi(int i) {
        }

        public int ka(t tVar) {
            return 0;
        }

        public int ms(int i, ao aoVar, t tVar) {
            return 0;
        }

        public View ms(View view, int i, ao aoVar, t tVar) {
            return null;
        }

        public void ms(int i, int i2, t tVar, ms msVar) {
        }

        public void ms(int i, ms msVar) {
        }

        public void ms(RecyclerView recyclerView, ao aoVar) {
        }

        public boolean ms(ch chVar) {
            return chVar != null;
        }

        public boolean ms(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        boolean ny() {
            return false;
        }

        public int qv() {
            return -1;
        }

        public boolean sl() {
            return false;
        }

        public int x(t tVar) {
            return 0;
        }

        public int xr(int i, ao aoVar, t tVar) {
            return 0;
        }

        public abstract ch xr();

        public void xr(t tVar) {
        }

        public ny() {
            com.bytedance.sdk.component.widget.recycler.zb.xr xrVar = new com.bytedance.sdk.component.widget.recycler.zb.xr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.ny.1
                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public View ms(int i) {
                    return ny.this.x(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int ms() {
                    return ny.this.i();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int xr() {
                    return ny.this.b() - ny.this.yu();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int ms(View view) {
                    return ny.this.ab(view) - ((ch) view.getLayoutParams()).leftMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int xr(View view) {
                    return ny.this.ny(view) + ((ch) view.getLayoutParams()).rightMargin;
                }
            };
            this.f1387ms = xrVar;
            com.bytedance.sdk.component.widget.recycler.zb.xr xrVar2 = new com.bytedance.sdk.component.widget.recycler.zb.xr() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.ny.2
                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public View ms(int i) {
                    return ny.this.x(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int ms() {
                    return ny.this.w();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int xr() {
                    return ny.this.re() - ny.this.op();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int ms(View view) {
                    return ny.this.x(view) - ((ch) view.getLayoutParams()).topMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.zb.xr
                public int xr(View view) {
                    return ny.this.ch(view) + ((ch) view.getLayoutParams()).bottomMargin;
                }
            };
            this.xr = xrVar2;
            this.ch = new com.bytedance.sdk.component.widget.recycler.zb(xrVar);
            this.hi = new com.bytedance.sdk.component.widget.recycler.zb(xrVar2);
            this.zb = false;
            this.u = false;
            this.ub = false;
            this.ah = true;
            this.d = true;
        }

        void ms(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.ny = null;
                this.x = null;
                this.ab = 0;
                this.qv = 0;
            } else {
                this.ny = recyclerView;
                this.x = recyclerView.ab;
                this.ab = recyclerView.getWidth();
                this.qv = recyclerView.getHeight();
            }
            this.ka = 1073741824;
            this.c = 1073741824;
        }

        void xr(int i, int i2) {
            this.ab = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.ka = mode;
            if (mode == 0 && !RecyclerView.xr) {
                this.ab = 0;
            }
            this.qv = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.c = mode2;
            if (mode2 != 0 || RecyclerView.xr) {
                return;
            }
            this.qv = 0;
        }

        void ah(int i, int i2) {
            int iY = y();
            if (iY == 0) {
                this.ny.ka(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iY; i7++) {
                View viewX = x(i7);
                Rect rect = this.ny.hi;
                ms(viewX, rect);
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
            this.ny.hi.set(i6, i4, i3, i5);
            ms(this.ny.hi, i, i2);
        }

        public void ms(Rect rect, int i, int i2) {
            ka(ms(i, rect.width() + i() + yu(), g()), ms(i2, rect.height() + w() + op(), of()));
        }

        public void zb() {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int ms(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void ms(String str) {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                recyclerView.ms(str);
            }
        }

        public boolean ms() {
            return this.ub;
        }

        public final boolean u() {
            return this.d;
        }

        void xr(RecyclerView recyclerView) {
            this.u = true;
            ah(recyclerView);
        }

        void xr(RecyclerView recyclerView, ao aoVar) {
            this.u = false;
            ms(recyclerView, aoVar);
        }

        public boolean ub() {
            RecyclerView recyclerView = this.ny;
            return recyclerView != null && recyclerView.ny;
        }

        public void ms(ao aoVar, t tVar) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public ch ms(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof ch) {
                return new ch((ch) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new ch((ViewGroup.MarginLayoutParams) layoutParams) : new ch(layoutParams);
        }

        public ch ms(Context context, AttributeSet attributeSet) {
            return new ch(context, attributeSet);
        }

        public void ms(RecyclerView recyclerView, t tVar, int i) {
            com.bytedance.sdk.component.utils.sl.d("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void ms(y yVar) {
            y yVar2 = this.sl;
            if (yVar2 != null && yVar != yVar2 && yVar2.ab()) {
                this.sl.ka();
            }
            this.sl = yVar;
            yVar.ms(this.ny, this);
        }

        public boolean ao() {
            y yVar = this.sl;
            return yVar != null && yVar.ab();
        }

        public int h() {
            return com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(this.ny);
        }

        public void ms(View view) {
            ms(view, -1);
        }

        public void ms(View view, int i) {
            ms(view, i, true);
        }

        public void xr(View view) {
            xr(view, -1);
        }

        public void xr(View view, int i) {
            ms(view, i, false);
        }

        private void ms(View view, int i, boolean z) {
            re reVarKa = RecyclerView.ka(view);
            if (!z && !reVarKa.h()) {
                this.ny.x.c(reVarKa);
            } else {
                this.ny.x.ka(reVarKa);
            }
            ch chVar = (ch) view.getLayoutParams();
            if (!reVarKa.hi() && !reVarKa.ny()) {
                if (view.getParent() == this.ny) {
                    int iXr = this.x.xr(view);
                    if (i == -1) {
                        i = this.x.xr();
                    }
                    if (iXr == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.ny.indexOfChild(view) + this.ny.ms());
                    }
                    if (iXr != i) {
                        this.ny.u.d(iXr, i);
                    }
                } else {
                    this.x.ms(view, i, false);
                    chVar.ah = true;
                    y yVar = this.sl;
                    if (yVar != null && yVar.ab()) {
                        this.sl.xr(view);
                    }
                }
            } else {
                if (reVarKa.ny()) {
                    reVarKa.ch();
                } else {
                    reVarKa.sl();
                }
                this.x.ms(view, i, view.getLayoutParams(), false);
            }
            if (chVar.d) {
                reVarKa.f1391ms.invalidate();
                chVar.d = false;
            }
        }

        public void ah(View view) {
            this.x.ms(view);
        }

        public void c(int i) {
            if (x(i) != null) {
                this.x.ms(i);
            }
        }

        public int d(View view) {
            return ((ch) view.getLayoutParams()).d();
        }

        public View xr(int i) {
            int iY = y();
            for (int i2 = 0; i2 < iY; i2++) {
                View viewX = x(i2);
                re reVarKa = RecyclerView.ka(viewX);
                if (reVarKa != null && reVarKa.d() == i && !reVarKa.M_() && (this.ny.cv.ms() || !reVarKa.h())) {
                    return viewX;
                }
            }
            return null;
        }

        public void ab(int i) {
            ms(i, x(i));
        }

        private void ms(int i, View view) {
            this.x.ka(i);
        }

        public void ms(View view, int i, ch chVar) {
            re reVarKa = RecyclerView.ka(view);
            if (reVarKa.h()) {
                this.ny.x.ka(reVarKa);
            } else {
                this.ny.x.c(reVarKa);
            }
            this.x.ms(view, i, chVar, reVarKa.h());
        }

        public void ah(View view, int i) {
            ms(view, i, (ch) view.getLayoutParams());
        }

        public void d(int i, int i2) {
            View viewX = x(i);
            if (viewX == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.ny.toString());
            }
            ab(i);
            ah(viewX, i2);
        }

        public void ms(View view, ao aoVar) {
            ah(view);
            aoVar.ms(view);
        }

        public void ms(int i, ao aoVar) {
            View viewX = x(i);
            c(i);
            aoVar.ms(viewX);
        }

        public int y() {
            com.bytedance.sdk.component.widget.recycler.xr xrVar = this.x;
            if (xrVar != null) {
                return xrVar.xr();
            }
            return 0;
        }

        public View x(int i) {
            com.bytedance.sdk.component.widget.recycler.xr xrVar = this.x;
            if (xrVar != null) {
                return xrVar.xr(i);
            }
            return null;
        }

        public int t() {
            return this.ka;
        }

        public int nw() {
            return this.c;
        }

        public int b() {
            return this.ab;
        }

        public int re() {
            return this.qv;
        }

        public int i() {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int w() {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int yu() {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int op() {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View le() {
            View focusedChild;
            RecyclerView recyclerView = this.ny;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.x.ah(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int cv() {
            RecyclerView recyclerView = this.ny;
            ms adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.ms();
            }
            return 0;
        }

        public void ny(int i) {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                recyclerView.c(i);
            }
        }

        public void ch(int i) {
            RecyclerView recyclerView = this.ny;
            if (recyclerView != null) {
                recyclerView.ka(i);
            }
        }

        public void ms(ao aoVar) {
            for (int iY = y() - 1; iY >= 0; iY--) {
                ms(aoVar, iY, x(iY));
            }
        }

        private void ms(ao aoVar, int i, View view) {
            re reVarKa = RecyclerView.ka(view);
            if (reVarKa.M_()) {
                return;
            }
            if (reVarKa.u() && !reVarKa.h() && !this.ny.zb.xr()) {
                c(i);
                aoVar.xr(reVarKa);
            } else {
                ab(i);
                aoVar.ah(view);
                this.ny.x.x(reVarKa);
            }
        }

        void xr(ao aoVar) {
            int iKa = aoVar.ka();
            for (int i = iKa - 1; i >= 0; i--) {
                View viewD = aoVar.d(i);
                re reVarKa = RecyclerView.ka(viewD);
                if (!reVarKa.M_()) {
                    reVarKa.ms(false);
                    if (reVarKa.qv()) {
                        this.ny.removeDetachedView(viewD, false);
                    }
                    if (this.ny.w != null) {
                        this.ny.w.d(reVarKa);
                    }
                    reVarKa.ms(true);
                    aoVar.xr(viewD);
                }
            }
            aoVar.c();
            if (iKa > 0) {
                this.ny.invalidate();
            }
        }

        boolean ms(View view, int i, int i2, ch chVar) {
            return (!view.isLayoutRequested() && this.ah && xr(view.getWidth(), i, chVar.width) && xr(view.getHeight(), i2, chVar.height)) ? false : true;
        }

        private static boolean xr(int i, int i2, int i3) {
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

        public void ms(View view, int i, int i2) {
            ch chVar = (ch) view.getLayoutParams();
            Rect rectNy = this.ny.ny(view);
            int i3 = i + rectNy.left + rectNy.right;
            int i4 = i2 + rectNy.top + rectNy.bottom;
            int iMs = ms(b(), t(), i() + yu() + chVar.leftMargin + chVar.rightMargin + i3, chVar.width, ah());
            int iMs2 = ms(re(), nw(), w() + op() + chVar.topMargin + chVar.bottomMargin + i4, chVar.height, d());
            if (ms(view, iMs, iMs2, chVar)) {
                view.measure(iMs, iMs2);
            }
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        /* JADX WARN: Code duplicated, block: B:13:0x001e  */
        /* JADX WARN: Code duplicated, block: B:19:0x002c  */
        public static int ms(int i, int i2, int i3, int i4, boolean z) {
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

        public int ka(View view) {
            Rect rect = ((ch) view.getLayoutParams()).xr;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int c(View view) {
            Rect rect = ((ch) view.getLayoutParams()).xr;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void ms(View view, int i, int i2, int i3, int i4) {
            ch chVar = (ch) view.getLayoutParams();
            Rect rect = chVar.xr;
            view.layout(i + rect.left + chVar.leftMargin, i2 + rect.top + chVar.topMargin, (i3 - rect.right) - chVar.rightMargin, (i4 - rect.bottom) - chVar.bottomMargin);
        }

        public void ms(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((ch) view.getLayoutParams()).xr;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.ny != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.ny.sl;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void ms(View view, Rect rect) {
            RecyclerView.ms(view, rect);
        }

        public int ab(View view) {
            return view.getLeft() - zb(view);
        }

        public int x(View view) {
            return view.getTop() - hi(view);
        }

        public int ny(View view) {
            return view.getRight() + u(view);
        }

        public int ch(View view) {
            return view.getBottom() + sl(view);
        }

        public int hi(View view) {
            return ((ch) view.getLayoutParams()).xr.top;
        }

        public int sl(View view) {
            return ((ch) view.getLayoutParams()).xr.bottom;
        }

        public int zb(View view) {
            return ((ch) view.getLayoutParams()).xr.left;
        }

        public int u(View view) {
            return ((ch) view.getLayoutParams()).xr.right;
        }

        private int[] xr(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int i = i();
            int iW = w();
            int iB = b() - yu();
            int iRe = re() - op();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i2 = left - i;
            int iMin = Math.min(0, i2);
            int i3 = top - iW;
            int iMin2 = Math.min(0, i3);
            int i4 = iWidth - iB;
            int iMax = Math.max(0, i4);
            int iMax2 = Math.max(0, iHeight - iRe);
            if (h() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i2, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i4);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i3, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean ms(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return ms(recyclerView, view, rect, z, false);
        }

        public boolean ms(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrXr = xr(recyclerView, view, rect, z);
            int i = iArrXr[0];
            int i2 = iArrXr[1];
            if ((z2 && !ms(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.ms(i, i2);
            }
            return true;
        }

        private boolean ms(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int i3 = i();
            int iW = w();
            int iB = b() - yu();
            int iRe = re() - op();
            Rect rect = this.ny.hi;
            ms(focusedChild, rect);
            return rect.left - i < iB && rect.right - i > i3 && rect.top - i2 < iRe && rect.bottom - i2 > iW;
        }

        @Deprecated
        public boolean ms(RecyclerView recyclerView, View view, View view2) {
            return ao() || recyclerView.u();
        }

        public boolean ms(RecyclerView recyclerView, t tVar, View view, View view2) {
            return ms(recyclerView, view, view2);
        }

        public void ms(ao aoVar, t tVar, int i, int i2) {
            this.ny.ka(i, i2);
        }

        public void ka(int i, int i2) {
            this.ny.setMeasuredDimension(i, i2);
        }

        public int g() {
            return com.bytedance.sdk.component.widget.recycler.ms.ah.ab.d(this.ny);
        }

        public int of() {
            return com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ka(this.ny);
        }

        void p() {
            y yVar = this.sl;
            if (yVar != null) {
                yVar.ka();
            }
        }

        void xr(y yVar) {
            if (this.sl == yVar) {
                this.sl = null;
            }
        }

        public void ah(ao aoVar) {
            for (int iY = y() - 1; iY >= 0; iY--) {
                if (!RecyclerView.ka(x(iY)).M_()) {
                    ms(iY, aoVar);
                }
            }
        }

        void d(RecyclerView recyclerView) {
            xr(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean pc() {
            int iY = y();
            for (int i = 0; i < iY; i++) {
                ViewGroup.LayoutParams layoutParams = x(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class ms<VH extends re> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final xr f1386ms = new xr();
        private boolean xr = false;

        public abstract int ms();

        public int ms(int i) {
            return 0;
        }

        public abstract VH ms(ViewGroup viewGroup, int i);

        public void ms(VH vh) {
        }

        public abstract void ms(VH vh, int i);

        public long xr(int i) {
            return -1L;
        }

        public boolean xr(VH vh) {
            return false;
        }

        public void ms(VH vh, int i, List<Object> list) {
            ms(vh, i);
        }

        public final VH xr(ViewGroup viewGroup, int i) {
            try {
                com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV CreateView");
                VH vh = (VH) ms(viewGroup, i);
                if (vh.f1391ms.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.c = i;
                com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
                return vh;
            } catch (Throwable th) {
                com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
                throw th;
            }
        }

        public final void xr(VH vh, int i) {
            vh.ah = i;
            if (xr()) {
                vh.ka = xr(i);
            }
            vh.ms(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms("RV OnBindView");
            ms(vh, i, vh.nw());
            vh.t();
            ViewGroup.LayoutParams layoutParams = vh.f1391ms.getLayoutParams();
            if (layoutParams instanceof ch) {
                ((ch) layoutParams).ah = true;
            }
            com.bytedance.sdk.component.widget.recycler.ms.ms.ms.ms();
        }

        public final boolean xr() {
            return this.xr;
        }

        public void ms(ah ahVar) {
            this.f1386ms.registerObserver(ahVar);
        }

        public void xr(ah ahVar) {
            this.f1386ms.unregisterObserver(ahVar);
        }

        public final void ah() {
            this.f1386ms.ms();
        }

        public final void ms(int i, Object obj) {
            this.f1386ms.ms(i, 1, obj);
        }

        public final void ms(int i, int i2) {
            this.f1386ms.ms(i, i2);
        }
    }

    public final class ao {
        private final List<re> ab;
        final ArrayList<re> ah;
        int d;
        ub ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final ArrayList<re> f1381ms;
        private nw ny;
        private int x;
        ArrayList<re> xr;

        public ao() {
            ArrayList<re> arrayList = new ArrayList<>();
            this.f1381ms = arrayList;
            this.xr = null;
            this.ah = new ArrayList<>();
            this.ab = Collections.unmodifiableList(arrayList);
            this.x = 2;
            this.d = 2;
        }

        public void ms() {
            this.f1381ms.clear();
            d();
        }

        public void ms(int i) {
            this.x = i;
            xr();
        }

        void xr() {
            this.d = this.x + (RecyclerView.this.u != null ? RecyclerView.this.u.ao : 0);
            for (int size = this.ah.size() - 1; size >= 0 && this.ah.size() > this.d; size--) {
                ah(size);
            }
        }

        public List<re> ah() {
            return this.ab;
        }

        boolean ms(re reVar) {
            if (reVar.h()) {
                return RecyclerView.this.cv.ms();
            }
            if (reVar.ah >= 0 && reVar.ah < RecyclerView.this.zb.ms()) {
                if (RecyclerView.this.cv.ms() || RecyclerView.this.zb.ms(reVar.ah) == reVar.x()) {
                    return !RecyclerView.this.zb.xr() || reVar.ab() == RecyclerView.this.zb.xr(reVar.ah);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + reVar + RecyclerView.this.ms());
        }

        private boolean ms(re reVar, int i, int i2, long j) {
            reVar.ao = RecyclerView.this;
            int iX = reVar.x();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.ka.xr(iX, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.zb.xr(reVar, i);
            this.ka.xr(reVar.x(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.cv.ms()) {
                return true;
            }
            reVar.ab = i2;
            return true;
        }

        public View xr(int i) {
            return ms(i, false);
        }

        View ms(int i, boolean z) {
            return ms(i, z, Long.MAX_VALUE).f1391ms;
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
          0x0182: PHI (r1v18 com.bytedance.sdk.component.widget.recycler.RecyclerView$re) = 
          (r1v17 com.bytedance.sdk.component.widget.recycler.RecyclerView$re)
          (r1v43 com.bytedance.sdk.component.widget.recycler.RecyclerView$re)
         binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]
          0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:82:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:88:0x01d1  */
        /* JADX WARN: Code duplicated, block: B:90:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:99:0x0201  */
        re ms(int i, boolean z, long j) {
            re reVarXr;
            boolean z2;
            re reVar;
            boolean z3;
            boolean zMs;
            ViewGroup.LayoutParams layoutParams;
            ch chVar;
            int iXr;
            RecyclerView recyclerViewCh;
            nw nwVar;
            View viewMs;
            if (i >= 0 && i < RecyclerView.this.cv.d()) {
                if (RecyclerView.this.cv.ms()) {
                    reVarXr = ka(i);
                    if (reVarXr != null) {
                        z2 = true;
                    }
                    if (reVarXr == null && (reVarXr = xr(i, z)) != null) {
                        if (ms(reVarXr)) {
                            z2 = true;
                        } else {
                            if (!z) {
                                reVarXr.xr(4);
                                if (reVarXr.ny()) {
                                    RecyclerView.this.removeDetachedView(reVarXr.f1391ms, false);
                                    reVarXr.ch();
                                } else if (reVarXr.hi()) {
                                    reVarXr.sl();
                                }
                                xr(reVarXr);
                            }
                            reVarXr = null;
                        }
                    }
                    if (reVarXr == null) {
                        reVar = reVarXr;
                    } else {
                        iXr = RecyclerView.this.c.xr(i);
                        if (iXr >= 0 || iXr >= RecyclerView.this.zb.ms()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iXr + ").state:" + RecyclerView.this.cv.d() + RecyclerView.this.ms());
                        }
                        int iMs = RecyclerView.this.zb.ms(iXr);
                        if (RecyclerView.this.zb.xr() && (reVarXr = ms(RecyclerView.this.zb.xr(iXr), iMs, z)) != null) {
                            reVarXr.ah = iXr;
                            z2 = true;
                        }
                        if (reVarXr == null && (nwVar = this.ny) != null && (viewMs = nwVar.ms(this, i, iMs)) != null) {
                            reVarXr = RecyclerView.this.xr(viewMs);
                            if (reVarXr == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.ms());
                            }
                            if (reVarXr.M_()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.ms());
                            }
                        }
                        if (reVarXr == null) {
                            re reVarMs = ab().ms(iMs);
                            if (reVarMs != null) {
                                reVarMs.b();
                                if (RecyclerView.f1374ms) {
                                    ka(reVarMs);
                                }
                            }
                            reVarXr = reVarMs;
                        }
                        if (reVarXr == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j != Long.MAX_VALUE && !this.ka.ms(iMs, nanoTime, j)) {
                                return null;
                            }
                            re reVarXr2 = RecyclerView.this.zb.xr(RecyclerView.this, iMs);
                            if (RecyclerView.d && (recyclerViewCh = RecyclerView.ch(reVarXr2.f1391ms)) != null) {
                                reVarXr2.xr = new WeakReference<>(recyclerViewCh);
                            }
                            this.ka.ms(iMs, RecyclerView.this.getNanoTime() - nanoTime);
                            reVar = reVarXr2;
                        } else {
                            reVar = reVarXr;
                        }
                    }
                    z3 = z2;
                    if (z3 && !RecyclerView.this.cv.ms() && reVar.ms(8192)) {
                        reVar.ms(0, 8192);
                        if (RecyclerView.this.cv.ch) {
                            RecyclerView.this.ms(reVar, RecyclerView.this.w.ms(RecyclerView.this.cv, reVar, c.ka(reVar) | 4096, reVar.nw()));
                        }
                    }
                    if (!RecyclerView.this.cv.ms() && reVar.ao()) {
                        reVar.ab = i;
                    } else {
                        if (reVar.ao() || reVar.ub() || reVar.u()) {
                            zMs = ms(reVar, RecyclerView.this.c.xr(i), i, j);
                        }
                        layoutParams = reVar.f1391ms.getLayoutParams();
                        if (layoutParams == null) {
                            chVar = (ch) RecyclerView.this.generateDefaultLayoutParams();
                            reVar.f1391ms.setLayoutParams(chVar);
                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                            chVar = (ch) RecyclerView.this.generateLayoutParams(layoutParams);
                            reVar.f1391ms.setLayoutParams(chVar);
                        } else {
                            chVar = (ch) layoutParams;
                        }
                        chVar.f1385ms = reVar;
                        chVar.d = !z3 && zMs;
                        return reVar;
                    }
                    zMs = false;
                    layoutParams = reVar.f1391ms.getLayoutParams();
                    if (layoutParams == null) {
                        chVar = (ch) RecyclerView.this.generateDefaultLayoutParams();
                        reVar.f1391ms.setLayoutParams(chVar);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                        chVar = (ch) RecyclerView.this.generateLayoutParams(layoutParams);
                        reVar.f1391ms.setLayoutParams(chVar);
                    } else {
                        chVar = (ch) layoutParams;
                    }
                    chVar.f1385ms = reVar;
                    chVar.d = !z3 && zMs;
                    return reVar;
                }
                reVarXr = null;
                z2 = false;
                if (reVarXr == null) {
                    if (ms(reVarXr)) {
                        if (!z) {
                            reVarXr.xr(4);
                            if (reVarXr.ny()) {
                                RecyclerView.this.removeDetachedView(reVarXr.f1391ms, false);
                                reVarXr.ch();
                            } else if (reVarXr.hi()) {
                                reVarXr.sl();
                            }
                            xr(reVarXr);
                        }
                        reVarXr = null;
                    } else {
                        z2 = true;
                    }
                }
                if (reVarXr == null) {
                    iXr = RecyclerView.this.c.xr(i);
                    if (iXr >= 0) {
                    }
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iXr + ").state:" + RecyclerView.this.cv.d() + RecyclerView.this.ms());
                }
                reVar = reVarXr;
                z3 = z2;
                if (z3) {
                    reVar.ms(0, 8192);
                    if (RecyclerView.this.cv.ch) {
                        RecyclerView.this.ms(reVar, RecyclerView.this.w.ms(RecyclerView.this.cv, reVar, c.ka(reVar) | 4096, reVar.nw()));
                    }
                }
                if (!RecyclerView.this.cv.ms()) {
                    if (reVar.ao()) {
                    }
                    zMs = ms(reVar, RecyclerView.this.c.xr(i), i, j);
                } else {
                    if (reVar.ao()) {
                    }
                    zMs = ms(reVar, RecyclerView.this.c.xr(i), i, j);
                }
                layoutParams = reVar.f1391ms.getLayoutParams();
                if (layoutParams == null) {
                    chVar = (ch) RecyclerView.this.generateDefaultLayoutParams();
                    reVar.f1391ms.setLayoutParams(chVar);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                    chVar = (ch) RecyclerView.this.generateLayoutParams(layoutParams);
                    reVar.f1391ms.setLayoutParams(chVar);
                } else {
                    chVar = (ch) layoutParams;
                }
                chVar.f1385ms = reVar;
                chVar.d = !z3 && zMs;
                return reVar;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.cv.d() + RecyclerView.this.ms());
        }

        private void ka(re reVar) {
            if (reVar.f1391ms instanceof ViewGroup) {
                ms((ViewGroup) reVar.f1391ms, false);
            }
        }

        private void ms(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    ms((ViewGroup) childAt, true);
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

        public void ms(View view) {
            re reVarKa = RecyclerView.ka(view);
            if (reVarKa.qv()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (reVarKa.ny()) {
                reVarKa.ch();
            } else if (reVarKa.hi()) {
                reVarKa.sl();
            }
            xr(reVarKa);
        }

        void d() {
            for (int size = this.ah.size() - 1; size >= 0; size--) {
                ah(size);
            }
            this.ah.clear();
            if (RecyclerView.d) {
                RecyclerView.this.le.ms();
            }
        }

        void ah(int i) {
            ms(this.ah.get(i), true);
            this.ah.remove(i);
        }

        void xr(re reVar) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (!reVar.ny() && reVar.f1391ms.getParent() == null) {
                if (reVar.qv()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + reVar + RecyclerView.this.ms());
                }
                if (reVar.M_()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.ms());
                }
                boolean zW = reVar.w();
                if ((RecyclerView.this.zb != null && zW && RecyclerView.this.zb.xr(reVar)) || reVar.re()) {
                    if (this.d <= 0 || reVar.ms(526)) {
                        z = false;
                    } else {
                        int size = this.ah.size();
                        if (size >= this.d && size > 0) {
                            ah(0);
                            size--;
                        }
                        if (RecyclerView.d && size > 0 && !RecyclerView.this.le.ms(reVar.ah)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.le.ms(this.ah.get(i).ah)) {
                                    break;
                                } else {
                                    i--;
                                }
                            }
                            size = i + 1;
                        }
                        this.ah.add(size, reVar);
                        z = true;
                    }
                    if (z) {
                        z3 = false;
                    } else {
                        ms(reVar, true);
                    }
                    z2 = z;
                } else {
                    z3 = false;
                }
                RecyclerView.this.x.ab(reVar);
                if (z2 || z3 || !zW) {
                    return;
                }
                reVar.ao = null;
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + reVar.ny() + " isAttached:" + (reVar.f1391ms.getParent() != null) + RecyclerView.this.ms());
        }

        void ms(re reVar, boolean z) {
            RecyclerView.ah(reVar);
            if (reVar.ms(16384)) {
                reVar.ms(0, 16384);
            }
            if (z) {
                d(reVar);
            }
            reVar.ao = null;
            ab().ms(reVar);
        }

        void xr(View view) {
            re reVarKa = RecyclerView.ka(view);
            reVarKa.zb = null;
            reVarKa.u = false;
            reVarKa.sl();
            xr(reVarKa);
        }

        void ah(View view) {
            re reVarKa = RecyclerView.ka(view);
            if (!reVarKa.ms(12) && reVarKa.yu() && !RecyclerView.this.xr(reVarKa)) {
                if (this.xr == null) {
                    this.xr = new ArrayList<>();
                }
                reVarKa.ms(this, true);
                this.xr.add(reVarKa);
                return;
            }
            if (reVarKa.u() && !reVarKa.h() && !RecyclerView.this.zb.xr()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.ms());
            }
            reVarKa.ms(this, false);
            this.f1381ms.add(reVarKa);
        }

        void ah(re reVar) {
            if (reVar.u) {
                this.xr.remove(reVar);
            } else {
                this.f1381ms.remove(reVar);
            }
            reVar.zb = null;
            reVar.u = false;
            reVar.sl();
        }

        int ka() {
            return this.f1381ms.size();
        }

        View d(int i) {
            return this.f1381ms.get(i).f1391ms;
        }

        void c() {
            this.f1381ms.clear();
            ArrayList<re> arrayList = this.xr;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        re ka(int i) {
            int size;
            int iXr;
            ArrayList<re> arrayList = this.xr;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    re reVar = this.xr.get(i2);
                    if (!reVar.hi() && reVar.d() == i) {
                        reVar.xr(32);
                        return reVar;
                    }
                }
                if (RecyclerView.this.zb.xr() && (iXr = RecyclerView.this.c.xr(i)) > 0 && iXr < RecyclerView.this.zb.ms()) {
                    long jXr = RecyclerView.this.zb.xr(iXr);
                    for (int i3 = 0; i3 < size; i3++) {
                        re reVar2 = this.xr.get(i3);
                        if (!reVar2.hi() && reVar2.ab() == jXr) {
                            reVar2.xr(32);
                            return reVar2;
                        }
                    }
                }
            }
            return null;
        }

        re xr(int i, boolean z) {
            View viewAh;
            int size = this.f1381ms.size();
            for (int i2 = 0; i2 < size; i2++) {
                re reVar = this.f1381ms.get(i2);
                if (!reVar.hi() && reVar.d() == i && !reVar.u() && (RecyclerView.this.cv.ab || !reVar.h())) {
                    reVar.xr(32);
                    return reVar;
                }
            }
            if (!z && (viewAh = RecyclerView.this.ab.ah(i)) != null) {
                re reVarKa = RecyclerView.ka(viewAh);
                RecyclerView.this.ab.ka(viewAh);
                int iXr = RecyclerView.this.ab.xr(viewAh);
                if (iXr == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + reVarKa + RecyclerView.this.ms());
                }
                RecyclerView.this.ab.ka(iXr);
                ah(viewAh);
                reVarKa.xr(8224);
                return reVarKa;
            }
            int size2 = this.ah.size();
            for (int i3 = 0; i3 < size2; i3++) {
                re reVar2 = this.ah.get(i3);
                if (!reVar2.u() && reVar2.d() == i) {
                    if (!z) {
                        this.ah.remove(i3);
                    }
                    return reVar2;
                }
            }
            return null;
        }

        re ms(long j, int i, boolean z) {
            for (int size = this.f1381ms.size() - 1; size >= 0; size--) {
                re reVar = this.f1381ms.get(size);
                if (reVar.ab() == j && !reVar.hi()) {
                    if (i == reVar.x()) {
                        reVar.xr(32);
                        if (reVar.h() && !RecyclerView.this.cv.ms()) {
                            reVar.ms(2, 14);
                        }
                        return reVar;
                    }
                    if (!z) {
                        this.f1381ms.remove(size);
                        RecyclerView.this.removeDetachedView(reVar.f1391ms, false);
                        xr(reVar.f1391ms);
                    }
                }
            }
            int size2 = this.ah.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                re reVar2 = this.ah.get(size2);
                if (reVar2.ab() == j) {
                    if (i == reVar2.x()) {
                        if (!z) {
                            this.ah.remove(size2);
                        }
                        return reVar2;
                    }
                    if (!z) {
                        ah(size2);
                        return null;
                    }
                }
            }
        }

        void d(re reVar) {
            if (RecyclerView.this.zb != null) {
                RecyclerView.this.zb.ms(reVar);
            }
            if (RecyclerView.this.cv != null) {
                RecyclerView.this.x.ab(reVar);
            }
        }

        void ms(ms msVar, ms msVar2, boolean z) {
            ms();
            ab().ms(msVar, msVar2, z);
        }

        void ms(int i, int i2) {
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
            int size = this.ah.size();
            for (int i6 = 0; i6 < size; i6++) {
                re reVar = this.ah.get(i6);
                if (reVar != null && reVar.ah >= i5 && reVar.ah <= i4) {
                    if (reVar.ah == i) {
                        reVar.ms(i2 - i, false);
                    } else {
                        reVar.ms(i3, false);
                    }
                }
            }
        }

        void xr(int i, int i2) {
            int size = this.ah.size();
            for (int i3 = 0; i3 < size; i3++) {
                re reVar = this.ah.get(i3);
                if (reVar != null && reVar.ah >= i) {
                    reVar.ms(i2, true);
                }
            }
        }

        void ms(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.ah.size() - 1; size >= 0; size--) {
                re reVar = this.ah.get(size);
                if (reVar != null) {
                    if (reVar.ah >= i3) {
                        reVar.ms(-i2, z);
                    } else if (reVar.ah >= i) {
                        reVar.xr(8);
                        ah(size);
                    }
                }
            }
        }

        void ms(nw nwVar) {
            this.ny = nwVar;
        }

        void ms(ub ubVar) {
            ub ubVar2 = this.ka;
            if (ubVar2 != null) {
                ubVar2.ah();
            }
            this.ka = ubVar;
            if (ubVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.ka.xr();
        }

        ub ab() {
            if (this.ka == null) {
                this.ka = new ub();
            }
            return this.ka;
        }

        void ah(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.ah.size() - 1; size >= 0; size--) {
                re reVar = this.ah.get(size);
                if (reVar != null && (i3 = reVar.ah) >= i && i3 < i4) {
                    reVar.xr(2);
                    ah(size);
                }
            }
        }

        void x() {
            int size = this.ah.size();
            for (int i = 0; i < size; i++) {
                re reVar = this.ah.get(i);
                if (reVar != null) {
                    reVar.xr(6);
                    reVar.ms((Object) null);
                }
            }
            if (RecyclerView.this.zb == null || !RecyclerView.this.zb.xr()) {
                d();
            }
        }

        void ny() {
            int size = this.ah.size();
            for (int i = 0; i < size; i++) {
                this.ah.get(i).ms();
            }
            int size2 = this.f1381ms.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f1381ms.get(i2).ms();
            }
            ArrayList<re> arrayList = this.xr;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.xr.get(i3).ms();
                }
            }
        }

        void ch() {
            int size = this.ah.size();
            for (int i = 0; i < size; i++) {
                ch chVar = (ch) this.ah.get(i).f1391ms.getLayoutParams();
                if (chVar != null) {
                    chVar.ah = true;
                }
            }
        }
    }

    public static class ub {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        SparseArray<ms> f1393ms = new SparseArray<>();
        private int xr = 0;

        public void ms() {
            for (int i = 0; i < this.f1393ms.size(); i++) {
                this.f1393ms.valueAt(i).f1394ms.clear();
            }
        }

        public re ms(int i) {
            ms msVar = this.f1393ms.get(i);
            if (msVar == null || msVar.f1394ms.isEmpty()) {
                return null;
            }
            ArrayList<re> arrayList = msVar.f1394ms;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void ms(re reVar) {
            int iX = reVar.x();
            ArrayList<re> arrayList = xr(iX).f1394ms;
            if (this.f1393ms.get(iX).xr > arrayList.size()) {
                reVar.b();
                arrayList.add(reVar);
            }
        }

        long ms(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void ms(int i, long j) {
            ms msVarXr = xr(i);
            msVarXr.ah = ms(msVarXr.ah, j);
        }

        void xr(int i, long j) {
            ms msVarXr = xr(i);
            msVarXr.d = ms(msVarXr.d, j);
        }

        boolean ms(int i, long j, long j2) {
            long j3 = xr(i).ah;
            return j3 == 0 || j + j3 < j2;
        }

        boolean xr(int i, long j, long j2) {
            long j3 = xr(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        void xr() {
            this.xr++;
        }

        void ah() {
            this.xr--;
        }

        void ms(ms msVar, ms msVar2, boolean z) {
            if (msVar != null) {
                ah();
            }
            if (!z && this.xr == 0) {
                ms();
            }
            if (msVar2 != null) {
                xr();
            }
        }

        private ms xr(int i) {
            ms msVar = this.f1393ms.get(i);
            if (msVar != null) {
                return msVar;
            }
            ms msVar2 = new ms();
            this.f1393ms.put(i, msVar2);
            return msVar2;
        }

        static class ms {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            final ArrayList<re> f1394ms = new ArrayList<>();
            int xr = 5;
            long ah = 0;
            long d = 0;

            ms() {
            }
        }
    }

    public static class ka {
        protected EdgeEffect ms(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    private class qv extends ah {
        qv() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ah
        public void ms() {
            RecyclerView.this.ms((String) null);
            RecyclerView.this.cv.c = true;
            RecyclerView.this.ah(true);
            if (RecyclerView.this.c.d()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ah
        public void ms(int i, int i2, Object obj) {
            RecyclerView.this.ms((String) null);
            if (RecyclerView.this.c.ms(i, i2, obj)) {
                xr();
            }
        }

        void xr() {
            if (RecyclerView.ah && RecyclerView.this.qv && RecyclerView.this.h) {
                RecyclerView recyclerView = RecyclerView.this;
                com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(recyclerView, recyclerView.ch);
            } else {
                RecyclerView.this.b = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    class b implements Runnable {
        private int d;
        private int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        OverScroller f1382ms;
        Interpolator xr = RecyclerView.ul;
        private boolean c = false;
        private boolean ab = false;

        b() {
            this.f1382ms = new OverScroller(RecyclerView.this.getContext(), RecyclerView.ul);
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
            if (RecyclerView.this.u == null) {
                xr();
                return;
            }
            ah();
            RecyclerView.this.d();
            OverScroller overScroller = this.f1382ms;
            y yVar = RecyclerView.this.u.sl;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.pc;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.d;
                int i7 = currY - this.ka;
                this.d = currX;
                this.ka = currY;
                if (RecyclerView.this.ms(i6, i7, iArr, null, 1)) {
                    i6 -= iArr[0];
                    i7 -= iArr[1];
                }
                if (RecyclerView.this.zb != null) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.ms(i6, i7, recyclerView.jw);
                    i = RecyclerView.this.jw[0];
                    i2 = RecyclerView.this.jw[1];
                    i3 = i6 - i;
                    i4 = i7 - i2;
                    if (yVar != null && !yVar.c() && yVar.ab()) {
                        int iD = RecyclerView.this.cv.d();
                        if (iD == 0) {
                            yVar.ka();
                        } else {
                            if (yVar.x() >= iD) {
                                yVar.ah(iD - 1);
                            }
                            yVar.ms(i6 - i3, i7 - i4);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.ao.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.ah(i6, i7);
                }
                if (!RecyclerView.this.ms(i, i2, i3, i4, (int[]) null, 1) && (i3 != 0 || i4 != 0)) {
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
                        RecyclerView.this.d(i5, currVelocity);
                    }
                    if ((i5 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (i != 0 || i2 != 0) {
                    RecyclerView.this.x(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i6 == 0 && i7 == 0) || (i6 != 0 && RecyclerView.this.u.ah() && i == i6) || (i7 != 0 && RecyclerView.this.u.d() && i2 == i7);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.ny(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.d) {
                        RecyclerView.this.le.ms();
                    }
                    RecyclerView.this.x(1);
                } else {
                    ms();
                    if (RecyclerView.this.op != null) {
                        RecyclerView.this.op.ms(RecyclerView.this, i6, i7);
                    }
                }
            }
            if (yVar != null) {
                if (yVar.c()) {
                    yVar.ms(0, 0);
                }
                if (!this.ab) {
                    yVar.ka();
                }
            }
            d();
        }

        private void ah() {
            this.ab = false;
            this.c = true;
        }

        private void d() {
            this.c = false;
            if (this.ab) {
                ms();
            }
        }

        void ms() {
            if (this.c) {
                this.ab = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.ms.ah.ab.ms(RecyclerView.this, this);
            }
        }

        public void ms(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.ka = 0;
            this.d = 0;
            this.f1382ms.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            ms();
        }

        public void xr(int i, int i2) {
            ms(i, i2, 0, 0);
        }

        public void ms(int i, int i2, int i3, int i4) {
            ms(i, i2, xr(i, i2, i3, i4));
        }

        private float ms(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int xr(int i, int i2, int i3, int i4) {
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
            float fMs = f2 + (ms(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fMs / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void ms(int i, int i2, int i3) {
            ms(i, i2, i3, RecyclerView.ul);
        }

        public void ms(int i, int i2, Interpolator interpolator) {
            int iXr = xr(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.ul;
            }
            ms(i, i2, iXr, interpolator);
        }

        public void ms(int i, int i2, int i3, Interpolator interpolator) {
            if (this.xr != interpolator) {
                this.xr = interpolator;
                this.f1382ms = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.ka = 0;
            this.d = 0;
            this.f1382ms.startScroll(0, 0, i, i2, i3);
            ms();
        }

        public void xr() {
            RecyclerView.this.removeCallbacks(this);
            this.f1382ms.abortAnimation();
        }
    }
}
