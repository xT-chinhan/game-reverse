package com.byazt.shh;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static volatile zo pr;

    private zo() {
    }

    public static zo pr() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new zo();
                }
            }
        }
        return pr;
    }

    public void pr(int i, int i2, com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(hwVar.qa());
        if (prVarPr.pr("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i > 0 && i3 > prVarPr.pr("check_api_hijack_version_code_diff", 500)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version_code_diff", i3);
                jSONObject.put("installed_version_code", i2);
                jSONObject.put("hijack_type", 1);
            } catch (JSONException e) {
            }
            com.byazt.mf.pr.pr().hw("api_hijack", jSONObject, hwVar);
        }
    }
}
