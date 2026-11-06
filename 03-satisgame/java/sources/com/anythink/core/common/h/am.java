package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class am {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e;
    private long f;
    private long g;
    private int h;
    private String i;
    private String j;
    private n k;
    private boolean l;

    private am() {
    }

    public static am a(n nVar, String str, String str2, int i) {
        am amVar = new am();
        amVar.b = nVar.N();
        amVar.d = nVar.aR();
        amVar.a = nVar.aQ();
        amVar.e = nVar.Z();
        amVar.f = System.currentTimeMillis();
        amVar.h = i;
        amVar.i = str;
        amVar.j = str2;
        amVar.k = nVar;
        return amVar;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        String str = this.a;
        return str != null ? str : "";
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.h;
    }

    public final String e() {
        return this.i + "," + this.j;
    }

    public final void a(long j) {
        this.g = j;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final long f() {
        return this.f + this.g;
    }

    public final String g() {
        return this.d;
    }

    public final String h() {
        return this.c;
    }

    public final n i() {
        return this.k;
    }

    public final boolean j() {
        return this.l;
    }

    public final void a(boolean z) {
        this.l = z;
    }

    public final String toString() {
        return "DynWFAdSourceRecordEntity{placementId='" + this.a + "', adSourceId='" + this.b + "', requestId='" + this.d + "', networkFirmId=" + this.e + "', recordTimeStamp=" + this.f + "', recordTimeInterval=" + this.g + "', recordTimeType=" + this.h + "', networkErrorCode='" + this.i + "', networkErrorMsg='" + this.j + "', serverErrorCode='" + this.c + "'}";
    }
}
