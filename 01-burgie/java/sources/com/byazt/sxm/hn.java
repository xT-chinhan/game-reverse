package com.byazt.sxm;

import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.eyv.AdBaseConstants;
import com.byazt.fn.m;
import com.byazt.lhc.BaseException;
import com.byazt.zv.g;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 448, 20})
public class hn implements m {
    @Override // com.byazt.fn.m
    public void pr(DownloadInfo downloadInfo) throws BaseException {
        g gVarW = k.w();
        if (downloadInfo != null && gVarW != null) {
            File filePr = pr(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
            com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
            if (hwVarPr != null) {
                com.byazt.uk.m.pr(hwVarPr.fw());
            }
            downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
            downloadInfo.setName(filePr.getName());
            downloadInfo.setMd5(null);
        }
    }

    @Override // com.byazt.fn.m
    public boolean hw(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.byazt.snv.hw.pr(com.byazt.ew.pr.pr(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File pr(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
