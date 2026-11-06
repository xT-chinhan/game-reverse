package com.byazt.vgx;

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
import android.text.TextUtils;
import com.anythink.china.a.c;
import com.anythink.core.common.l.f;
import com.anythink.core.d.b.e;
import com.byazt.gct.ae;
import com.byazt.gct.cd;
import com.byazt.gct.dw;
import com.byazt.gct.hd;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.gct.ta;
import com.byazt.gct.wv;
import com.byazt.ho.BaseConstants;
import com.byazt.lbp.cp;
import com.byazt.lbp.cy;
import com.byazt.lbp.d;
import com.byazt.lbp.fs;
import com.byazt.lbp.sz;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.sdk.api.SDMAdConst;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 13})
public class w {
    public static long cp = -1;
    public static volatile boolean d = false;
    public static volatile int fs = -1;
    public static String k;
    public static volatile long l;
    public static volatile int n;
    public static volatile int oa;
    public static volatile String q;
    public static volatile int qg;
    public static volatile int s;
    public static volatile long w;
    public static volatile long x;
    public static final AtomicBoolean sz = new AtomicBoolean(false);
    public static volatile String cy = null;
    public static volatile String hd = null;
    public static volatile String cd = null;
    public static String rv = null;
    public static String tj = null;

    public static int l(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    public static String n(int i) {
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

    public static String qg(int i) {
        switch (i) {
            case 1:
                return com.byazt.wg.qg.AD_TAG_BANNER;
            case 2:
                return "interaction";
            case 3:
            case 4:
                return "splash_ad";
            case 5:
            default:
                return com.byazt.wg.qg.AD_TAG_FEED;
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

    public static boolean n(Context context, String str) {
        Intent intentQg;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (!h()) {
                    Intent intentQg2 = qg(context, str);
                    if (intentQg2 == null) {
                        return false;
                    }
                    intentQg2.putExtra("START_ONLY_FOR_ANDROID", true);
                    context.startActivity(intentQg2);
                    return true;
                }
                if (!qg(str) || (intentQg = qg(context, str)) == null) {
                    return false;
                }
                intentQg.putExtra("START_ONLY_FOR_ANDROID", true);
                com.byazt.tk.n.n(context, intentQg, null);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String n(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return "";
        }
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) ? "" : scheme.toLowerCase(Locale.US);
    }

    public static Intent qg(Context context, String str) {
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

    public static boolean qg(String str) {
        Context context = rv.getContext();
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (h()) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (rv.qg().ff()) {
            return s(str);
        }
        return false;
    }

    public static boolean s(String str) {
        String[] strArr = {f.R, "media", "obb"};
        for (int i = 0; i < 3; i++) {
            if (n(strArr[i], str).exists()) {
                return true;
            }
        }
        return false;
    }

    private static File n(String str, String str2) {
        if (k == null) {
            String str3 = System.getenv("EXTERNAL_STORAGE");
            k = str3;
            if (str3 == null) {
                k = "/sdcard";
            }
        }
        return new File(k, "Android/" + str + "/" + str2);
    }

    public static boolean n(Intent intent, boolean z) {
        if (intent != null && h()) {
            return qg(intent, z);
        }
        return false;
    }

    public static boolean n(Intent intent) {
        if (intent != null && h()) {
            return qg(intent, false);
        }
        return false;
    }

    public static boolean qg(Intent intent, boolean z) {
        Boolean boolN;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String strN = com.byazt.rd.n.n(data);
        if (z && (boolN = com.byazt.rd.n.n(strN, 86400000L)) != null) {
            return boolN.booleanValue();
        }
        boolean zQ = q(intent);
        com.byazt.rd.n.n(strN, Boolean.valueOf(zQ));
        return zQ;
    }

    public static List<String> n() {
        ArrayList arrayList = new ArrayList();
        if (rv.qg().rm() && com.byazt.vyf.s.cy().hd().s()) {
            for (ResolveInfo resolveInfo : com.byazt.ehw.n.n(new Intent("android.intent.action.MAIN"), 131072)) {
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

    public static boolean qg() {
        try {
            PackageInfo packageInfo = rv.getContext().getPackageManager().getPackageInfo(rv.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean q(Intent intent) {
        try {
            List<ResolveInfo> listN = com.byazt.ehw.n.n(intent, 65536);
            return listN != null && listN.size() > 0;
        } catch (Throwable unused) {
        }
    }

    public static void s() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.tk.rv.n().post(new Runnable() { // from class: com.byazt.vgx.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.lh();
                }
            });
        } else {
            lh();
        }
    }

    public static int n(pk pkVar) {
        int iHu = rv.qg().hu();
        int iIntValue = 0;
        if (iHu != -1) {
            return (iHu == 0 || iHu != 1) ? 0 : 1;
        }
        try {
            su suVarFs = nf.fs(pkVar);
            dw dwVarX = nf.x(pkVar);
            if (suVarFs != null) {
                String strW = suVarFs.w();
                if (!TextUtils.isEmpty(strW)) {
                    iIntValue = Integer.valueOf(strW).intValue();
                }
            } else if (dwVarX != null) {
                String strD = dwVarX.d();
                if (!TextUtils.isEmpty(strD)) {
                    iIntValue = Integer.valueOf(strD).intValue();
                }
            }
            return iIntValue;
        } catch (Exception e) {
            k.qg("tl", e.getMessage());
            return iIntValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lh() {
        List<String> listGu;
        com.byazt.ivn.w wVarQg = rv.qg();
        if (com.byazt.vyf.s.cy().rf()) {
            com.byazt.vyf.s.cy().rv(false);
            return;
        }
        if (wVarQg.wf() || (listGu = wVarQg.gu()) == null) {
            return;
        }
        int iLr = wVarQg.lr();
        for (int i = 0; i < iLr && i < listGu.size(); i++) {
            Uri uri = Uri.parse(listGu.get(i));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            n(intent, true);
        }
    }

    public static boolean q() {
        return (com.byazt.vyf.s.cy() == null || com.byazt.vyf.s.cy().n()) ? false : true;
    }

    public static int q(String str) {
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

    public static String qg(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        try {
            return qg(d(pkVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject l(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean s(pk pkVar) {
        return pkVar != null && d(pkVar) == 5;
    }

    public static boolean q(pk pkVar) {
        return pkVar != null && d(pkVar) == 9;
    }

    public static boolean l(pk pkVar) {
        if (pkVar != null) {
            boolean z = d(pkVar) == 5;
            if (nf.s(pkVar) == 7 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean w(pk pkVar) {
        int iD = d(pkVar);
        return (iD == 9 || iD == 8 || iD == 7) && !TextUtils.isEmpty(ta.n(pkVar));
    }

    public static boolean x(pk pkVar) {
        int iD = d(pkVar);
        return iD == 3 || iD == 4 || iD == 9 || iD == 7 || iD == 8;
    }

    public static boolean fs(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        int iD = d(pkVar);
        return iD == 5 || iD == 1 || iD == 2;
    }

    public static boolean rv(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        int iD = d(pkVar);
        return iD == 3 || iD == 4;
    }

    public static boolean tj(pk pkVar) {
        JSONObject jSONObjectA_;
        if (pkVar == null || (jSONObjectA_ = pkVar.A_()) == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(jSONObjectA_.optString("compliance_data")).optJSONObject("ad").optInt("pricing_type");
            return iOptInt == 3 || iOptInt == 6;
        } catch (Exception e) {
            k.qg("ToolUtils", "error:" + e.getMessage());
            return false;
        }
    }

    public static String cp(pk pkVar) {
        hd hdVarSz;
        if (pkVar == null || (hdVarSz = pkVar.sz()) == null) {
            return null;
        }
        return hdVarSz.qg();
    }

    public static int d(pk pkVar) {
        JSONObject jSONObjectA_;
        if (pkVar == null || (jSONObjectA_ = pkVar.A_()) == null) {
            return 0;
        }
        return jSONObjectA_.optInt("ad_slot_type", 0);
    }

    public static int oa(pk pkVar) {
        JSONObject jSONObjectK = k(pkVar);
        if (jSONObjectK != null) {
            return jSONObjectK.optInt("content_type", 0);
        }
        return 0;
    }

    public static int sz(pk pkVar) {
        JSONObject jSONObjectK = k(pkVar);
        if (jSONObjectK != null) {
            return jSONObjectK.optInt("landing_type", 0);
        }
        return 0;
    }

    public static JSONObject k(pk pkVar) {
        JSONObject jSONObjectA_ = pkVar.A_();
        if (jSONObjectA_ == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObjectA_.optString("compliance_data")).optJSONObject("ad");
        } catch (Exception e) {
            k.qg("ToolUtils", "error:" + e.getMessage());
            return null;
        }
    }

    public static int cy(pk pkVar) {
        JSONObject jSONObjectA_;
        if (pkVar == null || (jSONObjectA_ = pkVar.A_()) == null) {
            return 0;
        }
        return jSONObjectA_.optInt("rit", 0);
    }

    public static String hd(pk pkVar) {
        JSONObject jSONObjectA_ = pkVar.A_();
        return jSONObjectA_ != null ? jSONObjectA_.optString("origin_req_id", "") : "";
    }

    public static String cd(pk pkVar) {
        JSONObject jSONObjectA_ = pkVar.A_();
        return jSONObjectA_ != null ? jSONObjectA_.optString("customer_id", "") : "";
    }

    public static double w(String str) {
        return n(l(str));
    }

    public static double um(pk pkVar) {
        return n(pkVar.A_());
    }

    private static double n(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static long l() {
        return cp;
    }

    public static String a(pk pkVar) {
        JSONObject jSONObjectA_ = pkVar.A_();
        return jSONObjectA_ != null ? jSONObjectA_.optString("req_id", "") : "";
    }

    public static String n(pk pkVar, String str) {
        JSONObject jSONObjectA_ = pkVar.A_();
        return jSONObjectA_ != null ? jSONObjectA_.optString("rit", str) : str;
    }

    public static String qg(pk pkVar, String str) {
        JSONObject jSONObjectA_ = pkVar.A_();
        return jSONObjectA_ != null ? jSONObjectA_.optString("creative_id", str) : str;
    }

    public static String s(pk pkVar, String str) {
        JSONObject jSONObjectA_ = pkVar.A_();
        return jSONObjectA_ != null ? jSONObjectA_.optString(MediationConstant.EXTRA_ADID, str) : str;
    }

    public static int py(pk pkVar) {
        JSONObject jSONObjectA_ = pkVar.A_();
        if (jSONObjectA_ != null) {
            return jSONObjectA_.optInt("pricing", 0);
        }
        return 0;
    }

    public static int ou(pk pkVar) {
        JSONObject jSONObjectA_ = pkVar.A_();
        if (jSONObjectA_ != null) {
            return jSONObjectA_.optInt(e.a.h, 0);
        }
        return 0;
    }

    public static String wm(pk pkVar) {
        if (pkVar == null) {
            return "";
        }
        com.byazt.gct.l lVarK = pkVar.k();
        String strQg = lVarK != null ? lVarK.qg() : null;
        return TextUtils.isEmpty(strQg) ? pkVar.e() : strQg;
    }

    public static String m(pk pkVar) {
        if (pkVar.k() != null && !TextUtils.isEmpty(pkVar.k().s())) {
            return pkVar.k().s();
        }
        if (TextUtils.isEmpty(pkVar.yr())) {
            return !TextUtils.isEmpty(pkVar.E_()) ? pkVar.E_() : "";
        }
        return pkVar.yr();
    }

    public static String hu(pk pkVar) {
        if (TextUtils.isEmpty(pkVar.E_())) {
            return !TextUtils.isEmpty(pkVar.m19if()) ? pkVar.m19if() : "";
        }
        return pkVar.E_();
    }

    public static void w() {
        if (tj.q()) {
            ((oa) com.byazt.qp.q.n("device_info_new")).qg(true);
        }
    }

    public static String x() {
        return UUID.randomUUID().toString();
    }

    public static String n(com.byazt.zq.qg qgVar) {
        String strQg;
        try {
            JSONObject jSONObject = new JSONObject(qgVar.py());
            int iOptInt = jSONObject.optInt("cypher");
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                strQg = ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).q(strOptString);
            } else if (iOptInt == 4) {
                com.byazt.vf.k kVarS = com.byazt.cl.s.s();
                strQg = kVarS == null ? "" : kVarS.qg(strOptString);
                if (strQg == null) {
                    strQg = "";
                }
            } else {
                strQg = null;
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strQg).optJSONArray("creatives");
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
    public static String fs() {
        if (!TextUtils.isEmpty(cd)) {
            return cd;
        }
        if (rv.getContext() != null) {
            try {
                cd = rv.getContext().getPackageName();
            } catch (Throwable th) {
                k.n("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return cd;
    }

    public static String rv() {
        if (TextUtils.isEmpty(cy) && rv.getContext() != null) {
            try {
                PackageInfo packageInfo = rv.getContext().getPackageManager().getPackageInfo(fs(), 0);
                cy = String.valueOf(packageInfo.versionCode);
                hd = packageInfo.versionName;
            } catch (Throwable th) {
                k.n("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return cy;
    }

    public static String tj() {
        if (TextUtils.isEmpty(hd) && rv.getContext() != null) {
            try {
                PackageInfo packageInfo = rv.getContext().getPackageManager().getPackageInfo(fs(), 0);
                cy = String.valueOf(packageInfo.versionCode);
                hd = packageInfo.versionName;
            } catch (Throwable th) {
                k.n("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return hd;
    }

    public static String cp() {
        if (!TextUtils.isEmpty(q) && !q.equals("0")) {
            return q;
        }
        String strQg = com.byazt.ed.s.n().qg("total_memory", "0");
        q = strQg;
        return strQg;
    }

    public static String d() {
        return String.valueOf(Long.parseLong(cp()) * c.k);
    }

    public static String x(String str) {
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
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    }
                } while (!line.contains(str));
                if (line != null) {
                    String str2 = line.split("\\s+")[1];
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused5) {
                    }
                    return str2;
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused6) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused7) {
                }
                return null;
            } catch (Throwable unused8) {
                bufferedReader = null;
            }
        } catch (Throwable unused9) {
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static int oa() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    /* JADX INFO: renamed from: com.byazt.vgx.w$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 43})
    static class AnonymousClass2 implements FilenameFilter {
        public Pattern n = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.n.matcher(str).matches();
        }
    }

    public static int sz() {
        if (n > 0) {
            return n;
        }
        int iQg = com.byazt.ed.s.n().qg("cpu_cnt", 0);
        n = iQg;
        return iQg;
    }

    public static int k() {
        if (qg > 0) {
            return qg;
        }
        int iQg = com.byazt.ed.s.n().qg("cpu_max_freq", 0);
        qg = iQg;
        return iQg;
    }

    public static int cy() {
        if (s > 0) {
            return s;
        }
        int iQg = com.byazt.ed.s.n().qg("cpu_min_freq", 0);
        s = iQg;
        return iQg;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0059 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:20:0x0054, B:22:0x0059), top: B:34:0x0054 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0066 A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #2 {Exception -> 0x0069, blocks: (B:26:0x0061, B:28:0x0066), top: B:38:0x0061 }] */
    public static int s(int i) {
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
                            k.qg("ToolUtils", th.getMessage());
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
    public static int q(int i) {
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
                            k.qg("ToolUtils", th.getMessage());
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

    public static long hd() {
        if (l > 0) {
            return l;
        }
        long jQg = com.byazt.ed.s.n().qg("internal_storage", 0L);
        l = jQg;
        return jQg;
    }

    public static long cd() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long um() {
        if (w > 0) {
            return w;
        }
        long jQg = com.byazt.ed.s.n().qg("free_storage", 0L);
        w = jQg;
        return jQg;
    }

    public static long a() {
        if (x > 0) {
            return x;
        }
        long jQg = com.byazt.ed.s.n().qg("sdcard_storage", 0L);
        x = jQg;
        return jQg;
    }

    public static long py() {
        try {
            if (!v()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.byazt.tk.w.s(rv.getContext(), false, null).getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            k.qg("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean v() {
        try {
            return "mounted".equals(com.byazt.xu.qg.n());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int ou() {
        if (fs >= 0) {
            return fs;
        }
        int iQg = com.byazt.ed.s.n().qg("is_root", -1);
        fs = iQg;
        return iQg;
    }

    public static boolean wm() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Map<String, Object> n(long j, pk pkVar, com.byazt.ej.x xVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (pkVar != null) {
            if (!TextUtils.isEmpty(pkVar.q())) {
                map.put("creative_id", pkVar.q());
            }
            com.byazt.zsl.s sVarK = ta.k(pkVar);
            if (sVarK != null) {
                map.put("video_resolution", sVarK.rv());
                map.put("video_size", Long.valueOf(sVarK.l()));
            }
        }
        n(map, xVar);
        return map;
    }

    public static Map<String, Object> n(boolean z, pk pkVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", pkVar.q());
        map.put("load_time", Long.valueOf(j));
        com.byazt.zsl.s sVarK = ta.k(pkVar);
        if (sVarK != null) {
            map.put("video_size", Long.valueOf(sVarK.l()));
            map.put("video_resolution", sVarK.rv());
            map.put("video_preload_size", Long.valueOf(sVarK.cy()));
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

    public static Map<String, Object> qg(boolean z, pk pkVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", pkVar.q());
        map.put("load_time", Long.valueOf(j));
        if (!z) {
            map.put("error_code", Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> n(pk pkVar, long j, com.byazt.ej.x xVar) {
        HashMap map = new HashMap();
        map.put("creative_id", pkVar.q());
        map.put("buffers_time", Long.valueOf(j));
        com.byazt.zsl.s sVarK = ta.k(pkVar);
        if (sVarK != null) {
            map.put("video_size", Long.valueOf(sVarK.l()));
            map.put("video_resolution", sVarK.rv());
        }
        n(map, xVar);
        return map;
    }

    private static void n(Map<String, Object> map, com.byazt.ej.x xVar) {
        if (map.containsKey("video_resolution") || xVar == null) {
            return;
        }
        try {
            map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(xVar.hd()), Integer.valueOf(xVar.cd())));
        } catch (Throwable unused) {
        }
    }

    public static JSONObject h(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.A_();
    }

    public static boolean fs(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String n(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Exception e) {
            k.qg("ToolUtils", e.toString());
            return "";
        }
    }

    public static boolean t(pk pkVar) {
        if (pkVar == null || cd.q(pkVar)) {
            return false;
        }
        int iCx = pkVar.cx();
        return iCx == 5 || iCx == 4;
    }

    public static boolean ur(pk pkVar) {
        if (pkVar == null) {
            return true;
        }
        int iL = rv.qg().l(cy(pkVar));
        if (iL == 1) {
            return com.byazt.tk.hd.q(rv.getContext());
        }
        if (iL == 2) {
            return com.byazt.tk.hd.l(rv.getContext()) || com.byazt.tk.hd.q(rv.getContext()) || com.byazt.tk.hd.w(rv.getContext());
        }
        if (iL != 3) {
            return iL != 5 || com.byazt.tk.hd.q(rv.getContext()) || com.byazt.tk.hd.w(rv.getContext());
        }
        return false;
    }

    private static String cy(String str) {
        if (TextUtils.isEmpty(str)) {
            rv = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            rv = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        rv = null;
        return str;
    }

    private static String hd(String str) {
        if (TextUtils.isEmpty(str)) {
            tj = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            tj = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        tj = null;
        return str;
    }

    public static String rv(String str) {
        return n(str, false, 0);
    }

    public static String tj(String str) {
        return n(str, false, 1);
    }

    public static String n(String str, boolean z) {
        return n(str, z, 0);
    }

    private static String n(String str, boolean z, int i) {
        String strA = i == 0 ? rv.qg().a() : cy(rv.qg().ur());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.byazt.lq.s.n() && com.byazt.vyf.s.cy().lq() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strA = com.byazt.vyf.s.cy().ic();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.byazt.vyf.s.cy().he() != null && fs().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strA = com.byazt.vyf.s.cy().ic();
        } else {
            str2 = str;
        }
        String strN = String.format("https://%s%s", strA, str2);
        if (com.byazt.lq.l.n()) {
            if (!z) {
                strN = com.byazt.lq.l.qg(strN);
            }
            String strN2 = com.byazt.lq.l.n("testIp.txt");
            if (strN2 != null) {
                strN = com.byazt.lq.l.n(strN, strN2);
            }
        }
        return z ? cd(strN) : strN;
    }

    private static String cd(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", rv()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String cp(String str) {
        return cd(String.format("https://%s%s", com.byazt.ph.q.sz(), str));
    }

    public static String m() {
        return com.byazt.lq.l.qg(Uri.parse(String.format("https://%s", hd(rv.qg().v()))).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static String hu() {
        return com.byazt.lq.l.qg(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", BaseConstants.ROM_OPPO_UPPER_CONSTANT);
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static boolean bb(pk pkVar) {
        return pkVar != null && pkVar.kj() == 1;
    }

    public static boolean n(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && n(j) == n(j2);
    }

    public static long n(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static String ln(pk pkVar) {
        Object obj;
        if (pkVar == null) {
            return "";
        }
        com.byazt.gct.w wVarCd = pkVar.cd();
        String strOa = wVarCd != null ? wVarCd.oa() : "";
        if (!TextUtils.isEmpty(strOa)) {
            return strOa;
        }
        com.byazt.gct.l lVarK = pkVar.k();
        if (lVarK != null) {
            strOa = lVarK.q();
        }
        if (!TextUtils.isEmpty(strOa)) {
            return strOa;
        }
        Map<String, Object> mapWl = pkVar.wl();
        if (mapWl != null && (obj = mapWl.get("ad_package_name")) != null) {
            strOa = obj.toString();
        }
        return !TextUtils.isEmpty(strOa) ? strOa : pkVar.em();
    }

    public static boolean h() {
        Context context = rv.getContext();
        if (context != null) {
            return !(context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0);
        }
        k.n("params context is null");
        return false;
    }

    public static void n(pk pkVar, JSONObject jSONObject) {
        Uri uri;
        int i;
        try {
            String strCp = cp(pkVar);
            int i2 = 3;
            if (TextUtils.isEmpty(strCp)) {
                i = 3;
                uri = null;
            } else {
                uri = Uri.parse(strCp);
                i = 0;
            }
            boolean zH = h();
            if (zH && uri != null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                i = qg(intent, false) ? 1 : 2;
            }
            jSONObject.putOpt("scheme_status", Integer.valueOf(i));
            String strLh = lh(pkVar);
            if (!TextUtils.isEmpty(strLh)) {
                i2 = s(strLh) ? 1 : 2;
            }
            jSONObject.put("hit_status", i2);
            jSONObject.putOpt("alist", Boolean.valueOf(com.byazt.vyf.s.cy().hd().s()));
            jSONObject.putOpt("query_auth", Integer.valueOf(zH ? 1 : 0));
            jSONObject.putOpt("scheme", uri != null ? com.byazt.rd.n.n(uri) : null);
            jSONObject.putOpt("hit_pkg", strLh);
        } catch (Throwable th) {
            k.n("ToolUtils", th);
        }
    }

    public static String lh(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        JSONObject jSONObjectDc = pkVar.dc();
        String strOptString = jSONObjectDc != null ? jSONObjectDc.optString(SDMAdConst.NETWORK_CUSTOM_KEY.PKG) : null;
        return TextUtils.isEmpty(strOptString) ? ln(pkVar) : strOptString;
    }

    public static String qg(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int qg(com.byazt.zq.qg qgVar) {
        if (qgVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(qgVar.q());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String t() {
        return fs() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static Intent n(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (context != null && broadcastReceiver != null && intentFilter != null) {
            if (l(context)) {
                try {
                    return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
                } catch (Throwable th) {
                    com.byazt.eji.s.n().n("receiver_exception", n(broadcastReceiver, intentFilter, str, "flags_register", i), th);
                    return null;
                }
            }
            try {
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
            } catch (Throwable th2) {
                com.byazt.eji.s.n().n("receiver_exception", n(broadcastReceiver, intentFilter, str, "legacy_register", i), th2);
            }
        }
        return null;
    }

    private static boolean l(Context context) {
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        try {
            return context.getApplicationInfo() != null && context.getApplicationInfo().targetSdkVersion >= 34;
        } catch (Throwable unused) {
        }
    }

    private static JSONObject n(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("stage", str2);
            jSONObject.putOpt("receiver", broadcastReceiver.getClass().getName());
            jSONObject.putOpt("permission", str);
            jSONObject.putOpt("flags", Integer.valueOf(i));
            if (intentFilter.countActions() > 0) {
                jSONObject.putOpt("action", intentFilter.getAction(0));
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static long qg(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            try {
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i = -1;
        }
        return i;
    }

    public static long s(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().minSdkVersion;
            try {
                Object[] objArr = new Object[2];
                Integer.valueOf(i);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i = -1;
        }
        return i;
    }

    public static Bundle n(int i, Bundle bundle) {
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

    public static String n(int[] iArr) {
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

    public static int[] oa(String str) {
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

    public static void n(Intent intent, pk pkVar) {
        if (pkVar == null) {
            return;
        }
        if (!rv.qg().p()) {
            intent.putExtra("multi_process_materialmeta", pkVar.pv().toString());
            return;
        }
        String strPy = pkVar.py();
        intent.putExtra("multi_process_materialmeta_key", strPy);
        if (((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n() && !tj.q()) {
            com.byazt.ikv.qg.s(strPy, pkVar, pk.class);
        } else {
            com.byazt.lk.l.n(s.q(), "sp_meta").n(strPy, ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).s(pkVar.pv().toString()));
        }
    }

    public static void n(Map<String, Object> map, JSONObject jSONObject, String str) {
        if (jSONObject == null || map == null) {
            return;
        }
        if (!rv.qg().p()) {
            map.put("multi_process_materialmeta", jSONObject.toString());
            return;
        }
        map.put("multi_process_materialmeta_key", str);
        if (((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n()) {
            com.byazt.ikv.qg.s(str, qg.n(jSONObject), pk.class);
        } else {
            com.byazt.lk.l.n(s.q(), "sp_meta").n(str, ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).s(jSONObject.toString()));
        }
    }

    public static void n(Map<String, Object> map, pk pkVar) {
        if (pkVar == null || map == null) {
            return;
        }
        if (!rv.qg().p()) {
            map.put("multi_process_materialmeta", pkVar.pv().toString());
            return;
        }
        String strPy = pkVar.py();
        map.put("multi_process_materialmeta_key", strPy);
        if (((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n() && !tj.q()) {
            com.byazt.ikv.qg.s(strPy, pkVar, pk.class);
        } else {
            com.byazt.lk.l.n(s.q(), "sp_meta").n(strPy, ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).s(pkVar.pv().toString()));
        }
    }

    public static pk qg(Intent intent) {
        pk pkVarN;
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra) && (pkVarN = qg.n(new JSONObject(stringExtra))) != null) {
                return pkVarN;
            }
        } catch (Exception e) {
            k.n("ToolUtils", "getMaterialMeta from intent failed", e);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        pk pkVar = (pk) com.byazt.ikv.qg.q(stringExtra2, pk.class);
        if (pkVar != null) {
            return pkVar;
        }
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(s.q(), "sp_meta");
        String strQ = ((com.byazt.vf.k) com.byazt.qp.q.n("encrypt_service")).q(sVarN.qg(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(strQ)) {
                k.qg("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return qg.n(new JSONObject(strQ));
        } catch (Exception e2) {
            k.n("ToolUtils", "getMaterialMeta from keva failed", e2);
            return null;
        } finally {
            sVarN.n(stringExtra2);
        }
    }

    public static void ur() {
        if (d && oa == com.byazt.ukb.qg.n()) {
            return;
        }
        d = true;
        oa = com.byazt.ukb.qg.n();
        com.byazt.jbj.n nVarN = com.byazt.jbj.n.n();
        if (com.byazt.ukb.qg.qg()) {
            nVarN.n("open_live_saas", new com.byazt.vku.s());
            nVarN.n("open_miniapp", new com.byazt.vku.q());
            nVarN.n("open_landing_page", new com.byazt.vku.qg());
            nVarN.n("download", new com.byazt.vku.n());
            nVarN.n("open_scheme", new com.byazt.vku.l());
            nVarN.n("report_event", new com.byazt.vku.w());
            nVarN.n("report_stats", new com.byazt.vku.x());
        } else {
            nVarN.n("open_sass_live", new cp());
            nVarN.n("open_miniapp", new d());
            nVarN.n("open_landing_page", new com.byazt.lbp.tj());
            nVarN.n("download", new com.byazt.lbp.x());
            nVarN.n("open_scheme", new com.byazt.lbp.oa());
            nVarN.n("report_event", new com.byazt.lbp.k());
            nVarN.n("report_stats", new cy());
        }
        nVarN.n("open_policy", new sz());
        nVarN.n("end_card", new com.byazt.lbp.rv());
        nVarN.n("common_popup", new com.byazt.lbp.n());
        nVarN.n("desc_popup", new com.byazt.lbp.qg());
        nVarN.n("permission_popup", new com.byazt.lbp.s());
        nVarN.n("privacy_popup", new com.byazt.lbp.q());
        nVarN.n("registration_pop", new com.byazt.lbp.l());
        nVarN.n("dislike_popup", new com.byazt.lbp.w());
        nVarN.n("download_popup", new fs());
        nVarN.n("reward_again", new com.byazt.lbp.cd());
        nVarN.n("reward_continue", new com.byazt.lbp.cd());
        nVarN.n("close_reward", new com.byazt.lbp.hd());
    }

    public static boolean n(String str, pk pkVar, Context context) {
        if (TextUtils.isEmpty(str) || pkVar == null || context == null) {
            return false;
        }
        HashMap map = new HashMap();
        map.put("material_meta", pkVar);
        map.put("context", context);
        com.byazt.ukb.qg.n(str, pkVar.pv(), map);
        return true;
    }

    public static String q(pk pkVar, String str) {
        wv wvVarJ_;
        if (pkVar == null || (wvVarJ_ = pkVar.J_()) == null || wvVarJ_.qg() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append("open_method=");
        if (!com.byazt.soz.q.s().n()) {
            return sb.append(2).toString();
        }
        sb.append(wvVarJ_.w());
        return sb.toString();
    }

    public static boolean n(String str, AtomicInteger atomicInteger) {
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
        if (ae.n.isEmpty()) {
            bb();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        Set<String> set = ae.n;
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

    public static void bb() {
        String strEu = rv.qg().eu();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(strEu);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!TextUtils.isEmpty(strGroup)) {
                    ae.n.add(strGroup);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strEu) || !ae.n.isEmpty()) {
            return;
        }
        ae.n.add("empty");
    }

    public static void s(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        } else if (rv.qg().cd(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
    }

    public static String q(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean sz(String str) {
        long jK = k(str);
        return jK != 0 && System.currentTimeMillis() - (jK * 1000) > 0;
    }

    public static long k(String str) {
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
}
