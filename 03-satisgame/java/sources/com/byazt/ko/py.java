package com.byazt.ko;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 866})
public class py extends s {
    public final Context l;
    public final fs w;

    public py(Context context, fs fsVar) {
        super(true, false);
        this.l = context;
        this.w = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException, SecurityException {
        TelephonyManager telephonyManager = (TelephonyManager) this.l.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                rv.n(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                rv.n(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                rv.n(jSONObject, "udid", this.w.dg() ? com.byazt.km.x.n(telephonyManager) : this.w.df());
                return true;
            } catch (Exception e) {
                com.byazt.km.cp.qg(e);
            }
        }
        return false;
    }
}
