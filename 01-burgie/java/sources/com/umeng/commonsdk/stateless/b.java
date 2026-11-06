package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/* JADX INFO: compiled from: UMSLNetWorkSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final int a = 273;
    private static Context b = null;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static a i;
    private static IntentFilter j;
    private static HandlerThread c = null;
    private static Handler d = null;
    private static Object e = new Object();
    private static volatile boolean k = false;
    private static LinkedList<String> l = new LinkedList<>();

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
            if ((i & 8) == 8) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
                b.a(274);
            }
        }
    }

    public static boolean a() {
        synchronized (e) {
            if (i != null) {
                return true;
            }
            return false;
        }
    }

    public b(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    b = context.getApplicationContext();
                    if (b != null && c == null) {
                        c = new HandlerThread("SL-NetWorkSender");
                        c.start();
                        if (i == null) {
                            String str = b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            i = new a(str);
                            i.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (d == null) {
                            d = new Handler(c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) throws IOException {
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
        if (k && d != null) {
            Message messageObtainMessage = d.obtainMessage();
            messageObtainMessage.what = i2;
            d.sendMessage(messageObtainMessage);
        }
    }

    public static void b(int i2) {
        try {
            if (k && d != null && !d.hasMessages(i2)) {
                Message messageObtainMessage = d.obtainMessage();
                messageObtainMessage.what = i2;
                d.sendMessage(messageObtainMessage);
            }
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
        try {
            String strPeek = l.peek();
            if (strPeek != null) {
                try {
                    l.removeFirst();
                    return strPeek;
                } catch (Throwable th) {
                    return strPeek;
                }
            }
            return strPeek;
        } catch (Throwable th2) {
            return null;
        }
    }

    private static void k() throws IOException {
        String strJ;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            if (Build.VERSION.SDK_INT >= 9) {
                strJ = l.pollFirst();
            } else {
                strJ = j();
            }
            if (!TextUtils.isEmpty(strJ)) {
                File file = new File(strJ);
                if (!file.exists()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                } else {
                    c cVar = new c(b);
                    if (cVar != null) {
                        byte[] bArrA = null;
                        try {
                            bArrA = d.a(strJ);
                        } catch (Exception e2) {
                        }
                        String name = file.getName();
                        String strSubstring = an.aH;
                        if (!TextUtils.isEmpty(name)) {
                            strSubstring = name.substring(0, 1);
                        }
                        String str = "";
                        String strC = d.c(d.d(name));
                        if (com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(strC)) {
                            str = com.umeng.commonsdk.vchannel.a.a;
                        }
                        if (cVar.a(bArrA, strC, str, strSubstring) && !file.delete()) {
                            file.delete();
                        }
                    }
                }
            }
        } while (strJ != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() throws IOException {
        File fileA;
        c cVar;
        if (!k || b == null) {
            return;
        }
        do {
            try {
                fileA = d.a(b);
                if (fileA != null && fileA.getParentFile() != null && !TextUtils.isEmpty(fileA.getParentFile().getName()) && (cVar = new c(b)) != null) {
                    String str = new String(Base64.decode(fileA.getParentFile().getName(), 0));
                    if (com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str) || com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str) || com.umeng.commonsdk.internal.a.G.equalsIgnoreCase(str)) {
                        new File(fileA.getAbsolutePath()).delete();
                    } else {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArrA = null;
                        try {
                            bArrA = d.a(fileA.getAbsolutePath());
                        } catch (Exception e2) {
                        }
                        String str2 = "";
                        if (com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(str)) {
                            str2 = com.umeng.commonsdk.vchannel.a.a;
                        }
                        String str3 = an.aH;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str3 = an.aB;
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = an.ax;
                        }
                        if (cVar.a(bArrA, str, str2, str3)) {
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
            if (file != null && file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() throws IOException {
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
            if (file != null && file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable th) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }
}
