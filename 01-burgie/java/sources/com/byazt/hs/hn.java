package com.byazt.hs;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.vkw.nt;
import com.byazt.wt.rc;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.analytics.pro.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 20})
public class hn {
    public static Map<Integer, String> hn;
    public static String pr = "SettingRitRepertoryImpl";
    public static boolean hw = false;
    public static long x = 0;

    public static boolean pr() {
        return hw;
    }

    public static void hw() {
        hw = true;
    }

    public static String hn() {
        return "CREATE TABLE IF NOT EXISTS setting_rit (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT UNIQUE,value TEXT,slot TEXT,config TEXT,preview_ads TEXT)";
    }

    public static String pr(int i, String str) {
        if (hn == null || System.currentTimeMillis() - x > 2000) {
            x = System.currentTimeMillis();
            hn = x();
        }
        Map<Integer, String> map = hn;
        if (map != null && !map.containsKey(Integer.valueOf(i))) {
            return str;
        }
        try {
            String strX = ((nt) uc.pr("encrypt_service")).x(map.get(Integer.valueOf(i)));
            return AbstractJsonLexerKt.NULL.equals(strX) ? "" : strX;
        } catch (Exception e) {
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0059 A[PHI: r3
      0x0059: PHI (r3v3 android.database.Cursor) = (r3v0 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:25:0x0057, B:17:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    private static Map<Integer, String> x() {
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.ad.pr.query(a.getContext(), "setting_global_info", new String[]{ar.d, Constants.VALUE_FIELD}, null, null, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return map;
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex(ar.d));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(Constants.VALUE_FIELD));
                        Integer numValueOf = Integer.valueOf(i);
                        if (string == null) {
                            string = "";
                        }
                        map.put(numValueOf, string);
                    } catch (Exception e) {
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
        } catch (Exception e2) {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public static Map<String, String> pr(String str) throws JSONException {
        JSONObject jSONObjectHw = hw(str);
        HashMap map = null;
        if (jSONObjectHw == null) {
            return null;
        }
        String strOptString = jSONObjectHw.optString("ext");
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
            } catch (Exception e) {
                map = map2;
                return map;
            }
        } catch (Exception e2) {
        }
    }

    public static JSONObject hw(String str) throws JSONException {
        String string;
        int columnIndex;
        if (!pr()) {
            return null;
        }
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            try {
                if (cursorQuery.moveToNext() && (columnIndex = cursorQuery.getColumnIndex("config")) >= 0) {
                    string = cursorQuery.getString(columnIndex);
                } else {
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(((nt) uc.pr("encrypt_service")).x(string));
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th) {
                        }
                    }
                    return jSONObject;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th3) {
        }
        return null;
    }

    public static void pr(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectHw = hw(str);
        if (jSONObjectHw == null) {
            return;
        }
        String strOptString = jSONObjectHw.optString("aid");
        String strOptString2 = jSONObjectHw.optString("cid");
        String strOptString3 = jSONObjectHw.optString("ext");
        if (!TextUtils.isEmpty(strOptString)) {
            jSONObject.put(MediationConstant.EXTRA_ADID, strOptString);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            jSONObject.put("creative_id", strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString3)) {
            jSONObject.put("ext", strOptString3);
        }
    }

    public static void hw(JSONObject jSONObject, String str) throws JSONException {
        JSONObject jSONObjectHn;
        if ((jSONObject != null || !TextUtils.isEmpty(str)) && (jSONObjectHn = hn(str)) != null) {
            if (jSONObjectHn.has("preview_ads_save_time") && System.currentTimeMillis() - jSONObjectHn.optLong("preview_ads_save_time") > 3600000) {
                x(str);
                return;
            }
            if (jSONObjectHn.has("image_mode")) {
                jSONObject.put("image_mode", jSONObjectHn.optString("image_mode"));
            }
            if (jSONObjectHn.has("preview_extra")) {
                jSONObject.put("preview_extra", jSONObjectHn.optString("preview_extra"));
            }
            if (jSONObjectHn.has("preview_ads")) {
                jSONObject.put("preview_ads", jSONObjectHn.optJSONObject("preview_ads"));
            }
        }
    }

    public static JSONObject hn(String str) throws JSONException {
        String string;
        int columnIndex;
        if (!pr()) {
            return null;
        }
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        }
        try {
            try {
                if (cursorQuery.moveToNext() && (columnIndex = cursorQuery.getColumnIndex("preview_ads")) >= 0) {
                    string = cursorQuery.getString(columnIndex);
                } else {
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(((nt) uc.pr("encrypt_service")).x(string));
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th) {
                        }
                    }
                    return jSONObject;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Throwable th3) {
        }
        return null;
    }

    public static void x(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("preview_ads", "");
                com.byazt.ad.pr.update(a.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
            } catch (Throwable th) {
            }
        }
    }

    public static void pr(String str, JSONObject jSONObject) {
        if (!pr() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Throwable th) {
            }
        }
        JSONObject jSONObjectPr = rc.pr(jSONObject == null ? null : jSONObject.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put(Constants.VALUE_FIELD, jSONObjectPr.toString());
        if (z) {
            com.byazt.ad.pr.update(a.getContext(), "setting_rit", contentValues, "rit=?", new String[]{str});
        } else {
            com.byazt.ad.pr.insert(a.getContext(), "setting_rit", contentValues);
        }
    }

    public static void pr(com.byazt.qe.hw hwVar) {
        if (!pr()) {
            return;
        }
        String strX = hwVar.x();
        if (!c(strX)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("img_width", hwVar.uc());
            jSONObject.put("img_height", hwVar.fw());
            jSONObject.put("express_width", hwVar.zo());
            jSONObject.put("express_height", hwVar.aj());
            jSONObject.put("ad_count", hwVar.k());
        } catch (JSONException e) {
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", strX);
        contentValues.put("slot", ((nt) uc.pr("encrypt_service")).hn(jSONObject.toString()));
        com.byazt.ad.pr.update(a.getContext(), "setting_rit", contentValues, "rit=?", new String[]{strX});
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ad.pr.delete(a.getContext(), "setting_rit", "rit=?", new String[]{str});
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026  */
    private static boolean c(String str) {
        boolean z;
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "setting_rit", null, "rit=?", new String[]{str}, null, null, null);
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

    public static void hw(int i, String str) {
        if (!pr()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = AbstractJsonLexerKt.NULL;
        }
        try {
            com.byazt.ad.pr.pr(a.getContext(), "INSERT OR REPLACE INTO setting_base_info (_id, value) VALUES (" + i + ", '" + ((nt) uc.pr("encrypt_service")).hn(str) + "')", "setting_base_info");
        } catch (Exception e) {
        }
    }

    public static void hn(int i, String str) {
        if (!pr()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = AbstractJsonLexerKt.NULL;
        }
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "setting_global_info", null, "_id=?", new String[]{String.valueOf(i)}, null, null, null);
        boolean z = cursorQuery != null && cursorQuery.getCount() > 0;
        if (cursorQuery != null) {
            try {
                cursorQuery.close();
            } catch (Exception e) {
            }
        }
        String strHn = ((nt) uc.pr("encrypt_service")).hn(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ar.d, Integer.valueOf(i));
        contentValues.put(Constants.VALUE_FIELD, strHn);
        if (z) {
            com.byazt.ad.pr.update(a.getContext(), "setting_global_info", contentValues, "_id=?", new String[]{String.valueOf(i)});
        } else {
            com.byazt.ad.pr.insert(a.getContext(), "setting_global_info", contentValues);
        }
    }
}
