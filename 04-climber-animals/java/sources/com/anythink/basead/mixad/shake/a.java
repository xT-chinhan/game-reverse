package com.anythink.basead.mixad.shake;

import android.content.Context;
import android.view.View;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.h.n;
import com.anythink.core.common.h.y;
import com.anythink.core.common.l.b;

/* JADX INFO: loaded from: classes.dex */
public final class a implements b {
    private BaseAd a;
    private Context b;
    private y c;

    public a(Context context, BaseAd baseAd, y yVar) {
        this.b = context;
        this.a = baseAd;
        this.c = yVar;
    }

    @Override // com.anythink.core.common.l.b
    public final com.anythink.core.common.l.a a(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        Boolean boolIsShakeEnabled;
        BaseAd baseAd = this.a;
        if (baseAd == null || this.b == null) {
            return null;
        }
        n detail = baseAd.getDetail();
        int iY = detail != null ? detail.Y() : 0;
        if (iY != 0 && (boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(iY)) != null && !boolIsShakeEnabled.booleanValue()) {
            return null;
        }
        View shakeView = this.a.getShakeView(i, i2, aTShakeViewListener);
        if (shakeView != null) {
            return new MixNativeAdNetworkShakeView(this.b, shakeView, i, i2);
        }
        MixNativeAdShakeView mixNativeAdShakeView = new MixNativeAdShakeView(this.b, this.c, this.a.getNativeAdInteractionType());
        mixNativeAdShakeView.initView(i, i2, aTShakeViewListener);
        return mixNativeAdShakeView;
    }
}
