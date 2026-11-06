package com.byazt.sxm;

import android.content.pm.PackageInfo;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.fn.m;
import com.byazt.lhc.BaseException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, 13})
public class hw implements m {
    @Override // com.byazt.fn.m
    public void pr(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo packageInfoPr = com.byazt.mdu.hn.pr(k.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoPr != null) {
            downloadInfo.setAppVersionCode(packageInfoPr.versionCode);
        }
    }

    @Override // com.byazt.fn.m
    public boolean hw(DownloadInfo downloadInfo) {
        if (downloadInfo != null && com.byazt.uk.c.hw() && downloadInfo.getPackageInfo() == null) {
            return true;
        }
        return false;
    }
}
