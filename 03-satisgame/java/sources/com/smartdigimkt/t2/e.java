package com.smartdigimkt.t2;

import com.smartdigimkt.sdk.core.SDKContext;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static volatile e c;
    public com.smartdigimkt.z2.q a;
    public final ConcurrentHashMap b;

    public e() {
        if (SDKContext.getInstance().d() != null) {
            this.a = com.smartdigimkt.z2.q.a(com.smartdigimkt.z2.d.a(SDKContext.getInstance().d()));
        }
        this.b = new ConcurrentHashMap(3);
    }

    public static e a() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = new e();
                }
            }
        }
        return c;
    }
}
