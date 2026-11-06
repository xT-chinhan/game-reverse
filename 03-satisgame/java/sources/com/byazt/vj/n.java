package com.byazt.vj;

import android.os.Build;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.j.q;
import com.byazt.qx.BaseException;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.vl.l;
import com.byazt.vl.rv;
import com.byazt.vl.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.y.AdDownloadModel;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1034, 19})
public class n {

    /* JADX INFO: renamed from: com.byazt.vj.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1034, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0373n {
        public static n n = new n();
    }

    public static n n() {
        return C0373n.n;
    }

    private n() {
    }

    public void n(long j, int i) {
        l lVarL = w.n().l(j);
        if (lVarL.m()) {
            com.byazt.ch.s.n().n("sendClickEvent ModelBox notValid");
            return;
        }
        if (lVarL.s.isEnableClickEvent()) {
            int i2 = 1;
            DownloadEventConfig downloadEventConfig = lVarL.s;
            String clickItemTag = i == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strN = oa.n(lVarL.s.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(q.n() ? 1 : 2));
                if (!com.byazt.ta.w.s(d.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException unused) {
            }
            n(clickItemTag, strN, jSONObject, lVarL);
            if (!"click".equals(strN) || lVarL.qg == null) {
                return;
            }
            s.n().n(j, lVarL.qg.getLogExtra());
        }
    }

    public void n(long j, int i, DownloadInfo downloadInfo) {
        String strN;
        l lVarL = w.n().l(j);
        if (lVarL.m()) {
            com.byazt.ch.s.n().n("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        oa.n(jSONObject, "download_scene", Integer.valueOf(lVarL.a()));
        if (i == 1) {
            strN = oa.n(lVarL.s.getStorageDenyLabel(), "storage_deny");
        } else if (i == 2) {
            strN = oa.n(lVarL.s.getClickStartLabel(), "click_start");
            com.byazt.rz.w.n(downloadInfo, jSONObject);
        } else if (i == 3) {
            strN = oa.n(lVarL.s.getClickPauseLabel(), "click_pause");
            com.byazt.rz.w.qg(downloadInfo, jSONObject);
        } else if (i == 4) {
            strN = oa.n(lVarL.s.getClickContinueLabel(), "click_continue");
            com.byazt.rz.w.s(downloadInfo, jSONObject);
        } else if (i != 5) {
            strN = null;
        } else {
            if (downloadInfo != null) {
                try {
                    com.byazt.rz.w.n(jSONObject, downloadInfo.getId());
                    com.byazt.s.n.qg(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strN = oa.n(lVarL.s.getClickInstallLabel(), "click_install");
        }
        n(null, strN, jSONObject, 0L, 1, lVarL);
    }

    public void qg(long j, int i) {
        n(j, i, (DownloadInfo) null);
    }

    public void n(String str, int i, l lVar) {
        n(null, str, null, i, 0, lVar);
    }

    public void n(long j, boolean z, int i) {
        l lVarL = w.n().l(j);
        if (lVarL.m()) {
            com.byazt.ch.s.n().n("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (lVarL.qg.getQuickAppModel() == null) {
            return;
        }
        if (lVarL.qg instanceof AdDownloadModel) {
            ((AdDownloadModel) lVarL.qg).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException unused) {
        }
        qg(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, lVarL);
    }

    public void n(long j, BaseException baseException) {
        l lVarL = w.n().l(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException unused) {
        }
        qg("download_failed", jSONObject, lVarL);
    }

    public void n(DownloadInfo downloadInfo) {
        com.byazt.h.qg qgVarN = w.n().n(downloadInfo);
        if (qgVarN == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.byazt.rz.w.s(downloadInfo, jSONObject);
            qgVarN.n(System.currentTimeMillis());
            n(qgVarN.tj(), "download_resume", jSONObject, qgVarN);
            rv.n().n(qgVarN);
        } catch (Throwable unused) {
        }
    }

    public void n(JSONObject jSONObject, com.byazt.h.qg qgVar) {
        n(qgVar.tj(), "install_finish", jSONObject, qgVar);
    }

    public void n(DownloadInfo downloadInfo, BaseException baseException) {
        com.byazt.h.qg qgVarN;
        if (downloadInfo == null || (qgVarN = w.n().n(downloadInfo)) == null || qgVarN.s.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.s.n.n(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(qgVarN.lh()));
            jSONObject.putOpt("fail_msg", qgVarN.v());
            jSONObject.put("download_failed_times", qgVarN.m());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (qgVarN.an() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - qgVarN.an());
            }
            if (qgVarN.ur() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - qgVarN.ur());
            }
            int i = 1;
            jSONObject.put("is_update_download", qgVarN.b() ? 1 : 2);
            jSONObject.put("can_show_notification", q.n() ? 1 : 2);
            if (!qgVarN.q.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException unused) {
        }
        n(qgVarN.tj(), "download_cancel", jSONObject, qgVarN);
    }

    public void qg(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.byazt.h.qg qgVarN = w.n().n(downloadInfo);
        if (qgVarN == null) {
            com.byazt.ch.s.n().n("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (qgVarN.s.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.byazt.rz.w.s(downloadInfo, jSONObject);
            com.byazt.s.n.n(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                qgVarN.q(baseException.getErrorCode());
                qgVarN.n(baseException.getErrorMessage());
            }
            qgVarN.hu();
            jSONObject.put("download_failed_times", qgVarN.m());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", qgVarN.q.get() ? 1 : 2);
            com.byazt.rz.w.n(qgVarN, jSONObject);
            if (!qgVarN.b()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException unused) {
        }
        n(qgVarN.tj(), "download_failed", jSONObject, qgVarN);
        rv.n().n(qgVarN);
    }

    public void n(String str, long j) {
        n(str, (JSONObject) null, j);
    }

    public void n(String str, com.byazt.h.n nVar) {
        n(str, (JSONObject) null, nVar);
    }

    public void n(String str, JSONObject jSONObject, long j) {
        com.byazt.h.n nVarQ = w.n().q(j);
        if (nVarQ != null) {
            n(str, jSONObject, nVarQ);
            return;
        }
        l lVarL = w.n().l(j);
        if (lVarL.m()) {
            com.byazt.ch.s.n().n("sendUnityEvent ModelBox notValid");
        } else {
            n(str, jSONObject, lVarL);
        }
    }

    public void n(String str, JSONObject jSONObject, com.byazt.h.n nVar) {
        JSONObject jSONObject2 = new JSONObject();
        oa.n(jSONObject2, "unity_label", str);
        n(com.byazt.wg.qg.AD_TAG_FEED, "ttdownloader_unity", oa.n(jSONObject, jSONObject2), nVar);
    }

    public void n(String str, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        qg(str, new l(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void qg(String str, long j) {
        com.byazt.h.qg qgVarQ = w.n().q(j);
        if (qgVarQ != null) {
            qg(str, qgVarQ);
        } else {
            qg(str, w.n().l(j));
        }
    }

    public void qg(String str, com.byazt.h.n nVar) {
        n((String) null, str, nVar);
    }

    public void qg(String str, JSONObject jSONObject, com.byazt.h.n nVar) {
        n((String) null, str, jSONObject, nVar);
    }

    public void n(String str, String str2, com.byazt.h.n nVar) {
        n(str, str2, (JSONObject) null, nVar);
    }

    public void n(String str, String str2, JSONObject jSONObject, com.byazt.h.n nVar) {
        n(str, str2, jSONObject, 0L, 0, nVar);
    }

    private void n(String str, String str2, JSONObject jSONObject, long j, int i, com.byazt.h.n nVar) {
        if (nVar == null) {
            com.byazt.ch.s.n().n("onEvent data null");
            return;
        }
        if ((nVar instanceof l) && ((l) nVar).m()) {
            com.byazt.ch.s.n().n("onEvent ModelBox notValid");
            return;
        }
        try {
            com.byazt.os.s.n nVarS = new com.byazt.os.s.n().n(oa.n(str, nVar.tj(), com.byazt.wg.qg.AD_TAG_FEED)).qg(str2).qg(nVar.s()).n(nVar.qg()).s(nVar.q());
            if (j <= 0) {
                j = nVar.d();
            }
            com.byazt.os.s.n nVarN = nVarS.qg(j).q(nVar.rv()).n(nVar.sz()).n(oa.n(n(nVar), jSONObject)).qg(nVar.cp()).n(nVar.k());
            if (i <= 0) {
                i = 2;
            }
            n(nVarN.n(i).n(nVar.oa()).n());
        } catch (Exception e) {
            com.byazt.ch.s.n().n(e, "onEvent");
        }
    }

    private JSONObject n(com.byazt.h.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            oa.n(nVar.x(), jSONObject);
            oa.n(nVar.cy(), jSONObject);
            jSONObject.putOpt(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, nVar.n());
            jSONObject.putOpt("package_name", nVar.l());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.byazt.bk.l.fs());
            jSONObject.putOpt("rom_version", com.byazt.bk.l.rv());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(nVar.fs()));
            if (nVar.fs() == 2) {
                com.byazt.rz.w.qg(jSONObject, nVar);
            }
            if (com.byazt.bk.l.cy()) {
                com.byazt.rz.w.n(jSONObject);
            }
        } catch (Exception e) {
            d.a().n(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void n(com.byazt.os.s sVar) {
        if (d.n() == null) {
            return;
        }
        if (sVar.oa()) {
            d.n().n(sVar);
        } else {
            d.n().qg(sVar);
        }
    }
}
