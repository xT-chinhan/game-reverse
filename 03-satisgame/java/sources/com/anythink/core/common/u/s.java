package com.anythink.core.common.u;

import com.anythink.core.api.ATAdConst;

/* JADX INFO: loaded from: classes.dex */
public class s {
    private static final String a = "s";
    private static double b;
    private static double c;

    public static double a() {
        return c;
    }

    public static double b() {
        return b;
    }

    public static void a(double d) {
        b = d;
        if (d > 0.0d) {
            c = 1.0d / d;
        }
    }

    public static ATAdConst.CURRENCY a(String str) {
        if (com.anythink.core.common.d.i.k.b.equalsIgnoreCase(str)) {
            return ATAdConst.CURRENCY.RMB;
        }
        if (com.anythink.core.common.d.i.k.a.equalsIgnoreCase(str)) {
            return ATAdConst.CURRENCY.USD;
        }
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.u.s$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ATAdConst.CURRENCY.values().length];
            a = iArr;
            try {
                iArr[ATAdConst.CURRENCY.RMB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ATAdConst.CURRENCY.RMB_CENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ATAdConst.CURRENCY.USD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (r8 == com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double a(double r5, com.anythink.core.api.ATAdConst.CURRENCY r7, com.anythink.core.api.ATAdConst.CURRENCY r8) {
        /*
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L4b
            if (r8 == 0) goto L4b
            if (r7 != 0) goto Lb
            goto L4b
        Lb:
            int[] r0 = com.anythink.core.common.u.s.AnonymousClass1.a     // Catch: java.lang.Throwable -> L4b
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L4b
            r7 = r0[r7]     // Catch: java.lang.Throwable -> L4b
            r0 = 1
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            if (r7 == r0) goto L3c
            r0 = 2
            if (r7 == r0) goto L2c
            com.anythink.core.api.ATAdConst$CURRENCY r7 = com.anythink.core.api.ATAdConst.CURRENCY.RMB     // Catch: java.lang.Throwable -> L4b
            if (r8 != r7) goto L24
            double r7 = com.anythink.core.common.u.s.c     // Catch: java.lang.Throwable -> L4b
            goto L42
        L24:
            com.anythink.core.api.ATAdConst$CURRENCY r7 = com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT     // Catch: java.lang.Throwable -> L4b
            if (r8 != r7) goto L4a
            double r7 = com.anythink.core.common.u.s.c     // Catch: java.lang.Throwable -> L4b
            double r5 = r5 * r7
            goto L48
        L2c:
            com.anythink.core.api.ATAdConst$CURRENCY r7 = com.anythink.core.api.ATAdConst.CURRENCY.USD     // Catch: java.lang.Throwable -> L4b
            if (r8 != r7) goto L36
            double r7 = r5 / r3
            double r5 = com.anythink.core.common.u.s.b     // Catch: java.lang.Throwable -> L4b
            double r5 = r5 * r7
            goto L4b
        L36:
            com.anythink.core.api.ATAdConst$CURRENCY r7 = com.anythink.core.api.ATAdConst.CURRENCY.RMB     // Catch: java.lang.Throwable -> L4b
            if (r8 != r7) goto L4a
            double r5 = r5 / r3
            goto L4b
        L3c:
            com.anythink.core.api.ATAdConst$CURRENCY r7 = com.anythink.core.api.ATAdConst.CURRENCY.USD     // Catch: java.lang.Throwable -> L4b
            if (r8 != r7) goto L44
            double r7 = com.anythink.core.common.u.s.b     // Catch: java.lang.Throwable -> L4b
        L42:
            double r5 = r5 * r7
            goto L4b
        L44:
            com.anythink.core.api.ATAdConst$CURRENCY r7 = com.anythink.core.api.ATAdConst.CURRENCY.RMB_CENT     // Catch: java.lang.Throwable -> L4b
            if (r8 != r7) goto L4a
        L48:
            double r5 = r5 * r3
            goto L4b
        L4a:
            double r5 = r5 * r1
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.u.s.a(double, com.anythink.core.api.ATAdConst$CURRENCY, com.anythink.core.api.ATAdConst$CURRENCY):double");
    }
}
