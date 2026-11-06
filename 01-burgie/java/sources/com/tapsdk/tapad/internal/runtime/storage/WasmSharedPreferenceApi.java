package com.tapsdk.tapad.internal.runtime.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tapsdk.tapad.group.constants.Constants;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WasmSharedPreferenceApi {
    private static final int CMD_CLEAR_NAMESPACE = 4;
    private static final int CMD_CONTAINS = 0;
    private static final int CMD_GET_STRING = 1;
    private static final int CMD_REMOVE = 3;
    private static final int CMD_SET_STRING = 2;
    private static final String DEFAULT_PREFS = "dirichlet_storage";
    private static final String TAG = "WasmSharedPreferenceApi";

    private WasmSharedPreferenceApi() {
    }

    public static int call(Context context, int i, String str, byte[] bArr) {
        if (context == null) {
            return -1;
        }
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String strValidatePrefsName = validatePrefsName(jSONObject.optString("namespace", DEFAULT_PREFS));
            if (strValidatePrefsName == null) {
                return -1;
            }
            String strOptString = jSONObject.optString("key", "");
            SharedPreferences sharedPreferences = context.getSharedPreferences(strValidatePrefsName, 0);
            switch (i) {
                case 0:
                    return (TextUtils.isEmpty(strOptString) || !sharedPreferences.contains(strOptString)) ? 0 : 1;
                case 1:
                    return getString(sharedPreferences, strOptString, bArr);
                case 2:
                    if (TextUtils.isEmpty(strOptString)) {
                        return -1;
                    }
                    putValue(sharedPreferences.edit(), strOptString, jSONObject.optString("type", "string"), jSONObject.optString(Constants.VALUE_FIELD, "")).apply();
                    return 1;
                case 3:
                    if (TextUtils.isEmpty(strOptString)) {
                        return -1;
                    }
                    sharedPreferences.edit().remove(strOptString).apply();
                    return 1;
                case 4:
                    sharedPreferences.edit().clear().apply();
                    return 1;
                default:
                    return -1;
            }
        } catch (Exception e) {
            e.getMessage();
            return -1;
        }
    }

    private static int getString(SharedPreferences sharedPreferences, String str, byte[] bArr) {
        String strValueOf;
        if (TextUtils.isEmpty(str) || !sharedPreferences.contains(str)) {
            return -1;
        }
        Object obj = sharedPreferences.getAll().get(str);
        if (obj instanceof String) {
            strValueOf = (String) obj;
        } else {
            strValueOf = obj != null ? String.valueOf(obj) : "";
        }
        byte[] bytes = (strValueOf != null ? strValueOf : "").getBytes(StandardCharsets.UTF_8);
        if (bArr != null && bArr.length > 0) {
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, bArr.length));
        }
        return bytes.length;
    }

    private static SharedPreferences.Editor putValue(SharedPreferences.Editor editor, String str, String str2, String str3) {
        if ("boolean".equals(str2) || "bool".equals(str2)) {
            return editor.putBoolean(str, Boolean.parseBoolean(str3));
        }
        if ("int".equals(str2) || "integer".equals(str2)) {
            return editor.putInt(str, Integer.parseInt(str3));
        }
        if ("long".equals(str2) || "i64".equals(str2)) {
            return editor.putLong(str, Long.parseLong(str3));
        }
        return ("float".equals(str2) || "f32".equals(str2)) ? editor.putFloat(str, Float.parseFloat(str3)) : editor.putString(str, str3);
    }

    private static String validatePrefsName(String str) {
        if (TextUtils.isEmpty(str)) {
            return DEFAULT_PREFS;
        }
        if (str.length() > 160 || str.contains("/") || str.contains("\\") || str.contains("..")) {
            return null;
        }
        return str;
    }
}
