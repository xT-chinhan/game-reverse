package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zd {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f542ms = ":push";

    public static boolean ms(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean ms(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return ms((Object) jSONObject, (Object) jSONObject2);
    }

    public static String ms(Context context) {
        ab abVarG;
        x xVarSl = ms.sl();
        return (xVarSl == null || (abVarG = xVarSl.g()) == null) ? "" : abVarG.ms(context);
    }

    public static boolean ms() {
        x xVarSl = ms.sl();
        if (xVarSl != null) {
            return xVarSl.yu();
        }
        return true;
    }

    public static boolean xr() {
        ab abVarG;
        x xVarSl = ms.sl();
        if (xVarSl == null || (abVarG = xVarSl.g()) == null) {
            return false;
        }
        return abVarG.ah();
    }

    public static String ah() {
        ab abVarG;
        x xVarSl = ms.sl();
        return (xVarSl == null || (abVarG = xVarSl.g()) == null) ? "" : abVarG.xr();
    }

    public static boolean d() {
        ab abVarG;
        x xVarSl = ms.sl();
        if (xVarSl == null || (abVarG = xVarSl.g()) == null) {
            return false;
        }
        return abVarG.d();
    }

    public static JSONObject ms(JSONObject jSONObject) {
        ab abVarG;
        x xVarSl = ms.sl();
        return (xVarSl == null || (abVarG = xVarSl.g()) == null) ? jSONObject : abVarG.ms(jSONObject);
    }

    public static Looper ms(pc pcVar) {
        x xVarFm;
        ab abVarG;
        if (pcVar == null || (xVarFm = pcVar.fm()) == null || (abVarG = xVarFm.g()) == null) {
            return null;
        }
        return abVarG.ka();
    }

    public static Looper xr(pc pcVar) {
        x xVarFm;
        ab abVarG;
        if (pcVar == null || (xVarFm = pcVar.fm()) == null || (abVarG = xVarFm.g()) == null) {
            return null;
        }
        return abVarG.c();
    }

    public static boolean xr(Context context) {
        String strMs = ms(context);
        return strMs != null && strMs.endsWith(f542ms);
    }

    public static JSONObject xr(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            oh.xr(e);
        }
        return jSONObject;
    }

    public static String ms(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strMs = ms(str3, str2);
            String str4 = map.get(str3);
            String strMs2 = str4 != null ? ms(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strMs).append("=").append(strMs2);
        }
        return sb.toString();
    }

    private static String ms(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void ms(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                oh.ms(th);
            }
        }
    }

    public static void ms(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                oh.xr(th);
            }
        }
    }

    public static String ms(String str) {
        ab abVarG;
        x xVarSl = ms.sl();
        return (xVarSl == null || (abVarG = xVarSl.g()) == null) ? "" : abVarG.ms(str);
    }

    public static JSONObject xr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        xr(jSONObject2, jSONObject);
        try {
            String strMs = vf.ms(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strMs)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strMs);
            return jSONObject2;
        } catch (Exception e) {
            oh.xr(e);
            return jSONObject2;
        }
    }
}
