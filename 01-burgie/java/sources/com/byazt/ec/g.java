package com.byazt.ec;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public static String pr = ":push";

    public static boolean pr(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean pr(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return pr((Object) jSONObject, (Object) jSONObject2);
    }

    public static String pr(Context context) {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            return ucVarY.pr(context);
        }
        return "";
    }

    public static boolean pr() {
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null) {
            return fwVarM.iu();
        }
        return true;
    }

    public static boolean hw() {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            return ucVarY.pr();
        }
        return false;
    }

    public static boolean hn() {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            return ucVarY.hw();
        }
        return false;
    }

    public static JSONObject pr(JSONObject jSONObject) {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            return ucVarY.pr(jSONObject);
        }
        return jSONObject;
    }

    public static void hw(JSONObject jSONObject, JSONObject jSONObject2) {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            ucVarY.pr(jSONObject, jSONObject2);
        }
    }

    public static String hw(JSONObject jSONObject) {
        try {
            byte[] bytes = jSONObject.toString().getBytes(Key.STRING_CHARSET_NAME);
            if (bytes.length == 0) {
                return "";
            }
            return com.byakv.z.TTEncryptUtils.clientPackedBase64(bytes, bytes.length);
        } catch (Exception e) {
            com.byazt.wx.pr.hw("parseEncrypt#parse error: " + e.getMessage());
            return "";
        }
    }

    public static JSONObject pr(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("aid", com.byazt.zrg.pr.fw());
            jSONObject2.putOpt("os", "android");
            jSONObject2.putOpt(an.y, Build.VERSION.RELEASE);
            jSONObject2.putOpt(an.F, Build.BRAND);
            jSONObject2.putOpt(an.ai, Build.MODEL);
            jSONObject2.putOpt("device_platform", "android");
            if (jSONObject != null) {
                jSONObject2.putOpt("app_version", jSONObject.optString("app_version"));
                if (TextUtils.isEmpty(str)) {
                    jSONObject2.putOpt("device_id", jSONObject.optString("device_id"));
                } else {
                    jSONObject2.putOpt("device_id", str);
                }
                jSONObject2.putOpt("device_model", jSONObject.optString("device_model"));
                jSONObject2.putOpt("os_api", Integer.valueOf(jSONObject.optInt("os_api")));
                jSONObject2.putOpt(an.s, jSONObject.optString(an.s));
                jSONObject2.putOpt(AbsServerManager.PACKAGE_QUERY_BINDER, jSONObject.optString(AbsServerManager.PACKAGE_QUERY_BINDER));
                jSONObject2.putOpt(Common.Predefined.SUB_ROM, jSONObject.optString(Common.Predefined.SUB_ROM));
                jSONObject2.putOpt("rom_version", com.byazt.kx.pr.hw());
                jSONObject2.putOpt("sdk_version", jSONObject.optString("sdk_version_name"));
                jSONObject2.putOpt("version_code", jSONObject.optString("version_code"));
            }
        } catch (Exception e) {
        }
        return jSONObject2;
    }

    public static SharedPreferences hw(Context context) {
        return com.byazt.mg.hw.hw(context, com.byazt.xa.zo.pr(), 0);
    }

    public static boolean x() {
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM == null) {
            return false;
        }
        return fwVarM.rc();
    }

    public static boolean c() {
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM == null) {
            return false;
        }
        return fwVarM.yb();
    }

    public static com.byazt.lq.uc uc() {
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM == null) {
            return null;
        }
        return fwVarM.y();
    }

    public static Looper fw() {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            return ucVarY.x();
        }
        return null;
    }

    public static Looper pr(com.byazt.xa.zo zoVar) {
        com.byazt.zrg.fw fwVarI;
        com.byazt.lq.uc ucVarY;
        if (zoVar == null || (fwVarI = zoVar.i()) == null || (ucVarY = fwVarI.y()) == null) {
            return null;
        }
        return ucVarY.hn();
    }

    public static Looper hw(com.byazt.xa.zo zoVar) {
        com.byazt.zrg.fw fwVarI;
        com.byazt.lq.uc ucVarY;
        if (zoVar == null || (fwVarI = zoVar.i()) == null || (ucVarY = fwVarI.y()) == null) {
            return null;
        }
        return ucVarY.x();
    }

    public static boolean hn(Context context) {
        String strPr = pr(context);
        return strPr != null && strPr.endsWith(pr);
    }

    public static JSONObject hn(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            w.hw(e);
        }
        return jSONObject;
    }

    public static String pr(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strPr = pr(str3, str2);
            String str4 = map.get(str3);
            String strPr2 = str4 != null ? pr(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(strPr).append("=").append(strPr2);
        }
        return sb.toString();
    }

    private static String pr(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static void pr(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                w.pr(th);
            }
        }
    }

    public static void pr(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                w.hw(th);
            }
        }
    }

    public static String pr(String str) {
        com.byazt.lq.uc ucVarY;
        com.byazt.zrg.fw fwVarM = com.byazt.zrg.pr.m();
        if (fwVarM != null && (ucVarY = fwVarM.y()) != null) {
            return ucVarY.pr(str);
        }
        return "";
    }

    public static JSONObject hn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        hn(jSONObject2, jSONObject);
        try {
            String strPr = com.byazt.xev.fw.pr(jSONObject2.optJSONObject("oaid"));
            if (!TextUtils.isEmpty(strPr)) {
                jSONObject2.put("oaid", strPr);
                return jSONObject2;
            }
            return jSONObject2;
        } catch (Exception e) {
            w.hw(e);
            return jSONObject2;
        }
    }
}
