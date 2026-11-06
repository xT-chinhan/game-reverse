package com.smartdigimkt.b3;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ long a(int i) {
        if (i == 1) {
            return 1001L;
        }
        if (i == 2) {
            return 1002L;
        }
        if (i == 3) {
            return 1003L;
        }
        if (i == 4) {
            return 1004L;
        }
        throw null;
    }

    public static boolean a(d dVar) {
        return q.a && dVar != null && (a(3, dVar) || a(4, dVar));
    }

    public static final boolean a(int i, long j) {
        return a(i) == j;
    }

    public static boolean a(long j) {
        return a(3, j) || a(4, j);
    }

    public static long a(long j, c cVar, com.smartdigimkt.a3.a aVar) {
        if (j <= 0) {
            return 0L;
        }
        if (!a(1, j) && !a(2, j)) {
            return j;
        }
        if ((aVar != null && aVar.k == 67) || aVar == null || aVar.c != 4 || !(cVar instanceof l)) {
            return 0L;
        }
        int i = ((l) cVar).U;
        if (i == 1 || i == 3) {
            return j;
        }
        return 0L;
    }

    public static final boolean a(int i, d dVar) {
        return dVar != null && dVar.a == a(i);
    }
}
