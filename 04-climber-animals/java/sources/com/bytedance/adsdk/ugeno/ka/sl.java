package com.bytedance.adsdk.ugeno.ka;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl {
    public static c.ms ms(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c.ms msVar = new c.ms();
        String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(str, jSONObject);
        Uri uri = Uri.parse(strMs);
        if (uri == null) {
            return null;
        }
        msVar.ah(strMs);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            msVar.ms(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        msVar.xr(authority);
        msVar.d(msVar.ms() + "://" + msVar.xr());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.d.xr.ms(uri.getQueryParameter(str2), jSONObject));
            }
        }
        msVar.ms(map);
        return msVar;
    }
}
