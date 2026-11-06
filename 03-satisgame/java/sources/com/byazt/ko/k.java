package com.byazt.ko;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 210})
public class k extends s {
    public final Context l;
    public final fs w;

    public k(Context context, fs fsVar) {
        super(false, false);
        this.l = context;
        this.w = fsVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:14:0x002c). Please report as a decompilation issue!!! */
    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        String strPk;
        try {
            fs fsVar = this.w;
            if (fsVar == null) {
                strPk = null;
            } else if (fsVar.u()) {
                strPk = Settings.Secure.getString(this.l.getContentResolver(), "android_id");
            } else {
                strPk = this.w.pk();
                if (TextUtils.isEmpty(strPk)) {
                    strPk = null;
                }
            }
        } catch (Exception e) {
            com.byazt.km.cp.s("", e);
        }
        if (!rv.n(strPk) || "9774d56d682e549c".equals(strPk)) {
            SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg(this.l, "snssdk_openudid", 0);
            String strQg = w.qg(sharedPreferencesQg.getString("custom_b", null));
            String string = TextUtils.isEmpty(strQg) ? sharedPreferencesQg.getString("openudid", null) : strQg;
            if (!rv.n(string)) {
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
                    string = n("openudid.dat", string);
                } catch (Exception unused) {
                }
                String strN = w.n(string);
                SharedPreferences.Editor editorEdit = sharedPreferencesQg.edit();
                editorEdit.putString("custom_b", strN);
                editorEdit.apply();
            }
            strPk = string;
        }
        jSONObject.put("openudid", strPk);
        return true;
    }
}
