package com.byazt.mx;

import android.text.TextUtils;
import com.byazt.wm.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 13})
public class w implements rv {
    public static com.byazt.bn.q n;

    public static com.byazt.bn.q n() {
        return n;
    }

    @Override // com.byazt.mx.rv
    public boolean n(final com.byazt.h.qg qgVar, int i, final fs fsVar) {
        DownloadInfo downloadInfoQg;
        if (qgVar == null || qgVar.ic() || !n(qgVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(qgVar.hf())) {
            downloadInfoQg = com.byazt.s.tj.n(com.byazt.ug.d.getContext()).n(qgVar.hf(), null, true);
        } else {
            downloadInfoQg = com.byazt.s.tj.n(com.byazt.ug.d.getContext()).qg(qgVar.n());
        }
        if (downloadInfoQg == null) {
            return false;
        }
        long curBytes = downloadInfoQg.getCurBytes();
        long totalBytes = downloadInfoQg.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int iN = com.byazt.ug.tj.n(downloadInfoQg.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iN > n(qgVar.um())) {
                n = new com.byazt.bn.q() { // from class: com.byazt.mx.w.1
                    @Override // com.byazt.bn.q
                    public void n() {
                        com.byazt.bn.q unused = w.n = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException unused2) {
                        }
                        com.byazt.vj.n.n().n("pause_optimise", jSONObject, qgVar);
                    }

                    @Override // com.byazt.bn.q
                    public void qg() {
                        com.byazt.bn.q unused = w.n = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException unused2) {
                        }
                        com.byazt.vj.n.n().n("pause_optimise", jSONObject, qgVar);
                        fsVar.n(qgVar);
                    }
                };
                TTDelegateActivity.qg(qgVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iN)), "继续", "暂停");
                qgVar.k(true);
                return true;
            }
        }
        return false;
    }

    private int n(int i) {
        return com.byazt.f.n.n(i).n("pause_optimise_download_percent", 50);
    }

    private boolean n(com.byazt.h.n nVar) {
        return com.byazt.rz.l.n(nVar).n("pause_optimise_download_percent_switch", 0) == 1 && nVar.hd();
    }
}
