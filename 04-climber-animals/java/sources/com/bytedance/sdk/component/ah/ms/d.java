package com.bytedance.sdk.component.ah.ms;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface d extends qv, WritableByteChannel {
    d ab(int i) throws IOException;

    ah ah();

    d ah(byte[] bArr) throws IOException;

    d ah(byte[] bArr, int i, int i2) throws IOException;

    @Override // com.bytedance.sdk.component.ah.ms.qv, java.io.Flushable
    void flush() throws IOException;

    d hi(long j) throws IOException;

    d nw() throws IOException;

    d ny(int i) throws IOException;

    d sl(long j) throws IOException;

    d x(int i) throws IOException;

    d xr(c cVar) throws IOException;

    d xr(String str) throws IOException;
}
