package com.byazt.nr;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.gc.AbsServerManager;
import com.byazt.qf.fs;
import com.byazt.yw.tj;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, 1357, 8})
public class s {
    public static volatile boolean n = true;
    public volatile long l;
    public final Context q;
    public n qg;
    public q s;
    public volatile boolean w = false;
    public final SharedPreferences x;

    public s(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.q = context;
        SharedPreferences sharedPreferencesQg = com.byazt.qyu.qg.qg(context, "anr_monitor_table", 0);
        this.x = sharedPreferencesQg;
        this.l = sharedPreferencesQg.getLong("trace_anr_happen_time", 0L);
    }

    public void n() {
        if (this.w) {
            return;
        }
        this.s = new q(this);
        this.w = true;
    }

    public boolean n(int i, String str, int i2) {
        JSONObject jSONObjectN;
        JSONObject jSONObjectN2;
        try {
            jSONObjectN = l.n(n);
        } catch (Throwable unused) {
            jSONObjectN = null;
        }
        String strN = l.n(this.q, i2);
        if (TextUtils.isEmpty(strN)) {
            return false;
        }
        try {
            com.byazt.qf.w wVarQ = fs.qg().q();
            if (wVarQ != null && wVarQ.n()) {
                if (i == 200 && (jSONObjectN2 = n(str, Process.myPid(), this.q.getPackageName())) != null && jSONObjectN2.length() > 0) {
                    jSONObjectN = jSONObjectN2;
                }
                if (jSONObjectN != null && jSONObjectN.length() > 0) {
                    try {
                        jSONObjectN.put("pid", Process.myPid());
                        jSONObjectN.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.q.getPackageName());
                        jSONObjectN.put("is_remote_process", 0);
                        com.byazt.ub.n nVar = new com.byazt.ub.n(new JSONObject());
                        nVar.n(f.R, jSONObjectN.toString());
                        nVar.n("is_anr", (Object) 1);
                        nVar.n(TapEventParamConstants.PARAM_SUB_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                        nVar.n("event_type", "anr");
                        nVar.n("anr_time", Long.valueOf(System.currentTimeMillis()));
                        nVar.n("crash_time", Long.valueOf(System.currentTimeMillis()));
                        nVar.n("anr_info", strN);
                        com.byazt.ub.n nVarN = com.byazt.pd.l.n().n(com.byazt.qf.s.ANR, nVar);
                        com.byazt.yw.q.n(this.q, com.byazt.qf.s.ANR.n(), (String) null);
                        com.byazt.xh.n.n().qg(nVarN.n());
                        n(strN);
                    } catch (Throwable th) {
                        tj.qg(th);
                    }
                }
                return true;
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    private static void n(String str) {
        Iterator<Object> it = fs.qg().s().iterator();
        while (it.hasNext()) {
            it.next();
            com.byazt.qf.s sVar = com.byazt.qf.s.ANR;
        }
    }

    public JSONObject n(String str, int i, String str2) throws Throwable {
        BufferedReader bufferedReader;
        int i2;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    boolean z = false;
                    Object[] objArrN = n(bufferedReader, patternCompile);
                    if (objArrN == null) {
                        com.byazt.yw.w.n(bufferedReader);
                        return null;
                    }
                    long j = Long.parseLong(objArrN[1].toString().split("\\s")[2]);
                    long time = simpleDateFormat.parse(objArrN[1].toString().split("\\s")[4] + " " + objArrN[1].toString().split("\\s")[5]).getTime();
                    Object[] objArrN2 = n(bufferedReader, patternCompile3);
                    if (objArrN2 == null) {
                        com.byazt.yw.w.n(bufferedReader);
                        return null;
                    }
                    String str3 = objArrN2[1].toString().split("\\s")[2];
                    if (j == i && str3.equalsIgnoreCase(str2)) {
                        if (this.l != 0 && Math.abs(this.l - time) < 20000) {
                            com.byazt.yw.w.n(bufferedReader);
                            return null;
                        }
                        this.l = time;
                        SharedPreferences sharedPreferences = this.x;
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putLong("trace_anr_happen_time", this.l).apply();
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("anrTime", time);
                        while (true) {
                            Object[] objArrN3 = n(bufferedReader, patternCompile2, patternCompile4);
                            if (objArrN3 != null && objArrN3[0] == patternCompile4) {
                                Matcher matcher = Pattern.compile("\".+\"").matcher(objArrN3[1].toString());
                                String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                                Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrN3[1].toString());
                                if (matcher2.find()) {
                                    String strGroup = matcher2.group();
                                    i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                                } else {
                                    i2 = -1;
                                }
                                String strN = n(bufferedReader);
                                if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strN) && strSubstring.equalsIgnoreCase("main")) {
                                    jSONObject.put("mainStackFromTrace", strN);
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (!z) {
                            com.byazt.yw.w.n(bufferedReader);
                            return null;
                        }
                        jSONObject.put("thread_number", 1);
                        com.byazt.yw.w.n(bufferedReader);
                        return jSONObject;
                    }
                    com.byazt.yw.w.n(bufferedReader);
                    return null;
                } catch (Exception unused) {
                    com.byazt.yw.w.n(bufferedReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    com.byazt.yw.w.n(bufferedReader2);
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private Object[] n(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
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

    private String n(BufferedReader bufferedReader) throws IOException {
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
