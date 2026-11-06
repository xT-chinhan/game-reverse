package com.byazt.lq;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.nf.rv;
import com.byazt.vf.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 751, 8})
public class s {
    public static String n = "SettingRitRepertoryImpl";
    public static long q = 0;
    public static boolean qg = false;
    public static Map<Integer, String> s;

    public static String s() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static boolean n() {
        return qg;
    }

    public static void qg() {
        qg = true;
    }

    public static String n(int i, String str) {
        if (s == null || System.currentTimeMillis() - q > 2000) {
            q = System.currentTimeMillis();
            s = q();
        }
        Map<Integer, String> map = s;
        if (map != null && !map.containsKey(Integer.valueOf(i))) {
            return str;
        }
        try {
            String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(map.get(Integer.valueOf(i)));
            return AbstractJsonLexerKt.NULL.equals(strQ) ? "" : strQ;
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053 A[PHI: r3
      0x0053: PHI (r3v3 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:21:0x0051, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    private static Map<Integer, String> q() {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.xp.n.query(rv.getContext(), "setting_global_info", new String[]{"_id", e.a.d}, null, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(e.a.d));
                        Integer numValueOf = Integer.valueOf(i);
                        if (string == null) {
                            string = "";
                        }
                        map.put(numValueOf, string);
                    } catch (Exception unused) {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return map;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public static Map<String, String> n(String str) throws JSONException {
        JSONObject jSONObjectQg = qg(str);
        HashMap map = null;
        if (jSONObjectQg == null) {
            return null;
        }
        String strOptString = jSONObjectQg.optString("ext");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject("headers");
                if (jSONObjectOptJSONObject == null) {
                    return null;
                }
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map2.put(next, jSONObjectOptJSONObject.optString(next));
                }
                return map2;
            } catch (Exception unused) {
                map = map2;
                return map;
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject qg(String str) throws JSONException {
        int columnIndex;
        if (!n()) {
            return null;
        }
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("config")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(string));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject;
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return null;
    }

    public static void n(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectQg = qg(str);
        if (jSONObjectQg == null) {
            return;
        }
        String strOptString = jSONObjectQg.optString("aid");
        String strOptString2 = jSONObjectQg.optString("cid");
        String strOptString3 = jSONObjectQg.optString("ext");
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject.put(MediationConstant.EXTRA_ADID, strOptString);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            jSONObject.put("creative_id", strOptString2);
        }
        if (TextUtils.isEmpty(strOptString3)) {
            return;
        }
        jSONObject.put("ext", strOptString3);
    }

    public static void qg(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectS;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (jSONObjectS = s(str)) == null) {
            return;
        }
        if (jSONObjectS.has("preview_ads_save_time") && System.currentTimeMillis() - jSONObjectS.optLong("preview_ads_save_time") > 3600000) {
            q(str);
            return;
        }
        if (jSONObjectS.has("image_mode")) {
            jSONObject.put("image_mode", jSONObjectS.optString("image_mode"));
        }
        if (jSONObjectS.has("preview_extra")) {
            jSONObject.put("preview_extra", jSONObjectS.optString("preview_extra"));
        }
        if (jSONObjectS.has("preview_ads")) {
            jSONObject.put("preview_ads", jSONObjectS.optJSONObject("preview_ads"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject s(String str) throws JSONException {
        int columnIndex;
        if (!n()) {
            return null;
        }
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("preview_ads")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(string));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject;
            }
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return null;
    }

    public static void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("preview_ads", "");
            com.byazt.xp.n.update(rv.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public static void n(String str, JSONObject jSONObject) {
        if (!n() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObjectN = com.byazt.cl.s.n(jSONObject == null ? null : jSONObject.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(e.a.d, jSONObjectN.toString());
        if (z) {
            com.byazt.xp.n.update(rv.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.byazt.xp.n.insert(rv.getContext(), "setting_rit", contentValues);
        }
    }

    public static void n(com.byazt.zq.qg qgVar) {
        if (n()) {
            String strQ = qgVar.q();
            if (l(strQ)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", qgVar.w());
                    jSONObject.put("img_height", qgVar.x());
                    jSONObject.put("express_width", qgVar.fs());
                    jSONObject.put("express_height", qgVar.rv());
                    jSONObject.put("ad_count", qgVar.d());
                } catch (JSONException unused) {
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strQ);
                contentValues.put("slot", ((k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject.toString()));
                com.byazt.xp.n.update(rv.getContext(), "setting_rit", contentValues, "rit=?", new String[]{strQ});
            }
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.xp.n.delete(rv.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    private static boolean l(String str) {
        boolean z;
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                z = cursorQuery.getCount() > 0;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return z;
    }

    public static void qg(int i, String str) {
        if (n()) {
            if (TextUtils.isEmpty(str)) {
                str = AbstractJsonLexerKt.NULL;
            }
            try {
                com.byazt.xp.n.n(rv.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + ((k) com.byazt.qp.q.n("encrypt_service")).s(str) + "')", "setting_base_info");
            } catch (Exception unused) {
            }
        }
    }

    public static void s(int i, String str) {
        if (n()) {
            if (TextUtils.isEmpty(str)) {
                str = AbstractJsonLexerKt.NULL;
            }
            Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
            boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused) {
                }
            }
            String strS = ((k) com.byazt.qp.q.n("encrypt_service")).s(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(i));
            contentValues.put(e.a.d, strS);
            if (z) {
                com.byazt.xp.n.update(rv.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
            } else {
                com.byazt.xp.n.insert(rv.getContext(), "setting_global_info", contentValues);
            }
        }
    }
}
