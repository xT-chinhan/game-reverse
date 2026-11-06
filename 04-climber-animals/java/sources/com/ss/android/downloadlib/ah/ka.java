package com.ss.android.downloadlib.ah;

import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka implements com.ss.android.socialbase.downloader.d.ah {
    @Override // com.ss.android.socialbase.downloader.d.ah
    public void ms(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = zb.ms(jSONObject);
            com.ss.android.downloadlib.ms.ms(jSONObject, downloadInfo);
            zb.ms(jSONObject, "model_id", Long.valueOf(xrVarMs.xr()));
        }
        com.ss.android.downloadlib.d.ms.ms().xr(str, jSONObject, xrVarMs);
    }

    @Override // com.ss.android.socialbase.downloader.d.ah
    public void xr(int i, String str, JSONObject jSONObject) {
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        DownloadInfo downloadInfo = Downloader.getInstance(hi.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (xrVarMs = com.ss.android.downloadlib.addownload.xr.c.ms().ms(downloadInfo)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.ms.ms().ms(str, jSONObject, xrVarMs);
    }
}
