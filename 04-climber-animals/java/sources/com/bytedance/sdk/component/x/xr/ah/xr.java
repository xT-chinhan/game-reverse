package com.bytedance.sdk.component.x.xr.ah;

import com.bytedance.sdk.component.x.ms.d;
import com.bytedance.sdk.component.x.ms.ka;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static void ms(AtomicLong atomicLong, int i, ka kaVar) {
        d dVarD = kaVar.d();
        if (dVarD == null || !dVarD.ny() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
