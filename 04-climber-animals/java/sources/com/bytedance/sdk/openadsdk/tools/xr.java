package com.bytedance.sdk.openadsdk.tools;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.basead.exoplayer.i.a;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.bz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static Map<Integer, String> ah = null;
    private static long d = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4132ms = "SettingRitRepertoryImpl";
    private static boolean xr = false;

    public static String ah() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static boolean ms() {
        return xr;
    }

    public static void xr() {
        xr = true;
    }

    public static String ms(int i, String str) {
        if (ah == null || System.currentTimeMillis() - d > a.f) {
            d = System.currentTimeMillis();
            ah = d();
        }
        Map<Integer, String> map = ah;
        if (map != null && !map.containsKey(Integer.valueOf(i))) {
            return str;
        }
        try {
            String strAh = com.bytedance.sdk.component.utils.ms.ah(map.get(Integer.valueOf(i)));
            return AbstractJsonLexerKt.NULL.equals(strAh) ? "" : strAh;
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053 A[PHI: r3
      0x0053: PHI (r3v3 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:21:0x0051, B:15:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    private static Map<Integer, String> d() {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "setting_global_info", new String[]{bz.d, f.a.d}, null, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex(bz.d));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(f.a.d));
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

    public static Map<String, String> ms(String str) throws JSONException {
        JSONObject jSONObjectXr = xr(str);
        HashMap map = null;
        if (jSONObjectXr == null) {
            return null;
        }
        String strOptString = jSONObjectXr.optString("ext");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(strOptString).optJSONObject(TTDownloadField.TT_HEADERS);
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

    /* JADX WARN: Code duplicated, block: B:43:0x0053 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject xr(String str) throws JSONException {
        int columnIndex;
        if (!ms()) {
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("config")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.ms.ah(string));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject;
            }
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            try {
                sl.xr(f4132ms, th);
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        return null;
    }

    public static void ms(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectXr = xr(str);
        if (jSONObjectXr == null) {
            return;
        }
        String strOptString = jSONObjectXr.optString("aid");
        String strOptString2 = jSONObjectXr.optString("cid");
        String strOptString3 = jSONObjectXr.optString("ext");
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject.put("ad_id", strOptString);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            jSONObject.put("creative_id", strOptString2);
        }
        if (TextUtils.isEmpty(strOptString3)) {
            return;
        }
        jSONObject.put("ext", strOptString3);
    }

    public static void xr(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectAh;
        if ((jSONObject == null && TextUtils.isEmpty(str)) || (jSONObjectAh = ah(str)) == null) {
            return;
        }
        if (jSONObjectAh.has("image_mode")) {
            jSONObject.put("image_mode", jSONObjectAh.optString("image_mode"));
        }
        if (jSONObjectAh.has("preview_extra")) {
            jSONObject.put("preview_extra", jSONObjectAh.optString("preview_extra"));
        }
        if (jSONObjectAh.has("preview_ads")) {
            jSONObject.put("preview_ads", jSONObjectAh.optJSONObject("preview_ads"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0053 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static JSONObject ah(String str) throws JSONException {
        int columnIndex;
        if (!ms()) {
            return null;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            String string = (!cursorQuery.moveToNext() || (columnIndex = cursorQuery.getColumnIndex("preview_ads")) < 0) ? "" : cursorQuery.getString(columnIndex);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.ms.ah(string));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject;
            }
            if (cursorQuery != null) {
            }
        } catch (Throwable th) {
            try {
                sl.xr(f4132ms, th);
            } finally {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
        return null;
    }

    public static void ms(String str, JSONObject jSONObject) {
        if (!ms() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObjectMs = com.bytedance.sdk.component.utils.ms.ms(jSONObject);
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(f.a.d, jSONObjectMs.toString());
        if (z) {
            com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.ms.ms.insert(re.getContext(), "setting_rit", contentValues);
        }
    }

    public static void ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (ms()) {
            String strD = xrVar.d();
            if (d(strD)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("img_width", xrVar.c());
                    jSONObject.put("img_height", xrVar.ab());
                    jSONObject.put("express_width", xrVar.x());
                    jSONObject.put("express_height", xrVar.ny());
                    jSONObject.put("ad_count", xrVar.sl());
                } catch (JSONException e) {
                    sl.ms(e);
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strD);
                contentValues.put("slot", com.bytedance.sdk.component.utils.ms.xr(jSONObject.toString()));
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), "setting_rit", contentValues, "rit=?", new String[]{strD});
            }
        }
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.multipro.ms.ms.delete(re.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    private static boolean d(String str) {
        boolean z;
        Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
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

    public static void xr(int i, String str) {
        if (ms()) {
            if (TextUtils.isEmpty(str)) {
                str = AbstractJsonLexerKt.NULL;
            }
            try {
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.ms(re.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + com.bytedance.sdk.component.utils.ms.xr(str) + "')");
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }

    public static void ah(int i, String str) {
        if (ms()) {
            if (TextUtils.isEmpty(str)) {
                str = AbstractJsonLexerKt.NULL;
            }
            Cursor cursorQuery = com.bytedance.sdk.openadsdk.core.multipro.ms.ms.query(re.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
            boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused) {
                }
            }
            String strXr = com.bytedance.sdk.component.utils.ms.xr(str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(bz.d, Integer.valueOf(i));
            contentValues.put(f.a.d, strXr);
            if (z) {
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.update(re.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.ms.ms.insert(re.getContext(), "setting_global_info", contentValues);
            }
        }
    }
}
