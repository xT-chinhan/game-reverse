package com.bytedance.embedapplog;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class qf extends le {
    private final Context ka;

    qf(Context context) {
        super(true, false);
        this.ka = context;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        jw.ms(jSONObject, "sim_region", ((TelephonyManager) this.ka.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
