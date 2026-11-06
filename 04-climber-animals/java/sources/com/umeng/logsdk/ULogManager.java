package com.umeng.logsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.commonsdk.framework.UMModuleRegister;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ULogManager {
    public static final String TAG = "CodeLogManager";
    private static Context a = null;
    private static ULogConfigManager b = null;
    private static EfsReporter c = null;
    private static boolean d = false;
    private static String e = "";
    private static String f = "";
    private static long h = 0;
    private static long i = 0;
    public static boolean isDebug = true;
    private static JSONArray g = new JSONArray();
    private static long j = 18432;
    private static Handler k = new Handler(Looper.getMainLooper()) { // from class: com.umeng.logsdk.ULogManager.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 0) {
                ULogManager.a(message);
            } else {
                if (i2 != 1) {
                    return;
                }
                ULogManager.e();
            }
        }
    };
    private static int l = 0;

    static /* synthetic */ void a(Message message) {
        String str;
        JSONObject jSONObject;
        if (message == null || message.getData() == null) {
            if (isDebug) {
                Log.e(TAG, "writeMemory msg or msg data is null!");
                return;
            }
            return;
        }
        Bundle data = message.getData();
        if (data == null) {
            if (isDebug) {
                Log.e(TAG, "writeMemory bundle is null!");
                return;
            }
            return;
        }
        String string = data.getString(TTDownloadField.TT_TAG);
        String string2 = data.getString("message");
        boolean z = false;
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            if (isDebug) {
                str = "ULog parameter null!";
                Log.e(TAG, str);
            }
        } else if (string.length() > a.a || string2.length() > a.b) {
            if (isDebug) {
                str = "ULog tag or message over length!";
                Log.e(TAG, str);
            }
        } else if (isInit()) {
            if (!TextUtils.isEmpty(getDeviceID()) || !TextUtils.isEmpty(getUserID())) {
                z = true;
            } else if (isDebug) {
                str = "ULog not set device id or user id!";
                Log.e(TAG, str);
            }
        } else if (isDebug) {
            str = "ULog not init!";
            Log.e(TAG, str);
        }
        if (z) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(TTDownloadField.TT_TAG, string);
                    jSONObject.put("msg", string2);
                    jSONObject.put("level", message.arg1);
                    jSONObject.put("time", System.currentTimeMillis());
                    jSONObject.put(UMModuleRegister.PROCESS, ProcessUtil.getCurrentProcessName());
                    jSONObject.put("thread", Thread.currentThread().getName());
                } catch (Throwable th) {
                    th = th;
                    jSONObject2 = jSONObject;
                    th.printStackTrace();
                    jSONObject = jSONObject2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (jSONObject != null) {
                if (g.length() == 0) {
                    h = System.currentTimeMillis();
                }
                g.put(jSONObject);
                if (isDebug) {
                    Log.i(TAG, "add mem is " + jSONObject.toString());
                }
            }
            if (g.toString().getBytes().length >= j) {
                if (isDebug) {
                    Log.i(TAG, "over max size upload. size is " + g.toString().getBytes().length);
                }
                e();
            }
        }
    }

    static /* synthetic */ int b() {
        int i2 = l;
        l = i2 + 1;
        return i2;
    }

    static /* synthetic */ int c() {
        int i2 = l;
        l = i2 - 1;
        return i2;
    }

    public static void d(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 1;
        Bundle bundle = new Bundle();
        bundle.putString(TTDownloadField.TT_TAG, str);
        bundle.putString("message", str2);
        message.setData(bundle);
        k.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e() {
        JSONObject jSONObject;
        Throwable th;
        if (g.length() > 0) {
            i = System.currentTimeMillis();
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("taskid", "");
                    jSONObject.put("status", 0);
                    jSONObject.put("time_start", h);
                    jSONObject.put("time_end", i);
                    jSONObject.put("uid", c.b(getUserID().getBytes()));
                    jSONObject.put("did", getDeviceID());
                    jSONObject.put("body", g);
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                }
            } catch (Throwable th3) {
                jSONObject = null;
                th = th3;
            }
            if (jSONObject != null) {
                EfsJSONLog efsJSONLog = new EfsJSONLog(Constants.LOG_TYPE_CODELOGPERF);
                efsJSONLog.setLogBeginTime(h);
                efsJSONLog.setLogEndTime(i);
                efsJSONLog.put("codelog", jSONObject);
                EfsReporter reporter = getReporter();
                if (reporter != null) {
                    if (isDebug) {
                        Log.i(TAG, "upload and send.");
                    }
                    reporter.send(efsJSONLog);
                    g = new JSONArray();
                }
            }
        }
    }

    public static void e(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 4;
        Bundle bundle = new Bundle();
        bundle.putString(TTDownloadField.TT_TAG, str);
        bundle.putString("message", str2);
        message.setData(bundle);
        k.sendMessage(message);
    }

    public static String getDeviceID() {
        return e;
    }

    public static EfsReporter getReporter() {
        return c;
    }

    public static ULogConfigManager getULogConfigManager() {
        return b;
    }

    public static String getUserID() {
        return f;
    }

    public static void i(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 2;
        Bundle bundle = new Bundle();
        bundle.putString(TTDownloadField.TT_TAG, str);
        bundle.putString("message", str2);
        message.setData(bundle);
        k.sendMessage(message);
    }

    public static void init(Context context, EfsReporter efsReporter) {
        try {
            if (isDebug) {
                Log.i(TAG, "begin init code log.");
            }
            if (context != null && efsReporter != null) {
                if (isInit()) {
                    if (isDebug) {
                        Log.e(TAG, "invalid init ！");
                        return;
                    }
                    return;
                }
                a = context.getApplicationContext();
                c = efsReporter;
                b = new ULogConfigManager(a, c);
                registerActivityCallback(context);
                d = true;
                if (isDebug) {
                    Log.i(TAG, "finish init code log.");
                    return;
                }
                return;
            }
            if (isDebug) {
                Log.e(TAG, "init code log manager error! parameter is null!");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean isInit() {
        return d;
    }

    public static void registerActivityCallback(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.logsdk.ULogManager.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStarted(Activity activity) {
                    ULogManager.b();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityStopped(Activity activity) {
                    ULogManager.c();
                    if (ULogManager.l == 0) {
                        ULogManager.e();
                    }
                }
            });
        }
    }

    public static void setDeviceID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            e = str;
        } else if (isDebug) {
            Log.e(TAG, "device id over length!");
        }
    }

    public static void setUserID(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 128) {
            f = c.a(str.getBytes());
        } else if (isDebug) {
            Log.e(TAG, "user id over length!");
        }
    }

    public static void setsLogMaxCache(long j2) {
        if (j2 <= 0 || j2 >= 18432) {
            Log.e(TAG, "日志回捞size需要大于0且小于20*1024");
        } else {
            j = j2;
        }
    }

    public static void v(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 0;
        Bundle bundle = new Bundle();
        bundle.putString(TTDownloadField.TT_TAG, str);
        bundle.putString("message", str2);
        message.setData(bundle);
        k.sendMessage(message);
    }

    public static void w(String str, String str2) {
        Message message = new Message();
        message.what = 0;
        message.arg1 = 3;
        Bundle bundle = new Bundle();
        bundle.putString(TTDownloadField.TT_TAG, str);
        bundle.putString("message", str2);
        message.setData(bundle);
        k.sendMessage(message);
    }
}
