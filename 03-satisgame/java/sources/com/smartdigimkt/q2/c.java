package com.smartdigimkt.q2;

import com.smartdigimkt.r4.h;
import com.smartdigimkt.sdk.api.IntegrationCheckListener;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IntegrationCheckListener {
    public final /* synthetic */ SDMSDK.InitCallBack a;
    public final /* synthetic */ SDKContext b;

    public c(SDKContext sDKContext, SDMSDK.InitCallBack initCallBack) {
        this.b = sDKContext;
        this.a = initCallBack;
    }

    @Override // com.smartdigimkt.sdk.api.IntegrationCheckListener
    public final void onValidationFail(String str) {
        this.b.e = true;
        this.b.a(this.a, str);
    }

    @Override // com.smartdigimkt.sdk.api.IntegrationCheckListener
    public final void onValidationSucceed() {
        this.b.e = true;
        this.b.a(this.a, "");
        h.a(this.b.k);
    }
}
