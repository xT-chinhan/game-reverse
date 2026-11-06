package com.efs.sdk.base.core.cache;

import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private ConcurrentHashMap<Byte, d> a = new ConcurrentHashMap<>();

    final d a(byte b) {
        if (!this.a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                this.a.putIfAbsent(Byte.valueOf(b), new e());
            } else if (b == 2) {
                this.a.putIfAbsent(Byte.valueOf(b), new c());
            } else {
                Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
            }
        }
        return this.a.get(Byte.valueOf(b));
    }
}
