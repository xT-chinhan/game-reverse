package com.smartdigimkt.y2;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a c = new a("", "");
    public final String a;
    public final String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean a() {
        return (this.a.isEmpty() || this.b.isEmpty()) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.equals(aVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return this.a + "/" + this.b;
    }
}
