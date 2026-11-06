package com.byazt.c;

import java.net.DatagramSocket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2152, 19})
public abstract class n {
    public static final qg l = new s();
    public int n;
    public qg q;
    public DatagramSocket qg;
    public boolean s;

    public void n() throws SocketException {
        DatagramSocket datagramSocketN = this.q.n();
        this.qg = datagramSocketN;
        datagramSocketN.setSoTimeout(this.n);
        this.s = true;
    }

    public boolean qg() {
        return this.s;
    }
}
