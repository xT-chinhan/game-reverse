package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    static final /* synthetic */ boolean d = true;
    public static String a = "";
    public static String b = "";
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    static boolean c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    public static String a() {
        if (h != null) {
            return h;
        }
        if (o()) {
            return h;
        }
        return "";
    }

    static long b() {
        return j;
    }

    static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    public static void a(String str, String str2) {
        synchronized (e) {
            if (!e.containsKey(str)) {
                f.add(str);
            }
            e.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb.toString());
    }

    static void e() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (e) {
            for (String str : f) {
                JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int iRemoveType;
        int iIntValue;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        synchronized (k) {
            if (k.containsKey(str)) {
                iIntValue = ((Integer) k.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i2);
            } else {
                iRemoveType = i2;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                if (m >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    m++;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                if (n >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    n++;
                }
            }
            if (LogType.isForUnexp(iRemoveType) && !LogType.isForUnexp(iIntValue)) {
                if (o >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                } else {
                    o++;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                if (p >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    p++;
                }
            }
            if ((1048849 & iRemoveType) != 0) {
                if (iIntValue == 0) {
                    l.add(str);
                }
                z5 = true;
            } else {
                z5 = false;
            }
            if (!z5) {
                return iRemoveType;
            }
            if (b.d && (1048833 & i2) != 0) {
                int iNativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!LogType.isForNative(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForUnexp(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                }
                if (!LogType.isForANR(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            k.put(str, new Object[]{Integer.valueOf(iRemoveType), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return iRemoveType;
        }
    }

    static void g() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                Object[] objArr = k.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), iIntValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0054 A[Catch: Throwable -> 0x00de, all -> 0x0111, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0014, B:9:0x001b, B:11:0x0021, B:12:0x0027, B:14:0x0031, B:21:0x0048, B:23:0x0054, B:25:0x0067, B:35:0x0084, B:37:0x00a1, B:39:0x00a9, B:49:0x00cd, B:51:0x00d8, B:42:0x00b7, B:44:0x00c0, B:59:0x00e4, B:18:0x0041, B:63:0x00f1, B:64:0x00f5, B:66:0x00fb, B:68:0x0109, B:70:0x010f), top: B:76:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    /* JADX WARN: Code duplicated, block: B:33:0x007e  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b7 A[Catch: Throwable -> 0x00dc, all -> 0x0111, TryCatch #0 {, blocks: (B:8:0x0014, B:9:0x001b, B:11:0x0021, B:12:0x0027, B:14:0x0031, B:21:0x0048, B:23:0x0054, B:25:0x0067, B:35:0x0084, B:37:0x00a1, B:39:0x00a9, B:49:0x00cd, B:51:0x00d8, B:42:0x00b7, B:44:0x00c0, B:59:0x00e4, B:18:0x0041, B:63:0x00f1, B:64:0x00f5, B:66:0x00fb, B:68:0x0109, B:70:0x010f), top: B:76:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c0 A[Catch: Throwable -> 0x00dc, all -> 0x0111, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0014, B:9:0x001b, B:11:0x0021, B:12:0x0027, B:14:0x0031, B:21:0x0048, B:23:0x0054, B:25:0x0067, B:35:0x0084, B:37:0x00a1, B:39:0x00a9, B:49:0x00cd, B:51:0x00d8, B:42:0x00b7, B:44:0x00c0, B:59:0x00e4, B:18:0x0041, B:63:0x00f1, B:64:0x00f5, B:66:0x00fb, B:68:0x0109, B:70:0x010f), top: B:76:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8 A[Catch: Throwable -> 0x006f, all -> 0x0111, TRY_LEAVE, TryCatch #0 {, blocks: (B:8:0x0014, B:9:0x001b, B:11:0x0021, B:12:0x0027, B:14:0x0031, B:21:0x0048, B:23:0x0054, B:25:0x0067, B:35:0x0084, B:37:0x00a1, B:39:0x00a9, B:49:0x00cd, B:51:0x00d8, B:42:0x00b7, B:44:0x00c0, B:59:0x00e4, B:18:0x0041, B:63:0x00f1, B:64:0x00f5, B:66:0x00fb, B:68:0x0109, B:70:0x010f), top: B:76:0x0014 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x0054, please report this as an issue */
    static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        int iB;
        int iMin;
        boolean zBooleanValue;
        String str2;
        boolean zBooleanValue2;
        String str3;
        File file;
        char c2 = 1;
        boolean z2 = arrayList == null;
        boolean zF = e.F();
        synchronized (k) {
            int i2 = 0;
            for (String str4 : l) {
                try {
                    Object[] objArr = k.get(str4);
                    if (arrayList == null) {
                        if (LogType.isForJava(((Integer) objArr[0]).intValue())) {
                            if (((Boolean) objArr[3]).booleanValue()) {
                                try {
                                    outputStream.write((str4 + "\n").getBytes(str));
                                } catch (Throwable th) {
                                    th = th;
                                    iB = i2;
                                    e.a(th, outputStream);
                                    i2 = iB;
                                    c2 = 1;
                                }
                            }
                            if (i2 > 153600) {
                                iB = 153600;
                            } else {
                                iB = i2;
                            }
                            try {
                                iMin = Math.min(20480, 153600 - iB);
                                zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                                str2 = (String) objArr[c2];
                                zBooleanValue2 = ((Boolean) objArr[4]).booleanValue();
                                if (!zF && !str2.startsWith("/proc/")) {
                                    str3 = str2;
                                    e.a(outputStream, "FILE", str2, iMin, zBooleanValue, zBooleanValue2);
                                } else {
                                    str3 = str2;
                                    if (zBooleanValue) {
                                        iB += e.a(outputStream, str3, iMin);
                                    } else {
                                        iB += e.b(outputStream, str3, iMin);
                                    }
                                }
                                i2 = iB;
                                if (zBooleanValue2 && z2 && !zF) {
                                    file = new File(str3);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                e.a(th, outputStream);
                                i2 = iB;
                            }
                            c2 = 1;
                        }
                    } else if (a(arrayList, str4)) {
                        if (((Boolean) objArr[3]).booleanValue()) {
                            outputStream.write((str4 + "\n").getBytes(str));
                        }
                        if (i2 > 153600) {
                            iB = 153600;
                        } else {
                            iB = i2;
                        }
                        iMin = Math.min(20480, 153600 - iB);
                        zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                        str2 = (String) objArr[c2];
                        zBooleanValue2 = ((Boolean) objArr[4]).booleanValue();
                        if (!zF) {
                            str3 = str2;
                            if (zBooleanValue) {
                                iB += e.a(outputStream, str3, iMin);
                            } else {
                                iB += e.b(outputStream, str3, iMin);
                            }
                        } else {
                            str3 = str2;
                            if (zBooleanValue) {
                                iB += e.a(outputStream, str3, iMin);
                            } else {
                                iB += e.b(outputStream, str3, iMin);
                            }
                        }
                        i2 = iB;
                        if (zBooleanValue2) {
                            file = new File(str3);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                        c2 = 1;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (arrayList != null && zF) {
                for (String str5 : arrayList) {
                    if (!a(l, str5)) {
                        e.a(outputStream, "CUSTOMDUMPFILE", str5);
                    }
                }
            }
        }
    }

    static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static String a(String str) {
        synchronized (k) {
            Object[] objArr = k.get(str);
            if (objArr == null) {
                return null;
            }
            return String.format(Locale.US, "%s%s%d%d", (String) objArr[1], "`", Integer.valueOf(((Boolean) objArr[2]).booleanValue() ? 1 : 0), Integer.valueOf(((Boolean) objArr[3]).booleanValue() ? 1 : 0));
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, int i2, Callable<String> callable, long j2, int i3) {
        int iRemoveType;
        int iIntValue;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (str == null) {
            return 0;
        }
        synchronized (q) {
            if (q.containsKey(str)) {
                iIntValue = ((Integer) q.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i2);
                if (iIntValue == iRemoveType) {
                    return iIntValue;
                }
            } else {
                iRemoveType = i2;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                if (s >= 8) {
                    z8 = true;
                } else if (j2 != 0) {
                    if (w < 6) {
                        w++;
                        s++;
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                } else if (s - w < 6) {
                    s++;
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (z8) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                if (t < 6) {
                    if (j2 != 0) {
                        if (x < 4) {
                            x++;
                            t++;
                            z7 = false;
                            z2 = true;
                            z3 = true;
                        }
                    } else {
                        if (t - x < 4) {
                            t++;
                            z7 = false;
                            z2 = true;
                        }
                        z3 = false;
                    }
                    z7 = true;
                    z2 = false;
                    z3 = false;
                } else {
                    z7 = true;
                    z2 = false;
                    z3 = false;
                }
                if (z7) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
            } else {
                z2 = false;
                z3 = false;
            }
            if (!LogType.isForANR(iRemoveType) || LogType.isForANR(iIntValue)) {
                z4 = false;
            } else if (v >= 6) {
                iRemoveType = LogType.removeType(iRemoveType, 1048576);
                z4 = false;
            } else {
                v++;
                z4 = true;
            }
            if (!LogType.isForUnexp(iRemoveType) || LogType.isForUnexp(iIntValue)) {
                z5 = false;
            } else if (u >= 6) {
                iRemoveType = LogType.removeType(iRemoveType, 256);
                z5 = false;
            } else {
                u++;
                z5 = true;
            }
            if ((1048849 & iRemoveType) != 0) {
                if (iIntValue == 0) {
                    r.add(str);
                }
                z6 = true;
            } else {
                z6 = false;
            }
            if (!z6) {
                return iRemoveType;
            }
            if (b.d && (1048833 & i2) != 0) {
                int iNativeAddCallbackInfo = JNIBridge.nativeAddCallbackInfo(str, i2, j2, i3);
                if (!LogType.isForNative(iNativeAddCallbackInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                    if (z2) {
                        t--;
                    }
                    if (z3) {
                        x--;
                    }
                }
                if (!LogType.isForANR(iNativeAddCallbackInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                    if (z4) {
                        v--;
                    }
                }
                if (!LogType.isForUnexp(iNativeAddCallbackInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                    if (z5) {
                        u--;
                    }
                }
            }
            q.put(str, new Object[]{Integer.valueOf(iRemoveType), callable, Long.valueOf(j2), Integer.valueOf(i3)});
            return iRemoveType;
        }
    }

    static void i() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (q) {
            for (String str : r) {
                Object[] objArr = q.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, iIntValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005e A[Catch: Throwable -> 0x008e, all -> 0x00d2, TryCatch #1 {Throwable -> 0x008e, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005e, B:21:0x0076, B:23:0x007c, B:24:0x0084, B:19:0x006c, B:13:0x002f), top: B:49:0x0015, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x006c A[Catch: Throwable -> 0x008e, all -> 0x00d2, TryCatch #1 {Throwable -> 0x008e, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005e, B:21:0x0076, B:23:0x007c, B:24:0x0084, B:19:0x006c, B:13:0x002f), top: B:49:0x0015, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0084 A[Catch: Throwable -> 0x008e, all -> 0x00d2, TRY_LEAVE, TryCatch #1 {Throwable -> 0x008e, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005e, B:21:0x0076, B:23:0x007c, B:24:0x0084, B:19:0x006c, B:13:0x002f), top: B:49:0x0015, outer: #0 }] */
    static void a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        long jLongValue;
        String string;
        synchronized (q) {
            for (String str3 : r) {
                try {
                    Object[] objArr = q.get(str3);
                    int iIntValue = ((Integer) objArr[0]).intValue();
                    if (arrayList == null) {
                        if (LogType.isForJava(iIntValue)) {
                            outputStream.write((str3 + "\n").getBytes(str));
                            jLongValue = ((Long) objArr[2]).longValue();
                            if (jLongValue != 0) {
                                string = JNIBridge.nativeGetCallbackInfo(str3, jLongValue, ((Integer) objArr[3]).intValue(), false);
                            } else {
                                string = b(str3, false).toString();
                            }
                            if (string == null && string.length() > 0) {
                                outputStream.write(string.getBytes(str));
                            } else {
                                outputStream.write("(data is null)\n".getBytes(str));
                            }
                            try {
                                outputStream.write("\n".getBytes(str));
                                outputStream.write(str2.getBytes(str));
                            } catch (Throwable th) {
                                e.a(th, outputStream);
                            }
                        }
                    } else if (a(arrayList, str3)) {
                        outputStream.write((str3 + "\n").getBytes(str));
                        jLongValue = ((Long) objArr[2]).longValue();
                        if (jLongValue != 0) {
                            string = JNIBridge.nativeGetCallbackInfo(str3, jLongValue, ((Integer) objArr[3]).intValue(), false);
                        } else {
                            string = b(str3, false).toString();
                        }
                        if (string == null) {
                            outputStream.write("(data is null)\n".getBytes(str));
                        } else {
                            outputStream.write("(data is null)\n".getBytes(str));
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                } catch (Throwable th2) {
                    e.a(th2, outputStream);
                }
            }
            if (arrayList != null && e.F()) {
                for (String str4 : arrayList) {
                    if (!a(r, str4)) {
                        e.a(outputStream, "CUSTOMCALLBACKINFO", str4);
                    }
                }
            }
        }
    }

    static String a(String str, boolean z2) {
        String string;
        synchronized (q) {
            Object[] objArr = q.get(str);
            long jLongValue = ((Long) objArr[2]).longValue();
            if (jLongValue != 0) {
                string = JNIBridge.nativeGetCallbackInfo(str, jLongValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                string = b(str, z2).toString();
            }
        }
        return string;
    }

    private static StringBuilder b(String str, boolean z2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    strA = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    if (callable != null) {
                        strA = (String) callable.call();
                    } else {
                        strA = d.a(str, z2);
                    }
                }
                if (strA != null) {
                    sb.append(strA);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    static String j() {
        String string;
        synchronized (q) {
            StringBuilder sb = new StringBuilder();
            synchronized (r) {
                boolean z2 = true;
                for (String str : r) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb.append("`");
                        }
                        sb.append(str);
                        z2 = false;
                    }
                }
            }
            string = sb.toString();
        }
        return string;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (y) {
            int id = (int) thread.getId();
            if (y.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            y.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    /* JADX WARN: Code duplicated, block: B:29:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ce A[Catch: Throwable -> 0x0107, all -> 0x0125, TryCatch #5 {Throwable -> 0x0107, blocks: (B:34:0x00c7, B:36:0x00ce, B:37:0x00d7, B:39:0x00dd, B:41:0x00e1, B:42:0x00ea), top: B:66:0x00c7, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00dd A[Catch: Throwable -> 0x0107, all -> 0x0125, TryCatch #5 {Throwable -> 0x0107, blocks: (B:34:0x00c7, B:36:0x00ce, B:37:0x00d7, B:39:0x00dd, B:41:0x00e1, B:42:0x00ea), top: B:66:0x00c7, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e1 A[Catch: Throwable -> 0x0107, all -> 0x0125, TryCatch #5 {Throwable -> 0x0107, blocks: (B:34:0x00c7, B:36:0x00ce, B:37:0x00d7, B:39:0x00dd, B:41:0x00e1, B:42:0x00ea), top: B:66:0x00c7, outer: #2 }] */
    static void a(OutputStream outputStream, String str, String str2) {
        Thread thread;
        Throwable th;
        String str3;
        StackTraceElement[] stackTrace;
        int length;
        int i2;
        boolean z2;
        String str4;
        synchronized (y) {
            Thread threadCurrentThread = Thread.currentThread();
            Iterator<Integer> it = z.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                try {
                    Object[] objArr = y.get(iIntValue);
                    if (objArr != null) {
                        thread = (Thread) ((WeakReference) objArr[0]).get();
                        try {
                            str3 = (String) objArr[1];
                            if (thread == null) {
                                try {
                                    com.uc.crashsdk.a.a.b("Thread (" + str3 + ", " + iIntValue + ") has exited!");
                                } catch (Throwable th2) {
                                    th = th2;
                                    e.a(th, outputStream);
                                    try {
                                        outputStream.write(String.format(Locale.US, "Thread Name: '%s'\n", str3).getBytes(str));
                                        if (thread.isDaemon()) {
                                            str4 = " daemon";
                                        } else {
                                            str4 = "";
                                        }
                                        outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), str4, Integer.valueOf(thread.getPriority()), Integer.valueOf(iIntValue), thread.getState().toString()).getBytes(str));
                                    } catch (Throwable th3) {
                                        e.a(th3, outputStream);
                                    }
                                    try {
                                        stackTrace = thread.getStackTrace();
                                        if (stackTrace.length == 0) {
                                            outputStream.write("  (no stack frames)".getBytes(str));
                                        }
                                        length = stackTrace.length;
                                        i2 = 0;
                                        z2 = true;
                                        while (i2 < length) {
                                            StackTraceElement stackTraceElement = stackTrace[i2];
                                            if (!z2) {
                                                outputStream.write("\n".getBytes(str));
                                            }
                                            outputStream.write(String.format(Locale.US, "  at %s", stackTraceElement.toString()).getBytes(str));
                                            i2++;
                                            z2 = false;
                                        }
                                    } catch (Throwable th4) {
                                        e.a(th4, outputStream);
                                    }
                                    try {
                                        outputStream.write("\n".getBytes(str));
                                        outputStream.write(str2.getBytes(str));
                                    } catch (Throwable th5) {
                                        e.a(th5, outputStream);
                                    }
                                }
                            } else if (threadCurrentThread != thread) {
                                outputStream.write(String.format(Locale.US, "Thread Name: '%s'\n", str3).getBytes(str));
                                if (thread.isDaemon()) {
                                    str4 = " daemon";
                                } else {
                                    str4 = "";
                                }
                                outputStream.write(String.format(Locale.US, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), str4, Integer.valueOf(thread.getPriority()), Integer.valueOf(iIntValue), thread.getState().toString()).getBytes(str));
                                stackTrace = thread.getStackTrace();
                                if (stackTrace.length == 0) {
                                    outputStream.write("  (no stack frames)".getBytes(str));
                                }
                                length = stackTrace.length;
                                i2 = 0;
                                z2 = true;
                                while (i2 < length) {
                                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                                    if (!z2) {
                                        outputStream.write("\n".getBytes(str));
                                    }
                                    outputStream.write(String.format(Locale.US, "  at %s", stackTraceElement2.toString()).getBytes(str));
                                    i2++;
                                    z2 = false;
                                }
                                outputStream.write("\n".getBytes(str));
                                outputStream.write(str2.getBytes(str));
                            }
                        } catch (Throwable th6) {
                            str3 = null;
                            th = th6;
                        }
                    }
                } catch (Throwable th7) {
                    thread = null;
                    th = th7;
                    str3 = null;
                }
            }
        }
    }

    public static int a(String str, int i2, int i3) {
        int iRemoveType;
        int iIntValue;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        synchronized (A) {
            if (A.containsKey(str)) {
                iIntValue = ((Integer) A.get(str)[1]).intValue();
                iRemoveType = LogType.addType(iIntValue, i3);
            } else {
                iRemoveType = i3;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                if (C >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    C++;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                if (D >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    D++;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                if (E >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    E++;
                }
            }
            if ((1048849 & iRemoveType) != 0) {
                if (iIntValue == 0) {
                    B.add(str);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return iRemoveType;
            }
            if (b.d && (i3 & 1048577) != 0) {
                int iNativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, iRemoveType);
                if (!LogType.isForNative(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForANR(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            A.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(iRemoveType), new ArrayList()});
            return iRemoveType;
        }
    }

    public static int b(String str, String str2) {
        int iIntValue;
        int iAddType = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        synchronized (A) {
            Object[] objArr = A.get(str);
            if (objArr != null) {
                int iIntValue2 = ((Integer) objArr[0]).intValue();
                iIntValue = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= iIntValue2) {
                    list.remove(0);
                }
                list.add(str2);
                iAddType = LogType.isForJava(iIntValue) ? LogType.addType(0, 16) : 0;
                if (!b.d) {
                    if (LogType.isForNative(iIntValue)) {
                        iAddType = LogType.addType(iAddType, 1);
                    }
                    if (LogType.isForANR(iIntValue)) {
                        iAddType = LogType.addType(iAddType, 1048576);
                    }
                }
            } else {
                iIntValue = 0;
            }
            if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(iIntValue)) {
                    iAddType = LogType.addType(iAddType, 1);
                }
                if (LogType.isForANR(iIntValue)) {
                    iAddType = LogType.addType(iAddType, 1048576);
                }
            }
        }
        return iAddType;
    }

    static void k() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & iIntValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, iIntValue, iIntValue2) != 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0076 A[Catch: Throwable -> 0x008e, all -> 0x00d2, TRY_LEAVE, TryCatch #1 {Throwable -> 0x008e, blocks: (B:18:0x006c, B:19:0x0070, B:21:0x0076), top: B:47:0x006c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static void b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        Iterator it;
        synchronized (A) {
            for (String str3 : B) {
                Object[] objArr = A.get(str3);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (arrayList == null) {
                    if (LogType.isForJava(iIntValue2)) {
                        try {
                            outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)).getBytes(str));
                        } catch (Throwable th) {
                            e.a(th, outputStream);
                        }
                        try {
                            it = list.iterator();
                            while (it.hasNext()) {
                                outputStream.write(((String) it.next()).getBytes(str));
                                outputStream.write("\n".getBytes(str));
                            }
                        } catch (Throwable th2) {
                            e.a(th2, outputStream);
                        }
                        try {
                            outputStream.write("\n".getBytes(str));
                            outputStream.write(str2.getBytes(str));
                        } catch (Throwable th3) {
                            e.a(th3, outputStream);
                        }
                    }
                } else if (a(arrayList, str3)) {
                    outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)).getBytes(str));
                    it = list.iterator();
                    while (it.hasNext()) {
                        outputStream.write(((String) it.next()).getBytes(str));
                        outputStream.write("\n".getBytes(str));
                    }
                    outputStream.write("\n".getBytes(str));
                    outputStream.write(str2.getBytes(str));
                }
            }
            if (arrayList != null && e.F()) {
                for (String str4 : arrayList) {
                    if (!a(B, str4)) {
                        e.a(outputStream, "CUSTOMCACHEDINFO", str4);
                    }
                }
            }
        }
    }

    static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    static String b(String str) {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            Object[] objArr = A.get(str);
            int iIntValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static int a(int i2, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        int i3 = 0;
        if (LogType.isForNative(i2) || LogType.isForANR(i2)) {
            if (b.d) {
                synchronized (y) {
                    JNIBridge.nativeCmd(4, i2, str, null);
                }
                if (LogType.isForNative(i2)) {
                    i3 = 1;
                }
                if (LogType.isForANR(i2)) {
                    i3 |= 1048576;
                }
            } else {
                com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            }
        }
        if (LogType.isForJava(i2)) {
            a(str, Thread.currentThread());
            return i3 | 16;
        }
        return i3;
    }

    public static boolean a(boolean z2) {
        int iG;
        if (!b.c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.L()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            iG = 0;
        } else {
            if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.G() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            iG = g.G() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, iG);
        return true;
    }

    static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] strArrSplit = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArrSplit) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static String m() {
        if (!G) {
            g = com.uc.crashsdk.a.b.a(b.m());
            G = true;
            if (g == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (H) {
            if (b.d) {
                JNIBridge.set(128, g);
            }
        } else {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.d || !b.g) {
                String str = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + str);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    public static void a(int i2) {
        switch (i2) {
            case 201:
                com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (b.d && c) {
                    JNIBridge.nativeCmd(11, g.G(), String.valueOf(g.H()), null);
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                a(false);
                return;
            case 202:
                p();
                String str = String.format(Locale.US, "%s/%s/%s", g.T(), g.U(), g.V());
                g = m();
                if (b.d) {
                    JNIBridge.set(128, g);
                }
                boolean z2 = !str.equals(g);
                if (z2) {
                    com.uc.crashsdk.a.b.a(b.m(), str);
                }
                if (!z2 || !g.u()) {
                    return;
                }
                com.uc.crashsdk.a.a.a("crashsdk", String.format(Locale.US, "Is new version ('%s' -> '%s'), deleting old stats data!", g, str));
                b.v();
                return;
            default:
                if (!d) {
                    throw new AssertionError();
                }
                return;
        }
    }
}
