package com.byazt.tuy;

import com.byazt.auw.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, 121})
public class x {
    public static boolean pr(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.byazt.ew.pr.pr(downloadInfo.getId()).hw("optimize_head_request") == 1;
    }

    public static boolean hw(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.byazt.ew.pr.pr(downloadInfo.getId()).hw("optimize_save_path") == 1;
    }
}
