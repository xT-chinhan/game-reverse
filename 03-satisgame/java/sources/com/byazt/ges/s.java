package com.byazt.ges;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.x;
import com.byazt.qk.oa;
import com.byazt.tk.hd;
import com.byazt.tk.hu;
import com.byazt.vf.k;
import com.byazt.vgx.w;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
@com.byazt.cp.n(n = {0, 1, 1374, 8})
public class s extends x {
    public static volatile s qg;
    public Comparator<JSONObject> fs;
    public AtomicBoolean l;
    public String n;
    public final n q;
    public final Context s;
    public AtomicBoolean w;
    public volatile AtomicBoolean x;

    public static s n() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    private s() {
        super("ApplistHelper");
        this.l = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(true);
        this.fs = new Comparator<JSONObject>() { // from class: com.byazt.ges.s.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context context = rv.getContext();
        this.s = context;
        this.q = new n(context);
    }

    public void n(String str) {
        if (w.qg()) {
            this.w.set(rv.qg().hy() && com.byazt.vyf.s.cy().hd().s());
            if (com.byazt.ivn.q.q() && this.x.get() && !this.l.get()) {
                this.l.set(true);
                try {
                    this.n = str;
                    com.byazt.qit.l.n(this, 1);
                } catch (Throwable unused) {
                    this.l.set(false);
                }
            }
        }
    }

    private List<JSONObject> qg(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.w.get() || (com.byazt.ehw.rv.hd() && Build.VERSION.SDK_INT >= 29)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qg.n("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = hu.n(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(hu.n(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
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
                        jSONObject2.put("app_name", "unknown");
                        jSONObject2.put("app_type", n(packageInfo));
                        jSONObject2.put("apk_dir", packageInfo.applicationInfo != null ? packageInfo.applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public List<String> n(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qg.n("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = hu.n(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(hu.n(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt("f")));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (n(packageInfo) != 1) {
                            arrayList.add("unknown:" + packageInfo.packageName);
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private int n(PackageInfo packageInfo) {
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
        if (!hd.n(this.s)) {
            this.l.set(false);
            return;
        }
        try {
            String str = this.n;
            boolean zS = this.q.s(str);
            this.x.set(false);
            if (zS) {
                qg(qg(this.s), str);
            } else {
                this.l.set(false);
            }
        } catch (Throwable unused) {
            this.l.set(false);
        }
    }

    private boolean n(List<JSONObject> list, String str) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.fs);
        String strQ = ((k) com.byazt.qp.q.n("encrypt_service")).q(this.q.qg(str));
        if (TextUtils.isEmpty(strQ)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strQ);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.fs);
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
            com.byazt.tk.k.n("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void qg(final List<JSONObject> list, final String str) {
        boolean zN = n(list, str);
        JSONObject jSONObjectN = n(zN ? list : new ArrayList<>(), rv.qg().nd(), rv.qg().gu());
        if (list != null) {
            list.size();
        }
        com.byazt.udc.s sVar = new com.byazt.udc.s();
        sVar.n(w.rv("/api/ad/union/sdk/upload/app_info/"));
        sVar.s(jSONObjectN, "applist");
        sVar.n(new com.byazt.qk.x() { // from class: com.byazt.ges.s.2
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar == null || !oaVar.x()) {
                    s.this.x.set(true);
                } else {
                    JSONObject jSONObjectL = oaVar.l();
                    if (jSONObjectL == null) {
                        return;
                    }
                    if (jSONObjectL != null && "20000".equals(jSONObjectL.optString("status"))) {
                        s.this.q.n(str);
                        s.this.q.n(((k) com.byazt.qp.q.n("encrypt_service")).s(new JSONArray((Collection) list).toString()), str);
                    }
                }
                s.this.l.set(false);
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str2, Throwable th) {
                s.this.l.set(false);
                s.this.x.set(true);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x01ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x014a  */
    /* JADX WARN: Code duplicated, block: B:50:0x014b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0163 A[Catch: Exception -> 0x01e3, TRY_LEAVE, TryCatch #2 {Exception -> 0x01e3, blocks: (B:3:0x0005, B:7:0x0023, B:11:0x002f, B:15:0x003d, B:18:0x0045, B:21:0x0050, B:27:0x0064, B:28:0x006d, B:30:0x0073, B:31:0x0083, B:33:0x00fc, B:35:0x0102, B:36:0x0110, B:38:0x0116, B:45:0x0130, B:46:0x0134, B:47:0x013e, B:51:0x014c, B:53:0x0151, B:56:0x0159, B:57:0x015d, B:59:0x0163, B:64:0x0184, B:66:0x018a, B:68:0x0190, B:69:0x01a2, B:71:0x01a8, B:73:0x01ba, B:74:0x01c2, B:75:0x01ca, B:76:0x01d4, B:78:0x01de, B:40:0x0122, B:42:0x0128, B:43:0x012c), top: B:86:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x01a8 A[Catch: Exception -> 0x01e3, TryCatch #2 {Exception -> 0x01e3, blocks: (B:3:0x0005, B:7:0x0023, B:11:0x002f, B:15:0x003d, B:18:0x0045, B:21:0x0050, B:27:0x0064, B:28:0x006d, B:30:0x0073, B:31:0x0083, B:33:0x00fc, B:35:0x0102, B:36:0x0110, B:38:0x0116, B:45:0x0130, B:46:0x0134, B:47:0x013e, B:51:0x014c, B:53:0x0151, B:56:0x0159, B:57:0x015d, B:59:0x0163, B:64:0x0184, B:66:0x018a, B:68:0x0190, B:69:0x01a2, B:71:0x01a8, B:73:0x01ba, B:74:0x01c2, B:75:0x01ca, B:76:0x01d4, B:78:0x01de, B:40:0x0122, B:42:0x0128, B:43:0x012c), top: B:86:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01de A[Catch: Exception -> 0x01e3, TRY_LEAVE, TryCatch #2 {Exception -> 0x01e3, blocks: (B:3:0x0005, B:7:0x0023, B:11:0x002f, B:15:0x003d, B:18:0x0045, B:21:0x0050, B:27:0x0064, B:28:0x006d, B:30:0x0073, B:31:0x0083, B:33:0x00fc, B:35:0x0102, B:36:0x0110, B:38:0x0116, B:45:0x0130, B:46:0x0134, B:47:0x013e, B:51:0x014c, B:53:0x0151, B:56:0x0159, B:57:0x015d, B:59:0x0163, B:64:0x0184, B:66:0x018a, B:68:0x0190, B:69:0x01a2, B:71:0x01a8, B:73:0x01ba, B:74:0x01c2, B:75:0x01ca, B:76:0x01d4, B:78:0x01de, B:40:0x0122, B:42:0x0128, B:43:0x012c), top: B:86:0x0005, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private JSONObject n(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i;
        Object obj;
        boolean zWf;
        Map<String, Boolean> mapN;
        List<String> listN;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.vf.oa oaVar = (com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new");
            com.byazt.vf.s sVar = (com.byazt.vf.s) com.byazt.qp.q.n("embed_applog");
            String strN = DeviceUtils.n((Boolean) null);
            Object obj2 = "";
            if (TextUtils.isEmpty(strN)) {
                strN = "";
            }
            if (TextUtils.isEmpty(strN)) {
                i = -1;
                obj = "";
            } else {
                obj = strN;
                i = 1;
            }
            int i2 = 0;
            String strN2 = sVar.n(false);
            if (TextUtils.isEmpty(strN2)) {
                strN2 = "";
            }
            if (i < 0 && !TextUtils.isEmpty(strN2)) {
                i = 4;
                obj = strN2;
            }
            String strQg = DeviceUtils.qg();
            if (TextUtils.isEmpty(strQg)) {
                strQg = "";
            }
            String strQg2 = com.byazt.yu.n.n().qg();
            if (!TextUtils.isEmpty(strQg2)) {
                obj2 = strQg2;
            }
            if (i < 0) {
                i = 3;
                obj = strQg;
            }
            JSONArray jSONArray3 = new JSONArray();
            Iterator<JSONObject> it = list.iterator();
            while (it.hasNext()) {
                jSONArray3.put(it.next().optString("package_name"));
            }
            jSONObject.put("app_list", jSONArray3);
            jSONObject.put(f.bI, new JSONArray((Collection) list));
            jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put(TapEventParamConstants.PARAM_DEVICE_ID, obj);
            jSONObject.put("did", com.byazt.ehw.l.n());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, oaVar.qg());
            jSONObject.put("app_id", com.byazt.vyf.s.cy().ou());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", tj.w);
            jSONObject.put("device_id_type", i);
            jSONObject.put("imei", strN);
            jSONObject.put("oaid", strN2);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", strQg);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (w.qg(str)) {
                                jSONArray4.put(str);
                            } else {
                                jSONArray5.put(str);
                            }
                        } catch (Throwable unused) {
                            jSONArray5.put(str);
                        }
                    }
                }
                jSONObject.put("have_applist", jSONArray4);
                jSONObject.put("no_applist", jSONArray5);
                zWf = rv.qg().wf();
                if (zWf) {
                    i2 = 1;
                }
                jSONObject.put("scheme_get_type", i2);
                if (list3 != null) {
                    for (String str2 : list3) {
                        if (!TextUtils.isEmpty(str2)) {
                            Uri uri = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(uri);
                            w.n(intent, true);
                        }
                    }
                }
                mapN = com.byazt.rd.n.n(259200000L);
                if (mapN != null) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    for (Map.Entry<String, Boolean> entry : mapN.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listN = w.n();
                if (listN.size() > 0) {
                    jSONObject.put("query_all_package", listN);
                }
            } else {
                zWf = rv.qg().wf();
                if (zWf) {
                    i2 = 1;
                }
                jSONObject.put("scheme_get_type", i2);
                if (list3 != null && !list3.isEmpty() && zWf) {
                    while (r1.hasNext()) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Uri uri2 = Uri.parse(str2);
                                Intent intent2 = new Intent("android.intent.action.VIEW");
                                intent2.setData(uri2);
                                w.n(intent2, true);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                mapN = com.byazt.rd.n.n(259200000L);
                if (mapN != null && mapN.size() > 0) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    while (r1.hasNext()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listN = w.n();
                if (listN.size() > 0) {
                    jSONObject.put("query_all_package", listN);
                }
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    @com.byazt.cp.n(n = {0, 1, 1374, 546})
    class n {
        public n(Context context) {
        }

        private com.byazt.gwu.s q(String str) {
            try {
                return com.byazt.lk.l.n(str, "tt_sp_app_list");
            } catch (Exception unused) {
                return null;
            }
        }

        public void n(String str, String str2) {
            com.byazt.gwu.s sVarQ;
            if (TextUtils.isEmpty(str) || (sVarQ = q(str2)) == null) {
                return;
            }
            sVarQ.n("old_app_list", str);
        }

        public void n(String str) {
            com.byazt.gwu.s sVarQ = q(str);
            if (sVarQ == null) {
                return;
            }
            sVarQ.n("day_update_time", System.currentTimeMillis());
        }

        public String qg(String str) {
            com.byazt.gwu.s sVarQ = q(str);
            return sVarQ == null ? "" : sVarQ.qg("old_app_list", "");
        }

        public boolean s(String str) {
            com.byazt.gwu.s sVarQ = q(str);
            return !w.n(sVarQ != null ? sVarQ.qg("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1374, 782})
    private static class qg {
        public static String n(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}
