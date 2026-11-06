package com.mcto.sspsdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.mcto.sspsdk.QyCustomMade;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class kl {
    public static String a;
    public static String b;

    public static String a() {
        if (b == null) {
            String strA = nh.a(jd.a).a("dpu");
            b = strA;
            if (TextUtils.isEmpty(strA)) {
                b = "https://msga.cupid.iqiyi.com/mcp2.gif";
            }
        }
        return rd.b ? b : b.replace("https://", "http://");
    }

    public static HashMap b(Context context, String str) {
        HashMap map = new HashMap();
        if (context != null && !str.isEmpty()) {
            String[] strArrSplit = str.split(",");
            PackageManager packageManager = context.getPackageManager();
            for (String str2 : strArrSplit) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str2, 256);
                    map.put(str2, new xa(str2, packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString(), String.valueOf(packageInfo.firstInstallTime), String.valueOf(packageInfo.lastUpdateTime), String.valueOf(packageInfo.versionName)));
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return map;
    }

    public static xa a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                String strTrim = str.trim();
                PackageInfo packageInfo = packageManager.getPackageInfo(strTrim, 256);
                return new xa(strTrim, packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString(), String.valueOf(packageInfo.firstInstallTime), String.valueOf(packageInfo.lastUpdateTime), String.valueOf(packageInfo.versionName));
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }

    public static HashMap a(Context context, boolean z) {
        HashMap map = new HashMap();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        try {
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                if (z || (resolveInfo.activityInfo.applicationInfo.flags & 1) != 1) {
                    String str = resolveInfo.activityInfo.applicationInfo.packageName;
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 256);
                    map.put(str, new xa(str, packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString(), String.valueOf(packageInfo.firstInstallTime), String.valueOf(packageInfo.lastUpdateTime), String.valueOf(packageInfo.versionName)));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return map;
    }

    public static void a(HashMap map, HashMap map2) {
        if (map != null || map2 != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                StringBuilder sbAppend = sb.append("alist:");
                QyCustomMade qyCustomMade = rd.d;
                Object obj = "1";
                sbAppend.append((qyCustomMade == null || !qyCustomMade.alist()) ? "0" : "1");
                y4 y4Var = y4.r;
                if (GlobalSetting.REWARD_VIDEO_AD.equals(y4Var.m)) {
                    sb.append("otp:").append(GlobalSetting.REWARD_VIDEO_AD).append(";");
                    sb.append("hmv:").append(y4Var.n).append(";");
                    sb.append("hmpm:").append(y4Var.c).append(";");
                }
                JSONObject jSONObjectPut = jSONObject.put("w", y4Var.b()).put("vv", y4Var.c()).put(an.aH, y4Var.i()).put(an.av, y4Var.e()).put("n", y4Var.g()).put("m", y4Var.h());
                AtomicInteger atomicInteger = gj.a;
                JSONObject jSONObjectPut2 = jSONObjectPut.put(an.aB, System.currentTimeMillis()).put("mua", Build.MODEL.toLowerCase()).put("brd", Build.BRAND.toLowerCase()).put("hpkg", jd.a.getPackageName());
                if (!rd.a()) {
                    obj = "2";
                }
                jSONObjectPut2.put("trs", obj).put("vd", Build.MANUFACTURER.toLowerCase()).put("x", sb);
                if (!rd.a()) {
                    jSONObject.put(ACTD.APPID_KEY, rd.f);
                } else {
                    jSONObject.put("y", rd.f);
                }
                JSONArray jSONArray = new JSONArray();
                if (map != null) {
                    for (xa xaVar : map.values()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(an.aI, new JSONArray().put("ins")).put("pn", xaVar.a).put("an", xaVar.b).put("ints", xaVar.c).put("upts", xaVar.d).put("avn", xaVar.f);
                        jSONArray.put(jSONObject2);
                    }
                }
                if (map2 != null) {
                    for (xa xaVar2 : map2.values()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(an.aI, new JSONArray().put("unins")).put("unts", xaVar2.e).put("acc", xaVar2.g).put("pn", xaVar2.a).put("an", xaVar2.b).put("ints", xaVar2.c).put("upts", xaVar2.d).put("avn", xaVar2.f);
                        jSONArray.put(jSONObject3);
                    }
                }
                jSONObject.put("scan", jSONArray);
                String string = jSONObject.toString();
                bg bgVar = new bg();
                String strA = a();
                if (strA != null) {
                    bgVar.b = strA;
                }
                bgVar.c = TapHttp.METHOD_POST;
                bgVar.f = lj.a("%7B" + gj.b(32, string, "e84584df1113ff82bccbdfef9b69c2f3"));
                cg cgVar = new cg(bgVar);
                c7 c7VarA = c7.a();
                c7VarA.getClass();
                zg.a.a(new a7(c7VarA, cgVar));
            } catch (Exception e) {
            }
        }
    }

    public static void a(HashMap map) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (xa xaVar : map.values()) {
                jSONArray.put(new JSONObject().put("pn", xaVar.a).put("an", xaVar.b).put("ints", xaVar.c).put("upts", xaVar.d).put("avn", xaVar.f));
            }
            jSONObject.put("json", jSONArray);
            nh.a(jd.a).a("iad_dev", "dinl", jSONObject.toString());
        } catch (Exception e) {
        }
    }
}
