package com.tapsdk.tapad.internal.telemetry;

import com.tapsdk.tapad.internal.runtime.NativeLibraryLoader;

/* JADX INFO: loaded from: classes3.dex */
public final class RustTelemetryBridge {
    private static final String TAG = "RustTelemetryBridge";
    public static final int TRANSPORT_MALFORMED_REQUEST = 2;
    public static final int TRANSPORT_NETWORK_ERROR = 1;
    public static final int TRANSPORT_RESPONSE = 0;
    public static final int TRANSPORT_TIMEOUT = 3;
    private static volatile boolean available;
    private static volatile boolean loadAttempted;

    private RustTelemetryBridge() {
    }

    public static String beginFlush(String str) {
        if (!ensureLoaded()) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        try {
            String strNativeBeginFlush = nativeBeginFlush(str);
            return strNativeBeginFlush != null ? strNativeBeginFlush : "";
        } catch (Throwable th) {
            available = false;
            return "";
        }
    }

    public static String beginFlushIfNeeded(String str) {
        if (!ensureLoaded()) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        try {
            String strNativeBeginFlushIfNeeded = nativeBeginFlushIfNeeded(str);
            return strNativeBeginFlushIfNeeded != null ? strNativeBeginFlushIfNeeded : "";
        } catch (Throwable th) {
            available = false;
            return "";
        }
    }

    public static boolean configure(String str) {
        if (!ensureLoaded()) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        try {
            return nativeConfigure(str);
        } catch (Throwable th) {
            available = false;
            return false;
        }
    }

    public static String deliveryPolicy(String str) {
        if (!ensureLoaded()) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        try {
            String strNativeDeliveryPolicy = nativeDeliveryPolicy(str);
            return strNativeDeliveryPolicy != null ? strNativeDeliveryPolicy : "";
        } catch (Throwable th) {
            available = false;
            return "";
        }
    }

    private static boolean ensureLoaded() {
        if (available) {
            return true;
        }
        if (loadAttempted) {
            return false;
        }
        synchronized (RustTelemetryBridge.class) {
            if (available) {
                return true;
            }
            if (loadAttempted) {
                return false;
            }
            loadAttempted = true;
            try {
                NativeLibraryLoader.load();
                available = true;
            } catch (Throwable th) {
                available = false;
            }
            return available;
        }
    }

    public static String finishDelivery(String str, int i, int i2, String str2) {
        if (!ensureLoaded()) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            String strNativeFinishDelivery = nativeFinishDelivery(str, i, i2, str2);
            return strNativeFinishDelivery != null ? strNativeFinishDelivery : "";
        } catch (Throwable th) {
            available = false;
            return "";
        }
    }

    public static boolean isAvailable() {
        return ensureLoaded();
    }

    private static native String nativeBeginFlush(String str);

    private static native String nativeBeginFlushIfNeeded(String str);

    private static native boolean nativeConfigure(String str);

    private static native String nativeDeliveryPolicy(String str);

    private static native String nativeFinishDelivery(String str, int i, int i2, String str2);

    private static native String nativeProjectFields(String str);

    private static native boolean nativeRestore(String str, String str2);

    private static native String nativeSnapshot(String str);

    private static native boolean nativeTrack(String str, String str2, String str3, int i);

    private static native boolean nativeTrackFact(String str, int i, String str2, int i2);

    private static native boolean nativeTrackRaw(String str, String str2, String str3, int i);

    public static String projectFields(String str) {
        if (!ensureLoaded()) {
            return "";
        }
        if (str == null) {
            str = "{}";
        }
        try {
            String strNativeProjectFields = nativeProjectFields(str);
            return strNativeProjectFields != null ? strNativeProjectFields : "";
        } catch (Throwable th) {
            available = false;
            return "";
        }
    }

    public static boolean restore(String str, String str2) {
        if (!ensureLoaded()) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            return nativeRestore(str, str2);
        } catch (Throwable th) {
            available = false;
            return false;
        }
    }

    public static String snapshot(String str) {
        if (!ensureLoaded()) {
            return "[]";
        }
        if (str == null) {
            str = "";
        }
        try {
            String strNativeSnapshot = nativeSnapshot(str);
            return strNativeSnapshot != null ? strNativeSnapshot : "[]";
        } catch (Throwable th) {
            available = false;
            return "[]";
        }
    }

    public static boolean track(String str, String str2, String str3, int i) {
        if (!ensureLoaded()) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "{}";
        }
        try {
            return nativeTrack(str, str2, str3, Math.max(i, 1));
        } catch (Throwable th) {
            available = false;
            return false;
        }
    }

    public static boolean trackFact(String str, int i, String str2, int i2) {
        if (ensureLoaded() && i > 0) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "{}";
            }
            try {
                return nativeTrackFact(str, i, str2, Math.max(i2, 1));
            } catch (Throwable th) {
                available = false;
            }
        }
        return false;
    }

    public static boolean trackRaw(String str, String str2, String str3, int i) {
        if (!ensureLoaded()) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "{}";
        }
        try {
            return nativeTrackRaw(str, str2, str3, Math.max(i, 1));
        } catch (Throwable th) {
            available = false;
            return false;
        }
    }
}
