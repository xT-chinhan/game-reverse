package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.tapsdk.tapad.constants.Constants;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public class e implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean a = true;
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final ConditionVariable o = new ConditionVariable();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final ArrayList<String> s = new ArrayList<>();
    private static int t = 0;
    private static String u = null;
    private static boolean v = false;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_URL_CODE);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    static /* synthetic */ void K() {
        StringBuilder sbY;
        if (com.uc.crashsdk.b.d && (sbY = Y()) != null) {
            JNIBridge.set(125, sbY.toString());
        }
        L = true;
        Z();
    }

    static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private void M() {
        int iJ = g.J();
        for (int i2 = 0; i2 < iJ; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void N() {
        Iterator<FileInputStream> it = this.e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O() {
        if (g.Q()) {
            return true;
        }
        return a();
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(com.uc.crashsdk.b.b("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    static long b() {
        if (g == -1) {
            g = h(com.uc.crashsdk.b.b("local"));
        }
        return g;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class a extends OutputStream {
        private final long a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        a(long j, OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0019  */
        private int a(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            this.d += i2;
            if (this.e) {
                return 0;
            }
            int iB = g.B();
            if (iB > 0) {
                int i4 = this.c;
                if (i4 + i2 > iB) {
                    i3 = iB - i4;
                } else {
                    i3 = i2;
                }
            } else {
                i3 = i2;
            }
            this.c += i3;
            if (this.a != 0) {
                b(new String(bArr, i, i3));
            } else {
                this.b.write(bArr, i, i3);
            }
            if (i3 < i2) {
                this.e = true;
            }
            return i3;
        }

        final void a() {
            try {
                if (this.d - this.c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(g.B()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        final void a(String str) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (e.h && e.O()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (e.h && e.O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String P() {
        return g.e() + "_";
    }

    static void c() {
        i = null;
    }

    static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String strJ = j(null);
        i = strJ;
        return strJ;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.U(), g.W(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
    }

    private static String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : "bg";
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    return bArr;
                }
            }
        }
        return bArr;
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case 402:
                Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int iNativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.p(), g.q());
                    if (iNativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((iNativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else {
                            if ((iNativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                                Z = 106;
                                i3 = 32;
                            } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i3);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                        break;
                    }
                    return;
                }
            case 403:
                ab();
                return;
            case 404:
            default:
                if (!a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder sbY = Y();
                String strG = com.uc.crashsdk.b.g();
                if (sbY != null) {
                    com.uc.crashsdk.a.g.a(new File(strG), sbY.toString());
                    return;
                }
                return;
            case 406:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                synchronized (ab) {
                    if (!ac && g.R() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (g.R()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                d(false);
                return;
            case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                a(false, true);
                return;
            case TTAdConstant.IMAGE_CODE /* 411 */:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(28, d("jni"));
                    JNIBridge.set(29, d("anr"));
                    return;
                }
                return;
            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                if (!R && com.uc.crashsdk.b.B() && g.N()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.B() && g.N()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                JNIBridge.cmd(8);
                return;
            case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        X();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                long jLongValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= jLongValue) {
                    h.g();
                    f.a(100);
                    d(true);
                    f.a(true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
                break;
            case 416:
                break;
        }
        W();
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i2 == 452) {
            if (!a && objArr == null) {
                throw new AssertionError();
            }
            String str = (String) objArr[0];
            d dVar = (d) objArr[1];
            return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
        }
        if (a) {
            return false;
        }
        throw new AssertionError();
    }

    private static String S() {
        return (!com.uc.crashsdk.b.F() || d) ? "java" : "ucebujava";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(boolean z2) {
        File[] fileArrListFiles;
        try {
            if (com.uc.crashsdk.b.y() && (fileArrListFiles = new File(g.Y()).listFiles()) != null) {
                int iM = g.m();
                int iN = g.n();
                if (fileArrListFiles.length < Math.min(iM, iN)) {
                    return;
                }
                Object[] objArr = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : fileArrListFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < iM) ? 0 : (i2 - iM) + 1;
                int i5 = (z2 || i3 < iN) ? 0 : (i3 - iN) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(fileArrListFiles, new b(objArr == true ? 1 : 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : fileArrListFiles) {
                    boolean zB = b(file2);
                    if (zB && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6--;
                    } else if (!zB && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7--;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class b implements Comparator<File> {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String strS;
        String strNativeGet;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.U(), g.V(), g.W(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str3 = "0";
            String str4 = "";
            if (com.uc.crashsdk.b.d) {
                String strNativeGet2 = JNIBridge.nativeGet(1, 0L, null);
                strNativeGet = JNIBridge.nativeGet(2, 0L, null);
                str3 = strNativeGet2;
            } else {
                strNativeGet = "";
            }
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str3, "240515102041", strNativeGet, "umeng").getBytes("UTF-8"));
            if (str != null) {
                str4 = str;
            }
            outputStream.write(("Report Name: " + str4.substring(str4.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ag) {
                strS = s("UUID");
            } else {
                strS = B;
            }
            outputStream.write(String.format("UUID: %s\n", strS).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String strE = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(strE)) {
                strE = "(none)";
            }
            outputStream.write(("Activity: " + strE + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static String e() {
        String str;
        String str2;
        String str3;
        String str4;
        if (!com.uc.crashsdk.a.g.a(j)) {
            return j;
        }
        String str5 = null;
        try {
            Field declaredField = Build.class.getDeclaredField("SUPPORTED_ABIS");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null && (obj instanceof String[])) {
                String[] strArr = (String[]) obj;
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                int i2 = 0;
                boolean z2 = true;
                while (i2 < length) {
                    String str6 = strArr[i2];
                    if (!z2) {
                        sb.append(",");
                    }
                    sb.append(str6);
                    i2++;
                    z2 = false;
                }
                j = sb.toString();
            }
        } catch (Throwable unused) {
        }
        if (com.uc.crashsdk.a.g.a(j)) {
            try {
                str3 = Build.CPU_ABI;
                try {
                    str4 = Build.CPU_ABI2;
                } catch (Throwable unused2) {
                    str4 = null;
                }
            } catch (Throwable unused3) {
                str3 = null;
            }
            boolean z3 = !com.uc.crashsdk.a.g.a(str3);
            if (z3) {
                j = str3;
            }
            if (!com.uc.crashsdk.a.g.a(str4)) {
                if (z3) {
                    j += ",";
                    j += str4;
                } else {
                    j = str4;
                }
            }
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                str = (String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
                try {
                    str2 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
                } catch (Throwable th) {
                    th = th;
                    com.uc.crashsdk.a.g.a(th);
                    str2 = null;
                }
                str5 = str;
            } else {
                str2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        try {
            if (!com.uc.crashsdk.a.g.a(str5) && !j.contains(str5)) {
                j += ",";
                j += str5;
            }
            if (!com.uc.crashsdk.a.g.a(str2) && !j.contains(str2)) {
                j += ",";
                j += str2;
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return j;
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    private static void T() {
        String strTrim;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String strTrim2 = "-";
        try {
            strTrim = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            strTrim = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("Hardware")) {
                            strTrim = line.substring(line.indexOf(":") + 1).trim();
                        } else if (line.startsWith("Processor")) {
                            strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = strTrim;
        l = strTrim2;
    }

    static String g() {
        try {
            StringBuilder sb = new StringBuilder("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024).append(" kB\nJavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024).append(" kB\nJavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024).append(" kB\nNativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024).append(" kB\nNativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024).append(" kB\nNativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024).append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ").append(memoryInfo.availMem / 1024).append(" kB\n");
                    sb.append("threshold:  ").append(memoryInfo.threshold / 1024).append(" kB\n");
                    sb.append("lowMemory:  ").append(memoryInfo.lowMemory).append("\n");
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{com.anythink.core.common.m.e.bc, "-ef"}).getInputStream()));
            boolean zB = com.uc.crashsdk.a.g.b(str);
            boolean zB2 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    boolean z2 = true;
                    if ((!zB || !line.contains(str)) && ((!zB2 || !line.contains(str2)) && (line.indexOf(47) >= 0 || line.indexOf(46) <= 0))) {
                        z2 = false;
                    }
                    if (z2) {
                        byteArrayOutputStream.write(line.getBytes("UTF-8"));
                        byteArrayOutputStream.write("\n".getBytes("UTF-8"));
                    }
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    return bufferedReader;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReaderA = null;
        try {
            try {
                outputStream.write("logcat:\n".getBytes("UTF-8"));
                if (g.o() <= 0) {
                    try {
                        outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                    } catch (Throwable th) {
                        a(th, outputStream);
                    }
                    a(outputStream);
                    com.uc.crashsdk.a.g.a((Closeable) null);
                    return;
                }
                int iO = g.o();
                bufferedReaderA = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.g.ax, "-b", "main", "-v", "threadtime", "-t", String.valueOf(iO)}).getInputStream()));
                if (bufferedReaderA == null) {
                    try {
                        outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                    } catch (Throwable th2) {
                        a(th2, outputStream);
                    }
                    a(outputStream);
                    com.uc.crashsdk.a.g.a(bufferedReaderA);
                    return;
                }
                h = false;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String line = bufferedReaderA.readLine();
                    if (line != null) {
                        i2++;
                        if (i3 < iO && !line.contains(" I auditd ") && !line.contains(" I liblog ")) {
                            outputStream.write(line.getBytes("UTF-8"));
                            outputStream.write("\n".getBytes("UTF-8"));
                            i3++;
                        }
                    } else {
                        try {
                            break;
                        } catch (Throwable th3) {
                            a(th3, outputStream);
                        }
                    }
                }
                outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
                h = true;
                com.uc.crashsdk.a.g.a(bufferedReaderA);
                a(outputStream);
                return;
            } catch (Throwable th4) {
                h = true;
                a(th4, outputStream);
            }
            h = true;
            a(th4, outputStream);
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
        } catch (Throwable th5) {
            com.uc.crashsdk.a.g.a((Closeable) null);
            throw th5;
        }
    }

    private static String a(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Throwable unused) {
            canonicalPath = null;
        }
        return com.uc.crashsdk.a.g.a(canonicalPath) ? file.getPath() : canonicalPath;
    }

    private static long a(StatFs statFs, String str, String str2) {
        Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        Object objInvoke = declaredMethod.invoke(statFs, new Object[0]);
        if (objInvoke != null && (objInvoke instanceof Long)) {
            return ((Long) objInvoke).longValue();
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (objInvoke2 == null || !(objInvoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) objInvoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void c(OutputStream outputStream) {
        int iK;
        if (com.uc.crashsdk.b.d) {
            String strO = com.uc.crashsdk.b.o();
            h = false;
            if (1 == JNIBridge.cmd(17, strO)) {
                File file = new File(strO);
                try {
                    byte[] bArrE = com.uc.crashsdk.a.g.e(file);
                    if (bArrE != null) {
                        outputStream.write(bArrE);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArrListFiles = null;
        try {
            iK = g.K();
            try {
                fileArrListFiles = new File("/proc/self/fd").listFiles();
                if (fileArrListFiles != null) {
                    outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArrListFiles.length), Integer.valueOf(iK)).getBytes("UTF-8"));
                } else {
                    outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
                }
            } catch (Throwable th3) {
                th = th3;
                a(th, outputStream);
            }
        } catch (Throwable th4) {
            th = th4;
            iK = 900;
        }
        if (fileArrListFiles != null) {
            try {
                if (fileArrListFiles.length >= iK) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArrListFiles) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (Throwable th5) {
                        a(th5, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
    }

    private static void d(OutputStream outputStream) {
        int iL;
        int length;
        File[] fileArrListFiles = null;
        try {
            iL = g.L();
            try {
                fileArrListFiles = new File("/proc/self/task").listFiles();
                if (fileArrListFiles == null || (length = fileArrListFiles.length) < iL) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                com.uc.crashsdk.a.g.a(th);
                length = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            iL = 300;
        }
        if (fileArrListFiles == null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(length), Integer.valueOf(iL)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (File file : fileArrListFiles) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), l(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static void e(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int iIndexOf;
        if (com.uc.crashsdk.b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(".so") && (iIndexOf = line.indexOf(47)) != -1) {
                                String strSubstring = line.substring(iIndexOf);
                                if ((strSubstring.contains("/data/") || strSubstring.contains(com.uc.crashsdk.a.a)) && !arrayList.contains(strSubstring)) {
                                    arrayList.add(strSubstring);
                                    if (ag) {
                                        try {
                                            outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", strSubstring) + "\n").getBytes("UTF-8"));
                                        } catch (Throwable th2) {
                                            a(th2, outputStream);
                                        }
                                    } else {
                                        outputStream.write(String.format(Locale.US, "%s: %s\n", strSubstring, JNIBridge.nativeGet(3, 0L, strSubstring)).getBytes("UTF-8"));
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0046 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:16:0x0030, B:17:0x0040, B:19:0x0046), top: B:27:0x0030 }] */
    static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String strA = com.uc.crashsdk.a.b.a(str);
            if (strA == null) {
                strA = "file: '" + str + "' not found or decode failed!";
            }
            int length = strA.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(strA.getBytes("UTF-8"), 0, i2);
                    outputStream.write("\n".getBytes("UTF-8"));
                    if (i2 < strA.length()) {
                        outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - i2)).getBytes("UTF-8"));
                    }
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                }
            } else if (i2 < strA.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] bArrR = R();
                if (bArrR == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    com.uc.crashsdk.a.g.a((Closeable) null);
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        int i6 = dataInputStream.read(bArrR);
                        if (i6 == -1) {
                            break;
                        }
                        i4 += i6;
                        int i7 = i2 - i3;
                        if (i6 <= i7 + 32) {
                            i7 = i6;
                        }
                        if (i7 > 0 && !z2) {
                            outputStream.write(bArrR, 0, i7);
                            i3 += i7;
                        }
                        if (!z2) {
                            z2 = i7 < i6 || i3 >= i2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        i5 = i3;
                        dataInputStream2 = dataInputStream;
                        try {
                            a(th, outputStream);
                            com.uc.crashsdk.a.g.a(dataInputStream2);
                            i3 = i5;
                        } catch (Throwable th2) {
                            com.uc.crashsdk.a.g.a(dataInputStream2);
                            throw th2;
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
            com.uc.crashsdk.a.g.a(dataInputStream);
        } catch (Throwable th3) {
            th = th3;
        }
        a(outputStream);
        return i3;
    }

    static String a(int i2) {
        try {
            String strA = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(strA) ? l(strA) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static String l(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(0);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String strA = a(Process.myPid());
        m = strA;
        return strA;
    }

    /* JADX WARN: Code duplicated, block: B:187:0x037b  */
    /* JADX WARN: Code duplicated, block: B:195:0x03b9 A[Catch: all -> 0x042b, TryCatch #7 {all -> 0x042b, blocks: (B:193:0x0396, B:195:0x03b9, B:196:0x03bb, B:198:0x03c9, B:199:0x03ce, B:201:0x03e8, B:204:0x040c, B:206:0x0413), top: B:299:0x0396 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x03c9 A[Catch: all -> 0x042b, TryCatch #7 {all -> 0x042b, blocks: (B:193:0x0396, B:195:0x03b9, B:196:0x03bb, B:198:0x03c9, B:199:0x03ce, B:201:0x03e8, B:204:0x040c, B:206:0x0413), top: B:299:0x0396 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x03e8 A[Catch: all -> 0x042b, TryCatch #7 {all -> 0x042b, blocks: (B:193:0x0396, B:195:0x03b9, B:196:0x03bb, B:198:0x03c9, B:199:0x03ce, B:201:0x03e8, B:204:0x040c, B:206:0x0413), top: B:299:0x0396 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x040a  */
    /* JADX WARN: Code duplicated, block: B:205:0x0410  */
    /* JADX WARN: Code duplicated, block: B:219:0x0447 A[Catch: all -> 0x04a6, TRY_LEAVE, TryCatch #3 {all -> 0x04a6, blocks: (B:180:0x0366, B:185:0x0377, B:210:0x042e, B:217:0x0443, B:219:0x0447, B:224:0x045c, B:223:0x0459, B:236:0x0472, B:238:0x0476, B:243:0x048b, B:242:0x0488, B:244:0x048e, B:249:0x049a, B:235:0x046f, B:229:0x0465, B:216:0x0440, B:191:0x0391, B:184:0x0374, B:179:0x0363, B:225:0x045f, B:231:0x0469, B:181:0x0369, B:212:0x043a, B:239:0x0479, B:245:0x0494, B:220:0x044a), top: B:292:0x0363, inners: #0, #8, #13, #20, #25, #37, #38 }] */
    /* JADX WARN: Code duplicated, block: B:238:0x0476 A[Catch: all -> 0x04a6, TRY_LEAVE, TryCatch #3 {all -> 0x04a6, blocks: (B:180:0x0366, B:185:0x0377, B:210:0x042e, B:217:0x0443, B:219:0x0447, B:224:0x045c, B:223:0x0459, B:236:0x0472, B:238:0x0476, B:243:0x048b, B:242:0x0488, B:244:0x048e, B:249:0x049a, B:235:0x046f, B:229:0x0465, B:216:0x0440, B:191:0x0391, B:184:0x0374, B:179:0x0363, B:225:0x045f, B:231:0x0469, B:181:0x0369, B:212:0x043a, B:239:0x0479, B:245:0x0494, B:220:0x044a), top: B:292:0x0363, inners: #0, #8, #13, #20, #25, #37, #38 }] */
    /* JADX WARN: Code duplicated, block: B:251:0x049f  */
    /* JADX WARN: Code duplicated, block: B:265:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:269:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:272:0x04d5 A[Catch: all -> 0x04e6, TryCatch #2 {all -> 0x04e6, blocks: (B:270:0x04d1, B:272:0x04d5, B:274:0x04e0), top: B:290:0x04d1 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x04de  */
    /* JADX WARN: Code duplicated, block: B:299:0x0396 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static String a(Throwable th, String str, long j2, boolean z2) {
        a aVar;
        FileOutputStream fileOutputStream;
        String strA;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        String strH;
        String str5;
        String str6 = "\n";
        try {
            try {
                if (!com.uc.crashsdk.b.L()) {
                    try {
                        g.a();
                        a(true);
                    } catch (Throwable th2) {
                        th = th2;
                        aVar = null;
                        fileOutputStream = null;
                        try {
                            a(th, aVar);
                            if (j2 != 0) {
                                b(aVar);
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            if (!ag) {
                                r(str);
                            }
                            if (ag) {
                                strA = str;
                            } else {
                                strA = a(m(str));
                            }
                            b(strA, "java");
                            return str;
                        } catch (Throwable th3) {
                            if (j2 != 0) {
                                b(aVar);
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            throw th3;
                        }
                    }
                }
                FileOutputStream fileOutputStream2 = j2 == 0 ? new FileOutputStream(str) : null;
                try {
                    a aVar2 = new a(j2, fileOutputStream2);
                    try {
                        try {
                            if (com.uc.crashsdk.b.d) {
                                JNIBridge.set(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_TOAST, str);
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                            aVar = aVar2;
                            a(th, aVar);
                            if (j2 != 0) {
                                b(aVar);
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            if (!ag) {
                                r(str);
                            }
                            if (ag) {
                                strA = a(m(str));
                            } else {
                                strA = str;
                            }
                            b(strA, "java");
                            return str;
                        }
                    } catch (Throwable th5) {
                        com.uc.crashsdk.a.g.a(th5);
                    }
                    b(aVar2, str, S());
                    if (z2) {
                        try {
                            aVar2.flush();
                        } catch (Throwable th6) {
                            com.uc.crashsdk.a.g.a(th6);
                        }
                    }
                    try {
                        aVar2.write(("Process Name: '" + h() + "'\n").getBytes("UTF-8"));
                        aVar2.write(("Thread Name: '" + Thread.currentThread().getName() + "'\n").getBytes("UTF-8"));
                    } catch (Throwable th7) {
                        com.uc.crashsdk.a.g.a(th7);
                    }
                    try {
                        aVar2.write("Back traces starts.\n".getBytes("UTF-8"));
                        try {
                            Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(th);
                            if (obj != null) {
                                declaredField.set(th, ((String) obj).replaceAll("\n\t", "\n->  "));
                            }
                        } catch (Throwable th8) {
                            com.uc.crashsdk.a.g.a(th8);
                        }
                        String message = th.getMessage();
                        if (message != null && !message.equals(th.getLocalizedMessage())) {
                            aVar2.write(("Message: " + message + "\n").getBytes("UTF-8"));
                        }
                    } catch (Throwable th9) {
                        com.uc.crashsdk.a.g.a(th9);
                    }
                    try {
                        th.printStackTrace(new PrintStream(aVar2));
                    } catch (Throwable th10) {
                        com.uc.crashsdk.a.g.a(th10);
                    }
                    try {
                        aVar2.write("Back traces ends.\n".getBytes("UTF-8"));
                    } catch (Throwable th11) {
                        com.uc.crashsdk.a.g.a(th11);
                    }
                    a((OutputStream) aVar2);
                    try {
                        aVar2.flush();
                    } catch (Throwable th12) {
                        com.uc.crashsdk.a.g.a(th12);
                    }
                    try {
                        com.uc.crashsdk.a.a(aVar2, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    } catch (Throwable th13) {
                        com.uc.crashsdk.a.g.a(th13);
                    }
                    if (z2) {
                        try {
                            aVar2.flush();
                        } catch (Throwable th14) {
                            com.uc.crashsdk.a.g.a(th14);
                        }
                    }
                    try {
                        aVar2.write("meminfo:\n".getBytes("UTF-8"));
                        b(aVar2, "/proc/meminfo", 10240);
                    } catch (Throwable th15) {
                        a(th15, aVar2);
                    }
                    try {
                        String str7 = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
                        aVar2.write("status:\n".getBytes("UTF-8"));
                        b(aVar2, str7, 10240);
                    } catch (Throwable th16) {
                        a(th16, aVar2);
                    }
                    try {
                        aVar2.write(("memory info:\n" + g()).getBytes("UTF-8"));
                    } catch (Throwable th17) {
                        a(th17, aVar2);
                    }
                    a((OutputStream) aVar2);
                    f(aVar2);
                    try {
                        com.uc.crashsdk.a.a(aVar2, "UTF-8", (ArrayList<String>) null);
                    } catch (Throwable th18) {
                        a(th18, aVar2);
                    }
                    if (ag) {
                        h = false;
                        try {
                            aVar2.write(s("JAVADUMPFILES").getBytes("UTF-8"));
                        } catch (Throwable th19) {
                            a(th19, aVar2);
                        }
                        h = true;
                    }
                    try {
                        aVar2.flush();
                    } catch (Throwable th20) {
                        com.uc.crashsdk.a.g.a(th20);
                    }
                    b((OutputStream) aVar2);
                    try {
                        aVar2.flush();
                    } catch (Throwable th21) {
                        com.uc.crashsdk.a.g.a(th21);
                    }
                    try {
                        aVar2.write("battery info:\n".getBytes("UTF-8"));
                    } catch (Throwable th22) {
                        a(th22, aVar2);
                    }
                    try {
                        if (ag) {
                            h = false;
                            aVar2.write(s("BATTERYINFO").getBytes("UTF-8"));
                            h = true;
                        } else {
                            StringBuilder sbY = Y();
                            if (sbY != null) {
                                aVar2.write(sbY.toString().getBytes("UTF-8"));
                            }
                        }
                    } catch (Throwable th23) {
                        a(th23, aVar2);
                    }
                    a((OutputStream) aVar2);
                    try {
                        aVar2.write("disk info:\n".getBytes("UTF-8"));
                    } catch (Throwable th24) {
                        a(th24, aVar2);
                    }
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        if (!ag) {
                                            try {
                                                HashSet hashSet = new HashSet();
                                                String strA2 = a(new File(com.uc.crashsdk.a.g.b()));
                                                if (!com.uc.crashsdk.a.g.a(strA2) && !hashSet.contains(strA2) && !strA2.equals("/storage/emulated")) {
                                                    hashSet.add(strA2);
                                                    try {
                                                        StatFs statFs = new StatFs(strA2);
                                                        long jA = a(statFs, "getBlockCountLong", "getBlockCount");
                                                        long jA2 = a(statFs, "getBlockSizeLong", "getBlockSize");
                                                        if ((jA / 1024) * jA2 >= 10240) {
                                                            fileOutputStream = fileOutputStream2;
                                                            try {
                                                                long jA3 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                                                                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                                                                try {
                                                                    long jA4 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                                                                    try {
                                                                        str6 = "\n";
                                                                        str3 = "su permission: ";
                                                                        try {
                                                                            aVar2.write(String.format(Locale.US, "%s:\n", strA2).getBytes("UTF-8"));
                                                                            Locale locale = Locale.US;
                                                                            Object[] objArr = new Object[1];
                                                                            str4 = "build tags: ";
                                                                            double d2 = jA2;
                                                                            try {
                                                                                objArr[0] = Long.valueOf((long) (((jA * 1.0d) * d2) / 1024.0d));
                                                                                aVar2.write(String.format(locale, "  total:      %d kB\n", objArr).getBytes("UTF-8"));
                                                                                aVar2.write(String.format(Locale.US, "  available:  %d kB\n", Long.valueOf((long) (((jA3 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                                                                                aVar2.write(String.format(Locale.US, "  free:       %d kB\n", Long.valueOf((long) (((jA4 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                                                                                aVar2.write(String.format(Locale.US, "  block size: %d B\n\n", Long.valueOf(jA2)).getBytes("UTF-8"));
                                                                            } catch (Throwable th25) {
                                                                                th = th25;
                                                                                try {
                                                                                    a(th, aVar2);
                                                                                } catch (Throwable th26) {
                                                                                    th = th26;
                                                                                    try {
                                                                                        a(th, aVar2);
                                                                                    } catch (Throwable th27) {
                                                                                        th = th27;
                                                                                        aVar = aVar2;
                                                                                        a(th, aVar);
                                                                                        if (j2 != 0) {
                                                                                            b(aVar);
                                                                                        }
                                                                                        com.uc.crashsdk.a.g.a(aVar);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (Throwable th28) {
                                                                            th = th28;
                                                                            str4 = "build tags: ";
                                                                            a(th, aVar2);
                                                                            a((OutputStream) aVar2);
                                                                            aVar2.write("device status:\n".getBytes("UTF-8"));
                                                                            if (ag) {
                                                                                try {
                                                                                    h = false;
                                                                                    aVar2.write(s("DEVICESTATUS").getBytes("UTF-8"));
                                                                                    h = true;
                                                                                } catch (Throwable th29) {
                                                                                    th = th29;
                                                                                    a(th, aVar2);
                                                                                }
                                                                            } else {
                                                                                try {
                                                                                    aVar2.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                                                                                    String str8 = Build.TAGS != null ? Build.TAGS : "";
                                                                                    sb = new StringBuilder(str4);
                                                                                    sb.append(str8);
                                                                                    if (com.uc.crashsdk.a.g.f()) {
                                                                                        sb.append(" (default root)");
                                                                                    }
                                                                                    sb.append(str6);
                                                                                    aVar2.write(sb.toString().getBytes("UTF-8"));
                                                                                    strH = com.uc.crashsdk.a.g.h();
                                                                                    if (com.uc.crashsdk.a.g.b(strH)) {
                                                                                        aVar2.write(String.format(Locale.US, "su binary: %s\n", strH).getBytes("UTF-8"));
                                                                                        StringBuilder sb2 = new StringBuilder(str3);
                                                                                        if (com.uc.crashsdk.a.g.g()) {
                                                                                            str5 = "valid (";
                                                                                        } else {
                                                                                            str5 = "invalid (";
                                                                                        }
                                                                                        sb2.append(str5);
                                                                                        sb2.append(com.uc.crashsdk.a.g.i());
                                                                                        sb2.append(")\n");
                                                                                        aVar2.write(sb2.toString().getBytes("UTF-8"));
                                                                                    }
                                                                                } catch (Throwable th30) {
                                                                                    th = th30;
                                                                                    a(th, aVar2);
                                                                                }
                                                                            }
                                                                            a((OutputStream) aVar2);
                                                                            c(aVar2);
                                                                            d(aVar2);
                                                                            String str9 = str2;
                                                                            com.uc.crashsdk.a.b(aVar2, "UTF-8", str9, null);
                                                                            if (ag) {
                                                                                h = false;
                                                                                try {
                                                                                    aVar2.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                                                                                } catch (Throwable th31) {
                                                                                    a(th31, aVar2);
                                                                                }
                                                                                h = true;
                                                                            }
                                                                            aVar2.flush();
                                                                            com.uc.crashsdk.a.a(aVar2, "UTF-8", str9, null);
                                                                            if (ag) {
                                                                                h = false;
                                                                                try {
                                                                                    aVar2.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                                                                                } catch (Throwable th32) {
                                                                                    a(th32, aVar2);
                                                                                }
                                                                                h = true;
                                                                            }
                                                                            aVar2.a();
                                                                            a(aVar2);
                                                                            aVar2.flush();
                                                                            if (j2 != 0) {
                                                                                b(aVar2);
                                                                            }
                                                                            com.uc.crashsdk.a.g.a(aVar2);
                                                                            com.uc.crashsdk.a.g.a(fileOutputStream);
                                                                            if (!ag) {
                                                                                r(str);
                                                                            }
                                                                            if (ag) {
                                                                                strA = a(m(str));
                                                                            } else {
                                                                                strA = str;
                                                                            }
                                                                            b(strA, "java");
                                                                            return str;
                                                                        }
                                                                    } catch (Throwable th33) {
                                                                        th = th33;
                                                                        str6 = "\n";
                                                                        str3 = "su permission: ";
                                                                    }
                                                                } catch (Throwable th34) {
                                                                    th = th34;
                                                                    str3 = "su permission: ";
                                                                    str4 = "build tags: ";
                                                                    a(th, aVar2);
                                                                    a((OutputStream) aVar2);
                                                                    aVar2.write("device status:\n".getBytes("UTF-8"));
                                                                    if (ag) {
                                                                        h = false;
                                                                        aVar2.write(s("DEVICESTATUS").getBytes("UTF-8"));
                                                                        h = true;
                                                                    } else {
                                                                        aVar2.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                                                                        if (Build.TAGS != null) {
                                                                        }
                                                                        sb = new StringBuilder(str4);
                                                                        sb.append(str8);
                                                                        if (com.uc.crashsdk.a.g.f()) {
                                                                            sb.append(" (default root)");
                                                                        }
                                                                        sb.append(str6);
                                                                        aVar2.write(sb.toString().getBytes("UTF-8"));
                                                                        strH = com.uc.crashsdk.a.g.h();
                                                                        if (com.uc.crashsdk.a.g.b(strH)) {
                                                                            aVar2.write(String.format(Locale.US, "su binary: %s\n", strH).getBytes("UTF-8"));
                                                                            StringBuilder sb3 = new StringBuilder(str3);
                                                                            if (com.uc.crashsdk.a.g.g()) {
                                                                                str5 = "valid (";
                                                                            } else {
                                                                                str5 = "invalid (";
                                                                            }
                                                                            sb3.append(str5);
                                                                            sb3.append(com.uc.crashsdk.a.g.i());
                                                                            sb3.append(")\n");
                                                                            aVar2.write(sb3.toString().getBytes("UTF-8"));
                                                                        }
                                                                    }
                                                                    a((OutputStream) aVar2);
                                                                    c(aVar2);
                                                                    d(aVar2);
                                                                    String str10 = str2;
                                                                    com.uc.crashsdk.a.b(aVar2, "UTF-8", str10, null);
                                                                    if (ag) {
                                                                        h = false;
                                                                        aVar2.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                                                                        h = true;
                                                                    }
                                                                    aVar2.flush();
                                                                    com.uc.crashsdk.a.a(aVar2, "UTF-8", str10, null);
                                                                    if (ag) {
                                                                        h = false;
                                                                        aVar2.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                                                                        h = true;
                                                                    }
                                                                    aVar2.a();
                                                                    a(aVar2);
                                                                    aVar2.flush();
                                                                    if (j2 != 0) {
                                                                        b(aVar2);
                                                                    }
                                                                    com.uc.crashsdk.a.g.a(aVar2);
                                                                    com.uc.crashsdk.a.g.a(fileOutputStream);
                                                                    if (!ag) {
                                                                        r(str);
                                                                    }
                                                                    if (ag) {
                                                                        strA = a(m(str));
                                                                    } else {
                                                                        strA = str;
                                                                    }
                                                                    b(strA, "java");
                                                                    return str;
                                                                }
                                                            } catch (Throwable th35) {
                                                                th = th35;
                                                                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                                                            }
                                                        }
                                                    } catch (Throwable unused) {
                                                    }
                                                }
                                            } catch (Throwable th36) {
                                                th = th36;
                                                str6 = "\n";
                                                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                                                str3 = "su permission: ";
                                                str4 = "build tags: ";
                                                fileOutputStream = fileOutputStream2;
                                            }
                                            a((OutputStream) aVar2);
                                            aVar2.write("device status:\n".getBytes("UTF-8"));
                                            if (ag) {
                                                h = false;
                                                aVar2.write(s("DEVICESTATUS").getBytes("UTF-8"));
                                                h = true;
                                            } else {
                                                aVar2.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                                                if (Build.TAGS != null) {
                                                }
                                                sb = new StringBuilder(str4);
                                                sb.append(str8);
                                                if (com.uc.crashsdk.a.g.f()) {
                                                    sb.append(" (default root)");
                                                }
                                                sb.append(str6);
                                                aVar2.write(sb.toString().getBytes("UTF-8"));
                                                strH = com.uc.crashsdk.a.g.h();
                                                if (com.uc.crashsdk.a.g.b(strH)) {
                                                    aVar2.write(String.format(Locale.US, "su binary: %s\n", strH).getBytes("UTF-8"));
                                                    StringBuilder sb4 = new StringBuilder(str3);
                                                    if (com.uc.crashsdk.a.g.g()) {
                                                        str5 = "valid (";
                                                    } else {
                                                        str5 = "invalid (";
                                                    }
                                                    sb4.append(str5);
                                                    sb4.append(com.uc.crashsdk.a.g.i());
                                                    sb4.append(")\n");
                                                    aVar2.write(sb4.toString().getBytes("UTF-8"));
                                                }
                                            }
                                            a((OutputStream) aVar2);
                                            c(aVar2);
                                            d(aVar2);
                                            String str11 = str2;
                                            com.uc.crashsdk.a.b(aVar2, "UTF-8", str11, null);
                                            if (ag) {
                                                h = false;
                                                aVar2.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                                                h = true;
                                            }
                                            aVar2.flush();
                                            com.uc.crashsdk.a.a(aVar2, "UTF-8", str11, null);
                                            if (ag) {
                                                h = false;
                                                aVar2.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                                                h = true;
                                            }
                                            aVar2.a();
                                            a(aVar2);
                                            aVar2.flush();
                                            if (j2 != 0) {
                                                b(aVar2);
                                            }
                                            com.uc.crashsdk.a.g.a(aVar2);
                                            com.uc.crashsdk.a.g.a(fileOutputStream);
                                            if (!ag) {
                                                r(str);
                                            }
                                            if (ag) {
                                                strA = a(m(str));
                                            } else {
                                                strA = str;
                                            }
                                            b(strA, "java");
                                            return str;
                                        }
                                        h = false;
                                        try {
                                            aVar2.write(s("FSSTAT").getBytes("UTF-8"));
                                        } catch (Throwable th37) {
                                            a(th37, aVar2);
                                        }
                                        h = true;
                                        aVar2.flush();
                                    } catch (Throwable th38) {
                                        com.uc.crashsdk.a.g.a(th38);
                                    }
                                    com.uc.crashsdk.a.b(aVar2, "UTF-8", str11, null);
                                } catch (Throwable th39) {
                                    a(th39, aVar2);
                                }
                                aVar2.write("device status:\n".getBytes("UTF-8"));
                            } catch (Throwable th40) {
                                a(th40, aVar2);
                            }
                            com.uc.crashsdk.a.a(aVar2, "UTF-8", str11, null);
                        } catch (Throwable th41) {
                            a(th41, aVar2);
                        }
                        aVar2.flush();
                    } catch (Throwable th42) {
                        com.uc.crashsdk.a.g.a(th42);
                    }
                    str6 = "\n";
                    str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                    str3 = "su permission: ";
                    str4 = "build tags: ";
                    fileOutputStream = fileOutputStream2;
                    a((OutputStream) aVar2);
                    if (ag) {
                        h = false;
                        aVar2.write(s("DEVICESTATUS").getBytes("UTF-8"));
                        h = true;
                    } else {
                        aVar2.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                        if (Build.TAGS != null) {
                        }
                        sb = new StringBuilder(str4);
                        sb.append(str8);
                        if (com.uc.crashsdk.a.g.f()) {
                            sb.append(" (default root)");
                        }
                        sb.append(str6);
                        aVar2.write(sb.toString().getBytes("UTF-8"));
                        strH = com.uc.crashsdk.a.g.h();
                        if (com.uc.crashsdk.a.g.b(strH)) {
                            aVar2.write(String.format(Locale.US, "su binary: %s\n", strH).getBytes("UTF-8"));
                            StringBuilder sb5 = new StringBuilder(str3);
                            if (com.uc.crashsdk.a.g.g()) {
                                str5 = "valid (";
                            } else {
                                str5 = "invalid (";
                            }
                            sb5.append(str5);
                            sb5.append(com.uc.crashsdk.a.g.i());
                            sb5.append(")\n");
                            aVar2.write(sb5.toString().getBytes("UTF-8"));
                        }
                    }
                    a((OutputStream) aVar2);
                    c(aVar2);
                    d(aVar2);
                    String str12 = str2;
                    if (ag) {
                        h = false;
                        aVar2.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                        h = true;
                    }
                    if (ag) {
                        h = false;
                        aVar2.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                        h = true;
                    }
                    aVar2.a();
                    a(aVar2);
                    if (j2 != 0) {
                        b(aVar2);
                    }
                    com.uc.crashsdk.a.g.a(aVar2);
                } catch (Throwable th43) {
                    th = th43;
                    fileOutputStream = fileOutputStream2;
                    aVar = null;
                }
            } catch (Throwable th44) {
                th = th44;
                aVar = null;
                fileOutputStream = null;
            }
            if (ag) {
                strA = a(m(str));
            } else {
                strA = str;
            }
            b(strA, "java");
        } catch (Throwable th45) {
            com.uc.crashsdk.a.g.a(th45);
        }
        com.uc.crashsdk.a.g.a(fileOutputStream);
        if (!ag) {
            r(str);
        }
        return str;
    }

    private static void f(OutputStream outputStream) {
        String strM;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ag) {
                strM = s("LASTVER");
            } else {
                strM = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", strM).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = s;
            synchronized (arrayList) {
                if (u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", u).getBytes("UTF-8"));
                }
                if (t > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(t)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(v)).getBytes("UTF-8"));
            if (w != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", w).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static String m(String str) {
        String strA = com.uc.crashsdk.a.b.a(str, g.x(), g.w());
        if (!str.equals(strA)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return strA;
    }

    static String a(String str) {
        int iLastIndexOf;
        int iIndexOf;
        int i2;
        int iIndexOf2;
        String strD;
        File file;
        byte[] bArrE;
        byte[] bArrB;
        if (!g.y() || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (iIndexOf = str.indexOf(95, iLastIndexOf)) <= iLastIndexOf || (iIndexOf2 = str.indexOf(95, (i2 = iIndexOf + 1))) <= iIndexOf || (strD = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(iLastIndexOf + 1, iIndexOf) + str.substring(i2, iIndexOf2))) == null || (bArrE = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || bArrE.length <= 0) {
            return str;
        }
        try {
            bArrB = com.uc.crashsdk.a.c.b(bArrE, strD.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            bArrB = null;
        }
        if (bArrB == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!com.uc.crashsdk.a.g.a(file2, bArrB)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Code duplicated, block: B:112:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:113:0x0308 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x030c  */
    /* JADX WARN: Code duplicated, block: B:116:0x0316 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x031a  */
    /* JADX WARN: Code duplicated, block: B:119:0x0327 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0335 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0342 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0346  */
    /* JADX WARN: Code duplicated, block: B:129:0x0355  */
    /* JADX WARN: Code duplicated, block: B:132:0x0362 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x037c A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0390 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0397 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x03b9 A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x03be A[Catch: all -> 0x044d, TryCatch #4 {all -> 0x044d, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0035, B:11:0x003b, B:12:0x004f, B:14:0x005f, B:16:0x0067, B:147:0x03d8, B:18:0x006f, B:20:0x007f, B:22:0x0091, B:25:0x00b3, B:27:0x00c3, B:31:0x00d0, B:42:0x00fc, B:38:0x00ee, B:62:0x01ce, B:64:0x01e2, B:66:0x01e6, B:67:0x01e8, B:69:0x01ed, B:70:0x01ef, B:71:0x01f4, B:81:0x0218, B:82:0x022f, B:84:0x0235, B:86:0x023e, B:88:0x024b, B:90:0x026a, B:91:0x027d, B:93:0x028f, B:95:0x029f, B:96:0x02b1, B:110:0x02f7, B:113:0x0308, B:116:0x0316, B:119:0x0327, B:121:0x0335, B:123:0x0342, B:126:0x0349, B:130:0x0356, B:132:0x0362, B:134:0x037c, B:135:0x0381, B:137:0x0390, B:139:0x039d, B:145:0x03c6, B:150:0x03ec, B:152:0x03f3, B:154:0x03fa, B:156:0x0401, B:158:0x0408, B:160:0x040f, B:166:0x0421, B:168:0x0428, B:170:0x042f, B:172:0x0436, B:164:0x041a, B:138:0x0397, B:140:0x03b9, B:142:0x03be, B:98:0x02b9, B:100:0x02bf, B:103:0x02c7, B:105:0x02cb, B:107:0x02e0, B:109:0x02e4, B:75:0x01ff, B:77:0x020d, B:79:0x0213, B:61:0x01cb, B:173:0x043e), top: B:195:0x000a, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:201:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x01bf  */
    private static void a(String str, boolean z2, boolean z3) {
        ConditionVariable conditionVariable;
        int i2;
        boolean z4;
        boolean z5;
        File[] fileArr;
        int i3;
        int i4;
        String str2;
        String name;
        String str3;
        boolean z6;
        String[] strArrSplit;
        File file;
        com.uc.crashsdk.a.a.a("crashsdk", "crashsdk uploading logs");
        synchronized (n) {
            try {
                try {
                    if (com.uc.crashsdk.a.g.b(str)) {
                        String strY = g.Y();
                        File file2 = new File(strY);
                        if (file2.exists()) {
                            File[] fileArrListFiles = file2.listFiles();
                            if (fileArrListFiles == null) {
                                com.uc.crashsdk.a.a.b("List folder failed: " + strY);
                            } else {
                                int length = fileArrListFiles.length;
                                int i5 = 0;
                                int i6 = 0;
                                int i7 = 0;
                                int i8 = 0;
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                int i12 = 0;
                                int i13 = 0;
                                boolean z7 = false;
                                boolean z8 = false;
                                boolean z9 = false;
                                while (true) {
                                    if (i5 >= length) {
                                        i2 = i8;
                                        z4 = z7;
                                        z5 = z8;
                                        break;
                                    }
                                    File file3 = fileArrListFiles[i5];
                                    if (file3.isFile()) {
                                        String name2 = file3.getName();
                                        fileArr = fileArrListFiles;
                                        if (name2.endsWith(".tmp")) {
                                            if ((System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                                com.uc.crashsdk.a.a.b("delete legacy tmp file: " + name2);
                                                i7++;
                                                com.uc.crashsdk.a.g.a(file3);
                                            }
                                            i3 = i11;
                                            z4 = z7;
                                        } else {
                                            length = length;
                                            z4 = z7;
                                            z5 = z8;
                                            if (file3.length() == 0) {
                                                i6++;
                                                com.uc.crashsdk.a.g.a(file3);
                                            } else {
                                                if (z2) {
                                                    long jCurrentTimeMillis = (System.currentTimeMillis() - file3.lastModified()) / 1000;
                                                    boolean z10 = jCurrentTimeMillis < 0 || (jCurrentTimeMillis >= 2 && (jCurrentTimeMillis >= 5 || !file3.getName().endsWith(com.anythink.dlopt.common.a.a.g)));
                                                    com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(jCurrentTimeMillis), Boolean.valueOf(z10)));
                                                    if (!z10) {
                                                        i8++;
                                                    }
                                                }
                                                try {
                                                    if (g.l()) {
                                                        Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                                        if (matcher.matches()) {
                                                            i2 = i8;
                                                            try {
                                                                file = new File(g.Y() + String.format(Locale.US, "%s%s_%s_%s.%s", j(matcher.group(2)), n(), Q(), matcher.group(1), matcher.group(3)));
                                                                com.uc.crashsdk.a.a.a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                                file3.renameTo(file);
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                com.uc.crashsdk.a.g.a(th);
                                                            }
                                                        } else {
                                                            i2 = i8;
                                                            file = file3;
                                                        }
                                                    } else {
                                                        i2 = i8;
                                                        file = file3;
                                                    }
                                                    if (file != file3) {
                                                        i12++;
                                                    }
                                                    file3 = file;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    i2 = i8;
                                                }
                                                String path = file3.getPath();
                                                boolean[] zArrN = n(path);
                                                String strB = b(path, zArrN[0], zArrN[1]);
                                                if (path != strB) {
                                                    if (zArrN[0]) {
                                                        i11++;
                                                    }
                                                    if (zArrN[1]) {
                                                        i9++;
                                                    }
                                                    file3 = new File(strB);
                                                }
                                                File fileA = com.uc.crashsdk.d.a(file3);
                                                if (fileA == null) {
                                                    fileA = null;
                                                } else if (file3 != fileA && !file3.getName().equals(fileA.getName()) && file3.exists()) {
                                                    file3.delete();
                                                }
                                                if (fileA == null) {
                                                    com.uc.crashsdk.a.a.b("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                                } else {
                                                    int iC = g.C();
                                                    if (iC <= 0 || fileA.length() < iC) {
                                                        d dVar = new d((byte) 0);
                                                        dVar.b = 0L;
                                                        dVar.a = System.currentTimeMillis();
                                                        String strU = U();
                                                        if (new File(strU).exists()) {
                                                            a(strU, new com.uc.crashsdk.a.e(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, new Object[]{strU, dVar}));
                                                        }
                                                        long jD = g.D();
                                                        int iE = g.E();
                                                        int iF = g.F();
                                                        if (jD >= 0) {
                                                            i3 = i11;
                                                            i4 = i12;
                                                            if (dVar.b + fileA.length() > jD) {
                                                                dVar.e = true;
                                                                str2 = "Reach max upload bytes: " + jD;
                                                            }
                                                            com.uc.crashsdk.a.a.b(str2);
                                                            if (dVar.e) {
                                                                i12 = i4;
                                                                z8 = z5;
                                                                i8 = i2;
                                                                z4 = true;
                                                            } else if (dVar.g) {
                                                                i12 = i4;
                                                                i8 = i2;
                                                                z8 = true;
                                                            } else if (dVar.f) {
                                                                i12 = i4;
                                                                z8 = z5;
                                                                i8 = i2;
                                                                z9 = true;
                                                            } else {
                                                                name = fileA.getName();
                                                                if (name.startsWith(P())) {
                                                                    strArrSplit = name.split("_", 10);
                                                                    if (strArrSplit.length == 9) {
                                                                        str3 = strArrSplit[1];
                                                                    } else {
                                                                        str3 = null;
                                                                    }
                                                                } else {
                                                                    str3 = null;
                                                                }
                                                                if (str3 == null && str3.equals(g.U())) {
                                                                    z6 = true;
                                                                } else {
                                                                    z6 = false;
                                                                }
                                                                if (com.uc.crashsdk.a.c.a(fileA, fileA.getName(), str)) {
                                                                    com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + fileA.getName(), null);
                                                                    if (z6) {
                                                                        f.a(13);
                                                                    }
                                                                    dVar.b += fileA.length();
                                                                    if (b(fileA)) {
                                                                        dVar.c++;
                                                                    } else {
                                                                        dVar.d++;
                                                                    }
                                                                    String strU2 = U();
                                                                    a(strU2, new com.uc.crashsdk.a.e(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME, new Object[]{strU2, dVar}));
                                                                    fileA.delete();
                                                                    i13 = 0;
                                                                } else {
                                                                    i13++;
                                                                    if (z6) {
                                                                        f.a(14);
                                                                    }
                                                                }
                                                                if (i13 >= 3) {
                                                                    com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                    i12 = i4;
                                                                    i11 = i3;
                                                                    break;
                                                                } else {
                                                                    i12 = i4;
                                                                    z8 = z5;
                                                                    i8 = i2;
                                                                }
                                                            }
                                                        } else {
                                                            i3 = i11;
                                                            i4 = i12;
                                                        }
                                                        if (!g.f()) {
                                                            if (b(fileA)) {
                                                                if (iE >= 0 && dVar.c >= iE) {
                                                                    dVar.g = true;
                                                                    str2 = "Reach max upload builtin log count: " + iE;
                                                                    com.uc.crashsdk.a.a.b(str2);
                                                                }
                                                            } else if (iF >= 0 && dVar.d >= iF) {
                                                                dVar.f = true;
                                                                str2 = "Reach max upload custom log count: " + iF;
                                                                com.uc.crashsdk.a.a.b(str2);
                                                            }
                                                        }
                                                        if (dVar.e) {
                                                            i12 = i4;
                                                            z8 = z5;
                                                            i8 = i2;
                                                            z4 = true;
                                                        } else if (dVar.g) {
                                                            i12 = i4;
                                                            i8 = i2;
                                                            z8 = true;
                                                        } else if (dVar.f) {
                                                            i12 = i4;
                                                            z8 = z5;
                                                            i8 = i2;
                                                            z9 = true;
                                                        } else {
                                                            name = fileA.getName();
                                                            if (name.startsWith(P())) {
                                                                strArrSplit = name.split("_", 10);
                                                                if (strArrSplit.length == 9) {
                                                                    str3 = strArrSplit[1];
                                                                } else {
                                                                    str3 = null;
                                                                }
                                                            } else {
                                                                str3 = null;
                                                            }
                                                            if (str3 == null) {
                                                                z6 = false;
                                                            } else {
                                                                z6 = false;
                                                            }
                                                            if (com.uc.crashsdk.a.c.a(fileA, fileA.getName(), str)) {
                                                                com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + fileA.getName(), null);
                                                                if (z6) {
                                                                    f.a(13);
                                                                }
                                                                dVar.b += fileA.length();
                                                                if (b(fileA)) {
                                                                    dVar.c++;
                                                                } else {
                                                                    dVar.d++;
                                                                }
                                                                String strU3 = U();
                                                                a(strU3, new com.uc.crashsdk.a.e(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME, new Object[]{strU3, dVar}));
                                                                fileA.delete();
                                                                i13 = 0;
                                                            } else {
                                                                i13++;
                                                                if (z6) {
                                                                    f.a(14);
                                                                }
                                                            }
                                                            if (i13 >= 3) {
                                                                com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                i12 = i4;
                                                                i11 = i3;
                                                                break;
                                                            } else {
                                                                i12 = i4;
                                                                z8 = z5;
                                                                i8 = i2;
                                                            }
                                                        }
                                                    } else {
                                                        i10++;
                                                        com.uc.crashsdk.a.g.a(fileA);
                                                    }
                                                }
                                                i3 = i11;
                                                z8 = z5;
                                                i8 = i2;
                                            }
                                            i3 = i11;
                                            z8 = z5;
                                        }
                                        i5++;
                                        fileArrListFiles = fileArr;
                                        i11 = i3;
                                        length = length;
                                        z7 = z4;
                                    } else {
                                        com.uc.crashsdk.a.g.a(file3);
                                        fileArr = fileArrListFiles;
                                    }
                                    i3 = i11;
                                    z4 = z7;
                                    i5++;
                                    fileArrListFiles = fileArr;
                                    i11 = i3;
                                    length = length;
                                    z7 = z4;
                                }
                                if (i7 > 0) {
                                    f.a(200, i7);
                                }
                                if (i6 > 0) {
                                    f.a(15, i6);
                                }
                                if (i10 > 0) {
                                    f.a(17, i10);
                                }
                                if (z4) {
                                    f.a(19);
                                }
                                if (z5) {
                                    f.a(20);
                                }
                                if (z9) {
                                    f.a(21);
                                }
                                if (z4 || z5 || z9) {
                                    f.a(18);
                                }
                                if (i11 > 0) {
                                    f.a(24, i11);
                                }
                                if (i9 > 0) {
                                    f.a(201, i9);
                                }
                                if (i12 > 0) {
                                    f.a(25, i12);
                                }
                                if (i2 > 0) {
                                    f.a(26, i2);
                                }
                            }
                        } else {
                            com.uc.crashsdk.a.a.a("crashsdk", "Folder not exist: " + strY);
                        }
                    } else {
                        com.uc.crashsdk.a.a.a("crashsdk", "upload url is empty!");
                    }
                    if (z3) {
                        conditionVariable = o;
                        conditionVariable.open();
                    }
                } catch (Throwable th3) {
                    try {
                        com.uc.crashsdk.a.g.a(th3);
                        if (z3) {
                            conditionVariable = o;
                        }
                    } catch (Throwable th4) {
                        if (!z3) {
                            throw th4;
                        }
                        o.open();
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    static boolean i() {
        return d;
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String strK = k();
            if (com.uc.crashsdk.a.g.a(strK)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{strK, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                ConditionVariable conditionVariable = o;
                conditionVariable.close();
                if (!conditionVariable.block(com.tapsdk.tapad.e.a.f)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    static void b(boolean z2) {
        try {
            boolean zT = g.s() && com.uc.crashsdk.b.F() && !d;
            if (!zT) {
                zT = g.t();
            }
            if (zT) {
                if (z2) {
                    String strK = k();
                    if (com.uc.crashsdk.a.g.a(strK)) {
                        return;
                    }
                    j();
                    a(strK, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static String U() {
        return g.X() + "bytes";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean zA;
        FileChannel channel;
        Exception e;
        synchronized (p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            ?? r5 = 0;
            fileLockLock = null;
            FileLock fileLockLock = null;
            zA = false;
            try {
                try {
                    try {
                        channel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r5 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r5);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        channel = null;
                    } catch (Exception e4) {
                        channel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(channel);
                        return zA;
                    }
                }
                if (channel != null) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                        }
                    }
                }
                try {
                    zA = eVar.a();
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                    com.uc.crashsdk.a.g.a(channel);
                } catch (Throwable th2) {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (Exception e8) {
                            com.uc.crashsdk.a.g.a(e8);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return zA;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class d {
        long a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static boolean a(String str, d dVar) {
        String strA = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (strA == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(strA);
            if (matcher.find()) {
                long j2 = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - j2 < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.a = j2;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    private static boolean b(File file) {
        int iIndexOf;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(95);
        if (iLastIndexOf <= 0 || (iIndexOf = name.indexOf(46, iLastIndexOf)) <= 0) {
            return false;
        }
        String strSubstring = name.substring(iLastIndexOf + 1, iIndexOf);
        return "java".equals(strSubstring) || "ucebujava".equals(strSubstring) || "jni".equals(strSubstring) || "ucebujni".equals(strSubstring) || LogType.UNEXP_TYPE.equals(strSubstring) || "anr".equals(strSubstring);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    private static boolean[] n(String str) {
        int i2;
        boolean zW = g.w();
        boolean zY = g.y();
        if (zW || zY) {
            if (str.endsWith(".tmp") || str.contains(".ec")) {
                zW = false;
                zY = false;
            } else {
                int iLastIndexOf = str.lastIndexOf(File.separatorChar);
                if (iLastIndexOf < 0) {
                    iLastIndexOf = 0;
                    i2 = 0;
                } else {
                    i2 = 0;
                }
                do {
                    iLastIndexOf = str.indexOf(95, iLastIndexOf);
                    if (iLastIndexOf >= 0) {
                        i2++;
                        iLastIndexOf++;
                    }
                } while (iLastIndexOf >= 0);
                if (i2 != 8) {
                    zW = false;
                    zY = false;
                } else {
                    String strX = g.x();
                    if (!str.endsWith(com.anythink.dlopt.common.a.a.g)) {
                        if (com.uc.crashsdk.a.g.a(strX) || !str.endsWith(strX)) {
                            zW = false;
                            zY = false;
                        }
                    } else if (com.uc.crashsdk.a.g.a(strX) || str.indexOf(com.anythink.dlopt.common.a.a.g, str.lastIndexOf(95)) != str.lastIndexOf(com.anythink.dlopt.common.a.a.g)) {
                    }
                    zW = false;
                }
            }
        }
        return new boolean[]{zW, zY};
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean zA;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ag || com.uc.crashsdk.b.L();
        if (!z3 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String strA = g.Y() + k(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long jNativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(strA, "custom", str, r11) : 0L;
            if (jNativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = jNativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (q) {
            z2 = r11;
            zA = a(strA, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (zA && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!zA) {
            return false;
        }
        if (!z3) {
            r(strA);
        }
        if (!z3) {
            strA = a(m(strA));
        }
        b(strA, str);
        if (z2 == 0 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    static boolean a(String str, String str2, boolean z2) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static boolean o(String str) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (r) {
            File file = new File(g.X() + "customlog");
            String strA = com.uc.crashsdk.a.g.a(file, 1024, false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (strA == null) {
                z2 = false;
                z3 = false;
                break;
            }
            stringBuffer.append(strA);
            Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
            int iEnd = 0;
            while (true) {
                if (!matcher.find(iEnd)) {
                    z2 = false;
                    z3 = false;
                    break;
                }
                if (!str.equals(matcher.group(1))) {
                    iEnd = matcher.end();
                } else {
                    long j2 = Long.parseLong(matcher.group(2));
                    if (jCurrentTimeMillis - j2 < 86400000) {
                        try {
                            i2 = Integer.parseInt(matcher.group(3));
                        } catch (Exception e) {
                            com.uc.crashsdk.a.g.a(e);
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                        j2 = jCurrentTimeMillis;
                    }
                    int iG = g.G();
                    z3 = iG >= 0 && i2 >= iG;
                    stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(j2), Integer.valueOf(i2 + 1)));
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(jCurrentTimeMillis)));
            }
            ?? r1 = 0;
            FileWriter fileWriter = null;
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        String string = stringBuffer.toString();
                        int length = string.length();
                        fileWriter2.write(string, 0, length);
                        com.uc.crashsdk.a.g.a(fileWriter2);
                        r1 = length;
                    } catch (Exception e2) {
                        e = e2;
                        fileWriter = fileWriter2;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileWriter);
                        r1 = fileWriter;
                    } catch (Throwable th) {
                        th = th;
                        r1 = fileWriter2;
                        com.uc.crashsdk.a.g.a((Closeable) r1);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return z3;
    }

    private static void a(a aVar, String str, long j2) {
        String strNativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            strNativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ag || strNativeDumpThreads == null || strNativeDumpThreads.length() >= 512 || !strNativeDumpThreads.startsWith("/") || strNativeDumpThreads.indexOf(10) >= 0) {
                str2 = strNativeDumpThreads;
            } else {
                str2 = strNativeDumpThreads;
                strNativeDumpThreads = new File(strNativeDumpThreads).exists() ? null : "Can not found " + strNativeDumpThreads;
            }
        } else {
            strNativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (strNativeDumpThreads != null) {
            try {
                aVar.write(strNativeDumpThreads.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !ag) {
            b(aVar, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0039 */
    /* JADX WARN: Code duplicated, block: B:100:0x012d A[Catch: all -> 0x0058, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0135 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x014f A[Catch: all -> 0x0177, TryCatch #9 {all -> 0x0177, blocks: (B:108:0x0145, B:110:0x014f, B:112:0x0159, B:113:0x015c, B:115:0x0160, B:116:0x0167, B:117:0x0169, B:119:0x016d, B:120:0x0175), top: B:150:0x0145, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0159 A[Catch: all -> 0x0177, TryCatch #9 {all -> 0x0177, blocks: (B:108:0x0145, B:110:0x014f, B:112:0x0159, B:113:0x015c, B:115:0x0160, B:116:0x0167, B:117:0x0169, B:119:0x016d, B:120:0x0175), top: B:150:0x0145, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0160 A[Catch: all -> 0x0177, TryCatch #9 {all -> 0x0177, blocks: (B:108:0x0145, B:110:0x014f, B:112:0x0159, B:113:0x015c, B:115:0x0160, B:116:0x0167, B:117:0x0169, B:119:0x016d, B:120:0x0175), top: B:150:0x0145, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x016d A[Catch: all -> 0x0177, TryCatch #9 {all -> 0x0177, blocks: (B:108:0x0145, B:110:0x014f, B:112:0x0159, B:113:0x015c, B:115:0x0160, B:116:0x0167, B:117:0x0169, B:119:0x016d, B:120:0x0175), top: B:150:0x0145, outer: #12 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0043  */
    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:42:0x0084 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0090 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0092 A[Catch: all -> 0x0058, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x009f A[Catch: all -> 0x0058, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae A[Catch: all -> 0x0058, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:95:0x011a A[Catch: all -> 0x0058, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0122 A[Catch: all -> 0x0058, TryCatch #10 {all -> 0x0058, blocks: (B:32:0x0054, B:40:0x0079, B:42:0x0084, B:47:0x008d, B:49:0x0092, B:51:0x0098, B:53:0x009f, B:55:0x00a5, B:57:0x00ae, B:59:0x00b4, B:70:0x00d6, B:76:0x00e3, B:75:0x00e0, B:69:0x00d3, B:89:0x010b, B:94:0x0118, B:93:0x0115, B:88:0x0108, B:84:0x00f8, B:95:0x011a, B:97:0x0122, B:98:0x0125, B:100:0x012d, B:102:0x0135, B:65:0x00c3, B:39:0x0076, B:61:0x00bd, B:85:0x00fb, B:43:0x0087, B:66:0x00c6, B:90:0x010e, B:36:0x005b, B:80:0x00f2, B:71:0x00da), top: B:152:0x0054, inners: #1, #2, #3, #4, #5, #6, #7, #15 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r17, long r18, java.lang.StringBuffer r20, java.lang.String r21, long r22, java.util.ArrayList<java.lang.String> r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.lang.String r27) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    public static String k() {
        String strA = x;
        if (com.uc.crashsdk.a.g.a(strA)) {
            synchronized (y) {
                strA = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.z(), true);
                x = strA;
            }
        }
        return strA;
    }

    public static void b(String str) {
        synchronized (y) {
            x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    public static void l() {
        synchronized (y) {
            x = null;
        }
    }

    public static void c(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.l(), str + "\n");
        }
    }

    static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00ae A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00ae, B:50:0x00d4, B:57:0x00ef, B:53:0x00df, B:64:0x00fc, B:67:0x0106, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:72:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00df A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00ae, B:50:0x00d4, B:57:0x00ef, B:53:0x00df, B:64:0x00fc, B:67:0x0106, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:72:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ef A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00ae, B:50:0x00d4, B:57:0x00ef, B:53:0x00df, B:64:0x00fc, B:67:0x0106, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:72:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00f5  */
    private static boolean p(String str) {
        boolean z2;
        int iIntValue;
        Integer num;
        long j2;
        long j3;
        long jB;
        long jCurrentTimeMillis;
        synchronized (z) {
            z2 = false;
            if (A == null) {
                A = q(com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.l(), "all:1", false));
            }
            if (A.containsKey(Constants.e.c)) {
                num = A.get(Constants.e.c);
            } else if (A.containsKey(str)) {
                num = A.get(str);
            } else {
                boolean z3 = "java".equals(str) || "jni".equals(str) || "anr".equals(str) || LogType.UNEXP_TYPE.equals(str);
                if (z3 && A.containsKey("crash")) {
                    num = A.get("crash");
                } else if (z3 || !A.containsKey("nocrash")) {
                    if (A.containsKey(AdnName.OTHER)) {
                        num = A.get(AdnName.OTHER);
                    } else {
                        iIntValue = 1;
                    }
                    if (iIntValue != 0) {
                        j2 = iIntValue;
                        if (j2 < 0) {
                            if (j2 == -2) {
                                j3 = 7;
                            } else if (j2 == -3) {
                                j3 = 15;
                            } else if (j2 == -4) {
                                j3 = 60;
                            } else {
                                j3 = 30;
                            }
                            jB = com.uc.crashsdk.a.b();
                            if (jB == 0) {
                                jCurrentTimeMillis = -1;
                            } else {
                                jCurrentTimeMillis = (System.currentTimeMillis() - jB) / 86400000;
                            }
                            if (jCurrentTimeMillis <= j3) {
                                j2 = 1;
                            } else {
                                j2 = jCurrentTimeMillis - j3;
                            }
                        }
                        if (j2 != 1 || j2 <= 0 || System.currentTimeMillis() % j2 == 0) {
                            z2 = true;
                        }
                    }
                } else {
                    num = A.get("nocrash");
                }
            }
            iIntValue = num.intValue();
            if (iIntValue != 0) {
                j2 = iIntValue;
                if (j2 < 0) {
                    if (j2 == -2) {
                        j3 = 7;
                    } else if (j2 == -3) {
                        j3 = 15;
                    } else if (j2 == -4) {
                        j3 = 60;
                    } else {
                        j3 = 30;
                    }
                    jB = com.uc.crashsdk.a.b();
                    if (jB == 0) {
                        jCurrentTimeMillis = -1;
                    } else {
                        jCurrentTimeMillis = (System.currentTimeMillis() - jB) / 86400000;
                    }
                    if (jCurrentTimeMillis <= j3) {
                        j2 = 1;
                    } else {
                        j2 = jCurrentTimeMillis - j3;
                    }
                }
                if (j2 != 1) {
                    z2 = true;
                } else {
                    z2 = true;
                }
            }
        }
        return z2;
    }

    private static Map<String, Integer> q(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] strArrSplit = str2.split(":", 3);
            if (strArrSplit.length == 2) {
                String strTrim = strArrSplit[0].trim();
                if (!com.uc.crashsdk.a.g.a(strTrim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(strArrSplit[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    map.put(strTrim, Integer.valueOf(i2));
                }
            }
        }
        return map;
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_CODE), 1000L);
    }

    static String n() {
        return a(new Date());
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    private static void r(String str) {
        if (g.r()) {
            try {
                ab();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.Z());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0054 A[Catch: all -> 0x006d, TryCatch #2 {all -> 0x006d, blocks: (B:6:0x000a, B:8:0x002c, B:20:0x004e, B:22:0x0054, B:24:0x0065), top: B:34:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0065 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:6:0x000a, B:8:0x002c, B:20:0x004e, B:22:0x0054, B:24:0x0065), top: B:34:0x000a }] */
    public static void p() {
        String strA;
        Throwable th;
        if (com.uc.crashsdk.a.g.a(B)) {
            String string = null;
            try {
                File file = new File(g.X() + "unique");
                if (file.exists()) {
                    strA = com.uc.crashsdk.a.g.a(file, 48, false);
                    if (strA != null) {
                        try {
                            try {
                                if (strA.length() == 36) {
                                    string = strA.replaceAll("[^0-9a-zA-Z-]", "-");
                                }
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                                string = strA;
                                if (com.uc.crashsdk.a.g.a(string)) {
                                    com.uc.crashsdk.b.G();
                                    string = UUID.randomUUID().toString();
                                    if (!com.uc.crashsdk.a.g.a(string)) {
                                        com.uc.crashsdk.a.g.a(file, string.getBytes());
                                    }
                                }
                                B = string;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.uc.crashsdk.a.g.a(th);
                            string = strA;
                        }
                    } else {
                        string = strA;
                    }
                }
                if (com.uc.crashsdk.a.g.a(string)) {
                    com.uc.crashsdk.b.G();
                    string = UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.g.a(string)) {
                        com.uc.crashsdk.a.g.a(file, string.getBytes());
                    }
                }
            } catch (Throwable th3) {
                strA = string;
                th = th3;
            }
            B = string;
        }
    }

    public static String q() {
        return B;
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class c extends BroadcastReceiver {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                int unused = e.C = intent.getIntExtra("level", -1);
                int unused2 = e.D = intent.getIntExtra("scale", -1);
                int unused3 = e.E = intent.getIntExtra("voltage", -1);
                int unused4 = e.F = intent.getIntExtra("health", -1);
                int unused5 = e.G = intent.getIntExtra("plugged", -1);
                int unused6 = e.H = intent.getIntExtra("status", -1);
                int unused7 = e.I = intent.getIntExtra("temperature", -1);
                String unused8 = e.J = intent.getStringExtra("technology");
                if (e.J() >= 2) {
                    e.K();
                    e.L();
                    return;
                }
                return;
            }
            if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                boolean unused9 = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                e.K();
            } else if ("android.intent.action.ANR".equals(action)) {
                try {
                    e.d(context);
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                }
            }
        }
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT < 29;
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
            if (processErrorStateInfo.pid == iMyPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + processErrorStateInfo.processName);
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(130, processErrorStateInfo.longMsg);
                }
                z2 = true;
                break;
            }
        }
        if (!z2 && com.uc.crashsdk.b.d) {
            W();
        }
        return true;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_URL_CODE), 1000L);
    }

    private static StringBuilder Y() {
        String str;
        String str2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ").append(C).append("\nscale: ");
            sb.append(D).append("\nhealth: ");
            int i2 = F;
            String str3 = " (Unknown)";
            switch (i2) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append(i2).append(str).append("\npluged: ");
            int i3 = G;
            if (i3 == 0) {
                str2 = " (None)";
            } else if (i3 == 1) {
                str2 = " (AC charger)";
            } else if (i3 != 2) {
                str2 = i3 != 4 ? " (?)" : " (Wireless)";
            } else {
                str2 = " (USB port)";
            }
            sb.append(i3).append(str2).append("\nstatus: ");
            int i4 = H;
            if (i4 != 1) {
                if (i4 == 2) {
                    str3 = " (Charging)";
                } else if (i4 == 3) {
                    str3 = " (Discharging)";
                } else if (i4 != 4) {
                    str3 = i4 != 5 ? " (?)" : " (Full)";
                } else {
                    str3 = " (Not charging)";
                }
            }
            sb.append(i4).append(str3).append("\nvoltage: ");
            sb.append(E).append("\ntemperature: ");
            sb.append(I).append("\ntechnology: ");
            sb.append(J).append("\nbattery low: ");
            sb.append(K).append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, com.anythink.basead.exoplayer.i.a.f);
        }
    }

    public static void b(Context context) {
        if (g.N()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.N() : z2 && g.N()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, com.tapsdk.tapad.e.a.f);
        }
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    static boolean u() {
        return c.get() || aa();
    }

    /* JADX WARN: Code duplicated, block: B:169:0x0257  */
    /* JADX WARN: Code duplicated, block: B:212:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:267:0x037e  */
    /* JADX WARN: Code duplicated, block: B:312:0x0400  */
    /* JADX WARN: Code duplicated, block: B:373:0x0507  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:429:0x05c1 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:476:0x0649 A[FINALLY_INSNS] */
    /* JADX WARN: Code duplicated, block: B:486:0x0664 A[FINALLY_INSNS] */
    /* JADX WARN: Code duplicated, block: B:84:0x00fb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    public final void a(Thread thread, Throwable th, boolean z2) {
        boolean z3;
        ?? r12;
        boolean z4;
        boolean zI;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Throwable th2;
        boolean z5;
        boolean zS;
        boolean zU;
        String str;
        boolean z6;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        boolean z7;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        Throwable th3;
        boolean z8;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4;
        boolean z9;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler5;
        boolean z10;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler6;
        boolean z11;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler7;
        boolean z12;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler8;
        boolean z13 = (ag && com.uc.crashsdk.b.d) || com.uc.crashsdk.b.L();
        try {
            r12 = 4;
            if (c.getAndSet(true) && Process.myPid() > 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "another thread is generating java report!");
                com.uc.crashsdk.a.a.d("DEBUG", "current thread exception is:");
                a(th);
                if (g.j()) {
                    int i2 = 0;
                    while (!V) {
                        try {
                            Thread.sleep(1000L);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(th4);
                        }
                        i2++;
                        if (i2 >= 4) {
                            break;
                        }
                    }
                    Process.killProcess(Process.myPid());
                }
                if (z2) {
                    try {
                        if (!g.s() || z13) {
                            z12 = false;
                        } else {
                            try {
                                a(true, false);
                                z12 = true;
                            } catch (Throwable th5) {
                                th = th5;
                                z12 = true;
                                com.uc.crashsdk.a.g.a(th);
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z12 = false;
                    }
                } else {
                    z12 = false;
                }
                if (!z12 && !z13) {
                    b(false);
                }
                try {
                    f.c(false);
                } catch (Throwable th7) {
                    com.uc.crashsdk.a.g.a(th7);
                }
                try {
                    boolean zI2 = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        zI2 = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI2);
                    if (zI2 && (uncaughtExceptionHandler8 = T) != null) {
                        uncaughtExceptionHandler8.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B() && !z13) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                } catch (Throwable th8) {
                    com.uc.crashsdk.a.g.a(th8);
                }
                V = true;
                if (Process.myPid() <= 0 || !g.j()) {
                    return;
                }
                Process.killProcess(Process.myPid());
                return;
            }
            U = th;
            if (!z13 && !com.uc.crashsdk.a.d.e()) {
                com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                if (z2) {
                    try {
                        if (!g.s() || z13) {
                            z11 = false;
                        } else {
                            try {
                                a(true, false);
                                z11 = true;
                            } catch (Throwable th9) {
                                th = th9;
                                z11 = true;
                                com.uc.crashsdk.a.g.a(th);
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        z11 = false;
                    }
                } else {
                    z11 = false;
                }
                if (!z11 && !z13) {
                    b(false);
                }
                try {
                    f.c(false);
                } catch (Throwable th11) {
                    com.uc.crashsdk.a.g.a(th11);
                }
                try {
                    boolean zI3 = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        zI3 = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI3);
                    if (zI3 && (uncaughtExceptionHandler7 = T) != null) {
                        uncaughtExceptionHandler7.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B() && !z13) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                } catch (Throwable th12) {
                    com.uc.crashsdk.a.g.a(th12);
                }
                V = true;
                if (Process.myPid() <= 0 || !g.j()) {
                    return;
                }
                Process.killProcess(Process.myPid());
                return;
            }
            com.uc.crashsdk.a.a.d("DEBUG", "encryptLog: " + g.y() + ", zipCrashLog: " + g.y());
            if (g.a != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set zip log to false stack is:");
                g.a.printStackTrace();
            }
            if (g.b != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set encrypt to true stack is:");
                g.b.printStackTrace();
            }
            com.uc.crashsdk.a.a.d("DEBUG", "begin to generate java report");
            try {
                N();
            } catch (Throwable th13) {
                com.uc.crashsdk.a.g.a(th13);
            }
            try {
                zU = g.u();
                try {
                    String strG = g.g();
                    if (strG == null || strG.equals("")) {
                        strG = k(S());
                    }
                    str = g.Y() + strG;
                    z3 = false;
                } catch (Throwable th14) {
                    th = th14;
                    com.uc.crashsdk.a.a.d("DEBUG", "get java log name failed: " + th);
                    a(th);
                    com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                    a(th);
                    z3 = true;
                    str = null;
                }
            } catch (Throwable th15) {
                th = th15;
                zU = false;
            }
            try {
                try {
                    if (z13) {
                        if (zU) {
                            str = "omit";
                            com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                        }
                        long jNativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(str, "java", null, 0) : 0L;
                        r12 = jNativeClientCreateConnection;
                        if (jNativeClientCreateConnection == 0) {
                            com.uc.crashsdk.a.a.d("DEBUG", "skip java crash:");
                            a(th);
                            if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                            }
                            if (z2) {
                                try {
                                    if (!g.s() || z13) {
                                        z10 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z10 = true;
                                        } catch (Throwable th16) {
                                            th = th16;
                                            z10 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th17) {
                                    th = th17;
                                    z10 = false;
                                }
                            } else {
                                z10 = false;
                            }
                            if (!z10 && !z13) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th18) {
                                com.uc.crashsdk.a.g.a(th18);
                            }
                            try {
                                boolean zI4 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI4 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI4);
                                if (zI4 && (uncaughtExceptionHandler6 = T) != null) {
                                    uncaughtExceptionHandler6.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th19) {
                                com.uc.crashsdk.a.g.a(th19);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        if (zU) {
                            if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                            }
                            if (z2) {
                                try {
                                    if (!g.s() || z13) {
                                        z9 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z9 = true;
                                        } catch (Throwable th20) {
                                            th = th20;
                                            z9 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th21) {
                                    th = th21;
                                    z9 = false;
                                }
                            } else {
                                z9 = false;
                            }
                            if (!z9 && !z13) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th22) {
                                com.uc.crashsdk.a.g.a(th22);
                            }
                            try {
                                boolean zI5 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI5 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI5);
                                if (zI5 && (uncaughtExceptionHandler5 = T) != null) {
                                    uncaughtExceptionHandler5.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th23) {
                                com.uc.crashsdk.a.g.a(th23);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                    } else {
                        try {
                            g.a();
                            try {
                                if (com.uc.crashsdk.b.B()) {
                                    f.a(3);
                                } else {
                                    f.a(4);
                                }
                            } catch (Throwable th24) {
                                com.uc.crashsdk.a.g.a(th24);
                            }
                        } catch (Throwable th25) {
                            com.uc.crashsdk.a.g.a(th25);
                        }
                        try {
                            new File(com.uc.crashsdk.b.b()).createNewFile();
                        } catch (Throwable th26) {
                            com.uc.crashsdk.a.g.a(th26);
                        }
                        if (zU) {
                            com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                            if (z2) {
                                try {
                                    if (!g.s() || z13) {
                                        z7 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z7 = true;
                                        } catch (Throwable th27) {
                                            th = th27;
                                            z7 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th28) {
                                    th = th28;
                                    z7 = false;
                                }
                            } else {
                                z7 = false;
                            }
                            if (!z7 && !z13) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th29) {
                                com.uc.crashsdk.a.g.a(th29);
                            }
                            try {
                                boolean zI6 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI6 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI6);
                                if (zI6 && (uncaughtExceptionHandler3 = T) != null) {
                                    uncaughtExceptionHandler3.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th30) {
                                com.uc.crashsdk.a.g.a(th30);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        if (!d("java")) {
                            com.uc.crashsdk.a.a.d("DEBUG", "java log sample miss");
                            if (z2) {
                                try {
                                    if (!g.s() || z13) {
                                        z6 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z6 = true;
                                        } catch (Throwable th31) {
                                            th = th31;
                                            z6 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th32) {
                                    th = th32;
                                    z6 = false;
                                }
                            } else {
                                z6 = false;
                            }
                            if (!z6 && !z13) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th33) {
                                com.uc.crashsdk.a.g.a(th33);
                            }
                            try {
                                boolean zI7 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI7 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI7);
                                if (zI7 && (uncaughtExceptionHandler2 = T) != null) {
                                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z13) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th34) {
                                com.uc.crashsdk.a.g.a(th34);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        r12 = 0;
                    }
                    boolean z14 = th instanceof OutOfMemoryError;
                    a(th, str, r12, z14);
                    com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                    if (!com.uc.crashsdk.b.L() && z14 && g.k()) {
                        String name = new File(str).getName();
                        String strZ = g.Z();
                        File file = new File(strZ);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str2 = String.format(Locale.US, "%s%s.hprof", strZ, name);
                        com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + str2);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            Debug.dumpHprofData(str2);
                        } catch (Throwable th35) {
                            com.uc.crashsdk.a.g.a(th35);
                        }
                        com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                    }
                    if (r12 != 0 && com.uc.crashsdk.b.d) {
                        JNIBridge.nativeClientCloseConnection(r12);
                    }
                    if (z2) {
                        try {
                            if (!g.s() || z13) {
                                z8 = false;
                            } else {
                                try {
                                    a(true, false);
                                    z8 = true;
                                } catch (Throwable th36) {
                                    th3 = th36;
                                    z8 = true;
                                    com.uc.crashsdk.a.g.a(th3);
                                }
                            }
                        } catch (Throwable th37) {
                            th3 = th37;
                            z8 = false;
                        }
                    } else {
                        z8 = false;
                    }
                    if (!z8 && !z13) {
                        b(false);
                    }
                    try {
                        f.c(false);
                    } catch (Throwable th38) {
                        com.uc.crashsdk.a.g.a(th38);
                    }
                    try {
                        boolean zI8 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            zI8 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI8);
                        if (zI8 && (uncaughtExceptionHandler4 = T) != null) {
                            uncaughtExceptionHandler4.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z13) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                    } catch (Throwable th39) {
                        com.uc.crashsdk.a.g.a(th39);
                    }
                    V = true;
                    if (Process.myPid() <= 0 || !g.j()) {
                        return;
                    }
                    Process.killProcess(Process.myPid());
                    return;
                } catch (Throwable th40) {
                    th = th40;
                }
            } catch (Throwable th41) {
                th = th41;
            }
        } catch (Throwable th42) {
            th = th42;
            z3 = false;
        }
        th = th42;
        z3 = false;
        r12 = 0;
        try {
            com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th);
            a(th);
            if (!z3) {
                com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                a(th);
            }
            if (z2) {
                try {
                    if (zS && !z13) {
                        try {
                        } catch (Throwable th43) {
                            th2 = th43;
                        }
                    }
                } catch (Throwable th44) {
                    th2 = th44;
                }
            }
        } finally {
            if (r12 != 0 && com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientCloseConnection(r12);
            }
            if (z2) {
                try {
                    if (!g.s() || z13) {
                        z4 = false;
                    } else {
                        try {
                            a(true, false);
                            z4 = true;
                        } catch (Throwable th45) {
                            th = th45;
                            z4 = true;
                            com.uc.crashsdk.a.g.a(th);
                            if (!z4) {
                                b(false);
                            }
                            f.c(false);
                            zI = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                                zI = true;
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI);
                            if (zI) {
                                uncaughtExceptionHandler.uncaughtException(thread, th);
                            }
                            if (com.uc.crashsdk.b.B()) {
                                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                            }
                            V = true;
                            if (Process.myPid() <= 0) {
                            }
                        }
                    }
                } catch (Throwable th46) {
                    th = th46;
                    z4 = false;
                }
            } else {
                z4 = false;
            }
            if (!z4 && !z13) {
                b(false);
            }
            try {
                f.c(false);
            } catch (Throwable th47) {
                com.uc.crashsdk.a.g.a(th47);
            }
            try {
                zI = g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                    zI = true;
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI);
                if (zI && (uncaughtExceptionHandler = T) != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B() && !z13) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
            } catch (Throwable th48) {
                com.uc.crashsdk.a.g.a(th48);
            }
            V = true;
            if (Process.myPid() <= 0 && g.j()) {
                Process.killProcess(Process.myPid());
            }
        }
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long jP = g.p();
        if (jP < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, jP);
        }
    }

    static void y() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    public static boolean e(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_LIST_SIZE_CODE), i2 * 1000);
    }

    private static void ab() {
        String strZ = g.Z();
        File file = new File(strZ);
        if (file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 150) {
                    Arrays.sort(fileArrListFiles, new b((byte) 0));
                    int length = fileArrListFiles.length - 150;
                    if (length < 0) {
                        length = 0;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < fileArrListFiles.length) {
                        File file2 = fileArrListFiles[i2];
                        boolean z2 = i2 < length;
                        if (!z2 && jCurrentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i3++;
                            i4 = 0;
                        } catch (Throwable th) {
                            i4++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i4 >= 3) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i3 + " logs in " + strZ);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static void A() {
        if (g.r()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.INTERACTION_TYPE_CODE), 1000L);
    }

    private static void a(Calendar calendar) {
        if (g.T()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_COVER_URL_CODE, new Object[]{Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_LIST_CODE), 7000L);
    }

    public static void d(boolean z2) {
        f.d(false);
        if (z2) {
            f.a(com.uc.crashsdk.b.c(), false);
            h.i();
        } else {
            f.a();
            h.i();
        }
    }

    public static int e(boolean z2) {
        return f.a(z2);
    }

    public static int f(boolean z2) {
        int iB;
        if (z2) {
            iB = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            iB = f.b();
        }
        int iB2 = f.b(z2);
        return iB2 > iB ? iB2 : iB;
    }

    static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    i3 = 0;
                    z2 = true;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    public static void D() {
        int iO = g.O();
        boolean z2 = false;
        boolean z3 = true;
        if (iO != 0 && iO != 3 && iO != 4 && iO == 1) {
            z3 = false;
        }
        if (!z3) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean zL = com.uc.crashsdk.b.L();
        if (Looper.getMainLooper() == Looper.myLooper() || !z3) {
            z2 = z3;
        } else {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_INFO_CODE));
        }
        JNIBridge.nativeCmd(7, zL ? 1L : 0L, null, null);
        if (z2) {
            JNIBridge.cmd(8);
        }
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            ParcelFileDescriptor parcelFileDescriptor = ae;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor;
            }
            int iCmd = (int) JNIBridge.cmd(14);
            if (iCmd == -1) {
                return null;
            }
            ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(iCmd);
            ae = parcelFileDescriptorAdoptFd;
            af = true;
            return parcelFileDescriptorAdoptFd;
        }
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ae != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ae = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int iNativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        ag = iNativeCmd != -1;
        return fd == -1 || iNativeCmd != -1;
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String strY = g.Y();
        File file = new File(strY);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + strY);
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }
}
