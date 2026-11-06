package com.byazt.ln;

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
import androidx.core.view.PointerIconCompat;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.C;
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
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 1842})
public class ViewPager extends ViewGroup {
    public float a;
    public float ae;
    public float an;
    public boolean b;
    public boolean bb;
    public int cd;
    public ArrayList<View> ci;
    public Parcelable cp;
    public l cx;
    public int cy;
    public ClassLoader d;
    public VelocityTracker df;
    public int dg;
    public boolean dh;
    public q e;
    public float f;
    public int fi;
    public final qg fs;
    public boolean h;
    public Drawable hd;
    public boolean hu;
    public int ic;
    public float j;
    public w k;
    public final Runnable kc;
    public int lh;
    public int ln;
    public int lq;
    public boolean m;
    public int n;
    public List<q> nf;
    public Scroller oa;
    public int oj;
    public int ou;
    public q pe;
    public int pk;
    public float py;
    public int q;
    public boolean rf;
    public int ri;
    public final Rect rv;
    public com.byazt.ln.qg s;
    public EdgeEffect sh;
    public boolean sz;
    public int t;
    public int tj;
    public int u;
    public int um;
    public boolean ur;
    public int v;
    public int wm;
    public boolean wo;
    public final ArrayList<qg> x;
    public EdgeEffect y;
    public List<Object> yw;
    public int z;
    public static final int[] qg = {R.attr.layout_gravity};
    public static final Comparator<qg> l = new Comparator<qg>() { // from class: com.byazt.ln.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(qg qgVar, qg qgVar2) {
            return qgVar.qg - qgVar2.qg;
        }
    };
    public static final Interpolator w = new Interpolator() { // from class: com.byazt.ln.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final fs hf = new fs();

    public interface l {
        void n(View view, float f);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface n {
    }

    public interface q {
        void d(int i);

        void n(int i, float f, int i2);

        void oa(int i);
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 1434})
    static class qg {
        public float l;
        public Object n;
        public float q;
        public int qg;
        public boolean s;
    }

    public ViewPager(Context context) {
        super(context);
        this.x = new ArrayList<>();
        this.fs = new qg();
        this.rv = new Rect();
        this.tj = -1;
        this.cp = null;
        this.d = null;
        this.a = -3.4028235E38f;
        this.py = Float.MAX_VALUE;
        this.t = 1;
        this.fi = -1;
        this.rf = true;
        this.dh = false;
        this.kc = new Runnable() { // from class: com.byazt.ln.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.s();
            }
        };
        this.z = 0;
        n();
    }

    public void n() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.oa = new Scroller(context, w);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.v = viewConfiguration.getScaledPagingTouchSlop();
        this.oj = (int) (400.0f * f);
        this.dg = viewConfiguration.getScaledMaximumFlingVelocity();
        this.sh = new EdgeEffect(context);
        this.y = new EdgeEffect(context);
        this.u = (int) (25.0f * f);
        this.pk = (int) (2.0f * f);
        this.ln = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.oa = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.kc);
        Scroller scroller = this.oa;
        if (scroller != null && !scroller.isFinished()) {
            this.oa.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void setScrollState(int i) {
        if (this.z == i) {
            return;
        }
        this.z = i;
        if (this.cx != null) {
            qg(i != 0);
        }
        w(i);
    }

    public void setAdapter(com.byazt.ln.qg qgVar) {
        com.byazt.ln.qg qgVar2 = this.s;
        if (qgVar2 != null) {
            qgVar2.n((DataSetObserver) null);
            for (int i = 0; i < this.x.size(); i++) {
                qg qgVar3 = this.x.get(i);
                this.s.n((ViewGroup) this, qgVar3.qg, qgVar3.n);
            }
            this.x.clear();
            w();
            this.q = 0;
            scrollTo(0, 0);
        }
        this.s = qgVar;
        this.n = 0;
        if (qgVar != null) {
            if (this.k == null) {
                this.k = new w();
            }
            this.s.n((DataSetObserver) this.k);
            this.h = false;
            boolean z = this.rf;
            this.rf = true;
            this.n = this.s.n();
            int i2 = this.tj;
            if (i2 >= 0) {
                n(i2, false, true);
                this.tj = -1;
                this.cp = null;
                this.d = null;
            } else if (!z) {
                s();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.yw;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.yw.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.yw.get(i3);
        }
    }

    private void w() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((s) getChildAt(i).getLayoutParams()).n) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.byazt.ln.qg getAdapter() {
        return this.s;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.h = false;
        n(i, !this.rf, false);
    }

    public void n(int i, boolean z) {
        this.h = false;
        n(i, z, false);
    }

    public int getCurrentItem() {
        return this.q;
    }

    public void n(int i, boolean z, boolean z2) {
        n(i, z, z2, 0);
    }

    public void n(int i, boolean z, boolean z2, int i2) {
        com.byazt.ln.qg qgVar = this.s;
        if (qgVar == null || qgVar.n() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.q == i && this.x.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.s.n()) {
            i = this.s.n() - 1;
        }
        int i3 = this.t;
        int i4 = this.q;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.x.size(); i5++) {
                this.x.get(i5).s = true;
            }
        }
        boolean z3 = this.q != i;
        if (this.rf) {
            this.q = i;
            if (z3) {
                l(i);
            }
            requestLayout();
            return;
        }
        n(i);
        n(i, z, i2, z3);
    }

    private void n(int i, boolean z, int i2, boolean z2) {
        qg qgVarQg = qg(i);
        int clientWidth = qgVarQg != null ? (int) (getClientWidth() * Math.max(this.a, Math.min(qgVarQg.l, this.py))) : 0;
        if (z) {
            n(clientWidth, 0, i2);
            if (z2) {
                l(i);
                return;
            }
            return;
        }
        if (z2) {
            l(i);
        }
        n(false);
        scrollTo(clientWidth, 0);
        q(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(q qVar) {
        this.pe = qVar;
    }

    public void n(q qVar) {
        if (this.nf == null) {
            this.nf = new ArrayList();
        }
        this.nf.add(qVar);
    }

    public void n(boolean z, l lVar) {
        n(z, lVar, 2);
    }

    public void n(boolean z, l lVar, int i) {
        boolean z2 = lVar != null;
        boolean z3 = z2 != (this.cx != null);
        this.cx = lVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.ic = z ? 2 : 1;
            this.lq = i;
        } else {
            this.ic = 0;
        }
        if (z3) {
            s();
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.ic == 2) {
            i2 = (i - 1) - i2;
        }
        return ((s) this.ci.get(i2).getLayoutParams()).w;
    }

    public int getOffscreenPageLimit() {
        return this.t;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (i != this.t) {
            this.t = i;
            s();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.cy;
        this.cy = i;
        int width = getWidth();
        n(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.cy;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.hd = drawable;
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
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.hd;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.hd;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public float n(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public void n(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.oa;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.sz ? this.oa.getCurrX() : this.oa.getStartX();
            this.oa.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            n(false);
            s();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fN = f2 + (n(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fN / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.s.n(this.q)) + this.cy)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.sz = false;
        this.oa.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    public qg n(int i, int i2) {
        qg qgVar = new qg();
        qgVar.qg = i;
        qgVar.n = this.s.n((ViewGroup) this, i);
        qgVar.q = this.s.n(i);
        if (i2 < 0 || i2 >= this.x.size()) {
            this.x.add(qgVar);
        } else {
            this.x.add(i2, qgVar);
        }
        return qgVar;
    }

    public void qg() {
        int iN = this.s.n();
        this.n = iN;
        boolean z = this.x.size() < (this.t * 2) + 1 && this.x.size() < iN;
        int iMax = this.q;
        int i = 0;
        while (i < this.x.size()) {
            qg qgVar = this.x.get(i);
            int iN2 = this.s.n(qgVar.n);
            if (iN2 != -1) {
                if (iN2 == -2) {
                    this.x.remove(i);
                    i--;
                    this.s.n((ViewGroup) this, qgVar.qg, qgVar.n);
                    if (this.q == qgVar.qg) {
                        iMax = Math.max(0, Math.min(this.q, iN - 1));
                    }
                } else if (qgVar.qg != iN2) {
                    if (qgVar.qg == this.q) {
                        iMax = iN2;
                    }
                    qgVar.qg = iN2;
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.x, l);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                s sVar = (s) getChildAt(i2).getLayoutParams();
                if (!sVar.n) {
                    sVar.s = 0.0f;
                }
            }
            n(iMax, false, true);
            requestLayout();
        }
    }

    public void s() {
        n(this.q);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00f5 A[PHI: r7 r10 r15
      0x00f5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
      0x00f5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    public void n(int i) {
        qg qgVarQg;
        String hexString;
        qg qgVarN;
        qg qgVarN2;
        qg qgVar;
        int i2 = this.q;
        if (i2 != i) {
            qgVarQg = qg(i2);
            this.q = i;
        } else {
            qgVarQg = null;
        }
        if (this.s == null) {
            x();
            return;
        }
        if (this.h) {
            x();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.t;
        int iMax = Math.max(0, this.q - i3);
        int iN = this.s.n();
        int iMin = Math.min(iN - 1, this.q + i3);
        if (iN != this.n) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.n + ", found: " + iN + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.s.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.x.size()) {
                qgVarN = this.x.get(i4);
                if (qgVarN.qg >= this.q) {
                    if (qgVarN.qg != this.q) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            qgVarN = null;
            break;
        }
        if (qgVarN == null && iN > 0) {
            qgVarN = n(this.q, i4);
        }
        if (qgVarN != null) {
            int i5 = i4 - 1;
            qg qgVar2 = i5 >= 0 ? this.x.get(i5) : null;
            int clientWidth = getClientWidth();
            float paddingLeft = clientWidth <= 0 ? 0.0f : (2.0f - qgVarN.q) + (getPaddingLeft() / clientWidth);
            float f = 0.0f;
            for (int i6 = this.q - 1; i6 >= 0; i6--) {
                if (f >= paddingLeft && i6 < iMax) {
                    if (qgVar2 == null) {
                        break;
                    }
                    if (i6 == qgVar2.qg && !qgVar2.s) {
                        this.x.remove(i5);
                        this.s.n((ViewGroup) this, i6, qgVar2.n);
                        i5--;
                        i4--;
                        if (i5 >= 0) {
                            qgVar = this.x.get(i5);
                        } else {
                            qgVar = null;
                        }
                        qgVar2 = qgVar;
                    }
                } else {
                    if (qgVar2 != null && i6 == qgVar2.qg) {
                        f += qgVar2.q;
                        i5--;
                        if (i5 >= 0) {
                            qgVar = this.x.get(i5);
                        } else {
                            qgVar = null;
                        }
                    } else {
                        f += n(i6, i5 + 1).q;
                        i4++;
                        if (i5 >= 0) {
                            qgVar = this.x.get(i5);
                        } else {
                            qgVar = null;
                        }
                    }
                    qgVar2 = qgVar;
                }
            }
            float f2 = qgVarN.q;
            int i7 = i4 + 1;
            if (f2 < 2.0f) {
                qg qgVar3 = i7 < this.x.size() ? this.x.get(i7) : null;
                float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                int i8 = this.q;
                while (true) {
                    i8++;
                    if (i8 >= iN) {
                        break;
                    }
                    if (f2 >= paddingRight && i8 > iMin) {
                        if (qgVar3 == null) {
                            break;
                        }
                        if (i8 == qgVar3.qg && !qgVar3.s) {
                            this.x.remove(i7);
                            this.s.n((ViewGroup) this, i8, qgVar3.n);
                            if (i7 < this.x.size()) {
                                qgVar3 = this.x.get(i7);
                            }
                        }
                    } else if (qgVar3 != null && i8 == qgVar3.qg) {
                        f2 += qgVar3.q;
                        i7++;
                        if (i7 < this.x.size()) {
                            qgVar3 = this.x.get(i7);
                        }
                    } else {
                        qg qgVarN3 = n(i8, i7);
                        i7++;
                        f2 += qgVarN3.q;
                        qgVar3 = i7 < this.x.size() ? this.x.get(i7) : null;
                    }
                }
            }
            n(qgVarN, i4, qgVarQg);
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            s sVar = (s) childAt.getLayoutParams();
            sVar.w = i9;
            if (!sVar.n && sVar.s == 0.0f && (qgVarN2 = n(childAt)) != null) {
                sVar.s = qgVarN2.q;
                sVar.l = qgVarN2.qg;
            }
        }
        x();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            qg qgVarQg2 = viewFindFocus != null ? qg(viewFindFocus) : null;
            if (qgVarQg2 == null || qgVarQg2.qg != this.q) {
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt2 = getChildAt(i10);
                    qg qgVarN4 = n(childAt2);
                    if (qgVarN4 != null && qgVarN4.qg == this.q && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    private void x() {
        if (this.ic != 0) {
            ArrayList<View> arrayList = this.ci;
            if (arrayList == null) {
                this.ci = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ci.add(getChildAt(i));
            }
            Collections.sort(this.ci, hf);
        }
    }

    private void n(qg qgVar, int i, qg qgVar2) {
        qg qgVar3;
        qg qgVar4;
        int iN = this.s.n();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.cy / clientWidth : 0.0f;
        if (qgVar2 != null) {
            int i2 = qgVar2.qg;
            if (i2 < qgVar.qg) {
                float fN = qgVar2.l + qgVar2.q + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= qgVar.qg && i4 < this.x.size()) {
                    qg qgVar5 = this.x.get(i4);
                    while (true) {
                        qgVar4 = qgVar5;
                        if (i3 <= qgVar4.qg || i4 >= this.x.size() - 1) {
                            break;
                        }
                        i4++;
                        qgVar5 = this.x.get(i4);
                    }
                    while (i3 < qgVar4.qg) {
                        fN += this.s.n(i3) + f;
                        i3++;
                    }
                    qgVar4.l = fN;
                    fN += qgVar4.q + f;
                    i3++;
                }
            } else if (i2 > qgVar.qg) {
                int size = this.x.size() - 1;
                float fN2 = qgVar2.l;
                while (true) {
                    i2--;
                    if (i2 < qgVar.qg || size < 0) {
                        break;
                    }
                    qg qgVar6 = this.x.get(size);
                    while (true) {
                        qgVar3 = qgVar6;
                        if (i2 >= qgVar3.qg || size <= 0) {
                            break;
                        }
                        size--;
                        qgVar6 = this.x.get(size);
                    }
                    while (i2 > qgVar3.qg) {
                        fN2 -= this.s.n(i2) + f;
                        i2--;
                    }
                    fN2 -= qgVar3.q + f;
                    qgVar3.l = fN2;
                }
            }
        }
        int size2 = this.x.size();
        float fN3 = qgVar.l;
        int i5 = qgVar.qg - 1;
        this.a = qgVar.qg == 0 ? qgVar.l : -3.4028235E38f;
        int i6 = iN - 1;
        this.py = qgVar.qg == i6 ? (qgVar.l + qgVar.q) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            qg qgVar7 = this.x.get(i7);
            while (i5 > qgVar7.qg) {
                fN3 -= this.s.n(i5) + f;
                i5--;
            }
            fN3 -= qgVar7.q + f;
            qgVar7.l = fN3;
            if (qgVar7.qg == 0) {
                this.a = fN3;
            }
            i7--;
            i5--;
        }
        float fN4 = qgVar.l + qgVar.q + f;
        int i8 = qgVar.qg + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            qg qgVar8 = this.x.get(i9);
            while (i8 < qgVar8.qg) {
                fN4 += this.s.n(i8) + f;
                i8++;
            }
            if (qgVar8.qg == i6) {
                this.py = (qgVar8.q + fN4) - 1.0f;
            }
            qgVar8.l = fN4;
            fN4 += qgVar8.q + f;
            i9++;
            i8++;
        }
        this.dh = false;
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 1362})
    public static class x extends com.byazt.ln.n {
        public static final Parcelable.Creator<x> CREATOR = new Parcelable.ClassLoaderCreator<x>() { // from class: com.byazt.ln.ViewPager.x.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i) {
                return new x[i];
            }
        };
        public ClassLoader q;
        public int qg;
        public Parcelable s;

        public x(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.byazt.ln.n, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.qg);
            parcel.writeParcelable(this.s, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.qg + "}";
        }

        public x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.qg = parcel.readInt();
            this.s = parcel.readParcelable(classLoader);
            this.q = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        xVar.qg = this.q;
        com.byazt.ln.qg qgVar = this.s;
        if (qgVar != null) {
            xVar.s = qgVar.qg();
        }
        return xVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        super.onRestoreInstanceState(xVar.n());
        if (this.s != null) {
            n(xVar.qg, false, true);
            return;
        }
        this.tj = xVar.qg;
        this.cp = xVar.s;
        this.d = xVar.q;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        s sVar = (s) layoutParams;
        sVar.n |= s(view);
        if (this.m) {
            if (sVar != null && sVar.n) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            sVar.q = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean s(View view) {
        return view.getClass().getAnnotation(n.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.m) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public qg n(View view) {
        for (int i = 0; i < this.x.size(); i++) {
            qg qgVar = this.x.get(i);
            if (this.s.n(view, qgVar.n)) {
                return qgVar;
            }
        }
        return null;
    }

    public qg qg(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return n(view);
            }
        }
    }

    public qg qg(int i) {
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            qg qgVar = this.x.get(i2);
            if (qgVar.qg == i) {
                return qgVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.rf = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        s sVar;
        s sVar2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.lh = Math.min(measuredWidth / 10, this.ln);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = C.ENCODING_PCM_32BIT;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (sVar2 = (s) childAt.getLayoutParams()) != null && sVar2.n) {
                int i8 = sVar2.qg & 7;
                int i9 = sVar2.qg & 112;
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
                if (sVar2.width != -2) {
                    i4 = sVar2.width != -1 ? sVar2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (sVar2.height != -2) {
                    i5 = sVar2.height != -1 ? sVar2.height : measuredHeight;
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
        this.ou = View.MeasureSpec.makeMeasureSpec(paddingLeft, C.ENCODING_PCM_32BIT);
        this.wm = View.MeasureSpec.makeMeasureSpec(measuredHeight, C.ENCODING_PCM_32BIT);
        this.m = true;
        s();
        this.m = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((sVar = (s) childAt2.getLayoutParams()) == null || !sVar.n)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * sVar.s), C.ENCODING_PCM_32BIT), this.wm);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.cy;
            n(i, i3, i5, i5);
        }
    }

    private void n(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.x.isEmpty()) {
            if (!this.oa.isFinished()) {
                this.oa.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        qg qgVarQg = qg(this.q);
        int iMin = (int) ((qgVarQg != null ? Math.min(qgVarQg.l, this.py) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            n(false);
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        qg qgVarN;
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
                s sVar = (s) childAt.getLayoutParams();
                if (sVar.n) {
                    int i9 = sVar.qg & 7;
                    int i10 = sVar.qg & 112;
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
                s sVar2 = (s) childAt2.getLayoutParams();
                if (!sVar2.n && (qgVarN = n(childAt2)) != null) {
                    float f = i18;
                    int i20 = ((int) (qgVarN.l * f)) + paddingLeft;
                    if (sVar2.q) {
                        sVar2.q = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * sVar2.s), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, C.ENCODING_PCM_32BIT));
                    }
                    childAt2.layout(i20, paddingTop, childAt2.getMeasuredWidth() + i20, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.cd = paddingTop;
        this.um = i6 - paddingBottom;
        this.ri = i7;
        if (this.rf) {
            z2 = false;
            n(this.q, false, 0, false);
        } else {
            z2 = false;
        }
        this.rf = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.sz = true;
        if (!this.oa.isFinished() && this.oa.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.oa.getCurrX();
            int currY = this.oa.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!q(currX)) {
                    this.oa.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        n(true);
    }

    private boolean q(int i) {
        if (this.x.size() == 0) {
            if (this.rf) {
                return false;
            }
            this.b = false;
            n(0, 0.0f, 0);
            if (this.b) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        qg qgVarRv = rv();
        int clientWidth = getClientWidth();
        int i2 = this.cy;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = qgVarRv.qg;
        float f2 = ((i / f) - qgVarRv.l) / (qgVarRv.q + (i2 / f));
        this.b = false;
        n(i4, f2, (int) (i3 * f2));
        if (this.b) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    public void n(int i, float f, int i2) {
        int iMax;
        int width;
        int left;
        if (this.ri > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                s sVar = (s) childAt.getLayoutParams();
                if (sVar.n) {
                    int i4 = sVar.qg & 7;
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
        qg(i, f, i2);
        if (this.cx != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i6 = 0; i6 < childCount2; i6++) {
                View childAt2 = getChildAt(i6);
                if (!((s) childAt2.getLayoutParams()).n) {
                    this.cx.n(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.b = true;
    }

    private void qg(int i, float f, int i2) {
        q qVar = this.pe;
        if (qVar != null) {
            qVar.n(i, f, i2);
        }
        List<q> list = this.nf;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                q qVar2 = this.nf.get(i3);
                if (qVar2 != null) {
                    qVar2.n(i, f, i2);
                }
            }
        }
        q qVar3 = this.e;
        if (qVar3 != null) {
            qVar3.n(i, f, i2);
        }
    }

    private void l(int i) {
        q qVar = this.pe;
        if (qVar != null) {
            qVar.d(i);
        }
        List<q> list = this.nf;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                q qVar2 = this.nf.get(i2);
                if (qVar2 != null) {
                    qVar2.d(i);
                }
            }
        }
        q qVar3 = this.e;
        if (qVar3 != null) {
            qVar3.d(i);
        }
    }

    private void w(int i) {
        q qVar = this.pe;
        if (qVar != null) {
            qVar.oa(i);
        }
        List<q> list = this.nf;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                q qVar2 = this.nf.get(i2);
                if (qVar2 != null) {
                    qVar2.oa(i);
                }
            }
        }
        q qVar3 = this.e;
        if (qVar3 != null) {
            qVar3.oa(i);
        }
    }

    private void n(boolean z) {
        boolean z2 = this.z == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.oa.isFinished()) {
                this.oa.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.oa.getCurrX();
                int currY = this.oa.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        q(currX);
                    }
                }
            }
        }
        this.h = false;
        for (int i = 0; i < this.x.size(); i++) {
            qg qgVar = this.x.get(i);
            if (qgVar.s) {
                qgVar.s = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.kc);
            } else {
                this.kc.run();
            }
        }
    }

    private boolean n(float f, float f2) {
        if (f >= this.lh || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.lh)) && f2 < 0.0f;
        }
        return true;
    }

    private void qg(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.lq : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            fs();
            return false;
        }
        if (action != 0) {
            if (this.ur) {
                return true;
            }
            if (this.bb) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.ae = x2;
            this.j = x2;
            float y = motionEvent.getY();
            this.f = y;
            this.an = y;
            this.fi = motionEvent.getPointerId(0);
            this.bb = false;
            this.sz = true;
            this.oa.computeScrollOffset();
            if (this.z == 2 && Math.abs(this.oa.getFinalX() - this.oa.getCurrX()) > this.pk) {
                this.oa.abortAnimation();
                this.h = false;
                s();
                this.ur = true;
                s(true);
                setScrollState(1);
            } else {
                n(false);
                this.ur = false;
            }
        } else if (action == 2) {
            int i = this.fi;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x3 = motionEvent.getX(iFindPointerIndex);
                float f = x3 - this.j;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.f);
                if (f != 0.0f && !n(this.j, f) && n(this, false, (int) f, (int) x3, (int) y2)) {
                    this.j = x3;
                    this.an = y2;
                    this.bb = true;
                    return false;
                }
                int i2 = this.v;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.ur = true;
                    s(true);
                    setScrollState(1);
                    this.j = f > 0.0f ? this.ae + this.v : this.ae - this.v;
                    this.an = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.bb = true;
                }
                if (this.ur && qg(x3)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            n(motionEvent);
        }
        if (this.df == null) {
            this.df = VelocityTracker.obtain();
        }
        this.df.addMovement(motionEvent);
        return this.ur;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.byazt.ln.qg qgVar;
        int iFindPointerIndex;
        if (this.wo) {
            return true;
        }
        boolean zFs = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (qgVar = this.s) == null || qgVar.n() == 0) {
            return false;
        }
        if (this.df == null) {
            this.df = VelocityTracker.obtain();
        }
        this.df.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.oa.abortAnimation();
            this.h = false;
            s();
            float x2 = motionEvent.getX();
            this.ae = x2;
            this.j = x2;
            float y = motionEvent.getY();
            this.f = y;
            this.an = y;
            this.fi = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.j = motionEvent.getX(actionIndex);
                            this.fi = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        n(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.fi);
                        if (iFindPointerIndex2 != -1) {
                            this.j = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.ur) {
                    n(this.q, true, 0, false);
                    zFs = fs();
                }
            } else if (!this.ur) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.fi);
                if (iFindPointerIndex3 == -1) {
                    zFs = fs();
                } else {
                    float x3 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x3 - this.j);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.an);
                    if (fAbs > this.v && fAbs > fAbs2) {
                        this.ur = true;
                        s(true);
                        float f = this.ae;
                        this.j = x3 - f > 0.0f ? f + this.v : f - this.v;
                        this.an = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.ur) {
                        zFs = false | qg(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.ur && (iFindPointerIndex = motionEvent.findPointerIndex(this.fi)) != -1) {
                zFs = false | qg(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.ur) {
            VelocityTracker velocityTracker = this.df;
            velocityTracker.computeCurrentVelocity(1000, this.dg);
            int xVelocity = (int) velocityTracker.getXVelocity(this.fi);
            this.h = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            qg qgVarRv = rv();
            float f2 = clientWidth;
            float f3 = this.cy / f2;
            int i = qgVarRv.qg;
            float f4 = ((scrollX / f2) - qgVarRv.l) / (qgVarRv.q + f3);
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.fi);
            if (iFindPointerIndex4 != -1) {
                n(n(i, f4, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.ae)), true, true, xVelocity);
                zFs = fs();
            }
        }
        if (zFs) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean fs() {
        this.fi = -1;
        tj();
        this.sh.onRelease();
        this.y.onRelease();
        return this.sh.isFinished() || this.y.isFinished();
    }

    private void s(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean qg(float f) {
        boolean z;
        boolean z2;
        float f2 = this.j - f;
        this.j = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.a * clientWidth;
        float f4 = this.py * clientWidth;
        boolean z3 = false;
        qg qgVar = this.x.get(0);
        ArrayList<qg> arrayList = this.x;
        qg qgVar2 = arrayList.get(arrayList.size() - 1);
        if (qgVar.qg != 0) {
            f3 = qgVar.l * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (qgVar2.qg != this.s.n() - 1) {
            f4 = qgVar2.l * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.sh.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.y.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.j += scrollX - i;
        scrollTo(i, getScrollY());
        q(i);
        return z3;
    }

    private qg rv() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.cy / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        qg qgVar = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.x.size()) {
            qg qgVar2 = this.x.get(i2);
            if (!z && qgVar2.qg != (i = i3 + 1)) {
                qgVar2 = this.fs;
                qgVar2.l = f + f3 + f2;
                qgVar2.qg = i;
                qgVar2.q = this.s.n(qgVar2.qg);
                i2--;
            }
            qg qgVar3 = qgVar2;
            f = qgVar3.l;
            float f4 = qgVar3.q + f + f2;
            if (!z && scrollX < f) {
                return qgVar;
            }
            if (scrollX < f4 || i2 == this.x.size() - 1) {
                return qgVar3;
            }
            int i4 = qgVar3.qg;
            float f5 = qgVar3.q;
            i2++;
            z = false;
            i3 = i4;
            f3 = f5;
            qgVar = qgVar3;
        }
        return qgVar;
    }

    private int n(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.u || Math.abs(i2) <= this.oj) {
            i += (int) (f + (i >= this.q ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.x.size() <= 0) {
            return i;
        }
        qg qgVar = this.x.get(0);
        ArrayList<qg> arrayList = this.x;
        return Math.max(qgVar.qg, Math.min(i, arrayList.get(arrayList.size() - 1).qg));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.byazt.ln.qg qgVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (qgVar = this.s) != null && qgVar.n() > 1)) {
            if (!this.sh.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.a * width);
                this.sh.setSize(height, width);
                zDraw = false | this.sh.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.y.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.py + 1.0f)) * width2);
                this.y.setSize(height2, width2);
                zDraw |= this.y.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.sh.finish();
            this.y.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        if (this.cy <= 0 || this.hd == null || this.x.size() <= 0 || this.s == null) {
            return;
        }
        int scrollX = getScrollX();
        int width = getWidth();
        float f3 = width;
        float f4 = this.cy / f3;
        int i = 0;
        qg qgVar = this.x.get(0);
        float f5 = qgVar.l;
        int size = this.x.size();
        int i2 = qgVar.qg;
        int i3 = this.x.get(size - 1).qg;
        while (i2 < i3) {
            while (i2 > qgVar.qg && i < size) {
                i++;
                qgVar = this.x.get(i);
            }
            if (i2 == qgVar.qg) {
                f2 = (qgVar.l + qgVar.q) * f3;
                f = qgVar.l + qgVar.q + f4;
            } else {
                float fN = this.s.n(i2);
                float f6 = (f5 + fN) * f3;
                f = f5 + fN + f4;
                f2 = f6;
            }
            if (this.cy + f2 > scrollX) {
                this.hd.setBounds(Math.round(f2), this.cd, Math.round(this.cy + f2), this.um);
                this.hd.draw(canvas);
            }
            if (f2 > scrollX + width) {
                return;
            }
            i2++;
            f5 = f;
            f4 = f4;
        }
    }

    private void n(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.fi) {
            int i = actionIndex == 0 ? 1 : 0;
            this.j = motionEvent.getX(i);
            this.fi = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.df;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void tj() {
        this.ur = false;
        this.bb = false;
        VelocityTracker velocityTracker = this.df;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.df = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.hu != z) {
            this.hu = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.s == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.a));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.py));
    }

    public boolean n(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && n(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || n(keyEvent);
    }

    public boolean n(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return q();
                }
                return s(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return l();
                }
                return s(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return s(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return s(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    public boolean s(int i) {
        boolean z;
        View viewFindFocus = findFocus();
        boolean zQ = false;
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
                k.qg("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i == 17 || i == 1) {
                zQ = q();
            } else if (i == 66 || i == 2) {
                zQ = l();
            }
        } else if (i == 17) {
            int i2 = n(this.rv, viewFindNextFocus).left;
            int i3 = n(this.rv, viewFindFocus).left;
            if (viewFindFocus != null && i2 >= i3) {
                zQ = q();
            } else {
                zQ = viewFindNextFocus.requestFocus();
            }
        } else if (i == 66) {
            int i4 = n(this.rv, viewFindNextFocus).left;
            int i5 = n(this.rv, viewFindFocus).left;
            if (viewFindFocus == null || i4 > i5) {
                zQ = viewFindNextFocus.requestFocus();
            } else {
                zQ = l();
            }
        }
        if (zQ) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zQ;
    }

    private Rect n(Rect rect, View view) {
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

    public boolean q() {
        int i = this.q;
        if (i <= 0) {
            return false;
        }
        n(i - 1, true);
        return true;
    }

    public boolean l() {
        com.byazt.ln.qg qgVar = this.s;
        if (qgVar == null || this.q >= qgVar.n() - 1) {
            return false;
        }
        n(this.q + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        qg qgVarN;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (qgVarN = n(childAt)) != null && qgVarN.qg == this.q) {
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
        qg qgVarN;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (qgVarN = n(childAt)) != null && qgVarN.qg == this.q) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        qg qgVarN;
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
            if (childAt.getVisibility() == 0 && (qgVarN = n(childAt)) != null && qgVarN.qg == this.q && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        qg qgVarN;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (qgVarN = n(childAt)) != null && qgVarN.qg == this.q && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new s();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof s) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new s(getContext(), attributeSet);
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 1360})
    private class w extends DataSetObserver {
        public w() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.qg();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.qg();
        }
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 1358})
    public static class s extends ViewGroup.LayoutParams {
        public int l;
        public boolean n;
        public boolean q;
        public int qg;
        public float s;
        public int w;

        public s() {
            super(-1, -1);
            this.s = 0.0f;
        }

        public s(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.s = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.qg);
            this.qg = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 1591})
    static class fs implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            s sVar = (s) view.getLayoutParams();
            s sVar2 = (s) view2.getLayoutParams();
            if (sVar.n != sVar2.n) {
                return sVar.n ? 1 : -1;
            }
            return sVar.l - sVar2.l;
        }
    }
}
