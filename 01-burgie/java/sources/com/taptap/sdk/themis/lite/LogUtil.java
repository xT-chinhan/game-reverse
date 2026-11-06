package com.taptap.sdk.themis.lite;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class LogUtil {
    public static final String TAG = "ThemisLite";
    private static boolean isDebug = false;

    public static void init(Context context) {
    }

    public static void info(String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }

    public static void err(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void debug(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void warn(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }

    public static void verbose(String msg) {
        if (isDebug) {
            Log.v(TAG, msg);
        }
    }

    public static void err(String msg, Throwable throwable) {
        if (isDebug) {
            Log.e(TAG, msg, throwable);
        }
    }

    public static void info(String format, Object... args) {
        if (isDebug) {
            Log.i(TAG, String.format(format, args));
        }
    }

    public static void debug(String format, Object... args) {
        if (isDebug) {
            Log.d(TAG, String.format(format, args));
        }
    }

    public static void warn(String format, Object... args) {
        if (isDebug) {
            Log.w(TAG, String.format(format, args));
        }
    }

    public static void verbose(String format, Object... args) {
        if (isDebug) {
            Log.v(TAG, String.format(format, args));
        }
    }

    public static void err(String format, Object... args) {
        if (isDebug) {
            Log.e(TAG, String.format(format, args));
        }
    }
}
