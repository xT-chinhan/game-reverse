package com.byazt.yx;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import com.byazt.hb.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, 1586})
public class FlexboxLayout extends ViewGroup implements com.byazt.yx.n {
    public q.n cd;
    public int cp;
    public List<s> cy;
    public int d;
    public Drawable fs;
    public com.byazt.gu.l hd;
    public q k;
    public int l;
    public int n;
    public int[] oa;
    public int q;
    public int qg;
    public int rv;
    public int s;
    public SparseIntArray sz;
    public int tj;
    public int w;
    public Drawable x;

    @Override // com.byazt.yx.n
    public int n(View view) {
        return 0;
    }

    public FlexboxLayout(Context context) {
        super(context, null);
        this.w = -1;
        this.k = new q(this);
        this.cy = new ArrayList();
        this.cd = new q.n();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.gu.l lVar = this.hd;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            n(iArrN[0], iArrN[1]);
        } else {
            n(i, i2);
        }
        com.byazt.gu.l lVar2 = this.hd;
        if (lVar2 != null) {
            lVar2.s();
        }
    }

    private void n(int i, int i2) {
        if (this.sz == null) {
            this.sz = new SparseIntArray(getChildCount());
        }
        if (this.k.qg(this.sz)) {
            this.oa = this.k.n(this.sz);
        }
        int i3 = this.n;
        if (i3 == 0 || i3 == 1) {
            qg(i, i2);
        } else {
            if (i3 == 2 || i3 == 3) {
                s(i, i2);
                return;
            }
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.n);
        }
    }

    @Override // com.byazt.yx.n
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.byazt.yx.n
    public View n(int i) {
        return getChildAt(i);
    }

    public View s(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.oa;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.byazt.yx.n
    public View qg(int i) {
        return s(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.sz == null) {
            this.sz = new SparseIntArray(getChildCount());
        }
        this.oa = this.k.n(view, i, layoutParams, this.sz);
        super.addView(view, i, layoutParams);
    }

    private void qg(int i, int i2) {
        this.cy.clear();
        this.cd.n();
        this.k.n(this.cd, i, i2);
        this.cy = this.cd.n;
        this.k.n(i, i2);
        if (this.q == 3) {
            for (s sVar : this.cy) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < sVar.fs; i3++) {
                    View viewS = s(sVar.k + i3);
                    if (viewS != null && viewS.getVisibility() != 8) {
                        n nVar = (n) viewS.getLayoutParams();
                        if (this.qg != 2) {
                            iMax = Math.max(iMax, viewS.getMeasuredHeight() + Math.max(sVar.d - viewS.getBaseline(), nVar.topMargin) + nVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewS.getMeasuredHeight() + nVar.topMargin + Math.max((sVar.d - viewS.getMeasuredHeight()) + viewS.getBaseline(), nVar.bottomMargin));
                        }
                    }
                }
                sVar.x = iMax;
            }
        }
        this.k.qg(i, i2, getPaddingTop() + getPaddingBottom());
        this.k.n();
        n(this.n, i, i2, this.cd.qg);
    }

    private void s(int i, int i2) {
        this.cy.clear();
        this.cd.n();
        this.k.qg(this.cd, i, i2);
        this.cy = this.cd.n;
        this.k.n(i, i2);
        this.k.qg(i, i2, getPaddingLeft() + getPaddingRight());
        this.k.n();
        n(this.n, i, i2, this.cd.qg);
    }

    private void n(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.byazt.yx.n
    public int getLargestMainSize() {
        Iterator<s> it = this.cy.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().l);
        }
        return iMax;
    }

    @Override // com.byazt.yx.n
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.cy.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            s sVar = this.cy.get(i4);
            if (q(i4)) {
                if (n()) {
                    i2 = this.cp;
                } else {
                    i2 = this.d;
                }
                i3 += i2;
            }
            if (w(i4)) {
                if (n()) {
                    i = this.cp;
                } else {
                    i = this.d;
                }
                i3 += i;
            }
            i3 += sVar.x;
        }
        return i3;
    }

    @Override // com.byazt.yx.n
    public boolean n() {
        int i = this.n;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.byazt.gu.l lVar = this.hd;
        if (lVar != null) {
            lVar.q();
        }
        int iN = x.n(this);
        int i5 = this.n;
        if (i5 == 0) {
            n(iN == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            n(iN != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iN == 1;
            n(this.qg == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iN == 1;
            n(this.qg == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.n);
        }
        com.byazt.gu.l lVar2 = this.hd;
        if (lVar2 != null) {
            lVar2.n(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x010e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0116  */
    /* JADX WARN: Code duplicated, block: B:55:0x011b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x0157  */
    /* JADX WARN: Code duplicated, block: B:62:0x0181  */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:69:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x0200  */
    /* JADX WARN: Code duplicated, block: B:72:0x020b  */
    private void n(boolean z, int i, int i2, int i3, int i4) {
        float measuredWidth;
        int i5;
        float f;
        float f2;
        float fMax;
        int i6;
        int i7;
        View viewS;
        int i8;
        int i9;
        int i10;
        char c;
        n nVar;
        float f3;
        float f4;
        float f5;
        int i11;
        char c2;
        int i12;
        n nVar2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i13 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.cy.size();
        int i14 = 0;
        while (i14 < size) {
            s sVar = this.cy.get(i14);
            if (q(i14)) {
                int i15 = this.cp;
                paddingBottom -= i15;
                paddingTop += i15;
            }
            int i16 = this.s;
            char c3 = 4;
            int i17 = 1;
            if (i16 != 0) {
                if (i16 == 1) {
                    measuredWidth = (i13 - sVar.l) + paddingRight;
                    i5 = sVar.l - paddingLeft;
                } else if (i16 == 2) {
                    measuredWidth = paddingLeft + ((i13 - sVar.l) / 2.0f);
                    f = (i13 - paddingRight) - ((i13 - sVar.l) / 2.0f);
                    f2 = 0.0f;
                } else if (i16 == 3) {
                    measuredWidth = paddingLeft;
                    int iQg = sVar.qg();
                    f2 = (i13 - sVar.l) / (iQg != 1 ? iQg - 1 : 1.0f);
                    f = i13 - paddingRight;
                } else if (i16 == 4) {
                    int iQg2 = sVar.qg();
                    f2 = iQg2 != 0 ? (i13 - sVar.l) / iQg2 : 0.0f;
                    float f6 = f2 / 2.0f;
                    measuredWidth = paddingLeft + f6;
                    f = (i13 - paddingRight) - f6;
                } else if (i16 == 5) {
                    int iQg3 = sVar.qg();
                    f2 = iQg3 != 0 ? (i13 - sVar.l) / (iQg3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f2;
                    f = (i13 - paddingRight) - f2;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.s);
                }
                fMax = Math.max(f2, 0.0f);
                i6 = 0;
                while (i6 < sVar.fs) {
                    i7 = sVar.k + i6;
                    viewS = s(i7);
                    if (viewS != null) {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        c = c3;
                    } else if (viewS.getVisibility() != 8) {
                        nVar = (n) viewS.getLayoutParams();
                        f3 = measuredWidth + nVar.leftMargin;
                        f4 = f - nVar.rightMargin;
                        if (q(i7, i6)) {
                            int i18 = this.d;
                            float f7 = i18;
                            f3 += f7;
                            i11 = i18;
                            f5 = f4 - f7;
                        } else {
                            f5 = f4;
                            i11 = 0;
                        }
                        if (i6 == sVar.fs - i17) {
                            c2 = 4;
                            i12 = (this.tj & 4) > 0 ? this.d : 0;
                            if (this.qg == 2) {
                                i8 = paddingLeft;
                                i9 = i17;
                                i10 = i6;
                                nVar2 = nVar;
                                c = c2;
                                if (z) {
                                    this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewS.getMeasuredHeight());
                                } else {
                                    this.k.n(viewS, sVar, Math.round(f3), paddingTop, Math.round(f3) + viewS.getMeasuredWidth(), paddingTop + viewS.getMeasuredHeight());
                                }
                            } else if (z) {
                                i9 = i17;
                                i10 = i6;
                                i8 = paddingLeft;
                                nVar2 = nVar;
                                c = c2;
                                this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingBottom - viewS.getMeasuredHeight(), Math.round(f5), paddingBottom);
                            } else {
                                i8 = paddingLeft;
                                i9 = i17;
                                i10 = i6;
                                nVar2 = nVar;
                                c = c2;
                                this.k.n(viewS, sVar, Math.round(f3), paddingBottom - viewS.getMeasuredHeight(), Math.round(f3) + viewS.getMeasuredWidth(), paddingBottom);
                            }
                            measuredWidth = f3 + viewS.getMeasuredWidth() + fMax + nVar2.rightMargin;
                            float measuredWidth2 = f5 - ((viewS.getMeasuredWidth() + fMax) + nVar2.leftMargin);
                            if (z) {
                                sVar.n(viewS, i12, 0, i11, 0);
                            } else {
                                sVar.n(viewS, i11, 0, i12, 0);
                            }
                            f = measuredWidth2;
                        } else {
                            c2 = 4;
                        }
                        if (this.qg == 2) {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            nVar2 = nVar;
                            c = c2;
                            if (z) {
                                this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewS.getMeasuredHeight());
                            } else {
                                this.k.n(viewS, sVar, Math.round(f3), paddingTop, Math.round(f3) + viewS.getMeasuredWidth(), paddingTop + viewS.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = i17;
                            i10 = i6;
                            i8 = paddingLeft;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingBottom - viewS.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, Math.round(f3), paddingBottom - viewS.getMeasuredHeight(), Math.round(f3) + viewS.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewS.getMeasuredWidth() + fMax + nVar2.rightMargin;
                        float measuredWidth3 = f5 - ((viewS.getMeasuredWidth() + fMax) + nVar2.leftMargin);
                        if (z) {
                            sVar.n(viewS, i12, 0, i11, 0);
                        } else {
                            sVar.n(viewS, i11, 0, i12, 0);
                        }
                        f = measuredWidth3;
                    } else {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        c = 4;
                    }
                    i6 = i10 + 1;
                    paddingLeft = i8;
                    i17 = i9;
                    c3 = c;
                }
                paddingTop += sVar.x;
                paddingBottom -= sVar.x;
                i14++;
                paddingLeft = paddingLeft;
            } else {
                measuredWidth = paddingLeft;
                i5 = i13 - paddingRight;
            }
            f = i5;
            f2 = 0.0f;
            fMax = Math.max(f2, 0.0f);
            i6 = 0;
            while (i6 < sVar.fs) {
                i7 = sVar.k + i6;
                viewS = s(i7);
                if (viewS != null) {
                    i8 = paddingLeft;
                    i9 = i17;
                    i10 = i6;
                    c = c3;
                } else if (viewS.getVisibility() != 8) {
                    nVar = (n) viewS.getLayoutParams();
                    f3 = measuredWidth + nVar.leftMargin;
                    f4 = f - nVar.rightMargin;
                    if (q(i7, i6)) {
                        int i19 = this.d;
                        float f8 = i19;
                        f3 += f8;
                        i11 = i19;
                        f5 = f4 - f8;
                    } else {
                        f5 = f4;
                        i11 = 0;
                    }
                    if (i6 == sVar.fs - i17) {
                        c2 = 4;
                        if ((this.tj & 4) > 0) {
                        }
                        if (this.qg == 2) {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            nVar2 = nVar;
                            c = c2;
                            if (z) {
                                this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewS.getMeasuredHeight());
                            } else {
                                this.k.n(viewS, sVar, Math.round(f3), paddingTop, Math.round(f3) + viewS.getMeasuredWidth(), paddingTop + viewS.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = i17;
                            i10 = i6;
                            i8 = paddingLeft;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingBottom - viewS.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i8 = paddingLeft;
                            i9 = i17;
                            i10 = i6;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, Math.round(f3), paddingBottom - viewS.getMeasuredHeight(), Math.round(f3) + viewS.getMeasuredWidth(), paddingBottom);
                        }
                        measuredWidth = f3 + viewS.getMeasuredWidth() + fMax + nVar2.rightMargin;
                        float measuredWidth4 = f5 - ((viewS.getMeasuredWidth() + fMax) + nVar2.leftMargin);
                        if (z) {
                            sVar.n(viewS, i12, 0, i11, 0);
                        } else {
                            sVar.n(viewS, i11, 0, i12, 0);
                        }
                        f = measuredWidth4;
                    } else {
                        c2 = 4;
                    }
                    if (this.qg == 2) {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        nVar2 = nVar;
                        c = c2;
                        if (z) {
                            this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingTop, Math.round(f5), paddingTop + viewS.getMeasuredHeight());
                        } else {
                            this.k.n(viewS, sVar, Math.round(f3), paddingTop, Math.round(f3) + viewS.getMeasuredWidth(), paddingTop + viewS.getMeasuredHeight());
                        }
                    } else if (z) {
                        i9 = i17;
                        i10 = i6;
                        i8 = paddingLeft;
                        nVar2 = nVar;
                        c = c2;
                        this.k.n(viewS, sVar, Math.round(f5) - viewS.getMeasuredWidth(), paddingBottom - viewS.getMeasuredHeight(), Math.round(f5), paddingBottom);
                    } else {
                        i8 = paddingLeft;
                        i9 = i17;
                        i10 = i6;
                        nVar2 = nVar;
                        c = c2;
                        this.k.n(viewS, sVar, Math.round(f3), paddingBottom - viewS.getMeasuredHeight(), Math.round(f3) + viewS.getMeasuredWidth(), paddingBottom);
                    }
                    measuredWidth = f3 + viewS.getMeasuredWidth() + fMax + nVar2.rightMargin;
                    float measuredWidth5 = f5 - ((viewS.getMeasuredWidth() + fMax) + nVar2.leftMargin);
                    if (z) {
                        sVar.n(viewS, i12, 0, i11, 0);
                    } else {
                        sVar.n(viewS, i11, 0, i12, 0);
                    }
                    f = measuredWidth5;
                } else {
                    i8 = paddingLeft;
                    i9 = i17;
                    i10 = i6;
                    c = 4;
                }
                i6 = i10 + 1;
                paddingLeft = i8;
                i17 = i9;
                c3 = c;
            }
            paddingTop += sVar.x;
            paddingBottom -= sVar.x;
            i14++;
            paddingLeft = paddingLeft;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:49:0x0105  */
    /* JADX WARN: Code duplicated, block: B:52:0x0111  */
    /* JADX WARN: Code duplicated, block: B:54:0x0119  */
    /* JADX WARN: Code duplicated, block: B:55:0x011e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:60:0x0155  */
    /* JADX WARN: Code duplicated, block: B:61:0x017d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0187  */
    /* JADX WARN: Code duplicated, block: B:64:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:71:0x0205  */
    private void n(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        float fMax;
        int i6;
        int i7;
        View viewS;
        int i8;
        boolean z3;
        char c;
        n nVar;
        float f4;
        float f5;
        float f6;
        float f7;
        int i9;
        char c2;
        int i10;
        n nVar2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i11 = i4 - i2;
        int i12 = (i3 - i) - paddingRight;
        int size = this.cy.size();
        for (int i13 = 0; i13 < size; i13++) {
            s sVar = this.cy.get(i13);
            if (q(i13)) {
                int i14 = this.d;
                paddingLeft += i14;
                i12 -= i14;
            }
            int i15 = this.s;
            char c3 = 4;
            boolean z4 = true;
            if (i15 != 0) {
                if (i15 == 1) {
                    f = (i11 - sVar.l) + paddingBottom;
                    i5 = sVar.l - paddingTop;
                } else if (i15 == 2) {
                    f = ((i11 - sVar.l) / 2.0f) + paddingTop;
                    f2 = (i11 - paddingBottom) - ((i11 - sVar.l) / 2.0f);
                    f3 = 0.0f;
                } else if (i15 == 3) {
                    f = paddingTop;
                    int iQg = sVar.qg();
                    f3 = (i11 - sVar.l) / (iQg != 1 ? iQg - 1 : 1.0f);
                    f2 = i11 - paddingBottom;
                } else if (i15 == 4) {
                    int iQg2 = sVar.qg();
                    f3 = iQg2 != 0 ? (i11 - sVar.l) / iQg2 : 0.0f;
                    float f8 = f3 / 2.0f;
                    f = paddingTop + f8;
                    f2 = (i11 - paddingBottom) - f8;
                } else if (i15 == 5) {
                    int iQg3 = sVar.qg();
                    f3 = iQg3 != 0 ? (i11 - sVar.l) / (iQg3 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i11 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.s);
                }
                fMax = Math.max(f3, 0.0f);
                i6 = 0;
                while (i6 < sVar.fs) {
                    i7 = sVar.k + i6;
                    viewS = s(i7);
                    if (viewS != null) {
                        i8 = i6;
                        z3 = z4;
                        c = c3;
                    } else if (viewS.getVisibility() != 8) {
                        nVar = (n) viewS.getLayoutParams();
                        f4 = f + nVar.topMargin;
                        f5 = f2 - nVar.bottomMargin;
                        if (q(i7, i6)) {
                            int i16 = this.cp;
                            float f9 = i16;
                            f6 = f4 + f9;
                            i9 = i16;
                            f7 = f5 - f9;
                        } else {
                            f6 = f4;
                            f7 = f5;
                            i9 = 0;
                        }
                        if (i6 == sVar.fs - 1) {
                            c2 = 4;
                            i10 = (this.rv & 4) > 0 ? this.cp : 0;
                            if (z) {
                                i8 = i6;
                                z3 = true;
                                nVar2 = nVar;
                                c = c2;
                                if (z2) {
                                    this.k.n(viewS, sVar, false, paddingLeft, Math.round(f7) - viewS.getMeasuredHeight(), paddingLeft + viewS.getMeasuredWidth(), Math.round(f7));
                                } else {
                                    this.k.n(viewS, sVar, false, paddingLeft, Math.round(f6), paddingLeft + viewS.getMeasuredWidth(), Math.round(f6) + viewS.getMeasuredHeight());
                                }
                            } else if (z2) {
                                i8 = i6;
                                z3 = true;
                                nVar2 = nVar;
                                c = c2;
                                this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f7) - viewS.getMeasuredHeight(), i12, Math.round(f7));
                            } else {
                                i8 = i6;
                                z3 = true;
                                nVar2 = nVar;
                                c = c2;
                                this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewS.getMeasuredHeight());
                            }
                            n nVar3 = nVar2;
                            float measuredHeight = f6 + viewS.getMeasuredHeight() + fMax + nVar3.bottomMargin;
                            float measuredHeight2 = f7 - ((viewS.getMeasuredHeight() + fMax) + nVar3.topMargin);
                            if (z2) {
                                sVar.n(viewS, 0, i10, 0, i9);
                            } else {
                                sVar.n(viewS, 0, i9, 0, i10);
                            }
                            f = measuredHeight;
                            f2 = measuredHeight2;
                        } else {
                            c2 = 4;
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            nVar2 = nVar;
                            c = c2;
                            if (z2) {
                                this.k.n(viewS, sVar, false, paddingLeft, Math.round(f7) - viewS.getMeasuredHeight(), paddingLeft + viewS.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.k.n(viewS, sVar, false, paddingLeft, Math.round(f6), paddingLeft + viewS.getMeasuredWidth(), Math.round(f6) + viewS.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f7) - viewS.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewS.getMeasuredHeight());
                        }
                        n nVar4 = nVar2;
                        float measuredHeight3 = f6 + viewS.getMeasuredHeight() + fMax + nVar4.bottomMargin;
                        float measuredHeight4 = f7 - ((viewS.getMeasuredHeight() + fMax) + nVar4.topMargin);
                        if (z2) {
                            sVar.n(viewS, 0, i10, 0, i9);
                        } else {
                            sVar.n(viewS, 0, i9, 0, i10);
                        }
                        f = measuredHeight3;
                        f2 = measuredHeight4;
                    } else {
                        i8 = i6;
                        z3 = true;
                        c = 4;
                    }
                    i6 = i8 + 1;
                    z4 = z3;
                    c3 = c;
                }
                paddingLeft += sVar.x;
                i12 -= sVar.x;
            } else {
                f = paddingTop;
                i5 = i11 - paddingBottom;
            }
            f2 = i5;
            f3 = 0.0f;
            fMax = Math.max(f3, 0.0f);
            i6 = 0;
            while (i6 < sVar.fs) {
                i7 = sVar.k + i6;
                viewS = s(i7);
                if (viewS != null) {
                    i8 = i6;
                    z3 = z4;
                    c = c3;
                } else if (viewS.getVisibility() != 8) {
                    nVar = (n) viewS.getLayoutParams();
                    f4 = f + nVar.topMargin;
                    f5 = f2 - nVar.bottomMargin;
                    if (q(i7, i6)) {
                        int i17 = this.cp;
                        float f10 = i17;
                        f6 = f4 + f10;
                        i9 = i17;
                        f7 = f5 - f10;
                    } else {
                        f6 = f4;
                        f7 = f5;
                        i9 = 0;
                    }
                    if (i6 == sVar.fs - 1) {
                        c2 = 4;
                        if ((this.rv & 4) > 0) {
                        }
                        if (z) {
                            i8 = i6;
                            z3 = true;
                            nVar2 = nVar;
                            c = c2;
                            if (z2) {
                                this.k.n(viewS, sVar, false, paddingLeft, Math.round(f7) - viewS.getMeasuredHeight(), paddingLeft + viewS.getMeasuredWidth(), Math.round(f7));
                            } else {
                                this.k.n(viewS, sVar, false, paddingLeft, Math.round(f6), paddingLeft + viewS.getMeasuredWidth(), Math.round(f6) + viewS.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i8 = i6;
                            z3 = true;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f7) - viewS.getMeasuredHeight(), i12, Math.round(f7));
                        } else {
                            i8 = i6;
                            z3 = true;
                            nVar2 = nVar;
                            c = c2;
                            this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewS.getMeasuredHeight());
                        }
                        n nVar5 = nVar2;
                        float measuredHeight5 = f6 + viewS.getMeasuredHeight() + fMax + nVar5.bottomMargin;
                        float measuredHeight6 = f7 - ((viewS.getMeasuredHeight() + fMax) + nVar5.topMargin);
                        if (z2) {
                            sVar.n(viewS, 0, i10, 0, i9);
                        } else {
                            sVar.n(viewS, 0, i9, 0, i10);
                        }
                        f = measuredHeight5;
                        f2 = measuredHeight6;
                    } else {
                        c2 = 4;
                    }
                    if (z) {
                        i8 = i6;
                        z3 = true;
                        nVar2 = nVar;
                        c = c2;
                        if (z2) {
                            this.k.n(viewS, sVar, false, paddingLeft, Math.round(f7) - viewS.getMeasuredHeight(), paddingLeft + viewS.getMeasuredWidth(), Math.round(f7));
                        } else {
                            this.k.n(viewS, sVar, false, paddingLeft, Math.round(f6), paddingLeft + viewS.getMeasuredWidth(), Math.round(f6) + viewS.getMeasuredHeight());
                        }
                    } else if (z2) {
                        i8 = i6;
                        z3 = true;
                        nVar2 = nVar;
                        c = c2;
                        this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f7) - viewS.getMeasuredHeight(), i12, Math.round(f7));
                    } else {
                        i8 = i6;
                        z3 = true;
                        nVar2 = nVar;
                        c = c2;
                        this.k.n(viewS, sVar, true, i12 - viewS.getMeasuredWidth(), Math.round(f6), i12, Math.round(f6) + viewS.getMeasuredHeight());
                    }
                    n nVar6 = nVar2;
                    float measuredHeight7 = f6 + viewS.getMeasuredHeight() + fMax + nVar6.bottomMargin;
                    float measuredHeight8 = f7 - ((viewS.getMeasuredHeight() + fMax) + nVar6.topMargin);
                    if (z2) {
                        sVar.n(viewS, 0, i10, 0, i9);
                    } else {
                        sVar.n(viewS, 0, i9, 0, i10);
                    }
                    f = measuredHeight7;
                    f2 = measuredHeight8;
                } else {
                    i8 = i6;
                    z3 = true;
                    c = 4;
                }
                i6 = i8 + 1;
                z4 = z3;
                c3 = c;
            }
            paddingLeft += sVar.x;
            i12 -= sVar.x;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.fs == null && this.x == null) {
            return;
        }
        if (this.rv == 0 && this.tj == 0) {
            return;
        }
        int iN = x.n(this);
        int i = this.n;
        if (i == 0) {
            n(canvas, iN == 1, this.qg == 2);
            return;
        }
        if (i == 1) {
            n(canvas, iN != 1, this.qg == 2);
            return;
        }
        if (i == 2) {
            boolean z = iN == 1;
            if (this.qg == 2) {
                z = !z;
            }
            qg(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iN == 1;
        if (this.qg == 2) {
            z2 = !z2;
        }
        qg(canvas, z2, true);
    }

    private void n(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.cy.size();
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = this.cy.get(i3);
            for (int i4 = 0; i4 < sVar.fs; i4++) {
                int i5 = sVar.k + i4;
                View viewS = s(i5);
                if (viewS != null && viewS.getVisibility() != 8) {
                    n nVar = (n) viewS.getLayoutParams();
                    if (q(i5, i4)) {
                        if (z) {
                            left = viewS.getRight() + nVar.rightMargin;
                        } else {
                            left = (viewS.getLeft() - nVar.leftMargin) - this.d;
                        }
                        n(canvas, left, sVar.qg, sVar.x);
                    }
                    if (i4 == sVar.fs - 1 && (this.tj & 4) > 0) {
                        if (z) {
                            right = (viewS.getLeft() - nVar.leftMargin) - this.d;
                        } else {
                            right = viewS.getRight() + nVar.rightMargin;
                        }
                        n(canvas, right, sVar.qg, sVar.x);
                    }
                }
            }
            if (q(i3)) {
                if (z2) {
                    i2 = sVar.q;
                } else {
                    i2 = sVar.qg - this.cp;
                }
                qg(canvas, paddingLeft, i2, iMax);
            }
            if (w(i3) && (this.rv & 4) > 0) {
                if (z2) {
                    i = sVar.qg - this.cp;
                } else {
                    i = sVar.q;
                }
                qg(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void qg(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.cy.size();
        for (int i3 = 0; i3 < size; i3++) {
            s sVar = this.cy.get(i3);
            for (int i4 = 0; i4 < sVar.fs; i4++) {
                int i5 = sVar.k + i4;
                View viewS = s(i5);
                if (viewS != null && viewS.getVisibility() != 8) {
                    n nVar = (n) viewS.getLayoutParams();
                    if (q(i5, i4)) {
                        if (z2) {
                            top = viewS.getBottom() + nVar.bottomMargin;
                        } else {
                            top = (viewS.getTop() - nVar.topMargin) - this.cp;
                        }
                        qg(canvas, sVar.n, top, sVar.x);
                    }
                    if (i4 == sVar.fs - 1 && (this.rv & 4) > 0) {
                        if (z2) {
                            bottom = (viewS.getTop() - nVar.topMargin) - this.cp;
                        } else {
                            bottom = viewS.getBottom() + nVar.bottomMargin;
                        }
                        qg(canvas, sVar.n, bottom, sVar.x);
                    }
                }
            }
            if (q(i3)) {
                if (z) {
                    i2 = sVar.s;
                } else {
                    i2 = sVar.n - this.d;
                }
                n(canvas, i2, paddingTop, iMax);
            }
            if (w(i3) && (this.tj & 4) > 0) {
                if (z) {
                    i = sVar.n - this.d;
                } else {
                    i = sVar.s;
                }
                n(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void n(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.fs;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.d + i, i3 + i2);
        this.fs.draw(canvas);
    }

    private void qg(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.x;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.cp + i2);
        this.x.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof n) {
            return new n((n) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new n((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new n(layoutParams);
    }

    @Override // com.byazt.yx.n
    public int getFlexDirection() {
        return this.n;
    }

    public void setFlexDirection(int i) {
        if (this.n != i) {
            this.n = i;
            requestLayout();
        }
    }

    @Override // com.byazt.yx.n
    public int getFlexWrap() {
        return this.qg;
    }

    public void setFlexWrap(int i) {
        if (this.qg != i) {
            this.qg = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.s;
    }

    public void setJustifyContent(int i) {
        if (this.s != i) {
            this.s = i;
            requestLayout();
        }
    }

    @Override // com.byazt.yx.n
    public int getAlignItems() {
        return this.q;
    }

    public void setAlignItems(int i) {
        if (this.q != i) {
            this.q = i;
            requestLayout();
        }
    }

    @Override // com.byazt.yx.n
    public int getAlignContent() {
        return this.l;
    }

    public void setAlignContent(int i) {
        if (this.l != i) {
            this.l = i;
            requestLayout();
        }
    }

    @Override // com.byazt.yx.n
    public int getMaxLine() {
        return this.w;
    }

    public void setMaxLine(int i) {
        if (this.w != i) {
            this.w = i;
            requestLayout();
        }
    }

    public List<s> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.cy.size());
        for (s sVar : this.cy) {
            if (sVar.qg() != 0) {
                arrayList.add(sVar);
            }
        }
        return arrayList;
    }

    @Override // com.byazt.yx.n
    public int n(View view, int i, int i2) {
        int i3;
        int i4;
        if (n()) {
            i3 = q(i, i2) ? 0 + this.d : 0;
            if ((this.tj & 4) <= 0) {
                return i3;
            }
            i4 = this.d;
        } else {
            i3 = q(i, i2) ? 0 + this.cp : 0;
            if ((this.rv & 4) <= 0) {
                return i3;
            }
            i4 = this.cp;
        }
        return i3 + i4;
    }

    @Override // com.byazt.yx.n
    public void n(s sVar) {
        if (n()) {
            if ((this.tj & 4) > 0) {
                sVar.l += this.d;
                sVar.w += this.d;
                return;
            }
            return;
        }
        if ((this.rv & 4) > 0) {
            sVar.l += this.cp;
            sVar.w += this.cp;
        }
    }

    @Override // com.byazt.yx.n
    public int n(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.byazt.yx.n
    public int qg(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.byazt.yx.n
    public void n(View view, int i, int i2, s sVar) {
        if (q(i, i2)) {
            if (n()) {
                sVar.l += this.d;
                sVar.w += this.d;
            } else {
                sVar.l += this.cp;
                sVar.w += this.cp;
            }
        }
    }

    @Override // com.byazt.yx.n
    public void setFlexLines(List<s> list) {
        this.cy = list;
    }

    @Override // com.byazt.yx.n
    public List<s> getFlexLinesInternal() {
        return this.cy;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.x;
    }

    public Drawable getDividerDrawableVertical() {
        return this.fs;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.x) {
            return;
        }
        this.x = drawable;
        if (drawable != null) {
            this.cp = drawable.getIntrinsicHeight();
        } else {
            this.cp = 0;
        }
        qg();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.fs) {
            return;
        }
        this.fs = drawable;
        if (drawable != null) {
            this.d = drawable.getIntrinsicWidth();
        } else {
            this.d = 0;
        }
        qg();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.tj;
    }

    public int getShowDividerHorizontal() {
        return this.rv;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.tj) {
            this.tj = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.rv) {
            this.rv = i;
            requestLayout();
        }
    }

    private void qg() {
        if (this.x == null && this.fs == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean q(int i, int i2) {
        if (l(i, i2)) {
            if (n()) {
                return (this.tj & 1) != 0;
            }
            return (this.rv & 1) != 0;
        }
        if (n()) {
            return (this.tj & 2) != 0;
        }
        return (this.rv & 2) != 0;
    }

    private boolean l(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewS = s(i - i3);
            if (viewS != null && viewS.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean q(int i) {
        if (i >= 0 && i < this.cy.size()) {
            if (l(i)) {
                if (n()) {
                    return (this.rv & 1) != 0;
                }
                return (this.tj & 1) != 0;
            }
            if (n()) {
                return (this.rv & 2) != 0;
            }
            if ((this.tj & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean l(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.cy.get(i2).qg() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean w(int i) {
        if (i >= 0 && i < this.cy.size()) {
            for (int i2 = i + 1; i2 < this.cy.size(); i2++) {
                if (this.cy.get(i2).qg() > 0) {
                    return false;
                }
            }
            if (n()) {
                return (this.rv & 4) != 0;
            }
            if ((this.tj & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, 1755})
    public static class n extends ViewGroup.MarginLayoutParams implements qg {
        public static final Parcelable.Creator<n> CREATOR = new Parcelable.Creator<n>() { // from class: com.byazt.yx.FlexboxLayout.n.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public n createFromParcel(Parcel parcel) {
                return new n(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public n[] newArray(int i) {
                return new n[i];
            }
        };
        public int fs;
        public float l;
        public int n;
        public int q;
        public float qg;
        public int rv;
        public float s;
        public boolean tj;
        public int w;
        public int x;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public n(n nVar) {
            super((ViewGroup.MarginLayoutParams) nVar);
            this.n = 1;
            this.qg = 0.0f;
            this.s = 0.0f;
            this.q = -1;
            this.l = -1.0f;
            this.w = -1;
            this.x = -1;
            this.fs = ViewCompat.MEASURED_SIZE_MASK;
            this.rv = ViewCompat.MEASURED_SIZE_MASK;
            this.n = nVar.n;
            this.qg = nVar.qg;
            this.s = nVar.s;
            this.q = nVar.q;
            this.l = nVar.l;
            this.w = nVar.w;
            this.x = nVar.x;
            this.fs = nVar.fs;
            this.rv = nVar.rv;
            this.tj = nVar.tj;
        }

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.n = 1;
            this.qg = 0.0f;
            this.s = 0.0f;
            this.q = -1;
            this.l = -1.0f;
            this.w = -1;
            this.x = -1;
            this.fs = ViewCompat.MEASURED_SIZE_MASK;
            this.rv = ViewCompat.MEASURED_SIZE_MASK;
        }

        public n(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.n = 1;
            this.qg = 0.0f;
            this.s = 0.0f;
            this.q = -1;
            this.l = -1.0f;
            this.w = -1;
            this.x = -1;
            this.fs = ViewCompat.MEASURED_SIZE_MASK;
            this.rv = ViewCompat.MEASURED_SIZE_MASK;
        }

        public n(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.n = 1;
            this.qg = 0.0f;
            this.s = 0.0f;
            this.q = -1;
            this.l = -1.0f;
            this.w = -1;
            this.x = -1;
            this.fs = ViewCompat.MEASURED_SIZE_MASK;
            this.rv = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.byazt.yx.qg
        public int n() {
            return this.width;
        }

        @Override // com.byazt.yx.qg
        public int qg() {
            return this.height;
        }

        @Override // com.byazt.yx.qg
        public int s() {
            return this.n;
        }

        public void s(int i) {
            this.n = i;
        }

        @Override // com.byazt.yx.qg
        public float q() {
            return this.qg;
        }

        public void n(float f) {
            this.qg = f;
        }

        @Override // com.byazt.yx.qg
        public float l() {
            return this.s;
        }

        public void qg(float f) {
            this.s = f;
        }

        @Override // com.byazt.yx.qg
        public int w() {
            return this.q;
        }

        public void q(int i) {
            this.q = i;
        }

        @Override // com.byazt.yx.qg
        public int x() {
            return this.w;
        }

        @Override // com.byazt.yx.qg
        public void n(int i) {
            this.w = i;
        }

        @Override // com.byazt.yx.qg
        public int fs() {
            return this.x;
        }

        @Override // com.byazt.yx.qg
        public void qg(int i) {
            this.x = i;
        }

        @Override // com.byazt.yx.qg
        public int rv() {
            return this.fs;
        }

        @Override // com.byazt.yx.qg
        public int tj() {
            return this.rv;
        }

        @Override // com.byazt.yx.qg
        public boolean cp() {
            return this.tj;
        }

        @Override // com.byazt.yx.qg
        public float d() {
            return this.l;
        }

        public void s(float f) {
            this.l = f;
        }

        @Override // com.byazt.yx.qg
        public int oa() {
            return this.leftMargin;
        }

        @Override // com.byazt.yx.qg
        public int sz() {
            return this.topMargin;
        }

        @Override // com.byazt.yx.qg
        public int k() {
            return this.rightMargin;
        }

        @Override // com.byazt.yx.qg
        public int cy() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.n);
            parcel.writeFloat(this.qg);
            parcel.writeFloat(this.s);
            parcel.writeInt(this.q);
            parcel.writeFloat(this.l);
            parcel.writeInt(this.w);
            parcel.writeInt(this.x);
            parcel.writeInt(this.fs);
            parcel.writeInt(this.rv);
            parcel.writeByte(this.tj ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        public n(Parcel parcel) {
            super(0, 0);
            this.n = 1;
            this.qg = 0.0f;
            this.s = 0.0f;
            this.q = -1;
            this.l = -1.0f;
            this.w = -1;
            this.x = -1;
            this.fs = ViewCompat.MEASURED_SIZE_MASK;
            this.rv = ViewCompat.MEASURED_SIZE_MASK;
            this.n = parcel.readInt();
            this.qg = parcel.readFloat();
            this.s = parcel.readFloat();
            this.q = parcel.readInt();
            this.l = parcel.readFloat();
            this.w = parcel.readInt();
            this.x = parcel.readInt();
            this.fs = parcel.readInt();
            this.rv = parcel.readInt();
            this.tj = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void n(com.byazt.ih.s sVar) {
        this.hd = sVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.gu.l lVar = this.hd;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.gu.l lVar = this.hd;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.gu.l lVar = this.hd;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.gu.l lVar = this.hd;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }
}
