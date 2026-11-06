package com.umeng.pagesdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;

/* JADX INFO: loaded from: classes3.dex */
public class PageManger {
    public static final String TAG = "PageManger";
    private static Context a;
    private static boolean b;
    private static EfsReporter c;
    private static PageConfigManger d;
    public static boolean isDebug = true;
    private static boolean e = true;

    public static Context getApplicationContext() {
        return a;
    }

    public static PageConfigManger getPageConfigManger() {
        return d;
    }

    public static EfsReporter getReporter() {
        return c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e(TAG, "init page manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            if (isDebug) {
                Log.e(TAG, "invalid init ！");
            }
        } else {
            a = context.getApplicationContext();
            c = efsReporter;
            d = new PageConfigManger(context, efsReporter);
            b = true;
        }
    }

    public static boolean isControlMainThread() {
        return e;
    }

    public static boolean isInit() {
        return b;
    }

    public static void onTracePageBegin(Activity activity, String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageBegin(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (activity.getClass() != null && activity.getClass().getName() != null && !TextUtils.isEmpty(str)) {
                    if (!z && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageBegin. parameter illegality!");
                            return;
                        }
                        return;
                    } else {
                        if (str.length() <= 10) {
                            if (e && !c.a(activity.getApplicationContext()) && isDebug) {
                                Log.e(TAG, "tracePageBegin. Non main process !");
                            }
                            b.a(activity.getClass().getName(), str, z);
                            return;
                        }
                        if (isDebug) {
                            Log.e(TAG, "tracePageBegin. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e(TAG, "tracePageBegin. parameter null!");
        }
    }

    public static void onTracePageEnd(Activity activity, String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageEnd(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (activity.getClass() != null && activity.getClass().getName() != null && !TextUtils.isEmpty(str)) {
                    if (!z && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e(TAG, "tracePageEnd. parameter illegality!");
                            return;
                        }
                        return;
                    } else {
                        if (str.length() <= 10) {
                            if (e && !c.a(activity.getApplicationContext()) && isDebug) {
                                Log.e(TAG, "tracePageBegin. Non main process !");
                            }
                            b.b(activity.getClass().getName(), str, z);
                            return;
                        }
                        if (isDebug) {
                            Log.e(TAG, "tracePageEnd. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e(TAG, "tracePageEnd. parameter null!");
        }
    }

    public static void setControlMainThread(boolean z) {
        e = z;
    }
}
