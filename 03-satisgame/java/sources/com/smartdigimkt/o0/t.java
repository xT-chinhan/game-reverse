package com.smartdigimkt.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public final String a;
    public final com.smartdigimkt.n0.n b;
    public final int c;
    public final byte[] d;

    public t(String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4 = 1;
        if (!((bArr2 == null) ^ (i == 0))) {
            throw new IllegalArgumentException();
        }
        this.a = str;
        this.c = i;
        this.d = bArr2;
        if (str != null && (str.equals("cbc1") || str.equals("cbcs"))) {
            i4 = 2;
        }
        this.b = new com.smartdigimkt.n0.n(i4, bArr, i2, i3);
    }
}
