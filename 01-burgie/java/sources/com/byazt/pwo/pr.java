package com.byazt.pwo;

import java.net.DatagramSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1992, 37})
public abstract class pr {
    public static final hw c = new hn();
    public boolean hn;
    public DatagramSocket hw;
    public int pr;
    public hw x;

    public void pr() throws SocketException {
        DatagramSocket datagramSocketPr = this.x.pr();
        this.hw = datagramSocketPr;
        datagramSocketPr.setSoTimeout(this.pr);
        this.hn = true;
    }

    public boolean hw() {
        return this.hn;
    }
}
