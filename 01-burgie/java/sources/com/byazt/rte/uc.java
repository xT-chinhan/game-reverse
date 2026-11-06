package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 5})
public class uc extends pr {
    public uc(Context context) {
        super(context, null, null);
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
