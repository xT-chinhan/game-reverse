package com.byazt.eld;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 13})
public class hw {
    public static volatile hw pr;
    public Handler hw = null;

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new hw();
                }
            }
        }
        return pr;
    }

    public void pr(Context context, DownloadInfo downloadInfo) {
        if (!hw() || downloadInfo == null) {
            return;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
        if (this.hw == null) {
            this.hw = new Handler(Looper.getMainLooper());
        }
        final String url = downloadInfo.getUrl();
        Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
        this.hw.post(new Runnable() { // from class: com.byazt.eld.hw.1
            @Override // java.lang.Runnable
            public void run() {
                k.hn().pr(3, k.getContext(), null, "下载失败，请重试！", null, 0);
                c cVarPr = com.byazt.cvl.zo.pr().pr(url);
                if (cVarPr != null) {
                    cVarPr.fw();
                }
            }
        });
    }

    public boolean hw() {
        return k.aj().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
