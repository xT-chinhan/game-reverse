package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX INFO: loaded from: classes.dex */
public class TTATNativePatchAd extends TTATNativeAd {
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }

    public TTATNativePatchAd(Context context, String str, TTNativeAd tTNativeAd, boolean z, Bitmap bitmap, int i, boolean z2) {
        super(context, str, tTNativeAd, z, bitmap, i, z2);
    }

    @Override // com.anythink.network.toutiao.TTATNativeAd
    public void setAdData(boolean z, Bitmap bitmap, int i) {
        super.setAdData(z, bitmap, i);
    }
}
