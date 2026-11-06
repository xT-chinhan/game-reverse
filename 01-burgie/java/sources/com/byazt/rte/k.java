package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 250})
public class k extends pr {
    public k(Context context, com.byazt.ew.pr prVar, String str) {
        super(context, prVar, str);
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        String strHn = this.hw.hn(an.aB);
        String strPr = com.byazt.now.hn.pr(this.hw.hn("ag"), strHn);
        String strPr2 = com.byazt.now.hn.pr(this.hw.hn("ah"), strHn);
        String strPr3 = com.byazt.now.hn.pr(this.hw.hn("ai"), strHn);
        String strPr4 = com.byazt.now.hn.pr(this.hw.hn("aj"), strHn);
        Intent intent = new Intent();
        intent.putExtra(strPr, this.hn);
        intent.putExtra(strPr2, "*/*");
        intent.putExtra(strPr3, true);
        intent.setAction(strPr4);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        return intent;
    }
}
