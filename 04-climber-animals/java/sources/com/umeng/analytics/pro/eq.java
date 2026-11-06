package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: classes4.dex */
public final class eq extends er {
    private byte[] a;
    private int b;
    private int c;

    @Override // com.umeng.analytics.pro.er
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.er
    public void b() throws es {
    }

    @Override // com.umeng.analytics.pro.er
    public void c() {
    }

    public eq() {
    }

    public eq(byte[] bArr) {
        a(bArr);
    }

    public eq(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    public void c(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i + i2;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.er
    public int a(byte[] bArr, int i, int i2) throws es {
        int iH = h();
        if (i2 > iH) {
            i2 = iH;
        }
        if (i2 > 0) {
            System.arraycopy(this.a, this.b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.umeng.analytics.pro.er
    public void b(byte[] bArr, int i, int i2) throws es {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.er
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.er
    public int g() {
        return this.b;
    }

    @Override // com.umeng.analytics.pro.er
    public int h() {
        return this.c - this.b;
    }

    @Override // com.umeng.analytics.pro.er
    public void a(int i) {
        this.b += i;
    }
}
