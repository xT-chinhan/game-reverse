package com.byazt.xf;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.cl.s;
import com.byazt.ehw.w;
import com.byazt.eq.qg;
import com.byazt.nf.rv;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 988, 19})
public class n {
    public static final n n = new n();
    public boolean fs;
    public int[] rv;
    public qg x;
    public String qg = "";
    public String s = "";
    public String q = "";
    public String l = "";
    public JSONArray w = new JSONArray();

    public static n n() {
        return n;
    }

    private n() {
    }

    public void n(Context context) {
        if (!rv.qg().ou()) {
            this.fs = false;
            return;
        }
        if (this.fs) {
            return;
        }
        try {
            qg();
            q();
            s();
            qg(context);
            s(context);
            this.x = s.d();
            this.fs = true;
        } catch (Exception e) {
            com.byazt.eji.s.n().n("zd_init", e);
        }
    }

    public void n(qg qgVar) {
        this.x = qgVar;
    }

    public void n(int[] iArr) {
        this.rv = iArr;
    }

    private String qg() {
        String strS = w.s();
        this.qg = strS;
        return strS;
    }

    private Long s() {
        Long.valueOf(-1L);
        Long lValueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        this.s = lValueOf.toString();
        return lValueOf;
    }

    private ActivityManager.MemoryInfo qg(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        this.q = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    private Long q() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.l = String.valueOf(jCurrentTimeMillis);
        return Long.valueOf(jCurrentTimeMillis);
    }

    private JSONArray s(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap map = new HashMap();
            map.put("com.ss.android.ugc.aweme", "a");
            map.put("com.ss.android.ugc.aweme.lite", "al");
            map.put("com.dragon.read", "r");
            map.put("com.ss.android.article.news", com.byazt.ug.n.n);
            map.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            for (Map.Entry entry : map.entrySet()) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(com.byazt.ug.n.n, entry.getValue());
                    jSONObject.put("i", j);
                    if (TextUtils.equals((CharSequence) entry.getValue(), "a") || TextUtils.equals((CharSequence) entry.getValue(), com.byazt.ug.n.n)) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
            this.w = jSONArray;
        } catch (Throwable th) {
            com.byazt.eji.s.n().n("zd_pd", th);
        }
        return jSONArray;
    }

    public void n(JSONObject jSONObject) {
        if (rv.qg().ou()) {
            try {
                qg qgVar = this.x;
                if (qgVar != null) {
                    JSONObject jSONObjectS = qgVar.s();
                    jSONObjectS.put("sl", 0);
                    jSONObject.put(f.bA, jSONObjectS);
                }
                jSONObject.put("boot_time_sec", this.l);
                jSONObject.put("memory", this.q);
                jSONObject.put("disk", this.s);
                jSONObject.put("client_tun", this.qg);
                jSONObject.put("pkg_info", this.w);
                int[] iArr = this.rv;
                if (iArr != null) {
                    jSONObject.put("inode", Arrays.toString(iArr));
                }
            } catch (Exception e) {
                com.byazt.eji.s.n().n("zd_fa", e);
            }
        }
    }
}
