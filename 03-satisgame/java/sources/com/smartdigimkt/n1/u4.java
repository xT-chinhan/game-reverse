package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;

/* JADX INFO: loaded from: classes3.dex */
public final class u4 implements View.OnClickListener {
    public final /* synthetic */ SdkBannerATView a;

    public u4(SdkBannerATView sdkBannerATView) {
        this.a = sdkBannerATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.M.onClick(view);
    }
}
