package com.byazt.ld;

import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 101})
public class fs<T> {
    public T n;
    public T qg;

    public void n(T t, T t2) {
        this.n = t;
        this.qg = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return qg(pair.first, this.n) && qg(pair.second, this.qg);
    }

    private static boolean qg(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.n;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.qg;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.n + " " + this.qg + "}";
    }
}
