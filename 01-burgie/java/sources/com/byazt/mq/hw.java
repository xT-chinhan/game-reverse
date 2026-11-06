package com.byazt.mq;

import android.content.Context;
import android.view.View;
import com.byazt.mo.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 427, 13})
public class hw implements vk {
    public m c;
    public ThemeStatusBroadcastReceiver hn;
    public com.byazt.qq.pr hw;
    public Context pr;
    public int uc;
    public zo x;

    public hw(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.uko.zo zoVar, zo zoVar2, com.byazt.mft.pr prVar) {
        this(context, mVar, themeStatusBroadcastReceiver, z, zoVar, zoVar2, prVar, null);
    }

    public hw(Context context, m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.uko.zo zoVar, zo zoVar2, com.byazt.mft.pr prVar, com.byazt.qq.pr prVar2) {
        this.pr = context;
        this.c = mVar;
        this.hn = themeStatusBroadcastReceiver;
        this.x = zoVar2;
        if (prVar2 != null) {
            this.hw = prVar2;
        } else {
            this.hw = new com.byazt.qq.pr(context, themeStatusBroadcastReceiver, z, zoVar, mVar, prVar);
        }
        this.hw.pr(this.x);
        if (zoVar instanceof com.byazt.uko.fw) {
            this.uc = 3;
        } else {
            this.uc = 2;
        }
    }

    public void pr(boolean z) {
        this.hw.hn(z);
    }

    @Override // com.byazt.mq.vk
    public boolean pr(final vk.pr prVar) {
        this.c.fw().pr(this.uc);
        this.hw.pr(new fw() { // from class: com.byazt.mq.hw.1
            @Override // com.byazt.mq.fw
            public void pr(View view, g gVar) {
                if (!prVar.hn()) {
                    hw.this.c.fw().c(hw.this.uc);
                    hw.this.c.fw().uc(hw.this.uc);
                    hw.this.c.fw().m();
                    ho hoVarHw = prVar.hw();
                    if (hoVarHw != null) {
                        hoVarHw.pr(hw.this.hw, gVar);
                        prVar.pr(true);
                    }
                }
            }

            @Override // com.byazt.mq.fw
            public void pr(int i, String str) {
                hw.this.c.fw().pr(hw.this.uc, i, str, prVar.hw(hw.this));
                if (prVar.hw(hw.this)) {
                    prVar.pr(hw.this);
                    return;
                }
                ho hoVarHw = prVar.hw();
                if (hoVarHw == null) {
                    return;
                }
                hoVarHw.a_(i);
            }
        });
        return true;
    }

    @Override // com.byazt.mq.vk
    public void hw(boolean z) {
        com.byazt.qq.pr prVar = this.hw;
        if (prVar != null) {
            prVar.pr(z);
        }
    }

    public com.byazt.imd.x pr() {
        com.byazt.qq.pr prVar = this.hw;
        if (prVar != null) {
            return prVar.c();
        }
        return null;
    }
}
