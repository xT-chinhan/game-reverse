package com.bytedance.ms.xr.x;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static String ms(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            ms(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder ms(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(j.z).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String ms(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (ah(th)) {
                ms(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            return stringWriter.toString();
        } catch (Exception unused) {
            return "";
        } finally {
            printWriter.close();
        }
    }

    public static JSONObject ms(String str) {
        boolean z;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!xr(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + j.z + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        z = jSONArray2.length() > 0;
                    }
                    if (z) {
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean xr(String str) {
        Set<String> setMs = ka.ms();
        if (setMs.contains(str)) {
            return true;
        }
        for (String str2 : setMs) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean xr(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            i++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final PrintWriter f595ms;

        ms(PrintWriter printWriter) {
            this.f595ms = printWriter;
        }

        Object ms() {
            return this.f595ms;
        }

        void ms(Object obj) {
            this.f595ms.println(obj);
        }
    }

    private static void ms(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        ms msVar = new ms(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (msVar.ms()) {
            msVar.ms(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (i > 256) {
                    msVar.ms("\t... skip " + (stackTrace.length - i) + " lines");
                    break;
                } else {
                    msVar.ms("\tat " + stackTraceElement);
                    i++;
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                ms(th2, msVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                ms(cause, msVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void ms(Throwable th, ms msVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            msVar.ms("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int iMin = Math.min(stackTrace.length, 256);
        int i = iMin - 1;
        int i2 = i;
        for (int iMin2 = Math.min(stackTraceElementArr.length, 256) - 1; i2 >= 0 && iMin2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[iMin2]); iMin2--) {
            i2--;
        }
        int i3 = i - i2;
        msVar.ms(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            msVar.ms(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            msVar.ms("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            msVar.ms(str2 + "\t... " + i3 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            ms(th2, msVar, stackTrace, "Suppressed: ", str2 + "\t", set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            ms(cause, msVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean ah(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }
}
