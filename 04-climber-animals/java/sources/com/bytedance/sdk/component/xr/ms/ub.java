package com.bytedance.sdk.component.xr.ms;

/* JADX INFO: loaded from: classes2.dex */
public class ub {
    public ch ah;
    public ms c;
    public String d;
    public byte[] ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1623ms;
    private String xr;

    public enum ms {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public ub() {
    }

    public String ms() {
        return this.f1623ms;
    }

    public String xr() {
        return this.xr;
    }

    public ub(ch chVar, String str, ms msVar) {
        this.ah = chVar;
        this.d = str;
        this.c = msVar;
    }

    public ub(ch chVar, byte[] bArr, String str, String str2, ms msVar) {
        this.ah = chVar;
        this.ka = bArr;
        this.xr = str;
        this.f1623ms = str2;
        this.c = msVar;
    }

    public ub(ch chVar, byte[] bArr, ms msVar) {
        this.ah = chVar;
        this.ka = bArr;
        this.c = msVar;
    }

    public static ub ms(ch chVar, String str) {
        return new ub(chVar, str, ms.STRING_TYPE);
    }

    public static ub ms(ch chVar, byte[] bArr) {
        return new ub(chVar, bArr, ms.BYTE_ARRAY_TYPE);
    }

    public static ub ms(ch chVar, byte[] bArr, String str, String str2) {
        return new ub(chVar, bArr, str, str2, ms.FILE_TYPE);
    }
}
