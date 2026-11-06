package com.byazt.km;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.gc.AbsServerManager;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, 110})
public class sz {
    public static String n = ":push";

    public static boolean n(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return n((Object) jSONObject, (Object) jSONObject2);
    }

    public static String n(Context context) {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        return (xVarOa == null || (wVarV = xVarOa.v()) == null) ? "" : wVarV.n(context);
    }

    public static boolean n() {
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa != null) {
            return xVarOa.t();
        }
        return true;
    }

    public static boolean qg() {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null || (wVarV = xVarOa.v()) == null) {
            return false;
        }
        return wVarV.n();
    }

    public static boolean s() {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null || (wVarV = xVarOa.v()) == null) {
            return false;
        }
        return wVarV.qg();
    }

    public static JSONObject n(JSONObject jSONObject) {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        return (xVarOa == null || (wVarV = xVarOa.v()) == null) ? jSONObject : wVarV.n(jSONObject);
    }

    public static void qg(JSONObject jSONObject, JSONObject jSONObject2) {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null || (wVarV = xVarOa.v()) == null) {
            return;
        }
        wVarV.n(jSONObject, jSONObject2);
    }

    public static String qg(JSONObject jSONObject) {
        try {
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            return bytes.length == 0 ? "" : com.byakv.z.TTEncryptUtils.clientPackedBase64(bytes, bytes.length);
        } catch (Exception e) {
            com.byazt.nt.n.qg("parseEncrypt#parse error: " + e.getMessage());
            return "";
        }
    }

    public static JSONObject n(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("aid", com.byazt.wv.n.x());
            jSONObject2.putOpt(TapEventParamConstants.PARAM_SUB_OS, "android");
            jSONObject2.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject2.putOpt("device_brand", Build.BRAND);
            jSONObject2.putOpt("device_type", Build.MODEL);
            jSONObject2.putOpt("device_platform", "android");
            if (jSONObject != null) {
                jSONObject2.putOpt("app_version", jSONObject.optString("app_version"));
                if (TextUtils.isEmpty(str)) {
                    jSONObject2.putOpt(TapEventParamConstants.PARAM_DEVICE_ID, jSONObject.optString(TapEventParamConstants.PARAM_DEVICE_ID));
                } else {
                    jSONObject2.putOpt(TapEventParamConstants.PARAM_DEVICE_ID, str);
                }
                jSONObject2.putOpt(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, jSONObject.optString(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL));
                jSONObject2.putOpt("os_api", Integer.valueOf(jSONObject.optInt("os_api")));
                jSONObject2.putOpt("display_name", jSONObject.optString("display_name"));
                jSONObject2.putOpt(AbsServerManager.PACKAGE_QUERY_BINDER, jSONObject.optString(AbsServerManager.PACKAGE_QUERY_BINDER));
                jSONObject2.putOpt(TapEventParamConstants.PARAM_SUB_ROM, jSONObject.optString(TapEventParamConstants.PARAM_SUB_ROM));
                jSONObject2.putOpt("rom_version", com.byazt.sd.n.qg());
                jSONObject2.putOpt("sdk_version", jSONObject.optString("sdk_version_name"));
                jSONObject2.putOpt("version_code", jSONObject.optString("version_code"));
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public static SharedPreferences qg(Context context) {
        return com.byazt.qyu.qg.qg(context, com.byazt.ko.fs.n(), 0);
    }

    public static boolean q() {
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null) {
            return false;
        }
        return xVarOa.m();
    }

    public static boolean l() {
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null) {
            return false;
        }
        return xVarOa.hd();
    }

    public static com.byazt.zve.w w() {
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null) {
            return null;
        }
        return xVarOa.v();
    }

    public static Looper x() {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        if (xVarOa == null || (wVarV = xVarOa.v()) == null) {
            return null;
        }
        return wVarV.q();
    }

    public static Looper n(com.byazt.ko.fs fsVar) {
        com.byazt.wv.x xVarWo;
        com.byazt.zve.w wVarV;
        if (fsVar == null || (xVarWo = fsVar.wo()) == null || (wVarV = xVarWo.v()) == null) {
            return null;
        }
        return wVarV.s();
    }

    public static Looper qg(com.byazt.ko.fs fsVar) {
        com.byazt.wv.x xVarWo;
        com.byazt.zve.w wVarV;
        if (fsVar == null || (xVarWo = fsVar.wo()) == null || (wVarV = xVarWo.v()) == null) {
            return null;
        }
        return wVarV.q();
    }

    public static boolean s(Context context) {
        String strN = n(context);
        return strN != null && strN.endsWith(n);
    }

    public static JSONObject s(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            cp.qg(e);
        }
        return jSONObject;
    }

    public static String n(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strN = n(str3, str2);
            String str4 = map.get(str3);
            String strN2 = str4 != null ? n(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strN).append("=").append(strN2);
        }
        return sb.toString();
    }

    private static String n(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void n(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                cp.n(th);
            }
        }
    }

    public static void n(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                cp.qg(th);
            }
        }
    }

    public static String n(String str) {
        com.byazt.zve.w wVarV;
        com.byazt.wv.x xVarOa = com.byazt.wv.n.oa();
        return (xVarOa == null || (wVarV = xVarOa.v()) == null) ? "" : wVarV.n(str);
    }

    public static JSONObject s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        s(jSONObject2, jSONObject);
        try {
            String strN = com.byazt.yb.x.n(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strN)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strN);
            return jSONObject2;
        } catch (Exception e) {
            cp.qg(e);
            return jSONObject2;
        }
    }
}
