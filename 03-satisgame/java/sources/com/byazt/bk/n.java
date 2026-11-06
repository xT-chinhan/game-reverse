package com.byazt.bk;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 19})
public class n {
    public static final HashMap<String, com.byazt.e.w.n> n = new HashMap<>();

    public static boolean n(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && n(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return qg(jSONObject) && n(jSONObject.optJSONArray("device_requirements")) && s(jSONObject);
    }

    public static boolean qg(JSONObject jSONObject) {
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
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean s(JSONObject jSONObject) {
        return jSONObject == null || w.n() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean n(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zN = false;
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
                for (String strTj : strOptString.split(",")) {
                    if ("market".equals(strTj)) {
                        strTj = l.tj();
                    }
                    com.byazt.e.w.n nVarQg = qg(strTj);
                    if (nVarQg != null && !(zN = n(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, nVarQg))) {
                        return false;
                    }
                }
            }
        }
        return zN;
    }

    private static boolean n(JSONArray jSONArray, JSONArray jSONArray2, String str, com.byazt.e.w.n nVar) {
        String strX = nVar.x();
        int iW = nVar.w();
        String str2 = iW + "_" + strX;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iW >= i2 && iW <= i3) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (qg(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !qg(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    private static boolean qg(JSONArray jSONArray, String str) {
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

    private static com.byazt.e.w.n qg(String str) {
        HashMap<String, com.byazt.e.w.n> map = n;
        if (map.containsKey(str)) {
            com.byazt.e.w.n nVar = map.get(str);
            if (nVar != null) {
                return nVar;
            }
            return null;
        }
        com.byazt.e.w.n nVarQg = com.byazt.e.w.qg(str);
        map.put(str, nVarQg);
        if (nVarQg != null) {
            return nVarQg;
        }
        return null;
    }

    public static com.byazt.e.w.n n(String str) {
        com.byazt.e.w.n nVarQg;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (nVarQg = qg(str)) == null) {
                return null;
            }
            return nVarQg;
        } catch (Throwable unused) {
        }
    }

    public static boolean n(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString(com.anythink.core.common.s.a);
            try {
                String strN = s.n(jSONObject.optString("az"), strOptString);
                String strN2 = s.n(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strN);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strN2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
