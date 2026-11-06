package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes3.dex */
public class ch extends ms {
    public ch(Context context, com.ss.android.socialbase.downloader.ab.ms msVar, String str) {
        super(context, msVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ms.ka
    public Intent xr() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.ah);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
