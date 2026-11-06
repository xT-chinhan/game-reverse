package com.byazt.mx;

import android.text.TextUtils;
import com.byazt.rz.oa;
import com.byazt.wm.DownloadInfo;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1149, 8})
public class s implements x {
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
        String str;
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
        long curBytes = downloadInfoQg.getCurBytes();
        long totalBytes = downloadInfoQg.getTotalBytes();
        if (curBytes < 0 || totalBytes <= 0) {
            return false;
        }
        final int iN = com.byazt.ug.tj.n(downloadInfoQg.getId(), (int) ((100 * curBytes) / totalBytes));
        final int i2 = (int) (curBytes / 1048576);
        boolean z = iN > n(qgVar.um());
        n = new com.byazt.bn.q() { // from class: com.byazt.mx.s.1
            @Override // com.byazt.bn.q
            public void n() {
                com.byazt.bn.q unused = s.n = null;
                s.this.n(iN, i2, i2, qgVar, "download_percent_cancel", "confirm");
            }

            @Override // com.byazt.bn.q
            public void qg() {
                com.byazt.bn.q unused = s.n = null;
                s.this.n(iN, i2, i2, qgVar, "download_percent_cancel", "cancel");
                fsVar.n(qgVar);
            }
        };
        String strN = oa.n(com.byazt.ug.tj.n(qgVar.um(), curBytes, totalBytes));
        if (z) {
            str = String.format("该任务已下载%s，仅需%s即可下载完成，是否继续？", strN, oa.n(totalBytes - curBytes));
        } else {
            str = String.format("该任务已下载%s，即将下载完成，是否继续下载？", strN);
        }
        String str2 = str;
        if (sVar != null) {
            n(new com.byazt.bn.s() { // from class: com.byazt.mx.s.2
                @Override // com.byazt.bn.s
                public void delete() {
                    com.byazt.bn.q unused = s.n = null;
                    s.this.n(iN, i2, i2, qgVar, "download_percent_cancel", "delete");
                    sVar.delete();
                }
            });
        }
        TTDelegateActivity.qg(qgVar, str2, "继续", "暂停", "删除");
        return true;
    }

    private int n(int i) {
        return com.byazt.f.n.n(i).n("cancel_pause_optimise_download_percent_value", 50);
    }

    private boolean n(com.byazt.h.n nVar) {
        return com.byazt.rz.l.n(nVar).n("cancel_pause_optimise_download_percent_retain_switch", 0) == 1 && nVar.hd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2, int i3, com.byazt.h.qg qgVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", str);
            jSONObject.putOpt("pause_optimise_action", str2);
            jSONObject.putOpt("download_percent", Integer.valueOf(i));
            jSONObject.putOpt("download_current_bytes", Integer.valueOf(i2));
            jSONObject.putOpt("download_total_bytes", Integer.valueOf(i3));
        } catch (JSONException unused) {
        }
        com.byazt.vj.n.n().n("pause_cancel_optimise", jSONObject, qgVar);
    }
}
