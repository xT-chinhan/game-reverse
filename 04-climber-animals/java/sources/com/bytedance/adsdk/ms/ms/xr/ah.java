package com.bytedance.adsdk.ms.ms.xr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ByteBuffer f323ms;

    public ah(ByteBuffer byteBuffer) {
        this.f323ms = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public long ms(long j) throws IOException {
        ByteBuffer byteBuffer = this.f323ms;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public byte c_() throws IOException {
        return this.f323ms.get();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public void d_() throws IOException {
        this.f323ms.position(0);
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public int ah() {
        return this.f323ms.position();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public int ms(byte[] bArr, int i, int i2) throws IOException {
        this.f323ms.get(bArr, i, i2);
        return i2;
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public int d() throws IOException {
        return this.f323ms.limit() - this.f323ms.position();
    }

    @Override // com.bytedance.adsdk.ms.ms.xr.c
    public InputStream ka() throws IOException {
        return new ByteArrayInputStream(this.f323ms.array());
    }
}
