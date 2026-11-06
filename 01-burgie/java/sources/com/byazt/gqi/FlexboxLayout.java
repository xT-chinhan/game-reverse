package com.byazt.gqi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.aa.fw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 600, 1467})
public class FlexboxLayout extends ViewGroup implements com.byazt.gqi.pr {
    public int aj;
    public int c;
    public Drawable fw;
    public SparseIntArray g;
    public int hn;
    public x ho;
    public int hw;
    public int k;
    public x.pr lb;
    public int[] m;
    public List<hn> nt;
    public int pr;
    public int uc;
    public int vk;
    public int w;
    public int x;
    public com.byazt.llk.c yb;
    public Drawable zo;

    public FlexboxLayout(Context context) {
        super(context, null);
        this.uc = -1;
        this.ho = new x(this);
        this.nt = new ArrayList();
        this.lb = new x.pr();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.llk.c cVar = this.yb;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            pr(iArrPr[0], iArrPr[1]);
        } else {
            pr(i, i2);
        }
        com.byazt.llk.c cVar2 = this.yb;
        if (cVar2 != null) {
            cVar2.hn();
        }
    }

    private void pr(int i, int i2) {
        if (this.g == null) {
            this.g = new SparseIntArray(getChildCount());
        }
        if (this.ho.hw(this.g)) {
            this.m = this.ho.pr(this.g);
        }
        switch (this.pr) {
            case 0:
            case 1:
                hw(i, i2);
                return;
            case 2:
            case 3:
                hn(i, i2);
                return;
            default:
                throw new IllegalStateException("Invalid value for the flex direction is set: " + this.pr);
        }
    }

    @Override // com.byazt.gqi.pr
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.byazt.gqi.pr
    public View pr(int i) {
        return getChildAt(i);
    }

    public View hn(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.m;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.byazt.gqi.pr
    public View hw(int i) {
        return hn(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.g == null) {
            this.g = new SparseIntArray(getChildCount());
        }
        this.m = this.ho.pr(view, i, layoutParams, this.g);
        super.addView(view, i, layoutParams);
    }

    private void hw(int i, int i2) {
        this.nt.clear();
        this.lb.pr();
        this.ho.pr(this.lb, i, i2);
        this.nt = this.lb.pr;
        this.ho.pr(i, i2);
        if (this.x == 3) {
            for (hn hnVar : this.nt) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < hnVar.zo; i3++) {
                    View viewHn = hn(hnVar.ho + i3);
                    if (viewHn != null && viewHn.getVisibility() != 8) {
                        pr prVar = (pr) viewHn.getLayoutParams();
                        if (this.hw != 2) {
                            iMax = Math.max(iMax, viewHn.getMeasuredHeight() + Math.max(hnVar.k - viewHn.getBaseline(), prVar.topMargin) + prVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewHn.getMeasuredHeight() + prVar.topMargin + Math.max((hnVar.k - viewHn.getMeasuredHeight()) + viewHn.getBaseline(), prVar.bottomMargin));
                        }
                    }
                }
                hnVar.fw = iMax;
            }
        }
        this.ho.hw(i, i2, getPaddingTop() + getPaddingBottom());
        this.ho.pr();
        pr(this.pr, i, i2, this.lb.hw);
    }

    private void hn(int i, int i2) {
        this.nt.clear();
        this.lb.pr();
        this.ho.hw(this.lb, i, i2);
        this.nt = this.lb.pr;
        this.ho.pr(i, i2);
        this.ho.hw(i, i2, getPaddingLeft() + getPaddingRight());
        this.ho.pr();
        pr(this.pr, i, i2, this.lb.hw);
    }

    private void pr(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        switch (i) {
            case 0:
            case 1:
                sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
                largestMainSize = getLargestMainSize();
                break;
            case 2:
            case 3:
                sumOfCrossSize = getLargestMainSize();
                largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
                break;
            default:
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < largestMainSize) {
                    i4 = View.combineMeasuredStates(i4, 16777216);
                } else {
                    size = largestMainSize;
                }
                iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
                break;
            case 0:
                iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
                break;
            case 1073741824:
                if (size < largestMainSize) {
                    i4 = View.combineMeasuredStates(i4, 16777216);
                }
                iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
                break;
            default:
                throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                if (size2 < sumOfCrossSize) {
                    i4 = View.combineMeasuredStates(i4, 256);
                } else {
                    size2 = sumOfCrossSize;
                }
                iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
                break;
            case 0:
                iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
                break;
            case 1073741824:
                if (size2 < sumOfCrossSize) {
                    i4 = View.combineMeasuredStates(i4, 256);
                }
                iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
                break;
            default:
                throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.byazt.gqi.pr
    public int getLargestMainSize() {
        Iterator<hn> it = this.nt.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().c);
        }
        return iMax;
    }

    @Override // com.byazt.gqi.pr
    public int getSumOfCrossSize() {
        int size = this.nt.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            hn hnVar = this.nt.get(i2);
            if (x(i2)) {
                if (pr()) {
                    i += this.w;
                } else {
                    i += this.k;
                }
            }
            if (uc(i2)) {
                if (pr()) {
                    i += this.w;
                } else {
                    i += this.k;
                }
            }
            i += hnVar.fw;
        }
        return i;
    }

    @Override // com.byazt.gqi.pr
    public boolean pr() {
        int i = this.pr;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3;
        boolean z4;
        com.byazt.llk.c cVar = this.yb;
        if (cVar != null) {
            cVar.x();
        }
        int iPr = fw.pr(this);
        switch (this.pr) {
            case 0:
                pr(iPr == 1, i, i2, i3, i4);
                break;
            case 1:
                pr(iPr != 1, i, i2, i3, i4);
                break;
            case 2:
                z2 = iPr == 1;
                if (this.hw != 2) {
                    z3 = z2;
                } else {
                    z3 = !z2;
                }
                pr(z3, false, i, i2, i3, i4);
                break;
            case 3:
                z2 = iPr == 1;
                if (this.hw != 2) {
                    z4 = z2;
                } else {
                    z4 = !z2;
                }
                pr(z4, true, i, i2, i3, i4);
                break;
            default:
                throw new IllegalStateException("Invalid flex direction is set: " + this.pr);
        }
        com.byazt.llk.c cVar2 = this.yb;
        if (cVar2 != null) {
            cVar2.pr(i, i2, i3, i4);
        }
    }

    private void pr(boolean z, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int i5;
        int i6;
        float f5;
        float f6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i9 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.nt.size();
        for (int i10 = 0; i10 < size; i10++) {
            hn hnVar = this.nt.get(i10);
            if (x(i10)) {
                int i11 = this.w;
                paddingBottom -= i11;
                paddingTop += i11;
            }
            int i12 = 1;
            switch (this.hn) {
                case 0:
                    f = paddingLeft;
                    f2 = i9 - paddingRight;
                    f3 = 0.0f;
                    break;
                case 1:
                    f = (i9 - hnVar.c) + paddingRight;
                    f2 = hnVar.c - paddingLeft;
                    f3 = 0.0f;
                    break;
                case 2:
                    f = paddingLeft + ((i9 - hnVar.c) / 2.0f);
                    f2 = (i9 - paddingRight) - ((i9 - hnVar.c) / 2.0f);
                    f3 = 0.0f;
                    break;
                case 3:
                    f = paddingLeft;
                    int iHw = hnVar.hw();
                    f3 = (i9 - hnVar.c) / (iHw != 1 ? iHw - 1 : 1.0f);
                    f2 = i9 - paddingRight;
                    break;
                case 4:
                    int iHw2 = hnVar.hw();
                    if (iHw2 == 0) {
                        f4 = 0.0f;
                    } else {
                        f4 = (i9 - hnVar.c) / iHw2;
                    }
                    float f7 = f4 / 2.0f;
                    f = paddingLeft + f7;
                    float f8 = f4;
                    f2 = (i9 - paddingRight) - f7;
                    f3 = f8;
                    break;
                case 5:
                    int iHw3 = hnVar.hw();
                    if (iHw3 == 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = (i9 - hnVar.c) / (iHw3 + 1);
                    }
                    f = paddingLeft + f3;
                    f2 = (i9 - paddingRight) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.hn);
            }
            float fMax = Math.max(f3, 0.0f);
            int i13 = 0;
            while (i13 < hnVar.zo) {
                int i14 = hnVar.ho + i13;
                View viewHn = hn(i14);
                if (viewHn == null || viewHn.getVisibility() == 8) {
                    i5 = i13;
                    i6 = i12;
                } else {
                    pr prVar = (pr) viewHn.getLayoutParams();
                    float f9 = f + prVar.leftMargin;
                    float f10 = f2 - prVar.rightMargin;
                    if (!x(i14, i13)) {
                        f5 = f9;
                        f6 = f10;
                        i7 = 0;
                    } else {
                        int i15 = this.k;
                        float f11 = i15;
                        f5 = f9 + f11;
                        i7 = i15;
                        f6 = f10 - f11;
                    }
                    if (i13 == hnVar.zo - i12 && (this.vk & 4) > 0) {
                        i8 = this.k;
                    } else {
                        i8 = 0;
                    }
                    if (this.hw == 2) {
                        if (z) {
                            i5 = i13;
                            i6 = i12;
                            this.ho.pr(viewHn, hnVar, Math.round(f6) - viewHn.getMeasuredWidth(), paddingBottom - viewHn.getMeasuredHeight(), Math.round(f6), paddingBottom);
                        } else {
                            i5 = i13;
                            i6 = i12;
                            this.ho.pr(viewHn, hnVar, Math.round(f5), paddingBottom - viewHn.getMeasuredHeight(), Math.round(f5) + viewHn.getMeasuredWidth(), paddingBottom);
                        }
                    } else {
                        i5 = i13;
                        i6 = i12;
                        if (z) {
                            this.ho.pr(viewHn, hnVar, Math.round(f6) - viewHn.getMeasuredWidth(), paddingTop, Math.round(f6), paddingTop + viewHn.getMeasuredHeight());
                        } else {
                            this.ho.pr(viewHn, hnVar, Math.round(f5), paddingTop, Math.round(f5) + viewHn.getMeasuredWidth(), paddingTop + viewHn.getMeasuredHeight());
                        }
                    }
                    float measuredWidth = f5 + viewHn.getMeasuredWidth() + fMax + prVar.rightMargin;
                    float measuredWidth2 = f6 - ((viewHn.getMeasuredWidth() + fMax) + prVar.leftMargin);
                    if (z) {
                        hnVar.pr(viewHn, i8, 0, i7, 0);
                    } else {
                        hnVar.pr(viewHn, i7, 0, i8, 0);
                    }
                    f = measuredWidth;
                    f2 = measuredWidth2;
                }
                i13 = i5 + 1;
                i12 = i6;
            }
            paddingTop += hnVar.fw;
            paddingBottom -= hnVar.fw;
        }
    }

    private void pr(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int i5;
        int i6;
        float f5;
        float f6;
        int i7;
        int i8;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int i10 = (i3 - i) - paddingRight;
        int size = this.nt.size();
        for (int i11 = 0; i11 < size; i11++) {
            hn hnVar = this.nt.get(i11);
            if (x(i11)) {
                int i12 = this.k;
                paddingLeft += i12;
                i10 -= i12;
            }
            int i13 = 1;
            switch (this.hn) {
                case 0:
                    f = paddingTop;
                    f2 = i9 - paddingBottom;
                    f3 = 0.0f;
                    break;
                case 1:
                    f = (i9 - hnVar.c) + paddingBottom;
                    f2 = hnVar.c - paddingTop;
                    f3 = 0.0f;
                    break;
                case 2:
                    f = paddingTop + ((i9 - hnVar.c) / 2.0f);
                    f2 = (i9 - paddingBottom) - ((i9 - hnVar.c) / 2.0f);
                    f3 = 0.0f;
                    break;
                case 3:
                    f = paddingTop;
                    int iHw = hnVar.hw();
                    f3 = (i9 - hnVar.c) / (iHw != 1 ? iHw - 1 : 1.0f);
                    f2 = i9 - paddingBottom;
                    break;
                case 4:
                    int iHw2 = hnVar.hw();
                    if (iHw2 == 0) {
                        f4 = 0.0f;
                    } else {
                        f4 = (i9 - hnVar.c) / iHw2;
                    }
                    float f7 = f4 / 2.0f;
                    f = paddingTop + f7;
                    float f8 = f4;
                    f2 = (i9 - paddingBottom) - f7;
                    f3 = f8;
                    break;
                case 5:
                    int iHw3 = hnVar.hw();
                    if (iHw3 == 0) {
                        f3 = 0.0f;
                    } else {
                        f3 = (i9 - hnVar.c) / (iHw3 + 1);
                    }
                    f = paddingTop + f3;
                    f2 = (i9 - paddingBottom) - f3;
                    break;
                default:
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.hn);
            }
            float fMax = Math.max(f3, 0.0f);
            int i14 = 0;
            while (i14 < hnVar.zo) {
                int i15 = hnVar.ho + i14;
                View viewHn = hn(i15);
                if (viewHn == null || viewHn.getVisibility() == 8) {
                    i5 = i14;
                    i6 = i13;
                } else {
                    pr prVar = (pr) viewHn.getLayoutParams();
                    float f9 = f + prVar.topMargin;
                    float f10 = f2 - prVar.bottomMargin;
                    if (!x(i15, i14)) {
                        f5 = f9;
                        f6 = f10;
                        i7 = 0;
                    } else {
                        int i16 = this.w;
                        float f11 = i16;
                        f5 = f9 + f11;
                        i7 = i16;
                        f6 = f10 - f11;
                    }
                    if (i14 == hnVar.zo - i13 && (this.aj & 4) > 0) {
                        i8 = this.w;
                    } else {
                        i8 = 0;
                    }
                    if (z) {
                        if (z2) {
                            i5 = i14;
                            i6 = i13;
                            this.ho.pr(viewHn, hnVar, true, i10 - viewHn.getMeasuredWidth(), Math.round(f6) - viewHn.getMeasuredHeight(), i10, Math.round(f6));
                        } else {
                            i5 = i14;
                            i6 = i13;
                            this.ho.pr(viewHn, hnVar, true, i10 - viewHn.getMeasuredWidth(), Math.round(f5), i10, Math.round(f5) + viewHn.getMeasuredHeight());
                        }
                    } else {
                        i5 = i14;
                        i6 = i13;
                        if (z2) {
                            this.ho.pr(viewHn, hnVar, false, paddingLeft, Math.round(f6) - viewHn.getMeasuredHeight(), paddingLeft + viewHn.getMeasuredWidth(), Math.round(f6));
                        } else {
                            this.ho.pr(viewHn, hnVar, false, paddingLeft, Math.round(f5), paddingLeft + viewHn.getMeasuredWidth(), Math.round(f5) + viewHn.getMeasuredHeight());
                        }
                    }
                    float measuredHeight = f5 + viewHn.getMeasuredHeight() + fMax + prVar.bottomMargin;
                    float measuredHeight2 = f6 - ((viewHn.getMeasuredHeight() + fMax) + prVar.topMargin);
                    if (z2) {
                        hnVar.pr(viewHn, 0, i8, 0, i7);
                    } else {
                        hnVar.pr(viewHn, 0, i7, 0, i8);
                    }
                    f = measuredHeight;
                    f2 = measuredHeight2;
                }
                i14 = i5 + 1;
                i13 = i6;
            }
            paddingLeft += hnVar.fw;
            i10 -= hnVar.fw;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.zo == null && this.fw == null) {
        }
        if (this.aj == 0 && this.vk == 0) {
            return;
        }
        int iPr = fw.pr(this);
        switch (this.pr) {
            case 0:
                pr(canvas, iPr == 1, this.hw == 2);
                break;
            case 1:
                pr(canvas, iPr != 1, this.hw == 2);
                break;
            case 2:
                boolean z = iPr == 1;
                if (this.hw == 2) {
                    z = !z;
                }
                hw(canvas, z, false);
                break;
            case 3:
                boolean z2 = iPr == 1;
                if (this.hw == 2) {
                    z2 = !z2;
                }
                hw(canvas, z2, true);
                break;
        }
    }

    private void pr(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.nt.size();
        for (int i3 = 0; i3 < size; i3++) {
            hn hnVar = this.nt.get(i3);
            for (int i4 = 0; i4 < hnVar.zo; i4++) {
                int i5 = hnVar.ho + i4;
                View viewHn = hn(i5);
                if (viewHn != null && viewHn.getVisibility() != 8) {
                    pr prVar = (pr) viewHn.getLayoutParams();
                    if (x(i5, i4)) {
                        if (z) {
                            left = viewHn.getRight() + prVar.rightMargin;
                        } else {
                            left = (viewHn.getLeft() - prVar.leftMargin) - this.k;
                        }
                        pr(canvas, left, hnVar.hw, hnVar.fw);
                    }
                    if (i4 == hnVar.zo - 1 && (this.vk & 4) > 0) {
                        if (z) {
                            right = (viewHn.getLeft() - prVar.leftMargin) - this.k;
                        } else {
                            right = viewHn.getRight() + prVar.rightMargin;
                        }
                        pr(canvas, right, hnVar.hw, hnVar.fw);
                    }
                }
            }
            if (x(i3)) {
                if (z2) {
                    i2 = hnVar.x;
                } else {
                    i2 = hnVar.hw - this.w;
                }
                hw(canvas, paddingLeft, i2, iMax);
            }
            if (uc(i3) && (this.aj & 4) > 0) {
                if (z2) {
                    i = hnVar.hw - this.w;
                } else {
                    i = hnVar.x;
                }
                hw(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void hw(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.nt.size();
        for (int i3 = 0; i3 < size; i3++) {
            hn hnVar = this.nt.get(i3);
            for (int i4 = 0; i4 < hnVar.zo; i4++) {
                int i5 = hnVar.ho + i4;
                View viewHn = hn(i5);
                if (viewHn != null && viewHn.getVisibility() != 8) {
                    pr prVar = (pr) viewHn.getLayoutParams();
                    if (x(i5, i4)) {
                        if (z2) {
                            top = viewHn.getBottom() + prVar.bottomMargin;
                        } else {
                            top = (viewHn.getTop() - prVar.topMargin) - this.w;
                        }
                        hw(canvas, hnVar.pr, top, hnVar.fw);
                    }
                    if (i4 == hnVar.zo - 1 && (this.aj & 4) > 0) {
                        if (z2) {
                            bottom = (viewHn.getTop() - prVar.topMargin) - this.w;
                        } else {
                            bottom = viewHn.getBottom() + prVar.bottomMargin;
                        }
                        hw(canvas, hnVar.pr, bottom, hnVar.fw);
                    }
                }
            }
            if (x(i3)) {
                if (z) {
                    i2 = hnVar.hn;
                } else {
                    i2 = hnVar.pr - this.k;
                }
                pr(canvas, i2, paddingTop, iMax);
            }
            if (uc(i3) && (this.vk & 4) > 0) {
                if (z) {
                    i = hnVar.pr - this.k;
                } else {
                    i = hnVar.hn;
                }
                pr(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void pr(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.zo;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.k + i, i3 + i2);
        this.zo.draw(canvas);
    }

    private void hw(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.fw;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.w + i2);
        this.fw.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof pr;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof pr) {
            return new pr((pr) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new pr((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new pr(layoutParams);
    }

    @Override // com.byazt.gqi.pr
    public int getFlexDirection() {
        return this.pr;
    }

    public void setFlexDirection(int i) {
        if (this.pr != i) {
            this.pr = i;
            requestLayout();
        }
    }

    @Override // com.byazt.gqi.pr
    public int getFlexWrap() {
        return this.hw;
    }

    public void setFlexWrap(int i) {
        if (this.hw != i) {
            this.hw = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.hn;
    }

    public void setJustifyContent(int i) {
        if (this.hn != i) {
            this.hn = i;
            requestLayout();
        }
    }

    @Override // com.byazt.gqi.pr
    public int getAlignItems() {
        return this.x;
    }

    public void setAlignItems(int i) {
        if (this.x != i) {
            this.x = i;
            requestLayout();
        }
    }

    @Override // com.byazt.gqi.pr
    public int getAlignContent() {
        return this.c;
    }

    public void setAlignContent(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    @Override // com.byazt.gqi.pr
    public int getMaxLine() {
        return this.uc;
    }

    public void setMaxLine(int i) {
        if (this.uc != i) {
            this.uc = i;
            requestLayout();
        }
    }

    public List<hn> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.nt.size());
        for (hn hnVar : this.nt) {
            if (hnVar.hw() != 0) {
                arrayList.add(hnVar);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.gqi.pr
    public int pr(View view, int i, int i2) {
        int i3;
        if (pr()) {
            i3 = x(i, i2) ? 0 + this.k : 0;
            if ((this.vk & 4) > 0) {
                return i3 + this.k;
            }
            return i3;
        }
        i3 = x(i, i2) ? 0 + this.w : 0;
        if ((this.aj & 4) > 0) {
            return i3 + this.w;
        }
        return i3;
    }

    @Override // com.byazt.gqi.pr
    public int pr(View view) {
        return 0;
    }

    @Override // com.byazt.gqi.pr
    public void pr(hn hnVar) {
        if (pr()) {
            if ((this.vk & 4) > 0) {
                hnVar.c += this.k;
                hnVar.uc += this.k;
                return;
            }
            return;
        }
        if ((this.aj & 4) > 0) {
            hnVar.c += this.w;
            hnVar.uc += this.w;
        }
    }

    @Override // com.byazt.gqi.pr
    public int pr(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.byazt.gqi.pr
    public int hw(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.byazt.gqi.pr
    public void pr(View view, int i, int i2, hn hnVar) {
        if (x(i, i2)) {
            if (pr()) {
                hnVar.c += this.k;
                hnVar.uc += this.k;
            } else {
                hnVar.c += this.w;
                hnVar.uc += this.w;
            }
        }
    }

    @Override // com.byazt.gqi.pr
    public void setFlexLines(List<hn> list) {
        this.nt = list;
    }

    @Override // com.byazt.gqi.pr
    public List<hn> getFlexLinesInternal() {
        return this.nt;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.fw;
    }

    public Drawable getDividerDrawableVertical() {
        return this.zo;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.fw) {
            return;
        }
        this.fw = drawable;
        if (drawable != null) {
            this.w = drawable.getIntrinsicHeight();
        } else {
            this.w = 0;
        }
        hw();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.zo) {
            return;
        }
        this.zo = drawable;
        if (drawable != null) {
            this.k = drawable.getIntrinsicWidth();
        } else {
            this.k = 0;
        }
        hw();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.vk;
    }

    public int getShowDividerHorizontal() {
        return this.aj;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.vk) {
            this.vk = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.aj) {
            this.aj = i;
            requestLayout();
        }
    }

    private void hw() {
        if (this.fw == null && this.zo == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean x(int i, int i2) {
        if (c(i, i2)) {
            if (pr()) {
                return (this.vk & 1) != 0;
            }
            return (this.aj & 1) != 0;
        }
        if (pr()) {
            return (this.vk & 2) != 0;
        }
        return (this.aj & 2) != 0;
    }

    private boolean c(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewHn = hn(i - i3);
            if (viewHn != null && viewHn.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean x(int i) {
        if (i < 0 || i >= this.nt.size()) {
            return false;
        }
        if (c(i)) {
            if (pr()) {
                return (this.aj & 1) != 0;
            }
            return (this.vk & 1) != 0;
        }
        if (pr()) {
            return (this.aj & 2) != 0;
        }
        return (this.vk & 2) != 0;
    }

    private boolean c(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.nt.get(i2).hw() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean uc(int i) {
        if (i < 0 || i >= this.nt.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.nt.size(); i2++) {
            if (this.nt.get(i2).hw() > 0) {
                return false;
            }
        }
        if (pr()) {
            if ((this.aj & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.vk & 4) == 0) {
            return false;
        }
        return true;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 600, 1498})
    public static class pr extends ViewGroup.MarginLayoutParams implements hw {
        public static final Parcelable.Creator<pr> CREATOR = new Parcelable.Creator<pr>() { // from class: com.byazt.gqi.FlexboxLayout.pr.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public pr createFromParcel(Parcel parcel) {
                return new pr(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public pr[] newArray(int i) {
                return new pr[i];
            }
        };
        public int aj;
        public float c;
        public int fw;
        public float hn;
        public float hw;
        public int pr;
        public int uc;
        public boolean vk;
        public int x;
        public int zo;

        public pr(pr prVar) {
            super((ViewGroup.MarginLayoutParams) prVar);
            this.pr = 1;
            this.hw = 0.0f;
            this.hn = 0.0f;
            this.x = -1;
            this.c = -1.0f;
            this.uc = -1;
            this.fw = -1;
            this.zo = ViewCompat.MEASURED_SIZE_MASK;
            this.aj = ViewCompat.MEASURED_SIZE_MASK;
            this.pr = prVar.pr;
            this.hw = prVar.hw;
            this.hn = prVar.hn;
            this.x = prVar.x;
            this.c = prVar.c;
            this.uc = prVar.uc;
            this.fw = prVar.fw;
            this.zo = prVar.zo;
            this.aj = prVar.aj;
            this.vk = prVar.vk;
        }

        public pr(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.pr = 1;
            this.hw = 0.0f;
            this.hn = 0.0f;
            this.x = -1;
            this.c = -1.0f;
            this.uc = -1;
            this.fw = -1;
            this.zo = ViewCompat.MEASURED_SIZE_MASK;
            this.aj = ViewCompat.MEASURED_SIZE_MASK;
        }

        public pr(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.pr = 1;
            this.hw = 0.0f;
            this.hn = 0.0f;
            this.x = -1;
            this.c = -1.0f;
            this.uc = -1;
            this.fw = -1;
            this.zo = ViewCompat.MEASURED_SIZE_MASK;
            this.aj = ViewCompat.MEASURED_SIZE_MASK;
        }

        public pr(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.pr = 1;
            this.hw = 0.0f;
            this.hn = 0.0f;
            this.x = -1;
            this.c = -1.0f;
            this.uc = -1;
            this.fw = -1;
            this.zo = ViewCompat.MEASURED_SIZE_MASK;
            this.aj = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.byazt.gqi.hw
        public int pr() {
            return this.width;
        }

        @Override // com.byazt.gqi.hw
        public int hw() {
            return this.height;
        }

        @Override // com.byazt.gqi.hw
        public int hn() {
            return this.pr;
        }

        public void hn(int i) {
            this.pr = i;
        }

        @Override // com.byazt.gqi.hw
        public float x() {
            return this.hw;
        }

        public void pr(float f) {
            this.hw = f;
        }

        @Override // com.byazt.gqi.hw
        public float c() {
            return this.hn;
        }

        public void hw(float f) {
            this.hn = f;
        }

        @Override // com.byazt.gqi.hw
        public int uc() {
            return this.x;
        }

        public void x(int i) {
            this.x = i;
        }

        @Override // com.byazt.gqi.hw
        public int fw() {
            return this.uc;
        }

        @Override // com.byazt.gqi.hw
        public void pr(int i) {
            this.uc = i;
        }

        @Override // com.byazt.gqi.hw
        public int zo() {
            return this.fw;
        }

        @Override // com.byazt.gqi.hw
        public void hw(int i) {
            this.fw = i;
        }

        @Override // com.byazt.gqi.hw
        public int aj() {
            return this.zo;
        }

        @Override // com.byazt.gqi.hw
        public int vk() {
            return this.aj;
        }

        @Override // com.byazt.gqi.hw
        public boolean w() {
            return this.vk;
        }

        @Override // com.byazt.gqi.hw
        public float k() {
            return this.c;
        }

        public void hn(float f) {
            this.c = f;
        }

        @Override // com.byazt.gqi.hw
        public int m() {
            return this.leftMargin;
        }

        @Override // com.byazt.gqi.hw
        public int g() {
            return this.topMargin;
        }

        @Override // com.byazt.gqi.hw
        public int ho() {
            return this.rightMargin;
        }

        @Override // com.byazt.gqi.hw
        public int nt() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.pr);
            parcel.writeFloat(this.hw);
            parcel.writeFloat(this.hn);
            parcel.writeInt(this.x);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.uc);
            parcel.writeInt(this.fw);
            parcel.writeInt(this.zo);
            parcel.writeInt(this.aj);
            parcel.writeByte(this.vk ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        public pr(Parcel parcel) {
            super(0, 0);
            this.pr = 1;
            this.hw = 0.0f;
            this.hn = 0.0f;
            this.x = -1;
            this.c = -1.0f;
            this.uc = -1;
            this.fw = -1;
            this.zo = ViewCompat.MEASURED_SIZE_MASK;
            this.aj = ViewCompat.MEASURED_SIZE_MASK;
            this.pr = parcel.readInt();
            this.hw = parcel.readFloat();
            this.hn = parcel.readFloat();
            this.x = parcel.readInt();
            this.c = parcel.readFloat();
            this.uc = parcel.readInt();
            this.fw = parcel.readInt();
            this.zo = parcel.readInt();
            this.aj = parcel.readInt();
            this.vk = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void pr(com.byazt.ik.hn hnVar) {
        this.yb = hnVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.llk.c cVar = this.yb;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.llk.c cVar = this.yb;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.llk.c cVar = this.yb;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.llk.c cVar = this.yb;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }
}
