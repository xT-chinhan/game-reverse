package com.byazt.zb;

import com.byazt.sd.zo;
import com.byazt.zs.uc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1868, 37})
public class pr {
    public static pr pr;

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    public com.byazt.vkw.pr pr(String str) {
        return uc.hw(str);
    }

    public static String hw() {
        return zo.nt().ny();
    }

    public static String hn() {
        return zo.nt().ny();
    }

    public static String x() {
        return zo.nt().ny();
    }

    public static com.byazt.vkw.pr c() {
        return uc.hw(x());
    }
}
