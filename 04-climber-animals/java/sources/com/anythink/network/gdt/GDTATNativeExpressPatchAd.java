package com.anythink.network.gdt;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class GDTATNativeExpressPatchAd extends GDTATNativeExpressAd {
    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeType() {
        return 2;
    }

    protected GDTATNativeExpressPatchAd(Context context, String str, int i, int i2, int i3, int i4, int i5, String str2) {
        super(context, str, i, i2, i3, i4, i5, str2);
    }
}
