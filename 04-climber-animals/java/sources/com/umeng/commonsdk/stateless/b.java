package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* JADX INFO: compiled from: UMSLNetWorkSender.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static final int a = 273;
    private static Context b = null;
    private static HandlerThread c = null;
    private static Handler d = null;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static a i = null;
    private static IntentFilter j = null;
    private static volatile boolean k = false;
    private static Object e = new Object();
    private static LinkedList<String> l = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static void a(boolean z) {
        k = z;
        if (z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(274);
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        }
    }

    /* JADX INFO: compiled from: UMSLNetWorkSender.java */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(274);
        }
    }

    public static boolean a() {
        synchronized (e) {
            return i != null;
        }
    }

    public b(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    b = applicationContext;
                    if (applicationContext != null && c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        c = handlerThread;
                        handlerThread.start();
                        if (i == null) {
                            String str = b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (d == null) {
                            d = new Handler(c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                b.l();
                                                return;
                                            case 274:
                                                b.n();
                                                return;
                                            case 275:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!k || (handler = d) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        d.sendMessage(messageObtainMessage);
    }

    public static void b(int i2) {
        Handler handler;
        try {
            if (!k || (handler = d) == null || handler.hasMessages(i2)) {
                return;
            }
            Message messageObtainMessage = d.obtainMessage();
            messageObtainMessage.what = i2;
            d.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    private static void i() {
        File[] fileArrC = d.c(b);
        if (fileArrC != null) {
            if (l.size() > 0) {
                l.clear();
            }
            for (File file : fileArrC) {
                l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String strPeek = l.peek();
            if (strPeek == null) {
                return strPeek;
            }
            try {
                l.removeFirst();
                return strPeek;
            } catch (Throwable unused) {
                str = strPeek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void k() {
        String strPollFirst;
        byte[] bArrA;
        String str;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            strPollFirst = l.pollFirst();
            if (!TextUtils.isEmpty(strPollFirst)) {
                File file = new File(strPollFirst);
                if (!file.exists()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                } else {
                    c cVar = new c(b);
                    try {
                        bArrA = d.a(strPollFirst);
                    } catch (Exception unused) {
                        bArrA = null;
                    }
                    String name = file.getName();
                    String strSubstring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String strC = d.c(d.d(name));
                    if (SdkVersion.SDK_TYPE == 0) {
                        cVar.a();
                    } else {
                        com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.stateless.a.j;
                        cVar.b();
                    }
                    if (com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(strC)) {
                        str = com.umeng.commonsdk.vchannel.a.a;
                    } else {
                        str = com.umeng.commonsdk.stateless.a.h;
                    }
                    if (cVar.a(bArrA, strC, str, strSubstring) && !file.delete()) {
                        file.delete();
                    }
                }
            }
        } while (strPollFirst != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File fileA;
        byte[] bArrA;
        String str;
        if (!k || b == null) {
            return;
        }
        do {
            try {
                fileA = d.a(b);
                if (fileA != null && fileA.getParentFile() != null && !TextUtils.isEmpty(fileA.getParentFile().getName())) {
                    c cVar = new c(b);
                    String str2 = new String(Base64.decode(fileA.getParentFile().getName(), 0));
                    if (com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str2) || com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str2) || com.umeng.commonsdk.internal.a.L.equalsIgnoreCase(str2)) {
                        new File(fileA.getAbsolutePath()).delete();
                    } else {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str2);
                        try {
                            bArrA = d.a(fileA.getAbsolutePath());
                        } catch (Exception unused) {
                            bArrA = null;
                        }
                        String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str2) ? "s" : "u";
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str2) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str2) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str2)) {
                            str3 = "p";
                        }
                        if (SdkVersion.SDK_TYPE == 0) {
                            cVar.a();
                        } else {
                            com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.stateless.a.j;
                            cVar.b();
                        }
                        if (com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(str2)) {
                            str = com.umeng.commonsdk.vchannel.a.a;
                        } else {
                            str = com.umeng.commonsdk.stateless.a.h;
                        }
                        if (cVar.a(bArrA, str2, str, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                            File file = new File(fileA.getAbsolutePath());
                            if (!file.delete()) {
                                ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                file.delete();
                            }
                        } else {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(b, th);
            }
        } while (fileA != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!k || b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static void c() {
        b(275);
    }

    public static void d() {
        b(512);
    }
}
