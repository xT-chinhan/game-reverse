package com.byazt.cf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 440, 37})
public final class pr {
    public static long pr(List<Long> list, int i) {
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        int iMax = Math.max(0, Math.min(100, i));
        int size = list.size();
        return list.get(Math.max(0, Math.min(size - 1, ((int) Math.ceil((((double) iMax) / 100.0d) * ((double) size))) - 1))).longValue();
    }

    public static long pr(long j, long j2, long j3) {
        if (j3 > 0 && j > j3) {
            j = j3;
        }
        if (j >= j2) {
            return j;
        }
        return j2;
    }
}
