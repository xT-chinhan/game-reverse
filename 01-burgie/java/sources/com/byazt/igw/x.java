package com.byazt.igw;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 77, 121})
public class x {
    public com.byazt.lq.hw hw;
    public String pr;

    public x(com.byazt.lq.hw hwVar) {
        this.hw = hwVar;
        if (hwVar == null || TextUtils.isEmpty(hwVar.pr()) || TextUtils.equals("00000000-0000-0000-0000-000000000000", hwVar.pr())) {
            this.pr = "error";
        }
    }

    public x(String str) {
        this.pr = str;
    }

    public com.byazt.lq.hw pr() {
        return this.hw;
    }

    public String getType() {
        return this.pr;
    }
}
