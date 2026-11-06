package com.byazt.xx;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 719, 8})
public class s {
    public final com.byazt.dg.qg n;
    public double q;
    public int qg = Integer.MIN_VALUE;
    public double s;

    public s(com.byazt.dg.qg qgVar) {
        this.n = qgVar;
    }

    public boolean n(double d, com.byazt.dg.qg.C0152qg c0152qg) {
        if (c0152qg != null && "score_reach".equals(this.n.q.n)) {
            n(c0152qg);
            if (d >= this.s) {
                return true;
            }
        }
        return false;
    }

    public boolean qg(double d, com.byazt.dg.qg.C0152qg c0152qg) {
        if (c0152qg != null && "time_expire".equals(this.n.l.n)) {
            n(c0152qg);
            if (d >= this.q) {
                return true;
            }
        }
        return false;
    }

    private void n(com.byazt.dg.qg.C0152qg c0152qg) {
        if (c0152qg.n == this.qg) {
            return;
        }
        JSONObject jSONObjectQg = qg(c0152qg);
        this.s = n(this.n.q.qg, jSONObjectQg, c0152qg.qg);
        this.q = n(this.n.l.qg, jSONObjectQg, c0152qg.s);
        this.qg = c0152qg.n;
    }

    private static JSONObject qg(com.byazt.dg.qg.C0152qg c0152qg) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (c0152qg.d != null) {
                jSONObject.put("level", c0152qg.d);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static double n(String str, JSONObject jSONObject, double d) {
        if (str != null && str.length() != 0) {
            try {
                if (str.contains("${")) {
                    str = com.byazt.mcb.qg.n(str, jSONObject);
                }
                if (str != null && str.length() != 0) {
                    return Double.parseDouble(str.trim());
                }
            } catch (Throwable unused) {
            }
        }
        return d;
    }
}
