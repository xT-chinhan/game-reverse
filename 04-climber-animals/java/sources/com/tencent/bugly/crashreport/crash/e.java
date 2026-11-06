package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements Thread.UncaughtExceptionHandler {
    private static String h;
    private static final Object i = new Object();
    private Context a;
    private b b;
    private com.tencent.bugly.crashreport.common.strategy.a c;
    private com.tencent.bugly.crashreport.common.info.a d;
    private Thread.UncaughtExceptionHandler e;
    private Thread.UncaughtExceptionHandler f;
    private boolean g = false;
    private int j;

    public e(Context context, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    public final synchronized void a() {
        if (this.j >= 10) {
            x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f = defaultUncaughtExceptionHandler;
                this.e = defaultUncaughtExceptionHandler;
            } else {
                x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.g = true;
        this.j++;
        x.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.g = false;
        x.a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            x.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.e);
            this.j--;
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String strA;
        boolean z2 = false;
        if (th == null) {
            x.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean zL = c.a().l();
        String str2 = (zL && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (zL && z) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.e();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.E = this.d.p();
        crashDetailBean.F = this.d.o();
        crashDetailBean.G = this.d.q();
        crashDetailBean.w = z.a(this.a, c.e, (String) null);
        crashDetailBean.x = y.a();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.x == null ? 0 : crashDetailBean.x.length);
        x.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.e = this.d.h();
        crashDetailBean.f = this.d.j;
        crashDetailBean.g = this.d.w();
        crashDetailBean.m = this.d.g();
        String name = th.getClass().getName();
        String strB = b(th, 1000);
        if (strB == null) {
            strB = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        x.e("stack frame :%d, has cause %b", objArr2);
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause != null && cause != th) {
            crashDetailBean.n = cause.getClass().getName();
            crashDetailBean.o = b(cause, 1000);
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.p = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(":").append(strB).append("\n");
            sb.append(string);
            sb.append("\n......\nCaused by:\n");
            sb.append(crashDetailBean.n).append(":").append(crashDetailBean.o).append("\n");
            strA = a(cause, c.f);
            sb.append(strA);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            crashDetailBean.o = strB + str2;
            if (crashDetailBean.o == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = string;
            strA = a(th, c.f);
            crashDetailBean.q = strA;
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = z.b(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.y = z.a(c.f, false);
            crashDetailBean.z = this.d.d;
            crashDetailBean.A = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.y.put(crashDetailBean.A, strA);
            crashDetailBean.H = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.I();
            crashDetailBean.L = this.d.a;
            crashDetailBean.M = this.d.a();
            crashDetailBean.O = this.d.F();
            crashDetailBean.P = this.d.G();
            crashDetailBean.Q = this.d.z();
            crashDetailBean.R = this.d.E();
        } catch (Throwable th2) {
            x.e("handle crash error %s", th2.toString());
        }
        if (z) {
            this.b.c(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.N = new HashMap(1);
                crashDetailBean.N.put("UserData", str);
            }
            if (z2) {
                crashDetailBean.S = bArr;
            }
        }
        return crashDetailBean;
    }

    private static boolean a(Thread thread) {
        synchronized (i) {
            if (h != null && thread.getName().equals(h)) {
                return true;
            }
            h = thread.getName();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x023e  */
    /* JADX WARN: Code duplicated, block: B:103:0x024e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0287 A[Catch: all -> 0x02d4, TRY_LEAVE, TryCatch #0 {all -> 0x02d4, blocks: (B:111:0x0281, B:113:0x0287), top: B:140:0x0281 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x028c  */
    /* JADX WARN: Code duplicated, block: B:123:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x018e  */
    /* JADX WARN: Code duplicated, block: B:69:0x019a A[Catch: all -> 0x0276, TRY_LEAVE, TryCatch #2 {all -> 0x0276, blocks: (B:67:0x0194, B:69:0x019a, B:86:0x01ef), top: B:144:0x0194 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:83:0x01eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:90:0x0212 A[Catch: all -> 0x026e, TryCatch #5 {all -> 0x026e, blocks: (B:88:0x0207, B:90:0x0212, B:91:0x0219), top: B:148:0x0207 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0220  */
    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String str2;
        String str3;
        String str4;
        int i2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        int i3;
        String str5;
        String str6;
        CrashDetailBean crashDetailBeanB;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        if (z) {
            x.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                x.a("this class has handled this exception", new Object[0]);
                if (this.f != null) {
                    x.a("call system handler", new Object[0]);
                    this.f.uncaughtException(thread, th);
                } else {
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            x.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.g) {
                x.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.e;
                    if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.c.b()) {
                x.e("waiting for remote sync", new Object[0]);
                int i4 = 0;
                while (!this.c.b()) {
                    z.b(500L);
                    i4 += 500;
                    if (i4 >= 3000) {
                        break;
                    }
                }
            }
            if (!this.c.b()) {
                x.d("no remote but still store!", new Object[0]);
            }
            String str7 = "JAVA_CRASH";
            if (this.c.c().g) {
                i3 = 0;
                str5 = "crashreport last handle end!";
                str6 = "crashreport last handle start!";
                crashDetailBeanB = b(thread, th, z, str, bArr);
                if (crashDetailBeanB == null) {
                    x.e("pkg crash datas fail!", new Object[0]);
                    if (z) {
                        uncaughtExceptionHandler3 = this.e;
                        if (uncaughtExceptionHandler3 == null) {
                        }
                        if (this.f != null) {
                            x.e("system handle start!", new Object[0]);
                            this.f.uncaughtException(thread, th);
                            x.e("system handle end!", new Object[0]);
                            return;
                        } else {
                            x.e(str6, new Object[0]);
                            x.e("current process die", new Object[0]);
                            Process.killProcess(Process.myPid());
                            System.exit(1);
                            x.e(str5, new Object[0]);
                            return;
                        }
                    }
                    return;
                }
                i2 = 0;
                b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.d.d, thread, z.a(th), crashDetailBeanB);
                if (!this.b.a(crashDetailBeanB)) {
                    this.b.a(crashDetailBeanB, com.tapsdk.tapad.e.a.f, z);
                }
                this.b.b(crashDetailBeanB);
                if (z) {
                    uncaughtExceptionHandler2 = this.e;
                    if (uncaughtExceptionHandler2 == null) {
                    }
                    if (this.f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e(str6, new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e(str5, new Object[0]);
                        return;
                    }
                }
                return;
            }
            try {
                if (this.c.b()) {
                    x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    if (!z) {
                        str7 = "JAVA_CATCH";
                    }
                    try {
                        b.a(str7, z.a(), this.d.d, thread, z.a(th), null);
                        if (z) {
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.e;
                            if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                                x.e("sys default last handle start!", new Object[0]);
                                this.e.uncaughtException(thread, th);
                                x.e("sys default last handle end!", new Object[0]);
                                return;
                            } else if (this.f != null) {
                                x.e("system handle start!", new Object[0]);
                                this.f.uncaughtException(thread, th);
                                x.e("system handle end!", new Object[0]);
                                return;
                            } else {
                                x.e("crashreport last handle start!", new Object[0]);
                                x.e("current process die", new Object[0]);
                                Process.killProcess(Process.myPid());
                                System.exit(1);
                                x.e("crashreport last handle end!", new Object[0]);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = "crashreport last handle start!";
                        str4 = "crashreport last handle end!";
                        str2 = "current process die";
                        i2 = 0;
                    }
                } else {
                    i3 = 0;
                    str5 = "crashreport last handle end!";
                    str6 = "crashreport last handle start!";
                    try {
                        crashDetailBeanB = b(thread, th, z, str, bArr);
                        if (crashDetailBeanB == null) {
                            x.e("pkg crash datas fail!", new Object[0]);
                            if (z) {
                                uncaughtExceptionHandler3 = this.e;
                                if (uncaughtExceptionHandler3 == null && a(uncaughtExceptionHandler3)) {
                                    x.e("sys default last handle start!", new Object[0]);
                                    this.e.uncaughtException(thread, th);
                                    x.e("sys default last handle end!", new Object[0]);
                                    return;
                                } else if (this.f != null) {
                                    x.e("system handle start!", new Object[0]);
                                    this.f.uncaughtException(thread, th);
                                    x.e("system handle end!", new Object[0]);
                                    return;
                                } else {
                                    x.e(str6, new Object[0]);
                                    x.e("current process die", new Object[0]);
                                    Process.killProcess(Process.myPid());
                                    System.exit(1);
                                    x.e(str5, new Object[0]);
                                    return;
                                }
                            }
                            return;
                        }
                        i2 = 0;
                        try {
                            b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.d.d, thread, z.a(th), crashDetailBeanB);
                            if (!this.b.a(crashDetailBeanB)) {
                                this.b.a(crashDetailBeanB, com.tapsdk.tapad.e.a.f, z);
                            }
                            this.b.b(crashDetailBeanB);
                            if (z) {
                                uncaughtExceptionHandler2 = this.e;
                                if (uncaughtExceptionHandler2 == null && a(uncaughtExceptionHandler2)) {
                                    x.e("sys default last handle start!", new Object[0]);
                                    this.e.uncaughtException(thread, th);
                                    x.e("sys default last handle end!", new Object[0]);
                                    return;
                                } else if (this.f != null) {
                                    x.e("system handle start!", new Object[0]);
                                    this.f.uncaughtException(thread, th);
                                    x.e("system handle end!", new Object[0]);
                                    return;
                                } else {
                                    x.e(str6, new Object[0]);
                                    x.e("current process die", new Object[0]);
                                    Process.killProcess(Process.myPid());
                                    System.exit(1);
                                    x.e(str5, new Object[0]);
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            str3 = str6;
                            str4 = str5;
                            str2 = "current process die";
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        str4 = str5;
                        str2 = "current process die";
                        str3 = str6;
                        i2 = i3;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                i3 = 0;
                str5 = "crashreport last handle end!";
                str6 = "crashreport last handle start!";
                str4 = str5;
                str2 = "current process die";
                str3 = str6;
                i2 = i3;
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (z) {
                    uncaughtExceptionHandler = this.e;
                    if (uncaughtExceptionHandler == null) {
                    }
                    if (this.f != null) {
                        x.e("system handle start!", new Object[i2]);
                        this.f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[i2]);
                    } else {
                        x.e(str3, new Object[i2]);
                        x.e(str2, new Object[i2]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e(str4, new Object[i2]);
                    }
                }
            }
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                if (z) {
                    uncaughtExceptionHandler = this.e;
                    if (uncaughtExceptionHandler == null && a(uncaughtExceptionHandler)) {
                        x.e("sys default last handle start!", new Object[i2]);
                        this.e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[i2]);
                    } else if (this.f != null) {
                        x.e("system handle start!", new Object[i2]);
                        this.f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[i2]);
                    } else {
                        x.e(str3, new Object[i2]);
                        x.e(str2, new Object[i2]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e(str4, new Object[i2]);
                    }
                }
            } catch (Throwable th6) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        x.e("sys default last handle start!", new Object[i2]);
                        this.e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[i2]);
                    } else if (this.f != null) {
                        x.e("system handle start!", new Object[i2]);
                        this.f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[i2]);
                    } else {
                        x.e(str3, new Object[i2]);
                        x.e(str2, new Object[i2]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e(str4, new Object[i2]);
                    }
                }
                throw th6;
            }
        } catch (Throwable th7) {
            th = th7;
            str2 = "current process die";
            str3 = "crashreport last handle start!";
            str4 = "crashreport last handle end!";
            i2 = 0;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (i) {
            a(thread, th, true, null, null);
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.g != this.g) {
                x.a("java changed to %b", Boolean.valueOf(strategyBean.g));
                if (strategyBean.g) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString()).append("\n");
                }
            }
        } catch (Throwable th2) {
            x.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
