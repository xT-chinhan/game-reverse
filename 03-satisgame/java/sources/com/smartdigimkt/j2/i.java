package com.smartdigimkt.j2;

import com.smartdigimkt.sdk.basead.ui.web.BaseWebView;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Runnable {
    public final /* synthetic */ WebLandPageActivity a;

    public i(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebLandPageActivity webLandPageActivity = this.a;
        int i = WebLandPageActivity.E;
        BaseWebView baseWebView = webLandPageActivity.c;
        if (baseWebView == null || !baseWebView.canGoBack()) {
            webLandPageActivity.finish();
        } else {
            webLandPageActivity.c.goBack();
        }
    }
}
