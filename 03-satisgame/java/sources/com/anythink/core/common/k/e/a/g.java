package com.anythink.core.common.k.e.a;

import android.view.View;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;

/* JADX INFO: loaded from: classes.dex */
public interface g extends ATNativeAdInfo {
    View a(int i, int i2, ATShakeViewListener aTShakeViewListener);

    BaseAd a();

    void a(ATNativeAdCustomRender aTNativeAdCustomRender);

    void a(ATNativeAdInfo.AdController adController);

    void a(com.anythink.core.common.k.b bVar);

    ATBaseAdAdapter b();

    ATNativeAdInfo.AdPrepareInfo c();

    ATNativeAdCustomRender d();
}
