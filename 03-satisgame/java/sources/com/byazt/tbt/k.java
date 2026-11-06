package com.byazt.tbt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 210})
public class k {
    public byte[] l;
    public String n;
    public String q;
    public String qg;
    public tj s;
    public n w;

    public enum n {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public k() {
    }

    public String n() {
        return this.n;
    }

    public String qg() {
        return this.qg;
    }

    public k(tj tjVar, String str, n nVar) {
        this.s = tjVar;
        this.q = str;
        this.w = nVar;
    }

    public k(tj tjVar, byte[] bArr, String str, String str2, n nVar) {
        this.s = tjVar;
        this.l = bArr;
        this.qg = str;
        this.n = str2;
        this.w = nVar;
    }

    public k(tj tjVar, byte[] bArr, n nVar) {
        this.s = tjVar;
        this.l = bArr;
        this.w = nVar;
    }

    public static k n(tj tjVar, String str) {
        return new k(tjVar, str, n.STRING_TYPE);
    }

    public static k n(tj tjVar, byte[] bArr) {
        return new k(tjVar, bArr, n.BYTE_ARRAY_TYPE);
    }

    public static k n(tj tjVar, byte[] bArr, String str, String str2) {
        return new k(tjVar, bArr, str, str2, n.FILE_TYPE);
    }
}
