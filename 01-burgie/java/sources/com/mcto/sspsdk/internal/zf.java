package com.mcto.sspsdk.internal;

import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.ssp.activity.DialogActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class zf extends ag {
    public zf(String str, String str2) {
        super(1, str, str2);
    }

    @Override // com.mcto.sspsdk.internal.ag
    public final boolean a() {
        if (!e1.c(this.b)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setClass(jd.a, DialogActivity.class);
        intent.putExtra("appName", this.c);
        intent.putExtra("apkName", this.b);
        intent.putExtra("deeplink", this.d);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        jd.a.startActivity(intent);
        return true;
    }
}
