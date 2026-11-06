package com.byazt.fty;

/* JADX INFO: loaded from: classes.dex */
public enum pr {
    AUTO(0),
    FLEX_START(1),
    CENTER(2),
    FLEX_END(3),
    STRETCH(4),
    BASELINE(5),
    SPACE_BETWEEN(6),
    SPACE_AROUND(7),
    SPACE_EVENLY(8);

    public final int vk;

    pr(int i) {
        this.vk = i;
    }

    public int pr() {
        return this.vk;
    }

    public static pr pr(int i) {
        switch (i) {
            case 0:
                return AUTO;
            case 1:
                return FLEX_START;
            case 2:
                return CENTER;
            case 3:
                return FLEX_END;
            case 4:
                return STRETCH;
            case 5:
                return BASELINE;
            case 6:
                return SPACE_BETWEEN;
            case 7:
                return SPACE_AROUND;
            case 8:
                return SPACE_EVENLY;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    public static pr pr(String str) {
        switch (str) {
            case "auto":
                return AUTO;
            case "flex_start":
                return FLEX_START;
            case "center":
                return CENTER;
            case "flex_end":
                return FLEX_END;
            case "stretch":
                return STRETCH;
            case "baseline":
                return BASELINE;
            case "space_between":
                return SPACE_BETWEEN;
            case "space_around":
                return SPACE_AROUND;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(str)));
        }
    }
}
