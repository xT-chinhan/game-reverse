package com.smartdigimkt.i4;

import java.io.InputStream;
import java.net.SocketException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    @Override // com.smartdigimkt.i4.d
    public final synchronized void a(com.smartdigimkt.h4.d dVar, com.smartdigimkt.h4.c cVar) {
        InputStream inputStream = this.d.getInputStream();
        if (inputStream.read(this.f, 0, 1) == -1) {
            throw new SocketException("Socket.InputStream read length = -1!");
        }
        byte[] bArr = this.f;
        byte b = bArr[0];
        bArr[0] = 0;
        if (b != 2) {
            if (cVar != null) {
                cVar.a((Object) null);
            }
            return;
        }
        inputStream.read(new byte[1], 0, 1);
        byte[] bArr2 = new byte[4];
        inputStream.read(bArr2, 0, 4);
        int i = ByteBuffer.wrap(bArr2).getInt();
        if (i <= 0) {
            if (cVar != null) {
                cVar.a((Object) null);
            }
            return;
        }
        byte[] bArr3 = new byte[i];
        inputStream.read(bArr3, 0, i);
        String str = new String(bArr3);
        if (cVar != null) {
            cVar.a(str);
        }
    }
}
