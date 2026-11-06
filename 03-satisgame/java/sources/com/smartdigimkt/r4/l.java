package com.smartdigimkt.r4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
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

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Thread.UncaughtExceptionHandler {
    public static volatile l c = null;
    public static volatile boolean d = false;
    public Thread.UncaughtExceptionHandler a;
    public final Context b;

    public l(Context context) {
        this.b = context;
    }

    public final String a() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            HashMap map = new HashMap(4);
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Thread key = it.next().getKey();
                if (key.getName().startsWith("sdm")) {
                    String str = key.getName() + "-" + key.getState();
                    if (map.containsKey(str)) {
                        map.put(str, Integer.valueOf(((Integer) map.get(str)).intValue() + 1));
                    } else {
                        map.put(str, 1);
                    }
                    i++;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(map);
                jSONObject.put("sdm_thread_count", i);
                try {
                    ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
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

    public final void b(Throwable th) {
        String strGroup;
        String str = "";
        try {
            String strA = a(th);
            com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
            if (aVarA != null) {
                if (aVarA.x == 0) {
                    return;
                }
                String str2 = aVarA.y;
                if (!TextUtils.isEmpty(str2)) {
                    JSONArray jSONArray = new JSONArray(str2);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (!strA.contains(jSONArray.optString(i))) {
                        }
                    }
                    return;
                }
            } else if (!strA.contains("com.smartdigimkt")) {
                return;
            }
            try {
                Matcher matcher = Pattern.compile(".*?(Exception|Error|Death)", 2).matcher(strA);
                strGroup = matcher.find() ? matcher.group(0) : "";
                try {
                    if (!TextUtils.isEmpty(strGroup)) {
                        strGroup = strGroup.replaceAll("Caused by:", "").replaceAll(" ", "");
                    }
                } catch (Exception unused) {
                    str = strGroup;
                    strGroup = str;
                }
            } catch (Exception unused2) {
            }
            String strA2 = a(strA);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("crash_type", URLEncoder.encode(strGroup));
            jSONObject.put("crash_msg", URLEncoder.encode(a() + "\n" + strA));
            jSONObject.put(com.anythink.core.common.d.f.c, SDKContext.getInstance().f());
            jSONObject.put("crash_sdk_type", strA2);
            String str3 = System.currentTimeMillis() + "_crash";
            Context context = this.b;
            String string = jSONObject.toString();
            if (context == null) {
                return;
            }
            com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_crash").a(str3, string, 2);
        } catch (Throwable unused3) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            try {
                if (d) {
                    return;
                }
                d = true;
                b(th);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
                if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof l)) {
                    return;
                }
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } catch (Exception unused) {
            }
        }
    }

    public final void b() {
        Map all;
        Context context;
        Context context2 = this.b;
        if (context2 == null) {
            all = null;
        } else {
            try {
                all = com.smartdigimkt.k4.c.a().a(context2, "sdm_adx_rp_crash").getAll();
                if (all == null) {
                    all = new HashMap();
                }
            } catch (Throwable unused) {
                all = null;
            }
        }
        Iterator it = all.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String string = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    com.smartdigimkt.n3.k.a(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(com.anythink.core.common.d.f.c), jSONObject.optString("crash_sdk_type"));
                } catch (Exception unused2) {
                }
            }
        }
        if (all.size() <= 0 || (context = this.b) == null) {
            return;
        }
        try {
            com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_crash").clear();
        } catch (Throwable unused3) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004e A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:26:0x0049, B:28:0x004e), top: B:40:0x0049 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x005a A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #4 {all -> 0x005d, blocks: (B:32:0x0055, B:34:0x005a), top: B:44:0x0055 }] */
    public static String a(Throwable th) throws Throwable {
        PrintWriter printWriter;
        StringWriter stringWriter = null;
        if (th == null) {
            return "";
        }
        try {
            for (Throwable th2 = new Throwable(j.a(), th); th2 != null; th2 = th2.getCause()) {
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

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("com.smartdigimkt")) {
            try {
                for (String str2 : str.split("Caused by:")) {
                    if (str2.contains("com.smartdigimkt")) {
                        String[] strArrSplit = str2.split("\\n");
                        for (int i = 0; i < strArrSplit.length; i++) {
                            if (strArrSplit[i].contains("com.smartdigimkt") && i <= 4) {
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
