package com.byazt.rm;

import com.byazt.tk.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 578, 19})
public class n {
    public static JSONObject n;

    public static JSONObject n() {
        if (n == null) {
            n = new JSONObject();
        }
        try {
            n.put("use_mediation", com.byazt.vyf.s.cy().oj());
        } catch (Throwable th) {
            k.qg("Tmee_TTEnvUtils", "getEvnJson error:" + th.toString());
        }
        return n;
    }
}
