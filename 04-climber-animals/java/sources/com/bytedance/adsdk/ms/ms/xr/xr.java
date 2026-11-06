package com.bytedance.adsdk.ms.ms.xr;

import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends d {
    public void ms(int i) {
        ms((byte) (i & 255));
        ms((byte) ((i >> 8) & 255));
        ms((byte) ((i >> 16) & 255));
        ms((byte) ((i >> 24) & 255));
    }

    public void xr(int i) {
        ms((byte) ((i >> 24) & 255));
        ms((byte) ((i >> 16) & 255));
        ms((byte) ((i >> 8) & 255));
        ms((byte) (i & 255));
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.d
    public void ah(int i) {
        super.ah(i);
        this.f324ms.order(ByteOrder.BIG_ENDIAN);
    }
}
