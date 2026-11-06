package com.byazt.mq;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 427, 5})
public class uc implements vk {
    public m hn;
    public pr hw;
    public Context pr;

    public uc(Context context, m mVar, pr prVar) {
        this.pr = context;
        this.hw = prVar;
        this.hn = mVar;
    }

    @Override // com.byazt.mq.vk
    public boolean pr(final vk.pr prVar) {
        this.hn.fw().aj();
        this.hw.pr(new fw() { // from class: com.byazt.mq.uc.1
            @Override // com.byazt.mq.fw
            public void pr(View view, g gVar) {
                if (prVar.hn()) {
                    return;
                }
                ho hoVarHw = prVar.hw();
                if (hoVarHw != null) {
                    hoVarHw.pr(uc.this.hw, gVar);
                }
                prVar.pr(true);
            }

            @Override // com.byazt.mq.fw
            public void pr(int i, String str) {
                ho hoVarHw = prVar.hw();
                if (hoVarHw != null) {
                    hoVarHw.a_(i);
                }
            }
        });
        return true;
    }

    @Override // com.byazt.mq.vk
    public void hw(boolean z) {
    }

    public void pr(hn hnVar) {
        this.hw.pr(hnVar);
    }
}
