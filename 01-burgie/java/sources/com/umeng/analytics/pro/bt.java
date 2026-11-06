package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bt {
    public final String a;
    public final byte b;
    public final int c;

    public bt() {
        this("", (byte) 0, 0);
    }

    public bt(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof bt) {
            return a((bt) obj);
        }
        return false;
    }

    public boolean a(bt btVar) {
        return this.a.equals(btVar.a) && this.b == btVar.b && this.c == btVar.c;
    }
}
