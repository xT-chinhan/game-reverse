package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum c {
    COLUMN(0),
    COLUMN_REVERSE(1),
    ROW(2),
    ROW_REVERSE(3);

    public final int c;

    c(int i) {
        this.c = i;
    }

    public int pr() {
        return this.c;
    }

    public static c pr(int i) {
        switch (i) {
            case 0:
                return COLUMN;
            case 1:
                return COLUMN_REVERSE;
            case 2:
                return ROW;
            case 3:
                return ROW_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0030  */
    public static c pr(String str) {
        switch (str) {
            case "column":
                return COLUMN;
            case "column_reverse":
                return COLUMN_REVERSE;
            case "row":
                return ROW;
            case "row_reverse":
                return ROW_REVERSE;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
