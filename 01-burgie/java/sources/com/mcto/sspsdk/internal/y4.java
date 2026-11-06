package com.mcto.sspsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ol.TTDownloadField;
import com.mcto.sspsdk.QyCustomMade;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class y4 {
    public static final y4 r = new y4();
    public String d;
    public String e;
    public String f;
    public String g;
    public String o;
    public String p;
    public String q;
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = "2";
    public String n = "-1";

    public static String a() {
        return Build.CPU_ABI;
    }

    public static int d() {
        BatteryManager batteryManager = (BatteryManager) jd.a.getSystemService("batterymanager");
        if (batteryManager != null) {
            return batteryManager.getIntProperty(4);
        }
        return -1;
    }

    public final String b() {
        if (!lj.b(this.h)) {
            return this.h;
        }
        String strA = nh.a(jd.a).a("danid");
        this.h = strA;
        if (!lj.b(strA)) {
            return this.h;
        }
        QyCustomMade qyCustomMade = rd.d;
        if (qyCustomMade == null || qyCustomMade.isCanUsePhoneAndroidId()) {
            String strA2 = w4.a(jd.a);
            this.h = strA2;
            if (!lj.b(strA2)) {
                nh.a(jd.a).a("iad_dev", "danid", this.h);
            }
            return this.h;
        }
        String devAndroidId = rd.d.getDevAndroidId();
        this.h = devAndroidId;
        if (!lj.b(devAndroidId)) {
            nh.a(jd.a).a("iad_dev", "danid", this.h);
        }
        return this.h;
    }

    public final String c() {
        String str;
        if (this.q == null) {
            Context context = jd.a;
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                r9.a("ssp_utils", "get Version error:", e);
                str = "";
            }
            this.q = str;
        }
        return this.q;
    }

    public final String e() {
        String strB;
        if (!lj.b(this.e)) {
            return this.e;
        }
        if (lj.b(g())) {
            strB = !lj.b(b()) ? b() : gj.d(h().replace(":", "").toLowerCase());
        } else {
            strB = g();
        }
        this.e = strB;
        return strB;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        try {
            this.i = System.getProperty("http.agent") + " cupidVersion/2.3.102";
        } catch (Exception e) {
            this.i = "Dalvik/2.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + (Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry().toLowerCase()) + "; " + Build.MODEL.toLowerCase() + ") cupidVersion/2.3.102";
        }
        return this.i;
    }

    public final String g() {
        if (!lj.b(this.d)) {
            return this.d;
        }
        String strA = nh.a(jd.a).a("dim");
        this.d = strA;
        if (!lj.b(strA)) {
            return this.d;
        }
        QyCustomMade qyCustomMade = rd.d;
        if (qyCustomMade == null || qyCustomMade.isCanUsePhoneIMEI()) {
            String strB = w4.b(jd.a);
            this.d = strB;
            if (!lj.b(strB)) {
                nh.a(jd.a).a("iad_dev", "dim", this.d);
            }
            return this.d;
        }
        String devImei = rd.d.getDevImei();
        this.d = devImei;
        if (!lj.b(devImei)) {
            nh.a(jd.a).a("iad_dev", "dim", this.d);
        }
        return this.d;
    }

    public final String h() {
        if (!lj.b(this.g)) {
            return this.g;
        }
        QyCustomMade qyCustomMade = rd.d;
        if (qyCustomMade != null && !qyCustomMade.isCanUsePhoneMacAddress()) {
            String devMac = rd.d.getDevMac();
            this.g = devMac;
            if (devMac == null) {
                this.g = "";
            }
            if (!lj.b(this.g)) {
                nh.a(jd.a).a("iad_dev", "dma", this.g);
            }
            return this.g;
        }
        String strA = nh.a(jd.a).a("dma");
        this.g = strA;
        if (!lj.b(strA)) {
            return this.g;
        }
        String strC = w4.c(jd.a);
        this.g = strC;
        if (!lj.b(strC)) {
            nh.a(jd.a).a("iad_dev", "dma", this.g);
        }
        return this.g;
    }

    public final String i() {
        String strD;
        QyCustomMade qyCustomMade;
        if (!lj.b(this.f)) {
            return this.f;
        }
        if (!rd.a() || (qyCustomMade = rd.d) == null) {
            if (rd.g == null) {
                rd.g = nh.a(jd.a).a("dqyid");
            }
            strD = rd.g;
        } else {
            strD = qyCustomMade.getQyid();
        }
        if (lj.b(strD)) {
            strD = gj.d(b() + "M_ssp_sdk");
        }
        this.f = strD;
        return strD;
    }

    public final boolean j() {
        long j;
        int i = this.b;
        if (i > 0) {
            return i == 1;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) jd.a.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            j = -1;
        } else {
            activityManager.getMemoryInfo(memoryInfo);
            j = memoryInfo.totalMem / 1073741824;
        }
        int i2 = j < 4 ? 1 : 0;
        this.b = i2;
        return i2 == 1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0043  */
    public final void k() {
        boolean zEquals;
        boolean zC;
        boolean z;
        boolean z2;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            zEquals = "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable th) {
            th.toString();
            zEquals = false;
        }
        if (zEquals) {
            z2 = true;
        } else {
            try {
                zC = e1.c("com.huawei.ohos.famanager");
            } catch (Throwable th2) {
                th2.toString();
                zC = false;
            }
            if (zC) {
                z2 = true;
            } else {
                try {
                    Class.forName("ohos.utils.system.SystemCapability");
                    z = true;
                } catch (Throwable th3) {
                    th3.toString();
                    z = false;
                }
                if (z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        if (z2) {
            this.m = GlobalSetting.REWARD_VIDEO_AD;
            try {
                Class<?> cls2 = Class.forName("android.os.SystemProperties");
                this.n = (String) cls2.getMethod("get", String.class).invoke(cls2, "hw_sc.build.platform.version");
            } catch (Throwable th4) {
                th4.toString();
            }
            Context context = jd.a;
            if (context != null) {
                try {
                    this.c = Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", -1);
                } catch (Throwable th5) {
                    th5.toString();
                }
            }
        }
    }

    public final void l() {
        Pair pairC = hk.c(jd.a);
        if (((Integer) pairC.first).intValue() == 0 || ((Integer) pairC.second).intValue() == 0) {
            this.j = "";
            this.a = 8;
            return;
        }
        this.j = pairC.first + "," + pairC.second;
        if (((double) ((Integer) pairC.second).intValue()) / ((double) ((Integer) pairC.first).intValue()) > 1.8d) {
            this.a = 16;
        } else {
            this.a = 8;
        }
    }
}
