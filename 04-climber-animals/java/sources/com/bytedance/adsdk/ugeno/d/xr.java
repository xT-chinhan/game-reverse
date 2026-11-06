package com.bytedance.adsdk.ugeno.d;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.d;
import com.bytedance.sdk.component.utils.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static String ms(String str, JSONObject jSONObject) {
        ms msVarAh;
        ms.InterfaceC0193ms interfaceC0193msMs;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (msVarAh = d.ms().ah()) == null || (interfaceC0193msMs = msVarAh.ms(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0193msMs.ms(jSONObject);
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return str;
    }
}
