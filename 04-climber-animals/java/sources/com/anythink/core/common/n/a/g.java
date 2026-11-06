package com.anythink.core.common.n.a;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {
    public g(String str, int i, long j) {
        super(str, i, j);
    }

    private g(String str, int i, long j, int i2) {
        super(str, i, j, i2);
    }

    @Override // com.anythink.core.common.n.a.d
    final e a(d.a aVar, String str, String str2, int i) throws Throwable {
        b bVar = new b((short) (Math.random() * 65535.0d), i, str2);
        byte[] bArrB = bVar.b();
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
                aVar.a.add(new Runnable() { // from class: com.anythink.core.common.n.a.g.1
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
                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[TTAdConstant.STYLE_SIZE_RADIO_3_2], TTAdConstant.STYLE_SIZE_RADIO_3_2);
                datagramSocket2.receive(datagramPacket2);
                Object[] objArr = new Object[2];
                e eVar = new e(str, bVar, datagramPacket2.getData());
                datagramSocket2.close();
                return eVar;
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
