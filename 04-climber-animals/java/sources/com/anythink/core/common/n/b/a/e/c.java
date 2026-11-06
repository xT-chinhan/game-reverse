package com.anythink.core.common.n.b.a.e;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final String b = ":status";
    public static final String c = ":method";
    public static final String d = ":path";
    public static final String e = ":scheme";
    public static final String f = ":authority";
    public final com.anythink.core.common.n.c.f l;
    public final com.anythink.core.common.n.c.f m;
    final int n;
    public static final com.anythink.core.common.n.c.f a = com.anythink.core.common.n.c.f.a(":");
    public static final com.anythink.core.common.n.c.f g = com.anythink.core.common.n.c.f.a(":status");
    public static final com.anythink.core.common.n.c.f h = com.anythink.core.common.n.c.f.a(":method");
    public static final com.anythink.core.common.n.c.f i = com.anythink.core.common.n.c.f.a(":path");
    public static final com.anythink.core.common.n.c.f j = com.anythink.core.common.n.c.f.a(":scheme");
    public static final com.anythink.core.common.n.c.f k = com.anythink.core.common.n.c.f.a(":authority");

    public c(String str, String str2) {
        this(com.anythink.core.common.n.c.f.a(str), com.anythink.core.common.n.c.f.a(str2));
    }

    public c(com.anythink.core.common.n.c.f fVar, String str) {
        this(fVar, com.anythink.core.common.n.c.f.a(str));
    }

    public c(com.anythink.core.common.n.c.f fVar, com.anythink.core.common.n.c.f fVar2) {
        this.l = fVar;
        this.m = fVar2;
        this.n = fVar.j() + 32 + fVar2.j();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.l.equals(cVar.l) && this.m.equals(cVar.m)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.l.hashCode() + 527) * 31) + this.m.hashCode();
    }

    public final String toString() {
        return com.anythink.core.common.n.b.a.c.a("%s: %s", this.l.a(), this.m.a());
    }
}
