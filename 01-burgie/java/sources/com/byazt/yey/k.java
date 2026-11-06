package com.byazt.yey;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 250})
public class k implements aj {
    @Override // com.byazt.yey.aj
    public boolean pr(com.byazt.tia.hw hwVar, int i, zo zoVar) {
        DownloadInfo downloadInfoHw;
        if (hwVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(hwVar.gu())) {
            downloadInfoHw = com.byazt.cvl.vk.pr((Context) null).pr(hwVar.gu(), null, true);
        } else {
            downloadInfoHw = com.byazt.cvl.vk.pr((Context) null).hw(hwVar.pr());
        }
        return ho.pr(hwVar, downloadInfoHw, i, zoVar, false, null);
    }
}
