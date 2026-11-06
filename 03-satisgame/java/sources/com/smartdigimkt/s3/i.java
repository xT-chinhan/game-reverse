package com.smartdigimkt.s3;

import com.smartdigimkt.sdk.api.ISDMAdManager;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ ISDMAdManager.S2SBidTokenCallback a;
    public final /* synthetic */ String b;

    public i(ISDMAdManager.S2SBidTokenCallback s2SBidTokenCallback, String str) {
        this.a = s2SBidTokenCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onComplete(this.b);
    }
}
