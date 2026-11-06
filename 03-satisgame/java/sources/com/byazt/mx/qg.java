package com.byazt.mx;

import android.text.TextUtils;
import com.byazt.rz.oa;
import com.byazt.wm.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 26})
public class qg implements x {
    public static com.byazt.bn.q n;
    public static com.byazt.bn.s qg;

    public static com.byazt.bn.q n() {
        return n;
    }

    public static com.byazt.bn.s qg() {
        return qg;
    }

    public static void n(com.byazt.bn.s sVar) {
        qg = sVar;
    }

    @Override // com.byazt.mx.x
    public boolean n(final com.byazt.h.qg qgVar, int i, final fs fsVar, final com.byazt.bn.s sVar) {
        DownloadInfo downloadInfoQg;
        if (qgVar == null || !n(qgVar)) {
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
        if (jN >= 0 && totalBytes > 0) {
            if (totalBytes <= n(qgVar.um())) {
                final int i2 = (int) (jN / 1048576);
                n = new com.byazt.bn.q() { // from class: com.byazt.mx.qg.1
                    @Override // com.byazt.bn.q
                    public void n() {
                        com.byazt.bn.q unused = qg.n = null;
                        qg.this.n(i2, i2, qgVar, "apk_size_cancel", "confirm");
                    }

                    @Override // com.byazt.bn.q
                    public void qg() {
                        com.byazt.bn.q unused = qg.n = null;
                        qg.this.n(i2, i2, qgVar, "apk_size_cancel", "cancel");
                        fsVar.n(qgVar);
                    }
                };
                String str = String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", oa.n(totalBytes - jN));
                if (sVar != null) {
                    n(new com.byazt.bn.s() { // from class: com.byazt.mx.qg.2
                        @Override // com.byazt.bn.s
                        public void delete() {
                            com.byazt.bn.q unused = qg.n = null;
                            qg.this.n(i2, i2, qgVar, "apk_size_cancel", "delete");
                            sVar.delete();
                        }
                    });
                }
                TTDelegateActivity.n(qgVar, str, "继续", "暂停", "删除");
                return true;
            }
        }
        return false;
    }

    private int n(int i) {
        return com.byazt.f.n.n(i).n("cancel_pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean n(com.byazt.h.n nVar) {
        return com.byazt.rz.l.n(nVar).n("cancel_pause_optimise_apk_retain_switch", 0) == 1 && nVar.hd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, com.byazt.h.qg qgVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i2));
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("pause_cancel_optimise", jSONObject, qgVar);
    }
}
