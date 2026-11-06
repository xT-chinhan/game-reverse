package com.byazt.ue;

import com.byazt.wm.DownloadInfo;
import com.byazt.z.cp;
import com.byazt.z.tj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1907, 8})
public class s implements cp {
    public static volatile s n;
    public List<cp> qg;

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    private s() {
        ArrayList arrayList = new ArrayList();
        this.qg = arrayList;
        arrayList.add(new qg());
        this.qg.add(new n());
    }

    @Override // com.byazt.z.cp
    public void n(DownloadInfo downloadInfo, tj tjVar) {
        if (downloadInfo != null && this.qg.size() != 0) {
            n(downloadInfo, 0, tjVar);
        } else if (tjVar != null) {
            tjVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final DownloadInfo downloadInfo, final int i, final tj tjVar) {
        if (i == this.qg.size() || i < 0) {
            tjVar.n();
        } else {
            this.qg.get(i).n(downloadInfo, new tj() { // from class: com.byazt.ue.s.1
                @Override // com.byazt.z.tj
                public void n() {
                    s.this.n(downloadInfo, i + 1, tjVar);
                }
            });
        }
    }
}
