package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SessionIdManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class y {
    private static volatile y c;
    private w a = new x();
    private String b;
    private List<a> d;
    private String e;

    /* JADX INFO: compiled from: SessionIdManager.java */
    public interface a {
        void a(String str, long j, long j2, long j3);

        void a(String str, String str2, long j, long j2, long j3);
    }

    private y() {
    }

    public static y a() {
        if (c == null) {
            synchronized (y.class) {
                if (c == null) {
                    c = new y();
                }
            }
        }
        return c;
    }

    public void a(long j) {
        this.a.a(j);
    }

    public long b() {
        return this.a.a();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0021 */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0022, code lost:
    
        r6 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(android.content.Context r6) throws java.lang.Throwable {
        /*
            r5 = this;
            android.content.Context r6 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext(r6)
            if (r6 != 0) goto L9
            java.lang.String r6 = ""
            return r6
        L9:
            java.lang.String r0 = ""
            java.lang.Class<com.umeng.analytics.pro.y> r1 = com.umeng.analytics.pro.y.class
            monitor-enter(r1)     // Catch: java.lang.Exception -> L24
            android.content.SharedPreferences r6 = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(r6)     // Catch: java.lang.Throwable -> L21
            java.lang.String r2 = "pre_session_id"
            java.lang.String r3 = ""
            java.lang.String r6 = r6.getString(r2, r3)     // Catch: java.lang.Throwable -> L21
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1c
            goto L26
        L1c:
            r0 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L22
        L21:
            r6 = move-exception
        L22:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L21
            throw r6     // Catch: java.lang.Exception -> L24
        L24:
            r6 = move-exception
            r6 = r0
        L26:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.y.a(android.content.Context):java.lang.String");
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.b = d(appContext);
        if (e(appContext)) {
            try {
                this.b = f(appContext);
            } catch (Exception e) {
            }
        }
        return this.b;
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.b = f(appContext);
        } catch (Exception e) {
        }
        return this.b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception e) {
            }
        }
        return this.b;
    }

    public String a(Context context, long j) {
        if (TextUtils.isEmpty(this.e)) {
            String str = "SUB" + j;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.e = sb.toString();
        }
        return this.e;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = d(context);
        }
        return TextUtils.isEmpty(this.b) || j(context) || g(context);
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(u.d, d(context));
            editorEdit.commit();
        } catch (Exception e) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.b;
        long jA = u.a(context);
        long j = jA * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + jA);
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            if (UMWorkDispatch.eventHasExist()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
                UMWorkDispatch.removeEvent();
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
            }
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        }
        a(jI, jH, j, str, false);
        this.b = this.a.a(context);
        a(jI, jH, j, str, true);
        this.a.a(context, this.b);
        return this.b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.b) && i.a(context).a(this.b) > 0;
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception e) {
            j = 0;
        }
        if (j <= 0) {
            return System.currentTimeMillis();
        }
        return j;
    }

    private long h(Context context) {
        return a(context, u.f);
    }

    private long i(Context context) {
        return a(context, u.a);
    }

    private void a(long j, long j2, long j3, String str, boolean z) {
        if (this.d != null) {
            for (a aVar : this.d) {
                if (z) {
                    try {
                        aVar.a(str, this.b, j, j2, j3);
                    } catch (Exception e) {
                    }
                } else {
                    aVar.a(this.b, j, j2, j3);
                }
            }
        }
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(u.e, 0L);
            long j2 = sharedPreferences.getLong(u.f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j > 0 && j2 == 0) {
                long jA = u.a(appContext);
                if (jA > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (jA * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.a.a(j, j2);
        } catch (Exception e) {
            return false;
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (!this.d.contains(aVar)) {
            this.d.add(aVar);
        }
    }

    public void b(a aVar) {
        if (aVar == null || this.d == null || this.d.size() == 0) {
            return;
        }
        this.d.remove(aVar);
    }
}
