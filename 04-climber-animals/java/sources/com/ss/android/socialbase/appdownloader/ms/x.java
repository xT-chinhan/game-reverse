package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes3.dex */
public class x extends ms {
    public x(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str) {
        super(context, msVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.ka.ah + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.ah);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
