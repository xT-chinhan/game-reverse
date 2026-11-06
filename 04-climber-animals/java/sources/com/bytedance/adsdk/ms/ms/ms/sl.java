package com.bytedance.adsdk.ms.ms.ms;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class sl extends ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final int f320ms = ka.ms("IHDR");
    int ah;
    byte[] x = new byte[5];
    int xr;

    sl() {
    }

    @Override // com.bytedance.adsdk.ms.ms.ms.ka
    void ms(com.bytedance.adsdk.ms.ms.xr.ms msVar) throws IOException {
        this.xr = msVar.xr();
        this.ah = msVar.xr();
        byte[] bArr = this.x;
        msVar.ms(bArr, 0, bArr.length);
    }
}
