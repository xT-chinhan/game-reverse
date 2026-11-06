package com.bytedance.sdk.openadsdk.core.video.d;

import com.bytedance.sdk.openadsdk.ao.xr.xr.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Map<Integer, WeakReference<u>> f3582ms = new HashMap();

    public static void ms(Integer num, u uVar) {
        f3582ms.put(num, new WeakReference<>(uVar));
    }

    public static u ms(Integer num) {
        WeakReference<u> weakReference = f3582ms.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
