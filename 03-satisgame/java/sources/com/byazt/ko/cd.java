package com.byazt.ko;

import android.content.SharedPreferences;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 86})
public class cd extends s {
    public final fs l;

    public cd(fs fsVar) {
        super(true, false, false);
        this.l = fsVar;
    }

    @Override // com.byazt.ko.s
    public boolean n(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesL = this.l.l();
        String string = sharedPreferencesL.getString("install_id", null);
        String string2 = sharedPreferencesL.getString(TapEventParamConstants.PARAM_DEVICE_ID, null);
        String string3 = sharedPreferencesL.getString("ssid", null);
        rv.n(jSONObject, "install_id", string);
        rv.n(jSONObject, TapEventParamConstants.PARAM_DEVICE_ID, string2);
        rv.n(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesL.getLong("register_time", 0L);
        if ((rv.qg(string) && rv.qg(string2)) || j2 == 0) {
            j = j2;
        } else {
            sharedPreferencesL.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
