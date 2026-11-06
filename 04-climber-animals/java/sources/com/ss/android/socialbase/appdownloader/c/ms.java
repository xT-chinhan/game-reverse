package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.ab;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final HashMap<String, ab.ms> f4563ms = new HashMap<>();

    public static boolean ms(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && ms(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return xr(jSONObject) && ms(jSONObject.optJSONArray("device_requirements")) && ah(jSONObject);
    }

    public static boolean xr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                int i3 = Integer.parseInt(strArrSplit[i2]);
                int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                if (i >= i3 && i <= i4) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return false;
    }

    public static boolean ah(JSONObject jSONObject) {
        return jSONObject == null || c.ms() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean ms(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zMs = false;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strCh : strOptString.split(",")) {
                    if ("market".equals(strCh)) {
                        strCh = ka.ch();
                    }
                    ab.ms msVarXr = xr(strCh);
                    if (msVarXr != null && !(zMs = ms(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, msVarXr))) {
                        return false;
                    }
                }
            }
        }
        return zMs;
    }

    private static boolean ms(JSONArray jSONArray, JSONArray jSONArray2, String str, ab.ms msVar) {
        String strAb = msVar.ab();
        int iC = msVar.c();
        String str2 = iC + "_" + strAb;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iC >= i2 && iC <= i3) {
                        return true;
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (xr(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !xr(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    private static boolean xr(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ab.ms xr(String str) {
        HashMap<String, ab.ms> map = f4563ms;
        if (map.containsKey(str)) {
            ab.ms msVar = map.get(str);
            if (msVar != null) {
                return msVar;
            }
            return null;
        }
        ab.ms msVarXr = ab.xr(str);
        map.put(str, msVarXr);
        if (msVarXr != null) {
            return msVarXr;
        }
        return null;
    }

    public static ab.ms ms(String str) {
        ab.ms msVarXr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (msVarXr = xr(str)) == null) {
                return null;
            }
            return msVarXr;
        } catch (Throwable unused) {
        }
    }

    public static boolean ms(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("s");
            try {
                String strMs = ah.ms(jSONObject.optString("az"), strOptString);
                String strMs2 = ah.ms(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strMs);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strMs2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
