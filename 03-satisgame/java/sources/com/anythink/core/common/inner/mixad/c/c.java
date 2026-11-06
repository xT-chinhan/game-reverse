package com.anythink.core.common.inner.mixad.c;

import android.view.View;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IATThirdPartyMaterial;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.common.k.e.a.g;

/* JADX INFO: loaded from: classes.dex */
public final class c implements g {
    private final BaseAd a;
    private IATThirdPartyMaterial b;
    private ATNativeAdInfo.AdPrepareInfo c;
    private ATNativeAdInfo.AdController d;
    private ATNativeAdCustomRender e;
    private com.anythink.core.common.k.b f;

    @Override // com.anythink.core.common.k.e.a.g
    public final ATBaseAdAdapter b() {
        return null;
    }

    public c(BaseAd baseAd) {
        this.a = baseAd;
    }

    @Override // com.anythink.core.api.ATNativeAdInfo
    public final IATThirdPartyMaterial getAdMaterial() {
        if (this.a == null) {
            return null;
        }
        if (this.b == null) {
            this.b = new d(this.a, this);
        }
        return this.b;
    }

    @Override // com.anythink.core.api.ATNativeAdInfo
    public final void prepare(ATNativeAdInfo.AdPrepareInfo adPrepareInfo) {
        this.c = adPrepareInfo;
    }

    @Override // com.anythink.core.api.ATNativeAdInfo
    public final ATNativeAdInfo.AdController getAdController() {
        return this.d;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final void a(ATNativeAdInfo.AdController adController) {
        this.d = adController;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final BaseAd a() {
        return this.a;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final ATNativeAdInfo.AdPrepareInfo c() {
        return this.c;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final ATNativeAdCustomRender d() {
        return this.e;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final void a(ATNativeAdCustomRender aTNativeAdCustomRender) {
        this.e = aTNativeAdCustomRender;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final void a(com.anythink.core.common.k.b bVar) {
        this.f = bVar;
    }

    @Override // com.anythink.core.common.k.e.a.g
    public final View a(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        View shakeView;
        BaseAd baseAd = this.a;
        if (baseAd != null && (shakeView = baseAd.getShakeView(i, i2, aTShakeViewListener)) != null) {
            return shakeView;
        }
        com.anythink.core.common.k.b bVar = this.f;
        if (bVar == null) {
            return null;
        }
        Object objA = bVar.a(i, i2, aTShakeViewListener);
        if (objA instanceof View) {
            return (View) objA;
        }
        return null;
    }
}
