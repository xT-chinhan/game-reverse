package com.byazt.vs;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class t extends com.byazt.cf.l<JSONObject, JSONObject> {
    public final Context n;

    public t(Context context) {
        this.n = context;
    }

    public static void n(com.byazt.cf.cy cyVar, Context context) {
        cyVar.n("openLiveRoom", (com.byazt.cf.l<?, ?>) new t(context));
    }

    @Override // com.byazt.cf.l
    public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int iN = -1;
        try {
            long jN = n(jSONObject);
            if (jN > 0 && this.n != null) {
                iN = com.byazt.wq.qg.n().n(this.n, jN);
            }
        } catch (Throwable th) {
            com.byazt.tk.k.qg("OpenLiveRoomMethod", "method:" + th.getMessage());
        }
        jSONObject2.put("code", iN);
        return jSONObject2;
    }

    private static long n(JSONObject jSONObject) {
        try {
            return Long.parseLong(jSONObject.optString("room_id", "0"));
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
