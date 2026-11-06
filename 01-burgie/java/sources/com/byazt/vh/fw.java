package com.byazt.vh;

import android.content.Context;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1093, 62})
public class fw extends hn {
    public static final fw hn = new fw(a.getContext());

    private fw(Context context) {
        super(context);
    }

    public static fw pr() {
        return hn;
    }

    @Override // com.byazt.vh.hn
    public int hw() {
        return 7;
    }

    public void pr(com.byazt.qe.hw hwVar, String str, int i, x xVar) {
        com.byazt.db.hn hnVar = new com.byazt.db.hn();
        hnVar.pr(str);
        hnVar.pr(i + 1);
        pr(hwVar, xVar, hnVar, null, null, null);
    }
}
