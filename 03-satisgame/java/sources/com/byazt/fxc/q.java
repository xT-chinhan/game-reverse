package com.byazt.fxc;

import com.anythink.core.common.l.f;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1743, 5})
public class q {
    public static JSONObject n(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder("id=");
            sb.append(str).append("&timestamp=");
            sb.append(iCurrentTimeMillis).append("&ext=");
            sb.append(str2);
            String upperCase = com.byazt.tk.l.qg(sb.toString()).toUpperCase();
            jSONObject.put("id", str);
            jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, iCurrentTimeMillis);
            jSONObject.put(f.Y, upperCase);
            jSONObject.put("ext", str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
