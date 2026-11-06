package com.byazt.sj;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 83, 18})
public final class l {
    public static volatile qg n;
    public static final ConcurrentHashMap<String, n> qg = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, Integer> s = new ConcurrentHashMap<>();

    public interface n {
        int n();
    }

    public interface qg {
        void n();

        void qg();
    }

    public static void n(qg qgVar) {
        n = qgVar;
    }

    public static void qg(qg qgVar) {
        if (n == qgVar) {
            n = null;
        }
    }

    public static void n(String str, n nVar) {
        if (TextUtils.isEmpty(str) || nVar == null) {
            return;
        }
        qg.put(str, nVar);
        s.remove(str);
    }

    public static void qg(String str, n nVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ConcurrentHashMap<String, n> concurrentHashMap = qg;
        if (concurrentHashMap.get(str) == nVar) {
            if (nVar != null) {
                s.put(str, Integer.valueOf(nVar.n()));
            }
            concurrentHashMap.remove(str);
        }
    }

    public static int n(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        n nVar = qg.get(str);
        if (nVar != null) {
            return nVar.n();
        }
        Integer num = s.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static void n() {
        qg qgVar = n;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    public static void qg() {
        qg qgVar = n;
        if (qgVar != null) {
            qgVar.qg();
        }
    }
}
