package com.byazt.wt;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 20})
public final class hn {
    public static long pr = 0;
    public static JSONObject hw = null;
    public static boolean hn = false;

    public static void pr() {
        if (!com.byazt.sd.zo.nt().w()) {
            pr |= 1;
        }
        if (!com.byazt.sd.zo.nt().x()) {
            pr |= 2;
        }
        if (!com.byazt.sd.zo.nt().yb().hw()) {
            pr |= 4;
        }
    }

    public static void pr(JSONObject jSONObject) {
        hw = jSONObject;
        if (!jSONObject.optBoolean("pglam_getwvid_enable", true)) {
            pr |= 8;
        }
    }

    public static JSONObject hw() {
        JSONObject jSONObject = hw;
        if (jSONObject != null) {
            return jSONObject;
        }
        String strHw = com.byazt.qn.x.hw(com.byazt.zb.pr.x(), com.byazt.is.w.c()).hw("pglam", "");
        if (TextUtils.isEmpty(strHw)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strHw);
            hw = jSONObject2;
            return jSONObject2;
        } catch (JSONException e) {
            return null;
        }
    }

    public static long hn() {
        if (!hn) {
            pr();
            hn = true;
        }
        if (hw == null) {
            JSONObject jSONObjectHw = hw();
            hw = jSONObjectHw;
            if (jSONObjectHw != null) {
                pr(jSONObjectHw);
            }
        }
        return pr;
    }
}
