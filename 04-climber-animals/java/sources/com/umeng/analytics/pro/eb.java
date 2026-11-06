package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes4.dex */
public final class eb {
    public final String a;
    public final byte b;
    public final int c;

    public eb() {
        this("", (byte) 0, 0);
    }

    public eb(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof eb) {
            return a((eb) obj);
        }
        return false;
    }

    public boolean a(eb ebVar) {
        return this.a.equals(ebVar.a) && this.b == ebVar.b && this.c == ebVar.c;
    }
}
