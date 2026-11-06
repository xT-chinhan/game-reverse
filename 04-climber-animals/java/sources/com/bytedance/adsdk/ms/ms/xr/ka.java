package com.bytedance.adsdk.ms.ms.xr;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected c f325ms;

    public ka(c cVar) {
        this.f325ms = cVar;
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public long ms(long j) throws IOException {
        return this.f325ms.ms(j);
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public byte c_() throws IOException {
        return this.f325ms.c_();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public void d_() throws IOException {
        this.f325ms.d_();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public int ah() {
        return this.f325ms.ah();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public int ms(byte[] bArr, int i, int i2) throws IOException {
        return this.f325ms.ms(bArr, i, i2);
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public int d() throws IOException {
        return this.f325ms.d();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public InputStream ka() throws IOException {
        d_();
        return this.f325ms.ka();
    }
}
