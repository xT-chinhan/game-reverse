package com.byazt.pb;

import android.content.Context;
import com.byazt.ew.fs;
import com.byazt.kfh.SSWebView;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 868, 19})
public class n {
    public fs n;
    public com.byazt.ew.n qg;

    public fs n(Context context, SSWebView sSWebView, com.byazt.ew.s sVar, com.byazt.ew.n nVar, Set<String> set, fs.n nVar2) {
        if (this.n == null) {
            fs fsVarN = fs.n(context, sSWebView, sVar, nVar, set, nVar2, true);
            this.n = fsVarN;
            fsVarN.q(false);
        }
        this.qg = nVar;
        return this.n;
    }
}
