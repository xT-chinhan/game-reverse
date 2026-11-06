package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.byazt.ol.TTDownloadField;
import com.tapsdk.tapad.internal.runtime.mediation.AdapterEnvelope;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    static final /* synthetic */ boolean i = true;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static String s = null;
    private static String t = null;
    private static String u = null;
    private static String v = null;
    private static String w = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static final Object e = new Object();
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    private static boolean x = false;
    private static boolean y = false;
    private static volatile boolean z = false;
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static final Object G = new Object();
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static final Object O = new Object();
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;
    private static Runnable S = new com.uc.crashsdk.a.e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;
    private static long aa = 0;
    private static final WeakHashMap<Activity, Integer> ab = new WeakHashMap<>();
    private static boolean ac = false;
    private static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;

    static /* synthetic */ boolean O() {
        ac = true;
        return true;
    }

    static String a() {
        int length;
        if (H != null) {
            return H;
        }
        String strH = e.h();
        if (com.uc.crashsdk.a.g.a(strH)) {
            H = "LLUN";
        } else {
            if (strH.length() > 48) {
                length = strH.length() - 48;
                strH = strH.substring(0, 48);
            } else {
                length = 0;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = strH.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b2 = bytes[length2];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 >= 48 && b2 <= 57) {
                    sb.append((char) b2);
                } else {
                    sb.append('2');
                }
            }
            if (length > 0) {
                sb.append(String.valueOf(length));
            }
            H = sb.toString();
        }
        return H;
    }

    private static String d(String str) {
        return g.W() + a() + "." + str;
    }

    private static String Q() {
        if (j == null) {
            j = d("ss");
        }
        return j;
    }

    static String b() {
        if (k == null) {
            k = d("ctj");
        }
        return k;
    }

    private static String R() {
        if (l == null) {
            l = d("ctn");
        }
        return l;
    }

    private static String S() {
        if (m == null) {
            m = d("cta");
        }
        return m;
    }

    static String c() {
        if (n == null) {
            n = d("st");
        }
        return n;
    }

    private static File[] e(String str) {
        if (!i && str.length() <= 0) {
            throw new AssertionError();
        }
        File[] fileArrListFiles = new File(g.W()).listFiles();
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : fileArrListFiles) {
                if (file.getPath().endsWith(str)) {
                    arrayList.add(file);
                }
            }
            return (File[]) arrayList.toArray(new File[arrayList.size()]);
        }
        return null;
    }

    static File[] d() {
        return e(".st");
    }

    static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".st");
        if (!i && iLastIndexOf < 0) {
            throw new AssertionError();
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        if (strSubstring.length() <= 0) {
            return null;
        }
        return strSubstring + ".stcb";
    }

    static String e() {
        if (o == null) {
            o = d("stcb");
        }
        return o;
    }

    static File[] f() {
        return e(".stcb");
    }

    static String g() {
        if (v == null) {
            v = d("bati");
        }
        return v;
    }

    static String h() {
        if (w == null) {
            w = d("hdr");
        }
        return w;
    }

    static String i() {
        if (q == null) {
            q = g.W() + "up";
        }
        return q;
    }

    public static String j() {
        if (r == null) {
            r = g.W() + "authu";
        }
        return r;
    }

    public static String k() {
        if (s == null) {
            s = g.W() + "statu";
        }
        return s;
    }

    static String l() {
        if (t == null) {
            t = g.W() + "poli";
        }
        return t;
    }

    static String m() {
        if (u == null) {
            u = g.W() + "ver";
        }
        return u;
    }

    public static String n() {
        return g.W() + "bvu";
    }

    static String o() {
        return g.W() + "fds";
    }

    static String p() {
        return com.uc.crashsdk.a.g.a(new File(Q()), 8, false);
    }

    static boolean q() {
        return y;
    }

    private static void T() {
        if (z || y) {
            return;
        }
        synchronized (G) {
            if (z) {
                return;
            }
            f(g.W());
            String strP = p();
            File file = new File(b());
            File file2 = new File(R());
            A = "f".equals(strP);
            B = "b".equals(strP);
            D = file.exists();
            E = file2.exists();
            boolean z2 = D || E;
            C = z2;
            if (!z2 && (A || B)) {
                boolean zR = r();
                F = zR;
                C = zR;
            }
            try {
                if (z()) {
                    Z();
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            z = true;
        }
    }

    static boolean r() {
        if (!J) {
            if (d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    public static void a(boolean z2) {
        L = z2;
        if (d) {
            JNIBridge.set(30, L);
        }
    }

    static boolean s() {
        T();
        return A;
    }

    static boolean t() {
        T();
        return B;
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    static boolean u() {
        return x;
    }

    public static void v() {
        boolean z2;
        f(g.W());
        y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {"up", "authu", "statu", "poli"};
        File[] fileArrListFiles = new File(g.W()).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i2])) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (x) {
            return;
        }
        x = true;
        if (L() || e.u()) {
            return;
        }
        f(g.W());
        Y();
        Z();
    }

    private static void Y() {
        if (d) {
            JNIBridge.set(26, x);
        }
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        Object[] objArrAb = ab();
        if (objArrAb[0].equals(P) || R != null) {
            Q = true;
            aa();
        } else {
            a(objArrAb);
        }
    }

    private static void aa() {
        if (!com.uc.crashsdk.a.f.b(S)) {
            com.uc.crashsdk.a.f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(S);
            com.uc.crashsdk.a.f.a(1, S);
        }
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = (String) objArr[0];
            long jLongValue = ((Long) objArr[1]).longValue();
            if (jLongValue < U) {
                com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(jLongValue), Long.valueOf(U)));
                return;
            }
            U = jLongValue;
            String strQ = Q();
            if (d) {
                if (M != null) {
                    com.uc.crashsdk.a.g.a(M);
                    M = null;
                }
                boolean zNativeChangeState = JNIBridge.nativeChangeState(strQ, str, N);
                N = false;
                if (!zNativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                if (M == null || N) {
                    if (M != null) {
                        com.uc.crashsdk.a.g.a(M);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(strQ, "rw");
                        M = randomAccessFile;
                        randomAccessFile.seek(0L);
                        N = false;
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0L);
                } catch (Exception e3) {
                    com.uc.crashsdk.a.g.a(e3);
                }
            }
            P = str;
            R = null;
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            W++;
            if (x) {
                return new Object[]{"e", Long.valueOf(W)};
            }
            if (B()) {
                return new Object[]{"f", Long.valueOf(W)};
            }
            return new Object[]{"b", Long.valueOf(W)};
        }
    }

    static boolean x() {
        return f(g.W());
    }

    static boolean y() {
        return f(g.X());
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (file.delete()) {
            file.mkdirs();
            return true;
        }
        return false;
    }

    static boolean z() {
        return X || !ad();
    }

    public static boolean A() {
        return Y || !ad();
    }

    public static void b(boolean z2) {
        if (e.u()) {
            return;
        }
        if (z2 && x) {
            if (g.O()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            x = false;
            Y();
        }
        boolean z3 = e.F() || L();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (X && !Y && z2 && aa != 0 && !z3 && jCurrentTimeMillis - aa > 1800000) {
            com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
        }
        aa = jCurrentTimeMillis;
        Y = z2;
        if (z2) {
            X = true;
        }
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (x || z3) {
            return;
        }
        T();
        Z();
        if (z2) {
            a.a(false);
            if (!Z) {
                e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        e.c(z2);
    }

    static boolean B() {
        return Y && !x;
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (g.L()) {
                C();
                return true;
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    static void C() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    static void D() {
        if (d && ad != null) {
            JNIBridge.set(129, ad);
        }
    }

    static String E() {
        return ad == null ? "" : ad;
    }

    public static void a(int i2) {
        Object objA;
        Activity activity;
        int i3;
        boolean z2 = false;
        switch (i2) {
            case 100:
                Object objAc = ac();
                if (objAc == null || (objA = a(objAc, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    Iterator it = ((Map) objA).entrySet().iterator();
                    boolean z3 = false;
                    while (it.hasNext()) {
                        Object value = ((Map.Entry) it.next()).getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, TTDownloadField.TT_ACTIVITY)) != null) {
                            boolean zBooleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean zBooleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                            synchronized (ab) {
                                if (zBooleanValue || zBooleanValue2) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                    z3 = true;
                                }
                                ab.put(activity, Integer.valueOf(i3));
                                break;
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        b(z3);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    boolean z4 = !new File(Q()).exists();
                    N = z4;
                    if (z4 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object ac() {
        Method declaredMethod;
        Object objA;
        Object objA2 = a((Application) com.uc.crashsdk.a.g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (objA2 != null && (objA = a(objA2, (Class<?>) null, "mActivityThread")) != null) {
            return objA;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            if (cls != null && (declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return null;
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static boolean F() {
        if (!ae) {
            if (!com.uc.crashsdk.a.g.a(a.a) && a.a.equals(e.h())) {
                af = true;
                if (d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    static void G() {
        ag = true;
        if (d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean zU = U();
        if (t()) {
            if (zU) {
                return 3;
            }
            return 6;
        }
        if (s()) {
            if (zU) {
                return 2;
            }
            return 5;
        }
        if (zU) {
            return 4;
        }
        return 1;
    }

    public static int J() {
        boolean zV = V();
        boolean zW = W();
        boolean zX = X();
        if (t()) {
            if (zV) {
                return 12;
            }
            if (zW) {
                return 14;
            }
            if (zX) {
                return 16;
            }
            return 98;
        }
        if (s()) {
            if (zV) {
                return 11;
            }
            if (zW) {
                return 13;
            }
            if (zX) {
                return 15;
            }
            return 97;
        }
        return 1;
    }

    public static void b(int i2) {
        I = i2;
        K();
    }

    static void K() {
        if (d) {
            JNIBridge.nativeSet(27, I, "12", null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean c(int i2) {
        return (i2 & I) != 0;
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) throws IOException {
        FileChannel channel;
        Throwable th;
        boolean zA;
        synchronized (obj) {
            FileChannel fileChannel = null;
            fileLockLock = null;
            FileLock fileLockLock = null;
            boolean z2 = false;
            if (d) {
                int iNativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (iNativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean zNativeLockFile = JNIBridge.nativeLockFile(iNativeOpenFile, true);
                    try {
                        zA = eVar.a();
                        if (zNativeLockFile) {
                            JNIBridge.nativeLockFile(iNativeOpenFile, false);
                        }
                        JNIBridge.nativeCloseFile(iNativeOpenFile);
                        return zA;
                    } catch (Throwable th2) {
                        if (zNativeLockFile) {
                            JNIBridge.nativeLockFile(iNativeOpenFile, false);
                        }
                        throw th2;
                    }
                } catch (Throwable th3) {
                    JNIBridge.nativeCloseFile(iNativeOpenFile);
                    throw th3;
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            try {
                try {
                    channel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th4) {
                    th = th4;
                    channel = null;
                    com.uc.crashsdk.a.g.a(channel);
                    throw th;
                }
            } catch (Exception e3) {
                try {
                    com.uc.crashsdk.a.g.a(e3);
                    channel = null;
                } catch (Exception e4) {
                    e = e4;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel);
                    zA = z2;
                    return zA;
                }
            }
            if (channel != null) {
                try {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            fileChannel = channel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            zA = z2;
                            return zA;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    com.uc.crashsdk.a.g.a(channel);
                    throw th;
                }
            }
            try {
                zA = eVar.a();
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception e7) {
                        try {
                            com.uc.crashsdk.a.g.a(e7);
                        } catch (Exception e8) {
                            fileChannel = channel;
                            z2 = zA;
                            e = e8;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            zA = z2;
                        }
                    }
                }
                com.uc.crashsdk.a.g.a(channel);
                return zA;
            } catch (Throwable th6) {
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception e9) {
                        com.uc.crashsdk.a.g.a(e9);
                    }
                }
                throw th6;
            }
        }
    }

    private static boolean ad() {
        String strA = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(strA)) {
            return false;
        }
        return strA.contains("/bg_non_interactive") || strA.contains("/background");
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                if (!ai) {
                    ah = ae();
                    ai = true;
                }
            }
        }
        return ah;
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                if (objInvoke != null && (objInvoke instanceof Boolean)) {
                    return ((Boolean) objInvoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int iMyUid = Process.myUid() % AdapterEnvelope.MAX_TRACE_FRAMES;
        return iMyUid >= 99000 && iMyUid <= 99999;
    }

    public static void M() {
        if (e.F() || L() || ak != null || g.h() < 0) {
            return;
        }
        try {
            Context contextA = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = contextA.getPackageManager().getLaunchIntentForPackage(contextA.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            ak = PendingIntent.getActivity(contextA, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    static void b(Context context) {
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (p == null) {
            p = d("rt");
        }
        File file = new File(p);
        long j2 = -1;
        try {
            j2 = Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        boolean z2 = false;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (g.h() >= 0 && (j2 <= 0 || jCurrentTimeMillis - j2 > g.h())) {
            f(g.W());
            com.uc.crashsdk.a.g.a(file, String.valueOf(jCurrentTimeMillis));
            z2 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j2 + ", currentTime: " + jCurrentTimeMillis + ", needRestart: " + z2);
        if (!z2) {
            return;
        }
        try {
            d.a(true);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        N();
    }

    static boolean N() {
        if (ak == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }
}
