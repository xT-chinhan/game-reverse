package com.smartdigimkt.n1;

import android.view.View;
import com.smartdigimkt.sdk.basead.ui.SdkBannerATView;

/* JADX INFO: loaded from: classes3.dex */
public final class q4 implements View.OnClickListener {
    public final /* synthetic */ SdkBannerATView a;

    public q4(SdkBannerATView sdkBannerATView) {
        this.a = sdkBannerATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SdkBannerATView sdkBannerATView = this.a;
        int i = SdkBannerATView.N;
        sdkBannerATView.a(1, 3);
    }
}
