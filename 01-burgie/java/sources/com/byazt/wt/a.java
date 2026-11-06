package com.byazt.wt;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a {
    public static volatile long hw;
    public static volatile String pr;

    public static String pr() {
        return ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hn(false)[0];
    }

    public static String hw() {
        return ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hn(false)[1];
    }

    public static String hn() {
        String str;
        Map<String, String> mapC = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).c(false);
        if (mapC == null) {
            str = null;
        } else {
            str = mapC.get("zaid_ipv6");
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static JSONArray pr(com.byazt.vkw.pr prVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            Map<String, String> mapC = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).c(false);
            if (mapC != null) {
                String str = mapC.get("register_ipv6");
                if (!TextUtils.isEmpty(str)) {
                    return new JSONArray(str);
                }
                return jSONArray;
            }
            return jSONArray;
        } catch (Exception e) {
            return jSONArray;
        }
    }

    public static String[] pr(boolean z, com.byazt.vkw.pr prVar) {
        String[] strArr = {"", ""};
        try {
            Map<String, String> mapC = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).c(z);
            if (mapC != null) {
                strArr[0] = mapC.get("enc_ipv4");
                strArr[1] = mapC.get("enc_ipv6");
                return strArr;
            }
        } catch (Throwable th) {
        }
        return strArr;
    }

    public static void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.mp.x.pr().hn("dev14", ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(str));
        pr = str;
        hw = System.currentTimeMillis();
    }

    @JProtect
    public static String hw(String str) {
        if (!TextUtils.isEmpty(pr) && !DeviceUtils.pr(hw, 1800000L)) {
            return pr;
        }
        String strHn = com.byazt.mp.x.pr().hn("dev14", 1800000L);
        if (TextUtils.isEmpty(strHn)) {
            if (str == null) {
                str = pr();
            }
            pr = str;
        } else {
            pr = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(strHn);
        }
        hw = System.currentTimeMillis();
        return pr;
    }

    public static String[] hw(com.byazt.vkw.pr prVar) {
        String[] strArr = {"", ""};
        Map<String, String> mapC = ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).c(false);
        if (mapC != null) {
            strArr[0] = mapC.get("local_ipv4");
            strArr[1] = mapC.get("local_ipv6");
        }
        return strArr;
    }
}
