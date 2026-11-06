package com.byazt.ht;

import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1169, 18})
public class l implements com.byazt.g.s {
    @Override // com.byazt.g.s
    public void n(int i, String str, JSONObject jSONObject) {
        com.byazt.h.qg qgVarN;
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (qgVarN = com.byazt.vl.w.n().n(downloadInfo)) == null) {
            return;
        }
        if ("install_view_result".equals(str)) {
            jSONObject = oa.n(jSONObject);
            com.byazt.s.n.n(jSONObject, downloadInfo);
            oa.n(jSONObject, "model_id", Long.valueOf(qgVarN.qg()));
        }
        com.byazt.vj.n.n().qg(str, jSONObject, qgVarN);
    }

    @Override // com.byazt.g.s
    public void qg(int i, String str, JSONObject jSONObject) {
        com.byazt.h.qg qgVarN;
        DownloadInfo downloadInfo = Downloader.getInstance(d.getContext()).getDownloadInfo(i);
        if (downloadInfo == null || (qgVarN = com.byazt.vl.w.n().n(downloadInfo)) == null) {
            return;
        }
        com.byazt.vj.n.n().n(str, jSONObject, qgVarN);
    }
}
