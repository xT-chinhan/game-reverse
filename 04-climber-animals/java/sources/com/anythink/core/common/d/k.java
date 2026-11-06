package com.anythink.core.common.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.core.common.v.af;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.constant.BaseConstants;
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
public class k implements Thread.UncaughtExceptionHandler {
    private static volatile k d = null;
    private static final String i = "0";
    private static final String j = "1";
    private static final int k = 4;
    private static volatile boolean l = false;
    private Thread.UncaughtExceptionHandler b;
    private Context c;
    private final String e = "crash_type";
    private final String f = "crash_msg";
    private final String g = g.c;
    private final String h = "crash_sdk_type";
    String a = "com.anythink";

    public static k a(Context context) {
        if (d == null) {
            synchronized (k.class) {
                if (d == null) {
                    d = new k(context);
                }
            }
        }
        return d;
    }

    private k(Context context) {
        this.c = context;
    }

    public final void a() {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.c).b(t.b().p());
        if (bVarB == null || bVarB.I() != 0) {
            try {
                Map<String, ?> mapB = af.b(this.c, u.b.d);
                Iterator<?> it = mapB.values().iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    String string = next != null ? next.toString() : "";
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string);
                            com.anythink.core.common.u.e.b(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(g.c), jSONObject.optString("crash_sdk_type"));
                        } catch (Exception unused) {
                        }
                    }
                }
                if (mapB.size() > 0) {
                    af.a(this.c, u.b.d);
                }
                if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof k)) {
                    this.b = Thread.getDefaultUncaughtExceptionHandler();
                }
                Thread.setDefaultUncaughtExceptionHandler(this);
            } catch (Exception unused2) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            try {
                if (l) {
                    return;
                }
                l = true;
                try {
                    String strB = b(th);
                    if (a(strB)) {
                        String strB2 = b(strB);
                        String strC = c(strB);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("crash_type", URLEncoder.encode(strB2));
                        jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + strB));
                        jSONObject.put(g.c, t.b().r());
                        jSONObject.put("crash_sdk_type", strC);
                        af.a(this.c, u.b.d, System.currentTimeMillis() + "_crash", jSONObject.toString());
                    }
                } catch (Throwable unused) {
                }
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
                if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof k)) {
                    return;
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } catch (Exception unused2) {
            }
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
                jSONObject.put(g.c, t.b().r());
                jSONObject.put("crash_sdk_type", strC);
                af.a(this.c, u.b.d, System.currentTimeMillis() + "_crash", jSONObject.toString());
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
                    ActivityManager activityManager = (ActivityManager) this.c.getSystemService(TTDownloadField.TT_ACTIVITY);
                    Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                    if (processMemoryInfo.length > 0) {
                        jSONObject.put("app_memory", (processMemoryInfo[0].getTotalPss() / 1024) + "MB");
                    }
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("sys_total_memory", (memoryInfo.totalMem / BaseConstants.MB_VALUE) + "MB");
                    jSONObject.put("sys_avail_memory", (memoryInfo.availMem / BaseConstants.MB_VALUE) + "MB");
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
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.c).b(t.b().p());
        if (bVarB != null) {
            if (bVarB.I() == 0) {
                return false;
            }
            String strK = bVarB.K();
            try {
                if (TextUtils.isEmpty(strK)) {
                    return true;
                }
                JSONArray jSONArray = new JSONArray(strK);
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
        Map<String, ?> mapB = af.b(this.c, u.b.d);
        Iterator<?> it = mapB.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String string = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    com.anythink.core.common.u.e.b(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(g.c), jSONObject.optString("crash_sdk_type"));
                } catch (Exception unused) {
                }
            }
        }
        if (mapB.size() > 0) {
            af.a(this.c, u.b.d);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004e A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:27:0x0049, B:29:0x004e), top: B:41:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x005a A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #4 {all -> 0x005d, blocks: (B:33:0x0055, B:35:0x005a), top: B:45:0x0055 }] */
    private static String b(Throwable th) throws Throwable {
        PrintWriter printWriter;
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = null;
        try {
            for (Throwable th2 = new Throwable(com.anythink.core.common.v.p.a(), th); th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof UnknownHostException) {
                    return "";
                }
            }
            StringWriter stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    printWriter.close();
                    stringWriter2.close();
                    String string = stringWriter2.toString();
                    try {
                        stringWriter2.close();
                        stringWriter2.close();
                    } catch (Throwable unused) {
                    }
                    return string;
                } catch (Exception unused2) {
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                            if (printWriter != null) {
                                stringWriter.close();
                            }
                        } catch (Throwable unused3) {
                            return "";
                        }
                    } else if (printWriter != null) {
                        stringWriter.close();
                    }
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                            if (printWriter != null) {
                                stringWriter.close();
                            }
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    } else if (printWriter != null) {
                        stringWriter.close();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
                printWriter = null;
            } catch (Throwable th4) {
                th = th4;
                printWriter = null;
            }
        } catch (Exception unused6) {
            printWriter = null;
        } catch (Throwable th5) {
            th = th5;
            printWriter = null;
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
