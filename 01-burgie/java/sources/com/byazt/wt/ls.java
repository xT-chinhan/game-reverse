package com.byazt.wt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.cr;
import com.byazt.hg.ie;
import com.byazt.hg.iy;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.u;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.constants.Constants;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 1121})
public class ls {
    public static volatile long c;
    public static volatile long fw;
    public static volatile int hn;
    public static String ho;
    public static volatile int hw;
    public static volatile int pr;
    public static volatile long uc;
    public static volatile String x;
    public static long w = -1;
    public static volatile int zo = -1;
    public static volatile boolean k = false;
    public static volatile int m = 0;
    public static final AtomicBoolean g = new AtomicBoolean(false);
    public static volatile String nt = null;
    public static volatile String yb = null;
    public static volatile String lb = null;
    public static String aj = null;
    public static String vk = null;

    public static boolean pr(Context context, String str) {
        Intent intentHw;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!b()) {
                Intent intentHw2 = hw(context, str);
                if (intentHw2 == null) {
                    return false;
                }
                intentHw2.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(intentHw2);
                return true;
            }
            if (!hw(str) || (intentHw = hw(context, str)) == null) {
                return false;
            }
            intentHw.putExtra("START_ONLY_FOR_ANDROID", true);
            com.byazt.ca.pr.pr(context, intentHw, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String pr(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return "";
        }
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme.toLowerCase(Locale.US);
    }

