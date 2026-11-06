package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.anythink.core.common.d.j;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {
    private static NativeCrashHandler a = null;
    private static boolean l = false;
    private static boolean m = false;
    private final Context b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final w d;
    private NativeExceptionHandler e;
    private String f;
    private final boolean g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private com.tencent.bugly.crashreport.crash.b n;

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i, String str);

    protected native void testCrash();

    protected native String unregist();

    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z, String str) {
        this.b = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).c + "/app_bugly";
        }
        this.n = bVar;
        this.f = str;
        this.c = aVar;
        this.d = wVar;
        this.g = z;
        this.e = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        if (a == null) {
            a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
        }
        return a;
    }

    public static synchronized NativeCrashHandler getInstance() {
        return a;
    }

    public synchronized String getDumpFilePath() {
        return this.f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f = str;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007f A[Catch: all -> 0x008d, TryCatch #3 {all -> 0x008d, blocks: (B:21:0x0075, B:23:0x007f, B:24:0x0081, B:26:0x008b), top: B:71:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x008b A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #3 {all -> 0x008d, blocks: (B:21:0x0075, B:23:0x007f, B:24:0x0081, B:26:0x008b), top: B:71:0x0075 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0091 A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005a, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0063, B:19:0x0069), top: B:67:0x0015, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0099 A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005a, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0063, B:19:0x0069), top: B:67:0x0015, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a4 A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005a, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0063, B:19:0x0069), top: B:67:0x0015, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005a, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0063, B:19:0x0069), top: B:67:0x0015, outer: #0 }] */
    private synchronized void a(boolean z) {
        StringBuilder sbAppend;
        String str;
        if (this.j) {
            x.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.i) {
            try {
                String strRegist = regist(this.f, z, 1);
                if (strRegist != null) {
                    x.a("[Native] Native Crash Report enable.", new Object[0]);
                    x.c("[Native] Check extra jni for Bugly NDK v%s", strRegist);
                    String strReplace = "2.1.1".replace(j.z, "");
                    String strReplace2 = "2.3.0".replace(j.z, "");
                    String strReplace3 = strRegist.replace(j.z, "");
                    try {
                        if (strReplace3.length() != 2) {
                            if (strReplace3.length() == 1) {
                                sbAppend = new StringBuilder().append(strReplace3);
                                str = "00";
                            }
                            if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace)) {
                                l = true;
                            }
                            if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace2)) {
                                m = true;
                            }
                            if (m) {
                                x.a("[Native] Info setting jni can be accessed.", new Object[0]);
                            } else {
                                x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
                            }
                            if (l) {
                                x.a("[Native] Extra jni can be accessed.", new Object[0]);
                            } else {
                                x.d("[Native] Extra jni can not be accessed.", new Object[0]);
                            }
                            this.c.n = strRegist;
                            this.j = true;
                            return;
                        }
                        sbAppend = new StringBuilder().append(strReplace3);
                        str = "0";
                        if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace)) {
                            l = true;
                        }
                        if (Integer.parseInt(strReplace3) >= Integer.parseInt(strReplace2)) {
                            m = true;
                        }
                    } catch (Throwable unused) {
                    }
                    strReplace3 = sbAppend.append(str).toString();
                    if (m) {
                        x.a("[Native] Info setting jni can be accessed.", new Object[0]);
                    } else {
                        x.d("[Native] Info setting jni can not be accessed.", new Object[0]);
                    }
                    if (l) {
                        x.a("[Native] Extra jni can be accessed.", new Object[0]);
                    } else {
                        x.d("[Native] Extra jni can not be accessed.", new Object[0]);
                    }
                    this.c.n = strRegist;
                    this.j = true;
                    return;
                }
            } catch (Throwable unused2) {
                x.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.h) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.f;
                objArr[1] = com.tencent.bugly.crashreport.common.info.b.a(false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str2 = (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str2 == null) {
                    Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                    com.tencent.bugly.crashreport.common.info.a.b();
                    str2 = (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", null, clsArr2, new Object[]{this.f, com.tencent.bugly.crashreport.common.info.b.a(false), Integer.valueOf(com.tencent.bugly.crashreport.common.info.a.J())});
                }
                if (str2 != null) {
                    this.j = true;
                    com.tencent.bugly.crashreport.common.info.a.b().n = str2;
                    Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str2});
                    if (bool != null) {
                        l = bool.booleanValue();
                    }
                    z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused3) {
            }
        }
        this.i = false;
        this.h = false;
    }

    public synchronized void startNativeMonitor() {
        if (!this.i && !this.h) {
            String str = "Bugly";
            boolean z = !z.a(this.c.m);
            String str2 = this.c.m;
            if (z) {
                str = str2;
            } else {
                this.c.getClass();
            }
            boolean zA = a(str, z);
            this.i = zA;
            if (zA || this.h) {
                a(this.g);
                this.d.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        if (!z.a(NativeCrashHandler.this.b, "native_record_lock", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT)) {
                            x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                            return;
                        }
                        try {
                            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                            nativeCrashHandler.setNativeAppVersion(nativeCrashHandler.c.j);
                            NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.this;
                            nativeCrashHandler2.setNativeAppChannel(nativeCrashHandler2.c.l);
                            NativeCrashHandler nativeCrashHandler3 = NativeCrashHandler.this;
                            nativeCrashHandler3.setNativeAppPackage(nativeCrashHandler3.c.c);
                            NativeCrashHandler nativeCrashHandler4 = NativeCrashHandler.this;
                            nativeCrashHandler4.setNativeUserId(nativeCrashHandler4.c.g());
                            NativeCrashHandler nativeCrashHandler5 = NativeCrashHandler.this;
                            nativeCrashHandler5.setNativeIsAppForeground(nativeCrashHandler5.c.a());
                            NativeCrashHandler nativeCrashHandler6 = NativeCrashHandler.this;
                            nativeCrashHandler6.setNativeLaunchTime(nativeCrashHandler6.c.a);
                        } catch (Throwable th) {
                            if (!x.a(th)) {
                                th.printStackTrace();
                            }
                        }
                        CrashDetailBean crashDetailBeanA = b.a(NativeCrashHandler.this.b, NativeCrashHandler.this.f, NativeCrashHandler.this.e);
                        if (crashDetailBeanA != null) {
                            x.a("[Native] Get crash from native record.", new Object[0]);
                            if (!NativeCrashHandler.this.n.a(crashDetailBeanA)) {
                                NativeCrashHandler.this.n.a(crashDetailBeanA, com.tapsdk.tapad.e.a.f, false);
                            }
                            b.a(false, NativeCrashHandler.this.f);
                        }
                        NativeCrashHandler.this.a();
                        z.b(NativeCrashHandler.this.b, "native_record_lock");
                    }
                });
                return;
            }
            return;
        }
        a(this.g);
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                x.d(th.getMessage(), new Object[0]);
                x.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    private synchronized void b() {
        if (!this.j) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.j = false;
                return;
            }
            try {
                z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
                this.j = false;
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                return;
            } catch (Throwable unused) {
                x.c("[Native] Failed to close native crash report.", new Object[0]);
                this.i = false;
                this.h = false;
                return;
            }
        } catch (Throwable unused2) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        throw th;
    }

    public void testNativeCrash() {
        if (!this.i) {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.e;
    }

    protected final void a() {
        File[] fileArrListFiles;
        long jB = z.b() - c.g;
        File file = new File(this.f);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        int i = 0;
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            if (name.startsWith("tomb_")) {
                try {
                    int iIndexOf = name.indexOf(".txt");
                    if (iIndexOf <= 0 || Long.parseLong(name.substring(5, iIndexOf)) < jB) {
                        if (file2.delete()) {
                            i++;
                        }
                    }
                } catch (Throwable unused) {
                    x.e("[Native] Tomb file format error, delete %s", name);
                }
            }
        }
        x.c("[Native] Clean tombs %d", Integer.valueOf(i));
    }

    private synchronized void b(boolean z) {
        try {
            if (z) {
                startNativeMonitor();
            } else {
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean isUserOpened() {
        return this.k;
    }

    private synchronized void c(boolean z) {
        if (this.k != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean zIsUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (aVarA != null) {
            zIsUserOpened = zIsUserOpened && aVarA.c().g;
        }
        if (zIsUserOpened != this.j) {
            x.a("native changed to %b", Boolean.valueOf(zIsUserOpened));
            b(zIsUserOpened);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0031 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:8:0x001a, B:10:0x0026, B:14:0x002d, B:16:0x0031), top: B:22:0x0005 }] */
    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        boolean z;
        if (strategyBean != null) {
            if (strategyBean.g != this.j) {
                x.d("server native changed to %b", Boolean.valueOf(strategyBean.g));
            }
            if (com.tencent.bugly.crashreport.common.strategy.a.a().c().g || !this.k) {
                z = false;
            } else {
                z = true;
            }
            if (z != this.j) {
                x.a("native changed to %b", Boolean.valueOf(z));
                b(z);
            }
        } else {
            if (com.tencent.bugly.crashreport.common.strategy.a.a().c().g) {
                z = false;
            } else {
                z = false;
            }
            if (z != this.j) {
                x.a("native changed to %b", Boolean.valueOf(z));
                b(z);
            }
        }
        throw th;
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.h || this.i) && l && str != null && str2 != null && str3 != null) {
            try {
                if (this.i) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.h || this.i) && l && str != null && str2 != null) {
            try {
                if (this.i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                l = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    private boolean a(int i, String str) {
        if (this.i && m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : Bugly.SDK_IS_DEV);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (x.a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }
}
