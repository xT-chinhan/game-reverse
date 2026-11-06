package com.byazt.pw;

import android.content.Context;
import com.byazt.mr.uc;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 420, 13})
public class hw {
    public static com.byazt.rc.x hw;
    public static com.byazt.rc.hn pr;

    public static void pr() {
        if (hw == null) {
            hw = new com.byazt.rc.x() { // from class: com.byazt.pw.hw.1
                @Override // com.byazt.rc.x
                public int pr(Context context, float f) {
                    return er.hn(context, f);
                }
            };
        }
        if (pr == null) {
            pr = new com.byazt.rc.hn() { // from class: com.byazt.pw.hw.2
                @Override // com.byazt.rc.hn
                public void pr(com.byazt.dw.hw hwVar, uc ucVar) {
                    com.byazt.pj.pr.pr(hwVar, ucVar);
                }

                @Override // com.byazt.rc.hn
                public void pr(Context context, com.byazt.dw.hw hwVar, String str) {
                    com.byazt.pj.pr.pr(hwVar.x(), hwVar.c(), hwVar.zo(), str);
                }
            };
        }
        com.byazt.rc.pr.pr(pr, hw);
    }
}
