package com.byazt.jc;

import com.byazt.nf.rv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1447, 19})
public class n {
    public static boolean n() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectZe = rv.qg().ze();
        if (jSONObjectZe == null) {
            return false;
        }
        return jCurrentTimeMillis >= jSONObjectZe.optLong("start", 1707480000000L) && jCurrentTimeMillis <= jSONObjectZe.optLong("end", 1707498000000L);
    }

    public static boolean qg() {
        JSONObject jSONObjectZe = rv.qg().ze();
        return jSONObjectZe != null && n() && jSONObjectZe.optInt("force_drop", 0) == 1;
    }
}
