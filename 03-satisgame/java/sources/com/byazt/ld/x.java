package com.byazt.ld;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 21})
public class x {
    public final float n;
    public final float qg;
    public final String s;

    public x(String str, float f, float f2) {
        this.s = str;
        this.qg = f2;
        this.n = f;
    }

    public boolean n(String str) {
        if (this.s.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.s.endsWith("\r")) {
            String str2 = this.s;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
