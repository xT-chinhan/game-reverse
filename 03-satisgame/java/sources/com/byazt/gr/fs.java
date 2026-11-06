package com.byazt.gr;

/* JADX INFO: loaded from: classes.dex */
public enum fs {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    public final int q;

    fs(int i) {
        this.q = i;
    }

    public static fs n(int i) {
        if (i == 0) {
            return UNDEFINED;
        }
        if (i == 1) {
            return EXACTLY;
        }
        if (i == 2) {
            return AT_MOST;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }
}
