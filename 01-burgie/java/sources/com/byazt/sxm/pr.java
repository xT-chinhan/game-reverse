package com.byazt.sxm;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.m;
import com.byazt.lhc.BaseException;
import com.umeng.analytics.pro.ar;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, 37})
public class pr implements m {
    @Override // com.byazt.fn.m
    public void pr(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo != null && hn(downloadInfo)) {
            pr(k.getContext(), downloadInfo);
        }
    }

    @Override // com.byazt.fn.m
    public boolean hw(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.byazt.uk.c.hw(com.byazt.ew.pr.pr(downloadInfo.getId()));
        }
        return false;
    }

    private boolean hn(DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        File file = new File(str);
        String strPr = com.byazt.pwu.c.pr(k.getContext(), com.byazt.mdu.hn.pr(downloadInfo, file), str);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strPr)) {
            String str2 = strPr + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                if (zRenameTo) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e) {
            }
        }
        return zRenameTo;
    }

    private void pr(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{ar.d}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex(ar.d))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.byazt.sxm.pr.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.byazt.lj.hn.z().pr(downloadInfo);
                    }
                }
            });
        }
        com.byazt.tuy.uc.pr(cursorQuery);
    }
}
