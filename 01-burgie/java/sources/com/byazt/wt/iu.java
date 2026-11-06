package com.byazt.wt;

import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 166})
public class iu {
    public static void pr(JSONObject jSONObject, of ofVar) {
        if (jSONObject == null || ofVar == null) {
            return;
        }
        try {
            JSONObject jSONObjectPr = com.byazt.ca.cz.pr().pr(ofVar.nl());
            int i = 0;
            if (jSONObjectPr != null && jSONObjectPr.has("click_calculation_type")) {
                int iOptInt = jSONObjectPr.optInt("click_calculation_type", 0);
                if (Math.abs(System.currentTimeMillis() - jSONObjectPr.optLong("click_calculation_time", 0L)) <= 2000) {
                    i = iOptInt;
                }
                com.byazt.ca.cz.pr().hw(ofVar.nl());
            }
            int iGg = ofVar.gg();
            int iKl = ofVar.kl();
            jSONObject.put("calculation_method", iGg);
            jSONObject.put("calculation_method_twist", iKl);
            jSONObject.put("click_calculation_type", i);
        } catch (Throwable th) {
        }
    }
}
