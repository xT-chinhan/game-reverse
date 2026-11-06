package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum zo {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);

    public final int x;

    zo(int i) {
        this.x = i;
    }

    public static zo pr(int i) {
        switch (i) {
            case 0:
                return UNDEFINED;
            case 1:
                return EXACTLY;
            case 2:
                return AT_MOST;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }
}
