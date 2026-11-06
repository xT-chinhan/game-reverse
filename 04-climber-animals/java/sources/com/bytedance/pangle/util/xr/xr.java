package com.bytedance.pangle.util.xr;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.api.ab;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static boolean ms(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new ms(new com.bytedance.pangle.util.xr.ms.ms().ms(str)).ms(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 == 1) {
                i6 = com.bytedance.pangle.d.xr.ms.f637ms;
            } else {
                if (i2 == 2) {
                    i6 = com.bytedance.pangle.d.xr.ms.xr;
                } else {
                    i5 = 0;
                }
                String str3 = "rmSo:" + z2 + " rmDex:" + z;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                ms(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
                return true;
            }
            i5 = i6;
            String str4 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
            ms(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str4);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    if (i2 == 1) {
                        i4 = com.bytedance.pangle.d.xr.ms.ah;
                    } else {
                        i4 = i2 == 2 ? com.bytedance.pangle.d.xr.ms.d : 0;
                    }
                }
                return false;
            } finally {
                if (i2 != 0) {
                    if (i2 == 1) {
                        i3 = com.bytedance.pangle.d.xr.ms.ah;
                    } else {
                        i3 = i2 == 2 ? com.bytedance.pangle.d.xr.ms.d : 0;
                    }
                    String string = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(string)));
                    ms(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, string);
                }
            }
        }
    }

    private static void ms(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(f.z, com.bytedance.pangle.log.xr.ms(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.xr.ms(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.xr.ms(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.xr.xr(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + com.bytedance.pangle.log.xr.ms(th));
        } catch (JSONException e) {
            ab.ms(e);
        }
        com.bytedance.pangle.d.xr.ms().ms(com.bytedance.pangle.d.xr.ch, jSONObject, jSONObject3, jSONObject2);
    }
}
