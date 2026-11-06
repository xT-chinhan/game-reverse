package com.byazt.ug;

import com.byazt.wm.DownloadInfo;
import com.byazt.xv.cd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 110})
public class sz implements cd {
    @Override // com.byazt.xv.cd
    public void n(DownloadInfo downloadInfo, int i, int i2) {
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("pause_reserve_wifi", jSONObject, qgVarN);
    }
}
