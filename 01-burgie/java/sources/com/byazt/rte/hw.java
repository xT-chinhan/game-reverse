package com.byazt.rte;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 13})
public class hw extends pr {
    public hw(Context context) {
        super(context, null, null);
    }

    @Override // com.byazt.rte.c
    public Intent hw() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.pr.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        return intent;
    }
}
