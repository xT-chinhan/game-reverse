package com.onevcat.uniwebview;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.onevcat.uniwebview.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0716g {
    public final AbstractC0725j a;
    public String b;
    public final boolean c;

    public C0716g(AbstractC0725j downloadType, String fileName, boolean z) {
        Intrinsics.checkNotNullParameter(downloadType, "downloadType");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.a = downloadType;
        this.b = fileName;
        this.c = z;
    }

    public final String a() {
        AbstractC0725j abstractC0725j = this.a;
        if (abstractC0725j instanceof C0722i) {
            return ((C0722i) abstractC0725j).a;
        }
        if (abstractC0725j instanceof C0719h) {
            return ((C0719h) abstractC0725j).a;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0716g)) {
            return false;
        }
        C0716g c0716g = (C0716g) obj;
        return Intrinsics.areEqual(this.a, c0716g.a) && Intrinsics.areEqual(this.b, c0716g.b) && this.c == c0716g.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z = this.c;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return iHashCode + r0;
    }

    public final String toString() {
        return "DownloadTask(downloadType=" + this.a + ", fileName=" + this.b + ", shouldSendEvent=" + this.c + ')';
    }
}
