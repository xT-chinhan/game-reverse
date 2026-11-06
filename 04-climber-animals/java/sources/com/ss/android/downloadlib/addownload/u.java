package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.qv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ms.d f4437ms;
    private static com.ss.android.downloadlib.addownload.ms.ah xr;

    public static boolean ms(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static com.ss.android.downloadlib.addownload.ms.d ms() {
        return f4437ms;
    }

    public static void ms(com.ss.android.downloadlib.addownload.ms.d dVar) {
        f4437ms = dVar;
    }

    public static com.ss.android.downloadlib.addownload.ms.ah xr() {
        return xr;
    }

    public static void ms(com.ss.android.downloadlib.addownload.ms.ah ahVar) {
        xr = ahVar;
    }

    public static boolean ms(final com.ss.android.downloadad.api.ms.xr xrVar, DownloadInfo downloadInfo, int i, final com.ss.android.downloadlib.addownload.d.x xVar, final boolean z, final com.ss.android.downloadlib.addownload.ms.ah ahVar) {
        boolean zXr;
        if (xrVar == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.ka.ah.ms().ms("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            zXr = com.ss.android.downloadlib.ab.ka.ah((com.ss.android.downloadad.api.ms.ms) xrVar);
        } else {
            zXr = com.ss.android.downloadlib.ab.ka.xr((com.ss.android.downloadad.api.ms.ms) xrVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zXr ? 1 : 0));
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        if (z) {
            com.ss.android.downloadlib.d.ms.ms().ms("cancel_pause_reserve_wifi_switch_status", jSONObject, xrVar);
        } else {
            com.ss.android.downloadlib.d.ms.ms().ms("pause_reserve_wifi_switch_status", jSONObject, xrVar);
        }
        if (!zXr || !ms(i) || com.ss.android.socialbase.downloader.ny.c.xr(hi.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        ms(new com.ss.android.downloadlib.addownload.ms.d() { // from class: com.ss.android.downloadlib.addownload.u.1
            @Override // com.ss.android.downloadlib.addownload.ms.d
            public void ms() {
                u.ms((com.ss.android.downloadlib.addownload.ms.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(hi.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    qv.ms().ms(downloadInfo2);
                    if (z) {
                        com.ss.android.downloadlib.d.ms.ms().ms("cancel_pause_reserve_wifi_confirm", xrVar);
                    } else {
                        com.ss.android.downloadlib.d.ms.ms().xr("pause_reserve_wifi_confirm", xrVar);
                    }
                }
                xVar.ms(xrVar);
            }

            @Override // com.ss.android.downloadlib.addownload.ms.d
            public void xr() {
                u.ms((com.ss.android.downloadlib.addownload.ms.d) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(hi.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.ss.android.downloadlib.d.ms.ms().ms("cancel_pause_reserve_wifi_cancel", xrVar);
                } else {
                    com.ss.android.downloadlib.d.ms.ms().xr("pause_reserve_wifi_cancel", xrVar);
                }
                xVar.ms(xrVar);
            }
        });
        if (z && ahVar != null) {
            ms(new com.ss.android.downloadlib.addownload.ms.ah() { // from class: com.ss.android.downloadlib.addownload.u.2
                @Override // com.ss.android.downloadlib.addownload.ms.ah
                public void delete() {
                    com.ss.android.downloadlib.d.ms.ms().ms("cancel_pause_reserve_wifi_delete", xrVar);
                    ahVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.ms(xrVar, "删除");
        } else {
            TTDelegateActivity.xr(xrVar);
        }
        return true;
    }
}
