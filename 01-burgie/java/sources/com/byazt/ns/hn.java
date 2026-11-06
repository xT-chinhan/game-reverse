package com.byazt.ns;

import android.content.Context;
import com.byazt.eq.zo;
import com.byazt.fj.SSWebView;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1419, 20})
public class hn {
    public com.byazt.eq.pr hw;
    public zo pr;

    public zo pr(Context context, SSWebView sSWebView, com.byazt.eq.hn hnVar, com.byazt.eq.pr prVar, Set<String> set, zo.pr prVar2) {
        if (this.pr == null) {
            zo zoVarPr = zo.pr(context, sSWebView, hnVar, prVar, set, prVar2, true);
            this.pr = zoVarPr;
            zoVarPr.x(false);
        }
        this.hw = prVar;
        return this.pr;
    }
}
