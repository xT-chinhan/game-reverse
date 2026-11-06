package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class k extends le {
    private final pc c;
    private final Context ka;

    k(Context context, pc pcVar) {
        super(false, false);
        this.ka = context;
        this.c = pcVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:14:0x002c). Please report as a decompilation issue!!! */
    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        String strEg;
        try {
            pc pcVar = this.c;
            if (pcVar == null) {
                strEg = null;
            } else if (pcVar.k()) {
                strEg = Settings.Secure.getString(this.ka.getContentResolver(), "android_id");
            } else {
                strEg = this.c.eg();
                if (TextUtils.isEmpty(strEg)) {
                    strEg = null;
                }
            }
        } catch (Exception e) {
            oh.ah("", e);
        }
        if (!jw.ms(strEg) || "9774d56d682e549c".equals(strEg)) {
            SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(this.ka, "snssdk_openudid", 0);
            String strXr = of.xr(sharedPreferencesXr.getString("custom_b", null));
            String string = TextUtils.isEmpty(strXr) ? sharedPreferencesXr.getString("openudid", null) : strXr;
            if (!jw.ms(string)) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
                if (string.charAt(0) == '-') {
                    string = string.substring(1);
                }
                int length = 13 - string.length();
                if (length > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (length > 0) {
                        sb.append('F');
                        length--;
                    }
                    sb.append(string);
                    string = sb.toString();
                }
                try {
                    string = ms("openudid.dat", string);
                } catch (Exception unused) {
                }
                String strMs = of.ms(string);
                SharedPreferences.Editor editorEdit = sharedPreferencesXr.edit();
                editorEdit.putString("custom_b", strMs);
                editorEdit.apply();
            }
            strEg = string;
        }
        jSONObject.put("openudid", strEg);
        return true;
    }
}
