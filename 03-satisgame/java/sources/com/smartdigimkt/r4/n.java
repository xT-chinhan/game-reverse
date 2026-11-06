package com.smartdigimkt.r4;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static double a;
    public static double b;

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        if (r8 == com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.RMB_CENT) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double a(double r5, com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY r7, com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY r8) {
        /*
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L51
            if (r8 == 0) goto L51
            if (r7 != 0) goto Lb
            goto L51
        Lb:
            int[] r0 = com.smartdigimkt.r4.m.a     // Catch: java.lang.Throwable -> L4d
            int r7 = r7.ordinal()     // Catch: java.lang.Throwable -> L4d
            r7 = r0[r7]     // Catch: java.lang.Throwable -> L4d
            r0 = 1
            r1 = 4636737291354636288(0x4059000000000000, double:100.0)
            if (r7 == r0) goto L3c
            r0 = 2
            if (r7 == r0) goto L2a
            com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY r7 = com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.RMB     // Catch: java.lang.Throwable -> L4d
            if (r8 != r7) goto L22
            double r7 = com.smartdigimkt.r4.n.b     // Catch: java.lang.Throwable -> L4d
            goto L4b
        L22:
            com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY r7 = com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.RMB_CENT     // Catch: java.lang.Throwable -> L4d
            if (r8 != r7) goto L49
            double r7 = com.smartdigimkt.r4.n.b     // Catch: java.lang.Throwable -> L4d
            double r5 = r5 * r7
            goto L47
        L2a:
            com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY r7 = com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.USD     // Catch: java.lang.Throwable -> L4d
            if (r8 != r7) goto L36
            double r7 = r5 / r1
            double r5 = com.smartdigimkt.r4.n.a     // Catch: java.lang.Throwable -> L4d
            r3 = r5
            r5 = r7
            r7 = r3
            goto L4b
        L36:
            com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY r7 = com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.RMB     // Catch: java.lang.Throwable -> L4d
            if (r8 != r7) goto L49
            double r5 = r5 / r1
            goto L51
        L3c:
            com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY r7 = com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.USD     // Catch: java.lang.Throwable -> L4d
            if (r8 != r7) goto L43
            double r7 = com.smartdigimkt.r4.n.a     // Catch: java.lang.Throwable -> L4d
            goto L4b
        L43:
            com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY r7 = com.smartdigimkt.sdk.api.SDMAdConst.CURRENCY.RMB_CENT     // Catch: java.lang.Throwable -> L4d
            if (r8 != r7) goto L49
        L47:
            double r5 = r5 * r1
            goto L51
        L49:
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L4b:
            double r5 = r5 * r7
            goto L51
        L4d:
            r7 = move-exception
            r7.getMessage()
        L51:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.r4.n.a(double, com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY, com.smartdigimkt.sdk.api.SDMAdConst$CURRENCY):double");
    }
}
