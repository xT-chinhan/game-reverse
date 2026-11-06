package com.anythink.core.common.l.e.a;

import android.view.View;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATNativeAdCustomRender;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.api.BaseAd;

/* JADX INFO: loaded from: classes.dex */
public interface g extends ATNativeAdInfo {
    View a(int i, int i2, ATShakeViewListener aTShakeViewListener);

    BaseAd a();

    void a(ATNativeAdCustomRender aTNativeAdCustomRender);

    void a(ATNativeAdInfo.AdController adController);

    void a(com.anythink.core.common.l.b bVar);

    ATBaseAdAdapter b();

    ATNativeAdInfo.AdPrepareInfo c();

    ATNativeAdCustomRender d();
}
