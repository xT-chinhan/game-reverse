package com.byazt.gaz;

import com.mar.sdk.MARCode;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1689, 37})
public final class pr extends com.byazt.pwo.pr {
    public int c;

    public x pr(InetAddress inetAddress, int i) throws IOException {
        if (!hw()) {
            pr();
        }
        hw hwVar = new hw();
        hwVar.pr(3);
        hwVar.hw(this.c);
        DatagramPacket datagramPacketG = hwVar.g();
        datagramPacketG.setAddress(inetAddress);
        datagramPacketG.setPort(i);
        hw hwVar2 = new hw();
        DatagramPacket datagramPacketG2 = hwVar2.g();
        hwVar.pr(c.x());
        this.hw.send(datagramPacketG);
        this.hw.receive(datagramPacketG2);
        return new x(hwVar2, System.currentTimeMillis(), false);
    }

    public x pr(InetAddress inetAddress) throws IOException {
        return pr(inetAddress, MARCode.CODE_VIVOCHANNEL_CALLBACK);
    }
}
