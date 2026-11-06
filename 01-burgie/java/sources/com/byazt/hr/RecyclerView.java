package com.byazt.hr;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
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
import com.taptap.sdk.update.download.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, 1327})
public class RecyclerView extends ViewGroup implements com.byazt.vu.hn {
    public static final boolean hn;
    public static final boolean hw;
    public static final Interpolator ls;
    public static final Class<?>[] of;
    public static final boolean pr;
    public static final boolean qi;
    public static final boolean qn;
    public static final boolean x;
    public boolean a;
    public int aa;
    public final int[] ag;
    public boolean aj;
    public final ny b;
    public final int bh;
    public List<w> bm;
    public final nt c;
    public int cr;
    public boolean cz;
    public int d;
    public final int[] e;
    public uc.pr eh;
    public float ey;
    public final AccessibilityManager f;
    public Runnable fe;
    public boolean fo;
    public com.byazt.hr.hw fw;
    public aj g;
    public int gu;
    public final a gz;
    public yb ho;
    public m hs;
    public final Rect i;
    public boolean ie;
    public final lb ii;
    public com.byazt.hr.x iu;
    public int iy;
    public k j;
    public int jn;
    public int jw;
    public final RectF k;
    public final com.byazt.hr.g.hw ks;
    public int l;
    public boolean lb;
    public c lv;
    public pr m;
    public com.byazt.vu.x mr;
    public EdgeEffect mw;
    public final int[] n;
    public x na;
    public boolean nl;
    public List<g> np;
    public final ArrayList<zo> nt;
    public int nw;
    public boolean ny;
    public int o;
    public EdgeEffect od;
    public float pj;
    public VelocityTracker pq;
    public boolean qa;
    public final int qo;
    public boolean qv;
    public final int[] qx;
    public final ArrayList<m> r;
    public boolean rc;
    public final int[] rk;
    public final List<fo> s;
    public EdgeEffect sv;
    public g u;
    public com.byazt.hr.pr uc;
    public com.byazt.hr.x.pr ve;
    public EdgeEffect vj;
    public final Runnable vk;
    public final Rect w;
    public int wt;
    public boolean ww;
    public boolean y;
    public boolean yb;
    public uc z;
    public final com.byazt.hr.g zo;
    public static final int[] er = {R.attr.nestedScrollingEnabled};
    public static final int[] v = {R.attr.clipToPadding};

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2181})
    public static abstract class cz {
        public abstract View pr(nt ntVar, int i, int i2);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 1037})
    public static abstract class k {
        public abstract boolean pr(int i, int i2);
    }

    public interface m {
        boolean pr(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface w {
        void hw(View view);

        void pr(View view);
    }

    public interface x {
        int pr(int i, int i2);
    }

    public interface yb {
    }

    static {
        pr = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        hw = Build.VERSION.SDK_INT >= 23;
        hn = Build.VERSION.SDK_INT >= 16;
        x = Build.VERSION.SDK_INT >= 21;
        qi = Build.VERSION.SDK_INT <= 15;
        qn = Build.VERSION.SDK_INT <= 15;
        of = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        ls = new Interpolator() { // from class: com.byazt.hr.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ii = new lb();
        this.c = new nt();
        this.zo = new com.byazt.hr.g();
        this.vk = new Runnable() { // from class: com.byazt.hr.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.qa && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.yb) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.cz) {
                        RecyclerView.this.a = true;
                    } else {
                        RecyclerView.this.x();
                    }
                }
            }
        };
        this.w = new Rect();
        this.i = new Rect();
        this.k = new RectF();
        this.nt = new ArrayList<>();
        this.r = new ArrayList<>();
        this.nw = 0;
        this.fo = false;
        this.rc = false;
        this.jn = 0;
        this.l = 0;
        this.lv = new c();
        this.z = new com.byazt.hr.hn();
        this.gu = 0;
        this.d = -1;
        this.pj = Float.MIN_VALUE;
        this.ey = Float.MIN_VALUE;
        this.qv = true;
        this.b = new ny();
        this.ve = x ? new com.byazt.hr.x.pr() : null;
        this.gz = new a();
        this.nl = false;
        this.y = false;
        this.eh = new fw();
        this.ww = false;
        this.rk = new int[2];
        this.ag = new int[2];
        this.n = new int[2];
        this.qx = new int[2];
        this.e = new int[2];
        this.s = new ArrayList();
        this.fe = new Runnable() { // from class: com.byazt.hr.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.z != null) {
                    RecyclerView.this.z.pr();
                }
                RecyclerView.this.ww = false;
            }
        };
        this.ks = new com.byazt.hr.g.hw() { // from class: com.byazt.hr.RecyclerView.3
            @Override // com.byazt.hr.g.hw
            public void pr(fo foVar, uc.hw hwVar, uc.hw hwVar2) {
                RecyclerView.this.c.hn(foVar);
                RecyclerView.this.hw(foVar, hwVar, hwVar2);
            }

            @Override // com.byazt.hr.g.hw
            public void hw(fo foVar, uc.hw hwVar, uc.hw hwVar2) {
                RecyclerView.this.pr(foVar, hwVar, hwVar2);
            }

            @Override // com.byazt.hr.g.hw
            public void hn(fo foVar, uc.hw hwVar, uc.hw hwVar2) {
                foVar.pr(false);
                if (RecyclerView.this.fo) {
                    if (RecyclerView.this.z.pr(foVar, foVar, hwVar, hwVar2)) {
                        RecyclerView.this.ho();
                    }
                } else if (RecyclerView.this.z.hn(foVar, hwVar, hwVar2)) {
                    RecyclerView.this.ho();
                }
            }

            @Override // com.byazt.hr.g.hw
            public void pr(fo foVar) {
                RecyclerView.this.g.pr(foVar.pr, RecyclerView.this.c);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v, i, 0);
                this.aj = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e) {
            }
        } else {
            this.aj = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.cr = viewConfiguration.getScaledTouchSlop();
        this.pj = com.byazt.vu.fw.pr(viewConfiguration, context);
        this.ey = com.byazt.vu.fw.hw(viewConfiguration, context);
        this.qo = viewConfiguration.getScaledMinimumFlingVelocity();
        this.bh = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.z.pr(this.eh);
        hw();
        z();
        rc();
        if (com.byazt.vu.fw.hw(this) == 0) {
            com.byazt.vu.fw.pr(this, 1);
        }
        this.f = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
                if (Build.VERSION.SDK_INT >= 21) {
                }
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
        }
        setNestedScrollingEnabled(true);
    }

    public String pr() {
        return " " + super.toString() + ", adapter:" + this.m + ", layout:" + this.g + ", context:" + getContext();
    }

    private void rc() {
        if (com.byazt.vu.fw.aj(this) == 0) {
            com.byazt.vu.fw.hw(this, 8);
        }
    }

    private void z() {
        this.fw = new com.byazt.hr.hw(new com.byazt.hr.hw.InterfaceC0088hw() { // from class: com.byazt.hr.RecyclerView.4
            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public int pr() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void pr(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.k(view);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public int pr(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void pr(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.w(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public View hw(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void hw() {
                int iPr = pr();
                for (int i = 0; i < iPr; i++) {
                    View viewHw = hw(i);
                    RecyclerView.this.w(viewHw);
                    viewHw.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public fo hw(View view) {
                return RecyclerView.c(view);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void pr(View view, int i, ViewGroup.LayoutParams layoutParams) {
                fo foVarC = RecyclerView.c(view);
                if (foVarC != null) {
                    if (!foVarC.lb() && !foVarC.X_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + foVarC + RecyclerView.this.pr());
                    }
                    foVarC.m();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void hn(int i) {
                fo foVarC;
                View viewHw = hw(i);
                if (viewHw != null && (foVarC = RecyclerView.c(viewHw)) != null) {
                    if (foVarC.lb() && !foVarC.X_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + foVarC + RecyclerView.this.pr());
                    }
                    foVarC.hw(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void hn(View view) {
                fo foVarC = RecyclerView.c(view);
                if (foVarC != null) {
                    foVarC.pr(RecyclerView.this);
                }
            }

            @Override // com.byazt.hr.hw.InterfaceC0088hw
            public void x(View view) {
                fo foVarC = RecyclerView.c(view);
                if (foVarC != null) {
                    foVarC.hw(RecyclerView.this);
                }
            }
        });
    }

    public void hw() {
        this.uc = new com.byazt.hr.pr(new com.byazt.hr.pr.InterfaceC0089pr() { // from class: com.byazt.hr.RecyclerView.5
            @Override // com.byazt.hr.pr.InterfaceC0089pr
            public fo pr(int i) {
                fo foVarPr = RecyclerView.this.pr(i, true);
                if (foVarPr == null || RecyclerView.this.fw.hn(foVarPr.pr)) {
                    return null;
                }
                return foVarPr;
            }

            @Override // com.byazt.hr.pr.InterfaceC0089pr
            public void pr(int i, int i2) {
                RecyclerView.this.pr(i, i2, true);
                RecyclerView.this.nl = true;
                RecyclerView.this.gz.hn += i2;
            }

            @Override // com.byazt.hr.pr.InterfaceC0089pr
            public void hw(int i, int i2) {
                RecyclerView.this.pr(i, i2, false);
                RecyclerView.this.nl = true;
            }

            @Override // com.byazt.hr.pr.InterfaceC0089pr
            public void pr(int i, int i2, Object obj) {
                RecyclerView.this.pr(i, i2, obj);
                RecyclerView.this.y = true;
            }

            @Override // com.byazt.hr.pr.InterfaceC0089pr
            public void hn(int i, int i2) {
                RecyclerView.this.fw(i, i2);
                RecyclerView.this.nl = true;
            }

            @Override // com.byazt.hr.pr.InterfaceC0089pr
            public void x(int i, int i2) {
                RecyclerView.this.uc(i, i2);
                RecyclerView.this.nl = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.lb = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.aj) {
            w();
        }
        this.aj = z;
        super.setClipToPadding(z);
        if (this.qa) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.aj;
    }

    public void setAdapter(pr prVar) {
        setLayoutFrozen(false);
        pr(prVar, false, true);
        hn(false);
        requestLayout();
    }

    public void hn() {
        uc ucVar = this.z;
        if (ucVar != null) {
            ucVar.x();
        }
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.hn(this.c);
            this.g.hw(this.c);
        }
        this.c.pr();
    }

    private void pr(pr prVar, boolean z, boolean z2) {
        pr prVar2 = this.m;
        if (prVar2 != null) {
            prVar2.hw(this.ii);
        }
        if (!z || z2) {
            hn();
        }
        this.uc.pr();
        pr prVar3 = this.m;
        this.m = prVar;
        if (prVar != null) {
            prVar.pr(this.ii);
        }
        this.c.pr(prVar3, this.m, z);
        this.gz.uc = true;
    }

    public pr getAdapter() {
        return this.m;
    }

    public void setRecyclerListener(yb ybVar) {
        this.ho = ybVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        aj ajVar = this.g;
        return ajVar != null ? ajVar.lb() : super.getBaseline();
    }

    public void pr(w wVar) {
        if (this.bm == null) {
            this.bm = new ArrayList();
        }
        this.bm.add(wVar);
    }

    public void setLayoutManager(aj ajVar) {
        if (ajVar != this.g) {
            uc();
            if (this.g != null) {
                uc ucVar = this.z;
                if (ucVar != null) {
                    ucVar.x();
                }
                this.g.hn(this.c);
                this.g.hw(this.c);
                this.c.pr();
                if (this.yb) {
                    this.g.hw(this, this.c);
                }
                this.g.pr((RecyclerView) null);
                this.g = null;
            } else {
                this.c.pr();
            }
            this.fw.pr();
            this.g = ajVar;
            if (ajVar != null) {
                if (ajVar.aj != null) {
                    throw new IllegalArgumentException("LayoutManager " + ajVar + " is already attached to a RecyclerView:" + ajVar.aj.pr());
                }
                this.g.pr(this);
                if (this.yb) {
                    this.g.hw(this);
                }
            }
            this.c.hw();
            requestLayout();
        }
    }

    public void setOnFlingListener(k kVar) {
        this.j = kVar;
    }

    public k getOnFlingListener() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void c(fo foVar) {
        View view = foVar.pr;
        boolean z = view.getParent() == this;
        this.c.hn(hw(view));
        if (foVar.lb()) {
            this.fw.pr(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.fw.pr(view, true);
        } else {
            this.fw.x(view);
        }
    }

    public boolean pr(View view) {
        c();
        boolean zUc = this.fw.uc(view);
        if (zUc) {
            fo foVarC = c(view);
            this.c.hn(foVarC);
            this.c.hw(foVarC);
        }
        pr(!zUc);
        return zUc;
    }

    public aj getLayoutManager() {
        return this.g;
    }

    public ho getRecycledViewPool() {
        return this.c.fw();
    }

    public void setRecycledViewPool(ho hoVar) {
        this.c.pr(hoVar);
    }

    public void setViewCacheExtension(cz czVar) {
        this.c.pr(czVar);
    }

    public void setItemViewCacheSize(int i) {
        this.c.pr(i);
    }

    public int getScrollState() {
        return this.gu;
    }

    public void setScrollState(int i) {
        if (i != this.gu) {
            this.gu = i;
            if (i != 2) {
                iu();
            }
            fw(i);
        }
    }

    public void pr(zo zoVar, int i) {
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.pr("Cannot add item decoration during a scroll  or layout");
        }
        if (this.nt.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.nt.add(zoVar);
        } else {
            this.nt.add(i, zoVar);
        }
        yb();
        requestLayout();
    }

    public void pr(zo zoVar) {
        pr(zoVar, -1);
    }

    public int getItemDecorationCount() {
        return this.nt.size();
    }

    public void setChildDrawingOrderCallback(x xVar) {
        if (xVar != this.na) {
            this.na = xVar;
            setChildrenDrawingOrderEnabled(xVar != null);
        }
    }

    public void pr(g gVar) {
        if (this.np == null) {
            this.np = new ArrayList();
        }
        this.np.add(gVar);
    }

    public void hw(g gVar) {
        List<g> list = this.np;
        if (list != null) {
            list.remove(gVar);
        }
    }

    public void pr(int i) {
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.x(i);
            awakenScrollBars();
        }
    }

    public void hw(int i) {
        if (!this.cz) {
            aj ajVar = this.g;
            if (ajVar == null) {
                com.byazt.ca.ho.hw("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                ajVar.pr(this, this.gz, i);
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        aj ajVar = this.g;
        if (ajVar == null) {
            com.byazt.ca.ho.hw("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.cz) {
            boolean zHn = ajVar.hn();
            boolean zX = this.g.x();
            if (zHn || zX) {
                if (!zHn) {
                    i = 0;
                }
                if (!zX) {
                    i2 = 0;
                }
                pr(i, i2, (MotionEvent) null);
            }
        }
    }

    public void pr(int i, int i2, int[] iArr) {
        int iPr;
        int iHw;
        c();
        k();
        com.byazt.de.pr.pr("RV Scroll");
        pr(this.gz);
        if (i == 0) {
            iPr = 0;
        } else {
            iPr = this.g.pr(i, this.c, this.gz);
        }
        if (i2 == 0) {
            iHw = 0;
        } else {
            iHw = this.g.hw(i2, this.c, this.gz);
        }
        com.byazt.de.pr.pr();
        ny();
        m();
        pr(false);
        if (iArr != null) {
            iArr[0] = iPr;
            iArr[1] = iHw;
        }
    }

    public void x() {
        if (this.qa && !this.fo) {
            if (this.uc.x()) {
                if (this.uc.pr(4) && !this.uc.pr(11)) {
                    com.byazt.de.pr.pr("RV PartialInvalidate");
                    c();
                    k();
                    this.uc.hw();
                    if (!this.a) {
                        if (b()) {
                            nt();
                        } else {
                            this.uc.hn();
                        }
                    }
                    pr(true);
                    m();
                    com.byazt.de.pr.pr();
                    return;
                }
                if (!this.uc.x()) {
                    return;
                }
            } else {
                return;
            }
        }
        com.byazt.de.pr.pr("RV FullInvalidate");
        nt();
        com.byazt.de.pr.pr();
    }

    private boolean b() {
        int iHw = this.fw.hw();
        for (int i = 0; i < iHw; i++) {
            fo foVarC = c(this.fw.hw(i));
            if (foVarC != null && !foVarC.X_() && foVarC.b()) {
                return true;
            }
        }
        return false;
    }

    public boolean pr(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        x();
        if (this.m != null) {
            pr(i, i2, this.e);
            int[] iArr = this.e;
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
        if (!this.nt.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (pr(i5, i4, i6, i3, this.ag, 0)) {
            int i10 = this.aa;
            int[] iArr2 = this.ag;
            int i11 = iArr2[0];
            this.aa = i10 - i11;
            int i12 = this.iy;
            int i13 = iArr2[1];
            this.iy = i12 - i13;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i11, i13);
            }
            int[] iArr3 = this.qx;
            int i14 = iArr3[0];
            int[] iArr4 = this.ag;
            iArr3[0] = i14 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.byazt.vu.fw.pr(motionEvent, 8194)) {
                pr(motionEvent.getX(), i6, motionEvent.getY(), i9);
            }
            hn(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            zo(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        aj ajVar = this.g;
        if (ajVar != null && ajVar.hn()) {
            return this.g.hn(this.gz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        aj ajVar = this.g;
        if (ajVar != null && ajVar.hn()) {
            return this.g.c(this.gz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        aj ajVar = this.g;
        if (ajVar != null && ajVar.hn()) {
            return this.g.fw(this.gz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        aj ajVar = this.g;
        if (ajVar != null && ajVar.x()) {
            return this.g.x(this.gz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        aj ajVar = this.g;
        if (ajVar != null && ajVar.x()) {
            return this.g.uc(this.gz);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        aj ajVar = this.g;
        if (ajVar != null && ajVar.x()) {
            return this.g.zo(this.gz);
        }
        return 0;
    }

    public void c() {
        int i = this.nw + 1;
        this.nw = i;
        if (i == 1 && !this.cz) {
            this.a = false;
        }
    }

    public void pr(boolean z) {
        if (this.nw <= 0) {
            this.nw = 1;
        }
        if (!z && !this.cz) {
            this.a = false;
        }
        if (this.nw == 1) {
            if (z && this.a && !this.cz && this.g != null && this.m != null) {
                nt();
            }
            if (!this.cz) {
                this.a = false;
            }
        }
        this.nw--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.cz) {
            pr("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.cz = false;
                if (this.a && this.g != null && this.m != null) {
                    requestLayout();
                }
                this.a = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.cz = true;
            this.ie = true;
            uc();
        }
    }

    public void pr(int i, int i2) {
        pr(i, i2, (Interpolator) null);
    }

    public void pr(int i, int i2, Interpolator interpolator) {
        aj ajVar = this.g;
        if (ajVar == null) {
            com.byazt.ca.ho.hw("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (!this.cz) {
            if (!ajVar.hn()) {
                i = 0;
            }
            if (!this.g.x()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                this.b.pr(i, i2, interpolator);
            }
        }
    }

    public boolean hw(int i, int i2) {
        aj ajVar = this.g;
        if (ajVar == null) {
            com.byazt.ca.ho.hw("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.cz) {
            return false;
        }
        boolean zHn = ajVar.hn();
        boolean zX = this.g.x();
        if (!zHn || Math.abs(i) < this.qo) {
            i = 0;
        }
        if (!zX || Math.abs(i2) < this.qo) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = zHn || zX;
            dispatchNestedFling(f, f2, z);
            k kVar = this.j;
            if (kVar != null && kVar.pr(i, i2)) {
                return true;
            }
            if (z) {
                int i3 = zHn ? 1 : 0;
                if (zX) {
                    i3 |= 2;
                }
                aj(i3, 1);
                int i4 = this.bh;
                int iMax = Math.max(-i4, Math.min(i, i4));
                int i5 = this.bh;
                this.b.pr(iMax, Math.max(-i5, Math.min(i2, i5)));
                return true;
            }
        }
        return false;
    }

    public void uc() {
        setScrollState(0);
        iu();
    }

    private void iu() {
        this.b.hw();
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.ww();
        }
    }

    public int getMinFlingVelocity() {
        return this.qo;
    }

    public int getMaxFlingVelocity() {
        return this.bh;
    }

    private void pr(float f, float f2, float f3, float f4) {
        boolean z;
        boolean z2 = true;
        if (f2 < 0.0f) {
            fw();
            com.byazt.vu.pr.pr(this.od, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
            z = true;
        } else if (f2 <= 0.0f) {
            z = false;
        } else {
            zo();
            com.byazt.vu.pr.pr(this.mw, f2 / getWidth(), f3 / getHeight());
            z = true;
        }
        if (f4 < 0.0f) {
            aj();
            com.byazt.vu.pr.pr(this.vj, (-f4) / getHeight(), f / getWidth());
        } else if (f4 <= 0.0f) {
            z2 = z;
        } else {
            vk();
            com.byazt.vu.pr.pr(this.sv, f4 / getHeight(), 1.0f - (f / getWidth()));
        }
        if (z2 || f2 != 0.0f || f4 != 0.0f) {
            com.byazt.vu.fw.hn(this);
        }
    }

    private void ve() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.od;
        if (edgeEffect == null) {
            zIsFinished = false;
        } else {
            edgeEffect.onRelease();
            zIsFinished = this.od.isFinished();
        }
        EdgeEffect edgeEffect2 = this.vj;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.vj.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mw;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mw.isFinished();
        }
        EdgeEffect edgeEffect4 = this.sv;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.sv.isFinished();
        }
        if (zIsFinished) {
            com.byazt.vu.fw.hn(this);
        }
    }

    public void hn(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.od;
        if (edgeEffect != null && !edgeEffect.isFinished() && i > 0) {
            this.od.onRelease();
            zIsFinished = this.od.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mw;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mw.onRelease();
            zIsFinished |= this.mw.isFinished();
        }
        EdgeEffect edgeEffect3 = this.vj;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.vj.onRelease();
            zIsFinished |= this.vj.isFinished();
        }
        EdgeEffect edgeEffect4 = this.sv;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.sv.onRelease();
            zIsFinished |= this.sv.isFinished();
        }
        if (zIsFinished) {
            com.byazt.vu.fw.hn(this);
        }
    }

    public void x(int i, int i2) {
        if (i < 0) {
            fw();
            this.od.onAbsorb(-i);
        } else if (i > 0) {
            zo();
            this.mw.onAbsorb(i);
        }
        if (i2 < 0) {
            aj();
            this.vj.onAbsorb(-i2);
        } else if (i2 > 0) {
            vk();
            this.sv.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            com.byazt.vu.fw.hn(this);
        }
    }

    public void fw() {
        if (this.od == null) {
            EdgeEffect edgeEffectPr = this.lv.pr(this, 0);
            this.od = edgeEffectPr;
            if (this.aj) {
                edgeEffectPr.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectPr.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void zo() {
        if (this.mw == null) {
            EdgeEffect edgeEffectPr = this.lv.pr(this, 2);
            this.mw = edgeEffectPr;
            if (this.aj) {
                edgeEffectPr.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectPr.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void aj() {
        if (this.vj == null) {
            EdgeEffect edgeEffectPr = this.lv.pr(this, 1);
            this.vj = edgeEffectPr;
            if (this.aj) {
                edgeEffectPr.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectPr.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void vk() {
        if (this.sv == null) {
            EdgeEffect edgeEffectPr = this.lv.pr(this, 3);
            this.sv = edgeEffectPr;
            if (this.aj) {
                edgeEffectPr.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectPr.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void w() {
        this.sv = null;
        this.vj = null;
        this.mw = null;
        this.od = null;
    }

    public static <T> T pr(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public void setEdgeEffectFactory(c cVar) {
        pr(cVar);
        this.lv = cVar;
        w();
    }

    public c getEdgeEffectFactory() {
        return this.lv;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewPr;
        boolean z;
        View viewX = this.g.x(view, i);
        if (viewX != null) {
            return viewX;
        }
        boolean z2 = (this.m == null || this.g == null || g() || this.cz) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (!this.g.x()) {
                z = false;
            } else {
                int i2 = i == 2 ? MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (qi) {
                    i = i2;
                }
            }
            if (!z && this.g.hn()) {
                int i3 = (this.g.yb() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (!qi) {
                    z = z3;
                } else {
                    i = i3;
                    z = z3;
                }
            }
            if (z) {
                x();
                if (hn(view) == null) {
                    return null;
                }
                c();
                this.g.pr(view, i, this.c, this.gz);
                pr(false);
            }
            viewPr = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                x();
                if (hn(view) == null) {
                    return null;
                }
                c();
                viewPr = this.g.pr(view, i, this.c, this.gz);
                pr(false);
            } else {
                viewPr = viewFindNextFocus;
            }
        }
        if (viewPr == null || viewPr.hasFocusable()) {
            return pr(view, viewPr, i) ? viewPr : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        pr(viewPr, (View) null);
        return view;
    }

    private boolean pr(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || hn(view2) == null) {
            return false;
        }
        if (view != null && hn(view) != null) {
            this.w.set(0, 0, view.getWidth(), view.getHeight());
            this.i.set(0, 0, view2.getWidth(), view2.getHeight());
            offsetDescendantRectToMyCoords(view, this.w);
            offsetDescendantRectToMyCoords(view2, this.i);
            byte b = -1;
            int i3 = this.g.yb() == 1 ? -1 : 1;
            if ((this.w.left < this.i.left || this.w.right <= this.i.left) && this.w.right < this.i.right) {
                i2 = 1;
            } else if ((this.w.right > this.i.right || this.w.left >= this.i.right) && this.w.left > this.i.left) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            if ((this.w.top < this.i.top || this.w.bottom <= this.i.top) && this.w.bottom < this.i.bottom) {
                b = 1;
            } else if ((this.w.bottom <= this.i.bottom && this.w.top < this.i.bottom) || this.w.top <= this.i.top) {
                b = 0;
            }
            switch (i) {
                case 1:
                    if (b >= 0 && (b != 0 || i2 * i3 > 0)) {
                        return false;
                    }
                    return true;
                case 2:
                    if (b <= 0 && (b != 0 || i2 * i3 < 0)) {
                        return false;
                    }
                    return true;
                case 17:
                    if (i2 >= 0) {
                        return false;
                    }
                    return true;
                case 33:
                    if (b >= 0) {
                        return false;
                    }
                    return true;
                case 66:
                    if (i2 <= 0) {
                        return false;
                    }
                    return true;
                case MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE /* 130 */:
                    if (b <= 0) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + i + pr());
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.g.pr(this, this.gz, view, view2) && view2 != null) {
            pr(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void pr(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.w.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof vk) {
            vk vkVar = (vk) layoutParams;
            if (!vkVar.hn) {
                Rect rect = vkVar.hw;
                this.w.left -= rect.left;
                this.w.right += rect.right;
                this.w.top -= rect.top;
                this.w.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.w);
            offsetRectIntoDescendantCoords(view, this.w);
        }
        this.g.pr(this, view, this.w, !this.qa, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.g.pr(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        aj ajVar = this.g;
        if (ajVar == null || !ajVar.pr(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (g()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.jn = 0;
        boolean z = true;
        this.yb = true;
        if (!this.qa || isLayoutRequested()) {
            z = false;
        }
        this.qa = z;
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.hw(this);
        }
        this.ww = false;
        if (x) {
            com.byazt.hr.x xVar = com.byazt.hr.x.pr.get();
            this.iu = xVar;
            if (xVar == null) {
                this.iu = new com.byazt.hr.x();
                Display displayFw = com.byazt.vu.fw.fw(this);
                float f = 60.0f;
                if (!isInEditMode() && displayFw != null) {
                    float refreshRate = displayFw.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                this.iu.x = (long) (1.0E9f / f);
                com.byazt.hr.x.pr.set(this.iu);
            }
            this.iu.pr(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.byazt.hr.x xVar;
        super.onDetachedFromWindow();
        uc ucVar = this.z;
        if (ucVar != null) {
            ucVar.x();
        }
        uc();
        this.yb = false;
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.hw(this, this.c);
        }
        this.s.clear();
        removeCallbacks(this.fe);
        this.zo.hw();
        if (x && (xVar = this.iu) != null) {
            xVar.hw(this);
            this.iu = null;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.yb;
    }

    public void pr(String str) {
        if (g()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + pr());
            }
            throw new IllegalStateException(str);
        }
        if (this.l > 0) {
            new IllegalStateException(pr());
        }
    }

    private boolean pr(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.hs = null;
        }
        int size = this.r.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.r.get(i);
            if (mVar.pr(this, motionEvent) && action != 3) {
                this.hs = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean hw(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.hs != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.hs = null;
                }
                return true;
            }
            this.hs = null;
        }
        if (action != 0) {
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                m mVar = this.r.get(i);
                if (mVar.pr(this, motionEvent)) {
                    this.hs = mVar;
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        if (this.cz) {
            return false;
        }
        if (pr(motionEvent)) {
            nl();
            return true;
        }
        aj ajVar = this.g;
        if (ajVar == null) {
            return false;
        }
        boolean zHn = ajVar.hn();
        boolean zX = this.g.x();
        if (this.pq == null) {
            this.pq = VelocityTracker.obtain();
        }
        this.pq.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                if (this.ie) {
                    this.ie = false;
                }
                this.d = motionEvent.getPointerId(0);
                int x2 = (int) (motionEvent.getX() + 0.5f);
                this.aa = x2;
                this.jw = x2;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.iy = y;
                this.wt = y;
                if (this.gu == 2) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                }
                int[] iArr = this.qx;
                iArr[1] = 0;
                iArr[0] = 0;
                if (!zHn) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (zX) {
                    i |= 2;
                }
                aj(i, 0);
                break;
            case 1:
                this.pq.clear();
                zo(0);
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.d);
                if (iFindPointerIndex >= 0) {
                    int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.gu != 1) {
                        int i2 = x3 - this.jw;
                        int i3 = y2 - this.wt;
                        if (zHn && Math.abs(i2) > this.cr) {
                            this.aa = x3;
                            z = true;
                        } else {
                            z = false;
                        }
                        if (zX && Math.abs(i3) > this.cr) {
                            this.iy = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                } else {
                    com.byazt.ca.ho.hw("RecyclerView", "Error processing scroll; pointer index for id " + this.d + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                break;
            case 3:
                nl();
                break;
            case 5:
                this.d = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.aa = x4;
                this.jw = x4;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.iy = y3;
                this.wt = y3;
                break;
            case 6:
                hn(motionEvent);
                break;
        }
        return this.gu == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.r.size();
        for (int i = 0; i < size; i++) {
            this.r.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00fc  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        boolean z;
        boolean z2 = false;
        if (this.cz || this.ie) {
            return false;
        }
        if (hw(motionEvent)) {
            nl();
            return true;
        }
        aj ajVar = this.g;
        if (ajVar == null) {
            return false;
        }
        boolean zHn = ajVar.hn();
        boolean zX = this.g.x();
        if (this.pq == null) {
            this.pq = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.qx;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.qx;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        switch (actionMasked) {
            case 0:
                this.d = motionEvent.getPointerId(0);
                int x2 = (int) (motionEvent.getX() + 0.5f);
                this.aa = x2;
                this.jw = x2;
                int y = (int) (motionEvent.getY() + 0.5f);
                this.iy = y;
                this.wt = y;
                if (!zHn) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (zX) {
                    i |= 2;
                }
                aj(i, 0);
                break;
            case 1:
                this.pq.addMovement(motionEventObtain);
                this.pq.computeCurrentVelocity(1000, this.bh);
                float f = zHn ? -this.pq.getXVelocity(this.d) : 0.0f;
                float f2 = zX ? -this.pq.getYVelocity(this.d) : 0.0f;
                if ((f == 0.0f && f2 == 0.0f) || !hw((int) f, (int) f2)) {
                    setScrollState(0);
                }
                gz();
                z2 = true;
                break;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.d);
                if (iFindPointerIndex >= 0) {
                    int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    int i2 = this.aa - x3;
                    int i3 = this.iy - y2;
                    if (pr(i2, i3, this.n, this.ag, 0)) {
                        int[] iArr3 = this.n;
                        i2 -= iArr3[0];
                        i3 -= iArr3[1];
                        int[] iArr4 = this.ag;
                        motionEventObtain.offsetLocation(iArr4[0], iArr4[1]);
                        int[] iArr5 = this.qx;
                        int i4 = iArr5[0];
                        int[] iArr6 = this.ag;
                        iArr5[0] = i4 + iArr6[0];
                        iArr5[1] = iArr5[1] + iArr6[1];
                    }
                    if (this.gu != 1) {
                        if (zHn) {
                            int iAbs = Math.abs(i2);
                            int i5 = this.cr;
                            if (iAbs > i5) {
                                if (i2 > 0) {
                                    i2 -= i5;
                                } else {
                                    i2 += i5;
                                }
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (zX) {
                            int iAbs2 = Math.abs(i3);
                            int i6 = this.cr;
                            if (iAbs2 > i6) {
                                if (i3 > 0) {
                                    i3 -= i6;
                                } else {
                                    i3 += i6;
                                }
                                z = true;
                            }
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                    if (this.gu == 1) {
                        int[] iArr7 = this.ag;
                        this.aa = x3 - iArr7[0];
                        this.iy = y2 - iArr7[1];
                        if (pr(zHn ? i2 : 0, zX ? i3 : 0, motionEventObtain)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        com.byazt.hr.x xVar = this.iu;
                        if (xVar != null && (i2 != 0 || i3 != 0)) {
                            xVar.pr(this, i2, i3);
                        }
                    }
                } else {
                    com.byazt.ca.ho.hw("RecyclerView", "Error processing scroll; pointer index for id " + this.d + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                break;
            case 3:
                nl();
                break;
            case 5:
                this.d = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.aa = x4;
                this.jw = x4;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.iy = y3;
                this.wt = y3;
                break;
            case 6:
                hn(motionEvent);
                break;
        }
        if (!z2) {
            this.pq.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void gz() {
        VelocityTracker velocityTracker = this.pq;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        zo(0);
        ve();
    }

    private void nl() {
        gz();
        setScrollState(0);
    }

    private void hn(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.d) {
            int i = actionIndex == 0 ? 1 : 0;
            this.d = motionEvent.getPointerId(i);
            int x2 = (int) (motionEvent.getX(i) + 0.5f);
            this.aa = x2;
            this.jw = x2;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.iy = y;
            this.wt = y;
        }
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.g != null && !this.cz && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.g.x()) {
                    f = -motionEvent.getAxisValue(9);
                } else {
                    f = 0.0f;
                }
                if (this.g.hn()) {
                    axisValue = motionEvent.getAxisValue(10);
                } else {
                    axisValue = 0.0f;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.g.x()) {
                    f = -axisValue;
                    axisValue = 0.0f;
                } else if (this.g.hn()) {
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
                pr((int) (axisValue * this.pj), (int) (f * this.ey), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        aj ajVar = this.g;
        if (ajVar == null) {
            c(i, i2);
            return;
        }
        boolean z = false;
        if (!ajVar.pr()) {
            if (this.lb) {
                this.g.pr(this.c, this.gz, i, i2);
                return;
            }
            if (this.ny) {
                c();
                k();
                n();
                m();
                if (this.gz.w) {
                    this.gz.fw = true;
                } else {
                    this.uc.c();
                    this.gz.fw = false;
                }
                this.ny = false;
                pr(false);
            } else if (this.gz.w) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            pr prVar = this.m;
            if (prVar != null) {
                this.gz.c = prVar.pr();
            } else {
                this.gz.c = 0;
            }
            c();
            this.g.pr(this.c, this.gz, i, i2);
            pr(false);
            this.gz.fw = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.g.pr(this.c, this.gz, i, i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z = true;
        }
        if (z || this.m == null) {
            return;
        }
        if (this.gz.x == 1) {
            v();
        }
        this.g.hw(i, i2);
        this.gz.aj = true;
        qi();
        this.g.hn(i, i2);
        if (this.g.aj()) {
            this.g.hw(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.gz.aj = true;
            qi();
            this.g.hn(i, i2);
        }
    }

    public void c(int i, int i2) {
        setMeasuredDimension(aj.pr(i, getPaddingLeft() + getPaddingRight(), com.byazt.vu.fw.x(this)), aj.pr(i2, getPaddingTop() + getPaddingBottom(), com.byazt.vu.fw.c(this)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            w();
        }
    }

    public void setItemAnimator(uc ucVar) {
        uc ucVar2 = this.z;
        if (ucVar2 != null) {
            ucVar2.x();
            this.z.pr(null);
        }
        this.z = ucVar;
        if (ucVar != null) {
            ucVar.pr(this.eh);
        }
    }

    public void k() {
        this.jn++;
    }

    public void m() {
        hw(true);
    }

    public void hw(boolean z) {
        int i = this.jn - 1;
        this.jn = i;
        if (i <= 0) {
            this.jn = 0;
            if (z) {
                y();
                fo();
            }
        }
    }

    private void y() {
        this.o = 0;
    }

    public boolean g() {
        return this.jn > 0;
    }

    public uc getItemAnimator() {
        return this.z;
    }

    public void ho() {
        if (!this.ww && this.yb) {
            com.byazt.vu.fw.pr(this, this.fe);
            this.ww = true;
        }
    }

    private boolean ww() {
        return this.z != null && this.g.k();
    }

    private void n() {
        if (this.fo) {
            this.uc.pr();
        }
        if (ww()) {
            this.uc.hw();
        } else {
            this.uc.c();
        }
        boolean z = false;
        boolean z2 = this.nl || this.y;
        this.gz.vk = this.qa && this.z != null && (this.fo || z2 || this.g.m) && (!this.fo || this.m.hw());
        a aVar = this.gz;
        if (aVar.vk && z2 && !this.fo && ww()) {
            z = true;
        }
        aVar.w = z;
    }

    public void nt() {
        if (this.m == null) {
            com.byazt.ca.ho.hw("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.g == null) {
            com.byazt.ca.ho.hw("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.gz.aj = false;
        if (this.gz.x == 1) {
            v();
        } else {
            if (!this.uc.uc() && this.g.ny() == getWidth() && this.g.fo() == getHeight()) {
                this.g.x(this);
            }
            qn();
        }
        this.g.x(this);
        qi();
        qn();
    }

    private void e() {
        View focusedChild;
        int iC;
        if (this.qv && hasFocus() && this.m != null) {
            focusedChild = getFocusedChild();
        } else {
            focusedChild = null;
        }
        fo foVarX = focusedChild != null ? x(focusedChild) : null;
        if (foVarX == null) {
            s();
            return;
        }
        this.gz.m = this.m.hw() ? foVarX.fw() : -1L;
        a aVar = this.gz;
        if (this.fo) {
            iC = -1;
        } else {
            iC = foVarX.yb() ? foVarX.x : foVarX.c();
        }
        aVar.k = iC;
        this.gz.g = m(foVarX.pr);
    }

    private void s() {
        this.gz.m = -1L;
        this.gz.k = -1;
        this.gz.g = -1;
    }

    private View ls() {
        fo foVarX;
        int i = this.gz.k != -1 ? this.gz.k : 0;
        int iX = this.gz.x();
        for (int i2 = i; i2 < iX; i2++) {
            fo foVarX2 = x(i2);
            if (foVarX2 == null) {
                break;
            }
            if (foVarX2.pr.hasFocusable()) {
                return foVarX2.pr;
            }
        }
        int iMin = Math.min(iX, i);
        do {
            iMin--;
            if (iMin < 0 || (foVarX = x(iMin)) == null) {
                return null;
            }
        } while (!foVarX.pr.hasFocusable());
        return foVarX.pr;
    }

    private void er() {
        fo foVarPr;
        View viewFindViewById;
        if (!this.qv || this.m == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() != 131072 || !isFocused()) {
            if (!isFocused()) {
                View focusedChild = getFocusedChild();
                if (qn && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                    if (this.fw.hw() == 0) {
                        requestFocus();
                        return;
                    }
                } else if (!this.fw.hn(focusedChild)) {
                    return;
                }
            }
            View viewLs = null;
            if (this.gz.m != -1 && this.m.hw()) {
                foVarPr = pr(this.gz.m);
            } else {
                foVarPr = null;
            }
            if (foVarPr != null && !this.fw.hn(foVarPr.pr) && foVarPr.pr.hasFocusable()) {
                viewLs = foVarPr.pr;
            } else if (this.fw.hw() > 0) {
                viewLs = ls();
            }
            if (viewLs != null) {
                if (this.gz.g != -1 && (viewFindViewById = viewLs.findViewById(this.gz.g)) != null && viewFindViewById.isFocusable()) {
                    viewLs = viewFindViewById;
                }
                viewLs.requestFocus();
            }
        }
    }

    private int m(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public final void pr(a aVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.b.pr;
            aVar.ho = overScroller.getFinalX() - overScroller.getCurrX();
            aVar.nt = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            aVar.ho = 0;
            aVar.nt = 0;
        }
    }

    private void v() {
        this.gz.pr(1);
        pr(this.gz);
        this.gz.aj = false;
        c();
        this.zo.pr();
        k();
        n();
        e();
        a aVar = this.gz;
        aVar.zo = aVar.vk && this.y;
        this.y = false;
        this.nl = false;
        a aVar2 = this.gz;
        aVar2.fw = aVar2.w;
        this.gz.c = this.m.pr();
        pr(this.rk);
        if (this.gz.vk) {
            int iHw = this.fw.hw();
            for (int i = 0; i < iHw; i++) {
                fo foVarC = c(this.fw.hw(i));
                if (!foVarC.X_() && (!foVarC.g() || this.m.hw())) {
                    this.zo.pr(foVarC, this.z.pr(this.gz, foVarC, uc.c(foVarC), foVarC.cz()));
                    if (this.gz.zo && foVarC.b() && !foVarC.yb() && !foVarC.X_() && !foVarC.g()) {
                        this.zo.pr(pr(foVarC), foVarC);
                    }
                }
            }
        }
        if (this.gz.w) {
            lb();
            boolean z = this.gz.uc;
            this.gz.uc = false;
            this.g.pr(this.c, this.gz);
            this.gz.uc = z;
            for (int i2 = 0; i2 < this.fw.hw(); i2++) {
                fo foVarC2 = c(this.fw.hw(i2));
                if (!foVarC2.X_() && !this.zo.x(foVarC2)) {
                    int iC = uc.c(foVarC2);
                    boolean zPr = foVarC2.pr(8192);
                    if (!zPr) {
                        iC |= 4096;
                    }
                    uc.hw hwVarPr = this.z.pr(this.gz, foVarC2, iC, foVarC2.cz());
                    if (zPr) {
                        pr(foVarC2, hwVarPr);
                    } else {
                        this.zo.hw(foVarC2, hwVarPr);
                    }
                }
            }
            qa();
        } else {
            qa();
        }
        m();
        pr(false);
        this.gz.x = 2;
    }

    private void qi() {
        c();
        k();
        this.gz.pr(6);
        this.uc.c();
        this.gz.c = this.m.pr();
        this.gz.hn = 0;
        this.gz.fw = false;
        this.g.pr(this.c, this.gz);
        this.gz.uc = false;
        a aVar = this.gz;
        aVar.vk = aVar.vk && this.z != null;
        this.gz.x = 4;
        m();
        pr(false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0079  */
    private void qn() {
        this.gz.pr(4);
        c();
        k();
        this.gz.x = 1;
        if (this.gz.vk) {
            for (int iHw = this.fw.hw() - 1; iHw >= 0; iHw--) {
                fo foVarC = c(this.fw.hw(iHw));
                if (!foVarC.X_()) {
                    long jPr = pr(foVarC);
                    uc.hw hwVarPr = this.z.pr(this.gz, foVarC);
                    fo foVarPr = this.zo.pr(jPr);
                    if (foVarPr != null && !foVarPr.X_()) {
                        boolean zPr = this.zo.pr(foVarPr);
                        boolean zPr2 = this.zo.pr(foVarC);
                        if (!zPr || foVarPr != foVarC) {
                            uc.hw hwVarHw = this.zo.hw(foVarPr);
                            this.zo.hn(foVarC, hwVarPr);
                            uc.hw hwVarHn = this.zo.hn(foVarC);
                            if (hwVarHw == null) {
                                pr(jPr, foVarC, foVarPr);
                            } else {
                                pr(foVarPr, foVarC, hwVarHw, hwVarHn, zPr, zPr2);
                            }
                        } else {
                            this.zo.hn(foVarC, hwVarPr);
                        }
                    } else {
                        this.zo.hn(foVarC, hwVarPr);
                    }
                }
            }
            this.zo.pr(this.ks);
        }
        this.g.hw(this.c);
        a aVar = this.gz;
        aVar.hw = aVar.c;
        this.fo = false;
        this.rc = false;
        this.gz.vk = false;
        this.gz.w = false;
        this.g.m = false;
        if (this.c.hw != null) {
            this.c.hw.clear();
        }
        if (this.g.yb) {
            this.g.nt = 0;
            this.g.yb = false;
            this.c.hw();
        }
        this.g.hw(this.gz);
        m();
        pr(false);
        this.zo.pr();
        int[] iArr = this.rk;
        if (vk(iArr[0], iArr[1])) {
            zo(0, 0);
        }
        er();
        s();
    }

    private void pr(long j, fo foVar, fo foVar2) {
        int iHw = this.fw.hw();
        for (int i = 0; i < iHw; i++) {
            fo foVarC = c(this.fw.hw(i));
            if (foVarC != foVar && pr(foVarC) == j) {
                pr prVar = this.m;
                if (prVar != null && prVar.hw()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + foVarC + " \n View Holder 2:" + foVar + pr());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + foVarC + " \n View Holder 2:" + foVar + pr());
            }
        }
        com.byazt.ca.ho.hw("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + foVar2 + " cannot be found but it is necessary for " + foVar + pr());
    }

    public void pr(fo foVar, uc.hw hwVar) {
        foVar.pr(0, 8192);
        if (this.gz.zo && foVar.b() && !foVar.yb() && !foVar.X_()) {
            this.zo.pr(pr(foVar), foVar);
        }
        this.zo.pr(foVar, hwVar);
    }

    private void pr(int[] iArr) {
        int iHw = this.fw.hw();
        if (iHw == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iHw; i3++) {
            fo foVarC = c(this.fw.hw(i3));
            if (!foVarC.X_()) {
                int iX = foVarC.x();
                if (iX < i) {
                    i = iX;
                }
                if (iX > i2) {
                    i2 = iX;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean vk(int i, int i2) {
        pr(this.rk);
        int[] iArr = this.rk;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        fo foVarC = c(view);
        if (foVarC != null) {
            if (foVarC.lb()) {
                foVarC.m();
            } else if (!foVarC.X_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + foVarC + pr());
            }
        }
        view.clearAnimation();
        w(view);
        super.removeDetachedView(view, z);
    }

    public long pr(fo foVar) {
        return this.m.hw() ? foVar.fw() : foVar.hn;
    }

    public void pr(fo foVar, uc.hw hwVar, uc.hw hwVar2) {
        foVar.pr(false);
        if (this.z.hw(foVar, hwVar, hwVar2)) {
            ho();
        }
    }

    public void hw(fo foVar, uc.hw hwVar, uc.hw hwVar2) {
        c(foVar);
        foVar.pr(false);
        if (this.z.pr(foVar, hwVar, hwVar2)) {
            ho();
        }
    }

    private void pr(fo foVar, fo foVar2, uc.hw hwVar, uc.hw hwVar2, boolean z, boolean z2) {
        foVar.pr(false);
        if (z) {
            c(foVar);
        }
        if (foVar != foVar2) {
            if (z2) {
                c(foVar2);
            }
            foVar.zo = foVar2;
            c(foVar);
            this.c.hn(foVar);
            foVar2.pr(false);
            foVar2.aj = foVar;
        }
        if (this.z.pr(foVar, foVar2, hwVar, hwVar2)) {
            ho();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.byazt.de.pr.pr("RV OnLayout");
        nt();
        com.byazt.de.pr.pr();
        this.qa = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.nw == 0 && !this.cz) {
            super.requestLayout();
        } else {
            this.a = true;
        }
    }

    public void yb() {
        int iHn = this.fw.hn();
        for (int i = 0; i < iHn; i++) {
            ((vk) this.fw.x(i).getLayoutParams()).hn = true;
        }
        this.c.vk();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.nt.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.nt.get(i);
        }
        EdgeEffect edgeEffect = this.od;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int paddingBottom = this.aj ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.od;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        } else {
            z = false;
        }
        EdgeEffect edgeEffect3 = this.vj;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.aj) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.vj;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mw;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.aj ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mw;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.sv;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.aj) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.sv;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.z == null || this.nt.size() <= 0 || !this.z.hw()) ? z : true) {
            com.byazt.vu.fw.hn(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.nt.size();
        for (int i = 0; i < size; i++) {
            this.nt.get(i);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof vk) && this.g.pr((vk) layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        aj ajVar = this.g;
        if (ajVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + pr());
        }
        return ajVar.hw();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        aj ajVar = this.g;
        if (ajVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + pr());
        }
        return ajVar.pr(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        aj ajVar = this.g;
        if (ajVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + pr());
        }
        return ajVar.pr(layoutParams);
    }

    public void lb() {
        int iHn = this.fw.hn();
        for (int i = 0; i < iHn; i++) {
            fo foVarC = c(this.fw.x(i));
            if (!foVarC.X_()) {
                foVarC.hw();
            }
        }
    }

    public void qa() {
        int iHn = this.fw.hn();
        for (int i = 0; i < iHn; i++) {
            fo foVarC = c(this.fw.x(i));
            if (!foVarC.X_()) {
                foVarC.pr();
            }
        }
        this.c.aj();
    }

    public void uc(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iHn = this.fw.hn();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < iHn; i6++) {
            fo foVarC = c(this.fw.x(i6));
            if (foVarC != null && foVarC.hn >= i4 && foVarC.hn <= i3) {
                if (foVarC.hn == i) {
                    foVarC.pr(i2 - i, false);
                } else {
                    foVarC.pr(i5, false);
                }
                this.gz.uc = true;
            }
        }
        this.c.pr(i, i2);
        requestLayout();
    }

    public void fw(int i, int i2) {
        int iHn = this.fw.hn();
        for (int i3 = 0; i3 < iHn; i3++) {
            fo foVarC = c(this.fw.x(i3));
            if (foVarC != null && !foVarC.X_() && foVarC.hn >= i) {
                foVarC.pr(i2, false);
                this.gz.uc = true;
            }
        }
        this.c.hw(i, i2);
        requestLayout();
    }

    public void pr(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iHn = this.fw.hn();
        for (int i4 = 0; i4 < iHn; i4++) {
            fo foVarC = c(this.fw.x(i4));
            if (foVarC != null && !foVarC.X_()) {
                if (foVarC.hn >= i3) {
                    foVarC.pr(-i2, z);
                    this.gz.uc = true;
                } else if (foVarC.hn >= i) {
                    foVarC.pr(i - 1, -i2, z);
                    this.gz.uc = true;
                }
            }
        }
        this.c.pr(i, i2, z);
        requestLayout();
    }

    public void pr(int i, int i2, Object obj) {
        int iHn = this.fw.hn();
        int i3 = i + i2;
        for (int i4 = 0; i4 < iHn; i4++) {
            View viewX = this.fw.x(i4);
            fo foVarC = c(viewX);
            if (foVarC != null && !foVarC.X_() && foVarC.hn >= i && foVarC.hn < i3) {
                foVarC.hw(2);
                foVarC.pr(obj);
                ((vk) viewX.getLayoutParams()).hn = true;
            }
        }
        this.c.hn(i, i2);
    }

    public boolean hw(fo foVar) {
        uc ucVar = this.z;
        return ucVar == null || ucVar.pr(foVar, foVar.cz());
    }

    public void hn(boolean z) {
        this.rc = z | this.rc;
        this.fo = true;
        a();
    }

    public void a() {
        int iHn = this.fw.hn();
        for (int i = 0; i < iHn; i++) {
            fo foVarC = c(this.fw.x(i));
            if (foVarC != null && !foVarC.X_()) {
                foVarC.hw(6);
            }
        }
        yb();
        this.c.zo();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.qv;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.qv = z;
    }

    public fo hw(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return c(view);
    }

    public View hn(View view) {
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

    public fo x(View view) {
        View viewHn = hn(view);
        if (viewHn == null) {
            return null;
        }
        return hw(viewHn);
    }

    public static fo c(View view) {
        if (view == null) {
            return null;
        }
        return ((vk) view.getLayoutParams()).pr;
    }

    @Deprecated
    public int uc(View view) {
        return fw(view);
    }

    public int fw(View view) {
        fo foVarC = c(view);
        if (foVarC != null) {
            return foVarC.c();
        }
        return -1;
    }

    public int zo(View view) {
        fo foVarC = c(view);
        if (foVarC != null) {
            return foVarC.x();
        }
        return -1;
    }

    public fo hn(int i) {
        return pr(i, false);
    }

    public fo x(int i) {
        fo foVar = null;
        if (this.fo) {
            return null;
        }
        int iHn = this.fw.hn();
        for (int i2 = 0; i2 < iHn; i2++) {
            fo foVarC = c(this.fw.x(i2));
            if (foVarC != null && !foVarC.yb() && x(foVarC) == i) {
                if (!this.fw.hn(foVarC.pr)) {
                    return foVarC;
                }
                foVar = foVarC;
            }
        }
        return foVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:21:0x0034 A[SYNTHETIC] */
    public fo pr(int i, boolean z) {
        int iHn = this.fw.hn();
        fo foVar = null;
        for (int i2 = 0; i2 < iHn; i2++) {
            fo foVarC = c(this.fw.x(i2));
            if (foVarC != null && !foVarC.yb()) {
                if (z) {
                    if (foVarC.hn != i) {
                        continue;
                    } else {
                        if (!this.fw.hn(foVarC.pr)) {
                            return foVarC;
                        }
                        foVar = foVarC;
                    }
                } else if (foVarC.x() != i) {
                    continue;
                } else {
                    if (!this.fw.hn(foVarC.pr)) {
                        return foVarC;
                    }
                    foVar = foVarC;
                }
            }
        }
        return foVar;
    }

    public fo pr(long j) {
        pr prVar = this.m;
        fo foVar = null;
        if (prVar == null || !prVar.hw()) {
            return null;
        }
        int iHn = this.fw.hn();
        for (int i = 0; i < iHn; i++) {
            fo foVarC = c(this.fw.x(i));
            if (foVarC != null && !foVarC.yb() && foVarC.fw() == j) {
                if (!this.fw.hn(foVarC.pr)) {
                    return foVarC;
                }
                foVar = foVarC;
            }
        }
        return foVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void c(int i) {
        int iHw = this.fw.hw();
        for (int i2 = 0; i2 < iHw; i2++) {
            this.fw.hw(i2).offsetTopAndBottom(i);
        }
    }

    public void uc(int i) {
        int iHw = this.fw.hw();
        for (int i2 = 0; i2 < iHw; i2++) {
            this.fw.hw(i2).offsetLeftAndRight(i);
        }
    }

    public static void pr(View view, Rect rect) {
        vk vkVar = (vk) view.getLayoutParams();
        Rect rect2 = vkVar.hw;
        rect.set((view.getLeft() - rect2.left) - vkVar.leftMargin, (view.getTop() - rect2.top) - vkVar.topMargin, view.getRight() + rect2.right + vkVar.rightMargin, view.getBottom() + rect2.bottom + vkVar.bottomMargin);
    }

    public Rect aj(View view) {
        vk vkVar = (vk) view.getLayoutParams();
        if (!vkVar.hn) {
            return vkVar.hw;
        }
        if (this.gz.pr() && (vkVar.hn() || vkVar.pr())) {
            return vkVar.hw;
        }
        Rect rect = vkVar.hw;
        rect.set(0, 0, 0, 0);
        int size = this.nt.size();
        for (int i = 0; i < size; i++) {
            this.w.set(0, 0, 0, 0);
            this.nt.get(i).pr(this.w, view, this, this.gz);
            rect.left += this.w.left;
            rect.top += this.w.top;
            rect.right += this.w.right;
            rect.bottom += this.w.bottom;
        }
        vkVar.hn = false;
        return rect;
    }

    public void zo(int i, int i2) {
        this.l++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        g gVar = this.u;
        if (gVar != null) {
            gVar.pr(this, i, i2);
        }
        List<g> list = this.np;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.np.get(size).pr(this, i, i2);
            }
        }
        this.l--;
    }

    public void fw(int i) {
        aj ajVar = this.g;
        if (ajVar != null) {
            ajVar.w(i);
        }
        g gVar = this.u;
        if (gVar != null) {
            gVar.pr(this, i);
        }
        List<g> list = this.np;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.np.get(size).pr(this, i);
            }
        }
    }

    public boolean cz() {
        return !this.qa || this.fo || this.uc.x();
    }

    public void ny() {
        int iHw = this.fw.hw();
        for (int i = 0; i < iHw; i++) {
            View viewHw = this.fw.hw(i);
            fo foVarHw = hw(viewHw);
            if (foVarHw != null && foVarHw.aj != null) {
                View view = foVarHw.aj.pr;
                int left = viewHw.getLeft();
                int top = viewHw.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public static RecyclerView vk(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewVk = vk(viewGroup.getChildAt(i));
            if (recyclerViewVk != null) {
                return recyclerViewVk;
            }
        }
        return null;
    }

    public static void hn(fo foVar) {
        if (foVar.hw != null) {
            RecyclerView recyclerView = foVar.hw.get();
            while (recyclerView != null) {
                if (recyclerView == foVar.pr) {
                    return;
                }
                Object parent = recyclerView.getParent();
                if (parent instanceof View) {
                    recyclerView = (View) parent;
                } else {
                    recyclerView = null;
                }
            }
            foVar.hw = null;
        }
    }

    public long getNanoTime() {
        if (x) {
            return System.nanoTime();
        }
        return 0L;
    }

    public void w(View view) {
        c(view);
        List<w> list = this.bm;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.bm.get(size).hw(view);
            }
        }
    }

    public void k(View view) {
        c(view);
        List<w> list = this.bm;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.bm.get(size).pr(view);
            }
        }
    }

    public boolean pr(fo foVar, int i) {
        if (g()) {
            foVar.ho = i;
            this.s.add(foVar);
            return false;
        }
        com.byazt.vu.fw.pr(foVar.pr, i);
        return true;
    }

    public void fo() {
        int i;
        for (int size = this.s.size() - 1; size >= 0; size--) {
            fo foVar = this.s.get(size);
            if (foVar.pr.getParent() == this && !foVar.X_() && (i = foVar.ho) != -1) {
                com.byazt.vu.fw.pr(foVar.pr, i);
                foVar.ho = -1;
            }
        }
        this.s.clear();
    }

    public int x(fo foVar) {
        if (foVar.pr(524) || !foVar.nt()) {
            return -1;
        }
        return this.uc.hn(foVar.hn);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().pr(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().pr();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().hw(i);
    }

    public boolean aj(int i, int i2) {
        return getScrollingChildHelper().pr(i, i2);
    }

    @Override // android.view.View, com.byazt.vu.hw
    public void stopNestedScroll() {
        getScrollingChildHelper().hn();
    }

    public void zo(int i) {
        getScrollingChildHelper().hn(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hw();
    }

    public boolean aj(int i) {
        return getScrollingChildHelper().pr(i);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().pr(i, i2, i3, i4, iArr);
    }

    public boolean pr(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().pr(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().pr(i, i2, iArr, iArr2);
    }

    public boolean pr(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().pr(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().pr(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().pr(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        x xVar = this.na;
        return xVar == null ? super.getChildDrawingOrder(i, i2) : xVar.pr(i, i2);
    }

    private com.byazt.vu.x getScrollingChildHelper() {
        if (this.mr == null) {
            this.mr = new com.byazt.vu.x(this);
        }
        return this.mr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2350})
    public static abstract class uc {
        public pr pr = null;
        public ArrayList<Object> hw = new ArrayList<>();
        public long hn = 120;
        public long x = 120;
        public long c = 250;
        public long uc = 250;

        interface pr {
            void pr(fo foVar);
        }

        public abstract boolean hn(fo foVar, hw hwVar, hw hwVar2);

        public abstract boolean hw();

        public abstract boolean hw(fo foVar, hw hwVar, hw hwVar2);

        public abstract void pr();

        public abstract boolean pr(fo foVar, fo foVar2, hw hwVar, hw hwVar2);

        public abstract boolean pr(fo foVar, hw hwVar, hw hwVar2);

        public abstract void x();

        public abstract void x(fo foVar);

        public long c() {
            return this.c;
        }

        public long uc() {
            return this.hn;
        }

        public long fw() {
            return this.x;
        }

        public long zo() {
            return this.uc;
        }

        public void pr(pr prVar) {
            this.pr = prVar;
        }

        public hw pr(a aVar, fo foVar, int i, List<Object> list) {
            return vk().pr(foVar);
        }

        public hw pr(a aVar, fo foVar) {
            return vk().pr(foVar);
        }

        public static int c(fo foVar) {
            int i = foVar.vk & 14;
            if (foVar.g()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int iUc = foVar.uc();
                int iC = foVar.c();
                if (iUc != -1 && iC != -1 && iUc != iC) {
                    return i | 2048;
                }
                return i;
            }
            return i;
        }

        public final void uc(fo foVar) {
            pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(foVar);
            }
        }

        public boolean fw(fo foVar) {
            return true;
        }

        public boolean pr(fo foVar, List<Object> list) {
            return fw(foVar);
        }

        public final void aj() {
            int size = this.hw.size();
            for (int i = 0; i < size; i++) {
                this.hw.get(i);
            }
            this.hw.clear();
        }

        public hw vk() {
            return new hw();
        }

        @com.byazt.vzx.pr(pr = {0, 1, 180, 724})
        public static class hw {
            public int hn;
            public int hw;
            public int pr;
            public int x;

            public hw pr(fo foVar) {
                return pr(foVar, 0);
            }

            public hw pr(fo foVar, int i) {
                View view = foVar.pr;
                this.pr = view.getLeft();
                this.hw = view.getTop();
                this.hn = view.getRight();
                this.x = view.getBottom();
                return this;
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2206})
    private class fw implements uc.pr {
        public fw() {
        }

        @Override // com.byazt.hr.RecyclerView.uc.pr
        public void pr(fo foVar) {
            foVar.pr(true);
            if (foVar.zo != null && foVar.aj == null) {
                foVar.zo = null;
            }
            foVar.aj = null;
            if (!foVar.rc() && !RecyclerView.this.pr(foVar.pr) && foVar.lb()) {
                RecyclerView.this.removeDetachedView(foVar.pr, false);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 1048})
    public static class a {
        public int g;
        public int ho;
        public int k;
        public long m;
        public int nt;
        public SparseArray<Object> yb;
        public int pr = -1;
        public int hw = 0;
        public int hn = 0;
        public int x = 1;
        public int c = 0;
        public boolean uc = false;
        public boolean fw = false;
        public boolean zo = false;
        public boolean aj = false;
        public boolean vk = false;
        public boolean w = false;

        public void pr(int i) {
            if ((this.x & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.x));
            }
        }

        public void pr(pr prVar) {
            this.x = 1;
            this.c = prVar.pr();
            this.fw = false;
            this.zo = false;
            this.aj = false;
        }

        public boolean pr() {
            return this.fw;
        }

        public boolean hw() {
            return this.w;
        }

        public boolean hn() {
            return this.pr != -1;
        }

        public int x() {
            return this.fw ? this.hw - this.hn : this.c;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.pr + ", mData=" + this.yb + ", mItemCount=" + this.c + ", mIsMeasuring=" + this.aj + ", mPreviousLayoutItemCount=" + this.hw + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.hn + ", mStructureChanged=" + this.uc + ", mInPreLayout=" + this.fw + ", mRunSimpleAnimations=" + this.vk + ", mRunPredictiveAnimations=" + this.w + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2218})
    static class hw extends Observable<hn> {
        public void pr() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((hn) this.mObservers.get(size)).pr();
            }
        }

        public void pr(int i, int i2) {
            pr(i, i2, null);
        }

        public void pr(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((hn) this.mObservers.get(size)).pr(i, i2, obj);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2327})
    public static abstract class qa {
        public boolean c;
        public aj hn;
        public RecyclerView hw;
        public View uc;
        public boolean x;
        public boolean zo;
        public int pr = -1;
        public final pr fw = new pr(0, 0);

        public interface hw {
            PointF hn(int i);
        }

        public abstract void pr();

        public abstract void pr(int i, int i2, a aVar, pr prVar);

        public abstract void pr(View view, a aVar, pr prVar);

        public void pr(RecyclerView recyclerView, aj ajVar) {
            if (this.zo) {
                getClass().getSimpleName();
                getClass().getSimpleName();
            }
            this.hw = recyclerView;
            this.hn = ajVar;
            if (this.pr == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.gz.pr = this.pr;
            this.c = true;
            this.x = true;
            this.uc = c(zo());
            this.hw.b.pr();
            this.zo = true;
        }

        public void hn(int i) {
            this.pr = i;
        }

        public PointF x(int i) {
            Object objX = x();
            if (objX instanceof hw) {
                return ((hw) objX).hn(i);
            }
            hw.class.getCanonicalName();
            return null;
        }

        public aj x() {
            return this.hn;
        }

        public final void c() {
            if (this.c) {
                this.c = false;
                pr();
                this.hw.gz.pr = -1;
                this.uc = null;
                this.pr = -1;
                this.x = false;
                this.hn.hw(this);
                this.hn = null;
                this.hw = null;
            }
        }

        public boolean uc() {
            return this.x;
        }

        public boolean fw() {
            return this.c;
        }

        public int zo() {
            return this.pr;
        }

        public void pr(int i, int i2) {
            PointF pointFX;
            RecyclerView recyclerView = this.hw;
            if (!this.c || this.pr == -1 || recyclerView == null) {
                c();
            }
            if (this.x && this.uc == null && this.hn != null && (pointFX = x(this.pr)) != null && (pointFX.x != 0.0f || pointFX.y != 0.0f)) {
                recyclerView.pr((int) Math.signum(pointFX.x), (int) Math.signum(pointFX.y), (int[]) null);
            }
            this.x = false;
            View view = this.uc;
            if (view != null) {
                if (pr(view) == this.pr) {
                    pr(this.uc, recyclerView.gz, this.fw);
                    this.fw.pr(recyclerView);
                    c();
                } else {
                    com.byazt.ca.ho.hw("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.uc = null;
                }
            }
            if (this.c) {
                pr(i, i2, recyclerView.gz, this.fw);
                boolean zPr = this.fw.pr();
                this.fw.pr(recyclerView);
                if (zPr) {
                    if (this.c) {
                        this.x = true;
                        recyclerView.b.pr();
                    } else {
                        c();
                    }
                }
            }
        }

        public int pr(View view) {
            return this.hw.zo(view);
        }

        public int aj() {
            return this.hw.g.qa();
        }

        public View c(int i) {
            return this.hw.g.hw(i);
        }

        public void hw(View view) {
            if (pr(view) == zo()) {
                this.uc = view;
            }
        }

        public void pr(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_500})
        public static class pr {
            public Interpolator c;
            public int fw;
            public int hn;
            public int hw;
            public int pr;
            public boolean uc;
            public int x;

            public pr(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public pr(int i, int i2, int i3, Interpolator interpolator) {
                this.x = -1;
                this.uc = false;
                this.fw = 0;
                this.pr = i;
                this.hw = i2;
                this.hn = i3;
                this.c = interpolator;
            }

            public void pr(int i) {
                this.x = i;
            }

            public boolean pr() {
                return this.x >= 0;
            }

            public void pr(RecyclerView recyclerView) {
                int i = this.x;
                if (i >= 0) {
                    this.x = -1;
                    recyclerView.pr(i);
                    this.uc = false;
                } else {
                    if (this.uc) {
                        hw();
                        if (this.c == null) {
                            if (this.hn == Integer.MIN_VALUE) {
                                recyclerView.b.hw(this.pr, this.hw);
                            } else {
                                recyclerView.b.pr(this.pr, this.hw, this.hn);
                            }
                        } else {
                            recyclerView.b.pr(this.pr, this.hw, this.hn, this.c);
                        }
                        int i2 = this.fw + 1;
                        this.fw = i2;
                        if (i2 > 10) {
                            com.byazt.ca.ho.hw("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.uc = false;
                        return;
                    }
                    this.fw = 0;
                }
            }

            private void hw() {
                if (this.c != null && this.hn <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.hn <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.pr = i;
                this.hw = i2;
                this.hn = i3;
                this.c = interpolator;
                this.uc = true;
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2214})
    public static abstract class hn {
        public void pr() {
        }

        public void pr(int i, int i2, Object obj) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2347})
    public static class vk extends ViewGroup.MarginLayoutParams {
        public boolean hn;
        public final Rect hw;
        public fo pr;
        public boolean x;

        public vk(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.hw = new Rect();
            this.hn = true;
            this.x = false;
        }

        public vk(int i, int i2) {
            super(i, i2);
            this.hw = new Rect();
            this.hn = true;
            this.x = false;
        }

        public vk(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.hw = new Rect();
            this.hn = true;
            this.x = false;
        }

        public vk(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.hw = new Rect();
            this.hn = true;
            this.x = false;
        }

        public vk(vk vkVar) {
            super((ViewGroup.MarginLayoutParams) vkVar);
            this.hw = new Rect();
            this.hn = true;
            this.x = false;
        }

        public boolean pr() {
            return this.pr.g();
        }

        public boolean hw() {
            return this.pr.yb();
        }

        public boolean hn() {
            return this.pr.b();
        }

        public int x() {
            return this.pr.x();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2197})
    public static abstract class fo {
        public static final List<Object> yb = Collections.emptyList();
        public WeakReference<RecyclerView> hw;
        public RecyclerView nt;
        public final View pr;
        public int vk;
        public int hn = -1;
        public int x = -1;
        public long c = -1;
        public int uc = -1;
        public int fw = -1;
        public fo zo = null;
        public fo aj = null;
        public List<Object> w = null;
        public List<Object> k = null;
        public int lb = 0;
        public nt m = null;
        public boolean g = false;
        public int qa = 0;
        public int ho = -1;

        public fo(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.pr = view;
        }

        public void pr(int i, int i2, boolean z) {
            hw(8);
            pr(i2, z);
            this.hn = i;
        }

        public void pr(int i, boolean z) {
            if (this.x == -1) {
                this.x = this.hn;
            }
            if (this.fw == -1) {
                this.fw = this.hn;
            }
            if (z) {
                this.fw += i;
            }
            this.hn += i;
            if (this.pr.getLayoutParams() != null) {
                ((vk) this.pr.getLayoutParams()).hn = true;
            }
        }

        public void pr() {
            this.x = -1;
            this.fw = -1;
        }

        public void hw() {
            if (this.x == -1) {
                this.x = this.hn;
            }
        }

        public boolean X_() {
            return (this.vk & 128) != 0;
        }

        public final int x() {
            int i = this.fw;
            return i == -1 ? this.hn : i;
        }

        public final int c() {
            RecyclerView recyclerView = this.nt;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.x(this);
        }

        public final int uc() {
            return this.x;
        }

        public final long fw() {
            return this.c;
        }

        public final int zo() {
            return this.uc;
        }

        public boolean aj() {
            return this.m != null;
        }

        public void vk() {
            this.m.hn(this);
        }

        public boolean w() {
            return (this.vk & 32) != 0;
        }

        public void k() {
            this.vk &= -33;
        }

        public void m() {
            this.vk &= -257;
        }

        public void pr(nt ntVar, boolean z) {
            this.m = ntVar;
            this.g = z;
        }

        public boolean g() {
            return (this.vk & 4) != 0;
        }

        public boolean ho() {
            return (this.vk & 2) != 0;
        }

        public boolean nt() {
            return (this.vk & 1) != 0;
        }

        public boolean yb() {
            return (this.vk & 8) != 0;
        }

        public boolean pr(int i) {
            return (i & this.vk) != 0;
        }

        public boolean lb() {
            return (this.vk & 256) != 0;
        }

        public boolean qa() {
            return (this.vk & 512) != 0 || g();
        }

        public void pr(int i, int i2) {
            this.vk = (i & i2) | (this.vk & (~i2));
        }

        public void hw(int i) {
            this.vk = i | this.vk;
        }

        public void pr(Object obj) {
            if (obj != null) {
                if ((1024 & this.vk) == 0) {
                    iu();
                    this.w.add(obj);
                    return;
                }
                return;
            }
            hw(1024);
        }

        private void iu() {
            if (this.w == null) {
                ArrayList arrayList = new ArrayList();
                this.w = arrayList;
                this.k = Collections.unmodifiableList(arrayList);
            }
        }

        public void a() {
            List<Object> list = this.w;
            if (list != null) {
                list.clear();
            }
            this.vk &= -1025;
        }

        public List<Object> cz() {
            if ((this.vk & 1024) == 0) {
                List<Object> list = this.w;
                return (list == null || list.size() == 0) ? yb : this.k;
            }
            return yb;
        }

        public void ny() {
            this.vk = 0;
            this.hn = -1;
            this.x = -1;
            this.c = -1L;
            this.fw = -1;
            this.lb = 0;
            this.zo = null;
            this.aj = null;
            a();
            this.qa = 0;
            this.ho = -1;
            RecyclerView.hn(this);
        }

        public void pr(RecyclerView recyclerView) {
            int i = this.ho;
            if (i != -1) {
                this.qa = i;
            } else {
                this.qa = com.byazt.vu.fw.hw(this.pr);
            }
            recyclerView.pr(this, 4);
        }

        public void hw(RecyclerView recyclerView) {
            recyclerView.pr(this, this.qa);
            this.qa = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.hn + " id=" + this.c + ", oldPos=" + this.x + ", pLpos:" + this.fw);
            if (aj()) {
                sb.append(" scrap ").append(this.g ? "[changeScrap]" : "[attachedScrap]");
            }
            if (g()) {
                sb.append(" invalid");
            }
            if (!nt()) {
                sb.append(" unbound");
            }
            if (ho()) {
                sb.append(" update");
            }
            if (yb()) {
                sb.append(" removed");
            }
            if (X_()) {
                sb.append(" ignored");
            }
            if (lb()) {
                sb.append(" tmpDetached");
            }
            if (!fo()) {
                sb.append(" not recyclable(" + this.lb + ")");
            }
            if (qa()) {
                sb.append(" undefined adapter position");
            }
            if (this.pr.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final void pr(boolean z) {
            int i = this.lb;
            int i2 = z ? i - 1 : i + 1;
            this.lb = i2;
            if (i2 < 0) {
                this.lb = 0;
                com.byazt.ca.ho.hw("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.vk |= 16;
            } else if (z && i2 == 0) {
                this.vk &= -17;
            }
        }

        public final boolean fo() {
            return (this.vk & 16) == 0 && !com.byazt.vu.fw.uc(this.pr);
        }

        public boolean rc() {
            return (this.vk & 16) != 0;
        }

        public boolean z() {
            return (this.vk & 16) == 0 && com.byazt.vu.fw.uc(this.pr);
        }

        public boolean b() {
            return (this.vk & 2) != 0;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 1042})
    public static abstract class g {
        public void pr(RecyclerView recyclerView, int i) {
        }

        public void pr(RecyclerView recyclerView, int i, int i2) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2361})
    public static abstract class zo {
        @Deprecated
        public void pr(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void pr(Rect rect, View view, RecyclerView recyclerView, a aVar) {
            pr(rect, ((vk) view.getLayoutParams()).x(), recyclerView);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2180})
    public static abstract class aj {
        public RecyclerView aj;
        public int c;
        public int fw;
        public boolean g;
        public boolean hn;
        public boolean ho;
        public final com.byazt.hr.m.hw hw;
        public qa k;
        public int lb;
        public boolean m;
        public int nt;
        public final com.byazt.hr.m.hw pr;
        public int uc;
        public com.byazt.hr.m vk;
        public com.byazt.hr.m w;
        public boolean x;
        public boolean yb;
        public com.byazt.hr.hw zo;

        public interface pr {
            void hw(int i, int i2);
        }

        public abstract vk hw();

        public aj() {
            com.byazt.hr.m.hw hwVar = new com.byazt.hr.m.hw() { // from class: com.byazt.hr.RecyclerView.aj.1
                @Override // com.byazt.hr.m.hw
                public View pr(int i) {
                    return aj.this.zo(i);
                }

                @Override // com.byazt.hr.m.hw
                public int pr() {
                    return aj.this.rc();
                }

                @Override // com.byazt.hr.m.hw
                public int hw() {
                    return aj.this.ny() - aj.this.b();
                }

                @Override // com.byazt.hr.m.hw
                public int pr(View view) {
                    return aj.this.fw(view) - ((vk) view.getLayoutParams()).leftMargin;
                }

                @Override // com.byazt.hr.m.hw
                public int hw(View view) {
                    return aj.this.aj(view) + ((vk) view.getLayoutParams()).rightMargin;
                }
            };
            this.pr = hwVar;
            com.byazt.hr.m.hw hwVar2 = new com.byazt.hr.m.hw() { // from class: com.byazt.hr.RecyclerView.aj.2
                @Override // com.byazt.hr.m.hw
                public View pr(int i) {
                    return aj.this.zo(i);
                }

                @Override // com.byazt.hr.m.hw
                public int pr() {
                    return aj.this.z();
                }

                @Override // com.byazt.hr.m.hw
                public int hw() {
                    return aj.this.fo() - aj.this.iu();
                }

                @Override // com.byazt.hr.m.hw
                public int pr(View view) {
                    return aj.this.zo(view) - ((vk) view.getLayoutParams()).topMargin;
                }

                @Override // com.byazt.hr.m.hw
                public int hw(View view) {
                    return aj.this.vk(view) + ((vk) view.getLayoutParams()).bottomMargin;
                }
            };
            this.hw = hwVar2;
            this.vk = new com.byazt.hr.m(hwVar);
            this.w = new com.byazt.hr.m(hwVar2);
            this.m = false;
            this.g = false;
            this.ho = false;
            this.hn = true;
            this.x = true;
        }

        public void pr(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.aj = null;
                this.zo = null;
                this.fw = 0;
                this.lb = 0;
            } else {
                this.aj = recyclerView;
                this.zo = recyclerView.fw;
                this.fw = recyclerView.getWidth();
                this.lb = recyclerView.getHeight();
            }
            this.c = 1073741824;
            this.uc = 1073741824;
        }

        public void hw(int i, int i2) {
            this.fw = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.c = mode;
            if (mode == 0 && !RecyclerView.hw) {
                this.fw = 0;
            }
            this.lb = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.uc = mode2;
            if (mode2 == 0 && !RecyclerView.hw) {
                this.lb = 0;
            }
        }

        public void hn(int i, int i2) {
            int iQa = qa();
            if (iQa == 0) {
                this.aj.c(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < iQa; i7++) {
                View viewZo = zo(i7);
                Rect rect = this.aj.w;
                pr(viewZo, rect);
                if (rect.left < i4) {
                    i4 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i5) {
                    i5 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.aj.w.set(i4, i5, i3, i6);
            pr(this.aj.w, i, i2);
        }

        public void pr(Rect rect, int i, int i2) {
            c(pr(i, rect.width() + rc() + b(), nl()), pr(i2, rect.height() + z() + iu(), y()));
        }

        public void m() {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int pr(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public void pr(String str) {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                recyclerView.pr(str);
            }
        }

        public boolean pr() {
            return this.ho;
        }

        public boolean k() {
            return false;
        }

        public final boolean g() {
            return this.x;
        }

        public void pr(int i, int i2, a aVar, pr prVar) {
        }

        public void pr(int i, pr prVar) {
        }

        public void hw(RecyclerView recyclerView) {
            this.g = true;
            hn(recyclerView);
        }

        public void hw(RecyclerView recyclerView, nt ntVar) {
            this.g = false;
            pr(recyclerView, ntVar);
        }

        public void hn(RecyclerView recyclerView) {
        }

        public void pr(RecyclerView recyclerView, nt ntVar) {
        }

        public boolean ho() {
            RecyclerView recyclerView = this.aj;
            return recyclerView != null && recyclerView.aj;
        }

        public void pr(nt ntVar, a aVar) {
            com.byazt.ca.ho.hw("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void hw(a aVar) {
        }

        public boolean pr(vk vkVar) {
            return vkVar != null;
        }

        public vk pr(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof vk) {
                return new vk((vk) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new vk((ViewGroup.MarginLayoutParams) layoutParams) : new vk(layoutParams);
        }

        public vk pr(Context context, AttributeSet attributeSet) {
            return new vk(context, attributeSet);
        }

        public int pr(int i, nt ntVar, a aVar) {
            return 0;
        }

        public int hw(int i, nt ntVar, a aVar) {
            return 0;
        }

        public boolean hn() {
            return false;
        }

        public boolean x() {
            return false;
        }

        public void x(int i) {
        }

        public void pr(RecyclerView recyclerView, a aVar, int i) {
            com.byazt.ca.ho.hw("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void pr(qa qaVar) {
            qa qaVar2 = this.k;
            if (qaVar2 != null && qaVar != qaVar2 && qaVar2.fw()) {
                this.k.c();
            }
            this.k = qaVar;
            qaVar.pr(this.aj, this);
        }

        public boolean nt() {
            qa qaVar = this.k;
            return qaVar != null && qaVar.fw();
        }

        public int yb() {
            return com.byazt.vu.fw.pr(this.aj);
        }

        public void pr(View view) {
            pr(view, -1);
        }

        public void pr(View view, int i) {
            pr(view, i, true);
        }

        public void hw(View view) {
            hw(view, -1);
        }

        public void hw(View view, int i) {
            pr(view, i, false);
        }

        private void pr(View view, int i, boolean z) {
            fo foVarC = RecyclerView.c(view);
            if (!z && !foVarC.yb()) {
                this.aj.zo.uc(foVarC);
            } else {
                this.aj.zo.c(foVarC);
            }
            vk vkVar = (vk) view.getLayoutParams();
            if (!foVarC.w() && !foVarC.aj()) {
                if (view.getParent() == this.aj) {
                    int iHw = this.zo.hw(view);
                    if (i == -1) {
                        i = this.zo.hw();
                    }
                    if (iHw == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.aj.indexOfChild(view) + this.aj.pr());
                    }
                    if (iHw != i) {
                        this.aj.g.x(iHw, i);
                    }
                } else {
                    this.zo.pr(view, i, false);
                    vkVar.hn = true;
                    qa qaVar = this.k;
                    if (qaVar != null && qaVar.fw()) {
                        this.k.hw(view);
                    }
                }
            } else {
                if (foVarC.aj()) {
                    foVarC.vk();
                } else {
                    foVarC.k();
                }
                this.zo.pr(view, i, view.getLayoutParams(), false);
            }
            if (vkVar.x) {
                foVarC.pr.invalidate();
                vkVar.x = false;
            }
        }

        public void hn(View view) {
            this.zo.pr(view);
        }

        public void uc(int i) {
            if (zo(i) != null) {
                this.zo.pr(i);
            }
        }

        public int lb() {
            return -1;
        }

        public int x(View view) {
            return ((vk) view.getLayoutParams()).x();
        }

        public View hw(int i) {
            int iQa = qa();
            for (int i2 = 0; i2 < iQa; i2++) {
                View viewZo = zo(i2);
                fo foVarC = RecyclerView.c(viewZo);
                if (foVarC != null && foVarC.x() == i && !foVarC.X_() && (this.aj.gz.pr() || !foVarC.yb())) {
                    return viewZo;
                }
            }
            return null;
        }

        public void fw(int i) {
            pr(i, zo(i));
        }

        private void pr(int i, View view) {
            this.zo.c(i);
        }

        public void pr(View view, int i, vk vkVar) {
            fo foVarC = RecyclerView.c(view);
            if (foVarC.yb()) {
                this.aj.zo.c(foVarC);
            } else {
                this.aj.zo.uc(foVarC);
            }
            this.zo.pr(view, i, vkVar, foVarC.yb());
        }

        public void hn(View view, int i) {
            pr(view, i, (vk) view.getLayoutParams());
        }

        public void x(int i, int i2) {
            View viewZo = zo(i);
            if (viewZo == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.aj.toString());
            }
            fw(i);
            hn(viewZo, i2);
        }

        public void pr(View view, nt ntVar) {
            hn(view);
            ntVar.pr(view);
        }

        public void pr(int i, nt ntVar) {
            View viewZo = zo(i);
            uc(i);
            ntVar.pr(viewZo);
        }

        public int qa() {
            com.byazt.hr.hw hwVar = this.zo;
            if (hwVar != null) {
                return hwVar.hw();
            }
            return 0;
        }

        public View zo(int i) {
            com.byazt.hr.hw hwVar = this.zo;
            if (hwVar != null) {
                return hwVar.hw(i);
            }
            return null;
        }

        public int a() {
            return this.c;
        }

        public int cz() {
            return this.uc;
        }

        public int ny() {
            return this.fw;
        }

        public int fo() {
            return this.lb;
        }

        public int rc() {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int z() {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int b() {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int iu() {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View ve() {
            View focusedChild;
            RecyclerView recyclerView = this.aj;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.zo.hn(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int gz() {
            RecyclerView recyclerView = this.aj;
            pr adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.pr();
            }
            return 0;
        }

        public void aj(int i) {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                recyclerView.uc(i);
            }
        }

        public void vk(int i) {
            RecyclerView recyclerView = this.aj;
            if (recyclerView != null) {
                recyclerView.c(i);
            }
        }

        public void pr(nt ntVar) {
            for (int iQa = qa() - 1; iQa >= 0; iQa--) {
                pr(ntVar, iQa, zo(iQa));
            }
        }

        private void pr(nt ntVar, int i, View view) {
            fo foVarC = RecyclerView.c(view);
            if (!foVarC.X_()) {
                if (foVarC.g() && !foVarC.yb() && !this.aj.m.hw()) {
                    uc(i);
                    ntVar.hw(foVarC);
                } else {
                    fw(i);
                    ntVar.hn(view);
                    this.aj.zo.zo(foVarC);
                }
            }
        }

        public void hw(nt ntVar) {
            int iC = ntVar.c();
            for (int i = iC - 1; i >= 0; i--) {
                View viewX = ntVar.x(i);
                fo foVarC = RecyclerView.c(viewX);
                if (!foVarC.X_()) {
                    foVarC.pr(false);
                    if (foVarC.lb()) {
                        this.aj.removeDetachedView(viewX, false);
                    }
                    if (this.aj.z != null) {
                        this.aj.z.x(foVarC);
                    }
                    foVarC.pr(true);
                    ntVar.hw(viewX);
                }
            }
            ntVar.uc();
            if (iC > 0) {
                this.aj.invalidate();
            }
        }

        public boolean pr(View view, int i, int i2, vk vkVar) {
            return (!view.isLayoutRequested() && this.hn && hw(view.getWidth(), i, vkVar.width) && hw(view.getHeight(), i2, vkVar.height)) ? false : true;
        }

        private static boolean hw(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size < i) {
                        return false;
                    }
                    return true;
                case 0:
                    return true;
                case 1073741824:
                    if (size != i) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }

        public void pr(View view, int i, int i2) {
            vk vkVar = (vk) view.getLayoutParams();
            Rect rectAj = this.aj.aj(view);
            int i3 = i + rectAj.left + rectAj.right;
            int i4 = i2 + rectAj.top + rectAj.bottom;
            int iPr = pr(ny(), a(), rc() + b() + vkVar.leftMargin + vkVar.rightMargin + i3, vkVar.width, hn());
            int iPr2 = pr(fo(), cz(), z() + iu() + vkVar.topMargin + vkVar.bottomMargin + i4, vkVar.height, x());
            if (pr(view, iPr, iPr2, vkVar)) {
                view.measure(iPr, iPr2);
            }
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0032  */
        /* JADX WARN: Code duplicated, block: B:23:0x0041  */
        public static int pr(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = 1073741824;
                } else if (i4 != -1) {
                    if (i4 == -2) {
                        i2 = 0;
                        i4 = 0;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                } else {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i4 = iMax;
                            break;
                        case 0:
                        default:
                            i2 = 0;
                            i4 = 0;
                            break;
                    }
                }
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 != -1) {
                if (i4 == -2) {
                    if (i2 != Integer.MIN_VALUE && i2 != 1073741824) {
                        i4 = iMax;
                        i2 = 0;
                    } else {
                        i4 = iMax;
                        i2 = Integer.MIN_VALUE;
                    }
                } else {
                    i2 = 0;
                    i4 = 0;
                }
            } else {
                i4 = iMax;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public int c(View view) {
            Rect rect = ((vk) view.getLayoutParams()).hw;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int uc(View view) {
            Rect rect = ((vk) view.getLayoutParams()).hw;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void pr(View view, int i, int i2, int i3, int i4) {
            vk vkVar = (vk) view.getLayoutParams();
            Rect rect = vkVar.hw;
            view.layout(i + rect.left + vkVar.leftMargin, i2 + rect.top + vkVar.topMargin, (i3 - rect.right) - vkVar.rightMargin, (i4 - rect.bottom) - vkVar.bottomMargin);
        }

        public void pr(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((vk) view.getLayoutParams()).hw;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.aj != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.aj.k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void pr(View view, Rect rect) {
            RecyclerView.pr(view, rect);
        }

        public int fw(View view) {
            return view.getLeft() - m(view);
        }

        public int zo(View view) {
            return view.getTop() - w(view);
        }

        public int aj(View view) {
            return view.getRight() + g(view);
        }

        public int vk(View view) {
            return view.getBottom() + k(view);
        }

        public int w(View view) {
            return ((vk) view.getLayoutParams()).hw.top;
        }

        public int k(View view) {
            return ((vk) view.getLayoutParams()).hw.bottom;
        }

        public int m(View view) {
            return ((vk) view.getLayoutParams()).hw.left;
        }

        public int g(View view) {
            return ((vk) view.getLayoutParams()).hw.right;
        }

        public View pr(View view, int i, nt ntVar, a aVar) {
            return null;
        }

        public View x(View view, int i) {
            return null;
        }

        private int[] hw(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iRc = rc();
            int iZ = z();
            int iNy = ny() - b();
            int iFo = fo() - iu();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iRc;
            int iMin = Math.min(0, i);
            int i2 = top - iZ;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iNy;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iFo);
            if (yb() == 1) {
                if (iMax == 0) {
                    iMax = Math.max(iMin, i3);
                }
            } else {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean pr(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return pr(recyclerView, view, rect, z, false);
        }

        public boolean pr(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrHw = hw(recyclerView, view, rect, z);
            int i = iArrHw[0];
            int i2 = iArrHw[1];
            if ((z2 && !pr(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.pr(i, i2);
            }
            return true;
        }

        private boolean pr(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iRc = rc();
            int iZ = z();
            int iNy = ny() - b();
            int iFo = fo() - iu();
            Rect rect = this.aj.w;
            pr(focusedChild, rect);
            return rect.left - i < iNy && rect.right - i > iRc && rect.top - i2 < iFo && rect.bottom - i2 > iZ;
        }

        @Deprecated
        public boolean pr(RecyclerView recyclerView, View view, View view2) {
            return nt() || recyclerView.g();
        }

        public boolean pr(RecyclerView recyclerView, a aVar, View view, View view2) {
            return pr(recyclerView, view, view2);
        }

        public boolean pr(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int c(a aVar) {
            return 0;
        }

        public int hn(a aVar) {
            return 0;
        }

        public int fw(a aVar) {
            return 0;
        }

        public int uc(a aVar) {
            return 0;
        }

        public int x(a aVar) {
            return 0;
        }

        public int zo(a aVar) {
            return 0;
        }

        public void pr(nt ntVar, a aVar, int i, int i2) {
            this.aj.c(i, i2);
        }

        public void c(int i, int i2) {
            this.aj.setMeasuredDimension(i, i2);
        }

        public int nl() {
            return com.byazt.vu.fw.x(this.aj);
        }

        public int y() {
            return com.byazt.vu.fw.c(this.aj);
        }

        public void ww() {
            qa qaVar = this.k;
            if (qaVar != null) {
                qaVar.c();
            }
        }

        public void hw(qa qaVar) {
            if (this.k == qaVar) {
                this.k = null;
            }
        }

        public void w(int i) {
        }

        public void hn(nt ntVar) {
            for (int iQa = qa() - 1; iQa >= 0; iQa--) {
                if (!RecyclerView.c(zo(iQa)).X_()) {
                    pr(iQa, ntVar);
                }
            }
        }

        public void x(RecyclerView recyclerView) {
            hw(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean aj() {
            return false;
        }

        public boolean n() {
            int iQa = qa();
            for (int i = 0; i < iQa; i++) {
                ViewGroup.LayoutParams layoutParams = zo(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2326})
    public static abstract class pr<VH extends fo> {
        public final hw pr = new hw();
        public boolean hw = false;

        public abstract int pr();

        public abstract VH pr(ViewGroup viewGroup, int i);

        public abstract void pr(VH vh, int i);

        public void pr(VH vh, int i, List<Object> list) {
            pr(vh, i);
        }

        public final VH hw(ViewGroup viewGroup, int i) {
            try {
                com.byazt.de.pr.pr("RV CreateView");
                VH vh = (VH) pr(viewGroup, i);
                if (vh.pr.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.uc = i;
                com.byazt.de.pr.pr();
                return vh;
            } catch (Throwable th) {
                com.byazt.de.pr.pr();
                throw th;
            }
        }

        public final void hw(VH vh, int i) {
            vh.hn = i;
            if (hw()) {
                vh.c = hw(i);
            }
            vh.pr(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.byazt.de.pr.pr("RV OnBindView");
            pr(vh, i, vh.cz());
            vh.a();
            ViewGroup.LayoutParams layoutParams = vh.pr.getLayoutParams();
            if (layoutParams instanceof vk) {
                ((vk) layoutParams).hn = true;
            }
            com.byazt.de.pr.pr();
        }

        public int pr(int i) {
            return 0;
        }

        public long hw(int i) {
            return -1L;
        }

        public final boolean hw() {
            return this.hw;
        }

        public void pr(VH vh) {
        }

        public boolean hw(VH vh) {
            return false;
        }

        public void pr(hn hnVar) {
            this.pr.registerObserver(hnVar);
        }

        public void hw(hn hnVar) {
            this.pr.unregisterObserver(hnVar);
        }

        public final void hn() {
            this.pr.pr();
        }

        public final void pr(int i, Object obj) {
            this.pr.pr(i, 1, obj);
        }

        public final void pr(int i, int i2) {
            this.pr.pr(i, i2);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2233})
    public final class nt {
        public cz aj;
        public ho c;
        public final List<fo> fw;
        public final ArrayList<fo> hn;
        public ArrayList<fo> hw;
        public final ArrayList<fo> pr;
        public int x;
        public int zo;

        public nt() {
            ArrayList<fo> arrayList = new ArrayList<>();
            this.pr = arrayList;
            this.hw = null;
            this.hn = new ArrayList<>();
            this.fw = Collections.unmodifiableList(arrayList);
            this.zo = 2;
            this.x = 2;
        }

        public void pr() {
            this.pr.clear();
            x();
        }

        public void pr(int i) {
            this.zo = i;
            hw();
        }

        public void hw() {
            this.x = this.zo + (RecyclerView.this.g != null ? RecyclerView.this.g.nt : 0);
            for (int size = this.hn.size() - 1; size >= 0 && this.hn.size() > this.x; size--) {
                hn(size);
            }
        }

        public List<fo> hn() {
            return this.fw;
        }

        public boolean pr(fo foVar) {
            if (foVar.yb()) {
                return RecyclerView.this.gz.pr();
            }
            if (foVar.hn >= 0 && foVar.hn < RecyclerView.this.m.pr()) {
                if (RecyclerView.this.gz.pr() || RecyclerView.this.m.pr(foVar.hn) == foVar.zo()) {
                    return !RecyclerView.this.m.hw() || foVar.fw() == RecyclerView.this.m.hw(foVar.hn);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + foVar + RecyclerView.this.pr());
        }

        private boolean pr(fo foVar, int i, int i2, long j) {
            foVar.nt = RecyclerView.this;
            int iZo = foVar.zo();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != LongCompanionObject.MAX_VALUE && !this.c.hw(iZo, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.m.hw(foVar, i);
            this.c.hw(foVar.zo(), RecyclerView.this.getNanoTime() - nanoTime);
            if (RecyclerView.this.gz.pr()) {
                foVar.fw = i2;
                return true;
            }
            return true;
        }

        public View hw(int i) {
            return pr(i, false);
        }

        public View pr(int i, boolean z) {
            return pr(i, z, LongCompanionObject.MAX_VALUE).pr;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0218  */
        /* JADX WARN: Code duplicated, block: B:102:0x0220  */
        /* JADX WARN: Code duplicated, block: B:103:0x022e  */
        /* JADX WARN: Code duplicated, block: B:108:0x0237  */
        /* JADX WARN: Code duplicated, block: B:99:0x020a  */
        public fo pr(int i, boolean z, long j) {
            fo foVarHw;
            boolean z2;
            fo foVar;
            boolean z3;
            boolean zPr;
            ViewGroup.LayoutParams layoutParams;
            vk vkVar;
            RecyclerView recyclerViewVk;
            cz czVar;
            View viewPr;
            if (i >= 0 && i < RecyclerView.this.gz.x()) {
                if (!RecyclerView.this.gz.pr()) {
                    foVarHw = null;
                    z2 = false;
                } else {
                    foVarHw = c(i);
                    z2 = foVarHw != null;
                }
                if (foVarHw == null && (foVarHw = hw(i, z)) != null) {
                    if (!pr(foVarHw)) {
                        if (!z) {
                            foVarHw.hw(4);
                            if (foVarHw.aj()) {
                                RecyclerView.this.removeDetachedView(foVarHw.pr, false);
                                foVarHw.vk();
                            } else if (foVarHw.w()) {
                                foVarHw.k();
                            }
                            hw(foVarHw);
                        }
                        foVarHw = null;
                    } else {
                        z2 = true;
                    }
                }
                if (foVarHw != null) {
                    foVar = foVarHw;
                    z3 = z2;
                } else {
                    int iHw = RecyclerView.this.uc.hw(i);
                    if (iHw < 0 || iHw >= RecyclerView.this.m.pr()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iHw + ").state:" + RecyclerView.this.gz.x() + RecyclerView.this.pr());
                    }
                    int iPr = RecyclerView.this.m.pr(iHw);
                    if (RecyclerView.this.m.hw() && (foVarHw = pr(RecyclerView.this.m.hw(iHw), iPr, z)) != null) {
                        foVarHw.hn = iHw;
                        z2 = true;
                    }
                    if (foVarHw == null && (czVar = this.aj) != null && (viewPr = czVar.pr(this, i, iPr)) != null) {
                        foVarHw = RecyclerView.this.hw(viewPr);
                        if (foVarHw == null) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.pr());
                        }
                        if (foVarHw.X_()) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.pr());
                        }
                    }
                    if (foVarHw == null) {
                        fo foVarPr = fw().pr(iPr);
                        if (foVarPr != null) {
                            foVarPr.ny();
                            if (RecyclerView.pr) {
                                c(foVarPr);
                            }
                        }
                        foVarHw = foVarPr;
                    }
                    if (foVarHw != null) {
                        foVar = foVarHw;
                        z3 = z2;
                    } else {
                        long nanoTime = RecyclerView.this.getNanoTime();
                        if (j != LongCompanionObject.MAX_VALUE && !this.c.pr(iPr, nanoTime, j)) {
                            return null;
                        }
                        fo foVarHw2 = RecyclerView.this.m.hw(RecyclerView.this, iPr);
                        if (RecyclerView.x && (recyclerViewVk = RecyclerView.vk(foVarHw2.pr)) != null) {
                            foVarHw2.hw = new WeakReference<>(recyclerViewVk);
                        }
                        this.c.pr(iPr, RecyclerView.this.getNanoTime() - nanoTime);
                        foVar = foVarHw2;
                        z3 = z2;
                    }
                }
                if (z3 && !RecyclerView.this.gz.pr() && foVar.pr(8192)) {
                    foVar.pr(0, 8192);
                    if (RecyclerView.this.gz.vk) {
                        RecyclerView.this.pr(foVar, RecyclerView.this.z.pr(RecyclerView.this.gz, foVar, uc.c(foVar) | 4096, foVar.cz()));
                    }
                }
                if (RecyclerView.this.gz.pr() && foVar.nt()) {
                    foVar.fw = i;
                } else {
                    if (!foVar.nt() || foVar.ho() || foVar.g()) {
                        zPr = pr(foVar, RecyclerView.this.uc.hw(i), i, j);
                    }
                    layoutParams = foVar.pr.getLayoutParams();
                    if (layoutParams == null) {
                        vkVar = (vk) RecyclerView.this.generateDefaultLayoutParams();
                        foVar.pr.setLayoutParams(vkVar);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                        vkVar = (vk) RecyclerView.this.generateLayoutParams(layoutParams);
                        foVar.pr.setLayoutParams(vkVar);
                    } else {
                        vkVar = (vk) layoutParams;
                    }
                    vkVar.pr = foVar;
                    vkVar.x = !z3 && zPr;
                    return foVar;
                }
                zPr = false;
                layoutParams = foVar.pr.getLayoutParams();
                if (layoutParams == null) {
                    vkVar = (vk) RecyclerView.this.generateDefaultLayoutParams();
                    foVar.pr.setLayoutParams(vkVar);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                    vkVar = (vk) RecyclerView.this.generateLayoutParams(layoutParams);
                    foVar.pr.setLayoutParams(vkVar);
                } else {
                    vkVar = (vk) layoutParams;
                }
                vkVar.pr = foVar;
                vkVar.x = !z3 && zPr;
                return foVar;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.gz.x() + RecyclerView.this.pr());
        }

        private void c(fo foVar) {
            if (foVar.pr instanceof ViewGroup) {
                pr((ViewGroup) foVar.pr, false);
            }
        }

        private void pr(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    pr((ViewGroup) childAt, true);
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

        public void pr(View view) {
            fo foVarC = RecyclerView.c(view);
            if (foVarC.lb()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (foVarC.aj()) {
                foVarC.vk();
            } else if (foVarC.w()) {
                foVarC.k();
            }
            hw(foVarC);
        }

        public void x() {
            for (int size = this.hn.size() - 1; size >= 0; size--) {
                hn(size);
            }
            this.hn.clear();
            if (RecyclerView.x) {
                RecyclerView.this.ve.pr();
            }
        }

        public void hn(int i) {
            pr(this.hn.get(i), true);
            this.hn.remove(i);
        }

        public void hw(fo foVar) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (!foVar.aj() && foVar.pr.getParent() == null) {
                if (foVar.lb()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + foVar + RecyclerView.this.pr());
                }
                if (foVar.X_()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.pr());
                }
                boolean z4 = foVar.z();
                if ((RecyclerView.this.m != null && z4 && RecyclerView.this.m.hw(foVar)) || foVar.fo()) {
                    if (this.x > 0 && !foVar.pr(526)) {
                        int size = this.hn.size();
                        if (size >= this.x && size > 0) {
                            hn(0);
                            size--;
                        }
                        if (RecyclerView.x && size > 0 && !RecyclerView.this.ve.pr(foVar.hn)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.ve.pr(this.hn.get(i).hn)) {
                                    break;
                                } else {
                                    i--;
                                }
                            }
                            size = i + 1;
                        }
                        this.hn.add(size, foVar);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z3 = false;
                        z2 = z;
                    } else {
                        pr(foVar, true);
                        z2 = z;
                    }
                } else {
                    z3 = false;
                }
                RecyclerView.this.zo.fw(foVar);
                if (!z2 && !z3 && z4) {
                    foVar.nt = null;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + foVar.aj() + " isAttached:" + (foVar.pr.getParent() != null) + RecyclerView.this.pr());
        }

        public void pr(fo foVar, boolean z) {
            RecyclerView.hn(foVar);
            if (foVar.pr(16384)) {
                foVar.pr(0, 16384);
            }
            if (z) {
                x(foVar);
            }
            foVar.nt = null;
            fw().pr(foVar);
        }

        public void hw(View view) {
            fo foVarC = RecyclerView.c(view);
            foVarC.m = null;
            foVarC.g = false;
            foVarC.k();
            hw(foVarC);
        }

        public void hn(View view) {
            fo foVarC = RecyclerView.c(view);
            if (!foVarC.pr(12) && foVarC.b() && !RecyclerView.this.hw(foVarC)) {
                if (this.hw == null) {
                    this.hw = new ArrayList<>();
                }
                foVarC.pr(this, true);
                this.hw.add(foVarC);
                return;
            }
            if (foVarC.g() && !foVarC.yb() && !RecyclerView.this.m.hw()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.pr());
            }
            foVarC.pr(this, false);
            this.pr.add(foVarC);
        }

        public void hn(fo foVar) {
            if (foVar.g) {
                this.hw.remove(foVar);
            } else {
                this.pr.remove(foVar);
            }
            foVar.m = null;
            foVar.g = false;
            foVar.k();
        }

        public int c() {
            return this.pr.size();
        }

        public View x(int i) {
            return this.pr.get(i).pr;
        }

        public void uc() {
            this.pr.clear();
            ArrayList<fo> arrayList = this.hw;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public fo c(int i) {
            int size;
            int iHw;
            ArrayList<fo> arrayList = this.hw;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            for (int i2 = 0; i2 < size; i2++) {
                fo foVar = this.hw.get(i2);
                if (!foVar.w() && foVar.x() == i) {
                    foVar.hw(32);
                    return foVar;
                }
            }
            if (RecyclerView.this.m.hw() && (iHw = RecyclerView.this.uc.hw(i)) > 0 && iHw < RecyclerView.this.m.pr()) {
                long jHw = RecyclerView.this.m.hw(iHw);
                for (int i3 = 0; i3 < size; i3++) {
                    fo foVar2 = this.hw.get(i3);
                    if (!foVar2.w() && foVar2.fw() == jHw) {
                        foVar2.hw(32);
                        return foVar2;
                    }
                }
            }
            return null;
        }

        public fo hw(int i, boolean z) {
            View viewHn;
            int size = this.pr.size();
            for (int i2 = 0; i2 < size; i2++) {
                fo foVar = this.pr.get(i2);
                if (!foVar.w() && foVar.x() == i && !foVar.g() && (RecyclerView.this.gz.fw || !foVar.yb())) {
                    foVar.hw(32);
                    return foVar;
                }
            }
            if (!z && (viewHn = RecyclerView.this.fw.hn(i)) != null) {
                fo foVarC = RecyclerView.c(viewHn);
                RecyclerView.this.fw.c(viewHn);
                int iHw = RecyclerView.this.fw.hw(viewHn);
                if (iHw == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + foVarC + RecyclerView.this.pr());
                }
                RecyclerView.this.fw.c(iHw);
                hn(viewHn);
                foVarC.hw(8224);
                return foVarC;
            }
            int size2 = this.hn.size();
            for (int i3 = 0; i3 < size2; i3++) {
                fo foVar2 = this.hn.get(i3);
                if (!foVar2.g() && foVar2.x() == i) {
                    if (!z) {
                        this.hn.remove(i3);
                    }
                    return foVar2;
                }
            }
            return null;
        }

        public fo pr(long j, int i, boolean z) {
            for (int size = this.pr.size() - 1; size >= 0; size--) {
                fo foVar = this.pr.get(size);
                if (foVar.fw() == j && !foVar.w()) {
                    if (i == foVar.zo()) {
                        foVar.hw(32);
                        if (foVar.yb() && !RecyclerView.this.gz.pr()) {
                            foVar.pr(2, 14);
                        }
                        return foVar;
                    }
                    if (!z) {
                        this.pr.remove(size);
                        RecyclerView.this.removeDetachedView(foVar.pr, false);
                        hw(foVar.pr);
                    }
                }
            }
            int size2 = this.hn.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                fo foVar2 = this.hn.get(size2);
                if (foVar2.fw() == j) {
                    if (i == foVar2.zo()) {
                        if (!z) {
                            this.hn.remove(size2);
                        }
                        return foVar2;
                    }
                    if (!z) {
                        hn(size2);
                        return null;
                    }
                }
            }
        }

        public void x(fo foVar) {
            if (RecyclerView.this.m != null) {
                RecyclerView.this.m.pr(foVar);
            }
            if (RecyclerView.this.gz != null) {
                RecyclerView.this.zo.fw(foVar);
            }
        }

        public void pr(pr prVar, pr prVar2, boolean z) {
            pr();
            fw().pr(prVar, prVar2, z);
        }

        public void pr(int i, int i2) {
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
            int size = this.hn.size();
            for (int i6 = 0; i6 < size; i6++) {
                fo foVar = this.hn.get(i6);
                if (foVar != null && foVar.hn >= i5 && foVar.hn <= i4) {
                    if (foVar.hn == i) {
                        foVar.pr(i2 - i, false);
                    } else {
                        foVar.pr(i3, false);
                    }
                }
            }
        }

        public void hw(int i, int i2) {
            int size = this.hn.size();
            for (int i3 = 0; i3 < size; i3++) {
                fo foVar = this.hn.get(i3);
                if (foVar != null && foVar.hn >= i) {
                    foVar.pr(i2, true);
                }
            }
        }

        public void pr(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.hn.size() - 1; size >= 0; size--) {
                fo foVar = this.hn.get(size);
                if (foVar != null) {
                    if (foVar.hn >= i3) {
                        foVar.pr(-i2, z);
                    } else if (foVar.hn >= i) {
                        foVar.hw(8);
                        hn(size);
                    }
                }
            }
        }

        public void pr(cz czVar) {
            this.aj = czVar;
        }

        public void pr(ho hoVar) {
            ho hoVar2 = this.c;
            if (hoVar2 != null) {
                hoVar2.hn();
            }
            this.c = hoVar;
            if (hoVar != null && RecyclerView.this.getAdapter() != null) {
                this.c.hw();
            }
        }

        public ho fw() {
            if (this.c == null) {
                this.c = new ho();
            }
            return this.c;
        }

        public void hn(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.hn.size() - 1; size >= 0; size--) {
                fo foVar = this.hn.get(size);
                if (foVar != null && (i3 = foVar.hn) >= i && i3 < i4) {
                    foVar.hw(2);
                    hn(size);
                }
            }
        }

        public void zo() {
            int size = this.hn.size();
            for (int i = 0; i < size; i++) {
                fo foVar = this.hn.get(i);
                if (foVar != null) {
                    foVar.hw(6);
                    foVar.pr((Object) null);
                }
            }
            if (RecyclerView.this.m == null || !RecyclerView.this.m.hw()) {
                x();
            }
        }

        public void aj() {
            int size = this.hn.size();
            for (int i = 0; i < size; i++) {
                this.hn.get(i).pr();
            }
            int size2 = this.pr.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.pr.get(i2).pr();
            }
            ArrayList<fo> arrayList = this.hw;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.hw.get(i3).pr();
                }
            }
        }

        public void vk() {
            int size = this.hn.size();
            for (int i = 0; i < size; i++) {
                vk vkVar = (vk) this.hn.get(i).pr.getLayoutParams();
                if (vkVar != null) {
                    vkVar.hn = true;
                }
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2215})
    public static class ho {
        public SparseArray<pr> pr = new SparseArray<>();
        public int hw = 0;

        @com.byazt.vzx.pr(pr = {0, 1, 180, 2015})
        static class pr {
            public final ArrayList<fo> pr = new ArrayList<>();
            public int hw = 5;
            public long hn = 0;
            public long x = 0;
        }

        public void pr() {
            for (int i = 0; i < this.pr.size(); i++) {
                this.pr.valueAt(i).pr.clear();
            }
        }

        public fo pr(int i) {
            pr prVar = this.pr.get(i);
            if (prVar != null && !prVar.pr.isEmpty()) {
                ArrayList<fo> arrayList = prVar.pr;
                return arrayList.remove(arrayList.size() - 1);
            }
            return null;
        }

        public void pr(fo foVar) {
            int iZo = foVar.zo();
            ArrayList<fo> arrayList = hw(iZo).pr;
            if (this.pr.get(iZo).hw > arrayList.size()) {
                foVar.ny();
                arrayList.add(foVar);
            }
        }

        public long pr(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void pr(int i, long j) {
            pr prVarHw = hw(i);
            prVarHw.hn = pr(prVarHw.hn, j);
        }

        public void hw(int i, long j) {
            pr prVarHw = hw(i);
            prVarHw.x = pr(prVarHw.x, j);
        }

        public boolean pr(int i, long j, long j2) {
            long j3 = hw(i).hn;
            return j3 == 0 || j + j3 < j2;
        }

        public boolean hw(int i, long j, long j2) {
            long j3 = hw(i).x;
            return j3 == 0 || j + j3 < j2;
        }

        public void hw() {
            this.hw++;
        }

        public void hn() {
            this.hw--;
        }

        public void pr(pr prVar, pr prVar2, boolean z) {
            if (prVar != null) {
                hn();
            }
            if (!z && this.hw == 0) {
                pr();
            }
            if (prVar2 != null) {
                hw();
            }
        }

        private pr hw(int i) {
            pr prVar = this.pr.get(i);
            if (prVar == null) {
                pr prVar2 = new pr();
                this.pr.put(i, prVar2);
                return prVar2;
            }
            return prVar;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 1041})
    public static class c {
        public EdgeEffect pr(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2219})
    private class lb extends hn {
        public lb() {
        }

        @Override // com.byazt.hr.RecyclerView.hn
        public void pr() {
            RecyclerView.this.pr((String) null);
            RecyclerView.this.gz.uc = true;
            RecyclerView.this.hn(true);
            if (!RecyclerView.this.uc.x()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // com.byazt.hr.RecyclerView.hn
        public void pr(int i, int i2, Object obj) {
            RecyclerView.this.pr((String) null);
            if (RecyclerView.this.uc.pr(i, i2, obj)) {
                hw();
            }
        }

        public void hw() {
            if (RecyclerView.hn && RecyclerView.this.lb && RecyclerView.this.yb) {
                RecyclerView recyclerView = RecyclerView.this;
                com.byazt.vu.fw.pr(recyclerView, recyclerView.vk);
            } else {
                RecyclerView.this.ny = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, 2234})
    class ny implements Runnable {
        public int c;
        public OverScroller pr;
        public int x;
        public Interpolator hw = RecyclerView.ls;
        public boolean uc = false;
        public boolean fw = false;

        public ny() {
            this.pr = new OverScroller(RecyclerView.this.getContext(), RecyclerView.ls);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            if (RecyclerView.this.g == null) {
                hw();
                return;
            }
            hn();
            RecyclerView.this.x();
            OverScroller overScroller = this.pr;
            qa qaVar = RecyclerView.this.g.k;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.n;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.x;
                int i7 = currY - this.c;
                this.x = currX;
                this.c = currY;
                if (RecyclerView.this.pr(i6, i7, iArr, null, 1)) {
                    i6 -= iArr[0];
                    i7 -= iArr[1];
                }
                if (RecyclerView.this.m == null) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.pr(i6, i7, recyclerView.e);
                    i = RecyclerView.this.e[0];
                    i2 = RecyclerView.this.e[1];
                    i3 = i6 - i;
                    i4 = i7 - i2;
                    if (qaVar != null && !qaVar.uc() && qaVar.fw()) {
                        int iX = RecyclerView.this.gz.x();
                        if (iX == 0) {
                            qaVar.c();
                        } else {
                            if (qaVar.zo() >= iX) {
                                qaVar.hn(iX - 1);
                            }
                            qaVar.pr(i6 - i3, i7 - i4);
                        }
                    }
                }
                if (!RecyclerView.this.nt.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.hn(i6, i7);
                }
                if (!RecyclerView.this.pr(i, i2, i3, i4, (int[]) null, 1) && (i3 != 0 || i4 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i3 == currX) {
                        i5 = 0;
                    } else if (i3 < 0) {
                        i5 = -currVelocity;
                    } else {
                        i5 = i3 > 0 ? currVelocity : 0;
                    }
                    if (i4 == currY) {
                        currVelocity = 0;
                    } else if (i4 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i4 <= 0) {
                        currVelocity = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.x(i5, currVelocity);
                    }
                    if ((i5 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (i != 0 || i2 != 0) {
                    RecyclerView.this.zo(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i6 == 0 && i7 == 0) || (i6 != 0 && RecyclerView.this.g.hn() && i == i6) || (i7 != 0 && RecyclerView.this.g.x() && i2 == i7);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.aj(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.x) {
                        RecyclerView.this.ve.pr();
                    }
                    RecyclerView.this.zo(1);
                } else {
                    pr();
                    if (RecyclerView.this.iu != null) {
                        RecyclerView.this.iu.pr(RecyclerView.this, i6, i7);
                    }
                }
            }
            if (qaVar != null) {
                if (qaVar.uc()) {
                    qaVar.pr(0, 0);
                }
                if (!this.fw) {
                    qaVar.c();
                }
            }
            x();
        }

        private void hn() {
            this.fw = false;
            this.uc = true;
        }

        private void x() {
            this.uc = false;
            if (this.fw) {
                pr();
            }
        }

        public void pr() {
            if (this.uc) {
                this.fw = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.byazt.vu.fw.pr(RecyclerView.this, this);
            }
        }

        public void pr(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.c = 0;
            this.x = 0;
            this.pr.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            pr();
        }

        public void hw(int i, int i2) {
            pr(i, i2, 0, 0);
        }

        public void pr(int i, int i2, int i3, int i4) {
            pr(i, i2, hw(i, i2, i3, i4));
        }

        private float pr(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int hw(int i, int i2, int i3, int i4) {
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
            float fPr = f2 + (pr(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fPr / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
        }

        public void pr(int i, int i2, int i3) {
            pr(i, i2, i3, RecyclerView.ls);
        }

        public void pr(int i, int i2, Interpolator interpolator) {
            int iHw = hw(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.ls;
            }
            pr(i, i2, iHw, interpolator);
        }

        public void pr(int i, int i2, int i3, Interpolator interpolator) {
            if (this.hw != interpolator) {
                this.hw = interpolator;
                this.pr = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.c = 0;
            this.x = 0;
            this.pr.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.pr.computeScrollOffset();
            }
            pr();
        }

        public void hw() {
            RecyclerView.this.removeCallbacks(this);
            this.pr.abortAnimation();
        }
    }
}
