package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import android.util.Log;
import com.taptap.sdk.update.download.DownloadTask;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class MLog {
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    public static boolean DEBUG = false;
    private static String TAG = AnalyticsConstants.LOG_TAG;
    private static int LOG_MAXLENGTH = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;

    private MLog() {
    }

    public static void i(Locale locale, String str, Object... objArr) throws Throwable {
        try {
            i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void d(Locale locale, String str, Object... objArr) throws Throwable {
        try {
            d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(Locale locale, String str, Object... objArr) throws Throwable {
        try {
            e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void v(Locale locale, String str, Object... objArr) throws Throwable {
        try {
            v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void w(Locale locale, String str, Object... objArr) throws Throwable {
        try {
            w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void i(String str, Object... objArr) throws Throwable {
        try {
            String str2 = "";
            if (str.contains("%")) {
                i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                i(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void d(String str, Object... objArr) throws Throwable {
        try {
            String str2 = "";
            if (str.contains("%")) {
                d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                d(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void e(String str, Object... objArr) throws Throwable {
        try {
            String str2 = "";
            if (str.contains("%")) {
                e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                e(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void v(String str, Object... objArr) throws Throwable {
        try {
            String str2 = "";
            if (str.contains("%")) {
                v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                v(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void w(String str, Object... objArr) throws Throwable {
        try {
            String str2 = "";
            if (str.contains("%")) {
                w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                if (objArr != null) {
                    str2 = (String) objArr[0];
                }
                w(str, str2, (Throwable) null);
            }
        } catch (Throwable th) {
            e(th);
        }
    }

    public static void i(Throwable th) throws Throwable {
        i(TAG, (String) null, th);
    }

    public static void v(Throwable th) throws Throwable {
        v(TAG, (String) null, th);
    }

    public static void w(Throwable th) throws Throwable {
        w(TAG, (String) null, th);
    }

    public static void d(Throwable th) throws Throwable {
        d(TAG, (String) null, th);
    }

    public static void e(Throwable th) throws Throwable {
        e(TAG, (String) null, th);
    }

    public static void i(String str, Throwable th) throws Throwable {
        i(TAG, str, th);
    }

    public static void v(String str, Throwable th) throws Throwable {
        v(TAG, str, th);
    }

    public static void w(String str, Throwable th) throws Throwable {
        w(TAG, str, th);
    }

    public static void d(String str, Throwable th) throws Throwable {
        d(TAG, str, th);
    }

    public static void e(String str, Throwable th) throws Throwable {
        e(TAG, str, th);
    }

    public static void v(String str) throws Throwable {
        v(TAG, str, (Throwable) null);
    }

    public static void d(String str) throws Throwable {
        d(TAG, str, (Throwable) null);
    }

    public static void i(String str) throws Throwable {
        i(TAG, str, (Throwable) null);
    }

    public static void w(String str) throws Throwable {
        w(TAG, str, (Throwable) null);
    }

    public static void e(String str) throws Throwable {
        e(TAG, str, (Throwable) null);
    }

    public static void v(String str, String str2, Throwable th) throws Throwable {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    public static void d(String str, String str2, Throwable th) throws Throwable {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) throws Throwable {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) throws Throwable {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) throws Throwable {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    private static void print(int i, String str, String str2, Throwable th) throws Throwable {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = LOG_MAXLENGTH;
            int i3 = 0;
            int i4 = 0;
            while (i3 < 100) {
                if (length > i2) {
                    switch (i) {
                        case 1:
                            Log.v(str, str2.substring(i4, i2));
                            break;
                        case 2:
                            Log.d(str, str2.substring(i4, i2));
                            break;
                        case 3:
                            Log.i(str, str2.substring(i4, i2));
                            break;
                        case 4:
                            Log.w(str, str2.substring(i4, i2));
                            break;
                        case 5:
                            Log.e(str, str2.substring(i4, i2));
                            break;
                    }
                    i3++;
                    i4 = i2;
                    i2 = LOG_MAXLENGTH + i2;
                } else {
                    switch (i) {
                        case 1:
                            Log.v(str, str2.substring(i4, length));
                            break;
                        case 2:
                            Log.d(str, str2.substring(i4, length));
                            break;
                        case 3:
                            Log.i(str, str2.substring(i4, length));
                            break;
                        case 4:
                            Log.w(str, str2.substring(i4, length));
                            break;
                        case 5:
                            Log.e(str, str2.substring(i4, length));
                            break;
                    }
                }
            }
        }
        if (th != null) {
            String stackTrace = getStackTrace(th);
            if (!TextUtils.isEmpty(stackTrace)) {
                switch (i) {
                    case 1:
                        Log.v(str, stackTrace);
                        break;
                    case 2:
                        Log.d(str, stackTrace);
                        break;
                    case 3:
                        Log.i(str, stackTrace);
                        break;
                    case 4:
                        Log.w(str, stackTrace);
                        break;
                    case 5:
                        Log.e(str, stackTrace);
                        break;
                }
            }
        }
    }

    public static String getStackTrace(Throwable th) throws Throwable {
        StringWriter stringWriter;
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            try {
                PrintWriter printWriter2 = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter2);
                    printWriter2.flush();
                    stringWriter.flush();
                    String string = stringWriter.toString();
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th2) {
                        }
                    }
                    if (printWriter2 == null) {
                        return string;
                    }
                    printWriter2.close();
                    return string;
                } catch (Throwable th3) {
                    th = th3;
                    printWriter = printWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th4) {
                        }
                    }
                    if (printWriter == null) {
                        throw th;
                    }
                    printWriter.close();
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            stringWriter = null;
        }
    }
}
