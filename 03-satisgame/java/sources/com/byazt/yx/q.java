package com.byazt.yx;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.PointerIconCompat;
import com.byazt.hb.w;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, 5})
public class q {
    public static final /* synthetic */ boolean s = true;
    public boolean[] l;
    public int[] n;
    public final com.byazt.yx.n q;
    public long[] qg;
    public long[] w;

    public int n(long j) {
        return (int) j;
    }

    public int qg(long j) {
        return (int) (j >> 32);
    }

    public long qg(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    public q(com.byazt.yx.n nVar) {
        this.q = nVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.q.getFlexItemCount();
        List<qg> listQg = qg(flexItemCount);
        qg qgVar = new qg();
        if (view != null && (layoutParams instanceof com.byazt.yx.qg)) {
            qgVar.qg = ((com.byazt.yx.qg) layoutParams).s();
        } else {
            qgVar.qg = 1;
        }
        if (i != -1 && i != flexItemCount && i < this.q.getFlexItemCount()) {
            qgVar.n = i;
            while (i < flexItemCount) {
                listQg.get(i).n++;
                i++;
            }
        } else {
            qgVar.n = flexItemCount;
        }
        listQg.add(qgVar);
        return n(flexItemCount + 1, listQg, sparseIntArray);
    }

    public int[] n(SparseIntArray sparseIntArray) {
        int flexItemCount = this.q.getFlexItemCount();
        return n(flexItemCount, qg(flexItemCount), sparseIntArray);
    }

    private List<qg> qg(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.byazt.yx.qg qgVar = (com.byazt.yx.qg) this.q.n(i2).getLayoutParams();
            qg qgVar2 = new qg();
            qgVar2.qg = qgVar.s();
            qgVar2.n = i2;
            arrayList.add(qgVar2);
        }
        return arrayList;
    }

    public boolean qg(SparseIntArray sparseIntArray) {
        int flexItemCount = this.q.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewN = this.q.n(i);
            if (viewN != null && ((com.byazt.yx.qg) viewN.getLayoutParams()).s() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] n(int i, List<qg> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (qg qgVar : list) {
            iArr[i2] = qgVar.n;
            sparseIntArray.append(qgVar.n, qgVar.qg);
            i2++;
        }
        return iArr;
    }

    public void n(n nVar, int i, int i2) {
        n(nVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<s>) null);
    }

