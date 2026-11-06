package com.byazt.cd;

import com.byazt.gct.pk;
import com.byazt.tk.py;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 86, 19})
public class n {
    public static void n(JSONObject jSONObject, pk pkVar) {
        if (jSONObject == null || pkVar == null) {
            return;
        }
        try {
            JSONObject jSONObjectN = py.n().n(pkVar.v());
            int iOptInt = 0;
            if (jSONObjectN != null && jSONObjectN.has("click_calculation_type")) {
                iOptInt = Math.abs(System.currentTimeMillis() - jSONObjectN.optLong("click_calculation_time", 0L)) <= 2000 ? jSONObjectN.optInt("click_calculation_type", 0) : 0;
                py.n().qg(pkVar.v());
            }
            int iQd = pkVar.qd();
            int iOn = pkVar.on();
            jSONObject.put("calculation_method", iQd);
            jSONObject.put("calculation_method_twist", iOn);
            jSONObject.put("click_calculation_type", iOptInt);
        } catch (Throwable unused) {
        }
    }
}
