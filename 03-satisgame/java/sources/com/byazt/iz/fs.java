package com.byazt.iz;

import android.content.Context;
import com.byazt.gct.pk;
import com.byazt.pmn.ITTInnerDownloadAdapter;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 101})
public class fs {
    public static com.byazt.oh.n n(Context context, pk pkVar, String str) {
        com.byazt.oh.q qVar = new com.byazt.oh.q(context, pkVar, str, "");
        if (pkVar != null) {
            com.byazt.de.n.n(pkVar, String.valueOf(com.byazt.vgx.w.cy(pkVar)), com.byazt.vgx.w.d(pkVar), 1, pkVar.h());
            com.byazt.ikv.qg.qg(pkVar.ih(), qVar, ITTInnerDownloadAdapter.class);
            pkVar.ih();
        }
        return qVar;
    }

    public static ITTInnerDownloadAdapter qg(Context context, pk pkVar, String str) {
        if (pkVar != null) {
            com.byazt.de.n.n(pkVar, String.valueOf(com.byazt.vgx.w.cy(pkVar)), com.byazt.vgx.w.d(pkVar), 2, pkVar.h());
        }
        return new com.byazt.oh.q(context, pkVar, str, "");
    }

    public static ITTInnerDownloadAdapter n(Context context, String str, pk pkVar, String str2) {
        if (pkVar != null) {
            com.byazt.de.n.n(pkVar, String.valueOf(com.byazt.vgx.w.cy(pkVar)), com.byazt.vgx.w.d(pkVar), 3, pkVar.h());
        }
        com.byazt.oh.q qVar = new com.byazt.oh.q(context, pkVar, str2, str);
        qVar.qg(true);
        return qVar;
    }
}
