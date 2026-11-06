package com.bytedance.sdk.component.panglearmor.ms;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.ms.xr.c;
import com.bytedance.sdk.openadsdk.api.plugin.xr;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ms f1311ms;
    private long xr = 0;

    public static ms ms() {
        if (f1311ms == null) {
            synchronized (ms.class) {
                if (f1311ms == null) {
                    ms msVar = new ms();
                    f1311ms = msVar;
                    msVar.xr = 0L;
                }
            }
        }
        return f1311ms;
    }

    private boolean xr() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean ah() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.xr = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.xr >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return xr();
        }
        if (i != 0 || this.xr < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return xr();
    }

    public synchronized JSONObject ms(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strXr = xr(context);
            if (!TextUtils.isEmpty(strXr) && ah()) {
                File file = new File(strXr);
                if (file.exists()) {
                    jSONObject = ms(file, context, str);
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    private JSONObject ms(File file, Context context, String str) {
        JSONObject jSONObjectMs = c.ms(file);
        File fileMs = xr.ms(context);
        if (fileMs != null) {
            c.ms(jSONObjectMs, "files", ms(!TextUtils.isEmpty(str) ? xr.ms(context).getParent() : xr.ms(context).getPath()), false);
            File parentFile = fileMs.getParentFile();
            if (parentFile != null) {
                List<String> listMs = ms((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/shared_prefs");
                List<String> listMs2 = ms((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/databases");
                c.ms(jSONObjectMs, "prefs", listMs, false);
                c.ms(jSONObjectMs, "databases", listMs2, false);
            }
        }
        try {
            JSONObject jSONObjectMs2 = ms(context);
            if (jSONObjectMs2 != null && jSONObjectMs2.length() > 0) {
                jSONObjectMs.put("manifest", jSONObjectMs2);
            }
            jSONObjectMs.put("rt", this.xr);
            jSONObjectMs.put("path", str);
        } catch (JSONException unused) {
        }
        return jSONObjectMs;
    }

    private List<String> ms(String str) {
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

    private JSONObject ms(Context context) {
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
                jSONObject.put(TTDownloadField.TT_LABEL, packageManager.getApplicationLabel(applicationInfo));
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

    private String xr(Context context) {
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
