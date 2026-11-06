package com.byazt.gr;

/* JADX INFO: loaded from: classes.dex */
public enum oa {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    public final int q;

    oa(int i) {
        this.q = i;
    }

    public int n() {
        return this.q;
    }

    public static oa n(int i) {
        if (i == 0) {
            return STATIC;
        }
        if (i == 1) {
            return RELATIVE;
        }
        if (i == 2) {
            return ABSOLUTE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static oa n(String str) {
        str.hashCode();
        switch (str) {
            case "static":
                return STATIC;
            case "relative":
                return RELATIVE;
            case "absolute":
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
