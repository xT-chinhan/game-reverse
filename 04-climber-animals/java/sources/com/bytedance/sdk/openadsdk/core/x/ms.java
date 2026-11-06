package com.bytedance.sdk.openadsdk.core.x;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private static String ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile String f3761ms;
    private static volatile String xr;

    public static String ah() {
        return "6.9.2.3";
    }

    public static String ms() {
        return "open_news";
    }

    public static String xr() {
        return "1371";
    }

    public static String d() {
        return f.sl();
    }

    public static String ka() {
        return ch.ub().nw();
    }

    public static String c() {
        return u.ab(re.getContext());
    }

    public static String ab() {
        return t.ah();
    }

    public static String ms(Context context) {
        try {
            if (f3761ms != null) {
                return f3761ms;
            }
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
            f3761ms = jSONObject.toString();
            return f3761ms;
        } catch (Throwable th) {
            sl.xr("getApplicationName:", th);
        }
    }

    public static String xr(Context context) {
        if (xr != null) {
            return xr;
        }
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            xr = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return xr;
    }

    public static int ah(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            sl.ms(e);
            return 0;
        }
    }

    @HungeonFlag
    public static String x() {
        try {
            if (!TextUtils.isEmpty(ah)) {
                return ah;
            }
            String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("app_sha1", 2592000000L);
            ah = strAh;
            if (!TextUtils.isEmpty(strAh)) {
                return ah;
            }
            String strMs = com.bytedance.sdk.component.utils.ah.ms(re.getContext());
            ah = strMs;
            if (ms(strMs)) {
                ah = ah.toUpperCase(Locale.getDefault());
                com.bytedance.sdk.openadsdk.core.ah.d.ms().d("app_sha1", ah);
                return ah;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    private static boolean ms(String str) {
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
