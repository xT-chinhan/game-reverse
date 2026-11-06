package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class c7 {
    public static final int[] a = {10000, 10000};
    public static volatile c7 b;

    public static void a(c7 c7Var, cg cgVar) {
        c7Var.getClass();
        try {
            cgVar.b = 0;
            cgVar.d = System.currentTimeMillis();
            int[] iArr = cgVar.m;
            if (iArr == null || iArr.length == 0) {
                iArr = a;
            }
            g4 g4Var = new g4();
            while (cgVar.b < iArr.length) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strA = g4Var.a(cgVar, iArr[cgVar.b]);
                int i = g4Var.a;
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (i != 200 && i != 206) {
                    int i2 = cgVar.b + 1;
                    cgVar.b = i2;
                    if (i2 == iArr.length) {
                        a(2, cgVar, null, i, jCurrentTimeMillis2);
                        return;
                    }
                }
                a(1, cgVar, cgVar.a ? gj.a(20, strA, cgVar.g) : strA, i, jCurrentTimeMillis2);
                return;
            }
        } catch (Throwable th) {
            r9.a("ssp_req", "executeRequestInExecutor: ", th);
            a(2, cgVar, null, -1, 0L);
        }
    }

    public static c7 a() {
        if (b == null) {
            synchronized (c7.class) {
                if (b == null) {
                    b = new c7();
                }
            }
        }
        return b;
    }

    public static void a(int i, cg cgVar, String str, int i2, long j) {
        if (cgVar.k != null) {
            cgVar.e = System.currentTimeMillis();
            try {
                if (i == 1) {
                    cgVar.k.a(str, new h7((int) j, cgVar.b));
                } else {
                    cgVar.k.a(new h7(i2, (int) j, cgVar.b));
                }
            } catch (Throwable th) {
                r9.a("ssp_req", "callback: ", th);
            }
        }
        p9.a.getClass();
        eh.a.a(new l9(i2, j, cgVar));
    }
}
