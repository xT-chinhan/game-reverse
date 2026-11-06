package com.byazt.gaz;

import com.mar.sdk.MARCode;
import java.net.DatagramPacket;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1689, 13})
public class hw implements hn {
    public volatile DatagramPacket hw;
    public final byte[] pr = new byte[48];

    public int pr() {
        return (pr(this.pr[0]) >> 0) & 7;
    }

    @Override // com.byazt.gaz.hn
    public void pr(int i) {
        byte[] bArr = this.pr;
        bArr[0] = (byte) ((i & 7) | (bArr[0] & 248));
    }

    public int hw() {
        return this.pr[2];
    }

    public int hn() {
        return this.pr[3];
    }

    public int x() {
        return (pr(this.pr[0]) >> 3) & 7;
    }

    @Override // com.byazt.gaz.hn
    public void hw(int i) {
        byte[] bArr = this.pr;
        bArr[0] = (byte) (((i & 7) << 3) | (bArr[0] & 199));
    }

    public int c() {
        return pr(this.pr[1]);
    }

    public int uc() {
        return hn(4);
    }

    public int fw() {
        return hn(8);
    }

    public double zo() {
        return ((double) fw()) / 65.536d;
    }

    public int aj() {
        return hn(12);
    }

    public String vk() {
        int iX = x();
        int iC = c();
        if (iX == 3 || iX == 4) {
            if (iC == 0 || iC == 1) {
                return nt();
            }
            if (iX == 4) {
                return yb();
            }
        }
        if (iC >= 2) {
            return ho();
        }
        return yb();
    }

    private String ho() {
        return pr(this.pr[12]) + "." + pr(this.pr[13]) + "." + pr(this.pr[14]) + "." + pr(this.pr[15]);
    }

    private String nt() {
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 3 && (c = (char) this.pr[i + 12]) != 0; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String yb() {
        return Integer.toHexString(aj());
    }

    @Override // com.byazt.gaz.hn
    public c w() {
        return x(40);
    }

    @Override // com.byazt.gaz.hn
    public void pr(c cVar) {
        pr(40, cVar);
    }

    @Override // com.byazt.gaz.hn
    public c k() {
        return x(24);
    }

    @Override // com.byazt.gaz.hn
    public c m() {
        return x(32);
    }

    @Override // com.byazt.gaz.hn
    public String getType() {
        return "NTP";
    }

    private int hn(int i) {
        return pr(this.pr[i + 3]) | (pr(this.pr[i]) << 24) | (pr(this.pr[i + 1]) << 16) | (pr(this.pr[i + 2]) << 8);
    }

    private c x(int i) {
        return new c(c(i));
    }

    private long c(int i) {
        return (hw(this.pr[i]) << 56) | (hw(this.pr[i + 1]) << 48) | (hw(this.pr[i + 2]) << 40) | (hw(this.pr[i + 3]) << 32) | (hw(this.pr[i + 4]) << 24) | (hw(this.pr[i + 5]) << 16) | (hw(this.pr[i + 6]) << 8) | hw(this.pr[i + 7]);
    }

    private void pr(int i, c cVar) {
        long jPr = cVar == null ? 0L : cVar.pr();
        for (int i2 = 7; i2 >= 0; i2--) {
            this.pr[i + i2] = (byte) (255 & jPr);
            jPr >>>= 8;
        }
    }

    @Override // com.byazt.gaz.hn
    public synchronized DatagramPacket g() {
        if (this.hw == null) {
            byte[] bArr = this.pr;
            this.hw = new DatagramPacket(bArr, bArr.length);
            this.hw.setPort(MARCode.CODE_VIVOCHANNEL_CALLBACK);
        }
        return this.hw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.pr, ((hw) obj).pr);
    }

    public int hashCode() {
        return Arrays.hashCode(this.pr);
    }

    public static final int pr(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public static final long hw(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public String toString() {
        return "[version:" + x() + ", mode:" + pr() + ", poll:" + hw() + ", precision:" + hn() + ", delay:" + uc() + ", dispersion(ms):" + zo() + ", id:" + vk() + ", xmitTime:" + w().c() + " ]";
    }
}
