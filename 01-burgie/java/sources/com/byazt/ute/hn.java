package com.byazt.ute;

import android.content.Context;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.lj.Downloader;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, 20})
public class hn {
    public static void pr() throws Throwable {
        List<DownloadInfo> listPr = com.byazt.mdu.x.w().pr(k.getContext());
        if (listPr != null && listPr.size() > 0) {
            for (int i = 0; i < listPr.size(); i++) {
                DownloadInfo downloadInfo = listPr.get(i);
                File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
                long jLastModified = file.lastModified();
                long jPr = ((long) com.byazt.ew.pr.pr(downloadInfo.getId()).pr("download_file_expire_hours", 0)) * 3600000;
                if (jPr <= 0) {
                    jPr = 604800000;
                }
                if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jPr) {
                    pr(file);
                    Downloader.getInstance(k.getContext()).clearDownloadData(downloadInfo.getId());
                }
            }
        }
    }

    public static void hw() throws Throwable {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(k.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
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
                    long jPr = ((long) com.byazt.ew.pr.pr(downloadInfo.getId()).pr("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jPr <= 0) {
                        jPr = 604800000;
                    }
                    boolean z = true;
                    if (jCurrentTimeMillis < jPr && !m.uc(k.getContext(), str)) {
                        z = false;
                    }
                    if (z) {
                        pr(file);
                    }
                }
            }
        }
    }

    public static void pr(Context context) {
        File externalCacheDir;
        if (context != null && (externalCacheDir = context.getExternalCacheDir()) != null) {
            try {
                pr(externalCacheDir.getPath());
            } catch (Exception e) {
            }
        }
    }

    public static void pr(File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write("1".getBytes());
                fileOutputStream2.close();
            } catch (Exception e) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        file.delete();
    }

    private static void pr(String str) {
        String str2;
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
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
                    pr(str2);
                }
            }
        }
        file.delete();
    }
}
