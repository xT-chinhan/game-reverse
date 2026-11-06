package com.tapsdk.tapad.log;

/* JADX INFO: loaded from: classes3.dex */
public class TapADLogger {
    private static final String TAG = "TapAD";
    private static volatile Level level = Level.INFO;

    /* JADX INFO: renamed from: com.tapsdk.tapad.log.TapADLogger$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level = iArr;
            try {
                iArr[Level.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level[Level.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level[Level.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level[Level.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public enum Level {
        OFF(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);

        private final int intValue;

        Level(int i) {
            this.intValue = i;
        }
    }

    public static void d(String str) {
        writeLog(Level.DEBUG, str);
    }

    public static void e(String str) {
        writeLog(Level.ERROR, str);
    }

    public static void i(String str) {
        writeLog(Level.INFO, str);
    }

    private static boolean isEnabled(Level level2) {
        return level.intValue >= level2.intValue;
    }

    public static void setIsDebug(boolean z) {
        if (z) {
            level = Level.DEBUG;
        } else {
            level = Level.INFO;
        }
    }

    public static void setLevel(Level level2) {
        if (level2 == null) {
            return;
        }
        level = level2;
    }

    public static void v(String str) {
        writeLog(Level.VERBOSE, str);
    }

    public static void w(String str) {
        writeLog(Level.WARNING, str);
    }

    private static void writeLog(Level level2, String str) {
        if (str == null) {
            str = "";
        }
        writeLog(level2, str, null);
    }

    public static void d(String str, Throwable th) {
        writeLog(Level.DEBUG, str, th);
    }

    public static void e(String str, Throwable th) {
        writeLog(Level.ERROR, str, th);
    }

    public static void i(String str, Throwable th) {
        writeLog(Level.INFO, str, th);
    }

    public static void v(String str, Throwable th) {
        writeLog(Level.VERBOSE, str, th);
    }

    public static void w(String str, Throwable th) {
        writeLog(Level.WARNING, str, th);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000f. Please report as an issue. */
    private static void writeLog(Level level2, String str, Throwable th) {
        if (isEnabled(level2)) {
            switch (AnonymousClass1.$SwitchMap$com$tapsdk$tapad$log$TapADLogger$Level[level2.ordinal()]) {
            }
        }
    }
}
