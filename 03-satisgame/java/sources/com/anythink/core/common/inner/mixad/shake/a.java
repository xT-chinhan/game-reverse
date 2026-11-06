package com.anythink.core.common.inner.mixad.shake;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.y;
import com.anythink.core.common.k.b;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {
    private final int[] a = {22, 8, 15};
    private BaseAd b;
    private Context c;
    private y d;

    public a(Context context, BaseAd baseAd, y yVar) {
        this.c = context;
        this.b = baseAd;
        this.d = yVar;
    }

    @Override // com.anythink.core.common.k.b
    public final com.anythink.core.common.k.a a(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        Boolean boolIsShakeEnabled;
        BaseAd baseAd = this.b;
        if (baseAd == null || this.c == null) {
            return null;
        }
        n detail = baseAd.getDetail();
        boolean z = false;
        int iZ = detail != null ? detail.Z() : 0;
        if (iZ != 0 && (boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(iZ)) != null && !boolIsShakeEnabled.booleanValue()) {
            return null;
        }
        View shakeView = this.b.getShakeView(i, i2, aTShakeViewListener);
        if (shakeView != null) {
            return new MixNativeAdNetworkShakeView(this.c, shakeView, i, i2);
        }
        int[] iArr = this.a;
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == iZ) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return null;
        }
        MixNativeAdShakeView mixNativeAdShakeView = new MixNativeAdShakeView(this.c, this.d, this.b.getNativeAdInteractionType());
        mixNativeAdShakeView.initView(i, i2, aTShakeViewListener);
        return mixNativeAdShakeView;
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
