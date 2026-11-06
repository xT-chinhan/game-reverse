package com.byazt.uvh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 576, 19})
public final class n {
    public static w n(List<s> list, int i, int i2, boolean z, long j) {
        return n(list, i, i2, 0, 0, z, true, j);
    }

    public static w n(List<s> list, int i, int i2, int i3, int i4, boolean z, boolean z2, long j) {
        List<s> arrayList = list == null ? new ArrayList<>() : list;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int iQg = 0;
        int iMax = 0;
        long j2 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            s sVar = arrayList.get(i6);
            int iN = sVar.n();
            arrayList2.add(Integer.valueOf(iN));
            j2 += (long) iN;
            iMax = Math.max(iMax, iN);
            iQg += sVar.qg();
            if (iN >= i) {
                i5++;
            }
        }
        Collections.sort(arrayList2);
        int i7 = size == 0 ? 0 : (int) (j2 / ((long) size));
        int iN2 = n(arrayList2, 50);
        int iN3 = n(arrayList2, 95);
        int i8 = size == 0 ? 0 : (i5 * 1000) / size;
        boolean z3 = z && z2;
        return new w(size, i5, i8, iQg, iMax, i7, iN2, iN3, i, z3 ? iN3 - i2 : 0, z3 ? i8 - i3 : 0, z3 ? iQg - i4 : 0, j, com.byazt.yq.q.n().qg());
    }

    private static int n(List<Integer> list, int i) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i2 = ((((i * size) + 100) - 1) / 100) - 1;
        int i3 = i2 >= 0 ? i2 : 0;
        if (i3 >= size) {
            i3 = size - 1;
        }
        return list.get(i3).intValue();
    }
}
