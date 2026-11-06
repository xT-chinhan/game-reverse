package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class eg extends le {
    private final pc c;
    private final Context ka;

    eg(Context context, pc pcVar) {
        super(false, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        int i;
        int i2;
        String packageName = this.ka.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.c.xn())) {
            jSONObject.put("package", packageName);
        } else {
            if (oh.xr) {
                oh.ms("has zijie pkg", null);
            }
            jSONObject.put("package", this.c.xn());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.ka.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                oh.xr(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.c.p())) {
            jSONObject.put("app_version", this.c.p());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.c.az())) {
            jSONObject.put("app_version_minor", this.c.az());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.c.cv() != 0) {
            jSONObject.put("version_code", this.c.cv());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.c.g() != 0) {
            jSONObject.put("update_version_code", this.c.g());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.c.of() != 0) {
            jSONObject.put("manifest_version_code", this.c.of());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.c.le())) {
            jSONObject.put("app_name", this.c.le());
        }
        if (!TextUtils.isEmpty(this.c.pc())) {
            jSONObject.put("tweaked_channel", this.c.pc());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put(bv.s, this.ka.getString(i2));
        return true;
    }
}
