package com.byazt.mkl;

import com.byazt.gct.pk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1613, 26})
public class qg {
    public pk n;

    public void n(pk pkVar) {
        this.n = pkVar;
    }

    public void n(int i) {
        n("config_change_type", i);
    }

    public void qg(int i) {
        n("real_change_type", i);
    }

    public void s(int i) {
        n("business_notify_status", i);
    }

    public void q(int i) {
        n("video_countdown_status", i);
    }

    public void l(int i) {
        n("jump_dest_type", i);
    }

    public void n(boolean z) {
        n("is_ab_style", z ? 1 : 0);
    }

    public void qg(boolean z) {
        n("predict_in_endcard", z ? 1 : 0);
    }

    private void n(String str, int i) {
        JSONObject jSONObjectN;
        pk pkVar = this.n;
        if (pkVar == null || (jSONObjectN = com.byazt.vhv.qg.n(pkVar.h())) == null) {
            return;
        }
        try {
            jSONObjectN.put(str, i);
        } catch (JSONException unused) {
        }
    }
}
