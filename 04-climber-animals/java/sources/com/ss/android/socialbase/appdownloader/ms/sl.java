package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes3.dex */
public class sl extends ms {
    public sl(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str) {
        super(context, msVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        String strAh = this.xr.ah("s");
        String strMs = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("ag"), strAh);
        String strMs2 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("ah"), strAh);
        String strMs3 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("ai"), strAh);
        String strMs4 = com.ss.android.socialbase.appdownloader.c.ah.ms(this.xr.ah("aj"), strAh);
        Intent intent = new Intent();
        intent.putExtra(strMs, this.ah);
        intent.putExtra(strMs2, "*/*");
        intent.putExtra(strMs3, true);
        intent.setAction(strMs4);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        return intent;
    }
}
