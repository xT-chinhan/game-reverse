package com.bytedance.sdk.openadsdk.core.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.re;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean ms(String str) {
        int iWq;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String strXr = g.ms("fsswiper_freq").xr(str, "");
            return !TextUtils.isEmpty(strXr) && (iWq = re.xr().wq()) > 0 && new JSONObject(strXr).optInt(ms(), 0) >= iWq;
        } catch (Exception unused) {
        }
    }

    public static void xr(String str) {
        ah(str);
    }

    private static void ah(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = g.ms("fsswiper_freq");
        try {
            String strXr = xrVarMs.xr(str, "");
            if (TextUtils.isEmpty(strXr)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strXr);
            }
            String strMs = ms();
            int iOptInt = jSONObject.optInt(strMs, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(strMs, iOptInt + 1);
            xrVarMs.ms(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    private static String ms() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
