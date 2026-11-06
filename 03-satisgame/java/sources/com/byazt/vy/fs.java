package com.byazt.vy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 101})
public class fs {
    public static boolean n = true;

    public static boolean n() {
        com.byazt.rb.qg.qg("TMe", "applogSOLoadSuccess = " + n);
        return n;
    }

    static {
        try {
            com.byazt.xhd.s.n("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            n = false;
        }
    }
}
