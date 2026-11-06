package com.ss.android.downloadlib.ah;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.anythink.dlopt.common.a.a;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.depend.zb;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.analytics.pro.bz;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements zb {
    @Override // com.ss.android.socialbase.downloader.depend.zb
    public void ms(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !ah(downloadInfo)) {
            return;
        }
        ms(hi.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.zb
    public boolean xr(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.ab.ka.xr(com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()));
        }
        return false;
    }

    private boolean ah(DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        File file = new File(str);
        String strMs = com.ss.android.socialbase.appdownloader.c.ms.ka.ms(hi.getContext(), com.ss.android.socialbase.appdownloader.ah.ms(downloadInfo, file), str);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strMs)) {
            String str2 = strMs + a.h;
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                if (zRenameTo) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e) {
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
        return zRenameTo;
    }

    private void ms(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{bz.d}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex(bz.d))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.ah.ms.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.ss.android.socialbase.downloader.downloader.ah.w().ms(downloadInfo);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.ny.c.ms(cursorQuery);
    }
}
