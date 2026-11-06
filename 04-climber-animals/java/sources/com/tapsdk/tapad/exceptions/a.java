package com.tapsdk.tapad.exceptions;

/* JADX INFO: loaded from: classes3.dex */
public class a extends RuntimeException {
    public int a;
    public String b;
    public String c;
    public long d;

    public a(int i, String str) {
        super(str);
        this.a = i;
        this.b = str;
    }

    public a(int i, String str, String str2, long j) {
        this(i, str);
        this.c = str2;
        this.d = j;
    }

    public a(String str) {
        super(str);
    }
}
