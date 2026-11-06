package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes3.dex */
public class xr extends ms {
    public xr(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f4590ms.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        return intent;
    }
}
