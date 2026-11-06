package com.byazt.hb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ca.yb;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.wt.ls;
import com.byazt.wt.nt;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1397, 37})
public class pr {
    public static volatile String pr = null;
    public static volatile String hw = null;
    public static String hn = null;

    public static String pr() {
        return "open_news";
    }

    public static String hw() {
        return "1371";
    }

    public static String hn() {
        return "7.7.1.4";
    }

    public static String x() {
        return iu.c;
    }

    public static String c() {
        return ls.vk();
    }

    public static String uc() {
        return zo.nt().fo();
    }

    public static String fw() {
        return yb.fw(a.getContext());
    }

    public static String zo() {
        return nt.pr();
    }

    public static String aj() {
        try {
            if (pr != null) {
                return pr;
            }
            Context context = a.getContext();
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
            pr = jSONObject.toString();
            return pr;
        } catch (Throwable th) {
        }
    }

    public static String vk() {
        if (hw != null) {
            return hw;
        }
        Context context = a.getContext();
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            hw = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception e) {
        }
        return hw;
    }

    public static int pr(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    @HungeonFlag
    public static String w() {
        try {
            if (TextUtils.isEmpty(hn)) {
                String strHn = com.byazt.mp.x.pr().hn("app_sha1", 2592000000L);
                hn = strHn;
                if (!TextUtils.isEmpty(strHn)) {
                    return hn;
                }
                String strPr = com.byazt.ca.hw.pr(a.getContext());
                hn = strPr;
                if (!pr(strPr)) {
                    return "";
                }
                hn = hn.toUpperCase(Locale.getDefault());
                com.byazt.mp.x.pr().hn("app_sha1", hn);
                return hn;
            }
            return hn;
        } catch (Exception e) {
            return "";
        }
    }

    private static boolean pr(String str) {
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
