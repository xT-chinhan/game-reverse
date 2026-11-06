package com.byazt.lpr;

import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 18})
public class l {
    public static Boolean n;

    private static boolean n() {
        if (n == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant$RitScenes");
                n = Boolean.TRUE;
            } catch (Throwable unused) {
                n = Boolean.FALSE;
            }
        }
        return n.booleanValue();
    }

    public static String n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return "game_more_kllkrtunities".equalsIgnoreCase(str) ? n(str) : str;
        }
        if (n()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
