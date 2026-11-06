package com.byazt.vy;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 866})
public class py {
    public static <T> boolean n(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean qg(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
