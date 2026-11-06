package com.byazt.km;

import android.text.TextUtils;
import com.byazt.vf.ae;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 18})
public class l {
    public static String n = "value";
    public static String qg = "time";
    public static String s = "p_version";

    public static String n() {
        return "sp_exec_getad_config";
    }

    public static com.byazt.gwu.s n(com.byazt.vf.n nVar) {
        return ((ae) com.byazt.qp.q.n("storage_service")).qg(nVar, n());
    }

    public static void n(com.byazt.zve.n nVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(n, str2);
            jSONObject.put(qg, System.currentTimeMillis());
            jSONObject.put(s, nVar.cy());
            n(nVar.k()).n(str, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }
}
