package com.byazt.ko;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.byazt.gc.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy extends s {
    public final Context l;
    public final fs w;

    public cy(Context context, fs fsVar) {
        super(false, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        int i;
        int i2;
        String packageName = this.l.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.w.sh())) {
            jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, packageName);
        } else {
            if (com.byazt.km.cp.qg) {
                com.byazt.km.cp.n("has zijie pkg", null);
            }
            jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.w.sh());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.l.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                com.byazt.km.cp.qg(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.w.v())) {
            jSONObject.put("app_version", this.w.v());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.w.fi())) {
            jSONObject.put("app_version_minor", this.w.fi());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.w.bb() != 0) {
            jSONObject.put("version_code", this.w.bb());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.w.ln() != 0) {
            jSONObject.put("update_version_code", this.w.ln());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.w.lh() != 0) {
            jSONObject.put("manifest_version_code", this.w.lh());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.w.ur())) {
            jSONObject.put("app_name", this.w.ur());
        }
        if (!TextUtils.isEmpty(this.w.j())) {
            jSONObject.put("tweaked_channel", this.w.j());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.l.getString(i2));
        return true;
    }
}
