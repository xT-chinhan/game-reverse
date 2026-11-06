package com.byazt.wgd;

import android.text.TextUtils;
import com.byazt.ld.lb;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 20})
public class hn extends pr {
    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        if (TextUtils.isEmpty(hnVar.fw())) {
            lb lbVarC = hnVar.cz().c();
            hnVar.hw(lbVarC.pr(hnVar));
            hnVar.pr(lbVarC.hw(hnVar));
        }
        hnVar.pr(new fw());
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "generate_key";
    }
}
