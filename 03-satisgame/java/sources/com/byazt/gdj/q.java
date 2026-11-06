package com.byazt.gdj;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2284, 5})
public class q {
    public String n;
    public String qg;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public String qg() {
        return this.qg;
    }

    public void qg(String str) {
        this.qg = str;
    }

    public boolean s() {
        return TextUtils.isEmpty(this.n) && TextUtils.isEmpty(this.qg);
    }

    public boolean q() {
        return (TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.qg)) ? false : true;
    }
}
