package com.byazt.wgd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 121})
public class x extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        com.byazt.ld.hw hwVarNy = hnVar.ny();
        if (hnVar.yb()) {
            if (hwVarNy.hn()) {
                hnVar.pr(new vk());
                return;
            } else if (hwVarNy.fw()) {
                hnVar.pr(new k());
                return;
            } else {
                hnVar.pr(new m());
                return;
            }
        }
        if (hwVarNy != null) {
            if (hwVarNy.hn()) {
                hnVar.pr(new vk());
                return;
            } else if (hwVarNy.x()) {
                hnVar.pr(new uc());
                return;
            }
        }
        hnVar.pr(new w());
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "cache_policy";
    }
}
