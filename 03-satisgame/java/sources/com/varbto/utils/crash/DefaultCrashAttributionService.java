package com.varbto.utils.crash;

import android.os.Process;
import com.varbto.internal.g;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultCrashAttributionService implements CrashAttributionService {
    public static final String[] a = {"com.anythink"};
    public static final String[] b = {"com.google.gms.ads"};

    public static String a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        int iMin = Math.min(stackTraceElementArr.length, 8);
        for (int i = 0; i < iMin; i++) {
            String className = stackTraceElementArr[i].getClassName();
            for (String str : strArr) {
                if (className != null && className.startsWith(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public static boolean b(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        if (stackTraceElementArr != null && stackTraceElementArr.length != 0) {
            int iMin = Math.min(stackTraceElementArr.length, 8);
            for (int i = 0; i < iMin; i++) {
                String className = stackTraceElementArr[i].getClassName();
                for (String str : strArr) {
                    if (className != null && className.startsWith(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.varbto.utils.crash.CrashAttributionService
    public CrashReport process(Throwable th) {
        boolean z;
        boolean z2;
        String strA;
        g gVar;
        int i;
        String strA2;
        g gVar2;
        String str;
        int i2;
        if (th == null) {
            HashMap map = new HashMap();
            map.put("thread", Thread.currentThread().getName());
            return new CrashReport("CRASH-" + System.currentTimeMillis(), g.e, 0, null, "None", map);
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String[] strArr = a;
        boolean zB = b(stackTrace, strArr);
        String[] strArr2 = b;
        boolean zB2 = b(stackTrace, strArr2);
        Throwable cause = th.getCause();
        while (true) {
            z = true;
            if (cause == null) {
                z2 = false;
                break;
            }
            if (b(cause.getStackTrace(), strArr)) {
                z2 = true;
                break;
            }
            cause = cause.getCause();
        }
        Throwable cause2 = th.getCause();
        while (true) {
            if (cause2 == null) {
                z = false;
                break;
            }
            if (b(cause2.getStackTrace(), strArr2)) {
                break;
            }
            cause2 = cause2.getCause();
        }
        String str2 = "SDK";
        if (!zB) {
            str2 = "Network";
            if (zB2) {
                g gVar3 = g.c;
                strA2 = a(stackTrace, strArr2);
                gVar2 = gVar3;
                str = "Network";
                i2 = 85;
            } else {
                strA = null;
                if (z2) {
                    gVar = g.b;
                    Throwable cause3 = th.getCause();
                    while (true) {
                        if (cause3 == null) {
                            i = 70;
                            break;
                        }
                        String strA3 = a(cause3.getStackTrace(), strArr);
                        if (strA3 != null) {
                            i = 70;
                            strA = strA3;
                            break;
                        }
                        cause3 = cause3.getCause();
                    }
                } else if (z) {
                    g gVar4 = g.d;
                    for (Throwable cause4 = th.getCause(); cause4 != null; cause4 = cause4.getCause()) {
                        String strA4 = a(cause4.getStackTrace(), strArr2);
                        if (strA4 != null) {
                            strA = strA4;
                            break;
                        }
                    }
                    gVar = gVar4;
                    i = 60;
                } else {
                    gVar = g.e;
                    str2 = "None";
                    i = 40;
                }
            }
            HashMap map2 = new HashMap();
            map2.put("thread", Thread.currentThread().getName());
            map2.put("process", Process.myUid() + "");
            map2.put("exception", th.getClass().getName());
            return new CrashReport("CRASH-" + System.currentTimeMillis(), gVar2, i2, strA2, str, map2);
        }
        gVar = g.a;
        strA = a(stackTrace, strArr);
        i = 90;
        strA2 = strA;
        i2 = i;
        gVar2 = gVar;
        str = str2;
        HashMap map3 = new HashMap();
        map3.put("thread", Thread.currentThread().getName());
        map3.put("process", Process.myUid() + "");
        map3.put("exception", th.getClass().getName());
        return new CrashReport("CRASH-" + System.currentTimeMillis(), gVar2, i2, strA2, str, map3);
    }
}
