package com.tapsdk.tapad.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public class d extends a {
    public String e;

    public d(int i, String str) {
        super(i, str);
    }

    public d(int i, String str, long j, String str2) {
        super(i, str);
        this.a = i;
        this.d = j;
        this.b = str;
        this.c = str2;
    }

    public d(int i, String str, String str2, String str3) {
        super(i, str);
        this.a = i;
        this.e = str2;
        this.b = str;
        this.c = str3;
    }

    public d(String str) {
        super(str);
    }
}
