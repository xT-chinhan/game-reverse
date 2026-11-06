package com.smartdigimkt.p3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final int a;
    public final int b;
    public final boolean c;
    public final int[] d;

    public f(JSONObject jSONObject) {
        this.a = a(jSONObject, "imp_min_pct", 1, 100, 50);
        this.b = a(jSONObject, "imp_min_px", 1, Integer.MAX_VALUE, 1);
        this.c = a(jSONObject, "imp_wf_sw", 1, 2, 1) == 1;
        this.d = new int[]{100, 0, 100, 0, 100};
        JSONObject jSONObjectOptJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("imp_min_time");
        int i = 0;
        while (true) {
            int[] iArr = this.d;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = a(jSONObjectOptJSONObject, String.valueOf(i), 0, Integer.MAX_VALUE, this.d[i]);
            i++;
        }
    }

    public static int a(JSONObject jSONObject, String str, int i, int i2, int i3) {
        Object objOpt = jSONObject == null ? null : jSONObject.opt(str);
        if (!(objOpt instanceof Integer) && !(objOpt instanceof Long)) {
            return i3;
        }
        long jLongValue = ((Number) objOpt).longValue();
        return (jLongValue < ((long) i) || jLongValue > ((long) i2)) ? i3 : (int) jLongValue;
    }
}
