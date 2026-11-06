package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum uc {
    FLEX_START(0),
    CENTER(1),
    FLEX_END(2),
    SPACE_BETWEEN(3),
    SPACE_AROUND(4),
    SPACE_EVENLY(5);

    public final int fw;

    uc(int i) {
        this.fw = i;
    }

    public int pr() {
        return this.fw;
    }

    public static uc pr(int i) {
        switch (i) {
            case 0:
                return FLEX_START;
            case 1:
                return CENTER;
            case 2:
                return FLEX_END;
            case 3:
                return SPACE_BETWEEN;
            case 4:
                return SPACE_AROUND;
            case 5:
                return SPACE_EVENLY;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    public static uc pr(String str) {
        switch (str) {
            case "flex_start":
                return FLEX_START;
            case "center":
                return CENTER;
            case "flex_end":
                return FLEX_END;
            case "space_between":
                return SPACE_BETWEEN;
            case "space_around":
                return SPACE_AROUND;
            case "space_evenly":
                return SPACE_EVENLY;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
