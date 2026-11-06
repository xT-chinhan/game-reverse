package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class xn extends le {
    private final pc ka;

    xn(pc pcVar) {
        super(true, false, false);
        this.ka = pcVar;
    }

    @Override // com.bytedance.embedapplog.le
    protected boolean ms(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesD = this.ka.d();
        String string = sharedPreferencesD.getString("install_id", null);
        String string2 = sharedPreferencesD.getString("device_id", null);
        String string3 = sharedPreferencesD.getString("ssid", null);
        jw.ms(jSONObject, "install_id", string);
        jw.ms(jSONObject, "device_id", string2);
        jw.ms(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesD.getLong(DeepLinkPresetEvent.UMEventParamRegisterTime, 0L);
        if ((jw.xr(string) && jw.xr(string2)) || j2 == 0) {
            j = j2;
        } else {
            sharedPreferencesD.edit().putLong(DeepLinkPresetEvent.UMEventParamRegisterTime, 0L).apply();
        }
        jSONObject.put(DeepLinkPresetEvent.UMEventParamRegisterTime, j);
        return true;
    }
}
