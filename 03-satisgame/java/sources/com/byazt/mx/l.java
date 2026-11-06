package com.byazt.mx;

import android.text.TextUtils;
import com.byazt.ug.k;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 18})
public class l implements x {
    @Override // com.byazt.mx.x
    public boolean n(com.byazt.h.qg qgVar, int i, fs fsVar, com.byazt.bn.s sVar) {
        DownloadInfo downloadInfoQg;
        if (qgVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(qgVar.hf())) {
            downloadInfoQg = com.byazt.s.tj.n(com.byazt.ug.d.getContext()).n(qgVar.hf(), null, true);
        } else {
            downloadInfoQg = com.byazt.s.tj.n(com.byazt.ug.d.getContext()).qg(qgVar.n());
        }
        return k.n(qgVar, downloadInfoQg, i, fsVar, true, sVar);
    }
}
