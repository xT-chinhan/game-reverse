package com.onevcat.uniwebview;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.onevcat.uniwebview.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0734m {
    public final String a;
    public final byte[] b;

    public C0734m(String str, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = str;
        this.b = data;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0734m)) {
            return false;
        }
        C0734m c0734m = (C0734m) obj;
        return Intrinsics.areEqual(this.a, c0734m.a) && Intrinsics.areEqual(this.b, c0734m.b);
    }

    public final int hashCode() {
        String str = this.a;
        return Arrays.hashCode(this.b) + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final String toString() {
        return "ParsedDataUrl(mediaType=" + this.a + ", data=" + Arrays.toString(this.b) + ')';
    }
}
