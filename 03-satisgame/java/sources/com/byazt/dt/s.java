package com.byazt.dt;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 212, 8})
public class s {
    public String n;
    public int qg;

    public String n() {
        return this.n;
    }

    public void n(String str) {
        this.n = str;
    }

    public void n(int i) {
        this.qg = i;
    }

    public int qg() {
        return this.qg;
    }

    public boolean s() {
        return !TextUtils.isEmpty(this.n);
    }
}
