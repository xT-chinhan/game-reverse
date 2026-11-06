package com.ss.android.socialbase.downloader.c;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ub {
    public static long ms(List<ny> list) {
        int size = list.size();
        long jKa = 0;
        for (int i = 0; i < size; i++) {
            ny nyVar = list.get(i);
            if (nyVar.ah() > jKa) {
                break;
            }
            if (nyVar.ka() > jKa) {
                jKa = nyVar.ka();
            }
        }
        return jKa;
    }

    public static long xr(List<ny> list) {
        long jAh;
        long jD;
        Iterator<ny> it = list.iterator();
        long j = 0;
        loop0: while (true) {
            jAh = -1;
            jD = -1;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ny next = it.next();
                if (jAh == -1) {
                    if (next.ms() > 0) {
                        jAh = next.ah();
                        jD = next.d();
                    }
                } else if (next.ah() > jD) {
                    j += jD - jAh;
                    if (next.ms() > 0) {
                        jAh = next.ah();
                        jD = next.d();
                    }
                } else if (next.d() > jD) {
                    jD = next.d();
                }
            }
        }
        return (jAh < 0 || jD <= jAh) ? j : j + (jD - jAh);
    }
}
