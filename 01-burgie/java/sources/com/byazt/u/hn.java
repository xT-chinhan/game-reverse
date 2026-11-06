package com.byazt.u;

import android.content.Context;
import android.os.Build;
import com.byazt.ihe.m;
import com.byazt.ihe.vk;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1259, 20})
public class hn {
    public static final ConcurrentHashMap<String, hw> pr = new ConcurrentHashMap<>();

    public static synchronized void pr(Context context, m mVar, vk.pr prVar) {
        if (mVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ConcurrentHashMap<String, hw> concurrentHashMap = pr;
            hw hwVar = concurrentHashMap.get(mVar.fo());
            if (hwVar == null) {
                hwVar = new hw(context, mVar);
                concurrentHashMap.put(mVar.fo(), hwVar);
                Object[] objArr = {"preloadVideo:  cache size = ", Integer.valueOf(mVar.fw()), mVar.fo()};
            }
            hwVar.pr(prVar);
        }
        Object[] objArr2 = {"preloadVideo:  cache size = ", Integer.valueOf(mVar.fw()), mVar.fo()};
    }

    public static synchronized void pr(m mVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            hw hwVarRemove = pr.remove(mVar.fo());
            if (hwVarRemove != null) {
                hwVarRemove.pr(true);
            }
            Object[] objArr = {"removePreload:  cache size = ", Integer.valueOf(mVar.fw()), mVar.fo()};
        }
    }
}
