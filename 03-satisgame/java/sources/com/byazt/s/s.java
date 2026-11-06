package com.byazt.s;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.byazt.hj.DownloadModel;
import com.byazt.qx.BaseException;
import com.byazt.rz.cp;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 8})
public class s implements com.byazt.z.rv {
    public static String n = "s";
    public Handler qg = new Handler(Looper.getMainLooper());

    @Override // com.byazt.z.rv
    public void n(DownloadInfo downloadInfo, BaseException baseException, int i) {
        BaseException baseException2;
        final DownloadModel downloadModelN;
        if (downloadInfo == null) {
            return;
        }
        if (i == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.rz.w.s(downloadInfo, jSONObject);
            n.n(jSONObject, downloadInfo);
            cp.n("download_failed", jSONObject.toString());
        }
        com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
        if (qgVarN == null) {
            return;
        }
        try {
            if (i != -1) {
                if (i == -3) {
                    n.n(downloadInfo, qgVarN);
                    return;
                }
                if (i == 2001) {
                    n.n().n(downloadInfo, qgVarN, 2001);
                    return;
                } else {
                    if (i == 11) {
                        n.n().n(downloadInfo, qgVarN, 2000);
                        if (qgVarN.y()) {
                            return;
                        }
                        n(downloadInfo, qgVarN);
                        return;
                    }
                    return;
                }
            }
            if (baseException != null) {
                if (com.byazt.f.n.n(downloadInfo.getId()).n("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.qg.post(new Runnable() { // from class: com.byazt.s.s.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.s().n(5, d.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.byazt.ta.w.fs(baseException)) {
                    if (d.oa() != null) {
                        d.oa();
                        qgVarN.qg();
                    }
                    com.byazt.vj.n.n().n("download_failed_for_space", qgVarN);
                    if (!qgVarN.wo()) {
                        com.byazt.vj.n.n().n("download_can_restart", qgVarN);
                        n(downloadInfo);
                    }
                    if ((d.oa() == null || !d.oa().s()) && (downloadModelN = com.byazt.vl.w.n().n(qgVarN.qg())) != null && downloadModelN.isShowToast()) {
                        final com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
                        if (nVarN.n("show_no_enough_space_toast", 0) == 1) {
                            this.qg.post(new Runnable() { // from class: com.byazt.s.s.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.s().n(2, d.getContext(), downloadModelN, nVarN.n("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), oa.n(baseException.getMessage(), d.rv().optInt("exception_msg_length", 500)));
            } else {
                baseException2 = null;
            }
            com.byazt.vj.n.n().qg(downloadInfo, baseException2);
            fs.n().n(downloadInfo, baseException, "");
        } catch (Exception e) {
            d.a().n(e, "onAppDownloadMonitorSend");
        }
    }

    private void n(final DownloadInfo downloadInfo, final com.byazt.h.qg qgVar) {
        final long jN = oa.n(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, oa.n(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d = (totalBytes * 2.5d) + jMin;
        if (jN > -1 && totalBytes > -1) {
            double d2 = jN;
            if (d2 < d && d - d2 > com.byazt.ug.q.qg()) {
                com.byazt.ug.q.n(downloadInfo.getId());
            }
        }
        com.byazt.b.n.n().n(new com.byazt.b.n.InterfaceC0133n() { // from class: com.byazt.s.s.3
            @Override // com.byazt.b.n.InterfaceC0133n
            public void s() {
            }

            @Override // com.byazt.b.n.InterfaceC0133n
            public void qg() {
                if (!oa.qg(qgVar)) {
                    long j = jN;
                    if (j <= -1 || totalBytes <= -1 || j >= d) {
                        return;
                    }
                    com.byazt.vj.n.n().n("clean_space_install", com.byazt.ug.q.n("install_no_enough_space"), qgVar);
                    if (com.byazt.ug.q.n(downloadInfo, ((long) d) - jN)) {
                        com.byazt.b.n.n().qg(this);
                        qgVar.x(true);
                        return;
                    }
                    return;
                }
                com.byazt.b.n.n().qg(this);
            }
        });
    }

    private void n(DownloadInfo downloadInfo) {
        if (com.byazt.rz.l.w(downloadInfo.getId())) {
            l.n().qg(new com.byazt.nb.qg(downloadInfo));
        }
    }
}
