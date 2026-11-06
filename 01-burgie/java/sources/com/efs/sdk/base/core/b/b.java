package com.efs.sdk.base.core.b;

import android.support.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private ConcurrentHashMap<Byte, e> a = new ConcurrentHashMap<>();

    @Nullable
    public final e a(byte b) {
        if (!this.a.containsKey(Byte.valueOf(b))) {
            switch (b) {
                case 1:
                    this.a.putIfAbsent(Byte.valueOf(b), new g());
                    break;
                case 2:
                    this.a.putIfAbsent(Byte.valueOf(b), new d());
                    break;
                default:
                    Log.w("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)));
                    break;
            }
        }
        return this.a.get(Byte.valueOf(b));
    }
}
