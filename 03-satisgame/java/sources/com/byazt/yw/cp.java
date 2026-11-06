package com.byazt.yw;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 29})
public final class cp {
    public static void n(com.byazt.ub.n nVar, com.byazt.ub.qg qgVar, com.byazt.qf.s sVar) {
        if (nVar == null || nVar.n() == null || sVar == null) {
            return;
        }
        JSONObject jSONObjectN = nVar.n();
        long jOptLong = jSONObjectN.optLong("crash_time");
        int iQg = qg(n("aid"));
        String strN = com.byazt.qf.fs.s().n();
        if (jOptLong <= 0 || iQg <= 0 || TextUtils.isEmpty(strN) || "0".equals(strN) || TextUtils.isEmpty(sVar.n())) {
            return;
        }
        try {
            String str = "android_" + iQg + "_" + strN + "_" + jOptLong + "_" + sVar;
            if (qgVar != null) {
                JSONObject jSONObjectN2 = qgVar.n();
                if (jSONObjectN2 != null) {
                    jSONObjectN2.put("unique_key", str);
                    return;
                }
                return;
            }
            jSONObjectN.put("unique_key", str);
        } catch (JSONException unused) {
        }
    }

    public static String n(String str) {
        Map<String, Object> mapN;
        if (com.byazt.qf.fs.n() == null || (mapN = com.byazt.qf.fs.n().n()) == null) {
            return null;
        }
        Object obj = mapN.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static int qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            tj.qg(e);
            return 0;
        }
    }
}
