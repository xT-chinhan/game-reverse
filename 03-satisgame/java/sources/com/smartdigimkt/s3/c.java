package com.smartdigimkt.s3;

import com.smartdigimkt.sdk.api.ISDMAdManager;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ SDKContext a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ ISDMAdManager.S2SBidTokenCallback d;

    public c(boolean z, boolean z2, SDKContext sDKContext, String str, Map map, ISDMAdManager.S2SBidTokenCallback s2SBidTokenCallback) {
        this.a = sDKContext;
        this.b = str;
        this.c = map;
        this.d = s2SBidTokenCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(new b(this));
    }
}
