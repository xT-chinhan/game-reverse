package com.byazt.ht;

import com.byazt.je.cp;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.vl.rv;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.google.android.gms.common.internal.ImagesContract;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 5})
public class q implements com.byazt.z.fs, cp {
    @Override // com.byazt.z.fs
    public void n(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        n(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    public void n(DownloadInfo downloadInfo, int i, boolean z) {
        com.byazt.vl.w.n().qg();
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        if (qgVarN == null) {
            return;
        }
        try {
            if (z) {
                qgVarN.s(downloadInfo.getFailedResumeCount());
            } else if (qgVarN.ln() == -1) {
                return;
            } else {
                qgVarN.s(-1);
            }
            rv.n().n(qgVarN);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put(TapEventParamConstants.PARAM_NAME, downloadInfo.getName());
            jSONObject.put(ImagesContract.URL, downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i2 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i2 = 2;
            }
            jSONObject.put("launch_resumed", i2);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.byazt.vj.n.n().n(com.byazt.wg.qg.AD_TAG_FEED, "download_uncompleted", jSONObject, qgVarN);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.je.cp
    public void n() {
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.ht.q.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.byazt.vl.w.n().qg();
                for (com.byazt.h.qg qgVar : com.byazt.vl.w.n().s().values()) {
                    int iUm = qgVar.um();
                    if (iUm != 0) {
                        com.byazt.f.n nVarN = com.byazt.f.n.n(iUm);
                        if (nVarN.qg("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(iUm)) != null) {
                            if (oa.qg(qgVar) && !oa.s(qgVar.l())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < nVarN.n("noti_open_restart_times", 1)) {
                                    fs.n().l(qgVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < nVarN.n("noti_continue_restart_times", 1)) {
                                    fs.n().n(qgVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.byazt.ta.w.s(downloadInfo) && !oa.qg(qgVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < nVarN.n("noti_install_restart_times", 1)) {
                                fs.n().s(qgVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }
}
