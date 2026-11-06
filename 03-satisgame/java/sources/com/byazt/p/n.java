package com.byazt.p;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 914, 19})
public final class n extends com.byazt.c.n {
    public int l;

    public q n(InetAddress inetAddress, int i) throws IOException {
        if (!qg()) {
            n();
        }
        qg qgVar = new qg();
        qgVar.n(3);
        qgVar.qg(this.l);
        DatagramPacket datagramPacketSz = qgVar.sz();
        datagramPacketSz.setAddress(inetAddress);
        datagramPacketSz.setPort(i);
        qg qgVar2 = new qg();
        DatagramPacket datagramPacketSz2 = qgVar2.sz();
        qgVar.n(l.q());
        this.qg.send(datagramPacketSz);
        this.qg.receive(datagramPacketSz2);
        return new q(qgVar2, System.currentTimeMillis(), false);
    }

    public q n(InetAddress inetAddress) throws IOException {
        return n(inetAddress, 123);
    }
}
