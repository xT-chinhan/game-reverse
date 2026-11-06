package com.byazt.bsm;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1492, 19})
public class n {
    public static String n(String str, String str2, Uri uri) {
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str);
            jSONObject.put("plugin_pkg_name", str2);
            jSONObject.put(ContentProviderManager.PROVIDER_URI, uri != null ? uri.toString() : "");
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
