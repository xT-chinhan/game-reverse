package com.byazt.wf;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public final class g {
    public static String pr(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            pr(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder pr(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String pr(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (hn(th)) {
                pr(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            return stringWriter.toString();
        } catch (Exception e) {
            return "";
        } finally {
            printWriter.close();
        }
    }

    public static JSONObject pr(String str) {
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
                if (!hw(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put(Constants.THREAD_NAME_FIELD, key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value == null) {
                        z = true;
                    } else {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
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
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean hw(String str) {
        Set<String> setPr = c.pr();
        if (setPr.contains(str)) {
            return true;
        }
        for (String str2 : setPr) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hw(Throwable th) {
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
            } catch (Throwable th2) {
            }
        }
        return false;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 201, MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS})
    private static class pr {
        public final PrintWriter pr;

        public pr(PrintWriter printWriter) {
            this.pr = printWriter;
        }

        public Object pr() {
            return this.pr;
        }

        public void pr(Object obj) {
            this.pr.println(obj);
        }
    }

    private static void pr(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        pr prVar = new pr(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (prVar.pr()) {
            prVar.pr(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (i > 256) {
                    prVar.pr("\t... skip " + (stackTrace.length - i) + " lines");
                    break;
                } else {
                    prVar.pr("\tat " + stackTraceElement);
                    i++;
                }
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    pr(th2, prVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                pr(cause, prVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void pr(Throwable th, pr prVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            prVar.pr("\t[CIRCULAR REFERENCE:" + th + "]");
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
        prVar.pr(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            prVar.pr(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            prVar.pr("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            prVar.pr(str2 + "\t... " + i3 + " more");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                pr(th2, prVar, stackTrace, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            pr(cause, prVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean hn(Throwable th) {
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
