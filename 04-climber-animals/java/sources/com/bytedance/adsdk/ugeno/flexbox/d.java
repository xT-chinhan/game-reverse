package com.bytedance.adsdk.ugeno.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.adsdk.ugeno.c.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
class d {
    static final /* synthetic */ boolean ah = true;
    private long[] c;
    private final com.bytedance.adsdk.ugeno.flexbox.ms d;
    private boolean[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int[] f356ms;
    long[] xr;

    int ms(long j) {
        return (int) j;
    }

    int xr(long j) {
        return (int) (j >> 32);
    }

    long xr(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    d(com.bytedance.adsdk.ugeno.flexbox.ms msVar) {
        this.d = msVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] ms(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.d.getFlexItemCount();
        List<xr> listXr = xr(flexItemCount);
        xr xrVar = new xr();
        if (view != null && (layoutParams instanceof com.bytedance.adsdk.ugeno.flexbox.xr)) {
            xrVar.xr = ((com.bytedance.adsdk.ugeno.flexbox.xr) layoutParams).ah();
        } else {
            xrVar.xr = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.d.getFlexItemCount()) {
            xrVar.f358ms = i;
            while (i < flexItemCount) {
                listXr.get(i).f358ms++;
                i++;
            }
        } else {
            xrVar.f358ms = flexItemCount;
        }
        listXr.add(xrVar);
        return ms(flexItemCount + 1, listXr, sparseIntArray);
    }

    int[] ms(SparseIntArray sparseIntArray) {
        int flexItemCount = this.d.getFlexItemCount();
        return ms(flexItemCount, xr(flexItemCount), sparseIntArray);
    }

    private List<xr> xr(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) this.d.ms(i2).getLayoutParams();
            xr xrVar2 = new xr();
            xrVar2.xr = xrVar.ah();
            xrVar2.f358ms = i2;
            arrayList.add(xrVar2);
        }
        return arrayList;
    }

    boolean xr(SparseIntArray sparseIntArray) {
        int flexItemCount = this.d.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewMs = this.d.ms(i);
            if (viewMs != null && ((com.bytedance.adsdk.ugeno.flexbox.xr) viewMs.getLayoutParams()).ah() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] ms(int i, List<xr> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (xr xrVar : list) {
            iArr[i2] = xrVar.f358ms;
            sparseIntArray.append(xrVar.f358ms, xrVar.xr);
            i2++;
        }
        return iArr;
    }

    void ms(ms msVar, int i, int i2) {
        ms(msVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<ah>) null);
    }

