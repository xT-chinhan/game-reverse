package com.byazt.lu;

import com.byazt.fvm.sz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1843, 26})
public final class qg {
    public static final Map<Integer, WeakReference<sz>> n = new HashMap();

    public static void n(Integer num, sz szVar) {
        n.put(num, new WeakReference<>(szVar));
    }

    public static sz n(Integer num) {
        WeakReference<sz> weakReference = n.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
