package com.byazt.nb;

import android.content.Context;
import com.anythink.core.e.i;
import com.byazt.q.AdBaseConstants;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1478, 8})
public class s {
    public static void n() throws Throwable {
        List<DownloadInfo> listN = com.byazt.e.q.cp().n(d.getContext());
        if (listN == null || listN.size() <= 0) {
            return;
        }
        for (int i = 0; i < listN.size(); i++) {
            DownloadInfo downloadInfo = listN.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long jLastModified = file.lastModified();
            long jN = ((long) com.byazt.f.n.n(downloadInfo.getId()).n("download_file_expire_hours", 0)) * 3600000;
            if (jN <= 0) {
                jN = i.f;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jN) {
                n(file);
                Downloader.getInstance(d.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void qg() throws Throwable {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(d.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
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
                    long jN = ((long) com.byazt.f.n.n(downloadInfo.getId()).n("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jN <= 0) {
                        jN = i.f;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jN && !oa.w(d.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        n(file);
                    }
                }
            }
        }
    }

    public static void n(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            n(externalCacheDir.getPath());
        } catch (Exception unused) {
        }
    }

    public static void n(File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write("1".getBytes());
                fileOutputStream2.close();
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
        file.delete();
    }

    private static void n(String str) {
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
                        n(str2);
                    }
                }
            }
            file.delete();
        }
    }
}
