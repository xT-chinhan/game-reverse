package com.byazt.mf;

import android.os.Build;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.eld.k;
import com.byazt.km.AdDownloadModel;
import com.byazt.lhc.BaseException;
import com.byazt.owr.x;
import com.byazt.shh.aj;
import com.byazt.shh.c;
import com.byazt.shh.uc;
import com.byazt.uk.m;
import com.mar.sdk.MARCode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1493, 37})
public class pr {

    /* JADX INFO: renamed from: com.byazt.mf.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1493, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0135pr {
        public static pr pr = new pr();
    }

    public static pr pr() {
        return C0135pr.pr;
    }

    private pr() {
    }

    public void pr(long j, int i) {
        int i2;
        c cVarC = uc.pr().c(j);
        if (cVarC.rc()) {
            com.byazt.vi.hn.pr().pr("sendClickEvent ModelBox notValid");
            return;
        }
        if (!cVarC.hn.isEnableClickEvent()) {
            return;
        }
        int i3 = 1;
        DownloadEventConfig downloadEventConfig = cVarC.hn;
        String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
        String strPr = m.pr(cVarC.hn.getClickLabel(), "click");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
            if (x.pr()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            jSONObject.putOpt("permission_notification", Integer.valueOf(i2));
            if (!com.byazt.tuy.uc.hn(k.getContext())) {
                i3 = 2;
            }
            jSONObject.putOpt("network_available", Integer.valueOf(i3));
        } catch (JSONException e) {
        }
        pr(clickItemTag, strPr, jSONObject, cVarC);
        if ("click".equals(strPr) && cVarC.hw != null) {
            hn.pr().pr(j, cVarC.hw.getLogExtra());
        }
    }

    public void pr(long j, int i, DownloadInfo downloadInfo) {
        String strPr;
        c cVarC = uc.pr().c(j);
        if (cVarC.rc()) {
            com.byazt.vi.hn.pr().pr("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        m.pr(jSONObject, "download_scene", Integer.valueOf(cVarC.a()));
        switch (i) {
            case 1:
                strPr = m.pr(cVarC.hn.getStorageDenyLabel(), "storage_deny");
                break;
            case 2:
                String strPr2 = m.pr(cVarC.hn.getClickStartLabel(), "click_start");
                com.byazt.uk.uc.pr(downloadInfo, jSONObject);
                strPr = strPr2;
                break;
            case 3:
                String strPr3 = m.pr(cVarC.hn.getClickPauseLabel(), "click_pause");
                com.byazt.uk.uc.hw(downloadInfo, jSONObject);
                strPr = strPr3;
                break;
            case 4:
                String strPr4 = m.pr(cVarC.hn.getClickContinueLabel(), "click_continue");
                com.byazt.uk.uc.hn(downloadInfo, jSONObject);
                strPr = strPr4;
                break;
            case 5:
                if (downloadInfo != null) {
                    try {
                        com.byazt.uk.uc.pr(jSONObject, downloadInfo.getId());
                        com.byazt.cvl.pr.hw(jSONObject, downloadInfo);
                        break;
                    } catch (Throwable th) {
                    }
                }
                strPr = m.pr(cVarC.hn.getClickInstallLabel(), "click_install");
                break;
            default:
                strPr = null;
                break;
        }
        pr(null, strPr, jSONObject, 0L, 1, cVarC);
    }

    public void hw(long j, int i) {
        pr(j, i, (DownloadInfo) null);
    }

    public void pr(String str, int i, c cVar) {
        pr(null, str, null, i, 0, cVar);
    }

    public void pr(long j, boolean z, int i) {
        c cVarC = uc.pr().c(j);
        if (cVarC.rc()) {
            com.byazt.vi.hn.pr().pr("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (cVarC.hw.getQuickAppModel() == null) {
            return;
        }
        if (cVarC.hw instanceof AdDownloadModel) {
            ((AdDownloadModel) cVarC.hw).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e) {
        }
        hw(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, cVarC);
    }

    public void pr(long j, BaseException baseException) {
        c cVarC = uc.pr().c(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e) {
        }
        hw("download_failed", jSONObject, cVarC);
    }

    public void pr(DownloadInfo downloadInfo) {
        com.byazt.tia.hw hwVarPr = uc.pr().pr(downloadInfo);
        if (hwVarPr == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.byazt.uk.uc.hn(downloadInfo, jSONObject);
            hwVarPr.pr(System.currentTimeMillis());
            pr(hwVarPr.vk(), "download_resume", jSONObject, hwVarPr);
            aj.pr().pr(hwVarPr);
        } catch (Throwable th) {
        }
    }

    public void pr(JSONObject jSONObject, com.byazt.tia.hw hwVar) {
        pr(hwVar.vk(), "install_finish", jSONObject, hwVar);
    }

    public void pr(DownloadInfo downloadInfo, BaseException baseException) {
        com.byazt.tia.hw hwVarPr;
        if (downloadInfo == null || (hwVarPr = uc.pr().pr(downloadInfo)) == null || hwVarPr.hn.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.cvl.pr.pr(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(hwVarPr.y()));
            jSONObject.putOpt("fail_msg", hwVarPr.ww());
            jSONObject.put("download_failed_times", hwVarPr.rc());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (hwVarPr.e() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - hwVarPr.e());
            }
            if (hwVarPr.ve() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - hwVarPr.ve());
            }
            int i = 1;
            jSONObject.put("is_update_download", hwVarPr.o() ? 1 : 2);
            jSONObject.put("can_show_notification", x.pr() ? 1 : 2);
            if (!hwVarPr.x.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e) {
        }
        pr(hwVarPr.vk(), "download_cancel", jSONObject, hwVarPr);
    }

    public void hw(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.byazt.tia.hw hwVarPr = uc.pr().pr(downloadInfo);
        if (hwVarPr == null) {
            com.byazt.vi.hn.pr().pr("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (hwVarPr.hn.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.uk.uc.hn(downloadInfo, jSONObject);
            com.byazt.cvl.pr.pr(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                hwVarPr.x(baseException.getErrorCode());
                hwVarPr.pr(baseException.getErrorMessage());
            }
            hwVarPr.z();
            jSONObject.put("download_failed_times", hwVarPr.rc());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", hwVarPr.x.get() ? 1 : 2);
            com.byazt.uk.uc.pr(hwVarPr, jSONObject);
            if (!hwVarPr.o()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException e) {
        }
        pr(hwVarPr.vk(), "download_failed", jSONObject, hwVarPr);
        aj.pr().pr(hwVarPr);
    }

    public void pr(String str, long j) {
        pr(str, (JSONObject) null, j);
    }

    public void pr(String str, com.byazt.tia.pr prVar) {
        pr(str, (JSONObject) null, prVar);
    }

    public void pr(String str, JSONObject jSONObject, long j) {
        com.byazt.tia.pr prVarX = uc.pr().x(j);
        if (prVarX != null) {
            pr(str, jSONObject, prVarX);
            return;
        }
        c cVarC = uc.pr().c(j);
        if (cVarC.rc()) {
            com.byazt.vi.hn.pr().pr("sendUnityEvent ModelBox notValid");
        } else {
            pr(str, jSONObject, cVarC);
        }
    }

    public void pr(String str, JSONObject jSONObject, com.byazt.tia.pr prVar) {
        JSONObject jSONObject2 = new JSONObject();
        m.pr(jSONObject2, "unity_label", str);
        pr(com.byazt.pfl.hw.AD_TAG_FEED, "ttdownloader_unity", m.pr(jSONObject, jSONObject2), prVar);
    }

    public void pr(String str, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        hw(str, new c(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void hw(String str, long j) {
        com.byazt.tia.hw hwVarX = uc.pr().x(j);
        if (hwVarX != null) {
            hw(str, hwVarX);
        } else {
            hw(str, uc.pr().c(j));
        }
    }

    public void hw(String str, com.byazt.tia.pr prVar) {
        pr((String) null, str, prVar);
    }

    public void hw(String str, JSONObject jSONObject, com.byazt.tia.pr prVar) {
        pr((String) null, str, jSONObject, prVar);
    }

    public void pr(String str, String str2, com.byazt.tia.pr prVar) {
        pr(str, str2, (JSONObject) null, prVar);
    }

    public void pr(String str, String str2, JSONObject jSONObject, com.byazt.tia.pr prVar) {
        pr(str, str2, jSONObject, 0L, 0, prVar);
    }

    private void pr(String str, String str2, JSONObject jSONObject, long j, int i, com.byazt.tia.pr prVar) {
        if (prVar == null) {
            com.byazt.vi.hn.pr().pr("onEvent data null");
            return;
        }
        if ((prVar instanceof c) && ((c) prVar).rc()) {
            com.byazt.vi.hn.pr().pr("onEvent ModelBox notValid");
            return;
        }
        try {
            com.byazt.cxa.hn.pr prVarHn = new com.byazt.cxa.hn.pr().pr(m.pr(str, prVar.vk(), com.byazt.pfl.hw.AD_TAG_FEED)).hw(str2).hw(prVar.hn()).pr(prVar.hw()).hn(prVar.x());
            if (j <= 0) {
                j = prVar.k();
            }
            com.byazt.cxa.hn.pr prVarPr = prVarHn.hw(j).x(prVar.aj()).pr(prVar.g()).pr(m.pr(pr(prVar), jSONObject)).hw(prVar.w()).pr(prVar.ho());
            if (i <= 0) {
                i = 2;
            }
            pr(prVarPr.pr(i).pr(prVar.m()).pr());
        } catch (Exception e) {
            com.byazt.vi.hn.pr().pr(e, "onEvent");
        }
    }

    private JSONObject pr(com.byazt.tia.pr prVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            m.pr(prVar.fw(), jSONObject);
            m.pr(prVar.nt(), jSONObject);
            jSONObject.putOpt("download_url", prVar.pr());
            jSONObject.putOpt("package_name", prVar.c());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.byazt.now.c.zo());
            jSONObject.putOpt("rom_version", com.byazt.now.c.aj());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(prVar.zo()));
            if (prVar.zo() == 2) {
                com.byazt.uk.uc.hw(jSONObject, prVar);
            }
            if (com.byazt.now.c.nt()) {
                com.byazt.uk.uc.pr(jSONObject);
            }
        } catch (Exception e) {
            k.a().pr(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void pr(com.byazt.cxa.hn hnVar) {
        if (k.pr() == null) {
            return;
        }
        if (hnVar.m()) {
            k.pr().pr(hnVar);
        } else {
            k.pr().hw(hnVar);
        }
    }
}
