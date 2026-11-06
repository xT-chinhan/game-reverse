package com.byazt.jh;

import com.byazt.is.s;
import com.byazt.vx.w;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 585, 26})
public class qg {
    public static boolean n(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new n(new com.byazt.kq.n().n(str)).n(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 == 1) {
                i6 = com.byazt.fw.qg.n.n;
            } else {
                if (i2 == 2) {
                    i6 = com.byazt.fw.qg.n.qg;
                } else {
                    i5 = 0;
                }
                String str3 = "rmSo:" + z2 + " rmDex:" + z;
                ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                n(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
                return true;
            }
            i5 = i6;
            String str4 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
            n(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str4);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    if (i2 == 1) {
                        i4 = com.byazt.fw.qg.n.s;
                    } else {
                        i4 = i2 == 2 ? com.byazt.fw.qg.n.q : 0;
                    }
                }
                return false;
            } finally {
                if (i2 != 0) {
                    if (i2 == 1) {
                        i3 = com.byazt.fw.qg.n.s;
                    } else {
                        i3 = i2 == 2 ? com.byazt.fw.qg.n.q : 0;
                    }
                    String string = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(string)));
                    n(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, string);
                }
            }
        }
    }

    private static void n(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", s.n(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", s.n(str));
            jSONObject.putOpt("version_code", s.n(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(s.qg(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + s.n(th));
        } catch (JSONException e) {
            w.n(e);
        }
        com.byazt.fw.qg.n().n(com.byazt.fw.qg.tj, jSONObject, jSONObject3, jSONObject2);
    }
}
