package com.smartdigimkt.sdk.basead.webtemplet.adformat.splash;

import com.smartdigimkt.n2.a;
import com.smartdigimkt.sdk.basead.webtemplet.WTWebView;
import com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin;

/* JADX INFO: loaded from: classes3.dex */
public class WTSplashJSBridgePlugin extends WTCommonJSBridgePlugin {
    @Override // com.smartdigimkt.sdk.basead.webtemplet.adformat.WTCommonJSBridgePlugin
    public void initialize(WTWebView wTWebView) {
        super.initialize(wTWebView);
        try {
            if (wTWebView.getJsCommunicationObject() == null || !(wTWebView.getJsCommunicationObject() instanceof a)) {
                return;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
