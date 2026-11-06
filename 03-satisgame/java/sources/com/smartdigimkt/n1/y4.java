package com.smartdigimkt.n1;

import com.smartdigimkt.sdk.basead.ui.ShakeNativeBorderThumbView;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class y4 {
    public final /* synthetic */ ShakeNativeBorderThumbView a;

    public y4(ShakeNativeBorderThumbView shakeNativeBorderThumbView) {
        this.a = shakeNativeBorderThumbView;
    }

    public final int a() {
        int[] iArr = new int[2];
        this.a.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = (this.a.getWidth() / 2) + i;
        int height = (this.a.getHeight() / 2) + i2;
        com.smartdigimkt.b2.y yVarA = com.smartdigimkt.b2.y.a();
        if (yVarA.e == 0) {
            yVarA.e = com.smartdigimkt.r4.h.k(SDKContext.getInstance().d());
        }
        int i3 = yVarA.e;
        com.smartdigimkt.b2.y yVarA2 = com.smartdigimkt.b2.y.a();
        if (yVarA2.f == 0) {
            yVarA2.f = com.smartdigimkt.r4.h.j(SDKContext.getInstance().d());
        }
        return (int) Math.sqrt(Math.pow(height - (yVarA2.f / 2), 2.0d) + Math.pow(width - (i3 / 2), 2.0d));
    }
}
