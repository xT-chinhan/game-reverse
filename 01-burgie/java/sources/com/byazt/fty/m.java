package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum m {
    STATIC(0),
    RELATIVE(1),
    ABSOLUTE(2);

    public final int x;

    m(int i) {
        this.x = i;
    }

    public int pr() {
        return this.x;
    }

    public static m pr(int i) {
        switch (i) {
            case 0:
                return STATIC;
            case 1:
                return RELATIVE;
            case 2:
                return ABSOLUTE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    public static m pr(String str) {
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
