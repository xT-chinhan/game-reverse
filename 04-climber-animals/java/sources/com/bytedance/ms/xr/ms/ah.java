package com.bytedance.ms.xr.ms;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.core.common.e.a;
import com.bytedance.ms.xr.x;
import com.bytedance.ms.xr.x.ch;
import com.bytedance.sdk.component.utils.sl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static volatile boolean f582ms = true;
    private final SharedPreferences ab;
    private d ah;
    private volatile boolean c = false;
    private final Context d;
    private volatile long ka;
    private ms xr;

    public ah(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.d = context;
        SharedPreferences sharedPreferencesXr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "anr_monitor_table", 0);
        this.ab = sharedPreferencesXr;
        this.ka = sharedPreferencesXr.getLong("trace_anr_happen_time", 0L);
    }

    public void ms() {
        if (this.c) {
            return;
        }
        this.ah = new d(this);
        this.c = true;
    }

    boolean ms(int i, String str, int i2) {
        JSONObject jSONObjectMs;
        JSONObject jSONObjectMs2;
        try {
            jSONObjectMs = ka.ms(f582ms);
        } catch (Throwable th) {
            sl.ms(th);
            jSONObjectMs = null;
        }
        String strMs = ka.ms(this.d, i2);
        if (TextUtils.isEmpty(strMs)) {
            return false;
        }
        try {
            com.bytedance.ms.xr.c cVarD = x.xr().d();
            if (cVarD != null && cVarD.ms()) {
                if (i == 200 && (jSONObjectMs2 = ms(str, Process.myPid(), this.d.getPackageName())) != null && jSONObjectMs2.length() > 0) {
                    jSONObjectMs = jSONObjectMs2;
                }
                if (jSONObjectMs != null && jSONObjectMs.length() > 0) {
                    try {
                        jSONObjectMs.put("pid", Process.myPid());
                        jSONObjectMs.put("package", this.d.getPackageName());
                        jSONObjectMs.put("is_remote_process", 0);
                        com.bytedance.ms.xr.ah.ms msVar = new com.bytedance.ms.xr.ah.ms(new JSONObject());
                        msVar.ms("data", jSONObjectMs.toString());
                        msVar.ms("is_anr", (Object) 1);
                        msVar.ms("timestamp", Long.valueOf(System.currentTimeMillis()));
                        msVar.ms(a.C0080a.b, "anr");
                        msVar.ms("anr_time", Long.valueOf(System.currentTimeMillis()));
                        msVar.ms("crash_time", Long.valueOf(System.currentTimeMillis()));
                        msVar.ms("anr_info", strMs);
                        com.bytedance.ms.xr.ah.ms msVarMs = com.bytedance.ms.xr.ka.ms.ka.ms().ms(com.bytedance.ms.xr.ah.ANR, msVar);
                        com.bytedance.ms.xr.x.d.ms(this.d, com.bytedance.ms.xr.ah.ANR.ms(), (String) null);
                        com.bytedance.ms.xr.ab.ms.ms().xr(msVarMs.ms());
                        ms(strMs);
                    } catch (Throwable th2) {
                        ch.xr(th2);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void ms(String str) {
        Iterator<Object> it = x.xr().ah().iterator();
        while (it.hasNext()) {
            it.next();
            com.bytedance.ms.xr.ah ahVar = com.bytedance.ms.xr.ah.ANR;
        }
    }

    public JSONObject ms(String str, int i, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i2;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    boolean z = false;
                    Object[] objArrMs = ms(bufferedReader, patternCompile);
                    if (objArrMs == null) {
                        com.bytedance.ms.xr.x.c.ms(bufferedReader);
                        return null;
                    }
                    long j = Long.parseLong(objArrMs[1].toString().split("\\s")[2]);
                    long time = simpleDateFormat.parse(objArrMs[1].toString().split("\\s")[4] + " " + objArrMs[1].toString().split("\\s")[5]).getTime();
                    Object[] objArrMs2 = ms(bufferedReader, patternCompile3);
                    if (objArrMs2 == null) {
                        com.bytedance.ms.xr.x.c.ms(bufferedReader);
                        return null;
                    }
                    String str3 = objArrMs2[1].toString().split("\\s")[2];
                    if (j == i && str3.equalsIgnoreCase(str2)) {
                        if (this.ka != 0 && Math.abs(this.ka - time) < 20000) {
                            com.bytedance.ms.xr.x.c.ms(bufferedReader);
                            return null;
                        }
                        this.ka = time;
                        SharedPreferences sharedPreferences = this.ab;
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong("trace_anr_happen_time", this.ka).apply();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("anrTime", time);
                        while (true) {
                            Object[] objArrMs3 = ms(bufferedReader, patternCompile2, patternCompile4);
                            if (objArrMs3 != null && objArrMs3[0] == patternCompile4) {
                                Matcher matcher = Pattern.compile("\".+\"").matcher(objArrMs3[1].toString());
                                String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                                Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrMs3[1].toString());
                                if (matcher2.find()) {
                                    String strGroup = matcher2.group();
                                    i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                                } else {
                                    i2 = -1;
                                }
                                String strMs = ms(bufferedReader);
                                if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strMs) && strSubstring.equalsIgnoreCase("main")) {
                                    jSONObject.put("mainStackFromTrace", strMs);
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (!z) {
                            com.bytedance.ms.xr.x.c.ms(bufferedReader);
                            return null;
                        }
                        jSONObject.put("thread_number", 1);
                        com.bytedance.ms.xr.x.c.ms(bufferedReader);
                        return jSONObject;
                    }
                    com.bytedance.ms.xr.x.c.ms(bufferedReader);
                    return null;
                } catch (Exception e) {
                    e = e;
                    sl.ms(e);
                    com.bytedance.ms.xr.x.c.ms(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        bufferedReader2 = bufferedReader;
        com.bytedance.ms.xr.x.c.ms(bufferedReader2);
        throw th;
    }

    private Object[] ms(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    for (Pattern pattern : patternArr) {
                        if (pattern.matcher(line).matches()) {
                            return new Object[]{pattern, line};
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    private String ms(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
