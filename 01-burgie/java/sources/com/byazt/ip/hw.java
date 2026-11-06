package com.byazt.ip;

import com.byazt.ca.c;
import com.byazt.sd.a;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1193, 13})
public class hw {
    public static volatile boolean hw = false;
    public static volatile Random pr;

    public static boolean pr() {
        return hw;
    }

    public static void hw() {
        pr(a.hw().d(), true);
    }

    public static boolean pr(float f, boolean z) {
        if (f <= 0.0f) {
            if (z) {
                hw = false;
            }
            return false;
        }
        int iNextInt = hn().nextInt(10000);
        int i = (int) (f * 10000.0f);
        if (z) {
            hw = iNextInt < i;
        }
        return iNextInt < i;
    }

    private static Random hn() {
        if (pr != null) {
            return pr;
        }
        Random randomPr = c.pr();
        pr = randomPr;
        return randomPr;
    }
}
