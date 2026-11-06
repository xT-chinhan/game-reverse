package com.byazt.bri;

import com.byazt.auw.DownloadInfo;
import com.byazt.ds.aj;
import com.byazt.shh.uc;
import com.byazt.zkm.vk;
import com.byazt.zkm.w;
import com.ss.android.downloadlib.activity.TTDelegateActivity;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 407, 37})
public class pr implements w {
    @Override // com.byazt.zkm.w
    public void pr(DownloadInfo downloadInfo, final vk vkVar) {
        pr(downloadInfo, new com.byazt.hja.pr() { // from class: com.byazt.bri.pr.1
            @Override // com.byazt.hja.pr
            public void pr() {
                vkVar.pr();
            }
        });
    }

    public void pr(final DownloadInfo downloadInfo, final com.byazt.hja.pr prVar) {
        com.byazt.tia.hw hwVarPr = uc.pr().pr(downloadInfo);
        if (hwVarPr != null && aj.pr(hwVarPr)) {
            TTDelegateActivity.pr(hwVarPr, new com.byazt.hja.pr() { // from class: com.byazt.bri.pr.2
                @Override // com.byazt.hja.pr
                public void pr() {
                    pr.this.hw(downloadInfo, prVar);
                }
            });
        } else {
            hw(downloadInfo, prVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(DownloadInfo downloadInfo, final com.byazt.hja.pr prVar) {
        com.byazt.tia.hw hwVarPr = uc.pr().pr(downloadInfo);
        boolean zPr = com.byazt.ds.uc.pr(hwVarPr);
        boolean zHw = com.byazt.ds.uc.hw(hwVarPr);
        if (!zPr || !zHw) {
            prVar.pr();
        } else {
            com.byazt.ds.hn.pr(hwVarPr, new com.byazt.hja.pr() { // from class: com.byazt.bri.pr.3
                @Override // com.byazt.hja.pr
                public void pr() {
                    prVar.pr();
                }
            });
        }
    }
}
