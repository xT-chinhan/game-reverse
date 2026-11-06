package com.byazt.sxm;

import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.lj.Downloader;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.cha.hn {
    @Override // com.byazt.cha.hn
    public void pr(int i, String str, JSONObject jSONObject) {
        com.byazt.tia.hw hwVarPr;
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = m.pr(jSONObject);
            com.byazt.cvl.pr.pr(jSONObject, downloadInfo);
            m.pr(jSONObject, "model_id", Long.valueOf(hwVarPr.hw()));
        }
        com.byazt.mf.pr.pr().hw(str, jSONObject, hwVarPr);
    }

    @Override // com.byazt.cha.hn
    public void hw(int i, String str, JSONObject jSONObject) {
        com.byazt.tia.hw hwVarPr;
        DownloadInfo downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo)) == null) {
            return;
        }
        com.byazt.mf.pr.pr().pr(str, jSONObject, hwVarPr);
    }
}
