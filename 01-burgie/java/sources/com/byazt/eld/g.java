package com.byazt.eld;

import com.byazt.auw.DownloadInfo;
import com.byazt.lj.lb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements lb {
    @Override // com.byazt.lj.lb
    public void pr(DownloadInfo downloadInfo, int i, int i2) {
        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("pause_reserve_wifi", jSONObject, hwVarPr);
    }
}
