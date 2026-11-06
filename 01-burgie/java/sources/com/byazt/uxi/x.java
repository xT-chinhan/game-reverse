package com.byazt.uxi;

import com.byazt.ynb.nt;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, 121})
public class x {
    public final String c;
    public final double hn;
    public final char hw;
    public final List<nt> pr;
    public final String uc;
    public final double x;

    public static int pr(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public x(List<nt> list, char c, double d, double d2, String str, String str2) {
        this.pr = list;
        this.hw = c;
        this.hn = d;
        this.x = d2;
        this.c = str;
        this.uc = str2;
    }

    public List<nt> pr() {
        return this.pr;
    }

    public double hw() {
        return this.x;
    }

    public int hashCode() {
        return pr(this.hw, this.uc, this.c);
    }
}
