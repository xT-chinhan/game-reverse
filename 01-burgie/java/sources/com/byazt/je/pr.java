package com.byazt.je;

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
import com.byazt.ly.uc;
import com.byazt.mg.hw;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2024, 37})
public class pr {
    public static pr pr;
    public long hw = 0;

    public static pr pr() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr prVar = new pr();
                    pr = prVar;
                    prVar.hw = 0L;
                }
            }
        }
        return pr;
    }

    private boolean hw() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean hn() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.hw = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.hw >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return hw();
        }
        if (i != 0 || this.hw < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return hw();
    }

    public synchronized JSONObject pr(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strHw = hw(context);
            if (!TextUtils.isEmpty(strHw) && hn()) {
                File file = new File(strHw);
                if (file.exists()) {
                    jSONObject = pr(file, context, str);
                }
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
        }
    }

    @DungeonFlag
    private JSONObject pr(File file, Context context, String str) {
        JSONObject jSONObjectPr = uc.pr(file);
        File filePr = hw.pr(context);
        if (filePr != null) {
            uc.pr(jSONObjectPr, "files", pr(!TextUtils.isEmpty(str) ? hw.pr(context).getParent() : hw.pr(context).getPath()), false);
            File parentFile = filePr.getParentFile();
            if (parentFile != null) {
                List<String> listPr = pr((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/shared_prefs");
                List<String> listPr2 = pr((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/databases");
                uc.pr(jSONObjectPr, "prefs", listPr, false);
                uc.pr(jSONObjectPr, "databases", listPr2, false);
            }
        }
        try {
            JSONObject jSONObjectPr2 = pr(context);
            if (jSONObjectPr2 != null && jSONObjectPr2.length() > 0) {
                jSONObjectPr.put("manifest", jSONObjectPr2);
            }
            jSONObjectPr.put("rt", this.hw);
            jSONObjectPr.put("path", str);
        } catch (JSONException e) {
        }
        return jSONObjectPr;
    }

    private List<String> pr(String str) {
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

    private JSONObject pr(Context context) {
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
        } catch (Throwable th) {
            return null;
        }
    }

    private String hw(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        return packageCodePath;
    }
}
