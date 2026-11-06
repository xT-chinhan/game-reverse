package com.byazt.mx;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ug.k;
import com.byazt.wm.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 113})
public class d implements rv {
    @Override // com.byazt.mx.rv
    public boolean n(com.byazt.h.qg qgVar, int i, fs fsVar) {
        DownloadInfo downloadInfoQg;
        if (qgVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(qgVar.hf())) {
            downloadInfoQg = com.byazt.s.tj.n((Context) null).n(qgVar.hf(), null, true);
        } else {
            downloadInfoQg = com.byazt.s.tj.n((Context) null).qg(qgVar.n());
        }
        return k.n(qgVar, downloadInfoQg, i, fsVar, false, null);
    }
}
