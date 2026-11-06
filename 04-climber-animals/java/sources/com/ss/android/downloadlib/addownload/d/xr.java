package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class xr implements ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ms.d f4412ms;
    private static com.ss.android.downloadlib.addownload.ms.ah xr;

    public static com.ss.android.downloadlib.addownload.ms.d ms() {
        return f4412ms;
    }

    public static com.ss.android.downloadlib.addownload.ms.ah xr() {
        return xr;
    }

    public static void ms(com.ss.android.downloadlib.addownload.ms.ah ahVar) {
        xr = ahVar;
    }

    @Override // com.ss.android.downloadlib.addownload.d.ab
    public boolean ms(final com.ss.android.downloadad.api.ms.xr xrVar, int i, final x xVar, final com.ss.android.downloadlib.addownload.ms.ah ahVar) {
        DownloadInfo downloadInfoXr;
        if (xrVar == null || !ms(xrVar)) {
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
        long jMs = com.ss.android.downloadlib.addownload.ch.ms(downloadInfoXr.getId(), downloadInfoXr.getCurBytes(), downloadInfoXr.getTotalBytes());
        long totalBytes = downloadInfoXr.getTotalBytes();
        if (jMs >= 0 && totalBytes > 0) {
            if (totalBytes <= ms(xrVar.y())) {
                final int i2 = (int) (jMs / BaseConstants.MB_VALUE);
                f4412ms = new com.ss.android.downloadlib.addownload.ms.d() { // from class: com.ss.android.downloadlib.addownload.d.xr.1
                    @Override // com.ss.android.downloadlib.addownload.ms.d
                    public void ms() {
                        com.ss.android.downloadlib.addownload.ms.d unused = xr.f4412ms = null;
                        xr.this.ms(i2, i2, xrVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.ss.android.downloadlib.addownload.ms.d
                    public void xr() {
                        com.ss.android.downloadlib.addownload.ms.d unused = xr.f4412ms = null;
                        xr.this.ms(i2, i2, xrVar, "apk_size_cancel", TrackAction.CANCEL);
                        xVar.ms(xrVar);
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", zb.ms(totalBytes - jMs));
                if (ahVar != null) {
                    ms(new com.ss.android.downloadlib.addownload.ms.ah() { // from class: com.ss.android.downloadlib.addownload.d.xr.2
                        @Override // com.ss.android.downloadlib.addownload.ms.ah
                        public void delete() {
                            com.ss.android.downloadlib.addownload.ms.d unused = xr.f4412ms = null;
                            xr.this.ms(i2, i2, xrVar, "apk_size_cancel", "delete");
                            ahVar.delete();
                        }
                    });
                }
                TTDelegateActivity.ms(xrVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int ms(int i) {
        return com.ss.android.socialbase.downloader.ab.ms.ms(i).ms("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean ms(com.ss.android.downloadad.api.ms.ms msVar) {
        return com.ss.android.downloadlib.ab.ka.ms(msVar).ms("cancel_pause_optimise_apk_retain_switch", 0) == 1 && msVar.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, int i2, com.ss.android.downloadad.api.ms.xr xrVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.ss.android.downloadlib.d.ms.ms().ms("pause_cancel_optimise", jSONObject, xrVar);
    }
}
