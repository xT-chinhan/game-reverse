package com.byazt.nkg;

import android.content.Context;
import com.byazt.ej.k;
import com.byazt.ej.tj;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1145, 8})
public class s {
    public static final ConcurrentHashMap<String, qg> n = new ConcurrentHashMap<>();

    public static synchronized void n(Context context, k kVar, tj.n nVar) {
        if (kVar == null) {
            return;
        }
        ConcurrentHashMap<String, qg> concurrentHashMap = n;
        qg qgVar = concurrentHashMap.get(kVar.wm());
        if (qgVar == null) {
            qgVar = new qg(context, kVar);
            concurrentHashMap.put(kVar.wm(), qgVar);
            Object[] objArr = new Object[3];
            Integer.valueOf(kVar.x());
            kVar.wm();
        }
        qgVar.n(nVar);
        Object[] objArr2 = new Object[3];
        Integer.valueOf(kVar.x());
        kVar.wm();
    }

    public static synchronized void n(k kVar) {
        qg qgVarRemove = n.remove(kVar.wm());
        if (qgVarRemove != null) {
            qgVarRemove.n(true);
        }
        Object[] objArr = new Object[3];
        Integer.valueOf(kVar.x());
        kVar.wm();
    }
}
