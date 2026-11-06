package com.byazt.qx;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 843, 21})
public class x extends BaseException {
    public x(int i, String str) {
        super(i, str);
    }

    public x n(String str) {
        setExtraInfo(str);
        return this;
    }

    public String n() {
        return getExtraInfo();
    }
}
