package com.anythink.core.common.inner.mixad.b;

import android.view.View;
import com.anythink.core.api.ATNativeAdInfo;
import com.anythink.core.common.inner.ui.thirdparty.ThirdPartyNativeTemplateView;

/* JADX INFO: loaded from: classes.dex */
public final class e extends a implements com.anythink.core.common.k.c.a.d {
    View b;
    ATNativeAdInfo.AdPrepareInfo c;

    @Override // com.anythink.core.common.k.c.a.d
    public final View a() {
        if (this.a != null && this.b == null) {
            View view = (View) this.a.a();
            this.b = view;
            if (view instanceof ThirdPartyNativeTemplateView) {
                this.c = ((ThirdPartyNativeTemplateView) view).getAdPrepareInfo();
            }
        }
        return this.b;
    }

    @Override // com.anythink.core.common.k.c.a.d
    public final ATNativeAdInfo.AdPrepareInfo b() {
        return this.c;
    }
}
