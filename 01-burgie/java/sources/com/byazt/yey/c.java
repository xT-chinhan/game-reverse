package com.byazt.yey;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements fw {
    @Override // com.byazt.yey.fw
    public boolean pr(com.byazt.tia.hw hwVar, int i, zo zoVar, com.byazt.wc.hn hnVar) {
        DownloadInfo downloadInfoHw;
        if (hwVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(hwVar.gu())) {
            downloadInfoHw = com.byazt.cvl.vk.pr(com.byazt.eld.k.getContext()).pr(hwVar.gu(), null, true);
        } else {
            downloadInfoHw = com.byazt.cvl.vk.pr(com.byazt.eld.k.getContext()).hw(hwVar.pr());
        }
        return ho.pr(hwVar, downloadInfoHw, i, zoVar, true, hnVar);
    }
}
