package com.byazt.kl;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 210})
public class k {
    public static long n(List<rv> list) {
        int size = list.size();
        long jL = 0;
        for (int i = 0; i < size; i++) {
            rv rvVar = list.get(i);
            if (rvVar.s() > jL) {
                break;
            }
            if (rvVar.l() > jL) {
                jL = rvVar.l();
            }
        }
        return jL;
    }

    public static long qg(List<rv> list) {
        long jS;
        long jQ;
        Iterator<rv> it = list.iterator();
        long j = 0;
        loop0: while (true) {
            jS = -1;
            jQ = -1;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                rv next = it.next();
                if (jS == -1) {
                    if (next.n() > 0) {
                        jS = next.s();
                        jQ = next.q();
                    }
                } else if (next.s() > jQ) {
                    j += jQ - jS;
                    if (next.n() > 0) {
                        jS = next.s();
                        jQ = next.q();
                    }
                } else if (next.q() > jQ) {
                    jQ = next.q();
                }
            }
        }
        return (jS < 0 || jQ <= jS) ? j : j + (jQ - jS);
    }
}
