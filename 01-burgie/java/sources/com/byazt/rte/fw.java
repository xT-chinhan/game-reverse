package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 62})
public class fw extends pr {
    public fw(Context context, com.byazt.ew.pr prVar, String str) {
        super(context, prVar, str);
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        Intent intent = new Intent(com.byazt.mrs.c.hn + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.hn);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
