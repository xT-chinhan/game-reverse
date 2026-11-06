package com.byazt.gr;

/* JADX INFO: loaded from: classes.dex */
public enum sz {
    NO_WRAP(0),
    WRAP(1),
    WRAP_REVERSE(2);

    public final int q;

    sz(int i) {
        this.q = i;
    }

    public int n() {
        return this.q;
    }

    public static sz n(int i) {
        if (i == 0) {
            return NO_WRAP;
        }
        if (i == 1) {
            return WRAP;
        }
        if (i == 2) {
            return WRAP_REVERSE;
        }
        throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
    }

    public static sz n(String str) {
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
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
