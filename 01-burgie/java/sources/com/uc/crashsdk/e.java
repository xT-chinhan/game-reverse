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
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bumptech.glide.load.Key;
import com.byazt.ol.TTDownloadField;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.utils.AVErrorInfo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.log.ULog;
import com.taptap.sdk.compliance.internal.TapComplianceSettings;
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
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    static final /* synthetic */ boolean a = true;
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
        int I2 = g.I();
        for (int i2 = 0; i2 < I2; i2++) {
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
        if (g.P()) {
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
            g = h(com.uc.crashsdk.b.b(TapComplianceSettings.STRATEGY_LOCAL));
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

        private int a(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            this.d += i2;
            if (this.e) {
                return 0;
            }
            int iA = g.A();
            if (iA > 0 && this.c + i2 > iA) {
                i3 = iA - this.c;
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
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(g.A()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        final void a(String str) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes(Key.STRING_CHARSET_NAME));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, String.format(Locale.US, "%c", Integer.valueOf(i)));
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
                        com.uc.crashsdk.a.a.d(ULog.L_DEBUG, new String(bArr2));
                    } catch (Throwable th) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (e.h && e.O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d(ULog.L_DEBUG, new String(bArr));
                } catch (Throwable th) {
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
        } catch (Throwable th) {
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
        if (i != null) {
            return i;
        }
        String strJ = j(null);
        i = strJ;
        return strJ;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.T(), g.V(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
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
            } catch (Throwable th) {
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
                synchronized (Y) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c(ULog.L_DEBUG, com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "unexp sample miss");
                        return;
                    }
                    int iNativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.o(), g.p());
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
                    synchronized (Y) {
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
                    if (!ac && g.Q() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (g.Q()) {
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
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d(LogType.ANR_TYPE));
                    return;
                }
                return;
            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                if (!R && com.uc.crashsdk.b.B() && g.M()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (!com.uc.crashsdk.b.B() || !g.M()) {
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
                            JNIBridge.set(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, "(get failed)");
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
        switch (i2) {
            case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME /* 451 */:
                if (a || objArr != null) {
                    return a((String) objArr[0], (d) objArr[1]);
                }
                throw new AssertionError();
            case MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME /* 452 */:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                String str = (String) objArr[0];
                d dVar = (d) objArr[1];
                return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
            default:
                if (a) {
                    return false;
                }
                throw new AssertionError();
        }
    }

    private static String S() {
        if (com.uc.crashsdk.b.F() && !d) {
            return "ucebujava";
        }
        return LogType.JAVA_TYPE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void a(boolean z2) {
        File[] fileArrListFiles;
        int i2;
        int i3;
        try {
            if (!com.uc.crashsdk.b.y() || (fileArrListFiles = new File(g.X()).listFiles()) == null) {
                return;
            }
            int iL = g.l();
            int iM = g.m();
            if (fileArrListFiles.length < Math.min(iL, iM)) {
                return;
            }
            Object[] objArr = 0;
            int i4 = 0;
            int i5 = 0;
            for (File file : fileArrListFiles) {
                if (b(file)) {
                    i4++;
                } else {
                    i5++;
                }
            }
            if (z2 && i4 >= iL) {
                i2 = (i4 - iL) + 1;
            } else {
                i2 = 0;
            }
            if (!z2 && i5 >= iM) {
                i3 = (i5 - iM) + 1;
            } else {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            Arrays.sort(fileArrListFiles, new b(objArr == true ? 1 : 0));
            int i6 = i3;
            int i7 = i2;
            for (File file2 : fileArrListFiles) {
                boolean zB = b(file2);
                if (zB && i7 > 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                    file2.delete();
                    i7 += -1;
                } else if (!zB && i6 > 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                    file2.delete();
                    i6 += -1;
                }
                if (i7 == 0 && i6 == 0) {
                    break;
                }
            }
            f.a(16, i2 + i3);
            if (i2 > 0) {
                f.a(22, i2);
            }
            if (i3 > 0) {
                f.a(23, i3);
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
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes(Key.STRING_CHARSET_NAME));
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes(Key.STRING_CHARSET_NAME));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes(Key.STRING_CHARSET_NAME));
            Locale locale2 = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.B() ? "fg" : "bg";
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.T(), g.U(), g.V(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes(Key.STRING_CHARSET_NAME));
            String str3 = "0";
            String strNativeGet = "";
            if (com.uc.crashsdk.b.d) {
                String strNativeGet2 = JNIBridge.nativeGet(1, 0L, null);
                strNativeGet = JNIBridge.nativeGet(2, 0L, null);
                str3 = strNativeGet2;
            }
            outputStream.write(String.format(Locale.US, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str3, "211215141717", strNativeGet, "release").getBytes(Key.STRING_CHARSET_NAME));
            if (str == null) {
                str = "";
            }
            outputStream.write(("Report Name: " + str.substring(str.lastIndexOf(47) + 1) + "\n").getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ag) {
                strS = s("UUID");
            } else {
                strS = B;
            }
            outputStream.write(String.format("UUID: %s\n", strS).getBytes(Key.STRING_CHARSET_NAME));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String strE = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(strE)) {
                strE = "(none)";
            }
            outputStream.write(("Activity: " + strE + "\n").getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, Key.STRING_CHARSET_NAME);
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes(Key.STRING_CHARSET_NAME));
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
            if (Build.VERSION.SDK_INT >= 21) {
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
            }
        } catch (Throwable th) {
        }
        if (com.uc.crashsdk.a.g.a(j)) {
            try {
                str = Build.CPU_ABI;
                try {
                    str2 = Build.CPU_ABI2;
                } catch (Throwable th2) {
                    str2 = null;
                }
            } catch (Throwable th3) {
                str = null;
            }
            boolean z3 = !com.uc.crashsdk.a.g.a(str);
            if (z3) {
                j = str;
            }
            if (!com.uc.crashsdk.a.g.a(str2)) {
                if (z3) {
                    j += ",";
                    j += str2;
                } else {
                    j = str2;
                }
            }
        }
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                str3 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
                try {
                    str4 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
                    str5 = str3;
                } catch (Throwable th4) {
                    th = th4;
                    com.uc.crashsdk.a.g.a(th);
                    str4 = null;
                    str5 = str3;
                }
            } else {
                str4 = null;
            }
        } catch (Throwable th5) {
            th = th5;
            str3 = null;
        }
        try {
            if (!com.uc.crashsdk.a.g.a(str5) && !j.contains(str5)) {
                j += ",";
                j += str5;
            }
            if (!com.uc.crashsdk.a.g.a(str4) && !j.contains(str4)) {
                j += ",";
                j += str4;
            }
        } catch (Throwable th6) {
            com.uc.crashsdk.a.g.a(th6);
        }
        return j;
    }

    public static String f() throws Throwable {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    private static void T() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        Closeable closeable;
        String strTrim = "-";
        String strTrim2 = "-";
        try {
            strTrim = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
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
                                i2++;
                                strTrim = line.substring(line.indexOf(":") + 1).trim();
                            } else if (line.startsWith("Processor")) {
                                i2++;
                                strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                        }
                    } while (i2 < 2);
                    com.uc.crashsdk.a.g.a(fileReader);
                } catch (Throwable th4) {
                    th = th4;
                    closeable = null;
                    com.uc.crashsdk.a.g.a(fileReader);
                    com.uc.crashsdk.a.g.a(closeable);
                    throw th;
                }
            } catch (Throwable th5) {
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
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append("\n");
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
        String[] strArr;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                strArr = new String[]{"ps", "-ef"};
            } else {
                strArr = new String[]{"ps"};
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            boolean zB = com.uc.crashsdk.a.g.b(str);
            boolean zB2 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if ((zB && line.contains(str)) || (zB2 && line.contains(str2)) || (line.indexOf(47) < 0 && line.indexOf(46) > 0)) {
                        byteArrayOutputStream.write(line.getBytes(Key.STRING_CHARSET_NAME));
                        byteArrayOutputStream.write("\n".getBytes(Key.STRING_CHARSET_NAME));
                    }
                } else {
                    return byteArrayOutputStream.toString(Key.STRING_CHARSET_NAME);
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
            } catch (Throwable th) {
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
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    private static void b(OutputStream outputStream) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                outputStream.write("logcat:\n".getBytes(Key.STRING_CHARSET_NAME));
                if (g.n() <= 0) {
                    try {
                        outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th) {
                        a(th, outputStream);
                    }
                    a(outputStream);
                    com.uc.crashsdk.a.g.a((Closeable) null);
                    return;
                }
                int iN = g.n();
                BufferedReader bufferedReaderA = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.d.ar, "-b", "main", "-v", "threadtime", "-t", String.valueOf(iN)}).getInputStream()));
                try {
                    try {
                        if (bufferedReaderA == null) {
                            try {
                                outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes(Key.STRING_CHARSET_NAME));
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
                                if (i3 < iN && !line.contains(" I auditd ") && !line.contains(" I liblog ")) {
                                    outputStream.write(line.getBytes(Key.STRING_CHARSET_NAME));
                                    outputStream.write("\n".getBytes(Key.STRING_CHARSET_NAME));
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
                        outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes(Key.STRING_CHARSET_NAME));
                        h = true;
                        com.uc.crashsdk.a.g.a(bufferedReaderA);
                        a(outputStream);
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = bufferedReaderA;
                        h = true;
                        a(th, outputStream);
                        com.uc.crashsdk.a.g.a(bufferedReader);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = bufferedReaderA;
                    com.uc.crashsdk.a.g.a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private static String a(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Throwable th) {
            canonicalPath = null;
        }
        if (com.uc.crashsdk.a.g.a(canonicalPath)) {
            return file.getPath();
        }
        return canonicalPath;
    }

    private static long a(StatFs statFs, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 18) {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(statFs, new Object[0]);
            if (objInvoke != null && (objInvoke instanceof Long)) {
                return ((Long) objInvoke).longValue();
            }
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (objInvoke2 != null && (objInvoke2 instanceof Integer)) {
                return ((Integer) objInvoke2).intValue();
            }
            return 0L;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static void c(OutputStream outputStream) {
        File[] fileArrListFiles;
        Throwable th;
        int iJ;
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
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th3) {
                    a(th3, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        try {
            iJ = g.J();
            try {
                fileArrListFiles = new File("/proc/self/fd").listFiles();
                try {
                    if (fileArrListFiles != null) {
                        outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArrListFiles.length), Integer.valueOf(iJ)).getBytes(Key.STRING_CHARSET_NAME));
                    } else {
                        outputStream.write("[DEBUG] listFiles failed!\n".getBytes(Key.STRING_CHARSET_NAME));
                    }
                } catch (Throwable th4) {
                    th = th4;
                    a(th, outputStream);
                }
            } catch (Throwable th5) {
                fileArrListFiles = null;
                th = th5;
            }
        } catch (Throwable th6) {
            fileArrListFiles = null;
            th = th6;
            iJ = AVMDLDataLoader.KeyIsMaxIpCountEachDomain;
        }
        if (fileArrListFiles != null) {
            try {
                if (fileArrListFiles.length >= iJ) {
                    outputStream.write("opened files:\n".getBytes(Key.STRING_CHARSET_NAME));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArrListFiles) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (Throwable th7) {
                        a(th7, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes(Key.STRING_CHARSET_NAME));
                }
            } catch (Throwable th8) {
                a(th8, outputStream);
            }
        }
        a(outputStream);
    }

    private static void d(OutputStream outputStream) {
        Throwable th;
        int iK;
        int i2;
        int i3;
        File[] fileArr = null;
        try {
            iK = g.K();
            try {
                File[] fileArrListFiles = new File("/proc/self/task").listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                try {
                    int length = fileArrListFiles.length;
                    if (length < iK) {
                        return;
                    }
                    i3 = length;
                    fileArr = fileArrListFiles;
                    i2 = iK;
                    if (fileArr == null) {
                        return;
                    }
                    try {
                        outputStream.write("threads info:\n".getBytes(Key.STRING_CHARSET_NAME));
                        outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(i3), Integer.valueOf(i2)).getBytes(Key.STRING_CHARSET_NAME));
                        outputStream.write(" tid     name\n".getBytes(Key.STRING_CHARSET_NAME));
                        for (File file : fileArr) {
                            outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), l(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes(Key.STRING_CHARSET_NAME));
                        }
                    } catch (Throwable th2) {
                        a(th2, outputStream);
                    }
                    a(outputStream);
                } catch (Throwable th3) {
                    th = th3;
                    fileArr = fileArrListFiles;
                    com.uc.crashsdk.a.g.a(th);
                    i2 = iK;
                    i3 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            iK = TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
        }
    }

    private static void e(OutputStream outputStream) throws Throwable {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        int iIndexOf;
        if (com.uc.crashsdk.b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes(Key.STRING_CHARSET_NAME));
            } catch (Throwable th2) {
                a(th2, outputStream);
            }
            try {
                ArrayList arrayList = new ArrayList();
                fileReader = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader, 512);
                    while (true) {
                        try {
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
                                                outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", strSubstring) + "\n").getBytes(Key.STRING_CHARSET_NAME));
                                            } catch (Throwable th3) {
                                                a(th3, outputStream);
                                            }
                                        } else {
                                            outputStream.write(String.format(Locale.US, "%s: %s\n", strSubstring, JNIBridge.nativeGet(3, 0L, strSubstring)).getBytes(Key.STRING_CHARSET_NAME));
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                a(th, outputStream);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                    th = th;
                    a(th, outputStream);
                    com.uc.crashsdk.a.g.a(fileReader);
                    com.uc.crashsdk.a.g.a(bufferedReader);
                    a(outputStream);
                }
            } catch (Throwable th7) {
                th = th7;
                fileReader = null;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(fileReader);
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
            aVar.write((s("LOG_END") + "\n").getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004a A[Catch: Throwable -> 0x0042, TRY_LEAVE, TryCatch #1 {Throwable -> 0x0042, blocks: (B:15:0x002d, B:18:0x0044, B:20:0x004a), top: B:29:0x002d }] */
    static int a(OutputStream outputStream, String str, int i2) {
        Throwable th;
        int length;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String strA = com.uc.crashsdk.a.b.a(str);
            if (strA == null) {
                strA = "file: '" + str + "' not found or decode failed!";
            }
            length = strA.length();
            if (length > i2 + 32) {
                length = i2;
            }
            if (length > 0) {
                try {
                    outputStream.write(strA.getBytes(Key.STRING_CHARSET_NAME), 0, length);
                    outputStream.write("\n".getBytes(Key.STRING_CHARSET_NAME));
                    if (length < strA.length()) {
                        outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - length)).getBytes(Key.STRING_CHARSET_NAME));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a(th, outputStream);
                }
            } else if (length < strA.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - length)).getBytes(Key.STRING_CHARSET_NAME));
            }
        } catch (Throwable th3) {
            th = th3;
            length = 0;
        }
        a(outputStream);
        return length;
    }

    static int b(OutputStream outputStream, String str, int i2) throws Throwable {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    byte[] bArrR = R();
                    if (bArrR == null) {
                        outputStream.write("(alloc buffer failed!)\n".getBytes(Key.STRING_CHARSET_NAME));
                        com.uc.crashsdk.a.g.a((Closeable) null);
                        return 0;
                    }
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    i4 = 0;
                    i3 = 0;
                    boolean z2 = false;
                    while (true) {
                        try {
                            int i5 = dataInputStream.read(bArrR);
                            if (i5 == -1) {
                                break;
                            }
                            i4 += i5;
                            int i6 = i2 - i3;
                            if (i5 <= i6 + 32) {
                                i6 = i5;
                            }
                            if (i6 > 0 && !z2) {
                                outputStream.write(bArrR, 0, i6);
                                i3 += i6;
                            }
                            if (!z2) {
                                z2 = i6 < i5 || i3 >= i2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            dataInputStream2 = dataInputStream;
                            com.uc.crashsdk.a.g.a(dataInputStream2);
                            throw th;
                        }
                    }
                } else {
                    outputStream.write(("file: '" + str + "' not exists!\n").getBytes(Key.STRING_CHARSET_NAME));
                    dataInputStream = null;
                    i4 = 0;
                    i3 = 0;
                }
                if (i3 > 0) {
                    outputStream.write("\n".getBytes(Key.STRING_CHARSET_NAME));
                }
                if (i3 < i4) {
                    outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes(Key.STRING_CHARSET_NAME));
                }
                com.uc.crashsdk.a.g.a(dataInputStream);
            } catch (Throwable th2) {
                th = th2;
                i3 = 0;
            }
            a(outputStream);
            return i3;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static String a(int i2) {
        try {
            String strA = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            if (com.uc.crashsdk.a.g.b(strA)) {
                return l(strA);
            }
            return "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static String l(String str) {
        if (com.uc.crashsdk.a.g.b(str)) {
            int iIndexOf = str.indexOf(0);
            if (iIndexOf >= 0) {
                str = str.substring(0, iIndexOf);
            }
            return str.trim();
        }
        return "";
    }

    public static String h() {
        if (m != null) {
            return m;
        }
        String strA = a(Process.myPid());
        m = strA;
        return strA;
    }

    /* JADX WARN: Code duplicated, block: B:203:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:214:0x03f6 A[Catch: all -> 0x039d, Throwable -> 0x0476, TryCatch #52 {Throwable -> 0x0476, blocks: (B:212:0x03d1, B:214:0x03f6, B:215:0x03f8, B:217:0x040b, B:218:0x0410, B:220:0x042c, B:223:0x0455, B:225:0x045c), top: B:394:0x03d1, outer: #49 }] */
    /* JADX WARN: Code duplicated, block: B:217:0x040b A[Catch: all -> 0x039d, Throwable -> 0x0476, TryCatch #52 {Throwable -> 0x0476, blocks: (B:212:0x03d1, B:214:0x03f6, B:215:0x03f8, B:217:0x040b, B:218:0x0410, B:220:0x042c, B:223:0x0455, B:225:0x045c), top: B:394:0x03d1, outer: #49 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x042c A[Catch: all -> 0x039d, Throwable -> 0x0476, TryCatch #52 {Throwable -> 0x0476, blocks: (B:212:0x03d1, B:214:0x03f6, B:215:0x03f8, B:217:0x040b, B:218:0x0410, B:220:0x042c, B:223:0x0455, B:225:0x045c), top: B:394:0x03d1, outer: #49 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0453  */
    /* JADX WARN: Code duplicated, block: B:224:0x0459  */
    /* JADX WARN: Code duplicated, block: B:238:0x0496  */
    /* JADX WARN: Code duplicated, block: B:257:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:272:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:297:0x0537  */
    /* JADX WARN: Code duplicated, block: B:301:0x0545  */
    /* JADX WARN: Code duplicated, block: B:302:0x054b  */
    /* JADX WARN: Code duplicated, block: B:305:0x0551 A[Catch: Throwable -> 0x0561, TryCatch #4 {Throwable -> 0x0561, blocks: (B:303:0x054d, B:305:0x0551, B:307:0x055b), top: B:325:0x054d }] */
    /* JADX WARN: Code duplicated, block: B:306:0x055a  */
    /* JADX WARN: Code duplicated, block: B:316:0x0570  */
    /* JADX WARN: Code duplicated, block: B:394:0x03d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static String a(Throwable th, String str, long j2, boolean z2) throws Throwable {
        Throwable th2;
        Throwable th3;
        a aVar;
        OutputStream fileOutputStream;
        String strA;
        StringBuilder sb;
        String strH;
        String str2;
        long j3 = j2;
        a aVar2 = null;
        try {
            try {
                if (!com.uc.crashsdk.b.L()) {
                    try {
                        g.a();
                        a(true);
                    } catch (Throwable th4) {
                        th3 = th4;
                        aVar = null;
                        fileOutputStream = aVar;
                        if (j3 != 0) {
                            b(aVar);
                        }
                        com.uc.crashsdk.a.g.a(aVar);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        throw th3;
                    }
                }
                fileOutputStream = j3 == 0 ? new FileOutputStream(str) : null;
                try {
                    a aVar3 = new a(j3, fileOutputStream);
                    try {
                        try {
                            if (com.uc.crashsdk.b.d) {
                                JNIBridge.set(126, str);
                            }
                        } catch (Throwable th5) {
                            th3 = th5;
                            j3 = j3;
                            aVar = aVar3;
                            if (j3 != 0) {
                                b(aVar);
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            throw th3;
                        }
                    } catch (Throwable th6) {
                        try {
                            com.uc.crashsdk.a.g.a(th6);
                        } catch (Throwable th7) {
                            th = th7;
                            j3 = j3;
                            aVar = aVar3;
                            th3 = th;
                            if (j3 != 0) {
                                b(aVar);
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                            com.uc.crashsdk.a.g.a(fileOutputStream);
                            throw th3;
                        }
                    }
                    b(aVar3, str, S());
                    if (z2) {
                        try {
                            aVar3.flush();
                        } catch (Throwable th8) {
                            try {
                                com.uc.crashsdk.a.g.a(th8);
                            } catch (Throwable th9) {
                                th2 = th9;
                                j3 = j3;
                                aVar2 = aVar3;
                                a(th2, aVar2);
                                if (j3 != 0) {
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
                                b(strA, LogType.JAVA_TYPE);
                                return str;
                            }
                        }
                    }
                    try {
                        aVar3.write(("Process Name: '" + h() + "'\n").getBytes(Key.STRING_CHARSET_NAME));
                        aVar3.write(("Thread Name: '" + Thread.currentThread().getName() + "'\n").getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th10) {
                        com.uc.crashsdk.a.g.a(th10);
                    }
                    try {
                        aVar3.write("Back traces starts.\n".getBytes(Key.STRING_CHARSET_NAME));
                        try {
                            Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(th);
                            if (obj != null) {
                                declaredField.set(th, ((String) obj).replaceAll("\n\t", "\n->  "));
                            }
                        } catch (Throwable th11) {
                            com.uc.crashsdk.a.g.a(th11);
                        }
                        String message = th.getMessage();
                        if (message != null && !message.equals(th.getLocalizedMessage())) {
                            aVar3.write(("Message: " + message + "\n").getBytes(Key.STRING_CHARSET_NAME));
                        }
                    } catch (Throwable th12) {
                        com.uc.crashsdk.a.g.a(th12);
                    }
                    try {
                        th.printStackTrace(new PrintStream(aVar3));
                    } catch (Throwable th13) {
                        com.uc.crashsdk.a.g.a(th13);
                    }
                    try {
                        aVar3.write("Back traces ends.\n".getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th14) {
                        com.uc.crashsdk.a.g.a(th14);
                    }
                    a((OutputStream) aVar3);
                    try {
                        aVar3.flush();
                    } catch (Throwable th15) {
                        com.uc.crashsdk.a.g.a(th15);
                    }
                    try {
                        com.uc.crashsdk.a.a(aVar3, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    } catch (Throwable th16) {
                        com.uc.crashsdk.a.g.a(th16);
                    }
                    if (z2) {
                        try {
                            aVar3.flush();
                        } catch (Throwable th17) {
                            com.uc.crashsdk.a.g.a(th17);
                        }
                    }
                    try {
                        aVar3.write("meminfo:\n".getBytes(Key.STRING_CHARSET_NAME));
                        b(aVar3, "/proc/meminfo", 10240);
                    } catch (Throwable th18) {
                        a(th18, aVar3);
                    }
                    try {
                        String str3 = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
                        aVar3.write("status:\n".getBytes(Key.STRING_CHARSET_NAME));
                        b(aVar3, str3, 10240);
                    } catch (Throwable th19) {
                        a(th19, aVar3);
                    }
                    try {
                        aVar3.write(("memory info:\n" + g()).getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th20) {
                        a(th20, aVar3);
                    }
                    a((OutputStream) aVar3);
                    f(aVar3);
                    try {
                        com.uc.crashsdk.a.a(aVar3, Key.STRING_CHARSET_NAME, (ArrayList<String>) null);
                    } catch (Throwable th21) {
                        a(th21, aVar3);
                    }
                    if (ag) {
                        h = false;
                        try {
                            aVar3.write(s("JAVADUMPFILES").getBytes(Key.STRING_CHARSET_NAME));
                        } catch (Throwable th22) {
                            a(th22, aVar3);
                        }
                        h = true;
                    }
                    try {
                        aVar3.flush();
                    } catch (Throwable th23) {
                        com.uc.crashsdk.a.g.a(th23);
                    }
                    b((OutputStream) aVar3);
                    try {
                        aVar3.flush();
                    } catch (Throwable th24) {
                        com.uc.crashsdk.a.g.a(th24);
                    }
                    try {
                        aVar3.write("battery info:\n".getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th25) {
                        a(th25, aVar3);
                    }
                    try {
                        if (ag) {
                            h = false;
                            aVar3.write(s("BATTERYINFO").getBytes(Key.STRING_CHARSET_NAME));
                            h = true;
                        } else {
                            StringBuilder sbY = Y();
                            if (sbY != null) {
                                aVar3.write(sbY.toString().getBytes(Key.STRING_CHARSET_NAME));
                            }
                        }
                    } catch (Throwable th26) {
                        a(th26, aVar3);
                    }
                    a((OutputStream) aVar3);
                    try {
                        aVar3.write("disk info:\n".getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th27) {
                        a(th27, aVar3);
                    }
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        if (ag) {
                                            h = false;
                                            try {
                                                aVar3.write(s("FSSTAT").getBytes(Key.STRING_CHARSET_NAME));
                                            } catch (Throwable th28) {
                                                a(th28, aVar3);
                                            }
                                            h = true;
                                        } else {
                                            try {
                                                try {
                                                    HashSet hashSet = new HashSet();
                                                    String strA2 = a(new File(com.uc.crashsdk.a.g.b()));
                                                    if (!com.uc.crashsdk.a.g.a(strA2) && !hashSet.contains(strA2) && !strA2.equals("/storage/emulated")) {
                                                        hashSet.add(strA2);
                                                        try {
                                                            StatFs statFs = new StatFs(strA2);
                                                            long jA = a(statFs, "getBlockCountLong", "getBlockCount");
                                                            long jA2 = a(statFs, "getBlockSizeLong", "getBlockSize");
                                                            if ((jA / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) * jA2 >= 10240) {
                                                                long jA3 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                                                                long jA4 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                                                                try {
                                                                    aVar3.write(String.format(Locale.US, "%s:\n", strA2).getBytes(Key.STRING_CHARSET_NAME));
                                                                    Locale locale = Locale.US;
                                                                    Object[] objArr = new Object[1];
                                                                    double d2 = jA2;
                                                                    try {
                                                                        objArr[0] = Long.valueOf((long) (((jA * 1.0d) * d2) / 1024.0d));
                                                                        aVar = aVar3;
                                                                        try {
                                                                            try {
                                                                                aVar.write(String.format(locale, "  total:      %d kB\n", objArr).getBytes(Key.STRING_CHARSET_NAME));
                                                                                aVar.write(String.format(Locale.US, "  available:  %d kB\n", Long.valueOf((long) (((jA3 * 1.0d) * d2) / 1024.0d))).getBytes(Key.STRING_CHARSET_NAME));
                                                                                aVar.write(String.format(Locale.US, "  free:       %d kB\n", Long.valueOf((long) (((jA4 * 1.0d) * d2) / 1024.0d))).getBytes(Key.STRING_CHARSET_NAME));
                                                                                aVar.write(String.format(Locale.US, "  block size: %d B\n\n", Long.valueOf(jA2)).getBytes(Key.STRING_CHARSET_NAME));
                                                                            } catch (Throwable th29) {
                                                                                th = th29;
                                                                                try {
                                                                                    a(th, aVar);
                                                                                } catch (Throwable th30) {
                                                                                    th = th30;
                                                                                    try {
                                                                                        a(th, aVar);
                                                                                    } catch (Throwable th31) {
                                                                                        th = th31;
                                                                                        j3 = j2;
                                                                                        th2 = th;
                                                                                        aVar2 = aVar;
                                                                                        a(th2, aVar2);
                                                                                        if (j3 != 0) {
                                                                                            b(aVar2);
                                                                                        }
                                                                                        com.uc.crashsdk.a.g.a(aVar2);
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (Throwable th32) {
                                                                            th = th32;
                                                                            th3 = th;
                                                                            j3 = j2;
                                                                            if (j3 != 0) {
                                                                                b(aVar);
                                                                            }
                                                                            com.uc.crashsdk.a.g.a(aVar);
                                                                            com.uc.crashsdk.a.g.a(fileOutputStream);
                                                                            throw th3;
                                                                        }
                                                                    } catch (Throwable th33) {
                                                                        th = th33;
                                                                        aVar = aVar3;
                                                                    }
                                                                } catch (Throwable th34) {
                                                                    th = th34;
                                                                    aVar = aVar3;
                                                                }
                                                            }
                                                        } catch (Throwable th35) {
                                                        }
                                                        a((OutputStream) aVar);
                                                        aVar.write("device status:\n".getBytes(Key.STRING_CHARSET_NAME));
                                                        if (ag) {
                                                            try {
                                                                h = false;
                                                                aVar.write(s("DEVICESTATUS").getBytes(Key.STRING_CHARSET_NAME));
                                                                h = true;
                                                            } catch (Throwable th36) {
                                                                try {
                                                                    a(th36, aVar);
                                                                } catch (Throwable th37) {
                                                                    th2 = th37;
                                                                    aVar2 = aVar;
                                                                    j3 = j2;
                                                                    a(th2, aVar2);
                                                                    if (j3 != 0) {
                                                                        b(aVar2);
                                                                    }
                                                                    com.uc.crashsdk.a.g.a(aVar2);
                                                                }
                                                            }
                                                        } else {
                                                            try {
                                                                aVar.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes(Key.STRING_CHARSET_NAME));
                                                                String str4 = Build.TAGS != null ? Build.TAGS : "";
                                                                sb = new StringBuilder();
                                                                sb.append("build tags: ");
                                                                sb.append(str4);
                                                                if (com.uc.crashsdk.a.g.f()) {
                                                                    sb.append(" (default root)");
                                                                }
                                                                sb.append("\n");
                                                                aVar.write(sb.toString().getBytes(Key.STRING_CHARSET_NAME));
                                                                strH = com.uc.crashsdk.a.g.h();
                                                                if (com.uc.crashsdk.a.g.b(strH)) {
                                                                    aVar.write(String.format(Locale.US, "su binary: %s\n", strH).getBytes(Key.STRING_CHARSET_NAME));
                                                                    StringBuilder sb2 = new StringBuilder();
                                                                    sb2.append("su permission: ");
                                                                    if (com.uc.crashsdk.a.g.g()) {
                                                                        str2 = "valid (";
                                                                    } else {
                                                                        str2 = "invalid (";
                                                                    }
                                                                    sb2.append(str2);
                                                                    sb2.append(com.uc.crashsdk.a.g.i());
                                                                    sb2.append(")\n");
                                                                    aVar.write(sb2.toString().getBytes(Key.STRING_CHARSET_NAME));
                                                                }
                                                            } catch (Throwable th38) {
                                                                a(th38, aVar);
                                                            }
                                                        }
                                                        a((OutputStream) aVar);
                                                        c(aVar);
                                                        d(aVar);
                                                        com.uc.crashsdk.a.b(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                                                        if (ag) {
                                                            h = false;
                                                            try {
                                                                aVar.write(s("JAVACACHEDINFOS").getBytes(Key.STRING_CHARSET_NAME));
                                                            } catch (Throwable th39) {
                                                                a(th39, aVar);
                                                            }
                                                            h = true;
                                                        }
                                                        aVar.flush();
                                                        com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                                                        if (ag) {
                                                            h = false;
                                                            try {
                                                                aVar.write(s("JAVACALLBACKINFOS").getBytes(Key.STRING_CHARSET_NAME));
                                                            } catch (Throwable th40) {
                                                                a(th40, aVar);
                                                            }
                                                            h = true;
                                                        }
                                                        aVar.a();
                                                        a(aVar);
                                                        aVar.flush();
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
                                                        b(strA, LogType.JAVA_TYPE);
                                                        return str;
                                                    }
                                                } catch (Throwable th41) {
                                                    aVar = aVar3;
                                                    th3 = th41;
                                                    j3 = j3;
                                                    if (j3 != 0) {
                                                        b(aVar);
                                                    }
                                                    com.uc.crashsdk.a.g.a(aVar);
                                                    com.uc.crashsdk.a.g.a(fileOutputStream);
                                                    throw th3;
                                                }
                                            } catch (Throwable th42) {
                                                th = th42;
                                                aVar = aVar3;
                                            }
                                        }
                                        aVar.flush();
                                    } catch (Throwable th43) {
                                        com.uc.crashsdk.a.g.a(th43);
                                    }
                                    com.uc.crashsdk.a.b(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                                } catch (Throwable th44) {
                                    a(th44, aVar);
                                }
                                aVar.write("device status:\n".getBytes(Key.STRING_CHARSET_NAME));
                            } catch (Throwable th45) {
                                a(th45, aVar);
                            }
                            aVar.flush();
                        } catch (Throwable th46) {
                            com.uc.crashsdk.a.g.a(th46);
                        }
                        com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", null);
                    } catch (Throwable th47) {
                        a(th47, aVar);
                    }
                    aVar = aVar3;
                    a((OutputStream) aVar);
                    if (ag) {
                        h = false;
                        aVar.write(s("DEVICESTATUS").getBytes(Key.STRING_CHARSET_NAME));
                        h = true;
                    } else {
                        aVar.write(String.format(Locale.US, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes(Key.STRING_CHARSET_NAME));
                        if (Build.TAGS != null) {
                        }
                        sb = new StringBuilder();
                        sb.append("build tags: ");
                        sb.append(str4);
                        if (com.uc.crashsdk.a.g.f()) {
                            sb.append(" (default root)");
                        }
                        sb.append("\n");
                        aVar.write(sb.toString().getBytes(Key.STRING_CHARSET_NAME));
                        strH = com.uc.crashsdk.a.g.h();
                        if (com.uc.crashsdk.a.g.b(strH)) {
                            aVar.write(String.format(Locale.US, "su binary: %s\n", strH).getBytes(Key.STRING_CHARSET_NAME));
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("su permission: ");
                            if (com.uc.crashsdk.a.g.g()) {
                                str2 = "valid (";
                            } else {
                                str2 = "invalid (";
                            }
                            sb3.append(str2);
                            sb3.append(com.uc.crashsdk.a.g.i());
                            sb3.append(")\n");
                            aVar.write(sb3.toString().getBytes(Key.STRING_CHARSET_NAME));
                        }
                    }
                    a((OutputStream) aVar);
                    c(aVar);
                    d(aVar);
                    if (ag) {
                        h = false;
                        aVar.write(s("JAVACACHEDINFOS").getBytes(Key.STRING_CHARSET_NAME));
                        h = true;
                    }
                    if (ag) {
                        h = false;
                        aVar.write(s("JAVACALLBACKINFOS").getBytes(Key.STRING_CHARSET_NAME));
                        h = true;
                    }
                    aVar.a();
                    a(aVar);
                    if (j2 != 0) {
                        b(aVar);
                    }
                    com.uc.crashsdk.a.g.a(aVar);
                } catch (Throwable th48) {
                    j3 = j3;
                    th3 = th48;
                    aVar = null;
                }
            } catch (Throwable th49) {
                th2 = th49;
            }
            if (ag) {
                strA = a(m(str));
            } else {
                strA = str;
            }
            b(strA, LogType.JAVA_TYPE);
        } catch (Throwable th50) {
            com.uc.crashsdk.a.g.a(th50);
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
            outputStream.write("recent status:\n".getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ag) {
                strM = s("LASTVER");
            } else {
                strM = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", strM).getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            synchronized (s) {
                if (u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", u).getBytes(Key.STRING_CHARSET_NAME));
                }
                if (t > 0 || s.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(t)).getBytes(Key.STRING_CHARSET_NAME));
                    Iterator<String> it = s.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes(Key.STRING_CHARSET_NAME));
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "dumping all threads: %s\n", Boolean.valueOf(v)).getBytes(Key.STRING_CHARSET_NAME));
            if (w != null) {
                outputStream.write(String.format(Locale.US, "dumping threads: %s\n", w).getBytes(Key.STRING_CHARSET_NAME));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static String m(String str) throws Throwable {
        String strA = com.uc.crashsdk.a.b.a(str, g.w(), g.v());
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
        File file;
        byte[] bArrE;
        byte[] bArrB;
        if (!g.x() || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (iIndexOf = str.indexOf(95, iLastIndexOf)) <= iLastIndexOf || (iIndexOf2 = str.indexOf(95, (i2 = iIndexOf + 1))) <= iIndexOf) {
            return str;
        }
        String strD = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(iLastIndexOf + 1, iIndexOf) + str.substring(i2, iIndexOf2));
        if (strD == null || (bArrE = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || bArrE.length <= 0) {
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
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes(Key.STRING_CHARSET_NAME));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes(Key.STRING_CHARSET_NAME));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:108:0x02f7 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:110:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:111:0x0307 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:113:0x030b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0314 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0322 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:118:0x032f A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0333  */
    /* JADX WARN: Code duplicated, block: B:124:0x0342  */
    /* JADX WARN: Code duplicated, block: B:127:0x034f A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0369 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:132:0x037f A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0386 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:135:0x03a9 A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:137:0x03af A[Catch: Throwable -> 0x0440, all -> 0x0455, TryCatch #1 {all -> 0x0455, blocks: (B:142:0x03c7, B:29:0x00be, B:181:0x044b, B:31:0x00c6, B:42:0x00f4, B:47:0x0131, B:49:0x0137, B:51:0x014b, B:59:0x01cb, B:61:0x01df, B:63:0x01e3, B:64:0x01e5, B:66:0x01ea, B:67:0x01ec, B:68:0x01f1, B:78:0x0214, B:79:0x022b, B:81:0x0231, B:83:0x023a, B:84:0x0241, B:86:0x0260, B:87:0x0273, B:89:0x0285, B:91:0x0294, B:92:0x02a7, B:105:0x02e7, B:108:0x02f7, B:111:0x0307, B:114:0x0314, B:116:0x0322, B:118:0x032f, B:121:0x0336, B:125:0x0343, B:127:0x034f, B:129:0x0369, B:130:0x036e, B:132:0x037f, B:134:0x038c, B:140:0x03b7, B:145:0x03db, B:147:0x03e4, B:149:0x03ed, B:151:0x03f4, B:153:0x03fb, B:155:0x0402, B:161:0x0414, B:163:0x041b, B:165:0x0422, B:167:0x0429, B:159:0x040d, B:133:0x0386, B:135:0x03a9, B:137:0x03af, B:93:0x02ab, B:95:0x02b1, B:98:0x02b9, B:100:0x02bd, B:102:0x02d1, B:104:0x02d5, B:72:0x01fb, B:74:0x0209, B:76:0x020f, B:58:0x01c7, B:38:0x00e6, B:168:0x042f), top: B:195:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:141:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:189:0x0459 A[Catch: all -> 0x045f, TryCatch #5 {all -> 0x045f, blocks: (B:170:0x043a, B:171:0x043c, B:184:0x0453, B:183:0x0450, B:189:0x0459, B:192:0x0462), top: B:199:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0462 A[Catch: all -> 0x045f, TryCatch #5 {all -> 0x045f, blocks: (B:170:0x043a, B:171:0x043c, B:184:0x0453, B:183:0x0450, B:189:0x0459, B:192:0x0462), top: B:199:0x000a }] */
    /* JADX WARN: Code duplicated, block: B:201:0x03b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x01bf  */
    /* JADX WARN: Instruction removed from duplicated block: B:127:0x034f, please report this as an issue */
    private static void a(String str, boolean z2, boolean z3) {
        Object obj;
        Throwable th;
        ConditionVariable conditionVariable;
        int i2;
        int i3;
        boolean z4;
        File[] fileArr;
        File file;
        String str2;
        String name;
        String str3;
        boolean z5;
        int i4;
        String[] strArrSplit;
        com.uc.crashsdk.a.a.a("crashsdk", "crashsdk uploading logs");
        Object obj2 = n;
        synchronized (obj2) {
            try {
                try {
                    try {
                        try {
                            if (com.uc.crashsdk.a.g.b(str)) {
                                String strX = g.X();
                                File file2 = new File(strX);
                                if (file2.exists()) {
                                    File[] fileArrListFiles = file2.listFiles();
                                    if (fileArrListFiles == null) {
                                        com.uc.crashsdk.a.a.b("List folder failed: " + strX);
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
                                        boolean z6 = false;
                                        boolean z7 = false;
                                        boolean z8 = false;
                                        while (true) {
                                            if (i5 >= length) {
                                                obj = obj2;
                                                i2 = i6;
                                                i3 = i7;
                                                z4 = z6;
                                                break;
                                            }
                                            File file3 = fileArrListFiles[i5];
                                            int i14 = length;
                                            if (file3.isFile()) {
                                                String name2 = file3.getName();
                                                fileArr = fileArrListFiles;
                                                if (!name2.endsWith(".tmp")) {
                                                    obj = obj2;
                                                    if (file3.length() == 0) {
                                                        i6++;
                                                        com.uc.crashsdk.a.g.a(file3);
                                                    } else {
                                                        try {
                                                            if (z2) {
                                                                long jCurrentTimeMillis = (System.currentTimeMillis() - file3.lastModified()) / 1000;
                                                                boolean z9 = jCurrentTimeMillis < 0 || (jCurrentTimeMillis >= 2 && (jCurrentTimeMillis >= 5 || !file3.getName().endsWith(".log")));
                                                                z4 = z6;
                                                                i2 = i6;
                                                                i3 = i7;
                                                                com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(jCurrentTimeMillis), Boolean.valueOf(z9)));
                                                                if (!z9) {
                                                                    i8++;
                                                                }
                                                                z6 = z4;
                                                                i6 = i2;
                                                                i7 = i3;
                                                            } else {
                                                                i2 = i6;
                                                                i3 = i7;
                                                                z4 = z6;
                                                            }
                                                            if (g.k()) {
                                                                Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                                                if (matcher.matches()) {
                                                                    file = new File(g.X() + String.format(Locale.US, "%s%s_%s_%s.%s", j(matcher.group(2)), n(), Q(), matcher.group(1), matcher.group(3)));
                                                                    com.uc.crashsdk.a.a.a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                                    file3.renameTo(file);
                                                                } else {
                                                                    file = file3;
                                                                }
                                                            } else {
                                                                file = file3;
                                                            }
                                                            if (file != file3) {
                                                                i12++;
                                                            }
                                                        } catch (Throwable th2) {
                                                            com.uc.crashsdk.a.g.a(th2);
                                                            file = file3;
                                                        }
                                                        String path = file.getPath();
                                                        boolean[] zArrN = n(path);
                                                        String strB = b(path, zArrN[0], zArrN[1]);
                                                        if (path != strB) {
                                                            if (zArrN[0]) {
                                                                i10++;
                                                            }
                                                            if (zArrN[1]) {
                                                                i11++;
                                                            }
                                                            file = new File(strB);
                                                        }
                                                        File fileA = com.uc.crashsdk.d.a(file);
                                                        if (fileA == null) {
                                                            fileA = null;
                                                        } else if (file != fileA && !file.getName().equals(fileA.getName()) && file.exists()) {
                                                            file.delete();
                                                        }
                                                        if (fileA == null) {
                                                            com.uc.crashsdk.a.a.b("onBeforeUploadLog return null, skip upload: " + file.getAbsolutePath());
                                                        } else {
                                                            int iB = g.B();
                                                            if (iB <= 0 || fileA.length() < iB) {
                                                                d dVar = new d((byte) 0);
                                                                dVar.b = 0L;
                                                                dVar.a = System.currentTimeMillis();
                                                                String strU = U();
                                                                if (new File(strU).exists()) {
                                                                    a(strU, new com.uc.crashsdk.a.e(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, new Object[]{strU, dVar}));
                                                                }
                                                                long jC = g.C();
                                                                int iD = g.D();
                                                                int iE = g.E();
                                                                if (jC < 0 || dVar.b + fileA.length() <= jC) {
                                                                    if (!g.f()) {
                                                                        if (b(fileA)) {
                                                                            if (iD >= 0 && dVar.c >= iD) {
                                                                                dVar.g = true;
                                                                                str2 = "Reach max upload builtin log count: " + iD;
                                                                            }
                                                                        } else if (iE >= 0 && dVar.d >= iE) {
                                                                            dVar.f = true;
                                                                            str2 = "Reach max upload custom log count: " + iE;
                                                                        }
                                                                    }
                                                                    if (dVar.e) {
                                                                        z6 = z4;
                                                                        i6 = i2;
                                                                        i7 = i3;
                                                                        z7 = true;
                                                                    } else if (dVar.g) {
                                                                        z6 = z4;
                                                                        i6 = i2;
                                                                        i7 = i3;
                                                                        z8 = true;
                                                                    } else if (dVar.f) {
                                                                        i6 = i2;
                                                                        i7 = i3;
                                                                        z6 = true;
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
                                                                        if (str3 == null && str3.equals(g.T())) {
                                                                            z5 = true;
                                                                        } else {
                                                                            z5 = false;
                                                                        }
                                                                        if (com.uc.crashsdk.a.c.a(fileA, fileA.getName(), str)) {
                                                                            com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + fileA.getName(), null);
                                                                            if (z5) {
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
                                                                            i4 = 0;
                                                                        } else {
                                                                            i4 = i13 + 1;
                                                                            if (z5) {
                                                                                f.a(14);
                                                                            }
                                                                        }
                                                                        if (i4 >= 3) {
                                                                            com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                            break;
                                                                        }
                                                                        i13 = i4;
                                                                        z6 = z4;
                                                                        i6 = i2;
                                                                        i7 = i3;
                                                                    }
                                                                } else {
                                                                    dVar.e = true;
                                                                    str2 = "Reach max upload bytes: " + jC;
                                                                }
                                                                com.uc.crashsdk.a.a.b(str2);
                                                                if (dVar.e) {
                                                                    z6 = z4;
                                                                    i6 = i2;
                                                                    i7 = i3;
                                                                    z7 = true;
                                                                } else if (dVar.g) {
                                                                    z6 = z4;
                                                                    i6 = i2;
                                                                    i7 = i3;
                                                                    z8 = true;
                                                                } else if (dVar.f) {
                                                                    i6 = i2;
                                                                    i7 = i3;
                                                                    z6 = true;
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
                                                                        z5 = false;
                                                                    } else {
                                                                        z5 = false;
                                                                    }
                                                                    if (com.uc.crashsdk.a.c.a(fileA, fileA.getName(), str)) {
                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + fileA.getName(), null);
                                                                        if (z5) {
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
                                                                        i4 = 0;
                                                                    } else {
                                                                        i4 = i13 + 1;
                                                                        if (z5) {
                                                                            f.a(14);
                                                                        }
                                                                    }
                                                                    if (i4 >= 3) {
                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                        break;
                                                                    }
                                                                    i13 = i4;
                                                                    z6 = z4;
                                                                    i6 = i2;
                                                                    i7 = i3;
                                                                }
                                                            } else {
                                                                i9++;
                                                                com.uc.crashsdk.a.g.a(fileA);
                                                            }
                                                        }
                                                        z6 = z4;
                                                        i6 = i2;
                                                        i7 = i3;
                                                    }
                                                } else if ((System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                                    com.uc.crashsdk.a.a.b("delete legacy tmp file: " + name2);
                                                    i7++;
                                                    com.uc.crashsdk.a.g.a(file3);
                                                }
                                                i5++;
                                                length = i14;
                                                fileArrListFiles = fileArr;
                                                obj2 = obj;
                                            } else {
                                                com.uc.crashsdk.a.g.a(file3);
                                                fileArr = fileArrListFiles;
                                            }
                                            obj = obj2;
                                            i5++;
                                            length = i14;
                                            fileArrListFiles = fileArr;
                                            obj2 = obj;
                                        }
                                        if (i3 > 0) {
                                            f.a(200, i3);
                                        }
                                        if (i2 > 0) {
                                            f.a(15, i2);
                                        }
                                        if (i9 > 0) {
                                            f.a(17, i9);
                                        }
                                        if (z7) {
                                            f.a(19);
                                        }
                                        if (z8) {
                                            f.a(20);
                                        }
                                        if (z4) {
                                            f.a(21);
                                        }
                                        if (z7 || z8 || z4) {
                                            f.a(18);
                                        }
                                        if (i10 > 0) {
                                            f.a(24, i10);
                                        }
                                        if (i11 > 0) {
                                            f.a(201, i11);
                                        }
                                        if (i12 > 0) {
                                            f.a(25, i12);
                                        }
                                        if (i8 > 0) {
                                            f.a(26, i8);
                                        }
                                    }
                                } else {
                                    com.uc.crashsdk.a.a.a("crashsdk", "Folder not exist: " + strX);
                                }
                                obj = obj2;
                            } else {
                                obj = obj2;
                                com.uc.crashsdk.a.a.a("crashsdk", "upload url is empty!");
                            }
                            if (z3) {
                                conditionVariable = o;
                                conditionVariable.open();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            com.uc.crashsdk.a.g.a(th);
                            if (z3) {
                                conditionVariable = o;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = th;
                        if (z3) {
                            throw th;
                        }
                        o.open();
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = obj2;
                }
            } catch (Throwable th6) {
                throw th6;
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
            if (com.uc.crashsdk.a.f.a(!z2 ? 0 : 1, new com.uc.crashsdk.a.e(406, new Object[]{strK, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                o.close();
                if (!o.block(3000L)) {
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
            boolean zS = g.r() && com.uc.crashsdk.b.F() && !d;
            if (!zS) {
                zS = g.s();
            }
            if (!zS) {
                return;
            }
            if (z2) {
                String strK = k();
                if (!com.uc.crashsdk.a.g.a(strK)) {
                    j();
                    a(strK, false, false);
                    return;
                }
                return;
            }
            a(true, false);
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
        return g.W() + "bytes";
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) throws IOException {
        Exception e;
        boolean zA;
        ?? r1;
        synchronized (p) {
            ?? file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            FileLock fileLockLock = null;
            try {
                try {
                    try {
                        file = new RandomAccessFile((File) file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        file = 0;
                        com.uc.crashsdk.a.g.a((Closeable) file);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        file = 0;
                    } catch (Exception e4) {
                        file = 0;
                        e = e4;
                        zA = false;
                        com.uc.crashsdk.a.g.a(e);
                        r1 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r1);
                        return zA;
                    }
                }
                if (file != 0) {
                    try {
                        fileLockLock = file.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            zA = false;
                            com.uc.crashsdk.a.g.a(e);
                            r1 = file;
                            com.uc.crashsdk.a.g.a((Closeable) r1);
                            return zA;
                        }
                    }
                    try {
                        zA = eVar.a();
                        r1 = file;
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                                r1 = file;
                            } catch (Exception e7) {
                                try {
                                    com.uc.crashsdk.a.g.a(e7);
                                    r1 = file;
                                } catch (Exception e8) {
                                    e = e8;
                                    com.uc.crashsdk.a.g.a(e);
                                    r1 = file;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (Exception e9) {
                                com.uc.crashsdk.a.g.a(e9);
                            }
                        }
                        throw th2;
                    }
                } else {
                    zA = eVar.a();
                    r1 = file;
                    if (fileLockLock != null) {
                        fileLockLock.release();
                        r1 = file;
                    }
                }
                com.uc.crashsdk.a.g.a((Closeable) r1);
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
        if (!LogType.JAVA_TYPE.equals(strSubstring) && !"ucebujava".equals(strSubstring) && !LogType.NATIVE_TYPE.equals(strSubstring) && !"ucebujni".equals(strSubstring) && !LogType.UNEXP_TYPE.equals(strSubstring) && !LogType.ANR_TYPE.equals(strSubstring)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    private static boolean[] n(String str) {
        boolean zV = g.v();
        boolean zX = g.x();
        if (zV || zX) {
            if (!str.endsWith(".tmp") && !str.contains(".ec")) {
                int iLastIndexOf = str.lastIndexOf(File.separatorChar);
                if (iLastIndexOf < 0) {
                    iLastIndexOf = 0;
                }
                int i2 = 0;
                do {
                    iLastIndexOf = str.indexOf(95, iLastIndexOf);
                    if (iLastIndexOf >= 0) {
                        i2++;
                        iLastIndexOf++;
                    }
                } while (iLastIndexOf >= 0);
                if (i2 == 8) {
                    String strW = g.w();
                    if (!str.endsWith(".log")) {
                        if (com.uc.crashsdk.a.g.a(strW) || !str.endsWith(strW)) {
                            zV = false;
                            zX = false;
                        }
                    } else if (com.uc.crashsdk.a.g.a(strW) || str.indexOf(".log", str.lastIndexOf(95)) != str.lastIndexOf(".log")) {
                    }
                    zV = false;
                } else {
                    zV = false;
                    zX = false;
                }
            } else {
                zV = false;
                zX = false;
            }
        }
        return new boolean[]{zV, zX};
    }

    private static String b(String str, boolean z2, boolean z3) throws Throwable {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (z3) {
            try {
                return a(str);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
                return str;
            }
        }
        return str;
    }

    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        long j4;
        boolean z2;
        boolean zA;
        String strA;
        long jNativeClientCreateConnection;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ag || com.uc.crashsdk.b.L();
        if (!z3 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c(ULog.L_DEBUG, com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String str3 = g.X() + k(str);
        boolean z4 = (j2 & 32) != 0;
        if (z3) {
            if (com.uc.crashsdk.b.d) {
                jNativeClientCreateConnection = JNIBridge.nativeClientCreateConnection(str3, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, str, z4 ? 1 : 0);
            } else {
                jNativeClientCreateConnection = 0;
            }
            if (jNativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "skip custom log: " + str);
                return false;
            }
            j3 = jNativeClientCreateConnection;
        } else {
            if (a(h(), str, z4)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (q) {
            j4 = j3;
            z2 = z4;
            zA = a(str3, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (zA && !z3) {
            b(h(), str, z2);
        }
        if (j4 != 0) {
            JNIBridge.nativeClientCloseConnection(j4);
        }
        if (!zA) {
            return false;
        }
        if (!z3) {
            r(str3);
        }
        if (!z3) {
            strA = a(m(str3));
        } else {
            strA = str3;
        }
        b(strA, str);
        if (z2 && !z3) {
            try {
                a(true, false);
                return true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
                return true;
            }
        }
        return true;
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

    /* JADX WARN: Code duplicated, block: B:26:0x0089  */
    private static boolean o(String str) {
        boolean z2;
        boolean z3;
        FileWriter fileWriter;
        int i2;
        int iF;
        synchronized (r) {
            File file = new File(g.W() + "customlog");
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
                        iF = g.F();
                        if (iF >= 0 || i2 < iF) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(j2), Integer.valueOf(i2 + 1)));
                        z2 = true;
                        break;
                    }
                    j2 = jCurrentTimeMillis;
                    i2 = 0;
                    iF = g.F();
                    if (iF >= 0) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(j2), Integer.valueOf(i2 + 1)));
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(jCurrentTimeMillis)));
            }
            try {
                fileWriter = new FileWriter(file);
                try {
                    try {
                        String string = stringBuffer.toString();
                        fileWriter.write(string, 0, string.length());
                    } catch (Exception e2) {
                        e = e2;
                        com.uc.crashsdk.a.g.a(e);
                    }
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    com.uc.crashsdk.a.g.a(fileWriter);
                    throw th2;
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th3) {
                th = th3;
                fileWriter = null;
                Throwable th4 = th;
                com.uc.crashsdk.a.g.a(fileWriter);
                throw th4;
            }
            com.uc.crashsdk.a.g.a(fileWriter);
        }
        return z3;
    }

    private static void a(a aVar, String str, long j2) throws Throwable {
        String strNativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            strNativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (!ag && strNativeDumpThreads != null && strNativeDumpThreads.length() < 512 && strNativeDumpThreads.startsWith("/") && strNativeDumpThreads.indexOf(10) < 0) {
                if (!new File(strNativeDumpThreads).exists()) {
                    str2 = "Can not found " + strNativeDumpThreads;
                }
                String str3 = str2;
                str2 = strNativeDumpThreads;
                strNativeDumpThreads = str3;
            } else {
                str2 = strNativeDumpThreads;
            }
        } else {
            strNativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (strNativeDumpThreads != null) {
            try {
                aVar.write(strNativeDumpThreads.getBytes(Key.STRING_CHARSET_NAME));
                aVar.write("\n".getBytes(Key.STRING_CHARSET_NAME));
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

    /* JADX WARN: Code duplicated, block: B:102:0x0136 A[Catch: all -> 0x005e, Throwable -> 0x0062, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0143 A[Catch: all -> 0x005e, Throwable -> 0x0062, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x014f A[Catch: all -> 0x005e, Throwable -> 0x0062, TRY_LEAVE, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0169 A[Catch: all -> 0x019a, TryCatch #11 {, blocks: (B:114:0x0160, B:116:0x0169, B:118:0x0179, B:119:0x017e, B:121:0x0182, B:122:0x0189, B:123:0x018c, B:125:0x0190, B:126:0x0198), top: B:157:0x0160, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0179 A[Catch: all -> 0x019a, TryCatch #11 {, blocks: (B:114:0x0160, B:116:0x0169, B:118:0x0179, B:119:0x017e, B:121:0x0182, B:122:0x0189, B:123:0x018c, B:125:0x0190, B:126:0x0198), top: B:157:0x0160, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0182 A[Catch: all -> 0x019a, TryCatch #11 {, blocks: (B:114:0x0160, B:116:0x0169, B:118:0x0179, B:119:0x017e, B:121:0x0182, B:122:0x0189, B:123:0x018c, B:125:0x0190, B:126:0x0198), top: B:157:0x0160, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0190 A[Catch: all -> 0x019a, TryCatch #11 {, blocks: (B:114:0x0160, B:116:0x0169, B:118:0x0179, B:119:0x017e, B:121:0x0182, B:122:0x0189, B:123:0x018c, B:125:0x0190, B:126:0x0198), top: B:157:0x0160, outer: #3 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0046  */
    /* JADX WARN: Code duplicated, block: B:31:0x004d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    /* JADX WARN: Code duplicated, block: B:47:0x0092 A[Catch: all -> 0x005e, Throwable -> 0x0062, TRY_LEAVE, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x009f A[Catch: all -> 0x005e, Throwable -> 0x0062, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac A[Catch: all -> 0x005e, Throwable -> 0x0062, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00bb A[Catch: all -> 0x005e, Throwable -> 0x0062, TryCatch #5 {Throwable -> 0x0062, blocks: (B:34:0x005a, B:45:0x0085, B:47:0x0092, B:51:0x009a, B:53:0x009f, B:55:0x00a5, B:57:0x00ac, B:59:0x00b2, B:61:0x00bb, B:63:0x00c1, B:74:0x00e3, B:79:0x00ef, B:78:0x00ec, B:73:0x00e0, B:93:0x011b, B:99:0x012a, B:98:0x0127, B:92:0x0118, B:87:0x0107, B:100:0x012c, B:102:0x0136, B:103:0x0139, B:105:0x0143, B:108:0x014f, B:68:0x00cf, B:44:0x0082), top: B:145:0x005a, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fe  */
    private static boolean a(String str, long j2, StringBuffer stringBuffer, String str2, long j3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str3) {
        Throwable th;
        FileOutputStream fileOutputStream;
        a aVar;
        if (j2 == 0) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                aVar = null;
                com.uc.crashsdk.a.g.a(th);
                if (aVar == null) {
                    com.uc.crashsdk.a.g.a(aVar);
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    return false;
                }
                if ((j3 & 1) != 0) {
                    try {
                        try {
                            b(aVar, str, str2);
                        } catch (Throwable th3) {
                            a(th3, aVar);
                        }
                    } catch (Throwable th4) {
                        com.uc.crashsdk.a.g.a(aVar);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        throw th4;
                    }
                }
                try {
                    aVar.write(stringBuffer.toString().getBytes());
                    aVar.write("\n".getBytes(Key.STRING_CHARSET_NAME));
                    aVar.flush();
                } catch (Throwable th5) {
                    a(th5, aVar);
                }
                a((OutputStream) aVar);
                if ((j3 & 4) != 0) {
                    b((OutputStream) aVar);
                    try {
                        aVar.flush();
                    } catch (Throwable th6) {
                        com.uc.crashsdk.a.g.a(th6);
                    }
                }
                if (arrayList != null) {
                    com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, arrayList);
                }
                if (arrayList2 != null) {
                    com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
                }
                if (arrayList3 != null) {
                    com.uc.crashsdk.a.b(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
                }
                if (str3 != null) {
                    try {
                        aVar.flush();
                    } catch (Throwable th7) {
                        a(th7, aVar);
                    }
                    try {
                        aVar.write("threads dump:\n".getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th8) {
                        a(th8, aVar);
                    }
                    h = false;
                    w = str3;
                    try {
                        a(aVar, str3, j2);
                    } catch (Throwable th9) {
                        a(th9, aVar);
                    }
                    w = null;
                    h = true;
                }
                if ((j3 & 8) != 0) {
                    try {
                        aVar.flush();
                    } catch (Throwable th10) {
                        a(th10, aVar);
                    }
                    try {
                        aVar.write("all threads dump:\n".getBytes(Key.STRING_CHARSET_NAME));
                    } catch (Throwable th11) {
                        a(th11, aVar);
                    }
                    v = true;
                    try {
                        a(aVar, "all", 0L);
                    } catch (Throwable th12) {
                        a(th12, aVar);
                    }
                    v = false;
                }
                if ((j3 & 16) != 0) {
                    e(aVar);
                }
                if ((j3 & 2) != 0) {
                    aVar.a();
                    a(aVar);
                }
                if (j2 != 0) {
                    b(aVar);
                }
                com.uc.crashsdk.a.g.a(aVar);
                com.uc.crashsdk.a.g.a(fileOutputStream);
                try {
                    synchronized (s) {
                        t++;
                        if (u != null) {
                            s.add(u);
                            if (s.size() > 3) {
                                s.remove(0);
                            }
                            if (com.uc.crashsdk.b.d) {
                                JNIBridge.set(WorkQueueKt.MASK, u);
                            }
                            u = null;
                        }
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(25, t);
                        }
                        return true;
                    }
                } catch (Throwable th13) {
                    com.uc.crashsdk.a.g.a(th13);
                }
            }
        } else {
            fileOutputStream = null;
        }
        try {
            aVar = new a(j2, fileOutputStream);
            try {
                synchronized (s) {
                    u = str;
                    if (com.uc.crashsdk.b.d) {
                        JNIBridge.set(126, u);
                    }
                }
            } catch (Throwable th14) {
                th = th14;
                com.uc.crashsdk.a.g.a(th);
            }
        } catch (Throwable th15) {
            th = th15;
            aVar = null;
            com.uc.crashsdk.a.g.a(th);
            if (aVar == null) {
                com.uc.crashsdk.a.g.a(aVar);
                com.uc.crashsdk.a.g.a(fileOutputStream);
                return false;
            }
            if ((j3 & 1) != 0) {
                b(aVar, str, str2);
            }
            aVar.write(stringBuffer.toString().getBytes());
            aVar.write("\n".getBytes(Key.STRING_CHARSET_NAME));
            aVar.flush();
            a((OutputStream) aVar);
            if ((j3 & 4) != 0) {
                b((OutputStream) aVar);
                aVar.flush();
            }
            if (arrayList != null) {
                com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, arrayList);
            }
            if (arrayList2 != null) {
                com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
            }
            if (arrayList3 != null) {
                com.uc.crashsdk.a.b(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
            }
            if (str3 != null) {
                aVar.flush();
                aVar.write("threads dump:\n".getBytes(Key.STRING_CHARSET_NAME));
                h = false;
                w = str3;
                a(aVar, str3, j2);
                w = null;
                h = true;
            }
            if ((j3 & 8) != 0) {
                aVar.flush();
                aVar.write("all threads dump:\n".getBytes(Key.STRING_CHARSET_NAME));
                v = true;
                a(aVar, "all", 0L);
                v = false;
            }
            if ((j3 & 16) != 0) {
                e(aVar);
            }
            if ((j3 & 2) != 0) {
                aVar.a();
                a(aVar);
            }
            if (j2 != 0) {
                b(aVar);
            }
            com.uc.crashsdk.a.g.a(aVar);
            com.uc.crashsdk.a.g.a(fileOutputStream);
            synchronized (s) {
                t++;
                if (u != null) {
                    s.add(u);
                    if (s.size() > 3) {
                        s.remove(0);
                    }
                    if (com.uc.crashsdk.b.d) {
                        JNIBridge.set(WorkQueueKt.MASK, u);
                    }
                    u = null;
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(25, t);
                }
                return true;
            }
        }
        if (aVar == null) {
            com.uc.crashsdk.a.g.a(aVar);
            com.uc.crashsdk.a.g.a(fileOutputStream);
            return false;
        }
        if ((j3 & 1) != 0) {
            b(aVar, str, str2);
        }
        aVar.write(stringBuffer.toString().getBytes());
        aVar.write("\n".getBytes(Key.STRING_CHARSET_NAME));
        aVar.flush();
        a((OutputStream) aVar);
        if ((j3 & 4) != 0) {
            b((OutputStream) aVar);
            aVar.flush();
        }
        if (arrayList != null && arrayList.size() > 0) {
            com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            com.uc.crashsdk.a.a(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            com.uc.crashsdk.a.b(aVar, Key.STRING_CHARSET_NAME, "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str3 != null) {
            aVar.flush();
            aVar.write("threads dump:\n".getBytes(Key.STRING_CHARSET_NAME));
            h = false;
            w = str3;
            a(aVar, str3, j2);
            w = null;
            h = true;
        }
        if ((j3 & 8) != 0 && j2 == 0) {
            aVar.flush();
            aVar.write("all threads dump:\n".getBytes(Key.STRING_CHARSET_NAME));
            v = true;
            a(aVar, "all", 0L);
            v = false;
        }
        if ((j3 & 16) != 0) {
            e(aVar);
        }
        if ((j3 & 2) != 0) {
            aVar.a();
            a(aVar);
        }
        if (j2 != 0) {
            b(aVar);
        }
        com.uc.crashsdk.a.g.a(aVar);
        com.uc.crashsdk.a.g.a(fileOutputStream);
        synchronized (s) {
            t++;
            if (u != null) {
                s.add(u);
                if (s.size() > 3) {
                    s.remove(0);
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(WorkQueueKt.MASK, u);
                }
                u = null;
            }
            if (com.uc.crashsdk.b.d) {
                JNIBridge.set(25, t);
            }
        }
        return true;
    }

    public static String k() {
        String strA = x;
        if (com.uc.crashsdk.a.g.a(strA)) {
            synchronized (y) {
                strA = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.y(), true);
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

    /* JADX WARN: Code duplicated, block: B:38:0x00b0 A[Catch: all -> 0x010e, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000a, B:7:0x001a, B:9:0x0025, B:10:0x002f, B:38:0x00b0, B:49:0x00d5, B:68:0x010c, B:64:0x0101, B:56:0x00f2, B:52:0x00e0, B:11:0x0035, B:13:0x003d, B:14:0x0046, B:16:0x004e, B:18:0x0056, B:20:0x005e, B:26:0x006c, B:28:0x0076, B:30:0x0083, B:32:0x008d, B:33:0x0098, B:35:0x00a2), top: B:74:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e0 A[Catch: all -> 0x010e, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000a, B:7:0x001a, B:9:0x0025, B:10:0x002f, B:38:0x00b0, B:49:0x00d5, B:68:0x010c, B:64:0x0101, B:56:0x00f2, B:52:0x00e0, B:11:0x0035, B:13:0x003d, B:14:0x0046, B:16:0x004e, B:18:0x0056, B:20:0x005e, B:26:0x006c, B:28:0x0076, B:30:0x0083, B:32:0x008d, B:33:0x0098, B:35:0x00a2), top: B:74:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f2 A[Catch: all -> 0x010e, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x000a, B:7:0x001a, B:9:0x0025, B:10:0x002f, B:38:0x00b0, B:49:0x00d5, B:68:0x010c, B:64:0x0101, B:56:0x00f2, B:52:0x00e0, B:11:0x0035, B:13:0x003d, B:14:0x0046, B:16:0x004e, B:18:0x0056, B:20:0x005e, B:26:0x006c, B:28:0x0076, B:30:0x0083, B:32:0x008d, B:33:0x0098, B:35:0x00a2), top: B:74:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:67:0x010b  */
    private static boolean p(String str) {
        int iIntValue;
        Integer num;
        boolean z2;
        long j2;
        long j3;
        long j4;
        long jB;
        long jCurrentTimeMillis;
        synchronized (z) {
            if (A == null) {
                A = q(com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.l(), "all:1", false));
            }
            if (A.containsKey("all")) {
                num = A.get("all");
            } else if (A.containsKey(str)) {
                num = A.get(str);
            } else {
                boolean z3 = LogType.JAVA_TYPE.equals(str) || LogType.NATIVE_TYPE.equals(str) || LogType.ANR_TYPE.equals(str) || LogType.UNEXP_TYPE.equals(str);
                if (z3 && A.containsKey(AVErrorInfo.CRASH)) {
                    num = A.get(AVErrorInfo.CRASH);
                } else if (z3 || !A.containsKey("nocrash")) {
                    if (A.containsKey("other")) {
                        num = A.get("other");
                    } else {
                        iIntValue = 1;
                    }
                    if (iIntValue != 0) {
                        j2 = iIntValue;
                        if (j2 < 0) {
                            j4 = 30;
                            if (j2 == -2) {
                                j4 = 7;
                            } else if (j2 == -3) {
                                j4 = 15;
                            } else if (j2 == -4) {
                                j4 = 60;
                            }
                            jB = com.uc.crashsdk.a.b();
                            if (jB == 0) {
                                jCurrentTimeMillis = -1;
                            } else {
                                jCurrentTimeMillis = (System.currentTimeMillis() - jB) / 86400000;
                            }
                            if (jCurrentTimeMillis <= j4) {
                                j3 = 1;
                            } else {
                                j3 = jCurrentTimeMillis - j4;
                            }
                        } else {
                            j3 = j2;
                        }
                        if (j3 == 1 && j3 > 0 && System.currentTimeMillis() % j3 != 0) {
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
                    j4 = 30;
                    if (j2 == -2) {
                        j4 = 7;
                    } else if (j2 == -3) {
                        j4 = 15;
                    } else if (j2 == -4) {
                        j4 = 60;
                    }
                    jB = com.uc.crashsdk.a.b();
                    if (jB == 0) {
                        jCurrentTimeMillis = -1;
                    } else {
                        jCurrentTimeMillis = (System.currentTimeMillis() - jB) / 86400000;
                    }
                    if (jCurrentTimeMillis <= j4) {
                        j3 = 1;
                    } else {
                        j3 = jCurrentTimeMillis - j4;
                    }
                } else {
                    j3 = j2;
                }
                z2 = j3 == 1;
            }
        }
        return z2;
    }

    private static Map<String, Integer> q(String str) {
        int i2;
        HashMap map = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] strArrSplit = str2.split(":", 3);
            if (strArrSplit.length == 2) {
                String strTrim = strArrSplit[0].trim();
                if (!com.uc.crashsdk.a.g.a(strTrim)) {
                    try {
                        i2 = Integer.parseInt(strArrSplit[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                        i2 = 1;
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
        if (!g.q()) {
            return;
        }
        try {
            ab();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        if (str == null || "".equals(str)) {
            return;
        }
        try {
            File file = new File(g.Y());
            if (!file.exists()) {
                file.mkdirs();
            }
            com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
            com.uc.crashsdk.a.g.a(new File(str), file);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0055 A[Catch: Throwable -> 0x006f, TRY_LEAVE, TryCatch #0 {Throwable -> 0x006f, blocks: (B:6:0x000b, B:8:0x002b, B:20:0x004f, B:22:0x0055), top: B:32:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0066 A[Catch: Throwable -> 0x0046, TRY_LEAVE, TryCatch #2 {Throwable -> 0x0046, blocks: (B:10:0x0034, B:13:0x003d, B:18:0x004b, B:23:0x0060, B:25:0x0066), top: B:34:0x0034, inners: #1 }] */
    public static void p() {
        String string;
        if (!com.uc.crashsdk.a.g.a(B)) {
            return;
        }
        String strReplaceAll = null;
        try {
            File file = new File(g.W() + "unique");
            if (file.exists()) {
                string = com.uc.crashsdk.a.g.a(file, 48, false);
                if (string != null) {
                    try {
                        try {
                            if (string.length() == 36) {
                                strReplaceAll = string.replaceAll("[^0-9a-zA-Z-]", "-");
                            }
                        } catch (Exception e) {
                            com.uc.crashsdk.a.g.a(e);
                            strReplaceAll = string;
                        }
                        if (com.uc.crashsdk.a.g.a(strReplaceAll)) {
                            com.uc.crashsdk.b.G();
                            string = UUID.randomUUID().toString();
                            if (!com.uc.crashsdk.a.g.a(string)) {
                                com.uc.crashsdk.a.g.a(file, string.getBytes());
                            }
                            strReplaceAll = string;
                        }
                    } catch (Throwable th) {
                        th = th;
                        strReplaceAll = string;
                        com.uc.crashsdk.a.g.a(th);
                    }
                } else {
                    strReplaceAll = string;
                    if (com.uc.crashsdk.a.g.a(strReplaceAll)) {
                        com.uc.crashsdk.b.G();
                        string = UUID.randomUUID().toString();
                        if (!com.uc.crashsdk.a.g.a(string)) {
                            com.uc.crashsdk.a.g.a(file, string.getBytes());
                        }
                        strReplaceAll = string;
                    }
                }
            } else if (com.uc.crashsdk.a.g.a(strReplaceAll)) {
                com.uc.crashsdk.b.G();
                string = UUID.randomUUID().toString();
                if (!com.uc.crashsdk.a.g.a(string)) {
                    com.uc.crashsdk.a.g.a(file, string.getBytes());
                }
                strReplaceAll = string;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        B = strReplaceAll;
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
            outputStream.write(String.format(Locale.US, "$^%s`%s`%d`%d,%d^$", str, str2, Integer.valueOf(i2), Integer.valueOf(z2 ? 1 : 0), Integer.valueOf(z3 ? 1 : 0)).getBytes(Key.STRING_CHARSET_NAME));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes(Key.STRING_CHARSET_NAME));
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
                int unused6 = e.H = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
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
            if (!V()) {
                return;
            }
            context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
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
                    JNIBridge.set(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, processErrorStateInfo.longMsg);
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
        if (!O && !com.uc.crashsdk.b.F() && !com.uc.crashsdk.b.L()) {
            JNIBridge.cmd(18);
        }
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
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            String str = " (?)";
            switch (F) {
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
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            String str2 = " (?)";
            int i2 = G;
            if (i2 != 4) {
                switch (i2) {
                    case 0:
                        str2 = " (None)";
                        break;
                    case 1:
                        str2 = " (AC charger)";
                        break;
                    case 2:
                        str2 = " (USB port)";
                        break;
                }
            } else {
                str2 = " (Wireless)";
            }
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            String str3 = " (?)";
            switch (H) {
                case 1:
                    str3 = " (Unknown)";
                    break;
                case 2:
                    str3 = " (Charging)";
                    break;
                case 3:
                    str3 = " (Discharging)";
                    break;
                case 4:
                    str3 = " (Not charging)";
                    break;
                case 5:
                    str3 = " (Full)";
                    break;
            }
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (!com.uc.crashsdk.a.f.b(P)) {
                com.uc.crashsdk.a.f.a(0, P, 2000L);
            }
        }
    }

    public static void b(Context context) {
        if (!g.M()) {
            return;
        }
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

    static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.M() : z2 && g.M()) {
            z3 = false;
        }
        if (z3) {
            if (com.uc.crashsdk.a.f.b(S)) {
                com.uc.crashsdk.a.f.a(S);
            }
            com.uc.crashsdk.a.f.a(0, S, 3000L);
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
    public void uncaughtException(Thread thread, Throwable th) throws Throwable {
        a(thread, th, false);
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    static boolean u() {
        return c.get() || aa();
    }

    /* JADX WARN: Code duplicated, block: B:170:0x027d  */
    /* JADX WARN: Code duplicated, block: B:212:0x030a  */
    /* JADX WARN: Code duplicated, block: B:271:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:321:0x0453  */
    /* JADX WARN: Code duplicated, block: B:381:0x0562  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:437:0x062f  */
    /* JADX WARN: Code duplicated, block: B:485:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:487:0x06c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:489:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:496:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:499:0x06f3 A[Catch: Throwable -> 0x070c, TryCatch #31 {Throwable -> 0x070c, blocks: (B:494:0x06d2, B:497:0x06de, B:499:0x06f3, B:501:0x06f7, B:502:0x06fc, B:505:0x0704), top: B:571:0x06d2 }] */
    /* JADX WARN: Code duplicated, block: B:504:0x0702 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:511:0x071a  */
    /* JADX WARN: Code duplicated, block: B:560:0x06a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0109  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:147:0x023b -> B:526:0x0244). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:151:0x0241 -> B:526:0x0244). Please report as a decompilation issue!!! */
    public final void a(Thread thread, Throwable th, boolean z2) throws Throwable {
        Throwable th2;
        Throwable th3;
        boolean z3;
        Throwable th4;
        boolean z4;
        boolean z5;
        boolean zI;
        Throwable th5;
        boolean z6;
        boolean z7;
        Throwable th6;
        boolean z8;
        Throwable th7;
        boolean z9;
        boolean zT;
        String str;
        long jNativeClientCreateConnection;
        Throwable th8;
        boolean z10;
        Throwable th9;
        boolean z11;
        Throwable th10;
        boolean z12;
        boolean z13;
        Throwable th11;
        boolean z14;
        Throwable th12;
        boolean z15;
        Throwable th13;
        boolean z16;
        boolean z17 = (ag && com.uc.crashsdk.b.d) || com.uc.crashsdk.b.L();
        long j2 = 0;
        try {
            try {
                if (c.getAndSet(true)) {
                    try {
                        try {
                            if (Process.myPid() > 0) {
                                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "another thread is generating java report!");
                                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "current thread exception is:");
                                a(th);
                                int i2 = 0;
                                while (!V) {
                                    try {
                                        Thread.sleep(1000L);
                                    } catch (Throwable th14) {
                                        com.uc.crashsdk.a.g.a(th14);
                                    }
                                    i2++;
                                    if (i2 >= 4) {
                                        break;
                                    }
                                }
                                Process.killProcess(Process.myPid());
                                if (z2) {
                                    try {
                                        if (!g.r() || z17) {
                                            z8 = false;
                                        } else {
                                            try {
                                                a(true, false);
                                                z8 = true;
                                            } catch (Throwable th15) {
                                                th6 = th15;
                                                z8 = true;
                                                com.uc.crashsdk.a.g.a(th6);
                                            }
                                        }
                                    } catch (Throwable th16) {
                                        th6 = th16;
                                        z8 = false;
                                    }
                                } else {
                                    z8 = false;
                                }
                                if (!z8 && !z17) {
                                    b(false);
                                }
                                try {
                                    f.c(false);
                                } catch (Throwable th17) {
                                    com.uc.crashsdk.a.g.a(th17);
                                }
                                try {
                                    boolean zI2 = g.i();
                                    if (!com.uc.crashsdk.a.d.e()) {
                                        zI2 = true;
                                    }
                                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI2);
                                    if (zI2 && T != null) {
                                        T.uncaughtException(thread, th);
                                    }
                                    if (com.uc.crashsdk.b.B() && !z17) {
                                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                    }
                                } catch (Throwable th18) {
                                    com.uc.crashsdk.a.g.a(th18);
                                }
                                V = true;
                                if (Process.myPid() > 0) {
                                    Process.killProcess(Process.myPid());
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th19) {
                            th3 = th19;
                            z3 = false;
                        }
                    } catch (Throwable th20) {
                        th2 = th20;
                        if (j2 != 0 && com.uc.crashsdk.b.d) {
                            JNIBridge.nativeClientCloseConnection(j2);
                        }
                        if (!z2) {
                            try {
                                if (g.r() || z17) {
                                    z4 = false;
                                } else {
                                    try {
                                        a(true, false);
                                        z4 = true;
                                    } catch (Throwable th21) {
                                        th4 = th21;
                                        z4 = true;
                                        com.uc.crashsdk.a.g.a(th4);
                                        if (!z4 || z17) {
                                            z5 = false;
                                        } else {
                                            z5 = false;
                                            b(false);
                                        }
                                        f.c(z5);
                                        zI = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                            zI = true;
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI);
                                        if (zI && T != null) {
                                            T.uncaughtException(thread, th);
                                        }
                                        if (com.uc.crashsdk.b.B() && !z17) {
                                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                        }
                                        V = true;
                                        if (Process.myPid() <= 0) {
                                            throw th2;
                                        }
                                        Process.killProcess(Process.myPid());
                                        throw th2;
                                    }
                                }
                            } catch (Throwable th22) {
                                th4 = th22;
                                z4 = false;
                            }
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            z5 = false;
                        } else {
                            z5 = false;
                        }
                        try {
                            f.c(z5);
                        } catch (Throwable th23) {
                            com.uc.crashsdk.a.g.a(th23);
                        }
                        try {
                            zI = g.i();
                            if (!com.uc.crashsdk.a.d.e()) {
                                zI = true;
                            }
                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI);
                            if (zI) {
                                T.uncaughtException(thread, th);
                            }
                            if (com.uc.crashsdk.b.B()) {
                                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                            }
                        } catch (Throwable th24) {
                            com.uc.crashsdk.a.g.a(th24);
                        }
                        V = true;
                        if (Process.myPid() <= 0) {
                            throw th2;
                        }
                        Process.killProcess(Process.myPid());
                        throw th2;
                    }
                }
                U = th;
                if (!z17 && !com.uc.crashsdk.a.d.e()) {
                    com.uc.crashsdk.a.a.c(ULog.L_DEBUG, com.uc.crashsdk.a.d.b());
                    if (z2) {
                        try {
                            if (!g.r() || z17) {
                                z16 = false;
                            } else {
                                try {
                                    a(true, false);
                                    z16 = true;
                                } catch (Throwable th25) {
                                    th13 = th25;
                                    z16 = true;
                                    com.uc.crashsdk.a.g.a(th13);
                                }
                            }
                        } catch (Throwable th26) {
                            th13 = th26;
                            z16 = false;
                        }
                    } else {
                        z16 = false;
                    }
                    if (!z16 && !z17) {
                        b(false);
                    }
                    try {
                        f.c(false);
                    } catch (Throwable th27) {
                        com.uc.crashsdk.a.g.a(th27);
                    }
                    try {
                        boolean zI3 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            zI3 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI3);
                        if (zI3 && T != null) {
                            T.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z17) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                    } catch (Throwable th28) {
                        com.uc.crashsdk.a.g.a(th28);
                    }
                    V = true;
                    if (Process.myPid() > 0) {
                        Process.killProcess(Process.myPid());
                        return;
                    }
                    return;
                }
                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "encryptLog: " + g.x() + ", zipCrashLog: " + g.x());
                if (g.a != null) {
                    com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "the set zip log to false stack is:");
                    g.a.printStackTrace();
                }
                if (g.b != null) {
                    com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "the set encrypt to true stack is:");
                    g.b.printStackTrace();
                }
                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "begin to generate java report");
                try {
                    N();
                } catch (Throwable th29) {
                    com.uc.crashsdk.a.g.a(th29);
                }
                try {
                    zT = g.t();
                    try {
                        String strG = g.g();
                        if (strG == null || strG.equals("")) {
                            strG = k(S());
                        }
                        str = g.X() + strG;
                        z3 = false;
                    } catch (Throwable th30) {
                        z9 = zT;
                        th7 = th30;
                        com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "get java log name failed: " + th7);
                        a(th7);
                        com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "original exception is: " + th);
                        a(th);
                        zT = z9;
                        z3 = true;
                        str = null;
                    }
                } catch (Throwable th31) {
                    th7 = th31;
                    z9 = false;
                }
                try {
                    try {
                        try {
                            if (z17) {
                                if (zT) {
                                    str = "omit";
                                    com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "omit java crash");
                                }
                                try {
                                    jNativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(str, LogType.JAVA_TYPE, null, 0) : 0L;
                                    if (jNativeClientCreateConnection == 0) {
                                        com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "skip java crash:");
                                        a(th);
                                        if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                            JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                                        }
                                        if (z2) {
                                            try {
                                                if (!g.r() || z17) {
                                                    z15 = false;
                                                } else {
                                                    try {
                                                        a(true, false);
                                                        z15 = true;
                                                    } catch (Throwable th32) {
                                                        th12 = th32;
                                                        z15 = true;
                                                        com.uc.crashsdk.a.g.a(th12);
                                                    }
                                                }
                                            } catch (Throwable th33) {
                                                th12 = th33;
                                                z15 = false;
                                            }
                                        } else {
                                            z15 = false;
                                        }
                                        if (!z15 && !z17) {
                                            b(false);
                                        }
                                        try {
                                            f.c(false);
                                        } catch (Throwable th34) {
                                            com.uc.crashsdk.a.g.a(th34);
                                        }
                                        try {
                                            boolean zI4 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                                zI4 = true;
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI4);
                                            if (zI4 && T != null) {
                                                T.uncaughtException(thread, th);
                                            }
                                            if (com.uc.crashsdk.b.B() && !z17) {
                                                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                            }
                                        } catch (Throwable th35) {
                                            com.uc.crashsdk.a.g.a(th35);
                                        }
                                        V = true;
                                        if (Process.myPid() > 0) {
                                            Process.killProcess(Process.myPid());
                                            return;
                                        }
                                        return;
                                    }
                                    if (zT) {
                                        if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                            JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                                        }
                                        if (z2) {
                                            try {
                                                if (!g.r() || z17) {
                                                    z14 = false;
                                                } else {
                                                    try {
                                                        a(true, false);
                                                        z14 = true;
                                                    } catch (Throwable th36) {
                                                        th11 = th36;
                                                        z14 = true;
                                                        com.uc.crashsdk.a.g.a(th11);
                                                    }
                                                }
                                            } catch (Throwable th37) {
                                                th11 = th37;
                                                z14 = false;
                                            }
                                        } else {
                                            z14 = false;
                                        }
                                        if (!z14 && !z17) {
                                            b(false);
                                        }
                                        try {
                                            f.c(false);
                                        } catch (Throwable th38) {
                                            com.uc.crashsdk.a.g.a(th38);
                                        }
                                        try {
                                            boolean zI5 = g.i();
                                            if (!com.uc.crashsdk.a.d.e()) {
                                                zI5 = true;
                                            }
                                            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI5);
                                            if (zI5 && T != null) {
                                                T.uncaughtException(thread, th);
                                            }
                                            if (com.uc.crashsdk.b.B() && !z17) {
                                                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                            }
                                        } catch (Throwable th39) {
                                            com.uc.crashsdk.a.g.a(th39);
                                        }
                                        V = true;
                                        if (Process.myPid() > 0) {
                                            Process.killProcess(Process.myPid());
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th40) {
                                    th3 = th40;
                                    j2 = 0;
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
                                    } catch (Throwable th41) {
                                        com.uc.crashsdk.a.g.a(th41);
                                    }
                                } catch (Throwable th42) {
                                    com.uc.crashsdk.a.g.a(th42);
                                }
                                try {
                                    new File(com.uc.crashsdk.b.b()).createNewFile();
                                } catch (Throwable th43) {
                                    com.uc.crashsdk.a.g.a(th43);
                                }
                                if (zT) {
                                    com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "omit java crash");
                                    if (z2) {
                                        try {
                                            if (!g.r() || z17) {
                                                z11 = false;
                                            } else {
                                                try {
                                                    a(true, false);
                                                    z11 = true;
                                                } catch (Throwable th44) {
                                                    th9 = th44;
                                                    z11 = true;
                                                    com.uc.crashsdk.a.g.a(th9);
                                                }
                                            }
                                        } catch (Throwable th45) {
                                            th9 = th45;
                                            z11 = false;
                                        }
                                    } else {
                                        z11 = false;
                                    }
                                    if (!z11 && !z17) {
                                        b(false);
                                    }
                                    try {
                                        f.c(false);
                                    } catch (Throwable th46) {
                                        com.uc.crashsdk.a.g.a(th46);
                                    }
                                    try {
                                        boolean zI6 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                            zI6 = true;
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI6);
                                        if (zI6 && T != null) {
                                            T.uncaughtException(thread, th);
                                        }
                                        if (com.uc.crashsdk.b.B() && !z17) {
                                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                        }
                                    } catch (Throwable th47) {
                                        com.uc.crashsdk.a.g.a(th47);
                                    }
                                    V = true;
                                    if (Process.myPid() > 0) {
                                        Process.killProcess(Process.myPid());
                                        return;
                                    }
                                    return;
                                }
                                if (!d(LogType.JAVA_TYPE)) {
                                    com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "java log sample miss");
                                    if (z2) {
                                        try {
                                            if (!g.r() || z17) {
                                                z10 = false;
                                            } else {
                                                try {
                                                    a(true, false);
                                                    z10 = true;
                                                } catch (Throwable th48) {
                                                    th8 = th48;
                                                    z10 = true;
                                                    com.uc.crashsdk.a.g.a(th8);
                                                }
                                            }
                                        } catch (Throwable th49) {
                                            th8 = th49;
                                            z10 = false;
                                        }
                                    } else {
                                        z10 = false;
                                    }
                                    if (!z10 && !z17) {
                                        b(false);
                                    }
                                    try {
                                        f.c(false);
                                    } catch (Throwable th50) {
                                        com.uc.crashsdk.a.g.a(th50);
                                    }
                                    try {
                                        boolean zI7 = g.i();
                                        if (!com.uc.crashsdk.a.d.e()) {
                                            zI7 = true;
                                        }
                                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI7);
                                        if (zI7 && T != null) {
                                            T.uncaughtException(thread, th);
                                        }
                                        if (com.uc.crashsdk.b.B() && !z17) {
                                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                        }
                                    } catch (Throwable th51) {
                                        com.uc.crashsdk.a.g.a(th51);
                                    }
                                    V = true;
                                    if (Process.myPid() > 0) {
                                        Process.killProcess(Process.myPid());
                                        return;
                                    }
                                    return;
                                }
                                jNativeClientCreateConnection = 0;
                            }
                            boolean z18 = th instanceof OutOfMemoryError;
                            a(th, str, jNativeClientCreateConnection, z18);
                            com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "generate java report finished");
                            if (!com.uc.crashsdk.b.L() && z18 && g.j()) {
                                String name = new File(str).getName();
                                String strY = g.Y();
                                File file = new File(strY);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                String str2 = String.format(Locale.US, "%s%s.hprof", strY, name);
                                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "begin dump hprof: " + str2);
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                try {
                                    Debug.dumpHprofData(str2);
                                } catch (Throwable th52) {
                                    com.uc.crashsdk.a.g.a(th52);
                                }
                                com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "end dump hprof, use " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                            }
                            if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                            }
                            if (z2) {
                                try {
                                    if (!g.r() || z17) {
                                        z12 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z12 = true;
                                        } catch (Throwable th53) {
                                            th10 = th53;
                                            z12 = true;
                                            com.uc.crashsdk.a.g.a(th10);
                                        }
                                    }
                                } catch (Throwable th54) {
                                    th10 = th54;
                                    z12 = false;
                                }
                            } else {
                                z12 = false;
                            }
                            if (z12 || z17) {
                                z13 = false;
                            } else {
                                z13 = false;
                                b(false);
                            }
                            try {
                                f.c(z13);
                            } catch (Throwable th55) {
                                com.uc.crashsdk.a.g.a(th55);
                            }
                            try {
                                boolean zI8 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI8 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI8);
                                if (zI8 && T != null) {
                                    T.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z17) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th56) {
                                com.uc.crashsdk.a.g.a(th56);
                            }
                            V = true;
                            if (Process.myPid() > 0) {
                                Process.killProcess(Process.myPid());
                                return;
                            }
                            return;
                        } catch (Throwable th57) {
                            th3 = th57;
                            j2 = 0;
                        }
                    } catch (Throwable th58) {
                        th3 = th58;
                    }
                } catch (Throwable th59) {
                    th2 = th59;
                    j2 = 0;
                    if (j2 != 0) {
                        JNIBridge.nativeClientCloseConnection(j2);
                    }
                    if (!z2) {
                        z4 = false;
                    } else if (g.r()) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    f.c(z5);
                    zI = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        zI = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI);
                    if (zI) {
                        T.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B()) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                    V = true;
                    if (Process.myPid() <= 0) {
                        throw th2;
                    }
                    Process.killProcess(Process.myPid());
                    throw th2;
                }
            } catch (Throwable th60) {
                th3 = th60;
                j2 = 0;
            }
        } catch (Throwable th61) {
            th2 = th61;
            j2 = 0;
        }
        z3 = false;
        com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "exception occurs while java log: " + th3);
        a(th3);
        if (!z3) {
            com.uc.crashsdk.a.a.d(ULog.L_DEBUG, "original exception is: " + th);
            a(th);
        }
        if (j2 != 0 && com.uc.crashsdk.b.d) {
            JNIBridge.nativeClientCloseConnection(j2);
        }
        if (z2) {
            try {
                if (!g.r() || z17) {
                    z6 = false;
                } else {
                    try {
                        a(true, false);
                        z6 = true;
                    } catch (Throwable th62) {
                        th5 = th62;
                        z6 = true;
                        com.uc.crashsdk.a.g.a(th5);
                    }
                }
            } catch (Throwable th63) {
                th5 = th63;
                z6 = false;
            }
        } else {
            z6 = false;
        }
        if (z6 || z17) {
            z7 = false;
        } else {
            z7 = false;
            b(false);
        }
        try {
            f.c(z7);
        } catch (Throwable th64) {
            com.uc.crashsdk.a.g.a(th64);
        }
        try {
            boolean zI9 = g.i();
            if (!com.uc.crashsdk.a.d.e()) {
                zI9 = true;
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI9);
            if (zI9 && T != null) {
                T.uncaughtException(thread, th);
            }
            if (com.uc.crashsdk.b.B() && !z17) {
                com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
            }
        } catch (Throwable th65) {
            com.uc.crashsdk.a.g.a(th65);
        }
        V = true;
        if (Process.myPid() > 0) {
            Process.killProcess(Process.myPid());
        }
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d(ULog.L_DEBUG, a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable th2) {
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
        long jO = g.o();
        if (jO < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (!z2) {
            return;
        }
        X = new com.uc.crashsdk.a.e(402);
        com.uc.crashsdk.a.f.a(0, X, jO);
    }

    static void y() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            if (X != null && !W) {
                com.uc.crashsdk.a.f.a(X);
                X = null;
                return true;
            }
            return false;
        }
    }

    public static boolean e(String str) {
        try {
            if (com.uc.crashsdk.a.g.b(str) && str.startsWith("lib") && str.endsWith(".so")) {
                System.loadLibrary(str.substring(3, str.length() - 3));
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TTAdConstant.IMAGE_LIST_SIZE_CODE), i2 * 1000);
    }

    private static void ab() {
        String strY = g.Y();
        File file = new File(strY);
        if (!file.isDirectory()) {
            return;
        }
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length <= 150) {
                return;
            }
            Arrays.sort(fileArrListFiles, new b((byte) 0));
            int length = fileArrListFiles.length - MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
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
            com.uc.crashsdk.a.a.a("Removed " + i3 + " logs in " + strY);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    public static void A() {
        if (!g.q()) {
            return;
        }
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(TTAdConstant.INTERACTION_TYPE_CODE), 1000L);
    }

    private static void a(Calendar calendar) {
        if (!g.S()) {
            return;
        }
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        long j2 = timeInMillis2 - timeInMillis;
        long j3 = 3600000;
        if (j2 <= 3600000) {
            j3 = j2 + 1000;
        }
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_COVER_URL_CODE, new Object[]{Long.valueOf(timeInMillis2)}), j3);
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
            if (f.a(com.uc.crashsdk.b.c())) {
                iB = 1;
            } else {
                iB = 0;
            }
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

    /* JADX WARN: Code duplicated, block: B:30:0x0050  */
    public static void D() {
        boolean z2;
        boolean z3;
        int iN = g.N();
        if (iN == 0 || iN == 3 || iN == 4) {
            if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 25) {
                z3 = true;
            } else {
                boolean z4 = iN != 0;
                if (iN == 3) {
                    z2 = System.currentTimeMillis() % 10 == 0;
                } else {
                    z2 = z4;
                }
                if (iN == 4) {
                    z3 = System.currentTimeMillis() % 3 == 0;
                } else {
                    z3 = z2;
                }
            }
        } else if (iN == 1) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        int i2 = com.uc.crashsdk.b.L() ? 1 : 0;
        if (Looper.getMainLooper() != Looper.myLooper() && z3) {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(TTAdConstant.VIDEO_INFO_CODE));
            z3 = false;
        }
        JNIBridge.nativeCmd(7, i2, null, null);
        if (z3) {
            JNIBridge.cmd(8);
        }
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            if (ae != null) {
                return ae;
            }
            int iCmd = (int) JNIBridge.cmd(14);
            if (iCmd == -1) {
                return null;
            }
            ae = ParcelFileDescriptor.adoptFd(iCmd);
            af = true;
            return ae;
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
        String strX = g.X();
        File file = new File(strX);
        if (!file.exists() || !file.isDirectory()) {
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + strX);
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
