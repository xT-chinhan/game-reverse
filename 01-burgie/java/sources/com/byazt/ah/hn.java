package com.byazt.ah;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.ewn.AbsServerManager;
import com.byazt.vlj.zo;
import com.byazt.wf.vk;
import com.uc.crashsdk.export.LogType;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1023, 20})
public class hn {
    public static volatile boolean pr = true;
    public volatile long c;
    public final SharedPreferences fw;
    public x hn;
    public pr hw;
    public volatile boolean uc = false;
    public final Context x;

    public hn(Context context) {
        if (context == null || !(context instanceof Application)) {
            throw new IllegalArgumentException("context must not be null or not application");
        }
        this.x = context;
        SharedPreferences sharedPreferencesHw = com.byazt.mg.hw.hw(context, "anr_monitor_table", 0);
        this.fw = sharedPreferencesHw;
        this.c = sharedPreferencesHw.getLong("trace_anr_happen_time", 0L);
    }

    public void pr() {
        if (this.uc) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            pr prVar = new pr(this, "/data/anr/", 8);
            this.hw = prVar;
            prVar.startWatching();
        } else {
            this.hn = new x(this);
        }
        this.uc = true;
    }

    public boolean pr(int i, String str, int i2) {
        JSONObject jSONObjectPr;
        JSONObject jSONObjectPr2;
        try {
            jSONObjectPr = c.pr(pr);
        } catch (Throwable th) {
            jSONObjectPr = null;
        }
        String strPr = c.pr(this.x, i2);
        if (TextUtils.isEmpty(strPr)) {
            return false;
        }
        try {
            com.byazt.vlj.uc ucVarX = zo.hw().x();
            if (ucVarX == null || !ucVarX.pr()) {
                return false;
            }
            if (i == 200 && (jSONObjectPr2 = pr(str, Process.myPid(), this.x.getPackageName())) != null && jSONObjectPr2.length() > 0) {
                jSONObjectPr = jSONObjectPr2;
            }
            if (jSONObjectPr != null && jSONObjectPr.length() > 0) {
                try {
                    jSONObjectPr.put("pid", Process.myPid());
                    jSONObjectPr.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.x.getPackageName());
                    jSONObjectPr.put("is_remote_process", 0);
                    com.byazt.lee.pr prVar = new com.byazt.lee.pr(new JSONObject());
                    prVar.pr("data", jSONObjectPr.toString());
                    prVar.pr("is_anr", (Object) 1);
                    prVar.pr("timestamp", Long.valueOf(System.currentTimeMillis()));
                    prVar.pr("event_type", LogType.ANR_TYPE);
                    prVar.pr("anr_time", Long.valueOf(System.currentTimeMillis()));
                    prVar.pr("crash_time", Long.valueOf(System.currentTimeMillis()));
                    prVar.pr("anr_info", strPr);
                    com.byazt.lee.pr prVarPr = com.byazt.se.c.pr().pr(com.byazt.vlj.hn.ANR, prVar);
                    com.byazt.wf.x.pr(this.x, com.byazt.vlj.hn.ANR.pr(), (String) null);
                    com.byazt.tv.pr.pr().hw(prVarPr.pr());
                    pr(strPr);
                } catch (Throwable th2) {
                    vk.hw(th2);
                }
            }
            return true;
        } catch (Throwable th3) {
            return false;
        }
    }

    private static void pr(String str) {
        Iterator<Object> it = zo.hw().hn().iterator();
        while (it.hasNext()) {
            it.next();
            com.byazt.vlj.hn hnVar = com.byazt.vlj.hn.ANR;
        }
    }

    public JSONObject pr(String str, int i, String str2) throws Throwable {
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
                Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                boolean z = false;
                Object[] objArrPr = pr(bufferedReader, patternCompile);
                if (objArrPr == null) {
                    com.byazt.wf.uc.pr(bufferedReader);
                    return null;
                }
                long j = Long.parseLong(objArrPr[1].toString().split("\\s")[2]);
                long time = simpleDateFormat.parse(objArrPr[1].toString().split("\\s")[4] + " " + objArrPr[1].toString().split("\\s")[5]).getTime();
                Object[] objArrPr2 = pr(bufferedReader, patternCompile3);
                if (objArrPr2 == null) {
                    com.byazt.wf.uc.pr(bufferedReader);
                    return null;
                }
                String str3 = objArrPr2[1].toString().split("\\s")[2];
                if (j == i && str3.equalsIgnoreCase(str2)) {
                    if (this.c != 0 && Math.abs(this.c - time) < 20000) {
                        com.byazt.wf.uc.pr(bufferedReader);
                        return null;
                    }
                    this.c = time;
                    SharedPreferences sharedPreferences = this.fw;
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putLong("trace_anr_happen_time", this.c).apply();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("anrTime", time);
                    while (true) {
                        Object[] objArrPr3 = pr(bufferedReader, patternCompile2, patternCompile4);
                        if (objArrPr3 != null && objArrPr3[0] == patternCompile4) {
                            Matcher matcher = Pattern.compile("\".+\"").matcher(objArrPr3[1].toString());
                            String strSubstring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                            Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(objArrPr3[1].toString());
                            if (matcher2.find()) {
                                String strGroup = matcher2.group();
                                i2 = Integer.parseInt(strGroup.substring(strGroup.indexOf("=") + 1));
                            } else {
                                i2 = -1;
                            }
                            String strPr = pr(bufferedReader);
                            if (i2 != -1 && !TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strPr) && strSubstring.equalsIgnoreCase("main")) {
                                jSONObject.put("mainStackFromTrace", strPr);
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        com.byazt.wf.uc.pr(bufferedReader);
                        return null;
                    }
                    jSONObject.put("thread_number", 1);
                    com.byazt.wf.uc.pr(bufferedReader);
                    return jSONObject;
                }
                com.byazt.wf.uc.pr(bufferedReader);
                return null;
            } catch (Exception e) {
                com.byazt.wf.uc.pr(bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                com.byazt.wf.uc.pr(bufferedReader2);
                throw th;
            }
        } catch (Exception e2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private Object[] pr(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null || patternArr.length <= 0) {
            return null;
        }
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
            } catch (Throwable th) {
            }
        }
        return null;
    }

    private String pr(BufferedReader bufferedReader) throws IOException {
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
