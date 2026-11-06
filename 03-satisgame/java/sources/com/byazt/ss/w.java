package com.byazt.ss;

import android.text.TextUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1334, 13})
public class w extends n {
    @Override // com.byazt.ss.n
    public void qg() {
    }

    public w(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
        super(sVar, str, nVar);
    }

    @Override // com.byazt.ss.n
    public void n() {
        Object obj;
        com.byazt.ih.s sVarQg;
        com.byazt.ih.s sVarW;
        final com.byazt.kg.n nVarTj;
        if (this.w == null || this.w.size() <= 0 || (obj = this.w.get(TapEventParamConstants.PARAM_NAME)) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (sVarQg = this.s.qg(this.s)) == null || (sVarW = sVarQg.w(strValueOf)) == null || (nVarTj = sVarW.tj(strValueOf)) == null) {
            return;
        }
        nVarTj.qg();
        nVarTj.n(new com.byazt.kg.qg() { // from class: com.byazt.ss.w.1
            @Override // com.byazt.kg.qg
            public void n() {
            }

            @Override // com.byazt.kg.qg
            public void qg() {
                w.this.s();
                nVarTj.qg(this);
            }
        });
    }
}
