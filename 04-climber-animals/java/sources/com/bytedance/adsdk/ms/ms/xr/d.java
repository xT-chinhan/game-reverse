package com.bytedance.adsdk.ms.ms.xr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected ByteBuffer f324ms;

    public d() {
        ah(10240);
    }

    public void ms(byte b) {
        this.f324ms.put(b);
    }

    public void ms(byte[] bArr) {
        this.f324ms.put(bArr);
    }

    public int ms() {
        return this.f324ms.position();
    }

    public void d(int i) {
        this.f324ms.position(i + ms());
    }

    public byte[] xr() {
        return this.f324ms.array();
    }

    public void ah(int i) {
        ByteBuffer byteBuffer = this.f324ms;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.f324ms = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.f324ms.clear();
    }
}
