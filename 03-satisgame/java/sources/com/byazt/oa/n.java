package com.byazt.oa;

import android.text.TextUtils;
import com.byazt.uj.hu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 19})
public class n {
    public static String n(String str, JSONObject jSONObject) {
        com.byazt.sz.n nVarN;
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            if (!str.startsWith("${") || !str.endsWith("}") || (nVarN = com.byazt.sz.n.n(str.substring(2, str.length() - 1))) == null) {
                return str;
            }
            Object objN = nVarN.n(jSONObject);
            if (objN instanceof String) {
                return (String) objN;
            }
            if (objN instanceof com.byazt.qy.n) {
                return String.valueOf(hu.n((com.byazt.qy.n) objN));
            }
            return String.valueOf(objN);
        } catch (Throwable unused) {
            return str;
        }
    }
}
