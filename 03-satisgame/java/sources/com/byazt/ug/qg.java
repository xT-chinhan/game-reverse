package com.byazt.ug;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 26})
public class qg {
    public static volatile qg n;
    public Handler qg = null;

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    public void n(Context context, DownloadInfo downloadInfo) {
        if (qg() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
            if (this.qg == null) {
                this.qg = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.qg.post(new Runnable() { // from class: com.byazt.ug.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    d.s().n(3, d.getContext(), null, "下载失败，请重试！", null, 0);
                    l lVarN = com.byazt.s.fs.n().n(url);
                    if (lVarN != null) {
                        lVarN.x();
                    }
                }
            });
        }
    }

    public boolean qg() {
        return d.rv().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
