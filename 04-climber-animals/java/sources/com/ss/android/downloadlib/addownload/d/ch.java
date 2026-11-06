package com.ss.android.downloadlib.addownload.d;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ch implements ny {
    @Override // com.ss.android.downloadlib.addownload.d.ny
    public boolean ms(com.ss.android.downloadad.api.ms.xr xrVar, int i, x xVar) {
        if (xrVar == null || !xr(xrVar.y())) {
            return false;
        }
        if (System.currentTimeMillis() - xrVar.qf() > ms(xrVar.y())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("pause_optimise", jSONObject, xrVar);
        return true;
    }

    private long ms(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("pause_optimise_mistake_click_interval", 300);
    }

    private boolean xr(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }
}
