package com.kwad.sdk.dexapi.kssupport;

import android.util.Log;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class SupportLogger {
    private static final boolean DEBUG_ENABLE = BuildConfig.isDevelopEnable.booleanValue();

    public static void d(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.d(str, str2 + " " + getCodeHyperlink());
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG_ENABLE) {
            Log.d(str, str2 + " " + getCodeHyperlink(), th);
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG_ENABLE) {
            Log.w(str, str2 + " " + getCodeHyperlink());
        }
    }

    public static void handleException(Throwable th) {
        if (DEBUG_ENABLE) {
            th.printStackTrace();
            throw new RuntimeException(th);
        }
    }

    public static void printStackTrace(Throwable th) {
        if (DEBUG_ENABLE) {
            th.printStackTrace();
        }
    }

    private static String getCodeHyperlink() {
        int lineNumber;
        String fileName;
        if (!DEBUG_ENABLE) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 2) {
            fileName = stackTrace[2].getFileName();
            lineNumber = stackTrace[2].getLineNumber();
        } else {
            lineNumber = -1;
            fileName = "unknown";
        }
        return "(" + fileName + AbstractJsonLexerKt.COLON + lineNumber + ')';
    }
}
