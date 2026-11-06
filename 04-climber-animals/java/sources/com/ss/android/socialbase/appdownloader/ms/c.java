package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes3.dex */
public class c extends ms {
    public c(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
