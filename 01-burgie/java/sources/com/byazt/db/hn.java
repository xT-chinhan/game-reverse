package com.byazt.db;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 908, 20})
public class hn {
    public int hw;
    public String pr;

    public String pr() {
        return this.pr;
    }

    public void pr(String str) {
        this.pr = str;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public int hw() {
        return this.hw;
    }

    public boolean hn() {
        return !TextUtils.isEmpty(this.pr);
    }
}
