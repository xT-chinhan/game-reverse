package com.byazt.ges;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.hd;
import com.byazt.vgx.w;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1374, 26})
public class qg {
    public static volatile String n;
    public static volatile String qg;
    public static String s;

    public static String n() {
        return "open_news";
    }

    public static String qg() {
        return "1371";
    }

    public static String s() {
        return "7.8.1.4";
    }

    public static String q() {
        return tj.w;
    }

    public static String l() {
        return w.tj();
    }

    public static String w() {
        return com.byazt.vyf.s.cy().wm();
    }

    public static String x() {
        return hd.x(rv.getContext());
    }

    public static String fs() {
        return com.byazt.ehw.l.n();
    }

    public static String rv() {
        try {
            if (n != null) {
                return n;
            }
            Context context = rv.getContext();
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null && bundle.keySet() != null) {
                for (String str : bundle.keySet()) {
                    if (str != null && str.toLowerCase().contains("channel")) {
                        Object obj = bundle.get(str);
                        jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                    }
                }
            }
            n = jSONObject.toString();
            return n;
        } catch (Throwable unused) {
        }
    }

    public static String tj() {
        if (qg != null) {
            return qg;
        }
        Context context = rv.getContext();
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            qg = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return qg;
    }

    public static int n(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @HungeonFlag
    public static String cp() {
        try {
            if (!TextUtils.isEmpty(s)) {
                return s;
            }
            String strS = com.byazt.ed.s.n().s("app_sha1", 2592000000L);
            s = strS;
            if (!TextUtils.isEmpty(strS)) {
                return s;
            }
            String strN = com.byazt.tk.qg.n(rv.getContext());
            s = strN;
            if (n(strN)) {
                s = s.toUpperCase(Locale.getDefault());
                com.byazt.ed.s.n().s("app_sha1", s);
                return s;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    private static boolean n(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split(":")) == null || strArrSplit.length < 20) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (!"00".equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
