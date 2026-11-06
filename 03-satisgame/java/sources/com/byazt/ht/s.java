package com.byazt.ht;

import com.byazt.je.oa;
import com.byazt.ky.sz;
import com.byazt.q.AdBaseConstants;
import com.byazt.qx.BaseException;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 8})
public class s implements oa {
    @Override // com.byazt.je.oa
    public void n(DownloadInfo downloadInfo) throws BaseException {
        sz szVarCp = d.cp();
        if (downloadInfo == null || szVarCp == null) {
            return;
        }
        File fileN = n(downloadInfo.getPackageName(), downloadInfo.getTargetFilePath());
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        if (qgVarN != null) {
            com.byazt.rz.oa.n(qgVarN.x());
        }
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(fileN.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.byazt.je.oa
    public boolean qg(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.byazt.es.qg.n(com.byazt.f.n.n(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }

    private File n(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + ".apk");
    }
}
