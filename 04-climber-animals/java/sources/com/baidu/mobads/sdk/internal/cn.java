package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes.dex */
public class cn {
    public static final String a = "9.394";
    public static final String b = "";
    public static final String e = "9.394";
    public static final int f = 5000;
    public static final boolean h = false;
    public static final Boolean c = false;
    public static final Boolean d = true;
    public static final Boolean g = false;
    public static String i = "adserv_0";

    public static String a() {
        return i;
    }

    public static double b() {
        try {
            return Double.parseDouble("9.394");
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static double c() {
        try {
            return Double.parseDouble("9.394");
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static int d() {
        try {
            return Integer.valueOf("9.394".split("\\.")[0]).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
