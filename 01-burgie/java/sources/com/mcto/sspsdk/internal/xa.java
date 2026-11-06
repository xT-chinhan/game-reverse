package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class xa {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public String e;
    public final String f;
    public String g;

    public xa(String str, String str2) {
        this.a = str;
        this.c = str2;
    }

    public final String toString() {
        return "PackageItem{packageName='" + this.a + "', appName='" + this.b + "', insTimeStamp='" + this.c + "', upTimeStamp='" + this.d + "', uniTimeStamp='" + this.e + "', appVersion='" + this.f + "', uniAcc='" + this.g + "'}";
    }

    public xa(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f = str5;
    }
}
