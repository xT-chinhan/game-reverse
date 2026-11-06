package com.byazt.ht;

import android.content.pm.PackageInfo;
import com.byazt.je.oa;
import com.byazt.qx.BaseException;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 26})
public class qg implements oa {
    @Override // com.byazt.je.oa
    public void n(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo packageInfoN = com.byazt.e.s.n(d.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoN != null) {
            downloadInfo.setAppVersionCode(packageInfoN.versionCode);
        }
    }

    @Override // com.byazt.je.oa
    public boolean qg(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.byazt.rz.l.qg() && downloadInfo.getPackageInfo() == null;
    }
}
