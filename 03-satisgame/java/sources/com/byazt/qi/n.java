package com.byazt.qi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 19})
public class n {
    public Context n;
    public com.byazt.qf.l qg;
    public Map<String, Object> s;

    public n(Context context, com.byazt.qf.l lVar) {
        this.n = context;
        this.qg = lVar;
    }

    public Map<String, Object> n() {
        Map<String, Object> mapN = this.qg.n();
        if (mapN == null) {
            mapN = new HashMap<>(4);
        }
        if (n(mapN)) {
            try {
                PackageInfo packageInfo = this.n.getPackageManager().getPackageInfo(this.n.getPackageName(), 128);
                mapN.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapN.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapN.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapN.get("version_code");
                    }
                    mapN.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapN.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.byazt.yw.n.l(this.n));
                mapN.put("version_code", Integer.valueOf(com.byazt.yw.n.w(this.n)));
                if (mapN.get("update_version_code") == null) {
                    mapN.put("update_version_code", mapN.get("version_code"));
                }
            }
        }
        return mapN;
    }

    public Map<String, Object> qg() {
        if (this.s == null) {
            this.s = this.qg.x();
        }
        return this.s;
    }

    public static boolean n(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public com.byazt.qf.l s() {
        return this.qg;
    }

    public String q() {
        return com.byazt.yw.n.q(this.n);
    }

    public String l() {
        return this.qg.qg();
    }
}
