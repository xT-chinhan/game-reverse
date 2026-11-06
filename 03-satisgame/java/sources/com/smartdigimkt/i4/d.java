package com.smartdigimkt.i4;

import com.byazt.ho.BaseConstants;
import com.smartdigimkt.o4.e;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public String b;
    public int c;
    public Socket d;
    public final String a = getClass().getSimpleName();
    public byte[] e = null;
    public final byte[] f = new byte[1];

    public static void a(d dVar, com.smartdigimkt.h4.d dVar2) {
        synchronized (dVar) {
            Socket socket = dVar.d;
            if (socket == null || !socket.isConnected() || dVar.d.isClosed()) {
                dVar.a(dVar2);
            }
            byte[] bArrB = dVar2.b();
            if (bArrB != null) {
                int length = bArrB.length;
                if (bArrB.length == 0) {
                    return;
                }
                int i = length + 7;
                byte[] bArr = dVar.e;
                if (bArr == null || bArr.length < i) {
                    dVar.e = new byte[i];
                }
                byte[] bArr2 = dVar.e;
                bArr2[0] = 0;
                bArr2[1] = (byte) 3;
                bArr2[2] = (byte) dVar2.a();
                byte[] bArr3 = dVar.e;
                bArr3[3] = (byte) ((length >>> 24) & 255);
                bArr3[4] = (byte) ((length >>> 16) & 255);
                bArr3[5] = (byte) ((length >>> 8) & 255);
                bArr3[6] = (byte) (length & 255);
                System.arraycopy(bArrB, 0, bArr3, 7, bArrB.length);
                OutputStream outputStream = dVar.d.getOutputStream();
                outputStream.write(dVar.e, 0, i);
                outputStream.flush();
            }
        }
    }

    public abstract void a(com.smartdigimkt.h4.d dVar, com.smartdigimkt.h4.c cVar);

    public final void a(com.smartdigimkt.h4.d dVar) {
        synchronized (this) {
            if (this.d == null) {
                Socket socket = new Socket();
                this.d = socket;
                socket.setSoTimeout(BaseConstants.Time.MINUTE);
            }
            dVar.getClass();
            com.smartdigimkt.p4.a aVarA = e.c().a();
            com.smartdigimkt.j4.a aVar = aVarA != null ? new com.smartdigimkt.j4.a(aVarA.A, aVarA.B) : null;
            if (aVar != null) {
                this.b = aVar.a;
                this.c = aVar.b;
                this.d.connect(new InetSocketAddress(this.b, this.c), 30000);
            } else {
                throw new IllegalArgumentException("The domain must not can be null or empty.");
            }
        }
    }
}
