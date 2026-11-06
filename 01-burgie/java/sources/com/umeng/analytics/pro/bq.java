package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes3.dex */
public class bq {
    public final String a;
    public final byte b;
    public final short c;

    public bq() {
        this("", (byte) 0, (short) 0);
    }

    public bq(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }

    public boolean a(bq bqVar) {
        return this.b == bqVar.b && this.c == bqVar.c;
    }
}
