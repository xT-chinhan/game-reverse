package com.mar.sdk.log;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Log {
    private static Log instance = new Log();
    private boolean isInited = false;
    private boolean enable = false;
    private String level = ULog.L_DEBUG;
    private boolean local = true;
    private List<ILog> logPrinters = new ArrayList();

    private Log() {
    }

    public static void d(String tag, String msg) {
        try {
            if (ULog.L_DEBUG.equalsIgnoreCase(instance.level)) {
                for (ILog printer : instance.logPrinters) {
                    printer.d(tag, msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void i(String tag, String msg) {
        try {
            if (ULog.L_DEBUG.equalsIgnoreCase(instance.level) || ULog.L_INFO.equalsIgnoreCase(instance.level)) {
                for (ILog printer : instance.logPrinters) {
                    printer.i(tag, msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void w(String tag, String msg) {
        try {
            if (!ULog.L_ERROR.equalsIgnoreCase(instance.level)) {
                for (ILog printer : instance.logPrinters) {
                    printer.w(tag, msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void w(String tag, String msg, Throwable e) {
        try {
            if (!ULog.L_ERROR.equalsIgnoreCase(instance.level)) {
                for (ILog printer : instance.logPrinters) {
                    printer.w(tag, msg, e);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void e(String tag, String msg) {
        try {
            for (ILog printer : instance.logPrinters) {
                printer.e(tag, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void e(String tag, String msg, Throwable e) {
        try {
            for (ILog printer : instance.logPrinters) {
                printer.e(tag, msg, e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void init(Context context) {
        try {
            if (!instance.isInited) {
                instance.parseConfig(context);
                instance.logPrinters.clear();
                if (!instance.enable) {
                    android.util.Log.d("ULOG", "the log is not enabled.");
                    return;
                }
                if (instance.local) {
                    instance.logPrinters.add(new ULocalLog());
                }
                instance.isInited = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void destory() {
        try {
            if (instance.logPrinters != null) {
                for (ILog printer : instance.logPrinters) {
                    printer.destory();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseConfig(Context ctx) {
        try {
            ApplicationInfo appInfo = ctx.getPackageManager().getApplicationInfo(ctx.getPackageName(), 128);
            if (appInfo != null && appInfo.metaData != null) {
                if (appInfo.metaData.containsKey("ulog.enable")) {
                    this.enable = appInfo.metaData.getBoolean("ulog.enable");
                }
                if (appInfo.metaData.containsKey("ulog.level")) {
                    this.level = appInfo.metaData.getString("ulog.level");
                }
                if (appInfo.metaData.containsKey("ulog.local")) {
                    this.local = appInfo.metaData.getBoolean("ulog.local");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