    public void qg(n nVar, int i, int i2) {
        n(nVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<s>) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(n nVar, int i, int i2, int i3, int i4, int i5, List<s> list) {
        int i6;
        int i7;
        List<s> list2;
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
        boolean zN = this.q.n();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<s> arrayList = list == null ? new ArrayList() : list;
        nVar.n = arrayList;
        int i17 = i16 == -1 ? 1 : 0;
        int iN = n(zN);
        int iQg = qg(zN);
        int iS = s(zN);
        int iQ = q(zN);
        s sVar = new s();
        int i18 = i4;
        sVar.k = i18;
        int i19 = iQg + iN;
        sVar.l = i19;
        int flexItemCount = this.q.getFlexItemCount();
        int i20 = i17;
        int i21 = Integer.MIN_VALUE;
        int i22 = 0;
        int iCombineMeasuredStates = 0;
        int i23 = 0;
        while (i18 < flexItemCount) {
            View viewQg = this.q.qg(i18);
            if (viewQg == null) {
                if (n(i18, flexItemCount, sVar)) {
                    n(arrayList, sVar, i18, i22);
                }
            } else {
                if (viewQg.getVisibility() == 8) {
                    sVar.rv++;
                    sVar.fs++;
                    if (n(i18, flexItemCount, sVar)) {
                        n(arrayList, sVar, i18, i22);
                    }
                } else {
                    if (viewQg instanceof CompoundButton) {
                        n((CompoundButton) viewQg);
                    }
                    com.byazt.yx.qg qgVar = (com.byazt.yx.qg) viewQg.getLayoutParams();
                    int i24 = flexItemCount;
                    if (qgVar.w() == 4) {
                        sVar.sz.add(Integer.valueOf(i18));
                    }
                    int iN2 = n(qgVar, zN);
                    if (qgVar.d() != -1.0f && mode == 1073741824) {
                        iN2 = Math.round(size * qgVar.d());
                    }
                    if (zN) {
                        int iN3 = this.q.n(i, i19 + s(qgVar, true) + q(qgVar, true), iN2);
                        int iQg2 = this.q.qg(i15, iS + iQ + l(qgVar, true) + w(qgVar, true) + i22, qg(qgVar, true));
                        viewQg.measure(iN3, iQg2);
                        n(i18, iN3, iQg2, viewQg);
                        i7 = iN3;
                    } else {
                        int iN4 = this.q.n(i15, iS + iQ + l(qgVar, false) + w(qgVar, false) + i22, qg(qgVar, false));
                        int iQg3 = this.q.qg(i, s(qgVar, false) + i19 + q(qgVar, false), iN2);
                        viewQg.measure(iN4, iQg3);
                        n(i18, iN4, iQg3, viewQg);
                        i7 = iQg3;
                    }
                    n(viewQg, i18);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewQg.getMeasuredState());
                    int i25 = sVar.l;
                    int i26 = i22;
                    int i27 = i19;
                    s sVar2 = sVar;
                    int i28 = size;
                    int i29 = i18;
                    list2 = arrayList;
                    int i30 = i7;
                    if (n(viewQg, mode, i28, i25, q(qgVar, zN) + n(viewQg, zN) + s(qgVar, zN), qgVar, i29, i23, arrayList.size())) {
                        if (sVar2.qg() > 0) {
                            n(list2, sVar2, i29 > 0 ? i29 - 1 : 0, i26);
                            i22 = sVar2.x + i26;
                        } else {
                            i22 = i26;
                        }
                        if (zN) {
                            if (qgVar.qg() == -1) {
                                com.byazt.yx.n nVar2 = this.q;
                                i8 = i2;
                                i18 = i29;
                                view = viewQg;
                                view.measure(i30, nVar2.qg(i8, nVar2.getPaddingTop() + this.q.getPaddingBottom() + qgVar.sz() + qgVar.cy() + i22, qgVar.qg()));
                                n(view, i18);
                            } else {
                                i8 = i2;
                                view = viewQg;
                                i18 = i29;
                            }
                        } else {
                            i8 = i2;
                            view = viewQg;
                            i18 = i29;
                            if (qgVar.n() == -1) {
                                com.byazt.yx.n nVar3 = this.q;
                                view.measure(nVar3.n(i8, nVar3.getPaddingLeft() + this.q.getPaddingRight() + qgVar.oa() + qgVar.k() + i22, qgVar.n()), i30);
                                n(view, i18);
                            }
                        }
                        sVar = new s();
                        i10 = 1;
                        sVar.fs = 1;
                        i9 = i27;
                        sVar.l = i9;
                        sVar.k = i18;
                        i12 = Integer.MIN_VALUE;
                        i11 = 0;
                    } else {
                        i8 = i2;
                        view = viewQg;
                        i18 = i29;
                        sVar = sVar2;
                        i9 = i27;
                        i10 = 1;
                        sVar.fs++;
                        i11 = i23 + 1;
                        i22 = i26;
                        i12 = i21;
                    }
                    sVar.hd = (sVar.hd ? 1 : 0) | (qgVar.q() != 0.0f ? i10 : 0);
                    sVar.cd = (sVar.cd ? 1 : 0) | (qgVar.l() != 0.0f ? i10 : 0);
                    int[] iArr = this.n;
                    if (iArr != null) {
                        iArr[i18] = list2.size();
                    }
                    sVar.l += n(view, zN) + s(qgVar, zN) + q(qgVar, zN);
                    sVar.tj += qgVar.q();
                    sVar.cp += qgVar.l();
                    this.q.n(view, i18, i11, sVar);
                    int iMax = Math.max(i12, qg(view, zN) + l(qgVar, zN) + w(qgVar, zN) + this.q.n(view));
                    sVar.x = Math.max(sVar.x, iMax);
                    if (zN) {
                        if (this.q.getFlexWrap() != 2) {
                            sVar.d = Math.max(sVar.d, view.getBaseline() + qgVar.sz());
                        } else {
                            sVar.d = Math.max(sVar.d, (view.getMeasuredHeight() - view.getBaseline()) + qgVar.cy());
                        }
                    }
                    i13 = i24;
                    if (n(i18, i13, sVar)) {
                        n(list2, sVar, i18, i22);
                        i22 += sVar.x;
                    }
                    i14 = i5;
                    if (i14 != -1 && list2.size() > 0 && list2.get(list2.size() - i10).cy >= i14 && i18 >= i14 && i20 == 0) {
                        i22 = -sVar.n();
                        i20 = i10;
                    }
                    if (i22 > i3 && i20 != 0) {
                        i6 = iCombineMeasuredStates;
                        nVar.qg = i6;
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
        nVar.qg = i6;
    }

    private void n(CompoundButton compoundButton) {
        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) compoundButton.getLayoutParams();
        int iX = qgVar.x();
        int iFs = qgVar.fs();
        Drawable drawableN = com.byazt.hb.l.n(compoundButton);
        int minimumWidth = drawableN == null ? 0 : drawableN.getMinimumWidth();
        int minimumHeight = drawableN != null ? drawableN.getMinimumHeight() : 0;
        if (iX == -1) {
            iX = minimumWidth;
        }
        qgVar.n(iX);
        if (iFs == -1) {
            iFs = minimumHeight;
        }
        qgVar.qg(iFs);
    }

    private int n(boolean z) {
        if (z) {
            return this.q.getPaddingStart();
        }
        return this.q.getPaddingTop();
    }

    private int qg(boolean z) {
        if (z) {
            return this.q.getPaddingEnd();
        }
        return this.q.getPaddingBottom();
    }

    private int s(boolean z) {
        if (z) {
            return this.q.getPaddingTop();
        }
        return this.q.getPaddingStart();
    }

    private int q(boolean z) {
        if (z) {
            return this.q.getPaddingBottom();
        }
        return this.q.getPaddingEnd();
    }

    private int n(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int qg(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int n(com.byazt.yx.qg qgVar, boolean z) {
        if (z) {
            return qgVar.n();
        }
        return qgVar.qg();
    }

    private int qg(com.byazt.yx.qg qgVar, boolean z) {
        if (z) {
            return qgVar.qg();
        }
        return qgVar.n();
    }

    private int s(com.byazt.yx.qg qgVar, boolean z) {
        if (z) {
            return qgVar.oa();
        }
        return qgVar.sz();
    }

    private int q(com.byazt.yx.qg qgVar, boolean z) {
        if (z) {
            return qgVar.k();
        }
        return qgVar.cy();
    }

    private int l(com.byazt.yx.qg qgVar, boolean z) {
        if (z) {
            return qgVar.sz();
        }
        return qgVar.oa();
    }

    private int w(com.byazt.yx.qg qgVar, boolean z) {
        if (z) {
            return qgVar.cy();
        }
        return qgVar.k();
    }

    private boolean n(View view, int i, int i2, int i3, int i4, com.byazt.yx.qg qgVar, int i5, int i6, int i7) {
        if (this.q.getFlexWrap() == 0) {
            return false;
        }
        if (qgVar.cp()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.q.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iN = this.q.n(view, i5, i6);
        if (iN > 0) {
            i4 += iN;
        }
        return i2 < i3 + i4;
    }

    private boolean n(int i, int i2, s sVar) {
        return i == i2 - 1 && sVar.qg() != 0;
    }

    private void n(List<s> list, s sVar, int i, int i2) {
        sVar.oa = i2;
        this.q.n(sVar);
        sVar.cy = i;
        list.add(sVar);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void n(View view, int i) {
        boolean z;
        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < qgVar.x()) {
            measuredWidth = qgVar.x();
        } else {
            if (measuredWidth > qgVar.rv()) {
                measuredWidth = qgVar.rv();
            } else {
                z = false;
            }
            if (measuredHeight < qgVar.fs()) {
                measuredHeight = qgVar.fs();
            } else if (measuredHeight > qgVar.tj()) {
                measuredHeight = qgVar.tj();
            } else {
                z2 = z;
            }
            if (z2) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, C.ENCODING_PCM_32BIT);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, C.ENCODING_PCM_32BIT);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                n(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
            }
        }
        z = true;
        if (measuredHeight < qgVar.fs()) {
            measuredHeight = qgVar.fs();
        } else if (measuredHeight > qgVar.tj()) {
            measuredHeight = qgVar.tj();
        } else {
            z2 = z;
        }
        if (z2) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, C.ENCODING_PCM_32BIT);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, C.ENCODING_PCM_32BIT);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            n(i, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
        }
    }

    public void n(int i, int i2) {
        n(i, i2, 0);
    }

    public void n(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        s(this.q.getFlexItemCount());
        if (i3 >= this.q.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.q.getFlexDirection();
        int flexDirection2 = this.q.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.q.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.q.getPaddingLeft();
            paddingRight = this.q.getPaddingRight();
        } else if (flexDirection2 == 2 || flexDirection2 == 3) {
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.q.getLargestMainSize();
            }
            paddingLeft = this.q.getPaddingTop();
            paddingRight = this.q.getPaddingBottom();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.n;
        List<s> flexLinesInternal = this.q.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            s sVar = flexLinesInternal.get(i5);
            if (sVar.l < size && sVar.hd) {
                n(i, i2, sVar, size, i4, false);
            } else if (sVar.l > size && sVar.cd) {
                qg(i, i2, sVar, size, i4, false);
            }
        }
    }

    private void s(int i) {
        boolean[] zArr = this.l;
        if (zArr == null) {
            this.l = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.l = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void n(int i, int i2, s sVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        double d;
        int i6;
        double d2;
        float f = 0.0f;
        if (sVar.tj <= 0.0f || i3 < sVar.l) {
            return;
        }
        int i7 = sVar.l;
        float f2 = (i3 - sVar.l) / sVar.tj;
        sVar.l = i4 + sVar.w;
        if (!z) {
            sVar.x = Integer.MIN_VALUE;
        }
        int i8 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i9 = 0;
        while (i8 < sVar.fs) {
            int i10 = sVar.k + i8;
            View viewQg = this.q.qg(i10);
            if (viewQg == null || viewQg.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.byazt.yx.qg qgVar = (com.byazt.yx.qg) viewQg.getLayoutParams();
                int flexDirection = this.q.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i7;
                    int measuredWidth = viewQg.getMeasuredWidth();
                    long[] jArr = this.w;
                    if (jArr != null) {
                        measuredWidth = n(jArr[i10]);
                    }
                    int measuredHeight = viewQg.getMeasuredHeight();
                    long[] jArr2 = this.w;
                    i5 = i11;
                    if (jArr2 != null) {
                        measuredHeight = qg(jArr2[i10]);
                    }
                    if (!this.l[i10] && qgVar.q() > 0.0f) {
                        float fQ = measuredWidth + (qgVar.q() * f2);
                        if (i8 == sVar.fs - 1) {
                            fQ += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fQ);
                        if (iRound > qgVar.rv()) {
                            iRound = qgVar.rv();
                            this.l[i10] = true;
                            sVar.tj -= qgVar.q();
                            z2 = true;
                        } else {
                            f3 += fQ - iRound;
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
                        int iQg = qg(i2, qgVar, sVar.oa);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, C.ENCODING_PCM_32BIT);
                        viewQg.measure(iMakeMeasureSpec, iQg);
                        int measuredWidth2 = viewQg.getMeasuredWidth();
                        int measuredHeight2 = viewQg.getMeasuredHeight();
                        n(i10, iMakeMeasureSpec, iQg, viewQg);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + qgVar.sz() + qgVar.cy() + this.q.n(viewQg));
                    sVar.l += measuredWidth + qgVar.oa() + qgVar.k();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewQg.getMeasuredHeight();
                    long[] jArr3 = this.w;
                    if (jArr3 != null) {
                        measuredHeight3 = qg(jArr3[i10]);
                    }
                    int measuredWidth3 = viewQg.getMeasuredWidth();
                    long[] jArr4 = this.w;
                    if (jArr4 != null) {
                        measuredWidth3 = n(jArr4[i10]);
                    }
                    if (this.l[i10] || qgVar.q() <= f) {
                        i6 = i7;
                    } else {
                        float fQ2 = measuredHeight3 + (qgVar.q() * f2);
                        if (i8 == sVar.fs - 1) {
                            fQ2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fQ2);
                        if (iRound2 > qgVar.tj()) {
                            iRound2 = qgVar.tj();
                            this.l[i10] = true;
                            sVar.tj -= qgVar.q();
                            i6 = i7;
                            z2 = true;
                        } else {
                            f3 += fQ2 - iRound2;
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
                        int iN = n(i, qgVar, sVar.oa);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, C.ENCODING_PCM_32BIT);
                        viewQg.measure(iN, iMakeMeasureSpec2);
                        measuredWidth3 = viewQg.getMeasuredWidth();
                        int measuredHeight4 = viewQg.getMeasuredHeight();
                        n(i10, iN, iMakeMeasureSpec2, viewQg);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + qgVar.oa() + qgVar.k() + this.q.n(viewQg));
                    sVar.l += measuredHeight3 + qgVar.sz() + qgVar.cy();
                    i5 = i6;
                }
                sVar.x = Math.max(sVar.x, iMax);
                i9 = iMax;
            }
            i8++;
            i7 = i5;
            f = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == sVar.l) {
            return;
        }
        n(i, i2, sVar, i3, i4, true);
    }

    private void qg(int i, int i2, s sVar, int i3, int i4, boolean z) {
        int i5;
        int iMax;
        int i6 = sVar.l;
        float f = 0.0f;
        if (sVar.cp <= 0.0f || i3 > sVar.l) {
            return;
        }
        float f2 = (sVar.l - i3) / sVar.cp;
        sVar.l = i4 + sVar.w;
        if (!z) {
            sVar.x = Integer.MIN_VALUE;
        }
        int i7 = 0;
        float f3 = 0.0f;
        boolean z2 = false;
        int i8 = 0;
        while (i7 < sVar.fs) {
            int i9 = sVar.k + i7;
            View viewQg = this.q.qg(i9);
            if (viewQg == null || viewQg.getVisibility() == 8) {
                i5 = i7;
            } else {
                com.byazt.yx.qg qgVar = (com.byazt.yx.qg) viewQg.getLayoutParams();
                int flexDirection = this.q.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int measuredWidth = viewQg.getMeasuredWidth();
                    long[] jArr = this.w;
                    if (jArr != null) {
                        measuredWidth = n(jArr[i9]);
                    }
                    int measuredHeight = viewQg.getMeasuredHeight();
                    long[] jArr2 = this.w;
                    if (jArr2 != null) {
                        measuredHeight = qg(jArr2[i9]);
                    }
                    if (!this.l[i9] && qgVar.l() > 0.0f) {
                        float fL = measuredWidth - (qgVar.l() * f2);
                        if (i5 == sVar.fs - 1) {
                            fL += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(fL);
                        if (iRound < qgVar.x()) {
                            iRound = qgVar.x();
                            this.l[i9] = true;
                            sVar.cp -= qgVar.l();
                            z2 = true;
                        } else {
                            f3 += fL - iRound;
                            double d = f3;
                            if (d > 1.0d) {
                                iRound++;
                                f3 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f3 += 1.0f;
                            }
                        }
                        int iQg = qg(i2, qgVar, sVar.oa);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, C.ENCODING_PCM_32BIT);
                        viewQg.measure(iMakeMeasureSpec, iQg);
                        int measuredWidth2 = viewQg.getMeasuredWidth();
                        int measuredHeight2 = viewQg.getMeasuredHeight();
                        n(i9, iMakeMeasureSpec, iQg, viewQg);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i8, measuredHeight + qgVar.sz() + qgVar.cy() + this.q.n(viewQg));
                    sVar.l += measuredWidth + qgVar.oa() + qgVar.k();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewQg.getMeasuredHeight();
                    long[] jArr3 = this.w;
                    if (jArr3 != null) {
                        measuredHeight3 = qg(jArr3[i9]);
                    }
                    int measuredWidth3 = viewQg.getMeasuredWidth();
                    long[] jArr4 = this.w;
                    if (jArr4 != null) {
                        measuredWidth3 = n(jArr4[i9]);
                    }
                    if (this.l[i9] || qgVar.l() <= f) {
                        i5 = i7;
                    } else {
                        float fL2 = measuredHeight3 - (qgVar.l() * f2);
                        if (i7 == sVar.fs - 1) {
                            fL2 += f3;
                            f3 = f;
                        }
                        int iRound2 = Math.round(fL2);
                        if (iRound2 < qgVar.fs()) {
                            iRound2 = qgVar.fs();
                            this.l[i9] = true;
                            sVar.cp -= qgVar.l();
                            i5 = i7;
                            z2 = true;
                        } else {
                            f3 += fL2 - iRound2;
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
                        int iN = n(i, qgVar, sVar.oa);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, C.ENCODING_PCM_32BIT);
                        viewQg.measure(iN, iMakeMeasureSpec2);
                        measuredWidth3 = viewQg.getMeasuredWidth();
                        int measuredHeight4 = viewQg.getMeasuredHeight();
                        n(i9, iN, iMakeMeasureSpec2, viewQg);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i8, measuredWidth3 + qgVar.oa() + qgVar.k() + this.q.n(viewQg));
                    sVar.l += measuredHeight3 + qgVar.sz() + qgVar.cy();
                }
                sVar.x = Math.max(sVar.x, iMax);
                i8 = iMax;
            }
            i7 = i5 + 1;
            f = 0.0f;
        }
        if (!z2 || i6 == sVar.l) {
            return;
        }
        qg(i, i2, sVar, i3, i4, true);
    }

    private int n(int i, com.byazt.yx.qg qgVar, int i2) {
        com.byazt.yx.n nVar = this.q;
        int iN = nVar.n(i, nVar.getPaddingLeft() + this.q.getPaddingRight() + qgVar.oa() + qgVar.k() + i2, qgVar.n());
        int size = View.MeasureSpec.getSize(iN);
        if (size > qgVar.rv()) {
            return View.MeasureSpec.makeMeasureSpec(qgVar.rv(), View.MeasureSpec.getMode(iN));
        }
        return size < qgVar.x() ? View.MeasureSpec.makeMeasureSpec(qgVar.x(), View.MeasureSpec.getMode(iN)) : iN;
    }

    private int qg(int i, com.byazt.yx.qg qgVar, int i2) {
        com.byazt.yx.n nVar = this.q;
        int iQg = nVar.qg(i, nVar.getPaddingTop() + this.q.getPaddingBottom() + qgVar.sz() + qgVar.cy() + i2, qgVar.qg());
        int size = View.MeasureSpec.getSize(iQg);
        if (size > qgVar.tj()) {
            return View.MeasureSpec.makeMeasureSpec(qgVar.tj(), View.MeasureSpec.getMode(iQg));
        }
        return size < qgVar.fs() ? View.MeasureSpec.makeMeasureSpec(qgVar.fs(), View.MeasureSpec.getMode(iQg)) : iQg;
    }

    public void qg(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.q.getFlexDirection();
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
        List<s> flexLinesInternal = this.q.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.q.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).x = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.q.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    s sVar = new s();
                    sVar.x = i5;
                    flexLinesInternal.add(0, sVar);
                    return;
                }
                if (alignContent == 2) {
                    this.q.setFlexLines(n(flexLinesInternal, size, sumOfCrossSize));
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
                                s sVar2 = new s();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    sVar2.x = Math.round(f + size3);
                                    f = 0.0f;
                                } else {
                                    sVar2.x = Math.round(size3);
                                }
                                f += size3 - sVar2.x;
                                if (f > 1.0f) {
                                    sVar2.x++;
                                    f -= 1.0f;
                                } else if (f < -1.0f) {
                                    sVar2.x--;
                                    f += 1.0f;
                                }
                                arrayList.add(sVar2);
                            }
                            i4++;
                        }
                        this.q.setFlexLines(arrayList);
                        return;
                    }
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.q.setFlexLines(n(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    s sVar3 = new s();
                    sVar3.x = size5;
                    for (s sVar4 : flexLinesInternal) {
                        arrayList2.add(sVar3);
                        arrayList2.add(sVar4);
                        arrayList2.add(sVar3);
                    }
                    this.q.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i4 < size7) {
                        s sVar5 = flexLinesInternal.get(i4);
                        float f3 = sVar5.x + size6;
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
                        sVar5.x = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<s> n(List<s> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        s sVar = new s();
        sVar.x = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(sVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(sVar);
            }
        }
        return arrayList;
    }

    public void n() {
        n(0);
    }

    public void n(int i) {
        View viewQg;
        if (i >= this.q.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.q.getFlexDirection();
        if (this.q.getAlignItems() == 4) {
            int[] iArr = this.n;
            List<s> flexLinesInternal = this.q.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                s sVar = flexLinesInternal.get(i2);
                int i3 = sVar.fs;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = sVar.k + i4;
                    if (i4 < this.q.getFlexItemCount() && (viewQg = this.q.qg(i5)) != null && viewQg.getVisibility() != 8) {
                        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) viewQg.getLayoutParams();
                        if (qgVar.w() == -1 || qgVar.w() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                n(viewQg, sVar.x, i5);
                            } else if (flexDirection == 2 || flexDirection == 3) {
                                qg(viewQg, sVar.x, i5);
                            } else {
                                throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                            }
                        }
                    }
                }
            }
            return;
        }
        for (s sVar2 : this.q.getFlexLinesInternal()) {
            for (Integer num : sVar2.sz) {
                View viewQg2 = this.q.qg(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    n(viewQg2, sVar2.x, num.intValue());
                } else if (flexDirection == 2 || flexDirection == 3) {
                    qg(viewQg2, sVar2.x, num.intValue());
                } else {
                    throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(flexDirection)));
                }
            }
        }
    }

    private void n(View view, int i, int i2) {
        int measuredWidth;
        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - qgVar.sz()) - qgVar.cy()) - this.q.n(view), qgVar.fs()), qgVar.tj());
        long[] jArr = this.w;
        if (jArr != null) {
            measuredWidth = n(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, C.ENCODING_PCM_32BIT);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, C.ENCODING_PCM_32BIT);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        n(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
    }

    private void qg(View view, int i, int i2) {
        int measuredHeight;
        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - qgVar.oa()) - qgVar.k()) - this.q.n(view), qgVar.x()), qgVar.rv());
        long[] jArr = this.w;
        if (jArr != null) {
            measuredHeight = qg(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, C.ENCODING_PCM_32BIT);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, C.ENCODING_PCM_32BIT);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        n(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
    }

    public void n(View view, s sVar, int i, int i2, int i3, int i4) {
        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) view.getLayoutParams();
        int alignItems = this.q.getAlignItems();
        if (qgVar.w() != -1) {
            alignItems = qgVar.w();
        }
        int i5 = sVar.x;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.q.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - qgVar.cy(), i3, i6 - qgVar.cy());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + qgVar.sz(), i3, (i4 - i5) + view.getMeasuredHeight() + qgVar.sz());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + qgVar.sz()) - qgVar.cy()) / 2;
                if (this.q.getFlexWrap() != 2) {
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
                if (this.q.getFlexWrap() != 2) {
                    int iMax = Math.max(sVar.d - view.getBaseline(), qgVar.sz());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((sVar.d - view.getMeasuredHeight()) + view.getBaseline(), qgVar.cy());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.q.getFlexWrap() != 2) {
            view.layout(i, i2 + qgVar.sz(), i3, i4 + qgVar.sz());
        } else {
            view.layout(i, i2 - qgVar.cy(), i3, i4 - qgVar.cy());
        }
    }

    public void n(View view, s sVar, boolean z, int i, int i2, int i3, int i4) {
        com.byazt.yx.qg qgVar = (com.byazt.yx.qg) view.getLayoutParams();
        int alignItems = this.q.getAlignItems();
        if (qgVar.w() != -1) {
            alignItems = qgVar.w();
        }
        int i5 = sVar.x;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - qgVar.k(), i2, ((i3 + i5) - view.getMeasuredWidth()) - qgVar.k(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + qgVar.oa(), i2, (i3 - i5) + view.getMeasuredWidth() + qgVar.oa(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + w.n(marginLayoutParams)) - w.qg(marginLayoutParams)) / 2;
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
            view.layout(i + qgVar.oa(), i2, i3 + qgVar.oa(), i4);
        } else {
            view.layout(i - qgVar.k(), i2, i3 - qgVar.k(), i4);
        }
    }

    private void n(int i, int i2, int i3, View view) {
        long[] jArr = this.qg;
        if (jArr != null) {
            jArr[i] = qg(i2, i3);
        }
        long[] jArr2 = this.w;
        if (jArr2 != null) {
            jArr2[i] = qg(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, 524})
    private static class qg implements Comparable<qg> {
        public int n;
        public int qg;

        private qg() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compareTo(qg qgVar) {
            int i = this.qg;
            int i2 = qgVar.qg;
            return i != i2 ? i - i2 : this.n - qgVar.n;
        }

        public String toString() {
            return "Order{order=" + this.qg + ", index=" + this.n + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @com.byazt.cp.n(n = {0, 1, PointerIconCompat.TYPE_GRABBING, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    static class n {
        public List<s> n;
        public int qg;

        public void n() {
            this.n = null;
            this.qg = 0;
        }
    }
}
