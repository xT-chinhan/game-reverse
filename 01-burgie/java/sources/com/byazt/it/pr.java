package com.byazt.it;

import com.byazt.mr.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1799, 37})
public final class pr {
    public static final Map<Integer, WeakReference<g>> pr = new HashMap();

    public static void pr(Integer num, g gVar) {
        pr.put(num, new WeakReference<>(gVar));
    }

    public static g pr(Integer num) {
        WeakReference<g> weakReference = pr.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