    public static Intent hw(Context context, String str) {
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

    public static boolean hw(String str) {
        Context context = com.byazt.sd.a.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (b()) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        if (!com.byazt.sd.a.hw().tm()) {
            return false;
        }
        return hn(str);
    }

    public static boolean hn(String str) {
        String[] strArr = {"data", "media", "obb"};
        for (int i = 0; i < 3; i++) {
            if (pr(strArr[i], str).exists()) {
                return true;
            }
        }
        return false;
    }

    private static File pr(String str, String str2) {
        if (ho == null) {
            String str3 = System.getenv("EXTERNAL_STORAGE");
            ho = str3;
            if (str3 == null) {
                ho = "/sdcard";
            }
        }
        return new File(ho, "Android/" + str + "/" + str2);
    }

    public static boolean pr(Intent intent, boolean z) {
        if (intent == null || !b()) {
            return false;
        }
        return hw(intent, z);
    }

    public static boolean pr(Intent intent) {
        if (intent == null || !b()) {
            return false;
        }
        return hw(intent, false);
    }

    public static boolean hw(Intent intent, boolean z) {
        Boolean boolPr;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String strPr = b.pr(data);
        if (z && (boolPr = b.pr(strPr, 86400000L)) != null) {
            return boolPr.booleanValue();
        }
        boolean zX = x(intent);
        b.pr(strPr, Boolean.valueOf(zX));
        return zX;
    }

    public static List<String> pr() {
        ArrayList arrayList = new ArrayList();
        if (!com.byazt.sd.a.hw().gg() || !com.byazt.sd.zo.nt().yb().hw()) {
            return arrayList;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        if (Build.VERSION.SDK_INT >= 23) {
            for (ResolveInfo resolveInfo : aj.pr(intent, 131072)) {
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

    public static boolean hw() {
        try {
            PackageInfo packageInfo = com.byazt.sd.a.getContext().getPackageManager().getPackageInfo(com.byazt.sd.a.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable th) {
            return true;
        }
    }

    private static boolean x(Intent intent) {
        try {
            List<ResolveInfo> listPr = aj.pr(intent, 65536);
            return listPr != null && listPr.size() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void hn() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.wt.ls.1
                @Override // java.lang.Runnable
                public void run() {
                    ls.y();
                }
            });
        } else {
            y();
        }
    }

    public static int pr(of ofVar) {
        int iIntValue = 0;
        switch (com.byazt.sd.a.hw().z()) {
            case -1:
                try {
                    cr crVarZo = ie.zo(ofVar);
                    iy iyVarFw = ie.fw(ofVar);
                    if (crVarZo != null) {
                        String strUc = crVarZo.uc();
                        if (!TextUtils.isEmpty(strUc)) {
                            iIntValue = Integer.valueOf(strUc).intValue();
                        }
                    } else if (iyVarFw != null) {
                        String strK = iyVarFw.k();
                        if (!TextUtils.isEmpty(strK)) {
                            iIntValue = Integer.valueOf(strK).intValue();
                        }
                    }
                    return iIntValue;
                } catch (Exception e) {
                    com.byazt.ca.ho.hw("tl", e.getMessage());
                    return iIntValue;
                }
            case 0:
            default:
                return 0;
            case 1:
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y() {
        List<String> listZj;
        com.byazt.is.w wVarHw = com.byazt.sd.a.hw();
        if (com.byazt.sd.zo.nt().hs()) {
            com.byazt.sd.zo.nt().fw(false);
            return;
        }
        if (wVarHw.hg() || (listZj = wVarHw.zj()) == null) {
            return;
        }
        int iSu = wVarHw.su();
        for (int i = 0; i < iSu && i < listZj.size(); i++) {
            Uri uri = Uri.parse(listZj.get(i));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            pr(intent, true);
        }
    }

    public static boolean x() {
        return (com.byazt.sd.zo.nt() == null || com.byazt.sd.zo.nt().pr()) ? false : true;
    }

    public static String pr(int i) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    public static int x(String str) {
        switch (str) {
            case "embeded_ad":
                return 1;
            case "draw_ad":
                return 6;
            case "banner_ad":
                return 2;
            case "interaction":
                return 3;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "rewarded_video":
                return 7;
            default:
                return 1;
        }
    }

    public static String hw(int i) {
        switch (i) {
            case 1:
                return com.byazt.pfl.hw.AD_TAG_BANNER;
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return com.byazt.pfl.hw.AD_TAG_FEED;
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

    public static String hw(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        try {
            return hw(k(ofVar));
        } catch (Throwable th) {
            return null;
        }
    }

    public static JSONObject c(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static boolean hn(of ofVar) {
        return ofVar != null && k(ofVar) == 5;
    }

    public static boolean x(of ofVar) {
        return ofVar != null && k(ofVar) == 9;
    }

    public static boolean c(of ofVar) {
        if (ofVar != null) {
            return ie.hn(ofVar) == 7 && (k(ofVar) == 5);
        }
        return false;
    }

    public static boolean uc(of ofVar) {
        int iK = k(ofVar);
        return (iK == 9 || iK == 8 || iK == 7) && !TextUtils.isEmpty(qv.pr(ofVar));
    }

    public static boolean fw(of ofVar) {
        int iK = k(ofVar);
        if (iK == 3 || iK == 4 || iK == 9 || iK == 7 || iK == 8) {
            return true;
        }
        return false;
    }

    public static boolean zo(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        int iK = k(ofVar);
        return iK == 5 || iK == 1 || iK == 2;
    }

    public static boolean aj(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        int iK = k(ofVar);
        return iK == 3 || iK == 4;
    }

    public static boolean vk(of ofVar) {
        JSONObject jSONObjectV_;
        if (ofVar == null || (jSONObjectV_ = ofVar.v_()) == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(jSONObjectV_.optString("compliance_data")).optJSONObject(an.aw).optInt("pricing_type");
            return iOptInt == 3 || iOptInt == 6;
        } catch (Exception e) {
            com.byazt.ca.ho.hw("ToolUtils", "error:" + e.getMessage());
            return false;
        }
    }

    public static String w(of ofVar) {
        com.byazt.hg.yb ybVarG;
        if (ofVar == null || (ybVarG = ofVar.g()) == null) {
            return null;
        }
        return ybVarG.hw();
    }

    public static int k(of ofVar) {
        JSONObject jSONObjectV_;
        if (ofVar != null && (jSONObjectV_ = ofVar.v_()) != null) {
            return jSONObjectV_.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static int m(of ofVar) {
        JSONObject jSONObjectV_;
        if (ofVar != null && (jSONObjectV_ = ofVar.v_()) != null) {
            return jSONObjectV_.optInt("rit", 0);
        }
        return 0;
    }

    public static String g(of ofVar) {
        JSONObject jSONObjectV_ = ofVar.v_();
        return jSONObjectV_ != null ? jSONObjectV_.optString("origin_req_id", "") : "";
    }

    public static String ho(of ofVar) {
        JSONObject jSONObjectV_ = ofVar.v_();
        return jSONObjectV_ != null ? jSONObjectV_.optString("customer_id", "") : "";
    }

    public static double uc(String str) {
        return pr(c(str));
    }

    public static double nt(of ofVar) {
        return pr(ofVar.v_());
    }

    private static double pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static long c() {
        return w;
    }

    public static String yb(of ofVar) {
        JSONObject jSONObjectV_ = ofVar.v_();
        return jSONObjectV_ != null ? jSONObjectV_.optString("req_id", "") : "";
    }

    public static String pr(of ofVar, String str) {
        JSONObject jSONObjectV_ = ofVar.v_();
        if (jSONObjectV_ != null) {
            return jSONObjectV_.optString("rit", str);
        }
        return str;
    }

    public static String hw(of ofVar, String str) {
        JSONObject jSONObjectV_ = ofVar.v_();
        if (jSONObjectV_ != null) {
            return jSONObjectV_.optString("creative_id", str);
        }
        return str;
    }

    public static String hn(of ofVar, String str) {
        JSONObject jSONObjectV_ = ofVar.v_();
        if (jSONObjectV_ != null) {
            return jSONObjectV_.optString(MediationConstant.EXTRA_ADID, str);
        }
        return str;
    }

    public static int lb(of ofVar) {
        JSONObject jSONObjectV_ = ofVar.v_();
        if (jSONObjectV_ != null) {
            return jSONObjectV_.optInt("pricing", 0);
        }
        return 0;
    }

    public static int qa(of ofVar) {
        JSONObject jSONObjectV_ = ofVar.v_();
        if (jSONObjectV_ != null) {
            return jSONObjectV_.optInt(IAction.PurchaseKey.Price, 0);
        }
        return 0;
    }

    public static String a(of ofVar) {
        if (ofVar == null) {
            return "";
        }
        String strHw = null;
        com.byazt.hg.c cVarHo = ofVar.ho();
        if (cVarHo != null) {
            strHw = cVarHo.hw();
        }
        if (TextUtils.isEmpty(strHw)) {
            return ofVar.hs();
        }
        return strHw;
    }

    public static String cz(of ofVar) {
        if (ofVar.ho() != null && !TextUtils.isEmpty(ofVar.ho().hn())) {
            return ofVar.ho().hn();
        }
        if (!TextUtils.isEmpty(ofVar.zj())) {
            return ofVar.zj();
        }
        if (!TextUtils.isEmpty(ofVar.A_())) {
            return ofVar.A_();
        }
        return "";
    }

    public static String ny(of ofVar) {
        if (!TextUtils.isEmpty(ofVar.A_())) {
            return ofVar.A_();
        }
        if (!TextUtils.isEmpty(ofVar.jv())) {
            return ofVar.jv();
        }
        return "";
    }

    public static void uc() {
        if (com.byazt.sd.iu.hn()) {
            ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(true);
        }
    }

    public static String fw() {
        return UUID.randomUUID().toString();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    /* JADX WARN: Code duplicated, block: B:23:0x0057 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:3:0x0005, B:6:0x001c, B:18:0x003e, B:21:0x0051, B:23:0x0057, B:25:0x0065, B:27:0x007b, B:26:0x0078, B:28:0x007e, B:9:0x002c, B:12:0x0034), top: B:32:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0065 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:3:0x0005, B:6:0x001c, B:18:0x003e, B:21:0x0051, B:23:0x0057, B:25:0x0065, B:27:0x007b, B:26:0x0078, B:28:0x007e, B:9:0x002c, B:12:0x0034), top: B:32:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0078 A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:3:0x0005, B:6:0x001c, B:18:0x003e, B:21:0x0051, B:23:0x0057, B:25:0x0065, B:27:0x007b, B:26:0x0078, B:28:0x007e, B:9:0x002c, B:12:0x0034), top: B:32:0x0005 }] */
    public static String pr(com.byazt.qe.hw hwVar) {
        JSONArray jSONArrayOptJSONArray;
        StringBuilder sb;
        int i;
        String strOptString;
        try {
            JSONObject jSONObject = new JSONObject(hwVar.cz());
            int iOptInt = jSONObject.optInt("cypher");
            String strOptString2 = jSONObject.optString("message");
            String strX = "";
            if (iOptInt == 3) {
                strX = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(strOptString2);
            } else {
                if (iOptInt != 4) {
                    strX = null;
                } else {
                    com.byazt.vkw.nt ntVarHn = rc.hn();
                    String strHw = ntVarHn == null ? "" : ntVarHn.hw(strOptString2);
                    if (strHw != null) {
                        strX = strHw;
                    }
                }
                jSONArrayOptJSONArray = new JSONObject(strX).optJSONArray("creatives");
                sb = new StringBuilder();
                if (jSONArrayOptJSONArray != null) {
                    for (i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        strOptString = ((JSONObject) jSONArrayOptJSONArray.get(i)).optString("material_key");
                        if (i != 0) {
                            sb.append("," + strOptString);
                        } else {
                            sb.append(strOptString);
                        }
                    }
                }
                return sb.toString();
            }
            jSONArrayOptJSONArray = new JSONObject(strX).optJSONArray("creatives");
            sb = new StringBuilder();
            if (jSONArrayOptJSONArray != null) {
                while (i < jSONArrayOptJSONArray.length()) {
                    strOptString = ((JSONObject) jSONArrayOptJSONArray.get(i)).optString("material_key");
                    if (i != 0) {
                        sb.append("," + strOptString);
                    } else {
                        sb.append(strOptString);
                    }
                }
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    @HungeonFlag
    public static String zo() {
        if (!TextUtils.isEmpty(lb)) {
            return lb;
        }
        if (com.byazt.sd.a.getContext() != null) {
            try {
                lb = com.byazt.sd.a.getContext().getPackageName();
            } catch (Throwable th) {
                com.byazt.ca.ho.pr("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return lb;
    }

    public static String aj() {
        if (TextUtils.isEmpty(nt) && com.byazt.sd.a.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.sd.a.getContext().getPackageManager().getPackageInfo(zo(), 0);
                nt = String.valueOf(packageInfo.versionCode);
                yb = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.ca.ho.pr("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return nt;
    }

    public static String vk() {
        if (TextUtils.isEmpty(yb) && com.byazt.sd.a.getContext() != null) {
            try {
                PackageInfo packageInfo = com.byazt.sd.a.getContext().getPackageManager().getPackageInfo(zo(), 0);
                nt = String.valueOf(packageInfo.versionCode);
                yb = packageInfo.versionName;
            } catch (Throwable th) {
                com.byazt.ca.ho.pr("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return yb;
    }

    public static String w() {
        if (!TextUtils.isEmpty(x) && !x.equals("0")) {
            return x;
        }
        String strHw = com.byazt.mp.x.pr().hw("total_memory", "0");
        x = strHw;
        return strHw;
    }

    public static String k() {
        return String.valueOf(Long.parseLong(w()) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    }

    public static String fw(String str) {
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
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception e2) {
                            }
                        }
                        return null;
                    }
                } while (!line.contains(str));
                if (line != null) {
                    String str2 = line.split("\\s+")[1];
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception e4) {
                    }
                    return str2;
                }
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                }
                try {
                    fileReader.close();
                } catch (Exception e6) {
                }
                return null;
            } catch (Throwable th2) {
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static int m() {
        File[] fileArrListFiles;
        if (Build.VERSION.SDK_INT >= 17) {
            return Math.max(Runtime.getRuntime().availableProcessors(), 0);
        }
        try {
            File file = new File("/sys/devices/system/cpu/");
            if (!file.exists() || (fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.byazt.wt.ls.2
                public Pattern pr = Pattern.compile("^cpu[0-9]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return this.pr.matcher(str).matches();
                }
            })) == null) {
                return 0;
            }
            return Math.max(fileArrListFiles.length, 0);
        } catch (Throwable th) {
        }
        return 0;
    }

    public static int g() {
        if (pr > 0) {
            return pr;
        }
        int iHw = com.byazt.mp.x.pr().hw("cpu_cnt", 0);
        pr = iHw;
        return iHw;
    }

    public static int ho() {
        if (hw > 0) {
            return hw;
        }
        int iHw = com.byazt.mp.x.pr().hw("cpu_max_freq", 0);
        hw = iHw;
        return iHw;
    }

    public static int nt() {
        if (hn > 0) {
            return hn;
        }
        int iHw = com.byazt.mp.x.pr().hw("cpu_min_freq", 0);
        hn = iHw;
        return iHw;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0062 A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #1 {Exception -> 0x005e, blocks: (B:22:0x005a, B:26:0x0062), top: B:43:0x005a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0075 A[Catch: Exception -> 0x0071, TRY_LEAVE, TryCatch #6 {Exception -> 0x0071, blocks: (B:33:0x006d, B:37:0x0075), top: B:53:0x006d }] */
    public static int hn(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader = null;
        int i2 = 0;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i--;
            if (i >= 0) {
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
                            } catch (Exception e) {
                            }
                            bufferedReader2 = bufferedReader3;
                            fileReader = fileReader2;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader3;
                            fileReader = fileReader2;
                            try {
                                com.byazt.ca.ho.hw("ToolUtils", th.getMessage());
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    } catch (Exception e2) {
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
                                    } catch (Exception e3) {
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
            } else {
                return i2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #4 {Exception -> 0x0062, blocks: (B:24:0x005e, B:28:0x0066), top: B:51:0x005e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0079 A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #3 {Exception -> 0x0075, blocks: (B:35:0x0071, B:39:0x0079), top: B:49:0x0071 }] */
    public static int x(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader = null;
        int i2 = 0;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i--;
            if (i >= 0) {
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
                            } catch (Exception e) {
                            }
                            bufferedReader2 = bufferedReader3;
                            fileReader = fileReader2;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader3;
                            fileReader = fileReader2;
                            try {
                                com.byazt.ca.ho.hw("ToolUtils", th.getMessage());
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                    } catch (Exception e2) {
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
                                    } catch (Exception e3) {
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
            } else {
                return i2;
            }
        }
    }

    public static long yb() {
        if (c > 0) {
            return c;
        }
        long jHw = com.byazt.mp.x.pr().hw("internal_storage", 0L);
        c = jHw;
        return jHw;
    }

    public static long lb() {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockCount * blockSize;
        } catch (Throwable th) {
            return 0L;
        }
    }

    public static long qa() {
        if (uc > 0) {
            return uc;
        }
        long jHw = com.byazt.mp.x.pr().hw("free_storage", 0L);
        uc = jHw;
        return jHw;
    }

    public static long a() {
        if (fw > 0) {
            return fw;
        }
        long jHw = com.byazt.mp.x.pr().hw("sdcard_storage", 0L);
        fw = jHw;
        return jHw;
    }

    public static long cz() {
        try {
            if (ww()) {
                StatFs statFs = new StatFs(com.byazt.ca.uc.hn(com.byazt.sd.a.getContext(), false, null).getPath());
                return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            return 0L;
        } catch (Throwable th) {
            com.byazt.ca.ho.hw("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean ww() {
        try {
            return "mounted".equals(com.byazt.zp.x.pr());
        } catch (Throwable th) {
            return false;
        }
    }

    public static int ny() {
        if (zo >= 0) {
            return zo;
        }
        int iHw = com.byazt.mp.x.pr().hw("is_root", -1);
        zo = iHw;
        return iHw;
    }

    public static boolean fo() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable th) {
            return false;
        }
    }

    public static Map<String, Object> pr(long j, of ofVar, com.byazt.ihe.fw fwVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (ofVar != null) {
            if (!TextUtils.isEmpty(ofVar.x())) {
                map.put("creative_id", ofVar.x());
            }
            com.byazt.n.x xVarHo = qv.ho(ofVar);
            if (xVarHo != null) {
                map.put("video_resolution", xVarHo.aj());
                map.put("video_size", Long.valueOf(xVarHo.c()));
            }
        }
        pr(map, fwVar);
        return map;
    }

    public static Map<String, Object> pr(boolean z, of ofVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", ofVar.x());
        map.put("load_time", Long.valueOf(j));
        com.byazt.n.x xVarHo = qv.ho(ofVar);
        if (xVarHo != null) {
            map.put("video_size", Long.valueOf(xVarHo.c()));
            map.put("video_resolution", xVarHo.aj());
            map.put("video_preload_size", Long.valueOf(Build.VERSION.SDK_INT >= 23 ? xVarHo.nt() : xVarHo.c()));
        }
        if (!z) {
            map.put(Constants.ERROR_CODE_FIELD, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> hw(boolean z, of ofVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", ofVar.x());
        map.put("load_time", Long.valueOf(j));
        if (!z) {
            map.put(Constants.ERROR_CODE_FIELD, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> pr(of ofVar, long j, com.byazt.ihe.fw fwVar) {
        HashMap map = new HashMap();
        map.put("creative_id", ofVar.x());
        map.put("buffers_time", Long.valueOf(j));
        com.byazt.n.x xVarHo = qv.ho(ofVar);
        if (xVarHo != null) {
            map.put("video_size", Long.valueOf(xVarHo.c()));
            map.put("video_resolution", xVarHo.aj());
        }
        pr(map, fwVar);
        return map;
    }

    private static void pr(Map<String, Object> map, com.byazt.ihe.fw fwVar) {
        if (!map.containsKey("video_resolution") && fwVar != null) {
            try {
                map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(fwVar.yb()), Integer.valueOf(fwVar.lb())));
            } catch (Throwable th) {
            }
        }
    }

    public static JSONObject fo(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.v_();
    }

    public static boolean zo(String str) {
        try {
            if (Pattern.compile("[一-龥]").matcher(str).find()) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String pr(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e) {
            com.byazt.ca.ho.hw("ToolUtils", e.toString());
            return "";
        }
    }

    public static boolean rc(of ofVar) {
        if (ofVar == null || com.byazt.hg.lb.x(ofVar)) {
            return false;
        }
        int iIe = ofVar.ie();
        return iIe == 5 || iIe == 4;
    }

    public static boolean z(of ofVar) {
        if (ofVar == null) {
            return true;
        }
        switch (com.byazt.sd.a.hw().uc(m(ofVar))) {
            case 1:
                return com.byazt.ca.yb.x(com.byazt.sd.a.getContext());
            case 2:
                if (com.byazt.ca.yb.c(com.byazt.sd.a.getContext()) || com.byazt.ca.yb.x(com.byazt.sd.a.getContext()) || com.byazt.ca.yb.uc(com.byazt.sd.a.getContext())) {
                    return true;
                }
                return false;
            case 3:
                return false;
            case 4:
                return true;
            case 5:
                if (com.byazt.ca.yb.x(com.byazt.sd.a.getContext()) || com.byazt.ca.yb.uc(com.byazt.sd.a.getContext())) {
                    return true;
                }
                return false;
            default:
                return true;
        }
    }

    private static String nt(String str) {
        if (TextUtils.isEmpty(str)) {
            aj = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            aj = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        aj = null;
        return str;
    }

    private static String yb(String str) {
        if (TextUtils.isEmpty(str)) {
            vk = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            vk = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        vk = null;
        return str;
    }

    public static String aj(String str) {
        return pr(str, false, 0);
    }

    public static String vk(String str) {
        return pr(str, false, 1);
    }

    public static String pr(String str, boolean z) {
        return pr(str, z, 0);
    }

    private static String pr(String str, boolean z, int i) {
        String strA = i == 0 ? com.byazt.sd.a.hw().a() : nt(com.byazt.sd.a.hw().ve());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.byazt.hs.hn.pr() && com.byazt.sd.zo.nt().od() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strA = com.byazt.sd.zo.nt().vj();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.byazt.sd.zo.nt().jw() != null && zo().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strA = com.byazt.sd.zo.nt().vj();
        } else {
            str2 = str;
        }
        String strPr = String.format("https://%s%s", strA, str2);
        if (s.pr()) {
            if (!z) {
                strPr = s.hw(strPr);
            }
            String strPr2 = s.pr("testIp.txt");
            if (strPr2 != null) {
                strPr = s.pr(strPr, strPr2);
            }
        }
        if (z) {
            return lb(strPr);
        }
        return strPr;
    }

    private static String lb(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", aj()).toString();
        } catch (Exception e) {
            return str;
        }
    }

    public static String w(String str) {
        return lb(String.format("https://%s%s", com.byazt.is.vk.w(), str));
    }

    public static String rc() {
        return s.hw(Uri.parse(String.format("https://%s", yb(com.byazt.sd.a.hw().ww()))).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static String z() {
        return s.hw(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static boolean b(of ofVar) {
        return ofVar != null && ofVar.ax() == 1;
    }

    public static boolean pr(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && pr(j) == pr(j2);
    }

    public static long pr(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static String iu(of ofVar) {
        Object obj;
        String string = "";
        if (ofVar == null) {
            return "";
        }
        com.byazt.hg.uc ucVarLb = ofVar.lb();
        if (ucVarLb != null) {
            string = ucVarLb.m();
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        com.byazt.hg.c cVarHo = ofVar.ho();
        if (cVarHo != null) {
            string = cVarHo.x();
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        Map<String, Object> mapZc = ofVar.zc();
        if (mapZc != null && (obj = mapZc.get("ad_package_name")) != null) {
            string = obj.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        return ofVar.ic();
    }

    public static boolean b() {
        boolean z;
        Context context = com.byazt.sd.a.getContext();
        if (context == null) {
            com.byazt.ca.ho.pr("params context is null");
            return false;
        }
        if (context.getApplicationInfo().targetSdkVersion < 30 || Build.VERSION.SDK_INT < 30 || context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") == 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        return true;
    }

    public static void pr(of ofVar, JSONObject jSONObject) {
        Uri uri;
        int i;
        try {
            String strW = w(ofVar);
            int i2 = 3;
            if (TextUtils.isEmpty(strW)) {
                i = 3;
                uri = null;
            } else {
                uri = Uri.parse(strW);
                i = 0;
            }
            boolean zB = b();
            if (zB && uri != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                if (hw(intent, false)) {
                    i = 1;
                } else {
                    i = 2;
                }
            }
            jSONObject.putOpt("scheme_status", Integer.valueOf(i));
            String strVe = ve(ofVar);
            if (!TextUtils.isEmpty(strVe)) {
                i2 = hn(strVe) ? 1 : 2;
            }
            jSONObject.put("hit_status", i2);
            jSONObject.putOpt("alist", Boolean.valueOf(com.byazt.sd.zo.nt().yb().hw()));
            jSONObject.putOpt("query_auth", Integer.valueOf(zB ? 1 : 0));
            jSONObject.putOpt("scheme", uri != null ? b.pr(uri) : null);
            jSONObject.putOpt("hit_pkg", strVe);
        } catch (Throwable th) {
            com.byazt.ca.ho.pr("ToolUtils", th);
        }
    }

    public static String ve(of ofVar) {
        String strOptString = null;
        if (ofVar == null) {
            return null;
        }
        JSONObject jSONObjectIa = ofVar.ia();
        if (jSONObjectIa != null) {
            strOptString = jSONObjectIa.optString("pkg");
        }
        if (TextUtils.isEmpty(strOptString)) {
            return iu(ofVar);
        }
        return strOptString;
    }

    public static String hw(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int hw(com.byazt.qe.hw hwVar) {
        if (hwVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(hwVar.x());
        } catch (Exception e) {
            return 0;
        }
    }

    public static String iu() {
        return zo() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static Intent pr(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (c(context)) {
            try {
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
            } catch (Throwable th) {
                com.byazt.xk.hw.pr().pr("receiver_exception", pr(broadcastReceiver, intentFilter, str, "flags_register", i), th);
                return null;
            }
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Throwable th2) {
            com.byazt.xk.hw.pr().pr("receiver_exception", pr(broadcastReceiver, intentFilter, str, "legacy_register", i), th2);
            return null;
        }
    }

    private static boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        try {
            return context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion >= 34;
        } catch (Throwable th) {
            return false;
        }
    }

    private static JSONObject pr(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("stage", str2);
            jSONObject.putOpt("receiver", broadcastReceiver.getClass().getName());
            jSONObject.putOpt("permission", str);
            jSONObject.putOpt("flags", Integer.valueOf(i));
            if (intentFilter.countActions() > 0) {
                jSONObject.putOpt("action", intentFilter.getAction(0));
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static long hw(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            try {
                Object[] objArr = {"targetSdkVersion = ", Integer.valueOf(i)};
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            i = -1;
        }
        return i;
    }

    public static long hn(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().minSdkVersion;
            try {
                Object[] objArr = {"minSdkVersion = ", Integer.valueOf(i)};
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            i = -1;
        }
        return i;
    }

    public static int c(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
            case 4:
            case 7:
            case 8:
                return 5;
            case 5:
            case 6:
            default:
                return 3;
        }
    }

    public static Bundle pr(int i, Bundle bundle) {
        int i2 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i3 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt("reward_extra_key_error_code", i3);
        bundle2.putString("reward_extra_key_error_msg", string2);
        bundle2.putString("reward_extra_key_reward_name", string);
        bundle2.putInt("reward_extra_key_reward_amount", i2);
        bundle2.putFloat("reward_extra_key_reward_propose", f);
        bundle2.putBoolean("reward_extra_key_is_server_verify", z2);
        if (i == 0) {
            bundle2.putBoolean("reward_extra_key_has_video_complete_reward", z);
        }
        return bundle2;
    }

    public static String pr(int[] iArr) {
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

    public static int[] m(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (Exception e) {
            }
        }
        return iArr;
    }

    public static void pr(Intent intent, of ofVar) {
        if (ofVar == null) {
            return;
        }
        if (!com.byazt.sd.a.hw().ae()) {
            intent.putExtra("multi_process_materialmeta", ofVar.to().toString());
            return;
        }
        String strCz = ofVar.cz();
        intent.putExtra("multi_process_materialmeta_key", strCz);
        if (((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr() && !com.byazt.sd.iu.hn()) {
            com.byazt.sd.cz.hn(strCz, ofVar, of.class);
        } else {
            com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_meta").pr(strCz, ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(ofVar.to().toString()));
        }
    }

    public static void pr(Map<String, Object> map, JSONObject jSONObject, String str) {
        if (jSONObject == null || map == null) {
            return;
        }
        if (!com.byazt.sd.a.hw().ae()) {
            map.put("multi_process_materialmeta", jSONObject.toString());
            return;
        }
        map.put("multi_process_materialmeta_key", str);
        if (((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr()) {
            com.byazt.sd.cz.hn(str, com.byazt.sd.pr.pr(jSONObject), of.class);
        } else {
            y.pr("sp_meta").pr(str, ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(jSONObject.toString()));
        }
    }

    public static void pr(Map<String, Object> map, of ofVar) {
        if (ofVar == null || map == null) {
            return;
        }
        if (!com.byazt.sd.a.hw().ae()) {
            map.put("multi_process_materialmeta", ofVar.to().toString());
            return;
        }
        String strCz = ofVar.cz();
        map.put("multi_process_materialmeta_key", strCz);
        if (((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr() && !com.byazt.sd.iu.hn()) {
            com.byazt.sd.cz.hn(strCz, ofVar, of.class);
        } else {
            com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_meta").pr(strCz, ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(ofVar.to().toString()));
        }
    }

    public static of hw(Intent intent) {
        of ofVarPr;
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra) && (ofVarPr = com.byazt.sd.pr.pr(new JSONObject(stringExtra))) != null) {
                return ofVarPr;
            }
        } catch (Exception e) {
            com.byazt.ca.ho.pr("ToolUtils", "getMaterialMeta from intent failed", e);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        of ofVar = (of) com.byazt.sd.cz.x(stringExtra2, of.class);
        if (ofVar != null) {
            return ofVar;
        }
        com.byazt.zq.hn hnVarPr = com.byazt.qn.x.pr(com.byazt.zb.pr.x(), "sp_meta");
        String strX = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(hnVarPr.hw(stringExtra2, ""));
        try {
            if (!TextUtils.isEmpty(strX)) {
                return com.byazt.sd.pr.pr(new JSONObject(strX));
            }
            com.byazt.ca.ho.hw("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
            return null;
        } catch (Exception e2) {
            com.byazt.ca.ho.pr("ToolUtils", "getMaterialMeta from keva failed", e2);
            return null;
        } finally {
            hnVarPr.pr(stringExtra2);
        }
    }

    public static void ve() {
        if (k && m == com.byazt.lx.hw.pr()) {
            return;
        }
        k = true;
        m = com.byazt.lx.hw.pr();
        com.byazt.kp.pr prVarPr = com.byazt.kp.pr.pr();
        if (com.byazt.lx.hw.hw()) {
            prVarPr.pr("open_live_saas", new com.byazt.lze.hn());
            prVarPr.pr("open_miniapp", new com.byazt.lze.x());
            prVarPr.pr("open_landing_page", new com.byazt.lze.hw());
            prVarPr.pr("download", new com.byazt.lze.pr());
            prVarPr.pr("open_scheme", new com.byazt.lze.c());
            prVarPr.pr("report_event", new com.byazt.lze.uc());
            prVarPr.pr("report_stats", new com.byazt.lze.fw());
        } else {
            prVarPr.pr("open_sass_live", new com.byazt.od.w());
            prVarPr.pr("open_miniapp", new com.byazt.od.k());
            prVarPr.pr("open_landing_page", new com.byazt.od.vk());
            prVarPr.pr("download", new com.byazt.od.fw());
            prVarPr.pr("open_scheme", new com.byazt.od.m());
            prVarPr.pr("report_event", new com.byazt.od.ho());
            prVarPr.pr("report_stats", new com.byazt.od.nt());
        }
        prVarPr.pr("open_policy", new com.byazt.od.g());
        prVarPr.pr("end_card", new com.byazt.od.aj());
        prVarPr.pr("common_popup", new com.byazt.od.pr());
        prVarPr.pr("desc_popup", new com.byazt.od.hw());
        prVarPr.pr("permission_popup", new com.byazt.od.hn());
        prVarPr.pr("privacy_popup", new com.byazt.od.x());
        prVarPr.pr("registration_pop", new com.byazt.od.c());
        prVarPr.pr("dislike_popup", new com.byazt.od.uc());
        prVarPr.pr("download_popup", new com.byazt.od.zo());
        prVarPr.pr("reward_again", new com.byazt.od.lb());
        prVarPr.pr("reward_continue", new com.byazt.od.lb());
        prVarPr.pr("close_reward", new com.byazt.od.yb());
    }

    public static boolean pr(String str, of ofVar, Context context) {
        if (TextUtils.isEmpty(str) || ofVar == null || context == null) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("material_meta", ofVar);
        map.put(d.R, context);
        com.byazt.lx.hw.pr(str, ofVar.to(), map);
        return true;
    }

    public static String x(of ofVar, String str) {
        u uVarF_;
        if (ofVar == null || (uVarF_ = ofVar.F_()) == null || uVarF_.hw() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.byazt.md.x.hn().pr()) {
            return sb.append(2).toString();
        }
        sb.append(uVarF_.uc());
        return sb.toString();
    }

    public static boolean pr(String str, AtomicInteger atomicInteger) {
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
        if (com.byazt.hg.e.pr.isEmpty()) {
            gz();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        Set<String> set = com.byazt.hg.e.pr;
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

    public static void gz() {
        String strEu = com.byazt.sd.a.hw().eu();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(strEu);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!TextUtils.isEmpty(strGroup)) {
                    com.byazt.hg.e.pr.add(strGroup);
                }
            }
        } catch (Throwable th) {
        }
        if (!TextUtils.isEmpty(strEu) && com.byazt.hg.e.pr.isEmpty()) {
            com.byazt.hg.e.pr.add("empty");
        }
    }

    public static void hn(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        } else if (com.byazt.sd.a.hw().lb(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
    }

    public static String x(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean g(String str) {
        long jHo = ho(str);
        return jHo != 0 && System.currentTimeMillis() - (jHo * 1000) > 0;
    }

    public static long ho(String str) {
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
                if (str.contains("v3-be-pack")) {
                    return j + 10800;
                }
                return j;
            } catch (Exception e) {
            }
        }
        return 0L;
    }
}
