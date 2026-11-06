package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f4445ms;
    private Handler xr = null;

    public static xr ms() {
        if (f4445ms == null) {
            synchronized (xr.class) {
                if (f4445ms == null) {
                    f4445ms = new xr();
                }
            }
        }
        return f4445ms;
    }

    public void ms(Context context, DownloadInfo downloadInfo) {
        if (xr() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
            if (this.xr == null) {
                this.xr = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.xr.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    hi.ah().ms(3, hi.getContext(), null, "下载失败，请重试！", null, 0);
                    ka kaVarMs = com.ss.android.downloadlib.x.ms().ms(url);
                    if (kaVarMs != null) {
                        kaVarMs.ab();
                    }
                }
            });
        }
    }

    public boolean xr() {
        return hi.ny().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
