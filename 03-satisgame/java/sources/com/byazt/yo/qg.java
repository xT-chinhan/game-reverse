package com.byazt.yo;

import android.content.Context;
import com.byazt.fvm.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 170, 26})
public class qg {
    public static com.byazt.nnl.s n;
    public static com.byazt.nnl.q qg;

    public static void n() {
        if (qg == null) {
            qg = new com.byazt.nnl.q() { // from class: com.byazt.yo.qg.1
                @Override // com.byazt.nnl.q
                public int n(Context context, float f) {
                    return com.byazt.okk.s.s(context, f);
                }
            };
        }
        if (n == null) {
            n = new com.byazt.nnl.s() { // from class: com.byazt.yo.qg.2
                @Override // com.byazt.nnl.s
                public void n(com.byazt.oj.qg qgVar, w wVar) {
                    com.byazt.hm.n.n(qgVar, wVar);
                }

                @Override // com.byazt.nnl.s
                public void n(Context context, com.byazt.oj.qg qgVar, String str) {
                    com.byazt.hm.n.n(qgVar.q(), qgVar.l(), qgVar.fs(), str);
                }
            };
        }
        com.byazt.nnl.n.n(n, qg);
    }
}
