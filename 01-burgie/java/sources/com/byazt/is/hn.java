package com.byazt.is;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.vkw.g;
import com.byazt.vkw.nt;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.b;
import com.byazt.wt.ls;
import com.byazt.wt.qi;
import com.byazt.wt.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 20})
public class hn extends com.byazt.xlm.fw {
    public static volatile hn hw;
    public AtomicBoolean c;
    public volatile AtomicBoolean fw;
    public final Context hn;
    public String pr;
    public AtomicBoolean uc;
    public final pr x;
    public Comparator<JSONObject> zo;

    public static hn hw() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    private hn() {
        super("ApplistHelper");
        this.c = new AtomicBoolean(false);
        this.uc = new AtomicBoolean(false);
        this.fw = new AtomicBoolean(true);
        this.zo = new Comparator<JSONObject>() { // from class: com.byazt.is.hn.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context context = a.getContext();
        this.hn = context;
        this.x = new pr(context);
    }

    public void pr(String str) {
        if (!ls.hw()) {
            return;
        }
        this.uc.set(a.hw().jo() && com.byazt.sd.zo.nt().yb().hw());
        if (!zo.c() || !this.fw.get() || this.c.get()) {
            return;
        }
        this.c.set(true);
        try {
            this.pr = str;
            com.byazt.xlm.c.pr(this, 1);
        } catch (Throwable th) {
            this.c.set(false);
        }
    }

    private List<JSONObject> hw(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.uc.get()) {
            return arrayList;
        }
        if (z.yb() && Build.VERSION.SDK_INT >= 29) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hw.pr("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = com.byazt.ca.z.pr(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(com.byazt.ca.z.pr(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("package_name", packageInfo.packageName);
                        jSONObject2.put("first_install_time", packageInfo.firstInstallTime);
                        jSONObject2.put("last_update_time", packageInfo.lastUpdateTime);
                        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                        jSONObject2.put("version_code", packageInfo.versionCode);
                        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, "unknown");
                        jSONObject2.put("app_type", pr(packageInfo));
                        jSONObject2.put("apk_dir", packageInfo.applicationInfo != null ? packageInfo.applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable th) {
        }
        return arrayList;
    }

