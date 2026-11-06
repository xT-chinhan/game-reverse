package com.umeng.analytics.pro;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes3.dex */
public class bo extends bv {
    protected static final int a = -65536;
    protected static final int b = -2147418112;
    private static final ca h = new ca();
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

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements bx {
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
            this.a = false;
            this.b = true;
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        @Override // com.umeng.analytics.pro.bx
        public bv a(cj cjVar) {
            bo boVar = new bo(cjVar, this.a, this.b);
            if (this.c != 0) {
                boVar.c(this.c);
            }
            return boVar;
        }
    }

    public bo(cj cjVar) {
        this(cjVar, false, true);
    }

    public bo(cj cjVar, boolean z, boolean z2) {
        super(cjVar);
        this.c = false;
        this.d = true;
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

    @Override // com.umeng.analytics.pro.bv
    public void a(bt btVar) throws bc {
        if (this.d) {
            a(b | btVar.b);
            a(btVar.a);
            a(btVar.c);
        } else {
            a(btVar.a);
            a(btVar.b);
            a(btVar.c);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ca caVar) {
    }

    @Override // com.umeng.analytics.pro.bv
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bq bqVar) throws bc {
        a(bqVar.b);
        a(bqVar.c);
    }

    @Override // com.umeng.analytics.pro.bv
    public void c() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void d() throws bc {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bs bsVar) throws bc {
        a(bsVar.a);
        a(bsVar.b);
        a(bsVar.c);
    }

    @Override // com.umeng.analytics.pro.bv
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(br brVar) throws bc {
        a(brVar.a);
        a(brVar.b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bz bzVar) throws bc {
        a(bzVar.a);
        a(bzVar.b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(boolean z) throws bc {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(byte b2) throws bc {
        this.i[0] = b2;
        this.g.b(this.i, 0, 1);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(short s) throws bc {
        this.j[0] = (byte) ((s >> 8) & 255);
        this.j[1] = (byte) (s & 255);
        this.g.b(this.j, 0, 2);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(int i) throws bc {
        this.k[0] = (byte) ((i >> 24) & 255);
        this.k[1] = (byte) ((i >> 16) & 255);
        this.k[2] = (byte) ((i >> 8) & 255);
        this.k[3] = (byte) (i & 255);
        this.g.b(this.k, 0, 4);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(long j) throws bc {
        this.l[0] = (byte) ((j >> 56) & 255);
        this.l[1] = (byte) ((j >> 48) & 255);
        this.l[2] = (byte) ((j >> 40) & 255);
        this.l[3] = (byte) ((j >> 32) & 255);
        this.l[4] = (byte) ((j >> 24) & 255);
        this.l[5] = (byte) ((j >> 16) & 255);
        this.l[6] = (byte) ((j >> 8) & 255);
        this.l[7] = (byte) (j & 255);
        this.g.b(this.l, 0, 8);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(double d) throws bc {
        a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(String str) throws bc {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new bc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ByteBuffer byteBuffer) throws bc {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // com.umeng.analytics.pro.bv
    public bt h() throws bc {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) != b) {
                throw new bw(4, "Bad version in readMessageBegin");
            }
            return new bt(z(), (byte) (iW & 255), w());
        }
        if (this.c) {
            throw new bw(4, "Missing version in readMessageBegin, old client?");
        }
        return new bt(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bv
    public ca j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.bv
    public void k() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bq l() throws bc {
        byte bU = u();
        return new bq("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.bv
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bs n() throws bc {
        return new bs(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bv
    public br p() throws bc {
        return new br(u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bv
    public bz r() throws bc {
        return new bz(u(), w());
    }

    @Override // com.umeng.analytics.pro.bv
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bv
    public boolean t() throws bc {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.bv
    public byte u() throws bc {
        if (this.g.h() >= 1) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        a(this.m, 0, 1);
        return this.m[0];
    }

    @Override // com.umeng.analytics.pro.bv
    public short v() throws bc {
        byte[] bArrF = this.n;
        int iG = 0;
        if (this.g.h() >= 2) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & UByte.MAX_VALUE) | ((bArrF[iG] & UByte.MAX_VALUE) << 8));
    }

    @Override // com.umeng.analytics.pro.bv
    public int w() throws bc {
        byte[] bArrF = this.o;
        int iG = 0;
        if (this.g.h() >= 4) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArrF[iG + 3] & UByte.MAX_VALUE) | ((bArrF[iG] & UByte.MAX_VALUE) << 24) | ((bArrF[iG + 1] & UByte.MAX_VALUE) << 16) | ((bArrF[iG + 2] & UByte.MAX_VALUE) << 8);
    }

    @Override // com.umeng.analytics.pro.bv
    public long x() throws bc {
        byte[] bArrF = this.p;
        int iG = 0;
        if (this.g.h() >= 8) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return (((long) (bArrF[iG] & UByte.MAX_VALUE)) << 56) | (((long) (bArrF[iG + 1] & UByte.MAX_VALUE)) << 48) | (((long) (bArrF[iG + 2] & UByte.MAX_VALUE)) << 40) | (((long) (bArrF[iG + 3] & UByte.MAX_VALUE)) << 32) | (((long) (bArrF[iG + 4] & UByte.MAX_VALUE)) << 24) | (((long) (bArrF[iG + 5] & UByte.MAX_VALUE)) << 16) | (((long) (bArrF[iG + 6] & UByte.MAX_VALUE)) << 8) | ((long) (bArrF[iG + 7] & UByte.MAX_VALUE));
    }

    @Override // com.umeng.analytics.pro.bv
    public double y() throws bc {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.bv
    public String z() throws bc {
        int iW = w();
        if (this.g.h() >= iW) {
            try {
                String str = new String(this.g.f(), this.g.g(), iW, Key.STRING_CHARSET_NAME);
                this.g.a(iW);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new bc("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return b(iW);
    }

    public String b(int i) throws bc {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new bc("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public ByteBuffer A() throws bc {
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

    private int a(byte[] bArr, int i, int i2) throws bc {
        d(i2);
        return this.g.d(bArr, i, i2);
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    protected void d(int i) throws bc {
        if (i < 0) {
            throw new bw("Negative length: " + i);
        }
        if (this.f) {
            this.e -= i;
            if (this.e < 0) {
                throw new bw("Message length exceeded: " + i);
            }
        }
    }
}
