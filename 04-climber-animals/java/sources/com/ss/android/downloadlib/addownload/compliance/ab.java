package com.ss.android.downloadlib.addownload.compliance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ab {
    public static void ms(String str, long j) {
        com.ss.android.downloadlib.addownload.xr.ka kaVarKa = com.ss.android.downloadlib.addownload.xr.c.ms().ka(j);
        if (kaVarKa.i()) {
            return;
        }
        kaVarKa.ah.setRefer(str);
        com.ss.android.downloadlib.d.ms.ms().xr("lp_app_dialog_click", kaVarKa);
    }

    public static void xr(String str, long j) {
        ms(str, null, j);
    }

    public static void ms(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadlib.d.ms.ms().xr(str, jSONObject, com.ss.android.downloadlib.addownload.xr.c.ms().ka(j));
    }

    public static void ms(String str, com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        com.ss.android.downloadlib.d.ms.ms().xr(str, kaVar);
    }

    public static void ms(int i, com.ss.android.downloadlib.addownload.xr.ka kaVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().xr("lp_compliance_error", jSONObject, kaVar);
    }

    public static void ms(int i, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error_code", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().xr("lp_compliance_error", jSONObject, com.ss.android.downloadlib.addownload.xr.c.ms().ka(j));
    }
}
