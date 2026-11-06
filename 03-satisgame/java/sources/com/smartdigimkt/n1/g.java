package com.smartdigimkt.n1;

import android.view.RoundedCorner;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static int[][] a(WindowInsets windowInsets) {
        int[] iArr = {0, 1, 3, 2};
        int[][] iArr2 = new int[4][];
        boolean z = false;
        for (int i = 0; i < 4; i++) {
            RoundedCorner roundedCorner = windowInsets.getRoundedCorner(iArr[i]);
            if (roundedCorner != null && roundedCorner.getRadius() > 0) {
                z = true;
                iArr2[i] = new int[]{roundedCorner.getCenter().x, roundedCorner.getCenter().y, roundedCorner.getRadius()};
            }
        }
        if (z) {
            return iArr2;
        }
        return null;
    }
}
