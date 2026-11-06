package com.byazt.ht;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byazt.je.oa;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 19})
public class n implements oa {
    @Override // com.byazt.je.oa
    public void n(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !s(downloadInfo)) {
            return;
        }
        n(d.getContext(), downloadInfo);
    }

    @Override // com.byazt.je.oa
    public boolean qg(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.byazt.rz.l.qg(com.byazt.f.n.n(downloadInfo.getId()));
        }
        return false;
    }

    private boolean s(DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        File file = new File(str);
        String strN = com.byazt.k.l.n(d.getContext(), com.byazt.e.s.n(downloadInfo, file), str);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strN)) {
            String str2 = strN + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                if (zRenameTo) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception unused) {
            }
        }
        return zRenameTo;
    }

    private void n(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.byazt.ht.n.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData("file_content_uri", uri.toString());
                        com.byazt.xv.s.hu().n(downloadInfo);
                    }
                }
            });
        }
        com.byazt.ta.w.n(cursorQuery);
    }
}