    void xr(ms msVar, int i, int i2) {
        ms(msVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<ah>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void ms(ms msVar, int i, int i2, int i3, int i4, int i5, List<ah> list) {
        int i6;
        int i7;
        List<ah> list2;
        int i8;
        View view;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = i2;
        int i16 = i5;
        boolean zMs = this.d.ms();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<ah> arrayList = list == null ? new ArrayList() : list;
        msVar.f357ms = arrayList;
        int i17 = i16 == -1 ? 1 : 0;
        int iMs = ms(zMs);
        int iXr = xr(zMs);
        int iAh = ah(zMs);
        int iD = d(zMs);
        ah ahVar = new ah();
        int i18 = i4;
        ahVar.ub = i18;
        int i19 = iXr + iMs;
        ahVar.ka = i19;
        int flexItemCount = this.d.getFlexItemCount();
        int i20 = i17;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        int iCombineMeasuredStates = 0;
        int i23 = 0;
        while (i18 < flexItemCount) {
            View viewXr = this.d.xr(i18);
            if (viewXr == null) {
                if (ms(i18, flexItemCount, ahVar)) {
                    ms(arrayList, ahVar, i18, i22);
                }
            } else {
                if (viewXr.getVisibility() == 8) {
                    ahVar.ny++;
                    ahVar.x++;
                    if (ms(i18, flexItemCount, ahVar)) {
                        ms(arrayList, ahVar, i18, i22);
                    }
                } else {
                    if (viewXr instanceof CompoundButton) {
                        ms((CompoundButton) viewXr);
                    }
                    com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) viewXr.getLayoutParams();
                    int i24 = flexItemCount;
                    if (xrVar.c() == 4) {
                        ahVar.u.add(Integer.valueOf(i18));
                    }
                    int iMs2 = ms(xrVar, zMs);
                    if (xrVar.sl() != -1.0f && mode == 1073741824) {
                        iMs2 = Math.round(size * xrVar.sl());
                    }
                    if (zMs) {
                        int iMs3 = this.d.ms(i, i19 + ah(xrVar, true) + d(xrVar, true), iMs2);
                        int iXr2 = this.d.xr(i15, iAh + iD + ka(xrVar, true) + c(xrVar, true) + i22, xr(xrVar, true));
                        viewXr.measure(iMs3, iXr2);
                        ms(i18, iMs3, iXr2, viewXr);
                        i7 = iMs3;
                    } else {
                        int iMs4 = this.d.ms(i15, iAh + iD + ka(xrVar, false) + c(xrVar, false) + i22, xr(xrVar, false));
                        int iXr3 = this.d.xr(i, ah(xrVar, false) + i19 + d(xrVar, false), iMs2);
                        viewXr.measure(iMs4, iXr3);
                        ms(i18, iMs4, iXr3, viewXr);
                        i7 = iXr3;
                    }
                    ms(viewXr, i18);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewXr.getMeasuredState());
                    int i25 = ahVar.ka;
                    int i26 = i22;
                    int i27 = i19;
                    ah ahVar2 = ahVar;
                    int i28 = size;
                    int i29 = i18;
                    list2 = arrayList;
                    int i30 = i7;
                    if (ms(viewXr, mode, i28, i25, d(xrVar, zMs) + ms(viewXr, zMs) + ah(xrVar, zMs), xrVar, i29, i23, arrayList.size())) {
                        if (ahVar2.xr() > 0) {
                            ms(list2, ahVar2, i29 > 0 ? i29 - 1 : 0, i26);
                            i22 = ahVar2.ab + i26;
                        } else {
                            i22 = i26;
                        }
                        if (zMs) {
                            if (xrVar.xr() == -1) {
                                com.bytedance.adsdk.ugeno.flexbox.ms msVar2 = this.d;
                                i8 = i2;
                                i18 = i29;
                                view = viewXr;
                                view.measure(i30, msVar2.xr(i8, msVar2.getPaddingTop() + this.d.getPaddingBottom() + xrVar.u() + xrVar.ao() + i22, xrVar.xr()));
                                ms(view, i18);
                            } else {
                                i8 = i2;
                                view = viewXr;
                                i18 = i29;
                            }
                        } else {
                            i8 = i2;
                            view = viewXr;
                            i18 = i29;
                            if (xrVar.ms() == -1) {
                                com.bytedance.adsdk.ugeno.flexbox.ms msVar3 = this.d;
                                view.measure(msVar3.ms(i8, msVar3.getPaddingLeft() + this.d.getPaddingRight() + xrVar.zb() + xrVar.ub() + i22, xrVar.ms()), i30);
                                ms(view, i18);
                            }
                        }
                        ahVar = new ah();
                        i10 = 1;
                        ahVar.x = 1;
                        i9 = i27;
                        ahVar.ka = i9;
                        ahVar.ub = i18;
                        i12 = Integer.MIN_VALUE;
                        i11 = 0;
                    } else {
                        i8 = i2;
                        view = viewXr;
                        i18 = i29;
                        ahVar = ahVar2;
                        i9 = i27;
                        i10 = 1;
                        ahVar.x++;
                        i11 = i23 + 1;
                        i22 = i26;
                        i12 = i21;
                    }
                    ahVar.h = (ahVar.h ? 1 : 0) | (xrVar.d() != 0.0f ? i10 : 0);
                    ahVar.qv = (ahVar.qv ? 1 : 0) | (xrVar.ka() != 0.0f ? i10 : 0);
                    int[] iArr = this.f356ms;
                    if (iArr != null) {
                        iArr[i18] = list2.size();
                    }
                    ahVar.ka += ms(view, zMs) + ah(xrVar, zMs) + d(xrVar, zMs);
                    ahVar.ch += xrVar.d();
                    ahVar.hi += xrVar.ka();
                    this.d.ms(view, i18, i11, ahVar);
                    int iMax = Math.max(i12, xr(view, zMs) + ka(xrVar, zMs) + c(xrVar, zMs) + this.d.ms(view));
                    ahVar.ab = Math.max(ahVar.ab, iMax);
                    if (zMs) {
                        if (this.d.getFlexWrap() != 2) {
                            ahVar.sl = Math.max(ahVar.sl, view.getBaseline() + xrVar.u());
                        } else {
                            ahVar.sl = Math.max(ahVar.sl, (view.getMeasuredHeight() - view.getBaseline()) + xrVar.ao());
                        }
                    }
                    i13 = i24;
                    if (ms(i18, i13, ahVar)) {
                        ms(list2, ahVar, i18, i22);
                        i22 += ahVar.ab;
                    }
                    i14 = i5;
                    if (i14 != -1 && list2.size() > 0 && list2.get(list2.size() - i10).ao >= i14 && i18 >= i14 && i20 == 0) {
                        i22 = -ahVar.ms();
                        i20 = i10;
                    }
                    if (i22 > i3 && i20 != 0) {
                        i6 = iCombineMeasuredStates;
                        msVar.xr = i6;
                    } else {
                        i23 = i11;
                        i21 = iMax;
                    }
                }
                i18++;
                flexItemCount = i13;
                i15 = i8;
                i19 = i9;
                arrayList = list2;
                size = size;
                i16 = i14;
                mode = mode;
            }
            size = size;
            mode = mode;
            i8 = i15;
            i14 = i16;
            list2 = arrayList;
            i9 = i19;
            i13 = flexItemCount;
            i18++;
            flexItemCount = i13;
            i15 = i8;
            i19 = i9;
            arrayList = list2;
            size = size;
            i16 = i14;
            mode = mode;
        }
        i6 = iCombineMeasuredStates;
        msVar.xr = i6;
    }

