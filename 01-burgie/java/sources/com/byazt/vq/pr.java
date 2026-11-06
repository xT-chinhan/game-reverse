package com.byazt.vq;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.hg.j;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.wt.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_FRAME_META_CALLBACK, 37})
public class pr {
    public static final pr pr = new pr();
    public int[] aj;
    public j fw;
    public boolean zo;
    public String hw = "";
    public String hn = "";
    public String x = "";
    public String c = "";
    public JSONArray uc = new JSONArray();

    public static pr pr() {
        return pr;
    }

    private pr() {
    }

    public void pr(Context context) {
        if (!a.hw().ny()) {
            this.zo = false;
            return;
        }
        if (!this.zo) {
            try {
                hw();
                x();
                hn();
                hw(context);
                hn(context);
                this.fw = rc.k();
                this.zo = true;
            } catch (Exception e) {
            }
        }
    }

    public void pr(j jVar) {
        this.fw = jVar;
    }

    public void pr(int[] iArr) {
        this.aj = iArr;
    }

    private String hw() {
        String strHn = com.byazt.wt.a.hn();
        this.hw = strHn;
        return strHn;
    }

    private Long hn() {
        Long lValueOf = -1L;
        if (Build.VERSION.SDK_INT >= 18) {
            lValueOf = Long.valueOf(new StatFs(Environment.getExternalStorageDirectory().getPath()).getTotalBytes());
        }
        this.hn = lValueOf.toString();
        return lValueOf;
    }

    private ActivityManager.MemoryInfo hw(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        this.x = String.valueOf(memoryInfo.totalMem);
        return memoryInfo;
    }

    private Long x() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        this.c = String.valueOf(jCurrentTimeMillis);
        return Long.valueOf(jCurrentTimeMillis);
    }

    private JSONArray hn(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                HashMap map = new HashMap();
                map.put("com.ss.android.ugc.aweme", an.av);
                map.put("com.ss.android.ugc.aweme.lite", "al");
                map.put("com.dragon.read", "r");
                map.put("com.ss.android.article.news", "n");
                map.put("com.ss.android.article.lite", "nl");
                PackageManager packageManager = context.getPackageManager();
                for (Map.Entry entry : map.entrySet()) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                        long j = packageInfo.firstInstallTime;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", entry.getValue());
                        jSONObject.put(an.aC, j);
                        if (TextUtils.equals((CharSequence) entry.getValue(), an.av) || TextUtils.equals((CharSequence) entry.getValue(), "n")) {
                            jSONObject.put(an.aH, packageInfo.lastUpdateTime);
                        }
                        jSONArray.put(jSONObject);
                    } catch (Throwable th) {
                    }
                }
                this.uc = jSONArray;
            }
        } catch (Throwable th2) {
        }
        return jSONArray;
    }

    public void pr(JSONObject jSONObject) {
        if (a.hw().ny()) {
            try {
                j jVar = this.fw;
                if (jVar != null) {
                    JSONObject jSONObjectHn = jVar.hn();
                    jSONObjectHn.put("sl", 0);
                    jSONObject.put("u_t", jSONObjectHn);
                }
                jSONObject.put("boot_time_sec", this.c);
                jSONObject.put("memory", this.x);
                jSONObject.put("disk", this.hn);
                jSONObject.put("client_tun", this.hw);
                jSONObject.put("pkg_info", this.uc);
                int[] iArr = this.aj;
                if (iArr != null) {
                    jSONObject.put("inode", Arrays.toString(iArr));
                }
            } catch (Exception e) {
            }
        }
    }
}
