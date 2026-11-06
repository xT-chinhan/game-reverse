package com.byazt.bok;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 5})
public class q {
    public static void n(l<?> lVar, Throwable th, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("exception_class", lVar != null ? lVar.getClass().getName() : null);
            jSONObject.putOpt("exception_detail", th != null ? Log.getStackTraceString(th) : null);
            jSONObject.putOpt("l_type", n(str, str2));
            com.byazt.eji.s.n().n("tt_lifecycle_monitor", jSONObject);
        } catch (Throwable unused) {
        }
    }

    private static String n(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str + "_" + str2;
    }
}
