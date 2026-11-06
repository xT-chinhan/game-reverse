package com.anythink.core.common.v;

import com.anythink.core.api.ATAdConst;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private static final String a = "t";
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
        if (com.anythink.core.common.d.j.C0079j.b.equalsIgnoreCase(str)) {
            return ATAdConst.CURRENCY.RMB;
        }
        if (com.anythink.core.common.d.j.C0079j.a.equalsIgnoreCase(str)) {
            return ATAdConst.CURRENCY.USD;
        }
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.t$1, reason: invalid class name */
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

    /* JADX WARN: Code duplicated, block: B:30:0x004d  */
    public static double a(double d, ATAdConst.CURRENCY currency, ATAdConst.CURRENCY currency2) {
        double d2;
        double d3;
        if (d <= 0.0d || currency2 == null || currency == null) {
            return d;
        }
        try {
            int i = AnonymousClass1.a[currency.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    if (currency2 == ATAdConst.CURRENCY.USD) {
                        d2 = (d / 100.0d) * b;
                    } else if (currency2 == ATAdConst.CURRENCY.RMB) {
                        d2 = d / 100.0d;
                    } else {
                        d2 = d * 1.0d;
                    }
                } else if (currency2 == ATAdConst.CURRENCY.RMB) {
                    d3 = c;
                    d2 = d3 * d;
                } else if (currency2 == ATAdConst.CURRENCY.RMB_CENT) {
                    d2 = c * d * 100.0d;
                } else {
                    d2 = d * 1.0d;
                }
            } else if (currency2 == ATAdConst.CURRENCY.USD) {
                d3 = b;
                d2 = d3 * d;
            } else if (currency2 == ATAdConst.CURRENCY.RMB_CENT) {
                d2 = d * 100.0d;
            } else {
                d2 = d * 1.0d;
            }
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
            d2 = d;
        }
        Object[] objArr2 = new Object[2];
        Double.valueOf(b);
        Double.valueOf(c);
        Object[] objArr3 = new Object[4];
        Double.valueOf(d);
        Double.valueOf(d2);
        return d2;
    }
}
