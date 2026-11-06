package com.bytedance.ms.xr.ka;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private Map<String, Object> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f572ms;
    private com.bytedance.ms.xr.ka xr;

    public ms(Context context, com.bytedance.ms.xr.ka kaVar) {
        this.f572ms = context;
        this.xr = kaVar;
    }

    public Map<String, Object> ms() {
        Map<String, Object> mapMs = this.xr.ms();
        if (mapMs == null) {
            mapMs = new HashMap<>(4);
        }
        if (ms(mapMs)) {
            try {
                PackageInfo packageInfo = this.f572ms.getPackageManager().getPackageInfo(this.f572ms.getPackageName(), 128);
                mapMs.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapMs.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapMs.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapMs.get("version_code");
                    }
                    mapMs.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapMs.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.bytedance.ms.xr.x.ms.ka(this.f572ms));
                mapMs.put("version_code", Integer.valueOf(com.bytedance.ms.xr.x.ms.c(this.f572ms)));
                if (mapMs.get("update_version_code") == null) {
                    mapMs.put("update_version_code", mapMs.get("version_code"));
                }
            }
        }
        return mapMs;
    }

    public Map<String, Object> xr() {
        if (this.ah == null) {
            this.ah = this.xr.ab();
        }
        return this.ah;
    }

    public static boolean ms(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public com.bytedance.ms.xr.ka ah() {
        return this.xr;
    }

    public String d() {
        return com.bytedance.ms.xr.x.ms.d(this.f572ms);
    }

    public String ka() {
        return this.xr.xr();
    }
}
