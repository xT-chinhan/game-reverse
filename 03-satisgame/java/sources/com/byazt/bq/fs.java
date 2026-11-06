package com.byazt.bq;

import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.vf.ae;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 101})
public class fs {
    public static volatile String n;
    public static volatile String qg;

    public static String n() {
        return "sp_exec_getad_config";
    }

    public static com.byazt.gwu.s n(String str, com.byazt.vf.n nVar) {
        return ((ae) com.byazt.qp.q.n("storage_service")).qg(nVar, str);
    }

    public static void n(String str, String str2, com.byazt.vf.n nVar) {
        try {
            n(n(), nVar).n(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static String qg(String str, String str2, com.byazt.vf.n nVar) {
        try {
            return n(n(), nVar).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void s(String str, String str2, com.byazt.vf.n nVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.a.d, str2);
            jSONObject.put("time", System.currentTimeMillis());
            n(str, jSONObject.toString(), nVar);
        } catch (JSONException unused) {
        }
    }

    public static String n(String str, long j, com.byazt.vf.n nVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strQg = qg(str, "", nVar);
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strQg);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(e.a.d);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String qg(String str, long j, com.byazt.vf.n nVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strQg = qg(str, "", nVar);
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strQg);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(e.a.d);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String n(com.byazt.vf.n nVar) {
        if (n == null) {
            n = qg("dev13", (String) null, nVar);
        }
        return n;
    }

    public static String qg(com.byazt.vf.n nVar) {
        if (qg == null) {
            qg = qg("dev15", (String) null, nVar);
        }
        return qg;
    }

    public static void qg(String str, com.byazt.vf.n nVar) {
        if (str == null || str.equals(n)) {
            return;
        }
        n = str;
        s("dev13", str, nVar);
    }

    public static void s(String str, com.byazt.vf.n nVar) {
        if (str == null || str.equals(qg)) {
            return;
        }
        qg = str;
        s("dev15", str, nVar);
    }
}
