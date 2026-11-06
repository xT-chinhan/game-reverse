package com.byazt.yw;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 110})
public final class sz {
    public static String n(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            n(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder n(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(i.E).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String n(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (s(th)) {
                n(th, printWriter);
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

    public static JSONObject n(String str) {
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
                if (!qg(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + i.E + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
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

    private static boolean qg(String str) {
        Set<String> setN = l.n();
        if (setN.contains(str)) {
            return true;
        }
        for (String str2 : setN) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean qg(Throwable th) {
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

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 1222})
    private static class n {
        public final PrintWriter n;

        public n(PrintWriter printWriter) {
            this.n = printWriter;
        }

        public Object n() {
            return this.n;
        }

        public void n(Object obj) {
            this.n.println(obj);
        }
    }

    private static void n(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        n nVar = new n(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (nVar.n()) {
            nVar.n(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (i > 256) {
                    nVar.n("\t... skip " + (stackTrace.length - i) + " lines");
                    break;
                } else {
                    nVar.n("\tat " + stackTraceElement);
                    i++;
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                n(th2, nVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                n(cause, nVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void n(Throwable th, n nVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            nVar.n("\t[CIRCULAR REFERENCE:" + th + "]");
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
        nVar.n(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            nVar.n(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            nVar.n("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            nVar.n(str2 + "\t... " + i3 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            n(th2, nVar, stackTrace, "Suppressed: ", str2 + "\t", set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            n(cause, nVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean s(Throwable th) {
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
