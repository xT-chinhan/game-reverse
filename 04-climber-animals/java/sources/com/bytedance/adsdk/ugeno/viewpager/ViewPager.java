package com.bytedance.adsdk.ugeno.viewpager;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.bytedance.sdk.component.utils.sl;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPager extends ViewGroup {
    private final ArrayList<xr> ab;
    com.bytedance.adsdk.ugeno.viewpager.xr ah;
    private boolean am;
    private int ao;
    private int az;
    private int b;
    private int ch;
    private boolean cv;
    int d;
    private int e;
    private int eg;
    private float f;
    private boolean fm;
    private int g;
    private int gy;
    private Drawable h;
    private Parcelable hi;
    private boolean i;
    private EdgeEffect il;
    private float jw;
    private int k;
    private boolean l;
    private boolean le;
    private int lm;
    private VelocityTracker m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f397ms;
    private float nw;
    private final Rect ny;
    private int of;
    private int op;
    private int p;
    private float pc;
    private boolean qf;
    private ka qk;
    private int qv;
    private int re;
    private ArrayList<View> rt;
    private d s;
    private int sa;
    private final Runnable sk;
    private ClassLoader sl;
    private float t;
    private d ti;
    private List<d> tz;
    private boolean u;
    private c ub;
    private float ul;
    private List<Object> v;
    private int vm;
    private boolean w;
    private final xr x;
    private EdgeEffect xn;
    private int y;
    private boolean yu;
    private Scroller zb;
    private int zf;
    static final int[] xr = {R.attr.layout_gravity};
    private static final Comparator<xr> ka = new Comparator<xr>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(xr xrVar, xr xrVar2) {
            return xrVar.xr - xrVar2.xr;
        }
    };
    private static final Interpolator c = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final x vy = new x();

    public interface d {
        void ms(int i, float f, int i2);

        void ny(int i);

        void x(int i);
    }

    public interface ka {
        void ms(View view, float f);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ms {
    }

    static class xr {
        boolean ah;
        float d;
        float ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        Object f401ms;
        int xr;

        xr() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.ab = new ArrayList<>();
        this.x = new xr();
        this.ny = new Rect();
        this.ch = -1;
        this.hi = null;
        this.sl = null;
        this.t = -3.4028235E38f;
        this.nw = Float.MAX_VALUE;
        this.op = 1;
        this.az = -1;
        this.qf = true;
        this.l = false;
        this.sk = new Runnable() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.ah();
            }
        };
        this.gy = 0;
        ms();
    }

    void ms() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.zb = new Scroller(context, c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.p = viewConfiguration.getScaledPagingTouchSlop();
        this.lm = (int) (400.0f * f);
        this.e = viewConfiguration.getScaledMaximumFlingVelocity();
        this.xn = new EdgeEffect(context);
        this.il = new EdgeEffect(context);
        this.k = (int) (25.0f * f);
        this.eg = (int) (2.0f * f);
        this.g = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.zb = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.sk);
        Scroller scroller = this.zb;
        if (scroller != null && !scroller.isFinished()) {
            this.zb.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.gy == i) {
            return;
        }
        this.gy = i;
        if (this.qk != null) {
            xr(i != 0);
        }
        c(i);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.xr xrVar) {
        com.bytedance.adsdk.ugeno.viewpager.xr xrVar2 = this.ah;
        if (xrVar2 != null) {
            xrVar2.ms((DataSetObserver) null);
            for (int i = 0; i < this.ab.size(); i++) {
                xr xrVar3 = this.ab.get(i);
                this.ah.ms((ViewGroup) this, xrVar3.xr, xrVar3.f401ms);
            }
            this.ab.clear();
            c();
            this.d = 0;
            scrollTo(0, 0);
        }
        this.ah = xrVar;
        this.f397ms = 0;
        if (xrVar != null) {
            if (this.ub == null) {
                this.ub = new c();
            }
            this.ah.ms((DataSetObserver) this.ub);
            this.yu = false;
            boolean z = this.qf;
            this.qf = true;
            this.f397ms = this.ah.ms();
            int i2 = this.ch;
            if (i2 >= 0) {
                ms(i2, false, true);
                this.ch = -1;
                this.hi = null;
                this.sl = null;
            } else if (!z) {
                ah();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.v;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.v.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.v.get(i3);
        }
    }

    private void c() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((ah) getChildAt(i).getLayoutParams()).f399ms) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.bytedance.adsdk.ugeno.viewpager.xr getAdapter() {
        return this.ah;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.yu = false;
        ms(i, !this.qf, false);
    }

    public void ms(int i, boolean z) {
        this.yu = false;
        ms(i, z, false);
    }

    public int getCurrentItem() {
        return this.d;
    }

    void ms(int i, boolean z, boolean z2) {
        ms(i, z, z2, 0);
    }

    void ms(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.viewpager.xr xrVar = this.ah;
        if (xrVar == null || xrVar.ms() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.d == i && this.ab.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.ah.ms()) {
            i = this.ah.ms() - 1;
        }
        int i3 = this.op;
        int i4 = this.d;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.ab.size(); i5++) {
                this.ab.get(i5).ah = true;
            }
        }
        boolean z3 = this.d != i;
        if (this.qf) {
            this.d = i;
            if (z3) {
                ka(i);
            }
            requestLayout();
            return;
        }
        ms(i);
        ms(i, z, i2, z3);
    }

    private void ms(int i, boolean z, int i2, boolean z2) {
        xr xrVarXr = xr(i);
        int clientWidth = xrVarXr != null ? (int) (getClientWidth() * Math.max(this.t, Math.min(xrVarXr.ka, this.nw))) : 0;
        if (z) {
            ms(clientWidth, 0, i2);
            if (z2) {
                ka(i);
                return;
            }
            return;
        }
        if (z2) {
            ka(i);
        }
        ms(false);
        scrollTo(clientWidth, 0);
        d(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(d dVar) {
        this.ti = dVar;
    }

    public void ms(d dVar) {
        if (this.tz == null) {
            this.tz = new ArrayList();
        }
        this.tz.add(dVar);
    }

    public void ms(boolean z, ka kaVar) {
        ms(z, kaVar, 2);
    }

    public void ms(boolean z, ka kaVar, int i) {
        boolean z2 = kaVar != null;
        boolean z3 = z2 != (this.qk != null);
        this.qk = kaVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.zf = z ? 2 : 1;
            this.vm = i;
        } else {
            this.zf = 0;
        }
        if (z3) {
            ah();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.zf == 2) {
            i2 = (i - 1) - i2;
        }
        return ((ah) this.rt.get(i2).getLayoutParams()).c;
    }

    public int getOffscreenPageLimit() {
        return this.op;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            sl.xr("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.op) {
            this.op = i;
            ah();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.ao;
        this.ao = i;
        int width = getWidth();
        ms(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.ao;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.h = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.h;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float ms(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    void ms(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.zb;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.u ? this.zb.getCurrX() : this.zb.getStartX();
            this.zb.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            ms(false);
            ah();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fMs = f2 + (ms(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fMs / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.ah.ms(this.d)) + this.ao)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.u = false;
        this.zb.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    xr ms(int i, int i2) {
        xr xrVar = new xr();
        xrVar.xr = i;
        xrVar.f401ms = this.ah.ms((ViewGroup) this, i);
        xrVar.d = this.ah.ms(i);
        if (i2 < 0 || i2 >= this.ab.size()) {
            this.ab.add(xrVar);
        } else {
            this.ab.add(i2, xrVar);
        }
        return xrVar;
    }

    void xr() {
        int iMs = this.ah.ms();
        this.f397ms = iMs;
        boolean z = this.ab.size() < (this.op * 2) + 1 && this.ab.size() < iMs;
        int iMax = this.d;
        int i = 0;
        while (i < this.ab.size()) {
            xr xrVar = this.ab.get(i);
            int iMs2 = this.ah.ms(xrVar.f401ms);
            if (iMs2 != -1) {
                if (iMs2 == -2) {
                    this.ab.remove(i);
                    i--;
                    this.ah.ms((ViewGroup) this, xrVar.xr, xrVar.f401ms);
                    if (this.d == xrVar.xr) {
                        iMax = Math.max(0, Math.min(this.d, iMs - 1));
                    }
                } else if (xrVar.xr != iMs2) {
                    if (xrVar.xr == this.d) {
                        iMax = iMs2;
                    }
                    xrVar.xr = iMs2;
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.ab, ka);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ah ahVar = (ah) getChildAt(i2).getLayoutParams();
                if (!ahVar.f399ms) {
                    ahVar.ah = 0.0f;
                }
            }
            ms(iMax, false, true);
            requestLayout();
        }
    }

    void ah() {
        ms(this.d);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f5 A[PHI: r7 r10 r15
      0x00f5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    void ms(int i) {
        xr xrVarXr;
        String hexString;
        xr xrVarMs;
        xr xrVarMs2;
        xr xrVar;
        int i2 = this.d;
        if (i2 != i) {
            xrVarXr = xr(i2);
            this.d = i;
        } else {
            xrVarXr = null;
        }
        if (this.ah == null) {
            ab();
            return;
        }
        if (this.yu) {
            ab();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.op;
        int iMax = Math.max(0, this.d - i3);
        int iMs = this.ah.ms();
        int iMin = Math.min(iMs - 1, this.d + i3);
        if (iMs != this.f397ms) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f397ms + ", found: " + iMs + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.ah.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.ab.size()) {
                xrVarMs = this.ab.get(i4);
                if (xrVarMs.xr >= this.d) {
                    if (xrVarMs.xr != this.d) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            xrVarMs = null;
            break;
        }
        if (xrVarMs == null && iMs > 0) {
            xrVarMs = ms(this.d, i4);
        }
        if (xrVarMs != null) {
            int i5 = i4 - 1;
            xr xrVar2 = i5 >= 0 ? this.ab.get(i5) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - xrVarMs.d) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i6 = this.d - 1; i6 >= 0; i6--) {
                if (f >= paddingLeft && i6 < iMax) {
                    if (xrVar2 == null) {
                        break;
                    }
                    if (i6 == xrVar2.xr && !xrVar2.ah) {
                        this.ab.remove(i5);
                        this.ah.ms((ViewGroup) this, i6, xrVar2.f401ms);
                        i5--;
                        i4--;
                        if (i5 >= 0) {
                            xrVar = this.ab.get(i5);
                        } else {
                            xrVar = null;
                        }
                        xrVar2 = xrVar;
                    }
                } else {
                    if (xrVar2 != null && i6 == xrVar2.xr) {
                        f += xrVar2.d;
                        i5--;
                        if (i5 >= 0) {
                            xrVar = this.ab.get(i5);
                        } else {
                            xrVar = null;
                        }
                    } else {
                        f += ms(i6, i5 + 1).d;
                        i4++;
                        if (i5 >= 0) {
                            xrVar = this.ab.get(i5);
                        } else {
                            xrVar = null;
                        }
                    }
                    xrVar2 = xrVar;
                }
            }
            float f2 = xrVarMs.d;
            int i7 = i4 + 1;
            if (f2 < 2.0f) {
                xr xrVar3 = i7 < this.ab.size() ? this.ab.get(i7) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i8 = this.d;
                while (true) {
                    i8++;
                    if (i8 >= iMs) {
                        break;
                    }
                    if (f2 >= paddingRight && i8 > iMin) {
                        if (xrVar3 == null) {
                            break;
                        }
                        if (i8 == xrVar3.xr && !xrVar3.ah) {
                            this.ab.remove(i7);
                            this.ah.ms((ViewGroup) this, i8, xrVar3.f401ms);
                            if (i7 < this.ab.size()) {
                                xrVar3 = this.ab.get(i7);
                            }
                        }
                    } else if (xrVar3 != null && i8 == xrVar3.xr) {
                        f2 += xrVar3.d;
                        i7++;
                        if (i7 < this.ab.size()) {
                            xrVar3 = this.ab.get(i7);
                        }
                    } else {
                        xr xrVarMs3 = ms(i8, i7);
                        i7++;
                        f2 += xrVarMs3.d;
                        xrVar3 = i7 < this.ab.size() ? this.ab.get(i7) : null;
                    }
                }
            }
            ms(xrVarMs, i4, xrVarXr);
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            ah ahVar = (ah) childAt.getLayoutParams();
            ahVar.c = i9;
            if (!ahVar.f399ms && ahVar.ah == 0.0f && (xrVarMs2 = ms(childAt)) != null) {
                ahVar.ah = xrVarMs2.d;
                ahVar.ka = xrVarMs2.xr;
            }
        }
        ab();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            xr xrVarXr2 = viewFindFocus != null ? xr(viewFindFocus) : null;
            if (xrVarXr2 == null || xrVarXr2.xr != this.d) {
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt2 = getChildAt(i10);
                    xr xrVarMs4 = ms(childAt2);
                    if (xrVarMs4 != null && xrVarMs4.xr == this.d && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    private void ab() {
        if (this.zf != 0) {
            ArrayList<View> arrayList = this.rt;
            if (arrayList == null) {
                this.rt = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.rt.add(getChildAt(i));
            }
            Collections.sort(this.rt, vy);
        }
    }

    private void ms(xr xrVar, int i, xr xrVar2) {
        xr xrVar3;
        xr xrVar4;
        int iMs = this.ah.ms();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.ao / clientWidth : 0.0f;
        if (xrVar2 != null) {
            int i2 = xrVar2.xr;
            if (i2 < xrVar.xr) {
                float fMs = xrVar2.ka + xrVar2.d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= xrVar.xr && i4 < this.ab.size()) {
                    xr xrVar5 = this.ab.get(i4);
                    while (true) {
                        xrVar4 = xrVar5;
                        if (i3 <= xrVar4.xr || i4 >= this.ab.size() - 1) {
                            break;
                        }
                        i4++;
                        xrVar5 = this.ab.get(i4);
                    }
                    while (i3 < xrVar4.xr) {
                        fMs += this.ah.ms(i3) + f;
                        i3++;
                    }
                    xrVar4.ka = fMs;
                    fMs += xrVar4.d + f;
                    i3++;
                }
            } else if (i2 > xrVar.xr) {
                int size = this.ab.size() - 1;
                float fMs2 = xrVar2.ka;
                while (true) {
                    i2--;
                    if (i2 < xrVar.xr || size < 0) {
                        break;
                    }
                    xr xrVar6 = this.ab.get(size);
                    while (true) {
                        xrVar3 = xrVar6;
                        if (i2 >= xrVar3.xr || size <= 0) {
                            break;
                        }
                        size--;
                        xrVar6 = this.ab.get(size);
                    }
                    while (i2 > xrVar3.xr) {
                        fMs2 -= this.ah.ms(i2) + f;
                        i2--;
                    }
                    fMs2 -= xrVar3.d + f;
                    xrVar3.ka = fMs2;
                }
            }
        }
        int size2 = this.ab.size();
        float fMs3 = xrVar.ka;
        int i5 = xrVar.xr - 1;
        this.t = xrVar.xr == 0 ? xrVar.ka : -3.4028235E38f;
        int i6 = iMs - 1;
        this.nw = xrVar.xr == i6 ? (xrVar.ka + xrVar.d) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            xr xrVar7 = this.ab.get(i7);
            while (i5 > xrVar7.xr) {
                fMs3 -= this.ah.ms(i5) + f;
                i5--;
            }
            fMs3 -= xrVar7.d + f;
            xrVar7.ka = fMs3;
            if (xrVar7.xr == 0) {
                this.t = fMs3;
            }
            i7--;
            i5--;
        }
        float fMs4 = xrVar.ka + xrVar.d + f;
        int i8 = xrVar.xr + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            xr xrVar8 = this.ab.get(i9);
            while (i8 < xrVar8.xr) {
                fMs4 += this.ah.ms(i8) + f;
                i8++;
            }
            if (xrVar8.xr == i6) {
                this.nw = (xrVar8.d + fMs4) - 1.0f;
            }
            xrVar8.ka = fMs4;
            fMs4 += xrVar8.d + f;
            i9++;
            i8++;
        }
        this.l = false;
    }

    public static class ab extends com.bytedance.adsdk.ugeno.viewpager.ms {
        public static final Parcelable.Creator<ab> CREATOR = new Parcelable.ClassLoaderCreator<ab>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.ab.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ab createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new ab(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ab createFromParcel(Parcel parcel) {
                return new ab(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ab[] newArray(int i) {
                return new ab[i];
            }
        };
        Parcelable ah;
        ClassLoader d;
        int xr;

        public ab(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.ms, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.xr);
            parcel.writeParcelable(this.ah, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.xr + "}";
        }

        ab(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.xr = parcel.readInt();
            this.ah = parcel.readParcelable(classLoader);
            this.d = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ab abVar = new ab(super.onSaveInstanceState());
        abVar.xr = this.d;
        com.bytedance.adsdk.ugeno.viewpager.xr xrVar = this.ah;
        if (xrVar != null) {
            abVar.ah = xrVar.xr();
        }
        return abVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ab)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ab abVar = (ab) parcelable;
        super.onRestoreInstanceState(abVar.ms());
        if (this.ah != null) {
            ms(abVar.xr, false, true);
            return;
        }
        this.ch = abVar.xr;
        this.hi = abVar.ah;
        this.sl = abVar.d;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        ah ahVar = (ah) layoutParams;
        ahVar.f399ms |= ah(view);
        if (this.i) {
            if (ahVar != null && ahVar.f399ms) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            ahVar.d = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean ah(View view) {
        return view.getClass().getAnnotation(ms.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.i) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    xr ms(View view) {
        for (int i = 0; i < this.ab.size(); i++) {
            xr xrVar = this.ab.get(i);
            if (this.ah.ms(view, xrVar.f401ms)) {
                return xrVar;
            }
        }
        return null;
    }

    xr xr(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return ms(view);
            }
        }
    }

    xr xr(int i) {
        for (int i2 = 0; i2 < this.ab.size(); i2++) {
            xr xrVar = this.ab.get(i2);
            if (xrVar.xr == i) {
                return xrVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.qf = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar;
        ah ahVar2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.of = Math.min(measuredWidth / 10, this.g);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (ahVar2 = (ah) childAt.getLayoutParams()) != null && ahVar2.f399ms) {
                int i8 = ahVar2.xr & 7;
                int i9 = ahVar2.xr & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (ahVar2.width != -2) {
                    i4 = ahVar2.width != -1 ? ahVar2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (ahVar2.height != -2) {
                    i5 = ahVar2.height != -1 ? ahVar2.height : measuredHeight;
                } else {
                    i5 = measuredHeight;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z = false;
        }
        this.b = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.re = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.i = true;
        ah();
        this.i = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((ahVar = (ah) childAt2.getLayoutParams()) == null || !ahVar.f399ms)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * ahVar.ah), 1073741824), this.re);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.ao;
            ms(i, i3, i5, i5);
        }
    }

    private void ms(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.ab.isEmpty()) {
            if (!this.zb.isFinished()) {
                this.zb.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        xr xrVarXr = xr(this.d);
        int iMin = (int) ((xrVarXr != null ? Math.min(xrVarXr.ka, this.nw) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            ms(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0073  */
    /* JADX WARN: Code duplicated, block: B:24:0x0077  */
    /* JADX WARN: Code duplicated, block: B:26:0x007b  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        xr xrVarMs;
        int iMax;
        int measuredWidth;
        int iMax2;
        int measuredHeight;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                ah ahVar = (ah) childAt.getLayoutParams();
                if (ahVar.f399ms) {
                    int i9 = ahVar.xr & 7;
                    int i10 = ahVar.xr & 112;
                    if (i9 == 1) {
                        iMax = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i9 == 3) {
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i9 != 5) {
                            measuredWidth = paddingLeft;
                        } else {
                            iMax = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i10 != 16) {
                            iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i10 != 48) {
                                measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i10 != 80) {
                                measuredHeight = paddingTop;
                            } else {
                                iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i11 = paddingLeft + scrollX;
                            childAt.layout(i11, paddingTop, childAt.getMeasuredWidth() + i11, paddingTop + childAt.getMeasuredHeight());
                            i7++;
                            paddingTop = measuredHeight;
                            paddingLeft = measuredWidth;
                        }
                        int i12 = iMax2;
                        measuredHeight = paddingTop;
                        paddingTop = i12;
                        int i13 = paddingLeft + scrollX;
                        childAt.layout(i13, paddingTop, childAt.getMeasuredWidth() + i13, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    }
                    int i14 = iMax;
                    measuredWidth = paddingLeft;
                    paddingLeft = i14;
                    if (i10 != 16) {
                        iMax2 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else {
                        if (i10 != 48) {
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                        } else if (i10 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            iMax2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        int i15 = paddingLeft + scrollX;
                        childAt.layout(i15, paddingTop, childAt.getMeasuredWidth() + i15, paddingTop + childAt.getMeasuredHeight());
                        i7++;
                        paddingTop = measuredHeight;
                        paddingLeft = measuredWidth;
                    }
                    int i16 = iMax2;
                    measuredHeight = paddingTop;
                    paddingTop = i16;
                    int i17 = paddingLeft + scrollX;
                    childAt.layout(i17, paddingTop, childAt.getMeasuredWidth() + i17, paddingTop + childAt.getMeasuredHeight());
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i18 = (i5 - paddingLeft) - paddingRight;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                ah ahVar2 = (ah) childAt2.getLayoutParams();
                if (!ahVar2.f399ms && (xrVarMs = ms(childAt2)) != null) {
                    float f = i18;
                    int i20 = ((int) (xrVarMs.ka * f)) + paddingLeft;
                    if (ahVar2.d) {
                        ahVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * ahVar2.ah), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i20, paddingTop, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.qv = paddingTop;
        this.y = i6 - paddingBottom;
        this.sa = i7;
        if (this.qf) {
            z2 = false;
            ms(this.d, false, 0, false);
        } else {
            z2 = false;
        }
        this.qf = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.u = true;
        if (!this.zb.isFinished() && this.zb.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.zb.getCurrX();
            int currY = this.zb.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!d(currX)) {
                    this.zb.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        ms(true);
    }

    private boolean d(int i) {
        if (this.ab.size() == 0) {
            if (this.qf) {
                return false;
            }
            this.am = false;
            ms(0, 0.0f, 0);
            if (this.am) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        xr xrVarNy = ny();
        int clientWidth = getClientWidth();
        int i2 = this.ao;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = xrVarNy.xr;
        float f2 = ((i / f) - xrVarNy.ka) / (xrVarNy.d + (i2 / f));
        this.am = false;
        ms(i4, f2, (int) (i3 * f2));
        if (this.am) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    protected void ms(int i, float f, int i2) {
        int iMax;
        int width;
        int left;
        if (this.sa > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ah ahVar = (ah) childAt.getLayoutParams();
                if (ahVar.f399ms) {
                    int i4 = ahVar.xr & 7;
                    if (i4 == 1) {
                        iMax = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i4 == 3) {
                            width = childAt.getWidth() + paddingLeft;
                        } else if (i4 != 5) {
                            width = paddingLeft;
                        } else {
                            iMax = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = width;
                    }
                    int i5 = iMax;
                    width = paddingLeft;
                    paddingLeft = i5;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        xr(i, f, i2);
        if (this.qk != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((ah) childAt2.getLayoutParams()).f399ms) {
                    this.qk.ms(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.am = true;
    }

    private void xr(int i, float f, int i2) {
        d dVar = this.ti;
        if (dVar != null) {
            dVar.ms(i, f, i2);
        }
        List<d> list = this.tz;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                d dVar2 = this.tz.get(i3);
                if (dVar2 != null) {
                    dVar2.ms(i, f, i2);
                }
            }
        }
        d dVar3 = this.s;
        if (dVar3 != null) {
            dVar3.ms(i, f, i2);
        }
    }

    private void ka(int i) {
        d dVar = this.ti;
        if (dVar != null) {
            dVar.x(i);
        }
        List<d> list = this.tz;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar2 = this.tz.get(i2);
                if (dVar2 != null) {
                    dVar2.x(i);
                }
            }
        }
        d dVar3 = this.s;
        if (dVar3 != null) {
            dVar3.x(i);
        }
    }

    private void c(int i) {
        d dVar = this.ti;
        if (dVar != null) {
            dVar.ny(i);
        }
        List<d> list = this.tz;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar2 = this.tz.get(i2);
                if (dVar2 != null) {
                    dVar2.ny(i);
                }
            }
        }
        d dVar3 = this.s;
        if (dVar3 != null) {
            dVar3.ny(i);
        }
    }

    private void ms(boolean z) {
        boolean z2 = this.gy == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.zb.isFinished()) {
                this.zb.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.zb.getCurrX();
                int currY = this.zb.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.yu = false;
        for (int i = 0; i < this.ab.size(); i++) {
            xr xrVar = this.ab.get(i);
            if (xrVar.ah) {
                xrVar.ah = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.sk);
            } else {
                this.sk.run();
            }
        }
    }

    private boolean ms(float f, float f2) {
        if (f >= this.of || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.of)) && f2 < 0.0f;
        }
        return true;
    }

    private void xr(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.vm : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            x();
            return false;
        }
        if (action != 0) {
            if (this.le) {
                return true;
            }
            if (this.cv) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.f = x2;
            this.pc = x2;
            float y = motionEvent.getY();
            this.ul = y;
            this.jw = y;
            this.az = motionEvent.getPointerId(0);
            this.cv = false;
            this.u = true;
            this.zb.computeScrollOffset();
            if (this.gy == 2 && Math.abs(this.zb.getFinalX() - this.zb.getCurrX()) > this.eg) {
                this.zb.abortAnimation();
                this.yu = false;
                ah();
                this.le = true;
                ah(true);
                setScrollState(1);
            } else {
                ms(false);
                this.le = false;
            }
        } else if (action == 2) {
            int i = this.az;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f = x3 - this.pc;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.ul);
                if (f != 0.0f && !ms(this.pc, f) && ms(this, false, (int) f, (int) x3, (int) y2)) {
                    this.pc = x3;
                    this.jw = y2;
                    this.cv = true;
                    return false;
                }
                int i2 = this.p;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.le = true;
                    ah(true);
                    setScrollState(1);
                    this.pc = f > 0.0f ? this.f + this.p : this.f - this.p;
                    this.jw = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.cv = true;
                }
                if (this.le && xr(x3)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            ms(motionEvent);
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        return this.le;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.viewpager.xr xrVar;
        int iFindPointerIndex;
        if (this.fm) {
            return true;
        }
        boolean zX = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (xrVar = this.ah) == null || xrVar.ms() == 0) {
            return false;
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.zb.abortAnimation();
            this.yu = false;
            ah();
            float x2 = motionEvent.getX();
            this.f = x2;
            this.pc = x2;
            float y = motionEvent.getY();
            this.ul = y;
            this.jw = y;
            this.az = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.pc = motionEvent.getX(actionIndex);
                            this.az = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        ms(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.az);
                        if (iFindPointerIndex2 != -1) {
                            this.pc = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.le) {
                    ms(this.d, true, 0, false);
                    zX = x();
                }
            } else if (!this.le) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.az);
                if (iFindPointerIndex3 == -1) {
                    zX = x();
                } else {
                    float x3 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x3 - this.pc);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.jw);
                    if (fAbs > this.p && fAbs > fAbs2) {
                        this.le = true;
                        ah(true);
                        float f = this.f;
                        this.pc = x3 - f > 0.0f ? f + this.p : f - this.p;
                        this.jw = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.le) {
                        zX = false | xr(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.le && (iFindPointerIndex = motionEvent.findPointerIndex(this.az)) != -1) {
                zX = false | xr(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.le) {
            VelocityTracker velocityTracker = this.m;
            velocityTracker.computeCurrentVelocity(1000, this.e);
            int xVelocity = (int) velocityTracker.getXVelocity(this.az);
            this.yu = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            xr xrVarNy = ny();
            float f2 = clientWidth;
            float f3 = this.ao / f2;
            int i = xrVarNy.xr;
            float f4 = ((scrollX / f2) - xrVarNy.ka) / (xrVarNy.d + f3);
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.az);
            if (iFindPointerIndex4 != -1) {
                ms(ms(i, f4, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.f)), true, true, xVelocity);
                zX = x();
            }
        }
        if (zX) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean x() {
        this.az = -1;
        ch();
        this.xn.onRelease();
        this.il.onRelease();
        return this.xn.isFinished() || this.il.isFinished();
    }

    private void ah(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean xr(float f) {
        boolean z;
        boolean z2;
        float f2 = this.pc - f;
        this.pc = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.t * clientWidth;
        float f4 = this.nw * clientWidth;
        boolean z3 = false;
        xr xrVar = this.ab.get(0);
        ArrayList<xr> arrayList = this.ab;
        xr xrVar2 = arrayList.get(arrayList.size() - 1);
        if (xrVar.xr != 0) {
            f3 = xrVar.ka * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (xrVar2.xr != this.ah.ms() - 1) {
            f4 = xrVar2.ka * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.xn.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.il.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.pc += scrollX - i;
        scrollTo(i, getScrollY());
        d(i);
        return z3;
    }

    private xr ny() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.ao / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        xr xrVar = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.ab.size()) {
            xr xrVar2 = this.ab.get(i2);
            if (!z && xrVar2.xr != (i = i3 + 1)) {
                xrVar2 = this.x;
                xrVar2.ka = f + f3 + f2;
                xrVar2.xr = i;
                xrVar2.d = this.ah.ms(xrVar2.xr);
                i2--;
            }
            xr xrVar3 = xrVar2;
            f = xrVar3.ka;
            float f4 = xrVar3.d + f + f2;
            if (!z && scrollX < f) {
                return xrVar;
            }
            if (scrollX < f4 || i2 == this.ab.size() - 1) {
                return xrVar3;
            }
            int i4 = xrVar3.xr;
            float f5 = xrVar3.d;
            i2++;
            z = false;
            i3 = i4;
            f3 = f5;
            xrVar = xrVar3;
        }
        return xrVar;
    }

    private int ms(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.k || Math.abs(i2) <= this.lm) {
            i += (int) (f + (i >= this.d ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.ab.size() <= 0) {
            return i;
        }
        xr xrVar = this.ab.get(0);
        ArrayList<xr> arrayList = this.ab;
        return Math.max(xrVar.xr, Math.min(i, arrayList.get(arrayList.size() - 1).xr));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.xr xrVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (xrVar = this.ah) != null && xrVar.ms() > 1)) {
            if (!this.xn.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.t * width);
                this.xn.setSize(height, width);
                zDraw = false | this.xn.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.il.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.nw + 1.0f)) * width2);
                this.il.setSize(height2, width2);
                zDraw |= this.il.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.xn.finish();
            this.il.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.ao <= 0 || this.h == null || this.ab.size() <= 0 || this.ah == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f3 = width;
        float f4 = this.ao / f3;
        int i = 0;
        xr xrVar = this.ab.get(0);
        float f5 = xrVar.ka;
        int size = this.ab.size();
        int i2 = xrVar.xr;
        int i3 = this.ab.get(size - 1).xr;
        while (i2 < i3) {
            while (i2 > xrVar.xr && i < size) {
                i++;
                xrVar = this.ab.get(i);
            }
            if (i2 == xrVar.xr) {
                f2 = (xrVar.ka + xrVar.d) * f3;
                f = xrVar.ka + xrVar.d + f4;
            } else {
                float fMs = this.ah.ms(i2);
                float f6 = (f5 + fMs) * f3;
                f = f5 + fMs + f4;
                f2 = f6;
            }
            if (this.ao + f2 > scrollX) {
                this.h.setBounds(Math.round(f2), this.qv, Math.round(this.ao + f2), this.y);
                this.h.draw(canvas);
            }
            if (f2 > scrollX + width) {
                return;
            }
            i2++;
            f5 = f;
            f4 = f4;
        }
    }

    private void ms(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.az) {
            int i = actionIndex == 0 ? 1 : 0;
            this.pc = motionEvent.getX(i);
            this.az = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void ch() {
        this.le = false;
        this.cv = false;
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.w != z) {
            this.w = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.ah == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.t));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.nw));
    }

    protected boolean ms(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && ms(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || ms(keyEvent);
    }

    public boolean ms(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return d();
                }
                return ah(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return ka();
                }
                return ah(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return ah(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return ah(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    public boolean ah(int i) {
        boolean z;
        View viewFindFocus = findFocus();
        boolean zD = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                sl.d("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i == 17 || i == 1) {
                zD = d();
            } else if (i == 66 || i == 2) {
                zD = ka();
            }
        } else if (i == 17) {
            int i2 = ms(this.ny, viewFindNextFocus).left;
            int i3 = ms(this.ny, viewFindFocus).left;
            if (viewFindFocus != null && i2 >= i3) {
                zD = d();
            } else {
                zD = viewFindNextFocus.requestFocus();
            }
        } else if (i == 66) {
            int i4 = ms(this.ny, viewFindNextFocus).left;
            int i5 = ms(this.ny, viewFindFocus).left;
            if (viewFindFocus == null || i4 > i5) {
                zD = viewFindNextFocus.requestFocus();
            } else {
                zD = ka();
            }
        }
        if (zD) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zD;
    }

    private Rect ms(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean d() {
        int i = this.d;
        if (i <= 0) {
            return false;
        }
        ms(i - 1, true);
        return true;
    }

    boolean ka() {
        com.bytedance.adsdk.ugeno.viewpager.xr xrVar = this.ah;
        if (xrVar == null || this.d >= xrVar.ms() - 1) {
            return false;
        }
        ms(this.d + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        xr xrVarMs;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (xrVarMs = ms(childAt)) != null && xrVarMs.xr == this.d) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        xr xrVarMs;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (xrVarMs = ms(childAt)) != null && xrVarMs.xr == this.d) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        xr xrVarMs;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (xrVarMs = ms(childAt)) != null && xrVarMs.xr == this.d && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        xr xrVarMs;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (xrVarMs = ms(childAt)) != null && xrVarMs.xr == this.d && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ah();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ah) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ah(getContext(), attributeSet);
    }

    private class c extends DataSetObserver {
        c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.xr();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.xr();
        }
    }

    public static class ah extends ViewGroup.LayoutParams {
        float ah;
        int c;
        boolean d;
        int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public boolean f399ms;
        public int xr;

        public ah() {
            super(-1, -1);
            this.ah = 0.0f;
        }

        public ah(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.ah = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.xr);
            this.xr = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class x implements Comparator<View> {
        x() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            ah ahVar = (ah) view.getLayoutParams();
            ah ahVar2 = (ah) view2.getLayoutParams();
            if (ahVar.f399ms != ahVar2.f399ms) {
                return ahVar.f399ms ? 1 : -1;
            }
            return ahVar.ka - ahVar2.ka;
        }
    }
}
