package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends d {
    public ah(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, lmVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void ms(int i, int i2) {
        super.ms(i, i2);
        if (this.ka == null || i <= 0 || i2 <= 0) {
            return;
        }
        this.ka.ah(i, i2);
        this.ka.ms(i, i2);
        xr(-1, -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    protected com.bykv.vk.openvk.component.video.api.renderview.xr re() {
        if (this.ka != null) {
            return this.ka.h();
        }
        return null;
    }
}
