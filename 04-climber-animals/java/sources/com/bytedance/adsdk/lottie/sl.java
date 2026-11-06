package com.bytedance.adsdk.lottie;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class sl<V> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final V f271ms;
    private final Throwable xr;

    public sl(V v) {
        this.f271ms = v;
        this.xr = null;
    }

    public sl(Throwable th) {
        this.xr = th;
        this.f271ms = null;
    }

    public V ms() {
        return this.f271ms;
    }

    public Throwable xr() {
        return this.xr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sl)) {
            return false;
        }
        sl slVar = (sl) obj;
        if (ms() != null && ms().equals(slVar.ms())) {
            return true;
        }
        if (xr() == null || slVar.xr() == null) {
            return false;
        }
        return xr().toString().equals(xr().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{ms(), xr()});
    }
}
