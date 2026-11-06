package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes4.dex */
public class dw extends ed {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final ei h = new ei();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    @Override // com.umeng.analytics.pro.ed
    public void a() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ei eiVar) {
    }

    @Override // com.umeng.analytics.pro.ed
    public void b() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void c() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void e() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void f() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void g() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void i() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void k() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void m() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void o() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void q() {
    }

    @Override // com.umeng.analytics.pro.ed
    public void s() {
    }

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements ef {
        protected boolean a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        @Override // com.umeng.analytics.pro.ef
        public ed a(er erVar) {
            dw dwVar = new dw(erVar, this.a, this.b);
            int i = this.c;
            if (i != 0) {
                dwVar.c(i);
            }
            return dwVar;
        }
    }

    public dw(er erVar) {
        this(erVar, false, true);
    }

    public dw(er erVar, boolean z, boolean z2) {
        super(erVar);
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(eb ebVar) throws dk {
        if (this.d) {
            a(b | ebVar.b);
            a(ebVar.a);
            a(ebVar.c);
        } else {
            a(ebVar.a);
            a(ebVar.b);
            a(ebVar.c);
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(dy dyVar) throws dk {
        a(dyVar.b);
        a(dyVar.c);
    }

    @Override // com.umeng.analytics.pro.ed
    public void d() throws dk {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ea eaVar) throws dk {
        a(eaVar.a);
        a(eaVar.b);
        a(eaVar.c);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(dz dzVar) throws dk {
        a(dzVar.a);
        a(dzVar.b);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(eh ehVar) throws dk {
        a(ehVar.a);
        a(ehVar.b);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(boolean z) throws dk {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(byte b2) throws dk {
        this.i[0] = b2;
        this.g.b(this.i, 0, 1);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(short s) throws dk {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.g.b(this.j, 0, 2);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(int i) throws dk {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.g.b(this.k, 0, 4);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(long j) throws dk {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.g.b(this.l, 0, 8);
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(double d) throws dk {
        a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(String str) throws dk {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public void a(ByteBuffer byteBuffer) throws dk {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // com.umeng.analytics.pro.ed
    public eb h() throws dk {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) != b) {
                throw new ee(4, "Bad version in readMessageBegin");
            }
            return new eb(z(), (byte) (iW & 255), w());
        }
        if (this.c) {
            throw new ee(4, "Missing version in readMessageBegin, old client?");
        }
        return new eb(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public ei j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.ed
    public dy l() throws dk {
        byte bU = u();
        return new dy("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.ed
    public ea n() throws dk {
        return new ea(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public dz p() throws dk {
        return new dz(u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public eh r() throws dk {
        return new eh(u(), w());
    }

    @Override // com.umeng.analytics.pro.ed
    public boolean t() throws dk {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.ed
    public byte u() throws dk {
        if (this.g.h() >= 1) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    @Override // com.umeng.analytics.pro.ed
    public short v() throws dk {
        int iG;
        byte[] bArrF = this.n;
        if (this.g.h() >= 2) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
            iG = 0;
        }
        return (short) ((bArrF[iG + 1] & UByte.MAX_VALUE) | ((bArrF[iG] & UByte.MAX_VALUE) << 8));
    }

    @Override // com.umeng.analytics.pro.ed
    public int w() throws dk {
        int iG;
        byte[] bArrF = this.o;
        if (this.g.h() >= 4) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
            iG = 0;
        }
        return (bArrF[iG + 3] & UByte.MAX_VALUE) | ((bArrF[iG] & UByte.MAX_VALUE) << 24) | ((bArrF[iG + 1] & UByte.MAX_VALUE) << 16) | ((bArrF[iG + 2] & UByte.MAX_VALUE) << 8);
    }

    @Override // com.umeng.analytics.pro.ed
    public long x() throws dk {
        int iG;
        byte[] bArrF = this.p;
        if (this.g.h() >= 8) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
            iG = 0;
        }
        return ((long) (bArrF[iG + 7] & UByte.MAX_VALUE)) | (((long) (bArrF[iG] & UByte.MAX_VALUE)) << 56) | (((long) (bArrF[iG + 1] & UByte.MAX_VALUE)) << 48) | (((long) (bArrF[iG + 2] & UByte.MAX_VALUE)) << 40) | (((long) (bArrF[iG + 3] & UByte.MAX_VALUE)) << 32) | (((long) (bArrF[iG + 4] & UByte.MAX_VALUE)) << 24) | (((long) (bArrF[iG + 5] & UByte.MAX_VALUE)) << 16) | (((long) (bArrF[iG + 6] & UByte.MAX_VALUE)) << 8);
    }

    @Override // com.umeng.analytics.pro.ed
    public double y() throws dk {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.ed
    public String z() throws dk {
        int iW = w();
        if (this.g.h() >= iW) {
            try {
                String str = new String(this.g.f(), this.g.g(), iW, "UTF-8");
                this.g.a(iW);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new dk("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(iW);
    }

    public String b(int i) throws dk {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.ed
    public ByteBuffer A() throws dk {
        int iW = w();
        d(iW);
        if (this.g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.g.f(), this.g.g(), iW);
            this.g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i, int i2) throws dk {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    protected void d(int i) throws dk {
        if (i < 0) {
            throw new ee("Negative length: " + i);
        }
        if (this.f) {
            int i2 = this.e - i;
            this.e = i2;
            if (i2 < 0) {
                throw new ee("Message length exceeded: " + i);
            }
        }
    }
}
