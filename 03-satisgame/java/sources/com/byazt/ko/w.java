package com.byazt.ko;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 13})
public class w extends s {
    public final Context l;

    public w(Context context) {
        super(false, false);
        this.l = context;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg(this.l, "snssdk_openudid", 0);
        String strQg = qg(sharedPreferencesQg.getString("custom_a", null));
        if (TextUtils.isEmpty(strQg)) {
            strQg = sharedPreferencesQg.getString("clientudid", null);
        }
        if (!rv.n(strQg)) {
            try {
                strQg = UUID.randomUUID().toString();
                strQg = n("clientudid.dat", strQg);
            } catch (Exception unused) {
            }
            String strN = n(strQg);
            SharedPreferences.Editor editorEdit = sharedPreferencesQg.edit();
            editorEdit.putString("custom_a", strN);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strQg);
        return true;
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
