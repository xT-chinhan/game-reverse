package com.byazt.fp;

import android.text.TextUtils;
import com.byazt.vkw.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static volatile String hw;
    public static volatile String pr;

    public static com.byazt.zq.hn pr(String str, com.byazt.vkw.pr prVar) {
        return ((s) com.byazt.zs.uc.pr("storage_service")).hw(prVar, str);
    }

    public static void pr(String str, String str2, com.byazt.vkw.pr prVar) {
        try {
            pr(pr(), prVar).pr(str, str2);
        } catch (Throwable th) {
        }
    }

    public static String hw(String str, String str2, com.byazt.vkw.pr prVar) {
        try {
            return pr(pr(), prVar).getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public static void hn(String str, String str2, com.byazt.vkw.pr prVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.VALUE_FIELD, str2);
            jSONObject.put("time", System.currentTimeMillis());
            pr(str, jSONObject.toString(), prVar);
        } catch (JSONException e) {
        }
    }

    public static String pr(String str, long j, com.byazt.vkw.pr prVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strHw = hw(str, "", prVar);
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strHw);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(Constants.VALUE_FIELD);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static String hw(String str, long j, com.byazt.vkw.pr prVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strHw = hw(str, "", prVar);
            if (TextUtils.isEmpty(strHw)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strHw);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(Constants.VALUE_FIELD);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static String pr() {
        return "sp_exec_getad_config";
    }

    public static String pr(com.byazt.vkw.pr prVar) {
        if (pr == null) {
            pr = hw("dev13", (String) null, prVar);
        }
        return pr;
    }

    public static String hw(com.byazt.vkw.pr prVar) {
        if (hw == null) {
            hw = hw("dev15", (String) null, prVar);
        }
        return hw;
    }

    public static void hw(String str, com.byazt.vkw.pr prVar) {
        if (str == null || str.equals(pr)) {
            return;
        }
        pr = str;
        hn("dev13", str, prVar);
    }

    public static void hn(String str, com.byazt.vkw.pr prVar) {
        if (str == null || str.equals(hw)) {
            return;
        }
        hw = str;
        hn("dev15", str, prVar);
    }
}
