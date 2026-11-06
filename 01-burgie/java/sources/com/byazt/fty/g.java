package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum g {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);

    public final int x;

    g(int i) {
        this.x = i;
    }

    public int pr() {
        return this.x;
    }

    public static g pr(int i) {
        switch (i) {
            case 0:
                return NO_WRAP;
            case 1:
                return WRAP;
            case 2:
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    public static g pr(String str) {
        String lowerCase = str.toLowerCase();
        switch (lowerCase) {
            case "nowrap":
                return NO_WRAP;
            case "wrap":
                return WRAP;
            case "wrap_reverse":
                return WRAP_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(lowerCase)));
        }
    }
}
