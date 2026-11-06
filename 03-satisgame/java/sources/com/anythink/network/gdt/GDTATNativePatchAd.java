package com.anythink.network.gdt;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;

/* JADX INFO: loaded from: classes.dex */
public class GDTATNativePatchAd extends GDTATNativeAd {
    protected GDTATNativePatchAd(Context context, NativeUnifiedADData nativeUnifiedADData, int i, int i2, int i3, boolean z) {
        super(context, nativeUnifiedADData, i, i2, i3, z);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }
}
