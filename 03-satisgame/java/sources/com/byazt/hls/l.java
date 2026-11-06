package com.byazt.hls;

import com.byazt.vf.cp;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1598, 18})
public class l {
    public static void n(AtomicLong atomicLong, int i, cp cpVar) {
        if (cpVar == null || !cpVar.fs() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
