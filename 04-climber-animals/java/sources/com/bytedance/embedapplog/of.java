package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class of extends le {
    private final Context ka;

    of(Context context) {
        super(false, false);
        this.ka = context;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.ka, "snssdk_openudid", 0);
        String strXr = xr(sharedPreferencesXr.getString("custom_a", null));
        if (TextUtils.isEmpty(strXr)) {
            strXr = sharedPreferencesXr.getString("clientudid", null);
        }
        if (!jw.ms(strXr)) {
            try {
                strXr = UUID.randomUUID().toString();
                strXr = ms("clientudid.dat", strXr);
            } catch (Exception unused) {
            }
            String strMs = ms(strXr);
            SharedPreferences.Editor editorEdit = sharedPreferencesXr.edit();
            editorEdit.putString("custom_a", strMs);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strXr);
        return true;
    }

    public static String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return str;
        }
    }

    public static String xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return str;
        }
    }
}
