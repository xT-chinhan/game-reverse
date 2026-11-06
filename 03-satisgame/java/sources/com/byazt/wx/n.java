package com.byazt.wx;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.byakv.z.SoftDecTool;
import com.byazt.iip.w;
import com.byazt.qyu.qg;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2425, 19})
public class n {
    public static n n;
    public long qg = 0;

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n nVar = new n();
                    n = nVar;
                    nVar.qg = 0L;
                }
            }
        }
        return n;
    }

    private boolean qg() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean s() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.qg = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.qg >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return qg();
        }
        if (i != 0 || this.qg < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return qg();
    }

    public synchronized JSONObject n(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strQg = qg(context);
            if (!TextUtils.isEmpty(strQg) && s()) {
                File file = new File(strQg);
                if (file.exists()) {
                    jSONObject = n(file, context, str);
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    private JSONObject n(File file, Context context, String str) {
        JSONObject jSONObjectN = w.n(file);
        File fileN = qg.n(context);
        if (fileN != null) {
            w.n(jSONObjectN, "files", n(!TextUtils.isEmpty(str) ? qg.n(context).getParent() : qg.n(context).getPath()), false);
            File parentFile = fileN.getParentFile();
            if (parentFile != null) {
                List<String> listN = n((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/shared_prefs");
                List<String> listN2 = n((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/databases");
                w.n(jSONObjectN, "prefs", listN, false);
                w.n(jSONObjectN, "databases", listN2, false);
            }
        }
        try {
            JSONObject jSONObjectN2 = n(context);
            if (jSONObjectN2 != null && jSONObjectN2.length() > 0) {
                jSONObjectN.put("manifest", jSONObjectN2);
            }
            jSONObjectN.put("rt", this.qg);
            jSONObjectN.put("path", str);
        } catch (JSONException unused) {
        }
        return jSONObjectN;
    }

    private List<String> n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject n(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String qg(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }
}
