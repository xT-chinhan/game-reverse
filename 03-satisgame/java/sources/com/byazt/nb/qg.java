package com.byazt.nb;

import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.byazt.vl.rv;
import com.byazt.vl.w;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1478, 26})
public class qg implements Runnable {
    public DownloadInfo n;

    public qg(DownloadInfo downloadInfo) {
        this.n = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.byazt.h.qg qgVarN;
        if (this.n == null || (qgVarN = w.n().n(this.n)) == null) {
            return;
        }
        com.byazt.vj.n.n().n("cleanspace_task", qgVarN);
        long jLongValue = Double.valueOf((com.byazt.rz.l.n(this.n.getId()) + 1.0d) * this.n.getTotalBytes()).longValue() - this.n.getCurBytes();
        long jQg = oa.qg(0L);
        if (d.oa() != null) {
            d.oa();
        }
        s.n();
        s.qg();
        if (com.byazt.rz.l.x(qgVarN.um())) {
            s.n(d.getContext());
        }
        long jQg2 = oa.qg(0L);
        if (jQg2 >= jLongValue) {
            qgVarN.d("1");
            rv.n().n(qgVarN);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jQg2 - jQg));
            } catch (JSONException unused) {
            }
            com.byazt.vj.n.n().n("cleanspace_download_after_quite_clean", jSONObject, qgVarN);
            Downloader.getInstance(d.getContext()).restart(this.n.getId());
            return;
        }
        if (d.oa() != null) {
            qgVarN.q(false);
            q.n().n(qgVarN.n(), new l() { // from class: com.byazt.nb.qg.1
            });
            if (d.oa().n(this.n.getId(), this.n.getUrl(), true, jLongValue)) {
                qgVarN.l(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException unused2) {
        }
        com.byazt.vj.n.n().n("cleanspace_window_show", jSONObject2, qgVarN);
    }
}
