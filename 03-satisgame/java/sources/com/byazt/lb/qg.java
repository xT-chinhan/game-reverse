package com.byazt.lb;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 766, 26})
public class qg {
    public static int n(boolean z, int i, int i2) {
        if (i2 == 0 || !z) {
            return i;
        }
        int i3 = i - 512;
        int iAbs = Math.abs(i3) % i2;
        return (i3 >= 0 || iAbs == 0) ? iAbs : i2 - iAbs;
    }

    public static boolean n(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
