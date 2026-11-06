package com.umeng.analytics.pro;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes3.dex */
public class bp extends bv {
    private static final ca d = new ca("");
    private static final bq e = new bq("", (byte) 0, 0);
    private static final byte[] f = new byte[16];
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;
    byte[] a;
    byte[] b;
    byte[] c;
    private au m;
    private short n;
    private bq o;
    private Boolean p;
    private final long q;
    private byte[] r;

    static {
        f[0] = 0;
        f[2] = 1;
        f[3] = 3;
        f[6] = 4;
        f[8] = 5;
        f[10] = 6;
        f[4] = 7;
        f[11] = 8;
        f[15] = 9;
        f[14] = 10;
        f[13] = 11;
        f[12] = 12;
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements bx {
        private final long a;

        public a() {
            this.a = -1L;
        }

        public a(int i) {
            this.a = i;
        }

        @Override // com.umeng.analytics.pro.bx
        public bv a(cj cjVar) {
            return new bp(cjVar, this.a);
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    private static class b {
        public static final byte a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    public bp(cj cjVar, long j2) {
        super(cjVar);
        this.m = new au(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    public bp(cj cjVar) {
        this(cjVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bv
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bt btVar) throws bc {
        b(h);
        d(((btVar.b << 5) & (-32)) | 1);
        b(btVar.c);
        a(btVar.a);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ca caVar) throws bc {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bv
    public void b() throws bc {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bq bqVar) throws bc {
        if (bqVar.b == 2) {
            this.o = bqVar;
        } else {
            a(bqVar, (byte) -1);
        }
    }

    private void a(bq bqVar, byte b2) throws bc {
        if (b2 == -1) {
            b2 = e(bqVar.b);
        }
        if (bqVar.c > this.n && bqVar.c - this.n <= 15) {
            d(b2 | ((bqVar.c - this.n) << 4));
        } else {
            b(b2);
            a(bqVar.c);
        }
        this.n = bqVar.c;
    }

    @Override // com.umeng.analytics.pro.bv
    public void d() throws bc {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bs bsVar) throws bc {
        if (bsVar.c == 0) {
            d(0);
            return;
        }
        b(bsVar.c);
        d(e(bsVar.b) | (e(bsVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(br brVar) throws bc {
        a(brVar.a, brVar.b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bz bzVar) throws bc {
        a(bzVar.a, bzVar.b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(boolean z) throws bc {
        if (this.o != null) {
            a(this.o, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(byte b2) throws bc {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(short s) throws bc {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(int i2) throws bc {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(long j2) throws bc {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(double d2) throws bc {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(String str) throws bc {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e2) {
            throw new bc("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ByteBuffer byteBuffer) throws bc {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bc {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void e() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void f() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void g() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void c() throws bc {
    }

    protected void a(byte b2, int i2) throws bc {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void b(int i2) throws bc {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.a[i3] = (byte) ((i2 & WorkQueueKt.MASK) | 128);
            i2 >>>= 7;
            i3++;
        }
        this.a[i3] = (byte) i2;
        this.g.b(this.a, 0, i3 + 1);
    }

    private void b(long j2) throws bc {
        int i2 = 0;
        while ((j2 & (-128)) != 0) {
            this.b[i2] = (byte) ((j2 & 127) | 128);
            j2 >>>= 7;
            i2++;
        }
        this.b[i2] = (byte) j2;
        this.g.b(this.b, 0, i2 + 1);
    }

    private long c(long j2) {
        return (j2 << 1) ^ (j2 >> 63);
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private void b(byte b2) throws bc {
        this.r[0] = b2;
        this.g.b(this.r);
    }

    private void d(int i2) throws bc {
        b((byte) i2);
    }

    @Override // com.umeng.analytics.pro.bv
    public bt h() throws bc {
        byte bU = u();
        if (bU != -126) {
            throw new bw("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & j);
        if (b2 != 1) {
            throw new bw("Expected version 1 but got " + ((int) b2));
        }
        return new bt(z(), (byte) ((bU2 >> 5) & 3), E());
    }

    @Override // com.umeng.analytics.pro.bv
    public ca j() throws bc {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.bv
    public void k() throws bc {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bv
    public bq l() throws bc {
        short sV;
        byte bU = u();
        if (bU == 0) {
            return e;
        }
        short s = (short) ((bU & 240) >> 4);
        if (s == 0) {
            sV = v();
        } else {
            sV = (short) (this.n + s);
        }
        byte b2 = (byte) (bU & cc.m);
        bq bqVar = new bq("", d(b2), sV);
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bqVar.c;
        return bqVar;
    }

    @Override // com.umeng.analytics.pro.bv
    public bs n() throws bc {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new bs(d((byte) (bU >> 4)), d((byte) (bU & cc.m)), iE);
    }

    @Override // com.umeng.analytics.pro.bv
    public br p() throws bc {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new br(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.bv
    public bz r() throws bc {
        return new bz(p());
    }

    @Override // com.umeng.analytics.pro.bv
    public boolean t() throws bc {
        if (this.p == null) {
            return u() == 1;
        }
        boolean zBooleanValue = this.p.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.bv
    public byte u() throws bc {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        this.g.d(this.c, 0, 1);
        return this.c[0];
    }

    @Override // com.umeng.analytics.pro.bv
    public short v() throws bc {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bv
    public int w() throws bc {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bv
    public long x() throws bc {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bv
    public double y() throws bc {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bv
    public String z() throws bc {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.g.h() >= iE) {
                String str = new String(this.g.f(), this.g.g(), iE, Key.STRING_CHARSET_NAME);
                this.g.a(iE);
                return str;
            }
            return new String(e(iE), Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e2) {
            throw new bc("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public ByteBuffer A() throws bc {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    private byte[] e(int i2) throws bc {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bw {
        if (i2 < 0) {
            throw new bw("Negative length: " + i2);
        }
        if (this.q != -1 && i2 > this.q) {
            throw new bw("Length exceeded max allowed: " + i2);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void i() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void m() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void o() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void q() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void s() throws bc {
    }

    private int E() throws bc {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & 127) << i4;
                if ((b2 & ByteCompanionObject.MIN_VALUE) == 128) {
                    i4 += 7;
                    i2++;
                } else {
                    this.g.a(i2 + 1);
                    return i3;
                }
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & 127) << i5;
                if ((bU & ByteCompanionObject.MIN_VALUE) == 128) {
                    i5 += 7;
                } else {
                    return i2;
                }
            }
        }
    }

    private long F() throws bc {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                long j3 = j2 | (((long) (b2 & 127)) << i3);
                if ((b2 & ByteCompanionObject.MIN_VALUE) == 128) {
                    i3 += 7;
                    i2++;
                    j2 = j3;
                } else {
                    this.g.a(i2 + 1);
                    return j3;
                }
            }
        } else {
            while (true) {
                byte bU = u();
                long j4 = j2 | (((long) (bU & 127)) << i2);
                if ((bU & ByteCompanionObject.MIN_VALUE) == 128) {
                    i2 += 7;
                    j2 = j4;
                } else {
                    return j4;
                }
            }
        }
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    private long d(long j2) {
        return (j2 >>> 1) ^ (-(j2 & 1));
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (((long) bArr[0]) & 255);
    }

    private boolean c(byte b2) {
        int i2 = b2 & cc.m;
        return i2 == 1 || i2 == 2;
    }

    private byte d(byte b2) throws bw {
        byte b3 = (byte) (b2 & cc.m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return cc.m;
            case 10:
                return cc.l;
            case 11:
                return cc.k;
            case 12:
                return (byte) 12;
            default:
                throw new bw("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f[b2];
    }
}
