package com.bytedance.sdk.component.ah.xr.ms.ka;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {
    public final com.bytedance.sdk.component.ah.ms.c ab;
    final int ny;
    public final com.bytedance.sdk.component.ah.ms.c x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final com.bytedance.sdk.component.ah.ms.c f1086ms = com.bytedance.sdk.component.ah.ms.c.ms(":");
    public static final com.bytedance.sdk.component.ah.ms.c xr = com.bytedance.sdk.component.ah.ms.c.ms(":status");
    public static final com.bytedance.sdk.component.ah.ms.c ah = com.bytedance.sdk.component.ah.ms.c.ms(":method");
    public static final com.bytedance.sdk.component.ah.ms.c d = com.bytedance.sdk.component.ah.ms.c.ms(":path");
    public static final com.bytedance.sdk.component.ah.ms.c ka = com.bytedance.sdk.component.ah.ms.c.ms(":scheme");
    public static final com.bytedance.sdk.component.ah.ms.c c = com.bytedance.sdk.component.ah.ms.c.ms(":authority");

    public ah(String str, String str2) {
        this(com.bytedance.sdk.component.ah.ms.c.ms(str), com.bytedance.sdk.component.ah.ms.c.ms(str2));
    }

    public ah(com.bytedance.sdk.component.ah.ms.c cVar, String str) {
        this(cVar, com.bytedance.sdk.component.ah.ms.c.ms(str));
    }

    public ah(com.bytedance.sdk.component.ah.ms.c cVar, com.bytedance.sdk.component.ah.ms.c cVar2) {
        this.ab = cVar;
        this.x = cVar2;
        this.ny = cVar.ab() + 32 + cVar2.ab();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ah) {
            ah ahVar = (ah) obj;
            if (this.ab.equals(ahVar.ab) && this.x.equals(ahVar.x)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.ab.hashCode() + 527) * 31) + this.x.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.ah.xr.ms.ah.ms("%s: %s", this.ab.ms(), this.x.ms());
    }
}
