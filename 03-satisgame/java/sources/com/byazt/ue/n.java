package com.byazt.ue;

import com.byazt.t.rv;
import com.byazt.vl.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.z.cp;
import com.byazt.z.tj;
import com.ss.android.downloadlib.activity.TTDelegateActivity;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1907, 19})
public class n implements cp {
    @Override // com.byazt.z.cp
    public void n(DownloadInfo downloadInfo, final tj tjVar) {
        n(downloadInfo, new com.byazt.gs.n() { // from class: com.byazt.ue.n.1
            @Override // com.byazt.gs.n
            public void n() {
                tjVar.n();
            }
        });
    }

    public void n(final DownloadInfo downloadInfo, final com.byazt.gs.n nVar) {
        com.byazt.h.qg qgVarN = w.n().n(downloadInfo);
        if (qgVarN != null && rv.n(qgVarN)) {
            TTDelegateActivity.n(qgVarN, new com.byazt.gs.n() { // from class: com.byazt.ue.n.2
                @Override // com.byazt.gs.n
                public void n() {
                    n.this.qg(downloadInfo, nVar);
                }
            });
        } else {
            qg(downloadInfo, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(DownloadInfo downloadInfo, final com.byazt.gs.n nVar) {
        com.byazt.h.qg qgVarN = w.n().n(downloadInfo);
        boolean zN = com.byazt.t.w.n(qgVarN);
        boolean zQg = com.byazt.t.w.qg(qgVarN);
        if (!zN || !zQg) {
            nVar.n();
        } else {
            com.byazt.t.s.n(qgVarN, new com.byazt.gs.n() { // from class: com.byazt.ue.n.3
                @Override // com.byazt.gs.n
                public void n() {
                    nVar.n();
                }
            });
        }
    }
}
