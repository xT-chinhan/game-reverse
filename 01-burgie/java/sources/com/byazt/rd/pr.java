package com.byazt.rd;

import com.byazt.sd.a;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 89, 37})
public abstract class pr {
    public abstract boolean hn();

    public abstract void hw(int i);

    public abstract boolean hw();

    public abstract boolean pr(int i);

    public abstract JSONObject x();

    public int pr() {
        JSONObject jSONObjectX = x();
        if (jSONObjectX == null) {
            return 0;
        }
        double dOptDouble = jSONObjectX.optDouble(Constants.VALUE_FIELD, 0.0d);
        int iOptInt = jSONObjectX.optInt("plan");
        if (iOptInt != 1) {
            return iOptInt;
        }
        if (dOptDouble == 0.0d) {
            return 0;
        }
        return 1;
    }

    public boolean hn(int i) {
        int iPr = pr();
        if (iPr == 0 || hw() || hn() || uc(i)) {
            return false;
        }
        return pr(iPr);
    }

    public static boolean x(int i) {
        return (pr(a.hw().wz(), i) ^ true) || (pr(a.hw().xb(), i) ^ true);
    }

    private static boolean pr(JSONObject jSONObject, int i) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("valid_type")) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                if (i == jSONArrayOptJSONArray.optInt(i2)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private boolean uc(int i) {
        return pr(x(), i);
    }

    public void c(int i) {
        int iPr = pr();
        if (iPr == 0 || hw() || hn() || uc(i)) {
            return;
        }
        hw(iPr);
    }

    public static double pr(double d, JSONObject jSONObject) {
        double dOptDouble = jSONObject.optDouble("min_value", -1.0d);
        double dOptDouble2 = jSONObject.optDouble("max_value", 1.0d);
        if (d > dOptDouble2) {
            return dOptDouble2;
        }
        if (d < dOptDouble) {
            return dOptDouble;
        }
        return d;
    }
}
