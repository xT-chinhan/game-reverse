package com.anythink.core.common.m.a;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public final class h extends e {
    public h(String str, int i, long j) {
        super(str, i, j);
    }

    public h(String str, int i, long j, int i2) {
        super(str, i, j, i2);
    }

    @Override // com.anythink.core.common.m.a.e
    final f a(e.a aVar, String str, String str2, int i) throws Throwable {
        c cVar = new c((short) (Math.random() * 65535.0d), i, str2);
        byte[] bArrB = cVar.b();
        InetAddress byName = InetAddress.getByName(str);
        DatagramSocket datagramSocket = null;
        try {
            final DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArrB, bArrB.length, byName, this.b);
                try {
                    datagramSocket2.setSoTimeout((int) this.a);
                } catch (Throwable unused) {
                    datagramSocket2.setSoTimeout(500);
                }
                aVar.a.add(new Runnable() { // from class: com.anythink.core.common.m.a.h.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            datagramSocket2.disconnect();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            datagramSocket2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                datagramSocket2.send(datagramPacket);
                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1500], 1500);
                datagramSocket2.receive(datagramPacket2);
                f fVar = new f(str, cVar, datagramPacket2.getData());
                datagramSocket2.close();
                return fVar;
            } catch (Throwable th) {
                th = th;
                datagramSocket = datagramSocket2;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
