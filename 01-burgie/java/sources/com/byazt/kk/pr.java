package com.byazt.kk;

import android.support.v4.view.PointerIconCompat;
import com.byazt.fh.x;
import com.byazt.is.vk;
import com.byazt.sf.hw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 37})
public final class pr {
    public static volatile boolean pr;

    public static void pr() {
        if (!vk.zo()) {
            return;
        }
        pr = true;
        if (!hw.hw()) {
            return;
        }
        com.byazt.ib.pr.pr().hw();
        x.pr().hw();
        com.byazt.ka.pr.pr().hw();
    }

    public static void hw() {
        if (!vk.zo() || !pr) {
            return;
        }
        com.byazt.ib.pr.pr().hn();
        x.pr().hn();
        com.byazt.ka.pr.pr().hn();
    }

    public static void hn() {
        if (!vk.zo() || !pr) {
            return;
        }
        pr();
    }
}
