package com.byazt.wgd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 250})
public class k extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        byte[] bArrPr = hnVar.cz().hw(hnVar.ny()).pr(hnVar.uc());
        if (bArrPr == null) {
            if (hnVar.yb()) {
                hnVar.pr(new m());
                return;
            } else {
                hnVar.pr(new uc());
                return;
            }
        }
        hnVar.pr(new hw(bArrPr, null));
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "raw_cache";
    }
}
