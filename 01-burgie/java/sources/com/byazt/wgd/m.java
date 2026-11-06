package com.byazt.wgd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 108})
public class m extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        String strUc = hnVar.uc();
        com.byazt.ld.hw hwVarNy = hnVar.ny();
        byte[] bArrPr = com.byazt.op.pr.pr(hnVar);
        if (bArrPr == null) {
            hnVar.pr(new zo(1006, "not image cache", null));
            return;
        }
        hnVar.pr(new hw(bArrPr, null));
        if (hwVarNy.fw()) {
            hnVar.cz().hw(hwVarNy).pr(strUc, bArrPr);
        }
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "spec_file_cache";
    }
}
