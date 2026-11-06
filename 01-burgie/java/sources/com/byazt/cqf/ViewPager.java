package com.byazt.cqf;

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
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 1682})
public class ViewPager extends ViewGroup {
    public float a;
    public final Rect aj;
    public boolean b;
    public List<x> bm;
    public float cz;
    public final Runnable d;
    public float e;
    public int er;
    public int f;
    public int fo;
    public final ArrayList<hw> fw;
    public boolean g;
    public boolean gz;
    public com.byazt.cqf.hw hn;
    public uc ho;
    public EdgeEffect hs;
    public boolean i;
    public boolean ie;
    public int ii;
    public int iu;
    public x jn;
    public ClassLoader k;
    public x l;
    public int lb;
    public float ls;
    public List<Object> lv;
    public Scroller m;
    public int mw;
    public float n;
    public int nl;
    public int nt;
    public boolean nw;
    public int ny;
    public boolean o;
    public c od;
    public int of;
    public int pq;
    public int pr;
    public int qa;
    public int qi;
    public int qn;
    public EdgeEffect r;
    public boolean rc;
    public float s;
    public ArrayList<View> sv;
    public VelocityTracker v;
    public boolean ve;
    public int vj;
    public int vk;
    public Parcelable w;
    public int ww;
    public int x;
    public int y;
    public Drawable yb;
    public boolean z;
    public final hw zo;
    public static final int[] hw = {R.attr.layout_gravity};
    public static final Comparator<hw> c = new Comparator<hw>() { // from class: com.byazt.cqf.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(hw hwVar, hw hwVar2) {
            return hwVar.hw - hwVar2.hw;
        }
    };
    public static final Interpolator uc = new Interpolator() { // from class: com.byazt.cqf.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    public static final zo gu = new zo();

    public interface c {
        void pr(View view, float f);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 1428})
    static class hw {
        public float c;
        public boolean hn;
        public int hw;
        public Object pr;
        public float x;
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface pr {
    }

    public interface x {
        void k(int i);

        void m(int i);

        void pr(int i, float f, int i2);
    }

    public ViewPager(Context context) {
        super(context);
        this.fw = new ArrayList<>();
        this.zo = new hw();
        this.aj = new Rect();
        this.vk = -1;
        this.w = null;
        this.k = null;
        this.a = -3.4028235E38f;
        this.cz = Float.MAX_VALUE;
        this.iu = 1;
        this.er = -1;
        this.nw = true;
        this.ie = false;
        this.d = new Runnable() { // from class: com.byazt.cqf.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.hn();
            }
        };
        this.pq = 0;
        pr();
    }

    public void pr() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, uc);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.ww = viewConfiguration.getScaledPagingTouchSlop();
        this.qi = (int) (400.0f * f);
        this.qn = viewConfiguration.getScaledMaximumFlingVelocity();
        this.r = new EdgeEffect(context);
        this.hs = new EdgeEffect(context);
        this.of = (int) (25.0f * f);
        this.ii = (int) (2.0f * f);
        this.nl = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.m = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.d);
        Scroller scroller = this.m;
        if (scroller != null && !scroller.isFinished()) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void setScrollState(int i) {
        if (this.pq == i) {
            return;
        }
        this.pq = i;
        if (this.od != null) {
            hw(i != 0);
        }
        uc(i);
    }

    public void setAdapter(com.byazt.cqf.hw hwVar) {
        com.byazt.cqf.hw hwVar2 = this.hn;
        if (hwVar2 != null) {
            hwVar2.pr((DataSetObserver) null);
            for (int i = 0; i < this.fw.size(); i++) {
                hw hwVar3 = this.fw.get(i);
                this.hn.pr((ViewGroup) this, hwVar3.hw, hwVar3.pr);
            }
            this.fw.clear();
            uc();
            this.x = 0;
            scrollTo(0, 0);
        }
        this.hn = hwVar;
        this.pr = 0;
        if (hwVar != null) {
            if (this.ho == null) {
                this.ho = new uc();
            }
            this.hn.pr((DataSetObserver) this.ho);
            this.b = false;
            boolean z = this.nw;
            this.nw = true;
            this.pr = this.hn.pr();
            int i2 = this.vk;
            if (i2 >= 0) {
                pr(i2, false, true);
                this.vk = -1;
                this.w = null;
                this.k = null;
            } else if (!z) {
                hn();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.lv;
        if (list != null && !list.isEmpty()) {
            int size = this.lv.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.lv.get(i3);
            }
        }
    }

    private void uc() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((hn) getChildAt(i).getLayoutParams()).pr) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.byazt.cqf.hw getAdapter() {
        return this.hn;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.b = false;
        pr(i, !this.nw, false);
    }

    public void pr(int i, boolean z) {
        this.b = false;
        pr(i, z, false);
    }

    public int getCurrentItem() {
        return this.x;
    }

    public void pr(int i, boolean z, boolean z2) {
        pr(i, z, z2, 0);
    }

    public void pr(int i, boolean z, boolean z2, int i2) {
        com.byazt.cqf.hw hwVar = this.hn;
        if (hwVar == null || hwVar.pr() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.x == i && this.fw.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.hn.pr()) {
            i = this.hn.pr() - 1;
        }
        int i3 = this.iu;
        int i4 = this.x;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.fw.size(); i5++) {
                this.fw.get(i5).hn = true;
            }
        }
        boolean z3 = this.x != i;
        if (this.nw) {
            this.x = i;
            if (z3) {
                c(i);
            }
            requestLayout();
            return;
        }
        pr(i);
        pr(i, z, i2, z3);
    }

    private void pr(int i, boolean z, int i2, boolean z2) {
        int clientWidth;
        hw hwVarHw = hw(i);
        if (hwVarHw == null) {
            clientWidth = 0;
        } else {
            clientWidth = (int) (getClientWidth() * Math.max(this.a, Math.min(hwVarHw.c, this.cz)));
        }
        if (z) {
            pr(clientWidth, 0, i2);
            if (z2) {
                c(i);
                return;
            }
            return;
        }
        if (z2) {
            c(i);
        }
        pr(false);
        scrollTo(clientWidth, 0);
        x(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(x xVar) {
        this.jn = xVar;
    }

    public void pr(x xVar) {
        if (this.bm == null) {
            this.bm = new ArrayList();
        }
        this.bm.add(xVar);
    }

    public void pr(boolean z, c cVar) {
        pr(z, cVar, 2);
    }

    public void pr(boolean z, c cVar, int i) {
        boolean z2 = cVar != null;
        boolean z3 = z2 != (this.od != null);
        this.od = cVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.mw = z ? 2 : 1;
            this.vj = i;
        } else {
            this.mw = 0;
        }
        if (z3) {
            hn();
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mw == 2) {
            i2 = (i - 1) - i2;
        }
        return ((hn) this.sv.get(i2).getLayoutParams()).uc;
    }

    public int getOffscreenPageLimit() {
        return this.iu;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            i = 1;
        }
        if (i != this.iu) {
            this.iu = i;
            hn();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.nt;
        this.nt = i;
        int width = getWidth();
        pr(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.nt;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.yb = drawable;
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
        return super.verifyDrawable(drawable) || drawable == this.yb;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.yb;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public float pr(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public void pr(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.m;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            int currX = this.g ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
            scrollX = currX;
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            pr(false);
            hn();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i6;
        float fPr = f2 + (pr(Math.min(1.0f, (Math.abs(i4) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fPr / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i4) / ((f * this.hn.pr(this.x)) + this.nt)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.g = false;
        this.m.startScroll(scrollX, scrollY, i4, i5, iMin);
        postInvalidateOnAnimation();
    }

    public hw pr(int i, int i2) {
        hw hwVar = new hw();
        hwVar.hw = i;
        hwVar.pr = this.hn.pr((ViewGroup) this, i);
        hwVar.x = this.hn.pr(i);
        if (i2 < 0 || i2 >= this.fw.size()) {
            this.fw.add(hwVar);
        } else {
            this.fw.add(i2, hwVar);
        }
        return hwVar;
    }

    public void hw() {
        int iPr = this.hn.pr();
        this.pr = iPr;
        boolean z = this.fw.size() < (this.iu * 2) + 1 && this.fw.size() < iPr;
        int iMax = this.x;
        int i = 0;
        while (i < this.fw.size()) {
            hw hwVar = this.fw.get(i);
            int iPr2 = this.hn.pr(hwVar.pr);
            if (iPr2 != -1) {
                if (iPr2 == -2) {
                    this.fw.remove(i);
                    i--;
                    this.hn.pr((ViewGroup) this, hwVar.hw, hwVar.pr);
                    if (this.x != hwVar.hw) {
                        z = true;
                    } else {
                        iMax = Math.max(0, Math.min(this.x, iPr - 1));
                        z = true;
                    }
                } else if (hwVar.hw != iPr2) {
                    if (hwVar.hw == this.x) {
                        iMax = iPr2;
                    }
                    hwVar.hw = iPr2;
                    z = true;
                }
            }
            i++;
        }
        Collections.sort(this.fw, c);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                hn hnVar = (hn) getChildAt(i2).getLayoutParams();
                if (!hnVar.pr) {
                    hnVar.hn = 0.0f;
                }
            }
            pr(iMax, false, true);
            requestLayout();
        }
    }

    public void hn() {
        pr(this.x);
    }

    public void pr(int i) {
        hw hwVarHw;
        String hexString;
        hw hwVarPr;
        hw hwVarPr2;
        float paddingLeft;
        float paddingRight;
        int i2 = this.x;
        if (i2 == i) {
            hwVarHw = null;
        } else {
            hwVarHw = hw(i2);
            this.x = i;
        }
        if (this.hn == null) {
            fw();
            return;
        }
        if (this.b) {
            fw();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        int i3 = this.iu;
        int iMax = Math.max(0, this.x - i3);
        int iPr = this.hn.pr();
        int iMin = Math.min(iPr - 1, this.x + i3);
        if (iPr != this.pr) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException e) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.pr + ", found: " + iPr + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.hn.getClass());
        }
        int i4 = 0;
        while (true) {
            if (i4 < this.fw.size()) {
                hwVarPr = this.fw.get(i4);
                if (hwVarPr.hw >= this.x) {
                    if (hwVarPr.hw != this.x) {
                        break;
                    } else {
                        break;
                    }
                }
                i4++;
            }
            hwVarPr = null;
            break;
        }
        if (hwVarPr == null && iPr > 0) {
            hwVarPr = pr(this.x, i4);
        }
        if (hwVarPr != null) {
            int i5 = i4 - 1;
            hw hwVar = i5 >= 0 ? this.fw.get(i5) : null;
            int clientWidth = getClientWidth();
            if (clientWidth <= 0) {
                paddingLeft = 0.0f;
            } else {
                paddingLeft = (2.0f - hwVarPr.x) + (getPaddingLeft() / clientWidth);
            }
            float f = 0.0f;
            for (int i6 = this.x - 1; i6 >= 0; i6--) {
                if (f >= paddingLeft && i6 < iMax) {
                    if (hwVar == null) {
                        break;
                    }
                    if (i6 == hwVar.hw && !hwVar.hn) {
                        this.fw.remove(i5);
                        this.hn.pr((ViewGroup) this, i6, hwVar.pr);
                        i5--;
                        i4--;
                        hwVar = i5 >= 0 ? this.fw.get(i5) : null;
                    }
                } else if (hwVar != null && i6 == hwVar.hw) {
                    f += hwVar.x;
                    i5--;
                    hwVar = i5 >= 0 ? this.fw.get(i5) : null;
                } else {
                    f += pr(i6, i5 + 1).x;
                    i4++;
                    hwVar = i5 >= 0 ? this.fw.get(i5) : null;
                }
            }
            float f2 = hwVarPr.x;
            int i7 = i4 + 1;
            if (f2 < 2.0f) {
                hw hwVar2 = i7 < this.fw.size() ? this.fw.get(i7) : null;
                if (clientWidth <= 0) {
                    paddingRight = 0.0f;
                } else {
                    paddingRight = (getPaddingRight() / clientWidth) + 2.0f;
                }
                int i8 = this.x;
                while (true) {
                    i8++;
                    if (i8 >= iPr) {
                        break;
                    }
                    if (f2 >= paddingRight && i8 > iMin) {
                        if (hwVar2 == null) {
                            break;
                        }
                        if (i8 == hwVar2.hw && !hwVar2.hn) {
                            this.fw.remove(i7);
                            this.hn.pr((ViewGroup) this, i8, hwVar2.pr);
                            hwVar2 = i7 < this.fw.size() ? this.fw.get(i7) : null;
                        }
                    } else if (hwVar2 != null && i8 == hwVar2.hw) {
                        f2 += hwVar2.x;
                        i7++;
                        hwVar2 = i7 < this.fw.size() ? this.fw.get(i7) : null;
                    } else {
                        hw hwVarPr3 = pr(i8, i7);
                        i7++;
                        f2 += hwVarPr3.x;
                        hwVar2 = i7 < this.fw.size() ? this.fw.get(i7) : null;
                    }
                }
            }
            pr(hwVarPr, i4, hwVarHw);
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            hn hnVar = (hn) childAt.getLayoutParams();
            hnVar.uc = i9;
            if (!hnVar.pr && hnVar.hn == 0.0f && (hwVarPr2 = pr(childAt)) != null) {
                hnVar.hn = hwVarPr2.x;
                hnVar.c = hwVarPr2.hw;
            }
        }
        fw();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            hw hwVarHw2 = viewFindFocus != null ? hw(viewFindFocus) : null;
            if (hwVarHw2 == null || hwVarHw2.hw != this.x) {
                for (int i10 = 0; i10 < getChildCount(); i10++) {
                    View childAt2 = getChildAt(i10);
                    hw hwVarPr4 = pr(childAt2);
                    if (hwVarPr4 != null && hwVarPr4.hw == this.x && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    private void fw() {
        if (this.mw != 0) {
            ArrayList<View> arrayList = this.sv;
            if (arrayList == null) {
                this.sv = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.sv.add(getChildAt(i));
            }
            Collections.sort(this.sv, gu);
        }
    }

    private void pr(hw hwVar, int i, hw hwVar2) {
        hw hwVar3;
        hw hwVar4;
        int iPr = this.hn.pr();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.nt / clientWidth : 0.0f;
        if (hwVar2 != null) {
            int i2 = hwVar2.hw;
            if (i2 < hwVar.hw) {
                float fPr = hwVar2.c + hwVar2.x + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= hwVar.hw && i4 < this.fw.size()) {
                    hw hwVar5 = this.fw.get(i4);
                    while (true) {
                        hwVar4 = hwVar5;
                        if (i3 <= hwVar4.hw || i4 >= this.fw.size() - 1) {
                            break;
                        }
                        i4++;
                        hwVar5 = this.fw.get(i4);
                    }
                    while (i3 < hwVar4.hw) {
                        fPr += this.hn.pr(i3) + f;
                        i3++;
                    }
                    hwVar4.c = fPr;
                    fPr += hwVar4.x + f;
                    i3++;
                }
            } else if (i2 > hwVar.hw) {
                int size = this.fw.size() - 1;
                float fPr2 = hwVar2.c;
                while (true) {
                    i2--;
                    if (i2 < hwVar.hw || size < 0) {
                        break;
                    }
                    hw hwVar6 = this.fw.get(size);
                    while (true) {
                        hwVar3 = hwVar6;
                        if (i2 >= hwVar3.hw || size <= 0) {
                            break;
                        }
                        size--;
                        hwVar6 = this.fw.get(size);
                    }
                    while (i2 > hwVar3.hw) {
                        fPr2 -= this.hn.pr(i2) + f;
                        i2--;
                    }
                    fPr2 -= hwVar3.x + f;
                    hwVar3.c = fPr2;
                }
            }
        }
        int size2 = this.fw.size();
        float fPr3 = hwVar.c;
        int i5 = hwVar.hw - 1;
        this.a = hwVar.hw == 0 ? hwVar.c : -3.4028235E38f;
        int i6 = iPr - 1;
        this.cz = hwVar.hw == i6 ? (hwVar.c + hwVar.x) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            hw hwVar7 = this.fw.get(i7);
            while (i5 > hwVar7.hw) {
                fPr3 -= this.hn.pr(i5) + f;
                i5--;
            }
            fPr3 -= hwVar7.x + f;
            hwVar7.c = fPr3;
            if (hwVar7.hw == 0) {
                this.a = fPr3;
            }
            i7--;
            i5--;
        }
        float fPr4 = hwVar.c + hwVar.x + f;
        int i8 = hwVar.hw + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            hw hwVar8 = this.fw.get(i9);
            while (i8 < hwVar8.hw) {
                fPr4 += this.hn.pr(i8) + f;
                i8++;
            }
            if (hwVar8.hw == i6) {
                this.cz = (hwVar8.x + fPr4) - 1.0f;
            }
            hwVar8.c = fPr4;
            fPr4 += hwVar8.x + f;
            i9++;
            i8++;
        }
        this.ie = false;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 1471})
    public static class fw extends com.byazt.cqf.pr {
        public static final Parcelable.Creator<fw> CREATOR = new Parcelable.ClassLoaderCreator<fw>() { // from class: com.byazt.cqf.ViewPager.fw.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public fw createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new fw(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public fw createFromParcel(Parcel parcel) {
                return new fw(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public fw[] newArray(int i) {
                return new fw[i];
            }
        };
        public Parcelable hn;
        public int hw;
        public ClassLoader x;

        public fw(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.byazt.cqf.pr, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hw);
            parcel.writeParcelable(this.hn, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.hw + "}";
        }

        public fw(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.hw = parcel.readInt();
            this.hn = parcel.readParcelable(classLoader);
            this.x = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        fw fwVar = new fw(super.onSaveInstanceState());
        fwVar.hw = this.x;
        com.byazt.cqf.hw hwVar = this.hn;
        if (hwVar != null) {
            fwVar.hn = hwVar.hw();
        }
        return fwVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof fw)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        fw fwVar = (fw) parcelable;
        super.onRestoreInstanceState(fwVar.pr());
        if (this.hn != null) {
            pr(fwVar.hw, false, true);
            return;
        }
        this.vk = fwVar.hw;
        this.w = fwVar.hn;
        this.k = fwVar.x;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        hn hnVar = (hn) layoutParams;
        hnVar.pr |= hn(view);
        if (this.rc) {
            if (hnVar != null && hnVar.pr) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            hnVar.x = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean hn(View view) {
        return view.getClass().getAnnotation(pr.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.rc) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public hw pr(View view) {
        for (int i = 0; i < this.fw.size(); i++) {
            hw hwVar = this.fw.get(i);
            if (this.hn.pr(view, hwVar.pr)) {
                return hwVar;
            }
        }
        return null;
    }

    public hw hw(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return pr(view);
            }
        }
    }

    public hw hw(int i) {
        for (int i2 = 0; i2 < this.fw.size(); i2++) {
            hw hwVar = this.fw.get(i2);
            if (hwVar.hw == i) {
                return hwVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nw = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        hn hnVar;
        hn hnVar2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.y = Math.min(measuredWidth / 10, this.nl);
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
            if (childAt.getVisibility() != 8 && (hnVar2 = (hn) childAt.getLayoutParams()) != null && hnVar2.pr) {
                int i8 = hnVar2.hw & 7;
                int i9 = hnVar2.hw & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else if (!z2) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i3 = 1073741824;
                }
                if (hnVar2.width == -2) {
                    i4 = paddingLeft;
                } else if (hnVar2.width == -1) {
                    i4 = paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = hnVar2.width;
                    i10 = 1073741824;
                }
                if (hnVar2.height == -2) {
                    i5 = measuredHeight;
                    i7 = i3;
                } else if (hnVar2.height == -1) {
                    i5 = measuredHeight;
                } else {
                    i5 = hnVar2.height;
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
        this.ny = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.fo = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.rc = true;
        hn();
        this.rc = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((hnVar = (hn) childAt2.getLayoutParams()) == null || !hnVar.pr)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * hnVar.hn), 1073741824), this.fo);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.nt;
            pr(i, i3, i5, i5);
        }
    }

    private void pr(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.fw.isEmpty()) {
            if (!this.m.isFinished()) {
                this.m.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        hw hwVarHw = hw(this.x);
        int iMin = (int) ((hwVarHw != null ? Math.min(hwVarHw.c, this.cz) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            pr(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        hw hwVarPr;
        int measuredWidth;
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
                hn hnVar = (hn) childAt.getLayoutParams();
                if (hnVar.pr) {
                    int i9 = hnVar.hw & 7;
                    int i10 = hnVar.hw & 112;
                    switch (i9) {
                        case 1:
                            measuredWidth = paddingLeft;
                            paddingLeft = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            break;
                        case 3:
                            measuredWidth = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth2 = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            measuredWidth = paddingLeft;
                            paddingLeft = measuredWidth2;
                            break;
                    }
                    switch (i10) {
                        case 16:
                            measuredHeight = paddingTop;
                            paddingTop = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            break;
                        case 48:
                            measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                            break;
                        case 80:
                            int measuredHeight2 = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                            measuredHeight = paddingTop;
                            paddingTop = measuredHeight2;
                            break;
                        default:
                            measuredHeight = paddingTop;
                            break;
                    }
                    int i11 = paddingLeft + scrollX;
                    childAt.layout(i11, paddingTop, childAt.getMeasuredWidth() + i11, paddingTop + childAt.getMeasuredHeight());
                    i7++;
                    paddingTop = measuredHeight;
                    paddingLeft = measuredWidth;
                }
            }
        }
        int i12 = (i5 - paddingLeft) - paddingRight;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                hn hnVar2 = (hn) childAt2.getLayoutParams();
                if (!hnVar2.pr && (hwVarPr = pr(childAt2)) != null) {
                    float f = i12;
                    int i14 = ((int) (hwVarPr.c * f)) + paddingLeft;
                    if (hnVar2.x) {
                        hnVar2.x = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * hnVar2.hn), 1073741824), View.MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i14, paddingTop, childAt2.getMeasuredWidth() + i14, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.lb = paddingTop;
        this.qa = i6 - paddingBottom;
        this.f = i7;
        if (this.nw) {
            z2 = false;
            pr(this.x, false, 0, false);
        } else {
            z2 = false;
        }
        this.nw = z2;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.g = true;
        if (!this.m.isFinished() && this.m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!x(currX)) {
                    this.m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        pr(true);
    }

    private boolean x(int i) {
        if (this.fw.size() == 0) {
            if (this.nw) {
                return false;
            }
            this.o = false;
            pr(0, 0.0f, 0);
            if (this.o) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        hw hwVarAj = aj();
        int clientWidth = getClientWidth();
        int i2 = this.nt;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = hwVarAj.hw;
        float f2 = ((i / f) - hwVarAj.c) / (hwVarAj.x + (i2 / f));
        this.o = false;
        pr(i4, f2, (int) (i3 * f2));
        if (!this.o) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    public void pr(int i, float f, int i2) {
        int width;
        if (this.f > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width2 = getWidth();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                hn hnVar = (hn) childAt.getLayoutParams();
                if (hnVar.pr) {
                    switch (hnVar.hw & 7) {
                        case 1:
                            width = paddingLeft;
                            paddingLeft = Math.max((width2 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 2:
                        case 4:
                        default:
                            width = paddingLeft;
                            break;
                        case 3:
                            width = childAt.getWidth() + paddingLeft;
                            break;
                        case 5:
                            int measuredWidth = (width2 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            width = paddingLeft;
                            paddingLeft = measuredWidth;
                            break;
                    }
                    int left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                    paddingLeft = width;
                }
            }
        }
        hw(i, f, i2);
        if (this.od != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i4 = 0; i4 < childCount2; i4++) {
                View childAt2 = getChildAt(i4);
                if (!((hn) childAt2.getLayoutParams()).pr) {
                    this.od.pr(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.o = true;
    }

    private void hw(int i, float f, int i2) {
        x xVar = this.jn;
        if (xVar != null) {
            xVar.pr(i, f, i2);
        }
        List<x> list = this.bm;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                x xVar2 = this.bm.get(i3);
                if (xVar2 != null) {
                    xVar2.pr(i, f, i2);
                }
            }
        }
        x xVar3 = this.l;
        if (xVar3 != null) {
            xVar3.pr(i, f, i2);
        }
    }

    private void c(int i) {
        x xVar = this.jn;
        if (xVar != null) {
            xVar.k(i);
        }
        List<x> list = this.bm;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar2 = this.bm.get(i2);
                if (xVar2 != null) {
                    xVar2.k(i);
                }
            }
        }
        x xVar3 = this.l;
        if (xVar3 != null) {
            xVar3.k(i);
        }
    }

    private void uc(int i) {
        x xVar = this.jn;
        if (xVar != null) {
            xVar.m(i);
        }
        List<x> list = this.bm;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar2 = this.bm.get(i2);
                if (xVar2 != null) {
                    xVar2.m(i);
                }
            }
        }
        x xVar3 = this.l;
        if (xVar3 != null) {
            xVar3.m(i);
        }
    }

    private void pr(boolean z) {
        boolean z2 = this.pq == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        x(currX);
                    }
                }
            }
        }
        this.b = false;
        for (int i = 0; i < this.fw.size(); i++) {
            hw hwVar = this.fw.get(i);
            if (hwVar.hn) {
                hwVar.hn = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.d);
            } else {
                this.d.run();
            }
        }
    }

    private boolean pr(float f, float f2) {
        if (f >= this.y || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.y)) && f2 < 0.0f;
        }
        return true;
    }

    private void hw(boolean z) {
        int i;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (!z) {
                i = 0;
            } else {
                i = this.vj;
            }
            getChildAt(i2).setLayerType(i, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            zo();
            return false;
        }
        if (action != 0) {
            if (this.ve) {
                return true;
            }
            if (this.gz) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x2 = motionEvent.getX();
                this.s = x2;
                this.n = x2;
                float y = motionEvent.getY();
                this.ls = y;
                this.e = y;
                this.er = motionEvent.getPointerId(0);
                this.gz = false;
                this.g = true;
                this.m.computeScrollOffset();
                if (this.pq == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.ii) {
                    this.m.abortAnimation();
                    this.b = false;
                    hn();
                    this.ve = true;
                    hn(true);
                    setScrollState(1);
                } else {
                    pr(false);
                    this.ve = false;
                }
                break;
            case 2:
                int i = this.er;
                if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float f = x3 - this.n;
                    float fAbs = Math.abs(f);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y2 - this.ls);
                    if (f != 0.0f && !pr(this.n, f) && pr(this, false, (int) f, (int) x3, (int) y2)) {
                        this.n = x3;
                        this.e = y2;
                        this.gz = true;
                        return false;
                    }
                    int i2 = this.ww;
                    if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                        this.ve = true;
                        hn(true);
                        setScrollState(1);
                        this.n = f > 0.0f ? this.s + this.ww : this.s - this.ww;
                        this.e = y2;
                        setScrollingCacheEnabled(true);
                    } else if (fAbs2 > i2) {
                        this.gz = true;
                    }
                    if (this.ve && hw(x3)) {
                        postInvalidateOnAnimation();
                    }
                }
                break;
            case 6:
                pr(motionEvent);
                break;
        }
        if (this.v == null) {
            this.v = VelocityTracker.obtain();
        }
        this.v.addMovement(motionEvent);
        return this.ve;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.byazt.cqf.hw hwVar;
        int iFindPointerIndex;
        if (this.i) {
            return true;
        }
        boolean zZo = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (hwVar = this.hn) == null || hwVar.pr() == 0) {
            return false;
        }
        if (this.v == null) {
            this.v = VelocityTracker.obtain();
        }
        this.v.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.b = false;
                hn();
                float x2 = motionEvent.getX();
                this.s = x2;
                this.n = x2;
                float y = motionEvent.getY();
                this.ls = y;
                this.e = y;
                this.er = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.ve) {
                    VelocityTracker velocityTracker = this.v;
                    velocityTracker.computeCurrentVelocity(1000, this.qn);
                    int xVelocity = (int) velocityTracker.getXVelocity(this.er);
                    this.b = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    hw hwVarAj = aj();
                    float f = clientWidth;
                    float f2 = this.nt / f;
                    int i = hwVarAj.hw;
                    float f3 = ((scrollX / f) - hwVarAj.c) / (hwVarAj.x + f2);
                    int iFindPointerIndex2 = motionEvent.findPointerIndex(this.er);
                    if (iFindPointerIndex2 != -1) {
                        pr(pr(i, f3, xVelocity, (int) (motionEvent.getX(iFindPointerIndex2) - this.s)), true, true, xVelocity);
                        zZo = zo();
                    }
                }
                break;
            case 2:
                if (!this.ve) {
                    int iFindPointerIndex3 = motionEvent.findPointerIndex(this.er);
                    if (iFindPointerIndex3 == -1) {
                        zZo = zo();
                    } else {
                        float x3 = motionEvent.getX(iFindPointerIndex3);
                        float fAbs = Math.abs(x3 - this.n);
                        float y2 = motionEvent.getY(iFindPointerIndex3);
                        float fAbs2 = Math.abs(y2 - this.e);
                        if (fAbs > this.ww && fAbs > fAbs2) {
                            this.ve = true;
                            hn(true);
                            float f4 = this.s;
                            this.n = x3 - f4 > 0.0f ? f4 + this.ww : f4 - this.ww;
                            this.e = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                        if (this.ve) {
                            zZo = false | hw(motionEvent.getX(iFindPointerIndex));
                        }
                    }
                } else if (this.ve && (iFindPointerIndex = motionEvent.findPointerIndex(this.er)) != -1) {
                    zZo = false | hw(motionEvent.getX(iFindPointerIndex));
                }
                break;
            case 3:
                if (this.ve) {
                    pr(this.x, true, 0, false);
                    zZo = zo();
                }
                break;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex != -1) {
                    this.n = motionEvent.getX(actionIndex);
                    this.er = motionEvent.getPointerId(actionIndex);
                }
                break;
            case 6:
                pr(motionEvent);
                int iFindPointerIndex4 = motionEvent.findPointerIndex(this.er);
                if (iFindPointerIndex4 != -1) {
                    this.n = motionEvent.getX(iFindPointerIndex4);
                }
                break;
        }
        if (zZo) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean zo() {
        this.er = -1;
        vk();
        this.r.onRelease();
        this.hs.onRelease();
        return this.r.isFinished() || this.hs.isFinished();
    }

    private void hn(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean hw(float f) {
        boolean z;
        boolean z2;
        float f2 = this.n - f;
        this.n = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.a * clientWidth;
        float f4 = this.cz * clientWidth;
        boolean z3 = false;
        hw hwVar = this.fw.get(0);
        ArrayList<hw> arrayList = this.fw;
        hw hwVar2 = arrayList.get(arrayList.size() - 1);
        if (hwVar.hw == 0) {
            z = true;
        } else {
            f3 = hwVar.c * clientWidth;
            z = false;
        }
        if (hwVar2.hw == this.hn.pr() - 1) {
            z2 = true;
        } else {
            f4 = hwVar2.c * clientWidth;
            z2 = false;
        }
        if (scrollX < f3) {
            if (z) {
                this.r.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.hs.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.n += scrollX - i;
        scrollTo(i, getScrollY());
        x(i);
        return z3;
    }

    private hw aj() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.nt / clientWidth : 0.0f;
        hw hwVar = null;
        int i2 = 0;
        int i3 = -1;
        boolean z = true;
        float f3 = 0.0f;
        while (i2 < this.fw.size()) {
            hw hwVar2 = this.fw.get(i2);
            if (!z && hwVar2.hw != (i = i3 + 1)) {
                hwVar2 = this.zo;
                hwVar2.c = f + f3 + f2;
                hwVar2.hw = i;
                hwVar2.x = this.hn.pr(hwVar2.hw);
                i2--;
            }
            f = hwVar2.c;
            float f4 = hwVar2.x + f + f2;
            if (!z && scrollX < f) {
                return hwVar;
            }
            if (scrollX < f4 || i2 == this.fw.size() - 1) {
                return hwVar2;
            }
            i3 = hwVar2.hw;
            f3 = hwVar2.x;
            i2++;
            z = false;
            hwVar = hwVar2;
        }
        return hwVar;
    }

    private int pr(int i, float f, int i2, int i3) {
        if (Math.abs(i3) > this.of && Math.abs(i2) > this.qi) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i += (int) (f + (i >= this.x ? 0.4f : 0.6f));
        }
        if (this.fw.size() > 0) {
            hw hwVar = this.fw.get(0);
            ArrayList<hw> arrayList = this.fw;
            return Math.max(hwVar.hw, Math.min(i, arrayList.get(arrayList.size() - 1).hw));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.byazt.cqf.hw hwVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (hwVar = this.hn) != null && hwVar.pr() > 1)) {
            if (!this.r.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.a * width);
                this.r.setSize(height, width);
                zDraw = false | this.r.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.hs.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.cz + 1.0f)) * width2);
                this.hs.setSize(height2, width2);
                zDraw |= this.hs.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.r.finish();
            this.hs.finish();
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
        if (this.nt > 0 && this.yb != null && this.fw.size() > 0 && this.hn != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f3 = width;
            float f4 = this.nt / f3;
            int i = 0;
            hw hwVar = this.fw.get(0);
            float f5 = hwVar.c;
            int size = this.fw.size();
            int i2 = hwVar.hw;
            int i3 = this.fw.get(size - 1).hw;
            while (i2 < i3) {
                while (i2 > hwVar.hw && i < size) {
                    i++;
                    hwVar = this.fw.get(i);
                }
                if (i2 == hwVar.hw) {
                    f2 = (hwVar.c + hwVar.x) * f3;
                    f = hwVar.c + hwVar.x + f4;
                } else {
                    float fPr = this.hn.pr(i2);
                    float f6 = (f5 + fPr) * f3;
                    f = f5 + fPr + f4;
                    f2 = f6;
                }
                if (this.nt + f2 > scrollX) {
                    this.yb.setBounds(Math.round(f2), this.lb, Math.round(this.nt + f2), this.qa);
                    this.yb.draw(canvas);
                }
                if (f2 <= scrollX + width) {
                    i2++;
                    f5 = f;
                    f4 = f4;
                } else {
                    return;
                }
            }
        }
    }

    private void pr(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.er) {
            int i = actionIndex == 0 ? 1 : 0;
            this.n = motionEvent.getX(i);
            this.er = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.v;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void vk() {
        this.ve = false;
        this.gz = false;
        VelocityTracker velocityTracker = this.v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.v = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.z != z) {
            this.z = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.hn == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.a));
        }
        return i > 0 && scrollX < ((int) (((float) clientWidth) * this.cz));
    }

    public boolean pr(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && pr(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || pr(keyEvent);
    }

    public boolean pr(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            switch (keyEvent.getKeyCode()) {
                case 21:
                    if (keyEvent.hasModifiers(2)) {
                        return x();
                    }
                    return hn(17);
                case 22:
                    if (keyEvent.hasModifiers(2)) {
                        return c();
                    }
                    return hn(66);
                case 61:
                    if (keyEvent.hasNoModifiers()) {
                        return hn(2);
                    }
                    if (keyEvent.hasModifiers(1)) {
                        return hn(1);
                    }
                default:
                    return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c0  */
    public boolean hn(int i) {
        boolean z;
        View viewFindFocus = findFocus();
        boolean zX = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent != this) {
                    parent = parent.getParent();
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                ho.hw("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            if (i != 17) {
                if (i == 66) {
                    int i2 = pr(this.aj, viewFindNextFocus).left;
                    int i3 = pr(this.aj, viewFindFocus).left;
                    if (viewFindFocus == null || i2 > i3) {
                        zX = viewFindNextFocus.requestFocus();
                    } else {
                        zX = c();
                    }
                }
            } else {
                int i4 = pr(this.aj, viewFindNextFocus).left;
                int i5 = pr(this.aj, viewFindFocus).left;
                if (viewFindFocus != null && i4 >= i5) {
                    zX = x();
                } else {
                    zX = viewFindNextFocus.requestFocus();
                }
            }
        } else if (i == 17 || i == 1) {
            zX = x();
        } else if (i == 66 || i == 2) {
            zX = c();
        }
        if (zX) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return zX;
    }

    private Rect pr(Rect rect, View view) {
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

    public boolean x() {
        int i = this.x;
        if (i > 0) {
            pr(i - 1, true);
            return true;
        }
        return false;
    }

    public boolean c() {
        com.byazt.cqf.hw hwVar = this.hn;
        if (hwVar != null && this.x < hwVar.pr() - 1) {
            pr(this.x + 1, true);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        hw hwVarPr;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (hwVarPr = pr(childAt)) != null && hwVarPr.hw == this.x) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        hw hwVarPr;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (hwVarPr = pr(childAt)) != null && hwVarPr.hw == this.x) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        hw hwVarPr;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (hwVarPr = pr(childAt)) != null && hwVarPr.hw == this.x && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        hw hwVarPr;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (hwVarPr = pr(childAt)) != null && hwVarPr.hw == this.x && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new hn();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof hn) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new hn(getContext(), attributeSet);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 1380})
    private class uc extends DataSetObserver {
        public uc() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.hw();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.hw();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 1430})
    public static class hn extends ViewGroup.LayoutParams {
        public int c;
        public float hn;
        public int hw;
        public boolean pr;
        public int uc;
        public boolean x;

        public hn() {
            super(-1, -1);
            this.hn = 0.0f;
        }

        public hn(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.hn = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.hw);
            this.hw = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 1366})
    static class zo implements Comparator<View> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            hn hnVar = (hn) view.getLayoutParams();
            hn hnVar2 = (hn) view2.getLayoutParams();
            if (hnVar.pr != hnVar2.pr) {
                return hnVar.pr ? 1 : -1;
            }
            return hnVar.c - hnVar2.c;
        }
    }
}
