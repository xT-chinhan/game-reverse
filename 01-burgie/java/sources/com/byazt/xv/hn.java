package com.byazt.xv;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 20})
public class hn extends hw implements com.byazt.mj.x {
    public com.byazt.mj.hn w;

    public hn(Context context) {
        super(context);
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        com.byazt.mj.pr prVarQi = this.hw.qi();
        if (prVarQi != null) {
            com.byazt.mj.hn hnVarPr = prVarQi.pr(this.uc);
            this.w = hnVarPr;
            if (hnVarPr != null) {
                hnVarPr.pr(this);
                return false;
            }
            prVarQi.pr(this.uc, new com.byazt.mj.hw());
            return false;
        }
        return false;
    }

    @Override // com.byazt.mj.x
    public void pr(String str) {
        this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
    }
}
