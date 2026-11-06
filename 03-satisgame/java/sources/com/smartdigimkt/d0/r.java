package com.smartdigimkt.d0;

import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Runnable {
    public final /* synthetic */ WTWebView a;

    public r(WTWebView wTWebView) {
        this.a = wTWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WTWebView wTWebView = this.a;
        if (wTWebView != null) {
            wTWebView.release();
        }
    }
}
