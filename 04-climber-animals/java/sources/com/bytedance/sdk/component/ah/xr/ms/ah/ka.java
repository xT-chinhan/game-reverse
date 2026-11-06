package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.qv;
import com.bytedance.sdk.component.ah.xr.y;
import com.bytedance.sdk.component.ah.xr.zb;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Pattern f1063ms = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long ms(cv cvVar) {
        return ms(cvVar.ab());
    }

    public static long ms(qv qvVar) {
        return ms(qvVar.ms("Content-Length"));
    }

    private static long ms(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> xr(qv qvVar) {
        Set<String> setEmptySet = Collections.emptySet();
        int iMs = qvVar.ms();
        for (int i = 0; i < iMs; i++) {
            if ("Vary".equalsIgnoreCase(qvVar.ms(i))) {
                String strXr = qvVar.xr(i);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strXr.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    public static qv xr(cv cvVar) {
        return ms(cvVar.ch().ms().ah(), cvVar.ab());
    }

    public static qv ms(qv qvVar, qv qvVar2) {
        Set<String> setXr = xr(qvVar2);
        if (setXr.isEmpty()) {
            return new qv.ms().ms();
        }
        qv.ms msVar = new qv.ms();
        int iMs = qvVar.ms();
        for (int i = 0; i < iMs; i++) {
            String strMs = qvVar.ms(i);
            if (setXr.contains(strMs)) {
                msVar.ms(strMs, qvVar.xr(i));
            }
        }
        return msVar.ms();
    }

    public static void ms(zb zbVar, y yVar, qv qvVar) {
        if (zbVar == zb.f1152ms) {
            return;
        }
        com.bytedance.sdk.component.ah.xr.sl.ms(yVar, qvVar).isEmpty();
    }

    public static boolean ah(cv cvVar) {
        if (cvVar.ms().xr().equals("HEAD")) {
            return false;
        }
        int iAh = cvVar.ah();
        return (((iAh >= 100 && iAh < 200) || iAh == 204 || iAh == 304) && ms(cvVar) == -1 && !"chunked".equalsIgnoreCase(cvVar.ms("Transfer-Encoding"))) ? false : true;
    }

    public static int ms(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int ms(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int xr(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
