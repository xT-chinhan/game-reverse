package com.bytedance.sdk.openadsdk.core.jw;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.rt;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.bv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static volatile long ab = 0;
    public static volatile int ah = 0;
    private static volatile String ao = null;
    public static volatile long c = 0;
    public static String ch = null;
    public static volatile String d = null;
    private static long hi = -1;
    public static volatile long ka = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile int f2700ms = 0;
    public static String ny = null;
    private static volatile boolean sl = false;
    private static volatile String u = null;
    private static volatile String ub = null;
    public static volatile int x = -1;
    public static volatile int xr = 0;
    private static volatile String zb = "";

    public static int ka(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    public static String ms(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static String xr(int i) {
        switch (i) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return "draw_ad";
        }
    }

    public static boolean ms(Context context, String str) {
        Intent intentXr;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!xr(context)) {
                    Intent intentXr2 = xr(context, str);
                    if (intentXr2 == null) {
                        return false;
                    }
                    intentXr2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(intentXr2);
                    return true;
                }
                if (!ah(context, str) || (intentXr = xr(context, str)) == null) {
                    return false;
                }
                intentXr.putExtra("START_ONLY_FOR_ANDROID", true);
                com.bytedance.sdk.component.utils.xr.ms(context, intentXr, null);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static JSONObject ms(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static Intent xr(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
        return launchIntentForPackage;
    }

    public static boolean ah(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (xr(context)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.re.xr().fl()) {
            return ms(str);
        }
        return false;
    }

    public static boolean ms(String str) {
        boolean zExists = ms("data", str).exists();
        return !zExists ? ms("media", str).exists() : zExists;
    }

    private static File ms(String str, String str2) {
        String str3 = System.getenv("EXTERNAL_STORAGE");
        if (str3 == null) {
            str3 = "/sdcard";
        }
        return new File(str3, "Android/" + str + "/" + str2);
    }

    public static boolean ms(Context context, Intent intent, boolean z) {
        if (intent == null || context == null || !xr(context)) {
            return false;
        }
        return xr(context, intent, z);
    }

    public static boolean ms(Context context, Intent intent) {
        if (intent == null || context == null || !xr(context)) {
            return false;
        }
        return xr(context, intent, false);
    }

    public static boolean xr(Context context, Intent intent, boolean z) {
        Boolean boolMs;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String strMs = yu.ms(data);
        if (z && (boolMs = yu.ms(strMs, 86400000L)) != null) {
            return boolMs.booleanValue();
        }
        boolean zXr = xr(context, intent);
        yu.ms(strMs, Boolean.valueOf(zXr));
        return zXr;
    }

    public static List<String> ms() {
        ArrayList arrayList = new ArrayList();
        if (com.bytedance.sdk.openadsdk.core.re.xr().vf() && com.bytedance.sdk.openadsdk.core.ch.ub().ao().xr()) {
            for (ResolveInfo resolveInfo : com.bytedance.sdk.openadsdk.core.re.getContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN"), 131072)) {
                if (resolveInfo.activityInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean xr() {
        try {
            PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.re.getContext().getPackageManager().getPackageInfo(com.bytedance.sdk.openadsdk.core.re.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean xr(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
        } catch (Throwable unused) {
        }
    }

    public static void ah() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.pc();
                }
            });
        } else {
            pc();
        }
    }

    public static int ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        int iU = com.bytedance.sdk.openadsdk.core.re.xr().u();
        int iIntValue = 0;
        if (iU != -1) {
            return (iU == 0 || iU != 1) ? 0 : 1;
        }
        try {
            rt rtVarPl = lmVar.pl();
            com.bytedance.sdk.openadsdk.core.nw.lm.ms msVarSi = lmVar.si();
            if (rtVarPl != null) {
                String strC = rtVarPl.c();
                if (!TextUtils.isEmpty(strC)) {
                    iIntValue = Integer.valueOf(strC).intValue();
                }
            } else if (msVarSi != null) {
                String strSl = msVarSi.sl();
                if (!TextUtils.isEmpty(strSl)) {
                    iIntValue = Integer.valueOf(strSl).intValue();
                }
            }
            return iIntValue;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("tl", e.getMessage());
            return iIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pc() {
        List<String> listWp;
        com.bytedance.sdk.openadsdk.core.g.ch chVarXr = com.bytedance.sdk.openadsdk.core.re.xr();
        if (com.bytedance.sdk.openadsdk.core.ch.ub().qf()) {
            com.bytedance.sdk.openadsdk.core.ch.ub().x(false);
            return;
        }
        if (chVarXr.n() || (listWp = chVarXr.wp()) == null) {
            return;
        }
        int iEc = chVarXr.ec();
        for (int i = 0; i < iEc && i < listWp.size(); i++) {
            Uri uri = Uri.parse(listWp.get(i));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            ms(com.bytedance.sdk.openadsdk.core.re.getContext(), intent, true);
        }
    }

    public static boolean d() {
        return (com.bytedance.sdk.openadsdk.core.ch.ub() == null || com.bytedance.sdk.openadsdk.core.ch.ub().ms()) ? false : true;
    }

    public static int xr(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 5;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "interaction":
                return 3;
            case "draw_ad":
                return 6;
            default:
                return 1;
        }
    }

    public static String xr(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        try {
            return xr(x(lmVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject ah(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return null;
        }
    }

    public static boolean ah(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        return lmVar != null && x(lmVar) == 9;
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar != null) {
            boolean z = x(lmVar) == 5;
            if (lmVar.du() == 7 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean ka(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        int iX = x(lmVar);
        return iX == 5 || iX == 1 || iX == 2;
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return false;
        }
        int iX = x(lmVar);
        return iX == 3 || iX == 4;
    }

    public static boolean ab(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt;
        if (lmVar == null || (jSONObjectIt = lmVar.it()) == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(jSONObjectIt.optString("compliance_data")).optJSONObject(bv.aw).optInt("pricing_type");
            return iOptInt == 3 || iOptInt == 6;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("ToolUtils", "error:" + e.getMessage());
            return false;
        }
    }

    public static int x(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        if (jSONObjectIt != null) {
            return jSONObjectIt.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int ny(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        if (jSONObjectIt != null) {
            return jSONObjectIt.optInt("rit", 0);
        }
        return 0;
    }

    public static String ch(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        return jSONObjectIt != null ? jSONObjectIt.optString("origin_req_id", "") : "";
    }

    public static String hi(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        return jSONObjectIt != null ? jSONObjectIt.optString("customer_id", "") : "";
    }

    public static long d(String str) {
        return ms(ah(str));
    }

    private static long ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0L);
        }
        return 0L;
    }

    public static int ka(String str) {
        return xr(ah(str));
    }

    private static int xr(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static double c(String str) {
        return ah(ah(str));
    }

    public static double sl(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        return ah(lmVar.it());
    }

    private static double ah(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static long ka() {
        return hi;
    }

    public static String zb(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        return jSONObjectIt != null ? jSONObjectIt.optString("req_id", "") : "";
    }

    public static String ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, String str) {
        JSONObject jSONObjectIt = lmVar.it();
        return jSONObjectIt != null ? jSONObjectIt.optString("rit", str) : str;
    }

    public static int u(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        if (jSONObjectIt != null) {
            return jSONObjectIt.optInt("pricing", 0);
        }
        return 0;
    }

    public static int ub(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        JSONObject jSONObjectIt = lmVar.it();
        if (jSONObjectIt != null) {
            return jSONObjectIt.optInt("price", 0);
        }
        return 0;
    }

    public static String ao(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = lmVar.zh();
        String strXr = kaVarZh != null ? kaVarZh.xr() : null;
        return TextUtils.isEmpty(strXr) ? lmVar.ao() : strXr;
    }

    public static String h(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar.zh() != null && !TextUtils.isEmpty(lmVar.zh().ah())) {
            return lmVar.zh().ah();
        }
        if (TextUtils.isEmpty(lmVar.nq())) {
            return !TextUtils.isEmpty(lmVar.eh()) ? lmVar.eh() : "";
        }
        return lmVar.nq();
    }

    public static String qv(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (TextUtils.isEmpty(lmVar.eh())) {
            return !TextUtils.isEmpty(lmVar.fs()) ? lmVar.fs() : "";
        }
        return lmVar.eh();
    }

    public static String c() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(";");
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            strConcat = strConcat.substring(0, i).concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + ";").concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String ab() {
        if (!TextUtils.isEmpty(zb)) {
            return zb;
        }
        return com.bytedance.sdk.openadsdk.ms.ah.ah.ms(zb);
    }

    public static String x() {
        String string;
        long j;
        try {
            String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("sdk_local_web_ua", "");
            if (TextUtils.isEmpty(strAh)) {
                string = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strAh);
                string = jSONObject.getString(com.anythink.core.common.e.f.a.d);
                j = jSONObject.getLong("time");
                zb = string;
            }
            if (TextUtils.isEmpty(string)) {
                jw();
            } else if (System.currentTimeMillis() - j > 259200000) {
                com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("tt-webua") { // from class: com.bytedance.sdk.openadsdk.core.jw.f.2
                    @Override // java.lang.Runnable
                    public void run() {
                        f.jw();
                    }
                });
            }
        } catch (Throwable unused) {
        }
        return zb;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.jw.f$3, reason: invalid class name */
    static class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = f.zb = f.ab(new SSWebView(com.bytedance.sdk.openadsdk.core.re.getContext()).getUserAgentString());
                com.bytedance.sdk.openadsdk.core.ah.d.ms().d("sdk_local_web_ua", f.zb);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jw() {
        try {
            zb = ab(WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.re.getContext()));
            com.bytedance.sdk.openadsdk.core.ah.d.ms().d("sdk_local_web_ua", zb);
        } catch (Throwable unused) {
        }
    }

    public static String ab(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String ny() {
        return UUID.randomUUID().toString();
    }

    public static String ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        String strMs;
        try {
            JSONObject jSONObject = new JSONObject(xrVar.nw());
            int iOptInt = jSONObject.optInt("cypher");
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                strMs = com.bytedance.sdk.component.utils.ms.ah(strOptString);
            } else if (iOptInt == 4) {
                strMs = com.bytedance.sdk.component.panglearmor.ny.ms().ms(strOptString);
                if (strMs == null) {
                    strMs = "";
                }
            } else {
                strMs = null;
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strMs).optJSONArray("creatives");
            StringBuilder sb = new StringBuilder();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString2 = ((JSONObject) jSONArrayOptJSONArray.get(i)).optString("material_key");
                    if (i != 0) {
                        sb.append("," + strOptString2);
                    } else {
                        sb.append(strOptString2);
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @HungeonFlag
    public static String ch() {
        if (!TextUtils.isEmpty(ao)) {
            return ao;
        }
        if (com.bytedance.sdk.openadsdk.core.re.getContext() != null) {
            try {
                ao = com.bytedance.sdk.openadsdk.core.re.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ah("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return ao;
    }

    public static String hi() {
        if (TextUtils.isEmpty(u) && com.bytedance.sdk.openadsdk.core.re.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.re.getContext().getPackageManager().getPackageInfo(ch(), 0);
                u = String.valueOf(packageInfo.versionCode);
                ub = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ah("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return u;
    }

    public static String sl() {
        if (TextUtils.isEmpty(ub) && com.bytedance.sdk.openadsdk.core.re.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.re.getContext().getPackageManager().getPackageInfo(ch(), 0);
                u = String.valueOf(packageInfo.versionCode);
                ub = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ah("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return ub;
    }

    public static String zb() {
        if (!TextUtils.isEmpty(d) && !d.equals("0")) {
            return d;
        }
        String strAh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ah("total_memory", "0");
        d = strAh;
        return strAh;
    }

    public static String d(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.sl.ms(th);
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static int u() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.jw.f$4, reason: invalid class name */
    static class AnonymousClass4 implements FilenameFilter {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Pattern f2701ms = Pattern.compile("^cpu[0-9]+$");

        AnonymousClass4() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f2701ms.matcher(str).matches();
        }
    }

    public static int ub() {
        if (f2700ms > 0) {
            return f2700ms;
        }
        int iXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("cpu_cnt", 0);
        f2700ms = iXr;
        return iXr;
    }

    public static int ao() {
        if (xr > 0) {
            return xr;
        }
        int iXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("cpu_max_freq", 0);
        xr = iXr;
        return iXr;
    }

    public static int h() {
        if (ah > 0) {
            return ah;
        }
        int iXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("cpu_min_freq", 0);
        ah = iXr;
        return iXr;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0059 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:20:0x0054, B:22:0x0059), top: B:34:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0066 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #2 {Exception -> 0x0069, blocks: (B:26:0x0061, B:28:0x0066), top: B:38:0x0061 }] */
    public static int ah(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        int i2 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int i3 = Integer.parseInt(bufferedReader3.readLine());
                        if (i3 > i2) {
                            i2 = i3;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.sl.d("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            bufferedReader2 = bufferedReader;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused3) {
                                    throw th3;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th4;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th5) {
                bufferedReader = bufferedReader2;
                th = th5;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005c A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:22:0x0057, B:24:0x005c), top: B:36:0x0057 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0069 A[Catch: Exception -> 0x006c, TRY_LEAVE, TryCatch #3 {Exception -> 0x006c, blocks: (B:28:0x0064, B:30:0x0069), top: B:42:0x0064 }] */
    public static int d(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        int i2 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq");
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int i3 = Integer.parseInt(bufferedReader3.readLine());
                        if (i3 < i2 || i2 == 0) {
                            i2 = i3;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.sl.d("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            bufferedReader2 = bufferedReader;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    if (fileReader != null) {
                                        fileReader.close();
                                    }
                                } catch (Exception unused3) {
                                    throw th3;
                                }
                            } else if (fileReader != null) {
                                fileReader.close();
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th4;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th5) {
                bufferedReader = bufferedReader2;
                th = th5;
            }
        }
    }

    public static long qv() {
        if (ka > 0) {
            return ka;
        }
        long jXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("internal_storage", 0L);
        ka = jXr;
        return jXr;
    }

    public static long y() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long t() {
        if (c > 0) {
            return c;
        }
        long jXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("free_storage", 0L);
        c = jXr;
        return jXr;
    }

    public static long nw() {
        if (ab > 0) {
            return ab;
        }
        long jXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("sdcard_storage", 0L);
        ab = jXr;
        return jXr;
    }

    public static long b() {
        try {
            if (!f()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), null).getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean f() {
        try {
            return "mounted".equals(com.bytedance.sdk.openadsdk.op.ah.ms());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int re() {
        if (x >= 0) {
            return x;
        }
        int iXr = com.bytedance.sdk.openadsdk.core.ah.d.ms().xr("is_root", -1);
        x = iXr;
        return iXr;
    }

    public static boolean i() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Map<String, Object> ms(long j, com.bytedance.sdk.openadsdk.core.nw.lm lmVar, com.bykv.vk.openvk.component.video.api.ms msVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (lmVar != null) {
            if (!TextUtils.isEmpty(lmVar.df())) {
                map.put("creative_id", lmVar.df());
            }
            com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = qr.u(lmVar);
            if (ahVarU != null) {
                map.put("video_resolution", ahVarU.ny());
                map.put("video_size", Long.valueOf(ahVarU.ka()));
            }
        }
        ms(map, msVar);
        return map;
    }

    public static Map<String, Object> ms(boolean z, com.bytedance.sdk.openadsdk.core.nw.lm lmVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", lmVar.df());
        map.put(com.baidu.mobads.sdk.internal.d.b, Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = qr.u(lmVar);
        if (ahVarU != null) {
            map.put("video_size", Long.valueOf(ahVarU.ka()));
            map.put("video_resolution", ahVarU.ny());
            map.put("video_preload_size", Long.valueOf(ahVarU.ao()));
        }
        if (!z) {
            map.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> xr(boolean z, com.bytedance.sdk.openadsdk.core.nw.lm lmVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", lmVar.df());
        map.put(com.baidu.mobads.sdk.internal.d.b, Long.valueOf(j));
        if (!z) {
            map.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> ms(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, long j, com.bykv.vk.openvk.component.video.api.ms msVar) {
        HashMap map = new HashMap();
        map.put("creative_id", lmVar.df());
        map.put("buffers_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = qr.u(lmVar);
        if (ahVarU != null) {
            map.put("video_size", Long.valueOf(ahVarU.ka()));
            map.put("video_resolution", ahVarU.ny());
        }
        ms(map, msVar);
        return map;
    }

    private static void ms(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.ms msVar) {
        if (map.containsKey("video_resolution") || msVar == null) {
            return;
        }
        try {
            map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(msVar.hi()), Integer.valueOf(msVar.sl())));
        } catch (Throwable unused) {
        }
    }

    public static JSONObject y(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.it();
    }

    public static boolean x(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String ms(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("ToolUtils", e.toString());
            return "";
        }
    }

    public static boolean t(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null || com.bytedance.sdk.openadsdk.core.nw.t.d(lmVar)) {
            return false;
        }
        int iQv = lmVar.qv();
        return iQv == 5 || iQv == 4;
    }

    public static boolean ms(boolean z, com.bytedance.sdk.openadsdk.core.nw.lm lmVar, String str) {
        if (z || lmVar == null) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.core.nw.h hVarTc = lmVar.tc();
            if (!(lmVar.sh() || (hVarTc != null && hVarTc.ah() == 2 && !hVarTc.ms() && com.bytedance.sdk.openadsdk.core.xr.ms().xr("dpl_reject_by_dialog", false)))) {
                return false;
            }
            String strIr = lmVar.ir();
            if (TextUtils.isEmpty(strIr) && hVarTc != null && hVarTc.ka() == 1 && !TextUtils.isEmpty(hVarTc.d())) {
                strIr = hVarTc.d();
            }
            if (!TextUtils.isEmpty(strIr)) {
                com.bytedance.sdk.openadsdk.core.ul.ms(strIr, lmVar, str);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean nw(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return true;
        }
        int iAb = com.bytedance.sdk.openadsdk.core.re.xr().ab(ny(lmVar));
        if (iAb == 1) {
            return com.bytedance.sdk.component.utils.u.d(com.bytedance.sdk.openadsdk.core.re.getContext());
        }
        if (iAb == 2) {
            return com.bytedance.sdk.component.utils.u.ka(com.bytedance.sdk.openadsdk.core.re.getContext()) || com.bytedance.sdk.component.utils.u.d(com.bytedance.sdk.openadsdk.core.re.getContext()) || com.bytedance.sdk.component.utils.u.c(com.bytedance.sdk.openadsdk.core.re.getContext());
        }
        if (iAb != 3) {
            return iAb != 5 || com.bytedance.sdk.component.utils.u.d(com.bytedance.sdk.openadsdk.core.re.getContext()) || com.bytedance.sdk.component.utils.u.c(com.bytedance.sdk.openadsdk.core.re.getContext());
        }
        return false;
    }

    private static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            ny = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            ny = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        ny = null;
        return str;
    }

    private static String qv(String str) {
        if (TextUtils.isEmpty(str)) {
            ch = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            ch = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        ch = null;
        return str;
    }

    public static String ny(String str) {
        return ms(str, false, 0);
    }

    public static String ch(String str) {
        return ms(str, false, 1);
    }

    public static String ms(String str, boolean z) {
        return ms(str, z, 0);
    }

    private static String ms(String str, boolean z, int i) {
        String strCh = i == 0 ? com.bytedance.sdk.openadsdk.core.re.xr().ch() : h(com.bytedance.sdk.openadsdk.core.re.xr().ao());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.bytedance.sdk.openadsdk.tools.xr.ms() && com.bytedance.sdk.openadsdk.core.ch.ub().vm() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strCh = com.bytedance.sdk.openadsdk.core.ch.ub().zf();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.bytedance.sdk.openadsdk.core.ch.ub().sk() != null && ch().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strCh = com.bytedance.sdk.openadsdk.core.ch.ub().zf();
        } else {
            str2 = str;
        }
        String strMs = String.format("https://%s%s", strCh, str2);
        if (jw.ms()) {
            if (!z) {
                strMs = jw.xr(strMs);
            }
            String strMs2 = jw.ms("testIp.txt");
            if (strMs2 != null) {
                strMs = jw.ms(strMs, strMs2);
            }
        }
        return z ? y(strMs) : strMs;
    }

    private static String y(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", hi()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String w() {
        return jw.xr(Uri.parse(String.format("https://%s", qv(com.bytedance.sdk.openadsdk.core.re.xr().t()))).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static String yu() {
        return jw.xr(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static String hi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static boolean ms(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && ms(j) == ms(j2);
    }

    public static long ms(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        return lmVar != null && TextUtils.equals(lmVar.cz(), lmVar.df()) && lmVar.jr() == 3 && !TextUtils.isEmpty(re(lmVar));
    }

    public static String re(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return "";
        }
        String strYw = lmVar.yw();
        return (!TextUtils.isEmpty(strYw) || lmVar.ph() == null) ? strYw : lmVar.ph().zb();
    }

    public static boolean xr(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.re.getContext();
        }
        if (context == null) {
            com.bytedance.sdk.component.utils.sl.xr("params context is null");
            return false;
        }
        boolean z = context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0;
        com.bytedance.sdk.component.utils.sl.ms("ToolUtils", "can query all package = " + (!z));
        return !z;
    }

    public static String xr(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (xrVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(xrVar.d());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String op() {
        return ch() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static long ah(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            try {
                com.bytedance.sdk.component.utils.sl.ms("ToolUtils", "targetSdkVersion = ", Integer.valueOf(i));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i = -1;
        }
        return i;
    }

    public static long d(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().minSdkVersion;
            try {
                com.bytedance.sdk.component.utils.sl.ms("ToolUtils", "minSdkVersion = ", Integer.valueOf(i));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i = -1;
        }
        return i;
    }

    public static String sl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageManager packageManager = com.bytedance.sdk.openadsdk.core.re.getContext().getPackageManager();
            return packageManager.getLaunchIntentForPackage(str).resolveActivity(packageManager).getClassName();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Bundle ms(int i, Bundle bundle) {
        int i2 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i3 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_CODE, i3);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_MSG, string2);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, string);
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, i2);
        bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_PROPOSE, f);
        bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_IS_SERVER_VERIFY, z2);
        if (i == 0) {
            bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD, z);
        }
        return bundle2;
    }

    public static String ms(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (i < iArr.length - 1) {
                sb.append(iArr[i] + ",");
            } else {
                sb.append(iArr[i]);
            }
        }
        return sb.toString();
    }

    public static int[] zb(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static void ms(Intent intent, com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.re.xr().bn()) {
            intent.putExtra("multi_process_materialmeta", lmVar.rm().toString());
            return;
        }
        String str = lmVar.hashCode() + lmVar.eu();
        intent.putExtra("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.h.ms(com.bytedance.sdk.openadsdk.core.re.getContext())) {
            com.bytedance.sdk.openadsdk.core.i.ms(str, lmVar, com.bytedance.sdk.openadsdk.core.nw.lm.class);
        } else {
            g.ms("sp_meta").ms(str, com.bytedance.sdk.component.utils.ms.xr(lmVar.rm().toString()));
        }
    }

    public static int ms(Class cls) {
        if (TTWebPageActivity.class.equals(cls)) {
            return 0;
        }
        if (TTNativePageActivity.class.equals(cls)) {
            return 2;
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            return 3;
        }
        return TTVideoScrollWebPageActivity.class.equals(cls) ? 4 : 0;
    }

    public static Class c(int i) {
        if (i == 2) {
            return TTNativePageActivity.class;
        }
        if (i == 3) {
            return TTVideoWebPageActivity.class;
        }
        if (i == 4) {
            return TTVideoScrollWebPageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    public static void ms(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        if (lmVar == null || map == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.re.xr().bn()) {
            map.put("multi_process_materialmeta", lmVar.rm().toString());
            return;
        }
        String str = lmVar.hashCode() + lmVar.eu();
        map.put("multi_process_materialmeta_key", str);
        if (com.bytedance.sdk.component.utils.h.ms(com.bytedance.sdk.openadsdk.core.re.getContext())) {
            com.bytedance.sdk.openadsdk.core.i.ms(str, lmVar, com.bytedance.sdk.openadsdk.core.nw.lm.class);
        } else {
            g.ms("sp_meta").ms(str, com.bytedance.sdk.component.utils.ms.xr(lmVar.rm().toString()));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.nw.lm ms(Intent intent) {
        com.bytedance.sdk.openadsdk.core.nw.lm lmVarMs;
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra) && (lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(stringExtra))) != null) {
                return lmVarMs;
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ah("ToolUtils", "getMaterialMeta from intent failed", e);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        com.bytedance.sdk.openadsdk.core.nw.lm lmVar = (com.bytedance.sdk.openadsdk.core.nw.lm) com.bytedance.sdk.openadsdk.core.i.xr(stringExtra2, com.bytedance.sdk.openadsdk.core.nw.lm.class);
        if (lmVar != null) {
            return lmVar;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = g.ms("sp_meta");
        String strAh = com.bytedance.sdk.component.utils.ms.ah(xrVarMs.xr(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(strAh)) {
                com.bytedance.sdk.component.utils.sl.d("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.ms.ms(new JSONObject(strAh));
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
            com.bytedance.sdk.component.utils.sl.ah("ToolUtils", "getMaterialMeta from keva failed", e2);
            return null;
        } finally {
            xrVarMs.ms(stringExtra2);
        }
    }

    public static void le() {
        if (sl) {
            return;
        }
        sl = true;
        com.bytedance.sdk.component.hi.ab.ms msVarMs = com.bytedance.sdk.component.hi.ab.ms.ms();
        msVarMs.ms("open_sass_live", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.hi());
        msVarMs.ms("open_miniapp", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.sl());
        msVarMs.ms("open_landing_page", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ch());
        if (com.bytedance.sdk.openadsdk.core.hi.ka.ms()) {
            msVarMs.ms("download", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ab());
        } else {
            msVarMs.ms("download", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.zb());
        }
        msVarMs.ms("open_scheme", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.u());
        msVarMs.ms("open_policy", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ub());
        msVarMs.ms("end_card", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ny());
        msVarMs.ms("common_popup", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ms());
        msVarMs.ms("desc_popup", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.xr());
        msVarMs.ms("permission_popup", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ah());
        msVarMs.ms("privacy_popup", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.d());
        msVarMs.ms("registration_pop", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ka());
        msVarMs.ms("dislike_popup", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.c());
        msVarMs.ms("download_popup", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.x());
        msVarMs.ms("reward_again", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.y());
        msVarMs.ms("reward_continue", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.y());
        msVarMs.ms("close_reward", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.qv());
        msVarMs.ms("report_event", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.ao());
        msVarMs.ms("report_stats", new com.bytedance.sdk.openadsdk.core.ny.ms.xr.h());
    }

    public static String xr(com.bytedance.sdk.openadsdk.core.nw.lm lmVar, String str) {
        ce ceVarJs;
        if (lmVar == null || (ceVarJs = lmVar.js()) == null || ceVarJs.xr() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.bytedance.sdk.openadsdk.core.xr.ms.xr.x.ah().ms()) {
            return sb.append(2).toString();
        }
        sb.append(ceVarJs.c());
        return sb.toString();
    }

    public static boolean ms(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (!(str.startsWith("https:") || str.startsWith("http:"))) {
            return true;
        }
        if (com.bytedance.sdk.openadsdk.core.nw.p.f3077ms.isEmpty()) {
            cv();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.nw.p.f3077ms;
        if (set.isEmpty()) {
            return true;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void cv() {
        String strWg = com.bytedance.sdk.openadsdk.core.re.xr().wg();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(strWg);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!TextUtils.isEmpty(strGroup)) {
                    com.bytedance.sdk.openadsdk.core.nw.p.f3077ms.add(strGroup);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strWg) || !com.bytedance.sdk.openadsdk.core.nw.p.f3077ms.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nw.p.f3077ms.add("empty");
    }

    public static void xr(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        } else if (com.bytedance.sdk.openadsdk.core.re.xr().y(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
    }

    public static String ka(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean u(String str) {
        long jUb = ub(str);
        return jUb != 0 && System.currentTimeMillis() - (jUb * 1000) > 0;
    }

    public static long ub(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("/([^/]+)/video/tos/cn").matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                return 0L;
            }
            try {
                long j = Long.parseLong(strGroup, 16);
                return str.contains("v3-be-pack") ? j + 10800 : j;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static String i(com.bytedance.sdk.openadsdk.core.nw.lm lmVar) {
        com.bytedance.sdk.openadsdk.core.nw.c cVarPh;
        if (lmVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = lmVar.zh();
        String strD = kaVarZh != null ? kaVarZh.d() : null;
        if (TextUtils.isEmpty(strD) && (cVarPh = lmVar.ph()) != null) {
            strD = cVarPh.zb();
        }
        return TextUtils.isEmpty(strD) ? lmVar.yw() : strD;
    }
}
