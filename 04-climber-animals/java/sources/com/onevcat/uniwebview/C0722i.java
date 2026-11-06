package com.onevcat.uniwebview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.onevcat.uniwebview.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0722i extends AbstractC0725j {
    public final String a;

    public C0722i(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.a = url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0722i) && Intrinsics.areEqual(this.a, ((C0722i) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Normal(url=" + this.a + ')';
    }
}
