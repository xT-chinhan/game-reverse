package com.smartdigimkt.b3;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("taskType", i);
            jSONObject.put("status", 1);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String a(int i, long j) {
        return j + "_" + i;
    }

    public static String a(int i, int i2, long j) {
        if (i == 16) {
            if (i2 == 53 || i2 == 42) {
                return a(4, j);
            }
            if (i2 == 54) {
                return a(5, j);
            }
            if (i2 == 55) {
                return a(6, j);
            }
            if (i2 == 56) {
                return a(7, j);
            }
        }
        if (i == 1) {
            if (i2 == 55) {
                return a(6, j);
            }
            if (i2 == 56) {
                return a(7, j);
            }
            if (i2 == 57) {
                return a(8, j);
            }
            if (i2 == 58) {
                return a(9, j);
            }
        }
        if ((i == 1 || i == 4 || i == 18 || i == 19 || i == 14 || i == 15) && (i2 == 6 || i2 == 30 || i2 == 34 || i2 == 36 || i2 == 40 || i2 == 41 || i2 == 24 || i2 == 25)) {
            return a(10, j);
        }
        if (i2 == 39 || i2 == 62) {
            return a(11, j);
        }
        if (i2 == 29 || i2 == 38 || i2 == 35 || i2 == 8 || i2 == 37 || i2 == 26) {
            return a(12, j);
        }
        if (i == 10 && i2 == 14) {
            return a(2, j);
        }
        if (i == 1 && i2 == 61) {
            return a(2, j);
        }
        if (i == 1 && i2 == 1) {
            return a(1, j);
        }
        if ((i == 4 && i2 == 5) || ((i == 18 && i2 == 51) || ((i == 19 && i2 == 50) || ((i == 1 && i2 == 3) || (i == 1 && i2 == 2))))) {
            return a(3, j);
        }
        return a(3, j);
    }
}
