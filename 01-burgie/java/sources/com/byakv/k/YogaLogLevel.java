package com.byakv.k;

/* JADX INFO: loaded from: classes.dex */
public enum YogaLogLevel {
    ERROR(0),
    WARN(1),
    INFO(2),
    DEBUG(3),
    VERBOSE(4),
    FATAL(5);

    public final int fw;

    YogaLogLevel(int i) {
        this.fw = i;
    }

    public static YogaLogLevel fromInt(int i) {
        switch (i) {
            case 0:
                return ERROR;
            case 1:
                return WARN;
            case 2:
                return INFO;
            case 3:
                return DEBUG;
            case 4:
                return VERBOSE;
            case 5:
                return FATAL;
            default:
                throw new IllegalArgumentException("Unknown enum value: ".concat(String.valueOf(i)));
        }
    }
}
