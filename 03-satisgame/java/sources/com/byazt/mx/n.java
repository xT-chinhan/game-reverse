package com.byazt.mx;

import android.text.TextUtils;
import com.byazt.rz.oa;
import com.byazt.wm.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 19})
public class n implements rv {
    public static com.byazt.bn.q n;

    public static com.byazt.bn.q n() {
        return n;
    }

    @Override // com.byazt.mx.rv
    public boolean n(final com.byazt.h.qg qgVar, int i, final fs fsVar) {
        DownloadInfo downloadInfoQg;
        if (qgVar == null || qgVar.lq() || !n(qgVar)) {
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
        long jN = com.byazt.ug.tj.n(downloadInfoQg.getId(), downloadInfoQg.getCurBytes(), downloadInfoQg.getTotalBytes());
        long totalBytes = downloadInfoQg.getTotalBytes();
        if (jN <= 0 || totalBytes <= 0 || totalBytes > n(qgVar.um())) {
            return false;
        }
        n = new com.byazt.bn.q() { // from class: com.byazt.mx.n.1
            @Override // com.byazt.bn.q
            public void n() {
                com.byazt.bn.q unused = n.n = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException unused2) {
                }
                com.byazt.vj.n.n().n("pause_optimise", jSONObject, qgVar);
            }

            @Override // com.byazt.bn.q
            public void qg() {
                com.byazt.bn.q unused = n.n = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException unused2) {
                }
                com.byazt.vj.n.n().n("pause_optimise", jSONObject, qgVar);
                fsVar.n(qgVar);
            }
        };
        TTDelegateActivity.n(qgVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", oa.n(totalBytes - jN)), "继续", "暂停");
        qgVar.sz(true);
        return true;
    }

    private int n(int i) {
        return com.byazt.f.n.n(i).n("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean n(com.byazt.h.n nVar) {
        return com.byazt.rz.l.n(nVar).n("pause_optimise_apk_size_switch", 0) == 1 && nVar.hd();
    }
}
