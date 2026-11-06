package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c implements ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ms.d f4406ms;

    public static com.ss.android.downloadlib.addownload.ms.d ms() {
        return f4406ms;
    }

    @Override // com.ss.android.downloadlib.addownload.d.ny
    public boolean ms(final com.ss.android.downloadad.api.ms.xr xrVar, int i, final x xVar) {
        DownloadInfo downloadInfoXr;
        if (xrVar == null || xrVar.zf() || !ms(xrVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(xrVar.vy())) {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms(com.ss.android.downloadlib.addownload.hi.getContext()).ms(xrVar.vy(), null, true);
        } else {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms(com.ss.android.downloadlib.addownload.hi.getContext()).xr(xrVar.ms());
        }
        if (downloadInfoXr == null) {
            return false;
        }
        long curBytes = downloadInfoXr.getCurBytes();
        long totalBytes = downloadInfoXr.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int iMs = com.ss.android.downloadlib.addownload.ch.ms(downloadInfoXr.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iMs > ms(xrVar.y())) {
                f4406ms = new com.ss.android.downloadlib.addownload.ms.d() { // from class: com.ss.android.downloadlib.addownload.d.c.1
                    @Override // com.ss.android.downloadlib.addownload.ms.d
                    public void ms() {
                        com.ss.android.downloadlib.addownload.ms.d unused = c.f4406ms = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e);
                        }
                        com.ss.android.downloadlib.d.ms.ms().ms("pause_optimise", jSONObject, xrVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.ms.d
                    public void xr() {
                        com.ss.android.downloadlib.addownload.ms.d unused = c.f4406ms = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", TrackAction.CANCEL);
                        } catch (JSONException e) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e);
                        }
                        com.ss.android.downloadlib.d.ms.ms().ms("pause_optimise", jSONObject, xrVar);
                        xVar.ms(xrVar);
                    }
                };
                TTDelegateActivity.xr(xrVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iMs)), "继续", "暂停");
                xrVar.ub(true);
                return true;
            }
        }
        return false;
    }

    private int ms(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("pause_optimise_download_percent", 50);
    }

    private boolean ms(com.ss.android.downloadad.api.ms.ms msVar) {
        return com.ss.android.downloadlib.ab.ka.ms(msVar).ms("pause_optimise_download_percent_switch", 0) == 1 && msVar.h();
    }
}
