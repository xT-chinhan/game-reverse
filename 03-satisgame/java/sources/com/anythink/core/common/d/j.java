package com.anythink.core.common.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.core.common.u.ad;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j implements Thread.UncaughtExceptionHandler {
    private static volatile j d = null;
    private static final String i = "0";
    private static final String j = "1";
    private static final int k = 4;
    private Thread.UncaughtExceptionHandler b;
    private final Context c;
    private final String e = "crash_type";
    private final String f = "crash_msg";
    private final String g = f.c;
    private final String h = "crash_sdk_type";
    String a = "com.anythink";
    private volatile boolean l = false;
    private volatile boolean m = false;

    public static j a(Context context) {
        if (d == null) {
            synchronized (j.class) {
                if (d == null) {
                    d = new j(context);
                }
            }
        }
        return d;
    }

    private j(Context context) {
        this.c = context;
    }

    public final void a() {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.c).b(s.b().p());
        if (bVarB == null || bVarB.A() != 0) {
            try {
                Map<String, ?> mapB = ad.b(this.c, t.b.d);
                Iterator<?> it = mapB.values().iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    String string = next != null ? next.toString() : "";
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            com.anythink.core.common.t.f.b(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(f.c), jSONObject.optString("crash_sdk_type"));
                        } catch (Exception unused) {
                        }
                    }
                }
                if (mapB.size() > 0) {
                    ad.a(this.c, t.b.d);
                }
                if (this.m) {
                    return;
                }
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                if (defaultUncaughtExceptionHandler != this) {
                    this.b = defaultUncaughtExceptionHandler;
                    Thread.setDefaultUncaughtExceptionHandler(this);
                }
                this.m = true;
            } catch (Exception unused2) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            try {
                if (!this.l) {
                    this.l = true;
                    try {
                        String strB = b(th);
                        if (a(strB)) {
                            String strB2 = b(strB);
                            String strC = c(strB);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("crash_type", URLEncoder.encode(strB2));
                            jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + strB));
                            jSONObject.put(f.c, s.b().r());
                            jSONObject.put("crash_sdk_type", strC);
                            ad.a(this.c, t.b.d, System.currentTimeMillis() + "_crash", jSONObject.toString());
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
                a(thread, th);
                return;
            }
        }
        a(thread, th);
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof j)) {
                return;
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } catch (Throwable unused) {
        }
    }

    private void a(Throwable th) {
        try {
            String strB = b(th);
            if (a(strB)) {
                String strB2 = b(strB);
                String strC = c(strB);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crash_type", URLEncoder.encode(strB2));
                jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + strB));
                jSONObject.put(f.c, s.b().r());
                jSONObject.put("crash_sdk_type", strC);
                ad.a(this.c, t.b.d, System.currentTimeMillis() + "_crash", jSONObject.toString());
            }
        } catch (Throwable unused) {
        }
    }

    private String b() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            HashMap map = new HashMap(4);
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Thread key = it.next().getKey();
                if (key.getName().startsWith("anythink")) {
                    String str = key.getName() + "-" + key.getState();
                    if (map.containsKey(str)) {
                        map.put(str, Integer.valueOf(((Integer) map.get(str)).intValue() + 1));
                    } else {
                        map.put(str, 1);
                    }
                    i2++;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(map);
                jSONObject.put("anythink_thread_count", i2);
                try {
                    ActivityManager activityManager = (ActivityManager) this.c.getSystemService("activity");
                    Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                    if (processMemoryInfo.length > 0) {
                        jSONObject.put("app_memory", (processMemoryInfo[0].getTotalPss() / 1024) + "MB");
                    }
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("sys_total_memory", (memoryInfo.totalMem / 1048576) + "MB");
                    jSONObject.put("sys_avail_memory", (memoryInfo.availMem / 1048576) + "MB");
                } catch (Throwable unused) {
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                return th.getMessage();
            }
        } catch (Throwable th2) {
            return th2.getMessage();
        }
    }

    private boolean a(String str) {
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.c).b(s.b().p());
        if (bVarB != null) {
            if (bVarB.A() == 0) {
                return false;
            }
            String strC = bVarB.C();
            try {
                if (TextUtils.isEmpty(strC)) {
                    return true;
                }
                JSONArray jSONArray = new JSONArray(strC);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (str.contains(jSONArray.optString(i2))) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        } else if (str.contains(this.a)) {
            return true;
        }
        return false;
    }

    private void c() {
        Map<String, ?> mapB = ad.b(this.c, t.b.d);
        Iterator<?> it = mapB.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String string = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    com.anythink.core.common.t.f.b(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(f.c), jSONObject.optString("crash_sdk_type"));
                } catch (Exception unused) {
                }
            }
        }
        if (mapB.size() > 0) {
            ad.a(this.c, t.b.d);
        }
    }

    private static String b(Throwable th) {
        StringWriter stringWriter;
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        PrintWriter printWriter = null;
        try {
            stringWriter = new StringWriter();
            try {
                PrintWriter printWriter2 = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter2);
                    printWriter2.flush();
                    String string = stringWriter.toString();
                    try {
                        printWriter2.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        stringWriter.close();
                    } catch (Throwable unused2) {
                    }
                    return string;
                } catch (Throwable unused3) {
                    printWriter = printWriter2;
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    return "";
                }
            } catch (Throwable unused6) {
            }
        } catch (Throwable unused7) {
            stringWriter = null;
        }
    }

    private static String b(String str) {
        String str2 = "";
        try {
            Matcher matcher = Pattern.compile(".*?(Exception|Error|Death)", 2).matcher(str);
            String strGroup = matcher.find() ? matcher.group(0) : "";
            try {
                return !TextUtils.isEmpty(strGroup) ? strGroup.replaceAll("Caused by:", "").replaceAll(" ", "") : strGroup;
            } catch (Exception unused) {
                str2 = strGroup;
                return str2;
            }
        } catch (Exception unused2) {
        }
    }

    private String c(String str) {
        String str2 = this.a;
        if (!TextUtils.isEmpty(str) && str.contains(str2)) {
            try {
                for (String str3 : str.split("Caused by:")) {
                    if (str3.contains(str2)) {
                        String[] strArrSplit = str3.split("\\n");
                        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                            if (strArrSplit[i2].contains(str2) && i2 <= 4) {
                                return "1";
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "0";
    }
}
