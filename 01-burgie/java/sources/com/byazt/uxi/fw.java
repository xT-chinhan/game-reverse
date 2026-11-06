package com.byazt.uxi;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, 62})
public class fw {
    public final String hn;
    public final float hw;
    public final float pr;

    public fw(String str, float f, float f2) {
        this.hn = str;
        this.hw = f2;
        this.pr = f;
    }

    public boolean pr(String str) {
        if (this.hn.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.hn.endsWith("\r")) {
            String str2 = this.hn;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
