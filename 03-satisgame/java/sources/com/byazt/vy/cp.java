package com.byazt.vy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 29})
public class cp {
    public static String n(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            sb.append(iArr[i]);
            if (i != iArr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
