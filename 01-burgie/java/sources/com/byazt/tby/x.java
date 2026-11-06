package com.byazt.tby;

import android.text.TextUtils;
import com.byazt.dd.fw;
import com.taptap.sdk.db.constant.Common;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 225, 121})
public class x extends pr {
    public x(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
        super(hnVar, str, prVar);
    }

    @Override // com.byazt.tby.pr
    public void pr() {
        Object obj;
        com.byazt.ik.hn hnVarHw;
        com.byazt.ik.hn hnVarUc;
        final com.byazt.iza.pr prVarVk;
        if (this.uc == null || this.uc.size() <= 0 || (obj = this.uc.get(Common.System.NAME)) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (!TextUtils.isEmpty(strValueOf) && (hnVarHw = this.hn.hw(this.hn)) != null && (hnVarUc = hnVarHw.uc(strValueOf)) != null && (prVarVk = hnVarUc.vk(strValueOf)) != null) {
            prVarVk.hw();
            prVarVk.pr(new com.byazt.iza.hw() { // from class: com.byazt.tby.x.1
                @Override // com.byazt.iza.hw
                public void pr() {
                }

                @Override // com.byazt.iza.hw
                public void hw() {
                    x.this.hn();
                    prVarVk.hw(this);
                }
            });
        }
    }

    @Override // com.byazt.tby.pr
    public void hw() {
    }
}
