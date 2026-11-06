package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes4.dex */
public class dy {
    public final String a;
    public final byte b;
    public final short c;

    public dy() {
        this("", (byte) 0, (short) 0);
    }

    public dy(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public String toString() {
        return "<TField name:'" + this.a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }

    public boolean a(dy dyVar) {
        return this.b == dyVar.b && this.c == dyVar.c;
    }
}
