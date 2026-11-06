package com.byazt.tf;

import android.text.TextUtils;
import com.byazt.lk.l;
import com.byazt.vgx.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1662, 26})
public class qg {
    public com.byazt.zq.qg n(String str, String str2) {
        try {
            return q.n(l.n(str, "full_reward_adslot").qg(str2, (String) null), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void n(String str, com.byazt.zq.qg qgVar) {
        if (qgVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                l.n(qgVar.an(), "full_reward_adslot").n(str, q.n(qgVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
