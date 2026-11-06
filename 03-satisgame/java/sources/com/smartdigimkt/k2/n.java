package com.smartdigimkt.k2;

import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.smartdigimkt.m3.b {
    public final /* synthetic */ WTWebView a;

    public n(WTWebView wTWebView) {
        this.a = wTWebView;
    }

    @Override // com.smartdigimkt.m3.b
    public final boolean a() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h5ShowException("{\"error_code\":-999,\"error_message\":\"render timeout\"}");
    }
}
