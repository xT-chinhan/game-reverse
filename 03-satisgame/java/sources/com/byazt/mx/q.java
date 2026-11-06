package com.byazt.mx;

import android.text.TextUtils;
import com.byazt.q.AdBaseConstants;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 5})
public class q {
    public static q n;
    public List<x> qg;

    public static q n() {
        if (n == null) {
            synchronized (cp.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    private q() {
        ArrayList arrayList = new ArrayList();
        this.qg = arrayList;
        arrayList.add(new l());
        this.qg.add(new qg());
        this.qg.add(new s());
    }

    public void n(com.byazt.h.qg qgVar, int i, fs fsVar, com.byazt.bn.s sVar) {
        DownloadInfo downloadInfoQg;
        List<x> list = this.qg;
        if (list == null || list.size() == 0 || qgVar == null) {
            fsVar.n(qgVar);
        }
        if (!TextUtils.isEmpty(qgVar.hf())) {
            downloadInfoQg = com.byazt.s.tj.n(com.byazt.ug.d.getContext()).n(qgVar.hf(), null, true);
        } else {
            downloadInfoQg = com.byazt.s.tj.n(com.byazt.ug.d.getContext()).qg(qgVar.n());
        }
        if (downloadInfoQg == null) {
            downloadInfoQg = Downloader.getInstance(com.byazt.ug.d.getContext()).getDownloadInfo(qgVar.um());
        }
        if (downloadInfoQg == null || !AdBaseConstants.MIME_APK.equals(downloadInfoQg.getMimeType())) {
            fsVar.n(qgVar);
            return;
        }
        if (new tj().n(qgVar, i, fsVar)) {
            return;
        }
        Iterator<x> it = this.qg.iterator();
        while (it.hasNext()) {
            if (it.next().n(qgVar, i, fsVar, sVar)) {
                return;
            }
        }
        fsVar.n(qgVar);
    }
}
