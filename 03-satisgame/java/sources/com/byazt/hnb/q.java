package com.byazt.hnb;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1322, 5})
public class q {
    public String n;
    public com.byazt.zve.qg qg;

    public q(com.byazt.zve.qg qgVar) {
        this.qg = qgVar;
        if (qgVar == null || TextUtils.isEmpty(qgVar.n()) || TextUtils.equals("00000000-0000-0000-0000-000000000000", qgVar.n())) {
            this.n = "error";
        }
    }

    public q(String str) {
        this.n = str;
    }

    public com.byazt.zve.qg n() {
        return this.qg;
    }

    public String getType() {
        return this.n;
    }
}
