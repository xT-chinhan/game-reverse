package com.byazt.gqi;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.byazt.aa.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 600, 121})
public class x {
    public static final /* synthetic */ boolean hn = true;
    public boolean[] c;
    public long[] hw;
    public int[] pr;
    public long[] uc;
    public final com.byazt.gqi.pr x;

    public x(com.byazt.gqi.pr prVar) {
        this.x = prVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] pr(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.x.getFlexItemCount();
        List<hw> listHw = hw(flexItemCount);
        hw hwVar = new hw();
        if (view != null && (layoutParams instanceof com.byazt.gqi.hw)) {
            hwVar.hw = ((com.byazt.gqi.hw) layoutParams).hn();
        } else {
            hwVar.hw = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.x.getFlexItemCount()) {
            hwVar.pr = i;
            while (i < flexItemCount) {
                listHw.get(i).pr++;
                i++;
            }
        } else {
            hwVar.pr = flexItemCount;
        }
        listHw.add(hwVar);
        return pr(flexItemCount + 1, listHw, sparseIntArray);
    }

    public int[] pr(SparseIntArray sparseIntArray) {
        int flexItemCount = this.x.getFlexItemCount();
        return pr(flexItemCount, hw(flexItemCount), sparseIntArray);
    }

    private List<hw> hw(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) this.x.pr(i2).getLayoutParams();
            hw hwVar2 = new hw();
            hwVar2.hw = hwVar.hn();
            hwVar2.pr = i2;
            arrayList.add(hwVar2);
        }
        return arrayList;
    }

    public boolean hw(SparseIntArray sparseIntArray) {
        int flexItemCount = this.x.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewPr = this.x.pr(i);
            if (viewPr != null && ((com.byazt.gqi.hw) viewPr.getLayoutParams()).hn() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] pr(int i, List<hw> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (hw hwVar : list) {
            iArr[i2] = hwVar.pr;
            sparseIntArray.append(hwVar.pr, hwVar.hw);
            i2++;
        }
        return iArr;
    }

    public void pr(pr prVar, int i, int i2) {
        pr(prVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<hn>) null);
    }

    public void hw(pr prVar, int i, int i2) {
        pr(prVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<hn>) null);
    }

    public void pr(pr prVar, int i, int i2, int i3, int i4, int i5, List<hn> list) {
        List<hn> arrayList;
        int i6;
        int i7;
        List<hn> list2;
        int i8;
        View view;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = i2;
        int i15 = i5;
        boolean zPr = this.x.pr();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (list != null) {
            arrayList = list;
        } else {
            arrayList = new ArrayList();
        }
        prVar.pr = arrayList;
        boolean z = i15 == -1;
        int iPr = pr(zPr);
        int iHw = hw(zPr);
        int iHn = hn(zPr);
        int iX = x(zPr);
        hn hnVar = new hn();
        int i16 = i4;
        hnVar.ho = i16;
        int i17 = iHw + iPr;
        hnVar.c = i17;
        int flexItemCount = this.x.getFlexItemCount();
        boolean z2 = z;
        int i18 = Integer.MIN_VALUE;
        int i19 = 0;
        int iCombineMeasuredStates = 0;
        int i20 = 0;
        while (i16 < flexItemCount) {
            View viewHw = this.x.hw(i16);
            if (viewHw == null) {
                if (pr(i16, flexItemCount, hnVar)) {
                    pr(arrayList, hnVar, i16, i19);
                }
            } else {
                if (viewHw.getVisibility() == 8) {
                    hnVar.aj++;
                    hnVar.zo++;
                    if (pr(i16, flexItemCount, hnVar)) {
                        pr(arrayList, hnVar, i16, i19);
                    }
                } else {
                    if (viewHw instanceof CompoundButton) {
                        pr((CompoundButton) viewHw);
                    }
                    com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) viewHw.getLayoutParams();
                    int i21 = flexItemCount;
                    if (hwVar.uc() == 4) {
                        hnVar.g.add(Integer.valueOf(i16));
                    }
                    int iPr2 = pr(hwVar, zPr);
                    if (hwVar.k() != -1.0f && mode == 1073741824) {
                        iPr2 = Math.round(size * hwVar.k());
                    }
                    if (zPr) {
                        int iPr3 = this.x.pr(i, i17 + hn(hwVar, true) + x(hwVar, true), iPr2);
                        int iHw2 = this.x.hw(i14, iHn + iX + c(hwVar, true) + uc(hwVar, true) + i19, hw(hwVar, true));
                        viewHw.measure(iPr3, iHw2);
                        pr(i16, iPr3, iHw2, viewHw);
                        i7 = iPr3;
                    } else {
                        int iPr4 = this.x.pr(i14, iHn + iX + c(hwVar, false) + uc(hwVar, false) + i19, hw(hwVar, false));
                        int iHw3 = this.x.hw(i, hn(hwVar, false) + i17 + x(hwVar, false), iPr2);
                        viewHw.measure(iPr4, iHw3);
                        pr(i16, iPr4, iHw3, viewHw);
                        i7 = iHw3;
                    }
                    pr(viewHw, i16);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewHw.getMeasuredState());
                    int i22 = hnVar.c;
                    int i23 = i19;
                    int i24 = i17;
                    hn hnVar2 = hnVar;
                    int i25 = size;
                    int i26 = i16;
                    list2 = arrayList;
                    int i27 = i7;
                    if (pr(viewHw, mode, i25, i22, x(hwVar, zPr) + pr(viewHw, zPr) + hn(hwVar, zPr), hwVar, i26, i20, arrayList.size())) {
                        if (hnVar2.hw() > 0) {
                            pr(list2, hnVar2, i26 > 0 ? i26 - 1 : 0, i23);
                            i19 = hnVar2.fw + i23;
                        } else {
                            i19 = i23;
                        }
                        if (zPr) {
                            if (hwVar.hw() != -1) {
                                i8 = i2;
                                view = viewHw;
                                i16 = i26;
                            } else {
                                com.byazt.gqi.pr prVar2 = this.x;
                                i8 = i2;
                                i16 = i26;
                                view = viewHw;
                                view.measure(i27, prVar2.hw(i8, prVar2.getPaddingTop() + this.x.getPaddingBottom() + hwVar.g() + hwVar.nt() + i19, hwVar.hw()));
                                pr(view, i16);
                            }
                        } else {
                            i8 = i2;
                            view = viewHw;
                            i16 = i26;
                            if (hwVar.pr() == -1) {
                                com.byazt.gqi.pr prVar3 = this.x;
                                view.measure(prVar3.pr(i8, prVar3.getPaddingLeft() + this.x.getPaddingRight() + hwVar.m() + hwVar.ho() + i19, hwVar.pr()), i27);
                                pr(view, i16);
                            }
                        }
                        hnVar = new hn();
                        hnVar.zo = 1;
                        i9 = i24;
                        hnVar.c = i9;
                        hnVar.ho = i16;
                        i11 = Integer.MIN_VALUE;
                        i10 = 0;
                    } else {
                        i8 = i2;
                        view = viewHw;
                        i16 = i26;
                        hnVar = hnVar2;
                        i9 = i24;
                        hnVar.zo++;
                        i10 = i20 + 1;
                        i19 = i23;
                        i11 = i18;
                    }
                    hnVar.yb |= hwVar.x() != 0.0f;
                    hnVar.lb |= hwVar.c() != 0.0f;
                    int[] iArr = this.pr;
                    if (iArr != null) {
                        iArr[i16] = list2.size();
                    }
                    hnVar.c += pr(view, zPr) + hn(hwVar, zPr) + x(hwVar, zPr);
                    hnVar.vk += hwVar.x();
                    hnVar.w += hwVar.c();
                    this.x.pr(view, i16, i10, hnVar);
                    int iMax = Math.max(i11, hw(view, zPr) + c(hwVar, zPr) + uc(hwVar, zPr) + this.x.pr(view));
                    hnVar.fw = Math.max(hnVar.fw, iMax);
                    if (zPr) {
                        if (this.x.getFlexWrap() != 2) {
                            hnVar.k = Math.max(hnVar.k, view.getBaseline() + hwVar.g());
                        } else {
                            hnVar.k = Math.max(hnVar.k, (view.getMeasuredHeight() - view.getBaseline()) + hwVar.nt());
                        }
                    }
                    i12 = i21;
                    if (pr(i16, i12, hnVar)) {
                        pr(list2, hnVar, i16, i19);
                        i19 += hnVar.fw;
                    }
                    i13 = i5;
                    if (i13 != -1 && list2.size() > 0 && list2.get(list2.size() - 1).nt >= i13 && i16 >= i13 && !z2) {
                        i19 = -hnVar.pr();
                        z2 = true;
                    }
                    if (i19 <= i3 || !z2) {
                        i20 = i10;
                        i18 = iMax;
                    } else {
                        i6 = iCombineMeasuredStates;
                        prVar.hw = i6;
                    }
                }
                i16++;
                flexItemCount = i12;
                i14 = i8;
                i17 = i9;
                arrayList = list2;
                mode = mode;
                i15 = i13;
                size = size;
            }
            size = size;
            mode = mode;
            i8 = i14;
            i13 = i15;
            list2 = arrayList;
            i9 = i17;
            i12 = flexItemCount;
            i16++;
            flexItemCount = i12;
            i14 = i8;
            i17 = i9;
            arrayList = list2;
            mode = mode;
            i15 = i13;
            size = size;
        }
        i6 = iCombineMeasuredStates;
        prVar.hw = i6;
    }

    private void pr(CompoundButton compoundButton) {
        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) compoundButton.getLayoutParams();
        int iFw = hwVar.fw();
        int iZo = hwVar.zo();
        Drawable drawablePr = com.byazt.aa.c.pr(compoundButton);
        int minimumWidth = drawablePr == null ? 0 : drawablePr.getMinimumWidth();
        int minimumHeight = drawablePr != null ? drawablePr.getMinimumHeight() : 0;
        if (iFw == -1) {
            iFw = minimumWidth;
        }
        hwVar.pr(iFw);
        if (iZo == -1) {
            iZo = minimumHeight;
        }
        hwVar.hw(iZo);
    }

    private int pr(boolean z) {
        if (z) {
            return this.x.getPaddingStart();
        }
        return this.x.getPaddingTop();
    }

    private int hw(boolean z) {
        if (z) {
            return this.x.getPaddingEnd();
        }
        return this.x.getPaddingBottom();
    }

    private int hn(boolean z) {
        if (z) {
            return this.x.getPaddingTop();
        }
        return this.x.getPaddingStart();
    }

    private int x(boolean z) {
        if (z) {
            return this.x.getPaddingBottom();
        }
        return this.x.getPaddingEnd();
    }

    private int pr(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int hw(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int pr(com.byazt.gqi.hw hwVar, boolean z) {
        if (z) {
            return hwVar.pr();
        }
        return hwVar.hw();
    }

    private int hw(com.byazt.gqi.hw hwVar, boolean z) {
        if (z) {
            return hwVar.hw();
        }
        return hwVar.pr();
    }

    private int hn(com.byazt.gqi.hw hwVar, boolean z) {
        if (z) {
            return hwVar.m();
        }
        return hwVar.g();
    }

    private int x(com.byazt.gqi.hw hwVar, boolean z) {
        if (z) {
            return hwVar.ho();
        }
        return hwVar.nt();
    }

    private int c(com.byazt.gqi.hw hwVar, boolean z) {
        if (z) {
            return hwVar.g();
        }
        return hwVar.m();
    }

    private int uc(com.byazt.gqi.hw hwVar, boolean z) {
        if (z) {
            return hwVar.nt();
        }
        return hwVar.ho();
    }

    private boolean pr(View view, int i, int i2, int i3, int i4, com.byazt.gqi.hw hwVar, int i5, int i6, int i7) {
        if (this.x.getFlexWrap() == 0) {
            return false;
        }
        if (hwVar.w()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.x.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iPr = this.x.pr(view, i5, i6);
        if (iPr > 0) {
            i4 += iPr;
        }
        return i2 < i3 + i4;
    }

    private boolean pr(int i, int i2, hn hnVar) {
        return i == i2 - 1 && hnVar.hw() != 0;
    }

    private void pr(List<hn> list, hn hnVar, int i, int i2) {
        hnVar.m = i2;
        this.x.pr(hnVar);
        hnVar.nt = i;
        list.add(hnVar);
    }

    private void pr(View view, int i) {
        boolean z;
        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < hwVar.fw()) {
            measuredWidth = hwVar.fw();
            z = true;
        } else if (measuredWidth <= hwVar.aj()) {
            z = false;
        } else {
            measuredWidth = hwVar.aj();
            z = true;
        }
        if (measuredHeight < hwVar.zo()) {
            measuredHeight = hwVar.zo();
        } else if (measuredHeight <= hwVar.vk()) {
            z2 = z;
        } else {
            measuredHeight = hwVar.vk();
        }
        if (z2) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            pr(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        }
    }

    public void pr(int i, int i2) {
        pr(i, i2, 0);
    }

    public void pr(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        hn(this.x.getFlexItemCount());
        if (i3 >= this.x.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.x.getFlexDirection();
        switch (this.x.getFlexDirection()) {
            case 0:
            case 1:
                int mode = View.MeasureSpec.getMode(i);
                size = View.MeasureSpec.getSize(i);
                int largestMainSize = this.x.getLargestMainSize();
                if (mode != 1073741824) {
                    size = Math.min(largestMainSize, size);
                }
                paddingLeft = this.x.getPaddingLeft() + this.x.getPaddingRight();
                break;
            case 2:
            case 3:
                int mode2 = View.MeasureSpec.getMode(i2);
                size = View.MeasureSpec.getSize(i2);
                if (mode2 != 1073741824) {
                    size = this.x.getLargestMainSize();
                }
                paddingLeft = this.x.getPaddingTop() + this.x.getPaddingBottom();
                break;
            default:
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = 0;
        int[] iArr = this.pr;
        if (iArr != null) {
            i4 = iArr[i3];
        }
        List<hn> flexLinesInternal = this.x.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = i4; i5 < size2; i5++) {
            hn hnVar = flexLinesInternal.get(i5);
            if (hnVar.c < size && hnVar.yb) {
                pr(i, i2, hnVar, size, paddingLeft, false);
            } else if (hnVar.c > size && hnVar.lb) {
                hw(i, i2, hnVar, size, paddingLeft, false);
            }
        }
    }

    private void hn(int i) {
        boolean[] zArr = this.c;
        if (zArr == null) {
            this.c = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.c = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void pr(int i, int i2, hn hnVar, int i3, int i4, boolean z) {
        int iMax;
        float f = 0.0f;
        if (hnVar.vk <= 0.0f || i3 < hnVar.c) {
            return;
        }
        int i5 = hnVar.c;
        float f2 = (i3 - hnVar.c) / hnVar.vk;
        hnVar.c = i4 + hnVar.uc;
        if (!z) {
            hnVar.fw = Integer.MIN_VALUE;
        }
        int i6 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i7 = 0;
        while (i6 < hnVar.zo) {
            int i8 = hnVar.ho + i6;
            View viewHw = this.x.hw(i8);
            if (viewHw == null || viewHw.getVisibility() == 8) {
                f2 = f2;
            } else {
                com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) viewHw.getLayoutParams();
                int flexDirection = this.x.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = viewHw.getMeasuredWidth();
                    long[] jArr = this.uc;
                    if (jArr != null) {
                        measuredWidth = pr(jArr[i8]);
                    }
                    int measuredHeight = viewHw.getMeasuredHeight();
                    long[] jArr2 = this.uc;
                    if (jArr2 != null) {
                        measuredHeight = hw(jArr2[i8]);
                    }
                    if (!this.c[i8] && hwVar.x() > 0.0f) {
                        float fX = measuredWidth + (hwVar.x() * f2);
                        if (i6 == hnVar.zo - 1) {
                            fX += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fX);
                        if (iRound > hwVar.aj()) {
                            iRound = hwVar.aj();
                            z2 = true;
                            this.c[i8] = true;
                            hnVar.vk -= hwVar.x();
                        } else {
                            f3 += fX - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 = (float) (d - 1.0d);
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 = (float) (d + 1.0d);
                            }
                        }
                        int iHw = hw(i2, hwVar, hnVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewHw.measure(iMakeMeasureSpec, iHw);
                        int measuredWidth2 = viewHw.getMeasuredWidth();
                        int measuredHeight2 = viewHw.getMeasuredHeight();
                        pr(i8, iMakeMeasureSpec, iHw, viewHw);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i7, measuredHeight + hwVar.g() + hwVar.nt() + this.x.pr(viewHw));
                    hnVar.c += measuredWidth + hwVar.m() + hwVar.ho();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewHw.getMeasuredHeight();
                    long[] jArr3 = this.uc;
                    if (jArr3 != null) {
                        measuredHeight3 = hw(jArr3[i8]);
                    }
                    int measuredWidth3 = viewHw.getMeasuredWidth();
                    long[] jArr4 = this.uc;
                    if (jArr4 != null) {
                        measuredWidth3 = pr(jArr4[i8]);
                    }
                    if (this.c[i8] || hwVar.x() <= f) {
                        f2 = f2;
                    } else {
                        float fX2 = measuredHeight3 + (hwVar.x() * f2);
                        if (i6 == hnVar.zo - 1) {
                            fX2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fX2);
                        if (iRound2 > hwVar.vk()) {
                            iRound2 = hwVar.vk();
                            this.c[i8] = true;
                            hnVar.vk -= hwVar.x();
                            f2 = f2;
                            z2 = true;
                        } else {
                            f3 += fX2 - iRound2;
                            f2 = f2;
                            double d2 = f3;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f3 = (float) (d2 - 1.0d);
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f3 = (float) (d2 + 1.0d);
                            }
                        }
                        int iPr = pr(i, hwVar, hnVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewHw.measure(iPr, iMakeMeasureSpec2);
                        measuredWidth3 = viewHw.getMeasuredWidth();
                        int measuredHeight4 = viewHw.getMeasuredHeight();
                        pr(i8, iPr, iMakeMeasureSpec2, viewHw);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i7, measuredWidth3 + hwVar.m() + hwVar.ho() + this.x.pr(viewHw));
                    hnVar.c += measuredHeight3 + hwVar.g() + hwVar.nt();
                }
                hnVar.fw = Math.max(hnVar.fw, iMax);
                i7 = iMax;
            }
            i6++;
            f2 = f2;
            f = 0.0f;
        }
        if (z2 && i5 != hnVar.c) {
            pr(i, i2, hnVar, i3, i4, true);
        }
    }

    private void hw(int i, int i2, hn hnVar, int i3, int i4, boolean z) {
        float f;
        int iMax;
        hn hnVar2 = hnVar;
        int i5 = hnVar2.c;
        float f2 = 0.0f;
        if (hnVar2.w <= 0.0f || i3 > hnVar2.c) {
            return;
        }
        float f3 = (hnVar2.c - i3) / hnVar2.w;
        hnVar2.c = i4 + hnVar2.uc;
        if (!z) {
            hnVar2.fw = Integer.MIN_VALUE;
        }
        int i6 = 0;
        float f4 = 0.0f;
        boolean z2 = false;
        int i7 = 0;
        while (i6 < hnVar2.zo) {
            int i8 = hnVar2.ho + i6;
            View viewHw = this.x.hw(i8);
            if (viewHw == null || viewHw.getVisibility() == 8) {
                f = f3;
            } else {
                com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) viewHw.getLayoutParams();
                int flexDirection = this.x.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = viewHw.getMeasuredWidth();
                    long[] jArr = this.uc;
                    if (jArr != null) {
                        measuredWidth = pr(jArr[i8]);
                    }
                    int measuredHeight = viewHw.getMeasuredHeight();
                    long[] jArr2 = this.uc;
                    if (jArr2 != null) {
                        measuredHeight = hw(jArr2[i8]);
                    }
                    if (this.c[i8] || hwVar.c() <= 0.0f) {
                        f = f3;
                    } else {
                        float fC = measuredWidth - (hwVar.c() * f3);
                        if (i6 == hnVar2.zo - 1) {
                            fC += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fC);
                        if (iRound < hwVar.fw()) {
                            iRound = hwVar.fw();
                            z2 = true;
                            this.c[i8] = true;
                            hnVar2.w -= hwVar.c();
                            f = f3;
                        } else {
                            f4 += fC - iRound;
                            f = f3;
                            double d = f4;
                            if (d > 1.0d) {
                                iRound++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f4 += 1.0f;
                            }
                        }
                        int iHw = hw(i2, hwVar, hnVar2.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewHw.measure(iMakeMeasureSpec, iHw);
                        int measuredWidth2 = viewHw.getMeasuredWidth();
                        int measuredHeight2 = viewHw.getMeasuredHeight();
                        pr(i8, iMakeMeasureSpec, iHw, viewHw);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i7, measuredHeight + hwVar.g() + hwVar.nt() + this.x.pr(viewHw));
                    hnVar2.c += measuredWidth + hwVar.m() + hwVar.ho();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewHw.getMeasuredHeight();
                    long[] jArr3 = this.uc;
                    if (jArr3 != null) {
                        measuredHeight3 = hw(jArr3[i8]);
                    }
                    int measuredWidth3 = viewHw.getMeasuredWidth();
                    long[] jArr4 = this.uc;
                    if (jArr4 != null) {
                        measuredWidth3 = pr(jArr4[i8]);
                    }
                    if (!this.c[i8] && hwVar.c() > f2) {
                        float fC2 = measuredHeight3 - (hwVar.c() * f3);
                        if (i6 == hnVar2.zo - 1) {
                            fC2 += f4;
                            f4 = f2;
                        }
                        int iRound2 = Math.round(fC2);
                        if (iRound2 < hwVar.zo()) {
                            iRound2 = hwVar.zo();
                            this.c[i8] = true;
                            hnVar2.w -= hwVar.c();
                            z2 = true;
                        } else {
                            f4 += fC2 - iRound2;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f4 += 1.0f;
                            }
                        }
                        hnVar2 = hnVar;
                        int iPr = pr(i, hwVar, hnVar2.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewHw.measure(iPr, iMakeMeasureSpec2);
                        int measuredWidth4 = viewHw.getMeasuredWidth();
                        int measuredHeight4 = viewHw.getMeasuredHeight();
                        pr(i8, iPr, iMakeMeasureSpec2, viewHw);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i7, measuredWidth3 + hwVar.m() + hwVar.ho() + this.x.pr(viewHw));
                    hnVar2.c += measuredHeight3 + hwVar.g() + hwVar.nt();
                    f = f3;
                }
                hnVar2.fw = Math.max(hnVar2.fw, iMax);
                i7 = iMax;
            }
            i6++;
            f3 = f;
            f2 = 0.0f;
        }
        if (z2 && i5 != hnVar2.c) {
            hw(i, i2, hnVar, i3, i4, true);
        }
    }

    private int pr(int i, com.byazt.gqi.hw hwVar, int i2) {
        com.byazt.gqi.pr prVar = this.x;
        int iPr = prVar.pr(i, prVar.getPaddingLeft() + this.x.getPaddingRight() + hwVar.m() + hwVar.ho() + i2, hwVar.pr());
        int size = View.MeasureSpec.getSize(iPr);
        if (size > hwVar.aj()) {
            return View.MeasureSpec.makeMeasureSpec(hwVar.aj(), View.MeasureSpec.getMode(iPr));
        }
        if (size < hwVar.fw()) {
            return View.MeasureSpec.makeMeasureSpec(hwVar.fw(), View.MeasureSpec.getMode(iPr));
        }
        return iPr;
    }

    private int hw(int i, com.byazt.gqi.hw hwVar, int i2) {
        com.byazt.gqi.pr prVar = this.x;
        int iHw = prVar.hw(i, prVar.getPaddingTop() + this.x.getPaddingBottom() + hwVar.g() + hwVar.nt() + i2, hwVar.hw());
        int size = View.MeasureSpec.getSize(iHw);
        if (size > hwVar.vk()) {
            return View.MeasureSpec.makeMeasureSpec(hwVar.vk(), View.MeasureSpec.getMode(iHw));
        }
        if (size < hwVar.zo()) {
            return View.MeasureSpec.makeMeasureSpec(hwVar.zo(), View.MeasureSpec.getMode(iHw));
        }
        return iHw;
    }

    public void hw(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.x.getFlexDirection();
        switch (flexDirection) {
            case 0:
            case 1:
                int mode2 = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                mode = mode2;
                size = size2;
                break;
            case 2:
            case 3:
                mode = View.MeasureSpec.getMode(i);
                size = View.MeasureSpec.getSize(i);
                break;
            default:
                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        List<hn> flexLinesInternal = this.x.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.x.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).fw = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                switch (this.x.getAlignContent()) {
                    case 1:
                        int i5 = size - sumOfCrossSize;
                        hn hnVar = new hn();
                        hnVar.fw = i5;
                        flexLinesInternal.add(0, hnVar);
                        return;
                    case 2:
                        this.x.setFlexLines(pr(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    case 3:
                        if (sumOfCrossSize < size) {
                            float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                            ArrayList arrayList = new ArrayList();
                            int size4 = flexLinesInternal.size();
                            float f = 0.0f;
                            while (i4 < size4) {
                                arrayList.add(flexLinesInternal.get(i4));
                                if (i4 != flexLinesInternal.size() - 1) {
                                    hn hnVar2 = new hn();
                                    if (i4 == flexLinesInternal.size() - 2) {
                                        hnVar2.fw = Math.round(f + size3);
                                        f = 0.0f;
                                    } else {
                                        hnVar2.fw = Math.round(size3);
                                    }
                                    f += size3 - hnVar2.fw;
                                    if (f > 1.0f) {
                                        hnVar2.fw++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        hnVar2.fw--;
                                        f += 1.0f;
                                    }
                                    arrayList.add(hnVar2);
                                }
                                i4++;
                            }
                            this.x.setFlexLines(arrayList);
                            return;
                        }
                        return;
                    case 4:
                        if (sumOfCrossSize >= size) {
                            this.x.setFlexLines(pr(flexLinesInternal, size, sumOfCrossSize));
                            return;
                        }
                        int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                        ArrayList arrayList2 = new ArrayList();
                        hn hnVar3 = new hn();
                        hnVar3.fw = size5;
                        for (hn hnVar4 : flexLinesInternal) {
                            arrayList2.add(hnVar3);
                            arrayList2.add(hnVar4);
                            arrayList2.add(hnVar3);
                        }
                        this.x.setFlexLines(arrayList2);
                        return;
                    case 5:
                        if (sumOfCrossSize < size) {
                            float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                            int size7 = flexLinesInternal.size();
                            float f2 = 0.0f;
                            while (i4 < size7) {
                                hn hnVar5 = flexLinesInternal.get(i4);
                                float f3 = hnVar5.fw + size6;
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
                                hnVar5.fw = iRound;
                                i4++;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private List<hn> pr(List<hn> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        hn hnVar = new hn();
        hnVar.fw = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(hnVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(hnVar);
            }
        }
        return arrayList;
    }

    public void pr() {
        pr(0);
    }

    public void pr(int i) {
        int i2;
        View viewHw;
        if (i >= this.x.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.x.getFlexDirection();
        if (this.x.getAlignItems() == 4) {
            int[] iArr = this.pr;
            if (iArr == null) {
                i2 = 0;
            } else {
                i2 = iArr[i];
            }
            List<hn> flexLinesInternal = this.x.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            while (i2 < size) {
                hn hnVar = flexLinesInternal.get(i2);
                int i3 = hnVar.zo;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = hnVar.ho + i4;
                    if (i4 < this.x.getFlexItemCount() && (viewHw = this.x.hw(i5)) != null && viewHw.getVisibility() != 8) {
                        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) viewHw.getLayoutParams();
                        if (hwVar.uc() == -1 || hwVar.uc() == 4) {
                            switch (flexDirection) {
                                case 0:
                                case 1:
                                    pr(viewHw, hnVar.fw, i5);
                                    break;
                                case 2:
                                case 3:
                                    hw(viewHw, hnVar.fw, i5);
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
                i2++;
            }
            return;
        }
        for (hn hnVar2 : this.x.getFlexLinesInternal()) {
            for (Integer num : hnVar2.g) {
                View viewHw2 = this.x.hw(num.intValue());
                switch (flexDirection) {
                    case 0:
                    case 1:
                        pr(viewHw2, hnVar2.fw, num.intValue());
                        break;
                    case 2:
                    case 3:
                        hw(viewHw2, hnVar2.fw, num.intValue());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void pr(View view, int i, int i2) {
        int measuredWidth;
        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - hwVar.g()) - hwVar.nt()) - this.x.pr(view), hwVar.zo()), hwVar.vk());
        long[] jArr = this.uc;
        if (jArr != null) {
            measuredWidth = pr(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        pr(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void hw(View view, int i, int i2) {
        int measuredHeight;
        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - hwVar.m()) - hwVar.ho()) - this.x.pr(view), hwVar.fw()), hwVar.aj());
        long[] jArr = this.uc;
        if (jArr != null) {
            measuredHeight = hw(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        pr(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    public void pr(View view, hn hnVar, int i, int i2, int i3, int i4) {
        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) view.getLayoutParams();
        int alignItems = this.x.getAlignItems();
        if (hwVar.uc() != -1) {
            alignItems = hwVar.uc();
        }
        int i5 = hnVar.fw;
        switch (alignItems) {
            case 0:
            case 4:
                if (this.x.getFlexWrap() != 2) {
                    view.layout(i, i2 + hwVar.g(), i3, i4 + hwVar.g());
                } else {
                    view.layout(i, i2 - hwVar.nt(), i3, i4 - hwVar.nt());
                }
                break;
            case 1:
                if (this.x.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - hwVar.nt(), i3, i6 - hwVar.nt());
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + hwVar.g(), i3, (i4 - i5) + view.getMeasuredHeight() + hwVar.g());
                }
                break;
            case 2:
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + hwVar.g()) - hwVar.nt()) / 2;
                if (this.x.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                }
                break;
            case 3:
                if (this.x.getFlexWrap() != 2) {
                    int iMax = Math.max(hnVar.k - view.getBaseline(), hwVar.g());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                } else {
                    int iMax2 = Math.max((hnVar.k - view.getMeasuredHeight()) + view.getBaseline(), hwVar.nt());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                }
                break;
        }
    }

    public void pr(View view, hn hnVar, boolean z, int i, int i2, int i3, int i4) {
        com.byazt.gqi.hw hwVar = (com.byazt.gqi.hw) view.getLayoutParams();
        int alignItems = this.x.getAlignItems();
        if (hwVar.uc() != -1) {
            alignItems = hwVar.uc();
        }
        int i5 = hnVar.fw;
        switch (alignItems) {
            case 0:
            case 3:
            case 4:
                if (!z) {
                    view.layout(i + hwVar.m(), i2, i3 + hwVar.m(), i4);
                } else {
                    view.layout(i - hwVar.ho(), i2, i3 - hwVar.ho(), i4);
                }
                break;
            case 1:
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - hwVar.ho(), i2, ((i3 + i5) - view.getMeasuredWidth()) - hwVar.ho(), i4);
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + hwVar.m(), i2, (i3 - i5) + view.getMeasuredWidth() + hwVar.m(), i4);
                }
                break;
            case 2:
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + uc.pr(marginLayoutParams)) - uc.hw(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                }
                break;
        }
    }

    public int pr(long j) {
        return (int) j;
    }

    public int hw(long j) {
        return (int) (j >> 32);
    }

    public long hw(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    private void pr(int i, int i2, int i3, View view) {
        long[] jArr = this.hw;
        if (jArr != null) {
            jArr[i] = hw(i2, i3);
        }
        long[] jArr2 = this.uc;
        if (jArr2 != null) {
            jArr2[i] = hw(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 600, 759})
    private static class hw implements Comparable<hw> {
        public int hw;
        public int pr;

        private hw() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compareTo(hw hwVar) {
            int i = this.hw;
            int i2 = hwVar.hw;
            if (i != i2) {
                return i - i2;
            }
            return this.pr - hwVar.pr;
        }

        public String toString() {
            return "Order{order=" + this.hw + ", index=" + this.pr + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 600, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    static class pr {
        public int hw;
        public List<hn> pr;

        public void pr() {
            this.pr = null;
            this.hw = 0;
        }
    }
}
