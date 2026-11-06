package com.byazt.fh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 890, 37})
public final class pr {
    public static uc pr(List<hn> list, int i, int i2, boolean z, long j) {
        return pr(list, i, i2, 0, 0, z, true, j);
    }

    public static uc pr(List<hn> list, int i, int i2, int i3, int i4, boolean z, boolean z2, long j) {
        List<hn> arrayList = list == null ? new ArrayList<>() : list;
        int size = arrayList.size();
        long j2 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i5 = 0;
        int iHw = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            hn hnVar = arrayList.get(i6);
            int iPr = hnVar.pr();
            arrayList2.add(Integer.valueOf(iPr));
            j2 += (long) iPr;
            iMax = Math.max(iMax, iPr);
            iHw += hnVar.hw();
            if (iPr >= i) {
                i5++;
            }
        }
        Collections.sort(arrayList2);
        int i7 = size == 0 ? 0 : (int) (j2 / ((long) size));
        int iPr2 = pr(arrayList2, 50);
        int iPr3 = pr(arrayList2, 95);
        int i8 = size == 0 ? 0 : (i5 * 1000) / size;
        boolean z3 = z && z2;
        return new uc(size, i5, i8, iHw, iMax, i7, iPr2, iPr3, i, z3 ? iPr3 - i2 : 0, z3 ? i8 - i3 : 0, z3 ? iHw - i4 : 0, j, com.byazt.sf.x.pr().hw());
    }

    private static int pr(List<Integer> list, int i) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int i3 = ((((i * size) + 100) - 1) / 100) - 1;
        if (i3 >= 0) {
            i2 = i3;
        }
        if (i2 >= size) {
            i2 = size - 1;
        }
        return list.get(i2).intValue();
    }
}
