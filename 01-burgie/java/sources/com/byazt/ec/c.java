package com.byazt.ec;

import android.text.TextUtils;
import com.byazt.vkw.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static String pr = Constants.VALUE_FIELD;
    public static String hw = "time";
    public static String hn = "p_version";

    public static com.byazt.zq.hn pr(com.byazt.vkw.pr prVar) {
        return ((s) com.byazt.zs.uc.pr("storage_service")).hw(prVar, pr());
    }

    public static String pr() {
        return "sp_exec_getad_config";
    }

    public static void pr(com.byazt.lq.pr prVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(pr, str2);
            jSONObject.put(hw, System.currentTimeMillis());
            jSONObject.put(hn, prVar.nt());
            pr(prVar.ho()).pr(str, jSONObject.toString());
        } catch (JSONException e) {
        }
    }
}
