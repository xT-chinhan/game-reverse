package com.byazt.p;

import com.anythink.core.common.d.i;
import java.net.DatagramPacket;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 914, 26})
public class qg implements s {
    public final byte[] n = new byte[48];
    public volatile DatagramPacket qg;

    public static final int n(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public static final long qg(byte b) {
        return b & UByte.MAX_VALUE;
    }

    @Override // com.byazt.p.s
    public String getType() {
        return "NTP";
    }

    public int n() {
        return (n(this.n[0]) >> 0) & 7;
    }

    @Override // com.byazt.p.s
    public void n(int i) {
        byte[] bArr = this.n;
        bArr[0] = (byte) ((i & 7) | (bArr[0] & 248));
    }

    public int qg() {
        return this.n[2];
    }

    public int s() {
        return this.n[3];
    }

    public int q() {
        return (n(this.n[0]) >> 3) & 7;
    }

    @Override // com.byazt.p.s
    public void qg(int i) {
        byte[] bArr = this.n;
        bArr[0] = (byte) (((i & 7) << 3) | (bArr[0] & 199));
    }

    public int l() {
        return n(this.n[1]);
    }

    public int w() {
        return s(4);
    }

    public int x() {
        return s(8);
    }

    public double fs() {
        return ((double) x()) / 65.536d;
    }

    public int rv() {
        return s(12);
    }

    public String tj() {
        int iQ = q();
        int iL = l();
        if (iQ == 3 || iQ == 4) {
            if (iL == 0 || iL == 1) {
                return cy();
            }
            if (iQ == 4) {
                return hd();
            }
        }
        if (iL >= 2) {
            return k();
        }
        return hd();
    }

    private String k() {
        return n(this.n[12]) + i.E + n(this.n[13]) + i.E + n(this.n[14]) + i.E + n(this.n[15]);
    }

    private String cy() {
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 3 && (c = (char) this.n[i + 12]) != 0; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String hd() {
        return Integer.toHexString(rv());
    }

    @Override // com.byazt.p.s
    public l cp() {
        return q(40);
    }

    @Override // com.byazt.p.s
    public void n(l lVar) {
        n(40, lVar);
    }

    @Override // com.byazt.p.s
    public l d() {
        return q(24);
    }

    @Override // com.byazt.p.s
    public l oa() {
        return q(32);
    }

    private int s(int i) {
        return n(this.n[i + 3]) | (n(this.n[i]) << 24) | (n(this.n[i + 1]) << 16) | (n(this.n[i + 2]) << 8);
    }

    private l q(int i) {
        return new l(l(i));
    }

    private long l(int i) {
        return (qg(this.n[i]) << 56) | (qg(this.n[i + 1]) << 48) | (qg(this.n[i + 2]) << 40) | (qg(this.n[i + 3]) << 32) | (qg(this.n[i + 4]) << 24) | (qg(this.n[i + 5]) << 16) | (qg(this.n[i + 6]) << 8) | qg(this.n[i + 7]);
    }

    private void n(int i, l lVar) {
        long jN = lVar == null ? 0L : lVar.n();
        for (int i2 = 7; i2 >= 0; i2--) {
            this.n[i + i2] = (byte) (255 & jN);
            jN >>>= 8;
        }
    }

    @Override // com.byazt.p.s
    public synchronized DatagramPacket sz() {
        if (this.qg == null) {
            byte[] bArr = this.n;
            this.qg = new DatagramPacket(bArr, bArr.length);
            this.qg.setPort(123);
        }
        return this.qg;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.n, ((qg) obj).n);
    }

    public int hashCode() {
        return Arrays.hashCode(this.n);
    }

    public String toString() {
        return "[version:" + q() + ", mode:" + n() + ", poll:" + qg() + ", precision:" + s() + ", delay:" + w() + ", dispersion(ms):" + fs() + ", id:" + tj() + ", xmitTime:" + cp().l() + " ]";
    }
}
