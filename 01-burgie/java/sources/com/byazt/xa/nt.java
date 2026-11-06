package com.byazt.xa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 74})
public class nt extends hn {
    public final Context c;
    public final zo uc;

    public nt(Context context, zo zoVar) {
        super(false, false);
        this.c = context;
        this.uc = zoVar;
    }

    @Override // com.byazt.xa.hn
    public boolean pr(JSONObject jSONObject) throws JSONException {
        int i;
        int i2;
        String packageName = this.c.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.uc.r())) {
            jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, packageName);
        } else {
            if (com.byazt.ec.w.hw) {
                com.byazt.ec.w.pr("has zijie pkg", null);
            }
            jSONObject.put(AbsServerManager.PACKAGE_QUERY_BINDER, this.uc.r());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.c.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable th) {
        }
        if (packageInfo == null) {
            i = 0;
        } else {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th2) {
                com.byazt.ec.w.hw(th2);
                return false;
            }
        }
        if (!TextUtils.isEmpty(this.uc.ww())) {
            jSONObject.put("app_version", this.uc.ww());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.uc.er())) {
            jSONObject.put("app_version_minor", this.uc.er());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.uc.gz() != 0) {
            jSONObject.put("version_code", this.uc.gz());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.uc.nl() != 0) {
            jSONObject.put("update_version_code", this.uc.nl());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.uc.y() != 0) {
            jSONObject.put("manifest_version_code", this.uc.y());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.uc.ve())) {
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, this.uc.ve());
        }
        if (!TextUtils.isEmpty(this.uc.n())) {
            jSONObject.put("tweaked_channel", this.uc.n());
        }
        if (packageInfo != null && packageInfo.applicationInfo != null && (i2 = packageInfo.applicationInfo.labelRes) > 0) {
            jSONObject.put(an.s, this.c.getString(i2));
            return true;
        }
        return true;
    }
}
