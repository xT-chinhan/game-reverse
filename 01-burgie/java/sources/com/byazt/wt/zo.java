package com.byazt.wt;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static volatile long pr = Long.MIN_VALUE;

    public static void pr(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        pr(jSONObject, "last_ab_device_id", nt.hw());
    }

    public static void hw(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        pr(jSONObject, "last_did", nt.pr());
        pr(jSONObject, "last_ab_device_id", nt.hn());
    }

    public static String hn(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strPr = pr(jSONObject, "ab_device_id");
        if (!TextUtils.isEmpty(strPr)) {
            return strPr;
        }
        return pr(jSONObject, "settings_device_id");
    }

    public static String x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return pr(jSONObject, "ab_device_id");
    }

    public static boolean pr(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.equals(str, str2)) ? false : true;
    }

    public static JSONObject c(JSONObject jSONObject) throws JSONException {
        return vk(jSONObject);
    }

    public static JSONObject pr() {
        try {
            String strHw = com.byazt.sd.hw.hw().hw("dev6103", "");
            if (TextUtils.isEmpty(strHw)) {
                return new JSONObject();
            }
            String strX = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(strHw);
            if (TextUtils.isEmpty(strX)) {
                return new JSONObject();
            }
            return new JSONObject(strX);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    public static void uc(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                return;
            }
        }
        com.byazt.sd.hw.hw().pr("dev6103", ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObject.toString()));
    }

    public static JSONObject hw() {
        try {
            String strHw = com.byazt.sd.hw.hw().hw("dev6104", "");
            if (TextUtils.isEmpty(strHw)) {
                return new JSONObject();
            }
            String strX = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(strHw);
            if (TextUtils.isEmpty(strX)) {
                return new JSONObject();
            }
            return new JSONObject(strX);
        } catch (Throwable th) {
            return new JSONObject();
        }
    }

    public static void fw(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                return;
            }
        }
        com.byazt.sd.hw.hw().pr("dev6104", ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObject.toString()));
    }

    public static JSONObject zo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        return vk(jSONObject.optJSONObject("device"));
    }

    public static JSONObject aj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject("device");
    }

    public static void pr(JSONObject jSONObject, JSONObject jSONObject2, String str, String str2) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        jSONObject.put("last_update", hw(System.currentTimeMillis()));
        boolean zPr = pr(str, str2);
        jSONObject.put("ab_device_id_diff", zPr ? 1 : 0);
        if (zPr) {
            JSONObject jSONObjectC = c(jSONObject2);
            JSONObject jSONObjectPr = pr();
            jSONObject.put("ab_device_id", pr(str2));
            jSONObject.put("last_ab_device_id", pr(str));
            jSONObject.put("last_request_context", jSONObjectPr);
            jSONObject.put("current_request_context", jSONObjectC);
        }
    }

    public static long hn() {
        long j = pr;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        try {
            long jHw = com.byazt.sd.hw.hw().hw("dev6105", 0L);
            pr = jHw;
            return jHw;
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static void pr(long j) {
        if (j <= 0) {
            return;
        }
        pr = j;
        try {
            com.byazt.sd.hw.hw().pr("dev6105", j);
        } catch (Throwable th) {
        }
    }

    public static void x() {
        pr = Long.MIN_VALUE;
    }

    public static long hw(long j) {
        long jHn = hn();
        if (jHn <= 0) {
            return -1L;
        }
        long j2 = j - jHn;
        if (j2 < 0) {
            return -1L;
        }
        return j2;
    }

    public static void pr(JSONObject jSONObject, pr prVar) throws JSONException {
        if (jSONObject == null || prVar == null) {
            return;
        }
        boolean zPr = pr(prVar.hw, prVar.hn);
        boolean zPr2 = pr(prVar.x, prVar.c);
        jSONObject.put("did_diff", zPr ? 1 : 0);
        jSONObject.put("ab_device_id_diff", zPr2 ? 1 : 0);
        if (zPr) {
            jSONObject.put("did", pr(prVar.hn));
            jSONObject.put("last_did", pr(prVar.hw));
        }
        if (zPr2) {
            jSONObject.put("ab_device_id", pr(prVar.c));
            jSONObject.put("last_ab_device_id", pr(prVar.x));
        }
        if (zPr || zPr2) {
            JSONObject jSONObjectZo = prVar.fw == null ? zo(prVar.pr) : prVar.fw;
            jSONObject.put("last_device", prVar.uc == null ? new JSONObject() : prVar.uc);
            if (jSONObjectZo == null) {
                jSONObjectZo = new JSONObject();
            }
            jSONObject.put("current_device", jSONObjectZo);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 673})
    public static final class pr {
        public final String c;
        public final JSONObject fw;
        public final String hn;
        public final String hw;
        public final JSONObject pr;
        public final JSONObject uc;
        public final String x;

        public pr(JSONObject jSONObject, String str, String str2, String str3, String str4, JSONObject jSONObject2, JSONObject jSONObject3) {
            this.pr = jSONObject;
            this.hw = str;
            this.hn = str2;
            this.x = str3;
            this.c = str4;
            this.uc = jSONObject2;
            this.fw = jSONObject3;
        }
    }

    public static void pr(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (jSONObject == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private static String pr(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString(str);
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        return strOptString;
    }

    private static String pr(String str) {
        return str == null ? "" : str;
    }

    private static JSONObject vk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (Throwable th) {
            return new JSONObject();
        }
    }
}
