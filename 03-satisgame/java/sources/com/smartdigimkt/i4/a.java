package com.smartdigimkt.i4;

import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {
    @Override // com.smartdigimkt.i4.d
    public final synchronized void a(com.smartdigimkt.h4.d dVar, com.smartdigimkt.h4.c cVar) {
        if (this.d.getInputStream().read(this.f, 0, 1) == -1) {
            throw new SocketException("Socket.InputStream read length = -1!");
        }
        byte[] bArr = this.f;
        byte b = bArr[0];
        bArr[0] = 0;
        if (b != 1) {
            throw new Exception("Response Error Code:" + ((int) b));
        }
        if (cVar != null) {
            cVar.a(dVar);
        }
        dVar.toString();
    }
}
