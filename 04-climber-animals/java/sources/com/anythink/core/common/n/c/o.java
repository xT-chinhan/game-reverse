package com.anythink.core.common.n.c;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class o extends AbstractList<f> implements RandomAccess {
    final f[] a;
    final int[] b;

    private o(f[] fVarArr, int[] iArr) {
        this.a = fVarArr;
        this.b = iArr;
    }

    public static o a(f... fVarArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(fVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, fVarArr[i2]), Integer.valueOf(i2));
        }
        if (((f) arrayList.get(0)).j() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            f fVar = (f) arrayList.get(i3);
            int i4 = i3 + 1;
            int i5 = i4;
            while (i5 < arrayList.size()) {
                f fVar2 = (f) arrayList.get(i5);
                if (!fVar2.c(fVar)) {
                    break;
                }
                if (fVar2.j() == fVar.j()) {
                    throw new IllegalArgumentException("duplicate option: ".concat(String.valueOf(fVar2)));
                }
                if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                    arrayList.remove(i5);
                    arrayList2.remove(i5);
                } else {
                    i5++;
                }
            }
            i3 = i4;
        }
        c cVar = new c();
        a(0L, cVar, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iA = a(cVar);
        int[] iArr = new int[iA];
        for (int i6 = 0; i6 < iA; i6++) {
            iArr[i6] = cVar.m();
        }
        if (!cVar.g()) {
            throw new AssertionError();
        }
        return new o((f[]) fVarArr.clone(), iArr);
    }

    private static void a(long j, c cVar, int i, List<f> list, int i2, int i3, List<Integer> list2) {
        int iIntValue;
        int i4;
        int i5;
        int i6;
        if (i2 >= i3) {
            throw new AssertionError();
        }
        for (int i7 = i2; i7 < i3; i7++) {
            if (list.get(i7).j() < i) {
                throw new AssertionError();
            }
        }
        f fVar = list.get(i2);
        f fVar2 = list.get(i3 - 1);
        if (i == fVar.j()) {
            int i8 = i2 + 1;
            i4 = i8;
            iIntValue = list2.get(i2).intValue();
            fVar = list.get(i8);
        } else {
            iIntValue = -1;
            i4 = i2;
        }
        if (fVar.b(i) != fVar2.b(i)) {
            int i9 = 1;
            for (int i10 = i4 + 1; i10 < i3; i10++) {
                if (list.get(i10 - 1).b(i) != list.get(i10).b(i)) {
                    i9++;
                }
            }
            long jA = j + ((long) a(cVar)) + 2 + ((long) (i9 * 2));
            cVar.i(i9);
            cVar.i(iIntValue);
            for (int i11 = i4; i11 < i3; i11++) {
                byte b = list.get(i11).b(i);
                if (i11 == i4 || b != list.get(i11 - 1).b(i)) {
                    cVar.i(b & UByte.MAX_VALUE);
                }
            }
            c cVar2 = new c();
            int i12 = i4;
            while (i12 < i3) {
                byte b2 = list.get(i12).b(i);
                int i13 = i12 + 1;
                int i14 = i13;
                while (true) {
                    if (i14 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (b2 != list.get(i14).b(i)) {
                            i6 = i14;
                            break;
                        }
                        i14++;
                    }
                }
                if (i13 == i6 && i + 1 == list.get(i12).j()) {
                    cVar.i(list2.get(i12).intValue());
                } else {
                    cVar.i((int) ((((long) a(cVar2)) + jA) * (-1)));
                    a(jA, cVar2, i + 1, list, i12, i6, list2);
                }
                cVar2 = cVar2;
                i12 = i6;
            }
            c cVar3 = cVar2;
            cVar.a(cVar3, cVar3.c);
            return;
        }
        int iMin = Math.min(fVar.j(), fVar2.j());
        int i15 = 0;
        for (int i16 = i; i16 < iMin && fVar.b(i16) == fVar2.b(i16); i16++) {
            i15++;
        }
        long jA2 = 1 + j + ((long) a(cVar)) + 2 + ((long) i15);
        cVar.i(-i15);
        cVar.i(iIntValue);
        int i17 = i;
        while (true) {
            i5 = i + i15;
            if (i17 >= i5) {
                break;
            }
            cVar.i(fVar.b(i17) & UByte.MAX_VALUE);
            i17++;
        }
        if (i4 + 1 == i3) {
            if (i5 != list.get(i4).j()) {
                throw new AssertionError();
            }
            cVar.i(list2.get(i4).intValue());
        } else {
            c cVar4 = new c();
            cVar.i((int) ((((long) a(cVar4)) + jA2) * (-1)));
            a(jA2, cVar4, i5, list, i4, i3, list2);
            cVar.a(cVar4, cVar4.c);
        }
    }

    private f a(int i) {
        return this.a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.length;
    }

    private static int a(c cVar) {
        return (int) (cVar.c / 4);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.a[i];
    }
}
