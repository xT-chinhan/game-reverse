package com.byazt.lhc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 502, 62})
public class fw extends BaseException {
    public fw(int i, String str) {
        super(i, str);
    }

    public fw pr(String str) {
        setExtraInfo(str);
        return this;
    }

    public String pr() {
        return getExtraInfo();
    }
}
