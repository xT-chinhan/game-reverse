package com.smartdigimkt.y0;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public final Uri a;
    public final long b;
    public final long c;
    public final String d;

    public k(Uri uri, long j, String str) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        this.a = uri;
        this.b = j;
        this.c = j;
        this.d = str;
    }

    public final String toString() {
        return com.smartdigimkt.f.i.a(new StringBuilder("DataSpec[").append(this.a).append(", ").append(Arrays.toString((byte[]) null)).append(", ").append(this.b).append(", ").append(this.c).append(", -1, "), this.d, ", 0]");
    }
}
