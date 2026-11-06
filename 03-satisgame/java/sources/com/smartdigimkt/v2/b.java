package com.smartdigimkt.v2;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final String a;
    public final long b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final String f;

    public b(String str, String str2, boolean z, long j, boolean z2, String str3) {
        this.a = str;
        this.f = str2;
        this.e = z;
        this.b = j;
        this.c = z2;
        this.d = str3;
    }

    public final String toString() {
        return com.smartdigimkt.f.i.a(new StringBuilder().append(com.smartdigimkt.r4.o.g).append("InspectResult{pkgName='").append(this.a).append("', inspectTime=").append(this.b).append(", inspectResult=").append(this.c).append(", appVersion='").append(this.d).append("', isRealTimeInspect=").append(this.e).append(", uploadKey='"), this.f, "'}");
    }
}
