package com.ss.android.downloadlib.d;

import android.os.Build;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.downloadlib.addownload.xr.c;
import com.ss.android.downloadlib.addownload.xr.ka;
import com.ss.android.downloadlib.addownload.xr.ny;
import com.ss.android.socialbase.appdownloader.ka.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ms {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.d.ms$ms, reason: collision with other inner class name */
    private static class C0537ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ms f4494ms = new ms();
    }

    public static ms ms() {
        return C0537ms.f4494ms;
    }

    private ms() {
    }

    public void ms(long j, int i) {
        ka kaVarKa = c.ms().ka(j);
        if (kaVarKa.i()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("sendClickEvent ModelBox notValid");
            return;
        }
        if (kaVarKa.ah.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = kaVarKa.ah;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strMs = zb.ms(kaVarKa.ah.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.ms() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.ny.c.ah(hi.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e) {
                ab.ms(e);
            }
            ms(clickItemTag, strMs, jSONObject, kaVarKa);
            if (!"click".equals(strMs) || kaVarKa.xr == null) {
                return;
            }
            ah.ms().ms(j, kaVarKa.xr.getLogExtra());
        }
    }

    public void ms(long j, int i, DownloadInfo downloadInfo) {
        String strMs;
        ka kaVarKa = c.ms().ka(j);
        if (kaVarKa.i()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zb.ms(jSONObject, "download_scene", Integer.valueOf(kaVarKa.t()));
        if (i == 1) {
            strMs = zb.ms(kaVarKa.ah.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            strMs = zb.ms(kaVarKa.ah.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.ab.c.ms(downloadInfo, jSONObject);
        } else if (i == 3) {
            strMs = zb.ms(kaVarKa.ah.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.ab.c.xr(downloadInfo, jSONObject);
        } else if (i == 4) {
            strMs = zb.ms(kaVarKa.ah.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
        } else if (i != 5) {
            strMs = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.ab.c.ms(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.ms.xr(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strMs = zb.ms(kaVarKa.ah.getClickInstallLabel(), "click_install");
        }
        ms(null, strMs, jSONObject, 0L, 1, kaVarKa);
    }

    public void xr(long j, int i) {
        ms(j, i, (DownloadInfo) null);
    }

    public void ms(String str, int i, ka kaVar) {
        ms(null, str, null, i, 0, kaVar);
    }

    public void ms(long j, boolean z, int i) {
        ka kaVarKa = c.ms().ka(j);
        if (kaVarKa.i()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (kaVarKa.xr.getQuickAppModel() == null) {
            return;
        }
        if (kaVarKa.xr instanceof AdDownloadModel) {
            ((AdDownloadModel) kaVarKa.xr).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e) {
            ab.ms(e);
        }
        xr(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, kaVarKa);
    }

    public void ms(long j, BaseException baseException) {
        ka kaVarKa = c.ms().ka(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e) {
            ab.ms(e);
        }
        xr("download_failed", jSONObject, kaVarKa);
    }

    public void ms(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.ms.xr xrVarMs = c.ms().ms(downloadInfo);
        if (xrVarMs == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
            xrVarMs.ms(System.currentTimeMillis());
            ms(xrVarMs.ch(), "download_resume", jSONObject, xrVarMs);
            ny.ms().ms(xrVarMs);
        } catch (Throwable th) {
            ab.ms(th);
        }
    }

    public void ms(JSONObject jSONObject, com.ss.android.downloadad.api.ms.xr xrVar) {
        ms(xrVar.ch(), "install_finish", jSONObject, xrVar);
    }

    public void ms(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.ms.xr xrVarMs;
        if (downloadInfo == null || (xrVarMs = c.ms().ms(downloadInfo)) == null || xrVarMs.ah.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.ms.ms(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(xrVarMs.of()));
            jSONObject.putOpt("fail_msg", xrVarMs.p());
            jSONObject.put("download_failed_times", xrVarMs.i());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (xrVarMs.jw() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - xrVarMs.jw());
            }
            if (xrVarMs.le() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - xrVarMs.le());
            }
            int i = 1;
            jSONObject.put("is_update_download", xrVarMs.am() ? 1 : 2);
            jSONObject.put("can_show_notification", d.ms() ? 1 : 2);
            if (!xrVarMs.d.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e) {
            ab.ms(e);
        }
        ms(xrVarMs.ch(), "download_cancel", jSONObject, xrVarMs);
    }

    public void xr(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.ms.xr xrVarMs = c.ms().ms(downloadInfo);
        if (xrVarMs == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (xrVarMs.ah.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.ab.c.ah(downloadInfo, jSONObject);
            com.ss.android.downloadlib.ms.ms(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                xrVarMs.d(baseException.getErrorCode());
                xrVarMs.ms(baseException.getErrorMessage());
            }
            xrVarMs.w();
            jSONObject.put("download_failed_times", xrVarMs.i());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", xrVarMs.d.get() ? 1 : 2);
            com.ss.android.downloadlib.ab.c.ms(xrVarMs, jSONObject);
            if (!xrVarMs.am()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException e) {
            ab.ms(e);
        }
        ms(xrVarMs.ch(), "download_failed", jSONObject, xrVarMs);
        ny.ms().ms(xrVarMs);
    }

    public void ms(String str, com.ss.android.downloadad.api.ms.ms msVar) {
        ms(str, (JSONObject) null, msVar);
    }

    public void ms(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.ms.ms msVarD = c.ms().d(j);
        if (msVarD != null) {
            ms(str, jSONObject, msVarD);
            return;
        }
        ka kaVarKa = c.ms().ka(j);
        if (kaVarKa.i()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("sendUnityEvent ModelBox notValid");
        } else {
            ms(str, jSONObject, kaVarKa);
        }
    }

    public void ms(String str, JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        JSONObject jSONObject2 = new JSONObject();
        zb.ms(jSONObject2, "unity_label", str);
        ms("embeded_ad", "ttdownloader_unity", zb.ms(jSONObject, jSONObject2), msVar);
    }

    public void ms(String str, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        xr(str, new ka(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void ms(String str, long j) {
        com.ss.android.downloadad.api.ms.xr xrVarD = c.ms().d(j);
        if (xrVarD != null) {
            xr(str, xrVarD);
        } else {
            xr(str, c.ms().ka(j));
        }
    }

    public void xr(String str, com.ss.android.downloadad.api.ms.ms msVar) {
        ms((String) null, str, msVar);
    }

    public void xr(String str, JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        ms((String) null, str, jSONObject, msVar);
    }

    public void ms(String str, String str2, com.ss.android.downloadad.api.ms.ms msVar) {
        ms(str, str2, (JSONObject) null, msVar);
    }

    public void ms(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.ms.ms msVar) {
        ms(str, str2, jSONObject, 0L, 0, msVar);
    }

    private void ms(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.downloadad.api.ms.ms msVar) {
        if (msVar == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("onEvent data null");
            return;
        }
        if ((msVar instanceof ka) && ((ka) msVar).i()) {
            com.ss.android.downloadlib.ka.ah.ms().ms("onEvent ModelBox notValid");
            return;
        }
        try {
            com.ss.android.download.api.model.ah.ms msVarAh = new com.ss.android.download.api.model.ah.ms().ms(zb.ms(str, msVar.ch(), "embeded_ad")).xr(str2).xr(msVar.ah()).ms(msVar.xr()).ah(msVar.d());
            if (j <= 0) {
                j = msVar.sl();
            }
            com.ss.android.download.api.model.ah.ms msVarMs = msVarAh.xr(j).d(msVar.ny()).ms(msVar.u()).ms(zb.ms(ms(msVar), jSONObject)).xr(msVar.hi()).ms(msVar.ub());
            if (i <= 0) {
                i = 2;
            }
            ms(msVarMs.ms(i).ms(msVar.zb()).ms());
        } catch (Exception e) {
            com.ss.android.downloadlib.ka.ah.ms().ms(e, "onEvent");
        }
    }

    private JSONObject ms(com.ss.android.downloadad.api.ms.ms msVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            zb.ms(msVar.ab(), jSONObject);
            zb.ms(msVar.ao(), jSONObject);
            jSONObject.putOpt("download_url", msVar.ms());
            jSONObject.putOpt("package_name", msVar.ka());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.c.ka.x());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.c.ka.ny());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(msVar.x()));
            if (msVar.x() == 2) {
                com.ss.android.downloadlib.ab.c.xr(jSONObject, msVar);
            }
            if (com.ss.android.socialbase.appdownloader.c.ka.ao()) {
                com.ss.android.downloadlib.ab.c.ms(jSONObject);
            }
        } catch (Exception e) {
            hi.t().ms(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void ms(com.ss.android.download.api.model.ah ahVar) {
        if (hi.ms() == null) {
            return;
        }
        if (ahVar.zb()) {
            hi.ms().ms(ahVar);
        } else {
            hi.ms().xr(ahVar);
        }
    }
}
