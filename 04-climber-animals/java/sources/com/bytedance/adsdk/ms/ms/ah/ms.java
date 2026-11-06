package com.bytedance.adsdk.ms.ms.ah;

import com.bytedance.adsdk.ms.ms.xr.ah;
import com.bytedance.adsdk.ms.ms.xr.c;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements xr {
    public abstract ByteBuffer ms();

    @Override // com.bytedance.adsdk.ms.ms.ah.xr
    public c xr() throws IOException {
        return new ah(ms());
    }
}
