package com.uc.crashsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.mar.sdk.MARCode;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.uc.crashsdk.JNIBridge;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static Context b;
    static final /* synthetic */ boolean a = true;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static String g = null;
    private static boolean h = false;
    private static final Object i = new Object();
    private static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[524288];
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                while (true) {
                    try {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            a(fileInputStream);
                            a(fileOutputStream2);
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void b(File file) {
        a(file, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable, java.io.FileInputStream] */
    public static String c(File file) throws Throwable {
        ?? fileInputStream;
        String string;
        if (!file.exists()) {
            return "";
        }
        ?? r1 = 0;
        ?? r2 = 0;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[256];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i2));
                    }
                    string = sb.toString();
                    a((Closeable) fileInputStream);
                    r1 = sb;
                } catch (Throwable th) {
                    th = th;
                    r2 = fileInputStream;
                    a(th, false);
                    a((Closeable) r2);
                    string = "";
                    r1 = r2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = r1;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return string;
    }

    public static String d(File file) {
        return a(file, 64, true);
    }

    public static String a(File file, int i2, boolean z) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[i2];
                    int i3 = fileInputStream.read(bArr);
                    if (i3 > 0) {
                        String str = new String(bArr, 0, i3);
                        a(fileInputStream);
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (z) {
                        a(th, false);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            a(fileInputStream);
            throw th;
        }
        a(fileInputStream);
        return null;
    }

    public static byte[] e(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    fileInputStream.read(bArr);
                    a(fileInputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    a(th, false);
                    a(fileInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static ArrayList<String> a(File file, int i2) throws Throwable {
        BufferedReader bufferedReader;
        Reader fileReader;
        ArrayList<String> arrayList = new ArrayList<>();
        Reader reader = null;
        try {
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i3 = 0;
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        arrayList.add(line);
                        i3++;
                        if (i2 > 0 && i3 >= i2) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        reader = bufferedReader;
                        a(fileReader);
                        a(reader);
                        throw th;
                    }
                }
                a(fileReader);
            } catch (Throwable th2) {
                th = th2;
                a(fileReader);
                a(reader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        a(bufferedReader);
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    a(fileOutputStream2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    a(th, false);
                    a(fileOutputStream);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(File file, String str) {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    fileWriter2.write(str, 0, str.length());
                    a(fileWriter2);
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    a(th, false);
                    a(fileWriter);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a(th, true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[PHI: r2
      0x002b: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v3 java.lang.String) binds: [B:7:0x0018, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    public static String a(String str, String str2, boolean z) throws Throwable {
        String str3 = null;
        if (new File(str).exists()) {
            String strA = b.a(str);
            if (!a(strA)) {
                if (z) {
                    strA = strA.trim();
                    if (strA.toLowerCase().startsWith("http")) {
                        str3 = strA;
                    }
                } else {
                    str3 = strA;
                }
            }
        }
        return str3 == null ? str2 : str3;
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(StringBuffer stringBuffer) {
        return stringBuffer == null || stringBuffer.length() == 0;
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static long c(String str) {
        if (!a(str)) {
            try {
                long j2 = Long.parseLong(str.trim());
                if (j2 < 0) {
                    return 0L;
                }
                return j2;
            } catch (NumberFormatException e2) {
            }
        }
        return 0L;
    }

    public static void a(Throwable th) {
        a(th, false);
    }

    public static void b(Throwable th) {
        a(th, true);
    }

    private static void a(Throwable th, boolean z) {
        if (!z) {
            try {
                if (!com.uc.crashsdk.g.O()) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        }
        th.printStackTrace();
    }

    public static void a(Context context) {
        if (b != null) {
            a.b("mContext is existed");
        }
        b = context;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        c = applicationInfo.dataDir;
        d = applicationInfo.sourceDir;
        try {
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            if (obj != null && (obj instanceof String)) {
                e = (String) obj;
            }
        } catch (Throwable th) {
            a(th, false);
        }
    }

    public static Context a() {
        return b;
    }

    public static String b() {
        return c;
    }

    public static String c() {
        return d;
    }

    public static String d() {
        if (e != null) {
            return e;
        }
        return "";
    }

    public static boolean e() {
        if (g()) {
            return true;
        }
        return f();
    }

    public static boolean f() {
        return Build.TAGS != null && Build.TAGS.contains("test-keys");
    }

    public static boolean g() {
        int iIndexOf;
        String strI = i();
        if (!a(strI) && (iIndexOf = strI.indexOf(" root ")) > 0) {
            String strSubstring = strI.substring(0, iIndexOf);
            if (strSubstring.contains("x") || strSubstring.contains(an.aB)) {
                return true;
            }
        }
        return false;
    }

    public static String h() {
        l();
        if (a(f)) {
            return "";
        }
        return f;
    }

    public static String i() {
        l();
        if (a(g)) {
            return "";
        }
        return g;
    }

    public static void j() {
        f.a(0, new e(800), IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS);
    }

    public static void a(int i2) {
        if (i2 == 800) {
            l();
        } else if (!a) {
            throw new AssertionError();
        }
    }

    private static void l() {
        String strTrim;
        int iIndexOf;
        int iIndexOf2;
        if (h) {
            return;
        }
        synchronized (i) {
            if (h) {
                return;
            }
            String strA = a(new String[]{"sh", "-c", "type su"});
            if (!a(strA) && (iIndexOf = (strTrim = strA.trim()).indexOf(32)) > 0 && strTrim.contains("/su") && (iIndexOf2 = strTrim.indexOf(47, iIndexOf + 1)) > 0) {
                f = strTrim.substring(iIndexOf2);
                String strA2 = a(new String[]{"ls", "-l", f});
                if (!a(strA2)) {
                    g = strA2.trim();
                }
            }
            h = true;
            k();
        }
    }

    public static void k() {
        if (!com.uc.crashsdk.b.d || !h) {
            return;
        }
        JNIBridge.set(MARCode.CODE_VIVOCHANNEL_CALLBACK, f);
        JNIBridge.set(124, g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private static String a(String[] strArr) throws Throwable {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader, 512);
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                String strTrim = sb.toString().trim();
                                a(bufferedReader);
                                a(inputStreamReader);
                                return strTrim;
                            }
                            sb.append(line);
                        }
                    } catch (Throwable th) {
                        th = th;
                        a(th, false);
                        a(bufferedReader);
                        a(inputStreamReader);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a((Closeable) r0);
                    a(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                r0 = strArr;
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public static String d(String str) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            int length = bArrDigest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            int i2 = length + 0;
            for (int i3 = 0; i3 < i2; i3++) {
                byte b2 = bArrDigest[i3];
                char c2 = j[(b2 & 240) >> 4];
                char c3 = j[b2 & cc.m];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (Exception e2) {
            a.a("crashsdk", "getMD5: ", e2);
            return null;
        }
    }
}
