package com.byazt.iy;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1110, 13})
public class hw {
    public static boolean hw;
    public static boolean pr;

    public static void pr(String str) {
        if (!hw) {
            com.byazt.qn.x.pr(str, "sp_multi_info").pr("is_support_multi_process", true);
        }
        pr = true;
        hw = true;
    }

    public static void hw(String str) {
        if (hw) {
            com.byazt.qn.x.pr(str, "sp_multi_info").pr("is_support_multi_process", false);
        }
        pr = false;
    }

    public static boolean pr() {
        if (!hw) {
            pr = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_multi_info").hw("is_support_multi_process", false);
            hw = true;
        }
        return pr;
    }
}
