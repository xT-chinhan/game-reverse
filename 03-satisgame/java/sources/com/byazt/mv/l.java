package com.byazt.mv;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 701, 18})
public class l {
    public final String n;
    public final float[] qg;
    public final int[] s;

    public l(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.n = str;
        this.qg = new float[jSONArray.length()];
        this.s = new int[jSONArray2.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.qg[i] = (float) jSONArray.optDouble(i);
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            this.s[i2] = jSONArray2.optInt(i2);
        }
    }

    public int n(float f) {
        int[] iArr;
        int i;
        float[] fArr = this.qg;
        int i2 = -1;
        if (fArr == null || fArr.length == 0 || (iArr = this.s) == null || iArr.length == 0) {
            return -1;
        }
        int length = fArr.length;
        int i3 = 0;
        while (i3 < length) {
            float[] fArr2 = this.qg;
            float f2 = fArr2[i3];
            if (f > f2 && (i = i3 + 1) < length && f <= fArr2[i]) {
                int[] iArr2 = this.s;
                return i3 < iArr2.length ? iArr2[i3] : i2;
            }
            if (i3 == length - 1 && f > f2) {
                i2 = this.s[i3];
            }
            i3++;
        }
        return i2;
    }
}
