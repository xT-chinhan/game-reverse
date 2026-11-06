package com.byazt.now;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1862, 37})
public class pr {
    public static final HashMap<String, com.byazt.mdu.uc.pr> pr = new HashMap<>();

    public static boolean pr(JSONArray jSONArray, String str) {
        if (jSONArray == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && pr(jSONObjectOptJSONObject)) {
                return true;
            }
        }
        return false;
    }

    public static boolean pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return hw(jSONObject) && pr(jSONObject.optJSONArray("device_requirements")) && hn(jSONObject);
    }

    public static boolean hw(JSONObject jSONObject) {
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
        }
        return false;
    }

    public static boolean hn(JSONObject jSONObject) {
        return jSONObject == null || uc.pr() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean pr(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zPr = false;
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
                for (String strVk : strOptString.split(",")) {
                    if (BaseConstants.SCHEME_MARKET.equals(strVk)) {
                        strVk = c.vk();
                    }
                    com.byazt.mdu.uc.pr prVarHw = hw(strVk);
                    if (prVarHw != null && !(zPr = pr(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, prVarHw))) {
                        return false;
                    }
                }
            }
        }
        return zPr;
    }

    private static boolean pr(JSONArray jSONArray, JSONArray jSONArray2, String str, com.byazt.mdu.uc.pr prVar) {
        String strFw = prVar.fw();
        int iUc = prVar.uc();
        String str2 = iUc + "_" + strFw;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iUc >= i2 && iUc <= i3) {
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (hw(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !hw(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    private static boolean hw(JSONArray jSONArray, String str) {
        if (jSONArray == null || str == null) {
            return false;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                return true;
            }
        }
        return false;
    }

    private static com.byazt.mdu.uc.pr hw(String str) {
        HashMap<String, com.byazt.mdu.uc.pr> map = pr;
        if (map.containsKey(str)) {
            com.byazt.mdu.uc.pr prVar = map.get(str);
            if (prVar != null) {
                return prVar;
            }
            return null;
        }
        com.byazt.mdu.uc.pr prVarHw = com.byazt.mdu.uc.hw(str);
        map.put(str, prVarHw);
        if (prVarHw != null) {
            return prVarHw;
        }
        return null;
    }

    public static com.byazt.mdu.uc.pr pr(String str) {
        com.byazt.mdu.uc.pr prVarHw;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (prVarHw = hw(str)) == null) {
                return null;
            }
            return prVarHw;
        } catch (Throwable th) {
        }
    }

    public static boolean pr(JSONObject jSONObject, Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null || jSONObject == null) {
            return false;
        }
        String strOptString = jSONObject.optString(an.aB);
        try {
            String strPr = hn.pr(jSONObject.optString("az"), strOptString);
            String strPr2 = hn.pr(jSONObject.optString("ba"), strOptString);
            Field declaredField = ContextWrapper.class.getDeclaredField(strPr);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(context);
            Field declaredField2 = obj.getClass().getDeclaredField(strPr2);
            declaredField2.setAccessible(true);
            declaredField2.set(obj, str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
