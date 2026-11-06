package com.umeng.commonsdk.deeplink;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: AttributionResultManager.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static volatile a a;
    private volatile OnAttributionListener b;
    private volatile Context c;
    private final Handler d = new Handler(Looper.getMainLooper());

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(Context context, OnAttributionListener onAttributionListener) {
        Context applicationContext;
        this.b = onAttributionListener;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] setListener: ".concat(onAttributionListener != null ? "registered" : AbstractJsonLexerKt.NULL));
        if (onAttributionListener == null) {
            return;
        }
        if (context != null) {
            applicationContext = context.getApplicationContext();
        } else {
            applicationContext = this.c != null ? this.c : null;
        }
        if (applicationContext == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] setListener: context is null, will handle in triggerQuery");
            return;
        }
        String strE = e(applicationContext);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] setListener: cache hit, dispatch immediately");
        a(strE);
    }

    public void a(Context context) {
        if (this.b == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] triggerQuery: no listener, skip");
            return;
        }
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (!UMUtils.isMainProgress(applicationContext)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] triggerQuery: not main process, skip");
            return;
        }
        this.c = applicationContext;
        String strE = e(applicationContext);
        if (!TextUtils.isEmpty(strE)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] triggerQuery: cache hit, dispatch cached result");
            a(strE);
        } else {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] triggerQuery: dispatch query message");
            UMWorkDispatch.sendEvent(applicationContext, com.umeng.commonsdk.internal.a.K, com.umeng.commonsdk.internal.b.a(applicationContext).a(), null);
        }
    }

    public void b(Context context) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            long jD = d(applicationContext);
            String appkey = UMUtils.getAppkey(applicationContext);
            String uMId = UMUtils.getUMId(applicationContext);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] executeQuery: appkey=" + appkey + ", umid=" + uMId + ", firstLaunchTime=" + jD);
            if (TextUtils.isEmpty(uMId)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] umid is empty, retry in 1s");
                c(applicationContext);
            } else {
                b.a(appkey, uMId, jD, new b.a() { // from class: com.umeng.commonsdk.deeplink.a.1
                    @Override // com.umeng.commonsdk.deeplink.b.a
                    public void a(int i, JSONObject jSONObject) {
                        a.this.a(applicationContext, i, jSONObject);
                    }

                    @Override // com.umeng.commonsdk.deeplink.b.a
                    public void a(Throwable th) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [attribution] network error: " + (th != null ? th.getMessage() : "unknown"));
                        a.this.c(applicationContext);
                    }
                });
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(applicationContext, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, JSONObject jSONObject) {
        if (i == 1) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] success: " + (jSONObject != null ? jSONObject.toString() : AbstractJsonLexerKt.NULL));
            a(context, jSONObject, 1);
            a(jSONObject);
        } else if (i == -1) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] failed: status=-1");
            a(context, (JSONObject) null, -1);
            a(-1);
        } else {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] pending: status=0, retry in 1s");
            c(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] scheduleRetry: delay 1000ms");
        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.K, com.umeng.commonsdk.internal.b.a(context).a(), null, 1000L);
    }

    private long d(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
        if (sharedPreferences == null) {
            return System.currentTimeMillis();
        }
        long j = sharedPreferences.getLong("um_attribution_first_launch_time", 0L);
        if (j > 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        sharedPreferences.edit().putLong("um_attribution_first_launch_time", jCurrentTimeMillis).commit();
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] firstLaunchTime created: " + jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    private void a(Context context, JSONObject jSONObject, int i) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", i);
            if (jSONObject != null) {
                jSONObject2.put("data", jSONObject);
            }
            sharedPreferences.edit().putString("um_attribution_result_cache", jSONObject2.toString()).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [attribution] cache saved: status=" + i);
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return null;
            }
            return sharedPreferences.getString("um_attribution_result_cache", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("status", 0);
            if (iOptInt == 1) {
                a(jSONObject.optJSONObject("data"));
            } else if (iOptInt == -1) {
                a(-1);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(final JSONObject jSONObject) {
        final OnAttributionListener onAttributionListener = this.b;
        if (onAttributionListener == null) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.umeng.commonsdk.deeplink.a.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    onAttributionListener.onAttributionSuccess(jSONObject);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void a(final int i) {
        final OnAttributionListener onAttributionListener = this.b;
        if (onAttributionListener == null) {
            return;
        }
        this.d.post(new Runnable() { // from class: com.umeng.commonsdk.deeplink.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    onAttributionListener.onAttributionFail(i);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
