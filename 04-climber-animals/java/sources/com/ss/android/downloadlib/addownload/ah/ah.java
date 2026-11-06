package com.ss.android.downloadlib.addownload.ah;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ah {
    public static void ms() throws Throwable {
        List<DownloadInfo> listMs = com.ss.android.socialbase.appdownloader.d.ch().ms(hi.getContext());
        if (listMs == null || listMs.size() <= 0) {
            return;
        }
        for (int i = 0; i < listMs.size(); i++) {
            DownloadInfo downloadInfo = listMs.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long jLastModified = file.lastModified();
            long jMs = ((long) com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("download_file_expire_hours", 0)) * 3600000;
            if (jMs <= 0) {
                jMs = 604800000;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jMs) {
                ms(file);
                Downloader.getInstance(hi.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void xr() throws Throwable {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(hi.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jMs = ((long) com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).ms("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jMs <= 0) {
                        jMs = 604800000;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jMs && !zb.c(hi.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        ms(file);
                    }
                }
            }
        }
    }

    public static void ms(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            ms(externalCacheDir.getPath());
        } catch (Exception e) {
            ab.ms(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void ms(File file) throws Throwable {
        FileOutputStream fileOutputStream;
        Exception e;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write("1".getBytes());
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    ab.ms(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            ab.ms(e3);
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                        ab.ms(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            e = e5;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
        file.delete();
    }

    private static void ms(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                if (str3 != null) {
                    if (str.endsWith(File.separator)) {
                        str2 = str + str3;
                    } else {
                        str2 = str + File.separator + str3;
                    }
                    File file2 = new File(str2);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        ms(str2);
                    }
                }
            }
            file.delete();
        }
    }
}
