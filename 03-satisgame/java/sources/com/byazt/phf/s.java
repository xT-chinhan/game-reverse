package com.byazt.phf;

import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.vf.bb;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1735, 8})
public class s {
    private static rv n(int i) {
        return ((bb) com.byazt.qp.q.n("net")).n().n(i);
    }

    public static rv n(String str) {
        return ((bb) com.byazt.qp.q.n("net")).n().n(str);
    }

    public static rv qg(String str) {
        return n(str).n(1);
    }

    public static rv s(String str) {
        return qg(str).l();
    }

    public static rv n() {
        return n(2);
    }

    public static rv q(String str) {
        return n(str).n(2);
    }

    public static rv n(String str, String str2, String str3) {
        return n(str).n(3).q(str2, str3);
    }

    public static oa l(String str) {
        return qg(str).n();
    }
}
