package com.byazt.bv;

import android.text.TextUtils;
import com.byazt.qn.x;
import com.byazt.wt.ve;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 431, 13})
public class hw {
    public com.byazt.qe.hw pr(String str, String str2) {
        try {
            return ve.pr(x.pr(str, "full_reward_adslot").hw(str2, (String) null), str);
        } catch (Throwable th) {
            return null;
        }
    }

    public void pr(String str, com.byazt.qe.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            x.pr(hwVar.gz(), "full_reward_adslot").pr(str, ve.pr(hwVar, str).toString());
        } catch (Throwable th) {
        }
    }
}
