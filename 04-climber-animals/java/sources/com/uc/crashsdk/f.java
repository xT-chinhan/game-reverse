package com.uc.crashsdk;

import android.util.SparseArray;
import com.uc.crashsdk.a.h;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();
    private static final SparseArray<String> c = new SparseArray<>();
    private static final Object d = new Object();
    private static boolean e = false;

    static void a(int i) {
        a(i, 1);
    }

    static void a(int i, int i2) {
        if (i2 == 0) {
            com.uc.crashsdk.a.a.b("Add stat for type " + i + " with count 0!");
        } else {
            a(b.c(), new com.uc.crashsdk.a.e(751, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        }
    }

    private static boolean b(int i, int i2) {
        try {
            b.x();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            String strC = c(i);
            if (strC == null) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stat type not exists: " + i, null);
                return false;
            }
            File file = new File(b.c());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            StringBuffer stringBufferA = a(file);
            if (com.uc.crashsdk.a.g.a(stringBufferA)) {
                if (stringBufferA == null) {
                    stringBufferA = new StringBuffer();
                }
                stringBufferA.append("[");
                stringBufferA.append(e.h());
                stringBufferA.append("]\n");
            }
            a(stringBufferA, strC, a(stringBufferA, strC) + i2);
            return a(file, stringBufferA);
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
            return false;
        }
    }

    private static StringBuffer a(File file) throws Throwable {
        FileReader fileReader = null;
        if (!file.exists()) {
            return null;
        }
        char[] cArrD = d();
        if (cArrD == null) {
            com.uc.crashsdk.a.a.a("crashsdk", "readCrashStatData alloc buffer failed!", null);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                FileReader fileReader2 = new FileReader(file);
                try {
                    int i = fileReader2.read(cArrD);
                    if (i > 0) {
                        fileReader = null;
                        stringBuffer.append(cArrD, 0, i);
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Exception e2) {
                    e = e2;
                    fileReader = fileReader2;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileReader);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    com.uc.crashsdk.a.g.a(fileReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return stringBuffer;
    }

    private static String a(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        int iIndexOf = stringBuffer.indexOf("[");
        if (iIndexOf < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name start!", null);
            return null;
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = stringBuffer.indexOf("]", i);
        if (iIndexOf2 < 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: Can not found process name end!", null);
            return null;
        }
        String strSubstring = stringBuffer.substring(i, iIndexOf2);
        if (strSubstring.length() > 0) {
            return strSubstring;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "getProcessName: process name is empty", null);
        return null;
    }

    private static int a(StringBuffer stringBuffer, String str) {
        int iIndexOf = stringBuffer.indexOf(str);
        if (iIndexOf < 0) {
            return 0;
        }
        int iIndexOf2 = stringBuffer.indexOf("=", iIndexOf + str.length());
        if (iIndexOf2 < 0) {
            com.uc.crashsdk.a.a.b(str + " line not contain '='!");
            return 0;
        }
        int i = iIndexOf2 + 1;
        int iIndexOf3 = stringBuffer.indexOf("\n", i);
        if (iIndexOf3 < 0) {
            iIndexOf3 = stringBuffer.length();
        }
        try {
            int i2 = Integer.parseInt(stringBuffer.substring(i, iIndexOf3));
            if (i2 < 0) {
                return 0;
            }
            return i2;
        } catch (NumberFormatException e2) {
            com.uc.crashsdk.a.g.a(e2);
            return 0;
        }
    }

    private static void a(StringBuffer stringBuffer, String str, int i) {
        int iIndexOf = stringBuffer.indexOf(str);
        if (iIndexOf < 0) {
            if (i > 0) {
                stringBuffer.append(str).append("=").append(i).append("\n");
            }
        } else {
            int iIndexOf2 = stringBuffer.indexOf("\n", iIndexOf);
            if (iIndexOf2 < 0) {
                iIndexOf2 = stringBuffer.length();
            }
            stringBuffer.replace(iIndexOf, iIndexOf2, str + "=" + String.valueOf(i));
        }
    }

    private static boolean a(File file, StringBuffer stringBuffer) throws Throwable {
        FileWriter fileWriter = null;
        try {
            try {
                FileWriter fileWriter2 = new FileWriter(file);
                try {
                    String string = stringBuffer.toString();
                    fileWriter2.write(string, 0, string.length());
                    com.uc.crashsdk.a.g.a(fileWriter2);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileWriter = fileWriter2;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    com.uc.crashsdk.a.g.a(fileWriter);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean b(String str) throws Throwable {
        File file = new File(str);
        StringBuffer stringBufferA = a(file);
        if (com.uc.crashsdk.a.g.a(stringBufferA)) {
            return false;
        }
        String strA = a(stringBufferA);
        StringBuffer stringBuffer = null;
        if (strA == null || strA.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "reportCrashStatImpl: process name is invalid", null);
            return false;
        }
        SparseArray<String> sparseArrayE = e();
        HashMap map = new HashMap();
        boolean zP = g.P();
        if (zP) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("reportCrashStatImpl: processName: ");
            stringBuffer.append(strA + "\n");
        }
        boolean z = false;
        for (int i = 0; i < sparseArrayE.size(); i++) {
            try {
                int iKeyAt = sparseArrayE.keyAt(i);
                String str2 = sparseArrayE.get(iKeyAt);
                int iA = a(stringBufferA, str2);
                if (iA > 0) {
                    if (zP) {
                        stringBuffer.append("name: ").append(str2);
                        stringBuffer.append(", key: ").append(iKeyAt);
                        stringBuffer.append(", count: ").append(iA);
                        stringBuffer.append("\n");
                    }
                    h.a(strA, iKeyAt, iA);
                    map.put(str2, Integer.valueOf(iA));
                    a(stringBufferA, str2, 0);
                    z = true;
                }
            } catch (Throwable th) {
                if (z) {
                    a(file, stringBufferA);
                    if (map.size() > 0) {
                        a(strA, (HashMap<String, Integer>) map, b.a(str));
                    }
                }
                throw th;
            }
        }
        if (zP) {
            com.uc.crashsdk.a.a.a(stringBuffer.toString());
        }
        if (!z) {
            return true;
        }
        a(file, stringBufferA);
        if (map.size() <= 0) {
            return true;
        }
        a(strA, (HashMap<String, Integer>) map, b.a(str));
        return true;
    }

    private static void a(String str, HashMap<String, Integer> map, String str2) {
        if (map.size() <= 0) {
            return;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: processName is null", null);
        } else if (com.uc.crashsdk.a.g.a(str2)) {
            com.uc.crashsdk.a.a.a("crashsdk", "cacheReportedStatsForCallback: callbackCacheFilePathName is null", null);
        } else {
            a(str2, new com.uc.crashsdk.a.e(754, new Object[]{str, map, str2}));
        }
    }

    private static void b(String str, HashMap<String, Integer> map, String str2) {
        try {
            b.x();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        try {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            StringBuffer stringBufferA = a(file);
            if (com.uc.crashsdk.a.g.a(stringBufferA)) {
                if (stringBufferA == null) {
                    stringBufferA = new StringBuffer();
                }
                stringBufferA.append("[");
                stringBufferA.append(str);
                stringBufferA.append("]\n");
            }
            boolean z = false;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int iIntValue = entry.getValue().intValue();
                if (iIntValue > 0) {
                    String key = entry.getKey();
                    a(stringBufferA, key, iIntValue + a(stringBufferA, key));
                    z = true;
                }
            }
            if (z) {
                a(file, stringBufferA);
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    static int a(boolean z) {
        if (z) {
            return c(b.e()) ? 1 : 0;
        }
        File[] fileArrF = b.f();
        if (fileArrF == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrF) {
            if (c(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    private static boolean c(String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(755, new Object[]{str}));
        }
        return false;
    }

    private static boolean d(String str) throws Throwable {
        if (!a && str == null) {
            throw new AssertionError();
        }
        File file = new File(str);
        StringBuffer stringBufferA = a(file);
        if (com.uc.crashsdk.a.g.a(stringBufferA)) {
            return false;
        }
        String strA = a(stringBufferA);
        StringBuffer stringBuffer = null;
        if (strA == null || strA.length() <= 0) {
            com.uc.crashsdk.a.a.a("crashsdk", "notifyStatsDetailImpl: process name is invalid", null);
            return false;
        }
        SparseArray<String> sparseArrayE = e();
        boolean zP = g.P();
        if (zP) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("notifyStatsDetailImpl: processName: ");
            stringBuffer.append(strA + "\n");
        }
        boolean z = false;
        for (int i = 0; i < sparseArrayE.size(); i++) {
            try {
                int iKeyAt = sparseArrayE.keyAt(i);
                String str2 = sparseArrayE.get(iKeyAt);
                int iA = a(stringBufferA, str2);
                if (iA > 0) {
                    if (zP) {
                        stringBuffer.append("name: ").append(str2);
                        stringBuffer.append(", key: ").append(iKeyAt);
                        stringBuffer.append(", count: ").append(iA);
                        stringBuffer.append("\n");
                    }
                    d.a(strA, iKeyAt, iA);
                    a(stringBufferA, str2, 0);
                    z = true;
                }
            } catch (Throwable th) {
                if (z) {
                    a(file, stringBufferA);
                }
                throw th;
            }
        }
        if (zP) {
            com.uc.crashsdk.a.a.a(stringBuffer.toString());
        }
        if (z) {
            d.a(strA, 1000000, 0);
        }
        if (z) {
            a(file, stringBufferA);
        }
        return z;
    }

    static int b(boolean z) {
        if (z) {
            return e(b.e()) ? 1 : 0;
        }
        File[] fileArrF = b.f();
        if (fileArrF == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrF) {
            if (e(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    private static boolean e(String str) {
        if (!com.uc.crashsdk.a.g.a(str) && new File(str).exists()) {
            return a(str, new com.uc.crashsdk.a.e(756, new Object[]{str}));
        }
        return false;
    }

    private static char[] d() {
        char[] cArr = null;
        int i = 1024;
        while (cArr == null && i > 0) {
            try {
                cArr = new char[i];
            } catch (Throwable unused) {
                i /= 2;
                if (i < 512) {
                    return cArr;
                }
            }
        }
        return cArr;
    }

    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        return b.a(b, str, eVar);
    }

    static boolean a(String str, boolean z) {
        if (h.a(z, "crash detail report")) {
            return false;
        }
        return a(str, new com.uc.crashsdk.a.e(752, new Object[]{str}));
    }

    private static String c(int i) {
        String str;
        f();
        SparseArray<String> sparseArray = c;
        synchronized (sparseArray) {
            str = sparseArray.get(i);
        }
        return str;
    }

    private static SparseArray<String> e() {
        SparseArray<String> sparseArrayClone;
        f();
        SparseArray<String> sparseArray = c;
        synchronized (sparseArray) {
            sparseArrayClone = sparseArray.clone();
        }
        return sparseArrayClone;
    }

    private static void f() {
        SparseArray<String> sparseArray = c;
        synchronized (sparseArray) {
            if (sparseArray.size() != 0) {
                return;
            }
            sparseArray.put(100, "start_pv");
            sparseArray.put(102, "start_hpv");
            sparseArray.put(1, "all_all");
            sparseArray.put(2, "all_fg");
            sparseArray.put(101, "all_bg");
            sparseArray.put(3, "java_fg");
            sparseArray.put(4, "java_bg");
            sparseArray.put(7, "native_fg");
            sparseArray.put(8, "native_bg");
            sparseArray.put(27, "native_anr_fg");
            sparseArray.put(28, "native_anr_bg");
            sparseArray.put(9, "native_ok");
            sparseArray.put(10, "unexp_anr");
            sparseArray.put(29, "unexp_lowmem");
            sparseArray.put(30, "unexp_killed");
            sparseArray.put(31, "unexp_exit");
            sparseArray.put(32, "unexp_restart");
            sparseArray.put(11, "unexp_fg");
            sparseArray.put(12, "unexp_bg");
            sparseArray.put(40, "anr_fg");
            sparseArray.put(41, "anr_bg");
            sparseArray.put(42, "anr_cr_fg");
            sparseArray.put(43, "anr_cr_bg");
            sparseArray.put(13, "log_up_succ");
            sparseArray.put(14, "log_up_fail");
            sparseArray.put(15, "log_empty");
            sparseArray.put(200, "log_tmp");
            sparseArray.put(16, "log_abd_all");
            sparseArray.put(22, "log_abd_builtin");
            sparseArray.put(23, "log_abd_custom");
            sparseArray.put(17, "log_large");
            sparseArray.put(18, "log_up_all");
            sparseArray.put(19, "log_up_bytes");
            sparseArray.put(20, "log_up_crash");
            sparseArray.put(21, "log_up_custom");
            sparseArray.put(24, "log_zipped");
            sparseArray.put(201, "log_enced");
            sparseArray.put(25, "log_renamed");
            sparseArray.put(26, "log_safe_skip");
        }
    }

    static void c(boolean z) {
        if (g.R() && !b.L()) {
            e.j();
            if (!h.e()) {
                h.a(z);
            }
            if (b.F()) {
                d(z);
                a(b.c(), z);
                h.b(z);
            }
        }
    }

    static int a() {
        File[] fileArrD = b.d();
        if (fileArrD == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrD) {
            if (a(file.getAbsolutePath(), false)) {
                i++;
            }
        }
        return i;
    }

    static boolean a(String str) {
        return a(str, new com.uc.crashsdk.a.e(753, new Object[]{str}));
    }

    static int b() {
        File[] fileArrD = b.d();
        if (fileArrD == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrD) {
            if (a(file.getAbsolutePath())) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004a A[Catch: all -> 0x0056, TryCatch #0 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0016, B:15:0x0018, B:17:0x001f, B:19:0x0029, B:28:0x004a, B:29:0x004d, B:30:0x0054, B:21:0x0030, B:23:0x0036, B:25:0x0041), top: B:35:0x0008 }] */
    static void d(boolean z) {
        boolean z2;
        if (e) {
            return;
        }
        synchronized (d) {
            if (e) {
                return;
            }
            if (h.a(z, "crash detail")) {
                return;
            }
            if (b.s()) {
                a(2, 1);
                if (b.r()) {
                    a(42, 1);
                }
            } else {
                if (b.t()) {
                    a(101, 1);
                    if (b.r()) {
                        a(43, 1);
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    a(1, 1);
                }
                a(100, 1);
                e = true;
            }
            z2 = true;
            if (z2) {
                a(1, 1);
            }
            a(100, 1);
            e = true;
        }
    }

    static void c() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(700), com.tapsdk.tapad.e.a.f);
    }

    public static void b(int i) {
        if (i != 700) {
            return;
        }
        d(false);
    }

    public static boolean a(int i, Object[] objArr) {
        switch (i) {
            case 751:
                if (a || objArr != null) {
                    return b(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                }
                throw new AssertionError();
            case 752:
                if (a || objArr != null) {
                    return b((String) objArr[0]);
                }
                throw new AssertionError();
            case 753:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file = new File((String) objArr[0]);
                if (!file.exists()) {
                    return false;
                }
                file.delete();
                return true;
            case 754:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                b((String) objArr[0], (HashMap) objArr[1], (String) objArr[2]);
                return true;
            case 755:
                if (a || objArr != null) {
                    return d((String) objArr[0]);
                }
                throw new AssertionError();
            case 756:
                if (!a && objArr == null) {
                    throw new AssertionError();
                }
                File file2 = new File((String) objArr[0]);
                if (!file2.exists()) {
                    return false;
                }
                file2.delete();
                return true;
            default:
                return false;
        }
    }
}