    public List<String> pr(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hw.pr("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = com.byazt.ca.z.pr(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(com.byazt.ca.z.pr(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (pr(packageInfo) != 1) {
                            arrayList.add("unknown:" + packageInfo.packageName);
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
        return arrayList;
    }

    private int pr(PackageInfo packageInfo) {
        if (packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 1) == 1) {
            return 1;
        }
        if (String.valueOf(packageInfo.firstInstallTime).endsWith("000")) {
            return 2;
        }
        return 1 & packageInfo.applicationInfo.flags;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!yb.pr(this.hn)) {
            this.c.set(false);
            return;
        }
        try {
            String str = this.pr;
            boolean zHn = this.x.hn(str);
            this.fw.set(false);
            if (!zHn) {
                this.c.set(false);
            } else {
                hw(hw(this.hn), str);
            }
        } catch (Throwable th) {
            this.c.set(false);
        }
    }

    private boolean pr(List<JSONObject> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.zo);
        String strX = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(this.x.hw(str));
        if (TextUtils.isEmpty(strX)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strX);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.zo);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = list.get(i2);
                JSONObject jSONObject2 = (JSONObject) arrayList.get(i2);
                String strOptString = jSONObject.optString("package_name");
                String strOptString2 = jSONObject.optString("last_update_time");
                if (strOptString == null || strOptString2 == null || !strOptString.equals(jSONObject2.optString("package_name")) || !strOptString2.equals(jSONObject2.optString("last_update_time"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            ho.pr("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void hw(final List<JSONObject> list, final String str) {
        boolean zPr = pr(list, str);
        JSONObject jSONObjectPr = pr(zPr ? list : new ArrayList<>(), a.hw().ax(), a.hw().zj());
        if (list != null) {
            list.size();
        }
        qi qiVar = new qi();
        qiVar.pr(ls.aj("/api/ad/union/sdk/upload/app_info/"));
        qiVar.hn(jSONObjectPr, "applist");
        qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.is.hn.2
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar == null || !mVar.fw()) {
                    hn.this.fw.set(true);
                } else {
                    JSONObject jSONObjectC = mVar.c();
                    if (jSONObjectC == null) {
                        return;
                    }
                    if (jSONObjectC != null && "20000".equals(jSONObjectC.optString(NotificationCompat.CATEGORY_STATUS))) {
                        hn.this.x.pr(str);
                        hn.this.x.pr(((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(new JSONArray((Collection) list).toString()), str);
                    }
                }
                hn.this.c.set(false);
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
                hn.this.c.set(false);
                hn.this.fw.set(true);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0161 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x014e  */
    /* JADX WARN: Code duplicated, block: B:52:0x014f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0167 A[Catch: Exception -> 0x01ea, TRY_LEAVE, TryCatch #2 {Exception -> 0x01ea, blocks: (B:3:0x0007, B:7:0x0025, B:11:0x0031, B:15:0x003f, B:18:0x0047, B:21:0x0052, B:27:0x0066, B:28:0x006f, B:30:0x0075, B:31:0x0085, B:33:0x00fe, B:35:0x0104, B:36:0x0112, B:38:0x0118, B:46:0x0134, B:48:0x0138, B:49:0x0142, B:53:0x0150, B:55:0x0155, B:58:0x015d, B:59:0x0161, B:61:0x0167, B:68:0x018a, B:70:0x0190, B:72:0x0196, B:73:0x01a8, B:75:0x01ae, B:77:0x01c0, B:78:0x01c8, B:79:0x01d0, B:80:0x01da, B:82:0x01e4, B:40:0x0125, B:42:0x012b, B:43:0x012f), top: B:90:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01ae A[Catch: Exception -> 0x01ea, TryCatch #2 {Exception -> 0x01ea, blocks: (B:3:0x0007, B:7:0x0025, B:11:0x0031, B:15:0x003f, B:18:0x0047, B:21:0x0052, B:27:0x0066, B:28:0x006f, B:30:0x0075, B:31:0x0085, B:33:0x00fe, B:35:0x0104, B:36:0x0112, B:38:0x0118, B:46:0x0134, B:48:0x0138, B:49:0x0142, B:53:0x0150, B:55:0x0155, B:58:0x015d, B:59:0x0161, B:61:0x0167, B:68:0x018a, B:70:0x0190, B:72:0x0196, B:73:0x01a8, B:75:0x01ae, B:77:0x01c0, B:78:0x01c8, B:79:0x01d0, B:80:0x01da, B:82:0x01e4, B:40:0x0125, B:42:0x012b, B:43:0x012f), top: B:90:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01e4 A[Catch: Exception -> 0x01ea, TRY_LEAVE, TryCatch #2 {Exception -> 0x01ea, blocks: (B:3:0x0007, B:7:0x0025, B:11:0x0031, B:15:0x003f, B:18:0x0047, B:21:0x0052, B:27:0x0066, B:28:0x006f, B:30:0x0075, B:31:0x0085, B:33:0x00fe, B:35:0x0104, B:36:0x0112, B:38:0x0118, B:46:0x0134, B:48:0x0138, B:49:0x0142, B:53:0x0150, B:55:0x0155, B:58:0x015d, B:59:0x0161, B:61:0x0167, B:68:0x018a, B:70:0x0190, B:72:0x0196, B:73:0x01a8, B:75:0x01ae, B:77:0x01c0, B:78:0x01c8, B:79:0x01d0, B:80:0x01da, B:82:0x01e4, B:40:0x0125, B:42:0x012b, B:43:0x012f), top: B:90:0x0007, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private JSONObject pr(List<JSONObject> list, List<String> list2, List<String> list3) {
        Object obj;
        boolean zHg;
        Map<String, Boolean> mapPr;
        List<String> listPr;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = new JSONObject();
        int i = -1;
        try {
            g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
            com.byazt.vkw.hn hnVar = (com.byazt.vkw.hn) com.byazt.zs.uc.pr("embed_applog");
            String strPr = DeviceUtils.pr((Boolean) null);
            Object obj2 = "";
            if (TextUtils.isEmpty(strPr)) {
                strPr = "";
            }
            if (TextUtils.isEmpty(strPr)) {
                obj = "";
            } else {
                obj = strPr;
                i = 1;
            }
            int i2 = 0;
            String strPr2 = hnVar.pr(false);
            if (TextUtils.isEmpty(strPr2)) {
                strPr2 = "";
            }
            if (i < 0 && !TextUtils.isEmpty(strPr2)) {
                i = 4;
                obj = strPr2;
            }
            String strHw = DeviceUtils.hw();
            if (TextUtils.isEmpty(strHw)) {
                strHw = "";
            }
            String strHw2 = com.byazt.sd.uc.pr().hw();
            if (!TextUtils.isEmpty(strHw2)) {
                obj2 = strHw2;
            }
            if (i < 0) {
                i = 3;
                obj = strHw;
            }
            JSONArray jSONArray3 = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray3.put(it.next().optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray3);
            jSONObject.put("app_info", new JSONArray((Collection) list));
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("device_id", obj);
            jSONObject.put("did", com.byazt.wt.nt.pr());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(an.y, Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", gVar.hw());
            jSONObject.put(PluginConstants.KEY_APP_ID, com.byazt.sd.zo.nt().ny());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", iu.c);
            jSONObject.put("device_id_type", i);
            jSONObject.put("imei", strPr);
            jSONObject.put("oaid", strPr2);
            jSONObject.put("applog_did", obj2);
            jSONObject.put(Common.Predefined.SUB_ANDROID_ID, strHw);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (ls.hw(str)) {
                                jSONArray4.put(str);
                            } else {
                                jSONArray5.put(str);
                            }
                        } catch (Throwable th) {
                            jSONArray5.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray4);
                jSONObject.put("no_applist", jSONArray5);
                zHg = a.hw().hg();
                if (zHg) {
                    i2 = 1;
                }
                jSONObject.put("scheme_get_type", i2);
                if (list3 != null) {
                    for (String str2 : list3) {
                        if (!TextUtils.isEmpty(str2)) {
                            Uri uri = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(uri);
                            ls.pr(intent, true);
                        }
                    }
                }
                mapPr = b.pr(259200000L);
                if (mapPr != null) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    for (Map.Entry<String, Boolean> entry : mapPr.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listPr = ls.pr();
                if (listPr.size() > 0) {
                    jSONObject.put("query_all_package", listPr);
                }
            } else {
                zHg = a.hw().hg();
                if (zHg) {
                    i2 = 1;
                }
                jSONObject.put("scheme_get_type", i2);
                if (list3 != null && !list3.isEmpty() && zHg) {
                    while (r2.hasNext()) {
                        if (!TextUtils.isEmpty(str2)) {
                            Uri uri2 = Uri.parse(str2);
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(uri2);
                            ls.pr(intent2, true);
                        }
                    }
                }
                mapPr = b.pr(259200000L);
                if (mapPr != null && mapPr.size() > 0) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    while (r0.hasNext()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listPr = ls.pr();
                if (listPr.size() > 0) {
                    jSONObject.put("query_all_package", listPr);
                }
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 116})
    class pr {
        public pr(Context context) {
        }

        private com.byazt.zq.hn x(String str) {
            try {
                return com.byazt.qn.x.pr(str, "tt_sp_app_list");
            } catch (Exception e) {
                return null;
            }
        }

        public void pr(String str, String str2) {
            com.byazt.zq.hn hnVarX;
            if (TextUtils.isEmpty(str) || (hnVarX = x(str2)) == null) {
                return;
            }
            hnVarX.pr("old_app_list", str);
        }

        public void pr(String str) {
            com.byazt.zq.hn hnVarX = x(str);
            if (hnVarX == null) {
                return;
            }
            hnVarX.pr("day_update_time", System.currentTimeMillis());
        }

        public String hw(String str) {
            com.byazt.zq.hn hnVarX = x(str);
            return hnVarX == null ? "" : hnVarX.hw("old_app_list", "");
        }

        public boolean hn(String str) {
            com.byazt.zq.hn hnVarX = x(str);
            return !ls.pr(hnVarX != null ? hnVarX.hw("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 506})
    private static class hw {
        public static String pr(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}
