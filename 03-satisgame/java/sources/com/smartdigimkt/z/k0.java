package com.smartdigimkt.z;

import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {
    public static volatile k0 c;
    public final com.smartdigimkt.p3.i a;
    public final com.smartdigimkt.p3.l b;

    public k0() {
        SDKContext.getInstance().d();
        this.a = new com.smartdigimkt.p3.i(1, 50);
        this.b = new com.smartdigimkt.p3.l(1);
    }

    public static k0 a() {
        if (c == null) {
            synchronized (g0.class) {
                if (c == null) {
                    c = new k0();
                }
            }
        }
        return c;
    }
}
