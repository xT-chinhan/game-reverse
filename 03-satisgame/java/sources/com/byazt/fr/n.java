package com.byazt.fr;

import com.anythink.core.common.f.e;
import com.byazt.nf.rv;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 671, 19})
public abstract class n {
    public abstract boolean n(int i);

    public abstract JSONObject q();

    public abstract void qg(int i);

    public abstract boolean qg();

    public abstract boolean s();

    public int n() {
        JSONObject jSONObjectQ = q();
        if (jSONObjectQ == null) {
            return 0;
        }
        double dOptDouble = jSONObjectQ.optDouble(e.a.d, 0.0d);
        int iOptInt = jSONObjectQ.optInt("plan");
        if (iOptInt == 1) {
            return dOptDouble == 0.0d ? 0 : 1;
        }
        return iOptInt;
    }

    public boolean s(int i) {
        int iN = n();
        if (iN == 0 || qg() || s() || w(i)) {
            return false;
        }
        return n(iN);
    }

    public static boolean q(int i) {
        return (n(rv.qg().il(), i) ^ true) || (n(rv.qg().la(), i) ^ true);
    }

    private static boolean n(JSONObject jSONObject, int i) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("valid_type")) == null || jSONArrayOptJSONArray.length() == 0) {
            return true;
        }
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            if (i == jSONArrayOptJSONArray.optInt(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean w(int i) {
        return n(q(), i);
    }

    public void l(int i) {
        int iN = n();
        if (iN == 0 || qg() || s() || w(i)) {
            return;
        }
        qg(iN);
    }

    public static double n(double d, JSONObject jSONObject) {
        double dOptDouble = jSONObject.optDouble("min_value", -1.0d);
        double dOptDouble2 = jSONObject.optDouble("max_value", 1.0d);
        if (d > dOptDouble2) {
            return dOptDouble2;
        }
        return d < dOptDouble ? dOptDouble : d;
    }
}
