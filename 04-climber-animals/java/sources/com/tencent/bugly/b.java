package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static boolean a = true;
    public static List<a> b = new ArrayList();
    public static boolean c;
    private static p d;
    private static boolean e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.o;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        a(context, null);
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (e) {
            x.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(x.a, "[init] context of init() is null, check it.");
            return;
        }
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a(aVarA)) {
            a = false;
            return;
        }
        String strF = aVarA.f();
        if (strF == null) {
            Log.e(x.a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
        } else {
            a(context, strF, aVarA.u, buglyStrategy);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0201 A[Catch: all -> 0x020d, TRY_LEAVE, TryCatch #1 {all -> 0x020d, blocks: (B:69:0x01f1, B:71:0x0201), top: B:89:0x01f1, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x021c A[Catch: all -> 0x022f, TryCatch #2 {, blocks: (B:4:0x0009, B:6:0x000e, B:10:0x0019, B:14:0x0024, B:18:0x002e, B:20:0x0032, B:21:0x006e, B:23:0x00bb, B:26:0x00bf, B:28:0x00cd, B:30:0x00db, B:32:0x00e1, B:33:0x00f7, B:34:0x0106, B:36:0x010c, B:38:0x0116, B:40:0x011c, B:41:0x0132, B:47:0x0162, B:53:0x0176, B:55:0x0180, B:57:0x0186, B:58:0x019c, B:59:0x01ab, B:61:0x01b1, B:63:0x01b7, B:64:0x01cd, B:65:0x01d9, B:42:0x0146, B:44:0x0151, B:46:0x015b, B:50:0x016f, B:52:0x0173, B:66:0x01e5, B:67:0x01e9, B:77:0x0217, B:79:0x021c, B:81:0x0223, B:74:0x020e, B:76:0x0214, B:69:0x01f1, B:71:0x0201), top: B:91:0x0009, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0221  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0217 A[SYNTHETIC] */
    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        int i;
        long appReportDelay;
        byte[] bArr;
        if (e) {
            x.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            Log.w(x.a, "[init] context is null, check it.");
            return;
        }
        if (str == null) {
            Log.e(x.a, "init arg 'crashReportAppID' should not be null!");
            return;
        }
        e = true;
        if (z) {
            c = true;
            x.b = true;
            x.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            x.e("--------------------------------------------------------------------------------------------", new Object[0]);
            x.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
            x.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
            x.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
            x.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
            x.e("--------------------------------------------------------------------------------------------", new Object[0]);
            x.b("[init] Open debug mode of Bugly.", new Object[0]);
        }
        x.a("[init] Bugly version: v%s", "2.6.5");
        x.a(" crash report start initializing...", new Object[0]);
        x.b("[init] Bugly start initializing...", new Object[0]);
        x.a("[init] Bugly complete version: v%s", "2.6.5");
        Context contextA = z.a(context);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        aVarA.t();
        y.a(contextA);
        d = p.a(contextA, b);
        u.a(contextA);
        com.tencent.bugly.crashreport.common.strategy.a aVarA2 = com.tencent.bugly.crashreport.common.strategy.a.a(contextA, b);
        n nVarA = n.a(contextA);
        if (a(aVarA)) {
            a = false;
            return;
        }
        aVarA.a(str);
        x.a("[param] Set APP ID:%s", str);
        if (buglyStrategy != null) {
            String appVersion = buglyStrategy.getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                if (appVersion.length() > 100) {
                    String strSubstring = appVersion.substring(0, 100);
                    x.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                    appVersion = strSubstring;
                }
                aVarA.j = appVersion;
                x.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
            }
            try {
                if (buglyStrategy.isReplaceOldChannel()) {
                    String appChannel = buglyStrategy.getAppChannel();
                    if (!TextUtils.isEmpty(appChannel)) {
                        if (appChannel.length() > 100) {
                            String strSubstring2 = appChannel.substring(0, 100);
                            x.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, strSubstring2);
                            appChannel = strSubstring2;
                        }
                        d.a(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, "app_channel", appChannel.getBytes(), (o) null, false);
                        aVarA.l = appChannel;
                    }
                } else {
                    Map<String, byte[]> mapA = d.a(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, (o) null, true);
                    if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                        aVarA.l = new String(bArr);
                    }
                }
                x.a("[param] Set App channel: %s", aVarA.l);
            } catch (Exception e2) {
                if (c) {
                    e2.printStackTrace();
                }
            }
            String appPackageName = buglyStrategy.getAppPackageName();
            if (!TextUtils.isEmpty(appPackageName)) {
                if (appPackageName.length() > 100) {
                    String strSubstring3 = appPackageName.substring(0, 100);
                    x.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, strSubstring3);
                    appPackageName = strSubstring3;
                }
                aVarA.c = appPackageName;
                x.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
            }
            String deviceID = buglyStrategy.getDeviceID();
            if (deviceID != null) {
                if (deviceID.length() > 100) {
                    String strSubstring4 = deviceID.substring(0, 100);
                    x.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, strSubstring4);
                    deviceID = strSubstring4;
                }
                aVarA.c(deviceID);
                x.a("s[param] Set device ID: %s", deviceID);
            }
            aVarA.e = buglyStrategy.isUploadProcess();
            y.a = buglyStrategy.isBuglyLogUpload();
            com.tencent.bugly.crashreport.biz.b.a(contextA, buglyStrategy);
            for (i = 0; i < b.size(); i++) {
                try {
                    if (nVarA.a(b.get(i).id)) {
                        b.get(i).init(contextA, z, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            if (buglyStrategy != null) {
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            aVarA2.a(appReportDelay);
            x.b("[init] Bugly initialization finished.", new Object[0]);
            return;
        }
        com.tencent.bugly.crashreport.biz.b.a(contextA, buglyStrategy);
        while (i < b.size()) {
            if (nVarA.a(b.get(i).id)) {
                b.get(i).init(contextA, z, buglyStrategy);
            }
        }
        if (buglyStrategy != null) {
            appReportDelay = buglyStrategy.getAppReportDelay();
        } else {
            appReportDelay = 0;
        }
        aVarA2.a(appReportDelay);
        x.b("[init] Bugly initialization finished.", new Object[0]);
        return;
        throw th;
    }

    public static synchronized void a(a aVar) {
        if (!b.contains(aVar)) {
            b.add(aVar);
        }
    }
}
