package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.bv;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class l extends le {
    private final pc c;
    private final Context ka;

    l(Context context, pc pcVar) {
        super(true, false);
        this.ka = context;
        this.c = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.ka.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                jw.ms(jSONObject, bv.P, telephonyManager.getNetworkOperatorName());
                jw.ms(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                jw.ms(jSONObject, "udid", this.c.e() ? bz.ms(telephonyManager) : this.c.m());
                return true;
            } catch (Exception e) {
                oh.xr(e);
            }
        }
        return false;
    }
}
