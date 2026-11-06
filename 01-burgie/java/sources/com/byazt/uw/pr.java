package com.byazt.uw;

import com.byazt.ca.ho;
import com.byazt.sd.zo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 99, 37})
public class pr {
    public static JSONObject pr = null;

    public static JSONObject pr() {
        if (pr == null) {
            pr = new JSONObject();
        }
        try {
            pr.put("use_mediation", zo.nt().v());
        } catch (Throwable th) {
            ho.hw("Tmee_TTEnvUtils", "getEvnJson error:" + th.toString());
        }
        return pr;
    }
}
