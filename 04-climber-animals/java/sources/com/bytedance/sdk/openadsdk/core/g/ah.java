package com.bytedance.sdk.openadsdk.core.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.utils.yu;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.m;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.component.ch.ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ah f2502ms;
    private Comparator<JSONObject> ab;
    private final ms ah;
    private volatile AtomicBoolean c;
    private AtomicBoolean d;
    private boolean ka;
    private final Context xr;

    public static ah ah() {
        if (f2502ms == null) {
            synchronized (ah.class) {
                if (f2502ms == null) {
                    f2502ms = new ah();
                }
            }
        }
        return f2502ms;
    }

    private ah() {
        super("ApplistHelper");
        this.d = new AtomicBoolean(false);
        this.ka = false;
        this.c = new AtomicBoolean(true);
        this.ab = new Comparator<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.g.ah.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                return jSONObject.optString("package_name").compareTo(jSONObject2.optString("package_name"));
            }
        };
        Context context = re.getContext();
        this.xr = context;
        this.ah = new ms(context);
    }

    public void d() {
        if (f.xr()) {
            this.ka = re.xr().ph() && com.bytedance.sdk.openadsdk.core.ch.ub().ao().xr();
            if (x.c() && this.c.get() && !this.d.get()) {
                this.d.set(true);
                try {
                    com.bytedance.sdk.component.ch.ab.ms(this, 1);
                } catch (Throwable unused) {
                    this.d.set(false);
                }
            }
        }
    }

    private List<JSONObject> xr(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        if (context == null || !this.ka || (w.b() && Build.VERSION.SDK_INT >= 29)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.ms.ah(xr.ms("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = yu.ms(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(yu.ms(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt(com.anythink.basead.b.f.a)));
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
                        jSONObject2.put("app_type", ms(packageInfo));
                        jSONObject2.put("apk_dir", packageInfo.applicationInfo != null ? packageInfo.applicationInfo.sourceDir : "unknown");
                        arrayList.add(jSONObject2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public List<String> ms(Context context) {
        List list;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.component.utils.ms.ah(xr.ms("6;37988e9g6h::3<4f9;g437;iei3:d66i5fd<9dde7;f579fUPZmGK\\lXZ2Szig5dHFs58}Sis:eU4fg3JFRho|eROK9Y8U2tY2yOyLKL7yl7YtV}meo.{v;:Oxm#h|Wyszi:Petp;UwqLh9NQq;XiZe3w9]dTjf|jsp}3X5\\dhKrjlho|4Wh4.\\o;vipTtn5oi[i8<tR#H{T7S.\\u5nNpQJV|7khNsW8iH[iLhey;PfqgLhff")));
            Object objInvoke = yu.ms(jSONObject.optString("pn"), jSONObject.optString("m2"), Integer.TYPE).invoke(yu.ms(jSONObject.optString("cn"), jSONObject.optString("m1"), new Class[0]).invoke(context, new Object[0]), Integer.valueOf(jSONObject.optInt(com.anythink.basead.b.f.a)));
            if ((objInvoke instanceof List) && (list = (List) objInvoke) != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof PackageInfo) {
                        PackageInfo packageInfo = (PackageInfo) obj;
                        if (ms(packageInfo) != 1) {
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

    private int ms(PackageInfo packageInfo) {
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
        if (!u.ms(this.xr)) {
            this.d.set(false);
            return;
        }
        try {
            boolean zAh = this.ah.ah();
            this.c.set(false);
            if (zAh) {
                xr(xr(this.xr));
            } else {
                this.d.set(false);
            }
        } catch (Throwable th) {
            this.d.set(false);
            sl.xr("ApplistHelper", "upload sdk runnable error: ", th);
        }
    }

    private boolean ms(List<JSONObject> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, this.ab);
        String strAh = com.bytedance.sdk.component.utils.ms.ah(this.ah.xr());
        if (TextUtils.isEmpty(strAh)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(strAh);
            int length = jSONArray.length();
            if (length != list.size()) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getJSONObject(i));
            }
            Collections.sort(arrayList, this.ab);
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
            sl.ah("ApplistHelper", "is app change error: ", th);
            return true;
        }
    }

    private void xr(final List<JSONObject> list) {
        boolean zMs = ms(list);
        JSONObject jSONObjectMs = ms(zMs ? list : new ArrayList<>(), re.xr().di(), re.xr().wp());
        if (list != null) {
            list.size();
        }
        m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
        mVar.ms(f.ny("/api/ad/union/sdk/upload/app_info/"));
        mVar.ah(jSONObjectMs, "applist");
        mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.g.ah.2
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar == null || !xrVar.x() || TextUtils.isEmpty(xrVar.d())) {
                    ah.this.c.set(true);
                } else {
                    try {
                        if ("20000".equals(new JSONObject(xrVar.d()).optString("status"))) {
                            ah.this.ah.ms();
                            ah.this.ah.ms(com.bytedance.sdk.component.utils.ms.xr(new JSONArray((Collection) list).toString()));
                        }
                    } catch (JSONException e) {
                        sl.ms(e);
                    }
                }
                ah.this.d.set(false);
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                ah.this.d.set(false);
                ah.this.c.set(true);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x01b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x01b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x013d  */
    /* JADX WARN: Code duplicated, block: B:50:0x013e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0156 A[Catch: Exception -> 0x01da, TRY_LEAVE, TryCatch #2 {Exception -> 0x01da, blocks: (B:3:0x0005, B:7:0x0012, B:11:0x001e, B:15:0x002c, B:18:0x0034, B:21:0x003f, B:27:0x0053, B:28:0x005c, B:30:0x0062, B:31:0x0072, B:33:0x00eb, B:35:0x00f1, B:36:0x00ff, B:38:0x0105, B:45:0x0123, B:46:0x0127, B:47:0x0131, B:51:0x013f, B:53:0x0144, B:56:0x014c, B:57:0x0150, B:59:0x0156, B:64:0x017b, B:66:0x0181, B:68:0x0187, B:69:0x0199, B:71:0x019f, B:73:0x01b1, B:74:0x01b9, B:75:0x01c1, B:76:0x01cb, B:78:0x01d5, B:40:0x0111, B:42:0x011b, B:43:0x011f), top: B:86:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x019f A[Catch: Exception -> 0x01da, TryCatch #2 {Exception -> 0x01da, blocks: (B:3:0x0005, B:7:0x0012, B:11:0x001e, B:15:0x002c, B:18:0x0034, B:21:0x003f, B:27:0x0053, B:28:0x005c, B:30:0x0062, B:31:0x0072, B:33:0x00eb, B:35:0x00f1, B:36:0x00ff, B:38:0x0105, B:45:0x0123, B:46:0x0127, B:47:0x0131, B:51:0x013f, B:53:0x0144, B:56:0x014c, B:57:0x0150, B:59:0x0156, B:64:0x017b, B:66:0x0181, B:68:0x0187, B:69:0x0199, B:71:0x019f, B:73:0x01b1, B:74:0x01b9, B:75:0x01c1, B:76:0x01cb, B:78:0x01d5, B:40:0x0111, B:42:0x011b, B:43:0x011f), top: B:86:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01d5 A[Catch: Exception -> 0x01da, TRY_LEAVE, TryCatch #2 {Exception -> 0x01da, blocks: (B:3:0x0005, B:7:0x0012, B:11:0x001e, B:15:0x002c, B:18:0x0034, B:21:0x003f, B:27:0x0053, B:28:0x005c, B:30:0x0062, B:31:0x0072, B:33:0x00eb, B:35:0x00f1, B:36:0x00ff, B:38:0x0105, B:45:0x0123, B:46:0x0127, B:47:0x0131, B:51:0x013f, B:53:0x0144, B:56:0x014c, B:57:0x0150, B:59:0x0156, B:64:0x017b, B:66:0x0181, B:68:0x0187, B:69:0x0199, B:71:0x019f, B:73:0x01b1, B:74:0x01b9, B:75:0x01c1, B:76:0x01cb, B:78:0x01d5, B:40:0x0111, B:42:0x011b, B:43:0x011f), top: B:86:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private JSONObject ms(List<JSONObject> list, List<String> list2, List<String> list3) {
        int i;
        Object obj;
        boolean zN;
        Map<String, Boolean> mapMs;
        List<String> listMs;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = new JSONObject();
        try {
            String strAb = t.ab();
            Object obj2 = "";
            if (TextUtils.isEmpty(strAb)) {
                strAb = "";
            }
            if (TextUtils.isEmpty(strAb)) {
                i = -1;
                obj = "";
            } else {
                obj = strAb;
                i = 1;
            }
            int i2 = 0;
            String strMs = b.ms(false);
            if (TextUtils.isEmpty(strMs)) {
                strMs = "";
            }
            if (i < 0 && !TextUtils.isEmpty(strMs)) {
                i = 4;
                obj = strMs;
            }
            String strC = t.c();
            if (TextUtils.isEmpty(strC)) {
                strC = "";
            }
            String strAh = com.bytedance.sdk.openadsdk.core.c.ms().ah();
            if (!TextUtils.isEmpty(strAh)) {
                obj2 = strAh;
            }
            if (i < 0) {
                i = 3;
                obj = strC;
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
            jSONObject.put("did", t.ah());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(bv.y, Build.VERSION.RELEASE);
            jSONObject.put("device_platform", "android");
            jSONObject.put("device_model", t.re());
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.ch.ub().t());
            jSONObject.put("app_list_type", 1);
            jSONObject.put("sdk_version", g.ah);
            jSONObject.put("device_id_type", i);
            jSONObject.put("imei", strAb);
            jSONObject.put("oaid", strMs);
            jSONObject.put("applog_did", obj2);
            jSONObject.put("android_id", strC);
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray4 = new JSONArray();
                JSONArray jSONArray5 = new JSONArray();
                for (String str : list2) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            if (f.ah(re.getContext(), str)) {
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
                zN = re.xr().n();
                if (zN) {
                    i2 = 1;
                }
                jSONObject.put("scheme_get_type", i2);
                if (list3 != null) {
                    for (String str2 : list3) {
                        if (!TextUtils.isEmpty(str2)) {
                            Uri uri = Uri.parse(str2);
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(uri);
                            f.ms(re.getContext(), intent, true);
                        }
                    }
                }
                mapMs = com.bytedance.sdk.openadsdk.core.jw.yu.ms(259200000L);
                if (mapMs != null) {
                    jSONArray = new JSONArray();
                    jSONArray2 = new JSONArray();
                    for (Map.Entry<String, Boolean> entry : mapMs.entrySet()) {
                        if (entry.getValue().booleanValue()) {
                            jSONArray.put(entry.getKey());
                        } else {
                            jSONArray2.put(entry.getKey());
                        }
                    }
                    jSONObject.put("scheme_success_list", jSONArray);
                    jSONObject.put("scheme_fail_list", jSONArray2);
                }
                listMs = f.ms();
                if (listMs.size() > 0) {
                    jSONObject.put("query_all_package", listMs);
                }
            } else {
                zN = re.xr().n();
                if (zN) {
                    i2 = 1;
                }
                jSONObject.put("scheme_get_type", i2);
                if (list3 != null && !list3.isEmpty() && zN) {
                    while (r1.hasNext()) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                Uri uri2 = Uri.parse(str2);
                                Intent intent2 = new Intent("android.intent.action.VIEW");
                                intent2.setData(uri2);
                                f.ms(re.getContext(), intent2, true);
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                mapMs = com.bytedance.sdk.openadsdk.core.jw.yu.ms(259200000L);
                if (mapMs != null && mapMs.size() > 0) {
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
                listMs = f.ms();
                if (listMs.size() > 0) {
                    jSONObject.put("query_all_package", listMs);
                }
            }
        } catch (Exception unused3) {
        }
        return jSONObject;
    }

    class ms {
        private com.bytedance.sdk.component.d.ms.xr xr;

        ms(Context context) {
            try {
                this.xr = ms(context);
            } catch (Throwable unused) {
            }
        }

        private com.bytedance.sdk.component.d.ms.xr ms(Context context) {
            try {
                return com.bytedance.sdk.openadsdk.core.jw.g.ms("tt_sp_app_list");
            } catch (Exception e) {
                sl.ms(e);
                return null;
            }
        }

        void ms(String str) {
            com.bytedance.sdk.component.d.ms.xr xrVar;
            if (TextUtils.isEmpty(str) || (xrVar = this.xr) == null) {
                return;
            }
            xrVar.ms("old_app_list", str);
        }

        void ms() {
            com.bytedance.sdk.component.d.ms.xr xrVar = this.xr;
            if (xrVar == null) {
                return;
            }
            xrVar.ms("day_update_time", System.currentTimeMillis());
        }

        String xr() {
            com.bytedance.sdk.component.d.ms.xr xrVar = this.xr;
            return xrVar == null ? "" : xrVar.xr("old_app_list", "");
        }

        boolean ah() {
            com.bytedance.sdk.component.d.ms.xr xrVar = this.xr;
            return !f.ms(xrVar != null ? xrVar.xr("day_update_time", 0L) : 0L, System.currentTimeMillis());
        }
    }

    private static class xr {
        static String ms(String str) {
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }
            return new String(bytes);
        }
    }
}
