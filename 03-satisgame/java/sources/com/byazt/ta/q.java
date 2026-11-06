package com.byazt.ta;

import com.byazt.wm.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 5})
public class q {
    public static boolean n(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.byazt.f.n.n(downloadInfo.getId()).qg("optimize_head_request") == 1;
    }

    public static boolean qg(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.byazt.f.n.n(downloadInfo.getId()).qg("optimize_save_path") == 1;
    }
}
