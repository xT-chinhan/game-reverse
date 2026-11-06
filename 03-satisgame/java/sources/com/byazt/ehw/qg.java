package com.byazt.ehw;

import android.text.TextUtils;
import com.byazt.vf.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 470, 26})
public final class qg {
    public static volatile long n = Long.MIN_VALUE;

    private static String n(String str) {
        return str == null ? "" : str;
    }

    public static void n(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        n(jSONObject, "last_ab_device_id", l.qg());
    }

    public static void qg(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        n(jSONObject, "last_did", l.n());
        n(jSONObject, "last_ab_device_id", l.s());
    }

    public static String s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strN = n(jSONObject, "ab_device_id");
        return !TextUtils.isEmpty(strN) ? strN : n(jSONObject, "settings_device_id");
    }

    public static String q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return n(jSONObject, "ab_device_id");
    }

    public static boolean n(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.equals(str, str2)) ? false : true;
    }

    public static JSONObject l(JSONObject jSONObject) throws JSONException {
        return tj(jSONObject);
    }

    public static JSONObject n() {
        try {
            String strQg = com.byazt.ikv.n.qg().qg("dev6103", "");
            if (TextUtils.isEmpty(strQg)) {
                return new JSONObject();
            }
            String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(strQg);
            if (TextUtils.isEmpty(strQ)) {
                return new JSONObject();
            }
            return new JSONObject(strQ);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void w(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable unused) {
                return;
            }
        }
        com.byazt.ikv.n.qg().n("dev6103", ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject.toString()));
    }

    public static JSONObject qg() {
        try {
            String strQg = com.byazt.ikv.n.qg().qg("dev6104", "");
            if (TextUtils.isEmpty(strQg)) {
                return new JSONObject();
            }
            String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(strQg);
            if (TextUtils.isEmpty(strQ)) {
                return new JSONObject();
            }
            return new JSONObject(strQ);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void x(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable unused) {
                return;
            }
        }
        com.byazt.ikv.n.qg().n("dev6104", ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject.toString()));
    }

    public static JSONObject fs(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return tj(jSONObject.optJSONObject("device"));
    }

    public static JSONObject rv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject("device");
    }

    public static void n(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("last_update", qg(System.currentTimeMillis()));
        boolean zN = n(str, str2);
        jSONObject.put("ab_device_id_diff", zN ? 1 : 0);
        if (zN) {
            JSONObject jSONObjectL = l(jSONObject2);
            JSONObject jSONObjectN = n();
            jSONObject.put("ab_device_id", n(str2));
            jSONObject.put("last_ab_device_id", n(str));
            jSONObject.put("last_request_context", jSONObjectN);
            jSONObject.put("current_request_context", jSONObjectL);
        }
    }

    public static long s() {
        long j = n;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        try {
            long jQg = com.byazt.ikv.n.qg().qg("dev6105", 0L);
            n = jQg;
            return jQg;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void n(long j) {
        if (j <= 0) {
            return;
        }
        n = j;
        try {
            com.byazt.ikv.n.qg().n("dev6105", j);
        } catch (Throwable unused) {
        }
    }

    public static void q() {
        n = Long.MIN_VALUE;
    }

    public static long qg(long j) {
        long jS = s();
        if (jS <= 0) {
            return -1L;
        }
        long j2 = j - jS;
        if (j2 < 0) {
            return -1L;
        }
        return j2;
    }

    public static void n(JSONObject jSONObject, n nVar) throws JSONException {
        if (jSONObject == null || nVar == null) {
            return;
        }
        boolean zN = n(nVar.qg, nVar.s);
        boolean zN2 = n(nVar.q, nVar.l);
        jSONObject.put("did_diff", zN ? 1 : 0);
        jSONObject.put("ab_device_id_diff", zN2 ? 1 : 0);
        if (zN) {
            jSONObject.put("did", n(nVar.s));
            jSONObject.put("last_did", n(nVar.qg));
        }
        if (zN2) {
            jSONObject.put("ab_device_id", n(nVar.l));
            jSONObject.put("last_ab_device_id", n(nVar.q));
        }
        if (zN || zN2) {
            JSONObject jSONObjectFs = nVar.x == null ? fs(nVar.n) : nVar.x;
            jSONObject.put("last_device", nVar.w == null ? new JSONObject() : nVar.w);
            if (jSONObjectFs == null) {
                jSONObjectFs = new JSONObject();
            }
            jSONObject.put("current_device", jSONObjectFs);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 470, 48})
    public static final class n {
        public final String l;
        public final JSONObject n;
        public final String q;
        public final String qg;
        public final String s;
        public final JSONObject w;
        public final JSONObject x;

        public n(JSONObject jSONObject, String str, String str2, String str3, String str4, JSONObject jSONObject2, JSONObject jSONObject3) {
            this.n = jSONObject;
            this.qg = str;
            this.s = str2;
            this.q = str3;
            this.l = str4;
            this.w = jSONObject2;
            this.x = jSONObject3;
        }
    }

    public static void n(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private static String n(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString(str);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    private static JSONObject tj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }
}
