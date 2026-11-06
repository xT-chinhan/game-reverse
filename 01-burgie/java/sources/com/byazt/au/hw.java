package com.byazt.au;

import com.byazt.dea.uc;
import com.byazt.wp.hn;
import com.bytedance.pangle.log.ZeusLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 479, 13})
public class hw {
    public static boolean pr(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new pr(new com.byazt.rm.pr().pr(str)).pr(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 == 1) {
                i5 = com.byazt.yk.hw.pr.pr;
            } else {
                i5 = i2 == 2 ? com.byazt.yk.hw.pr.hw : 0;
            }
            String str3 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
            pr(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    if (i2 == 1) {
                        i4 = com.byazt.yk.hw.pr.hn;
                    } else {
                        i4 = i2 == 2 ? com.byazt.yk.hw.pr.x : 0;
                    }
                }
                return false;
            } finally {
                if (i2 != 0) {
                    if (i2 != 1) {
                        i3 = i2 == 2 ? com.byazt.yk.hw.pr.x : 0;
                    } else {
                        i3 = com.byazt.yk.hw.pr.hn;
                    }
                    String string = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(string)));
                    pr(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, string);
                }
            }
        }
    }

    private static void pr(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", hn.pr(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", hn.pr(str));
            jSONObject.putOpt("version_code", hn.pr(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(hn.hw(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + hn.pr(th));
        } catch (JSONException e) {
            uc.pr(e);
        }
        com.byazt.yk.hw.pr().pr(com.byazt.yk.hw.vk, jSONObject, jSONObject3, jSONObject2);
    }
}
