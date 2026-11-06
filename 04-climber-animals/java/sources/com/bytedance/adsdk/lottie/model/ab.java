package com.bytedance.adsdk.lottie.model;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class ab<T> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    T f177ms;
    T xr;

    public void ms(T t, T t2) {
        this.f177ms = t;
        this.xr = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return xr(pair.first, this.f177ms) && xr(pair.second, this.xr);
    }

    private static boolean xr(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.f177ms;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.xr;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f177ms + " " + this.xr + "}";
    }
}
