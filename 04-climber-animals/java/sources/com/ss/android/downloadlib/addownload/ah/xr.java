package com.ss.android.downloadlib.addownload.ah;

import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.downloadlib.addownload.xr.ny;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DownloadInfo f4359ms;

    public xr(DownloadInfo downloadInfo) {
        this.f4359ms = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.ss.android.downloadad.api.ms.xr xrVarMs;
        if (this.f4359ms == null || (xrVarMs = c.ms().ms(this.f4359ms)) == null) {
            return;
        }
        com.ss.android.downloadlib.d.ms.ms().ms("cleanspace_task", xrVarMs);
        long jLongValue = Double.valueOf((com.ss.android.downloadlib.ab.ka.ms(this.f4359ms.getId()) + 1.0d) * this.f4359ms.getTotalBytes()).longValue() - this.f4359ms.getCurBytes();
        long jXr = zb.xr(0L);
        if (hi.zb() != null) {
            hi.zb();
        }
        ah.ms();
        ah.xr();
        if (com.ss.android.downloadlib.ab.ka.ab(xrVarMs.y())) {
            ah.ms(hi.getContext());
        }
        long jXr2 = zb.xr(0L);
        if (jXr2 >= jLongValue) {
            xrVarMs.sl("1");
            ny.ms().ms(xrVarMs);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jXr2 - jXr));
            } catch (JSONException e) {
                ab.ms(e);
            }
            com.ss.android.downloadlib.d.ms.ms().ms("cleanspace_download_after_quite_clean", jSONObject, xrVarMs);
            Downloader.getInstance(hi.getContext()).restart(this.f4359ms.getId());
            return;
        }
        if (hi.zb() != null) {
            xrVarMs.d(false);
            d.ms().ms(xrVarMs.ms(), new ka() { // from class: com.ss.android.downloadlib.addownload.ah.xr.1
            });
            if (hi.zb().ms(this.f4359ms.getId(), this.f4359ms.getUrl(), true, jLongValue)) {
                xrVarMs.ka(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e2) {
            ab.ms(e2);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("cleanspace_window_show", jSONObject2, xrVarMs);
    }
}
