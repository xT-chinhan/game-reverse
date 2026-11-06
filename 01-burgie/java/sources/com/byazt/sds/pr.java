package com.byazt.sds;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, 37})
public class pr {
    public Map<String, Object> hn;
    public com.byazt.vlj.c hw;
    public Context pr;

    public pr(Context context, com.byazt.vlj.c cVar) {
        this.pr = context;
        this.hw = cVar;
    }

    public Map<String, Object> pr() {
        Map<String, Object> mapPr = this.hw.pr();
        if (mapPr == null) {
            mapPr = new HashMap<>(4);
        }
        if (pr(mapPr)) {
            try {
                PackageInfo packageInfo = this.pr.getPackageManager().getPackageInfo(this.pr.getPackageName(), 128);
                mapPr.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapPr.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapPr.get("update_version_code") == null) {
                    Object obj = null;
                    if (packageInfo.applicationInfo.metaData != null) {
                        obj = packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE");
                    }
                    if (obj == null) {
                        obj = mapPr.get("version_code");
                    }
                    mapPr.put("update_version_code", obj);
                }
            } catch (Throwable th) {
                mapPr.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.byazt.wf.pr.c(this.pr));
                mapPr.put("version_code", Integer.valueOf(com.byazt.wf.pr.uc(this.pr)));
                if (mapPr.get("update_version_code") == null) {
                    mapPr.put("update_version_code", mapPr.get("version_code"));
                }
            }
        }
        return mapPr;
    }

    public Map<String, Object> hw() {
        if (this.hn == null) {
            this.hn = this.hw.fw();
        }
        return this.hn;
    }

    public static boolean pr(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public com.byazt.vlj.c hn() {
        return this.hw;
    }

    public String x() {
        return com.byazt.wf.pr.x(this.pr);
    }

    public String c() {
        return this.hw.hw();
    }
}
