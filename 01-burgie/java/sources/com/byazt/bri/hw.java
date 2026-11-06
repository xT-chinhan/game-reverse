package com.byazt.bri;

import com.byazt.auw.DownloadInfo;
import com.byazt.shh.uc;
import com.byazt.zkm.vk;
import com.byazt.zkm.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 407, 13})
public class hw implements w {
    @Override // com.byazt.zkm.w
    public void pr(DownloadInfo downloadInfo, vk vkVar) {
        com.byazt.tia.hw hwVarPr;
        if (downloadInfo != null && (hwVarPr = uc.pr().pr(downloadInfo)) != null) {
            downloadInfo.setLinkMode(hwVarPr.of());
        }
        if (vkVar != null) {
            vkVar.pr();
        }
    }
}
