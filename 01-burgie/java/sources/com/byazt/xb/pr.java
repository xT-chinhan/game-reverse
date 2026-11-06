package com.byazt.xb;

import android.content.Context;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.jx.zo;
import com.byazt.nv.hn;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.wt.ls;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 97, 37})
public class pr {
    public static void pr(View view, of ofVar, Context context) {
        if (ofVar == null) {
            return;
        }
        if (context == null) {
            context = a.getContext();
        }
        String strHw = ls.hw(ofVar);
        com.byazt.az.pr prVar = new com.byazt.az.pr(context, ofVar, strHw, ls.x(strHw));
        hn hnVarPr = pr(ofVar, context, strHw);
        if (hnVarPr != null) {
            ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(hnVarPr);
        }
        ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr((com.byazt.dl.pr.InterfaceC0041pr) cz.hn(ofVar.le(), com.byazt.dl.pr.InterfaceC0041pr.class));
        prVar.pr(view, new vk());
    }

    private static hn pr(of ofVar, Context context, String str) {
        if (ofVar == null) {
            return null;
        }
        hn hnVar = (hn) cz.hn(ofVar.le(), hn.class);
        if (hnVar != null) {
            ofVar.le();
        }
        if (hnVar == null) {
            hn hnVarHw = hw(ofVar, context, str);
            cz.hw(ofVar.le(), hnVarHw, hn.class);
            ofVar.le();
            return hnVarHw;
        }
        return hnVar;
    }

    private static hn hw(of ofVar, Context context, String str) {
        if (ofVar.aj() == 4) {
            com.byazt.ri.pr prVarPr = zo.pr(context, ofVar, str);
            final String strX = ofVar.x();
            prVarPr.pr(new com.byazt.nv.pr() { // from class: com.byazt.xb.pr.1
                @Override // com.byazt.nv.pr
                public void pr() {
                    com.byazt.dp.pr.pr(strX);
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, long j2, String str2, String str3) {
                    com.byazt.dp.pr.pr(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void hw(long j, long j2, String str2, String str3) {
                    com.byazt.dp.pr.hw(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void hn(long j, long j2, String str2, String str3) {
                    com.byazt.dp.pr.hn(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, String str2, String str3) {
                    com.byazt.dp.pr.hw(strX);
                }

                @Override // com.byazt.nv.pr
                public void pr(String str2, String str3) {
                    com.byazt.dp.pr.hn(strX);
                }
            });
            prVarPr.pr();
            return prVarPr;
        }
        return null;
    }
}
