package com.bytedance.sdk.openadsdk.core.g;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    private static ValueSet ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final AtomicInteger f2514ms = new AtomicInteger(com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), "sync_switch", 0).getInt("status", 1));
    private static com.bytedance.sdk.openadsdk.core.ah xr;

    public static boolean ms() {
        return f2514ms.get() == 1;
    }

    protected static void ms(int i) {
        com.bytedance.sdk.openadsdk.core.ah ahVar;
        if (i == 1 || i == 2) {
            com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), "sync_switch", 0).edit().putInt("status", i).apply();
            AtomicInteger atomicInteger = f2514ms;
            int i2 = atomicInteger.get();
            atomicInteger.set(i);
            if (i2 != 2 || i != 1 || (ahVar = xr) == null || ahVar.isInitSuccess()) {
                return;
            }
            try {
                xr.init(re.getContext(), ah);
                xr = null;
                ah = null;
            } catch (Throwable th) {
                sl.ah("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
