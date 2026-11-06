package com.efs.sdk.net.a;

import java.util.WeakHashMap;
import okhttp3.Call;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final WeakHashMap<Call, f> a = new WeakHashMap<>();

    public static void a(Call call, f fVar) {
        a.put(call, fVar);
    }

    public static f a(Call call) {
        return a.get(call);
    }

    public static void b(Call call) {
        a.remove(call);
    }
}
