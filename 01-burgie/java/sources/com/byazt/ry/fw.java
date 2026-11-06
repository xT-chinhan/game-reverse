package com.byazt.ry;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 21, 62})
public final class fw {
    public static HashMap<Integer, pr> hn;
    public static HashMap<Integer, c> hw;
    public static volatile fw pr;

    private fw() {
        hw = new HashMap<>();
        hn = new HashMap<>();
    }

    public static synchronized fw pr() {
        if (pr == null) {
            synchronized (fw.class) {
                if (pr == null) {
                    pr = new fw();
                }
            }
        }
        return pr;
    }

    public c pr(int i) {
        c cVar = hw.get(Integer.valueOf(i));
        if (cVar == null) {
            c cVar2 = new c(i);
            hw.put(Integer.valueOf(i), cVar2);
            return cVar2;
        }
        return cVar;
    }

    public pr pr(int i, Context context) {
        pr prVar = hn.get(Integer.valueOf(i));
        if (prVar == null) {
            pr prVar2 = new pr(context, i);
            hn.put(Integer.valueOf(i), prVar2);
            return prVar2;
        }
        return prVar;
    }
}