    private void ms(CompoundButton compoundButton) {
        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) compoundButton.getLayoutParams();
        int iAb = xrVar.ab();
        int iX = xrVar.x();
        Drawable drawableMs = com.bytedance.adsdk.ugeno.c.ka.ms(compoundButton);
        int minimumWidth = drawableMs == null ? 0 : drawableMs.getMinimumWidth();
        int minimumHeight = drawableMs != null ? drawableMs.getMinimumHeight() : 0;
        if (iAb == -1) {
            iAb = minimumWidth;
        }
        xrVar.ms(iAb);
        if (iX == -1) {
            iX = minimumHeight;
        }
        xrVar.xr(iX);
    }

    private int ms(boolean z) {
        if (z) {
            return this.d.getPaddingStart();
        }
        return this.d.getPaddingTop();
    }

    private int xr(boolean z) {
        if (z) {
            return this.d.getPaddingEnd();
        }
        return this.d.getPaddingBottom();
    }

    private int ah(boolean z) {
        if (z) {
            return this.d.getPaddingTop();
        }
        return this.d.getPaddingStart();
    }

    private int d(boolean z) {
        if (z) {
            return this.d.getPaddingBottom();
        }
        return this.d.getPaddingEnd();
    }

    private int ms(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int xr(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int ms(com.bytedance.adsdk.ugeno.flexbox.xr xrVar, boolean z) {
        if (z) {
            return xrVar.ms();
        }
        return xrVar.xr();
    }

    private int xr(com.bytedance.adsdk.ugeno.flexbox.xr xrVar, boolean z) {
        if (z) {
            return xrVar.xr();
        }
        return xrVar.ms();
    }

    private int ah(com.bytedance.adsdk.ugeno.flexbox.xr xrVar, boolean z) {
        if (z) {
            return xrVar.zb();
        }
        return xrVar.u();
    }

    private int d(com.bytedance.adsdk.ugeno.flexbox.xr xrVar, boolean z) {
        if (z) {
            return xrVar.ub();
        }
        return xrVar.ao();
    }

    private int ka(com.bytedance.adsdk.ugeno.flexbox.xr xrVar, boolean z) {
        if (z) {
            return xrVar.u();
        }
        return xrVar.zb();
    }

    private int c(com.bytedance.adsdk.ugeno.flexbox.xr xrVar, boolean z) {
        if (z) {
            return xrVar.ao();
        }
        return xrVar.ub();
    }

    private boolean ms(View view, int i, int i2, int i3, int i4, com.bytedance.adsdk.ugeno.flexbox.xr xrVar, int i5, int i6, int i7) {
        if (this.d.getFlexWrap() == 0) {
            return false;
        }
        if (xrVar.hi()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.d.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iMs = this.d.ms(view, i5, i6);
        if (iMs > 0) {
            i4 += iMs;
        }
        return i2 < i3 + i4;
    }

    private boolean ms(int i, int i2, ah ahVar) {
        return i == i2 - 1 && ahVar.xr() != 0;
    }

    private void ms(List<ah> list, ah ahVar, int i, int i2) {
        ahVar.zb = i2;
        this.d.ms(ahVar);
        ahVar.ao = i;
        list.add(ahVar);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void ms(View view, int i) {
        boolean z;
        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < xrVar.ab()) {
            measuredWidth = xrVar.ab();
        } else {
            if (measuredWidth > xrVar.ny()) {
                measuredWidth = xrVar.ny();
            } else {
                z = false;
            }
            if (measuredHeight < xrVar.x()) {
                measuredHeight = xrVar.x();
            } else if (measuredHeight > xrVar.ch()) {
                measuredHeight = xrVar.ch();
            } else {
                z2 = z;
            }
            if (z2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                ms(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
            }
        }
        z = true;
        if (measuredHeight < xrVar.x()) {
            measuredHeight = xrVar.x();
        } else if (measuredHeight > xrVar.ch()) {
            measuredHeight = xrVar.ch();
        } else {
            z2 = z;
        }
        if (z2) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            ms(i, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
        }
    }

    void ms(int i, int i2) {
        ms(i, i2, 0);
    }

    void ms(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        ah(this.d.getFlexItemCount());
        if (i3 >= this.d.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.d.getFlexDirection();
        int flexDirection2 = this.d.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.d.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.d.getPaddingLeft();
            paddingRight = this.d.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.d.getLargestMainSize();
            }
            paddingLeft = this.d.getPaddingTop();
            paddingRight = this.d.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.f356ms;
        List<ah> flexLinesInternal = this.d.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            ah ahVar = flexLinesInternal.get(i5);
            if (ahVar.ka < size && ahVar.h) {
                ms(i, i2, ahVar, size, i4, false);
            } else if (ahVar.ka > size && ahVar.qv) {
                xr(i, i2, ahVar, size, i4, false);
            }
        }
    }

    private void ah(int i) {
        boolean[] zArr = this.ka;
        if (zArr == null) {
            this.ka = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.ka = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void ms(int i, int i2, ah ahVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        double d;
        int i6;
        double d2;
        float f = 0.0f;
        if (ahVar.ch <= 0.0f || i3 < ahVar.ka) {
            return;
        }
        int i7 = ahVar.ka;
        float f2 = (i3 - ahVar.ka) / ahVar.ch;
        ahVar.ka = i4 + ahVar.c;
        if (!z) {
            ahVar.ab = Integer.MIN_VALUE;
        }
        int i8 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i9 = 0;
        while (i8 < ahVar.x) {
            int i10 = ahVar.ub + i8;
            View viewXr = this.d.xr(i10);
            if (viewXr == null || viewXr.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) viewXr.getLayoutParams();
                int flexDirection = this.d.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i7;
                    int measuredWidth = viewXr.getMeasuredWidth();
                    long[] jArr = this.c;
                    if (jArr != null) {
                        measuredWidth = ms(jArr[i10]);
                    }
                    int measuredHeight = viewXr.getMeasuredHeight();
                    long[] jArr2 = this.c;
                    i5 = i11;
                    if (jArr2 != null) {
                        measuredHeight = xr(jArr2[i10]);
                    }
                    if (!this.ka[i10] && xrVar.d() > 0.0f) {
                        float fD = measuredWidth + (xrVar.d() * f2);
                        if (i8 == ahVar.x - 1) {
                            fD += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fD);
                        if (iRound > xrVar.ny()) {
                            iRound = xrVar.ny();
                            this.ka[i10] = true;
                            ahVar.ch -= xrVar.d();
                            z2 = true;
                        } else {
                            f3 += fD - iRound;
                            double d3 = f3;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f3 = (float) d;
                        }
                        int iXr = xr(i2, xrVar, ahVar.zb);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewXr.measure(iMakeMeasureSpec, iXr);
                        int measuredWidth2 = viewXr.getMeasuredWidth();
                        int measuredHeight2 = viewXr.getMeasuredHeight();
                        ms(i10, iMakeMeasureSpec, iXr, viewXr);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + xrVar.u() + xrVar.ao() + this.d.ms(viewXr));
                    ahVar.ka += measuredWidth + xrVar.zb() + xrVar.ub();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewXr.getMeasuredHeight();
                    long[] jArr3 = this.c;
                    if (jArr3 != null) {
                        measuredHeight3 = xr(jArr3[i10]);
                    }
                    int measuredWidth3 = viewXr.getMeasuredWidth();
                    long[] jArr4 = this.c;
                    if (jArr4 != null) {
                        measuredWidth3 = ms(jArr4[i10]);
                    }
                    if (this.ka[i10] || xrVar.d() <= f) {
                        i6 = i7;
                    } else {
                        float fD2 = measuredHeight3 + (xrVar.d() * f2);
                        if (i8 == ahVar.x - 1) {
                            fD2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fD2);
                        if (iRound2 > xrVar.ch()) {
                            iRound2 = xrVar.ch();
                            this.ka[i10] = true;
                            ahVar.ch -= xrVar.d();
                            i6 = i7;
                            z2 = true;
                        } else {
                            f3 += fD2 - iRound2;
                            i6 = i7;
                            double d4 = f3;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f3 = (float) d2;
                        }
                        int iMs = ms(i, xrVar, ahVar.zb);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewXr.measure(iMs, iMakeMeasureSpec2);
                        measuredWidth3 = viewXr.getMeasuredWidth();
                        int measuredHeight4 = viewXr.getMeasuredHeight();
                        ms(i10, iMs, iMakeMeasureSpec2, viewXr);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + xrVar.zb() + xrVar.ub() + this.d.ms(viewXr));
                    ahVar.ka += measuredHeight3 + xrVar.u() + xrVar.ao();
                    i5 = i6;
                }
                ahVar.ab = Math.max(ahVar.ab, iMax);
                i9 = iMax;
            }
            i8++;
            i7 = i5;
            f = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == ahVar.ka) {
            return;
        }
        ms(i, i2, ahVar, i3, i4, true);
    }

    private void xr(int i, int i2, ah ahVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        int i6 = ahVar.ka;
        float f = 0.0f;
        if (ahVar.hi <= 0.0f || i3 > ahVar.ka) {
            return;
        }
        float f2 = (ahVar.ka - i3) / ahVar.hi;
        ahVar.ka = i4 + ahVar.c;
        if (!z) {
            ahVar.ab = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i8 = 0;
        while (i7 < ahVar.x) {
            int i9 = ahVar.ub + i7;
            View viewXr = this.d.xr(i9);
            if (viewXr == null || viewXr.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) viewXr.getLayoutParams();
                int flexDirection = this.d.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int measuredWidth = viewXr.getMeasuredWidth();
                    long[] jArr = this.c;
                    if (jArr != null) {
                        measuredWidth = ms(jArr[i9]);
                    }
                    int measuredHeight = viewXr.getMeasuredHeight();
                    long[] jArr2 = this.c;
                    if (jArr2 != null) {
                        measuredHeight = xr(jArr2[i9]);
                    }
                    if (!this.ka[i9] && xrVar.ka() > 0.0f) {
                        float fKa = measuredWidth - (xrVar.ka() * f2);
                        if (i5 == ahVar.x - 1) {
                            fKa += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fKa);
                        if (iRound < xrVar.ab()) {
                            iRound = xrVar.ab();
                            this.ka[i9] = true;
                            ahVar.hi -= xrVar.ka();
                            z2 = true;
                        } else {
                            f3 += fKa - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int iXr = xr(i2, xrVar, ahVar.zb);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewXr.measure(iMakeMeasureSpec, iXr);
                        int measuredWidth2 = viewXr.getMeasuredWidth();
                        int measuredHeight2 = viewXr.getMeasuredHeight();
                        ms(i9, iMakeMeasureSpec, iXr, viewXr);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + xrVar.u() + xrVar.ao() + this.d.ms(viewXr));
                    ahVar.ka += measuredWidth + xrVar.zb() + xrVar.ub();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewXr.getMeasuredHeight();
                    long[] jArr3 = this.c;
                    if (jArr3 != null) {
                        measuredHeight3 = xr(jArr3[i9]);
                    }
                    int measuredWidth3 = viewXr.getMeasuredWidth();
                    long[] jArr4 = this.c;
                    if (jArr4 != null) {
                        measuredWidth3 = ms(jArr4[i9]);
                    }
                    if (this.ka[i9] || xrVar.ka() <= f) {
                        i5 = i7;
                    } else {
                        float fKa2 = measuredHeight3 - (xrVar.ka() * f2);
                        if (i7 == ahVar.x - 1) {
                            fKa2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fKa2);
                        if (iRound2 < xrVar.x()) {
                            iRound2 = xrVar.x();
                            this.ka[i9] = true;
                            ahVar.hi -= xrVar.ka();
                            i5 = i7;
                            z2 = true;
                        } else {
                            f3 += fKa2 - iRound2;
                            i5 = i7;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f3 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f3 += 1.0f;
                            }
                        }
                        int iMs = ms(i, xrVar, ahVar.zb);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewXr.measure(iMs, iMakeMeasureSpec2);
                        measuredWidth3 = viewXr.getMeasuredWidth();
                        int measuredHeight4 = viewXr.getMeasuredHeight();
                        ms(i9, iMs, iMakeMeasureSpec2, viewXr);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + xrVar.zb() + xrVar.ub() + this.d.ms(viewXr));
                    ahVar.ka += measuredHeight3 + xrVar.u() + xrVar.ao();
                }
                ahVar.ab = Math.max(ahVar.ab, iMax);
                i8 = iMax;
            }
            i7 = i5 + 1;
            f = 0.0f;
        }
        if (!z2 || i6 == ahVar.ka) {
            return;
        }
        xr(i, i2, ahVar, i3, i4, true);
    }

    private int ms(int i, com.bytedance.adsdk.ugeno.flexbox.xr xrVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.ms msVar = this.d;
        int iMs = msVar.ms(i, msVar.getPaddingLeft() + this.d.getPaddingRight() + xrVar.zb() + xrVar.ub() + i2, xrVar.ms());
        int size = View.MeasureSpec.getSize(iMs);
        if (size > xrVar.ny()) {
            return View.MeasureSpec.makeMeasureSpec(xrVar.ny(), View.MeasureSpec.getMode(iMs));
        }
        return size < xrVar.ab() ? View.MeasureSpec.makeMeasureSpec(xrVar.ab(), View.MeasureSpec.getMode(iMs)) : iMs;
    }

    private int xr(int i, com.bytedance.adsdk.ugeno.flexbox.xr xrVar, int i2) {
        com.bytedance.adsdk.ugeno.flexbox.ms msVar = this.d;
        int iXr = msVar.xr(i, msVar.getPaddingTop() + this.d.getPaddingBottom() + xrVar.u() + xrVar.ao() + i2, xrVar.xr());
        int size = View.MeasureSpec.getSize(iXr);
        if (size > xrVar.ch()) {
            return View.MeasureSpec.makeMeasureSpec(xrVar.ch(), View.MeasureSpec.getMode(iXr));
        }
        return size < xrVar.x() ? View.MeasureSpec.makeMeasureSpec(xrVar.x(), View.MeasureSpec.getMode(iXr)) : iXr;
    }

    void xr(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.d.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<ah> flexLinesInternal = this.d.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.d.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).ab = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.d.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    ah ahVar = new ah();
                    ahVar.ab = i5;
                    flexLinesInternal.add(0, ahVar);
                    return;
                }
                if (alignContent == 2) {
                    this.d.setFlexLines(ms(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize < size) {
                        float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        ArrayList arrayList = new ArrayList();
                        int size4 = flexLinesInternal.size();
                        float f = 0.0f;
                        while (i4 < size4) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                ah ahVar2 = new ah();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    ahVar2.ab = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    ahVar2.ab = Math.round(size3);
                                }
                                f += size3 - ahVar2.ab;
                                if (f > 1.0f) {
                                    ahVar2.ab++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    ahVar2.ab--;
                                    f += 1.0f;
                                }
                                arrayList.add(ahVar2);
                            }
                            i4++;
                        }
                        this.d.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.d.setFlexLines(ms(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    ah ahVar3 = new ah();
                    ahVar3.ab = size5;
                    for (ah ahVar4 : flexLinesInternal) {
                        arrayList2.add(ahVar3);
                        arrayList2.add(ahVar4);
                        arrayList2.add(ahVar3);
                    }
                    this.d.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        ah ahVar5 = flexLinesInternal.get(i4);
                        float f3 = ahVar5.ab + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f3 += f2;
                            f2 = 0.0f;
                        }
                        int iRound = Math.round(f3);
                        f2 += f3 - iRound;
                        if (f2 > 1.0f) {
                            iRound++;
                            f2 -= 1.0f;
                        } else if (f2 < -1.0f) {
                            iRound--;
                            f2 += 1.0f;
                        }
                        ahVar5.ab = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<ah> ms(List<ah> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        ah ahVar = new ah();
        ahVar.ab = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(ahVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(ahVar);
            }
        }
        return arrayList;
    }

    void ms() {
        ms(0);
    }

    void ms(int i) {
        View viewXr;
        if (i >= this.d.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.d.getFlexDirection();
        if (this.d.getAlignItems() == 4) {
            int[] iArr = this.f356ms;
            List<ah> flexLinesInternal = this.d.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                ah ahVar = flexLinesInternal.get(i2);
                int i3 = ahVar.x;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = ahVar.ub + i4;
                    if (i4 < this.d.getFlexItemCount() && (viewXr = this.d.xr(i5)) != null && viewXr.getVisibility() != 8) {
                        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) viewXr.getLayoutParams();
                        if (xrVar.c() == -1 || xrVar.c() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                ms(viewXr, ahVar.ab, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                xr(viewXr, ahVar.ab, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (ah ahVar2 : this.d.getFlexLinesInternal()) {
            for (Integer num : ahVar2.u) {
                View viewXr2 = this.d.xr(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    ms(viewXr2, ahVar2.ab, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    xr(viewXr2, ahVar2.ab, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void ms(View view, int i, int i2) {
        int measuredWidth;
        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - xrVar.u()) - xrVar.ao()) - this.d.ms(view), xrVar.x()), xrVar.ch());
        long[] jArr = this.c;
        if (jArr != null) {
            measuredWidth = ms(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        ms(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void xr(View view, int i, int i2) {
        int measuredHeight;
        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - xrVar.zb()) - xrVar.ub()) - this.d.ms(view), xrVar.ab()), xrVar.ny());
        long[] jArr = this.c;
        if (jArr != null) {
            measuredHeight = xr(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        ms(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    void ms(View view, ah ahVar, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) view.getLayoutParams();
        int alignItems = this.d.getAlignItems();
        if (xrVar.c() != -1) {
            alignItems = xrVar.c();
        }
        int i5 = ahVar.ab;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.d.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - xrVar.ao(), i3, i6 - xrVar.ao());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + xrVar.u(), i3, (i4 - i5) + view.getMeasuredHeight() + xrVar.u());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + xrVar.u()) - xrVar.ao()) / 2;
                if (this.d.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.d.getFlexWrap() != 2) {
                    int iMax = Math.max(ahVar.sl - view.getBaseline(), xrVar.u());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((ahVar.sl - view.getMeasuredHeight()) + view.getBaseline(), xrVar.ao());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.d.getFlexWrap() != 2) {
            view.layout(i, i2 + xrVar.u(), i3, i4 + xrVar.u());
        } else {
            view.layout(i, i2 - xrVar.ao(), i3, i4 - xrVar.ao());
        }
    }

    void ms(View view, ah ahVar, boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.flexbox.xr xrVar = (com.bytedance.adsdk.ugeno.flexbox.xr) view.getLayoutParams();
        int alignItems = this.d.getAlignItems();
        if (xrVar.c() != -1) {
            alignItems = xrVar.c();
        }
        int i5 = ahVar.ab;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - xrVar.ub(), i2, ((i3 + i5) - view.getMeasuredWidth()) - xrVar.ub(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + xrVar.zb(), i2, (i3 - i5) + view.getMeasuredWidth() + xrVar.zb(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + c.ms(marginLayoutParams)) - c.xr(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + xrVar.zb(), i2, i3 + xrVar.zb(), i4);
        } else {
            view.layout(i - xrVar.ub(), i2, i3 - xrVar.ub(), i4);
        }
    }

    private void ms(int i, int i2, int i3, View view) {
        long[] jArr = this.xr;
        if (jArr != null) {
            jArr[i] = xr(i2, i3);
        }
        long[] jArr2 = this.c;
        if (jArr2 != null) {
            jArr2[i] = xr(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private static class xr implements Comparable<xr> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        int f358ms;
        int xr;

        private xr() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compareTo(xr xrVar) {
            int i = this.xr;
            int i2 = xrVar.xr;
            return i != i2 ? i - i2 : this.f358ms - xrVar.f358ms;
        }

        public String toString() {
            return "Order{order=" + this.xr + ", index=" + this.f358ms + AbstractJsonLexerKt.END_OBJ;
        }
    }

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        List<ah> f357ms;
        int xr;

        ms() {
        }

        void ms() {
            this.f357ms = null;
            this.xr = 0;
        }
    }
}
