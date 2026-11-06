package com.byazt.mx;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.q.AdBaseConstants;
import com.byazt.wm.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 29})
public class cp {
    public static cp n;
    public List<rv> qg;

    public static cp n() {
        if (n == null) {
            synchronized (cp.class) {
                if (n == null) {
                    n = new cp();
                }
            }
        }
        return n;
    }

    private cp() {
        ArrayList arrayList = new ArrayList();
        this.qg = arrayList;
        arrayList.add(new tj());
        this.qg.add(new d());
        this.qg.add(new w());
        this.qg.add(new n());
    }

    public void n(com.byazt.h.qg qgVar, int i, fs fsVar) {
        DownloadInfo downloadInfoQg;
        List<rv> list = this.qg;
        if (list == null || list.size() == 0 || qgVar == null) {
            fsVar.n(qgVar);
            return;
        }
        if (!TextUtils.isEmpty(qgVar.hf())) {
            downloadInfoQg = com.byazt.s.tj.n((Context) null).n(qgVar.hf(), null, true);
        } else {
            downloadInfoQg = com.byazt.s.tj.n((Context) null).qg(qgVar.n());
        }
        if (downloadInfoQg == null || !AdBaseConstants.MIME_APK.equals(downloadInfoQg.getMimeType())) {
            fsVar.n(qgVar);
            return;
        }
        boolean z = com.byazt.f.n.n(qgVar.um()).n("pause_optimise_switch", 0) == 1;
        for (rv rvVar : this.qg) {
            if (z || (rvVar instanceof d)) {
                if (rvVar.n(qgVar, i, fsVar)) {
                    return;
                }
            }
        }
        fsVar.n(qgVar);
    }
}
