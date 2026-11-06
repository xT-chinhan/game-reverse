package com.ss.android.downloadlib.addownload;

import com.ss.android.socialbase.downloader.downloader.qv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class zb implements qv {
    @Override // com.ss.android.socialbase.downloader.downloader.qv
    public void ms(DownloadInfo downloadInfo, int i, int i2) {
        com.ss.android.downloadad.api.ms.xr xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reserve_wifi_source", Integer.valueOf(i2));
            jSONObject.putOpt("reserve_wifi_status", Integer.valueOf(i));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("pause_reserve_wifi", jSONObject, xrVarMs);
    }
}
