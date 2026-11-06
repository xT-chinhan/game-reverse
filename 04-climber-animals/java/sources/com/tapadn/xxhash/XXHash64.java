package com.tapadn.xxhash;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class XXHash64 {
    public abstract long hash(ByteBuffer byteBuffer, int i, int i2, long j);

    public final long hash(ByteBuffer byteBuffer, long j) {
        long jHash = hash(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), j);
        byteBuffer.position(byteBuffer.limit());
        return jHash;
    }

    public abstract long hash(byte[] bArr, int i, int i2, long j);

    public String toString() {
        return getClass().getSimpleName();
    }
}
